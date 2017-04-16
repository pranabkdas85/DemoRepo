import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File_operations {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
				File f= new File("C:\\Users\\Admin\\workspace\\Module 7\\src\\temp.txt");
				f.createNewFile();
				
				//writing
				FileWriter w=new FileWriter("C:\\Users\\Admin\\workspace\\Module 7\\src\\temp.txt");
				BufferedWriter out= new BufferedWriter(w);
				out.write("Hello we are writing the file");
				out.newLine();
				out.write("Second line in the file");
				out.newLine();
				out.write("Third line in the file");
				out.newLine();
				out.write("Forth line in the file");
				out.newLine();
				out.write("Fifth line in the file");
				out.newLine();
				out.write("Sixth line in the file");
				out.flush();
				
				//reading the file
				FileReader r=new FileReader("C:\\Users\\Admin\\workspace\\Module 7\\src\\temp.txt");
				BufferedReader bfr=new BufferedReader(r);
				
				System.out.println(bfr.readLine());// prints the first line
				System.out.println(bfr.readLine());// prints the second line*/
				String x="";
				while ((x = bfr.readLine())!= null)
				System.out.println(x);
					
	}

}
