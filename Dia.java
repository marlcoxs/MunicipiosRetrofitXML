package com.example.aplicacionmunicipios;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false)
class Dia {
    @Attribute(name="fecha")
    private String fecha;
    @Element(name="temperatura")
    private Temperatura temperatura;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Temperatura getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Temperatura temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return "Dia{" + "fecha=" + fecha + ", temperatura=" + temperatura + '}';
    }

}