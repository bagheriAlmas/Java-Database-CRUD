package ir.almasapps.javadatabasesqlitecrud.Database.View;

import android.content.Context;

import java.util.List;

import ir.almasapps.javadatabasesqlitecrud.Database.Controller.MyDB;
import ir.almasapps.javadatabasesqlitecrud.Database.Model.Contact;


/**
 * Created by Mahdi on 9/28/17.
 */

public class CreateView {
    Context context;
    MyDB myDB;

    public CreateView(Context context) {
        this.context = context;
        myDB = new MyDB(context);
    }

    //Insert Contact
    public long insertContact(String name,String phone,String email ,int image){
        return myDB.insertContactt(new Contact(name,phone,email,image));
    }

    // get All Contacts
    public List<Contact> getAllContacts(){
        return myDB.getAllContacts();
    }

    // GET CONTACT BY ID
    public Contact getContactByID(int id){
        return myDB.getContactByID(id);
    }

    //UPDATE CONTACT
    public long updateContact(int id,String name,String phone,String email ,int image){
        return myDB.updateContact(new Contact(id,name,phone,email,image));
    }

    // DELETE CONTACT BY ID
    public int deleteContactByID(int id){
        return myDB.deleteContactByID(id);
    }

    // CONTACT COUNT
    public int getContactCount(){
        return myDB.getContactsCount();
    }
}
