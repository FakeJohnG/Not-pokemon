package Pokes;

import Notpokemon.GamePanel;

import java.awt.image.BufferedImage;

public class Poke {
    GamePanel gamepanel;
    public String name;
    public BufferedImage Pokeimagen,Pokeimagen2,Pokeshop;
    public int nivel;
    public String tipo;
    public Movimientos[] movimientos = new Movimientos[4];
    public int pv,maxPV;
    public String genero;
    public int ppMax;
    public int statAtaque;
    public int statDefensa;
    public int precio;

    public Poke(GamePanel gamepanel) {
        this.gamepanel = gamepanel;
    }

    public void recibirDaño(int daño) {
        this.pv -= daño;

        if (this.pv <= 0) {
            this.pv = 0;

            System.out.println(name + " fue derrotado.");
            if (this == gamepanel.pokeJugador) {
                gamepanel.ui.uiState = 5;
                System.out.println("Perdiste");

            }
            else if (this == gamepanel.pokeEnemigo) {
                gamepanel.ui.uiState = 4;
                System.out.println("Pokemon enemigo"+name + " fue derrotado.");

            }
        }
    }
    public int getStatAtaque() {
        return statAtaque;
    }
    public int getStatDefensa() {
        return statDefensa;
    }

}
