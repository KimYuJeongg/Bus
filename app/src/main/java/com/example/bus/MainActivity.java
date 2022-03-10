package com.example.bus;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bus.adapter.MainRecyclerViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        toolbar.setPadding(0, getStatusBarHeight(), 0, 0);

        ArrayList<String[]> list = new ArrayList<>();
        String[] arr1 = {"603","서대전역 입구", "14분", "6분"};
        String[] arr2 = {"318","유천네거리", "21분", "3분"};
        String[] arr3 = {"911","충남대학교", "17분", "5분"};
        String[] arr4 = {"121","탑립동", "12분", "10분"};
        String[] arr5 = {"63","삼성 초등학교", "6분", "5분"};
        String[] arr6 = {"108","월평역", "9분", "4분"};
        String[] arr7 = {"604","대덕대학교", "23분", "6분"};
        String[] arr8 = {"407","외평동", "17분", "3분"};
        String[] arr9 = {"703","꿈나무아파트", "8분", "3분"};
        list.add(arr1);
        list.add(arr2);
        list.add(arr3);
        list.add(arr4);
        list.add(arr5);
        list.add(arr6);
        list.add(arr7);
        list.add(arr8);
        list.add(arr9);

        RecyclerView recyclerView = findViewById(R.id.recyclerView) ;
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager) ;

        MainRecyclerViewAdapter adapter = new MainRecyclerViewAdapter(list) ;
        recyclerView.setAdapter(adapter) ;
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.appbar_action, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(MainActivity.this, SearchActivity.class);

        switch (item.getItemId()) {
            case R.id.search:
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public int getStatusBarHeight()
    {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0)
            result = getResources().getDimensionPixelSize(resourceId);

        return result;
    }
}