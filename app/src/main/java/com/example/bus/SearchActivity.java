package com.example.bus;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.bus.data.Body;
import com.example.bus.data.BusStopInterface;
import com.example.bus.data.Items;
import com.example.bus.data.Result;
import com.example.bus.data.RetrofitClient;
import com.example.bus.databinding.ActivitySearchBinding;
import com.example.bus.ui.main.PlaceholderFragment;
import com.example.bus.ui.main.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

    private ActivitySearchBinding binding;
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private String key = "9BWhbO2OOt0gFxjT43TFFgz5hK2EAxt%2BPEO0DTHE1i7lO7pOlN3GhQJgM2F5Yd4cH4fwkoC4UYmwOFoLOzVxng%3D%3D";
    private BusStopInterface busStopInterface;
    private RetrofitClient retrofitClient;

    ViewPager2 pager;
    TabLayout tabs;
    EditText searchBox;
    PlaceholderFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(SearchActivity.this);
        pager = binding.viewPager;
        pager.setAdapter(sectionsPagerAdapter);
        tabs = binding.tabs;
        searchBox = binding.searchBox;
        fragment = new PlaceholderFragment();
        new TabLayoutMediator(tabs, pager, (tab, position) -> tab.setText(TAB_TITLES[position])).attach();

        tabs.addOnTabSelectedListener(tabSelectedListener);
        searchBox.addTextChangedListener(textWatcher);

        retrofitClient = RetrofitClient.getInstance();
        busStopInterface = RetrofitClient.getRetrofitInterface();

        busStopInterface.getBusStop(key, 1, 10, "json", 25, "전통시장", 44810).enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if(response.isSuccessful())
                {
                    Result result = response.body();
                    Body body = result.getBody();
                    Items items = body.getItems();
                    Log.d("retrofit", "Data fetch success");
                    fragment.busStopItems = items.getItem();
                } else {
                    Log.d("retrofit", "Data fetch fail");
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.d("retrofit", t.getMessage());
                Log.d("retrofit", "onFailure");
            }
        });
    }

    TabLayout.OnTabSelectedListener tabSelectedListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            if (tab.getPosition() == 0) {
                    System.out.println("position: 정류장");
                } else if (tab.getPosition() == 1) {
                    System.out.println("position: 버스");
                }
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
//            fragment.setSearchResultList(s.toString());
        }
    };
}