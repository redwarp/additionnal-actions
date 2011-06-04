package net.redwarp.actions;

import java.io.File;

import com.jbbres.lib.actions.elements.ActionExecutionException;
import com.jbbres.lib.actions.elements.Parameters;
import com.jbbres.lib.actions.tools.elements.AbstractAction;
import com.jbbres.lib.actions.tools.elements.AbstractActionService;

public class SendFilesFTPService extends AbstractActionService<File[], File[]>{

	public SendFilesFTPService(AbstractAction parent) {
		super(parent);
		// TODO Auto-generated constructor stub
	}

	@Override
	public File[] executeAction(File[] arg0, Parameters arg1)
			throws ActionExecutionException {
		// TODO Auto-generated method stub
		return arg0;
	}

}
