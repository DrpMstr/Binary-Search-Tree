package BSTBackground;

import java.util.NoSuchElementException;

public class Manager {
    private InfoNode base;

    public Manager(InfoNode base) {
        this.base = base;
    }

    public void print() {
        print(base);
        System.out.println(base);
    }

    private void print(InfoNode root) {
        if( root != null) {
            print(base.left);
            System.out.print(base.right);
            print(base.right);
        }
    }

    public void display() {
        display(base);
    }

    private void display(InfoNode root) {
        if (root != null) {
            display(root.left);
            System.out.println(root.key + ", " +  root.firstName + ", " + root.lastName + ", " + root.address + ", " + root.city + ", " + root.zipCode + ", " + root.email + ", " + root.phoneNumber);
            display(root.right);
        }
    }
    private void displayRight(InfoNode root) {
        if (root != null) {
            display(root.left);
            System.out.println(root.key + ", " +  root.firstName + ", " + root.lastName + ", " + root.address + ", " + root.city + ", " + root.zipCode + ", " + root.email + ", " + root.phoneNumber);
            display(root.right);
        }
    }


    public void find() {
        find(base);
    }

    private void find(InfoNode root) {
        if (root != null) {
            System.out.println(root.key + ", " +  root.firstName + ", " + root.lastName + ", " + root.address + ", " + root.city + ", " + root.zipCode + ", " + root.email + ", " + root.phoneNumber);
        }
    }



    public void lookup(int newKey) {
        find(lookup(base, newKey));
    }

    private InfoNode lookup(InfoNode root, int newKey) {
        if (root == null) {
           // throw new NoSuchElementException();
            System.out.printf("ERROR: Item Does not Exist!%n%n%n%n");
            return null;
        }
        else  if (root.key > newKey) {
            return lookup(root.left, newKey);
        }
        else if (root.key < newKey) {
            return lookup(root.right, newKey);
        }
       // else if (newKey != root.key) {
         //   return
        //}
        else {// root.key == newKey
            return root;
        }
    }

    public void lookupModify(int newKey) {
        find(lookup(base, newKey));
    }

    private InfoNode lookupModify(InfoNode root, int newKey) {
        if (root == null) {
            // throw new NoSuchElementException();
            System.out.print("ERROR: Item Does not Exist!%n%n%n%n");
            return null;
        }
        else  if (root.key > newKey) {
            return lookup(root.left, newKey);
        }
        else if (root.key < newKey) {
            return lookup(root.right, newKey);
        }
        // else if (newKey != root.key) {
        //   return
        //}
        else {// root.key == newKey
            return root;
        }
    }

    public void printS() {
        printS(base, "");
    }

    private void printS(InfoNode root, String indent) {
        if(root != null) {
            printS(root.right, indent + "    ");
            System.out.println(indent + root.key);
            printS(root.left, indent + "     ");
        }

    }

    public int getMin() {
        if(base == null) {
            throw new NoSuchElementException();
        }
        return getMin(base);

    }

    private int getMin(InfoNode root) {
        if(root.left == null) {
            return root.key;
        } else {
            return getMin(root.left);
        }
    }
    //doesnt work properly yet
    public void modify(int newKey, int modCode, String change) {
        base = modify(base, newKey, modCode, change);
    }
    // doesn't work properly yet.
    private InfoNode modify(InfoNode root, int newKey, int modCode, String change) {
        if (root == null) {
            return null;
        }
        else if (root.key > newKey) {
            root.left = modify(root.left, newKey, modCode, change);
        }
        else if (root.key < newKey) {
            root.right = modify(root.left, newKey, modCode, change);
        }
        else {

        }
        return root;
    }

    public void add(int newKey, String fName, String lName, String street, String place, String zip, String mail, String phone) {
        base = add(base, newKey,fName, lName, street, place, zip, mail, phone);
    }

    private InfoNode add(InfoNode root,int newKey, String fName, String lName, String street, String place, String zip, String mail, String phone) {

        if (root == null) {
            root = new InfoNode(newKey, fName, lName, street, place, zip, mail, phone);
        }
        else if (root.key > newKey) {
            root.left = add(root.left,newKey, fName, lName, street, place, zip, mail, phone);
            /*if(root.left == null) {
                root.left = new InfoNode(newKey, fName, lName, street, place, zip, mail, phone);
            }
            else {
                root.left = add(root.left,newKey, fName, lName, street, place, zip, mail, phone);
            }  */

        }
        else if (root.key < newKey) {
            root.right  = add(root.right,newKey, fName, lName, street, place, zip, mail, phone);
           /* if (root.right == null) {
                root.right = new InfoNode(newKey, fName, lName, street, place, zip, mail, phone);
            }
            else {
                root.right  = add(root.right,newKey, fName, lName, street, place, zip, mail, phone);
            }  */

        }
        return root;

    }

    public void remove(int newKey) {
        base = remove(base, newKey);
    }

    private InfoNode remove(InfoNode root, int newKey) {

        if (root == null) {
            return null;
        }
        else if (root.key > newKey) {
            root.left = remove(root.left, newKey);
        }
        else if (root.key < newKey) {
            root.right = remove(root.right, newKey);
        }
        else {
            if (root.right == null) {
                return root.left;
            }
            else if (root.left == null) {
                return root.right;
            }
            else {
                root.key = getMin(root.right);
                root.right = remove(root.right, root.key);
            }
        }
        return root;
    }

    public int size() {
        return size(base);
    }

    private int size(InfoNode root) {
        if (root == null) {
            return 0;
        }
        else {
            return (size(root.left) + 1 + size(root.right));
        }
    }

    /*
    public void modify(String fName, String lName, String street, String place, String zip, String mail, String phone) {

    }
    */



}