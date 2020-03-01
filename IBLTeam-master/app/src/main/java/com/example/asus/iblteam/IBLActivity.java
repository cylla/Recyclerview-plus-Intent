package com.example.asus.iblteam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class IBLActivity extends AppCompatActivity {

    ImageView ivDetail;
    TextView tvDetail,tvTitle,tvLink;

//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//        startActivity(intent);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibl);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ivDetail = findViewById(R.id.iv_detail);
        tvDetail = findViewById(R.id.team_description);
        tvTitle = findViewById(R.id.team_title);
        tvLink = findViewById(R.id.link_team);

        getIncomingIntent();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                return true;

                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    private void getIncomingIntent(){
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int ivThumb = bundle.getInt("img_url");
            Glide.with(getApplicationContext()).load(ivThumb).into(ivDetail);
            String getDesc = bundle.getString("detail");
            String getTitle = bundle.getString("title");
            String getLink = bundle.getString("link");

            tvLink.setText(getLink);
            tvDetail.setText(getDesc);
            tvTitle.setText(getTitle);

        }


    }
}
