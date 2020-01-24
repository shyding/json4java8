package example06;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import jsonHub.JsonHub;

public class PojoWritePrettyPrintJsonToFile {
	public int num;
	public String str;
	public boolean bool;
	public Object nul;
	public List<String> list;
	
	protected float not_parse_because_not_public;
	public static long not_parse_because_static = -1L;
	
	public PojoWritePrettyPrintJsonToFile() {
		
		num = 1;
		str = "STRING";
		bool = true;
		nul = null;
		list = Arrays.asList("a", "b", "c");
		
		not_parse_because_not_public = -1.0F;
	}

	public static void main(String[] args) {
		
		Path path = Paths.get("path_to_file.json");
		
		PojoWritePrettyPrintJsonToFile pojo = new PojoWritePrettyPrintJsonToFile();
		
		try {
			JsonHub.fromPojo(pojo).prettyPrint(path);
			System.out.println("wrote to " + path.toAbsolutePath());
		}
		catch ( IOException e ) {
			e.printStackTrace();
			System.out.println("write failed");
		}
	}
	
}
