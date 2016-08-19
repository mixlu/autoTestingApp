package com.example.qinlu.autotesting;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper
{
    public DataBaseHelper(Context context, String name,CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }
    // Called when no database exists in disk and the helper class needs
    // to create a new one.
    @Override
    public void onCreate(SQLiteDatabase _db)
    {
		// Create USERS Table and insert default value
        _db.execSQL(LoginDataBaseAdapter.DATABASE_CREATE);
		this.addDefaultUser(_db, "admin@admin.com", "admin", "123456");
    }
    // Called when there is a database version mismatch meaning that the version
    // of the database on disk needs to be upgraded to the current version.
    @Override
    public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion)
    {
        // Log the version upgrade.
        Log.w("TaskDBAdapter", "Upgrading from version " +_oldVersion + " to " +_newVersion + ", which will destroy all old data");

        // Upgrade the existing database to conform to the new version. Multiple
        // previous versions can be handled by comparing _oldVersion and _newVersion
        // values.
        // The simplest case is to drop the old table and create a new one.
        _db.execSQL("DROP TABLE IF EXISTS " + "TEMPLATE");
        // Create a new one.
        onCreate(_db);
    }

    public void addDefaultUser(SQLiteDatabase db, String email, String user, String pwd) {
        ContentValues defaultValues = new ContentValues();
        defaultValues.put("USEREMAIL", email);
        defaultValues.put("USERNAME", user);
        defaultValues.put("PASSWORD",pwd);

        // Insert the row into your table
        db.insert(LoginDataBaseAdapter.TABLE_USER, null, defaultValues);
    }
}
