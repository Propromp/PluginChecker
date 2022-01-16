package net.propromp.pluginchecker

import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.server.PluginEnableEvent
import org.bukkit.event.server.ServerLoadEvent
import sun.tracing.PrintStreamProviderFactory
import sun.tracing.ProviderSkeleton
import java.io.FileDescriptor
import java.io.FileOutputStream
import java.io.PrintStream

class EventListener(val plugin: PluginChecker): Listener {
    @EventHandler
    fun onEnable(e: ServerLoadEvent) {
        Bukkit.getPluginManager().plugins.forEach {
            val str = plugin.plugins[it.name] ?: return@forEach
            PrintStream(FileOutputStream(FileDescriptor.out)).println(str.replace("%success%",it.isEnabled.toString()))
        }
        Bukkit.getServer().shutdown()
    }
}