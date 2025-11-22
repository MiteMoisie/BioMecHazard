package biomechazard.content;

import mindustry.world.*;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.blocks.power.*;
import mindustry.game.*;
import mindustry.type.*;
import mindustry.content.*;
import mindustry.content.Items;

import static mindustry.type.ItemStack.*;
import static mindustry.content.Items.*;

public class BMHBlocks{
    public static Block coreNethrax;

        public static void load(){
        
        coreNethrax = new CoreBlock("core-nethrax"){{
            requirements(Category.effect, with(sporePod, 14000, titanium, 14000, silicon, 11000, thorium, 10000, phaseFabric, 7000, surgeAlloy, 4000));

            unitType = BMHUnits.mokuge;
            health = 13820;
            size = 6;
			armor = 60f;
			unitCapModifier = 32;
            itemCapacity = 19000;
			unitMoveBreakable = true;
            buildTime = 12600f;
			floating = true;
            placeableLiquid = true;
            researchCostMultiplier = 0.15f;
			alwaysUnlocked = true;
			
			/*À faire : ajouter la capacité au noyau de stocker des liquides. Pour l'instant
			*le noyau affiche les infos mais n'accepte pas les liquides.
			*/
			hasLiquids = true;
			liquidCapacity = 8000;
			liquidPressure = 800;
			
			//À faire : ajouter la capacité au noyau de produire de l'énergie
			//powerProduction = 14.5f;
			//
			/*Code java converti d'après du code javascript. 
			*import mindustry.world.blocks.storage.CoreBlock;
			*
			*public class coreLevel4 extends CoreBlock {
			*    private static final int powerProduction = 10;
			*    private static final float productionEfficiency = 1.0f;
			*
			*    public coreLevel4() {
			*        super("coreLevel4");
			*        hasPower = true;
			*        outputsPower = true;
			*        consumesPower = false;
			*
			*        baseExplosiveness = 10;
			*        thrusterLength = 46f / 4f;
			*    }
			*
			*    @Override
			*    public CoreBuild createBuild() {
			*        return new coreLevel4Build();
			*    }
			*
			*    public class coreLevel4Build extends CoreBlock.CoreBuild {
			*        public float getPowerProduction() {
			*            return powerProduction * productionEfficiency;
			*        }
			*    }
			*}
			*/
			/* Code javascript d'origine
			*const powerProduction = 10;
			*const productionEfficiency = 1.0;
			*
			*const coreLevel4 = extend(CoreBlock, "coreLevel4", {
			*	
			*    hasPower: true,
			*    outputsPower: true,
			*    consumesPower: false,
			*	
			*    baseExplosiveness: 12,
			*    thrusterLength: 46/4,
			*});
			*
			*coreLevel4.buildType = () => extend(CoreBlock.CoreBuild, coreLevel4, {
			*	//endowing the core with the ability to produce power
			*    getPowerProduction(){
			*        return powerProduction * productionEfficiency;
			*    }
			*});
			*/
			hasPower = true;
			consumesPower = false;
			outputsPower = true;
			conductivePower = true;

			requiresCoreZone = false; //Pour que le noyau soit constructible n'importe où, cet attribut ne suffit pas.
			//On utilise le même comportement que si on était dans l'éditeur
			canPlaceOn = (tile, team, rotation) -> true;
        }
		//On utilise le même comportement que si on était dans l'éditeur
		/*@Override
		public boolean canPlaceOn(Tile tile, Team team, int rotation){
			if(tile == null) return false;
			return true;
		}*/};
}}










