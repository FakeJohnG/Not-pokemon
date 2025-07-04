package Notpokemon;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sonido {
    Clip clip;
    URL sonidoURL[]=new URL[30];

    public Sonido(){
        sonidoURL[0]=getClass().getResource("/musica/mundoBeta.wav");
        sonidoURL[1]=getClass().getResource("/musica/pausa.wav");
        sonidoURL[2]=getClass().getResource("/musica/gemGet.wav");
        sonidoURL[3]=getClass().getResource("/musica/bigShot.wav");
        sonidoURL[4]=getClass().getResource("/musica/cambioMapa.wav");
        sonidoURL[5]=getClass().getResource("/musica/soulBattle.wav");

    }
    public void setFile(int i){
        try{
            AudioInputStream ais= AudioSystem.getAudioInputStream(sonidoURL[i]);
            clip=AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public void play(){
        clip.start();

    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }
    public void stop(){
        clip.stop();

    }

}

