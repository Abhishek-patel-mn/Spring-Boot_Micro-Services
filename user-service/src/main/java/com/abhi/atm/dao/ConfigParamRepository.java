package com.abhi.atm.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigParamRepository extends MongoRepository<ConfigParam, Integer> {

	ConfigParam findByParamName(String paramName);
}
