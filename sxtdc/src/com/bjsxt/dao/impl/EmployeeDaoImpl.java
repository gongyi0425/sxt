package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bjsxt.dao.EmployeeDao;
import com.bjsxt.entity.Department;
import com.bjsxt.entity.Employee;
import com.bjsxt.entity.Position;
import com.bjsxt.util.DBUtil;
/**
 * 员工  dao 层实现类
 * @author ZhaoWeiguang
 *
 */
public class EmployeeDaoImpl implements EmployeeDao{

	/**
	 * 保存员工信息到数据库
	 */
	public int saveEmp(Employee emp) {
		String sql = "insert into employee values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";		
		
		//先判断离职日期是否为空，如果是null就不转换，避免转换异常
		java.sql.Date leaveDate02 = null;
		Date leaveDate = emp.getLeaveDate();
		if(leaveDate != null){
			leaveDate02 = new java.sql.Date(leaveDate.getTime());
		}
		Object[] params = {
							emp.getEmpid(),
							emp.getPassword(),
							emp.getDeptno(),
							emp.getPosid(),
							emp.getMgrid(),
							emp.getEmpName(),
							emp.getEmpAge(),
							emp.getEmpSex(),
							emp.getEmpEducation(),
							emp.getIdcard(),
							emp.getNation(),
							emp.getMarry(),
							emp.getPhone(),
							emp.getQq(),
							emp.getAddress(),
							emp.getEmail(),
							emp.getEmpType(),							
							new java.sql.Date(emp.getBrithDate().getTime()),
							new java.sql.Date(emp.getHireDate().getTime()),							
							leaveDate02,
							emp.getWagesnum(),
							emp.getOnDuty(),
							emp.getEmerContactPerson(),
							emp.getEmpDesc(),
							emp.getSign()
						  };
		
		return DBUtil.executeUpdate(sql, params);
	}
	
	
	/**
	 * 查询员工功能
	 * 可根据条件查询员工的信息
	 * 所在的岗位信息和部门信息
	 */
	public List<Employee> findEmpByXXX(String empid2,int deptno2,int posid2,int onduty2,String hireDate2,String empName2) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//创建一个list集合
		List<Employee> empList = new ArrayList<Employee>();
		try {
			//2.建立和数据库的连接（url，user、password）			
			conn =DBUtil.getConnection();			
			//创建可变字符串   方便sql语句的拼接  默认是查询全部
			StringBuilder sql = new StringBuilder(""
					 +" select e.*,mgr.empname,mgr.empid,d.deptname,p.posname"
					 +" from employee e"
			         +" left join department d"
			         +" on e.deptno=d.deptno"
			         +" join position p"
			         +" on e.posid=p.posid"
			         +" left join employee mgr"
			         +" on e.mgrid=mgr.empid"
			         +" where 1=1"
					);
			
			//判断是否增加查询条件
			if(empid2!=null && !("".equals(empid2))){
				sql.append(" and e.empid like '%"+empid2+"%'");
			}
			if(deptno2>0 ){
				sql.append(" and e.deptno = "+deptno2);
			}
			if(posid2>0 ){
				sql.append(" and e.posid = "+posid2);
			}
			if(onduty2>=0 ){
				sql.append(" and e.onduty = "+onduty2);
			}
			if(hireDate2!=null && !("".equals(hireDate2))){
				//sql.append(" and e.hiredate =to_date('"+hireDate2+"','yyyy/mm/dd')");
				sql.append(" and to_char(e.hiredate,'yyyy-mm-dd') >= '"+hireDate2+"'");
			}
			if(empName2!=null && !("".equals(empName2))){
				sql.append(" and e.empName like '%"+empName2+"%'");
			}
			//3.创建SQL命令发送器
			pstmt = conn.prepareStatement(sql.toString());//注意要将sql转变成String字符串			
			//4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果			
			rs = pstmt.executeQuery();			
			//5.处理结果（封装到List中）
			while(rs.next()){
				//1.取出当前行各个字段的值
				String empid = rs.getString("empid");      //用户名
				String password = rs.getString("password");//密码
				String empName = rs.getString("empname");  //员工姓名
				int empAge = rs.getInt("empAge");          //年龄
				String empSex = rs.getString("empsex");    //性别
				String empEducation = rs.getString("empEducation");//学历
				String idcard = rs.getString("idcard");    //身份证号
				String nation = rs.getString("nation");    //民族
				String marry = rs.getString("marry");      //婚否
				String phone = rs.getString("phone"); 	   //手机
				String qq = rs.getString("qq"); 
				String address = rs.getString("address");  //家庭住址
				String email = rs.getString("email");      //邮箱
				int empType = rs.getInt("empType");		   //员工类型      规定：1.普通员工，   2.各级管理人员
				Date brithDate = rs.getDate("brithdate");  //出生日期
				Date hireDate = rs.getDate("hireDate");    //入职日期
				Date leaveDate = rs.getDate("leaveDate");  //离职日期
				String wagesnum = rs.getString("wagesnum");//银行卡号	
				int onDuty = rs.getInt("onduty");          //是否在职    1.  在职     0.离职
				String emerContactPerson = rs.getString("emerContactPerson");//紧急联系人信息
				String empDesc = rs.getString("empDesc");  //备注信息
				String sign = rs.getString("sign");        //个性签名
								
				String mgrName = rs.getString(27);//直接上级真实姓名
				String mgrEmpid = rs.getString(28);//直接上级id
				Employee mgr = new Employee();
				mgr.setEmpName(mgrName);
				mgr.setEmpid(mgrEmpid);
				
				String deptName = rs.getString("deptName");//所属部门
				int deptno = rs.getInt("deptno");          //员工部门编号
				Department dept = new Department();
				dept.setDeptName(deptName);
				dept.setDeptno(deptno);
				
				int posid = rs.getInt("posid");//员工岗位编号
				String posName = rs.getString("posname");
				Position pos = new Position();
				pos.setPosName(posName);
				pos.setPosid(posid);
				int empCount = rs.getInt("empCount");
				
				Employee emp = new Employee(empid, password, deptno, posid, mgrEmpid, empName, empAge, empSex, empEducation, idcard, nation, marry, phone, qq, address, email, empType, brithDate, hireDate, leaveDate, wagesnum, onDuty, emerContactPerson, empDesc, mgr, dept, pos);
				emp.setSign(sign);
				emp.setEmpcount(empCount);
				//将数据添加到集合中
				empList.add(emp);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		
		//7.返回数据		
		return empList;
	}


	/**
	 * 重置密码
	 */
	public int pwdReset(String empid) {
		String sql = " update employee set password='000000' where empid=?";		

		Object[] params = {empid};		
		return DBUtil.executeUpdate(sql, params);
	}


	/**
	 * 修改员工信息
	 */
	public int updateEmp(Employee emp) {
		
		String sql = "update employee set deptno=?,posid=?,mgrid=?,marry=?,address=?,"
				+ "empType=?,wagesnum=?,emerContactPerson=?,empDesc=?"
				+ "where empid=?";
		Object[] params = {
				emp.getDeptno(),
				emp.getPosid(),
				emp.getMgrid(),
				emp.getMarry(),
				emp.getAddress(),
				emp.getEmpType(),
				emp.getWagesnum(),
				emp.getEmerContactPerson(),
				emp.getEmpDesc(),
				emp.getEmpid()
				};
		return DBUtil.executeUpdate(sql, params);
	}


	/**
	 * 删除员工
	 */
	public int deleteEmp(String empid) {
		String sql = " update employee set onduty='0' where empid=?";		

		Object[] params = {empid};		
		return DBUtil.executeUpdate(sql, params);
	}


	/**
	 * 查看上级信息
	 */
	public List<Employee> findEmpByType(int empType) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 创建一个list集合
		List<Employee> mgrList = new ArrayList<Employee>();
		try {
			// 2.建立和数据库的连接（url，user、password）
			conn = DBUtil.getConnection();
			// 创建可变字符串 方便sql语句的拼接 默认是查询全部
			String sql = "select * from employee where emptype="+empType;
			int a = empType;
			// 3.创建SQL命令发送器
			pstmt = conn.prepareStatement(sql);
			// 4.使用SQL命令发送器发送SQL命令给数据库，并得到返回的结果
			rs = pstmt.executeQuery();
			// 5.处理结果
			while(rs.next()) {
				String empid = rs.getString("empid");
				String empName = rs.getString("empName");
				Employee emp = new Employee();
				emp.setEmpid(empid);
				emp.setEmpName(empName);
				
				mgrList.add(emp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6.关闭资源
			DBUtil.closeAll(rs, pstmt, conn);
		}
		// 7.返回数据
		return mgrList;
	}


	/**
	 * 修改密码
	 */
	public int updatePwd(String pwd, String empid) {
		
		String sql = " update employee set password=? where empid=?";		

		Object[] params = {pwd,empid};		
		return DBUtil.executeUpdate(sql, params);
	}


	/**
	 * 修改个人信息
	 */
	public int myInfoUpdate(Employee emp) {
		
		String sql = "UPDATE EMPLOYEE SET MARRY=?,PHONE=?,QQ=?,ADDRESS=?,"
				+ "EMAIL=?,EMERCONTACTPERSON=?,SIGN=? "
				+ "WHERE EMPID=?";
		Object[] params = {
				
				emp.getMarry(),
				emp.getPhone(),
				emp.getQq(),
				emp.getAddress(),
				emp.getEmail(),
				emp.getEmerContactPerson(),
				emp.getSign(),
				emp.getEmpid()
				};
		return DBUtil.executeUpdate(sql, params);
	}


	/**
	 * 记录登录次数
	 */
	public void updateEmpCoune(String empid, int empcount) {

		String sql = "UPDATE EMPLOYEE SET empcount=? WHERE EMPID=?";
				
		Object[] params = {empcount,empid};
		 DBUtil.executeUpdate(sql, params);
		
	}


}
