package me.lukasabbe.closerecipebook.util;

import net.minecraft.client.recipebook.ClientRecipeBook;
import net.minecraft.recipe.book.RecipeBookCategory;

public class RecipeBookUtil {
    public static void closeAllRecipeBooks(ClientRecipeBook recipeBook){
        recipeBook.setGuiOpen(RecipeBookCategory.CRAFTING, false);
        recipeBook.setGuiOpen(RecipeBookCategory.BLAST_FURNACE, false);
        recipeBook.setGuiOpen(RecipeBookCategory.FURNACE, false);
        recipeBook.setGuiOpen(RecipeBookCategory.SMOKER, false);
    }
}
