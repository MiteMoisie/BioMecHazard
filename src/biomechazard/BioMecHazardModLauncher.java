package biomechazard;

import arc.*;
import arc.Events;
import arc.util.*;

//import mindustry.*;
//import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.Mod;
import mindustry.ui.dialogs.*;

import biomechazard.content.*;
import biomechazard.content.blocks.*;
import biomechazard.audiovisual.Sfx;

public class BioMecHazardModLauncher extends Mod{
	
	//public static Mods.LoadedMod MOD;

    public BioMecHazardModLauncher(){
        Log.info("Loaded BioMecHazardModLauncher constructor.");

        Events.on(FileTreeInitEvent.class, e -> Sfx.load());
		
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
        Log.info("Mod BioMecHazard : chargement des blocs.");
		//BMHBlocks.load();
		BMHBlocksStorage.load();
		BMHBlocksLogistic.load();
		BMHBlocksUtility.load();
		BMHBlocksProduction.load();
		/*
		BMHBlocksTurret.load();
		BMHBlocksUnits.load();
		BMHBlocksCore.load();
		BMHBlocksDrill.load();
		BMHBlocksDuct.load();
		BMHBlocksCrafting.load();
		BMHBlocksPower.load();
		BMHBlocksLogic.load();
		BMHBlocksWall.load();
		BMHBlocksTurret.load();
		BMHBlocksUnitFactory.load();
		*/
		//Log.info("Mod BioMecHazard : chargement des balles.");
		//BMHBullets.load();
		
        //BMHPlanets.load();
		
        //BMHSectors.load();
		
		Log.info("Mod BioMecHazard : chargement du contenu du mod 'Unlimited Armament Works'.");
		UAWBullets.load();
		UAWUnitTypes.load();
		UAWBlocksPower.load();
		UAWBlocksDefense.load();
		UAWBlocksLogistic.load();
		UAWBlocksProduction.load();
		UAWBlocksUnits.load();
		
		Log.info("Mod BioMecHazard : chargement du contenu du mod 'Fading Revelations'.");
		FRBlocksOthers.load();
		FRBlocksLogistic.load();
		FRBlocksLiquid.load();
		FRBlocksPower.load();
		FRBlocksDefense.load();
		//FRBlocksAttack.load();
		FRBlocksTrading.load();
		FRBlocksDrills.load();
		FRBlocksProduction.load();
		
		Log.info("Mod BioMecHazard : chargement des arbres technologiques.");
		BMHTechtreeNodes.load();
		BMHTechtree.load();
		
		Log.info("Chargement de BioMecHazard v0.0.30" /*+ MOD.meta.version*/ + " effectué | Durée écoulée : " + (Time.elapsed() / Time.toSeconds) + " sec.");
    }

}
