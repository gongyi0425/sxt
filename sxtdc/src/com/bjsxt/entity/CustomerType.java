package com.bjsxt.entity;

import java.io.Serializable;

/**
 * 客户类型表
 * @author ZhaoWeiguang
 *
 */
public class CustomerType implements Serializable{
		
	private static final long serialVersionUID = 5101324439979273551L;
	private int typeid;      //客户类型编号
	private String typeName; //客户类型名称
	private String typeDesc; //客户类型描述
	
	//构造方法
	public CustomerType() {
		super();
	}

	public CustomerType(int typeid, String typeName, String typeDesc) {
		super();
		this.typeid = typeid;
		this.typeName = typeName;
		this.typeDesc = typeDesc;
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeDesc() {
		return typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}

	@Override
	public String toString() {
		return "Type [typeid=" + typeid + ", typeName=" + typeName
				+ ", typeDesc=" + typeDesc + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((typeDesc == null) ? 0 : typeDesc.hashCode());
		result = prime * result
				+ ((typeName == null) ? 0 : typeName.hashCode());
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
		CustomerType other = (CustomerType) obj;
		if (typeDesc == null) {
			if (other.typeDesc != null)
				return false;
		} else if (!typeDesc.equals(other.typeDesc))
			return false;
		if (typeName == null) {
			if (other.typeName != null)
				return false;
		} else if (!typeName.equals(other.typeName))
			return false;
		if (typeid != other.typeid)
			return false;
		return true;
	}
	
	
	
	
}
