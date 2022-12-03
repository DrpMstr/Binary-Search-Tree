//made by Cece Rashaan and Nathan

import BSTBackground.InfoNode;
import BSTBackground.Manager;
import java.util.Scanner;


public class NMDictionary {
    public static void main(String[] args) {
        InfoNode info = new InfoNode(50, "ece", "love", "123place", "bham", "23456", "misosoup@foods.com", "5555555550");
        Manager directory = new Manager(info);
        Scanner console = new Scanner(System.in);
        boolean runProgram = true;
        do {
            menu();
            String response = console.next();
            char command = response.charAt(0);
            switch (command) {
                case 'a':
                    addTo(console, directory);
                    System.out.println();
                    break;
                case 'r':
                    System.out.println("Please enter the key for the item you would like to remove: ");
                    int newKey = console.nextInt();
                    System.out.println("Are you sure you want to delete this entry?");
                    String confirm = console.next();
                    if (confirm.charAt(0) == ('y')) {
                        directory.remove(newKey);
                        System.out.println("The entry with key number, " + newKey + " has been removed!");
                    } else {
                        break;
                    }

                    break;
                case 'v':
                    System.out.println("Entry Key, First Name, Last Name, Street Name, City Name, Zip Code, Primary Email Address, Primary Phone Number");
                    directory.display();
                    break;
                case 'l':

                    System.out.println("Please enter the key for the item you would like to view:");
                    System.out.println("Remember to look at the key before submitting");
                    System.out.println("Enter 0 to go back");
                    int findKey = console.nextInt();
                    if (findKey == 0) break;
                    System.out.println("The item corresponding to the key " + findKey + " is:");
                    directory.lookup(findKey);
                    break;
                case 'n':
                    int size = directory.size();
                    System.out.println("There are " + size + " items in the directory.");
                    break;
                case 'm':
                    System.out.println("Please enter the key for the item you would like to modify: ");
                    int modKey = console.nextInt();
                    System.out.println("Are you sure you want to modify this entry?");
                    System.out.println("There is no going back after this");
                    String confirm2 = console.next();
                    if (confirm2.charAt(0) == ('y')) {
                        directory.remove(modKey);
                        addToMod(console, directory, modKey);
                        System.out.println();
                        break;
                    } else {
                        break;
                    }
                case 'q':
                    System.out.println("Thanks for using the Info Center!");
                    runProgram = false;
                default:
                    break;
            }
        } while (runProgram);


    }

    public static void asciiArt() {
        //creates art
        for (int i = 1; i <= 8; i++) {
            System.out.print(" ");
            for (int j = 1; j <= (2 * i + (8 / 2)); j++){
                System.out.print("#");
            }
            for (int j = 1; j <= (-1 * i + (8 + 1)); j++){
                System.out.print(" ");
            }
            for (int j = 1; j <= (2 * i + (8 / 2)); j++){
                System.out.print("#");
            }
            System.out.println();
        }
    }



    public static void menu() {
        //add view tree types
        asciiArt();
        System.out.println("Welcome to the Info Center");
        System.out.println("What would you like to do? ");
        System.out.println("(a)dd to the directory");
        System.out.println("(r)emove from the directory");
        System.out.println("(m)odify an entry");
        System.out.println("(v)iew the directory");
        // add lookup; display from key   
        System.out.println("(l)ookup an entry");
        System.out.println("(n)umber of records");
        System.out.println("(q)uit the program");
    }

    public static void addTo(Scanner console, Manager directory) {
        //the method to add stuff to
        System.out.println("Please fill out the following fields:");
        System.out.println("Please enter the access key: ");
        System.out.println("Enter 0 to go back");
        int keyName = console.nextInt();
        if (keyName == 0) {
            System.out.println();
        } else {
            System.out.print("First Name: ");
            String name1 = console.next();
            System.out.print("Last Name: ");
            String name2 = console.next();
            System.out.print("Address: ");
            String street = console.next();
            System.out.print("City: ");
            String place = console.next();
            System.out.print("ZipCode: ");
            String zip = console.next();
            System.out.print("Email: ");
            String mail = console.next();
            System.out.print("Phone Number: ");
            String phone = console.next();
            directory.add(keyName, name1, name2, street, place, zip, mail, phone);
            System.out.println("Your entry has been successfully added!");
        }
    }
   public static void addToMod(Scanner console, Manager directory, int modKey) {
        //the method for editing data
        System.out.println("Please fill out ALL of the following fields:");
            System.out.print("First Name: ");
            String name1 = console.next();
            System.out.print("Last Name: ");
            String name2 = console.next();
            System.out.print("Address: ");
            String street = console.next();
            System.out.print("City: ");
            String place = console.next();
            System.out.print("ZipCode: ");
            String zip = console.next();
            System.out.print("Email: ");
            String mail = console.next();
            System.out.print("Phone Number: ");
            String phone = console.next();
            directory.add(modKey, name1, name2, street, place, zip, mail, phone);
            System.out.println("Your entry has been successfully added!");
        }
    }
