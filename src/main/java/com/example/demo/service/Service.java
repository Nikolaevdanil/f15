package com.example.demo.service;

import com.example.demo.models.Manufacture;
import com.example.demo.models.Worker;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

@org.springframework.stereotype.Service
public class Service implements ServiceInterface  {
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    @Override
    public void addManufacture(Manufacture manufacture) {
        Session session = sessionFactory.openSession();
        var transaction = session.beginTransaction();
        session.saveOrUpdate(manufacture);
        transaction.commit();
        session.close();

    }

    @Override
    public void addWorker(Worker worker) {
        Session session = sessionFactory.openSession();
        var transaction = session.beginTransaction();
        session.saveOrUpdate(worker);
        transaction.commit();
        session.close();
    }

    @PostConstruct
    @Override
    public List<Manufacture> getAllManufacture() {
        Session session = sessionFactory.openSession();
        List<Manufacture> manufactures = session.createQuery("select b from Manufacture b", Manufacture.class).getResultList();
        session.close();
        return manufactures;
    }

    @Override
    public List<Worker> getAllWorker() {
        Session session = sessionFactory.openSession();
        List<Worker> workers = session.createQuery("select c from Worker c", Worker.class).getResultList();
        session.close();
        return workers;
    }

    @Override
    public Manufacture getManufactureById(Long id) {
        return null;
    }

    @Override
    public Worker getWorkerById(Long id) {
        return null;
    }

    @Override
    public void deleteManufactureById(Long id) {
        Manufacture buff = new Manufacture();
        List<Manufacture> banks = getAllManufacture();
        for (Manufacture item:banks) {
            if(id == item.getId()){
                buff = item;
            }
        }
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(session.get(Manufacture.class, buff.getId()));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteAllManufactures() {

    }

    @Override
    public void deleteWorkerById(Long id) {
        List<Worker> cards = getAllWorker();
        Worker buff = new Worker();
        for (Worker item:cards) {
            if(id == item.getId()){
                buff = item;
            }
        }
        System.out.println(buff.getFirstName());
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(session.get(Worker.class, buff.getId()));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteAllWorkers() {

    }
}
