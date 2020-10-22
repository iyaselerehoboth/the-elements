package com.iyaselerehoboth.theelements.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iyaselerehoboth.theelements.data.room.tables.Elements;
import com.iyaselerehoboth.theelements.databinding.ItemElementsLayoutBinding;

import java.util.List;

public class ElementsAdapter extends RecyclerView.Adapter<ElementsAdapter.ViewHolder> {
    private final OnItemClickListener listener;
    private Context mCtx;
    private List<Elements> elementsList;

    public ElementsAdapter(Context context, List<Elements> elementsList, OnItemClickListener listener) {
        this.mCtx = context;
        this.elementsList = elementsList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemElementsLayoutBinding binding = ItemElementsLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(elementsList.get(position));
    }

    @Override
    public int getItemCount() {
        return elementsList.size();
    }

    public interface OnItemClickListener {
        void onClick(Elements element);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemElementsLayoutBinding binding;

        public ViewHolder(ItemElementsLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.getRoot().setOnClickListener(view -> listener.onClick(elementsList.get(getLayoutPosition())));
        }

        public void bind(Elements element) {
            binding.mtvFullName.setText(element.getName());
            binding.mtvElectronicConfiguration.setText(element.getElectronic_configuration());
            binding.mtvSymbol.setText(element.getSymbol());
            binding.mtvSymbol.setBackgroundColor(Color.parseColor("#" + element.getCpk_hex_color()));
            binding.executePendingBindings();
        }
    }
}
