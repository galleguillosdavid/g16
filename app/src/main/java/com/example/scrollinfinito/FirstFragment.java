package com.example.scrollinfinito;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scrollinfinito.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment implements WordAdapter.PassElementSelected {
    private FragmentFirstBinding binding;
    private RecyclerView mRecyclerView;
    private WordAdapter mWordAdapter;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false);

        mRecyclerView = binding.myRecycler;
        mWordAdapter = new WordAdapter(getWordData(),this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mWordAdapter);

        //return inflater.inflate(R.layout.fragment_first, container, false);
        Log.d("TAG", String.valueOf(getWordData()));
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
    private List<String> getWordData(){
        List<String> palabras = new ArrayList<>();
        for(int i = 0; i<20;i++ ){
            palabras.add("WORD " + i);
        }
        return palabras;
    }

    @Override
    public void passElement(String word) {
        Toast.makeText(getContext(), word, Toast.LENGTH_SHORT).show();
    }
}