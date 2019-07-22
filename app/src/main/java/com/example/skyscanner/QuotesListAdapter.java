package com.example.skyscanner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.skyscanner.databinding.QuotesListBinding;
import com.example.skyscanner.viewmodel.QuotesListViewModel;

import java.util.List;

public class QuotesListAdapter extends RecyclerView.Adapter<QuotesListAdapter.QuotesViewHolder> {


    List<QuotesListViewModel> quotesListViewModels;

    public QuotesListAdapter(List<QuotesListViewModel> quotesListViewModels) {
        this.quotesListViewModels = quotesListViewModels;
    }

    @NonNull
    @Override
    public QuotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        QuotesListBinding binding = DataBindingUtil.inflate(inflater,R.layout.quotes_list,parent,false);
        return new QuotesViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull QuotesViewHolder holder, int position) {
        holder.binding.setVm(quotesListViewModels.get(position));
    }

    @Override
    public int getItemCount() {
        return quotesListViewModels.size();
    }

    class QuotesViewHolder extends RecyclerView.ViewHolder {

        QuotesListBinding binding;

        QuotesViewHolder(QuotesListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }
}
