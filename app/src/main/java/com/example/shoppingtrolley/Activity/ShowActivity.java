package com.example.shoppingtrolley.Activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.shoppingtrolley.Adapter.ShowAdapter;
import com.example.shoppingtrolley.Bean.ShowBean;
import com.example.shoppingtrolley.Okhttp;
import com.example.shoppingtrolley.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ShowActivity extends AppCompatActivity {

    String path = "http://www.qubaobei.com/ios/cf/dish_list.php?stage_id=1&limit=20&page=1";
    private RecyclerView show_rv;
    private List<ShowBean.DataBean> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();
        new Task().execute();
        ShowAdapter showAdapter = new ShowAdapter(this, list);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        show_rv.setLayoutManager(manager);
        show_rv.setAdapter(showAdapter);
    }

    private void initView() {
        show_rv = (RecyclerView) findViewById(R.id.show_rv);
    }

    class Task extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            return Okhttp.getString(path);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s != null && !s.isEmpty()) {
                Gson gson = new Gson();
                ShowBean showBean = gson.fromJson(s, ShowBean.class);
                List<ShowBean.DataBean> data = showBean.getData();
                list.addAll(data);

            }
        }
    }
}
