package com.example.firebasecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private TextView detailDesc, detailTitle;
    private ImageView detailImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailTitle = (TextView) findViewById(R.id.detailTitle);
        detailDesc = (TextView) findViewById(R.id.detailDesc);
        detailImage = (ImageView) findViewById(R.id.detailImage);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            detailTitle.setText(bundle.getString("title"));
            detailDesc.setText(bundle.getString("description"));
            Glide.with(this).load(bundle.getString("image")).into(detailImage);
        }
    }
}