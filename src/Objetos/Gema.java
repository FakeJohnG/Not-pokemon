package Objetos;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Gema extends ObjetoMadre {
    public Gema(){
        nombre="Gema";
        try{
            imagen= ImageIO.read(getClass().getResourceAsStream("/otros/gema.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
//Si el objeto tiene collision declarela aqui con collision=true; por defecto sera false
    }
}
