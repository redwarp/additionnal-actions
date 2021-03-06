/*
 * Copyright 2011 Redwarp
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
