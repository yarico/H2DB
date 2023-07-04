package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;
import com.example.demo.student.Student;

@Controller
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien);
		return "home.jsp";
	}
	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {
		
		ModelAndView mv= new ModelAndView("show.jsp");
		Alien alien = repo.findById(aid).orElse(new Alien());
		mv.addObject(alien);
		
		return mv;
	}
	@RequestMapping("/deleteStudent")
	  public String deleteStudent(int aid) {
	        repo.deleteById(aid);
	        return "home.jsp";
	   }
	@RequestMapping("/updateStudent")
	 public String updateStudent(int aid, Alien alen) {
	        repo.save(alen);
	        return "home.jsp";
	   }
/*	@RequestMapping("/getAlien")
     public ModelAndView getAllStudents() {
    	
        
    	
       ModelAndView mv= new ModelAndView("show.jsp");
        List<Alien> students = new ArrayList<>();
    	
        repo.findAll()
        .forEach(students::add);
		mv.addObject(students);
		
		return mv;		
    }*/
}
