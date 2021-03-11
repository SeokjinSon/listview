package com.example.listview;

import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;


public class SimpleList2 extends AppCompatActivity {

    // Member Variable --------------------------------
    private final boolean                               D           = true;
    private final static String                         TAG         = "SimpleList2";

    private ListView                                    dataLST;
    private ArrayList<HashMap<String, String>>          name;
    private InputMethodManager                          imm;

    // List 관련
    private SimpleAdapter                               adapter;

    // Member Method - Activity's Override ----------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        if(D)
            Log.i(TAG, "onCreate()");
    }

    // Member Method - Custom -----------------------------------------
    // App 초기화 매서드
    private void init() {
        dataLST = findViewById(R.id.dataLST);
        //imm.hideSoftInputFromWindow(nameETXT.getWindowToken(), 0)

        makeHashMap();
        // List 데이터 준비
        name = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("name", "SonSeokjin");
        map.put("area", "Daegu");
        name.add(map);

        adapter = new SimpleAdapter(this,
                                           name,
                                           R.layout.layout_custom,
                                           new String[] {"name", "area"},
                                           new int[] {R.id.phoneTXT, R.id.addressTXT});
        dataLST.setAdapter(adapter);
    }

    public void makeHashMap() {

    }
}