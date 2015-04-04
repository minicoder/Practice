import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException; 
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.*;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.Entity;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class DOMEcho {
	static final String outputEncoding = "UTF-8";
	
	public static void main(String[] args) {
		String filename = "xml/employee.xml";
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(ClassLoader.getSystemResourceAsStream(filename));
			
			List<Employee> employeeList = new ArrayList<Employee>();
			
			NodeList nodes = doc.getDocumentElement().getChildNodes();
			
			for(int i = 0 ; i < nodes.getLength() ; i++) {
				Node node = nodes.item(i);
				if(node instanceof Element) {
					Employee emp = new Employee();
					emp.id = node.getAttributes().getNamedItem("id").getNodeValue();
				}
			}
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}