package igi.prismaga.gfx;

import igi.prismaga.main.Game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	public BufferedImage load(String path) {
		try {
			System.out.println("[INFO]:Successfully loaded image resource: " + path);
			return ImageIO.read(Game.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}