package game.audios;

import jplay.Sound;

public class Audio {
	
	private static Sound musica;
	
	
	public static void play(String audio) {
		stop();
		musica = new Sound(audio);
		Audio.musica.play();
		Audio.musica.setRepeat(true);
	}
	
	public static void stop() {
		if(Audio.musica != null) {
			musica.stop();
		}
	}

}
