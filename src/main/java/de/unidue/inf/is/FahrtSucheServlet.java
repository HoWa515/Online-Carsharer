package de.unidue.inf.is;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.domain.OffenFahrt;
import de.unidue.inf.is.stores.FahrtStore;
import de.unidue.inf.is.stores.OffenFahrtStore;
import de.unidue.inf.is.utils.DateTimeUtil;

 public class FahrtSucheServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		
		req.getRequestDispatcher("view_search.ftl").forward(req, resp);
    }
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String start=req.getParameter("Startsort");
		String ziel=req.getParameter("Zielort");
	    String abDate=req.getParameter("ab_date");
	    String abTime="00:00";//set a time 
	    String ab=DateTimeUtil.myconvertDateAndTimeToDB2DateTime(abDate, abTime);
	    OffenFahrtStore ofs=new OffenFahrtStore();
	    List<OffenFahrt> ofl=ofs.findSearchFahrt(start,ziel,ab);
	    if(ofl.isEmpty()) {
	    	req.getRequestDispatcher("no_available_drive.ftl").forward(req, resp);
	    }
	    else {
		req.setAttribute("searchResult", ofl);
		req.getRequestDispatcher("searchResult.ftl").forward(req, resp);}
    }
}
