package biomechazard.content.blocks;

import arc.graphics.*;
import arc.math.Interp;
import mindustry.content.*;
import mindustry.entities.effect.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.world.Block;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;
import biomechazard.content.*;

import static mindustry.type.ItemStack.*;

public class BMHBlocksUtility{
	public static Block overclockedOverdriveDome, recyclingComplex;
	
	public static void load(){
		
		overclockedOverdriveDome = new OverdriveProjector("overclocked-overdrive-dome"){{
            requirements(Category.effect, with(Items.lead, 500, Items.titanium, 430, Items.silicon, 430, Items.plastanium, 380, Items.surgeAlloy, 420));
            health = 540;
			consumePower(20f);
            size = 2;
            range = 200f;
            speedBoost = 3.5f;
            useTime = 350f;
			speedBoostPhase = 0.75f;
			phaseRangeBoost = 50f;
            consumeItems(with(Items.phaseFabric, 4, Items.silicon, 4, Items.surgeAlloy, 2));
			hasBoost = false;
			//hasLiquids = true;
			//liquidCapacity = 80f;
			//consumeLiquid(Liquids.cryofluid, 0.15f).boost();
			baseColor = Color.valueOf("4c75fc");
			phaseColor = Color.valueOf("50b0fa");
        }};
		
		recyclingComplex = new PayloadDeconstructor("recycling-complex"){{
            requirements(Category.crafting, with(Items.graphite, 250, Items.thorium, 250, Items.silicon, 200));
            health = 1000;
			itemCapacity = 250;
            consumePower(3f);
            size = 5;
            deconstructSpeed = 6f;
			maxPayloadSize = 50;
        }};
	}

}
