package com.ch.lz.base.entity;

import java.io.Serializable;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

// TODO: Auto-generated Javadoc
/**
 * 系统资源实体.
 */
@Entity
@Table(name="tb_cms_resource")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class XaCmsResource   implements Serializable{

	private static final long serialVersionUID = -6716116635654730576L;
	
	
	/** 资源Id. */
	private Long resourceId;
	
	/** 资源名称. */
	private String resourceName;
	
	/** 资源路径. */
	private String resourceUrl;
	
	/** 排序号(序号越大，菜单显示越下面). */
	private int orderNum;
	
	/** 显示类型
	 *  0: 页面级别
	 *  1：按钮级别 .
	 *  2:菜单级 */
	private int showType;
	
	/**
	 * @Fields parentId : 如果为空，表示一级菜单，不为空，表示为子菜单
	 */
	private Long parentId;
	
	/**
	 * @Fields status : 资源的状态，1表示可用，0表示不可用或已删除
	 */
	private int status;
	

	/**
	 * @Fields parentResourceName : 父资源名称
	 */
	private String parentResourceName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="resource_id")
	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	@Column(name="resource_name", nullable=false, length=40)
	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	@Column(name="resource_url", nullable=false, length=100)
	public String getResourceUrl() {
		return resourceUrl;
	}

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	@Column(name="order_num")
	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	@Column(name="show_type")
	public int getShowType() {
		return showType;
	}

	public void setShowType(int showType) {
		this.showType = showType;
	}

	@Column(name="parent_id")
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Column(name="status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Transient
	public String getParentResourceName() {
		return parentResourceName;
	}

	public void setParentResourceName(String parentResourceName) {
		this.parentResourceName = parentResourceName;
	}
	
	
}
