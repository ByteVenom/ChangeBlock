package com.katsaroucraft.gopaintman;

import org.bukkit.block.Block;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		this.saveDefaultConfig(); 
		getServer().getLogger();
		
		
	}

	@Override
	public void onDisable() {
		getServer().getLogger();
		
	}
	public boolean onCommand(CommandSender sender, Command cmd,String commandLabel, String[] args) {
		if((cmd.getName().equalsIgnoreCase("changeblock")) && (sender.hasPermission(new ChangeBlockPerms().makeBlock) || sender.isOp())){
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if(args.length > 0){
				
				
				Block block = player.getTargetBlock(null, this.getConfig().getInt("Range"));
				int ID;
			
				try{
					 ID = Integer.parseInt(args[0]);
					 
					 try{
						block.setTypeId(ID);
						sender.sendMessage(ChatColor.YELLOW + "Block successfully changed to "  + block.getType().name());
					 	}catch(Exception ex){
						 				sender.sendMessage(ChatColor.RED + "No ID found for block");
					 }
				}catch(Exception e){
					sender.sendMessage(ChatColor.RED + "No numbers found in your input.");
				}
				
				
			}else{
				return false;
			}
			}else{
				sender.sendMessage("This command can only be sent by a player");
				
			}
			
			
			
		}
		return true;
		
		
		
		
	}
	
}
