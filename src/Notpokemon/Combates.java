package Notpokemon;

import Pokes.*;

public class Combates {
    GamePanel gamePanel;
    public int combateState;
    public Poke jugador;


    public Combates(GamePanel gamepanel, Poke jugador) {
        this.gamePanel = gamepanel;
        this.jugador = jugador;



    }
    public Poke generarPokeSalvaje() {
        int rand = (int)(Math.random() * 4); // saca un numero entre 0 a 4
        System.out.println("spawneando pokemon"+rand);
//Saca un numero alazar y el que salga sera el pokemon seleccionado
        switch(rand) {
            case 0: return new Gengar(gamePanel);
            case 1: return new Eevee(gamePanel);
            case 2: return new Scorbunny(gamePanel);
            case 3:return new Mudkip(gamePanel);

            default: return new Pikachu(gamePanel);
        }
    }
    public void procesarTurno(Poke atacante, Poke defensivo, Movimientos movimiento){
        int daño = calcularDaño(atacante, defensivo, movimiento);
        System.out.println(daño);
        gamePanel.ui.dañoCausado=daño;
        defensivo.recibirDaño(daño);


    }

    public int calcularDaño(Poke atacante,Poke defensivo,Movimientos movimiento){

        int poder = movimiento.getPoder();// poder del movimiento
        int precision=movimiento.getPrecision(); // precision del movimiento, osea si falla o no.
        int ataque = atacante.getStatAtaque(); // stat de atacante
        int defensa = defensivo.getStatDefensa(); // stat de defensa
        // Tirada de precisión
        System.out.println("presicion:"+precision);
        int tirada = (int)(Math.random() * 100); // 0 a 99
        System.out.println("tirada:"+tirada);

        if (tirada >= precision) {
            // Falló el ataque
            gamePanel.sonidoE.setFile(9);
            gamePanel.sonidoE.play();
            return 0 ;
        }

        else{
            int dañoBase = (ataque * poder) / (defensa + 1);
            int variación = (int)(Math.random() * 5); // daño adicional aleatorio [0-4]

            return Math.max(1, dañoBase + variación);
        }

    }


}
