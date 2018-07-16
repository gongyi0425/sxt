package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjsxt.dao.CustomerDao;
import com.bjsxt.entity.Customer;
import com.bjsxt.entity.CustomerSource;
import com.bjsxt.entity.CustomerStatus;
import com.bjsxt.entity.CustomerType;
import com.bjsxt.entity.Employee;
import com.bjsxt.util.DBUtil;
/**
 * 客户  dao 层实现类
 * @author ZhaoWeiguang
 *
 */
public class CustomerDaoImpl implements CustomerDao{

	
	/**
	 * 保存客户信息导数据库
	 */
	public int saveCus(Customer cus) {
		String sql = "insert into Customer(CUSID,TYPEID,STAID,SOUID,CUSNAME,CUSSEX,BIRTHDAY,CUSCOMPANY,"
				+ "CUSJOB,CUSADDRESS,CUSPHONE,CUSPLANE,CUSQQ,EMAIL,FOUDER,ADDTIME,REMARK,ALLOT,PROVINCE) "
				+ "values(seq_customer.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";		
		
		Object[] params = {
							cus.getTypeid(),
							cus.getStaid(),
							cus.getSouid(),
							cus.getCusName(),
							cus.getCusSex(),
							new java.sql.Date(cus.getBirthday().getTime()),
							cus.getCusCompany(),
							cus.getCusJob(),
							cus.getCusAddress(),
							cus.getCusPhone(),
							cus.getCusPlane(),
							cus.getCusQQ(),
							cus.getEmail(),
							cus.getFouder(),
							new java.sql.Date(cus.getAddTime().getTime()),
							cus.getRemark(),
							cus.getAllot(),
							cus.getProvince()
						  };
		
		return DBUtil.executeUpdate(sql, params);
	}

	/**
	 * 根据条件查询客户信息
	 */
	public List<Customer> findCusByXXX(String cusName2, String staName2,
			String souName2, String typeName2, String empid2, String cusCompany2, int cusid2,int allot2) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//创建一个list集合
		List<Customer> cusList = new ArrayList<Customer>();
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();			
			//创建可变字符串   方便sql语句的拼接  默认是查询全部
			StringBuilder sql = new StringBuilder(""
					 +" select cus.*,sou.souname,sta.staname,typ.typeName,emp.empname"
					 +" from customer cus"
					 +" left join CustomerSource sou"
					 +" on cus.souid= sou.souid"
					 +" left join CustomerStatus sta"
					 +" on cus.staid=sta.staid"
					 +" left join CustomerType typ"
					 +" on cus.typeid=typ.typeid"
					 +" left join Employee emp"
					 +" on cus.empid=emp.empid"
			         +" where 1=1"
					);
			//判断是否增加查询条件
			if(empid2!=null && !("".equals(empid2))){
				sql.append(" and cus.empid like '%"+empid2+"%'");
			}
			if(cusName2!=null && !("".equals(cusName2))){
				sql.append(" and cus.cusName like '%"+cusName2+"%'");
			}
			
			if(staName2!=null && !("".equals(staName2))){
				sql.append(" and sta.staName like '%"+staName2+"%'");
			}
			if(souName2!=null && !("".equals(empid2))){
				sql.append(" and sou.souName like '%"+souName2+"%'");
			}
			if(typeName2!=null && !("".equals(typeName2))){
				sql.append(" and typ.typeName like '%"+empid2+"%'");
			}
			if(cusCompany2!=null && !("".equals(cusCompany2))){
				sql.append(" and cus.cusCompany like '%"+cusCompany2+"%'");
			}
			if(cusid2 > 0){
				sql.append(" and cus.cusid="+cusid2);
			}
			if(allot2 == 0){
				sql.append(" and cus.allot="+allot2);
			}
			
			//3.创建SQL命令发送器
			pstmt = conn.prepareStatement(sql.toString());//注意要将sql转变成String字符串			
			//4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果			
			rs = pstmt.executeQuery();			
			//5.处理结果（封装到List中）
			while(rs.next()){
				//取出当前行各个字段的值				 
				int cusid = rs.getInt("cusid");	        //客户编号
				String empid = rs.getString("empid");   //员工编号
				int typeid = rs.getInt("typeid");	    //类型编号   
				int staid = rs.getInt("staid");         //状态编号
				int souid = rs.getInt("souid");         //来源编号
				String cusName = rs.getString("cusName");//客户姓名 
				String cusSex = rs.getString("cusSex");  //客户性别
				Date birthday = rs.getDate("birthday");  //出生日期
				String cusCompany = rs.getString("cusCompany"); //客户公司
				String cusJob = rs.getString("cusJob");         //客户职位
				String cusAddress = rs.getString("cusAddress"); //客户地址
				String cusPhone = rs.getString("cusPhone");    //客户手机
				String cusPlane = rs.getString("cusPlane");    //客户座机
				String cusQQ = rs.getString("cusQQ");          //客户QQ
				String email = rs.getString("email");    //客户邮箱  
				String fouder = rs.getString("fouder");  //创建人    当前登录用户的姓名   自动获取
				Date addTime = rs.getDate("addTime");    //创建时间  自动获取
				String changeMan = rs.getString("changeMan"); //修改人    当前登录用户的姓名   自动获取
				String remark = rs.getString("remark");       //备注
				Date updateTime = rs.getDate("updateTime");   //修改时间  自动获取
				int allot = rs.getInt("allot");

				String empName = rs.getString("empName");   //员工姓名
				Employee emp = new Employee();
				emp.setEmpName(empName);
				
				String typeName = rs.getString("typeName");  //类型名称
				CustomerType type = new CustomerType();
				type.setTypeName(typeName);
				
				String staName = rs.getString("staName");    //状态名称
				CustomerStatus status = new CustomerStatus();
				status.setStaName(staName);
				
				String souName = rs.getString("souName");   //来源名称
				CustomerSource source = new CustomerSource();
				source.setSouName(souName);

				Customer cus = new Customer(cusid, empid, typeid, staid, souid, cusName, cusSex, birthday, cusCompany, cusJob, cusAddress, cusPhone, cusPlane, cusQQ, email, fouder, addTime, changeMan, remark, updateTime, emp, type, status, source,allot);
				//将数据添加到集合中
				cusList.add(cus);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		
		//7.返回数据		
		return cusList;
	}

	/**
	 * 删除客户
	 */
	public int deleteCus(int cusid) {
		String sql = " delete from customer where cusid=?";		

		Object[] params = {cusid};		
		return DBUtil.executeUpdate(sql, params);
	}

	/**
	 * 修改员工信息
	 */
	public int updateCus(Customer cus) {
		String sql = "update Customer set TYPEID=?,STAID=?,SOUID=?,CUSNAME=?,CUSCOMPANY=?,"
				+ "CUSJOB=?,CUSADDRESS=?,CUSPHONE=?,CUSPLANE=?,CUSQQ=?,EMAIL=?,CHANGEMAN=?,"
				+ "REMARK=?,UPDATETIME=?"
				+ "where cusid=?";
		Object[] params = {
				cus.getTypeid(),
				cus.getStaid(),
				cus.getSouid(),
				cus.getCusName(),
				cus.getCusCompany(),
				cus.getCusJob(),
				cus.getCusAddress(),
				cus.getCusPhone(),
				cus.getCusPlane(),
				cus.getCusQQ(),
				cus.getEmail(),
				cus.getChangeMan(),
				cus.getRemark(),
				new java.sql.Date(cus.getUpdateTime().getTime()),
				cus.getCusid()
				};
		return DBUtil.executeUpdate(sql, params);
	}

	/**
	 * 客户分配
	 */
	public int allotCus(int cusid, String empid) {
		
		String sql = "update Customer set empid=? where cusid=?";
				
		Object[] params = {empid,cusid};
		return DBUtil.executeUpdate(sql, params);
	}

	/**
	 * 客户分布图显示
	 */
	public List<Object[]> getAreaData() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Object []> areaList = new ArrayList<Object[]>();
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();
			
			//3.创建SQL命令发送器（手枪）
			pstmt = conn.prepareStatement("select province,count(*) from customer group by province");
			//4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果（子弹）			
			rs = pstmt.executeQuery();
			
			//5.处理结果（封装到List中）
			while(rs.next()){
				//1.取出当前行各个字段的值
				String province = rs.getString(1);
				int count = rs.getInt(2);
				//2.将当前行各个字段的值封装到Employee对象中
				Object []  arr = {province,count};
				//3.将user放入userList
				areaList.add(arr);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		
		//7.返回数据		
		return areaList;
	}

}
