package Timesheet;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Timesheet.User;

 
@ManagedBean(name="record", eager=true)
@SessionScoped

public class UserBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String eid;
	private String pass;
	public UserBean()
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
	
	public String createUser(){
		EntityManagerFactory recfactory = Persistence.createEntityManagerFactory( "Application" );
	      
	    EntityManager entitymanager = recfactory.createEntityManager( );
	    entitymanager.getTransaction( ).begin( );
	    
	    User user = new User();
	    user.setEid(getEid());
	    user.setPass(getPass());
	    
	    entitymanager.persist(user);
	    entitymanager.getTransaction().commit();
	    
	    entitymanager.close();
	    recfactory.close();
	    
	    return "success";
	}
}
