package com.microsoft.hack.whatthediet.utils;

import android.util.Range;

import com.microsoft.hack.whatthediet.models.FoodItem;

/**
 * Created by prmeno on 7/26/2016.
 */
public class NutritionHelper {

    public static final int UNHEALTHY = 0;
    public static final int NORMAL = 1;
    public static final int HEALTHY = 2;

    public static final Range<Float> ENERGY_HEALTH_RANGE = new Range<>(500F, 1000F);
    public static final Range<Float> PROTIEN_HEALTH_RANGE = new Range<>(14F, 20F);
    public static final Range<Float> CARBOHYDRATE_HEALTH_RANGE = new Range<>(70F, 130F);
    public static final Range<Float> FIBRE_HEALTH_RANGE = new Range<>(7F, 13F);
    public static final Range<Float> FAT_HEALTH_RANGE = new Range<>(20F, 26F);

    private static final Range<Integer> HEALTHY_HASH_VALUE_RANGE = new Range<>(5, 5);
    private static final Range<Integer> NORMAL_HASH_VALUE_RANGE = new Range<>(3, 4);
    private static final Range<Integer> UNHEALTHY_HASH_VALUE_RANGE = new Range<>(0, 2);

    public static int getHealthQuotient(FoodItem foodItem) {
        int nutritionHashValue = foodItem.getNutrition().getNutritionHashvalue();

        if (HEALTHY_HASH_VALUE_RANGE.contains(nutritionHashValue))
            return HEALTHY;

        if (NORMAL_HASH_VALUE_RANGE.contains(nutritionHashValue))
            return NORMAL;

        return UNHEALTHY;
    }

}
