package com.atzipenekoak;

import java.io.File;

import com.pojoak.Salmentak;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class SalmentaXmla {
    public Salmentak salmentak;
    public String strFileOut;


    public SalmentaXmla(Salmentak salmentak, String strFileOut) {
        this.salmentak = salmentak;
        this.strFileOut = strFileOut;
    }


    public void idatzi() {
        //int produktuKopurua = 0;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Salmentak.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal(this.salmentak, new File(this.strFileOut));
            // jaxbMarshaller.marshal(mendiak, System.out);
            //produktuKopurua = produktuak.getProduktuak().size();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
