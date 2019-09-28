package com.nguyenoanh.email;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAccountAdapter extends RecyclerView.Adapter<ItemAccountAdapter.ViewHolder> {
    private Context context;
    private List<ItemAccount> list;

    public ItemAccountAdapter(Context context, List<ItemAccount> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from (context);
        View view = inflater.inflate (R.layout.item_account, viewGroup, false);

        return new ItemAccountAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int i) {
        final ItemAccount itemNew = list.get (i);

        holder.tvIconName.setText (itemNew.getIconName ());
        holder.tvName.setText (itemNew.getName ());
        holder.tvContent.setText (itemNew.getContent ());
        holder.tvTime.setText (itemNew.getTime ());
        holder.cardView.setCardBackgroundColor (ContextCompat.getColor(context,itemNew.getCardView ()));

        holder.itemView.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle ();
                bundle.putInt ("id", itemNew.getId ());
                bundle.putString ("name", itemNew.getName ());

                Intent intent = new Intent (context.getApplicationContext (), Sender.class);
                intent.addFlags (Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra ("bundle", bundle);
                context.startActivity (intent);
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        CardView cardView;
        TextView tvIconName, tvName, tvContent, tvTime;

        public ViewHolder(@NonNull View itemView) {
            super (itemView);

            cardView = (CardView) itemView.findViewById (R.id.card_view);
            tvIconName = (TextView) itemView.findViewById (R.id.icon_name);
            tvName = (TextView) itemView.findViewById (R.id.tv_name);
            tvContent = (TextView) itemView.findViewById (R.id.tv_content);
            tvTime = (TextView) itemView.findViewById (R.id.tv_time);

            itemView.setOnClickListener (this);
        }

        @Override
        public void onClick(View view) {
        }
    }

    @Override
    public int getItemCount() {
        return list.size ();
    }

    public ItemAccount getItem(int position) {
        return list.get(position);
    }
}


