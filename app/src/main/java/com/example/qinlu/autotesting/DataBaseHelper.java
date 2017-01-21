package com.example.qinlu.autotesting;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "cars.db";
    static final int DATABASE_VERSION = 1;
    public static String[] platePrefixList;
    public static String[] plateTypeList;

    public DataBaseHelper(Context context, String name,CursorFactory factory, int version)
    {
        super(context, name, factory, version);
        platePrefixList = context.getResources().getStringArray(R.array.platePrefixList);
        plateTypeList = context.getResources().getStringArray(R.array.plateTypeList);
    }
    // Called when no database exists in disk and the helper class needs
    // to create a new one.
    @Override
    public void onCreate(SQLiteDatabase _db)
    {
		// 创建操作员表格
        _db.execSQL(LoginDataBaseAdapter.CREATE_TABLE_USER);
        _db.execSQL(InspectionDataBaseAdapter.CREATE_TABLE_EMISSION);
        _db.execSQL(InspectionDataBaseAdapter.CREATE_TABLE_EXTERIOR);
        _db.execSQL(InspectionDataBaseAdapter.CREATE_TABLE_COMMANDER);
        _db.execSQL(InspectionDataBaseAdapter.CREATE_TABLE_ORG);
        _db.execSQL(InspectionDataBaseAdapter.CREATE_TABLE_PLATE_PREFIX);
        _db.execSQL(InspectionDataBaseAdapter.CREATE_TABLE_PLATE_TYPE);
        _db.execSQL(InspectionDataBaseAdapter.CREATE_TABLE_VEHICLE);
        _db.execSQL(InspectionDataBaseAdapter.CREATE_TABLE_REPORT);

        // 添加缺省值
        this.addDefaultUser(_db, "admin@admin.com", "admin", "123456");
        this.addDefaultPlatePrefix(_db, platePrefixList);
        this.addDefaultPlateType(_db, plateTypeList);
        this.addDefaultWorker(_db);
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
        _db.execSQL("DROP TABLE IF EXISTS " + LoginDataBaseAdapter.CREATE_TABLE_USER);
        _db.execSQL("DROP TABLE IF EXISTS " + InspectionDataBaseAdapter.CREATE_TABLE_EMISSION);
        _db.execSQL("DROP TABLE IF EXISTS " + InspectionDataBaseAdapter.CREATE_TABLE_EXTERIOR);
        _db.execSQL("DROP TABLE IF EXISTS " + InspectionDataBaseAdapter.CREATE_TABLE_COMMANDER);
        _db.execSQL("DROP TABLE IF EXISTS " + InspectionDataBaseAdapter.CREATE_TABLE_ORG);
        _db.execSQL("DROP TABLE IF EXISTS " + InspectionDataBaseAdapter.CREATE_TABLE_PLATE_PREFIX);
        _db.execSQL("DROP TABLE IF EXISTS " + InspectionDataBaseAdapter.CREATE_TABLE_PLATE_TYPE);
        _db.execSQL("DROP TABLE IF EXISTS " + InspectionDataBaseAdapter.CREATE_TABLE_VEHICLE);
        _db.execSQL("DROP TABLE IF EXISTS " + InspectionDataBaseAdapter.CREATE_TABLE_REPORT);
        // Create a new one.
        onCreate(_db);
    }

    // 添加缺省用户信息
    private void addDefaultUser(SQLiteDatabase db, String email, String user, String pwd) {
        ContentValues defaultValues = new ContentValues();
        defaultValues.put("USEREMAIL", email);
        defaultValues.put("USERNAME", user);
        defaultValues.put("PASSWORD",pwd);

        // Insert the row into your table
        db.insert(LoginDataBaseAdapter.TABLE_USER, null, defaultValues);
    }

    // 添加缺省车牌前缀
    private void addDefaultPlatePrefix(SQLiteDatabase db, String[] platePrefix) {
        ContentValues defaultValues = new ContentValues();
        for (String curPrefix : platePrefix) {
            defaultValues.put("PLATE_PREFIX", curPrefix);
            // Insert the row into your table
            db.insert(InspectionDataBaseAdapter.TABLE_PLATE_PREFIX, null, defaultValues);
        }
    }

    // 添加缺省车牌种类
    private void addDefaultPlateType(SQLiteDatabase db, String[] plateType) {
        ContentValues defaultValues = new ContentValues();
        for (String curType : plateType) {
            defaultValues.put("PLATE_TYPE", curType);
            // Insert the row into your table
            db.insert(InspectionDataBaseAdapter.TABLE_PLATE_TYPE, null, defaultValues);
        }
    }

    // 添加缺省检验员
    private void addDefaultWorker(SQLiteDatabase db) {
        ContentValues defaultValues = new ContentValues();
        defaultValues.put("OPNAME", "测试员");
        // Insert the row into your table
        db.insert(InspectionDataBaseAdapter.TABLE_COMMANDER, null, defaultValues);
        db.insert(InspectionDataBaseAdapter.TABLE_EMISSION, null, defaultValues);
        db.insert(InspectionDataBaseAdapter.TABLE_EXTERIOR, null, defaultValues);
    }
}
