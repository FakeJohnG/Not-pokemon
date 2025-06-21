package Notpokemon;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
//Todo este codigo para que namas salga una ventana nueva, loco verdad?
        JFrame window= new JFrame();
        GamePanel gamepanel= new GamePanel();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Not pokemon BETA");
        window.add(gamepanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamepanel.startGameThread();
    }
}
