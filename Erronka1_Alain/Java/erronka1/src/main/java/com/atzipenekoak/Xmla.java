package com.atzipenekoak;

import java.io.File;

import com.pojoak.Produktuak;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class Xmla {

    public Produktuak produktuak;
    public String strFileOut;
    public String strFileIn;

    public Xmla(String strFile) {
        strFileIn = strFile;
    }

    public Xmla(Produktuak produktuak, String strFileOut) {
        this.produktuak = produktuak;
        this.strFileOut = strFileOut;
    }


    public Produktuak irakurri() {
        Produktuak produktuak = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Produktuak.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            produktuak = (Produktuak) jaxbUnmarshaller.unmarshal(new File(strFileIn));
        } catch (Exception ex) {
            System.out.println("Arazoren bat " + strFileIn + " irakurtzerakoan.");
        }
        return produktuak;
    }

    public void idatzi() {
        //int produktuKopurua = 0;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Produktuak.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal(this.produktuak, new File(this.strFileOut));
            // jaxbMarshaller.marshal(mendiak, System.out);
            //produktuKopurua = produktuak.getProduktuak().size();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}

