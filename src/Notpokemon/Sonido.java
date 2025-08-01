package Notpokemon;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sonido {
    Clip clip;
    URL sonidoURL[]=new URL[30];
    //Clase sonido, aqui cada cancion y efecto de sonido del juego se guardan en el arreglo sonidoUrl


    public Sonido(){
        sonidoURL[0]=getClass().getResource("/musica/townTest.wav");
        sonidoURL[1]=getClass().getResource("/musica/pausa.wav");
        sonidoURL[2]=getClass().getResource("/musica/gemGet.wav");
        sonidoURL[3]=getClass().getResource("/musica/bigShot.wav");
        sonidoURL[4]=getClass().getResource("/musica/cambioMapa.wav");
        sonidoURL[5]=getClass().getResource("/musica/soulBattle.wav");
        sonidoURL[6]=getClass().getResource("/musica/secret.wav");
        sonidoURL[7]=getClass().getResource("/musica/startButton.wav");
        sonidoURL[8]=getClass().getResource("/musica/titulo.wav");
        sonidoURL[9]=getClass().getResource("/musica/bruhMoment.wav");
        sonidoURL[10]=getClass().getResource("/musica/cancel.wav");
        sonidoURL[11]=getClass().getResource("/musica/buySpam.wav");
        sonidoURL[12]=getClass().getResource("/musica/spamError.wav");



    }
    public void setFile(int i){
        //Metodo para que el programa sepe cual audio va a reproducir
        try{
            AudioInputStream ais= AudioSystem.getAudioInputStream(sonidoURL[i]);
            clip=AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public void play(){
        //Reproduce el audio
        clip.start();

    }
    public void loop(){
        //El audio es reproducido en bucle
        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }
    public void stop(){
        //Se detiene el audio
        clip.stop();
        clip.close();

    }

}

