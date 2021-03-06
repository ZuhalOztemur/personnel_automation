package com.personnel_automation.controller;

import com.personnel_automation.entity.AdministrativeEntity;
import com.personnel_automation.form.CreateAdministrativeForm;
import com.personnel_automation.service.AdministrativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/administrative")
public class AdministrativeController
{
    @Autowired
    private AdministrativeService administrativeService;


    @PostMapping(value = "/create")
    private String createOrUpdateAdministrative(@ModelAttribute CreateAdministrativeForm createAdministrativeForm){
        administrativeService.createOrUpdateAdministrative(createAdministrativeForm);
        return "redirect:/admin/get-admin-administrative";
    }

    @GetMapping(value = "/delete/{administrativeId}")
    private String deleteStudent(@PathVariable("administrativeId") Long administrativeId){
        administrativeService.deleteAdministrative(administrativeId);
        return "redirect:/admin/get-admin-administrative";
    }

    @GetMapping(value = "/{administrativeId}")
    private String getAdministrativeById(@PathVariable("administrativeId") Long administrativeId, Model model){

        AdministrativeEntity administrativeEntity = administrativeService.getAdministrativeById(administrativeId);

        CreateAdministrativeForm createAdministrativeForm = new CreateAdministrativeForm();
        createAdministrativeForm.setId(administrativeEntity.getId());
        createAdministrativeForm.setName(administrativeEntity.getName());
        createAdministrativeForm.setBranch(administrativeEntity.getBranch());
        createAdministrativeForm.setPassword(administrativeEntity.getPassword());
        createAdministrativeForm.setUserName(administrativeEntity.getUserName());

        model.addAttribute("administrativeList", administrativeService.getAll().stream().map(AdministrativeEntity::toDTO).collect(Collectors.toList()));
        model.addAttribute("createAdministrativeForm",createAdministrativeForm);
        return "adminPanelAdministrative";
    }

    @GetMapping
    private String getAdministrativeById( Model model){
        model.addAttribute("administratives",administrativeService.getAll());
        return "administratives";
    }

}
