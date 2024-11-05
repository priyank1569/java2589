package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.AllCrudModel;
import com.example.demo.repositary.AllCrudRepositary;

@RestController
public class AllCrudController {
	@Autowired
	AllCrudRepositary repo;
	
	@PostMapping("/insert")
	public String Insert(AllCrudModel model)
	{
		try
		{
			repo.save(model);
			
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return "Data Inserted..";
		
		
	}
	
	@GetMapping("/display")
	public Iterable<AllCrudModel> getAll()
	{
		return repo.findAll();
	}
	
	@PostMapping("/delete")
	public String Delete(Integer Id)
	{
		try
		{
			repo.deleteById(Id);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		return "Data deleted..";
	}
	
	@PostMapping("/update")
    public String update(@ModelAttribute AllCrudModel model) {
        try {
            repo.save(model); // Spring automatically updates the existing record if ID exists
            return "Record Updated.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error while updating data.";
        }
    }
	
}
