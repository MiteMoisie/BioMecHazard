package biomechazard.content.blocks;

import mindustry.content.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.production.*;
import biomechazard.content.*;

import static mindustry.type.ItemStack.*;

public class FRBlocksTrading {
	public static Block 
		blastCompoundTradingStation, coalTradingStation, graphiteTradingStation, leadTradingStation, metaglassTradingStation, 
		phaseFabricTradingStation, plastaniumTradingStation, pyratiteTradingStation, sandTradingStation, siliconTradingStation, 
		sporePodTradingStation, surgeAlloyTradingStation, copperTradingStation, thoriumTradingStation, titaniumTradingStation;
	
	public static void load(){
		blastCompoundTradingStation = new GenericCrafter("bc-trading-station"){{
            requirements(Category.crafting, with(Items.copper, 150, Items.lead, 40, Items.blastCompound, 20));
			
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(Items.blastCompound, 2);
            craftTime = 120f;
			itemCapacity = 64;
            size = 2;
            hasItems = true;
            hasPower = true;
			
			consumePower(4f);
            consumeItem(BMHItems.gold, 1);
        }};
		coalTradingStation = new GenericCrafter("coal-trading-station"){{
            requirements(Category.crafting, with(Items.copper, 150, Items.lead, 40, Items.coal, 20));
			
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(Items.coal, 8);
            craftTime = 120f;
			itemCapacity = 64;
            size = 2;
            hasItems = true;
            hasPower = true;
			
			consumePower(2f);
            consumeItem(BMHItems.gold, 1);
        }};
		graphiteTradingStation = new GenericCrafter("graphite-trading-station"){{
            requirements(Category.crafting, with(Items.copper, 150, Items.lead, 40, Items.graphite, 20));
			
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(Items.graphite, 3);
            craftTime = 120f;
			itemCapacity = 64;
            size = 2;
            hasItems = true;
            hasPower = true;
			
			consumePower(4f);
            consumeItem(BMHItems.gold, 1);
        }};
		leadTradingStation = new GenericCrafter("lead-trading-station"){{
            requirements(Category.crafting, with(Items.copper, 150, Items.lead, 60));
			
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(Items.lead, 16);
            craftTime = 120f;
			itemCapacity = 64;
            size = 2;
            hasItems = true;
            hasPower = true;
			
			consumePower(1f);
            consumeItem(BMHItems.gold, 1);
        }};
		metaglassTradingStation = new GenericCrafter("metaglass-trading-station"){{
            requirements(Category.crafting, with(Items.copper, 150, Items.lead, 40, Items.metaglass, 20));
			
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(Items.metaglass, 3);
            craftTime = 120f;
			itemCapacity = 64;
            size = 2;
            hasItems = true;
            hasPower = true;
			
			consumePower(2f);
            consumeItem(BMHItems.gold, 1);
        }};
		phaseFabricTradingStation = new GenericCrafter("phase-trading-station"){{
            requirements(Category.crafting, with(Items.copper, 150, Items.lead, 40, Items.phaseFabric, 20));
			
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(Items.phaseFabric, 1);
            craftTime = 120f;
			itemCapacity = 64;
            size = 2;
            hasItems = true;
            hasPower = true;
			
			consumePower(6f);
            consumeItem(BMHItems.gold, 1);
        }};
		plastaniumTradingStation = new GenericCrafter("plastanium-trading-station"){{
            requirements(Category.crafting, with(Items.copper, 150, Items.lead, 40, Items.plastanium, 20));
			
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(Items.plastanium, 1);
            craftTime = 120f;
			itemCapacity = 64;
            size = 2;
            hasItems = true;
            hasPower = true;
			
			consumePower(6f);
            consumeItem(BMHItems.gold, 1);
        }};
		pyratiteTradingStation = new GenericCrafter("pyratite-trading-station"){{
            requirements(Category.crafting, with(Items.copper, 150, Items.lead, 40, Items.pyratite, 20));
			
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(Items.pyratite, 3);
            craftTime = 120f;
			itemCapacity = 64;
            size = 2;
            hasItems = true;
            hasPower = true;
			
			consumePower(4f);
            consumeItem(BMHItems.gold, 1);
        }};
		sandTradingStation = new GenericCrafter("sand-trading-station"){{
            requirements(Category.crafting, with(Items.copper, 150, Items.lead, 40, Items.sand, 20));
			
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(Items.sand, 16);
            craftTime = 120f;
			itemCapacity = 64;
            size = 2;
            hasItems = true;
            hasPower = true;
			
			consumePower(1f);
            consumeItem(BMHItems.gold, 1);
        }};
		siliconTradingStation = new GenericCrafter("silicon-trading-station"){{
            requirements(Category.crafting, with(Items.copper, 150, Items.lead, 40, Items.silicon, 20));
			
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(Items.silicon, 3);
            craftTime = 120f;
			itemCapacity = 64;
            size = 2;
            hasItems = true;
            hasPower = true;
			
			consumePower(2f);
            consumeItem(BMHItems.gold, 1);
        }};
		sporePodTradingStation = new GenericCrafter("spore-pod-trading-station"){{
            requirements(Category.crafting, with(Items.copper, 150, Items.lead, 40, Items.sporePod, 20));
			
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(Items.sporePod, 2);
            craftTime = 120f;
			itemCapacity = 64;
            size = 2;
            hasItems = true;
            hasPower = true;
			
			consumePower(2f);
            consumeItem(BMHItems.gold, 1);
        }};
		surgeAlloyTradingStation = new GenericCrafter("surge-trading-station"){{
            requirements(Category.crafting, with(Items.copper, 150, Items.lead, 40, Items.surgeAlloy, 20));
			
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(Items.surgeAlloy, 1);
            craftTime = 120f;
			itemCapacity = 64;
            size = 2;
            hasItems = true;
            hasPower = true;
			
			consumePower(6f);
            consumeItem(BMHItems.gold, 1);
        }};
		copperTradingStation = new GenericCrafter("gold-exchanger-copper"){{
            requirements(Category.crafting, with(Items.copper, 150, Items.lead, 40));
			
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(BMHItems.gold, 1);
            craftTime = 30;
			itemCapacity = 320;
            size = 2;
            hasItems = true;
			
			consumeItem(Items.copper, 32);
        }};
		thoriumTradingStation = new GenericCrafter("gold-exchanger-thorium"){{
            requirements(Category.crafting, with(Items.copper, 200, Items.lead, 90, Items.titanium, 70, Items.thorium, 50));
			
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(BMHItems.gold, 1);
            craftTime = 30;
			itemCapacity = 160;
            size = 2;
            hasItems = true;
			
			consumeItem(Items.thorium, 8);
        }};
		titaniumTradingStation = new GenericCrafter("gold-exchanger-titanium"){{
            requirements(Category.crafting, with(Items.copper, 200, Items.lead, 90, Items.titanium, 70));
			
            craftEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(BMHItems.gold, 1);
            craftTime = 30;
			itemCapacity = 240;
            size = 2;
            hasItems = true;
			
			consumeItem(Items.titanium, 16);
        }};
	}
}