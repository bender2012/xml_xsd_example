package com.epam.xml.app;

import java.io.File;

import com.epam.xml.service.XmlValidator;

public class App {
	
	/*
	 
	 With xsd schema you can set order of elements but can't 
	 set attributes order apearing.
	 
	 */

	private static final String XML_FILE_NAME = "src/main/resources/xml_source.xml";
	private static final String XSD_FILE_NAME = "src/main/resources/xsd_source.xsd";

	public static void main(String[] args) {
		XmlValidator xmlValidator = new XmlValidator();
		boolean isValid = false;

		File xmlFile = new File(XML_FILE_NAME);
		File xsdSchema = new File(XSD_FILE_NAME);
		isValid = xmlValidator.isValid(xmlFile, xsdSchema);

		System.out.println("Document valid: " + isValid);
	}

}
