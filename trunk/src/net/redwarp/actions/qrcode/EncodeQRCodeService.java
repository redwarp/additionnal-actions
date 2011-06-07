package net.redwarp.actions.qrcode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;
import com.jbbres.lib.actions.elements.ActionExecutionException;
import com.jbbres.lib.actions.elements.Parameters;
import com.jbbres.lib.actions.tools.elements.AbstractAction;
import com.jbbres.lib.actions.tools.elements.AbstractActionService;

public class EncodeQRCodeService extends AbstractActionService<String[], Image[]>{

	public EncodeQRCodeService(AbstractAction parent) {
		super(parent);
	}

	@Override
	public Image[] executeAction(String[] toEncode, Parameters arg1)
			throws ActionExecutionException {
		if(toEncode == null){
			throw new ActionExecutionException(EncodeQRCode.bundle.getString("errorNoInput"));
		}
		
		Image images[] = new Image[toEncode.length];
		for(int i = 0; i < images.length; i++){
			QRCode code = new QRCode();
			try{
				Encoder.encode(toEncode[i], ErrorCorrectionLevel.M, code);
			} catch (WriterException e){
				throw new ActionExecutionException(String.format(EncodeQRCode.bundle.getString("errorEncode"), toEncode[i]));
			}

			images[i] = imageFromByteArray(code.getMatrix().getArray(), 6);
		}	
		
		return images;
	}

	private Image imageFromByteArray(byte[][] matrix, int scale){
		BufferedImage image = new BufferedImage(matrix.length, matrix.length, BufferedImage.TYPE_BYTE_BINARY);
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				image.setRGB(j, i, matrix[i][j] == 0 ? 0xFFFFFFFF : 0xFF000000);
			}
		}
		BufferedImage scaledImage = new BufferedImage((image.getWidth() + 2) * scale, (image.getHeight() + 2) * scale, BufferedImage.TYPE_BYTE_BINARY);
		Graphics2D g = scaledImage.createGraphics();
		g.setBackground(Color.WHITE);
		g.clearRect(0, 0, scaledImage.getWidth(), scaledImage.getHeight());
		g.drawImage(image, scale, scale, image.getWidth() * scale, image.getHeight() * scale, null);
		return scaledImage;
	}
}
