package saturnine.practice;
import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contact> contactList;
    private String phoneNumber;

    public MobilePhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.contactList = new ArrayList<Contact>();
    }

    public void printContacts(){
        System.out.println("Contact List:");
        for(int i = 0; i < this.contactList.size();i++){
            System.out.println((i+1) + "." + this.contactList.get(i).getName() + ":"
                    + this.contactList.get(i).getPhoneNumber());
        }

    }

    public boolean addNewContact(Contact contact){
        if(findContact(contact.getName()) >= 0){
            System.out.println("Contact" + contact.getName() + " already in the list");
            return false;
        }else{
            contactList.add(contact);
            return true;
        }
    }
    public boolean updateContact(Contact contact, Contact newContact){
        if(findContact(contact.getName()) >= 0){
            int index = findContact(contact);
            this.contactList.set(index,newContact);
            return true;
        }else{
            System.out.println(contact.getName() + " was not found;");
            return false;
        }
    }

    private int findContact(Contact contact){
        return this.contactList.indexOf(contact);
    }

    private int findContact(String name){
        for (Contact contact : this.contactList) {
            if (name.equals(contact.getName())) {
                return this.contactList.indexOf(contact);
            }
        }
        return -1;
    }

    public String queryContact(Contact contact){
        if(findContact(contact) >= 0){
            return contact.getName();
        }

        return null;
    }

    public Contact queryContact(String name){
        if(findContact(name) >= 0){
            return this.contactList.get(findContact(name));
        }
        return null;
    }

    public boolean removeContact(Contact contact){
        if(findContact(contact) < 0){
            System.out.println(contact.getName() + " was not found");
            return false;
        }else{
            this.contactList.remove(findContact(contact));
            System.out.println(contact.getName() + " was deleted!");
            return true;
        }
    }


}
