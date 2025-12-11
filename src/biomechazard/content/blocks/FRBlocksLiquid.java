package biomechazard.content.blocks;

import mindustry.content.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.production.*;
import mindustry.world.draw.*;

import biomechazard.content.*;

import static mindustry.type.ItemStack.*;

public class FRBlocksLiquid{
	
	public static Block 
		liquidCanister, steelTank, steelPump;
	
	public static void load(){
		
        liquidCanister = new LiquidRouter("liquid-canister"){{
            requirements(Category.liquid, with(Items.titanium, 3, Items.metaglass, 4));
            size = 1;
            solid = true;
            liquidCapacity = 200f;
            health = 40;
        }};

        steelTank = new LiquidRouter("steel-tank"){{
            requirements(Category.liquid, with(Items.titanium, 30, Items.metaglass, 40, BMHItems.livingSteel, 20));
            size = 3;
            solid = true;
            liquidCapacity = 2100f;
            health = 750;
        }};

        steelPump = new Pump("steel-pump"){{
            requirements(Category.liquid, 
				with(Items.copper, 90, Items.metaglass, 100, Items.silicon, 35, BMHItems.livingSteel, 60, Items.thorium, 45));
            pumpAmount = 0.25f;
            consumePower(1.6f);
            liquidCapacity = 40f;
            hasPower = true;
			hasLiquids = true;
            size = 3;
			drawer = new DrawMulti(
				new DrawRegion("-bottom"), 
				new DrawLiquidRegion(Liquids.water),
				new DrawBlurSpin("-rotator", 1.2f),
				new DrawDefault()
			);
        }};
		
	}

}


