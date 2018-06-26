package com.example.shoppingtrolley.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shoppingtrolley.Bean.ShowBean;
import com.example.shoppingtrolley.MainActivity;
import com.example.shoppingtrolley.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ViewHolder> {
    private Context context;
    private List<ShowBean.DataBean> mDatas;

    public ShowAdapter(Context context, List<ShowBean.DataBean> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_show, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        final ShowBean.DataBean bean = mDatas.get(position);
        Picasso.with(context).load(bean.getPic()).into(holder.iv);
        holder.tv1.setText(bean.getTitle());
        holder.tv2.setText(bean.getNum()+"");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("photo", mDatas.get(position).getPic());
                intent.putExtra("title", mDatas.get(position).getTitle());
                intent.putExtra("price", mDatas.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView tv1, tv2;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.item_iv);
            tv1 = itemView.findViewById(R.id.name);
            tv2 = itemView.findViewById(R.id.item_tv_price);
        }
    }
}
