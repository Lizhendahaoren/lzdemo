package com.ch.lz.base.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.persistence.Version;

import com.ch.lz.base.constant.XaConstant;
import com.wordnik.swagger.annotations.ApiModelProperty;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 * ID
	 */
	private Long tId;

	@ApiModelProperty(value = "状态，0：无效，1：为正常,9：删除 参看XaConstant.Status")
	private Integer status;

	@ApiModelProperty(value = "版本,hibernate维护")
	private Integer version;

	@ApiModelProperty(value = "@Fields createUser : 创建者")
	private Long createUser;

	@ApiModelProperty(value = "@Fields createTime : 创建时间")
	private Long createTime;
	
	@ApiModelProperty(value = " 创建时间 字符串形式")
	private String createTimeStr;

	@ApiModelProperty(value = "@Fields modifyUser : 修改者")
	private Long modifyUser;

	@ApiModelProperty(value = "@Fields modifyTime : 修改时间")
	private Long modifyTime;
	
	@ApiModelProperty(value = "修改时间 字符串")
	private String modifyTimeStr;

	@ApiModelProperty(value = "@Fields modifyDescription : 修改描述")
	private String modifyDescription;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	@Column(name = "id", nullable = false, columnDefinition = "BIGINT UNSIGNED")
	public Long gettId() {
		return tId;
	}

	public void settId(Long tId) {
		this.tId = tId;
	}

	@Column(name = "createTimeStr")
	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	@Column(name = "modifyTimeStr")
	public String getModifyTimeStr() {
		return modifyTimeStr;
	}

	public void setModifyTimeStr(String modifyTimeStr) {
		this.modifyTimeStr = modifyTimeStr;
	}

	/**
	 * 为确保赋值增加默认值1:正常
	 */
	@Column(nullable = false, columnDefinition = "int default 1")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Version
	@Column(nullable = false, columnDefinition = "int default 0")
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Column(name = "createUser")
	public Long getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}

	@Column(name = "createTime")
	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	@Column(name = "modifyUser")
	public Long getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(Long modifyUser) {
		this.modifyUser = modifyUser;
	}

	@Column(name = "modifyTime")
	public Long getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Long modifyTime) {
		this.modifyTime = modifyTime;
	}

	@Column(name = "modifyDescription", length = 500)
	public String getModifyDescription() {
		return modifyDescription;
	}

	public void setModifyDescription(String modifyDescription) {
		this.modifyDescription = modifyDescription;
	}

	/**
	 * 数据插入前的操作
	 */
	@PrePersist
	public void setInsertBefore() {
		this.createTime = (new Date()).getTime();
		this.createTimeStr = getLongToString((new Date()).getTime());
		if(status == null){
			this.status = XaConstant.Status.valid;
		}
		this.modifyTime = (new Date()).getTime();
		this.modifyTimeStr = getLongToString((new Date()).getTime());
	}

	/**
	 * 数据修改前的操作
	 */
	@PreUpdate
	public void setUpdateBefore() {
		this.modifyTime = (new Date()).getTime();
		this.modifyTimeStr = getLongToString((new Date()).getTime());
	}

	@Transient
	@ApiModelProperty(value = "创建时间的字符串表示")
	public String getCreateAtStr() {
		// return CommonUtils.getStrDate(createTime,
		// CommonUtils.YYYYMMDDHHMMSS);
		return getLongToString(createTime);
	}

	@Transient
	@ApiModelProperty(value = "修改时间的字符串表示")
	public String getUpdatedAtStr() {
		// return CommonUtils.getStrDate(modifyTime,
		// CommonUtils.YYYYMMDDHHMMSS);
		return getLongToString(modifyTime);
	}

	public static String getLongToString(Long longTime) {
		if (longTime == null) {
			return null;
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(longTime);
		return sf.format(date);
	}
}
