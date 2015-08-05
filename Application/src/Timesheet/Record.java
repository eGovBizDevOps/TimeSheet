package Timesheet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class Record {
	
	@Id
	   @GeneratedValue(strategy = GenerationType.AUTO) 
	private String date;
	private String timeIn;
	private String timeOut;
	private int hrs;
	private String eid;
	public Record()
	{
	}

	public String getEid()
	{
		return eid;
	}
	
	public void setEid(String eid)
	{
		this.eid = eid;
	}
	
	public String getDate()
	{
		return this.date;
	}
	
	public void setDate(String date)
	{
		this.date = date;
	}
	
	public String getTimeIn()
	{
		return this.timeIn;
	}
	
	public void setTimeIn(String timeIn)
	{
		this.timeIn = timeIn;
	}

	public String getTimeOut()
	{
		return this.timeOut;
	}
	
	public void setTimeOut(String timeOut)
	{
		this.timeOut = timeOut;
	}
	
	public void setHrs(int hrs)
	{
		this.hrs = hrs;
	}
	
	public int getHrs()
	{
		return this.hrs;
	}
}
