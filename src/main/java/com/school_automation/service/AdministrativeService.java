package com.school_automation.service;

import com.school_automation.form.CreateAdministrativeForm;
import com.school_automation.entity.AdministrativeEntity;
import com.school_automation.repository.AdministrativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class AdministrativeService
{
    @Autowired
    private AdministrativeRepository administrativeRepository;

    public List<AdministrativeEntity> getAll()
    {
        Iterator<AdministrativeEntity> administrativesIt = administrativeRepository.findAll().iterator();
        List<AdministrativeEntity> administratives = new ArrayList<>();

        administrativesIt.forEachRemaining(administratives::add);

        return administratives;
    }

    public AdministrativeEntity getAdministrativeById(Long id){
        return administrativeRepository.findById(id).get();
    }

    public void createAdministrative(CreateAdministrativeForm createAdministrativeForm)
    {
        AdministrativeEntity administrativeEntity;
        if (createAdministrativeForm.getId() == null) {
            administrativeEntity = new AdministrativeEntity();
        }else{
            Optional<AdministrativeEntity> administrativeEntityOptional = administrativeRepository.findById(createAdministrativeForm.getId());
            administrativeEntity = administrativeEntityOptional.orElseGet(AdministrativeEntity::new);
        }
        administrativeEntity.setName(createAdministrativeForm.getName());
        administrativeEntity.setBranch(createAdministrativeForm.getBranch());
        administrativeEntity.setUserName(createAdministrativeForm.getUserName());
        administrativeEntity.setPassword(createAdministrativeForm.getPassword());

        administrativeRepository.save(administrativeEntity);
    }

    public void updateAdministrative(CreateAdministrativeForm createAdministrativeForm)
    {
        AdministrativeEntity administrativeEntity = new AdministrativeEntity();
        administrativeEntity.setName(createAdministrativeForm.getName());
        administrativeEntity.setBranch(createAdministrativeForm.getBranch());
        administrativeEntity.setUserName(createAdministrativeForm.getUserName());
        administrativeEntity.setPassword(createAdministrativeForm.getPassword());

        administrativeRepository.save(administrativeEntity);
    }

    public void deleteAdministrative(Long id)
    {
        Optional<AdministrativeEntity> administrativeEntityOptional = administrativeRepository.findById(id);
        administrativeEntityOptional.ifPresent(administrativeEntity -> administrativeRepository.delete(administrativeEntity));
    }
}
