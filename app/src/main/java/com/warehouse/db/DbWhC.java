package com.warehouse.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * CONTRACT basis class
 */
public class DbWhC {

    public static final String DB_WH_FILE_PREFIX = "DbWh";

    public static final String _ID      = BaseColumns._ID;
    public static final String DATE_CHG = "date_chg";
    public static final String DEV_CHG  = "dev_chg";

    public static final String _ID_WHERE     = _ID + Util.WHERE_PARAM;
    public static final String PACKAGE       = "com.warehouse.db";
    public static final String AUTHORITY     = PACKAGE + ".provider";
    public static final Uri    AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);


    public static final String DbCreateTrailer =
            "date_chg TEXT NOT NULL, "
                    + "dev_chg TEXT NOT NULL ";

    // THE fields of the DB:
    public long   _id;
    public String date_chg;
    public String dev_chg;


    protected Map<String,DbDDIC> dbDDICMap = new HashMap<String, DbDDIC>();
    protected DbDDIC dbDDIC;
    protected void addDbDdic (String Fieldname, String DbType, String Pk, String NOT_NULL, String DEFAULT, String Text ) {
        dbDDIC = new DbDDIC(Fieldname.toUpperCase(), DbType.toUpperCase(), Pk.toUpperCase(),
                NOT_NULL.toUpperCase(), DEFAULT.toUpperCase(), Text );
        dbDDICMap.put(Fieldname.toUpperCase(), dbDDIC);
    }

    public DbWhC() {
        addDbDdic("_id","INTEGER","PRIMARY KEY AUTOINCREMENT","","","autoincrement ID of Product");

        addDbDdic("date_chg","TEXT","","NOT NULL","","Date of Change, Format yyyy-MM-dd'T'HH:MM");
        addDbDdic("dev_chg","TEXT","","NOT NULL","","Device on which change was recorded");
    }





    public static Uri getContentUri(String dbName) {
        Uri res = Uri.withAppendedPath(DbWhC.AUTHORITY_URI, dbName);
        return res;
    }

    public void setValues(@NonNull Cursor cursor) {
        int index = cursor.getColumnIndex(_ID);
        if (index > -1) {
            _id = cursor.getLong(index);
        }

        index = cursor.getColumnIndex(DATE_CHG);
        if (index > -1) {
            date_chg = cursor.getString(index);
        }

        index = cursor.getColumnIndex(DEV_CHG);
        if (index > -1) {
            dev_chg = cursor.getString(index);
        }

    }

    public ContentValues getContentValues() {
        ContentValues contentValues = new ContentValues();
        if (this._id > Util.ZERO_LONG) {
            contentValues.put(_ID, this._id);
        }

        this.date_chg = Util.getDateTime();
        contentValues.put(DATE_CHG, this.date_chg);

        this.dev_chg = Util.DEVICE;
        contentValues.put(DEV_CHG, this.dev_chg);

        return contentValues;
    }

}
