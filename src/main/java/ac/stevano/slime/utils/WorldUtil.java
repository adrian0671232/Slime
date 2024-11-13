package ac.stevano.slime.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class WorldUtil {
    public void copyWorld(String oldDirectory, String newDirectory, String name) {
        try {
            File dest = new File("./" + newDirectory + "/" + name);
            File source = new File("./" + oldDirectory + "/");
            FileUtils.copyDirectory(source, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteWorld(String directory, String world) {
        Bukkit.unloadWorld(world, false);
        File dir = new File("./" + directory + world);
        try {
            FileUtils.deleteDirectory(dir);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void clearMobs(String world) {
        for (Entity e : Bukkit.getWorld(world).getEntities()){
            if (!(e instanceof Player)) {
                e.remove();
            }
        }
    }
}
