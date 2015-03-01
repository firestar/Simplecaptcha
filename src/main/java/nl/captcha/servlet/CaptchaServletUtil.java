package nl.captcha.servlet;

import nl.captcha.audio.Sample;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;

public final class CaptchaServletUtil {

    public static void writeImage(OutputStream os, BufferedImage bi) {
    	try {
			ImageIO.write(bi, "png", os);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public static void writeAudio(OutputStream os, Sample sample) {
       try {
          ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
          AudioSystem.write(sample.getAudioInputStream(), AudioFileFormat.Type.WAVE, baos);
          os.write(baos.toByteArray());
          os.flush();
          os.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }
}
