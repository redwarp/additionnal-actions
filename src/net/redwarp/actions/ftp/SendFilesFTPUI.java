package net.redwarp.actions.ftp;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.jbbres.lib.actions.elements.InvalidParametersException;
import com.jbbres.lib.actions.elements.Parameters;
import com.jbbres.lib.actions.tools.elements.AbstractAction;
import com.jbbres.lib.actions.tools.elements.AbstractActionUI;

public class SendFilesFTPUI extends AbstractActionUI{

	private static final long serialVersionUID = -452538517334716473L;

	private JLabel hostLabel;
	private JTextField hostField;
	private JLabel loginLabel;
	private JTextField loginField;
	private JLabel passwordLabel;
	private JPasswordField passwordField;
	private JCheckBox showPasswordCheckBox;
	private char showPasswordChar;
	private JCheckBox overwriteCheckBox;
	private JCheckBox passiveCheckBox;
	private JLabel directoryLabel;
	private JTextField directoryField;

	private ResourceBundle bundle;

	public SendFilesFTPUI(AbstractAction parent) {
		super(parent);

		bundle = ResourceBundle.getBundle("net.redwarp.actions.locale.SendFilesFTPLocale");

		JPanel hostPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		hostLabel = new JLabel(bundle.getString("host"));
		hostField = new JTextField(50);
		hostLabel.setLabelFor(hostField);
		hostField.setToolTipText(bundle.getString("hostMore"));
		hostPanel.add(hostLabel);
		hostPanel.add(hostField);

		JPanel loginPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		loginLabel = new JLabel(bundle.getString("login"));
		loginField = new JTextField(20);
		loginLabel.setLabelFor(loginField);
		passwordLabel = new JLabel(bundle.getString("password"));
		passwordField = new JPasswordField(20);
		passwordLabel.setLabelFor(passwordField);
		showPasswordCheckBox = new JCheckBox(bundle.getString("showPassword"));
		showPasswordChar = passwordField.getEchoChar();
		showPasswordCheckBox.setSelected(false);
		showPasswordCheckBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if(showPasswordCheckBox.isSelected()){
					passwordField.setEchoChar((char)0);
				} else {
					passwordField.setEchoChar(showPasswordChar);
				}
			}
		});
		loginPanel.add(loginLabel);
		loginPanel.add(loginField);
		loginPanel.add(passwordLabel);
		loginPanel.add(passwordField);
		loginPanel.add(showPasswordCheckBox);
		
		JPanel directoryPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		directoryLabel = new JLabel(bundle.getString("directory"));
		directoryField = new JTextField(50);
		directoryField.setToolTipText(bundle.getString("directoryMore"));
		directoryLabel.setLabelFor(directoryField);
		directoryPanel.add(directoryLabel);
		directoryPanel.add(directoryField);

		JPanel optionPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		overwriteCheckBox = new JCheckBox(bundle.getString("overwrite"));
		overwriteCheckBox.setToolTipText(bundle.getString("overwriteMore"));
		overwriteCheckBox.setSelected(false);
		passiveCheckBox = new JCheckBox(bundle.getString("passive"));
		passiveCheckBox.setToolTipText(bundle.getString("passiveMore"));
		passiveCheckBox.setSelected(true);
		optionPanel.add(overwriteCheckBox);
		optionPanel.add(passiveCheckBox);

		getContentPane().setLayout(new GridLayout(0, 1));
		getContentPane().add(hostPanel);
		getContentPane().add(loginPanel);
		getContentPane().add(directoryPanel);
		getContentPane().add(optionPanel);
	}

	@Override
	protected Parameters getUIParameters() {
		Parameters params = new Parameters();
		params.setParameter(SendFilesFTP.PARAM_HOST, hostField.getText());
		params.setParameter(SendFilesFTP.PARAM_LOGIN, loginField.getText());
		params.setParameter(SendFilesFTP.PARAM_PASSWORD, new String(passwordField.getPassword()));
		params.setParameter(SendFilesFTP.PARAM_OVERWRITE, overwriteCheckBox.isSelected());
		params.setParameter(SendFilesFTP.PARAM_PASSIVE, passiveCheckBox.isSelected());
		params.setParameter(SendFilesFTP.PARAM_DIRECTORY, directoryField.getText());
		return params;
	}

	@Override
	protected void setUIParameters(Parameters params)
	throws InvalidParametersException {
		hostField.setText(params.getParameter(SendFilesFTP.PARAM_HOST));
		loginField.setText(params.getParameter(SendFilesFTP.PARAM_LOGIN));
		passwordField.setText(params.getParameter(SendFilesFTP.PARAM_PASSWORD));
		overwriteCheckBox.setSelected(params.getBooleanParameter(SendFilesFTP.PARAM_OVERWRITE));
		passiveCheckBox.setSelected(params.getBooleanParameter(SendFilesFTP.PARAM_PASSIVE));
		directoryField.setText(params.getParameter(SendFilesFTP.PARAM_DIRECTORY));
	}

}
