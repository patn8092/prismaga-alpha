package igi.prismaga.gfx;

import igi.prismaga.main.Game;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage sheet;
	public int w, h;
	
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
		this.w = sheet.getWidth();
		this.h = sheet.getHeight();
	}
	
	public BufferedImage crop(int col, int row, int w, int h) {
		return sheet.getSubimage(col * Game.TILESIZE, row * Game.TILESIZE, w, h);
	}
	
	public BufferedImage cropFont(int col, int row, int w, int h) {
		return sheet.getSubimage(col, row, w, h);
	}
}
