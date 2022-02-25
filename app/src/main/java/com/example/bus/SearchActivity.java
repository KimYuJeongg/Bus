package com.example.bus;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.bus.data.BusStopInterface;
import com.example.bus.data.Example;
import com.example.bus.data.Items;
import com.example.bus.data.RetrofitClient;
import com.example.bus.databinding.ActivitySearchBinding;
import com.example.bus.ui.main.PlaceholderFragment;
import com.example.bus.ui.main.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

    private ActivitySearchBinding binding;
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final String key = "key";
    private BusStopInterface busStopInterface;
    private SectionsPagerAdapter sectionsPagerAdapter;
    List<PlaceholderFragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fragments = new ArrayList<>();
        fragments.add(PlaceholderFragment.newInstance(1));
        fragments.add(PlaceholderFragment.newInstance(2));
        sectionsPagerAdapter = new SectionsPagerAdapter(SearchActivity.this, fragments);
        ViewPager2 pager = binding.viewPager;
        pager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        EditText searchBox = binding.searchBox;

        new TabLayoutMediator(tabs, pager, (tab, position) -> tab.setText(TAB_TITLES[position])).attach();

        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        busStopInterface = RetrofitClient.getRetrofitInterface();

        searchBox.addTextChangedListener(textWatcher);
        pager.registerOnPageChangeCallback(pageChangeCallback);
    }

    ViewPager2.OnPageChangeCallback pageChangeCallback = new ViewPager2.OnPageChangeCallback() {
        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            if (position == 0) {
                System.out.println("position: 정류장");
            } else if (position == 1) {
                System.out.println("position: 버스");
            }
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
        busStopInterface.getBusStop(key, 25, "json", 25, s.toString()).enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.isSuccessful()) {
                    Example example = response.body();
                    Items items = example.getResult().getBody().getItems();
                    fragments.get(0).resetRecyclerView(items.getItem());
                    sectionsPagerAdapter.notifyDataSetChanged();
                } else {
                    Log.d("retrofit", "Data fetch fail");
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("retrofit", t.getMessage());
            }
        });
        }
    };
}