package com.personnel_automation.service;

import com.personnel_automation.form.CreateManagerForm;
import com.personnel_automation.entity.ManagerEntity;
import com.personnel_automation.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ManagerService
{
    @Autowired
    private ManagerRepository managerRepository;

    public List<ManagerEntity> getAll()
    {
        Iterator<ManagerEntity> managersIt = managerRepository.findAll().iterator();
        List<ManagerEntity> managers = new ArrayList<>();

        managersIt.forEachRemaining(managers::add);

        return managers;
    }

    public ManagerEntity getManagerById(Long id){
        return managerRepository.findById(id).get();
    }
    public ManagerEntity getManagerByUserName(String userName){
        return managerRepository.findManagerEntityByUserName(userName);
    }

    public void createManager(CreateManagerForm createManagerForm)
    {

        ManagerEntity managerEntity;
        if (createManagerForm.getId() == null) {
            managerEntity = new ManagerEntity();
        }else{
            Optional<ManagerEntity> managerEntityOptional = managerRepository.findById(createManagerForm.getId());
            managerEntity = managerEntityOptional.orElseGet(ManagerEntity::new);
        }

        managerEntity.setPassword(createManagerForm.getPassword());
        managerEntity.setUserName(createManagerForm.getUserName());

        managerRepository.save(managerEntity);
    }

    public void updateManager(CreateManagerForm createManagerForm)
    {
        ManagerEntity managerEntity = new ManagerEntity();
        managerEntity.setPassword(createManagerForm.getPassword());
        managerEntity.setUserName(createManagerForm.getUserName());

        managerRepository.save(managerEntity);
    }


    public void deleteManager(Long id)
    {
        Optional<ManagerEntity> managerEntityOptional = managerRepository.findById(id);
        managerEntityOptional.ifPresent(managerEntity -> managerRepository.delete(managerEntity));
    }
}
