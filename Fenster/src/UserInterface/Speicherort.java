package UserInterface;

import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import medizin.Verbindung;

import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.DirectoryDialog;

public class Speicherort {
	
	public static Text txt_Datei;
	
	private static Composite Speicherort;
	public static void open(final Shell shell)
	{
		Speicherort = new Composite(shell, SWT.NONE);
		Speicherort.setBounds(10, 10, 780, 527);
		Speicherort.setVisible(false);
		
		Group group_Speicherort = new Group(Speicherort, SWT.NONE);
		group_Speicherort.setBounds(10, 10, 760, 507);
		group_Speicherort.setText("Speicherorteinstellungen");
		
		Label lblDatei = new Label(group_Speicherort, SWT.NONE);
		lblDatei.setBounds(30, 30, 100, 14);
		lblDatei.setText("Dateipfad:");
		
		txt_Datei = new Text(group_Speicherort, SWT.BORDER);
		txt_Datei.setBounds(136, 27, 500, 19);
		txt_Datei.setText(medizin.Variablen.Pfad);
		
		Button btnBrowse = new Button(group_Speicherort, SWT.NONE);
		btnBrowse.setBounds(130, 50, 94, 28);
		btnBrowse.setText("Auswählen...");
		btnBrowse.addMouseListener(new MouseAdapter() { //WEITER
			@Override
			public void mouseDown(MouseEvent e) {
				
				DirectoryDialog dialog = new DirectoryDialog(shell);
			    dialog.setFilterPath("c:\\"); // Windows specific
			    txt_Datei.setText(dialog.open());
				
			}
		});
	}
		
		
	
	public static void speichern()
	{
		//TODO
		
		medizin.Variablen.Pfad = txt_Datei.getText();
		
		Variablen.laden_3=true;
	}
	
	public static void laden()
	{
		//TODO

	}
	public static void visible_true()
	{
		Speicherort.setVisible(true);
	}
	public static void visible_false()
	{
		Speicherort.setVisible(false);
	}

}
