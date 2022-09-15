package de.unidue.inf.is.stores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import de.unidue.inf.is.utils.DBUtil;

public class ReserveStore {
	public void addReserve(int user,int fahrt,int rePlatz) 
	{   
		try {
        	Connection con =DBUtil.getExternalConnection();
        	String sql="insert into dbp031.reservieren(kunde,fahrt,anzPlaetze) values(?,?,?)";
        			
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, user);
            ps.setInt(2, fahrt);
            ps.setInt(3, rePlatz);
            ps.executeUpdate();
           }
        catch (SQLException e) {
            throw new StoreException(e);
        }
	}

}
