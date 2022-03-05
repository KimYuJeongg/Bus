package com.example.bus;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.bus.data.RetrofitClient;
import com.example.bus.data.bus.BusExample;
import com.example.bus.data.bus.BusInterface;
import com.example.bus.data.bus.BusItems;
import com.example.bus.data.busstop.BusStopExample;
import com.example.bus.data.busstop.BusStopInterface;
import com.example.bus.data.busstop.BusStopItems;
import com.example.bus.databinding.ActivitySearchBinding;
import com.example.bus.ui.main.PlaceholderFragment;
import com.example.bus.ui.main.SectionsPagerAdapter;
import com.google.android.material.appbar.AppBarLayout;
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
    private List<PlaceholderFragment> fragments;
    private int page = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppBarLayout appBarLayout = findViewById(R.id.appbar);
        appBarLayout.setPadding(0, getStatusBarHeight(), 0, 0);
        fragments = new ArrayList<>();
        fragments.add(PlaceholderFragment.newInstance(1));
        fragments.add(PlaceholderFragment.newInstance(2));
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(SearchActivity.this, fragments);
        ViewPager2 pager = binding.viewPager;
        pager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        EditText searchBox = binding.searchBox;

        new TabLayoutMediator(tabs, pager, (tab, position) -> tab.setText(TAB_TITLES[position])).attach();

        searchBox.addTextChangedListener(textWatcher);
        pager.registerOnPageChangeCallback(pageChangeCallback);
    }

    ViewPager2.OnPageChangeCallback pageChangeCallback = new ViewPager2.OnPageChangeCallback() {
        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            if (position == 0) {
                System.out.println("position: 정류장");
                page = 0;
            } else if (position == 1) {
                System.out.println("position: 버스");
                page = 1;
            }
        }
    };

    TextWatcher textWatcher = new TextWatcher() {
        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        BusStopInterface busStopInterface = retrofitClient.getBusStopRetrofitInterface();
        BusInterface busInterface = retrofitClient.getBusRetrofitInterface();
        final String API_KEY = BuildConfig.API_KEY;

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (page == 0) {
                busStopInterface.getBusStop(API_KEY, 25, "json", 25, s.toString()).enqueue(new Callback<BusStopExample>() {
                    @Override
                    public void onResponse(Call<BusStopExample> call, Response<BusStopExample> response) {
                        if (response.isSuccessful()) {
                            BusStopExample example = response.body();
                            BusStopItems items = example.getResult().getBody().getItems();
                            fragments.get(0).resetBusStopItems(items.getBusStopItem());
                            Log.d("retrofit", "Bus Stop Data fetch success");
                        } else {
                            Log.d("retrofit", "Bus Stop Data fetch fail");
                        }
                    }

                    @Override
                    public void onFailure(Call<BusStopExample> call, Throwable t) {
                        Log.e("Bus Stop retrofit", t.getMessage());
                    }
                });
            } else if (page == 1) {
                busInterface.getBus(API_KEY, 10, "json", 25, s.toString()).enqueue(new Callback<BusExample>() {
                    @Override
                    public void onResponse(Call<BusExample> call, Response<BusExample> response) {
                        if (response.isSuccessful()) {
                            BusExample example = response.body();
                            BusItems items = example.getResult().getBody().getItems();
                            fragments.get(1).resetBusItems(items.getBusItem());
                            Log.d("retrofit", "Bus Data fetch success");
                        } else {
                            Log.d("retrofit", "Bus Data fetch fail");
                        }
                    }

                    @Override
                    public void onFailure(Call<BusExample> call, Throwable t) {
                        Log.e("Bus retrofit", t.getMessage());
                    }
                });
            }
        }
    };

    public int getStatusBarHeight()
    {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0)
            result = getResources().getDimensionPixelSize(resourceId);

        return result;
    }
}