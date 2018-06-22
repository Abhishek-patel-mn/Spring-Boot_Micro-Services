package com.abhi.atm.service;

import java.util.List;

import com.abhi.atm.common.BusinessServiceException;
import com.abhi.atm.common.DataAccessException;
import com.abhi.atm.dao.ConfigParam;
import com.abhi.atm.dto.ConfigParamDto;


/**
 * @author Abhishek Patel M N Jan 17, 2018
 */
public interface ConfigParamMgmtService {

	void addConfigParam(ConfigParamDto configParamDto) throws BusinessServiceException, DataAccessException;

	List<ConfigParamDto> getAllConfigParams() throws BusinessServiceException, Exception;

	ConfigParamDto getConfigParamByConfigParamId(Integer configParamId) throws BusinessServiceException, DataAccessException;

	void deleteConfigParam(Integer configParamId) throws BusinessServiceException, DataAccessException;

	void updateConfigParam(ConfigParamDto configParamDto) throws BusinessServiceException, DataAccessException;

	ConfigParam findByParamName(String configParamName);
	
}
