package at.tigerpanzer;

import at.tigerpanzer.command.RealWorldTimeCommand;
import at.tigerpanzer.events.RealWorldTime;
import at.tigerpanzer.util.SpigotPluginUpdater;
import at.tigerpanzer.util.Utils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
    private boolean needUpdateJoin;

    @Override
    public void onEnable() {
        needUpdateJoin = false;
        saveDefaultConfig();
        Bukkit.getConsoleSender().sendMessage(Utils.color(getConfig().getString("Console.PrefixConsole") + " &cWird &aGESTARTET &7| &cis &aSTARTED"));
        register();
        update();
        Bukkit.getConsoleSender().sendMessage(Utils.color(getConfig().getString("Console.PrefixConsole") + " &7=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="));
        Bukkit.getConsoleSender().sendMessage(Utils.color(getConfig().getString("Console.PrefixConsole") + " &cPlugin version: &e" + getDescription().getVersion()));
        Bukkit.getConsoleSender().sendMessage(Utils.color(getConfig().getString("Console.PrefixConsole") + " &cPlugin author: &e" + getDescription().getAuthors()));
        Bukkit.getConsoleSender().sendMessage(Utils.color(getConfig().getString("Console.PrefixConsole") + " &cPlugin status: &aaktiviert &c| &aenabled"));
        Bukkit.getConsoleSender().sendMessage(Utils.color(getConfig().getString("Console.PrefixConsole") + " &7=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="));
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(Utils.color(getConfig().getString("Console.PrefixConsole") + " &7=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="));
        Bukkit.getConsoleSender().sendMessage(Utils.color(getConfig().getString("Console.PrefixConsole") + " &cPlugin version: &e" + getDescription().getVersion()));
        Bukkit.getConsoleSender().sendMessage(Utils.color(getConfig().getString("Console.PrefixConsole") + " &cPlugin author: &e" + getDescription().getAuthors()));
        Bukkit.getConsoleSender().sendMessage(Utils.color(getConfig().getString("Console.PrefixConsole") + " &cPlugin status: &4deaktiviert &c| &4disabled"));
        Bukkit.getConsoleSender().sendMessage(Utils.color(getConfig().getString("Console.PrefixConsole") + " &7=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="));
    }

    private void update() {
        SpigotPluginUpdater update = new SpigotPluginUpdater(this, "http://tigerpanzer02.bplaced.net/plugins/realworldtime/");
        update.enableOut();
        update.needsUpdate();
    }

    private void register() {
        new RealWorldTimeCommand(this);
        new RealWorldTime(this);
    }

    public boolean needUpdateJoin() {
        return needUpdateJoin;
    }

    public void setNeedUpdateJoin(boolean needUpdateJoin) {
        this.needUpdateJoin = needUpdateJoin;
    }
}
