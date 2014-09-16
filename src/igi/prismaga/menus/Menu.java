/*
 * Project Prismaga
 * Copyright (c) 2014 Igadabif Interactive LLC.
 * Date: 8/8/2014
 * Author(s): Patrick Nichols
 */

package igi.prismaga.menus;

import java.awt.Graphics;

public abstract class Menu {
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
}
