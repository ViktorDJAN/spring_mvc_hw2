package ru.kashtanov.spring_mvc_hw2.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kashtanov.spring_mvc_hw2.dao.EmployeeDAO;
import ru.kashtanov.spring_mvc_hw2.models.Employee;

import java.util.logging.Logger;

@Controller
@RequestMapping("chief_page")
public class ChiefController {
    private final Logger logger = Logger.getLogger(String.valueOf(ChiefController.class));
    private final EmployeeDAO employeeDAO;



    @Autowired
    public ChiefController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    /**Read*/
    @GetMapping
    public String chiefPage(Model model){
        logger.info("HERE IS A CHIEF PAGE");
        model.addAttribute("employees",employeeDAO.getAllEmployees());
        return "chief_page/chief_index";
    }

    @GetMapping("/{id}")
    public String certainEmployee(@PathVariable("id")int id , Model model){
        logger.info("HERE IS A CERTAIN EMPLOYEE PAGE");
        model.addAttribute("employee",employeeDAO.showEmployeeWithId(id));
        return "employee_page/certain_employee";
    }
    /**Create*/
    @PostMapping
    public String createEmploy(@ModelAttribute("createdEmployee") Employee employee){
        logger.info("HERE IS AN EMPLOYEE CREATING");
        employeeDAO.saveEmployee(employee);
        return "redirect:/chief_page";
    }

    @GetMapping("/{id}/edit")
    public String changeEmployee(@PathVariable("id")int id, Model model){
        logger.info("HERE IS AN EMPLOYEE CHANGING");
        model.addAttribute("employee",employeeDAO.showEmployeeWithId(id));
        return "employee_page/change_employee";
    }
    /**Update*/
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("employee")Employee employee,@PathVariable("id") int id){
        logger.info("HERE IS AN EMPLOYEE UPDATING");
        employeeDAO.update(id,employee);
        return "redirect:/chief_page";
    }

    @GetMapping("/new")
    public String newEmployee(Model model){
        logger.info("HERE IS AN NEW PEOPLE REPRESENTATION");
        model.addAttribute("createdEmployee",new Employee());
        return "employee_page/new";
    }

    /**Delete*/
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id")int id){
        logger.info("DELETE METHOD IS IMPLEMENTING HERE");
        employeeDAO.delete(id);
        return "redirect:/chief_page";
    }

}
