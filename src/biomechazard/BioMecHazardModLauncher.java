package biomechazard;

import arc.*;
import arc.util.*;
//import arc.util.Time;

import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.mod.Mod;
import mindustry.mod.Mods;
import mindustry.ui.dialogs.*;

import biomechazard.content.*;

public class BioMecHazardModLauncher extends Mod{
	
	//public static Mods.LoadedMod MOD;

    public BioMecHazardModLauncher(){
        Log.info("Loaded BioMecHazardModLauncher constructor.");

        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("welcome");
                dialog.cont.add("A scourge is coming.").row();
                //mod sprites are prefixed with the mod name (this mod is called 'biomechazard' in its config)
                dialog.cont.image(Core.atlas.find("biomechazard-splashscreen")).pad(20f).row();
                dialog.cont.button("I'm ready", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
		
		Log.info("So far, so good...");
    }

    @Override
    public void loadContent(){
		Time.mark();
		
		//MOD = Mods.getMod(getClass());
		
        //Log.info("Mod BioMecHazard : chargement des stats.");
		//BMHStats.load();
        //Log.info("Mod BioMecHazard : chargement des réglages.");
		//BMHSettings.load();
		//Log.info("Mod BioMecHazard : chargement des effets visuels.");
		//BMHVisualEffects.load();
        Log.info("Mod BioMecHazard : chargement des unités.");
		BMHUnits.load();
        Log.info("Mod BioMecHazard : chargement des blocs.");
		BMHBlocks.load();
		
		//BMHStatusEffects.load();
        //BMHItems.load();
        //BMHLiquids.load();
        //BMHWeathers.load();
        //BMHPlanets.load();
        //BMHSectors.load();
        //Log.info("Mod BioMecHazard : chargement de l'arbre des technologies.");
		//BMHTechTree.load();
		
		Log.info("Chargement de BioMecHazard v0.0.1" /*+ MOD.meta.version*/ + " effectué | Durée écoulée : " + (Time.elapsed() / Time.toSeconds) + " sec.");
    }

}

