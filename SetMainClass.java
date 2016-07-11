/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Administrator
 */
public class SetMainClass {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        FileInputStream fstream = new FileInputStream("src\\Common\\UserAccount.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String tk;
        String mk;
//Read File Line By Line
        if ((tk = br.readLine()) == null) {
            // Print the content on the console
            JFrameMain f = new JFrameMain();
            f.setVisible(true);
        } else {
            LogTimeMain f = new LogTimeMain(tk);
            f.setVisible(true);
        }
//Close the input stream
        br.close();

    }

}
