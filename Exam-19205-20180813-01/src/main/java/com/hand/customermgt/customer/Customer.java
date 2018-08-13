package com.hand.customermgt.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hand.common.Md5;

/**
 * 用户信息表
 * @author 周宇
 *
 */
@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String password;
	
	/**
	 * 是否是管理员或者普通用户的标识
	 */
	private String flag;
	
	/**
	 * 版本号
	 */
	private Long versionId = 0L;
	
	public final static String MANAGER="MANAGER";
	
	public final static String USER="USER";
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		//使用MD5对数据库密码加密
		password = Md5.makeMD5(password);
		this.password = password;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public static String getManager() {
		return MANAGER;
	}

	public static String getUser() {
		return USER;
	}

	public Long getVersionId() {
		return versionId;
	}

	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", password=" + password + ", flag=" + flag + ", versionId="
				+ versionId + "]";
	}

	public Customer(Long id, String name, String password, String flag, Long versionId) {
		super();
		this.id = id;
		this.name = name;
		password = Md5.makeMD5(password);
		this.password = password;
		this.flag = flag;
		this.versionId = versionId;
	}

	public Customer() {
		super();
	}


	
	
}
