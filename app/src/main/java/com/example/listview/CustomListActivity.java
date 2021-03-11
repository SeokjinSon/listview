package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomListActivity extends AppCompatActivity {
    private final boolean           D               = true;
    private final String            TAG             = "CustomAcitivity";

    private ListView                dataLST;
    private ArrayList<ItemData>     dataArrays;
    private ItemDataAdapter         adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    // Member Method - Custom -----------------------------------
    private void init() {
        dataLST = findViewById(R.id.dataLST);

        dataArrays = new ArrayList<ItemData>();
        dataArrays.add(new ItemData("TEST", "010", "Daegu", R.drawable.flower));
        dataArrays.add(new ItemData("KIM", "011", "Jeju", R.drawable.flower2));

        // 뷰, 데이터 순으로 전달
        adapter = new ItemDataAdapter(this, R.layout.item_data, dataArrays);

        dataLST.setAdapter(adapter);
    }
}