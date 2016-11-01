package Datenbank;

public class lesen {
	
	public static void Datenbank()
	{
		Window.txt_DBServer.setText(medizin.Variablen.VDaten[0]);
		Window.txt_DBPort.setText(medizin.Variablen.VDaten[1]);
		Window.txt_DBName.setText(medizin.Variablen.VDaten[2]);
		Window.txt_DBBenutzer.setText(medizin.Variablen.VDaten[3]);
		Window.txt_DBPasswort.setText(medizin.Variablen.VDaten[4]);
	}

}
