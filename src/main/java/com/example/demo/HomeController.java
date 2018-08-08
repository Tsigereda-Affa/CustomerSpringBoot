package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
   @Autowired
    CustomerRepository customerRepository;
   @RequestMapping("/")
    public String listCustomers(Model model){
       model.addAttribute("customers",customerRepository.findAll());
       return "list";
   }

    @RequestMapping("/detail/{id}")
    public String showCourse(@PathVariable("id") long id, Model model){
        model.addAttribute("customer", customerRepository.findById(id).get());
        return "show";
    }
}
