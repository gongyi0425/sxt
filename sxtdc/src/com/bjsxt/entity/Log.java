package com.bjsxt.entity;

import java.util.Date;


public class Log {
	private int logid;
	private String empid;
	private String cip;
	private String starttime;
	private String endtime;
	public int getLogid() {
		return logid;
	}
	public void setLogid(int logid) {
		this.logid = logid;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getCip() {
		return cip;
	}
	public void setCip(String cip) {
		this.cip = cip;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public Log() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Log(int logid, String empid, String cip, String starttime, String endtime) {
		super();
		this.logid = logid;
		this.empid = empid;
		this.cip = cip;
		this.starttime = starttime;
		this.endtime = endtime;
	}
	@Override
	public String toString() {
		return "Log [logid=" + logid + ", empid=" + empid + ", cip=" + cip
				+ ", starttime=" + starttime + ", endtime=" + endtime + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cip == null) ? 0 : cip.hashCode());
		result = prime * result + ((empid == null) ? 0 : empid.hashCode());
		result = prime * result + ((endtime == null) ? 0 : endtime.hashCode());
		result = prime * result + logid;
		result = prime * result
				+ ((starttime == null) ? 0 : starttime.hashCode());
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
		Log other = (Log) obj;
		if (cip == null) {
			if (other.cip != null)
				return false;
		} else if (!cip.equals(other.cip))
			return false;
		if (empid == null) {
			if (other.empid != null)
				return false;
		} else if (!empid.equals(other.empid))
			return false;
		if (endtime == null) {
			if (other.endtime != null)
				return false;
		} else if (!endtime.equals(other.endtime))
			return false;
		if (logid != other.logid)
			return false;
		if (starttime == null) {
			if (other.starttime != null)
				return false;
		} else if (!starttime.equals(other.starttime))
			return false;
		return true;
	}
	

}
