/*
 * Project Prismaga
 * Copyright (c) 2014 Igadabif Interactive LLC.
 * Date: 8/8/2014
 * Author(s): Patrick Nichols
 */

package igi.prismaga.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyManager implements KeyListener {
	
public boolean[] keys = new boolean[180];
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
			System.exit(10);
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {
		
	}

}
