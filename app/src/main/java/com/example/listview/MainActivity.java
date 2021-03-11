package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    // Member Variable --------------------------------
    private final boolean           D           = true;
    private final static String     TAG         = "MainActivity";

    private ListView                dataLST;
    private ArrayList<String>       name;
    private EditText                editTXT;
    private InputMethodManager      imm;

    // List 관련
    private Resources               resources;
    private ArrayAdapter<String>    adapter;
    private String nameValue;

    // Member Method - Activity's Override ----------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        set_listViewListener();

        if(D)
            Log.i(TAG, "onCreate()");
    }

    // Member Method - Custom -----------------------------------------
    // App 초기화 매서드
    private void init() {
        name = new ArrayList<String>();
        nameValue = "";
        editTXT = findViewById(R.id.nameETXT);
        dataLST = findViewById(R.id.dataLST);
//        imm.hideSoftInputFromWindow()
    }

    public void set_listViewListener() {
        // ListView Item 클릭 이벤트 설정
        dataLST.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) { // view : 리스트에서 선택한 뷰
                Toast.makeText(MainActivity.this, ((TextView)view).getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void click_addBtn(View v) {
        nameValue = editTXT.getText().toString();
        if(nameValue == "") {
            Toast.makeText(this, R.string.noName, Toast.LENGTH_SHORT).show();
        } else {
            name.add(nameValue);
            adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,
                    name);
            dataLST.setAdapter(adapter);
            editTXT.setText("");
            Toast.makeText(this, R.string.noName, Toast.LENGTH_SHORT).show();
        }
    }

    public void click_cancelBtn(View v) {
        name.removeAll(name);
    }
}