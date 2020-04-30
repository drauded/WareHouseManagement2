package com.warehouse.db;
import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;

 // Gen timestamp: 27.04.2020 14:55:41

public class DbWhProdC extends DbWhC {  // Contract  
public static final String TABLE_NAME = "DbWhProd";
private static final int    _DB_VERSION             = 1;


// Constants for column names:
// public static final String _ID = "_id";
public static final String PROD_BARCODE = "prod_barcode";
public static final String PROD_BARCODE_TYPE = "prod_barcode_type";
public static final String PROD_NAME = "prod_name";
public static final String PROD_LIST_PRICE = "prod_list_price";
public static final String PROD_COUNT = "prod_count";
public static final String PROD_PICTURE = "prod_picture";

// Attributes for column names:
// public  long _id;
public  String prod_barcode;
public  String prod_barcode_type;
public  String prod_name;
public  double prod_list_price;
public  long prod_count;
public  byte[] prod_picture;

// Constants for WHERE clauses:
// public static final String _ID_WHERE = _ID + Util.WHERE_PARAM;
public static final String PROD_BARCODE_WHERE = PROD_BARCODE + Util.WHERE_PARAM;
public static final String PROD_BARCODE_TYPE_WHERE = PROD_BARCODE_TYPE + Util.WHERE_PARAM;
public static final String PROD_NAME_WHERE = PROD_NAME + Util.WHERE_PARAM;
public static final String PROD_LIST_PRICE_WHERE = PROD_LIST_PRICE + Util.WHERE_PARAM;
public static final String PROD_COUNT_WHERE = PROD_COUNT + Util.WHERE_PARAM;
public static final String PROD_PICTURE_WHERE = PROD_PICTURE + Util.WHERE_PARAM;

// Constructor:
public DbWhProdC() {

        super();
 // addDbDdic("_id","INTEGER","PRIMARY KEY AUTOINCREMENT","","","autoincrement ID of Product");
addDbDdic("prod_barcode","TEXT","","NOT NULL","","Barcode");
addDbDdic("prod_barcode_type","TEXT","","","DEFAULT  \"BARC\"","Barcode Type (ISBN, barcode, QR, etc.)");
addDbDdic("prod_name","TEXT","","","","Product name");
addDbDdic("prod_list_price","REAL","","","DEFAULT 0","Listing price");
addDbDdic("prod_count","INTEGER","","","DEFAULT 1","");
addDbDdic("prod_picture","BLOB","","","","Picture of product");
} // End constructor

@Override
public void setValues(@NonNull Cursor cursor) {
super.setValues(cursor); 
int index = -1;

index = cursor.getColumnIndex(_ID );
if (index > -1) {
 //       _id = cursor.getInt(index);
}

index = cursor.getColumnIndex(PROD_BARCODE );
if (index > -1) {
       prod_barcode = cursor.getString(index);
}

index = cursor.getColumnIndex(PROD_BARCODE_TYPE );
if (index > -1) {
       prod_barcode_type = cursor.getString(index);
}

index = cursor.getColumnIndex(PROD_NAME );
if (index > -1) {
       prod_name = cursor.getString(index);
}

index = cursor.getColumnIndex(PROD_LIST_PRICE );
if (index > -1) {
       prod_list_price = cursor.getDouble(index);
}

index = cursor.getColumnIndex(PROD_COUNT );
if (index > -1) {
       prod_count = cursor.getInt(index);
}

index = cursor.getColumnIndex(PROD_PICTURE );
if (index > -1) {
       prod_picture = cursor.getBlob(index);
}


} // End setValues


@Override
public ContentValues getContentValues() {
  ContentValues contentValues = super.getContentValues(); 

 //     contentValues.put(_ID,_id);

if (prod_barcode!= null) {
     contentValues.put(PROD_BARCODE,prod_barcode);
}

if (prod_barcode_type!= null) {
     contentValues.put(PROD_BARCODE_TYPE,prod_barcode_type);
}

if (prod_name!= null) {
     contentValues.put(PROD_NAME,prod_name);
}

     contentValues.put(PROD_LIST_PRICE,prod_list_price);

     contentValues.put(PROD_COUNT,prod_count);

if (prod_picture!= null) {
     contentValues.put(PROD_PICTURE,prod_picture);
}

return contentValues;

} // End getContentValues


public static final String SQL_CREATE = 
"CREATE TABLE IF NOT EXISTS DbWhProdC ("
 + " _id INTEGER PRIMARY KEY AUTOINCREMENT   , "
 + " prod_barcode TEXT  NOT NULL  , "
 + " prod_barcode_type TEXT   DEFAULT  \"BARC\" , "
 + " prod_name TEXT    , "
 + " prod_list_price REAL   DEFAULT 0 , "
 + " prod_count INTEGER   DEFAULT 1 , "
 + " prod_picture BLOB    , "
 + DbWhC.DbCreateTrailer  
 + ");"
;

} // End classDbWhProdC
