package com.bjsxt.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.bjsxt.entity.Bargain;
import com.bjsxt.entity.Customer;
import com.bjsxt.entity.Employee;
import com.bjsxt.service.BargainService;
import com.bjsxt.service.CustomerService;
import com.bjsxt.service.impl.BargainServiceImpl;
import com.bjsxt.service.impl.CustomerServiceImpl;


/**
 * 交易信息
 * @author ZhaoWeiguang
 *
 */
public class BargainServlet extends BaseServlet {

	/**
	 * 添加交易
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addBargain(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取视图层的表单数据
		String fouder = request.getParameter("fouder");
		int cusid = Integer.parseInt(request.getParameter("cusid"));
		String empid = request.getParameter("empid");
		int houseid = Integer.parseInt(request.getParameter("houseid"));
		double barprice = Double.parseDouble(request.getParameter("barprice"));
		String barDesc = request.getParameter("barDesc");
		
		String sfixturedate = request.getParameter("fixturedate");
		Date fixturedate = null;
		if(sfixturedate == null && "".equals(sfixturedate)){			
			//变换
//			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");			
//			try {
//				fixturedate = df.parse(sfixturedate);
//			} catch (ParseException e) {
//				e.printStackTrace();
//			}
			fixturedate = new Date();
			
		}
		
		
		//调用业务层进行添加操作
		BargainService bargainService = new BargainServiceImpl();
		Bargain bargain = new Bargain(cusid, empid, houseid, barprice, fixturedate, fouder, barDesc);
		int n = bargainService.addBargain(bargain);
		
		//跳转到/bargain/bargainList.jsp页面
		if(n > 0){
			//添加成功，跳转到/bargain/bargainList.jsp页面
			response.sendRedirect(request.getContextPath()+"/servlet/BargainServlet?method=findAllBargain");
		}else{
			//添加失败，返回添加页面
			request.setAttribute("error", "添加失败");
			request.getRequestDispatcher("/bargain/bargainAdd.jsp").forward(request, response);
		}
	}
	/**
	 * 查询所有交易
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findAllBargain(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//调用业务层查询所有交易信息
		BargainService bargainService = new BargainServiceImpl();
		List<Bargain> bargainList = bargainService.findByIdBargain(null,null,0);
		
		//跳转到/bargain/bargainList.jsp页面
		request.setAttribute("bargainList", bargainList);
		request.getRequestDispatcher("/bargain/bargainList.jsp").forward(request, response);
	}
	/**
	 * 按条件查询交易信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findByIdBargain(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//接受要查询的信息
		String query = request.getParameter("query");
		int queryType = Integer.parseInt(request.getParameter("queryType"));
		
		if(query !=null && !"".equals(query)){
			//如果queryType的值为7，进行转换
			if(queryType == 7){
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date squery = null;
				try {
					squery = df.parse(query);//公告时间
				} catch (ParseException e) {
					e.printStackTrace();
				}
				//调用业务层进行查询操作
				BargainService bargainService = new BargainServiceImpl();
				List<Bargain> bargainList = bargainService.findByIdBargain(query,squery,queryType);
				//跳转到
				request.setAttribute("query", query);
				request.setAttribute("queryType", queryType);
				request.setAttribute("bargainList", bargainList);
				request.getRequestDispatcher("/bargain/bargainList.jsp").forward(request, response);
			}
			
			//调用业务层进行查询操作
			BargainService bargainService = new BargainServiceImpl();
			List<Bargain> bargainList = bargainService.findByIdBargain(query,null,queryType);
			//跳转到
			request.setAttribute("query", query);
			request.setAttribute("queryType", queryType);
			request.setAttribute("bargainList", bargainList);
			request.getRequestDispatcher("/bargain/bargainList.jsp").forward(request, response);
			
		}
		
		
	}
	/**
	 * 查看交易详细信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findBarInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//接受要查看的交易编号
		String sbarid = request.getParameter("barid");
		int barid = 0;
		if(sbarid != null && !"".equals(sbarid)){
			try{
				barid = Integer.parseInt(sbarid);
			}catch(NumberFormatException e){
				e.printStackTrace();
			}
		}
		
		//调用业务层进行查询操作
		BargainService bargainService = new BargainServiceImpl();
		Bargain bargain = bargainService.findBarInfo(barid);
		
		//返回bargain/bargainShowInfo.jsp页面
		request.setAttribute("bargain", bargain);
		request.getRequestDispatcher("/bargain/bargainShowInfo.jsp").forward(request, response);
	}
	/**
	 * 删除指定编号的交易
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteBargain(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取要删除的交易编号
		String sbarid = request.getParameter("barid");
		int barid = 0;
		if(sbarid != null && !"".equals(sbarid)){
			try{
				barid = Integer.parseInt(sbarid);
			}catch(NumberFormatException e){
				e.printStackTrace();
			}
		}
		
		//调用业务层进行删除操作
		BargainService bargainService = new BargainServiceImpl();
		bargainService.deleteBargain(barid);
		
		///bargain/bargainList.jsp页面
		request.getRequestDispatcher("/servlet/BargainServlet?method=findAllBargain").forward(request, response);
		
	}
	/**
	 * 我的交易单
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void myFindByIdBargain(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//String empName = "qwer";
		//调用业务层查询所有交易信息
		BargainService bargainService = new BargainServiceImpl();
		//List<Bargain> barList = bargainService.findBargainByEmpid(empid);
		
		//跳转到/bargain/bargainList.jsp页面
		//request.setAttribute("barList", barList);
		request.getRequestDispatcher("").forward(request, response);
	}
	
	
	/**
	 * 查询我的交易单 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findBarByEmpid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接受登陆员工的编号
		Employee emp = (Employee)request.getSession().getAttribute("emp");
		String empid = emp.getEmpid();
		//接收视图层的数据
		String queryType = request.getParameter("queryType");//根据选择条件查询指定内容
		//按内容
		String content = request.getParameter("content");
		
		int barid = 0;   		 //订单编号	1
		String cusName = null;   	 //客户姓名	2		
		
		double area = 0;   			//房屋面积	3
		double totalPrice = 0;      //成交价格	4
	
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
		    	barid = Integer.parseInt(content);
		    	break;
		    case 2 :
		    	cusName = content; 	
		    	break;
		    case 3 :
		    	area = Double.parseDouble(content);
		    	break;
		    case 4 :
		    	totalPrice = Double.parseDouble(content);
		    	break;
		   
		    default :
		    	barid = 0;   		 //订单编号	1
				cusName = null;   	 //客户姓名	2						
				area = 0;   			//房屋面积	3
				totalPrice = 0;      //成交价格	4
		    	
		}
		//调用业务层完成操作
		BargainService bargainService = new BargainServiceImpl();
		List<Bargain> bargainList = bargainService.findBarByEmpid(barid,cusName,area,totalPrice,empid);
		
		
		//转发到查看客户信息页面
		request.setAttribute("queryType", query);
		request.setAttribute("content", content);
		
		request.setAttribute("barList", bargainList);
		request.getRequestDispatcher("/bargain/mybargain.jsp").forward(request, response);
	}
	
	/*
	 * ================================================================================
	 */
	/**
	 * 导出文档
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void exportXls(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		//接受要查询的信息
		String query = request.getParameter("query");
		int queryType = Integer.parseInt(request.getParameter("queryType"));
		
		//调用业务层进行查询操作
		BargainService bargainService = new BargainServiceImpl();
		List<Bargain> bargainList = bargainService.findByIdBargain(query,null,queryType);
		
		//返回outputStream
		createExcel(bargainList,response);
		
		
		
	}
	/**
	 * 导出文档
	 */
	private static void createExcel(List<Bargain> list,HttpServletResponse response) {
        // 创建一个Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建一个工作表
        HSSFSheet sheet = workbook.createSheet("尚学堂地产交易信息");
        
        CellRangeAddress region = new CellRangeAddress(0, // first row
                0, // last row
                0, // first column
                7 // last column
        );
        sheet.addMergedRegion(region);
        
        HSSFRow hssfRow = sheet.createRow(0);
        HSSFCell headCell = hssfRow.createCell(0);
        headCell.setCellValue("尚学堂地产交易表");
        
        // 设置单元格格式居中
        HSSFCellStyle cellStyle = workbook.createCellStyle();
    	cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        headCell.setCellStyle(cellStyle);
        
        
        // 添加表头行
        hssfRow = sheet.createRow(1);
        // 添加表头内容
        headCell = hssfRow.createCell(0);
        headCell.setCellValue("订单号");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(1);
        headCell.setCellValue("客户姓名");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(2);
        headCell.setCellValue("员工部门");
        headCell.setCellStyle(cellStyle);
        
        
        headCell = hssfRow.createCell(3);
        headCell.setCellValue("房屋类型");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(4);
        headCell.setCellValue("房屋面积");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(5);
        headCell.setCellValue("成交价格");
        headCell.setCellStyle(cellStyle);


        headCell = hssfRow.createCell(6);
        headCell.setCellValue("成交时间");
        headCell.setCellStyle(cellStyle);
        
        headCell = hssfRow.createCell(7);
        headCell.setCellValue("备注信息");
        headCell.setCellStyle(cellStyle);

        // 添加数据内容
        for (int i = 0; i < list.size(); i++) {
            hssfRow = sheet.createRow((int) i + 2);
            Bargain bargain = list.get(i);

            // 创建单元格，并设置值
            HSSFCell cell = hssfRow.createCell(0);
            cell.setCellValue(bargain.getBarid());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(1);
            cell.setCellValue(bargain.getCus().getCusName());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(2);
            cell.setCellValue(bargain.getEmp().getEmpName());
            cell.setCellStyle(cellStyle);
            
            
            cell = hssfRow.createCell(3);
            cell.setCellValue(bargain.getHou().getType().getTypeName());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(4);
            cell.setCellValue(bargain.getHou().getArea());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(5);
            cell.setCellValue(bargain.getBarprice());
            cell.setCellStyle(cellStyle);
            
            cell = hssfRow.createCell(6);
            cell.setCellValue(bargain.getFixturedate());
            cell.setCellStyle(cellStyle);
            
            cell = hssfRow.createCell(7);
            cell.setCellValue(bargain.getBarDesc());
            cell.setCellStyle(cellStyle);
        }

        // 保存Excel文件
        try {
        	response.setContentType("application/vnd.ms-excel");
        	response.setHeader("Content-disposition", "attachment;filename=sxtdc.xls");//附件形式下载，文件名叫duty.xls
        	//OutputStream outputStream = new FileOutputStream("D:/duty.xls");//保存到本地（服务器端）
        	OutputStream outputStream = response.getOutputStream();	 //写到客户端       	
            workbook.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
