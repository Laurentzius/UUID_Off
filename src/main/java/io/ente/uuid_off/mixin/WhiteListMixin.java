package io.ente.uuid_off.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.server.Whitelist;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Whitelist.class)
public abstract class WhiteListMixin{

    @Shadow public abstract String[] getNames();

    /**
     * @author Ente
     * @reason .
     */
    @Overwrite
    public boolean isAllowed(GameProfile profile) {
        String name = profile.getName();
        String[] players = getNames();

        for (String player: players) {
            if (player.equals(name)) {
                return true;
            }
        }

        return false;
    }
}
