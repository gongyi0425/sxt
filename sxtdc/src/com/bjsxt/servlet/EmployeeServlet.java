package com.bjsxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bjsxt.entity.Department;
import com.bjsxt.entity.Employee;
import com.bjsxt.entity.Log;
import com.bjsxt.entity.Position;
import com.bjsxt.service.DepartmentService;
import com.bjsxt.service.EmployeeService;
import com.bjsxt.service.PositionService;
import com.bjsxt.service.impl.DepartmentServiceImpl;
import com.bjsxt.service.impl.EmployeeServiceImpl;
import com.bjsxt.service.impl.PositionServiceImpl;
/**
 * 员工相关
 * @author ZhaoWeiguang
 *
 */
public class EmployeeServlet extends BaseServlet {

	/**
	 * 登录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收登录页面传来的数据
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		String online = request.getParameter("online");
		
		String verifyCode = request.getParameter("yzm");//获取验证码
		String randStr = (String)request.getSession().getAttribute("randStr");//正确的验证码
		if(verifyCode ==null || !verifyCode.equals(randStr)){
			request.setAttribute("verifyCode", "验证码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;//结束执行，后面代码不会执行。
		}
		//调用业务层完成显示员工信息操作
		EmployeeService empService = new EmployeeServiceImpl();
		Employee emp = empService.login(user,pwd);
		//返回数据
		if (emp != null) {
			//登录成功后才记住密码
			Cookie cookie1 = new Cookie("user",user);
			Cookie cookie2 = new Cookie("pwd",pwd);
			if("yes".equals(online)){   			
   				//2.指定记住密码时间
   				cookie1.setMaxAge(60*60*24*10);
   				cookie2.setMaxAge(60*60*24*10);   				  				
   			}else{   			
   				//2.指定记住密码的周期
   				cookie1.setMaxAge(0);
   				cookie2.setMaxAge(0);
   			}   
			cookie1.setPath("/sxtdc/");
			cookie2.setPath("/sxtdc/");
			response.addCookie(cookie1);
			response.addCookie(cookie2);
			request.getSession().setAttribute("user", user);
			
			//==============将计数器进行加一操作==========================
			//获取servletcontext作用域
			ServletContext sc = getServletContext();
			//获取count值
			int count = (Integer) sc.getAttribute("count");
			//计数器加一
			++count;
			//将count值存储到servletcontext作用域中
			sc.setAttribute("count", count);
			
		//========给Log对象赋值,获取logid,empid,cip,startTime=====================
			//获取session对象
			HttpSession hs = request.getSession();
			//获取Log对象--日志对象
		    Log log = new Log();
		     
			
			//给logid赋值---日志id---把日志id和计数器绑定在一起
			log.setLogid(count);
			//获取empid---用户id
			String empid = emp.getEmpid();
			//给empid赋值
			log.setEmpid(empid);
			//获取cip---用户ip
			String cip = request.getRemoteAddr();
			//给cip赋值
			log.setCip(cip);
			//获取starttime----登录时间
			Date stime = new Date();
			//给starttime赋值			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String startTime = null;
			startTime = df.format(stime);
			log.setStarttime(startTime);
			//将Log对象存储到session作用域中
			hs.setAttribute("Log", log);
			//测试代码
			//System.out.println("EmployeeServlet.login():测试log");
			log.toString();
			//=================================================  
			int empcount = emp.getEmpcount();
			++empcount;
			emp.setEmpcount(empcount);
			
			empService.updateEmpCoune(user,empcount);
			
			//将数据保存在Session中
			request.getSession().setAttribute("emp", emp);
			response.sendRedirect(request.getContextPath()+"/");
		} else {
			request.setAttribute("error", "用户名或者密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);

		}
	}
	/**
	 * 退出登录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void outLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//结束当前的session
		request.getSession().invalidate();
				
		//跳转到登录页面:注销之后建议使用重定向跳转到登录页面
		response.sendRedirect(request.getContextPath()+"/login.jsp");
		
	}

	/**
	 * 在进去添加员工页面之前进行的操作
	 * 获得下拉信息选项的动态信息
	 * 然后跳转到添加页面
	 * 显示下拉选项信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void toAddEmp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//获取所有的部门信息
		DepartmentService deptService = new DepartmentServiceImpl();
		List<Department> deptList = deptService.findAllDept();
		//显示所有岗位信息
		PositionService posService = new PositionServiceImpl();
		List<Position> posList = posService.findAllPos();
		//获取上级员工信息
		EmployeeService empService = new EmployeeServiceImpl();
		List<Employee> mgrList = empService.findEmpByType(2);//1.代表基层员工，2.代表各级管理人员
		
		//转发到添加员工信息页面
		request.setAttribute("deptList", deptList);
		request.setAttribute("posList", posList);
		request.setAttribute("mgrList", mgrList);
		request.getRequestDispatcher("/system/empAdd.jsp").forward(request, response);
	}
	/**
	 * 添加员工功能
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addEmp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收视图层的表单数据
		String empid = request.getParameter("empid");           //用户名
		String password = "000000";	                            //新创建密码000000
		String empName = request.getParameter("empName");       //员工姓名
		String sex = request.getParameter("sex");               //性别
		int age = Integer.parseInt(request.getParameter("age"));//年龄
		String nation = request.getParameter("nation");         //民族
		int empType = Integer.parseInt(request.getParameter("empType"));//员工等级
		String phone = request.getParameter("phone");           //手机
		String qq = request.getParameter("qq");                 //qq
		String email = request.getParameter("email");           //邮箱
		String address = request.getParameter("address");       //家庭住址
		String wagesnum = request.getParameter("wagesnum");     //银行卡号
		String idcard = request.getParameter("idcard");         //身份证号
		String emerContactPerson = request.getParameter("emerContactPerson");//紧急联系人信息
		String empDesc = request.getParameter("empDesc");					 //备注信息
		String empEducation = request.getParameter("empeducation");   //学历
		String marry= request.getParameter("marry");                  //婚姻
		int onDuty = 1;   //默认在职
		int deptno = Integer.parseInt(request.getParameter("deptno"));//部门		
		int posid = Integer.parseInt(request.getParameter("posid"));  //岗位
		String mgrid = request.getParameter("mgrid");                 //上级
		
		
				
		//获得日期
		String sbirthDate = request.getParameter("brithDate");   //出生日期
		String shireDate = request.getParameter("hireDate");	 //入职时间	
		//转换
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate = null;
		try {
			birthDate = df.parse(sbirthDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date hireDate = null;
		try {
			hireDate = df.parse(shireDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String sign = "这家伙很懒，什么也没留下。";//默认个性签名
		//调用业务层完成添加操作		
		Employee emp = new Employee(empid, password, deptno, posid, mgrid, empName, age, sex, empEducation, idcard, nation, marry, phone, qq, address, email, empType, birthDate, hireDate, null, wagesnum, onDuty, emerContactPerson, empDesc);
		emp.setSign(sign);
		EmployeeService empService = new EmployeeServiceImpl();
		int n = empService.addEmp(emp);
		
		//根据结果跳转到不同的页面
		if(n>0){
			//添加成功重定向
			response.sendRedirect(request.getContextPath()+"/servlet/EmployeeServlet?method=findEmpByXXX");
		}else{
			//失败转发添加员工页面
			request.setAttribute("error", "添加员工失败");
			request.getRequestDispatcher("/system/empAdd.jsp").forward(request, response);
		}
	}
	/**
	 * 查询员工功能
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findEmpByXXX(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收视图层的数据
		String empid = request.getParameter("empid");//按用户名查询
		//按部门查询
		String sdeptno = request.getParameter("deptno");
		int deptno = -1;
		if(sdeptno!=null && !"".equals(sdeptno)){			
			try{
				deptno = Integer.parseInt(sdeptno); 
			}catch(NumberFormatException e){
				e.printStackTrace();
			}		
		}
		
		//按岗位查询
		String sposid = request.getParameter("posid");
		int posid = -1;
		if(sposid!=null && !"".equals(sposid)){			
			try{
				posid = Integer.parseInt(sposid); 
			}catch(NumberFormatException e){
				e.printStackTrace();
			}		
		}
		
		//是否在职
		String sonduty = request.getParameter("onDuty");
		int onDuty = 1;
		if(sonduty!=null&&!"".equals(sonduty)){
			try{
				onDuty = Integer.parseInt(sonduty); 
			}catch(NumberFormatException e){
					e.printStackTrace();
			}	
		}
			
		/**
		 * 按入职时间
		 * 思路：先得到的是字符串
		 * 转换成时间格式
		 * 再转换成指定格式的字符串
		 */
		String shireDate=request.getParameter("hireDate");		
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dhireDate=null;
		String hireDate=null;
		if(shireDate!=null&&!"".equals(shireDate)){			
			try {
				dhireDate = sdf.parse(shireDate);
			} catch (ParseException e) {				
				e.printStackTrace();
			}
			
			if(shireDate !=null){
				hireDate = sdf.format(dhireDate); 
			}
		}		
		//调用业务层完成操作
		EmployeeService empService = new EmployeeServiceImpl();	
		
		List<Employee> empList = empService.findEmpByXXX(empid,deptno,posid,onDuty,hireDate);		
		//获取所有的部门信息
		DepartmentService deptService = new DepartmentServiceImpl();
		List<Department> deptList = deptService.findAllDept();
		//显示所有岗位信息
		PositionService posService = new PositionServiceImpl();
		List<Position> posList = posService.findAllPos();
		//转发到添加员工信息页面
		request.setAttribute("empList", empList);
		request.setAttribute("deptList", deptList);
		request.setAttribute("posList", posList);
		//记住查询条件
		request.setAttribute("empid", empid);
		request.setAttribute("deptno", sdeptno);
		request.setAttribute("posid", sposid);
		request.setAttribute("onDuty", sonduty);
		request.setAttribute("hireDate", shireDate);
		request.getRequestDispatcher("/system/empList.jsp").forward(request, response);
	}
	
	
	/**
	 * 查看员工详细信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findEmpInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收视图层的数据
		String empid = request.getParameter("empid");
		if(empid == null || "".equals(empid)){
			Employee emp2 = (Employee)request.getSession().getAttribute("emp");
			empid = emp2.getEmpid();
			
		}
		//调用业务层完成操作
		EmployeeService empService = new EmployeeServiceImpl();	
		Employee emp = empService.findEmpById(empid);
		if(emp!=null){
			request.setAttribute("emp", emp);
			request.getRequestDispatcher("/system/empShowInfo.jsp").forward(request, response);
		}else{
			//失败转发添加员工页面
			request.setAttribute("error", "没有查到你要的信息");
			request.getRequestDispatcher("/system/empList.jsp").forward(request, response);
		}
		
		
	}
	/**
	 * 修改员工之前的操作
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void toUpdateEmp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收视图层传来的数据
		String empid = request.getParameter("empid");
		//调用业务层完成显示员工信息操作
		EmployeeService empService = new EmployeeServiceImpl();
		Employee emp = empService.findEmpById(empid);
		
		//获取所有的部门信息
		DepartmentService deptService = new DepartmentServiceImpl();
		List<Department> deptList = deptService.findAllDept();
		//显示所有岗位信息
		PositionService posService = new PositionServiceImpl();
		List<Position> posList = posService.findAllPos();
		//获取上级员工信息		
		List<Employee> mgrList = empService.findEmpByType(2);//1.代表基层员工，2.代表各级管理人员
		
		//转发到添加员工信息页面
		request.setAttribute("deptList", deptList);
		request.setAttribute("posList", posList);
		request.setAttribute("mgrList", mgrList);
		request.setAttribute("emp", emp);
		request.getRequestDispatcher("/system/empUpdate.jsp").forward(request, response);
	}
	
	/**
	 * 修改员工信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateEmp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收视图层的表单数据
		String empid = request.getParameter("empid");           //用户名
		int empType = Integer.parseInt(request.getParameter("empType"));//员工等级
		int deptno = Integer.parseInt(request.getParameter("deptno"));//部门		
		int posid = Integer.parseInt(request.getParameter("posid"));  //岗位
		String mgrid = request.getParameter("mgrid");                 //上级
		String marry= request.getParameter("marry");                  //婚姻		
		String address = request.getParameter("address");                    //家庭住址
		String wagesnum = request.getParameter("wagesnum");   //银行卡号
		String emerContactPerson = request.getParameter("emerContactPerson");//紧急联系人信息
		String empDesc = request.getParameter("empDesc");					 //备注信息
		
		
		Employee emp = new Employee(empid, deptno, posid, mgrid, marry, address, empType, wagesnum, emerContactPerson, empDesc);
		
		//调用业务层完成修改操作
		EmployeeService empService = new EmployeeServiceImpl();
		int n = empService.updateEmp(emp);
		//根据结果跳转到不同的页面
		if(n>0){
			//添加成功重定向
			response.sendRedirect(request.getContextPath()+"/servlet/EmployeeServlet?method=findEmpByXXX");
		}else{
			//失败转发添加员工页面
			request.setAttribute("error", "修改员工失败");
			request.getRequestDispatcher("/system/empUpdate.jsp").forward(request, response);
		}
	}
	
	/**
	 * 重置密码
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void pwdReset(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//解决中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		//接收视图层传来的数据
		String empid = request.getParameter("empid");
		//调用业务层完成显示员工信息操作
		EmployeeService empService = new EmployeeServiceImpl();
		int n = empService.pwdReset(empid);
		
		//返回数据
		if (n > 0) {
			String data = "密码重置成功";
			response.getWriter().println(data);
		}
	}
	
	/**
	 * 删除员工
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteEmp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//解决中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		//接收视图层传来的数据
		String empid = request.getParameter("empid");
		//调用业务层完成显示员工信息操作
		EmployeeService empService = new EmployeeServiceImpl();
		int n = empService.deleteEmp(empid);		
		//返回数据
		if (n > 0) {
			String data = "员工信息删除成功";
			response.getWriter().println(data);
		}
	}
	
	
	/**
	 * =======================================================================
	 * 关于员工的其他相关操作
	 */
	/**
	 * 查询员工功能
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findEmpByName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收视图层的数据
		String empName = request.getParameter("empName");//按用户名查询

		//调用业务层完成操作
		EmployeeService empService = new EmployeeServiceImpl();	
		
		List<Employee> empList = empService.findEmpByName(empName);		
		
		//转发到添加员工信息页面
		request.setAttribute("empList", empList);
		request.setAttribute("empName", empName);
		request.getRequestDispatcher("/bargain/empInfo.jsp").forward(request, response);
	}
	
	
	
	/**
	 * 个人平台相关操作=============================================================
	 */
	/**
	 * 修改员工信息之前的过度
	 * 将要修改员工信息，带着数据过去
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void toUpdateMyInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Employee emp2 = (Employee)request.getSession().getAttribute("emp");
		String empid = emp2.getEmpid();
		
		//调用业务层完成显示员工信息操作
		EmployeeService empService = new EmployeeServiceImpl();
		Employee emp = empService.findEmpById(empid);							
		//转发到updateMyInfo.jsp
		request.setAttribute("emp", emp);
		//request.setAttribute("posList", posList);
		request.getRequestDispatcher("/myself/updateMyInfo.jsp").forward(request, response);		
	}
	
	/**
	 * 修改员工个人信息之前的操作
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void toMyInfoUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Employee emp2 = (Employee)request.getSession().getAttribute("emp");
		String empid = emp2.getEmpid();
		//调用业务层完成显示员工信息操作
		EmployeeService empService = new EmployeeServiceImpl();
		Employee emp = empService.findEmpById(empid);
		
		//转发到添加员工信息页面	
		request.setAttribute("emp", emp);
		request.getRequestDispatcher("/myself/updateMyInfo.jsp").forward(request, response);
	}
	
	/**
	 * 修改员工个人信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void myInfoUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Employee emp2 = (Employee)request.getSession().getAttribute("emp");
		String empid = emp2.getEmpid();
		//接收视图层的表单数据		
		String phone = request.getParameter("phone");  //手机
		String qq = request.getParameter("qq");        //qq
		String email = request.getParameter("email");                 //邮箱
		String address = request.getParameter("address");             //家庭住址
		String marry= request.getParameter("marry");                  //婚姻
		String emerContactPerson = request.getParameter("emerContactPerson");//紧急联系人信息		
		String sign = request.getParameter("sign");      //个性签名			
			//调用业务层完成添加操作
		EmployeeService empService = new EmployeeServiceImpl();
		Employee emp = new Employee();
		emp.setEmpid(empid);
		emp.setPhone(phone);
		emp.setQq(qq);
		emp.setEmail(email);
		emp.setAddress(address);
		emp.setMarry(marry);
		emp.setEmerContactPerson(emerContactPerson);
		emp.setSign(sign);
		int n = empService.myInfoUpdate(emp);		
		//根据结果跳转到不同的页面
		if(n>0){
			//添加成功
			request.getRequestDispatcher("/servlet/EmployeeServlet?method=findEmpInfo").forward(request, response);
		}else{
			//失败转发添加员工页面
			request.setAttribute("error", "修个人信息失败");
			request.getRequestDispatcher("/#").forward(request, response);
		}
	}
	
	/**
	 * 修改密码
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updatePwd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//解决中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		//得到当前用户的id
		Employee emp2 = (Employee)request.getSession().getAttribute("emp");
		String empid = emp2.getEmpid();
		//接收视图层的表单数据
		String newPwd = request.getParameter("pwd");
		EmployeeService empService = new EmployeeServiceImpl();					
		int n = empService.updatePwd(newPwd,empid);	
	
		//根据结果跳转到不同的页面
		if(n>0){
			response.getWriter().println("密码修改成功，为确保信息安全，请重新登录！");

		}else{
			//失败转发添加员工页面
			request.setAttribute("error", "修改密码失败");
			request.getRequestDispatcher("/myself/myInfo.jsp").forward(request, response);
		}
	}

}
