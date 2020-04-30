package com.warehouse.db;
import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;

 // Gen timestamp: 27.04.2020 14:55:41

public class DbWhStockC extends DbWhC {  // Contract  
public static final String TABLE_NAME = "DbWhStock";
private static final int    _DB_VERSION             = 1;


// Constants for column names:
// public static final String _ID = "_id";
public static final String CART_ID = "cart_id";
public static final String OPERATION = "operation";

// Attributes for column names:
// public  long _id;
public  long cart_id;
public  String operation;

// Constants for WHERE clauses:
// public static final String _ID_WHERE = _ID + Util.WHERE_PARAM;
public static final String CART_ID_WHERE = CART_ID + Util.WHERE_PARAM;
public static final String OPERATION_WHERE = OPERATION + Util.WHERE_PARAM;

// Constructor:
public DbWhStockC() {

        super();
 // addDbDdic("_id","INTEGER","PRIMARY KEY AUTOINCREMENT","","","Stock _id");
addDbDdic("cart_id","INTEGER","","NOT NULL","","last Cart id processed to stock");
addDbDdic("operation","TEXT","","","DEFAULT \"+\"","operation=+ then cart was added; -= cart was subtracted (storno)");
} // End constructor

@Override
public void setValues(@NonNull Cursor cursor) {
super.setValues(cursor); 
int index = -1;

index = cursor.getColumnIndex(_ID );
if (index > -1) {
 //       _id = cursor.getInt(index);
}

index = cursor.getColumnIndex(CART_ID );
if (index > -1) {
       cart_id = cursor.getInt(index);
}

index = cursor.getColumnIndex(OPERATION );
if (index > -1) {
       operation = cursor.getString(index);
}


} // End setValues


@Override
public ContentValues getContentValues() {
  ContentValues contentValues = super.getContentValues(); 

 //     contentValues.put(_ID,_id);

     contentValues.put(CART_ID,cart_id);

if (operation!= null) {
     contentValues.put(OPERATION,operation);
}

return contentValues;

} // End getContentValues


public static final String SQL_CREATE = 
"CREATE TABLE IF NOT EXISTS DbWhStockC ("
 + " _id INTEGER PRIMARY KEY AUTOINCREMENT   , "
 + " cart_id INTEGER  NOT NULL  , "
 + " operation TEXT   DEFAULT \"+\" , "
 + DbWhC.DbCreateTrailer  
 + ");"
;

} // End classDbWhStockC
