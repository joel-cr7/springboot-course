package com.example.course.week1.DependencyInjectionLecture;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {

    final private DB db;

    public DBService(DB db){
        this.db = db;
    }

    public String getData(){
        return db.getData();
    }
}
