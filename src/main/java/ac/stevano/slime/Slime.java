package ac.stevano.slime;

import ac.stevano.slime.utils.items.InventoryUtil;
import ac.stevano.slime.utils.items.ItemBuilder;
import ac.stevano.slime.utils.*;

public class Slime {
    private ItemBuilder itemBuilder;
    private InventoryUtil inventoryUtil;
    private PlayerUtil playerUtil;
    private CC cc;
    private DateUtil dateUtil;
    private MessageBuilder messageBuilder;
    private LocationUtil locationUtil;
    private TimeUtil timeUtil;
    private ServerSlotsUtil serverSlotsUtil;
    private WorldUtil worldUtil;
    private FileUtil fileUtil;

    public Slime() {
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

    public ItemBuilder getItemBuilder() {
        return itemBuilder;
    }

    public InventoryUtil getInventoryUtil() {
        return inventoryUtil;
    }

    public PlayerUtil getPlayerUtil() {
        return playerUtil;
    }

    public CC getCC() {
        return cc;
    }

    public DateUtil getDateUtil() {
        return dateUtil;
    }

    public LocationUtil getLocationUtil() {
        return locationUtil;
    }

    public MessageBuilder getMessageBuilder() {
        return messageBuilder;
    }

    public TimeUtil getTimeUtil() {
        return timeUtil;
    }

    public FileUtil getFileUtil() {
        return fileUtil;
    }

    public ServerSlotsUtil getServerSlotsUtil() {
        return serverSlotsUtil;
    }

    public WorldUtil getWorldUtil() {
        return worldUtil;
    }
}
