package saturnine.practice;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("929 499 7605");
    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();
        while(!quit){
            System.out.println("Enter action\n");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action){
                case 0:
                    System.out.println("\nPhone is shutting down...");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();;
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    checkContact();
                    break;
                case 6:
                   printActions();
                    break;
            }
        }
    }

    private static void startPhone(){
        System.out.println("Starting phone. . .");
    }

    private static void printActions(){
        System.out.println("\nAvailable Actions: \nPress:");
        System.out.println( "0 - to shutdown\n" +
                            "1 - to print contacts\n" +
                            "2 - add a new contact\n" +
                            "3 - update existing contact\n" +
                            "4 - remove existing contact\n" +
                            "5 - query if existing contact exists\n" +
                            "6 - print available actions");
        System.out.println("Choose your action:");
    }

    public static void addNewContact(){
        System.out.println("Enter contact name:");
        String name = scanner.nextLine();
        System.out.println("Enter contact phone:");
        String phoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(name,phoneNumber);
        if(mobilePhone.addNewContact(newContact)){
            System.out.println("New contact " + name + " " + phoneNumber + " has been added");
        }else{
            System.out.println("Can not add a new contact");
        }
    }

    public static void updateContact(){
        System.out.println("Enter which contact would you like to update");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if(existingContact != null){
            System.out.println("Enter a name of new contact:");
            String newContactName = scanner.nextLine();
            System.out.println("Enter a phone of new contact:");
            String newContactphone = scanner.nextLine();
            Contact newContact = Contact.createContact(newContactName,newContactphone);
            mobilePhone.updateContact(existingContact,newContact);
        }else{
            System.out.println("Contact does not exist!");
        }
    }

    public static void removeContact(){
        System.out.println("Enter which contact would you like to remove:");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if(existingContact == null){
            System.out.println("Contact does not exist");
        }else{
            mobilePhone.removeContact(existingContact);
        }
    }

    public static void checkContact(){
        System.out.println("Enter the contact you would like to check:");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if(existingContact == null){
            System.out.println("Contact does not exist");
        }else{
            System.out.println("Name " + existingContact.getName() + " --> "
                    + existingContact.getPhoneNumber());
        }
    }
}
