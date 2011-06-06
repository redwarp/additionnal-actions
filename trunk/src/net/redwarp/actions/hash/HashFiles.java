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
package net.redwarp.actions.hash;

import java.io.IOException;
import java.util.ResourceBundle;

import com.jbbres.lib.actions.tools.elements.AbstractAction;
import com.jbbres.lib.actions.workflow.Workflow;

public class HashFiles extends AbstractAction{
	public static final ResourceBundle bundle = ResourceBundle.getBundle("net.redwarp.actions.locale.HashFilesLocale");

	public HashFiles(Workflow workflow) throws IOException {
		super(workflow);
	}

}
