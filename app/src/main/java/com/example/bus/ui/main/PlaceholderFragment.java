package com.example.bus.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bus.adapter.SearchRecyclerViewAdapter;
import com.example.bus.data.BusStopItem;
import com.example.bus.databinding.FragmentSearchBinding;

import java.util.ArrayList;
import java.util.List;

public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private FragmentSearchBinding binding;

    ArrayList<String> list = new ArrayList<>();
    public List<BusStopItem> busStopItems = new ArrayList<>();
    SearchRecyclerViewAdapter adapter = new SearchRecyclerViewAdapter(busStopItems);

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        setList(index);
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSearchBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recyclerView = binding.searchRecyclerView;
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), 1));

        pageViewModel.getIndex().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer index) {
                if (index == 1) {
                    adapter.setItemViewType(SearchRecyclerViewAdapter.VIEWTYPE_BUS_STOP);
                } else if (index == 2) {
                    adapter.setItemViewType(SearchRecyclerViewAdapter.VIEWTYPE_BUS);
                }
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    void setList(int index) {
        if(index == 1) {
            list.add("ab");
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
        } else {
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

}