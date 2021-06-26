package Freeze.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import Freeze.commands.Freeze;

public class FreezeListener implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if (Freeze.freezeList.contains(p.getName())) {
            e.setCancelled(true);
            p.sendMessage("§3You are frozen!");
        }
    }
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (Freeze.freezeList.contains(p.getName())) {
            e.setCancelled(true);
        }
    }


}
