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
package net.redwarp.actions.tools;

import java.io.File;

public class Tools {
	public static final File[] sortByIsDirectory(File[] files){
		if(files == null){
			return null;
		}
		File temp;
		for(int i = 0; i < files.length - 1; i++){
			for(int j = 0; j < files.length - 1 - i; j++){
				if(files[j + 1].isFile()){
					temp = files[j + 1];
					files[j + 1] = files[j];
					files[j] = temp;
				}
			}
		}
		return files;
	}

	public static final File[] sortByIsDirectoryListCopy(final File[] files){
		if(files == null){
			return null;
		}
		File[] newList = new File[files.length];
		for(int i = 0; i < files.length; i++){
			newList[i] = files[i];
		}
		return sortByIsDirectory(newList);
	}
}
