package com.example.bus.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bus.adapter.SearchRecyclerViewAdapter;
import com.example.bus.data.busnumber.BusNumberItem;
import com.example.bus.data.busstop.BusStopItem;
import com.example.bus.databinding.FragmentSearchBinding;

import java.util.List;

public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private FragmentSearchBinding binding;

    public SearchRecyclerViewAdapter adapter = new SearchRecyclerViewAdapter();

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
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSearchBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = binding.searchRecyclerView;
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), 1));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void resetBusStopItems(List<BusStopItem> newItems) {
        adapter.resetBusStopItems(newItems);
    }

    public void resetBusItems(List<BusNumberItem> newItems) {
        adapter.resetBusItems(newItems);
    }
}