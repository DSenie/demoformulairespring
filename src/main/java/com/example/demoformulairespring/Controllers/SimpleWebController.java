package com.example.demoformulairespring.Controllers;

import com.example.demoformulairespring.Repository.CustomerRepository;
import com.example.demoformulairespring.entity.Customer;
import org.apache.tomcat.jni.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@Controller
public class SimpleWebController {

    @Autowired
    CustomerRepository customerRepository;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value="/form", method=RequestMethod.GET)
    public String customerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "form";
    }



    @RequestMapping(value="/form", method=RequestMethod.POST)
    public String customerSubmit(@ModelAttribute Customer customer, Model model) {

        model.addAttribute("customer", customer);
        String info = String.format("Customer Submission: id = %d, firstname = %s, lastname = %s, fonction = %s ",
                customer.getId(), customer.getFirstname(), customer.getLastname(), customer.getFonction());
        log.info(info);
        customerRepository.save(customer);
        return "result";
    }

    @RequestMapping(value="/load", method=RequestMethod.GET)
    public String customerSubmit(@RequestParam("id") long id, Model model) {
        Customer customer = customerRepository.findById(id).orElse(null);
        model.addAttribute("customer", customer);
        return "load";
    }

    @RequestMapping(value="/modifier", method=RequestMethod.GET)
    public String customerModifier(@RequestParam("id") long id, Model model) {
        Customer customer = customerRepository.findById(id).orElse(null);
        model.addAttribute("customer", customer);
        return "modifier";
    }

    @RequestMapping(value="/modifier/{id}", method=RequestMethod.POST)
    public String updateUser(@PathVariable("id") long id, Customer user, Model model) {
        Customer customer = customerRepository.findById(id).orElse(null);
        customer.setFirstname(user.getFirstname());
        customerRepository.save(customer);
        return "result";
    }


    @RequestMapping(value="/list", method=RequestMethod.GET)
    public String findCities(Model model) {

        List<Customer> custumer = (List<Customer>) customerRepository.findAll();
        model.addAttribute("custumer", custumer);
        return "list";
    }

}
