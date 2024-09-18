package me.lukasabbe.closerecipebook.mixin;

import me.lukasabbe.closerecipebook.util.RecipeBookUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.DownloadingTerrainScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class JoinWorldMixin {
    @Shadow @Nullable public ClientPlayerEntity player;

    @Inject(method = "joinWorld",at=@At("HEAD"))
    public void joinWorld(ClientWorld world, DownloadingTerrainScreen.WorldEntryReason worldEntryReason, CallbackInfo ci){
        if(player != null){
            RecipeBookUtil.closeAllRecipeBooks(player.getRecipeBook());
        }
    }
}
