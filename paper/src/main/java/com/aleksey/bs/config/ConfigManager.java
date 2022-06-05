package com.aleksey.bs.config;

import me.casperge.realisticseasons.season.Season;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.logging.Logger;

public class ConfigManager {
    private Logger _logger;

    private HashMap<Season, String> _realisticBiomesConfigs;

    public String getRealisticBiomesConfig(Season season) {
        return _realisticBiomesConfigs.get(season);
    }

    public ConfigManager(Logger logger) {
        _logger = logger;
    }

    public void load(FileConfiguration file) {
        readSeasons(file.getConfigurationSection("Seasons"));
    }

    private void readSeasons(ConfigurationSection config) {
        _realisticBiomesConfigs = new HashMap<>();

        if (config == null)
            return;

        for (String key : config.getKeys(false)) {
            if (!config.isConfigurationSection(key))
                continue;

            Season season;

            switch (key.toUpperCase()) {
                case "WINTER" -> season = Season.WINTER;
                case "SPRING" -> season = Season.SPRING;
                case "SUMMER" -> season = Season.SUMMER;
                case "FALL" -> season = Season.FALL;
                default -> {
                    _logger.warning("Unsupported season: " + key);
                    continue;
                }
            }

            ConfigurationSection seasonSection = config.getConfigurationSection(key);
            String configFile = seasonSection.getString("configFile");

            _realisticBiomesConfigs.put(season, configFile);
        }
    }
}
