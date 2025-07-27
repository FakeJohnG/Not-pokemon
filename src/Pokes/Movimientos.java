package Pokes;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Movimientos {
    public String nombre;
    public String tipo;
    public BufferedImage tipoImagen;
    public int poder;
    public int precision;
    public int pp;

    public Movimientos(String nombre, String tipo, int poder, int precision, int pp) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.poder = poder;
        this.precision = precision;
        this.pp = pp;
        try {
            tipoImagen = ImageIO.read(getClass().getResourceAsStream("/tipos/" + tipo.toLowerCase() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getNombre(){
        return nombre;
    }
    public int getPoder() {
        return poder;
    }
    public int getPrecision() {
        return precision;
    }
}
