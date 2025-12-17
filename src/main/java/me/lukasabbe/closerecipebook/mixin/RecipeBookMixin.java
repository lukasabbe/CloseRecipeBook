package me.lukasabbe.closerecipebook.mixin;

import me.lukasabbe.closerecipebook.util.RecipeBookUtil;
import net.minecraft.client.ClientRecipeBook;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractRecipeBookScreen;
import net.minecraft.client.gui.screens.recipebook.RecipeBookComponent;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.inventory.RecipeBookType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LocalPlayer.class)
public class RecipeBookMixin {
    @Shadow @Final private ClientRecipeBook recipeBook;

    @Shadow @Final public ClientPacketListener connection;

    @Shadow @Final protected Minecraft minecraft;

    @Inject(method = "clientSideCloseContainer", at= @At("HEAD"))
    public void onClosedInject(CallbackInfo ci){
        if(minecraft != null && minecraft.screen != null){
            if(minecraft.screen instanceof AbstractRecipeBookScreen<?> recipeBookProvider){
                final RecipeBookComponent<?> recipeBookWidget = ((RecipeBookScreenAccessor) recipeBookProvider).getRecipeBook();
                final RecipeBookType category = ((RecipeBookAccessor) recipeBookWidget).getCraftingHandler().getRecipeBookType();
                RecipeBookUtil.closeRecipeBook(recipeBook, connection, category);
            }
        }
    }

}
