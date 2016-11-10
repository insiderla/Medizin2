package UserInterface;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Shell;

import medizin.Verbindung;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;


public class Allgemein {
	
	static Button btnWeiter;
	static Button btnZurck;
	
	public static void open(Shell shell)
	{
		btnWeiter = new Button(shell, SWT.NONE);
		btnWeiter.setBounds(596, 540, 94, 28);
		btnZurck = new Button(shell, SWT.NONE);
		btnZurck.setBounds(496, 540, 94, 28);
		btnWeiter.addMouseListener(new MouseAdapter() { //WEITER
			@Override
			public void mouseDown(MouseEvent e) {
				
				Variablen.Zaehler_Windows++;
				if (Variablen.Zaehler_Windows==2)
				{
					Datenbank.speichern();
					Datenbank.visible_false();
					if (Variablen.laden_1==true)
					{
						Verknuepfungen.laden();
					}
					if (Variablen.laden_1==false)
					{
						Verbindung.anzahl();
						//System.out.println(medizin.Variablen.anzahl_Tabellen);
						String [] table = new String [medizin.Variablen.anzahl_Tabellen];
						table = medizin.Verbindung.Tabellennamen(table);
						//System.out.println(table[0]);
						Verknuepfungen.initialisieren(table);
					}
					Verknuepfungen.visible_true();
					
				}
				if (Variablen.Zaehler_Windows==3)
				{
					Verknuepfungen.speichern();
					Verknuepfungen.visible_false();
					if (Variablen.laden_2==true)
					{
						Spalten.laden();
					}
					Spalten.visible_true();
				}
				if (Variablen.Zaehler_Windows==4)
				{
					Spalten.visible_false();
					Spalten.speichern();
					if (Variablen.laden_3==true)
					{
						Speicherort.laden();
					}
					Speicherort.visible_true();
					btnWeiter.setText("Fertig");
				}
				if (Variablen.Zaehler_Windows==5)
				{
					medizin.Programm.start();
					//Error.open2("Fertig");
					System.exit(0);
				}
				btnZurck.setEnabled(true);
				
			}
		});
		btnWeiter.setText("Weiter");
		btnWeiter.setEnabled(false);
		
		
		btnZurck.addMouseListener(new MouseAdapter() {  //ZURÜCK
			@Override
			public void mouseDown(MouseEvent e) {
				
				/*
				 * medizin.Variablen.Zaehler_Windows--;
				
				if (medizin.Variablen.Zaehler_Windows==1)
				{
					lesen.Datenbank();
					composite_Datenbank.setVisible(true);
					composite_Verknuepfungen.setVisible(false);
					btnZurck.setEnabled(false);
				}
				if (medizin.Variablen.Zaehler_Windows==2)
				{
					composite_Verknuepfungen.setVisible(true);
					composite_Spalten.setVisible(false);
				}
				if (medizin.Variablen.Zaehler_Windows==3)
				{
					composite_Spalten.setVisible(true);
					composite_Datei.setVisible(false);
					btnWeiter.setText("Weiter");
				}
				 */
			}
		});
		btnZurck.setText("Zurück");
		btnZurck.setEnabled(false);
		
		Button btnAbbrechen = new Button(shell, SWT.NONE);
		btnAbbrechen.setBounds(696, 540, 94, 28);
		btnAbbrechen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				System.exit(0);
			}
		});
		btnAbbrechen.setText("Abbrechen");
		

	}
	public static void enable_Weiter()
	{
		btnWeiter.setEnabled(true);
	}
	public static void disable_Weiter()
	{
		btnWeiter.setEnabled(false);
	}
	public static void enable_Zurueck()
	{
		btnZurck.setEnabled(true);
	}
	public static void disable_Zurueck()
	{
		btnZurck.setEnabled(false);
	}

}
