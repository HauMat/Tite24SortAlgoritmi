# Harjoitustyö Raportti

## Työn eteneminen
Aloitin työn tekemisen kopioimalla tarvittavat Sort algoritmit https://www.geeksforgeeks.org sivustolta.
Aloin heti pohtimaan, kuinka saan mitattua kuluneen ajan. Tämän pohjalta päädyin tekemään TimeTest() funktion, jota päivitin koko harjoitustyön ajan.
Toimivan funktion jälkeen tein funktiot nousevalla ja laskevalle taulukolle. Kirjoitin mainiin usean TimeTest() funktion ja sen jälkeen println(), jossa tulostan saadun ajan.
Testasin ohjelmaa ja minua alkoi epäiyttämään saadut tulokset.
Päädyin tutkimaan asiaa tekoälyn avulla ja päädyin lisäämään koodia, joka pyrkii estämään koodin ylioptimoinnin.

## Ohjelman toiminta
TimeTest() funktio ottaa parametreinä käytettävän funktion ja taulukon.
Taulukko kloonataan funktion sisällä, jotta muut käyttökerrat saavat saman datan.
Funktion sisällä kloonia pääsee käyttämään ja muokkaamaan kutsuttu Sorting algoritmi funktio.
Käytetään funktiota .apply() komennolla.
Ennen sorting algoritmi funktiota otetaan aloitusaika ja funktion päätyttyä otetaan lopetusaika. 
Aikojen erotuksella saadaan sorting algoritmiin kulunut aika, joka palautetaan ohjelman käyttöön.

Funktion sisällä pyritään käyttämään tulosta, joka muuttaa funktion ulkopuolella olevaa kohde muuttujaa.
Nyt algoritmi funktioita käytettäessä funktion ulkopuolella oleva muuttuja on riippuvainen funktion tuloksesta, jolloin .apply komennon tuloksia ei optimoida pois.
Tämä ymmärtääkseni vähentää JIT:n ja DCE:n tuottamia häiriöitä nousevia ja laskevia taulukkoja järjestettäessä.

Mainin alussa määritellään size muuttuja, jolla määritellään tehtävien taulukkojen koot.
Kopiota käytettäessä kaikki funktiot käyttävät samaa taulukkoa, millä vältetään kummallisia heittoja saaduilla tuloksilla.
Main funktio on täynnä turhaa println() koodia, jonka olisi järkevästi lisätä funktioiden sisälle.

## Tulokset
Mittasin aikoja N arvoilla 10,000 ja 500,000. 
Molemmilla N arvoilla runnasin koodin 5 kertaa, jotta saan laskettua keskiarvon ja mediaanin.
Kopioin tulokset data tekstitiedostoon, jonka pohjalta tein excel taulukon.
Excel taulukossa on vähemmän turhaa tekstiä ja lasken siellä keskiarvon sekä mediaanin.
Osa ajoista näyttää hurjan nopeilta, mutta oletan tämän johtuvan pelikoneellani tehdystä harjoituksesta.
### Hiturit
N arvolla 500 000 nähdään välittömästi, kuinka insertion- ja bubble sort ovat molemmat erittäin hitaita verrattuna tehokkaampiin algoritmeihin. 
Harjoitusta tehtäessä näiden 2 algoritmin takia jouduin odottamaan useita minuutteja arvoja kerätessä.

### Kiiturit
Quick-, Merge-, Shell- ja Array sort suoriutuivat tehokkaasti, jopa suurelta tuntuvalla N arvolla 500 000.
Satunnaisessa tilanteessa javan Array sort toistuvasti on hitaampi, kuin muut nopeat algortmit. Tämä silti suorittaa tehtävän tehokkaasti.
Vaikea sanoa mitä kaikkia hienoja asioita helppokäyttöinen Array.sort sisältää, kun se yllättäen päihittää laskevassa ja nousevassa taulukossa Merge- ja Shell sortin.
Nopeimpana näkyy Quick sort
### Quick sort
Nopea
### Merge sort
Nopea
### Shell sort
Nopea
### Array sort
Nopea

| N  = 10 000                  |            |            |
|------------------------------|------------|------------|
|     Random taulu tulokset:   | Keskiarvo s| Mediaani s |
|     Insertion sort time:     | 0,02579108 | 0,02584680 |
|     Bubble sort time:        | 0,03574816 | 0,03553030 |
|     Quick sort time:         | 0,00122492 | 0,00120100 |
|     Merge sort time:         | 0,00170090 | 0,00161220 |
|     Shell sort time:         | 0,00322092 | 0,00321680 |
|     Array sort time:         | 0,00323596 | 0,00327250 |
|                              |            |            |
|     Nousevan taulun tulokset |            |            |
|     Insertion sort time:     | 0,00004086 | 0,00004030 |
|     Bubble sort time:        | 0,00007232 | 0,00007170 |
|     Quick sort time:         | 0,00009876 | 0,00009360 |
|     Merge sort time:         | 0,00084146 | 0,00084060 |
|     Shell sort time:         | 0,00038904 | 0,00044210 |
|     Array sort time:         | 0,00016242 | 0,00016240 |
|                              |            |            |
|     Laskevan taulun tulokset |            |            |
|     Insertion sort time:     | 0,05212068 | 0,05186690 |
|     Bubble sort time:        | 0,01765012 | 0,01742510 |
|     Quick sort time:         | 0,00010224 | 0,00009750 |
|     Merge sort time:         | 0,00037702 | 0,00038620 |
|     Shell sort time:         | 0,00030646 | 0,00027680 |
|     Array sort time:         | 0,00031514 | 0,00031710 |

| N = 500 000                  |              |              |
|------------------------------|--------------|--------------|
|     Random taulu tulokset:   | Keskiarvo s  | Mediaani  s  |
|     Insertion sort time:     | 45,76575536  | 46,00837380  |
|     Bubble sort time:        | 224,90750194 | 227,48120200 |
|     Quick sort time:         | 0,04539280   | 0,04582490   |
|     Merge sort time:         | 0,06100566   | 0,06402480   |
|     Shell sort time:         | 0,06221784   | 0,06243980   |
|     Array sort time:         | 0,12324730   | 0,12502070   |
|                              |              |              |
|     Nousevan taulun tulokset |              |              |
|     Insertion sort time:     | 0,00264234   | 0,00194840   |
|     Bubble sort time:        | 0,00036384   | 0,00037160   |
|     Quick sort time:         | 0,00792690   | 0,00892970   |
|     Merge sort time:         | 0,02004166   | 0,01954140   |
|     Shell sort time:         | 0,01076812   | 0,01066820   |
|     Array sort time:         | 0,00315710   | 0,00326650   |
|                              |              |              |
|     Laskevan taulun tulokset |              |              |
|     Insertion sort time:     | 103,28817346 | 104,45245940 |
|     Bubble sort time:        | 42,51569178  | 42,48818840  |
|     Quick sort time:         | 0,00607720   | 0,00576170   |
|     Merge sort time:         | 0,02562786   | 0,02352740   |
|     Shell sort time:         | 0,01238554   | 0,01173780   |
|     Array sort time:         | 0,00230974   | 0,00240010   |



## Testiympäristö

Harjoitustyö on tehty itse rakennetulla pelaamiseen tarkoitetulla pöytätietokomeella.
Tiedot on kopioitu reposta löytyvästä Systeminfo.txt tiedostosta.
Tiedosto on tehty dxdiag komennolla, josta poistin ylimääräisen/yksityisen tiedon.

------------------
System Information
------------------
         Operating System: Windows 11 Pro 64-bit (10.0, Build 26100) (26100.ge_release.240331-1435)
                 Language: English (Regional Setting: English)
      System Manufacturer: ASUS
             System Model: System Product Name
                     BIOS: 3621 (type: UEFI)
                Processor: AMD Ryzen 7 5800X 8-Core Processor              (16 CPUs), ~4.2GHz
                   Memory: 16384MB RAM
      Available OS Memory: 16292MB RAM
