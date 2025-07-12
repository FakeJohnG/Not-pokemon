package Notpokemon;
import Entidades.Entidad;
import Entidades.Player;
import Objetos.ObjetoMadre;
import tile.TileManager;

import javax.swing.JPanel;
import java.awt.*;

//Esta clase sirve para darle atributos a la ventana.
public class GamePanel extends JPanel implements Runnable {
    //Atributos de la pantalla
    final int originalTileSize=16;
    final int scale=3;

    public final int tileSize= originalTileSize*scale;
    public final int maxScreenCol =16;
    public final int maxScreenRow =12;
    public final int screenWidth= tileSize* maxScreenCol;
    public final int screenHeight= tileSize* maxScreenRow;

    //Ajustes del mapa
    public final int maxWorldCol=50;
    public final int maxWorldFila =50;
    public final int mapaMax=10;
    public  int mapaActual=0;

    Inputs input= new Inputs(this);
    Sonido sonido= new Sonido();
    Sonido sonidoE= new Sonido();
    Thread gameThread;
    public CollisionManager managerC =new CollisionManager(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public Player player=new Player(this,input);
    public ObjetoMadre obj[][]=new ObjetoMadre[mapaMax][10];
    public Entidad npc[][]=new Entidad[mapaMax][10];
    TileManager tileM=new TileManager(this);
    public InterfazUsuario ui=new InterfazUsuario(this);
    public AdministradorEventos eventos=new AdministradorEventos(this);
    //Estado del juego
    public int gameState;
    public final int playState=1;
    public final int pauseState=2;
    public final int tituloState=3;
    public int objetivoStatus=0;


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
    public void setup(){
        aSetter.setObjecto();
        aSetter.setNpc();
        playMusic(0);
        //stopMusic(); //para mutear la musica escribir eso
        gameState=playState;
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
                remainingTime=remainingTime/1_000_000;
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
        if(gameState==playState){
            player.update();
            //npc
            for(int i=0;i< npc[1].length;i++){
                if(npc[mapaActual][i]!=null){
                    npc[mapaActual][i].update();
                }
            }
            sonido.loop();
        }
        if(gameState==pauseState){
            sonido.stop();
        }

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2=(Graphics2D)g;
        //OJO, Tile manager debe ir primero sino, el personje se dibujara debajo de las tiles.
        tileM.draw(g2);
        for(int i=0;i<obj[1].length;i++){
            if(obj[mapaActual][i]!=null){
                obj[mapaActual][i].draw(g2,this);
            }
        }
        //Dibujo de npc
        for(int i=0;i<npc[1].length;i++){
            if(npc[mapaActual][i]!=null){
                npc[mapaActual][i].draw(g2);
            }
        }
        player.draw(g2);

        ui.draw(g2);


        g2.dispose();
    }
    public void playMusic(int i){
        sonido.setFile(i);
        sonido.play();
        sonido.loop();

    }
    public void stopMusic(){
        sonido.stop();
    }
    public void playEfectosSonido(int i){
        sonidoE.setFile(i);
        sonidoE.play();

    }
}

