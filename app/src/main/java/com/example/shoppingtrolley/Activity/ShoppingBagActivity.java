package com.example.shoppingtrolley.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shoppingtrolley.Adapter.ShowbagAdapter;
import com.example.shoppingtrolley.Bean.ShowBagBean;
import com.example.shoppingtrolley.R;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBagActivity extends AppCompatActivity implements View.OnClickListener {

    List<ShowBagBean> mDatas = new ArrayList<>();
    private RecyclerView rec;
    public static TextView bag_price;
    private TextView bag_send;
    public static TextView bag_money;
    private Button bag_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_bag);
        initView();
        Intent intent = getIntent();
        String photo = intent.getStringExtra("photo");
//        ShowBagBean.Bean bean = new ShowBagBean.Bean(photo, intent.getStringExtra("title"), intent.getStringExtra("price"));
//        bean
        String price = intent.getStringExtra("price");
        ShowBagBean showBagBean = new ShowBagBean(photo, intent.getStringExtra("title"), intent.getStringExtra("price"));

        mDatas.add(showBagBean);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rec.setLayoutManager(manager);
        rec.setAdapter(new ShowbagAdapter(this, mDatas));
        bag_price.setText(showBagBean.getNum());
        bag_money.setText(Integer.parseInt(showBagBean.getNum()) + 15 + "");
    }

    private void initView() {
        rec = (RecyclerView) findViewById(R.id.rec);
        bag_price = (TextView) findViewById(R.id.bag_price);
        bag_send = (TextView) findViewById(R.id.bag_send);
        bag_money = (TextView) findViewById(R.id.bag_money);
        bag_btn = (Button) findViewById(R.id.bag_btn);

        bag_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bag_btn:

                break;
        }
    }

    public void sax(View view) {
        Toast.makeText(this, "结算完成", Toast.LENGTH_SHORT).show();
    }
}
