/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */

//US10060
package org.openmrs.api.impl;

import org.openmrs.UserAcknowledge;
import org.openmrs.api.APIException;
import org.openmrs.api.UserAcknowledgeService;
import org.openmrs.api.UserService;
import org.openmrs.api.db.UserAcknowledgeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;

public class UserAcknowledgeServiceImpl extends BaseOpenmrsService implements UserAcknowledgeService {
	
UserAcknowledgeService userAcknowledgeService;	
UserAcknowledgeDAO userAcknowledgeDAO;
	
	public UserAcknowledgeDAO getUserAcknowledgeDAO() {
		return userAcknowledgeDAO;
	}

	public void setUserAcknowledgeDAO(UserAcknowledgeDAO userAcknowledgeDAO) {
		this.userAcknowledgeDAO = userAcknowledgeDAO;
	}
	
	public UserAcknowledgeService getUserAcknowledgeService() {
		return userAcknowledgeService;
	}
	
	public void setUserAcknowledgeService(UserAcknowledgeService userAcknowledgeService) {
		this.userAcknowledgeService = userAcknowledgeService;
	}

	@Override
	public UserAcknowledge saveUserAcknowledge(Integer id, int intervalValue) throws APIException {
		return userAcknowledgeDAO.saveUserAcknowledge(id, intervalValue);
	}
	
	@Override
	public Date checkLastLogin(Integer id) throws APIException {
		return userAcknowledgeDAO.checkLastLogin(id);
	}
	
	@Override
	public boolean checkExsisting(Integer id) throws APIException {
		return userAcknowledgeDAO.checkExsisting(id);
	}
	
	
}
