/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Locale;
import model.LoginManager;
import view.Menu;

/**
 *
 * @author Admin
 */
public class LoginItem extends Menu<String>{

    public LoginItem(String title, String[] s){
        super(title, s);
    }
    
    @Override
    public void execute(int n) {
        Locale vietnamese = new Locale("vi");
        Locale english = Locale.ENGLISH;
        switch (n) {
            case 1:
                LoginManager.login(vietnamese);
                break;
            case 2:
                LoginManager.login(english);
                break;
            case 3:
                System.exit(0); 
                break;
        }
    }
}


