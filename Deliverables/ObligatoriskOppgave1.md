## 1. Organisering av teamet

**Teamnavn**: ?

**Medlemmer:** Daniel Sandhaug, Thomas Lande, Thomas S. Johansen, Andrey Arkharov

**Bakgrunn til teammedlemmene:**
Alle teammedlemmer har kunnskaper innenfor Java tilsvarende emnet INF101. I tillegg har Daniel, Thomas L., Thomas J. tatt emnet INF102 som omhandler algoritmer og datastrukturer. Av andre emner har gruppemedlemmene også tatt emner som inngår i bachelorgraden "Informatikk: Datateknologi" som INF101 (Innføring i programmering, Python), INF122 (Funksjonell programmering, Haskell), MNF130 (Diskrete strukturer).

Teamet anser seg selv å være "midt på treet" når det gjelder programmeringskunnskaper.

**Git**:
Det er opprettet en [Gitlab gruppe](https://git.app.uib.no/group-4-team-2) med alle-teammedlemmene og [et GitLab prosjekt](https://git.app.uib.no/group-4-team-2/oblig) på UiB sin GitLab CE instans (git.app.uib.no).

**### Kort om rollefordeling**
Teamet har ingen bestemte roller per dags dato. Det gir ingen mening å ha egne roller når vi er en liten team. Målet er at alle skal kunne bidra med på de ulike delene av prosjektet.


## 2. Prosjektprossess

### (Praktisk) organisering av møter
Under gruppetiden tirsdag den 08.02.2022 har teamet ble enige om forløpelige faste møtetider for teamet:
**+** I "gruppetimen" tirsdager i tidsrommet 12-14, på Høyteknologisentetet.
**+** Hver torsdag i tidsrommet 10-14, fortrinsvis på Høyteknologisenteret.

Skulle det oppstå behov for ekstra møter utover de faste, er det rom for å avtale dette.


### Kommunikasjon mellom møter
Kommunikasjon mellom møter vil foregå på Discord. Om nødvendig, vil det være mulig å organisere "ad-hoc" møter, for eksempel digitalt - dette avtales via Discord.

## Prosjektmetodikk
Ingen bestemt prosjektmetodikk følges. Fra Kanban henter vi blant annet "issues board". Rent praktisk velger vi å bruke "Issues board" i Gitlab-prosjektet som tavlen for prosjektet, som i et ledd for å holde det viktigeste på et sted (gjør det mer oversiktlig). Oppgavene velges fra TODO og teamet bestemmer seg for hvilke oppgaver de skal ta for seg i et bestemt periode. "Commit & push" skjer kontinuerlig (dvs. når oppgaven er klar til review/ferdig).

Fra Scrum henter vi ideen om at teamet jobber med et bestemt sett av oppgaver i perioden (f.eks. fra en gruppemøte til en annen - hvor realistisk?) uten å endre scopet (legge / fjerne oppgaver), samt retrospektiv for hver møte, hvor vi etterstreber å justere prossesen etter hver "iterasjon" for å eliminere friksjoner og løse utfordringer (mhp. at dette er gjerne er første større gruppearbeidsprosjekt for oss alle og hvor vi må prøve oss frem).


## 3. Spesifikasjon

### Brukerhistorier
(BX hvor B står for brukerhistorie, og X er løpende nummerering fra 1.)

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

**B4: Som spiller, skal kameraet følge karakteren, slik at det er mulig å se omgivelsene rundt karakteren.

Akseptansekriterie for B4:
- Når spillerens karakter beveger seg, beveger kameraet sammen med karakteren.
****




## 4. Oppsummering (prosjekt-retrospektiv)
*>* Hver møte, men her blir oppsumering for hele perioden.
*>*

**Hva gikk bra? Hvorfor?**
Gruppen kommer bra overens og alle møter opp til gruppetimene samt har arrangert eksterne tider å møte for å jobbe sammen enten fysisk eller via discord. Alle har også en bra forsåelse på hvor de ligger I forhold til kunnskap/nivå og hva som kan forbedres I fremtiden.

**Hva som fungerte mindre bra? Hvorfor?**
Var litt vanskelig som forventet å jobbe som en gruppe i forhold til delt fordeling av koding/arbeid, hvor det kanskje ender litt opp med at man ikke helt kommuniserer på forhånd hvem som hadde ansvar for å gjøre enkelte ting, slik at man endte opp med at noe av arbeidet overlappet til noe grad. Tiden til å jobbe var ganske liten og gruppen ble påvirket av sykdom i løpet av gruppen som hindret en del av selve arbeidet som en gruppe.

**Forbedringspunkter**
Inndeling av roler og prøve å inndele arbeid jevnt mellom gruppemedlemmene, slik at vi unngår en skjeiv fordeling i forhold til arbeids mengde per person. Jobbe med parkoding og bruke mer tid på å prøve å kode sammen som en gruppe.
