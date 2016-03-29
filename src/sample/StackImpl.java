package sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;

import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;

public class StackImpl extends ArrayList{

	/**
	 * @param args
	 * @throws JAXBException 
	 * @throws SAXException 
	 */
	public static void main(String[] args) throws SAXException, JAXBException {
		// TODO Auto-generated method stub
		Stack st = new Stack();
		
		List<String> strList = new ArrayList<String>();
		strList.add("Hi");
		strList.add("There");
		strList.add("Get Lost!");
		java.util.ListIterator<String> listIter = strList.listIterator();
		System.out.println("Items before: "+strList.size());
		while(listIter.hasNext()) {
			System.out.println(listIter.next());			
			((java.util.ListIterator<String>) listIter).remove();
		}
		System.out.println("Items after: "+strList.size());
		Map<String,String> map = new HashMap<String,String>();
		map.put("No", "90");
		map.put("Yes", "100");
		Iterator<Map.Entry<String,String>> iter = map.entrySet().iterator();
		System.out.println("Map before: "+map.size());
	
		while(iter.hasNext()){
			iter.next();
			iter.remove();
		}
		System.out.println("Map after: "+map.size());
		
		List <String> l1 = new ArrayList<String>();
		List<Integer> l2 = new ArrayList<Integer>();
		System.out.println(l1.getClass() == l2.getClass());
		
		//		st.push(2);
//		System.out.println(st.pop());
//		System.out.println(st.peek());
	}
	//Stack --> LiFo
	//Use a HashMap with key as counter, value as element
	//push --> increment counter by 1
	//pop --> size() of map, get last element from size and remove it using Iterator 

}


