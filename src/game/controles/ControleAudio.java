package game.controles;

import jplay.Sound;

public class ControleAudio {
	
	private static Sound musica;
	
	
	public static void play(String audio) {
		stop();
		musica = new Sound(audio);
		ControleAudio.musica.play();
		ControleAudio.musica.setRepeat(true);
	}
	
	public static void stop() {
		if(ControleAudio.musica != null) {
			musica.stop();
		}
	}

}
