package Datenbank;

public class Speichern {
	
	public static void Datenbank()
	{
		medizin.Variablen.VDaten[0] = Window.txt_DBServer.getText();
		medizin.Variablen.VDaten[1] = Window.txt_DBPort.getText();
	    medizin.Variablen.VDaten[2] = Window.txt_DBName.getText();
	    medizin.Variablen.VDaten[3] = Window.txt_DBBenutzer.getText();
	    medizin.Variablen.VDaten[4] = Window.txt_DBPasswort.getText();
	    
	}

}
