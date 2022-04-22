package com.cnda.csvtodb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cnda.csvtodb.model.DaGroupUser;

@Repository
public interface DaGroupUserRepo extends CrudRepository<DaGroupUser, Integer> {

}
