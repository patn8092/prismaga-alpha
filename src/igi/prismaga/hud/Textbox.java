/*
 * Project Prismaga
 * Copyright (c) 2014 Igadabif Interactive LLC.
 * Date: 8/8/2014
 * Author(s): Patrick Nichols
 */

package igi.prismaga.hud;

import igi.prismaga.main.Game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Textbox {
	
	public int x, y;
	
	public BufferedImage textbox1 = Game.imageLoader.load("/gfx/hud/textbox.png");
	public BufferedImage textbox2 = Game.imageLoader.load("/gfx/hud/textbox1.png");
	public BufferedImage textbox3 = Game.imageLoader.load("/gfx/hud/textbox2.png");
	public BufferedImage textbox4 = Game.imageLoader.load("/gfx/hud/statusbartop.png");
	
	public BufferedImage currentTextbox;
	
	public String[] submessages;
	
	public Textbox(int x, int y, int type) {
		this.x = x;
		this.y = y;
		setCurrentTextbox(type);
	}
	
	public void setCurrentTextbox(int i) {
		switch(i) {
		case 1: 
			currentTextbox = textbox1;
			break;
		case 2: 
			currentTextbox = textbox2;
			break;
		case 3: 
			currentTextbox = textbox3;
			break;
		case 4:
			currentTextbox = textbox4;
			break;
		default: 
			currentTextbox = textbox1;
			break;
		}
	}
	
	public void render(Graphics g, String message) {
		g.drawImage(currentTextbox,
				x,
				y,
				currentTextbox.getWidth() * Game.SCALE,
				currentTextbox.getHeight() * Game.SCALE,
				null
				);
		
		if(currentTextbox == textbox1) {
			if(message.length() >= 40) {
				this.submessages = new String[2];
				this.submessages[0] = message.substring(0,39);
				this.submessages[1] = message.substring(40);
				if(message.length() >= 80) {
					this.submessages = new String[3];
					this.submessages[0] = message.substring(0,39);
					this.submessages[1] = message.substring(40,79);
					this.submessages[2] = message.substring(80);
				}
			} else {
				submessages = new String[1];
				submessages[0] = message;
			}
			
			if(this.submessages.length == 2) {
				Game.fontRenderer.renderMessage(g, this.submessages[0], this.x + 4, this.y + (2 * Game.SCALE));
				Game.fontRenderer.renderMessage(g, this.submessages[1], this.x + 4, this.y + (2 + 8 * Game.SCALE));
			}
			if(this.submessages.length == 3) {
				Game.fontRenderer.renderMessage(g, this.submessages[0], this.x + 4, this.y + (2 * Game.SCALE));
				Game.fontRenderer.renderMessage(g, this.submessages[1], this.x + 4, this.y + (2 + 8 * Game.SCALE));
				Game.fontRenderer.renderMessage(g, this.submessages[2], this.x + 4, this.y + (2 + 16 * Game.SCALE));
			}
			if(this.submessages.length == 1) {
				Game.fontRenderer.renderMessage(g, submessages[0], this.x + 4, this.y + 4);
			}
		} else {
			Game.fontRenderer.renderMessage(g, message, this.x + 4, this.y + 4);
		}
	}
}
