package org.wuyi.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
@Entity
@PrimaryKeyJoinColumn(name = "user_id")
public class Admin extends User {

	private static final long serialVersionUID = -2868159710951467718L;
	
}
