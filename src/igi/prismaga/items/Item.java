/*
 * Project Prismaga
 * Copyright (c) 2014 Igadabif Interactive LLC.
 * Date: 8/8/2014
 * Author(s): Patrick Nichols
 */

package igi.prismaga.items;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Item {
	
	public BufferedImage image;
	
	public abstract void tick();
	public abstract void render(Graphics g, int x, int y);
}
