package algorithmicExamples;

public class Sample {
	
	public static void main(String[] args) {

	    String withString ="";
	    long t0 = System.currentTimeMillis();
	    for (int i = 0 ; i < 100000; i++){
	        withString+="some string";
	    }
	    System.out.println("strings:" + (System.currentTimeMillis() - t0));

	    t0 = System.currentTimeMillis();
	    StringBuffer buf = new StringBuffer();
	    for (int i = 0 ; i < 100000; i++){
	        buf.append("some string");
	    }
	    System.out.println("Buffers : "+(System.currentTimeMillis() - t0));

	    t0 = System.currentTimeMillis();
	    StringBuilder building = new StringBuilder();
	    for (int i = 0 ; i < 100000; i++){
	        building.append("some string");
	    }
	    System.out.println("Builder : "+(System.currentTimeMillis() - t0));
	}

}
