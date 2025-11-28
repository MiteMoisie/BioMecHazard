package biomechazard.content.blocks;

import mindustry.world.*;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.meta.*;

import static mindustry.world.meta.BuildVisibility.*;

public class BMHGates {
    public static Block 
		gateMain, gateSector, gateCore, gateCoreUnit,  gateItem, gateDrill, gateDistribution, gateDuct, gateCrafter, gatePower, 
		gateUtil, gateLogic, gateWall, gateTurret, gateUnitFactory, gateGroundUnit, gateAirUnit, gateNavalUnit;
		//BuildVisibility.hidden
		
    public static void load() {
		gateMain = new Wall("gate-main") {{
			buildVisibility = hidden;
			alwaysUnlocked = true;
			hideDatabase = true;
			health = 0;
			size = 1;
		}};
		gateSector = new Wall("gate-sector") {{
			buildVisibility = hidden;
			alwaysUnlocked = true;
			hideDatabase = true;
			health = 0;
			size = 1;
		}};
		gateCore = new Wall("gate-core") {{
			buildVisibility = hidden;
			alwaysUnlocked = true;
			hideDatabase = true;
			health = 0;
			size = 1;
		}};
		gateCoreUnit = new Wall("gate-core-unit") {{
			buildVisibility = hidden;
			alwaysUnlocked = true;
			hideDatabase = true;
			health = 0;
			size = 1;
		}};
		gateItem = new Wall("gate-item") {{
			buildVisibility = hidden;
			alwaysUnlocked = true;
			hideDatabase = true;
			health = 0;
			size = 1;
		}};
		gateDrill = new Wall("gate-drill") {{
			buildVisibility = hidden;
			alwaysUnlocked = true;
			hideDatabase = true;
			health = 0;
			size = 1;
		}};
		gateDistribution = new Wall("gate-distribution") {{
			buildVisibility = hidden;
			alwaysUnlocked = true;
			hideDatabase = true;
			health = 0;
			size = 1;
		}};
		gateDuct = new Wall("gate-duct") {{
			buildVisibility = hidden;
			alwaysUnlocked = true;
			hideDatabase = true;
			health = 0;
			size = 1;
		}};
		gateCrafting = new Wall("gate-crafting") {{
			buildVisibility = hidden;
			alwaysUnlocked = true;
			hideDatabase = true;
			health = 0;
			size = 1;
		}};
		gatePower = new Wall("gate-power") {{
			buildVisibility = hidden;
			alwaysUnlocked = true;
			hideDatabase = true;
			health = 0;
			size = 1;
		}};
		gateUtil = new Wall("gate-util") {{
			buildVisibility = hidden;
			alwaysUnlocked = true;
			hideDatabase = true;
			health = 0;
			size = 1;
		}};
		gateLogic = new Wall("gate-logic") {{
			buildVisibility = hidden;
			alwaysUnlocked = true;
			hideDatabase = true;
			health = 0;
			size = 1;
		}};
		gateWall = new Wall("gate-wall") {{
			buildVisibility = hidden;
			alwaysUnlocked = true;
			hideDatabase = true;
			health = 0;
			size = 1;
		}};
		gateTurret = new Wall("gate-turret") {{
			buildVisibility = hidden;
			alwaysUnlocked = true;
			hideDatabase = true;
			health = 0;
			size = 1;
		}};
		gateUnitFactory = new Wall("gate-unit-factory") {{
			buildVisibility = hidden;
			alwaysUnlocked = true;
			hideDatabase = true;
			health = 0;
			size = 1;
		}};
		gateGroundUnit = new Wall("gate-ground-unit") {{
			buildVisibility = hidden;
			alwaysUnlocked = true;
			hideDatabase = true;
			health = 0;
			size = 1;
		}};
		gateAirUnit = new Wall("gate-air-unit") {{
			buildVisibility = hidden;
			alwaysUnlocked = true;
			hideDatabase = true;
			health = 0;
			size = 1;
		}};
		gateNavalUnit = new Wall("gate-naval-unit") {{
			buildVisibility = hidden;
			alwaysUnlocked = true;
			hideDatabase = true;
			health = 0;
			size = 1;
		}};
    }
}
