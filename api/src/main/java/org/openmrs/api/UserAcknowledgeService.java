/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.api;

import org.openmrs.UserAcknowledge;
import org.openmrs.api.db.*;
import org.openmrs.annotation.Authorized;
import org.springframework.transaction.annotation.Transactional;

public interface UserAcknowledgeService extends OpenmrsService {
	
	public UserAcknowledgeDAO getUserAcknowledgeDAO();
	
	public void setUserAcknowledgeDAO(UserAcknowledgeDAO userAcknowledgeDAO);
	
	public void setUserAcknowledgeService(UserAcknowledgeService userAcknowledgeService);
	
	
	
	public UserAcknowledgeService getUserAcknowledgeService();
	//the above throws api exception in the last code
	
	//@Authorized()
	//@Transactional(readOnly = true)
	//UserAcknowledge getUserAcknowledgeById(Integer id) throws APIException;
	
	//	@Authorized(EnterpriseConfig.MODULE_PRIVILEGE)
	
	@Authorized()
	@Transactional
	UserAcknowledge saveUserAcknowledge(UserAcknowledge userAcknowledge) throws APIException;
}
