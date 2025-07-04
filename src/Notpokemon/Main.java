package Notpokemon;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
//Todo este codigo para que namas salga una ventana nueva, loco verdad?
        ImageIcon icon= new ImageIcon(Main.class.getResource("/otros/notPokemonbeta.jpg"));
        JFrame window= new JFrame();
        GamePanel gamepanel= new GamePanel();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Pokemon't BETA");
        window.setIconImage(icon.getImage());
        window.add(gamepanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gamepanel.setup();
        gamepanel.startGameThread();
    }
}
