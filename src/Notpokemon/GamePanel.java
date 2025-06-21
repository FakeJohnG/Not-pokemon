package Notpokemon;
import Entidades.Player;
import tile.TileManager;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyListener;

//Esta clase sirve para darle atributos a la ventana.
public class GamePanel extends JPanel implements Runnable {
//Atributos
    final int originalTileSize=16;
    final int scale=3;
    public final int tileSize= originalTileSize*scale;
   public final int maxScreenColm=16;
    public final int maxScreenRow=12;
    public final int screenWidth= tileSize*maxScreenColm;
    public final int screenHeight= tileSize*maxScreenRow;
    Inputs input= new Inputs();
    Thread gameThread;
    Player player=new Player(this,input);
    TileManager tileM=new TileManager(this);

    //fps (frames per second)
    int fps=24;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.BLACK);
        //Si el rendimiento del juego va mal, sera culpa de este
        this.setDoubleBuffered(true);
        this.addKeyListener(input);
        this.setFocusable(true);
    }
    //Estas lineas de abajo se encargan de manejar el gameloop, mejor no las toquen.
public void startGameThread(){
        //Con esta linea se instancia el thread
        gameThread = new Thread(this);
        gameThread.start();
}
    @Override
    public void run() {
        double drawInterval=1000000000/fps;
        double nextDrawTime= System.nanoTime() + drawInterval;
        while(gameThread !=null){

            //System.out.println("The game is running");
            update();

            repaint();
            try {
            double remainingTime =nextDrawTime-System.nanoTime();
            remainingTime=remainingTime/1000000000;
            if(remainingTime<0){
                remainingTime=0;
            }

                Thread.sleep((long)remainingTime);
            nextDrawTime+=drawInterval;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public void update(){
        player.update();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2=(Graphics2D)g;
        //OJO, Tile manager debe ir primero sino, el personje se dibujara debajo de las tiles.
        tileM.draw(g2);
        player.draw(g2);


        g2.dispose();
    }
}
