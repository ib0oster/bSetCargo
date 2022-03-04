package me.booster.bsetcargo.commands;

import me.booster.bsetcargo.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BSCCommand implements CommandExecutor {

    @SuppressWarnings("all")
    public boolean onCommand(CommandSender sender, Command c, String lbl, String[] args) {

        if (!sender.hasPermission("bsc.bsc")) {
            sender.sendMessage(Main.getInstance().getConfig().getString("Messages.noperm"));
            return true;
        }

        if (args.length < 1) {
            String bsc = String.join(" " + Main.getInstance().getConfig().getStringList("Messages.bsc")).replace("&", "§");
            sender.sendMessage(bsc);
            return true;
        }

        if (args[0].equalsIgnoreCase("reload")) {
            Main.getInstance().reloadConfig();
            sender.sendMessage(Main.getInstance().getConfig().getString("Messages.reload").replace("&", "§"));
            return true;
        }

        String bsc = String.join(" " + Main.getInstance().getConfig().getStringList("Messages.bsc")).replace("&", "§");
            sender.sendMessage(bsc);


        return true;
    }
}
