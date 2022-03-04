package me.booster.bsetcargo;

import me.booster.bsetcargo.commands.BSCCommand;
import me.booster.bsetcargo.commands.SetRoleCommand;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("all")
public class Main extends JavaPlugin {

    private static Chat chat = null;
    public static Main instance;


    public void onEnable() {

        setup();
        this.getLogger().info("Plugin inicializado com sucesso.");

    }

    private void setup() {

        setupChat();
        saveDefaultConfig();
        instance = this;

        this.getCommand("setcargo").setExecutor(new SetRoleCommand());
        this.getCommand("bsc").setExecutor(new BSCCommand());

    }

    public static Main getInstance() {
        return instance;
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    public static Chat getChat() {
        return chat;
    }

}
