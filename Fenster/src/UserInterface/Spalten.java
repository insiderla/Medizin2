package UserInterface;

import org.eclipse.swt.widgets.Display;
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
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.CoolBar;

public class Spalten {
	
	private static Composite Spalten;
	public static void open(Shell shell)
	{
		Spalten = new Composite(shell, SWT.NONE);
		Spalten.setBounds(10, 10, 780, 527);
		Spalten.setVisible(false);
		
		Group group_Spalten = new Group(Spalten, SWT.NONE);
		group_Spalten.setBounds(10, 10, 760, 507);
		group_Spalten.setText("Spalteneinstellungen");
		
		//TODO
		
		
	}
	
	public static void speichern()
	{
		//TODO
		
		Variablen.laden_2=true;
	}
	
	public static void laden()
	{
		//TODO

	}
	public static void visible_true()
	{
		Spalten.setVisible(true);
	}
	public static void visible_false()
	{
		Spalten.setVisible(false);
	}

}
