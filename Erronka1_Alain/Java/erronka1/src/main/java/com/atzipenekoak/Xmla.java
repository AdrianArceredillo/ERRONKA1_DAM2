package com.atzipenekoak;

import java.io.File;

import com.pojoak.Produktuak;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class Xmla {

    public Produktuak produktuak;
    public String strFileOut;


    public Xmla(Produktuak produktuak, String strFileOut) {
        this.produktuak = produktuak;
        this.strFileOut = strFileOut;
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

