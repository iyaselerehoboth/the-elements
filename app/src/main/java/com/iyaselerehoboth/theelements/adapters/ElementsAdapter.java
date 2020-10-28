package com.iyaselerehoboth.theelements.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iyaselerehoboth.theelements.data.room.tables.Elements;
import com.iyaselerehoboth.theelements.databinding.ItemElementsLayoutBinding;

import java.util.ArrayList;
import java.util.List;

public class ElementsAdapter extends RecyclerView.Adapter<ElementsAdapter.ViewHolder> implements Filterable {
    private final OnItemClickListener listener;
    private Context mCtx;
    private List<Elements> elementsList;
    private List<Elements> mFilteredList;

    public ElementsAdapter(Context context, List<Elements> elementsList, OnItemClickListener listener) {
        this.mCtx = context;
        this.elementsList = elementsList;
        this.mFilteredList = elementsList;
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
        holder.bind(mFilteredList.get(position));
    }

    @Override
    public int getItemCount() {
        if (mFilteredList != null) {
            return mFilteredList.size();
        } else {
            return elementsList.size();
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    mFilteredList = elementsList;
                } else {
                    List<Elements> filteredList = new ArrayList<>();
                    for (Elements element : elementsList) {
                        if (element.getName().toLowerCase().contains(charString)
                                || element.getSymbol().toLowerCase().contains(charString) || element.getAtomic_number().toString().contains(charString)) {
                            filteredList.add(element);
                        }
                    }
                    mFilteredList = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (List<Elements>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public interface OnItemClickListener {
        void onClick(Elements element);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemElementsLayoutBinding binding;

        public ViewHolder(ItemElementsLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.getRoot().setOnClickListener(view -> {
                listener.onClick(mFilteredList.get(getLayoutPosition()));
            });
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
