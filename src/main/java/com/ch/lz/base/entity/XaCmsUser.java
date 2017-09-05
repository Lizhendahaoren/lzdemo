package com.ch.lz.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 用户实体.
 */
@Entity
@Table(name = "tb_cms_user")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class XaCmsUser implements java.io.Serializable {

	private static final long serialVersionUID = -2588141205901945887L;

	/** 用户Id. */
	private Long userId;

	/** 用户名. */
	private String userName;

	/** 真实姓名. */
	private String realName;

	/**
	 * 用户状态. 1.正常 0.锁定 9.删除
	 */
	private int status;

	/** 密码. */
	private String password;

	/** 手机号. */
	private String mobile;

	/** 邮箱地址. */
	private String email;

	/** 用户描述. */
	private String description;
	
	private String user_sessionId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "user_sessionId", nullable = false, length = 100)
	public String getUser_sessionId() {
		return user_sessionId;
	}
	public void setUser_sessionId(String user_sessionId) {
		this.user_sessionId = user_sessionId;
	}
	
	@Column(name = "user_name", nullable = false, length = 20)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "real_name", nullable = false, length = 20)
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Column(name = "status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name = "password", nullable = false, length = 100)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "mobile", length = 20)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "email", length = 30)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "description", length = 150)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

}