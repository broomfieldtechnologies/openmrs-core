/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.api.db;

import org.hibernate.criterion.Restrictions;
import org.openmrs.UserAcknowledge;
import org.openmrs.api.db.hibernate.DbSession;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserAcknowledgeDAO {
	
	//	public UserAcknowledge saveUserAcknowledge(UserAcknowledge userAcknowledge) throws DAOException;
	
	@Autowired
	DbSessionFactory sessionFactory;
	
	private DbSession getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	//	public UserAcknowledge getUserAcknowledge(Integer userAcknowledgeId) throws DAOException;
	
	//	public void deleteUserAcknowledge(UserAcknowledge userAcknowledge) throws DAOException;
	
	public UserAcknowledge getUserAcknowledgeById(Integer id) {
		return (UserAcknowledge) getSession().createCriteria(UserAcknowledge.class).add(Restrictions.eq("id", id)).uniqueResult();
	}
	
	public UserAcknowledge saveUserAcknowledge(UserAcknowledge userAcknowledge) {
		getSession().saveOrUpdate(userAcknowledge);
		return userAcknowledge;
	}
}
