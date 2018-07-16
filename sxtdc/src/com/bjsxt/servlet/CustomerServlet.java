package com.bjsxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjsxt.entity.Area;
import com.bjsxt.entity.Customer;
import com.bjsxt.entity.CustomerSource;
import com.bjsxt.entity.CustomerStatus;
import com.bjsxt.entity.CustomerType;
import com.bjsxt.entity.Department;
import com.bjsxt.entity.Employee;
import com.bjsxt.entity.Position;
import com.bjsxt.service.CustomerService;
import com.bjsxt.service.CustomerSourceService;
import com.bjsxt.service.CustomerStatusService;
import com.bjsxt.service.CustomerTypeService;
import com.bjsxt.service.DepartmentService;
import com.bjsxt.service.EmployeeService;
import com.bjsxt.service.PositionService;
import com.bjsxt.service.impl.CustomerServiceImpl;
import com.bjsxt.service.impl.CustomerSourceServiceImpl;
import com.bjsxt.service.impl.CustomerStatusServiceImpl;
import com.bjsxt.service.impl.CustomerTypeServiceImpl;
import com.bjsxt.service.impl.DepartmentServiceImpl;
import com.bjsxt.service.impl.EmployeeServiceImpl;
import com.bjsxt.service.impl.PositionServiceImpl;
import com.google.gson.Gson;
/**
 * 客户
 * @author ZhaoWeiguang
 *
 */
public class CustomerServlet extends BaseServlet {

	
	/**
	 * 添加客户之前的操作
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void toAddCus(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取所有的客户类型信息
		CustomerTypeService typeService = new CustomerTypeServiceImpl();
		List<CustomerType> typeList = typeService.findAllCustomerType();
		//显示所有客户来源信息
		CustomerSourceService sourceService = new CustomerSourceServiceImpl();
		List<CustomerSource> souList = sourceService.findAllSource();
		//获取所有客户状态信息
		CustomerStatusService statusService = new CustomerStatusServiceImpl();
		List<CustomerStatus> staList = statusService.findAllStatus();
		
		//转发到添加员工信息页面
		request.setAttribute("typeList", typeList);
		request.setAttribute("souList", souList);
		request.setAttribute("staList", staList);
		request.getRequestDispatcher("/customer/customerAdd.jsp").forward(request, response);
		
	}

	
	/**
	 * 添加客户信息
	 */
	public void addCus(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//得到当前用户的姓名
		Employee emp = (Employee)request.getSession().getAttribute("emp");
		String fouder = emp.getEmpName();
		
		
		//从视图层接收数据
		String cusName = request.getParameter("cusName");   //客户姓名cusCompany
		String cusSex = request.getParameter("cusSex");     //客户性别
		int staid = Integer.parseInt(request.getParameter("staid"));  //客户状态
		int typeid = Integer.parseInt(request.getParameter("typeid"));//客户类型
		int souid = Integer.parseInt(request.getParameter("souid"));  //客户来源
		String cusCompany = request.getParameter("cusCompany");       //客户公司
		String cusJob = request.getParameter("cusJob");      //客户公司
		String sbirthday = request.getParameter("birthday"); //出生日期
		//转换
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday = null;
		try {
			birthday = df.parse(sbirthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
				
		String cusPhone = request.getParameter("cusPhone");    //客户手机
		String cusPlane = request.getParameter("cusPlane");    //客户座机
		String cusQQ = request.getParameter("cusQQ");          //客户QQ	
		String email = request.getParameter("email");          //客户邮箱
		String remark = request.getParameter("remark");        //客户备注
		Date addTime = new Date();  //创建时间为当前时间
		int allot = 0;  //新创建客户默认未分配
						
		//province 省/直辖市    city 市   county 区县
		int province2 = Integer.parseInt(request.getParameter("province"));  //省  这只是获得对应编号 
		int city2 = Integer.parseInt(request.getParameter("city"));          //市  这只是获得对应编号 
		int county2 = Integer.parseInt(request.getParameter("county"));      //县  这只是获得对应编号
		
		//根据  省  市  县 的编号 获得对应的名称
		CustomerService cusService = new CustomerServiceImpl();
		String province = cusService.findAreaName(province2);   //省
		String city = cusService.findAreaName(city2);			//市
		String county = cusService.findAreaName(county2);		//县/区
		
		
		String address = request.getParameter("cusAddress"); //客户详细地址
		

		String cusAddress = ""+province+"/"+city+"/"+county+"/"+address;
		
		Customer cus = new Customer(typeid, staid, souid, cusName, cusSex, birthday, cusCompany, cusJob, cusAddress, cusPhone, cusPlane, cusQQ, email, fouder, addTime, remark,allot,province);
		
		//调用业务层完成添加操作
		
		int n = cusService.addCus(cus);
		
		//根据结果跳转到不同的页面
		if(n>0){
			//添加成功重定向
			
			response.sendRedirect(request.getContextPath()+"/servlet/CustomerServlet?method=findCusByXXX");
		}else{
			//失败转发添加员工页面
			request.setAttribute("error", "添加客户失败");
			request.getRequestDispatcher("/customer/customerAdd.jsp").forward(request, response);
		}
		
	}

	/**
	 * 查询客户功能
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findCusByXXX(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收视图层的数据
		String queryType = request.getParameter("queryType");//根据选择条件查询指定内容
		//按部门查询
		String content = request.getParameter("content");
		
		String cusName = null;    //客户姓名	1
		String staName = null;    //客户状态	2		
		String souName = null;      //客户来源	3
		String typeName = null;     //客户类型	4
		String empid = null;      //所属员工	5
		String cusCompany = null; //客户公司	6
		int allot = -1;
		int query = 0;
		if(queryType != null && !"".equals(queryType)){			
			try{
				query = Integer.parseInt(queryType); 
			}catch(NumberFormatException e){
				e.printStackTrace();
			}				
		}
		switch(query){
		    case 1 :
		    	cusName = content;
		    	break;
		    case 2 :
		    	staName = content; 	
		    	break;
		    case 3 :
		    	souName = content;
		    	break;
		    case 4 :
		    	typeName = content;
		    	break;
		    case 5 :
		    	empid = content;
		    	break;
		    case 6 :
		    	cusCompany = content;
		    	break;
		    default :
		    	 cusName = null;    //客户姓名	1
				 staName = null;    //客户状态	2		
				 souName = null;      //客户来源	3
				 typeName = null;     //客户类型	4
				 empid = null;      //所属员工	5
				 cusCompany = null; //客户公司	6
		    	
		}
		//调用业务层完成操作
		CustomerService cusService = new CustomerServiceImpl();	
		
		List<Customer> cusList = cusService.findCusByXXX(cusName,staName,souName,typeName,empid,cusCompany,allot);		
		
		
		//转发到查看客户信息页面
		request.setAttribute("queryType", query);
		request.setAttribute("content", content);
		
		request.setAttribute("cusList", cusList);
		request.getRequestDispatcher("/customer/customerList.jsp").forward(request, response);
	}
	
	/**
	 * 查看客户详细信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findCusInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收视图层的数据
		int cusid = Integer.parseInt(request.getParameter("cusid"));
		//调用业务层完成操作
		CustomerService cusService = new CustomerServiceImpl();	
		Customer cus = cusService.findCusById(cusid);
		if(cus!=null){
			request.setAttribute("cus", cus);
			request.getRequestDispatcher("/customer/customerShowInfo.jsp").forward(request, response);
		}else{
			//失败转发添加员工页面
			request.setAttribute("error", "没有查到你要的信息");
			request.getRequestDispatcher("/customer/customerList.jsp").forward(request, response);
		}
	}
	/**
	 * =======================================================================
	 * 关于员工的其他相关操作
	 */
	/**
	 * 查询客户功能
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findCusByName(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
		//接受视图层的数据
		String cusName = request.getParameter("cusName");
		
		//调用业务层进行查询
		CustomerService cusService = new CustomerServiceImpl();	
		List<Customer> cusList = cusService.findCusByName(cusName);
		
		//转发到添加客户信息页面
		request.setAttribute("cusList", cusList);
		request.setAttribute("cusName", cusName);
		request.getRequestDispatcher("/bargain/customerInfo.jsp").forward(request, response);
	}
	
	/**
	 * 删除客户信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteCus(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//解决中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		//接收视图层传来的数据
		int cusid = Integer.parseInt(request.getParameter("cusid"));
		//调用业务层完成显示员工信息操作
		CustomerService cusService = new CustomerServiceImpl();
		int n = cusService.deleteCus(cusid);		
		//返回数据
		if (n > 0) {
			String data = "客户信息删除成功";
			response.getWriter().println(data);
		}
	}

	/**
	 * 修改员工之前的操作
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void toUpdateCus(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接受视图层数据
		int cusid = Integer.parseInt(request.getParameter("cusid")); 
		
		//调用业务层完成相关操作
		//获取客户信息
		CustomerService cusService = new CustomerServiceImpl();	
		Customer cus = cusService.findCusById(cusid);
		//获取所有的客户类型信息
		CustomerTypeService typeService = new CustomerTypeServiceImpl();
		List<CustomerType> typeList = typeService.findAllCustomerType();
		//显示所有客户来源信息
		CustomerSourceService sourceService = new CustomerSourceServiceImpl();
		List<CustomerSource> souList = sourceService.findAllSource();
		//获取所有客户状态信息
		CustomerStatusService statusService = new CustomerStatusServiceImpl();
		List<CustomerStatus> staList = statusService.findAllStatus();
		
		//转发到添加员工信息页面
		request.setAttribute("cus", cus);
		request.setAttribute("typeList", typeList);
		request.setAttribute("souList", souList);
		request.setAttribute("staList", staList);
		request.getRequestDispatcher("/customer/customerUpdate.jsp").forward(request, response);
		
	}
	
	/**
	 * 修改客户信息
	 */
	public void updateCus(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//得到当前用户的姓名
		Employee emp = (Employee)request.getSession().getAttribute("emp");
		String changeMan = emp.getEmpName();
				
		//从视图层接收数据
		String cusName = request.getParameter("cusName");   //客户姓名cusCompany
		int cusid = Integer.parseInt(request.getParameter("cusid")); 
		int staid = Integer.parseInt(request.getParameter("staid"));  //客户状态
		int typeid = Integer.parseInt(request.getParameter("typeid"));//客户类型
		int souid = Integer.parseInt(request.getParameter("souid"));  //客户来源
		String cusCompany = request.getParameter("cusCompany");       //客户公司
		String cusJob = request.getParameter("cusJob");      //客户岗位
		
		
		String cusAddress = request.getParameter("cusAddress");//客户住址
		String cusPhone = request.getParameter("cusPhone");    //客户手机
		String cusPlane = request.getParameter("cusPlane");    //客户座机
		String cusQQ = request.getParameter("cusQQ");          //客户QQ	
		String email = request.getParameter("email");          //客户邮箱
		String remark = request.getParameter("remark");        //客户备注
		Date updateTime = new Date();  //修改时间  当前时间
				
		Customer cus = new Customer(cusid,typeid, staid, souid, cusName,  cusCompany, cusJob, cusAddress, cusPhone, cusPlane, cusQQ, email, remark,changeMan,updateTime);
		
		//调用业务层完成添加操作
		CustomerService cusService = new CustomerServiceImpl();
		int n = cusService.updateCus(cus);
		
		//根据结果跳转到不同的页面
		if(n>0){
			//添加成功重定向
			
			response.sendRedirect(request.getContextPath()+"/servlet/CustomerServlet?method=findCusByXXX");
		}else{
			//失败转发添加员工页面
			request.setAttribute("error", "修改客户失败");
			request.getRequestDispatcher("/customer/customerUpdate.jsp").forward(request, response);
		}
		
	}
	
	/**
	 * 客户分配之前的操作
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void toAllotCus(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接受视图层数据
		int cusid = Integer.parseInt(request.getParameter("cusid")); 
		
		//调用业务层完成相关操作
		//获取客户信息
		CustomerService cusService = new CustomerServiceImpl();	
		Customer cus = cusService.findCusById(cusid);
		
		//判断当前客户是否被分配
		String allot = "";
		int empAllot = cus.getAllot();
		if(empAllot == 0){
			allot = "当前客户未分配";
		}else{
			allot = "当前客户所属员工是:";
		}
		//转发到添加员工信息页面
		request.setAttribute("cus", cus);
		
		request.setAttribute("empAllot", allot);
		request.getRequestDispatcher("/customer/customerAllot.jsp").forward(request, response);
		
	}
	/**
	 * 客户分配操作
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void allotCus(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接受视图层数据
		int cusid = Integer.parseInt(request.getParameter("cusid")); 
		String empid = request.getParameter("empid");
		//调用业务层完成相关操作
		//获取客户信息
		CustomerService cusService = new CustomerServiceImpl();	
		int n = cusService.allotCus(cusid,empid);
		
		//根据结果跳转到不同的页面
		if(n>0){
			//添加成功重定向
			
			response.sendRedirect(request.getContextPath()+"/servlet/CustomerServlet?method=findCusByXXX");
		}else{
			//失败转发添加员工页面
			request.setAttribute("error", "客户分配失败");
			request.getRequestDispatcher("/customer/customerAllot.jsp").forward(request, response);
		}
	
	}
	
	/**
	 * 查询我的客户功能
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findCusByEmpid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Employee emp = (Employee)request.getSession().getAttribute("emp");
		String empid = emp.getEmpid();
		     //所属员工	5
		//接收视图层的数据
		String queryType = request.getParameter("queryType");//根据选择条件查询指定内容
		//按部门查询
		String content = request.getParameter("content");
		
		String cusName = null;    //客户姓名	1
		String staName = null;    //客户状态	2		
		String souName = null;      //客户来源	3
		String typeName = null;     //客户类型	4
		
		String cusCompany = null; //客户公司	6
		int allot = -1;
		int query = 0;
		if(queryType != null && !"".equals(queryType)){			
			try{
				query = Integer.parseInt(queryType); 
			}catch(NumberFormatException e){
				e.printStackTrace();
			}				
		}
		switch(query){
		    case 1 :
		    	cusName = content;
		    	break;
		    case 2 :
		    	staName = content; 	
		    	break;
		    case 3 :
		    	souName = content;
		    	break;
		    case 4 :
		    	typeName = content;
		    	break;
		   
		    case 6 :
		    	cusCompany = content;
		    	break;
		    default :
		    	 cusName = null;    //客户姓名	1
				 staName = null;    //客户状态	2		
				 souName = null;    //客户来源	3
				 typeName = null;   //客户类型	4				
				 cusCompany = null; //客户公司	6
		    	
		}
		//调用业务层完成操作
		CustomerService cusService = new CustomerServiceImpl();	
		
		List<Customer> cusList = cusService.findCusByXXX(cusName,staName,souName,typeName,empid,cusCompany,allot);		
		
		
		//转发到查看客户信息页面
		request.setAttribute("queryType", query);
		request.setAttribute("content", content);
		
		request.setAttribute("cusList", cusList);
		request.getRequestDispatcher("/customer/MyCustomerList.jsp").forward(request, response);
	}
	/**
	 * 查询公共客户信息  未分配客户
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findCusByAllot(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//接收视图层的数据
		String queryType = request.getParameter("queryType");//根据选择条件查询指定内容
		//按部门查询
		String content = request.getParameter("content");
		
		String cusName = null;    //客户姓名	1
		String staName = null;    //客户状态	2		
		String souName = null;      //客户来源	3
		String typeName = null;     //客户类型	4
		
		String cusCompany = null; //客户公司	6
		int allot = 0;   //0  代表未分配客户  1 代表分配客户
		int query = 0;
		if(queryType != null && !"".equals(queryType)){			
			try{
				query = Integer.parseInt(queryType); 
			}catch(NumberFormatException e){
				e.printStackTrace();
			}				
		}
		switch(query){
		    case 1 :
		    	cusName = content;
		    	break;
		    case 2 :
		    	staName = content; 	
		    	break;
		    case 3 :
		    	souName = content;
		    	break;
		    case 4 :
		    	typeName = content;
		    	break;
		   
		    case 6 :
		    	cusCompany = content;
		    	break;
		    default :
		    	 cusName = null;    //客户姓名	1
				 staName = null;    //客户状态	2		
				 souName = null;      //客户来源	3
				 typeName = null;     //客户类型	4
				
				 cusCompany = null; //客户公司	6
		    	
		}
		//调用业务层完成操作
		CustomerService cusService = new CustomerServiceImpl();	
		
		List<Customer> cusList = cusService.findCusByXXX(cusName,staName,souName,typeName,null,cusCompany,allot);		
		
		
		//转发到查看客户信息页面
		request.setAttribute("queryType", query);
		request.setAttribute("content", content);
		
		request.setAttribute("cusList", cusList);
		request.getRequestDispatcher("/customer/customerPublicList.jsp").forward(request, response);
	}
	
	/**
	 * 通过ajax实现客户分配员工姓名的自动获取
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void showEmpName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//解决中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		
		//得到视图层的员工id
		String empid = request.getParameter("empid");
		//调用业务层完成相关操作
		EmployeeService empService = new EmployeeServiceImpl();
		Employee emp = empService.findEmpById(empid);
		String empName = "";
		if(emp != null){
			empName = emp.getEmpName();
		}else{
			empName = "您输入的员工编号有误";
		}
		
		response.getWriter().println(empName);
	}
	
	

	
	/**
	 * 通过ajax实现获得局部刷新的地图信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getAreaInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//接收信息parentID
		String sParentID = request.getParameter("parentID");
		int parentID = Integer.parseInt(sParentID);
		//调用业务层完成操作
		CustomerService cusService = new CustomerServiceImpl();	
		List<Area> areaList = cusService.getAreaInfo(parentID);
		
		Gson gson = new Gson();
		
		out.println(gson.toJson(areaList));
	}
	
	/**
	 * 通过ajax实现获得局部刷新的地图信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getAreaData(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       
		//解决中文乱码问题
		response.setContentType("text/html;charset=utf-8");
//		String a = "北京";
//		StringBuilder jsonStr = new StringBuilder("[");
//		jsonStr.append("{\"value\":"+300+",\"name\":\""+a+"\"");
		
		//调用业务层完成操作
		CustomerService cusService = new CustomerServiceImpl();
		String data = cusService.getAreaData();

		//返回JsonStr		
		response.getWriter().println(data);
				
	}
	
	
	
	
}
