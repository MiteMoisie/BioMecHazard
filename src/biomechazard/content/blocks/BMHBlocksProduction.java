package biomechazard.content.blocks;

import arc.graphics.*;
import arc.math.Interp;
import mindustry.content.*;
import mindustry.entities.effect.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.world.Block;
import mindustry.world.blocks.production.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;
import biomechazard.content.*;
import biomechazard.audiovisual.*;

import static mindustry.type.ItemStack.*;

public class BMHBlocksProduction{
	public static Block livingSteelManufacturingIndustrialComplex;
	
	public static void load(){
		
		livingSteelManufacturingIndustrialComplex = new GenericCrafter("living-steel-manufacturing-industrial-complex"){{
			requirements(Category.crafting, with(Items.copper, 520, Items.lead, 380, Items.titanium, 180, Items.metaglass, 200));
			size = 3;
			craftTime = 40f;
			craftEffect = Fx.smeltsmoke;
			updateEffect = Fx.smeltsmoke;
			hasPower = true;
			hasItems = true;
			hasLiquids = true;
			consumePower(2.8f);
			consumeItems(with(Items.titanium, 2, Items.sporePod, 1, Items.thorium, 2));
			consumeLiquid(Liquids.oil, 0.6f);
			outputItem = new ItemStack(BMHItems.livingSteel, 4, BMHItems.hardenedLivingSteel, 4);
			outputLiquid = new LiquidStack(BMHLiquids.livingSteelLiquid, 0.8f);
			drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidRegion(BMHLiquids.livingSteelLiquid), new DrawDefault());
		}};
		
	}
}