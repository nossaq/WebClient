package javaclasses;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class XMLParser {
	
	private String xml;
	Element element;
	
	public String getStartDate(){
		NodeList nodes = element.getElementsByTagName("startDate");
		return nodes.item(0).getFirstChild().getNodeValue();
	}
	
	public void setXML( String xml){
		
		this.xml = xml;
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			InputSource is = new InputSource();
	        is.setCharacterStream(new StringReader( this.xml));
	        
			Document doc = dBuilder.parse( is);
			element = doc.getDocumentElement();
		} catch (SAXException saxe) {
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static String getValue(String tag, Element element) {
	//http://javarevisited.blogspot.com/2011/12/parse-xml-file-in-java-example-tutorial.html
		
		NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = (Node) nodes.item(0);
		return node.getNodeValue();
	}
}


