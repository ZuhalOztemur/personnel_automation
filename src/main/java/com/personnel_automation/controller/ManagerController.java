package com.personnel_automation.controller;

import com.personnel_automation.entity.ManagerEntity;
import com.personnel_automation.form.CreateManagerForm;
import com.personnel_automation.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/manager")
public class ManagerController
{
    @Autowired
    private ManagerService managerService;


    @PostMapping(value = "/create")
    private String createOrUpdateManager(@ModelAttribute CreateManagerForm createManagerForm){
        managerService.createManager(createManagerForm);
        return "redirect:/admin/get-admin-manager";
    }

    @GetMapping(value = "/delete/{managerId}")
    private String deleteManager(@PathVariable("managerId") Long managerId){
        managerService.deleteManager(managerId);
        return "redirect:/admin/get-admin-manager";
    }

    @GetMapping(value = "/{managerId}")
    private String getManagerById(@PathVariable("managerId") Long managerId, Model model){

        ManagerEntity managerEntity = managerService.getManagerById(managerId);

        CreateManagerForm createManagerForm = new CreateManagerForm();

        createManagerForm.setId(managerEntity.getId());
        createManagerForm.setPassword(managerEntity.getPassword());
        createManagerForm.setUserName(managerEntity.getUserName());

        model.addAttribute("managerList", managerService.getAll().stream().map(ManagerEntity::toDTO).collect(Collectors.toList()));
        model.addAttribute("createManagerForm",createManagerForm);
        return "adminPanelManager";
    }
    @GetMapping
    private String getManagerById( Model model){
        model.addAttribute("managers",managerService.getAll());
        return "managers";
    }
}
