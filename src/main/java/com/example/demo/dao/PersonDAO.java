package com.example.demo.dao;


import com.example.demo.models.Manufacture;
import com.example.demo.models.Worker;
import com.example.demo.service.Service;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Neil Alishev
 */
@Component
public class PersonDAO {
    private static Long WORKER_COUNT;
    private static Long MANUFACTURE_COUNT;
    private List<Worker> workers;
    private List<Manufacture>manufactures;

    @Autowired
    Service service;

    public List<Worker> index1() {
        return service.getAllWorker();
    }
    public List<Manufacture> index2() {
        return service.getAllManufacture();
    }

    public void save(Manufacture manufacture,Worker worker) {
        service.addWorker(worker);
        service.addManufacture(manufacture);
    }

    public void delete(Long id) {
        service.deleteManufactureById(id);
        service.deleteWorkerById(id);
    }

}