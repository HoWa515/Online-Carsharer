package de.unidue.inf.is;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.domain.OffenFahrt;
import de.unidue.inf.is.domain.ReserFahrt;
import de.unidue.inf.is.stores.OffenFahrtStore;
import de.unidue.inf.is.stores.ReserFahrtStore;

public class HauptServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		ReserFahrtStore rs=new ReserFahrtStore();
        List<ReserFahrt> rf=rs.findReserFahrt();
        
        OffenFahrtStore os=new OffenFahrtStore();
        List<OffenFahrt> of=os.findOffenFahrt();
       
	    req.setAttribute("reserFahrt",rf);
		req.setAttribute("offenFahrt",of);
		req.getRequestDispatcher("view_haupt.ftl").forward(req, resp);
        
      }
}
