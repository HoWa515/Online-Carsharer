package de.unidue.inf.is;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.unidue.inf.is.domain.Benutzer;
import de.unidue.inf.is.stores.BenutzerStore;
import de.unidue.inf.is.domain.Fahrt;
import de.unidue.inf.is.domain.OffenFahrt;
import de.unidue.inf.is.domain.ReserFahrt;
import de.unidue.inf.is.stores.FahrtStore;
import de.unidue.inf.is.stores.OffenFahrtStore;
import de.unidue.inf.is.stores.ReserFahrtStore;
import de.unidue.inf.is.stores.ReserveStore;

public class ViewDriveServlet extends HttpServlet {
	 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method=request.getParameter("method");
        String id_deleteStr=request.getParameter("fahrtID");//para used in delete
        int id_delete=Integer.parseInt(id_deleteStr);
        int id_reserve=id_delete; // same id
       
        
        if(method==null) 
        {
        	request.getRequestDispatcher("view_drive.ftl").forward(request,response);
        }
        switch(method) {
        case "delete"://from view_drive
        	String anbieterStr=request.getParameter("anbieter");
            int anbieter=Integer.parseInt(anbieterStr);
        	Integer fahrtErsteller=anbieter;//the corosponding one FahrtErsteller
        	ReserFahrtStore rs=new ReserFahrtStore();//find all reserved drive ID
        	List<Integer> allResevID=rs.findAllReID();
        	if(fahrtErsteller!=1) //----not the specifide anbieter
        	{
        		request.getRequestDispatcher("no_right_delete.ftl").forward(request,response);
        	}else {
        		
        		if(allResevID.contains(id_delete))
        		{ReserFahrtStore rfs=new ReserFahrtStore();
        		 rfs.deleteReFahrt(id_delete);	
        		}else {
        		FahrtStore fs=new FahrtStore(); // delete fahrt by id in table fahrt
        		fs.deleteByID(id_delete);}
        		
        		  
                List<ReserFahrt> rf=rs.findReserFahrt();//return to hauptseite
                request.setAttribute("reserFahrt",rf);
           
              
        		OffenFahrtStore os=new OffenFahrtStore();
                List<OffenFahrt> of=os.findOffenFahrt();
                request.setAttribute("offenFahrt",of);
                
                request.getRequestDispatcher("view_haupt.ftl").forward(request, response); 
        	}
        	break;
        case "reserve":
        	 String freiPstr=request.getParameter("freiP");
        	 int freiP=Integer.parseInt(freiPstr);
        	 String reserPStr=request.getParameter("reserPlatz");
             int reserP=Integer.parseInt(reserPStr);
        	
        	 BenutzerStore beStore=new BenutzerStore();
        	 List<Integer> bids=beStore.findAllBenutzerID();
        	 Integer userNr=1;
             userNr++;//make sure each time to insert beid is not the same;
        	 if(!bids.contains(userNr)) {
        		 request.getRequestDispatcher("notInBelist.ftl").forward(request, response);
        	 }else 
        	 {   if(freiP<reserP) 
        	     {
        		 request.getRequestDispatcher("seatNotEnough.ftl").forward(request, response);
        	     }else {
        		 ReserveStore reStore=new ReserveStore();
        		 reStore.addReserve(userNr,id_reserve , reserP);//insert into reservieren Table
        		 
        		 ReserFahrtStore rfs=new ReserFahrtStore();//to show in homepage
        		 List<ReserFahrt> reList=rfs.findReserFahrt();
        		 request.setAttribute("reserFahrt",reList );
        		 OffenFahrtStore os=new OffenFahrtStore();
                 List<OffenFahrt> of=os.findOffenFahrt();
                 request.setAttribute("offenFahrt",of);
        		 request.getRequestDispatcher("view_haupt.ftl").forward(request, response);
        	     }
        	 }
        }
      }
 }


