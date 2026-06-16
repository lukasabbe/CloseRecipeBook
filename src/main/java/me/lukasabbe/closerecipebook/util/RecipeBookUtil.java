package me.lukasabbe.closerecipebook.util;

import net.minecraft.client.ClientRecipeBook;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.protocol.game.ServerboundRecipeBookChangeSettingsPacket;
import net.minecraft.world.inventory.RecipeBookType;

public class RecipeBookUtil {
    public static void closeRecipeBook(ClientRecipeBook recipeBook, ClientPacketListener networkHandler, RecipeBookType category){
        recipeBook.setOpen(category, false);
        networkHandler.send(new ServerboundRecipeBookChangeSettingsPacket(category,false,false));
    }
}
