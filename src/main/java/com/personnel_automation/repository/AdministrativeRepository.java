package com.personnel_automation.repository;

import com.personnel_automation.entity.AdministrativeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrativeRepository extends CrudRepository<AdministrativeEntity, Long> {
    AdministrativeEntity findAdministrativeEntityByUserName(String userName);
}
