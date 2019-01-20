package com.example.android.bakeapp.adapters;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.bakeapp.R;
import com.example.android.bakeapp.models.Recipe;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * This is the list where the data for the recipes is stored
 */
public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.RecipeViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Recipe recipe);
    }

    private List<Recipe> mRecipes;
    private OnItemClickListener clickListener;

    public RecipesAdapter(List<Recipe> recipes, OnItemClickListener clickListener) {
        this.mRecipes = recipes;
        this.clickListener = clickListener;
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_recipe_layout, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {
        Recipe currentRecipe = mRecipes.get(position);
        holder.bind(currentRecipe, clickListener);
    }

    @Override
    public int getItemCount() {
        if (mRecipes == null)
            return 0;

        return mRecipes.size();
    }

    //------------------------- VIEW HOLDER -----------------------------------------
    class RecipeViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.texview_recipe_name)
        TextView mTVRecipeName;

        public RecipeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final Recipe item, final OnItemClickListener listener) {

            mTVRecipeName.setText(item.getName());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(item);
                }
            });
        }
    }
    //------------------------- END VIEW HOLDER ---------------------------------------

    public void updateRecipeList(List<Recipe> newRecipeList) {
        mRecipes.clear();
        mRecipes.addAll(newRecipeList);
        notifyDataSetChanged();
    }

}
