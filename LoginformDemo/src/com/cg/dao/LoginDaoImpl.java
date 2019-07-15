package com.cg.dao;

import java.sql.Connection;
import java.sql.Statement;

import java.sql.ResultSet;

import com.cg.bean.Login;
import com.cg.util.DBUtil;

public class LoginDaoImpl implements LoginDao {
	Connection con=DBUtil.getConnect();
	@Override
	public Login loginUser(Login user) {
		// TODO Auto-generated method stub
		Login obj=null;
		String qry="SELECT * FROM UserDetails";
		try{
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(qry);
			while(rs.next())
			{
				String uName=rs.getString(1);
				String pWd=rs.getString(2);
				if(uName.equals(user.getUsername())&&pWd.equals(user.getPassword()))
				{
					obj=user;
					break;
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return obj;
	}

}
