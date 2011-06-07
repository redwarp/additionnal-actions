package net.redwarp.actions.qrcode;

import java.io.IOException;
import java.util.ResourceBundle;

import com.jbbres.lib.actions.tools.elements.AbstractAction;
import com.jbbres.lib.actions.workflow.Workflow;

public class EncodeQRCode extends AbstractAction{
	
	public static final ResourceBundle bundle = ResourceBundle.getBundle("net.redwarp.actions.qrcode.encodeQRCode");
	
	public EncodeQRCode(Workflow workflow) throws IOException {
		super(workflow);
	}

}
