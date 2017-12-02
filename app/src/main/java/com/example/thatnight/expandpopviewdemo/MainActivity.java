package com.example.thatnight.expandpopviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.expandpopview.callback.OnOneListCallback;
import com.example.expandpopview.callback.OnTwoListCallback;
import com.example.expandpopview.view.ExpandPopView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandPopView mExpandPopView;


    private List<String> mParentList;
    private List<String> mChildList;
    private List<List<String>> mParentChild;
    private List<String> mOneList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mExpandPopView = findViewById(R.id.elv_main);
        mParentList = new ArrayList<>();
        mParentChild = new ArrayList<>();
        mOneList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            mOneList.add("一级列表" + i);
        }
        mExpandPopView.addItemToExpandTab("一级", mOneList, new OnOneListCallback() {
            @Override
            public void returnKey(int pos, String value) {
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();

            }
        });

        for (int i = 0; i < 10; i++) {
            mParentList.add("安卓分类" + i);
            mChildList = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                mChildList.add( i+ " " + j);
            }
            mParentChild.add(mChildList);
        }

        mExpandPopView.addItemToExpandTab("二级", mParentList, mParentChild, new OnTwoListCallback() {
            @Override
            public void returnParentKey(int pos, String value) {
                Toast.makeText(MainActivity.this, pos + "  " + value, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void returnChildKey(int pos, String value) {
                Toast.makeText(MainActivity.this, pos + "  " + value, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
