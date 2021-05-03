package com.example.demo.cotroller;

import com.example.demo.dao.PersonDAO;
import com.example.demo.models.Manufacture;
import com.example.demo.models.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class mycontroller {
    private final PersonDAO personDAO;

    @Autowired
    public mycontroller(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model1,Model model2) {
        model1.addAttribute("worker", personDAO.index1());
        model2.addAttribute("manufacture", personDAO.index2());
        return "home";
    }
    @PostMapping()
    public String addManufacture(@RequestParam String name,
                                 @RequestParam String address,
                                 @RequestParam String firstName,
                                 @RequestParam String lastName,
                                 @RequestParam String middleName){
        Manufacture manufacture = new Manufacture();
        manufacture.setName(name);
        manufacture.setAddress(address);
        Worker worker=new Worker();
        worker.setFirstName(firstName);
        worker.setLastName(lastName);
        worker.setMiddleName(middleName);
        personDAO.save(manufacture,worker);
        return "redirect:/people";
    }
    @PostMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        personDAO.delete(id);
        return "redirect:/people";
    }
}
