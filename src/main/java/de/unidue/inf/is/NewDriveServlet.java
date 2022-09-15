package de.unidue.inf.is;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.domain.Benutzer;
import de.unidue.inf.is.stores.FahrtStore;
import de.unidue.inf.is.stores.NewDriveStore;
import de.unidue.inf.is.utils.DateTimeUtil;

public class NewDriveServlet extends HttpServlet {
	      
	 @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	        String startort=req.getParameter("von");
	        
	        String zielort=req.getParameter("bis");
	        
	        String maxPlaetzestr=req.getParameter("max");
	        int maxPlaetze=Integer.parseInt(maxPlaetzestr);
	        
	        String fahrkostenstr=req.getParameter("kosten");
	        Double fahrtkosten=Double.parseDouble(fahrkostenstr);
	        
	        String transStr=req.getParameter("trans_mittel");
	        int trans=Integer.parseInt(transStr);
	        
            String dateStr=req.getParameter("date");
            String timeStr=req.getParameter("time");
          	String datetime=DateTimeUtil.myconvertDateAndTimeToDB2DateTime(dateStr, timeStr);
	        
	        String beschreibung=req.getParameter("beschreibung");
	        
	        FahrtStore fs=new FahrtStore();
	        String status="offen"; //set a status to insert ,by default is offen
	        int anbieter=1; //set a default anbieter, in reality is a logged in user
	        fs.insertFahrt(startort,zielort,datetime,maxPlaetze,fahrtkosten,status,anbieter,trans,beschreibung);
	        
	        req.getRequestDispatcher("view_haupt.ftl").forward(req, res);
	      
	    }
	 
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	        
	    	RequestDispatcher rd=req.getRequestDispatcher("new_drive.ftl");
	        
	        rd.forward(req, res);
	    }


}
