package com.personnel_automation.controller;
import com.personnel_automation.entity.DeveloperEntity;
import com.personnel_automation.form.CreateDeveloperForm;
import com.personnel_automation.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;
@Controller
@RequestMapping(value = "/developer")
public class DeveloperController {
    @Autowired
    private DeveloperService developerService;


    @PostMapping(value = "/create")
    private String createOrUpdateDeveloper(@ModelAttribute CreateDeveloperForm createDeveloperForm){
        developerService.createDeveloper(createDeveloperForm);
        return "redirect:/admin/get-admin-developer";
    }

    @GetMapping(value = "/delete/{developerId}")
    private String deleteDeveloper(@PathVariable("developerId") Long developerId){
        developerService.deleteDeveloper(developerId);
        return "redirect:/admin/get-admin-developer";
    }

    @GetMapping(value = "/{developerId}")
    private String getDeveloperById(@PathVariable("developerId") Long developerId, Model model){

        DeveloperEntity developerEntity = developerService.getDeveloperById(developerId);

        CreateDeveloperForm createDeveloperForm = new CreateDeveloperForm();

        createDeveloperForm.setId(developerEntity.getId());
        createDeveloperForm.setName(developerEntity.getName());
        createDeveloperForm.setUserName(developerEntity.getUserName());
        createDeveloperForm.setPassword(developerEntity.getPassword());
        createDeveloperForm.setPay(developerEntity.getPay());


        model.addAttribute("developerList", developerService.getAll().stream().map(DeveloperEntity::toDTO).collect(Collectors.toList()));
        model.addAttribute("createDeveloperForm",createDeveloperForm);
        return "adminPanelDeveloper";  //!!!
    }

    @GetMapping
    private String getDeveloperById( Model model){
        model.addAttribute("developers",developerService.getAll());
        return "developers"; //!!!
    }


}
