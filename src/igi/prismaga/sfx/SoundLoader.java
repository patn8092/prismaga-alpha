package igi.prismaga.sfx;

import igi.prismaga.main.Game;

import java.applet.Applet;
import java.applet.AudioClip;

public class SoundLoader {

		public AudioClip load(String path) {
			try {
				AudioClip clip;
				clip = Applet.newAudioClip(Game.class.getResource(path));
				System.out.println("[INFO]:Successfully loaded sound resource: " + path);
				return clip;
			} catch (NullPointerException e) {
				System.out.println("[WARNING]:Could not load resource: " + path);
				System.out.println("[WARNING]:Caught Error: " + e);
			}
			return null;
		}
}
