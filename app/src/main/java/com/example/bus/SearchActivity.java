package com.example.bus;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.bus.adapter.SearchRecyclerViewAdapter;
import com.example.bus.databinding.ActivitySearchBinding;
import com.example.bus.databinding.FragmentSearchBinding;
import com.example.bus.ui.main.PlaceholderFragment;
import com.example.bus.ui.main.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    private ActivitySearchBinding binding;
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
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
            fragment.setSearchResultList(s.toString());
        }
    };
}