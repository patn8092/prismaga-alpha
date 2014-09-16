package igi.prismaga.sfx;

import igi.prismaga.main.Game;

import java.io.IOException;
import java.io.InputStream;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

public class Music {
	
	private Sequencer se;
	
	public Music(String path) {
		try {
			se = MidiSystem.getSequencer();
			se.open();
			InputStream is = Game.class.getResourceAsStream(path);
			se.setSequence(is);
		} catch (MidiUnavailableException | IOException | InvalidMidiDataException e) {
			e.printStackTrace();
		}		
	}
	
	public void start() {
		se.start();
	}
	
	public void stop() {
		se.stop();
	}
	
	public void loop() {
		se.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
	}
}
