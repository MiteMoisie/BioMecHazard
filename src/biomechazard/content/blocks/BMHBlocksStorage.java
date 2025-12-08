package biomechazard.content.blocks;

import mindustry.content.Items;
import mindustry.type.*;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.storage.Unloader;
import mindustry.world.blocks.storage.StorageBlock;
import mindustry.world.meta.BlockGroup;

import biomechazard.content.*;

import static mindustry.type.ItemStack.*;

public class BMHBlocksStorage{
	public static Block 
		coreNethrax, coreNexus, coreNetwork, 
		enhancedContainer, enhancedVault, warehouse, largeWarehouse, enhancedUnloader, highOutputUnloader;
	
	public static void load(){
		
		coreNethrax = new CoreQuarkhod("core-nethrax"){{
			requirements(Category.effect, 
				with(Items.sporePod, 14000, Items.titanium, 14000, Items.silicon, 11000, Items.thorium, 10000, Items.phaseFabric, 7000, Items.surgeAlloy, 4000));
			unitType = BMHUnits.mokuge;
			size = 7;
			health = 13820;
			armor = 60f;
			unitCapModifier = 32;
			itemCapacity = 19000;
			buildTime = 12600f;
			researchCostMultiplier = 0.15f;
			liquidCapacity = 8000;
			//liquidPressure = 800;
			powerProduction = 14.5f;
		}};
		
		coreNexus = new CoreBlock("core-nexus"){{
			requirements(Category.effect, 
				with(Items.copper, 12500, Items.lead, 12500, Items.silicon, 12500, Items.thorium, 12500, Items.titanium, 12500, Items.phaseFabric, 6250));
			unitType = BMHUnits.delta;
			size = 6;
			itemCapacity = 18000;
			health = 8600;
			unitCapModifier = 26;
			//researchCostMultiplier = 0.15f;
		}};
		
		coreNetwork = new CoreCage("core-network"){{
			requirements(Category.effect, 
				with(Items.copper, 22000, Items.lead, 22000, Items.silicon, 22000, Items.thorium, 22000, Items.plastanium, 10000, Items.phaseFabric, 10000, 
				Items.surgeAlloy, 22000, Items.titanium, 22000, Items.metaglass, 10000, Items.graphite, 10000));
			unitType = BMHUnits.epsilon;
			size = 7;
			itemCapacity = 24000;
			health = 22600;
			unitCapModifier = 32;
			//researchCostMultiplier = 0.15f;
		}};
		
		enhancedContainer = new StorageBlock("enhanced-container"){{
			requirements(Category.effect, with(Items.titanium, 100, Items.metaglass, 50));
            size = 2;
            itemCapacity = 300;
            scaledHealth = 55;
			floating = true;
            placeableLiquid = true;
			researchCostMultiplier = 1.5f;
			/** 
			* À faire : ajouter la capacité de stocker des liquides. Pour l'instant
			* le bloc affiche les infos mais n'accepte pas les liquides.
			*/
			hasLiquids = true;
			liquidCapacity = 700;
			liquidPressure = 350;
			isDuct = true;
			outputsLiquid = true;
			consumesPower = false;
			conductivePower = true;
		}};
		
		enhancedVault = new StorageBlock("enhanced-vault"){{
            requirements(Category.effect, with(Items.titanium, 250, Items.metaglass, 175, Items.thorium, 125));
            size = 3;
            itemCapacity = 1000;
            scaledHealth = 55;
			floating = true;
            placeableLiquid = true;
			researchCostMultiplier = 1.5f;
			/** 
			* À faire : ajouter la capacité de stocker des liquides. Pour l'instant
			* le bloc affiche les infos mais n'accepte pas les liquides.
			*/
			hasLiquids = true;
			liquidCapacity = 1800;
			liquidPressure = 900;
			isDuct = true;
			outputsLiquid = true;
			consumesPower = false;
			conductivePower = true;
        }};
		
		warehouse = new StorageBlock("warehouse"){{
            requirements(Category.effect, with(Items.titanium, 250, Items.metaglass, 175, Items.thorium, 125));
            size = 4;
            itemCapacity = 4500;
            scaledHealth = 55;
			floating = true;
            placeableLiquid = true;
			researchCostMultiplier = 1.5f;
			/** 
			* À faire : ajouter la capacité de stocker des liquides. Pour l'instant
			* le bloc affiche les infos mais n'accepte pas les liquides.
			*/
			hasLiquids = true;
			liquidCapacity = 4700;
			liquidPressure = 2000;
			isDuct = true;
			outputsLiquid = true;
			consumesPower = false;
			conductivePower = true;
        }};
		
		largeWarehouse = new StorageBlock("large-warehouse"){{
            requirements(Category.effect, with(Items.titanium, 250, Items.metaglass, 175, Items.thorium, 125));
            size = 5;
            itemCapacity = 17000;
            scaledHealth = 55;
			floating = true;
            placeableLiquid = true;
			researchCostMultiplier = 1.5f;
			/** 
			* À faire : ajouter la capacité de stocker des liquides. Pour l'instant
			* le bloc affiche les infos mais n'accepte pas les liquides.
			*/
			hasLiquids = true;
			liquidCapacity = 14000;
			liquidPressure = 10000;
			isDuct = true;
			outputsLiquid = true;
			consumesPower = false;
			conductivePower = true;
        }};
		
		enhancedUnloader = new Unloader("enhanced-unloader"){{
            requirements(Category.effect, with(Items.titanium, 50, Items.silicon, 60, Items.surgeAlloy, 30));
            speed = 60f / 120f;
            group = BlockGroup.transportation;
			itemCapacity = 240;
        }};
		
		highOutputUnloader = new Unloader("high-output-unloader"){{
            requirements(Category.effect, with(Items.titanium, 150, Items.silicon, 90, Items.surgeAlloy, 60, Items.thorium, 30));
            speed = 60f / 360f;
            group = BlockGroup.transportation;
			itemCapacity = 720;
        }};
	}

}









