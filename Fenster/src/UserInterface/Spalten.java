package UserInterface;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import medizin.Befehl;
import medizin.Beispiel;
import medizin.Variablen;
import medizin.Verbindung;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.CoolBar;

public class Spalten {
	
	
	public static Label[] namen = new Label [50]; 
	public static Button[] checkButton1 = new Button [50];
	public static Button[] checkButton2 = new Button [50];
	public static Text[] namen_aendern = new Text[50];
	
	private static Composite Spalten;
	public static void open(Shell shell)
	{
		Spalten = new Composite(shell, SWT.NONE);
		Spalten.setBounds(10, 10, 780, 527);
		Spalten.setVisible(false);
		
		Group group_Spalten = new Group(Spalten, SWT.NONE);
		group_Spalten.setBounds(10, 10, 760, 507);
		group_Spalten.setText("Spalteneinstellungen");
		
		Label Namen = new Label(group_Spalten, SWT.NONE);
		Namen.setBounds(5, 10, 200, 22);
		Namen.setText("Spaltennamen:");
		Namen.setVisible(true);
		
		Label Checkbox1 = new Label(group_Spalten, SWT.NONE);
		Checkbox1.setBounds(205, 10, 200, 22);
		Checkbox1.setText("Hauptspalten:");
		Checkbox1.setVisible(true);
		
		Label Checkbox2 = new Label(group_Spalten, SWT.NONE);
		Checkbox2.setBounds(405, 10, 200, 22);
		Checkbox2.setText("Andere Spalten:");
		Checkbox2.setVisible(true);
		
		Label Namen_aendern = new Label(group_Spalten, SWT.NONE);
		Namen_aendern.setBounds(605, 10, 300, 22);
		Namen_aendern.setText("Spaltenname ändern:");
		Namen_aendern.setVisible(true);
		
		BoxBau(group_Spalten);
		
		
		
				
	   
		
	}
	public static void BoxBau(Group group_Verknuepfungen)//Nur 10 Verknüpfungen
	{
		for (int i =0; i<50;i++)
		{
			
			namen[i] = new Label(group_Verknuepfungen, SWT.READ_ONLY);
			namen[i].setBounds(5, 34+(30*(i+1)), 200, 22);
			namen[i].setText("");
			namen[i].setVisible(false);
			
			
			checkButton1[i] = new Button(group_Verknuepfungen, SWT.CHECK);
			checkButton1[i].setBounds(245,34+(30*(i+1)),20, 20);;
		    checkButton1[i].setVisible(false);
		    
		    checkButton2[i] = new Button(group_Verknuepfungen, SWT.CHECK);
			checkButton2[i].setBounds(445,34+(30*(i+1)),20, 20);;
		    checkButton2[i].setVisible(false);
		    
		    namen_aendern[i] = new Text(group_Verknuepfungen, SWT.BORDER);
		    namen_aendern[i].setBounds(555,34+(30*(i+1)), 200, 22);
		    namen_aendern[i].setText("");
		    namen_aendern[i].setVisible(false);
		    
			/*
			
			
			combo3[i] = new Combo(group_Verknuepfungen, SWT.READ_ONLY);
			combo3[i].setBounds(585, 74+(30*(i+1)), 170, 22);
			combo3[i].setVisible(false);
			combo3[i].setEnabled(false);
			*/
			if (UserInterface.Variablen.Spaltennamen[i][0]!=null)
			{
				namen[i].setVisible(true);
				
			}
			
		}
			
		}
	public static void speichern()
	{
		//TODO
		
		UserInterface.Variablen.laden_2 = true;
	}
	
	public static void laden()
	{
		UserInterface.Variablen.Spaltennamen[0][1]="1";
		UserInterface.Variablen.Spaltennamen[1][1]="1";
		UserInterface.Variablen.Spaltennamen[2][1]="1";
		UserInterface.Variablen.Spaltennamen[3][1]="3";
		UserInterface.Variablen.Spaltennamen[4][1]="2";
		UserInterface.Variablen.Spaltennamen[5][1]="3";
		UserInterface.Variablen.Spaltennamen[6][1]="2";
		UserInterface.Variablen.Spaltennamen[7][1]="2";
		UserInterface.Variablen.Spaltennamen[8][1]="2";
        
		UserInterface.Variablen.Spaltennamen[0][2]="Matrikelnummer";
		UserInterface.Variablen.Spaltennamen[1][2]="Name";
		UserInterface.Variablen.Spaltennamen[2][2]="Semester";
		for (int i =0; i<50;i++)
		{
			
			if (UserInterface.Variablen.Spaltennamen[i][0]!=null)
			{
				namen[i].setText(UserInterface.Variablen.Spaltennamen[i][0]);
				namen[i].setVisible(true);
				
				if (UserInterface.Variablen.Spaltennamen[i][1] == "1")
				{
					checkButton1[i].setSelection(true);
				}
				checkButton1[i].setVisible(true);
				
				if (UserInterface.Variablen.Spaltennamen[i][1] == "2")
				{
					checkButton2[i].setSelection(true);
				}
				checkButton2[i].setVisible(true);
				if(UserInterface.Variablen.Spaltennamen[i][2]!=null)
				{
					namen_aendern[i].setText(UserInterface.Variablen.Spaltennamen[i][2]);
				}
				namen_aendern[i].setVisible(true);
				
				
			}
		}
		


	}
	public static void visible_true()
	{
		Spalten.setVisible(true);
	}
	public static void visible_false()
	{
		Spalten.setVisible(false);
	}
	public static void initialisieren()
	{
		String SQL = Befehl.SQL_hinten(Variablen.Primärschlüssel, Variablen.Verkn);
		int AnzahlSpalten = Verbindung.spalten(SQL);
        System.out.println("Anzahl Spalten Gesamt: "+AnzahlSpalten);
        String [][] Namen = new String [Variablen.Vergleichdaten.length][AnzahlSpalten];
        //UserInterface.Variablen.Spaltennamen = new String[(Variablen.Vergleichdaten.length*AnzahlSpalten)][3];
        int zaehler=0;
        for (int k=0;k<UserInterface.Variablen.Spaltennamen.length;k++)
        {
        	UserInterface.Variablen.Spaltennamen[k][1]="3";
        	UserInterface.Variablen.Spaltennamen[k][2]=null;
        }
        for(int k = 0;Variablen.Vergleichdaten[k] != null;k++)
        {
            Namen[k] = Verbindung.Spaltenname(Variablen.Vergleichdaten[k], Namen[k]);
            
        } 
        for(int k = 0;Namen[k][0]!=null;k++)
        {
            for (int m=0;Namen[k][m]!=null;m++)
            {
                
            	UserInterface.Variablen.Spaltennamen[zaehler][0]=Namen[k][m];
                System.out.print(UserInterface.Variablen.Spaltennamen[zaehler][0]+", ");
                zaehler++;
            }
            
            
                
        }
        
        
        System.out.println("\n");
	}
}
