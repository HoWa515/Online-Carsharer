package de.unidue.inf.is.stores;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.unidue.inf.is.domain.Benutzer;
import de.unidue.inf.is.utils.DBUtil;

public class NewDriveStore {
	
	public void addDrive(String von,String bis, int maxPlaetze,Double fahrkosten,String transportmittel,String beschreibung) {
		
		try {
        	Connection con =DBUtil.getExternalConnection();
        	String sql="insert into dbp031.fahrt(startort,zielort,fahrtdatumzeit,maxPlaetze,fahrkosten,transportmittel,beschreibung)"
        			+ " values(?,?,?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, von);
            ps.setString(2,bis);
            ps.setDate(3, new Date(1));
            ps.setInt(4, maxPlaetze);
            ps.setDouble(5, fahrkosten);
            ps.setString(6, transportmittel);
            ps.setString(7, beschreibung);
            
            ps.executeUpdate();
            
        }
        catch (SQLException e) {
            throw new StoreException(e);
        }
	}
		 


}
