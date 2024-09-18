package me.lukasabbe.closerecipebook.mixin;

import me.lukasabbe.closerecipebook.util.RecipeBookUtil;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.recipebook.ClientRecipeBook;
import net.minecraft.recipe.book.RecipeBookCategory;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class RecipeBookMixin {
    @Shadow @Final private ClientRecipeBook recipeBook;

    @Inject(method = "closeScreen", at= @At("HEAD"))
    public void onClosedInject(CallbackInfo ci){
        RecipeBookUtil.closeAllRecipeBooks(recipeBook);
    }

}
