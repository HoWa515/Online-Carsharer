package de.unidue.inf.is;

import java.io.IOException;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import COM.ibm.db2.app.Clob;
import de.unidue.inf.is.stores.BewertungStore;
import de.unidue.inf.is.stores.NewDriveStore;
import de.unidue.inf.is.stores.NewRateStore;

public class NewRateServlet extends HttpServlet {
	    
	 @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	 {
	         
		    String textnachricht =req.getParameter("Bewertungstext");
		    
	        String ratingstr=req.getParameter("rate");
            int  rating=Integer.parseInt(ratingstr);
	        
           BewertungStore nbs=new BewertungStore();
           nbs.addRate(textnachricht,rating);	
           req.getRequestDispatcher("rateSubmited.ftl").forward(req, res);
	   }
	 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.getRequestDispatcher("new_rating.ftl").forward(request, response);
	    }


}
