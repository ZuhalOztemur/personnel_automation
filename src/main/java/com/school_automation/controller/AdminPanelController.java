package com.school_automation.controller;

import com.school_automation.entity.DeveloperEntity;
import com.school_automation.entity.AdministrativeEntity;
import com.school_automation.entity.ManagerEntity;
import com.school_automation.form.CreateDeveloperForm;
import com.school_automation.form.CreateAdministrativeForm;
import com.school_automation.form.CreateManagerForm;
import com.school_automation.form.LoginForm;
import com.school_automation.service.DeveloperService;
import com.school_automation.service.AdministrativeService;
import com.school_automation.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/admin")
public class AdminPanelController {

    @Autowired
    ManagerService managerService;

    @Autowired
    AdministrativeService administrativeService;

    @Autowired
    DeveloperService developerService;

    @GetMapping
    private String getAdminLoginPage(Model model, HttpSession session){
        if (session.getAttribute("loginAdmin") != null){
            return "adminPanelManager";
        }
        model.addAttribute("loginForm",new LoginForm());
        return "adminLogin";
    }

    @PostMapping(value = "/login")
    private String adminLogin(@ModelAttribute LoginForm loginForm, HttpSession session, Model model){
        ManagerEntity managerEntity = managerService.getManagerByUserName(loginForm.getUserName());
        if (managerEntity != null && managerEntity.getPassword().equals(loginForm.getPassword()) ){
            session.setAttribute("loginAdmin",loginForm.getUserName());
            model.addAttribute("managerList", managerService.getAll().stream().map(ManagerEntity::toDTO).collect(Collectors.toList()));
            model.addAttribute("createManagerForm",new CreateManagerForm());
            return "adminPanelManager";
        }
        return "redirect:/admin";
    }

    @GetMapping(value = "/get-admin-administrative")
    private String getAdminAdministrativePage(HttpSession session, Model model){
        if (session.getAttribute("loginAdmin") != null){
            model.addAttribute("administrativeList",administrativeService.getAll().stream().map(AdministrativeEntity::toDTO).collect(Collectors.toList()));
            model.addAttribute("createAdministrativeForm",new CreateAdministrativeForm());
            return "adminPanelAdministrative";
        }
        return "redirect:/admin";
    }

    @GetMapping(value = "/get-admin-manager")
    private String getAdminManagerPage(HttpSession session, Model model){
        if (session.getAttribute("loginAdmin") != null){
            model.addAttribute("managerList", managerService.getAll().stream().map(ManagerEntity::toDTO).collect(Collectors.toList()));
            model.addAttribute("createManagerForm",new CreateManagerForm());
            return "adminPanelManager";
        }
        return "redirect:/admin";
    }

    @GetMapping(value = "/get-admin-developer")
    private String getAdminDeveloperPage(HttpSession session,Model model){
        if (session.getAttribute("loginAdmin") != null){
            model.addAttribute("developerList",developerService.getAll().stream().map(DeveloperEntity::toDTO).collect(Collectors.toList()));
            model.addAttribute("createDeveloperForm",new CreateDeveloperForm());
            return "adminPanelDeveloper";
        }
        return "redirect:/admin";
    }


    @GetMapping(value = "/logout")
    private String logOut(HttpSession session){
        session.setAttribute("loginAdmin",null);
        return "redirect:/admin";
    }
}
