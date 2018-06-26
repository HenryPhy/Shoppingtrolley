package com.example.shoppingtrolley.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shoppingtrolley.Activity.ShoppingBagActivity;
import com.example.shoppingtrolley.Bean.ShowBagBean;
import com.example.shoppingtrolley.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class ShowbagAdapter extends RecyclerView.Adapter<ShowbagAdapter.ViewHolder> {
    private int num = 1;
    private Context context;
    private List<ShowBagBean> mDatas;

    public ShowbagAdapter(Context context, List<ShowBagBean> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_bag, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        final ShowBagBean showBagBean = mDatas.get(position);
        Picasso.with(context).load(showBagBean.getPath()).into(holder.iv);
        holder.tv1.setText(showBagBean.getTitle());
        holder.tv3.setText(showBagBean.getNum());

        holder.iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num--;
                if (num > 0) {
                    holder.tv2.setText(num + "");
                    int i = num * Integer.parseInt(showBagBean.getNum());
                    ShoppingBagActivity.bag_price.setText(i + "");
                    ShoppingBagActivity.bag_money.setText(i + 15 + "");
                } else if (num <= 0) {
                    num = 1;
                    Toast.makeText(context, "不能在减了", Toast.LENGTH_SHORT).show();
                }
            }
        });
        holder.iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num++;
                holder.tv2.setText(num + "");
                int num1 = num * Integer.parseInt(showBagBean.getNum());
                ShoppingBagActivity.bag_price.setText(num1 + "");
                ShoppingBagActivity.bag_money.setText(num1 + 15 + "");

            }
        });


    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv, iv2, iv3;
        TextView tv1, tv2, tv3;

        public ViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.itembag_ivv);
            iv2 = itemView.findViewById(R.id.itembag_jian);
            iv3 = itemView.findViewById(R.id.itembag_jia);
            tv1 = itemView.findViewById(R.id.itembag_tv1);
            tv2 = itemView.findViewById(R.id.itembag_tv);
            tv3 = itemView.findViewById(R.id.itembag_allprice);
        }
    }
}
