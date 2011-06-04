package net.redwarp.actions.ftp;

import java.io.IOException;

import com.jbbres.lib.actions.tools.elements.AbstractAction;
import com.jbbres.lib.actions.workflow.Workflow;

public class SendFilesFTP extends AbstractAction{
	public static final String PARAM_HOST = "host";
	public static final String PARAM_LOGIN = "login";
	public static final String PARAM_PASSWORD = "password";
	public static final String PARAM_OVERWRITE = "overwrite";
	public static final String PARAM_PASSIVE = "passive";
	public static final String PARAM_DIRECTORY = "directory";

	public SendFilesFTP(Workflow workflow) throws IOException {
		super(workflow);
		// TODO Auto-generated constructor stub
	}

}
