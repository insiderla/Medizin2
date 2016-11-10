package Datenbank;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.CoolBar;

public class Window {

	protected Shell shell;

	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Window window = new Window();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(800, 600);
		shell.setText("MySQL to ARX");
		shell.setLayout(null);
		
		Button btnAbbrechen = new Button(shell, SWT.NONE);
		btnAbbrechen.setBounds(696, 540, 94, 28);
		btnAbbrechen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				System.exit(0);
			}
		});
		btnAbbrechen.setText("Abbrechen");
		
		final Composite composite_Datenbank = new Composite(shell, SWT.NONE);
		composite_Datenbank.setBounds(10, 10, 780, 527);
		composite_Datenbank.setVisible(true);
		
		Group group_Datenbank = new Group(composite_Datenbank, SWT.NONE);
		group_Datenbank.setBounds(10, 10, 760, 507);
		group_Datenbank.setText("Datenbankeinstellungen");
		
		Label lblServer = new Label(group_Datenbank, SWT.NONE);
		lblServer.setBounds(30, 30, 100, 14);
		lblServer.setText("Server:");
		
		Label lblPort = new Label(group_Datenbank, SWT.NONE);
		lblPort.setBounds(30, 60, 100, 14);
		lblPort.setText("Port:");
		
		Label lblDBName = new Label(group_Datenbank, SWT.NONE);
		lblDBName.setBounds(30, 90, 100, 14);
		lblDBName.setText("Datenbankname:");
		
		Label lblDBBenutzer = new Label(group_Datenbank, SWT.NONE);
		lblDBBenutzer.setBounds(30, 120, 100, 14);
		lblDBBenutzer.setText("Benutzer:");
		
		Label lblDBPasswort = new Label(group_Datenbank, SWT.NONE);
		lblDBPasswort.setBounds(30, 150, 100, 14);
		lblDBPasswort.setText("Passwort:");
		
		txt_DBServer = new Text(group_Datenbank, SWT.BORDER);
		txt_DBServer.setBounds(136, 27, 250, 19);
		txt_DBServer.setText("localhost");
		
		txt_DBPort = new Text(group_Datenbank, SWT.BORDER);
		txt_DBPort.setBounds(136, 57, 250, 19);
		txt_DBPort.setText("3306");
		
		txt_DBName = new Text(group_Datenbank, SWT.BORDER);
		txt_DBName.setBounds(136, 87, 250, 19);
		txt_DBName.setText("Test");
		
		txt_DBBenutzer = new Text(group_Datenbank, SWT.BORDER);
		txt_DBBenutzer.setBounds(136, 117, 250, 19);
		txt_DBBenutzer.setText("root");
		
		txt_DBPasswort = new Text(group_Datenbank, SWT.BORDER);
		txt_DBPasswort.setBounds(136, 147, 250, 19);
		txt_DBPasswort.setText("");
		
		Button btnVerbindungTesten = new Button(group_Datenbank, SWT.NONE);
		btnVerbindungTesten.setBounds(136, 200, 250, 28);
		btnVerbindungTesten.setText("Verbindung testen");
		
		final Label lblVerbindungOK = new Label(group_Datenbank, SWT.NONE);
		lblVerbindungOK.setBounds(136, 234, 581, 149);
		lblVerbindungOK.setText("Verbindung OK");
		lblVerbindungOK.setVisible(false);
		
		final Composite composite_Verknuepfungen = new Composite(shell, SWT.NONE);
		composite_Verknuepfungen.setBounds(10, 10, 780, 527);
		composite_Verknuepfungen.setVisible(false);
		
		Group group_Verknuepfungen = new Group(composite_Verknuepfungen, SWT.NONE);
		group_Verknuepfungen.setBounds(10, 10, 760, 507);
		group_Verknuepfungen.setText("Verknüpfungen");   
		
		table = new Table(group_Verknuepfungen, SWT.BORDER | SWT.MULTI);
		table.setBounds(10, 10, 650, 460);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		for (int i = 0; i < 6; i++) {
		      TableColumn column = new TableColumn(table, SWT.NONE);
		      column.setWidth(150);
		      if (i==2)
		      {
		    	  column.setWidth(50);
		      }
		}
		
		//table.getColumn(2).setAlignment(SWT.RIGHT);
		for (int i = 0; i < 12; i++) {
		      new TableItem(table, SWT.NONE);
		    }
		TableItem[] items = table.getItems();
	      for (int i = 0; i < items.length; i++) {
	        TableEditor editor = new TableEditor(table);
	        CCombo combo_Tabelle = new CCombo(table, SWT.NONE);
	        combo_Tabelle.setText("Tabellen auswahl");
	        combo_Tabelle.add("item 1");
	        combo_Tabelle.add("item 2");
	        combo_Tabelle.add("Modify1");
	        editor.grabHorizontal = true;
	        editor.setEditor(combo_Tabelle, items[i], 0);
	        
	        editor = new TableEditor(table);
	        CCombo combo_Spalte = new CCombo(table, SWT.NONE);
	        combo_Spalte.setText("Spaltenauswahl");
	        combo_Spalte.add("item 1");
	        combo_Spalte.add("item 2");
	        combo_Spalte.add("Modify1");
	        editor.grabHorizontal = true;
	        editor.setEditor(combo_Spalte, items[i], 1);
	        
	        editor = new TableEditor(table);
	        Text text = new Text(table, SWT.NONE);
	        text.setText("JOIN");
	        editor.grabHorizontal = true;
	        editor.setEditor(text, items[i], 2);
	        
	        editor = new TableEditor(table);
	        CCombo combo_Tabelle2 = new CCombo(table, SWT.NONE);
	        combo_Tabelle2.setText("Tabellenauswahl");
	        combo_Tabelle2.add("item 1");
	        combo_Tabelle2.add("item 2");
	        combo_Tabelle2.add("Modify1");
	        editor.grabHorizontal = true;
	        editor.setEditor(combo_Tabelle2, items[i], 3);
	        
	        editor = new TableEditor(table);
	        CCombo combo_Spalte2 = new CCombo(table, SWT.NONE);
	        combo_Spalte2.setText("Spaltenauswahl");
	        combo_Spalte2.add("item 1");
	        combo_Spalte2.add("item 2");
	        combo_Spalte2.add("Modify1");
	        editor.grabHorizontal = true;
	        editor.setEditor(combo_Spalte2, items[i], 4);
	      }
		
		final Composite composite_Spalten = new Composite(shell, SWT.NONE);
		composite_Spalten.setBounds(10, 10, 780, 527);
		composite_Spalten.setVisible(true);
		
		
		Group group_Spalten = new Group(composite_Spalten, SWT.NONE);
		group_Spalten.setBounds(10, 10, 760, 507);
		group_Spalten.setText("Spalten auswählen");
		
		final Composite composite_Datei = new Composite(shell, SWT.NONE);
		composite_Datei.setBounds(10, 10, 780, 527);
		composite_Datei.setVisible(true);
		
		Group group_Datei = new Group(composite_Datei, SWT.NONE);
		group_Datei.setBounds(10, 10, 760, 507);
		group_Datei.setText("Speicherort");
		
		Label lblDatei = new Label(group_Datei, SWT.NONE);
		lblDatei.setBounds(30, 30, 100, 14);
		lblDatei.setText("Dateipfad:");
		
		txt_Datei = new Text(group_Datei, SWT.BORDER);
		txt_Datei.setBounds(136, 27, 500, 19);
		txt_Datei.setText(medizin.Variablen.Pfad);
		
		final Button btnWeiter = new Button(shell, SWT.NONE);
		btnWeiter.setBounds(596, 540, 94, 28);
		final Button btnZurck = new Button(shell, SWT.NONE);
		btnZurck.setBounds(496, 540, 94, 28);
		btnWeiter.addMouseListener(new MouseAdapter() { //WEITER
			@Override
			public void mouseDown(MouseEvent e) {
				medizin.Variablen.Zaehler_Windows++;
				if (medizin.Variablen.Zaehler_Windows==2)
				{
					composite_Datenbank.setVisible(false);
					Speichern.Datenbank();
					composite_Verknuepfungen.setVisible(true);
				}
				if (medizin.Variablen.Zaehler_Windows==3)
				{
					composite_Verknuepfungen.setVisible(false);
					composite_Spalten.setVisible(true);
				}
				if (medizin.Variablen.Zaehler_Windows==4)
				{
					composite_Spalten.setVisible(false);
					composite_Datei.setVisible(true);
					btnWeiter.setText("Fertig");
				}
				if (medizin.Variablen.Zaehler_Windows==5)
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
				medizin.Variablen.Zaehler_Windows--;
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
				;

			}
		});
		btnZurck.setText("Zurück");
		btnZurck.setEnabled(false);
		
		
		btnVerbindungTesten.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				Speichern.Datenbank();
				String test = medizin.Verbindung.test();
				if (test == null)
				{
					lblVerbindungOK.setText("Verbindung OK");
					lblVerbindungOK.setVisible(true);
					btnWeiter.setEnabled(true);
				}
				else
				{
					lblVerbindungOK.setText("Fehler in der Verbindung! \n"+test);
					lblVerbindungOK.setVisible(true);
					btnWeiter.setEnabled(false);
				}
			}
		});

		
		
		
		

	}
}
