package fr.ensisa.code_generator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Factory {

	private File file;
	
	public Factory() {
		setFile("output.html");
	}
	
	public void setFile(String filename) {
		file = new File(filename);
		this.clearFile();
	}
	
	public String createComment(Object id) {
		return "\n<span class=\"comment\">" + id + "</span>";
	}
	
	public String createKeyword(Object k) {
		System.out.println("key : " + k);
		return "<span class=\"keyword\">" + k + " </span>";
	}
	
	public String createKeywords(Object keys, Object key) {
		System.out.println("keys " + keys + "  key : " + key);
		return (String)keys + (String)key;
	}
	
	public String createVariable(Object m, Object id) {
		System.out.println("m " + m + "  id : " + id);
		return  "\t" + m + id + ";";
	}
	
	public String createFunction(Object m, Object id) {
		System.out.println("m " + m + "  id : " + id);
		return  "\t" + m + id + "()";
	}
	
	public String createClass(Object m, Object id, Object fd) {
		return  m + this.createKeyword("class") + id + "{\n" + fd + "\n }\n	</pre>\n</section>\n</body>\n</html>";
	}
	
	public void appendToFile(Object d, Object c) {
		if (file == null) return;
		try(PrintWriter output = new PrintWriter(new FileWriter(file, true))) 
		{
		    output.printf("%s\r\n", d);
		    output.printf("%s\r\n", c);
		} 
		catch (Exception e) {}
	}
	
	public void clearFile() {
		try {
			this.copierFichier("template.txt", "output.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void copierFichier(String source, String destination) throws IOException {
	    FileInputStream fis = null;
	    FileOutputStream fos = null;

	    try {
	      byte buffer[] = new byte[1024];
	      int taille = 0;

	      fis = new FileInputStream(source);
	      fos = new FileOutputStream(destination);
	      while ((taille = fis.read(buffer)) != -1) {
	        fos.write(buffer, 0, taille);
	      }
	    } finally {
	      if (fis != null) {
	        try {
	          fis.close();
	        } catch (IOException e) {
	        }
	      }
	      if (fos != null) {
	        try {
	          fos.close();
	        } catch (IOException e) {
	        }
	      }
	    }
	}
}
