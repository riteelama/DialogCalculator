package com.chapter5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.sql.Array;

public class ListViewAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_acitivity);

        ListView itemsLv = findViewById(R.id.itemsLv);

        String names[] = {"Ritee","Rajan","Kriti","Krisha","Maya","Ram","Kamala","Isabella","Snowie","Cookie","Snowbell"};

        ArrayAdapter<String> namesAdapter= new ArrayAdapter<String>(this,R.layout.list_view_items,R.id.namesTv,names);

        itemsLv.setAdapter(namesAdapter);
    }
}