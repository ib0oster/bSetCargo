package me.booster.bsetcargo.commands;

import com.sun.istack.internal.Nullable;
import me.booster.bsetcargo.Main;
import me.booster.bsetcargo.api.JsonAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class SetRoleCommand implements CommandExecutor {

    @SuppressWarnings("all")
    public boolean onCommand(CommandSender sender, Command cmd, String lbl, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cO console não pode executar esse comando.");
            return true;
        }
        Player p = (Player) sender;
        if (args.length == 0) {
            p.sendMessage(Main.getInstance().getConfig().getString("Messages.noargs").replace("&", "§"));
            return true;
        }
        if (!p.hasPermission("bsc.setcargo")) {
            p.sendMessage(Main.getInstance().getConfig().getString("Messages.noperm").replace("&", "§"));
            return true;
        }
        if (Bukkit.getServer().getPlayer(args[0]) != null) {
            Player p2 = Bukkit.getServer().getPlayer(args[0]);
            p.sendMessage("");
            p.sendMessage(Main.getInstance().getConfig().getString("Messages.setcargo").replace("%player%", args[0]).replace("%p-prefix%", Main.getChat().getPlayerPrefix(p2)).replace("&", "§"));
            for (String roles : Main.getInstance().getConfig().getConfigurationSection("Roles").getKeys(false)) {
                String names = Main.getInstance().getConfig().getString("Settings.starter").replace("&", "§") + Main.getInstance().getConfig().getString("Roles." + roles + ".Name").replace("&", "§");
                String commands = Main.getInstance().getConfig().getString("Roles." + roles + ".Command").replace("%player%", args[0]);
                String lores = String.join(" ", Main.getInstance().getConfig().getStringList("Roles." + roles + ".Lore")).replace("&", "§").replace("%player%", args[0]);

                JsonAPI.sendCommandText(p, names, lores, commands);

            }
            p.sendMessage("");
            return true;
        } else if (Bukkit.getServer().getPlayer(args[0]) == null) {
            p.sendMessage(Main.getInstance().getConfig().getString("Messages.needonline").replace("&", "§"));
        }
        return true;
    }
}
