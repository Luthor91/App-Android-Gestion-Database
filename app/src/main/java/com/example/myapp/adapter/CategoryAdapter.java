package com.example.myapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapp.R;
import com.example.myapp.dta.CategoryDto;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private List<CategoryDto> mData;
    private LayoutInflater mInflater;

    // data is passed into the constructor
    public CategoryAdapter(Context context, List<CategoryDto> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.categorylayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CategoryDto categoryDto = mData.get(position);
        holder.levelTextView.setText(categoryDto.getTitle());
        holder.titleTextView.setText(""+categoryDto.getLeval());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView levelTextView;
        TextView titleTextView;
        ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            levelTextView = itemView.findViewById(R.id.levelTextView);
        }


    }
}