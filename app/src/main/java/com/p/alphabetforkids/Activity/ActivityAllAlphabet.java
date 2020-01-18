package com.p.alphabetforkids.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.p.alphabetforkids.Adapter.AdapterAlfabet;
import com.p.alphabetforkids.Model.ItemModel;
import com.p.alphabetforkids.R;
import com.p.alphabetforkids.database.MyDatabase;


import java.util.ArrayList;
import java.util.List;

public class ActivityAllAlphabet extends AppCompatActivity {
    //ImageView imgback;
    MyDatabase database;
    RecyclerView recyclerView;
    AdapterAlfabet adapterAlfabet;
    List<ItemModel> itemModelList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_alphabet);


        // فول اسکرین کردن صفحه
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        database = new MyDatabase(this);


        itemModelList = database.allAlphabet();
        recyclerView = findViewById(R.id.recyclerview);
        adapterAlfabet = new AdapterAlfabet(this, itemModelList);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        recyclerView.setAdapter(adapterAlfabet);


    }

    // برای اینکه دکمه بک گوشی کار نکنه
   /* @Override
    public void onBackPressed() {

    }*/

    // داده های فیک برای تست
    private List<ItemModel> generateItem() {
        List<ItemModel> models = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ItemModel itemModel = new ItemModel();
            itemModel.setTitle("سـ  س ");
            models.add(itemModel);

        }
        return models;
    }


}

// imgback = findViewById(R.id.imageBack);
        /*imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityAllAlphabet.this, WellcomActivity.class);
                startActivity(intent);
                finish();

            }
        });*/




         /*private void readFromDB() {
        SQLiteDatabase db = databaseOpenHelper.openDatabase();

        String sql = "select * from alfabet";
        Cursor cursor = db.rawQuery(sql, null);
        int counter = 0;
        if (cursor.moveToFirst()) {
            int id = -1;
            String title = "";
            String image = "";
            try {
                do {
                    counter++;
                    //if (counter == 3)
                    //continue;
                    id = -1;
                    title = "";
                    image = "";

                    id = cursor.getInt(cursor.getColumnIndex("Id"));
                    title = cursor.getString(cursor.getColumnIndex("title"));
                    image = cursor.getString(cursor.getColumnIndex("image"));

                    ItemModel movie = new ItemModel();
                    movie.setId(id);
                    movie.setTitle(title);
                    movie.setImage(image);

                    itemModelList.add(movie);
                }
                while (cursor.moveToNext());
            } catch (Exception e) {
                final String TAG = "sdfsqqqqqq";
                Log.w(TAG, id + "");
                Log.w(TAG, title + "");
                Log.w(TAG, image + "");
                Log.e(TAG, counter + "");
                Log.e(TAG, e.toString());
            }
        }

    }*/

