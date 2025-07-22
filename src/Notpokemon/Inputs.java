package Notpokemon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Esta clase, maneja lo que son los inputs del teclado
//Ps. talves implemente soporte para control pero eso ya seria un requisito no funcional. J
public class Inputs implements KeyListener {
    //Atributos
public boolean upPressed,downPressed,leftPressed,rightPressed,ePressed;
    GamePanel gamePanel;
    public Inputs(GamePanel gamePanel){
        this.gamePanel=gamePanel;

    }

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
        if(code==KeyEvent.VK_E){
            ePressed=true;

        }
        if(code==KeyEvent.VK_ENTER){
            if(gamePanel.gameState==gamePanel.playState){
                gamePanel.gameState=gamePanel.pauseState;
                gamePanel.sonido.stop();

                gamePanel.sonidoE.setFile(1);
                gamePanel.sonidoE.play();

                gamePanel.sonidoE.setFile(6);
                gamePanel.sonidoE.play();

            } else if (gamePanel.gameState==gamePanel.pauseState) {
                gamePanel.sonidoE.stop();
                gamePanel.sonido.stop();
                gamePanel.sonidoE.setFile(1);
                gamePanel.sonidoE.play();
                gamePanel.gameState=gamePanel.playState;

            }else if (gamePanel.gameState== gamePanel.tituloState) {
                gamePanel.sonidoE.setFile(7);
                gamePanel.sonidoE.play();
                gamePanel.gameState= gamePanel.playState;
                gamePanel.sonido.stop();
                gamePanel.sonido.setFile(0);
                gamePanel.sonido.play();
            } else if (gamePanel.gameState== gamePanel.combateState) {
                gamePanel.gameState= gamePanel.playState;
                gamePanel.sonido.stop();
                gamePanel.sonido.setFile(0);
                gamePanel.sonido.play();

            }


        }
        if(gamePanel.gameState== gamePanel.yapperState){
            gamePanel.sonidoE.setFile(7);
            gamePanel.sonidoE.play();
            if(code==KeyEvent.VK_E){
                gamePanel.gameState= gamePanel.playState;
            }
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
