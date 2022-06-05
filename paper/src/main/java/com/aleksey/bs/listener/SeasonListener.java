package com.aleksey.bs.listener;

import com.aleksey.bs.Engine.SeasonHelper;
import me.casperge.realisticseasons.api.SeasonChangeEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class SeasonListener implements Listener {
    private final SeasonHelper _seasonHelper;
    private boolean _currentSeasonApplied;

    public SeasonListener(SeasonHelper seasonHelper) {
        _seasonHelper = seasonHelper;
        _currentSeasonApplied = false;
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPlayerLeave(PlayerLoginEvent event) {
        if (!_currentSeasonApplied)
            _currentSeasonApplied = _seasonHelper.applyCurrentSeason(event.getPlayer().getWorld());
    }

    @EventHandler
    public void onSeasonChange(SeasonChangeEvent e) {
        _seasonHelper.switchRelaisticBiomesConfig(e.getNewSeason(), e.getWorld());
    }
}
