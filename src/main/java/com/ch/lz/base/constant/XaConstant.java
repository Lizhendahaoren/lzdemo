package com.ch.lz.base.constant;

/**
 * @Title: XaConstant.java
 * @Package com.xa3ti.shengmilu.base.constant
 * @Description: 常量类
 * @author hchen
 * @date 2014年8月2日 上午10:07:48
 * @version V1.0
 */
public class XaConstant {

	/**
	 * @ClassName: UserStatus
	 * @Description: 后台用户状态常量
	 * @author hchen
	 * @date 2014年8月2日 上午10:10:09
	 */
	public static class UserStatus {
		/**
		 * @Fields status_normal : 正常
		 */
		public static final int status_normal = 1;
		/**
		 * @Fields status_lock : 锁定或禁用
		 */
		public static final int status_lock = 0;
		/**
		 * @Fields status_delete : 已删除
		 */
		public static final int status_delete = 9;

	}

	/**
	 * @ClassName: RoleStatus
	 * @Description: 角色的状态
	 * @author hchen
	 * @date 2014年8月2日 上午10:53:08
	 *
	 */
	public static class RoleStatus {
		/**
		 * @Fields status_normal : 正常
		 */
		public static final int status_normal = 1;
		/**
		 * @Fields status_delete : 已删除
		 */
		public static final int status_delete = 0;
	}

	/**
	 * @ClassName: ResourcesStatus
	 * @Description: 资源的状态
	 * @author hchen
	 * @date 2014年8月2日 上午11:14:46
	 *
	 */
	public static class ResourcesStatus {
		/**
		 * @Fields status_normal : 正常
		 */
		public static final int status_normal = 1;
		/**
		 * @Fields status_delete : 已删除
		 */
		public static final int status_delete = 0;
	}

	/**
	 * @ClassName: ResourceShowType
	 * @Description: 资源级别
	 * @author hchen
	 * @date 2014年8月8日 下午2:23:32
	 *
	 */
	public static class ResourceShowType {
		/**
		 * @Fields page_level : 页面级资源
		 */
		public static final int page_level = 0;
		/**
		 * @Fields menu_level : 菜单级资源
		 */
		public static final int menu_level = 2;
		/**
		 * @Fields button_level : 按钮级资源
		 */
		public static final int button_level = 1;
	}

	public static class SessionKey {

		/**
		 * @Fields currentUser : session中存放和获取当前用户信息的key
		 */
		public static final String currentUser = "currentUser";

		/**
		 * @Fields currentMenuData : session中存放和获取当前用户菜单的key
		 */
		public static final String currentMenuData = "currentMenuData";

		/**
		 * @Fields currentMessageList : 发消息的队列
		 */
		public static final String currentMessageList = "messageUserList";
	}

	/**
	 * @ClassName: Status
	 * @Description: 常用状态类型
	 * @author hchen
	 * @date 2014年8月13日 下午2:45:25
	 *
	 */
	public static class Status {
		/**
		 * @Fields locked : 锁定状态
		 */
		public static final int locked = -1;

		/**
		 * @Fields invalid : 删除/无效状态
		 */
		public static final int invalid = 0;

		/**
		 * @Fields valid : 有效/正常状态
		 */
		public static final int valid = 1;

		/**
		 * @Fields publish : 发布
		 */
		public static final int publish = 2;

		/**
		 * @Fields delete : 删除
		 */
		public static final int delete = 3;
	}

	/**
	 * @ClassName: TreeNodeIcon
	 * @Description: 节点类型
	 * @author hchen
	 * @date 2014年8月13日 下午1:59:01
	 *
	 */
	public static class TreeNodeIcon {
		/**
		 * @Fields html_24 : 24*24的页面级菜单图片
		 */
		public static final String html_24 = "image/html_24.png";
		/**
		 * @Fields menu_24 : 24*24的菜单级菜单图片
		 */
		public static final String menu_24 = "image/menu_24.png";
		/**
		 * @Fields action_24 : 24*24的按钮级菜单图片
		 */
		public static final String action_24 = "image/action_24.png";
	}

	/**
	 * @ClassName: Code
	 * @Description: xaResult的code
	 * @author hchen
	 * @date 2014年8月15日 下午5:34:20
	 *
	 */
	public static final class Code {
		/**
		 * @Fields ok : 成功
		 */
		public static final int success = 1;
		/**
		 * @Fields error : 失败
		 */
		public static final int error = 0;
		/**
		 * token失效
		 */
		public static final int code_failure_token = 101;
		/**
		 * fresh_token失效
		 */
		public static final int code_failure_fresh_token = 102;

		public static final int code_system_failure = 10001;

		public static final int code_business_failure = 20001;

		public static final int code_validation_failure = 30001;

		public static final int code_database_failure = 40001;

		public static final int code_json_failure = 50001;
	}

	/**
	 * @ClassName: Message
	 * @Description: xaResult的message
	 * @author hchen
	 * @date 2014年8月15日 下午5:34:20
	 *
	 */
	public static final class Message {
		/**
		 * @Fields ok : 成功
		 */
		public static final String success = "成功!";
		/**
		 * @Fields error : 失败
		 */
		public static final String error = "系统错误!";
		public static final String object_not_find = "找不到要操作的记录!";
	}

	/**
	 * 用户类型
	 * 
	 * @author hchen
	 *
	 */
	public static final class userType {
		// 1为新浪微博、2为QQ、3为微信、4：表示系统注册帐户
		/**
		 * 新浪用户
		 */
		public static final int sina = 1;
		/**
		 * QQ用户
		 */
		public static final int qq = 2;
		/**
		 * 微信用户
		 */
		public static final int weixi = 3;
		/**
		 * 系统帐户
		 */
		public static final int system = 4;
	}

	/**
	 * 用户性别
	 * 
	 * @author hchen
	 *
	 */
	public static final class userSex {
		/**
		 * 女性
		 */
		public static final int female = 1;
		/**
		 * 男性
		 */
		public static final int male = 2;
	}

	/**
	 * 用户设备
	 * 
	 * @author hchen
	 *
	 */
	public static final class userDevice {
		/**
		 * ios设备
		 */
		public static final int ios = 1;
		/**
		 * android设备
		 */
		public static final int android = 2;
		/**
		 * wap
		 */
		public static final int wap = 3;
	}

	/**
	 * 价格参数一级分类
	 * 
	 * @author Administrator
	 *
	 */
	public static final class priceProperty {
		/**
		 * 
		 */
		public static final String material = "面料";
		/**
		 * 
		 */
		public static final String print = "打印";
		/**
		 * 
		 */
		public static final String pack = "包装";
	}

	/**
	 * 订单状态
	 */
	public static final class orderStatus {
		/**
		 * 待支付
		 */
		public static final int notpay = 1;
		/**
		 * 已付款
		 */
		public static final int alreadPay = 2;
		/**
		 * 制作中
		 */
		public static final int work = 3;
		/**
		 * 发货中
		 */
		public static final int send = 4;
		/**
		 * 已完成
		 */
		public static final int complete = 5;
		/**
		 * 用户取消
		 */
		public static final int userCancle = -1;
		/**
		 * 系统退单
		 */
		public static final int systemCancle = -2;
	}

	/**
	 * 两个用户之间的关系
	 * 
	 * @author Administrator
	 *
	 */
	public static final class isFriends {
		/**
		 * 表示当前用户已关注要查看的用户，但是要查看的用户并未关注当前用户
		 */
		public static final int attentionOther = 1;
		/**
		 * 表示当前用户未关注要查看的用户，但是要查看的用户已关注当前用户
		 */
		public static final int attentionSelf = 2;
		/**
		 * 表示当前用户已关注要查看的用户，要查看的用户也已经关注当前用户
		 */
		public static final int friends = 3;
		/**
		 * 双方都未关注对方
		 */
		public static final int strange = 2;
	}

	/**
	 * 积分类型
	 * 
	 * @author Administrator
	 *
	 */
	public static final class integralType {
		/**
		 * 创作
		 */
		public static final int createProduct = 1;
		/**
		 * 被评论
		 */
		public static final int comment = 2;
		/**
		 * 购买作品
		 */
		public static final int buyProduct = 3;
		/**
		 * 销售作品
		 */
		public static final int saleProduct = 4;
	}

	/**
	 * 栏目对应的新闻类型
	 * 
	 * @author lex
	 *
	 */
	public static final class newsType {
		/**
		 * 富文本新闻
		 */
		public static final int richText = 1;
		/**
		 * 视频新闻
		 */
		public static final int media = 3;
		/**
		 * 图片新闻
		 */
		public static final int picture = 2;
		/**
		 * 杂志新闻
		 */
		public static final int magazine = 4;
	}

	/**
	 * 审核状态
	 * 
	 * @author lex
	 *
	 */
	public static final class audioStatus {
		/**
		 * 待审核
		 */
		public static final int notAudio = 0;
		/**
		 * 审核通过
		 */
		public static final int pass = 1;
		/**
		 * 审核未通过
		 */
		public static final int notPass = -1;
	}

	/**
	 * 搜索关键字类型
	 * 
	 * @author Administrator
	 *
	 */
	public static final class keyType {
		/**
		 * 标题
		 */
		public static final int newsTitle = 1;
		/**
		 * 作者
		 */
		public static final int newsAuthor = 2;
		/**
		 * 全部
		 */
		public static final int all = 3;
	}

	/**
	 * 随手拍类型
	 * 
	 * @author Administrator
	 *
	 */
	public static final class TakephotoType {
		/**
		 * 图片
		 */
		public static final int pic = 1;
		/**
		 * 视频
		 */
		public static final int media = 2;

	}

	public static final class PictureType {

		/**
		 * 兼职用户相册
		 */
		public static final int album = 1;

		/**
		 * 技能证书
		 */
		public static final int skill = 2;
		/**
		 * 银行证书
		 */
		public static final int bank = 3;

	}

	/**
	 * 简历投递状态
	 * 
	 * @author lex
	 *
	 */
	public static final class deliveryStatus {

		/**
		 * 简历已成功投递，但还没被查看
		 */
		public static final int delivery = 0;
		/**
		 * 简历已被查看
		 */
		public static final int alreadySee = 1;

		/**
		 * 简历被企业用户聘用
		 */
		public static final int offer = 2;

	}
}
