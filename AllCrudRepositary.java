package com.example.demo.repositary;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.AllCrudModel;

public interface AllCrudRepositary extends CrudRepository<AllCrudModel,Integer> {

}
