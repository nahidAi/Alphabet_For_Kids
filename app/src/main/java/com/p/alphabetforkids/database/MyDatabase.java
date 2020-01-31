package com.p.alphabetforkids.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.p.alphabetforkids.Model.ItemModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;


public class MyDatabase extends SQLiteOpenHelper {
    private static String DB_NAME = "Alphabetdb";
    private static String DB_PATH = "";
    private static final int DB_VERSION = 1;

    private SQLiteDatabase mDataBase;
    private final Context mContext;
    private boolean mNeedUpdate = false;


    public MyDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        if (android.os.Build.VERSION.SDK_INT >= 17)
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        else
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        this.mContext = context;

        copyDataBase();

        this.getReadableDatabase();
        openDataBase();

    }

    public void updateDataBase() throws IOException {
        if (mNeedUpdate) {
            File dbFile = new File(DB_PATH + DB_NAME);
            if (dbFile.exists())
                dbFile.delete();

            copyDataBase();

            mNeedUpdate = false;
        }
    }

    private boolean checkDataBase() {
        File dbFile = new File(DB_PATH + DB_NAME);
        return dbFile.exists();

    }

    private void copyDataBase() {
        if (!checkDataBase()) {
            this.getReadableDatabase();
            this.close();
            try {
                copyDBFile();
            } catch (IOException mIOException) {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }

    private void copyDBFile() throws IOException {
        InputStream mInput = mContext.getAssets().open(DB_NAME);
        // InputStream mInput = mContext.getResources().openRawResource(R.raw.info);
        OutputStream mOutput = new FileOutputStream(DB_PATH + DB_NAME);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0)
            mOutput.write(mBuffer, 0, mLength);
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    public boolean openDataBase() throws SQLException {
        mDataBase = SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        return mDataBase != null;
    }

    @Override
    public synchronized void close() {
        if (mDataBase != null)
            mDataBase.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion)
            mNeedUpdate = true;
    }

    public ArrayList<ItemModel> allAlphabet() {
        ArrayList<ItemModel> alphabet = new ArrayList<ItemModel>();
        Cursor cursor = mDataBase.rawQuery("SELECT * FROM alfabet", null);

        if (cursor.moveToFirst()) {
            do {
                String title = cursor.getString(cursor.getColumnIndex("title"));
                String image = cursor.getString(cursor.getColumnIndex("image"));
                int id = cursor.getInt(cursor.getColumnIndex("Id"));
                int id_word_count = cursor.getInt(cursor.getColumnIndex("id_word_count"));
                int row = cursor.getInt(cursor.getColumnIndex("row"));
                String first_alphabet_word = cursor.getString(cursor.getColumnIndex("first_alphabet_word"));
                String end_alphabet_word = cursor.getString(cursor.getColumnIndex("end_alphabet_words"));
                String second_alphabet_words = cursor.getString(cursor.getColumnIndex("second_alphabet_words"));
                String third_alphabet_words = cursor.getString(cursor.getColumnIndex("Third_alphabet_words"));
                String imgExampleOne = cursor.getString(cursor.getColumnIndex("one_example"));
                String imgExampleTwo = cursor.getString(cursor.getColumnIndex("two_example"));
                String imgExampleThree = cursor.getString(cursor.getColumnIndex("three_example"));
                String imgExampleEnd = cursor.getString(cursor.getColumnIndex("four_example"));
                String img_one = cursor.getString(cursor.getColumnIndex("img_one"));
                String img_two = cursor.getString(cursor.getColumnIndex("img_two"));
                String img_three = cursor.getString(cursor.getColumnIndex("img_three"));
                String img_end = cursor.getString(cursor.getColumnIndex("img_end"));
                String poetry = cursor.getString(cursor.getColumnIndex("protry"));

                Log.i("sdfdsf", id + "");
                ItemModel model = new ItemModel();
                model.setTitle(title);
                model.setImage(image);
                model.setId(id);
                model.setId_word_count(id_word_count);
                model.setRow(row);
                model.setFirst_alphabet_word(first_alphabet_word);
                model.setEnd_alphabet_word(end_alphabet_word);
                model.setSecond_alphabet_words(second_alphabet_words);
                model.setThird_alphabet_words(third_alphabet_words);
                model.setExampleOne(imgExampleOne);
                model.setExampleTwo(imgExampleTwo);
                model.setExampleThree(imgExampleThree);
                model.setExampleEnd(imgExampleEnd);
                model.setImg_one(img_one);
                model.setImg_two(img_two);
                model.setImg_three(img_three);
                model.setImg_four(img_end);
                model.setPoetry(poetry);



                alphabet.add(model);

            }
            while (cursor.moveToNext());
        }
        return alphabet;
    }


    public ItemModel selectAlphabetByRow(int mRow) {
        ArrayList<ItemModel> models = new ArrayList<>();

        Cursor cursor = mDataBase.rawQuery("SELECT * FROM alfabet WHERE row = '" + mRow + "'", null);
        if (cursor.moveToFirst()) {
            do {
                String title = cursor.getString(cursor.getColumnIndex("title"));
                String image = cursor.getString(cursor.getColumnIndex("image"));
                int id = cursor.getInt(cursor.getColumnIndex("Id"));
                int id_word_count = cursor.getInt(cursor.getColumnIndex("id_word_count"));
                int row = cursor.getInt(cursor.getColumnIndex("row"));
                String first_alphabet_word = cursor.getString(cursor.getColumnIndex("first_alphabet_word"));
                String end_alphabet_word = cursor.getString(cursor.getColumnIndex("end_alphabet_words"));
                String second_alphabet_words = cursor.getString(cursor.getColumnIndex("second_alphabet_words"));
                String third_alphabet_words = cursor.getString(cursor.getColumnIndex("Third_alphabet_words"));
                String imgExampleOne = cursor.getString(cursor.getColumnIndex("one_example"));
                String imgExampleTwo = cursor.getString(cursor.getColumnIndex("two_example"));
                String imgExampleThree = cursor.getString(cursor.getColumnIndex("three_example"));
                String imgExampleEnd = cursor.getString(cursor.getColumnIndex("four_example"));
                String img_one = cursor.getString(cursor.getColumnIndex("img_one"));
                String img_two = cursor.getString(cursor.getColumnIndex("img_two"));
                String img_three = cursor.getString(cursor.getColumnIndex("img_three"));
                String img_end = cursor.getString(cursor.getColumnIndex("img_end"));

                ItemModel model = new ItemModel();
                model.setTitle(title);
                model.setImage(image);
                model.setId(id);
                model.setId_word_count(id_word_count);
                model.setRow(row);
                model.setFirst_alphabet_word(first_alphabet_word);
                model.setEnd_alphabet_word(end_alphabet_word);
                model.setSecond_alphabet_words(second_alphabet_words);
                model.setThird_alphabet_words(third_alphabet_words);
                model.setExampleOne(imgExampleOne);
                model.setExampleTwo(imgExampleTwo);
                model.setExampleThree(imgExampleThree);
                model.setExampleEnd(imgExampleEnd);
                model.setImg_one(img_one);
                model.setImg_two(img_two);
                model.setImg_three(img_three);
                model.setImg_four(img_end);
                models.add(model);


            }
            while (cursor.moveToNext());

        }
        return models.get(0);
    }
}
