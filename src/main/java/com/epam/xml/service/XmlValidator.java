package com.epam.xml.service;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;

public class XmlValidator {

	public boolean isValid(File xmlFile, File xsdSchema) {

		boolean result = true;

		try {
			// parse an XML document into a DOM tree
			DocumentBuilder parser = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			Document document = parser.parse(xmlFile);

			// create a SchemaFactory capable of understanding WXS schemas
			SchemaFactory factory = SchemaFactory
					.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

			// load a WXS schema, represented by a Schema instance
			Source schemaFile = new StreamSource(xsdSchema);
			Schema schema = factory.newSchema(schemaFile);

			// create a Validator instance, which can be used to validate an
			// instance document
			Validator validator = schema.newValidator();

			// validate the DOM tree
			validator.validate(new DOMSource(document));
		} catch (Exception e) {
			result = false;
		}

		return result;
	};

}
