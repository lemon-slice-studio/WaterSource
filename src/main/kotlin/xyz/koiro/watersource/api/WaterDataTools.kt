package xyz.koiro.watersource.api

import net.minecraft.entity.player.PlayerEntity
import xyz.koiro.watersource.world.attachment.ModAttachmentTypes
import xyz.koiro.watersource.world.attachment.WaterLevelData

fun PlayerEntity.canExhaustWater(): Boolean {
    return !(this.isCreative || this.isSpectator)
}

fun PlayerEntity.ifInSurvivalAndGetWaterData(action: (data: WaterLevelData) -> Unit) {
    if (this.canExhaustWater()) {
        val data = this.getAttachedOrCreate(ModAttachmentTypes.WATER_LEVEL)
        action(data)
    }
}