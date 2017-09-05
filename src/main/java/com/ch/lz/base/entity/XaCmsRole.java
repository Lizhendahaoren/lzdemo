package com.ch.lz.base.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

// TODO: Auto-generated Javadoc
/**
 * 系统角色实体.
 */
@Entity
@Table(name="tb_cms_role")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class XaCmsRole implements Serializable{
	
	private static final long serialVersionUID = 700235310223571456L;

	
	/** 角色Id. */
	private Long roleId;
	
	/** 角色名称. */
	private String roleName;
	
	/** 角色描述 */
	private String roleDesc;
	
	/** 状态. */
	private int status;
	

	
	
	
	public XaCmsRole(String roleName, String roleDesc) {
		this.roleName = roleName;
		this.roleDesc = roleDesc;
	}

	public XaCmsRole() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id")
	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	@Column(name="role_name", nullable=false, length=40)
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name="status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name="role_desc")
	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
}
