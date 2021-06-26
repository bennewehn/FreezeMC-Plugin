package Freeze.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Freeze implements CommandExecutor {
    public static ArrayList<String> freezeList = new ArrayList();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 0) {
            commandSender.sendMessage("/§4freeze [Player]");
        } else {
            Player player = Bukkit.getPlayerExact(strings[0]);
            if (player != null) {
                if (commandSender.hasPermission("freeze.freeze")) {
                    if (freezeList.contains(player.getName())) {
                        commandSender.sendMessage("Player §a§n" + player.getName() + "§r§4was already frozen!");
                    } else {
                        freezeList.add(player.getName());
                        player.sendMessage("§bYou have been frozen by §a§n" + commandSender.getName());
                    }
                } else {
                    commandSender.sendMessage("§4You have no permission to do this.");
                }
            } else {
                commandSender.sendMessage("§a§n" + strings[0] + "§r§4 is not available.");
            }
        }

        return false;
    }
}
