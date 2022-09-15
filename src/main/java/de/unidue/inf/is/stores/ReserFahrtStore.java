package de.unidue.inf.is.stores;

import java.beans.Statement;
import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.unidue.inf.is.domain.Benutzer;
import de.unidue.inf.is.domain.ReserFahrt;
import de.unidue.inf.is.domain.User;
import de.unidue.inf.is.utils.DBUtil;



public final class ReserFahrtStore  {

    private Connection con;
    PreparedStatement ps;
    ResultSet rs;
   
    public List<ReserFahrt> findReserFahrt(){
    	List<ReserFahrt> rflist=new ArrayList<>();
        try {
        	con =DBUtil.getExternalConnection();
        	String sql="select f.fid,r.kunde,f.startort,f.zielort,f.status from dbp031.fahrt f join dbp031.reservieren r on f.fid=r.fahrt ";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) 
            {   int fid=rs.getInt(1);
                int kunde=rs.getInt(2);
            	String von=rs.getString(3);
            	String nach=rs.getString(4);
            	String status=rs.getString(5);
            	ReserFahrt rf =new ReserFahrt(fid,kunde,von,nach,status);
            	rflist.add(rf);
            }
        }
        catch (SQLException e) {
            throw new StoreException(e);
        }
		return rflist;
    }
    
    public void deleteReFahrt(int id) 
    {    try {
    	con=DBUtil.getExternalConnection();
    	String sql="delete from dbp031.reservieren where fahrt=?";
    	ps=con.prepareStatement(sql);
    	ps.setInt(1, id);
        ps.executeUpdate();
       }catch (SQLException e){
    	   throw new StoreException(e);
       }finally {
    	   try {
			ps.close();
	    	con.close();
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
    	   
       }
        
    }
    
    public List<Integer> findAllReID(){
    	List<Integer> re_id=new ArrayList<>();
        try {
        	con =DBUtil.getExternalConnection();
        	String sql="select distinct f.fid from dbp031.fahrt f join dbp031.reservieren r on f.fid=r.fahrt";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) 
            {   int id=rs.getInt(1);
            	re_id.add(id);
            }
        }
        catch (SQLException e) {
            throw new StoreException(e);
        }
		return re_id;
    }

    
     

}