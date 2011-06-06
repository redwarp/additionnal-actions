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

import java.awt.FlowLayout;
import javax.swing.JLabel;

import com.jbbres.lib.actions.elements.InvalidParametersException;
import com.jbbres.lib.actions.elements.Parameters;
import com.jbbres.lib.actions.tools.elements.AbstractAction;
import com.jbbres.lib.actions.tools.elements.AbstractActionUI;

public class HashFilesUI extends AbstractActionUI{
	private static final long serialVersionUID = -7700772057375870715L;

	public HashFilesUI(AbstractAction parent) {
		super(parent);

		getContentPane().setLayout(new FlowLayout(FlowLayout.LEADING));
		getContentPane().add(new JLabel(HashFiles.bundle.getString("message")));
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
