package net.redwarp.actions;

import java.awt.FlowLayout;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JLabel;

import com.jbbres.lib.actions.elements.InvalidParametersException;
import com.jbbres.lib.actions.elements.Parameters;
import com.jbbres.lib.actions.tools.elements.AbstractAction;
import com.jbbres.lib.actions.tools.elements.AbstractActionUI;

public class HashFilesUI extends AbstractActionUI{
	private static final long serialVersionUID = -7700772057375870715L;
	ResourceBundle bundle;

	public HashFilesUI(AbstractAction parent) {
		super(parent);
		bundle = ResourceBundle.getBundle("net.redwarp.actions.locale.HashFilesLocale");
		
		getContentPane().setLayout(new FlowLayout(FlowLayout.LEADING));
		getContentPane().add(new JLabel(bundle.getString("message")));
	}

	@Override
	protected Parameters getUIParameters() {
		// TODO Auto-generated method stub
		return new Parameters();
	}

	@Override
	protected void setUIParameters(Parameters params)
			throws InvalidParametersException {
		// TODO Auto-generated method stub
		
	}

}
