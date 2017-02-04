package com.example.gilad.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by Gilad on 04/02/2017.
 */

public class ListActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Intent intent = getIntent();

        populateList();
    }

    private void populateList() {
        String [] Videos = {"HS1", "HS2", "HS3", "HearthStone"};

        ListAdapter adapter = new CustomAdapter(this, Videos);

        ListView list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
    }
}
