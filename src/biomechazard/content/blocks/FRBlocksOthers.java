package biomechazard.content.blocks;

import arc.graphics.Color;
import mindustry.content.*;
import mindustry.type.*;
import mindustry.world.Block;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.storage.*;
import biomechazard.content.*;
import biomechazard.world.blocks.storage.*;

import static mindustry.type.ItemStack.*;

public class FRBlocksOthers{
	public static Block 
		constructionPylon, coreAtom, coreElement, mainCore, depository, advancedUnloader, darkMender, enhancedMendProjector, 
		forceDome, miniOverdriveDome, outpost;
		
	public static void load(){
		
		constructionPylon = new BuildTurret("construction-pylon"){{
            requirements(Category.effect, with(Items.copper, 90, Items.silicon, 60, Items.titanium, 150, BMHItems.livingSteel, 150));
            size = 3;
			range = 160f;
			buildSpeed = 1f;
			consumePower(9f);
            consumeLiquid(Liquids.cryofluid, 0.2f);
        }};
		
		coreAtom = new CoreBlock("core-atom"){{
            requirements(Category.effect, with(Items.copper, 10000, Items.lead, 10000, Items.silicon, 6000, Items.titanium, 8000, 
				Items.thorium, 10000, Items.plastanium, 1000, Items.phaseFabric, 1000));
            size = 6;
			researchCostMultiplier = 0.5f;
			health = 8000;
			itemCapacity = 16000;
			unitType = BMHUnits.mokuge;//FRUnits.deltaFR;
			unitCapModifier = 32;
        }};
		
		coreElement = new CoreBlock("core-element"){{
            requirements(Category.effect, with(Items.copper, 13000, Items.lead, 13000, Items.silicon, 9000, Items.titanium, 11000, 
				Items.thorium, 12000, Items.plastanium, 2000, Items.phaseFabric, 2500, Items.surgeAlloy, 1500));
            size = 7;
			researchCostMultiplier = 0.5f;
			health = 9500;
			itemCapacity = 19000;
			unitType = BMHUnits.mokuge;//FRUnits.epsilonFR;
			unitCapModifier = 42;
        }};
		
		mainCore = new CoreBlock("main-core"){{
            requirements(Category.effect, with(Items.copper, 18000, Items.lead, 18000, Items.silicon, 11000, Items.titanium, 13000, 
				Items.thorium, 15000, Items.plastanium, 3600, Items.phaseFabric, 5200, Items.surgeAlloy, 2300));
            size = 8;
			researchCostMultiplier = 0.4f;
			health = 11200;
			itemCapacity = 22000;
			unitType = BMHUnits.mokuge;//FRUnits.mainCoreUnit;
			unitCapModifier = 56;
        }};
		
		depository = new StorageBlock("depository"){{
			requirements(Category.effect, with(Items.titanium, 300, Items.thorium, 180, Items.plastanium, 20));
            size = 4;
			hasItems = true;
            itemCapacity = 1800;
            health = 760;
			coreMerge = true;
		}};
		
		advancedUnloader = new Unloader("fast-unloader"){{
            requirements(Category.effect, with(Items.titanium, 45, Items.silicon, 50));
            size = 1;
			speed = 3f;
			itemCapacity = 5;
        }};
		
		darkMender = new MendProjector("dark-mender"){{
            requirements(Category.effect, with(Items.graphite, 60, Items.silicon, 140, Items.titanium, 150, BMHItems.hardenedLivingSteel, 120, 
				Items.phaseFabric, 40));
            size = 3;
			health = 1350;
            range = 80f;
			reload = 120f;
			consumesPower = false;
			baseColor = Color.valueOf("6d5ac6");
			phaseColor = Color.valueOf("6d5ac6");
			hasPower = false;
			healPercent = 15f;
			consumeItems(with(BMHItems.livingSteel, 1));
			//hasBoost = false;
			//Ce bloc ne peut pas être boosté
			//booster = false;
			//optional = false;
        }};
		
		enhancedMendProjector = new MendProjector("enhanced-mend-projector"){{
            requirements(Category.effect, with(Items.graphite, 60, Items.silicon, 140, Items.titanium, 150, Items.phaseFabric, 40));
            size = 3;
			health = 1000;
            range = 120f;
			reload = 100f;
			healPercent = 5f;
			consumePower(5f);
			consumeItem(Items.phaseFabric, 5).boost();
        }};
		
		forceDome = new ForceProjector("force-dome"){{
            requirements(Category.effect, with(Items.lead, 300, Items.titanium, 150, Items.silicon, 265, Items.thorium, 200, Items.plastanium, 100));
            size = 4;
			health = 500;
            radius = 210f;
            shieldHealth = 1500f;
            cooldownNormal = 1.1f;
            cooldownBrokenBase = 0.9f;
            consumePower(5f);
			//hasBoost = false;
        }};

        miniOverdriveDome = new OverdriveProjector("mini-od"){{
            requirements(Category.effect, with(Items.lead, 25, Items.titanium, 20, Items.silicon, 25));
            size = 1;
            range = 48f;
            hasBoost = false;
            speedBoost = 1.15f;
            reload = 1f;
            consumePower(1.25f);
        }};

        outpost = new Outpost("outpost"){{
            requirements(Category.effect, 
				with(Items.copper, 3000, Items.lead, 2500, Items.silicon, 2200, Items.titanium, 2000, BMHItems.hardenedLivingSteel, 1000, 
				BMHItems.gold, 600, BMHItems.steelAmalgam, 500));
            size = 3;
			health = 1200;
            hasItems = true;
			itemCapacity = 5;
			solid = true;
			update = true;
        }};
	}

}


