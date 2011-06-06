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

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

import org.apache.commons.net.ftp.FTPFile;

import net.redwarp.actions.tools.Tools;

import com.jbbres.lib.actions.elements.ActionExecutionException;
import com.jbbres.lib.actions.elements.Parameters;
import com.jbbres.lib.actions.tools.elements.AbstractAction;
import com.jbbres.lib.actions.tools.elements.AbstractActionService;

public class SendFilesFTPService extends AbstractActionService<File[], File[]>{
	private static ResourceBundle bundle = ResourceBundle.getBundle("net.redwarp.actions.locale.CustomFTPClientLocale");

	public SendFilesFTPService(AbstractAction parent) {
		super(parent);
	}

	@Override
	public File[] executeAction(File[] files, Parameters params)
	throws ActionExecutionException {
		CustomFTPClient client = new CustomFTPClient(
				params.getParameter(SendFilesFTP.PARAM_HOST),
				params.getParameter(SendFilesFTP.PARAM_LOGIN),
				params.getParameter(SendFilesFTP.PARAM_PASSWORD));
		client.setOverwrite(params.getBooleanParameter(SendFilesFTP.PARAM_OVERWRITE));
		client.setPassiveMode(params.getBooleanParameter(SendFilesFTP.PARAM_PASSIVE));

		File[] orderedFileList = Tools.sortByIsDirectoryListCopy(files);
		if(orderedFileList != null){
			boolean status;
			try{
				client.connect();
			} catch (Exception e){
				throw new ActionExecutionException(bundle.getString("errorClientConnexion"));
			}

			try{
				status = client.login();
				if(!status){
					throw new ActionExecutionException(bundle.getString("errorClientLogin"));
				}

				String directory = params.getParameter(SendFilesFTP.PARAM_DIRECTORY);
				if(!"".equals(directory)){
					client.makeDirectoryRecursive(directory);
					status = client.changeWorkingDirectory(directory);
					if(!status){
						throw new ActionExecutionException(bundle.getString("errorFolderAccess"));
					}
				}
				
				FTPFile[] fileList = client.listFiles();
				for(File file : files){
					client.sendFile(file, fileList);
				}
				client.logout();
			} catch (IOException e){
				throw new ActionExecutionException(bundle.getString("errorIO"));
			} finally {
				try {
					client.disconnect();
				} catch (IOException e) {
					throw new ActionExecutionException(bundle.getString("errorClientDisconnect"));
				}
			}

		}


		return files;
	}

}
