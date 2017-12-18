package mx.ipn.escom;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class BD extends SQLiteOpenHelper{

    private static String DB_NAME = "Inventarios";
    private static SQLiteDatabase base;

    public static SQLiteDatabase getInstance(Context ctx) {
        if(base == null){
            Log.v("Base", "Se instancia la base");
            base = new BD(ctx.getApplicationContext()).getWritableDatabase();
        }
        return base;
    }

    private BD(Context context) {
        super(context, DB_NAME,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
