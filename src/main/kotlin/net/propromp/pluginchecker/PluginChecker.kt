package net.propromp.pluginchecker

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class PluginChecker: JavaPlugin() {
    val plugins = mutableMapOf<String,String>()
    override fun onEnable() {
        logger.info("Hello")

        saveDefaultConfig()
        config.getConfigurationSection("plugins")?.getKeys(true)?.forEach {
            plugins[it] = config.getString("plugins.$it")!!
        }

        Bukkit.getPluginManager().registerEvents(EventListener(this),this)
    }
}