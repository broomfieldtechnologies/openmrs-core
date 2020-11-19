/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */

package org.openmrs.api.db.hibernate;

import org.openmrs.api.db.UserAcknowledgeDAO;
import org.hibernate.SessionFactory;
import org.openmrs.UserAcknowledge;
import org.openmrs.api.db.hibernate.DbSession;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;

@Repository("userAcknowledgeService")
public class HibernateUserAcknowledgeDAO implements UserAcknowledgeDAO {
	
	private static final Logger log = LoggerFactory.getLogger(HibernateUserDAO.class);
	
	/**
	 * Hibernate session factory
	 */
	//@Autowired
	SessionFactory sessionFactory;
	
	/**
	 * Set session factory
	 * 
	 * @param sessionFactory
	 */
	//@Autowired
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	

	@Override
	public UserAcknowledge saveUserAcknowledge(UserAcknowledge userAcknowledge) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(userAcknowledge);
		return userAcknowledge;
		
	}
	
}
