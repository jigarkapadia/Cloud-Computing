import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class proj1_1 {
	
	/* reads line by line from the file and checks for the
	 * given requirements. If the line matches the requirements,
	 * it writes the line to the output file
	 * */
	public static void main(String[] args) throws IOException {
		
		File testcases=new File("pagecounts-20141101-000000");
		BufferedReader br = new BufferedReader(new FileReader(testcases));
		FileWriter fw = new FileWriter("output_temp");
		String this_line=br.readLine();
		//String this_line="";
		while(this_line!=null)
		{
			String[] parts=this_line.split(" ");
			if(test_title(parts[0]))
			{	
				if(test_name(parts[1]))
				{
					fw.write(parts[1] + "\t" + parts[2]+"\n");
				}
			}
			
			this_line=br.readLine();
		}
		br.close();
		fw.close();
	}
	/* Checks if the name is "en" or not */
	static boolean test_title(String s)
	{
		if(s.equals("en"))
			return true;
		return false;
	}
	/* Checks if any of the prohibited strings are present in the title or not */
	static boolean test_name(String s)
	{	
		if(s.contains("Media:") || s.contains("Special:") || s.contains("Talk:") || 
				s.contains("User:") || s.contains("User_talk:") || s.contains("Project:") ||
				s.contains("Project_talk:") || s.contains("File_talk:") || s.contains("MediaWiki:") ||
				s.contains("File:") ||
				s.contains("MediaWiki_talk:") || s.contains("Template:") || s.contains("Template_talk:") ||
				s.contains("Help:") || s.contains("Help_talk:") || s.contains("Category:") ||
				s.contains("Category_talk:") || s.contains("Portal:") || s.contains("Wikipedia:") ||
				s.contains("Wikipedia_talk:") || s.contains("404_error/") || s.contains("Main_Page") ||
				s.contains("Hypertext_Transfer_Protocol") || s.contains("Search") || s.contains(".jpg") ||
				s.contains(".gif") || s.contains(".png") || s.contains(".JPG") ||
				s.contains(".GIF") || s.contains(".PNG") || s.contains(".txt") || s.contains(".ico"))
					return false;
		else
			return true;
	}

}
