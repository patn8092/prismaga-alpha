/*
 * Project Prismaga
 * Copyright (c) 2014 Igadabif Interactive LLC.
 * Date: 8/8/2014
 * Author(s): Patrick Nichols
 */

package igi.prismaga.menus;

public class MenuManager {
	
	private static Menu currentMenu;
	
	public static void setCurrentMenu(Menu m) {
		currentMenu = m;
	}
	
	public static Menu getCurrentMenu() {
		return currentMenu;
	}
}
