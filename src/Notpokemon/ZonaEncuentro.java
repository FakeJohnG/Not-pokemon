package Notpokemon;

import java.awt.*;

public class ZonaEncuentro {
    Rectangle area;
    int mapa;
    boolean activa = true;
    //La unica funcion de esta clase es para dalre los datos necesarios a la areas salvajes
    //Para que se generen en el mapa

    public ZonaEncuentro(int mapa, int colInicio, int filaInicio, int colFin, int filaFin, int tileSize) {
        this.mapa = mapa;
        int x = colInicio * tileSize;
        int y = filaInicio * tileSize;
        int width = (colFin - colInicio + 1) * tileSize;
        int height = (filaFin - filaInicio + 1) * tileSize;
        this.area = new Rectangle(x, y, width, height);
    }
}
