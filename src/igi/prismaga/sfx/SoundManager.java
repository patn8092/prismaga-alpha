package igi.prismaga.sfx;

import igi.prismaga.main.Game;

import java.applet.AudioClip;

public class SoundManager {
	
	public static AudioClip init,
							   walk1,
							   walk2,
							   walk3,
							   swim1,
							   swim2,
							   blip,
							   select
							   ;
	
	
	public SoundManager() {
		init = Game.soundLoader.load("/sfx/clip1.wav");
		//walk1 = Game.soundLoader.load("/sfx/walk1.wav");
		//walk2 = Game.soundLoader.load("/sfx/walk2.wav");
		//walk3 = Game.soundLoader.load("/sfx/walk3.wav");
		swim1 = Game.soundLoader.load("/sfx/swim1.wav");
		swim2 = Game.soundLoader.load("/sfx/swim2.wav");
		blip = Game.soundLoader.load("/sfx/blip.wav");
		select = Game.soundLoader.load("/sfx/select.wav");
		
		/*
		prismaga_theme = MidiSystem.getSequencer();
		prismaga_theme.open();
		InputStream is = getClass().getResourceAsStream("/sfx/prismagatheme.mid");
		prismaga_theme.setSequence(is);
		*/
	}
}
