package net.redwarp.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.jbbres.lib.actions.elements.ActionExecutionException;
import com.jbbres.lib.actions.elements.Parameters;
import com.jbbres.lib.actions.tools.elements.AbstractAction;
import com.jbbres.lib.actions.tools.elements.AbstractActionService;

public class HashFilesService extends AbstractActionService<File, String>{

	public HashFilesService(AbstractAction parent) {
		super(parent);
	}

	@Override
	public String executeAction(File files, Parameters params)
	throws ActionExecutionException {
		if(files == null){
			throw new ActionExecutionException("Empty files");
		}
		if(files.isDirectory()){
			throw new ActionExecutionException("Cannot hash a directory");
		}
		long fileLength = files.length();
		if(fileLength > Integer.MAX_VALUE){
			throw new ActionExecutionException("File is too big");
		}


		MessageDigest digest;
		try{
			digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e){
			throw new ActionExecutionException("MD5 doesn't exist");
		}
		try{
			InputStream fis = new FileInputStream(files);
			fis = new DigestInputStream(fis, digest);
			byte[] pointlessBuffer = new byte[1024];
			while (fis.read(pointlessBuffer) != -1);
		} catch (Exception e){
			throw new ActionExecutionException("File access error");
		}
		byte[] result = digest.digest();
		return toHexString(result);
	}

	private String toHexString(byte[] result) {
		StringBuilder hexString = new StringBuilder();
		for(byte b : result){
			String letter = Integer.toHexString(b & 0xFF);
			while(letter.length() < 2){
				letter = "0" + letter;
			}
			hexString.append(letter);
		}
		return hexString.toString();
	}

}
