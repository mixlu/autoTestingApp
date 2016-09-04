package com.example.qinlu.autotesting;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
/**
 * Created by qinlu on 8/22/2016.
 * TABLE_EMISSION - 废气检验员的表格
 * TABLE_EXTERIOR - 外验员的表格
 * TABLE_COMMANDER - 存引车员的表格
 * TABLE_ORG - 检测单位的表格
 * TABLE_VEHICLE - 车辆信息的表格
 */
public class InspectionDataBaseAdapter
{
    public static final String TABLE_VEHICLE = "VEHICLES";
    public static final String TABLE_EMISSION = "EMISSION";
    public static final String TABLE_EXTERIOR = "EXTERIOR";
    public static final String TABLE_COMMANDER = "COMMANDER";
    public static final String TABLE_ORG = "ORG";
    public static final String TABLE_PLATE = "PLATEPREFIX";
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
            +"ID"+" integer primary key autoincrement,"
            + "OPNAME text NOT NULL);";
    static final String CREATE_TABLE_EXTERIOR = "create table " + TABLE_EXTERIOR + "( "
            +"ID"+" integer primary key autoincrement,"
            + "OPNAME text NOT NULL);";
    static final String CREATE_TABLE_COMMANDER = "create table " + TABLE_COMMANDER + "( "
            +"ID"+" integer primary key autoincrement,"
            + "OPNAME text NOT NULL);";
    static final String CREATE_TABLE_ORG = "create table " + TABLE_ORG + "( "
            +"ID"+" integer primary key autoincrement,"
            + "ORGNAME text NOT NULL);";
    static final String CREATE_TABLE_PLATE = "create table " + TABLE_PLATE + "( "
            +"ID"+" integer primary key autoincrement,"
            + "PLATE_PREFIX text NOT NULL);";
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
//    public int deleteEntry(String UserName)
//    {
//        //String id=String.valueOf(ID);
//        String where="USERNAME=?";
//        int numberOFEntriesDeleted= db.delete(TABLE_USER, where, new String[]{UserName}) ;
//        // Toast.makeText(context, "Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_LONG).show();
//        return numberOFEntriesDeleted;
//    }
//    public String getPwd(String userEmail)
//    {
//        Cursor cursor=db.query(TABLE_USER, null, " USEREMAIL=?", new String[]{userEmail}, null, null, null);
//        if(cursor.getCount()<1) // UserName Not Exist
//        {
//            cursor.close();
//            return "NOT EXIST";
//        }
//        cursor.moveToFirst();
//        String password= cursor.getString(cursor.getColumnIndex("PASSWORD"));
//        cursor.close();
//        return password;
//    }
//    public Boolean isUserExist(String userEmail)
//    {
//        Cursor cursor=db.query(TABLE_USER, null, " USEREMAIL=?", new String[]{userEmail}, null, null, null);
//        // User Not Exist
//        if(cursor.getCount()<1)
//        {
//            cursor.close();
//            return false;
//        }
//        return true;
//    }
//    public void updateEntry(String userName, String password)
//    {
//        // Define the updated row content.
//        ContentValues updatedValues = new ContentValues();
//        // Assign values for each row.
//        updatedValues.put("USERNAME", userName);
//        updatedValues.put("PASSWORD",password);
//
//        String where="USERNAME = ?";
//        db.update(TABLE_USER,updatedValues, where, new String[]{userName});
//    }
}