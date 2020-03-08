/*
   ___   _           _      _  _
  / _ \ | |__   ___ (_)  __| |( )  __ _  _ __
 | | | ||  _ \ / __|| | / _  || | / _  ||  _ \
 | |_| || |_) |\__ \| || (_| || || (_| || | | |
  \___/ |_ __/ |___/|_| \__ _||_| \__ _||_| |_|

Obsidian - 黑曜石                              */
package name.Obsidian;

import cn.nukkit.Server;
import cn.nukkit.event.Listener;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;
import name.Obsidian.Listener.OB_Listener;

public class Obsidian extends PluginBase implements Listener {

    private Config config;
    private static Obsidian OB_config;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        this.config = getConfig();
        OB_config = this;
        this.getServer().getPluginManager().registerEvents(new OB_Listener(), this);
        Server.getInstance().getLogger().info(TextFormat.GREEN+"[Obsidian] 加载完成！");
    }

    @Override
    public void onDisable() {
        Server.getInstance().getLogger().info(TextFormat.RED+"[Obsidian] 已卸载！");
    }

    public static Obsidian getOB_config() {
        return OB_config;
    }

    public boolean getOR() {
        return this.config.getBoolean("空桶点击黑曜石还原岩浆",true);
    }

    public boolean getSK() {
        return this.config.getBoolean("仅潜行时有效",true);
    }

    public boolean getERS() {
        return this.config.getBoolean("允许错误的刷石机",false);
    }

    public boolean getWFW() {
        return this.config.getBoolean("禁止高空流水",true);
    }

    public int getWFWY() {
        return this.config.getInt("高空流水判断格数",3);
    }

    public boolean getSMBD() {
        return this.config.getBoolean("树苗掉落保底",false);
    }

    public boolean getKWS() {
        return this.config.getBoolean("刷石机概率生成矿物",false);
    }

}
