package Pokes;

import Notpokemon.GamePanel;

import java.awt.image.BufferedImage;

public class Poke {
    GamePanel gamepanel;
    public String name;
    public BufferedImage Pokeimagen;
    public int nivel;
    public String tipo;
    public Movimientos[] movimientos = new Movimientos[4];
    public int pv;
    public String genero;

    public Poke(GamePanel gamepanel) {
        this.gamepanel = gamepanel;
    }
}
