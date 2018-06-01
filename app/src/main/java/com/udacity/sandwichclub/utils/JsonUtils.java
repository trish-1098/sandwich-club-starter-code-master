package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        ArrayList<String> sandwichArrayList = new ArrayList<>();
        ArrayList<String> sandwichIngredientsArrayList = new ArrayList<>();
        if(json.isEmpty()){
            return null;
        }
        try{
            Sandwich sandwichObject = new Sandwich();
            JSONObject sandwichJSONObject = new JSONObject(json);
            JSONObject nameObject = sandwichJSONObject.getJSONObject("name");
            String mainName = nameObject.getString("mainName");
            sandwichObject.setMainName(mainName);
            JSONArray alsoKnownAsArray = nameObject.getJSONArray("alsoKnownAs");
            for (int i = 0; i < alsoKnownAsArray.length(); i++) {
                sandwichArrayList.add(alsoKnownAsArray.getString(i));
            }
            sandwichObject.setAlsoKnownAs(sandwichArrayList);
            String placeOfOrigin = sandwichJSONObject.getString("placeOfOrigin");
            sandwichObject.setPlaceOfOrigin(placeOfOrigin);
            String descriptionOfSandwich = sandwichJSONObject.getString("description");
            sandwichObject.setDescription(descriptionOfSandwich);
            String imageOfSandwich = sandwichJSONObject.getString("image");
            sandwichObject.setImage(imageOfSandwich);
            JSONArray ingredientsArray = sandwichJSONObject.getJSONArray("ingredients");
            for (int j = 0; j < ingredientsArray.length(); j++) {
                sandwichIngredientsArrayList.add(ingredientsArray.getString(j));
            }
            sandwichObject.setIngredients(sandwichIngredientsArrayList);
            return sandwichObject;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
