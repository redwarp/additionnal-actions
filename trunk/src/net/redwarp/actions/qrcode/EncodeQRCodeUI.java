package net.redwarp.actions.qrcode;

import com.jbbres.lib.actions.elements.InvalidParametersException;
import com.jbbres.lib.actions.elements.Parameters;
import com.jbbres.lib.actions.tools.elements.AbstractAction;
import com.jbbres.lib.actions.tools.elements.AbstractActionUI;

public class EncodeQRCodeUI extends AbstractActionUI{

	public EncodeQRCodeUI(AbstractAction parent) {
		super(parent);
	}

	private static final long serialVersionUID = -7095909084700602161L;

	@Override
	protected Parameters getUIParameters() {
		return new Parameters();
	}

	@Override
	protected void setUIParameters(Parameters arg0)
			throws InvalidParametersException {
		
	}

}
