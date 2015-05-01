package com.srini.sitemap.main;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.srini.jaxb.sitemap.ObjectFactory;
import com.srini.jaxb.sitemap.TUrl;
import com.srini.jaxb.sitemap.Urlset;

public class JaxbMain {

	private static JAXBContext jaxbContext;

	public static void main(String[] args) {
		try {
			jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Urlset urlset = (Urlset) unmarshaller.unmarshal(new File("./XMLXSD/sitemap.xml"));
			List<TUrl> tUrlList = urlset.getUrl();
			
			for(TUrl tUrl : tUrlList){
				System.out.println(tUrl.getLoc());
			}
			
			TUrl url = new TUrl();
			url.setLoc("http://java.dzone.com");
			tUrlList.add(url);
			
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.marshal(urlset, new File("./XMLXSD/sitemap-modified.xml"));
			
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
