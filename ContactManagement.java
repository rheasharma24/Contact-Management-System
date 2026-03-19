package com;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

class Contact{
    String name;
    String email;
    int number;

    Contact(String n,String e,int no){
        this.name=n;
        this.email=e;
        this.number=no;
    }

    void display(){
        System.out.println("name: "+name);
        System.out.println("email: "+email);
        System.out.println("Number: "+number);
    }
}



public class ContactManagement {
    static ArrayList<com.Contact>contacts=new ArrayList<com.Contact>();
    static  Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {

        int choice;
        do{
            System.out.println("1.add contact");
            System.out.println("2.view contact");
            System.out.println("3.search contact");
            System.out.println("4.delete contact");
            System.out.println("5.exit");
            System.out.println("enter choice");
            choice=sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 1:
                    addContact();
                    break;

                case 2:
                    viewContact();
                    break;

                case 3:
                    searchContact();
                    break;

                case 4:
                    DeleteContact();
                    break;

                case 5:
                    System.out.println("exit");
                    break;

                default:
                    System.out.println("invalid choice");

            }

        }while (choice!=5);
    }


    static void addContact(){
        System.out.println("enter name: ");
        String name=sc.nextLine();

        System.out.println("enter email: ");
        String email= sc.nextLine();

        System.out.println("enter number: ");
        int number= sc.nextInt();

        com.Contact c=new com.Contact(name,email,number);
        contacts.add(c);
        System.out.println("contact added successfully! ");
    }

    static void viewContact(){
        if (contacts.isEmpty()) {
            System.out.println("invalid number:");
        }
        for (com.Contact c:contacts){
            c.display();
        }
    }

    static void searchContact(){
        System.out.println("enter name to search: ");
        String name= sc.nextLine();

        for (com.Contact c:contacts){
            if (c.name.equalsIgnoreCase(name));
            c.display();
            return;
        }
    }

    static void DeleteContact(){
        System.out.println("enter name to delete: ");
        String name= sc.nextLine();

        Iterator<com.Contact>it=contacts.iterator();
        while (it.hasNext()){
            com.Contact c=it.next();
            if (c.name.equalsIgnoreCase(name)){
                it.remove();
                System.out.println("contact deleted succesfully: ");
                return;
            }
        }
        System.out.println("contact not found");
    }
}
