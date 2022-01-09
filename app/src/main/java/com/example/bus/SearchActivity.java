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
    RecyclerView searchRecyclerView;
    SearchRecyclerViewAdapter adapter;
    ArrayList<String> list = new ArrayList<>();
    ArrayList<String> searchResultList = new ArrayList<>();

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

        searchRecyclerView = (RecyclerView) findViewById(R.id.searchRecyclerView);
        adapter = new SearchRecyclerViewAdapter(searchResultList);
        searchRecyclerView.setAdapter(adapter);
        searchRecyclerView.addItemDecoration(new DividerItemDecoration(searchRecyclerView.getContext(), 1));

        new TabLayoutMediator(tabs, pager, (tab, position) -> tab.setText(TAB_TITLES[position])).attach();

        setList(1);

        tabs.addOnTabSelectedListener(tabSelectedListener);
        searchBox.addTextChangedListener(textWatcher);
    }

    void setList(int index) {
        if(index == 1) {
            list.add("대전테크노파크");
            list.add("으능정이");
            list.add("대전준법지원센터");
            list.add("중부경찰서");
            list.add("대전역");
            list.add("서대전초등학교");
            list.add("호수돈여고");
            list.add("대전대학교입구");
            list.add("용운동주민센터");
            list.add("용운도서관");
            list.add("판암주공5단지");
            list.add("판암역");
        } else if(index == 2) {
            list.clear();
            list.add("603");
            list.add("107");
            list.add("318");
            list.add("604");
            list.add("108");
            list.add("912");
            list.add("511");
            list.add("684");
            list.add("422");
            list.add("357");
            list.add("급행 1번");
        }
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
            searchResultList.clear();

            for(int i = 0; i < list.size(); i++) {
                if(list.get(i).contains(searchBox.getText())) {
                    searchResultList.add(list.get(i));
                }
            }

            adapter.notifyItemRangeInserted(0, searchResultList.size());
        }
    };
}