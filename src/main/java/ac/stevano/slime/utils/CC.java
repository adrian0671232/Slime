package ac.stevano.slime.utils;

import org.apache.commons.lang.StringEscapeUtils;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class CC {

    public final String BLUE = ChatColor.BLUE.toString();
    public final String AQUA = ChatColor.DARK_PURPLE.toString();
    public final String YELLOW = ChatColor.YELLOW.toString();
    public final String RED = ChatColor.RED.toString();
    public final String GRAY = ChatColor.WHITE.toString();
    public final String GOLD = ChatColor.GOLD.toString();
    public final String GREEN = ChatColor.GREEN.toString();
    public final String WHITE = ChatColor.WHITE.toString();
    public final String BLACK = ChatColor.BLACK.toString();
    public final String BOLD = ChatColor.BOLD.toString();
    public final String ITALIC = ChatColor.ITALIC.toString();
    public final String UNDER_LINE = ChatColor.UNDERLINE.toString();
    public final String STRIKE_THROUGH = ChatColor.STRIKETHROUGH.toString();
    public final String RESET = ChatColor.RESET.toString();
    public final String MAGIC = ChatColor.MAGIC.toString();
    public final String DARK_BLUE = ChatColor.DARK_BLUE.toString();
    public final String DARK_AQUA = ChatColor.DARK_AQUA.toString();
    public final String DARK_GRAY = ChatColor.DARK_GRAY.toString();
    public final String DARK_GREEN = ChatColor.DARK_GREEN.toString();
    public final String DARK_PURPLE = ChatColor.DARK_PURPLE.toString();
    public final String DARK_RED = ChatColor.DARK_RED.toString();
    public final String PINK = ChatColor.LIGHT_PURPLE.toString();
    public final String MENU_BAR = ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH + "------------------------";
    public final String CHAT_BAR = ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH + "------------------------------------------------";
    public final String SB_BAR = ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH + "----------------------";
    public char CIRCLE = '●';
    public char DOUBLE_ARROW_RIGHT = '»';
    public char DOUBLE_ARROW_LEFT = '«';
    public String STAR = StringEscapeUtils.unescapeJava("☆");
    public String CHECKMARK = StringEscapeUtils.unescapeJava("✓");
    public String X = StringEscapeUtils.unescapeJava("✗");
    public String LUNAR = StringEscapeUtils.unescapeJava("✪");
    public String LINE = StringEscapeUtils.unescapeJava("┃");

    public String translate(String in) {
        return ChatColor.translateAlternateColorCodes('&', in);
    }

    public List<String> translate(List<String> lines) {
        List<String> toReturn = new ArrayList<>();

        for (String line : lines) {
            toReturn.add(ChatColor.translateAlternateColorCodes('&', line));
        }

        return toReturn;
    }

    public List<String> translate(String[] lines) {
        List<String> toReturn = new ArrayList<>();

        for (String line : lines) {
            if (line != null) {
                toReturn.add(ChatColor.translateAlternateColorCodes('&', line));
            }
        }

        return toReturn;
    }

}