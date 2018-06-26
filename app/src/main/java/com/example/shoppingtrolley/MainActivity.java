package com.example.shoppingtrolley;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.shoppingtrolley.Activity.ShoppingBagActivity;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView iv;
    private Button btn_car;
    Intent intent;
    String title;
    private String price, photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        intent = getIntent();
        photo = intent.getStringExtra("photo");
        Picasso.with(this).load(photo).into(iv);
        title = intent.getStringExtra("title");
        price = intent.getStringExtra("price");
    }

    private void initView() {
        iv = (ImageView) findViewById(R.id.iv);
        btn_car = (Button) findViewById(R.id.btn_car);

        btn_car.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_car:
                Intent intent1 = new Intent(this, ShoppingBagActivity.class);
                intent1.putExtra("photo", photo);
                intent1.putExtra("title", title);
                intent1.putExtra("price", price);
                startActivity(intent1);
                break;
        }
    }
}
