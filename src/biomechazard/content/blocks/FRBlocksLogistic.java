package biomechazard.content.blocks;

import arc.graphics.*;
import mindustry.content.*;
import mindustry.entities.effect.*;
import mindustry.type.*;
import mindustry.world.Block;
import mindustry.world.blocks.campaign.LaunchPad;
import mindustry.world.meta.BlockGroup;
import biomechazard.content.*;

import static mindustry.type.ItemStack.*;

public class FRBlocksLogistic{
	public static Block 
		plastaniumConduit, amalgamConveyor, surgeAlloyConveyor, surgeBridgeConveyor, surgeTitaniumConveyor, 
		titaniumDistributor, titaniumJunction, titaniumRouter, tinyMassDriver, massAccelerator, advancedLaunchPad;
	
	public static void load(){
		
		amalgamConveyor = new StackConveyor("amalgam-conveyor"){{
            requirements(Category.distribution, with(Items.steelAmalgam, 1, Items.silicon, 1, Items.graphite, 1));
            health = 110;
            speed = 0.09f;
            itemCapacity = 20;
			outputRouter = true;
			glowColor = Color.valueOf("dbaf85");
			unloadEffect = new WaveEffect(){{
				sizeFrom = 0;
				sizeTo = 5;
				colorFrom = Color.valueOf("a3506e");
				colorTo = Color.valueOf("ba6a83");
			}};
			loadEffect = new WaveEffect(){{
				sizeFrom = 5;
				sizeTo = 0;
				colorFrom = Color.valueOf("ba6a83");
				colorTo = Color.valueOf("a3506e");
			}};
        }};
		
		plastaniumConduit = new Conduit("plastanium-conduit"){{
			requirements(Category.liquid, with(Items.metaglass, 2, Items.thorium, 3, Items.plastanium, 2));
			health = 110;
			liquidPressure = 2;
		}};
		
		surgeAlloyConveyor = new Conveyor("surge-alloy-conveyor"){{
            requirements(Category.distribution, with(Items.copper, 1, Items.lead, 1, Items.titanium, 1, Items.surgeAlloy, 1));
            health = 350;
            speed = 0.2f;
            displayedSpeed = 22f;
        }};
		
		surgeBridgeConveyor = new ItemBridge("surge-bridge-conveyor"){{
            requirements(Category.distribution, with(Items.lead, 6, Items.copper, 6, Items.surgeAlloy, 4));
			health = 250;
            range = 6;
			transportTime = 2f;
			hasPower = false;
        }};
		
		surgeTitaniumConveyor = new ItemBridge("titanium-bridge-conveyor"){{
            requirements(Category.distribution, with(Items.lead, 4, Items.copper, 4, Items.titanium, 4));
            health = 250;
            range = 6;
			transportTime = 4f;
			hasPower = false;
        }};
		
		titaniumDistributor = new Router("titanium-distributor"){{
            requirements(Category.distribution, with(Items.lead, 6, Items.copper, 8, Items.titanium, 4));
            size = 2;
			health = 220;
            speed = 0.1f;
			dumpTime = 1;
			itemCapacity = 20;
        }};
		
		titaniumJunction = new Junction("titanium-junction"){{
            requirements(Category.distribution, with(Items.copper, 6, Items.titanium, 4));
            size = 1;
			speed = 18;
            health = 45;
        }};
		
		titaniumRouter = new Router("titanium-router"){{
            requirements(Category.distribution, with(Items.copper, 5, Items.titanium, 2));
			dumpTime = 1;
			speed = 0.1;
            health = 75;
			itemCapacity = 20;
			size = 1;
        }};
		
		tinyMassDriver = new MassDriver("tiny-md"){{
            requirements(Category.distribution, with(Items.titanium, 25, Items.copper, 75, Items.lead, 50));
            size = 1;
            itemCapacity = 20;
            reload = 10f;
            range = 88f;
            consumePower(0.3333333333f);
			health = 160;
        }};
		
		massAccelerator = new MassDriver("mass-accelerator"){{
            requirements(Category.distribution, with(Items.titanium, 200, Items.silicon, 110, Items.lead, 200, Items.phaseFabric, 50));
            size = 4;
            itemCapacity = 300;
            reload = 120f;
            range = 600f;
            consumePower(3.333333333333333333f);
			health = 720;
        }};
		
		advancedLaunchPad = new LaunchPad("big-launch-pad"){{
            requirements(Category.effect, 
				with(Items.silicon, 700, Items.lead, 700, Items.titanium, 800, Items.plastanium, 200, Items.phaseFabric, 200, Items.steelAmalgam, 100));
            health = 740;
            launchTime = 780f;
			lightColor = Color.valueOf("8c0291");
            itemCapacity = 200;
			size = 4;
            hasPower = true;
            acceptMultipleItems = true;
            consumePower(10f);
			consumeLiquid(Liquids.water, 0.3f);
        }};
	}
}