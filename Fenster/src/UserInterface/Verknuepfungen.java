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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import medizin.Verbindung;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.CoolBar;

public class Verknuepfungen {
	
	//private static Combo[] combo0 = new Combo[50];
	//private static Combo[] combo1 = new Combo[50];
	//private static Combo[] combo2 = new Combo[50];
	//private static Combo[] combo3 = new Combo[50];
	//private static Label[] lblJoin = new Label[50];
	private static Combo combi1;
	private static Combo combi2;
	
	private static int visible_zaehler = 1;
	
	
	private static Composite Verknuepfungen;
	public static void open(Shell shell)
	{
		Verknuepfungen = new Composite(shell, SWT.V_SCROLL);
		Verknuepfungen.setBounds(10, 10, 780, 527);
		Verknuepfungen.setVisible(false);
		
		final Group group_Verknuepfungen = new Group(Verknuepfungen, SWT.V_SCROLL);
		group_Verknuepfungen.setBounds(10, 10, 760, 507);
		group_Verknuepfungen.setText("Verknüpfungen:");
		
		combi1 = new Combo(group_Verknuepfungen, SWT.READ_ONLY);
		combi1.setBounds(5, 64, 170, 22);
		combi1.setVisible(true);
		
		combi2 = new Combo(group_Verknuepfungen, SWT.READ_ONLY);
		combi2.setBounds(175, 64, 170, 22);
		combi2.setVisible(true);
		combi2.setEnabled(false);
		
		combi1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				combi1.setEnabled(true);
				int zaehler = Verbindung.spalten("from "+ combi1.getText());
				combi2.setItems(Verbindung.Spaltenname2(combi1.getText(), zaehler));
				combi2.setEnabled(true);

			}
		 });
		
		
		
		Label Primärschlüssel = new Label(group_Verknuepfungen, SWT.NONE);
		Primärschlüssel.setBounds(360, 66, 200, 22);
		Primärschlüssel.setText("Primärschlüssel");
		Primärschlüssel.setVisible(true);
		
		VerknZusatz.BoxBau(group_Verknuepfungen);
	
		
		Button button = new Button(group_Verknuepfungen, SWT.NONE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if (visible_zaehler<49)
				{
					
					VerknZusatz.combo0[visible_zaehler].setVisible(true);
					//combo2.setEnabled(false);
					
					VerknZusatz.combo1[visible_zaehler].setVisible(true);
					
					VerknZusatz.lblJoin[visible_zaehler].setVisible(true);
					

					VerknZusatz.combo2[visible_zaehler].setVisible(true);
					//combo2.setEnabled(false);
					

					VerknZusatz.combo3[visible_zaehler].setVisible(true);
					
					visible_zaehler++;
				}
				else
				{System.out.println("Maximum erreicht!");}
				
				
				Display.getCurrent().getActiveShell().redraw();
				Display.getCurrent().update();
				Display.getCurrent().getActiveShell().layout();
			}
		});
		button.setBounds(10, 10, 94, 28);
		button.setText("+");
		
		Button button_1 = new Button(group_Verknuepfungen, SWT.NONE);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if (visible_zaehler!=1)
				{
					visible_zaehler--;
					VerknZusatz.combo0[visible_zaehler].setVisible(false);
					VerknZusatz.combo1[visible_zaehler].setVisible(false);
					VerknZusatz.lblJoin[visible_zaehler].setVisible(false);
					VerknZusatz.combo2[visible_zaehler].setVisible(false);
					VerknZusatz.combo3[visible_zaehler].setVisible(false);
					
					
				}
				else
				{System.out.println("Minimum erreicht!");}
				
				
				Display.getCurrent().getActiveShell().redraw();
				Display.getCurrent().update();
				Display.getCurrent().getActiveShell().layout();
			}
		});
		button_1.setBounds(110, 10, 94, 28);
		button_1.setText("-");
		VerknZusatz.combo0[0].setVisible(true);
		VerknZusatz.combo1[0].setVisible(true);
		VerknZusatz.lblJoin[0].setVisible(true);
		VerknZusatz.combo2[0].setVisible(true);
		VerknZusatz.combo3[0].setVisible(true);
		
	}

	public static void initialisieren(String [] Tabellennamen)
	{
		combi1.setItems(Tabellennamen);
		for (int i=0;i<49;i++)
		{
			VerknZusatz.combo0[i].setItems(Tabellennamen);
			VerknZusatz.combo2[i].setItems(Tabellennamen);
		}
	}
	
	public static void speichern()
	{
		medizin.Variablen.Primärschlüssel[0] = combi1.getText();
		medizin.Variablen.Primärschlüssel[1] = combi2.getText();
		
		
		for (int i=0;i<50;i++)
		{
			if (VerknZusatz.combo0[i].isVisible())
			{
				medizin.Variablen.Verkn[i][0] = VerknZusatz.combo0[i].getText();
				medizin.Variablen.Verkn[i][1] = VerknZusatz.combo1[i].getText();
				medizin.Variablen.Verkn[i][3] = VerknZusatz.combo2[i].getText();
				medizin.Variablen.Verkn[i][4] = VerknZusatz.combo3[i].getText();
				
			}
		}
		Variablen.laden_1=true;
	    
	    
	}
	public static void laden()
	{
		for (int i=0;i<50;i++)
		{
			VerknZusatz.combo0[i].setVisible(false);
			VerknZusatz.combo1[i].setVisible(false);
			VerknZusatz.combo2[i].setVisible(false);
			VerknZusatz.combo3[i].setVisible(false);
			
			if(medizin.Variablen.Verkn[i][0]!= "")
			{
				VerknZusatz.combo0[i].setText(medizin.Variablen.Verkn[i][0]);
				VerknZusatz.combo1[i].setText(medizin.Variablen.Verkn[i][1]);
				VerknZusatz.combo2[i].setText(medizin.Variablen.Verkn[i][3]);
				VerknZusatz.combo3[i].setText(medizin.Variablen.Verkn[i][4]);
				VerknZusatz.combo0[i].setVisible(true);
				VerknZusatz.combo1[i].setVisible(true);
				VerknZusatz.combo2[i].setVisible(true);
				VerknZusatz.combo3[i].setVisible(true);
				
			}
			
		}


	}


	public static void visible_true()
	{
		Verknuepfungen.setVisible(true);
	}
	public static void visible_false()
	{
		Verknuepfungen.setVisible(false);
	}

}
