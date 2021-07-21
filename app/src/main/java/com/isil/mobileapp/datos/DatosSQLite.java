package com.isil.mobileapp.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatosSQLite extends SQLiteOpenHelper {
    public DatosSQLite(@Nullable Context context) {
        super(context, "autos", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE autos(" +
                "idauto INTEGER PRIMARY KEY AUTOINCREMENT," +
                "marca TEXT,"+
                "modelo TEXT," +
                "placa TEXT," +
                "propietario TEXT)");
    }


    public String registrarAuto(DatosSQLite datosSQLite, String marca, String modelo, String placa, String propietario  ){
        SQLiteDatabase db = datosSQLite.getWritableDatabase();
        //db.execSQL("Insert Into .....");
        ContentValues contentValues = new ContentValues();
        contentValues.put("marca",marca);
        contentValues.put("modelo",modelo);
        contentValues.put("placa",placa);
        contentValues.put("propietario",propietario);
        int autonumerico = (int) db.insert("autos",null,contentValues);
        String resultado = autonumerico != 0 ? "Se ha registrado satisfactoriamente" : "Error";
        return resultado;
    }

    public Cursor mostrarTodo(DatosSQLite datosSQLite){
        SQLiteDatabase db = datosSQLite.getReadableDatabase();
        String sql = "select * from autos";
        return db.rawQuery(sql,null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
