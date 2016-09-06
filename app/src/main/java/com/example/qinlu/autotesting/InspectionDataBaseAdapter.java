package com.example.qinlu.autotesting;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qinlu on 8/22/2016.
 * TABLE_VEHICLE - 车辆信息的表格
 * TABLE_EMISSION - 废气检验员的表格
 * TABLE_EXTERIOR - 外验员的表格
 * TABLE_COMMANDER - 存引车员的表格
 * TABLE_ORG - 检测单位的表格
 * TABLE_MAKEMODEL - 厂牌型号的表格
 * TABLE_PLATE - 号牌前缀的表格
 */
public class InspectionDataBaseAdapter
{
    public static final String TABLE_VEHICLE = "VEHICLES";
    public static final String TABLE_EMISSION = "EMISSION";
    public static final String TABLE_EXTERIOR = "EXTERIOR";
    public static final String TABLE_COMMANDER = "COMMANDER";
    public static final String TABLE_ORG = "ORG";
    public static final String TABLE_PLATE_PREFIX = "PLATEPREFIX";
    public static final String TABLE_PLATE_TYPE = "PLATETYPE";
    // SQL Statement to create a new databases.
    static final String CREATE_TABLE_VEHICLE = "create table " + TABLE_VEHICLE + "( "
            +"ID"+" integer primary key autoincrement,"
            + "PLATE_NUMBER integer NOT NULL,"
            + "ENGINE_NUMBER text NOT NULL,"
            + "MAKE_MODLE text NOT NULL,"
            + "VIN_NUMBER text NOT NULL,"
            + "OWNER_NAME text NOT NULL,"
            + "VEH_TYPE text NOT NULL,"
            + "REGISTER_DATE date NOT NULL,"
            + "FUEL_TYTE text NOT NULL,"
            + "SEAT_NUMBER integer NOT NULL,"
            + "BASE_WEIGHT integer NOT NULL,"
            + "WHOLE_WEIGHT integer NOT NULL,"
            + "CONDITION_LEVEL text NOT NULL,"
            + "LIGHT_TYPE text NOT NULL,"
            + "PLATE_TYPE text NOT NULL,"
            + "LICENCE_NUMBER text NOT NULL,"
            + "BRAKE_TYPE text NOT NULL);";
    static final String CREATE_TABLE_EMISSION = "create table " + TABLE_EMISSION + "( "
            +"_id"+" integer primary key autoincrement,"
            + "OPNAME text NOT NULL);";
    static final String CREATE_TABLE_EXTERIOR = "create table " + TABLE_EXTERIOR + "( "
            +"_id"+" integer primary key autoincrement,"
            + "OPNAME text NOT NULL);";
    static final String CREATE_TABLE_COMMANDER = "create table " + TABLE_COMMANDER + "( "
            +"_id"+" integer primary key autoincrement,"
            + "OPNAME text NOT NULL);";
    static final String CREATE_TABLE_ORG = "create table " + TABLE_ORG + "( "
            +"_id"+" integer primary key autoincrement,"
            + "ORGNAME text NOT NULL);";
    static final String CREATE_TABLE_PLATE_PREFIX = "create table " + TABLE_PLATE_PREFIX + "( "
            +"_id"+" integer primary key autoincrement,"
            + "PLATE_PREFIX text NOT NULL);";
    static final String CREATE_TABLE_PLATE_TYPE = "create table " + TABLE_PLATE_TYPE + "( "
            +"_id"+" integer primary key autoincrement,"
            + "PLATE_TYPE text NOT NULL);";
    // Variable to hold the database instance
    public  SQLiteDatabase db;
    // Context of the application using the database.
    private final Context context;
    // Database open/upgrade helper
    private DataBaseHelper dbHelper;
    public  InspectionDataBaseAdapter(Context _context)
    {
        context = _context;
        dbHelper = new DataBaseHelper(context, DataBaseHelper.DATABASE_NAME, null, DataBaseHelper.DATABASE_VERSION);
    }
    public  InspectionDataBaseAdapter open() throws SQLException
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

    public void insertItemToTable(String emissonName, String tableName) {
        String colName = getRightColName(tableName);
        ContentValues contentValue = new ContentValues();
        contentValue.put(colName, emissonName);
        db.insert(tableName, null, contentValue);
    }

    public int updateItem(long _id, String itemName, String tableName) {
        String colName = getRightColName(tableName);
        ContentValues contentValues = new ContentValues();
        contentValues.put(colName, itemName);
        int i = db.update(tableName, contentValues, "_id = " + _id, null);
        return i;
    }

    public void deleteItemFromTable(long _id, String table) {
        db.delete(table, "_id = " + _id, null);
    }

    public boolean isExistedItem(String itemName, String dbTable) {
        String colName = getRightColName(dbTable);
        Cursor cursor=db.query(dbTable, null, colName + "=?", new String[]{itemName}, null, null, null);
        // User Not Exist
        if(cursor.getCount()<1)
        {
            cursor.close();
            return false;
        }
        return true;
    }

    public Cursor fetch(String tableName) {
        String colName = getRightColName(tableName);
        String[] columns = new String[] {"_id", colName};
        Cursor cursor = db.query(tableName, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    private String getRightColName(String tableName) {
        String colName = "OPNAME";
        switch (tableName){
            case TABLE_ORG:
                colName = "ORGNAME";
                break;
            case TABLE_PLATE_PREFIX:
                colName = "PLATE_PREFIX";
                break;
            case TABLE_PLATE_TYPE:
                colName = "PLATE_TYPE";
                break;
        }
        return colName;
    }
    public List<String> getPlatePrefix() {
        List<String> platePrefixList = new ArrayList<String>();

        Cursor cursor = db.rawQuery("SELECT PLATE_PREFIX FROM " + TABLE_PLATE_PREFIX, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                platePrefixList.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return platePrefixList;
    }

    public List<String> getPlateType() {
        List<String> plateTypeList = new ArrayList<String>();

        Cursor cursor = db.rawQuery("SELECT PLATE_TYPE FROM " + TABLE_PLATE_TYPE, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                plateTypeList.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return plateTypeList;
    }

    public List<String> getEmission() {
        List<String> emissionList = new ArrayList<String>();

        Cursor cursor = db.rawQuery("SELECT OPNAME FROM " + TABLE_EMISSION, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                emissionList.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return emissionList;
    }

    public List<String> getCommander() {
        List<String> commanderList = new ArrayList<String>();

        Cursor cursor = db.rawQuery("SELECT OPNAME FROM " + TABLE_COMMANDER, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                commanderList.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return commanderList;
    }

    public List<String> getExterior() {
        List<String> exteriorList = new ArrayList<String>();

        Cursor cursor = db.rawQuery("SELECT OPNAME FROM " + TABLE_EXTERIOR, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                exteriorList.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return exteriorList;
    }
//    public void insertVehicle(Vehicle newveh)
//    {
//        ContentValues newValues = new ContentValues();
//        newValues.put("PLATE_NUMBER", newveh);
//        newValues.put("ENGINE_NUMBER", userName);
//        newValues.put("MAKE_MODLE",password);
//        newValues.put("VIN_NUMBER", userEmail);
//        newValues.put("OWNER_NAME", userName);
//        newValues.put("SEAT_NUMBER",password);
//        newValues.put("BASE_WEIGHT", userEmail);
//        newValues.put("WHOLE_WEIGHT", userName);
//        newValues.put("CONDITION_LEVEL",password);
//        newValues.put("LIGHT_TYPE", userEmail);
//        newValues.put("PLATE_TYPE", userName);
//        newValues.put("LICENCE_NUMBER",password);
//        newValues.put("BRAKE_TYPE", userEmail);
//        newValues.put("ENGINE_NUMBER", userName);
//        newValues.put("MAKE_MODLE",password);
//
//        // Insert the row into your table
//        db.insert(TABLE_USER, null, newValues);
//        ///Toast.makeText(context, "Reminder Is Successfully Saved", Toast.LENGTH_LONG).show();
//    }
}