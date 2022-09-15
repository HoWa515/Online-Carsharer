package de.unidue.inf.is.stores;

import java.beans.Statement;
import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.ibm.db2.jcc.DBTimestamp;

import de.unidue.inf.is.domain.Benutzer;
import de.unidue.inf.is.domain.OffenFahrt;
import de.unidue.inf.is.domain.ReserFahrt;
import de.unidue.inf.is.domain.User;
import de.unidue.inf.is.utils.DBUtil;



public final class OffenFahrtStore  {

    private Connection con;
   
    public List<OffenFahrt> findSearchFahrt(String start,String ziel,String ab){
    	List<OffenFahrt> searchFahrt=new ArrayList<>();
        try {
        	Connection con =DBUtil.getExternalConnection();
        	String sql="select f.fid,f.startort,f.zielort,f.maxPlaetze,f.fahrtkosten"
        			+ " from dbp031.fahrt f where status='offen' and startort=? and zielort=? and fahrtdatumzeit>=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, start);
            ps.setString(2, ziel);
            Timestamp ts=Timestamp.valueOf(ab);
            ps.setTimestamp(3, ts);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) 
            {   int oid=rs.getInt(1);
            	String von=rs.getString(2);
            	String nach=rs.getString(3);
            	int freiePlaetze=rs.getInt(4);
            	double fahrkosten=rs.getDouble(5);
            	OffenFahrt of =new OffenFahrt(oid,von,nach,freiePlaetze,fahrkosten);
            	searchFahrt.add(of);
            }
        }
        catch (SQLException e) {
            throw new StoreException(e);
        }
		return searchFahrt;
    }

    
    public List<OffenFahrt> findOffenFahrt(){
    	List<OffenFahrt> oflist=new ArrayList<>();
        try {
        	con =DBUtil.getExternalConnection();
        	String sql="select f.fid,f.startort,f.zielort,f.maxPlaetze,f.fahrtkosten"
        			+ " from dbp031.fahrt f where status='offen'";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()) 
            {   int oid=rs.getInt(1);
            	String von=rs.getString(2);
            	String nach=rs.getString(3);
            	int freiePlaetze=rs.getInt(4);
            	double fahrkosten=rs.getDouble(5);
            	OffenFahrt of =new OffenFahrt(oid,von,nach,freiePlaetze,fahrkosten);
            	oflist.add(of);
            }
        }
        catch (SQLException e) {
            throw new StoreException(e);
        }
		return oflist;
    }

}