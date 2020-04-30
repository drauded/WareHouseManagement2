package com.warehouse.db;
import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;

 // Gen timestamp: 27.04.2020 14:55:41

public class DbWhCartC extends DbWhC {  // Contract  
public static final String TABLE_NAME = "DbWhCart";
private static final int    _DB_VERSION             = 1;


// Constants for column names:
// public static final String _ID = "_id";
public static final String CART_TEXT = "cart_text";
public static final String CART_STATUS = "cart_status";

// Attributes for column names:
// public  long _id;
public  String cart_text;
public  String cart_status;

// Constants for WHERE clauses:
// public static final String _ID_WHERE = _ID + Util.WHERE_PARAM;
public static final String CART_TEXT_WHERE = CART_TEXT + Util.WHERE_PARAM;
public static final String CART_STATUS_WHERE = CART_STATUS + Util.WHERE_PARAM;

// Constructor:
public DbWhCartC() {

        super();
 // addDbDdic("_id","INTEGER","PRIMARY KEY AUTOINCREMENT","","","autoincrement ID of a Shopping Cart");
addDbDdic("cart_text","TEXT","NOT NULL","","DEFAULT \"Your Cart Text here\"","Description of this shopping cart");
addDbDdic("cart_status","TEXT","","","DEFAULT \"OPEN\"","Open = Items still addable; Close=no more adding of items;");
} // End constructor

@Override
public void setValues(@NonNull Cursor cursor) {
super.setValues(cursor); 
int index = -1;

index = cursor.getColumnIndex(_ID );
if (index > -1) {
 //       _id = cursor.getInt(index);
}

index = cursor.getColumnIndex(CART_TEXT );
if (index > -1) {
       cart_text = cursor.getString(index);
}

index = cursor.getColumnIndex(CART_STATUS );
if (index > -1) {
       cart_status = cursor.getString(index);
}


} // End setValues


@Override
public ContentValues getContentValues() {
  ContentValues contentValues = super.getContentValues(); 

 //     contentValues.put(_ID,_id);

if (cart_text!= null) {
     contentValues.put(CART_TEXT,cart_text);
}

if (cart_status!= null) {
     contentValues.put(CART_STATUS,cart_status);
}

return contentValues;

} // End getContentValues


public static final String SQL_CREATE = 
"CREATE TABLE IF NOT EXISTS DbWhCartC ("
 + " _id INTEGER PRIMARY KEY AUTOINCREMENT   , "
 + " cart_text TEXT NOT NULL  DEFAULT \"Your Cart Text here\" , "
 + " cart_status TEXT   DEFAULT \"OPEN\" , "
 + DbWhC.DbCreateTrailer  
 + ");"
;

} // End classDbWhCartC
