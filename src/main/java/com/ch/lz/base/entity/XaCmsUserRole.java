package com.ch.lz.base.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

// TODO: Auto-generated Javadoc
/**
 * 用户角色关系实体.
 */
@Entity
@Table(name = "tb_cms_user_role")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class XaCmsUserRole implements Serializable {

	private static final long serialVersionUID = 3858125794616531577L;

	/** The version. */
	private Long version;

	/** Id. */
	private Long id;

	/** 用户. */
	private Long userId;

	/** 角色. */
	private Long roleId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Version
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
