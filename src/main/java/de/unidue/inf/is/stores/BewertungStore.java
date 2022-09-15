package de.unidue.inf.is.stores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.unidue.inf.is.domain.Benutzer;
import de.unidue.inf.is.utils.DBUtil;

public class BewertungStore {
	public void addRate(String textnach,int rate)
	{   Connection con=null; 
	    PreparedStatement ps=null;
	    
		try {
        	con =DBUtil.getExternalConnection();
        	String sql="insert into dbp031.bewertung(textnachricht,erstellungsdatum,rating) values(?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, textnach);
            LocalDateTime now = LocalDateTime.now();
            ps.setTimestamp(2, Timestamp.valueOf(now));
            ps.setInt(3, rate);
            ps.executeUpdate();
             }
        catch (SQLException e) {
            throw new StoreException(e);
        }finally {
        	try { 
        		ps.close();
				con.close();
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();}
        	}
		 
	}

}
