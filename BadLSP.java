
class MediaPlayer {
    public void play() {
        System.out.println("Playing media");
    }
}

class AudioOnlyPlayer extends MediaPlayer {

    public void play() {
        throw new UnsupportedOperationException("Cannot play video");
    }
}

public class BadLSP {
    public static void main(String[] args) {
        MediaPlayer player = new AudioOnlyPlayer();
        player.play(); 
    }
}
