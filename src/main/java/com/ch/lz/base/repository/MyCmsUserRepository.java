package com.ch.lz.base.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ch.lz.base.entity.XaCmsUser;

/**
 * 
 * 用户持久层
 * 
 * @author lz
 *
 */
public interface MyCmsUserRepository
		extends PagingAndSortingRepository<XaCmsUser, Long>, JpaSpecificationExecutor<XaCmsUser> {

	/**
	 * @Description 查找用户信息
	 * @param userName
	 * @param stuts
	 * @return XaCmsUser
	 * @author lz
	 */
	@Query("from XaCmsUser xcu where xcu.userName=?1 and xcu.status=?2")
	XaCmsUser findUserByName(String userName, Integer stuts);

}
