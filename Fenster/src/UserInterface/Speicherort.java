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

public class Speicherort {
	
	private static Composite Speicherort;
	public static void open(Shell shell)
	{
		Speicherort = new Composite(shell, SWT.NONE);
		Speicherort.setBounds(10, 10, 780, 527);
		Speicherort.setVisible(false);
		
		Group group_Speicherort = new Group(Speicherort, SWT.NONE);
		group_Speicherort.setBounds(10, 10, 760, 507);
		group_Speicherort.setText("Speicherorteinstellungen");
		
		//TODO
	}
		
		
	
	public static void speichern()
	{
		//TODO
		
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
