package com.srini.jaxb.custom.main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.srini.jaxb.custom.Training;

public class Main {

	public static void main(String[] args) {
		try {
			JAXBContext context = JAXBContext.newInstance(Training.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Training training = (Training) unmarshaller.unmarshal(new File("./XMLXSD/persons.xml"));
			System.out.println(training.getPersons().get(0));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
