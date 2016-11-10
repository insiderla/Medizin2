package UserInterface;


public class Speichern {
	
	public static void Datenbank()
	{
		medizin.Variablen.VDaten[0] = Variablen.txt_DBServer.getText();
		medizin.Variablen.VDaten[1] = Variablen.txt_DBPort.getText();
	    medizin.Variablen.VDaten[2] = Variablen.txt_DBName.getText();
	    medizin.Variablen.VDaten[3] = Variablen.txt_DBBenutzer.getText();
	    medizin.Variablen.VDaten[4] = Variablen.txt_DBPasswort.getText();
	    
	}

}
