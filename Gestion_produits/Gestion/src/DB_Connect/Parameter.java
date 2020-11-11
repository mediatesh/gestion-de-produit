/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Connect;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mediatech
 */
public class Parameter {
    Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
    File file = new File(path.toString()+"\\Parameter.txt");
    Scanner scan;
    String[] data = med();
    public String IPHOST = data[0];
    public String PORT = data[1];
    public String NAME_DB = data[2];
    public String HOST_DB = "jdbc:mysql://" + IPHOST + ":"+PORT+"/"+NAME_DB;
    public String USERNAME_DB = data[3];
    public String PASSWORD_DB = data[4];
    public static String USER;

    public String[] med() {
        try {
            this.scan = new Scanner(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Parameter.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] parameter = new String[5];
        int i = 0;
        while(scan.hasNextLine()){ 
            parameter[i]=scan.nextLine();
            i++;
        }
        return parameter;
    }
}
