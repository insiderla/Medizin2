package medizin;



public class Programm {
	
public static void laden(){

	//BeispielDaten laden
	Beispiel.Datenbank();
	Beispiel.Pfad();

    Beispiel.Primärschlüssel();
    Beispiel.Verknüpfungen();
}

public static void start() {
        laden();       
//SQL_Befehl_back

        String SQL = Befehl.SQL_hinten(Variablen.Primärschlüssel, Variablen.Verkn);
        //System.out.println("hinterer SQL-Befehl teil:");
        //System.out.println(SQL);
    
        
 //Verbindung
        
///Wie viele Tabellen
        int AnzahlTabellen = Verbindung.anzahl();
        System.out.println("Tabellenanzahl: "+ AnzahlTabellen);
        
//Array Tabellennamen initialisieren
        String [] ArrayTabellennamen = new String [AnzahlTabellen]; 
        
      
//Tabellennamen
        System.out.println("Tabellen vorhanden:");
        ArrayTabellennamen = Verbindung.Tabellennamen(ArrayTabellennamen);
        for(int k=0;k<AnzahlTabellen;k++)
        {
            System.out.print(ArrayTabellennamen[k]+"|");
        }
        System.out.println();

        
           
// Wie viele Zeilen und Spalten
        int AnzahlZeilen = Verbindung.zeilen(SQL);
        System.out.println("Anzahl Zeilen Gesamt: "+AnzahlZeilen);
        int AnzahlSpalten = Verbindung.spalten(SQL);
        System.out.println("Anzahl Spalten Gesamt: "+AnzahlSpalten);
        int AnzahlZeilenGroup = Verbindung.zeilenGroup(SQL,Variablen.Primärschlüssel);
        System.out.println("Anzahl Zeilen Gruppiert: "+AnzahlZeilenGroup);

// Spaltennamen auslesen
        int BSP=1;
        String [][] Namen = new String [Variablen.Vergleichdaten.length][AnzahlSpalten];
        String [] []Spaltennamen = new String[(Variablen.Vergleichdaten.length*AnzahlSpalten)][3];
        int zaehler=0;
        for (int k=0;k<Spaltennamen.length;k++)
        {
            Spaltennamen[k][1]="3";
            Spaltennamen[k][2]=null;
        }
        for(int k = 0;Variablen.Vergleichdaten[k] != null;k++)
        {
            Namen[k] = Verbindung.Spaltenname(Variablen.Vergleichdaten[k], Namen[k]);
            
        } 
        for(int k = 0;Namen[k][0]!=null;k++)
        {
            for (int m=0;Namen[k][m]!=null;m++)
            {
                
                Spaltennamen[zaehler][0]=Namen[k][m];
                System.out.print(Spaltennamen[zaehler][0]+", ");
                zaehler++;
            }
            
            
                
        }
        System.out.println();
//Bsp.: Spaltendaten laden
        if(BSP==1)
        {
        Spaltennamen[0][1]="1";
        Spaltennamen[1][1]="1";
        Spaltennamen[2][1]="1";
        Spaltennamen[3][1]="3";
        Spaltennamen[4][1]="2";
        Spaltennamen[5][1]="3";
        Spaltennamen[6][1]="2";
        Spaltennamen[7][1]="2";
        Spaltennamen[8][1]="2";
        
        Spaltennamen[0][2]="Matrikelnummer";
        Spaltennamen[1][2]="Name";
        Spaltennamen[2][2]="Semester";
        //Spaltennamen[3][2]="3";
        //Spaltennamen[4][2]="2";
        //Spaltennamen[5][2]="3";
        //Spaltennamen[6][2]="2";
        //Spaltennamen[7][2]="2";
        //Spaltennamen[8][2]="2";
        }
        if(BSP==2)
        {
        Spaltennamen[0][1]="1";
        Spaltennamen[1][1]="1";
        Spaltennamen[2][1]="1";
        Spaltennamen[3][1]="1";
        Spaltennamen[4][1]="2";
        Spaltennamen[5][1]="2";
        Spaltennamen[6][1]="2";
        Spaltennamen[7][1]="3";
        }
//Array Daten initialisieren
        //String [][] Daten = new String [AnzahlZeilen+1][AnzahlSpalten];
        //Daten = Verbindung.Daten_holen(Daten,SQL);
        int Schluesselanzahl = Verbindung.Schluesselanzahl(SQL, Variablen.Primärschlüssel);
        String Schluessel [] = new String [Schluesselanzahl];
        Schluessel = Verbindung.Schlusselnamen(SQL,Schluessel, Variablen.Primärschlüssel);
        
        System.out.println("Fertig!!!!");
        // Array füllen
        
        //Verbindung.oeffnen();
        
//Datei schreiben
        
        try{Verbindung.schreiben(SQL,Spaltennamen,AnzahlSpalten,AnzahlZeilenGroup,Variablen.Pfad,Schluessel,Variablen.Primärschlüssel);}
        catch(Exception e)
        {System.out.println("***** FEHLERMELDUNG *****"+e);}
        
        
    }

}
