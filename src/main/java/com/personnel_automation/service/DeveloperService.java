package com.personnel_automation.service;


import com.personnel_automation.form.CreateDeveloperForm;
import com.personnel_automation.entity.DeveloperEntity;
import com.personnel_automation.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class DeveloperService
{
    @Autowired
    private DeveloperRepository developerRepository;

    public List<DeveloperEntity> getAll()
    {
        Iterator<DeveloperEntity> developersIt = developerRepository.findAll().iterator();
        List<DeveloperEntity> developers = new ArrayList<>();

        developersIt.forEachRemaining(developers::add);

        return developers;
    }

    public DeveloperEntity getDeveloperById(Long id){
        return developerRepository.findById(id).get();
    }
    public DeveloperEntity getDeveloperByUserName(String userName){
        return developerRepository.findDeveloperEntityByUserName(userName);
    }

    public void createDeveloper(CreateDeveloperForm createDeveloperForm)
    {
        DeveloperEntity developerEntity;
        if (createDeveloperForm.getId() == null) {
            developerEntity = new DeveloperEntity();
        }else{
            Optional<DeveloperEntity> developerEntityOptional = developerRepository.findById(createDeveloperForm.getId());
            developerEntity = developerEntityOptional.orElseGet(DeveloperEntity::new);
        }

        developerEntity.setName(createDeveloperForm.getName());
        developerEntity.setPay(createDeveloperForm.getPay());

        developerRepository.save(developerEntity);
    }

    public void updateDeveloper(CreateDeveloperForm createDeveloperForm)
    {
        DeveloperEntity developerEntity = new DeveloperEntity();
        developerEntity.setName(createDeveloperForm.getName());
        developerEntity.setPay(createDeveloperForm.getPay());

        developerRepository.save(developerEntity);
    }

    public void deleteDeveloper(Long id)
    {
        Optional<DeveloperEntity> developerEntityOptional = developerRepository.findById(id);
        developerEntityOptional.ifPresent(developerEntity -> developerRepository.delete(developerEntity));
    }
}
