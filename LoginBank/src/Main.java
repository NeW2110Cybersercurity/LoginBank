/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import controller.LoginItem;
import view.Menu;

/**
 *
 * @author Admin
 */

public class Main {
    public static void main(String[] args) {
        String title = "------LOGIN SYSTEMS------- ";
        String[] s = new String[]{"VietNamese Language ", "English Language", "Exit"};
        Menu<String> menu = new LoginItem(title, s);
        menu.run();
    }
}
