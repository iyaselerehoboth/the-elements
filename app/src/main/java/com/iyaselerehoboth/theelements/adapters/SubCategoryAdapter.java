package com.iyaselerehoboth.theelements.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iyaselerehoboth.theelements.databinding.ItemSubCategoryLayoutBinding;

import java.util.List;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.ViewHolder> {
    private final OnItemClickListener listener;
    private Context mCtx;
    private List<String> sub_category_list;

    public SubCategoryAdapter(Context context, List<String> sub_category_list, OnItemClickListener listener) {
        this.mCtx = context;
        this.listener = listener;
        this.sub_category_list = sub_category_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSubCategoryLayoutBinding binding = ItemSubCategoryLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String sub = sub_category_list.get(position);
        holder.bind(sub);
    }

    @Override
    public int getItemCount() {
        return sub_category_list.size();
    }

    public interface OnItemClickListener {
        void onClick(String sub_category);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemSubCategoryLayoutBinding binding;

        public ViewHolder(ItemSubCategoryLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.getRoot().setOnClickListener(v -> {
                listener.onClick(sub_category_list.get(getLayoutPosition()));
            });
        }

        public void bind(String sub_category) {
            binding.mtvSubCategory.setText(sub_category);
            binding.executePendingBindings();
        }
    }
}
