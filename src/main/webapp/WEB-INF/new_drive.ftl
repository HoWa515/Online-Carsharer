<html>
<head><title>Fahrt Erstellen</title>
 
<body>
  <h1>Fahrt erstellen</h1>
  <form action="newDrive" method="post">
    von:<input type="text" name="von" /> <br/>
    bis:<input type="text" name="bis" /> <br/>
    maximal Kapazitaet: <input type="text" name="max" /> <br/>
    Fahrkosten:         <input type="text" name="kosten" /> <br/>
    Transportmittel:<input type="radio" name="trans_mittel" value="1">Auto
    				<input type="radio" name="trans_mittel" value="2">Bus
    				<input type="radio" name="trans_mittel" value="3">Kleintransporter<br/>
    Fahrtdatum:<input type="date" name="date"> 
              <input type="time" name="time"><br/>          
    Beschreibung:<textarea name="beschreibung"></textarea> 	<br/>			
    <input type="submit" value="erstellen" />
  </form>
 
  
</body>
</html>