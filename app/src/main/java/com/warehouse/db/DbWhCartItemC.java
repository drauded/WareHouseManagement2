package com.warehouse.db;
import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;

 // Gen timestamp: 27.04.2020 14:55:41

public class DbWhCartItemC extends DbWhC {  // Contract  
public static final String TABLE_NAME = "DbWhCartItem";
private static final int    _DB_VERSION             = 1;


// Constants for column names:
// public static final String _ID = "_id";
public static final String CART_ID = "cart_id";
public static final String PROD_ID = "prod_id";
public static final String COUNT = "count";
public static final String PRICE_ITEM = "price_item";
public static final String PROD_PICTURE_STORAGE = "prod_picture_storage";

// Attributes for column names:
// public  long _id;
public  long cart_id;
public  long prod_id;
public  long count;
public  double price_item;
public  byte[] prod_picture_storage;

// Constants for WHERE clauses:
// public static final String _ID_WHERE = _ID + Util.WHERE_PARAM;
public static final String CART_ID_WHERE = CART_ID + Util.WHERE_PARAM;
public static final String PROD_ID_WHERE = PROD_ID + Util.WHERE_PARAM;
public static final String COUNT_WHERE = COUNT + Util.WHERE_PARAM;
public static final String PRICE_ITEM_WHERE = PRICE_ITEM + Util.WHERE_PARAM;
public static final String PROD_PICTURE_STORAGE_WHERE = PROD_PICTURE_STORAGE + Util.WHERE_PARAM;

// Constructor:
public DbWhCartItemC() {

        super();
 // addDbDdic("_id","INTEGER","PRIMARY KEY AUTOINCREMENT","","","Item number in cart");
addDbDdic("cart_id","INTEGER","","NOT NULL","","Cart id to which item was added");
addDbDdic("prod_id","INTEGER","","NOT NULL","","prod_id added to cart");
addDbDdic("count","INTEGER","","NOT NULL","DEFAULT 1","multiplicity of item added/subtracted from cart");
addDbDdic("price_item","REAL","","NOT NULL","DEFAULT 0","Price of 1 item");
addDbDdic("prod_picture_storage","BLOB","","","","pictore of storage (ex. In celler) if available/needed");
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

index = cursor.getColumnIndex(PROD_ID );
if (index > -1) {
       prod_id = cursor.getInt(index);
}

index = cursor.getColumnIndex(COUNT );
if (index > -1) {
       count = cursor.getInt(index);
}

index = cursor.getColumnIndex(PRICE_ITEM );
if (index > -1) {
       price_item = cursor.getDouble(index);
}

index = cursor.getColumnIndex(PROD_PICTURE_STORAGE );
if (index > -1) {
       prod_picture_storage = cursor.getBlob(index);
}


} // End setValues


@Override
public ContentValues getContentValues() {
  ContentValues contentValues = super.getContentValues(); 

 //     contentValues.put(_ID,_id);

     contentValues.put(CART_ID,cart_id);

     contentValues.put(PROD_ID,prod_id);

     contentValues.put(COUNT,count);

     contentValues.put(PRICE_ITEM,price_item);

if (prod_picture_storage!= null) {
     contentValues.put(PROD_PICTURE_STORAGE,prod_picture_storage);
}

return contentValues;

} // End getContentValues


public static final String SQL_CREATE = 
"CREATE TABLE IF NOT EXISTS DbWhCartItemC ("
 + " _id INTEGER PRIMARY KEY AUTOINCREMENT   , "
 + " cart_id INTEGER  NOT NULL  , "
 + " prod_id INTEGER  NOT NULL  , "
 + " count INTEGER  NOT NULL DEFAULT 1 , "
 + " price_item REAL  NOT NULL DEFAULT 0 , "
 + " prod_picture_storage BLOB    , "
 + DbWhC.DbCreateTrailer  
 + ");"
;

} // End classDbWhCartItemC
