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
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.ScrollBar;
import org.eclipse.swt.widgets.CoolBar;

public class Verknuepfungen {
	
	private static Combo[] combo0 = new Combo[50];
	private static Combo[] combo1 = new Combo[50];
	private static Combo[] combo2 = new Combo[50];
	private static Combo[] combo3 = new Combo[50];
	private static Label[] lblJoin = new Label[50];
	
	private static int visible_zaehler = 1;
	private static int i = 0;
	
	
	private static Composite Verknuepfungen;
	public static void open(Shell shell)
	{
		Verknuepfungen = new Composite(shell, SWT.V_SCROLL);
		Verknuepfungen.setBounds(10, 10, 780, 527);
		Verknuepfungen.setVisible(false);
		
		final Group group_Verknuepfungen = new Group(Verknuepfungen, SWT.V_SCROLL);
		group_Verknuepfungen.setBounds(10, 10, 760, 507);
		group_Verknuepfungen.setText("Verknüpfungen:");
		

		for (i =0; i<50;i++)
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
		ScrollBar sb = Verknuepfungen.getVerticalBar();
		ScrollBar sb2 = group_Verknuepfungen.getVerticalBar();
		
		Button button = new Button(group_Verknuepfungen, SWT.NONE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if (visible_zaehler<49)
				{
					
					combo0[visible_zaehler].setVisible(true);
					//combo2.setEnabled(false);
					
					combo1[visible_zaehler].setVisible(true);
					
					lblJoin[visible_zaehler].setVisible(true);
					

					combo2[visible_zaehler].setVisible(true);
					//combo2.setEnabled(false);
					

					combo3[visible_zaehler].setVisible(true);
					
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
					combo0[visible_zaehler].setVisible(false);
					combo1[visible_zaehler].setVisible(false);
					lblJoin[visible_zaehler].setVisible(false);
					combo2[visible_zaehler].setVisible(false);
					combo3[visible_zaehler].setVisible(false);
					
					
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
		combo0[0].setVisible(true);
		combo1[0].setVisible(true);
		lblJoin[0].setVisible(true);
		combo2[0].setVisible(true);
		combo3[0].setVisible(true);
		
	}

	public static void initialisieren(String [] Tabellennamen)
	{
		for (int i=0;i<49;i++)
		{
			combo0[i].setItems(Tabellennamen);
			combo2[i].setItems(Tabellennamen);
		}
	}
	public static void speichern()
	{
		//TODO
		
		Variablen.laden_1=true;
	}
	
	public static void laden()
	{
		//TODO

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
