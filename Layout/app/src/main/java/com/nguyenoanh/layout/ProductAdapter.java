package com.nguyenoanh.layout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context context;

    private List<Product> productList;


    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_view, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int i) {

        Product product = productList.get(i);

        holder.tvTitle.setText(product.getTitle());
        holder.tvTopic.setText(product.getTitle());
        holder.tvTime.setText(product.getDate());
        holder.tvComment.setText(product.getTitle());
        holder.tvLike.setText(product.getTitle());
        holder.tvContentNew.setText(product.getTitle());

        holder.imageView.setImageDrawable(context.getResources().getDrawable(product.getImage()));

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvTopic, tvTime, tvContentNew, tvComment, tvLike;
        ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTiltle);
            tvTopic = itemView.findViewById(R.id.tvTopic);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvContentNew = itemView.findViewById(R.id.tvContent);
            tvComment = itemView.findViewById(R.id.tvComment);
            tvLike = itemView.findViewById(R.id.tvLike);

            imageView = itemView.findViewById(R.id.imvImage);
        }
    }
}
