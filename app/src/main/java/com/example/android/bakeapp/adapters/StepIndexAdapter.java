package com.example.android.bakeapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.bakeapp.R;
import com.example.android.bakeapp.models.Step;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *  This Adapter holds the data of the steps, described in a simple way, involved to create
 *  the dessert.
 */

public class StepIndexAdapter extends RecyclerView.Adapter<StepIndexAdapter.StepViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Step step);
    }

    private List<Step> mRecipeSteps;
    private OnItemClickListener clickListener;

    public StepIndexAdapter(List<Step> mRecipeSteps, OnItemClickListener clickListener) {
        this.mRecipeSteps = mRecipeSteps;
        this.clickListener = clickListener;
    }

    @Override
    public StepViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_step_layout, parent, false);
        return new StepViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StepViewHolder holder, int position) {
        Step currentStep = mRecipeSteps.get(position);
        holder.bind(currentStep, clickListener);
    }

    @Override
    public int getItemCount() {
        if (mRecipeSteps == null) return 0;
        return mRecipeSteps.size();
    }


    //------------------------- VIEW HOLDER -----------------------------------------
    class StepViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textiview_step_description_item)
        TextView mTVStepDescription;

        public StepViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final Step item, final OnItemClickListener listener) {

            mTVStepDescription.setText(item.getShortDescription());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(item);
                }
            });
        }
    }
    //------------------------- END VIEW HOLDER ---------------------------------------

    public void  updateStepList(List<Step> newStepList){
        mRecipeSteps = newStepList;
        notifyDataSetChanged();
    }


}
