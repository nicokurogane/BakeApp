package com.example.android.bakeapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;


public class Recipe implements Parcelable {

    private int id;
    private String name;
    private int servings;    //how many people o cups will satisfy

    private List<Ingredient> ingredients;  //list of ingredients for the recipe
    private List<Step> steps; //list of steps necesary for this recipe

    private String image;

    public Recipe() {
    }

    public Recipe(int id, String name, int servings, List<Ingredient> ingredients, List<Step> steps) {
        this.id = id;
        this.name = name;
        this.servings = servings;
        this.ingredients = ingredients;
        this.steps = steps;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeInt(this.servings);
        dest.writeTypedList(this.ingredients);
        dest.writeTypedList(this.steps);
        dest.writeString(this.image);
    }

    protected Recipe(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.servings = in.readInt();
        this.ingredients = in.createTypedArrayList(Ingredient.CREATOR);
        this.steps = in.createTypedArrayList(Step.CREATOR);
        this.image = in.readString();
    }

    public static final Parcelable.Creator<Recipe> CREATOR = new Parcelable.Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel source) {
            return new Recipe(source);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };
}
