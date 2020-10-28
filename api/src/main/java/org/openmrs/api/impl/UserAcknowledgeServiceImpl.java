/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.api.impl;

import org.openmrs.UserAcknowledge;
import org.openmrs.api.APIException;
import org.openmrs.api.UserAcknowledgeService;
import org.openmrs.api.UserService;
import org.openmrs.api.db.UserAcknowledgeDAO;

public class UserAcknowledgeServiceImpl extends BaseOpenmrsService implements UserAcknowledgeService {
	
	UserAcknowledgeDAO dao;
	
	UserService userService;
	
	/**
	 * Injected in moduleApplicationContext.xml
	 */
	public void setDao(UserAcknowledgeDAO dao) {
		this.dao = dao;
	}
	
	/**
	 * Injected in moduleApplicationContext.xml
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public UserAcknowledge getUserAcknowledgeById(Integer id) throws APIException {
		return dao.getUserAcknowledgeById(id);
	}
	
	@Override
	public UserAcknowledge saveUserAcknowledge(UserAcknowledge userAcknowledge) throws APIException {
		//		if (enterprise.getCreator() == null) {
		//			enterprise.setCreator(userService.getUser(1));
		//		}
		
		return dao.saveUserAcknowledge(userAcknowledge);
	}
}
