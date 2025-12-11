package biomechazard.content.blocks;

import mindustry.content.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;

import biomechazard.content.*;

public class FRBlocksDefense{
	
	public static Block plastaniumWallHuge;
	
	public static void load(){

        plastaniumWallHuge = new Wall("plastanium-wall-2"){{
            requirements(Category.defense, with(Items.plastanium, 54));
            health = 4680;
            size = 3;
            insulated = true;
            absorbLasers = true;
        }};
		
	}

}
