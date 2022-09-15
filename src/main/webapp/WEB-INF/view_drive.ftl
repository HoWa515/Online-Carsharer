<html>
<head><title>New Rate</title>
<style type="text/css">
* {
   margin:0;
   padding:0;
}

body{
   text-align:center;
   background: #efe4bf none repeat scroll 0 0;
}

#wrapper{
   width:600px;
   margin:0 auto;
   text-align:left;
   background-color: #fff;
   border-radius: 0 0 10px 10px;
   padding: 20px;
   box-shadow: 1px -2px 14px rgba(0, 0, 0, 0.4);
   border:1px solid black
}

#header{
 color: #fff;
 background-color: #2c5b9c;
 height: 3.5em;
 padding: 1em 0em 1em 1em;
 
}

#site{
    background-color: #fff;
    padding: 20px 0px 0px 0px;
    border:1px solid black
    
}
.centerBlock{
	margin:0 auto;
}
</style>
<body>
<div id="site">	
		 <div id="wrapper">	 
			<h2>Informationen</h2>
		 	
		    <table>
		    <tr><td>Fahrt nummer: ${fahrtID}  </td></tr>
		    <tr><td>Anbieter: ${anbieter}  </td></tr>
		    <tr><td>Fahrdatum und Uhrzeit:${datumzeit} </td></tr>
		    <tr><td>von:${startort} </td></tr>
		    <tr><td>nach: ${zielort}</td></tr>
		    <tr><td>Anzahl freie Plaetze:${plaetze} </td></tr>
		    <tr><td>Fahrkosten:${kosten} </td></tr>
		    <tr><td>Status: ${status}</td></tr>
		    <tr><td>beschreibung: </td></tr>
		    </table>
		 </div>
		
		 <div id="wrapper">			 
			<h2>Aktionsleiste</h2>
			<form action="viewDrive?method=reserve&fahrtID=${fahrtID}&freiP=${plaetze}" method="post">
		    Anzahl Plaetze fuer Reservierung:<input type="number" name="reserPlatz" min="1" max="2" step="1"></input>
		    <input type="submit" value="Fahrt reservieren" />
		    <br/>
		    </form>
		    
		    <form action="viewDrive?method=delete&fahrtID=${fahrtID}&anbieter=${anbieter}" method="post">
		    <input type="submit" value="Fahrt loeschen" />
		    </form>
		 </div>
		
		 <div id="wrapper">		 
			<h2>Bewertung</h2> <h3>Durchschnittsrating:</h3>
		 	
		    <form action="newRate?">
		    <table>
		    <tr><td>User    </td> 
		    <td>Beschreibung&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp </td> 
		    <td>ratePoint  </td></tr> 
            <tr><td><input type="submit" value="Fahrt Betwerten" /></td></tr>
            </form>
          </div>  
</div>		 
</body>
</html>
