package com.bjsxt.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.bjsxt.entity.House;
import com.bjsxt.entity.HouseImg;
import com.bjsxt.entity.HouseType;
import com.bjsxt.service.CustomerService;
import com.bjsxt.service.HouseService;
import com.bjsxt.service.HouseTypeService;
import com.bjsxt.service.impl.CustomerServiceImpl;
import com.bjsxt.service.impl.HouseServiceImpl;
import com.bjsxt.service.impl.HouseTypeServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 房屋信息
 * @author 潘培轩
 *
 */
public class HouseServlet extends BaseServlet { 


	

	
	public void toAddHouse(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//获取所有房屋类型信息
		HouseTypeService houseTypeService = new HouseTypeServiceImpl();
		List<HouseType> houseTypeList = houseTypeService.findAllHouseType();
		request.setAttribute("houseTypeList", houseTypeList);
		//跳转到houseAdd.jsp
		request.getRequestDispatcher("/house/houseAdd.jsp").forward(request, response);
	}
	
	
	/*
	 * 查询所有房屋信息
	 */
	public void findAllHouse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//调用业务层获取所有房屋信息
		HouseService houseService = new HouseServiceImpl();
		List<House> houseList = houseService.findAllHouse();
		//获取所有房屋类型信息
		HouseTypeService houseTypeService = new HouseTypeServiceImpl();
		List<HouseType> houseTypeList = houseTypeService.findAllHouseType();
		request.setAttribute("houseTypeList", houseTypeList);
		//跳转到houseList.jsp
		request.setAttribute("houseList", houseList);
		request.getRequestDispatcher("/house/houseList.jsp").forward(request, response);
	}
	
	
	/*
	 * 按条件查询房屋信息（查询所有是按条件查询的一种特殊形式）
	 */
	public void findHouse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//按地址查询
		String location = request.getParameter("location");//按用户名查询
		//按房屋类型查询
		int typeid = 0;
		String stypeid = request.getParameter("typeid");
		if(stypeid != null){
			try{
				typeid = Integer.parseInt(stypeid);
			}catch(NumberFormatException e){
				e.printStackTrace();
			}
		}
		//按房屋状态查询
		String housestate = request.getParameter("housestate");
		//调用业务层完成操作
		HouseService houseService = new HouseServiceImpl();
		List<House> houseList = houseService.findHouse(location,typeid,housestate);		
		//获取所有的房屋类型信息
		HouseTypeService houseTypeService = new HouseTypeServiceImpl();
		List<HouseType> houseTypeList = houseTypeService.findAllHouseType();
		request.setAttribute("houseTypeList", houseTypeList);
		//跳转到houseList.jsp
		request.setAttribute("location", location);
		request.setAttribute("typeid", typeid);
		request.setAttribute("housestate", housestate);
		request.setAttribute("houseList", houseList);
		request.getRequestDispatcher("/house/houseList.jsp").forward(request, response);
	}
	/**
	 * 查询房屋功能
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findHouseByName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接受视图层的数据
		String shouName = request.getParameter("houName");
		int houName = 0;
		if(shouName != null && !"".equals(shouName)){
			try{
				houName = Integer.parseInt(shouName);
			}catch(NumberFormatException e){
				e.printStackTrace();
			}
		}
		
		String typeName = request.getParameter("typeName");
		String sprice = request.getParameter("price");
		double price = 0;
		if(sprice != null && !"".equals(sprice)){
			try{
				price = Double.parseDouble(sprice);
			}catch(NumberFormatException e){
				e.printStackTrace();
			}
		}
		
		//调用业务层进行查询
		HouseTypeService houseTypeService = new HouseTypeServiceImpl();
		List<HouseType> houseTypeList = houseTypeService.findAllHouseType();
		HouseService houseService = new HouseServiceImpl();
		List<House> houList = houseService.findHouseName(houName,typeName,price);
		//转发到添加房屋信息页面
		request.setAttribute("houseTypeList", houseTypeList);
		request.setAttribute("houList", houList);
		request.setAttribute("houName", houName);
		request.getRequestDispatcher("/bargain/houseInfo.jsp").forward(request, response);
	}
	
	/*
	 * 删除房屋
	 */
	public void deleteHou(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//解决中文乱码问题
				response.setContentType("text/html;charset=utf-8");
		//调用视图层要删除的房屋编号
		int houseid = Integer.parseInt(request.getParameter("houseid"));
		//调用业务层完成删除操作
		HouseService houseService = new HouseServiceImpl();
		int n = houseService.deleteHouse(houseid);
		
		
		//返回数据
		if (n > 0) {
			String data = "客户信息删除成功";
			response.getWriter().println(data);
		}
	}
	
	/*
	 * 查询指定编号的房屋信息
	 */
	public void findHouseById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收视图层的表单数据
		int houseid = Integer.parseInt(request.getParameter("houseid"));
		//调用业务层完成查询指定编号的操作
		HouseService houseService = new HouseServiceImpl();
		House house = houseService.findHouseById(houseid);
		//获取所有房屋类型信息
		HouseTypeService houseTypeService = new HouseTypeServiceImpl();
		List<HouseType> houseTypeList = houseTypeService.findAllHouseType();
		request.setAttribute("houseTypeList", houseTypeList);
		//根据结果调转到相应的页面
		request.setAttribute("house", house);
		request.getRequestDispatcher("/house/houseUpdate.jsp").forward(request, response);
	}
	
	
	public void updateHouse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取更新房屋信息表单的值
		int houseid = Integer.parseInt(request.getParameter("houseid"));
		String location = request.getParameter("location");
		int typeid = Integer.parseInt(request.getParameter("typeid"));
		Double area = Double.parseDouble(request.getParameter("area"));
		Double price = Double.parseDouble(request.getParameter("price"));
		Double totalPrice = area*price;
		String ambient = request.getParameter("ambient");
		String houseDesc = request.getParameter("houseDesc");
		String housestate = request.getParameter("housestate");
		//调用业务层完成更新操作
		HouseService houseService = new HouseServiceImpl();
		House house = new House(houseid, typeid, location, price, area, totalPrice, ambient, housestate, houseDesc);
		int n = houseService.updateHouse(house);
		//根据结果跳转到相应的页面
		if(n > 0){
			response.sendRedirect(request.getContextPath()+"/servlet/HouseServlet?method=findHouse");
		}else{
			request.setAttribute("error", "更新失败");
			request.getRequestDispatcher("/house/houseAdd.jsp").forward(request, response);
		}
		
	}
	/**
	 * ============================================================================
	 */
	
	/**
	 * 添加房屋信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addHouse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.创建FileItemFactory对象
		FileItemFactory factory = new DiskFileItemFactory();
		
		//2.创建ServletFileUpload对象
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");//解决file表单项的文件名中文乱码问题
		
		//限制上传的单个和所有文件的大小。写在这个位置可防止占用空间
		upload.setFileSizeMax(1600*1024);//单个文件的上限
		upload.setSizeMax(5*1600*1024);//一次上传的所有文件的总大小的上限
		
		
		//3.通过ServletFileUpload对象实现上传操作，将客户端一个个表单项封装到一个个FileItem中
		List<FileItem>  itemList = null;
		try {
			itemList = upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
			request.setAttribute("mess", "文件不能超过1600kb....");
			request.getRequestDispatcher("/add.jsp").forward(request, response);
			return;
		}
		
		String location = null;  //房屋住址
		int typeid = 0;			  //房屋类型编号
		double area = 0;		  //房屋面积
		double price = 0;		  //房屋价格（/平米）
		String ambient =null;     //房屋环境
		String houseDesc =null;   //备注信息
		String imgType =null;     //图片类型
		String imgUploadName =null;//图片上传后名称
		String imgName =null;		//图片名称
		List<HouseImg> imgList = new ArrayList<HouseImg>();
		HouseImg img = new HouseImg();
		for(int i=0;i<itemList.size();i++){
			//获取每个FileItem对象的内容
			FileItem item = itemList.get(i);

			//获取第i个FileItem对象的内容
			if(item.isFormField()){//普通表单项

				//房屋地址
				if("location".equals(item.getFieldName())){
					location = item.getString("utf-8");
				}
				//房屋类型编号score = Double.parseDouble(item.getString());
				if("typeid".equals(item.getFieldName())){
					typeid = Integer.parseInt(item.getString());
				}
				//房屋面积
				if("area".equals(item.getFieldName())){
					area = Double.parseDouble(item.getString());
				}
				//房屋价格（/平米） 
				if("price".equals(item.getFieldName())){
					price = Double.parseDouble(item.getString());
				}
				//房屋环境
				if("ambient".equals(item.getFieldName())){
					ambient = item.getString("utf-8");
				}
				//备注信息 
				if("houseDesc".equals(item.getFieldName())){
					houseDesc = item.getString("utf-8");
				}
			}else{//file表单项
				if("img".equals(item.getFieldName())){
					
					
					//只上传jpg、jpeg和gif文件
					imgType = item.getContentType();//images/jpg
					
					if(!"image/jpeg".equals(imgType) && !"image/gif".equals(imgType)){
						request.setAttribute("mess", "只能上传jpg和gif文件");
						request.getRequestDispatcher("/add.jsp").forward(request, response);
						return;
					}
					
					//指定上传的文件夹
					String realPath = this.getServletContext().getRealPath("/upload");
					File dir = new File(realPath);
					//：如果文件夹不存在，就创建
					if(!dir.exists()){
						dir.mkdirs();
					}
					
					//指定上传文件的文件名
					imgName = item.getName(); //adfad.fadf.yi.jpg   
					//指定上传的文件夹和文件名
					//为了防止文件的同名覆盖，上传到服务器端的文件重新命名
					UUID uuid = UUID.randomUUID();
					String extName = imgName.substring(imgName.lastIndexOf("."));
					//上传后文件名  重新命名，防止重名
					imgUploadName = uuid.toString()+extName; //535bc231-935a-427b-a1d7-b3e6d8b8293e.jpg
					
					File file = new File(dir, imgUploadName);
					
					img.setImgName(imgName);    //图片名称
					img.setImgType(imgType);	//图片类型
					img.setImgUploadName(imgUploadName);  //图片上传后名称
					imgList.add(img);
					//上传该照片到指定位置
					try {
						item.write(file);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		double totalPrice = price*area;   //房屋总价
		String housestate = "新添加";     //房屋状态

		//将数据封装到房屋类中   其中包括房屋的图片
		House hou= new House(typeid, location, price, area, totalPrice, ambient, housestate, houseDesc, imgList);
		HouseService houService = new HouseServiceImpl();
		/**
		 *使用抛异常的方式判断添加是否成功 
		 */
		try{
			 houService.addHou(hou);
			//成功页面跳转
			 response.sendRedirect(request.getContextPath()+"/servlet/HouseServlet?method=findHouse");
		}catch(Exception e){
			e.printStackTrace();
			//失败 页面跳转
			request.setAttribute("error", "添加失败");
			request.getRequestDispatcher("/house/houseAdd.jsp").forward(request, response);
			
		}
		
			  
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findHouseImg(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//解决中文乱码问题
		response.setContentType("text/html;charset=utf-8");
		//获取视图层的数据
		int houseid = Integer.parseInt(request.getParameter("houseid"));
		
		//调用业务层完成相关操作
		HouseService houseService = new HouseServiceImpl();
		List<HouseImg> imgList = houseService.findImgByHouseId(houseid);
//		for(int i = 0;i<imgList.size();i++){
//			HouseImg img = imgList.get(i);
//			System.out.println(img);
//		}
		
		Gson gson = new Gson();
		//得到数据
		response.getWriter().println(gson.toJson(imgList));
		System.out.println(gson.toJson(imgList));
//			request.setAttribute("imgList", "imgList");
//			request.getRequestDispatcher("/house/houseImgShow.jsp").forward(request, response);
		
		
	}
	/**
	 * 图片下载
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void downImg(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//从视图层获取信息
		int imgid = Integer.parseInt(request.getParameter("imgid"));
		
		//调用业务层完成查询 操作
		HouseService houseService = new HouseServiceImpl();
		HouseImg img = houseService.findByImgId(imgid);
		
		//3.通过IO流实现照片下载（从服务器端到客户端）
		//3.1创建一个输入流和输出流
		String realPath = this.getServletContext().getRealPath("/upload");
		
		String fileName = realPath+"/"+img.getImgUploadName();
		File file = new File(fileName);
		
		response.setContentLength((int)file.length());//文件长度
		response.setContentType(img.getImgType());//MIME类型
		
		
		String realName = img.getImgName();//获取下载文件的原来名称，可能有中文，要解决中文乱码问题
		String userAgent = request.getHeader("User-Agent").toLowerCase();
		
		//IE游览器特殊，要进行特殊操作
		if(userAgent.indexOf("msie")>=0){
			realName = URLEncoder.encode(realName, "utf-8");
		}else{
			realName = new String(realName.getBytes("utf-8"),"iso-8859-1");
		}
		
		
		response.setHeader("Content-disposition", "attachment;filename="+realName);
		InputStream is = new FileInputStream(file);  //读服务器端一个文件
		OutputStream os = response.getOutputStream(); //写到客户端
		
		//3.2使用输入流和输出流完成复制操作（服务器端-----客户端）
		IOUtils.copy(is, os);
		//3.3关闭输入流是输出流
		is.close();
		os.close();
	}
		
	
	/**
	*====================================================================
	 * 只显示房屋信息
	 */
	
	/**
	 *查看房屋信息之前的操作
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void toHouseList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
	}
	public void findHouseByXXX(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			//按地址查询
			String location = request.getParameter("location");//按用户名查询
			//按房屋类型查询
			int typeid = 0;
			String stypeid = request.getParameter("typeid");
			if(stypeid != null && !"".equals(stypeid)){
				try{
					typeid = Integer.parseInt(stypeid);
				}catch(NumberFormatException e){
					e.printStackTrace();
				}
			}
			//按房屋状态查询
			String housestate = request.getParameter("housestate");
			//调用业务层完成操作
			HouseService houseService = new HouseServiceImpl();
			List<House> houseList = houseService.findHouse(location,typeid,housestate);		
			//获取所有的房屋类型信息
			//查询房屋类型
			HouseTypeService houseTypeService = new HouseTypeServiceImpl();
			List<HouseType> houseTypeList = houseTypeService.findAllHouseType();
			//跳转到houseList.jsp
			request.setAttribute("location", location);
			request.setAttribute("typeid", typeid);
			request.setAttribute("housestate", housestate);
			request.setAttribute("houseList", houseList);
			
			request.setAttribute("houseTypeList", houseTypeList);
			request.getRequestDispatcher("/house/houseList2.jsp").forward(request, response);
		}
	
}
