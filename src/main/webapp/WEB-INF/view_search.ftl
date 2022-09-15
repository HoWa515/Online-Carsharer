<html>
<head><title>Fahrt Suche</title>

<style type="text/css">
* {
   margin:0;
   padding:0;
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



.centerBlock{
	margin:0 auto;
}
</style>
 
<body>
   <div id="wrapper">
   <form action="fahrtSuche" method="post">	
   <table>
		    <tr><td>Start:<input type="text" name="Startsort" /> </td></tr>
		    <tr><td> Ziel:<input type="text" name="Zielort" /> <br/> </td></tr>
		    <tr><td> ab:<input type="date" name="ab_date" />  </td></tr>
		    <tr><td> <input type="submit" value="Suche" /> </td></tr>
  </table>
  </form>  
  </div>
  
  <h2>----------------------------------------------------------------------------------------------------</h2>
  
 
</body>
</html>