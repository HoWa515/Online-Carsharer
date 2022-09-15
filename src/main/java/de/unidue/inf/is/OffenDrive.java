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
import de.unidue.inf.is.stores.FahrtStore;
import de.unidue.inf.is.stores.ReserFahrtStore;

public class OffenDrive extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method=request.getParameter("method");
        String id_offenStr=request.getParameter("id_offen");
        int id_offen=Integer.parseInt(id_offenStr);
        
        if(method==null) 
        {
        	request.getRequestDispatcher("view_drive.ftl").forward(request,response);
        }
        switch(method) {
        case "show": //para show is from "view_haupt"
        	
        	FahrtStore fstore=new FahrtStore();
        	Fahrt f=fstore.findThisFahrt(id_offen);
            request.setAttribute("fahrtID", f.getId());
        	request.setAttribute("anbieter",f.getAnbieter());
        	request.setAttribute("datumzeit",f.getFahrtdatumzeit());
        	request.setAttribute("startort",f.getStartort());
        	request.setAttribute("zielort",f.getZielort());
        	request.setAttribute("plaetze",f.getMaxPlaetze());
        	request.setAttribute("kosten",f.getFahrtkosten());
        	request.setAttribute("status",f.getStatus());
            request.setAttribute("beschreibung",f.getBeschreibung());
            request.getRequestDispatcher("view_drive.ftl").forward(request,response);
        	
    	 break;
        
        }
    }
 }


