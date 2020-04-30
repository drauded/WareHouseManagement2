package com.warehouse.db;

// Data Dictionary
public class DbDDIC {
    public String fieldname;
    public String DbType;
    public String PK	;
    public String NOT_NULL;
    public String DEFAULT;
    public String Text;

    public DbDDIC(String Fieldname, String DbType, String Pk, String NOIT_NULL, String DEFAULT, String Text) {
        this.fieldname = Fieldname;
        this.DbType = DbType;
        this.PK = Pk	;
        this.NOT_NULL = NOIT_NULL;
        this.DEFAULT = DEFAULT;
        this.Text = Text;
    }

}
