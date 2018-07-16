
package com.bjsxt.entity;
/**
 * 岗位表
 * @author ZhaoWeiguang
 *
 */


import java.io.Serializable;

public class Position implements Serializable{
	
	private static final long serialVersionUID = 8559054469973776667L;
	private int posid;         //岗位编号
	private String posName;    //岗位名称
	private String posDesc;	   //岗位描述
	
	//构造方法
	public Position() {
		super();
	}
	//全部属性构造方法
	public Position(int posid, String posName, String posDesc) {
		super();
		this.posid = posid;
		this.posName = posName;
		this.posDesc = posDesc;
	}
	public int getPosid() {
		return posid;
	}
	public void setPosid(int posid) {
		this.posid = posid;
	}
	public String getPosName() {
		return posName;
	}
	public void setPosName(String posName) {
		this.posName = posName;
	}
	public String getPosDesc() {
		return posDesc;
	}
	public void setPosDesc(String posDesc) {
		this.posDesc = posDesc;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Position [posid=" + posid + ", posName=" + posName
				+ ", posDesc=" + posDesc + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((posDesc == null) ? 0 : posDesc.hashCode());
		result = prime * result + ((posName == null) ? 0 : posName.hashCode());
		result = prime * result + posid;
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
		Position other = (Position) obj;
		if (posDesc == null) {
			if (other.posDesc != null)
				return false;
		} else if (!posDesc.equals(other.posDesc))
			return false;
		if (posName == null) {
			if (other.posName != null)
				return false;
		} else if (!posName.equals(other.posName))
			return false;
		if (posid != other.posid)
			return false;
		return true;
	}
	
}

