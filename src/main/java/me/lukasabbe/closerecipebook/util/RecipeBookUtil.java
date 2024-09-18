package me.lukasabbe.closerecipebook.util;

import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.recipebook.ClientRecipeBook;
import net.minecraft.network.packet.c2s.play.RecipeCategoryOptionsC2SPacket;
import net.minecraft.recipe.book.RecipeBookCategory;

public class RecipeBookUtil {
    public static void closeRecipeBook(ClientRecipeBook recipeBook, ClientPlayNetworkHandler networkHandler, RecipeBookCategory category){
        recipeBook.setGuiOpen(category, false);
        networkHandler.sendPacket(new RecipeCategoryOptionsC2SPacket(category,false,false));
    }
}
