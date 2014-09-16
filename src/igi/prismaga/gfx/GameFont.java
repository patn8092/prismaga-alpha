package igi.prismaga.gfx;

import igi.prismaga.main.Game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class GameFont {
	
	private static int fontWidth;
	private static int fontHeight;
	private int align;
	
	public static int LEFT = 0, RIGHT = 1, CENTER = 2;
	
	public String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ 1234567890!?.,:;$%()-=+/\'\"<>{}[]";
	
	public SpriteSheet glyphs = new SpriteSheet(Game.imageLoader.load("/gfx/fonts/glyphs.png"));
	
	public GameFont() {
		fontWidth = 8;
		fontHeight = 8;
		align = CENTER;
	}
	
	public void renderMessage(Graphics g, String msg, int x, int y) {
		
		msg = msg.toUpperCase();
		
		for(int i = 0; i < msg.length(); i++) {

			if(characters.indexOf(msg.charAt(i)) > -1 || characters.indexOf(msg.charAt(i)) < characters.length()) {
				
				BufferedImage currentCharacterImage = glyphs.cropFont(characters.indexOf(msg.charAt(i)) * fontWidth, 0, fontWidth, getFontHeight());
				
				if(align == LEFT) {
					g.drawImage(currentCharacterImage, 
								x, 
								y, 
								currentCharacterImage.getWidth() * Game.SCALE,
								currentCharacterImage.getHeight() * Game.SCALE,
								null
								);
				}
				
				if(align == RIGHT) {
					g.drawImage(currentCharacterImage, 
							x + ((msg.length() - 1) * (fontWidth * Game.SCALE)), 
							y, 
							currentCharacterImage.getWidth() * Game.SCALE,
							currentCharacterImage.getHeight() * Game.SCALE,
							null
							);
				}
				
				if(align == CENTER) {
					g.drawImage(currentCharacterImage, 
							x - (((msg.length() - 1) * (fontWidth * Game.SCALE)) / 2), 
							y, 
							currentCharacterImage.getWidth() * Game.SCALE,
							currentCharacterImage.getHeight() * Game.SCALE,
							null
							);
				}
				
				x += currentCharacterImage.getWidth() * Game.SCALE;
			}
		}
	}
	
	public void setAlign(int a) {
		this.align = a;
	}
	
	public void setFont(BufferedImage fntimg) {
		this.glyphs = new SpriteSheet(fntimg);
	}

	public static int getFontHeight() {
		return fontHeight;
	}

	public void setFontHeight(int fontHeight) {
		GameFont.fontHeight = fontHeight;
	}
	
	public static int getFontWidth() {
		return fontWidth;
	}
	
	public void setFontWidth(int fontWidth) {
		GameFont.fontWidth = fontWidth;
	}
	
}
