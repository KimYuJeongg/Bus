package com.example.bus;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.bus.data.RetrofitClient;
import com.example.bus.data.busnumber.BusNumberExample;
import com.example.bus.data.busnumber.BusNumberInterface;
import com.example.bus.data.busnumber.BusNumberItems;
import com.example.bus.data.busstop.BusStopExample;
import com.example.bus.data.busstop.BusStopInterface;
import com.example.bus.data.busstop.BusStopItems;
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

public class SearchActivity extends Fragment {

    private ActivitySearchBinding binding;
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private List<PlaceholderFragment> fragments;
    private int page = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());

        fragments = new ArrayList<>();
        fragments.add(PlaceholderFragment.newInstance(1));
        fragments.add(PlaceholderFragment.newInstance(2));
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager(), getLifecycle(), fragments);
        ViewPager2 pager = binding.viewPager;
        pager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        EditText searchBox = binding.searchBox;
        ImageButton cancelButton = binding.cancelButton;

        new TabLayoutMediator(tabs, pager, (tab, position) -> tab.setText(TAB_TITLES[position])).attach();

        cancelButton.setOnClickListener(cancelListener);
        searchBox.addTextChangedListener(textWatcher);
        pager.registerOnPageChangeCallback(pageChangeCallback);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    View.OnClickListener cancelListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText searchBox = binding.searchBox;
            searchBox.setText("");
        }
    };

    ViewPager2.OnPageChangeCallback pageChangeCallback = new ViewPager2.OnPageChangeCallback() {
        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            page = position;
        }
    };

    TextWatcher textWatcher = new TextWatcher() {
        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        BusStopInterface busStopInterface = retrofitClient.getBusStopRetrofitInterface();
        BusNumberInterface busNumberInterface = retrofitClient.getBusRetrofitInterface();
        final String API_KEY = BuildConfig.API_KEY;

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            final String text = s.toString();
            if(!(text.trim().isEmpty()) && text.matches("^[가-힣a-zA-Z0-9]*$")) {
                if (page == 0) {
                    busStopInterface.getBusStop(API_KEY, 25, "json", 25, text).enqueue(new Callback<BusStopExample>() {
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
                    busNumberInterface.getBusNumberList(API_KEY, 10, "json", 25, text).enqueue(new Callback<BusNumberExample>() {
                        @Override
                        public void onResponse(Call<BusNumberExample> call, Response<BusNumberExample> response) {
                            if (response.isSuccessful()) {
                                BusNumberExample example = response.body();
                                BusNumberItems items = example.getResult().getBody().getItems();
                                fragments.get(1).resetBusItems(items.getBusItem());
                                Log.d("retrofit", "Bus Data fetch success");
                            } else {
                                Log.d("retrofit", "Bus Data fetch fail");
                            }
                        }

                        @Override
                        public void onFailure(Call<BusNumberExample> call, Throwable t) {
                            Log.e("Bus retrofit", t.getMessage());
                        }
                    });
                }
            }
        }
    };
}