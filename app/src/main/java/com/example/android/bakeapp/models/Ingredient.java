package com.example.android.bakeapp.models;

import android.os.Parcel;
import android.os.Parcelable;


public class Ingredient implements Parcelable {


    private double quantity;
    private String measure;
    private String ingredient;

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    //TODO refinar esta funcion luego de tener la funcionalidad basica
    public String getFormattedIngredient() {
        String readeableIngredient;

        readeableIngredient = Double.toString(quantity);

        if (!measure.equals("UNIT"))
            readeableIngredient += " " + measure;

        readeableIngredient  += ingredient;

        return readeableIngredient;
    }

    //TODO CREAR LA FUNCION DE CONVERSION DE DECIMALES  A FRACCIONES
   /* private String getFractionFromNumber(){

    }*/


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.quantity);
        dest.writeString(this.measure);
        dest.writeString(this.ingredient);
    }

    public Ingredient() {
    }

    protected Ingredient(Parcel in) {
        this.quantity = in.readDouble();
        this.measure = in.readString();
        this.ingredient = in.readString();
    }

    public static final Parcelable.Creator<Ingredient> CREATOR = new Parcelable.Creator<Ingredient>() {
        @Override
        public Ingredient createFromParcel(Parcel source) {
            return new Ingredient(source);
        }

        @Override
        public Ingredient[] newArray(int size) {
            return new Ingredient[size];
        }
    };
}
