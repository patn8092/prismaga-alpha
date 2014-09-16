package igi.prismaga.gfx;

import igi.prismaga.entities.Entity;
import igi.prismaga.main.Game;

import java.awt.image.BufferedImage;

public class AnimationManager {
	
	public BufferedImage findEntityFrame(Entity e, int direction,int action,int frameCount, SpriteSheet spritesheet) {
			if(action == 0) { //IDLE
				if(frameCount < 4) {
					if(e.status == 0) { //NORMAL
						return spritesheet.crop(1, direction, Game.TILESIZE, Game.TILESIZE);
					} else 
					if(e.status == 1) { //ON FIRE
						return spritesheet.crop(frameCount, 4 + direction, Game.TILESIZE, Game.TILESIZE);
					}
				}
			} else if(action == 1) {
				if(frameCount < 4) {
					if(e.status == 0) {
						return spritesheet.crop(frameCount, direction, Game.TILESIZE, Game.TILESIZE);
					}
					if(e.status == 1) {
						return spritesheet.crop(frameCount, 4 + direction, Game.TILESIZE, Game.TILESIZE);
					}
				}
			} else if(action == 2) {
				if(frameCount < 4) {
					if(e.status == 0) {
						return spritesheet.crop(4 + frameCount, direction, Game.TILESIZE, Game.TILESIZE);
					}
					if(e.status == 1) {
						return spritesheet.crop(4 + frameCount, 4 + direction, Game.TILESIZE, Game.TILESIZE);
					}
				}
			} else if(action == 3) {
				if(frameCount < 4) {
					if(e.status == 0) {
						return spritesheet.crop(1, direction, Game.TILESIZE, Game.TILESIZE);
					}
					if(e.status == 1) {
						return spritesheet.crop(frameCount, 4 + direction, Game.TILESIZE, Game.TILESIZE);
					}
				}
			}
		return spritesheet.crop(1, direction, Game.TILESIZE, Game.TILESIZE);
	}
	
}
