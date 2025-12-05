package biomechazard.content.blocks;

import mindustry.content.Items;
import mindustry.type.*;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.campaign.LaunchPad;
import mindustry.world.meta.BlockGroup;

import static mindustry.type.ItemStack.*;

public class BMHBlocksLogistic{
	public static Block 
		enhancedContainer;
		
	public static void load(){
		itemsLaunchPad = new LaunchPad("items-launch-pad"){{
            requirements(Category.effect, with(Items.copper, 350, Items.silicon, 140, Items.lead, 200, Items.titanium, 150));
            size = 3;
            itemCapacity = 100;
            launchTime = 60f * 20;
            hasPower = true;
            acceptMultipleItems = true;
            consumePower(4f);
			researchCostMultiplier = 1.5f;
        }};
	}
}