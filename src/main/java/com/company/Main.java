package com.company;


import com.company.Dao.MenuAndDaoTo;

public class Main {

    public static void main(String[] args) {


        try { MenuAndDaoTo.showMenu();
        } catch (Throwable t) {
            System.out.println("Restart Program");
        }



    }
}





