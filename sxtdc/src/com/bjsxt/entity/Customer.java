package com.bjsxt.entity;

import java.util.Date;

/**
 * 
 * @author ZhaoWeiguang
 *
 */
public class Customer {
	private int cusid;        //客户编号
	private String empid;     //员工编号
	private int typeid;       //类型编号
	private int staid;        //状态编号
	private int souid;        //来源编号
	private String cusName;   //客户姓名
	private String cusSex;    //客户性别
	private Date birthday;    //出生日期
	private String cusCompany;//客户公司
	private String cusJob;    //客户职位
	private String cusAddress;//客户地址
	private String cusPhone;     //客户手机
	private String cusPlane;     //客户座机
	private String cusQQ;        //客户QQ
	private String email;     //客户邮箱
	private String fouder;    //创建人    当前登录用户的姓名   自动获取
	private Date addTime;     //创建时间  自动获取
	private String changeMan; //修改人    当前登录用户的姓名   自动获取
	private String remark;    //备注
	private Date updateTime;  //修改时间  自动获取
	private int allot;        //表示分配状态，  0代表未分配， 1 代表已分配
	private String province;  //省
	
	private Employee emp;     //存储员工的所有信息
	private CustomerType type;        //客户类型信息
	private CustomerStatus status;    //客户状态信息
	private CustomerSource source;    //客户来源信息
	
	private int demandRoom;	//客户需求面积
	private int demandFloor;	//客户需求楼层
	private boolean isSigned;	//客户是否签约
	public int getDemandPrice() {
		return demandPrice;
	}


	public void setDemandPrice(int demandPrice) {
		this.demandPrice = demandPrice;
	}


	private int subScription;	//客户认筹认购金额
	private boolean isHasBuy;	//客户是否商购
	private int demandPrice;	//客户需求价格
	
	
	public int getDemandRoom() {
		return demandRoom;
	}


	public void setDemandRoom(int demandRoom) {
		this.demandRoom = demandRoom;
	}


	public int getDemandFloor() {
		return demandFloor;
	}


	public void setDemandFloor(int demandFloor) {
		this.demandFloor = demandFloor;
	}


	public boolean isSigned() {
		return isSigned;
	}


	public void setSigned(boolean isSigned) {
		this.isSigned = isSigned;
	}


	public int getSubScription() {
		return subScription;
	}


	public void setSubScription(int subScription) {
		this.subScription = subScription;
	}


	public boolean isHasBuy() {
		return isHasBuy;
	}


	public void setHasBuy(boolean isHasBuy) {
		this.isHasBuy = isHasBuy;
	}


	//构造方法
	public Customer() {
		super();
	}


	//根据条件查询的构造方法
	public Customer( String empid, int typeid, int staid, int souid,
			String cusName, String cusCompany) {
		super();
		
		this.empid = empid;
		this.typeid = typeid;
		this.staid = staid;
		this.souid = souid;
		this.cusName = cusName;
		this.cusCompany = cusCompany;
		
	}
	

	//添加客户的构造方法
	public Customer(  int typeid, int staid, int souid,
			String cusName, String cusSex, Date birthday, String cusCompany,
			String cusJob, String cusAddress, String cusPhone, String cusPlane,
			String cusQQ, String email, String fouder, Date addTime,
			 String remark ,int allot,String province) {
		super();				
		this.typeid = typeid;
		this.staid = staid;
		this.souid = souid;
		this.cusName = cusName;
		this.cusSex = cusSex;
		this.birthday = birthday;
		this.cusCompany = cusCompany;
		this.cusJob = cusJob;
		this.cusAddress = cusAddress;
		this.cusPhone = cusPhone;
		this.cusPlane = cusPlane;
		this.cusQQ = cusQQ;
		this.email = email;
		this.fouder = fouder;
		this.addTime = addTime;	
		this.remark = remark;
		this.allot = allot;
		this.province = province;
	}

	public String getProvince() {
		return province;
	}


	public void setProvince(String province) {
		this.province = province;
	}


	//修改客户信息的构造方法
	public Customer( int cusid, int typeid, int staid, int souid,
			String cusName,  String cusCompany,
			String cusJob, String cusAddress, String cusPhone, String cusPlane,
			String cusQQ, String email, 
			String changeMan, String remark, Date updateTime
			) {
		super();
		this.cusid = cusid;
		this.typeid = typeid;
		this.staid = staid;
		this.souid = souid;
		this.cusName = cusName;		
		this.cusCompany = cusCompany;
		this.cusJob = cusJob;
		this.cusAddress = cusAddress;
		this.cusPhone = cusPhone;
		this.cusPlane = cusPlane;
		this.cusQQ = cusQQ;
		this.email = email;		
		this.changeMan = changeMan;
		this.remark = remark;
		this.updateTime = updateTime;
		
	}

	//全部属性构造方法
		public Customer(int cusid, String empid, int typeid, int staid, int souid,
				String cusName, String cusSex, Date birthday, String cusCompany,
				String cusJob, String cusAddress, String cusPhone, String cusPlane,
				String cusQQ, String email, String fouder, Date addTime,
				String changeMan, String remark, Date updateTime, Employee emp,
				CustomerType type, CustomerStatus status, CustomerSource source,int allot) {
			super();
			this.cusid = cusid;
			this.empid = empid;
			this.typeid = typeid;
			this.staid = staid;
			this.souid = souid;
			this.cusName = cusName;
			this.cusSex = cusSex;
			this.birthday = birthday;
			this.cusCompany = cusCompany;
			this.cusJob = cusJob;
			this.cusAddress = cusAddress;
			this.cusPhone = cusPhone;
			this.cusPlane = cusPlane;
			this.cusQQ = cusQQ;
			this.email = email;
			this.fouder = fouder;
			this.addTime = addTime;
			this.changeMan = changeMan;
			this.remark = remark;
			this.updateTime = updateTime;
			this.emp = emp;
			this.type = type;
			this.status = status;
			this.source = source;
			this.allot = allot;
		}


	public int getCusid() {
		return cusid;
	}


	public void setCusid(int cusid) {
		this.cusid = cusid;
	}


	public String getEmpid() {
		return empid;
	}


	public void setEmpid(String empid) {
		this.empid = empid;
	}


	public int getTypeid() {
		return typeid;
	}


	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}


	public int getStaid() {
		return staid;
	}


	public void setStaid(int staid) {
		this.staid = staid;
	}


	public int getSouid() {
		return souid;
	}


	public void setSouid(int souid) {
		this.souid = souid;
	}


	public String getCusName() {
		return cusName;
	}


	public void setCusName(String cusName) {
		this.cusName = cusName;
	}


	public String getCusSex() {
		return cusSex;
	}


	public void setCusSex(String cusSex) {
		this.cusSex = cusSex;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public String getCusCompany() {
		return cusCompany;
	}


	public void setCusCompany(String cusCompany) {
		this.cusCompany = cusCompany;
	}


	public String getCusJob() {
		return cusJob;
	}


	public void setCusJob(String cusJob) {
		this.cusJob = cusJob;
	}


	public String getCusAddress() {
		return cusAddress;
	}


	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}


	public String getCusPhone() {
		return cusPhone;
	}


	public void setCusPhone(String cusPhone) {
		this.cusPhone = cusPhone;
	}


	public String getCusPlane() {
		return cusPlane;
	}


	public void setCusPlane(String cusPlane) {
		this.cusPlane = cusPlane;
	}


	public String getCusQQ() {
		return cusQQ;
	}


	public void setCusQQ(String cusQQ) {
		this.cusQQ = cusQQ;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFouder() {
		return fouder;
	}


	public void setFouder(String fouder) {
		this.fouder = fouder;
	}


	public Date getAddTime() {
		return addTime;
	}


	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}


	public String getChangeMan() {
		return changeMan;
	}


	public void setChangeMan(String changeMan) {
		this.changeMan = changeMan;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	public Date getUpdateTime() {
		return updateTime;
	}


	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	public Employee getEmp() {
		return emp;
	}


	public void setEmp(Employee emp) {
		this.emp = emp;
	}


	public CustomerType getType() {
		return type;
	}


	public void setType(CustomerType type) {
		this.type = type;
	}


	public CustomerStatus getStatus() {
		return status;
	}


	public void setStatus(CustomerStatus status) {
		this.status = status;
	}


	public CustomerSource getSource() {
		return source;
	}


	public void setSource(CustomerSource source) {
		this.source = source;
	}


	public int getAllot() {
		return allot;
	}


	public void setAllot(int allot) {
		this.allot = allot;
	}


	@Override
	public String toString() {
		return "Customer [cusid=" + cusid + ", empid=" + empid + ", typeid="
				+ typeid + ", staid=" + staid + ", souid=" + souid
				+ ", cusName=" + cusName + ", cusSex=" + cusSex + ", birthday="
				+ birthday + ", cusCompany=" + cusCompany + ", cusJob="
				+ cusJob + ", cusAddress=" + cusAddress + ", cusPhone="
				+ cusPhone + ", cusPlane=" + cusPlane + ", cusQQ=" + cusQQ
				+ ", email=" + email + ", fouder=" + fouder + ", addTime="
				+ addTime + ", changeMan=" + changeMan + ", remark=" + remark
				+ ", updateTime=" + updateTime + ", emp=" + emp + ", type="
				+ type + ", status=" + status + ", source=" + source + "]";
	}
	
	
}
