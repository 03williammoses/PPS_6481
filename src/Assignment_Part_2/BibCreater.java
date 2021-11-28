package Assignment_Part_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

/**
 *  @author William Moses Stalin Jebadoss
 * The Class FileInvalidException.
 */

class FileInvalidException extends Exception{

	private static final long serialVersionUID = 1L;

	public FileInvalidException(String s) {
		super(s);
	}
}

/**
 * The Class BibCreater.
 */
public class BibCreater {
	
	/** The Constant article. */
	public final static String article = "@ARTICLE";
	
	/** The valid file. */
	public static boolean validFile = true;
	
	/**
	 * Process files for validation.
	 *
	 * @param bibiliography Scanner
	 * @param ieeeFormat Writer
	 * @param acm Writer
	 * @param njFormat Writer
	 * @return true, if successful
	 * @throws FileInvalidException the file invalid exception
	 */
	@SuppressWarnings("resource")
	public static boolean processFilesForValidation(Scanner bibiliography, PrintWriter ieeeFormat, PrintWriter acm, PrintWriter njFormat) throws FileInvalidException {
		String fullText = null;
		
		// counter variable for acm json
		int acmCount = 1; 
		
		// validFile check
		validFile = true;
		
		// read the whole file and store it in fullText variable
		while(bibiliography.hasNextLine()) {
			if(fullText == null) {
				fullText = bibiliography.nextLine()+"\n";
			} else {
				fullText += bibiliography.nextLine()+"\n";
			}
		}
		String jsonString = null;
		
		// split the fullText of the file based on article which is the start of the json
		String bodyArticle[] = fullText.split(article);
		
		// each json object will iterate individually 
		for(int i=0;i<bodyArticle.length;i++) {
			if(bodyArticle[i].length()!=0) {
				jsonString = bodyArticle[i];
				jsonString = jsonString.trim();
				HashMap<String, String> hm = new HashMap<>();
				if(!(jsonString.charAt(0)=='{') || !(jsonString.charAt(jsonString.length()-1)=='}')) {
					validFile = false;
				} else {   
					bibiliography = new Scanner(jsonString);
					// id - for future reference of the id in each json object
					long id = 0;
					while(bibiliography.hasNextLine()) {
						String temp = bibiliography.nextLine();
						if(!temp.isEmpty() && (temp.matches("[0-9]+") || temp.contains(","))) {
							id = Long.parseLong( temp.contains(",")?temp.replace(",", "").trim():temp.trim());
							break;
						}
					}
					
					/** 
					 * 	line - 	for concatenating each line from the file and evaluate it, 
					 * 			further to write the content from this line to ieee.json, acm.json, np.json
					* */
					String line = null;
					
					while(bibiliography.hasNextLine()) {
						line = bibiliography.nextLine().trim();
						if(line.isEmpty()) {
							continue;
						}
						
						// check whether the first statement starts with close braces which is not the correct format
						if(line.charAt(0)=='}') {
							break;
						}
						
						// check whether each line contains comma at the end of the statement
						if(line.charAt(line.length()-1)!=',') {
							throw new FileInvalidException("File is Invalid: Input  file  cannot  be  parsed  due  to  missing  information \",\" at the field.");
						} 
						
						// removal of comma from the line
						line = line.substring(0, line.length()-1);
						
						// split the key of json based on '='
						String key = line.split("=")[0];
						
						// split the value of json based on '='
						String value = line.split("=")[1];
						
						// check whether the value starts and ends with curly braces
						if(!value.startsWith("{") || !value.endsWith("}")) {
							validFile = false;
							throw new FileInvalidException("File is Invalid: Input  file  cannot  be  parsed  due to file does not start/end with '{' / '}'.");
						} else if(value.length()<3) {	// checks whether the value is empty or anything other than the braces is available
							validFile = false;
							throw new FileInvalidException("File is Invalid: Field \""+key+"\" is Empty. Processing stopped at this point. Other empty fields may be present as well.");
						} else {	// removal of braces from the value
							value = value.substring(1,value.length()-1);
						}
						// check whether the key is already present
						if(!hm.containsKey(key)) {
							hm.put(key, value);
						} else {
							validFile = false;
							throw new FileInvalidException("File is Invalid: Input  file  cannot  be  parsed  due  to duplicate key \""+key+"\" information found.");
						}
					}
				}
				// check whether its valid file or not
				if(validFile) {
					// ieee writing format
					String ieeeStr = hm.get("author").replaceAll(" and", ",")+". \""+hm.get("title")+"\", "+hm.get("journal")+
							", vol. "+hm.get("volume")+", no. "+hm.get("number")+", p. "+hm.get("pages")+", "+hm.get("month")+" "+hm.get("year")+".\n";
					
					// acm writing format
					String acmStr = "["+acmCount+++"]\t"+hm.get("author").split(" and")[0]+" el al. "+hm.get("year")+". "+hm.get("title")+
							". "+hm.get("journal")+". "+hm.get("volume")+", "+hm.get("number")+" ("+hm.get("year")+"), "+hm.get("pages")+
							". DOI:https://doi.org/"+hm.get("doi")+".\n";
					
					// nj writing format
					String njStr = hm.get("author").replaceAll("and", "&")+". "+hm.get("title")+". "+hm.get("journal")+". "+hm.get("volume")+
							", "+hm.get("pages")+"("+hm.get("year")+").\n";
					
					ieeeFormat.println(ieeeStr);
					acm.println(acmStr);
					njFormat.println(njStr);
				}
			}
		}
		return validFile;
	}
	
	/**
	 * Directory clean.
	 *
	 * @param fileName the file name
	 */
	public static void dirClean(int fileName) {
		// respective file path to remove the files
		File ieee = new File("Resources/IEEE"+fileName+".json");
		File acm = new File("Resources/ACM"+fileName+".json");
		File nj = new File("Resources/NJ"+fileName+".json");
		ieee.delete();
		acm.delete();
		nj.delete();
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
			Scanner bib = null;
			PrintWriter ieee = null, acm = null, nj = null;
			System.out.println("Welcome to BibCreator!");
			int invalidFileCount = 0;
			for(int i=1;i<=10;i++) {
				try {
					dirClean(i);
					// read the files
					bib = new Scanner(new FileInputStream("Resources/Latex"+i+".bib"));
					//create new files
					ieee = new PrintWriter(new FileOutputStream("Resources/IEEE"+i+".json"), true);
					acm = new PrintWriter(new FileOutputStream("Resources/ACM"+i+".json"), true);
					nj = new PrintWriter(new FileOutputStream("Resources/NJ"+i+".json"), true);

					// validate and process the files
					processFilesForValidation(bib, ieee, acm, nj);
					
					// close the objects
					bib.close();
					ieee.close();
					acm.close();
					nj.close();
				} catch (FileNotFoundException e) {
					System.out.println("Could not open input file Latex"+i+".bib for reading. \n\nPlease check if file exists! "
							+ "Program will terminate after closing any opened files.");
				} catch (FileInvalidException e) {
					invalidFileCount++;
					System.out.println("\nError : Detected Empty Field!\n=======================\n\nProblem detected with input file: Latex"+i+".bib");
					System.out.println(e.getMessage());
					
					// close the objects
					bib.close();
					ieee.close();
					acm.close();
					nj.close();
					dirClean(i);
				} catch(Exception e) {
					System.out.println("Exception has occurred!!");
				}
			}
			if(invalidFileCount>0) {
				System.out.println("\nA total of "+invalidFileCount+" files were invalid, and could not be processed. All other "+
			(10-invalidFileCount)+" \"Valid\" files have been created.\n");	
			}
			
			
			String fileName = null;
			boolean flag = true;
			
			// number of attempts flag
			int i =0;
			bib = new Scanner(System.in);
			do {
				try {
					System.out.print("Please enter the name of one of the files that you need to review : ");
					fileName = bib.nextLine();
					BufferedReader br = new BufferedReader(new FileReader("Resources/"+fileName));
					flag = false;
					System.out.println("Here are the contents of the successfully created JSON File: "+fileName);
					String strCurrentLine;
					while ((strCurrentLine = br.readLine()) != null) {
						System.out.println(strCurrentLine);
					}
					break;
				} catch(FileNotFoundException f) {
					i++;
					System.out.println(i==1?"Could not open input file. File does not exist; possibly it could not be created!\n":
						"Could not open input file again! Either file does not exist or could not be created.\n");
				} catch (IOException e) {
					System.out.println();
				}
			}while(i<=1);
			
			if(flag) {
				System.out.println("Sorry! I am unable to display your desired files! Program will exit!");
				System.exit(0);
			} else {
				System.out.println("Goodbye! Hope you have enjoyed creating the needed files using BibCreator.");
				System.exit(0);
			}
			
	}

}
