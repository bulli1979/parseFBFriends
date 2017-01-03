package me.sna;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

public class Worker {

	public void start() throws IOException {
		InputStream is = null;
		is = this.getClass().getClassLoader().getResourceAsStream("meberlein.html");
		String filestring = IOUtils.toString(is, "utf-8"); 
		String[] friends =  filestring.split(" Freunde</");
		int count = 0;
		for(String friend : friends){
			try{
				String[] split = friend.split(">");
				String entry = split[split.length-1];
				if(!entry.endsWith("gemeinsame")&& !entry.equals("Alle")){
					int current = Integer.parseInt(entry.replace(".", ""));
					count+=current;
				}
			}catch(Exception e){
				//Falls ein Fehler auftritt beim parsen ignorieren
				System.out.println("hardcore Coding fix wie nix");
			}
			
		}
		System.out.println(count);
		is.close();
	}
}
