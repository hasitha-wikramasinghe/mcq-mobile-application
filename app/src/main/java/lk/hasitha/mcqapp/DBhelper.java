package lk.hasitha.mcqapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DBhelper extends SQLiteOpenHelper {

    public static final int version= 1;
    public static final String DATABASE_NAME ="mcq.db";
    public static final String TABLE_NAME= "questionTable";
    public static final String ID = "id";
    public static final String Question = "question";
    public static final String Answer = "answer";
    public static final String w1_Answer = "w1";
    public static final String w2_Answer = "w2";
    public static final String w3_Answer = "w3";
    public static final String w4_Answer = "w4";
    private SQLiteDatabase dbmcq;

    public DBhelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, version);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String TABLE_CREATE_QUERY = " CREATE TABLE " + TABLE_NAME +" "+
                "("
                +ID+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
                +Question+ " TEXT,"
                +Answer+ " TEXT,"
                +w1_Answer+ " TEXT,"
                +w2_Answer+ " TEXT,"
                +w3_Answer+ " TEXT,"
                +w4_Answer+ " TEXT"+
                ");";
        db.execSQL(TABLE_CREATE_QUERY);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
    public void addQuestion(QuestionModelClass questionModelClass){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Question,questionModelClass.getQuestion());
        contentValues.put(Answer,questionModelClass.getAnswer());
        contentValues.put(w1_Answer,questionModelClass.getW1());
        contentValues.put(w2_Answer,questionModelClass.getW2());
        contentValues.put(w3_Answer,questionModelClass.getW3());
        contentValues.put(w4_Answer,questionModelClass.getW4());

        //save to table
        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        //close database
        sqLiteDatabase.close();
    }
    public List<QuestionModelClass>getAllQuestion(){
        List<QuestionModelClass>quesList = new ArrayList<QuestionModelClass>();
        //select Query
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " ORDER BY "+ "RANDOM()";
        dbmcq = this.getReadableDatabase();
        Cursor cursor = dbmcq.rawQuery(selectQuery,null);

        if (cursor.moveToFirst()){
            do {
                QuestionModelClass quest = new QuestionModelClass();
                quest.setId(cursor.getInt(0));
                quest.setQuestion(cursor.getString(1));
                quest.setAnswer(cursor.getString(2));
                quest.setW1(cursor.getString(3));
                quest.setW2(cursor.getString(4));
                quest.setW3(cursor.getString(5));
                quest.setW4(cursor.getString(6));
                quesList.add(quest);
            } while (cursor.moveToNext());
            Collections.shuffle(quesList);
        }
        return quesList;
    }
}
