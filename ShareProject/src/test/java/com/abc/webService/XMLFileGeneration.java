package com.abc.webService;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
 
public class XMLFileGeneration {
 
	public static void xmlgenerate(){ 
 
	  try {
 
		  
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
		// root elements
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("suite");
		doc.appendChild(rootElement);
 
		Attr attributeSuite = doc.createAttribute("name");
		attributeSuite.setValue("Suite");
		rootElement.setAttributeNode(attributeSuite);
		
		attributeSuite = doc.createAttribute("parallel");
		attributeSuite.setValue("none");
		rootElement.setAttributeNode(attributeSuite);
		
		// staff elements
		Element test = doc.createElement("test");
		rootElement.appendChild(test);
 
		// set attribute to staff element
		Attr attr = doc.createAttribute("name");
		attr.setValue("Test");
		test.setAttributeNode(attr);
 
		attr = doc.createAttribute("preserve-order");
		attr.setValue("true");
		test.setAttributeNode(attr);
		
 
		// firstname elements
		Element classes = doc.createElement("classes");
		test.appendChild(classes);
 
		// lastname elements
		Element class1 = doc.createElement("class");
		classes.appendChild(class1);
		
		attr = doc.createAttribute("name");
		attr.setValue("com.abc.testscript.javafile");
		class1.setAttributeNode(attr);
		
 
		// nickname elements  methods
		Element methods = doc.createElement("methods");
		class1.appendChild(methods);
		
		
		// lastname elements
				Element include = doc.createElement("include");
				methods.appendChild(include);
				
				attr = doc.createAttribute("name");
				attr.setValue("MethodName");
				include.setAttributeNode(attr);
		
				
				Element listeners = doc.createElement("listeners");
				rootElement.appendChild(listeners);	
 
				
				Element listener = doc.createElement("listener");
				listeners.appendChild(listener);
				attr = doc.createAttribute("class-name");
				attr.setValue("com.abc.listener.TestListener");
				listener.setAttributeNode(attr);
				
	
	
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(System.getProperty("user.dir")+"/testNG.xml"));
 
		// Output to console for testing
	
 
		transformer.transform(source, result);
 
		System.out.println(" XML File saved!");
 
	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  } catch (TransformerException tfe) {
		tfe.printStackTrace();
	  }
	}
}
