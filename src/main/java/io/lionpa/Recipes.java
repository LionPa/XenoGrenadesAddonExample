package io.lionpa;

import io.lionpa.utils.Ingredient;
import io.lionpa.utils.RecipeManager;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class Recipes {
    public static void init(){
        RecipeManager.addShapedRecipe(
                new ShapedRecipe(
                        new NamespacedKey("example_of_addon","gravity_grenade_recipe"),
                        Items.gravityGrenade), //result
                new String[]{ // Shape
                        " s ",
                        " g ",
                        " s "},
                new Ingredient('s', Material.SHULKER_SHELL), //Ingredients
                new Ingredient('g', Material.GUNPOWDER)
        );
    }
}
