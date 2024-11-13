package ac.stevano.slime;

import ac.stevano.slime.utils.items.InventoryUtil;
import ac.stevano.slime.utils.items.ItemBuilder;
import ac.stevano.slime.utils.*;

public class Slime {
    private static ItemBuilder itemBuilder;
    private static InventoryUtil inventoryUtil;
    private static PlayerUtil playerUtil;
    private static CC cc;
    private static DateUtil dateUtil;
    private static MessageBuilder messageBuilder;
    private static LocationUtil locationUtil;
    private static TimeUtil timeUtil;
    private static ServerSlotsUtil serverSlotsUtil;
    private static WorldUtil worldUtil;
    private static FileUtil fileUtil;

    public void init() {
        itemBuilder = new ItemBuilder();
        inventoryUtil = new InventoryUtil();
        playerUtil = new PlayerUtil();
        cc = new CC();
        dateUtil = new DateUtil();
        messageBuilder = new MessageBuilder();
        locationUtil = new LocationUtil();
        timeUtil = new TimeUtil();
        serverSlotsUtil = new ServerSlotsUtil();
        worldUtil = new WorldUtil();
        fileUtil = new FileUtil();
    }

    public static ItemBuilder getItemBuilder() {
        return itemBuilder;
    }

    public static InventoryUtil getInventoryUtil() {
        return inventoryUtil;
    }

    public static PlayerUtil getPlayerUtil() {
        return playerUtil;
    }

    public static CC getCC() {
        return cc;
    }

    public static DateUtil getDateUtil() {
        return dateUtil;
    }

    public static LocationUtil getLocationUtil() {
        return locationUtil;
    }

    public static MessageBuilder getMessageBuilder() {
        return messageBuilder;
    }

    public static TimeUtil getTimeUtil() {
        return timeUtil;
    }

    public static FileUtil getFileUtil() {
        return fileUtil;
    }

    public static ServerSlotsUtil getServerSlotsUtil() {
        return serverSlotsUtil;
    }

    public static WorldUtil getWorldUtil() {
        return worldUtil;
    }
}
