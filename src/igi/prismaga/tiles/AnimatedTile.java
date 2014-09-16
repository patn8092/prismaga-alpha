package igi.prismaga.tiles;

import igi.prismaga.gfx.SpriteSheet;
import igi.prismaga.main.Game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class AnimatedTile extends Tile{
	
	private int animationSwitchDelay;
	private int currentAnimationIndex;
	private int maxFrames;
	private long lastIterationTime;
	private SpriteSheet images;
	private BufferedImage currentFrame;
	
	public AnimatedTile(SpriteSheet images, boolean isSolid, int switchDelay) {
		super(null, isSolid);
		this.images = images;
		this.maxFrames = images.h / Game.TILESIZE;
		this.currentAnimationIndex = 0;
		this.lastIterationTime = System.currentTimeMillis();
		this.animationSwitchDelay = switchDelay;
	}

	public void tick() {
		if((System.currentTimeMillis() - lastIterationTime) >= (animationSwitchDelay)) {
			lastIterationTime = System.currentTimeMillis();
			currentAnimationIndex = (currentAnimationIndex + 1) % maxFrames;
		}
		this.currentFrame = images.crop(0, currentAnimationIndex, Game.TILESIZE, Game.TILESIZE);
	}

	public void render(Graphics g, int x, int y) {
		g.drawImage(currentFrame, x, y, Game.TILESIZE* Game.SCALE, Game.TILESIZE * Game.SCALE, null);
	}
}
