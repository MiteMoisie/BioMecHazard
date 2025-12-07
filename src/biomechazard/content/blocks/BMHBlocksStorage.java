package biomechazard.content.blocks;

import mindustry.content.Items;
import mindustry.type.*;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.storage.Unloader;
import mindustry.world.blocks.storage.StorageBlock;
import mindustry.world.meta.BlockGroup;

import static mindustry.type.ItemStack.*;

public class BMHBlocksStorage{
	public static Block 
		coreCage, 
		enhancedContainer, enhancedVault, warehouse, largeWarehouse, enhancedUnloader, highOutputUnloader;
	
	public static void load(){
		coreCage = new CoreCage("core-cage"){{
			requirements(Category.effect, with(copper, 11000, lead, 11000, silicon, 8000, thorium, 7000, plastanium, 6000));
			unitType = BMHUnits.mokuge;
			itemCapacity = 20000;
			health = 8500;
			unitCapModifier = 32;
			alwaysUnlocked = true;
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






