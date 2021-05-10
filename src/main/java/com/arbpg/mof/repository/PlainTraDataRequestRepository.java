package com.arbpg.mof.repository;

import com.arbpg.mof.model.PlainTrandata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlainTraDataRequestRepository extends CrudRepository<PlainTrandata, String> {

}
