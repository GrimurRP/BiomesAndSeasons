package com.aleksey.bs;

import com.aleksey.bs.Engine.SeasonHelper;
import com.aleksey.bs.config.ConfigManager;
import com.aleksey.bs.listener.SeasonListener;
import org.bukkit.plugin.java.JavaPlugin;

public class BiomesAndSeasons extends JavaPlugin {
    private ConfigManager _config;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        _config = new ConfigManager(getLogger());
        _config.load(getConfig());

        SeasonHelper seasonHelper = new SeasonHelper(getLogger(), _config);

        getServer().getPluginManager().registerEvents(new SeasonListener(seasonHelper), this);
    }

    @Override
    public void onDisable() {
    }
}
