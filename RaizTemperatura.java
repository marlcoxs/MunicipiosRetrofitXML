package com.example.aplicacionmunicipios;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name="root",strict=false)
public class RaizTemperatura {
    @Element(name = "nombre")
    private String nombre_municipio;
    @ElementList(name = "prediccion")
    private List<Dia> prediccion;

    public String getNombre_municipio() {
        return nombre_municipio;
    }

    public void setNombre_municipio(String nombre_municipio) {
        this.nombre_municipio = nombre_municipio;
    }

    public List<Dia> getPrediccion() {
        return prediccion;
    }

    public void setPrediccion(List<Dia> prediccion) {
        this.prediccion = prediccion;
    }
}
