package com.example.StudentprojectInfo.controller;

import com.example.StudentprojectInfo.dto.Projectrequest;
import com.example.StudentprojectInfo.model.Project;
import com.example.StudentprojectInfo.service.Projectservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class Projectcontroller {
    @Autowired
    private Projectservice projectservice;
    @PostMapping("/addproject")
    public ResponseEntity<Project> saveproject(@RequestBody @Valid Projectrequest projectrequest ) {
        return new ResponseEntity<>(projectservice.saveproject(projectrequest), HttpStatus.CREATED);
    }
    @GetMapping("/project")
    public List<Project> getproject(){
        return projectservice.getproject();
    }
    @GetMapping("/project/{id}")
    public Project  getprojectbyid(@PathVariable int id){
        return projectservice.getprojectbyid(id);
    }
    @PutMapping("/updateproject/{id}")
    public Project updateproject(@PathVariable int id,@RequestBody @Valid Projectrequest projectrequest){
        return projectservice.updateproject(id,projectrequest);
    }
    @DeleteMapping("/deleteproject/{id}")
    public String deleteproject(@PathVariable int id){
        return projectservice.deleteproject(id);
    }
}
