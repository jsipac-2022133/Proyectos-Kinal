/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

public class Objeto {
    private List<Cesta> listaCesta;
    private double sumaSubtotales;

    // Constructor (puede ser opcional)
    public Objeto() {
    }

    // Getters y setters para listaCesta y sumaSubtotales
    public List<Cesta> getListaCesta() {
        return listaCesta;
    }

    public void setListaCesta(List<Cesta> listaCesta) {
        this.listaCesta = listaCesta;
    }

    public double getSumaSubtotales() {
        return sumaSubtotales;
    }

    public void setSumaSubtotales(double sumaSubtotales) {
        this.sumaSubtotales = sumaSubtotales;
    }
}


