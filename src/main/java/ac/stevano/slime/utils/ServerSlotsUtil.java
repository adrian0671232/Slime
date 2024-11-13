package ac.stevano.slime.utils;

import org.bukkit.Bukkit;
import org.bukkit.Server;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ServerSlotsUtil {

    private final String CRAFT_BUKKIT_PACKAGE;
    private final String NET_MINECRAFT_SERVER_PACKAGE;

    private final Class CRAFT_SERVER_CLASS;
    private final Method CRAFT_SERVER_GET_HANDLE_METHOD;

    private final Class PLAYER_LIST_CLASS;
    private final Field PLAYER_LIST_MAX_PLAYERS_FIELD;
    {
        try {
            String version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];

            CRAFT_BUKKIT_PACKAGE = "org.bukkit.craftbukkit." + version + ".";
            NET_MINECRAFT_SERVER_PACKAGE = "net.minecraft.server." + version + ".";

            CRAFT_SERVER_CLASS = Class.forName(CRAFT_BUKKIT_PACKAGE + "CraftServer");
            CRAFT_SERVER_GET_HANDLE_METHOD = CRAFT_SERVER_CLASS.getDeclaredMethod("getHandle");
            CRAFT_SERVER_GET_HANDLE_METHOD.setAccessible(true);

            PLAYER_LIST_CLASS = Class.forName(NET_MINECRAFT_SERVER_PACKAGE + "PlayerList");
            PLAYER_LIST_MAX_PLAYERS_FIELD = PLAYER_LIST_CLASS.getDeclaredField("maxPlayers");
            PLAYER_LIST_MAX_PLAYERS_FIELD.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();

            throw new RuntimeException("Failed to initialize Bukkit/NMS Reflection");
        }
    }

    public void setMaxPlayers(Server server, int slots) {
        try {
            PLAYER_LIST_MAX_PLAYERS_FIELD.set(CRAFT_SERVER_GET_HANDLE_METHOD.invoke(server), slots);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}