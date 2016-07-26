package com.microsoft.hack.whatthediet.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.microsoft.hack.whatthediet.R;
import com.microsoft.hack.whatthediet.models.FoodItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prmeno on 7/26/2016.
 */
public class FoodItemsAdapter extends RecyclerView.Adapter<FoodItemsAdapter.FoodItemviewHolder> {

    private List<FoodItem> mFoodItems;

    public FoodItemsAdapter() {
        mFoodItems = new ArrayList<FoodItem>();
    }

    @Override
    public FoodItemviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View foodItemView = layoutInflater.inflate(R.layout.list_item_food, parent, false);

        return new FoodItemviewHolder(foodItemView);
    }

    @Override
    public void onBindViewHolder(FoodItemviewHolder holder, int position) {
        holder.bind(mFoodItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mFoodItems.size();
    }

    public void renewList(List<FoodItem> foodItems) {
        mFoodItems = foodItems;
        notifyDataSetChanged();
    }

    private void removeFoodItem(int position) {
        mFoodItems.remove(position);
        notifyItemRemoved(position);
    }

    public class FoodItemviewHolder extends RecyclerView.ViewHolder {

        private TextView mtextViewName;

        public FoodItemviewHolder(View itemView) {
            super(itemView);

            mtextViewName = (TextView) itemView.findViewById(R.id.textViewName);
        }

        public void bind(FoodItem foodItem) {
            mtextViewName.setText(foodItem.getName());
        }
    }
}
