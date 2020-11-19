/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Please note that a corresponding table schema must be created in liquibase.xml.
 */

@Entity(name = "userAcknowledge")
@Table(name = "user_acknowledge")
public class UserAcknowledge extends BaseOpenmrsData {
	
	@Id
	@GeneratedValue
	@Column(name = "user_acknowledge_id")
	private Integer id;
	
	@Basic
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "login_date")
	private Date loginDate;
	
	// default constructor
	@Autowired
	public UserAcknowledge() {
	}
	
	public UserAcknowledge(Integer userId) {
		this.userId=userId;
	}
	
	@Override
	public Integer getId() {
		return id;
	}
	
	@Override
	@Autowired
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getUserId() {
		return userId;
	}
	@Autowired
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Date getLoginDate() {
		return loginDate;
	}
	@Autowired
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	
}
