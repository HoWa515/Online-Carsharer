package de.unidue.inf.is.stores;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import de.unidue.inf.is.utils.DBUtil;

public class NewRateStore {
	public void addRate(String textnachricht,int rating) 
	{   
		try {
        	Connection con =DBUtil.getExternalConnection();
        	String sql="insert into dbp031.bewertung(textnachricht ,erstellungsdatum ,rating ) values(?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,textnachricht);
            ps.setTimestamp(2, (Timestamp) new Date(1));
            ps.setInt(3,rating);
            
           
            ps.executeUpdate();
            
        }
        catch (SQLException e) {
            throw new StoreException(e);
        }
	}

}
