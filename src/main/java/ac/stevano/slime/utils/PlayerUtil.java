package ac.stevano.slime.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PlayerUtil {
    private Method getHandleMethod;
    private Field pingField;

    public int getPing(Player player) {
        try {
            if (getHandleMethod == null) {
                getHandleMethod = player.getClass().getDeclaredMethod("getHandle");
                getHandleMethod.setAccessible(true);
            }
            Object entityPlayer = getHandleMethod.invoke(player);
            if (pingField == null) {
                pingField = entityPlayer.getClass().getDeclaredField("ping");
                pingField.setAccessible(true);
            }
            int ping = pingField.getInt(entityPlayer);

            return Math.max(ping, 0);
        } catch (Exception e) {
            return 1;
        }
    }

    public ItemStack getHead(Player player) {
        ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta skullMeta = (SkullMeta) itemStack.getItemMeta();
        skullMeta.setOwner(player.getName());
        itemStack.setItemMeta(skullMeta);
        return itemStack;
    }

    public void clearInventory(Player player) {
        player.getInventory().clear();
        player.getInventory().setArmorContents(null);
    }

    public void healPlayer(Player player) {
        player.setHealth(player.getMaxHealth());
    }

    public void feedPlayer(Player player) {
        player.setFoodLevel(20);
        player.setExhaustion(0);
    }

    public void clearLevels(Player player) {
        player.setLevel(0);
        player.setExp(0);
    }

    public void clearEffects(Player player) {
        for (PotionEffect effect : player.getActivePotionEffects()) {
            player.removePotionEffect(effect.getType());
        }
    }

    public void resetPlayer(Player player) {
        clearEffects(player);
        clearInventory(player);
        clearEffects(player);
        clearLevels(player);
        feedPlayer(player);
        healPlayer(player);
    }
}
