package com.warehouse.db;
import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;

 // Gen timestamp: 27.04.2020 14:55:41

public class DbWhStockItemC extends DbWhC {  // Contract  
public static final String TABLE_NAME = "DbWhStockItem";
private static final int    _DB_VERSION             = 1;


// Constants for column names:
// public static final String _ID = "_id";
public static final String PROD_ID = "prod_id";
public static final String COUNT_ITEM = "count_item";

// Attributes for column names:
// public  long _id;
public  long prod_id;
public  long count_item;

// Constants for WHERE clauses:
// public static final String _ID_WHERE = _ID + Util.WHERE_PARAM;
public static final String PROD_ID_WHERE = PROD_ID + Util.WHERE_PARAM;
public static final String COUNT_ITEM_WHERE = COUNT_ITEM + Util.WHERE_PARAM;

// Constructor:
public DbWhStockItemC() {

        super();
 // addDbDdic("_id","INTEGER","PRIMARY KEY AUTOINCREMENT","","","Item id in stock");
addDbDdic("prod_id","INTEGER","","NOT NULL","","prod_id of item");
addDbDdic("count_item","INTEGER","","","DEFAULT 0","Number of items in stock");
} // End constructor

@Override
public void setValues(@NonNull Cursor cursor) {
super.setValues(cursor); 
int index = -1;

index = cursor.getColumnIndex(_ID );
if (index > -1) {
 //       _id = cursor.getInt(index);
}

index = cursor.getColumnIndex(PROD_ID );
if (index > -1) {
       prod_id = cursor.getInt(index);
}

index = cursor.getColumnIndex(COUNT_ITEM );
if (index > -1) {
       count_item = cursor.getInt(index);
}


} // End setValues


@Override
public ContentValues getContentValues() {
  ContentValues contentValues = super.getContentValues(); 

 //     contentValues.put(_ID,_id);

     contentValues.put(PROD_ID,prod_id);

     contentValues.put(COUNT_ITEM,count_item);

return contentValues;

} // End getContentValues


public static final String SQL_CREATE = 
"CREATE TABLE IF NOT EXISTS DbWhStockItemC ("
 + " _id INTEGER PRIMARY KEY AUTOINCREMENT   , "
 + " prod_id INTEGER  NOT NULL  , "
 + " count_item INTEGER   DEFAULT 0 , "
 + DbWhC.DbCreateTrailer  
 + ");"
;

} // End classDbWhStockItemC
