package com.utkarsh.carepath;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tab1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_tab1, container, false);

        TextView textView = view.findViewById(R.id.entre_txt);

        try {
            String line;
            InputStreamReader isr = new InputStreamReader(getResources().getAssets().open("Entre.txt"));
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
            String data = stringBuilder.toString();
            textView.setText(data);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return view;
    }
}
