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
package org.openmrs.api.db;

import java.util.*;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.UserAcknowledge;
import org.openmrs.api.db.hibernate.DbSession;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserAcknowledgeDAO {
	
	public SessionFactory getSessionFactory();
	
	public void setSessionFactory(SessionFactory sessionFactory);
	
	public UserAcknowledge saveUserAcknowledge(Integer id, int intervalValue) throws DAOException;
	
	public Date checkLastLogin(Integer id) throws DAOException;
	
	public boolean checkExsisting(Integer id) throws DAOException;
	
}
