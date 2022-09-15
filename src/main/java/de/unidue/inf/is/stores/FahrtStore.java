package de.unidue.inf.is.stores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ibm.db2.jcc.DBTimestamp;

import de.unidue.inf.is.domain.Fahrt;
import de.unidue.inf.is.domain.ReserFahrt;
import de.unidue.inf.is.utils.DBUtil;

public class FahrtStore {
	    private Connection con;
	    PreparedStatement ps;
	    ResultSet rs;
	    
	   
//----------------------------------------------------------------------------------------
	    public Fahrt findThisFahrt(int id){
	    	Fahrt returnFahrt=null;
	    	List<Fahrt> flist=new ArrayList<>();
	        try {
	        	con =DBUtil.getExternalConnection();
	        	
	        	String sql="select f.fid,f.anbieter,f.fahrtdatumzeit,f.startort,f.zielort,f.maxPlaetze,f.fahrtkosten,f.status,f.beschreibung from dbp031.fahrt f";
	            PreparedStatement ps=con.prepareStatement(sql);
	            ResultSet rs=ps.executeQuery();
	            while(rs.next()) 
	            {   int fid=rs.getInt(1);
	            	int anbieter=rs.getInt(2);
	            	Date datumzeit=rs.getTimestamp(3);
	            	String startort=rs.getString(4); 
	            	String zielort=rs.getString(5); 
	            	int plaetze=rs.getInt(6);
	            	double kosten=rs.getDouble(7);
	            	String status=rs.getString(8);
	            	String beschreibung=rs.getString(9);
	            	Fahrt f=new Fahrt(fid,anbieter,datumzeit,startort,zielort,plaetze,kosten,status,beschreibung);
	            	flist.add(f);
	            	for(Fahrt fahrt :flist){
	            	    if (fahrt.getId()==id)
	            	    {
	            	    	 returnFahrt=fahrt;
	            	    }
	            	}
	            	
	            }
	            
	        }
	        catch (SQLException e) {
	            throw new StoreException(e);
	        }
			return returnFahrt;
	    }
	    
//----------------------------------------------------------------------------
	    public void deleteByID(int id) 
	    { try {
        	con =DBUtil.getExternalConnection();
        	
        	String sql="delete from dbp031.fahrt where fid=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
           }
        catch (SQLException e) {
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
//-----------------------------------------------------------------------------------------------------------	    
	    public List<Integer> findAllFahrtID(){
	    	List<Integer> allFahrt_id=new ArrayList<>();
	        try {
	        	con =DBUtil.getExternalConnection();
	        	String sql="select fid from dbp01.fahrt";
	            ps=con.prepareStatement(sql);
	            rs=ps.executeQuery();
	            while(rs.next()) 
	            {   int id=rs.getInt(1);
	            allFahrt_id.add(id);
	            }
	        }
	        catch (SQLException e) {
	            throw new StoreException(e);
	        }
			return allFahrt_id;
	    }
	  //----------------------------------------------------------------------------------------------------------	    
	    public List<Integer> findAllAnbieterID(){
	    	List<Integer> allAnbieter_id=new ArrayList<>();
	        try {
	        	con =DBUtil.getExternalConnection();
	        	String sql="select anbieter from dbp01.fahrt";
	            ps=con.prepareStatement(sql);
	            rs=ps.executeQuery();
	            while(rs.next()) 
	            {   int id=rs.getInt(1);
	            allAnbieter_id.add(id); 
	            }
	        }
	        catch (SQLException e) {
	            throw new StoreException(e);
	        }
			return allAnbieter_id;
	    }
	  //----------------------------------------------------------------------------------------------------------
	    public void insertFahrt(String start,String end,String datetime,int max,double kosten,String status,int anbieter,int trans,String beschreib)
		{   Connection con=null; 
		    PreparedStatement ps=null;
		    
			try {
	        	con =DBUtil.getExternalConnection();
	        	String sql="insert into dbp031.fahrt(startort,zielort,fahrtdatumzeit,"
	        			+ "maxPlaetze,fahrtkosten,status,anbieter,transportmittel,beschreibung) values(?,?,?,?,?,?,?,?,?)";
	            ps=con.prepareStatement(sql);
	            ps.setString(1,start);
	            ps.setString(2,end);
	            Timestamp t=Timestamp.valueOf(datetime);
		        ps.setTimestamp(3, t);
	            ps.setInt(4, max);
	            ps.setDouble(5, kosten);
	            ps.setString(6, status);
	            ps.setInt(7, anbieter);
	            ps.setInt(8, trans);
	            ps.setString(9, beschreib);
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
