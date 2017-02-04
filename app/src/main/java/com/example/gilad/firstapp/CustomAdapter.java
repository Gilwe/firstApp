package com.example.gilad.firstapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

/**
 * Created by Gilad on 04/02/2017.
 */

public class CustomAdapter extends ArrayAdapter<String> {

    public CustomAdapter(Context context, String [] Names) {
        super(context,R.layout.custom_row, Names);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.custom_row, parent,false);

        TextView title = (TextView) customView.findViewById(R.id.videoTitle);
        TextView size = (TextView) customView.findViewById(R.id.videoSize);

        title.setText(getItem(position));

        Random r = new Random();
        r.nextInt();

        size.setText((String.valueOf(((new Random()).nextInt(100) + 1) )) + " MB" );

        return customView;
    }
}
