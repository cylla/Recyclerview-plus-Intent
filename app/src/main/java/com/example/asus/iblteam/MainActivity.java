package com.example.asus.iblteam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_ibl_list;
    private ArrayList<IBLModel> list = new ArrayList<>();
    private TextView team_description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_ibl_list = findViewById(R.id.rv_ibl_list);
        rv_ibl_list.setHasFixedSize(true);
        list.addAll(IBLData.getListData());

        showRecyclerList();
    }


    private void showRecyclerList() {
        rv_ibl_list.setLayoutManager(new LinearLayoutManager(this));
        IBLAdapter iblAdapter = new IBLAdapter(this);
        iblAdapter.setIBLList(list);
        rv_ibl_list.setAdapter(iblAdapter);
    }
}
