package com.example.qinlu.autotesting;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
/**
 * Created by qinlu on 7/28/2016.
 */
public class LoginDataBaseAdapter
{
    static final String DATABASE_NAME = "cars.db";
    public static final String TABLE_USER = "USERS";
    static final int DATABASE_VERSION = 1;
    public static final int NAME_COLUMN = 1;
    // TODO: Create public field for each column in your table.
    // SQL Statement to create a new database.
    static final String DATABASE_CREATE = "create table " + TABLE_USER +
            "( " +"ID"+" integer primary key autoincrement,"+ "USEREMAIL text NOT NULL, USERNAME text NOT NULL, PASSWORD text NOT NULL);";
    // Variable to hold the database instance
    public  SQLiteDatabase db;
    // Context of the application using the database.
    private final Context context;
    // Database open/upgrade helper
    private DataBaseHelper dbHelper;
    public  LoginDataBaseAdapter(Context _context)
    {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public  LoginDataBaseAdapter open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }
    public void close()
    {
        db.close();
    }

    public  SQLiteDatabase getDatabaseInstance()
    {
        return db;
    }

    public void insertEntry(String userEmail, String userName,String password)
    {
        ContentValues newValues = new ContentValues();
        newValues.put("USEREMAIL", userEmail);
        newValues.put("USERNAME", userName);
        newValues.put("PASSWORD",password);

        // Insert the row into your table
        db.insert(TABLE_USER, null, newValues);
        ///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
    }
    public int deleteEntry(String UserName)
    {
        //String id=String.valueOf(ID);
        String where="USERNAME=?";
        int numberOFEntriesDeleted= db.delete(TABLE_USER, where, new String[]{UserName}) ;
        // Toast.makeText(context, "Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
        return numberOFEntriesDeleted;
    }
    public String getPwd(String userEmail)
    {
        Cursor cursor=db.query(TABLE_USER, null, " USEREMAIL=?", new String[]{userEmail}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
        cursor.close();
        return password;
    }
    public Boolean isUserExist(String userEmail)
    {
        Cursor cursor=db.query(TABLE_USER, null, " USEREMAIL=?", new String[]{userEmail}, null, null, null);
        // User Not Exist
        if(cursor.getCount()<1)
        {
            cursor.close();
            return false;
        }
        return true;
    }
    public void updateEntry(String userName, String password)
    {
        // Define the updated row content.
        ContentValues updatedValues = new ContentValues();
        // Assign values for each row.
        updatedValues.put("USERNAME", userName);
        updatedValues.put("PASSWORD",password);

        String where="USERNAME = ?";
        db.update(TABLE_USER,updatedValues, where, new String[]{userName});
    }
}