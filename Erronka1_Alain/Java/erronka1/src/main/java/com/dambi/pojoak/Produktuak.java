package com.dambi.pojoak;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Produktuak")
public class Produktuak {

    List<Produktua> produktuak;

    public List<Produktua> getProduktuak() {
        return produktuak;
    }

    @XmlElement(name = "Produktua")
    public void setProduktuak(List<Produktua> produktuak) {
        this.produktuak = produktuak;
    }

    public void add(Produktua produktua) {
        if (this.produktuak == null) {
            this.produktuak = new ArrayList<produktua>();
        }
        this.produktuak.add(produktua);

    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (Produktua p : this.produktuak) {
            str.append(p.toString());
            str.append("\n");
        }
        return str.toString();
    }

}
