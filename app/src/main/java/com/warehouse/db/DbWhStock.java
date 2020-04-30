package com.warehouse.db;
 import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
 
 // Gen timestamp: 27.04.2020 14:55:41

public class DbWhStock extends SQLiteOpenHelper {  // Db Helper  
public static final String TABLE_NAME = "DbWhStock";
public static final String _CREATE = DbWhStockC.SQL_CREATE;
private static final int    _DB_VERSION             = 1;

    public DbWhStock(@NonNull Context context) {
   
 
        super(context, TABLE_NAME, null, _DB_VERSION);
 
        File dbFile = context.getDatabasePath(TABLE_NAME); 
        String dbPath = dbFile.getAbsolutePath();
        boolean exists =  dbFile.exists();
 
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(dbFile, null) ; 
        try { 
          //  db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME); 
        }
        catch (Exception e) {   
            String err = e.getMessage();  
            Log.e("DbWhProd Create drop", err);   
            e.printStackTrace();
        }
        db.execSQL(_CREATE);
        db.close(); // new .. works ??   
  
        // SQLiteDatabase db=getWritableDatabase(); 
    }  // End constructor 

@Override 
    public void onCreate(SQLiteDatabase db) { 
        db.execSQL(_CREATE);
    } // End  onCreate

@Override 
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { 
        return;
    } // End  onUpgrade


} // End classDbWhStock
