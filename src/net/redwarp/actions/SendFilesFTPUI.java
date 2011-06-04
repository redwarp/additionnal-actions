package net.redwarp.actions;

import java.awt.FlowLayout;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.jbbres.lib.actions.elements.InvalidParametersException;
import com.jbbres.lib.actions.elements.Parameters;
import com.jbbres.lib.actions.tools.elements.AbstractAction;
import com.jbbres.lib.actions.tools.elements.AbstractActionUI;

public class SendFilesFTPUI extends AbstractActionUI{
	public static final String PARAM_HOST = "host";
	
	private static final long serialVersionUID = -452538517334716473L;
	
	private JLabel hostLabel;
	private JTextField hostField;
	private ResourceBundle bundle;

	public SendFilesFTPUI(AbstractAction parent) {
		super(parent);
		bundle = ResourceBundle.getBundle("net.redwarp.actions.locale.SendFilesFTPLocale", Locale.getDefault());
		
		hostLabel = new JLabel(bundle.getString("host"));
		hostField = new JTextField();
		hostField.setEditable(true);

		getContentPane().setLayout(new FlowLayout(FlowLayout.LEADING));
		getContentPane().add(hostLabel);
		getContentPane().add(hostField);
	}
	
	@Override
	protected Parameters getUIParameters() {
		Parameters params = new Parameters();
		params.setParameter(PARAM_HOST, hostField.getText());
		return params;
	}

	@Override
	protected void setUIParameters(Parameters params)
			throws InvalidParametersException {
		hostField.setText(params.getParameter(PARAM_HOST));
	}

}
