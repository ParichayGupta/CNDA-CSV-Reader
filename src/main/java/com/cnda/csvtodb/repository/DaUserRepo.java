package com.cnda.csvtodb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cnda.csvtodb.model.DaUser;

@Repository
public interface DaUserRepo extends CrudRepository<DaUser, Integer> {

}
