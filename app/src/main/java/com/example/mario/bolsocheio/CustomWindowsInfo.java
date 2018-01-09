package com.example.mario.bolsocheio;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by mario on 09/01/18.
 */

public class CustomWindowsInfo implements GoogleMap.InfoWindowAdapter {

    private Activity context;

    public CustomWindowsInfo (Activity context){
        this.context = context;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {

//        Log.d("AQUIIIIIIIIIIIIIIIIIII", "ENTROUUUUUU");
//
//        View view = context.getLayoutInflater().inflate(R.layout.custompopup, null);
//
//        TextView tvTitle = (TextView) view.findViewById(R.id.tv_title);
//        TextView tvSubTitle = (TextView) view.findViewById(R.id.tv_subtitle);
//
//        tvTitle.setText(marker.getTitle());
//        tvSubTitle.setText(marker.getSnippet());

        //Context context = getApplicationContext(); //or getActivity(), YourActivity.this, etc.

        LinearLayout info = new LinearLayout(context);
        info.setOrientation(LinearLayout.VERTICAL);

        TextView title = new TextView(context);
        title.setTextColor(Color.GREEN);
        title.setGravity(Gravity.CENTER);
        title.setTypeface(null, Typeface.BOLD);
        title.setText(marker.getTitle());

        TextView snippet = new TextView(context);
        snippet.setTextColor(Color.GRAY);
        snippet.setText(marker.getSnippet());

        Button button = new Button(context);
        button.setText("clica");
        button.setBackgroundColor(25);


        info.addView(title);
        info.addView(snippet);
        info.addView(button);

        return info;

        //return view;
    }
}