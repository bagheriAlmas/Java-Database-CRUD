package ir.almasapps.javadatabasesqlitecrud.Database.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import ir.almasapps.javadatabasesqlitecrud.Database.Model.Contact;

/**
 * Created by Mahdi on 9/28/17.
 */

public class MyDB extends SQLiteOpenHelper{
    private final static String DB_NAME = "db_contacts";
    private final static int DB_VERSION = 1;
    private final static String TABLE_NAME = "tbl_contact";
    private final static String KEY_CONTACT_ID = "contact_id";
    private final static String KEY_CONTACT_NAME = "contact_name";
    private final static String KEY_CONTACT_PHONE = "contact_phone";
    private final static String KEY_CONTACT_EMAIL = "contact_email";
    private final static String KEY_CONTACT_IMAGE = "contact_imagee";


    public MyDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String strSQL = "CREATE TABLE " + TABLE_NAME + " ( "
                + KEY_CONTACT_ID + " INTEGER PRIMARY KEY , "
                + KEY_CONTACT_NAME + " TEXT , "
                + KEY_CONTACT_PHONE + " TEXT , "
                + KEY_CONTACT_EMAIL + " TEXT , "
                + KEY_CONTACT_IMAGE + " INTEGER);";
        db.execSQL(strSQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //INSERT CONTACT
    public long insertContactt(Contact contact){
        long result;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CONTACT_NAME,contact.getName());
        values.put(KEY_CONTACT_PHONE,contact.getPhone());
        values.put(KEY_CONTACT_EMAIL,contact.getEmail());
        values.put(KEY_CONTACT_IMAGE,contact.getImage());

        result = db.insert(TABLE_NAME,null,values);
        db.close();
        return result;
    }

    //GET BY ID
    public Contact getContactByID(int id) {

        Contact contact = new Contact();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{KEY_CONTACT_ID,KEY_CONTACT_NAME,KEY_CONTACT_PHONE,KEY_CONTACT_EMAIL,KEY_CONTACT_IMAGE}
                , KEY_CONTACT_ID + "=? ", new String[]{id+""}
                , null, null, null, null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                contact.setId(cursor.getInt(0));
                contact.setName(cursor.getString(1));
                contact.setPhone(cursor.getString(2));
                contact.setEmail(cursor.getString(3));
                contact.setImage(cursor.getInt(4));
            }
        }
        cursor.close();
        db.close();

        return contact;
    }

    // GET ALL
    public List<Contact> getAllContacts(){
        List<Contact> contactsList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String strSQL = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(strSQL,null);
        if( cursor != null){
            if(cursor.moveToFirst()){
                do{
                    Contact tmp = new Contact();
                    tmp.setId(cursor.getInt(0));
                    tmp.setName(cursor.getString(1));
                    tmp.setPhone(cursor.getString(2));
                    tmp.setEmail(cursor.getString(3));
                    tmp.setImage(cursor.getInt(4));
                    contactsList.add(tmp);

                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        db.close();
        return contactsList;
    }

    // UPDATE
    public int updateContact(Contact contact) {
        int result = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CONTACT_NAME, contact.getName());
        values.put(KEY_CONTACT_PHONE, contact.getPhone());
        values.put(KEY_CONTACT_EMAIL, contact.getEmail());
        values.put(KEY_CONTACT_IMAGE, contact.getImage());

        result = db.update(TABLE_NAME, values, KEY_CONTACT_ID + "=? ", new String[]{contact.getId() + ""});
        db.close();
        return result;
    }


    // DELETE
    public int deleteContactByID (int ID){
        int result =0;
        SQLiteDatabase db = this.getWritableDatabase();
        result = db.delete(TABLE_NAME,KEY_CONTACT_ID+"= ?",new String[]{String.valueOf(ID)});
        db.close();
        return result;
    }

    // TABLE COUNT
    public int getContactsCount() {
        int result = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        String strSQL = "select * from " + TABLE_NAME;

        Cursor cursor = db.rawQuery(strSQL, null);
        if (cursor != null) {
            result = cursor.getCount();
        }
        cursor.close();
        db.close();
        return result;
    }
}
