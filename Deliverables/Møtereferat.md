# Møtereferat

### Møte - 29/03/2022
**Deltagelse:** Thomas L, Thomas J  
  
**Diskusjon og progresjon under møte**  
Etter innleveringen av oblig2 ble vi oppmerksom på en god del ting vi trengte å jobbe videre med. I møte gikk vi gjennom punktene vi måtte se videre på samt fikk hjelp av gruppeleder på videre utvikling av tester. Til Oblig2 leverte vi tester, men de funket dessverre ikke. Dette fikk vi løst denne gruppetimen. Main menu screenen har en bug som gjør at den ikke kan forstørres.

**Fordeling av oppvaver**  
Thomas J - Kolisjonsoppdagelse og ordentlige metoder for drap av spiller og fullføring av kart.  
Thomas L - Fikse main menu samt legge til knapper som skiller mellom 1-player og 2-player.  
Daniel S - Starte implementeringen av enemies.  

### Møte - 31/03/2022  
Digitalt  
**Deltagelse:** Thomas L, Thomas J, Daniel  

**Diskusjon og progresjon under møte**  
Startet litt på utviklingen av maps både for singleplayer og multiplayer (work in progress). Dette blir nok ikke lagt til før siste innlevering.

### Møte - 05/04/2022   
**Deltagelse:** Thomas J, Daniel  (Thomas L en time forsinket)  
  
**Diskusjon og progresjon under møte**  
Jobbet viderer med implementeringen av enemies og MainMenuScreen. Vi fant ut hvordan koden kan kjøres på mac (ReadMe oppdatert med instrukser).

### Møte - 07/04/2022  
Digitalt  
**Deltagelse:** Thomas L, Thomas J, Daniel  

**Diskusjon og progresjon under møte**  
MainMenuScreen er nå oppdatert med nye knapper (singleplayer, multiplayer og exit). Problemet med resizing av MainMenuScreen fikset etter og ha satt MainMenuScrren til en fixed size. Enemies har delevis blitt implementert (en god del som mangler, men et godt utgangspunkt). Ellers har noe kode blitt flyttet på til eksterne klasser og noe av tilesettet blitt oppdatert. Vider mot innlevering trengs det og finpusses på noe kode samt oppdatere tekstdokumentet for oblig 3


### Møte - 19/04/2022 og 21/04/2022 avlyst grunnet andre innleveringer  
  
### Møte - 22/04/2022  
**Deltagelse:** Daniel, Thomas J  

**Diskusjon og progresjon under møte**  
Diskuterte fordeling av oppgaver for siste uken, de vkktigste gjennverende oppgavene ble oppsumert til:  
Tester  
Kamera  
Spawna via tiled kart  
Mulighet te å bytta/ha flere nivå på singleplayer  
Spillobject:  
<ol>
	<li>Knapp som åpner dår når trykket på</li>
	<li>Dør</li>
	<li>Gravity Shift Plater</li>
	<li>Flere enemies?</li>
	<li>Poeng objekter for multiplayer</li>
<ol/>  

  
Level design  
  
Daniel tok på seg å lage tester.
Thomas J ser for seg å fikse spawning via Tiled, level bytting og Kamera.
Hadde et kort møte med Thomas L senere på kvelden, han tok på seg å jobbe med de manglede objektene  
  
Level design blir sannsynligvis på felles når alt annet er ferdig.

### Møte - 26/04/2022  
**Deltagelse:** Daniel, Thomas J, Thomas L 

**Diskusjon og progresjon under møte**  
Spillobjekter kan nå spawnes vi Tiled. Den første banene/lvlen er ferdig med tutorial på hvordan spille fungerer. Tester for noen av spilleobjekten er også på plass.  

### Møte - 27/04/2022  
Digitalt   
**Deltagelse:** Daniel, Thomas J, Thomas L  

**Diskusjon og progresjon under møte**  
EnemyAI er nå implementert. Alien beveger seg frem og tilbake ettersom når den kolliderer med et objekt. Ailen vil også rotere og bevege seg på vegger og i tak ettersom at gravitasjoen forandrer seg. PressurePad sensor objektet er laget, men ikke ferdig implementert.   

### Møte - 28/04/2022  
Digitalt   
**Deltagelse:** Daniel, Thomas J, Thomas L  

**Diskusjon og progresjon under møte**  
PressurePad som åpner dør har blitt implementert. Coin objekt er ferdig laget. Dette vil bli brukt i multiplayer hvor objektet er å samle flest coins. HUDen til mulitplayer har da også blitt oppdatert med en oversikt over score. Videre arbeider vi opp mot siste innspurt av prosjekt innleverinegn og desgine av nye kart.
