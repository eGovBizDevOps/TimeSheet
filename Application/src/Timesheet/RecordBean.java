package Timesheet;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Timesheet.Record;

 
@ManagedBean(name="record", eager=true)
@SessionScoped

public class RecordBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String date;
	private String timeIn;
	private String timeOut;
	private int hrs;
	private String eid;
	public RecordBean()
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
		setHrs();
	}
	
	public void setHrs(int hrs)
	{
		this.hrs = hrs;
	}
	
	public int toMins(String time)
	{
		int i = 0;
		String hours = "";
		int hrs1 = 0;
		String mins = "";
		int mins1 = 0;
		while (time.charAt(i) != ':')
		{
			hours = hours + time.charAt(i);
			i++;
		}
		i++;
		for(int j = i; j<time.length(); j++)
		{
			mins = mins + time.charAt(j);
		}
		hrs1 = Integer.parseInt(hours);
		if(time.charAt(time.length()-2) == 'p')
		{
			hrs1 = hrs1 + 12;
		}
		mins1 = (hrs1*60) + Integer.parseInt(mins.substring(0,mins.length()-2));
		return mins1;
	}
	
	public void setHrs()
	{
		double dif = (double) (toMins(timeOut) - toMins(timeIn));
		this.hrs = (int) Math.floor(dif/60) - 1; //One off for lunch
		System.out.println(this.hrs);
	}
	
	public int getHrs(){
		return this.hrs;
	}
	
	public String createRecord(){
		EntityManagerFactory recfactory = Persistence.createEntityManagerFactory( "Application" );
	      
	    EntityManager entitymanager = recfactory.createEntityManager( );
	    entitymanager.getTransaction( ).begin( );
	    
	    Record record = new Record();
	    record.setDate(getDate());
	    record.setTimeIn(getTimeIn());
	    record.setTimeOut(getTimeOut());
	    record.setHrs(getHrs());
	    record.setEid(getEid());
	    
	    entitymanager.persist(record);
	    entitymanager.getTransaction().commit();
	    
	    entitymanager.close();
	    recfactory.close();
	    
	    return "success";
	}
}
