package com.bjsxt.entity;
/**
 * 房屋照片类
 * @author ZhaoWeiGuang
 *
 */
public class HouseImg {

	private int imgid;     //图片编号
	private int houseid;   //房屋编号
	private String imgType;//图片类型
	private String imgUploadName;//图片上传后名称
	private String imgName;      //图片名称
	
	
	private House  hous;   //房屋信息

	//构造方法
	public HouseImg() {
		super();
	}

	//全部构造方法
	public HouseImg(int imgid, int houseid, String imgType,
			String imgUploadName, String imgName, House hous) {
		super();
		this.imgid = imgid;
		this.houseid = houseid;
		this.imgType = imgType;
		this.imgUploadName = imgUploadName;
		this.imgName = imgName;
		this.hous = hous;
	}
	//查询构造方法
	public HouseImg(int imgid, int houseid, String imgType,
			String imgUploadName, String imgName) {
		super();
		this.imgid = imgid;
		this.houseid = houseid;
		this.imgType = imgType;
		this.imgUploadName = imgUploadName;
		this.imgName = imgName;
		
	}

	public int getImgid() {
		return imgid;
	}

	public void setImgid(int imgid) {
		this.imgid = imgid;
	}

	public int getHouseid() {
		return houseid;
	}

	public void setHouseid(int houseid) {
		this.houseid = houseid;
	}

	public String getImgType() {
		return imgType;
	}

	public void setImgType(String imgType) {
		this.imgType = imgType;
	}

	public String getImgUploadName() {
		return imgUploadName;
	}

	public void setImgUploadName(String imgUploadName) {
		this.imgUploadName = imgUploadName;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public House getHous() {
		return hous;
	}

	public void setHous(House hous) {
		this.hous = hous;
	}

	@Override
	public String toString() {
		return "HouseImg [imgid=" + imgid + ", houseid=" + houseid
				+ ", imgType=" + imgType + ", imgUploadName=" + imgUploadName
				+ ", imgName=" + imgName + ", hous=" + hous + "]";
	}
	
	
	
	
	
}
