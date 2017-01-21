package com.example.qinlu.autotesting;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.qinlu.autotesting.model.VehicleModel;

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
 * TABLE_REPORT - 报告表格
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
    public static final String TABLE_REPORT = "REPORT";

    // SQL Statement to create a new databases.
    static final String CREATE_TABLE_VEHICLE = "create table " + TABLE_VEHICLE + "( "
            + "_id integer primary key autoincrement,"
            + "PLATE_NUMBER integer NOT NULL,"
            + "PLATE_PREFIX text NOT NULL,"
            + "ENGINE_NUMBER text NOT NULL,"
            + "MAKE_MODEL text NOT NULL,"
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
            + "_id integer primary key autoincrement,"
            + "OPNAME text NOT NULL);";
    static final String CREATE_TABLE_EXTERIOR = "create table " + TABLE_EXTERIOR + "( "
            + "_id integer primary key autoincrement,"
            + "OPNAME text NOT NULL);";
    static final String CREATE_TABLE_COMMANDER = "create table " + TABLE_COMMANDER + "( "
            + "_id integer primary key autoincrement,"
            + "OPNAME text NOT NULL);";
    static final String CREATE_TABLE_ORG = "create table " + TABLE_ORG + "( "
            + "_id integer primary key autoincrement,"
            + "ORGNAME text NOT NULL);";
    static final String CREATE_TABLE_PLATE_PREFIX = "create table " + TABLE_PLATE_PREFIX + "( "
            + "_id integer primary key autoincrement,"
            + "PLATE_PREFIX text NOT NULL);";
    static final String CREATE_TABLE_PLATE_TYPE = "create table " + TABLE_PLATE_TYPE + "( "
            + "_id integer primary key autoincrement,"
            + "PLATE_TYPE text NOT NULL);";
    static final String CREATE_TABLE_REPORT = "create table " + TABLE_REPORT + "( "
            + "_id INTEGER primary key autoincrement,"
            + "VEC_ID INTEGER NOT NULL,"
            + "CREATE_DATE DATETIME NOT NULL,"
            + "EMISSION INTEGER NOT NULL,"
            + "EXTERIOR INTEGER NOT NULL,"
            + "COMMANDER INTEGER NOT NULL,"
            + "IS_TESTED INTEGER DEFAULT 0,"
            + "SHAFT1_WHEEL_L TEXT,"
            + "SHAFT1_WHEEL_R TEXT,"
            + "SHAFT1_WHEEL_D_L TEXT,"
            + "SHAFT1_WHEEL_D_R TEXT,"
            + "SHAFT1_BRAKE_L TEXT,"
            + "SHAFT1_BRAKE_R TEXT,"
            + "SHAFT1_DIFF_L TEXT,"
            + "SHAFT1_DIFF_R TEXT,"
            + "SHAFT1_BRAKE_RATIO TEXT,"
            + "SHAFT1_BALANCE_RATIO TEXT,"
            + "SHAFT1_RATE TEXT,"
            + "SHAFT1_BALANCE_RATE TEXT,"
            + "SHAFT1_BRAKE_BALANCE_RATE TEXT,"
            + "SHAFT2_WHEEL_L TEXT,"
            + "SHAFT2_WHEEL_R TEXT,"
            + "SHAFT2_WHEEL_D_L TEXT,"
            + "SHAFT2_WHEEL_D_R TEXT,"
            + "SHAFT2_BRAKE_L TEXT,"
            + "SHAFT2_BRAKE_R TEXT,"
            + "SHAFT2_DIFF_L TEXT,"
            + "SHAFT2_DIFF_R TEXT,"
            + "SHAFT2_BRAKE_RATIO TEXT,"
            + "SHAFT2_BALANCE_RATIO TEXT,"
            + "SHAFT2_RATE TEXT,"
            + "SHAFT2_BALANCE_RATE TEXT,"
            + "SHAFT2_BRAKE_BALANCE_RATE TEXT,"
            + "SHAFT3_WHEEL_L TEXT,"
            + "SHAFT3_WHEEL_R TEXT,"
            + "SHAFT3_WHEEL_D_L TEXT,"
            + "SHAFT3_WHEEL_D_R TEXT,"
            + "SHAFT3_BRAKE_L TEXT,"
            + "SHAFT3_BRAKE_R TEXT,"
            + "SHAFT3_DIFF_L TEXT,"
            + "SHAFT3_DIFF_R TEXT,"
            + "SHAFT3_BRAKE_RATIO TEXT,"
            + "SHAFT3_BALANCE_RATIO TEXT,"
            + "SHAFT3_RATE TEXT,"
            + "SHAFT3_BALANCE_RATE TEXT,"
            + "SHAFT3_BRAKE_BALANCE_RATE TEXT,"
            + "SHAFT4_WHEEL_L TEXT,"
            + "SHAFT4_WHEEL_R TEXT,"
            + "SHAFT4_WHEEL_D_L TEXT,"
            + "SHAFT4_WHEEL_D_R TEXT,"
            + "SHAFT4_BRAKE_L TEXT,"
            + "SHAFT4_BRAKE_R TEXT,"
            + "SHAFT4_DIFF_L TEXT,"
            + "SHAFT4_DIFF_R TEXT,"
            + "SHAFT4_BRAKE_RATIO TEXT,"
            + "SHAFT4_BALANCE_RATIO TEXT,"
            + "SHAFT4_RATE TEXT,"
            + "SHAFT4_BALANCE_RATE TEXT,"
            + "SHAFT4_BRAKE_BALANCE_RATE TEXT,"
            + "BRAKE_RATE_L TEXT,"
            + "BRAKE_RATE_R TEXT,"
            + "MANUAL_BRAKE_RATIO TEXT,"
            + "PARK_RATE TEXT,"
            + "VEC_WEIGHT TEXT,"
            + "VEC_BRAKE TEXT,"
            + "VEC_BRAKE_RATIO TEXT,"
            + "VEC_BRAKE_RATIO_RATE TEXT,"
            + "SLIDE TEXT,"
            + "SLIDE_RATE TEXT,"
            + "FOREIGN KEY(VEC_ID) REFERENCES " + TABLE_VEHICLE + "(ID),"
            + "FOREIGN KEY(EMISSION) REFERENCES " + TABLE_EMISSION + "(ID),"
            + "FOREIGN KEY(EXTERIOR) REFERENCES " + TABLE_EXTERIOR + "(ID),"
            + "FOREIGN KEY(COMMANDER) REFERENCES " + TABLE_COMMANDER + "(ID)"
            + ");";
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

    public int updateItem(long id, String itemName, String tableName) {
        String colName = getRightColName(tableName);
        ContentValues contentValues = new ContentValues();
        contentValues.put(colName, itemName);
        int i = db.update(tableName, contentValues, "ID = " + id, null);
        return i;
    }

    public void deleteItemFromTable(long id, String table) {
        db.delete(table, "_id = " + id, null);
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

    // TODO: Add precondition not null check
    public void insertVehicle(VehicleModel newVeh)
    {
        ContentValues newValues = new ContentValues();
        newValues.put("PLATE_NUMBER", newVeh.getPlateNumber());
        newValues.put("PLATE_PREFIX", newVeh.getPlatePrefix());
        newValues.put("ENGINE_NUMBER", newVeh.getEngineNumber());
        newValues.put("MAKE_MODEL", newVeh.getMakeModel());
        newValues.put("VIN_NUMBER", newVeh.getVinNumber());
        newValues.put("OWNER_NAME", newVeh.getOwner());
        newValues.put("VEH_TYPE", newVeh.getVehType());
        newValues.put("REGISTER_DATE", newVeh.getRegisterDate().toString());
        newValues.put("FUEL_TYPE", newVeh.getFuleType());
        newValues.put("SEAT_NUMBER", newVeh.getSeatNumber());
        newValues.put("BASE_WEIGHT", newVeh.getBaseWeight());
        newValues.put("WHOLE_WEIGHT", newVeh.getWholeWeight());
        newValues.put("CONDITION_LEVEL", newVeh.getConditionLevel());
        newValues.put("LIGHT_TYPE", newVeh.getLightType());
        newValues.put("PLATE_TYPE", newVeh.getPlateType());
        newValues.put("LICENCE_NUMBER", newVeh.getLicenseNumber());
        newValues.put("BRAKE_TYPE", newVeh.getBrakeType());

        // Insert the row into VEHICLE table
        db.insert(TABLE_VEHICLE, null, newValues);
    }

    public boolean isVehicleExisted(CarBasicInfoModel car){
        String platePrefix = car.getPrefix();
        String plateNum = car.getNumber();
        String plateType = car.getType();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_VEHICLE + " WHERE PLATE_PREFIX=? AND PLATE_NUMBER=? AND PLATE_TYPE", new String[]{platePrefix, plateNum, plateType});
        // Vehicle Not Exist
        if(cursor.getCount()<1)
        {
            cursor.close();
            return false;
        }
        return true;
    }

    /* Get vehicle whole information from database by given basic veh info
     * @return vehicle model
     */
    public VehicleModel getVehInfo(CarBasicInfoModel car){
        VehicleModel veh = new VehicleModel();
        if (isVehicleExisted(car)) {
            String platePrefix = car.getPrefix();
            String plateNum = car.getNumber();
            String plateType = car.getType();
            Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_VEHICLE + " WHERE PLATE_PREFIX=? AND PLATE_NUMBER=? AND PLATE_TYPE", new String[]{platePrefix, plateNum, plateType});

            veh.setPlatePrefix(cursor.getString(cursor.getColumnIndex("PLATE_NUMBER")));
            veh.setPlateNumber(cursor.getString(cursor.getColumnIndex("PLATE_PREFIX")));
            veh.setEngineNumber(cursor.getString(cursor.getColumnIndex("ENGINE_NUMBER")));
            veh.setMakeModel(cursor.getString(cursor.getColumnIndex("MAKE_MODEL")));
            veh.setVinNumber(cursor.getString(cursor.getColumnIndex("VIN_NUMBER")));
            veh.setOwner(cursor.getString(cursor.getColumnIndex("OWNER_NAME")));
            veh.setVehType(cursor.getString(cursor.getColumnIndex("VEH_TYPE")));
            veh.setRegisterDate(cursor.getString(cursor.getColumnIndex("REGISTER_DATE")));
            veh.setFuleType(cursor.getString(cursor.getColumnIndex("FUEL_TYPE")));
            veh.setSeatNumber(cursor.getInt(cursor.getColumnIndex("SEAT_NUMBER")));
            veh.setBaseWeight(cursor.getInt(cursor.getColumnIndex("BASE_WEIGHT")));
            veh.setWholeWeight(cursor.getInt(cursor.getColumnIndex("WHOLE_WEIGHT")));
            veh.setConditionLevel(cursor.getString(cursor.getColumnIndex("CONDITION_LEVEL")));
            veh.setLightType(cursor.getString(cursor.getColumnIndex("LIGHT_TYPE")));
            veh.setPlateType(cursor.getString(cursor.getColumnIndex("PLATE_TYPE")));
            veh.setLicenseNumber(cursor.getString(cursor.getColumnIndex("LICENCE_NUMBER")));
            veh.setBrakeType(cursor.getString(cursor.getColumnIndex("BRAKE_TYPE")));
        }
        return veh;
    }

    public void addReport(CarBasicInfoModel car, int emission, int commandor, int exterior) {

    }

    public void updateReport() {

    }
}