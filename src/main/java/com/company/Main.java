package com.company;


import com.company.view.MenuAndDaoTo;

public class Main {

    public static void main(String[] args) {


        try { MenuAndDaoTo.showMenu();
        } catch (Throwable t) {
            System.out.println("Restart Program");
        }



    }
}





