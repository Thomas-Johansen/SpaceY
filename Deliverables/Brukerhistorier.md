# Brukerhistorier

(BX hvor B står for brukerhistorie, og X er løpende nummerering fra 1.)

## Oblig1

**B1: Når jeg starter spillet, skal det vises et grafisk vindu med spillelementer, slik at det er mulig for meg å finne ut hvor jeg skal bevege min karakter**

Akseptansekriterie for B1:

- Det vises et GUI når spillet kjøres.
- Spillet kræsjer ikke når spillet kjøres.
- Grafikken vises (bakgrunnsbilde, grafiske elementer, etc).


**B2: Som spiller, skal jeg kunne styre spilleren med piltastene og wad, slik at min karakter i spillet beveger seg oppover eller høyre/venstre.**

Akseptansekriterie for B2:

- Spillet oppfatter og behandler input fra tastatur.
- Spilleren beveger den seg til venstre/høyre ved å trykke henholdsvis w eller d-tastene.
- Spilleren har veldefinerte koordinater, den beveger seg alltid så mye til høyre/venstre som input som gis.
- Spilleren hopper ved å trykke w. Spilleren kan IKKE trykke og holde w for å oppnå "uendelig bevegelse oppover".

**B3: Som spiller, skal karakteren min ved starten av spillet være i et spillbar startposisjon, slik at min karakter i spillet kan faktisk starte spillet (ikke være "stuck")**

Akseptansekriterie for B3:
- Spilleren dukker opp på et fornuftig startposisjon.
- Spilleren kan beveges på.

**B4: Som spiller, skal kameraet følge karakteren, slik at det er mulig å se omgivelsene rundt karakteren.**

Akseptansekriterie for B4:
- Når spillerens karakter beveger seg, beveger kameraet sammen med karakteren.


## Oblig2

**B5: Når jeg starter spillet, skal det vises en main menu med fungerende knapper man kan klikke på.**

Akseptansekriterie for B5:
- Main menu dukker opp i GUI når spillet kjøres.
- Grafikken vises (bakgrunnsbilde, grafiske elementer, etc).
- Knappene fungerer å respondere på klikk.

Arbeidsoppgaver:
- Implementere en ny gamescreen som fungerer som main menu.

**B6: Som spiller skal jeg kunne skifte gravitasjoen på spiller ved å klikke G på tastaturet.**

Akseptansekriterie for B6:
- Garvitasjoen for player objektet kan skiftest mellom de fire ulike himmelretningen.
- Kameraet roter med spiller når gravitasjonen skiftes.

Arbeidsoppgaver:
- Implementere fire caser med gravitasjon, en for hver himmelretningen.

**B7: Som utvikler ønsker jeg å ha dokumentasjon på deler av koden for å letter forstå hva koden gjør.**

Akseptansekriterie for B7:
- Klassene har dokumentasjon med nyttig infromasjon. 
- metoder er dokumentert med nyttig informasjon.

Arbeidsoppgaver:
- Aktivt dokumentere kode og klasser (JavaDoc).

**B8: Som spiller trenger jeg et avgrenset målområde som registrerer at jeg har seiret i spillet.**

Akseptansekriterie for B8:
- Et målområde på spillbrettet vises.
- Level/spill registreses som ferdig når spiller krysser målområde.

Arbeidsoppgaver:
- Implementere et målområde på spillbrettet.
- Definere vilkår om seier når målområde blir passert.

**B9: Som spiller ønsker jeg å kunne spille sammen med min kompis når han er på besøk.**

Akseptansekriterie for B9:
- Spillbrettet viser to spillere som kan styres med ulike key inputs (awd og left,up,rigth).
- Spillere kan interaktere med hverandre.
- Kamerate følger bakerste spiller.

Arbeidsoppgaver:
- Leggt til et nytt spiller objekt med andre key inputs.
- Oppdatere kameraet slik at det følger den bakerste spilleren.

**B10: Som spiller ønsker jeg at det er interaksjon mellom min brikk og elementer på spillbrettet.**

Akseptansekriterie for B10:
- Spiller kan flytte/dytte elementer rundt på spillbrettet.
- Spiler kan ta skade av elementer på spillbrettet.

Arbeidsoppgaver:
- Legge til elementer på spillbrett som kan dyttes av spiller.
- Legge til at elementer tar skade av spiller.  

## Oblig2  

**B11: Som spiller ønsker jeg at.**

Akseptansekriterie for B11:  
- BlaBla

Arbeidsoppgaver: 
- BlaBla

**B11: Som spiller ønsker jeg at.**

Akseptansekriterie for B12: 
- BlaBla 

Arbeidsoppgaver: 
- BlaBla
