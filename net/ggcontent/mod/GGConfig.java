package net.ggcontent.mod;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class GGConfig extends Configuration {

    public boolean glitchShaders;    
    public int idEffectGlitch;
    public String gfPotionReq;
    public String gpPotionEff;

    public GGConfig(File file) {

        super(file);
        this.load();

        Property propShaders = this.get("Safety","Shaders",true);
        propShaders.comment = "Disable this if you are sensitive to flashing lights!!!";
        glitchShaders = propShaders.getBoolean(false);        

        Property propPotionId = this.get("Potions","glitchfestEffectId",100);
        idEffectGlitch = propPotionId.getInt();

        Property propPotionReq = this.get("Brewing","glitchfestPotionRequirement", " 0 & 1 & !2 & 3 & 4 & 10 & 3+6");
        gfPotionReq = propPotionReq.getString();

        Property propPotionEff = this.get("Brewing","glitchPowderPotionEffect","+0+1-2+3+10+13");
        gpPotionEff = propPotionEff.getString();

        this.save();


    }

}

