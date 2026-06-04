package com.tao.android.myfirstandroid.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tao.android.myfirstandroid.R;
import com.tao.android.myfirstandroid.model.FoodItem;

import java.util.List;

/**
 * ClassName: FoodAdapter
 * Package: com.tao.android.myfristandroid.adapter
 * Description:
 *
 * @Author ct
 * @Create 2026/6/3 21:44
 * @Version 1.0
 */
public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    private List<FoodItem> foodList;

    public FoodAdapter(List<FoodItem> foodList) {
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FoodItem item=foodList.get(position);
        holder.foodName.setText(item.getName());
        holder.foodDescription.setText(item.getDescription());
        holder.foodImage.setImageResource(item.getImageResId());
    }

    public  void updateData(List<FoodItem> newfoodList){
        this.foodList=newfoodList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public  static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView foodImage;
        TextView foodName;
        TextView foodDescription;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImage=itemView.findViewById(R.id.item_food_image);
            foodName=itemView.findViewById(R.id.item_food_name);
            foodDescription=itemView.findViewById(R.id.item_food_desc);
        }
    }
}
