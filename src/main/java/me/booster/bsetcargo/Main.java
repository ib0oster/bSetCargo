package me.booster.bsetcargo;

import me.booster.bsetcargo.commands.BSCCommand;
import me.booster.bsetcargo.commands.SetRoleCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static Main instance;


    public void onEnable() {

        setup();

        c("");
        c("bSetCargo inicializado com sucesso.");
        c("Versão: 1.0 / Criador: iBoosterr_");
        c("");
    }

    private void setup() {

        saveDefaultConfig();
        instance = this;

        this.getCommand("setcargo").setExecutor(new SetRoleCommand());
        this.getCommand("bsc").setExecutor(new BSCCommand());

    }

    private void c(String mensagemfoda) {

        this.getLogger().info(mensagemfoda);

    }

    public static Main getInstance() {
        return instance;
    }

}
