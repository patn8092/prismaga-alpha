package igi.prismaga.hud;

import igi.prismaga.main.Game;
import java.awt.image.BufferedImage;

public class InventoryUIButton {
	
	public BufferedImage image0 = Game.imageLoader.load("/gfx/hud/expand_cells.png");
	public BufferedImage image1 = Game.imageLoader.load("/gfx/hud/collapse_cells.png");
	public BufferedImage currentImage;
	
	public int x,y,width,height;
	
	public boolean CursorIsHovering;

	public InventoryUIButton(int x, int y) {
		this.x = x;
		this.y = y;
		this.width = image0.getWidth() * Game.SCALE;
		this.height = image0.getHeight() * Game.SCALE;
		this.currentImage = image0;
	}
	
	public void setImage(BufferedImage i) {
		this.currentImage = i;
	}
}
