package ac.stevano.slime.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class WorldUtil {
    public void copyWorld(String oldDirectory, String newDirectory, String name) {
        try {
            File dest = new File("./" + newDirectory + "/" + name);
            File source = new File("./" + oldDirectory + "/");

            if (!dest.exists()) {
                dest.mkdirs();
            }

            Files.walkFileTree(source.toPath(), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Path targetFile = dest.toPath().resolve(source.toPath().relativize(file));
                    Files.copy(file, targetFile, StandardCopyOption.REPLACE_EXISTING);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    Path targetDir = dest.toPath().resolve(source.toPath().relativize(dir));
                    if (!Files.exists(targetDir)) {
                        Files.createDirectory(targetDir);
                    }
                    return FileVisitResult.CONTINUE;
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteWorld(String directory, String world) {
        Bukkit.unloadWorld(world, false);
        File dir = new File("./" + directory + "/" + world);
        try {
            if (dir.exists() && dir.isDirectory()) {
                Files.walkFileTree(dir.toPath(), new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        Files.delete(file);
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                        Files.delete(dir);
                        return FileVisitResult.CONTINUE;
                    }
                });
            }
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
