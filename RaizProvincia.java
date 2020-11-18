package com.example.aplicacionmunicipios;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(strict=false, name="consulta_provinciero")
public class RaizProvincia {

    @ElementList
    private List<Provincia> provinciero;


    public List<Provincia> getProvinciero() {
        return provinciero;
    }

    public void setProvinciero(List<Provincia> provinciero) {
        this.provinciero = provinciero;
    }

    @Override
    public String toString() {
        return "consulta_provinciero, provinciero=" + provinciero + '}';
    }
}