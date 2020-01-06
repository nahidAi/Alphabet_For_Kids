package com.p.alphabetforkids.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.p.alphabetforkids.Adapter.AdapterAlfabet;
import com.p.alphabetforkids.Model.ItemModel;
import com.p.alphabetforkids.R;

import java.util.ArrayList;
import java.util.List;

public class PropertisActivity extends AppCompatActivity {
    //ImageView imgback;
    RecyclerView recyclerView;
    AdapterAlfabet adapterAlfabet;
    List<ItemModel> itemModelList = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propertis);


        findView();






       // imgback = findViewById(R.id.imageBack);
        /*imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PropertisActivity.this, WellcomActivity.class);
                startActivity(intent);
                finish();

            }
        });*/

    }

    @Override
    public void onBackPressed() {

    }

    private void findView() {
        recyclerView = findViewById(R.id.recyclerview);
        adapterAlfabet = new AdapterAlfabet(this, generateItem());
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        recyclerView.setAdapter(adapterAlfabet);


    }
    private List<ItemModel>generateItem(){
        List<ItemModel>models = new ArrayList<>();
        for (int i = 0;i<20;i++){
            ItemModel itemModel = new ItemModel();
            itemModel.setTitle("سـ  س ");
            models.add(itemModel);

        }
        return models;
    }
}

