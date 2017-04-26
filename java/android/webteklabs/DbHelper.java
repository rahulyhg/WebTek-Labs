package android.webteklabs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
	//Database Name
    static String DATABASE_NAME="wtl";
    //table Name
    public static final String TABLE_NAME1="login";
    public static final String TABLE_NAME2="rs";
    public static final String TABLE_NAME3="ce";
    //table fields Name

    public static final String KEY_I1="i1";
    public static final String KEY_I2="i2";
    public static final String KEY_I3="i3";
    public static final String KEY_ID="id";
    public static final String KEY_Password="Password";
    public static final String KEY_Ename="ename";
    public static final String KEY_Ephone="ephone";
    public static final String KEY_Ecourse="ecourse";
    public static final String KEY_Eamount="eamount";
    public static final String KEY_Cname="cname";
    public static final String KEY_Cphone="cphone";
    public static final String KEY_Csub="csub";
    
    //dbHelper P constructor
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
       
    }
    //create Database with table
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE1="CREATE TABLE "+TABLE_NAME1+" ("+KEY_I1+" INTEGER PRIMARY KEY, "+KEY_ID+" TEXT, "+KEY_Password+" TEXT)";
        db.execSQL(CREATE_TABLE1);

        String CREATE_TABLE2="CREATE TABLE "+TABLE_NAME2+" ("+KEY_I2+" INTEGER PRIMARY KEY, "+KEY_Ename+" TEXT, "+KEY_Ephone+" TEXT, "+KEY_Ecourse+" TEXT, "+KEY_Eamount+" TEXT)";
        db.execSQL(CREATE_TABLE2);

        String CREATE_TABLE3="CREATE TABLE "+TABLE_NAME3+" ("+KEY_I3+" INTEGER PRIMARY KEY, "+KEY_Cname+" TEXT, "+KEY_Cphone+" TEXT, "+KEY_Csub+" TEXT)";
        db.execSQL(CREATE_TABLE3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME2);

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME3);
        onCreate(db);
    }

}