package com.bjsxt.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 房屋信息
 * @author ZhaoWeiguang
 *
 */
public class House implements Serializable{

	private static final long serialVersionUID = -4962535038425328321L;
	private int houseid;       //房屋编号
	private int typeid;        //房屋类型编号
	private String location;   //房屋地址
	private double price;      //房屋单价
	private double area;       //房屋面积
	private double totalPrice; //总价
	private String ambient;    //房屋环境
	private String housestate; //房屋状态
	private String houseDesc;       //备注信息
	
	private HouseType type;    //存储房屋类型信息
	private List<HouseImg> imgList = new ArrayList<HouseImg>();
	private HouseImg img;      //图片信息  
	 

	
	//构造方法
	public House() {
		super();
	}
	
	//添加房屋信哦构造方法
	public House( int typeid, String location, double price,
			double area, double totalPrice, String ambient, String housestate,
			String houseDesc, List<HouseImg> imgList
			) {
		super();		
		this.typeid = typeid;
		this.location = location;
		this.price = price;
		this.area = area;
		this.totalPrice = totalPrice;
		this.ambient = ambient;
		this.housestate = housestate;
		this.houseDesc = houseDesc;
		this.imgList = imgList;
	}


	public House(int houseid, int typeid, String location, double price,
			double area) {
		super();
		this.houseid = houseid;
		this.typeid = typeid;
		this.location = location;
		this.price = price;
		this.area = area;
	}

	//全部属性构造方法
	public House(int houseid, String location, double price,
			double area, double totalPrice, String ambient, String housestate,
			String houseDesc, HouseType type) {
		super();
		this.houseid = houseid;
		this.location = location;
		this.price = price;
		this.area = area;
		this.totalPrice = totalPrice;
		this.ambient = ambient;
		this.housestate = housestate;
		this.houseDesc = houseDesc;
		this.type = type;
	}
	public House(int houseid, int typeid, String location, double price,
			double area, double totalPrice, String ambient, String housestate,
			String houseDesc, HouseType type) {
		super();
		this.houseid = houseid;
		this.typeid = typeid;
		this.location = location;
		this.price = price;
		this.area = area;
		this.totalPrice = totalPrice;
		this.ambient = ambient;
		this.housestate = housestate;
		this.houseDesc = houseDesc;
		this.type = type;
	}
	public House(int typeid, String location, double price, double area,
			double totalPrice, String ambient, String housestate,
			String houseDesc) {
		super();
		this.typeid = typeid;
		this.location = location;
		this.price = price;
		this.area = area;
		this.totalPrice = totalPrice;
		this.ambient = ambient;
		this.housestate = housestate;
		this.houseDesc = houseDesc;
	}
	
	public House(int houseid, int typeid, String location, double price,
			double area, double totalPrice, String ambient, String housestate,
			String houseDesc) {
		super();
		this.houseid = houseid;
		this.typeid = typeid;
		this.location = location;
		this.price = price;
		this.area = area;
		this.totalPrice = totalPrice;
		this.ambient = ambient;
		this.housestate = housestate;
		this.houseDesc = houseDesc;
	}
	
	public House(String location, double price, double area, double totalPrice,
			String ambient, String housestate, String houseDesc, HouseType type) {
		super();
		this.location = location;
		this.price = price;
		this.area = area;
		this.totalPrice = totalPrice;
		this.ambient = ambient;
		this.housestate = housestate;
		this.houseDesc = houseDesc;
		this.type = type;
	}

	public int getHouseid() {
		return houseid;
	}
	public void setHouseid(int houseid) {
		this.houseid = houseid;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getAmbient() {
		return ambient;
	}
	public void setAmbient(String ambient) {
		this.ambient = ambient;
	}
	public String getHousestate() {
		return housestate;
	}
	public void setHousestate(String housestate) {
		this.housestate = housestate;
	}
	public String getHouseDesc() {
		return houseDesc;
	}
	public void setHouseDesc(String houseDesc) {
		this.houseDesc = houseDesc;
	}
	public HouseType getType() {
		return type;
	}
	public void setType(HouseType type) {
		this.type = type;
	}
	
	public List<HouseImg> getImgList() {
		return imgList;
	}

	public void setImgList(List<HouseImg> imgList) {
		this.imgList = imgList;
	}
	
	public HouseImg getImg() {
		return img;
	}

	public void setImg(HouseImg img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "House [houseid=" + houseid + ", typeid=" + typeid
				+ ", location=" + location + ", price=" + price + ", area="
				+ area + ", totalPrice=" + totalPrice + ", ambient=" + ambient
				+ ", housestate=" + housestate + ", houseDesc=" + houseDesc
				+ ", type=" + type + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ambient == null) ? 0 : ambient.hashCode());
		long temp;
		temp = Double.doubleToLongBits(area);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((houseDesc == null) ? 0 : houseDesc.hashCode());
		result = prime * result + houseid;
		result = prime * result
				+ ((housestate == null) ? 0 : housestate.hashCode());
		result = prime * result
				+ ((location == null) ? 0 : location.hashCode());
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + typeid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		House other = (House) obj;
		if (ambient == null) {
			if (other.ambient != null)
				return false;
		} else if (!ambient.equals(other.ambient))
			return false;
		if (Double.doubleToLongBits(area) != Double
				.doubleToLongBits(other.area))
			return false;
		if (houseDesc == null) {
			if (other.houseDesc != null)
				return false;
		} else if (!houseDesc.equals(other.houseDesc))
			return false;
		if (houseid != other.houseid)
			return false;
		if (housestate == null) {
			if (other.housestate != null)
				return false;
		} else if (!housestate.equals(other.housestate))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (Double.doubleToLongBits(totalPrice) != Double
				.doubleToLongBits(other.totalPrice))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (typeid != other.typeid)
			return false;
		return true;
	}
	
}
