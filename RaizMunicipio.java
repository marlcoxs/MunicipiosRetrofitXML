package com.example.aplicacionmunicipios;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name="consulta_municipiero", strict =false)
public class RaizMunicipio {

    @ElementList
    private List<Municipio> municipiero;

    public List<Municipio> getMunicipiero() {
        return municipiero;
    }

    public void setMunicipiero(List<Municipio> municipiero) {
        this.municipiero = municipiero;
    }

    @Override
    public String toString() {
        return "RaizMunicipio{" + "municipiero=" + municipiero + '}';
    }


}
