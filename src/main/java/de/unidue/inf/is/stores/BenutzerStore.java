package de.unidue.inf.is.stores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.unidue.inf.is.stores.StoreException;
import de.unidue.inf.is.utils.DBUtil;

public class BenutzerStore {
	
	private Connection con;
    PreparedStatement ps;
    ResultSet rs;
	public List<Integer> findAllBenutzerID(){
    	List<Integer> b_id=new ArrayList<>();
        try {
        	con =DBUtil.getExternalConnection();
        	String sql="select bid from dbp031.benutzer";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) 
            {   int id=rs.getInt(1);
            	b_id.add(id);
            }
        }
        catch (SQLException e) {
            throw new StoreException(e);
        }
		return b_id;
    }

}
