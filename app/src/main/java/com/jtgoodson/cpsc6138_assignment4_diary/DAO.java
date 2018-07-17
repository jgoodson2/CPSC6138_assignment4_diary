package com.jtgoodson.cpsc6138_assignment4_diary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DAO extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "diary.db";
    public static final String TABLE_DIARY_ENTRIES = "diary_entries";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_SUBJECT = "subject";
    public static final String COLUMN_CONTENT = "content";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    public DAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_DIARY_ENTRIES + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TIMESTAMP + " TEXT, " +
                COLUMN_SUBJECT + " TEXT, " +
                COLUMN_CONTENT + " TEXT " +
                ");";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DIARY_ENTRIES);
        onCreate(db);
    }

    //insert new record
    public void addDiaryEntry(DiaryEntry diaryEntry) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_TIMESTAMP, diaryEntry.get_timestamp().toString());
        values.put(COLUMN_SUBJECT, diaryEntry.get_subject());
        values.put(COLUMN_CONTENT, diaryEntry.get_content());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_DIARY_ENTRIES, null, values);
        db.close();
    }

    //print out records
    public String printAllRecords() {
        String allRecordsString = "";
        SQLiteDatabase db = getWritableDatabase();
        String sql = "SELECT * FROM " + TABLE_DIARY_ENTRIES + " WHERE 1";

        Cursor c = db.rawQuery(sql, null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex(COLUMN_TIMESTAMP)) != null) {
                allRecordsString += c.getString(c.getColumnIndex(COLUMN_TIMESTAMP)) + "\t"
                        + c.getString(c.getColumnIndex(COLUMN_SUBJECT))
                        + c.getString(c.getColumnIndex(COLUMN_CONTENT));
                allRecordsString += "\n";
            }
        }

        db.close();
        return allRecordsString;

    }
}
