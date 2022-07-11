package com.chainsys.application.doctor;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class DoctorService 
{
    @Autowired
    private DoctorRepository repo;
//    @Bean
//    public void setRepo(DoctorRepository repo)
//    {
//        this.repo=repo;
//    }
    @GetMapping("/getdoctor")
    public Doctor getDoctor(int id)
    {
        return repo.findById(id);
    }
    
    @PostMapping(value="/newdoctor", consumes = "application/json")
    //we need to give from where to read data from the http req and also the content type
    public String addNewDoctor(@RequestBody Doctor dr)
    {
        repo.save(dr);
        return "redirect:/getalldoctors";
    }
    @PostMapping(value="/modifydoctor", consumes = "application/json")
    public String modifyDoctor(@RequestBody Doctor dr)
    {
        repo.save(dr);
        return "redirect:/getalldoctors";
    }
    
    @DeleteMapping("/deletedoctor")
    public String deleteDoctor(int id)
    {
        repo.deleteById(id);
        return "redirect:/getalldoctors";
    }
    
    @GetMapping("/getall")
    public List<Doctor> getDoctors()
    {
        return repo.findAll();
    }
    
}