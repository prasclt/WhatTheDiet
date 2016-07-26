package com.microsoft.hack.whatthediet.models;

import com.microsoft.hack.whatthediet.utils.NutritionHelper;

/**
 * Created by prmeno on 7/26/2016.
 */
public class Nutrition {

    private int nutritionHashvalue;
    private float energy;
    private float protien;
    private float carboHydrate;
    private float fibre;
    private float fat;

    public Nutrition(float energy,
                     float protien,
                     float carboHydrate,
                     float fibre,
                     float fat) {
        this.energy = energy;
        this.protien = protien;
        this.carboHydrate = carboHydrate;
        this.fibre = fibre;
        this.fat = fat;

        computeNutritionhash();
    }

    private void computeNutritionhash() {
        nutritionHashvalue = 0;
        nutritionHashvalue += NutritionHelper.ENERGY_HEALTH_RANGE.contains(energy) ? 1 : 0;
        nutritionHashvalue += NutritionHelper.PROTIEN_HEALTH_RANGE.contains(protien) ? 1 : 0;
        nutritionHashvalue += NutritionHelper.CARBOHYDRATE_HEALTH_RANGE.contains(carboHydrate) ? 1 : 0;
        nutritionHashvalue += NutritionHelper.FIBRE_HEALTH_RANGE.contains(fibre) ? 1 : 0;
        nutritionHashvalue += NutritionHelper.FAT_HEALTH_RANGE.contains(fat) ? 1 : 0;
    }

    public int getNutritionHashvalue() {
        return nutritionHashvalue;
    }
}
