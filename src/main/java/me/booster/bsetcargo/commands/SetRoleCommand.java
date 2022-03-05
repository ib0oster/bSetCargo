package me.booster.bsetcargo.commands;

import me.booster.bsetcargo.Main;
import me.booster.bsetcargo.api.JsonAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class SetRoleCommand implements CommandExecutor {

    @SuppressWarnings("all")
    public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cO console não pode executar esse comando.");
            return true;
        }
        Player p = (Player) sender;
        if (args.length < 1) {

            p.sendMessage(Main.getInstance().getConfig().getString("messages.noArgs").replace("&", "§"));
            return true;
        }
        if (!p.hasPermission("bsc.setcargo")) {
            p.sendMessage(Main.getInstance().getConfig().getString("messages.noPermission").replace("&", "§"));
            return true;
        }
        if (!(Bukkit.getServer().getPlayer(args[0]) == null)) {
            Player p2 = Bukkit.getServer().getPlayer(args[0]);
            p.sendMessage("");
            p.sendMessage(Main.getInstance().getConfig().getString("messages.setRole").replace("%player%", args[0]).replace("%p-prefix%", Main.getChat().getPlayerPrefix(p2)).replace("&", "§"));
            for (String path : Main.getInstance().getConfig().getConfigurationSection("roles").getKeys(false)) {
                String names = Main.getInstance().getConfig().getString("settings.starter").replace("&", "§") + Main.getInstance().getConfig().getString("roles." + path + ".name").replace("&", "§");
                String commands = Main.getInstance().getConfig().getString("roles." + path + ".command").replace("%player%", args[0]);
                String lores = String.join(" ", Main.getInstance().getConfig().getStringList("roles." + path + ".lore")).replace("%player%", args[0]).replace("%p-prefix%",  Main.getChat().getPlayerPrefix(p2)).replace("&", "§");
                String permissions = Main.getInstance().getConfig().getString("roles." + path + ".permission");
                List<String> bsc = new ArrayList<String>();
                bsc.add("1");


                bsc.stream().filter(key -> sender.hasPermission(permissions)).forEach(key -> {
                    JsonAPI.sendCommandText(p, names, lores, commands);
                });

            }
            p.sendMessage("");
            return true;
        } else if (Bukkit.getServer().getPlayer(args[0]) == null) {
            p.sendMessage(Main.getInstance().getConfig().getString("messages.needOnline").replace("&", "§"));
        }

        return true;
    }
}
