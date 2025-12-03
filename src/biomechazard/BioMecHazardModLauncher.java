package biomechazard;

import arc.*;
import arc.util.*;

import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.mod.Mod;
import mindustry.mod.Mods;
import mindustry.ui.dialogs.*;

import biomechazard.content.*;
import biomechazard.content.blocks.*;
import biomechazard.content.bullets.*;

public class BioMecHazardModLauncher extends Mod{
	
	//public static Mods.LoadedMod MOD;

    public BioMecHazardModLauncher(){
        Log.info("Loaded BioMecHazardModLauncher constructor.");

        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
			/*
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("splashscreen");
                dialog.cont.add("A scourge is coming.").row();
                //mod sprites are prefixed with the mod name (this mod is called 'biomechazard' in its config)
                dialog.cont.image(Core.atlas.find("biomechazard-splashscreen")).pad(20f).row();
                dialog.cont.button("I'm ready", dialog::hide).size(100f, 50f);
                dialog.show();
            });
			*/
        });
		
		Log.info("So far, so good...");
    }

    @Override
    public void loadContent(){
		Time.mark();
		
		//MOD = Mods.getMod(getClass());
		
		//Log.info("Mod BioMecHazard : chargement des stats.");
		//BMHStats.load();
		
		//BMHAttribute.load();
		
		//BMHSounds.load();
        //Log.info("Mod BioMecHazard : chargement des réglages.");
		//BMHSettings.load();
		Log.info("Mod BioMecHazard : chargement des états.");
		BMHStatus.load();
		Log.info("Mod BioMecHazard : chargement des objets.");
		BMHItems.load();
		Log.info("Mod BioMecHazard : chargement des liquides.");
		BMHLiquids.load();
		
		//BMHWeathers.load();
		
        //Log.info("Mod BioMecHazard : chargement des effets visuels.");
		//BMHVisualEffects.load();
        Log.info("Mod BioMecHazard : chargement des unités.");
		BMHUnits.load();
		UAWUnitTypes.load();
        Log.info("Mod BioMecHazard : chargement des blocs.");
		BMHBlocks.load();
		BMHBlocksTurret.load();
		UAWBlocksDefense.load();
		UAWBlocksPower.load();
		UAWBlocksLogistic.load();
		UAWBlocksProduction.load();
		UAWBlocksUnits.load();
		/*
		BMHBlocksProduction.load();
		BMHBlocksUnits.load();
		BMHBlocksCore.load();
		BMHBlocksDrill.load();
		BMHBlocksLogistic.load();
		BMHBlocksDuct.load();
		BMHBlocksCrafting.load();
		BMHBlocksPower.load();
		BMHBlocksUtility.load();
		BMHBlocksLogic.load();
		BMHBlocksWall.load();
		BMHBlocksTurret.load();
		BMHBlocksUnitFactory.load();
		*/
		Log.info("Mod BioMecHazard : chargement des balles.");
		//BMHBullets.load();
		UAWBullets.load();
		
        //BMHPlanets.load();
		
        //BMHSectors.load();
        Log.info("Mod BioMecHazard : chargement des arbres technologiques.");
		BMHTechtreeNodes.load();
		BMHTechtree.load();
		
		Log.info("Chargement de BioMecHazard v0.0.4" /*+ MOD.meta.version*/ + " effectué | Durée écoulée : " + (Time.elapsed() / Time.toSeconds) + " sec.");
    }

}



