package Notpokemon;
import Pokes.Movimientos;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Esta clase, maneja lo que son los inputs del teclado
//Ps. talves implemente soporte para control pero eso ya seria un requisito no funcional. J

public class Inputs implements KeyListener {
    //Atributos
public boolean upPressed,downPressed,leftPressed,rightPressed, enterPressed,EPressed,DeletePressed;
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
        //Inputs en combate
        if(gamePanel.gameState==gamePanel.combateState){
            if(code==KeyEvent.VK_A){
                gamePanel.sonidoE.setFile(7);
                gamePanel.sonidoE.play();
                gamePanel.ui.numCommando--;
                if(gamePanel.ui.numCommando <0){
                    gamePanel.ui.numCommando=3;
                }
            }
            if(code==KeyEvent.VK_D){
                gamePanel.sonidoE.setFile(7);
                gamePanel.sonidoE.play();
                gamePanel.ui.numCommando++;
                if(gamePanel.ui.numCommando >3){
                    gamePanel.ui.numCommando=0;
                }
            }
        }

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
            EPressed=true;
             if (gamePanel.gameState== gamePanel.combateState) {
                gamePanel.gameState= gamePanel.playState;
                 gamePanel.ui.uiState=0;
                gamePanel.sonido.stop();
                gamePanel.sonido.setFile(0);
                gamePanel.sonido.play();

            }

        }
        if(code==KeyEvent.VK_BACK_SPACE){
            DeletePressed=true;
            if(gamePanel.gameState==gamePanel.combateState){
                if(gamePanel.ui.uiState==1){
                    gamePanel.sonidoE.setFile(10);
                    gamePanel.sonidoE.play();
                    gamePanel.ui.uiState=0;
                }
            }
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

                } else if (gamePanel.gameState== gamePanel.tituloState) {
                    gamePanel.sonidoE.setFile(7);
                    gamePanel.sonidoE.play();
                    gamePanel.gameState= gamePanel.playState;
                    gamePanel.sonido.stop();
                    gamePanel.sonido.setFile(0);
                    gamePanel.sonido.play();
                } else if (gamePanel.gameState== gamePanel.combateState) {
                    if(gamePanel.ui.uiState==0){
                        if(gamePanel.ui.numCommando==0){
                            gamePanel.ui.uiState=1;
                            gamePanel.sonidoE.setFile(7);
                            gamePanel.sonidoE.play();

                        }
                        if(gamePanel.ui.numCommando==3){
                            gamePanel.sonidoE.setFile(9);
                            gamePanel.sonidoE.play();
                            gamePanel.gameState=gamePanel.playState;
                            gamePanel.sonido.stop();
                            gamePanel.sonido.setFile(0);
                            gamePanel.sonido.play();
                            gamePanel.ui.uiState=0;
                            gamePanel.ui.numCommando=0;
                        }

                    }
                    else if(gamePanel.ui.uiState==1){
                        if(gamePanel.ui.numCommando==0){
                            gamePanel.sonidoE.setFile(7);
                            gamePanel.sonidoE.play();
                            gamePanel.ui.uiState=2;
                            gamePanel.combate.procesarTurno(gamePanel.pokeJugador,gamePanel.pokeEnemigo,gamePanel.pokeJugador.movimientos[1]);
                            gamePanel.ui.movUsado=0;



                        }
                        if(gamePanel.ui.numCommando==1){
                            gamePanel.sonidoE.setFile(7);
                            gamePanel.sonidoE.play();
                            gamePanel.ui.uiState=2;
                            gamePanel.combate.procesarTurno(gamePanel.pokeJugador,gamePanel.pokeEnemigo,gamePanel.pokeJugador.movimientos[1]);
                            gamePanel.ui.movUsado=1;

                        }
                        if(gamePanel.ui.numCommando==2){
                            gamePanel.sonidoE.setFile(7);
                            gamePanel.sonidoE.play();
                            gamePanel.ui.uiState=2;
                            gamePanel.combate.procesarTurno(gamePanel.pokeJugador,gamePanel.pokeEnemigo,gamePanel.pokeJugador.movimientos[1]);
                            gamePanel.ui.movUsado=2;

                        }
                        if(gamePanel.ui.numCommando==3){
                            gamePanel.sonidoE.setFile(7);
                            gamePanel.sonidoE.play();
                            gamePanel.ui.uiState=2;
                            gamePanel.combate.procesarTurno(gamePanel.pokeJugador,gamePanel.pokeEnemigo,gamePanel.pokeJugador.movimientos[1]);
                            gamePanel.ui.movUsado=3;


                        }
                    }
                    else if(gamePanel.ui.uiState==2){
                        gamePanel.ui.uiState=3;
                        int i = (int)(Math.random() * 4); // Movimiento aleatorio del enemigo
                        Movimientos movimientoEnemigo = gamePanel.pokeEnemigo.movimientos[i];
                        gamePanel.combate.procesarTurno(gamePanel.pokeEnemigo, gamePanel.pokeJugador, movimientoEnemigo);
                        gamePanel.ui.movUsadoE=i;
                    }
                    else if(gamePanel.ui.uiState==3){
                        gamePanel.ui.uiState=0;
                    } else if (gamePanel.ui.uiState==4) {
                        gamePanel.pokeJugador.pv=gamePanel.pokeJugador.maxPV;
                        gamePanel.pokeEnemigo.pv=gamePanel.pokeEnemigo.maxPV;
                        gamePanel.gameState=gamePanel.playState;
                        gamePanel.sonido.stop();
                        gamePanel.sonido.setFile(0);
                        gamePanel.sonido.play();
                        gamePanel.ui.uiState=0;
                        gamePanel.jugador.dinero=gamePanel.jugador.dinero+10;

                    } else if (gamePanel.ui.uiState==5) {
                        gamePanel.pokeJugador.pv=gamePanel.pokeJugador.maxPV;
                        gamePanel.pokeEnemigo.pv=gamePanel.pokeEnemigo.maxPV;
                        gamePanel.gameState=gamePanel.playState;
                        gamePanel.sonidoE.setFile(9);
                        gamePanel.sonidoE.play();
                        gamePanel.sonido.stop();
                        gamePanel.sonido.setFile(0);
                        gamePanel.sonido.play();
                        gamePanel.ui.uiState=0;


                    }

                }


            }
            //Dialogo
            if(gamePanel.gameState== gamePanel.yapperState){

                if(code==KeyEvent.VK_E){
                    gamePanel.sonidoE.setFile(7);
                    gamePanel.sonidoE.play();
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
        if(code==KeyEvent.VK_ENTER){
            enterPressed =false;
        }
        if(code==KeyEvent.VK_BACK_SPACE){
            DeletePressed=false;
        }




    }
}
