package com.rayzr522.chunkfixer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ChunkFixer extends JavaPlugin {

    @Override
    public void onEnable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 1) {
            return false;
        }

        World world = Bukkit.getWorld(args[0]);
        if (world == null) {
            sender.sendMessage(ChatColor.RED + "That world does not exist!");
            return false;
        }

        for (Chunk c : world.getLoadedChunks()) {
            if (!c.unload()) {
                sender.sendMessage(ChatColor.RED + "Failed to unload chunk at " + c.getX() + "," + c.getZ());
            }
        }

        sender.sendMessage(ChatColor.GREEN + "World has been repaired.");

        return true;
    }

}
