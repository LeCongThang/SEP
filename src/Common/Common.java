/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Common;

import Presentation.JFrameMain;
import Presentation.LogTimeMain;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;

/**
 *
 * @author Administrator
 */
public class Common {

    public static String GetUser() {
        try {
            FileInputStream fstream = new FileInputStream("src\\Common\\UserAccount.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String tk;
            tk = br.readLine();

//Close the input stream
            br.close();
            return tk;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean checkname(String n) {
        Pattern pt = Pattern.compile("[^a-z,0-9  ]", Pattern.CASE_INSENSITIVE);

        Matcher mt1 = pt.matcher(n);
        if (mt1.find()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkusernamepassword(String n) {
        Pattern pt = Pattern.compile("[^a-z,0-9]", Pattern.CASE_INSENSITIVE);
        Matcher mt1 = pt.matcher(n);
        if (mt1.find()) {
            return true;
        } else {
            return false;
        }

    }
    public static void CreateSession(String email,String Pass){
        File file = new File("src\\Common\\UserAccount.txt");
        if (file.exists()) {
            try {
                FileWriter fw = new FileWriter(file, false);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(email);
                bw.newLine();
                bw.write(Pass);
                bw.flush();
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(JFrameMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void DeleteSession()
    {
        try {
            File file = new File("src\\Common\\UserAccount.txt");
            if (file.exists()) {
                try {
                    PrintWriter out = new PrintWriter(new FileWriter(new File("src\\Common\\UserAccount.txt"), false));
                    
                } catch (IOException ex) {
                    Logger.getLogger(JFrameMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           
        } catch (Exception e) {

        }
    }
public static void ChangePass()
    {
        try {
            File file = new File("src\\Common\\UserAccount.txt");
            if (file.exists()) {
                try {
                    PrintWriter out = new PrintWriter(new FileWriter(new File("src\\Common\\UserAccount.txt"), false));
                    
                    
                } catch (IOException ex) {
                    Logger.getLogger(JFrameMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           
        } catch (Exception e) {

        }
    }
}
