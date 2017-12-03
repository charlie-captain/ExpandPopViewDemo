package com.example.thatnight.expandpopviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.expandpopview.callback.OnOneListCallback;
import com.example.expandpopview.callback.OnTwoListCallback;
import com.example.expandpopview.entity.KeyValue;
import com.example.expandpopview.view.ExpandPopView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandPopView mExpandPopView;


    private List<KeyValue> mParentList;
    private List<KeyValue> mChildList;
    private List<List<KeyValue>> mParentChild;
    private List<KeyValue> mOneList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mExpandPopView = findViewById(R.id.elv_main);
        mParentList = new ArrayList<>();
        mParentChild = new ArrayList<>();
        mOneList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            mOneList.add(new KeyValue("一级列表" + i, i + ""));
        }
        mExpandPopView.addItemToExpandTab("一级", mOneList, new OnOneListCallback() {
            @Override
            public void returnKeyValue(int pos, KeyValue keyValue) {
                Toast.makeText(MainActivity.this, keyValue.getKey() + " " + keyValue.getValue(), Toast.LENGTH_SHORT).show();

            }

        });

        for (int i = 0; i < 10; i++) {
            mParentList.add(new KeyValue("安卓分类" + i, i + ""));
            mChildList = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                mChildList.add(new KeyValue(i + " " + j, j + ""));
            }
            mParentChild.add(mChildList);
        }


        mExpandPopView.addItemToExpandTab("二级", mParentList, mParentChild, new OnTwoListCallback() {
            @Override
            public void returnParentKeyValue(int pos, KeyValue keyValue) {
                Toast.makeText(MainActivity.this, pos + "  " + keyValue.getKey() + " " + keyValue.getValue(), Toast.LENGTH_SHORT).show();
//                mChildList = new ArrayList<>();
//                for (int j = 0; j < 2; j++) {
//                    mChildList.add(new KeyValue(j + "asd" + j, j + ""));
//                }
//                mExpandPopView.refreshItemChildrenData(1, mChildList);
            }

            @Override
            public void returnChildKeyValue(int pos, KeyValue keyValue) {
                Toast.makeText(MainActivity.this, pos + "  " + keyValue.getKey() + " " + keyValue.getValue(), Toast.LENGTH_SHORT).show();

            }

        });
    }
}
