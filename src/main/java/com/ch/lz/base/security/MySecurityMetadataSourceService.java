package com.ch.lz.base.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ch.lz.base.constant.XaConstant;
import com.ch.lz.base.entity.XaCmsRole;
import com.ch.lz.base.repository.MyCmsResoureRepository;
import com.ch.lz.base.repository.MyCmsRoleRepository;
import com.ch.lz.base.util.XaUtil;

/**
 * 最核心的地方，就是提供某个资源对应的权限定义，即getAttributes方法返回的结果。 此类在初始化时，应该取到所有资源及其对应角色的定义
 * 形成以URL为key，权限列表为value的Map时，
 * 要注意key和Value的对应性，避免Value的不正确对应形成重复，这样会导致没有权限的人也能访问到不该访问到的资源。
 * 还有getAttributes()方法，要有 url.indexOf("?")这样的判断，要通过判断对URL特别是Action问号之前的部分进行匹配，
 * 防止用户请求的带参数的URL与你数据库中定义的URL不匹配，造成访问拒绝！
 * 
 * @author lizhen
 *
 */
@Service("MySecurityMetadataSourceService")
@Transactional
public class MySecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {

	@Autowired
	private MyCmsResoureRepository myCmsResoureRepository;

	@Autowired
	private MyCmsRoleRepository myCmsRoleRepository;

	private static final Logger logger = Logger.getLogger(MySecurityMetadataSourceService.class);

	// 存储资源权限的 key--url value--权限列表
	private static Map<String, Collection<ConfigAttribute>> roleMap = null;

	// 在web启动时提取所有资源权限
	public void loadResourceDefine() {
		if (XaUtil.isEmpty(roleMap)) {// 未null时
			roleMap = new LinkedHashMap<String, Collection<ConfigAttribute>>();
		}
		// 获取所有权限
		//Iterator<XaCmsRole> iterator = myCmsRoleRepository.findAllXaCmsRole(XaConstant.RoleStatus.status_normal).iterator();

		Iterator<XaCmsRole> AllRole = myCmsRoleRepository.findAllRole(XaConstant.Status.valid).iterator();
		while (AllRole.hasNext()) {// 便利权限 查找url
			XaCmsRole mcr = AllRole.next();
			// 根据RoleId 查找url list
			List<String> urlByRoleId = myCmsResoureRepository.findResoureUrlByRoleId(mcr.getRoleId());
			for (String url : urlByRoleId) {
				if (XaUtil.isNotEmpty(url)) {// url不是空时
					if (XaUtil.isNotEmpty(mcr.getRoleName())) {// 权限不是空时
						ConfigAttribute configAttribute = new SecurityConfig(mcr.getRoleName());
						Collection<ConfigAttribute> configAttributes = null;
						if (url.length() > 0) {// 对url进行处理 防止出错
							if (!"/".equals(url.substring(0, 1))) {
								url = "/" + url;
							}
						}
						if (roleMap.containsKey(url)) {// 先判断roleMap是否已经有这个url
														// 防止出现重复
							configAttributes = roleMap.get(url);
						} else {
							configAttributes = new ArrayList<ConfigAttribute>();
						}
						configAttributes.add(configAttribute);// 添加到权限列表
						roleMap.put(url, configAttributes);
					}
				}
			}
		}
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object arg0) throws IllegalArgumentException {
		// arg0 是一个URL，被用户请求的url。
		String url = ((FilterInvocation) arg0).getRequestUrl();
		int firstQuestionMarkIndex = url.indexOf("?");
		if (firstQuestionMarkIndex != -1) {
			url = url.substring(0, firstQuestionMarkIndex);
		}
		if (roleMap == null) {
			loadResourceDefine();
		}
		logger.info("--获取该url权限--url:" + url);
		return roleMap.get(url);
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	// 将roleMap设为null
	public static void reset() {
		roleMap = null;
	}

}
