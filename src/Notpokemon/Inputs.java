package Notpokemon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Esta clase, maneja lo que son los inputs del teclado
//Ps. talves implemente soporte para control pero eso ya seria un requisito no funcional. J
public class Inputs implements KeyListener {
    //Atributos
public boolean upPressed,downPressed,leftPressed,rightPressed;


    @Override
    public void keyTyped(KeyEvent e) {
//Esta realmente no se usa
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code= e.getKeyCode();
        if(code==KeyEvent.VK_W){
            upPressed=true;

        }
        if(code==KeyEvent.VK_A){
            leftPressed=true;

        }
        if(code==KeyEvent.VK_S){
            downPressed=true;

        }
        if(code==KeyEvent.VK_D){
            rightPressed=true;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code= e.getKeyCode();
        if(code==KeyEvent.VK_W){
            upPressed=false;

        }
        if(code==KeyEvent.VK_A){
            leftPressed=false;

        }
        if(code==KeyEvent.VK_S){
            downPressed=false;

        }
        if(code==KeyEvent.VK_D){
            rightPressed=false;

        }


    }
}
