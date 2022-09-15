<html>
<head><title>Hauptseite</title>
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
   width:200px;
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
		<div id="header">
		<h1> carSharer </h1>
		</div>
	   
 		<div id="site">		 
			<h2>Meine reservierten Fahrten</h2>
		<div>
		
		<#list reserFahrt as r>
		<div id="wrapper">	
		     
		    <form action="reserDrive?method=show&id_reser=${r.id}" method="post">
		    <table>
		    <tr> 		    
            <input type="submit" value="view_drive" />
            </tr>
            <tr><td>Fahrt nummer:${r.id} </td></tr>
            <tr><td>Kunde nummer:${r.kunde} </td></tr>
		    <tr><td>von:${r.von} </td></tr>
		    <tr><td>nach: ${r.nach}</td></tr>
		    <tr><td>Status:${r.status} </td></tr>
		    </table>
		    </form>
		</div>
		</#list>
 
  		
		<div id="site">		 
			<h2>Offene Fahrten</h2>
		<div>
				
		<#list offenFahrt as o>
		<div id="wrapper">		
		    <table>
		    <tr> 
            <form action="offenDrive?method=show&id_offen=${o.id}" method="post">
            <input type="submit" value="view_drive" />
            </form>
            </tr>
            <tr><td>Fahrt nummer:${o.id} </td></tr>
		    <tr><td>von:${o.von} </td></tr>
		    <tr><td>nach: ${o.nach}</td></tr>
		    <tr><td>Freie Plaetze: ${o.freiePlaetze}</td></tr>
		    <tr><td>Fahrkosten: ${o.fahrkosten}</td></tr>
		    </table>
		</div>
		</#list>
		
		<div id="wrapper">	
	 	<form action="newDrive" method="get">
        <input type="submit" value="Fahrt Erstellen" />
        </form>
        </div>
        <div id="wrapper">	
	 	<form action="fahrtSuche" method="get">
        <input type="submit" value="Fahrt Suche" />
        </form>
        </div>
				
	</div>
</body>
</html>
