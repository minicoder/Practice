import java.util.Scanner;

//String manipulations
//Hello World
//lastIndexOf("o") = 7 , substring(6)="World", substring(6,8)="Wo", indexOf("o")=4, charAt(6)="W"
public class FileName {
    private String fullPath;
    private char pathSeparator, 
                 extensionSeparator;

    public FileName(String str, char sep, char ext) {
        fullPath = str;
        pathSeparator = sep;
        extensionSeparator = ext;
    }

    public String extension() {
        int dot = fullPath.lastIndexOf(extensionSeparator);
        System.out.println("Dot:"+dot);
        return fullPath.substring(dot + 1);
    }

    // gets filename without extension
    public String filename() {
        int dot = fullPath.lastIndexOf(extensionSeparator);
        int sep = fullPath.lastIndexOf(pathSeparator);
        return fullPath.substring(sep + 1, dot);
    }

    public String path() {
        int sep = fullPath.lastIndexOf(pathSeparator);
        return fullPath.substring(0, sep);
    }
    
    public static void main(String[] args) {
        //final String FPATH = "/home/user/index.html";
        String line;
        Scanner scan = new Scanner(System.in);
		System.out.println("Enter a filename: ");
		line = scan.nextLine();
        FileName myHomePage = new FileName(line, '/', '.');
		System.out.println("Extension = " + myHomePage.extension());
        System.out.println("Filename = " + myHomePage.filename());
        System.out.println("Path = " + myHomePage.path());
    }
}
