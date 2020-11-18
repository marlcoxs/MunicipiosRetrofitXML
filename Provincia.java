package com.example.aplicacionmunicipios;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false )
class Provincia {
    @Element
    private int cpine;
    @Element
    private String np;//nombre provincia

    public int getCpine() {
        return cpine;
    }

    public void setCpine(int cpine) {
        this.cpine = cpine;
    }

    public String getNp() {
        return np;
    }

    public void setNp(String np) {
        this.np = np;
    }

    @Override
    public String toString() {
        return  np +  "";
    }
}