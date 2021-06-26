package Freeze.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UnFreeze implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 0) {
            commandSender.sendMessage("/§4unfreeze [Player]");
        } else {
            Player player = Bukkit.getPlayerExact(strings[0]);
            if (player != null) {
                if (commandSender.hasPermission("freeze.unfreeze")) {
                    if (Freeze.freezeList.contains(player.getName())) {
                        Freeze.freezeList.remove(player.getName());
                        commandSender.sendMessage("You have successfully freed §a§n" + player.getName() + "§r§b!");
                        player.sendMessage("§a§n" + commandSender.getName() + "§r§a has successfully freed you!");
                    } else {
                        commandSender.sendMessage("§4The player must be frozen first!");
                    }
                } else {
                    commandSender.sendMessage("§4You have no permission to do this.");
                }
            } else {
                commandSender.sendMessage("§a§n" + strings[0] + "§r is not available.");
            }
        }
        return false;
    }
}
