package com.aleksey.bs.Engine;

import com.aleksey.bs.config.ConfigManager;
import com.untamedears.realisticbiomes.RealisticBiomes;
import me.casperge.realisticseasons.api.SeasonsAPI;
import me.casperge.realisticseasons.season.Season;
import org.bukkit.World;

import java.util.logging.Logger;

public class SeasonHelper {
    private Logger _logger;
    private ConfigManager _configManager;
    private Season _currentSeason;

    public SeasonHelper(Logger logger, ConfigManager configManager) {
        _logger = logger;
        _configManager = configManager;
        _currentSeason = Season.DISABLED;
    }

    public boolean applyCurrentSeason(World world) {
        Season season;

        try {
            season = SeasonsAPI.getInstance().getSeason(world);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

        switchRelaisticBiomesConfig(season, world);

        return true;
    }

    public void switchRelaisticBiomesConfig(Season season, World world) {
        if (_currentSeason == season) {
            _logger.info(String.format("The season %s is already active, ignore change event", season.name()));
            return;
        }

        String configFile = _configManager.getRealisticBiomesConfig(season);
        if (configFile == null) {
            _logger.severe(String.format("Season '%s' is not registered. RB config cannot be switched.", season.name()));
            return;
        }

        _logger.info(String.format("Switching RB config for season '%s' of the world '%s' to '%s'", season.name(), world.getName(), configFile));

        RealisticBiomes.getInstance().reload(configFile);

        _currentSeason = season;
    }
}
