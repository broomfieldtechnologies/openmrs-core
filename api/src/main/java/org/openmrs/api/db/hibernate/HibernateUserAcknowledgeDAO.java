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

//US10060
import org.openmrs.api.context.Context;
import org.openmrs.api.db.UserAcknowledgeDAO;
import org.openmrs.UserAcknowledge;
import org.openmrs.api.db.hibernate.DbSession;
import org.openmrs.api.db.hibernate.DbSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.*;
import java.util.*;
import org.openmrs.GlobalProperty;

import java.util.Date;

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
	public UserAcknowledge saveUserAcknowledge(Integer authUserId, int intervalValue) {
		
		
		Date loginDate = new Date();
		
		Date lastLoginDate = null;
		
		Query query = null;
		
		String sql="select * from user_acknowledge where user_id= :userId";
		
	
		query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		query.setInteger("userId", authUserId);
		
		
		UserAcknowledge userser = null;
		
		if((query.uniqueResult()==null)) {
			
			UserAcknowledge userAcknowledge=new UserAcknowledge();
			userAcknowledge.setUserId(authUserId);
			userAcknowledge.setLoginDate(loginDate);
			
			sessionFactory.getCurrentSession().saveOrUpdate(userAcknowledge);
		}
		else {
			
			
			
			if(query.uniqueResult()!=null) {
			
				
				Query querys = sessionFactory.getCurrentSession().createQuery("from UserAcknowledge ua where ua.userId= :authUser").setInteger("authUser", authUserId);
				
				List<UserAcknowledge> userAcknowledgeList = querys.list();
			
		 	
				userser = userAcknowledgeList.get(0);
			
				lastLoginDate=userser.getLoginDate();
				
				long interval=0;
				
				interval = (loginDate.getTime() - lastLoginDate.getTime())/86400000;
				
				log.error("inteval inside else:" +interval);
				
				if (interval > 30) {
					
					
					String sqlUpdate = "update user_acknowledge set login_date = :logd1 where user_id = :useridauth";
					sessionFactory.getCurrentSession().createSQLQuery(sqlUpdate).setParameter("logd1", loginDate).setParameter("useridauth", authUserId).executeUpdate();
					
					
					
				}}
				
			
		}
		
		
		
		
		return userser;
		 
	}
	
	
	@Override
	public Date checkLastLogin(Integer authUserId) {
		
		UserAcknowledge userAcknowledge = null;
		Date lastLoginDate = null;
		
				
	
		Query userIdQuery = sessionFactory.getCurrentSession().createQuery("from UserAcknowledge ua where ua.userId= :authUser").setInteger("authUser", authUserId);
		
		if(userIdQuery.uniqueResult()!=null) {
		
		List<UserAcknowledge> userAcknowledgeList = userIdQuery.list();
		
	 	
		userAcknowledge=userAcknowledgeList.get(0);
		
		lastLoginDate=userAcknowledge.getLoginDate();
		
		} 
		
		return lastLoginDate;
	}
	
	
	
	
	@Override
	public boolean checkExsisting(Integer authUserId) {
		
		boolean checkExsistingFlag = false;
		
		Query checkExsistingQuery = sessionFactory.getCurrentSession().createQuery("from UserAcknowledge ua where ua.userId= :authUser").setInteger("authUser", authUserId);
		
		if(checkExsistingQuery.uniqueResult()!=null) {
			checkExsistingFlag = true;
		}
		
		return checkExsistingFlag;
		
	}
	
}
