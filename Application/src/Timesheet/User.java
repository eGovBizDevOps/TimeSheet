package Timesheet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table

public class User {
	
	@Id
	   @GeneratedValue(strategy = GenerationType.AUTO) 
	private String eid;
	private String pass;
	public User()
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
	
	public String getPass()
	{
		return pass;
	}
	
	public void setPass(String pass)
	{
		this.pass = pass;
	}
}
