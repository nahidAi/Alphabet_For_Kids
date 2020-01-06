package com.p.alphabetforkids.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.p.alphabetforkids.Model.ItemModel;
import com.p.alphabetforkids.R;
import com.squareup.picasso.Picasso;
import com.zyp.cardview.YcCardView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterAlfabet extends RecyclerView.Adapter<AdapterAlfabet.viewHolder> {
    Context context;
    private List<ItemModel>itemModelList;
    public AdapterAlfabet(Context context,List<ItemModel>itemModelList) {
        this.context = context;
        this.itemModelList = itemModelList;

    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_for_recyclerview,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ItemModel model = itemModelList.get(position);
        holder.txtItem.setText(model.getTitle());
        /*Picasso
                .with(context)
                .load(model.getImage())
                .into(holder.imgItem);*/




    }

    @Override
    public int getItemCount() {
        return itemModelList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        private ImageView imgItem;
        private TextView txtItem;
        private YcCardView ycCardView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.imageItem);
            txtItem = itemView.findViewById(R.id.txtItem);
            ycCardView = itemView.findViewById(R.id.card);
            ycCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, " کلیک شد ", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
