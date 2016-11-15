package UserInterface;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

import medizin.Verbindung;

public class VerknZusatz {
	
	public static Combo[] combo0 = new Combo[50];
	public static Combo[] combo1 = new Combo[50];
	public static Combo[] combo2 = new Combo[50];
	public static Combo[] combo3 = new Combo[50];
	public static Label[] lblJoin = new Label[50];
	
	public static void BoxBau2(Group group_Verknuepfungen)//Fehler bei der Schleife
	{
		for (int i =0; i<50;i++)
		{
			combo0[i] = new Combo(group_Verknuepfungen, SWT.READ_ONLY);
			combo0[i].setBounds(5, 74+(30*i), 170, 22);
			combo0[i].setVisible(false);
			
			//System.out.println(i);
			combo0[i].addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					
					System.out.println(((Combo)e.getSource()).getText());

				}
	      });
			
			combo1[i] = new Combo(group_Verknuepfungen, SWT.READ_ONLY);
			combo1[i].setBounds(175, 74+(30*i), 170, 22);
			combo1[i].setVisible(false);
			combo1[i].setEnabled(false);
			
			
			lblJoin[i] = new Label(group_Verknuepfungen, SWT.NONE);
			lblJoin[i].setBounds(360, 76+(30*i), 80, 22);
			lblJoin[i].setText("JOIN");
			lblJoin[i].setVisible(false);
			
			
			combo2[i] = new Combo(group_Verknuepfungen, SWT.READ_ONLY);
			combo2[i].setBounds(415, 74+(30*i), 170, 22);
			combo2[i].setVisible(false);
			combo0[i].addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					
					//System.out.println(combo.getText());

				}
			});
			
			combo3[i] = new Combo(group_Verknuepfungen, SWT.READ_ONLY);
			combo3[i].setBounds(585, 74+(30*i), 170, 22);
			combo3[i].setVisible(false);
			combo3[i].setEnabled(false);
			
		}
	}
	public static void BoxBau(Group group_Verknuepfungen)//Nur 10 Verknüpfungen
	{
		for (int i =0; i<50;i++)
		{
			combo0[i] = new Combo(group_Verknuepfungen, SWT.READ_ONLY);
			combo0[i].setBounds(5, 74+(30*(i+1)), 170, 22);
			combo0[i].setVisible(false);

			
			combo1[i] = new Combo(group_Verknuepfungen, SWT.READ_ONLY);
			combo1[i].setBounds(175, 74+(30*(i+1)), 170, 22);
			combo1[i].setVisible(false);
			combo1[i].setEnabled(false);
			
			
			lblJoin[i] = new Label(group_Verknuepfungen, SWT.NONE);
			lblJoin[i].setBounds(360, 76+(30*(i+1)), 80, 22);
			lblJoin[i].setText("JOIN");
			lblJoin[i].setVisible(false);
			
			
			combo2[i] = new Combo(group_Verknuepfungen, SWT.READ_ONLY);
			combo2[i].setBounds(415, 74+(30*(i+1)), 170, 22);
			combo2[i].setVisible(false);
			
			combo3[i] = new Combo(group_Verknuepfungen, SWT.READ_ONLY);
			combo3[i].setBounds(585, 74+(30*(i+1)), 170, 22);
			combo3[i].setVisible(false);
			combo3[i].setEnabled(false);
			
		}
		Listener();
		
		
	}

	private static void Listener()
	{
		combo0[0].addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				combo1[0].setEnabled(true);
				int zaehler = Verbindung.spalten("from "+ combo0[0].getText());
				combo1[0].setItems(Verbindung.Spaltenname2(combo0[0].getText(), zaehler));

			}
		 });
		
		combo2[0].addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				combo3[0].setEnabled(true);
				int zaehler = Verbindung.spalten("from "+ combo2[0].getText());
				combo3[0].setItems(Verbindung.Spaltenname2(combo2[0].getText(), zaehler));

			}
		 });
		
		//////////////////////////////////////////////////////////////////////
		combo0[1].addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				combo1[1].setEnabled(true);
				int zaehler = Verbindung.spalten("from "+ combo0[1].getText());
				combo1[1].setItems(Verbindung.Spaltenname2(combo0[1].getText(), zaehler));

			}
		 });
		combo2[1].addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				combo3[1].setEnabled(true);
				int zaehler = Verbindung.spalten("from "+ combo2[1].getText());
				combo3[1].setItems(Verbindung.Spaltenname2(combo2[1].getText(), zaehler));

			}
		 });
		
		//////////////////////////////////////////////////////////////////////
		combo0[2].addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				combo1[2].setEnabled(true);
				int zaehler = Verbindung.spalten("from "+ combo0[2].getText());
				combo1[2].setItems(Verbindung.Spaltenname2(combo0[2].getText(), zaehler));

			}
		 });
		combo2[2].addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				combo3[2].setEnabled(true);
				int zaehler = Verbindung.spalten("from "+ combo2[2].getText());
				combo3[2].setItems(Verbindung.Spaltenname2(combo2[2].getText(), zaehler));

			}
		 });
		
		
		//////////////////////////////////////////////////////////////////////
		combo0[3].addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				combo1[3].setEnabled(true);
				int zaehler = Verbindung.spalten("from "+ combo0[3].getText());
				combo1[3].setItems(Verbindung.Spaltenname2(combo0[3].getText(), zaehler));

			}
		 });
		combo2[3].addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				combo3[3].setEnabled(true);
				int zaehler = Verbindung.spalten("from "+ combo2[3].getText());
				combo3[3].setItems(Verbindung.Spaltenname2(combo2[3].getText(), zaehler));

			}
		 });
		

		
		//////////////////////////////////////////////////////////////////////
		combo0[4].addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				combo1[4].setEnabled(true);
				int zaehler = Verbindung.spalten("from "+ combo0[4].getText());
				combo1[4].setItems(Verbindung.Spaltenname2(combo0[4].getText(), zaehler));

			}
		 });
		combo2[4].addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				combo3[4].setEnabled(true);
				int zaehler = Verbindung.spalten("from "+ combo2[4].getText());
				combo3[4].setItems(Verbindung.Spaltenname2(combo2[4].getText(), zaehler));

			}
		 });
		

		
		//////////////////////////////////////////////////////////////////////
		combo0[5].addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				combo1[5].setEnabled(true);
				int zaehler = Verbindung.spalten("from "+ combo0[5].getText());
				combo1[5].setItems(Verbindung.Spaltenname2(combo0[5].getText(), zaehler));

			}
		 });
		combo2[5].addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				combo3[5].setEnabled(true);
				int zaehler = Verbindung.spalten("from "+ combo2[5].getText());
				combo3[5].setItems(Verbindung.Spaltenname2(combo2[5].getText(), zaehler));

			}
		 });

		
		//////////////////////////////////////////////////////////////////////
		combo0[6].addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				combo1[6].setEnabled(true);
				int zaehler = Verbindung.spalten("from "+ combo0[6].getText());
				combo1[6].setItems(Verbindung.Spaltenname2(combo0[6].getText(), zaehler));

			}
		 });
		
		combo2[6].addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				combo3[6].setEnabled(true);
				int zaehler = Verbindung.spalten("from "+ combo2[6].getText());
				combo3[6].setItems(Verbindung.Spaltenname2(combo2[6].getText(), zaehler));

			}
		 });

		
		//////////////////////////////////////////////////////////////////////
		combo0[7].addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				combo1[7].setEnabled(true);
				int zaehler = Verbindung.spalten("from "+ combo0[7].getText());
				combo1[7].setItems(Verbindung.Spaltenname2(combo0[7].getText(), zaehler));

			}
		 });
		combo2[7].addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				combo3[7].setEnabled(true);
				int zaehler = Verbindung.spalten("from "+ combo2[7].getText());
				combo3[7].setItems(Verbindung.Spaltenname2(combo2[7].getText(), zaehler));

			}
		 });

		
		//////////////////////////////////////////////////////////////////////
		combo0[8].addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				combo1[8].setEnabled(true);
				int zaehler = Verbindung.spalten("from "+ combo0[8].getText());
				combo1[8].setItems(Verbindung.Spaltenname2(combo0[8].getText(), zaehler));

			}
		 });
		combo2[8].addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				combo3[8].setEnabled(true);
				int zaehler = Verbindung.spalten("from "+ combo2[8].getText());
				combo3[8].setItems(Verbindung.Spaltenname2(combo2[8].getText(), zaehler));

			}
		 });

		
		//////////////////////////////////////////////////////////////////////
		combo0[9].addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				combo1[9].setEnabled(true);
				int zaehler = Verbindung.spalten("from "+ combo0[9].getText());
				combo1[9].setItems(Verbindung.Spaltenname2(combo0[9].getText(), zaehler));

			}
		 });
		combo2[9].addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				combo3[9].setEnabled(true);
				int zaehler = Verbindung.spalten("from "+ combo2[9].getText());
				combo3[9].setItems(Verbindung.Spaltenname2(combo2[9].getText(), zaehler));

			}
		 });
	
	}
	
	public static void speichern()
	{
		
		for (int i=0;i<50;i++)
		{
			if (combo0[i].isVisible())
			{
				medizin.Variablen.Verkn[i][0] = combo0[i].getText();
				medizin.Variablen.Verkn[i][1] = combo1[i].getText();
				medizin.Variablen.Verkn[i][3] = combo2[i].getText();
				medizin.Variablen.Verkn[i][4] = combo3[i].getText();
				
			}
		}
	    
	    
	}
	public static void laden()
	{
		for (int i=0;i<50;i++)
		{
			if(medizin.Variablen.Verkn[i][0]!= "")
			{
				combo0[i].setText(medizin.Variablen.Verkn[i][0]);
				combo1[i].setText(medizin.Variablen.Verkn[i][1]);
				combo2[i].setText(medizin.Variablen.Verkn[i][3]);
				combo3[i].setText(medizin.Variablen.Verkn[i][4]);
			}
			
		}


	}


}
