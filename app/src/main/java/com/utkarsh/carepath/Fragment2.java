package com.utkarsh.carepath;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class Fragment2 extends Fragment {

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_fragment2, container, false);

        final CancelableEdittext edittext = view.findViewById(R.id.fragment_2_edittext);

        edittext.requestFocus();

        Button send = view.findViewById(R.id.fragment_2_btn);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                @SuppressLint({"NewApi", "LocalSuppress"})
                String data = Objects.requireNonNull(edittext.getText()).toString().trim();
                if (data.isEmpty()) {
                    Toast.makeText(view.getContext(),"Field is Empty...",Toast.LENGTH_SHORT).show();
                }
                else {
                    Bundle bundle = new Bundle();
                    bundle.putString("Data",data);
                    Toast.makeText(view.getContext(),"Data Send Successfully...",Toast.LENGTH_SHORT).show();
                    Fragment fragment = new Fragment1();
                    fragment.setArguments(bundle);
                    assert getFragmentManager() != null;
                    getFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
                }
            }
        });

        TextView textView = view.findViewById(R.id.fragment_2_txt);

        if (getArguments()!= null && getArguments().containsKey("Data")) {
            textView.setText("Data Received :- \n\n"+getArguments().getString("Data"));
        }

        return view;
    }
}
