package com.adith.dicoding.myrecycleview.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.adith.dicoding.myrecycleview.Presiden;
import com.adith.dicoding.myrecycleview.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListPresidenAdapter extends RecyclerView.Adapter<ListPresidenAdapter.CategoryViewHolder>{
    private Context konteks;

    public ArrayList<Presiden> getListPresiden(){
        return listPresiden;
    }
    public void setListPresident(ArrayList<Presiden> listPresiden) {
        this.listPresiden = listPresiden;
    }

    private ArrayList<Presiden>listPresiden;

    public ListPresidenAdapter(Context konteks){
        this.konteks = konteks;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_baris_presiden, parent, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        holder.namaPresiden.setText(getListPresiden().get(position).getName());
        holder.remarksPresiden.setText(getListPresiden().get(position).getRemarks());

        Glide.with(konteks)
                .load(getListPresiden().get(position).getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListPresiden().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder{
        TextView namaPresiden;
        TextView remarksPresiden;
        ImageView imgPhoto;

        public CategoryViewHolder (View itemView){
            super(itemView);
            namaPresiden = (TextView)itemView.findViewById(R.id.nama_presiden);
            remarksPresiden = (TextView)itemView.findViewById(R.id.remaks_presiden);
            imgPhoto = (ImageView)itemView.findViewById(R.id.item_photo);
        }
    }
}
