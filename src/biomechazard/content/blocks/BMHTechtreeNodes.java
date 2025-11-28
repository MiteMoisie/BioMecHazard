package biomechazard.content.blocks;

import mindustry.world.*;
import biomechazard.content.blocks.BMHTechtreeNode;
import mindustry.world.meta.*;

import static mindustry.world.meta.BuildVisibility.*;

public class BMHTechtreeNodes {
    public static Block 
		//Arbre Quarkhod
		gateQuarkhod, gateSector, gateCore, gateCoreUnit,  gateItem, gateDrill, gateDistribution, gateDuct, gateCrafting, gatePower, 
		gateUtil, gateLogic, gateWall, gateTurret, gateUnitFactory, gateGroundUnit, gateAirUnit, gateNavalUnit, 
		//Arbre Unlimited Armament Works
		gateUAWStart, gateUAWCrafting, gateUAWDefence, gateUAWTurret, gateUAWTurretART, gateUAWTurretEN, gateUAWTurretMG, gateUAWTurretMSL, gateUAWTurretSG;
		
    public static void load() {
		gateQuarkhod = new BMHTechtreeNode("gate-quarkhod") {{}};
		gateSector = new BMHTechtreeNode("gate-sector") {{}};
		gateCore = new BMHTechtreeNode("gate-core") {{}};
		gateCoreUnit = new BMHTechtreeNode("gate-core-unit") {{}};
		gateItem = new BMHTechtreeNode("gate-item") {{}};
		gateDrill = new BMHTechtreeNode("gate-drill") {{}};
		gateDistribution = new BMHTechtreeNode("gate-distribution") {{}};
		gateDuct = new BMHTechtreeNode("gate-duct") {{}};
		gateCrafting = new BMHTechtreeNode("gate-crafting") {{}};
		gatePower = new BMHTechtreeNode("gate-power") {{}};
		gateUtil = new BMHTechtreeNode("gate-util") {{}};
		gateLogic = new BMHTechtreeNode("gate-logic") {{}};
		gateWall = new BMHTechtreeNode("gate-wall") {{}};
		gateTurret = new BMHTechtreeNode("gate-turret") {{}};
		gateUnitFactory = new BMHTechtreeNode("gate-unit-factory") {{}};
		gateGroundUnit = new BMHTechtreeNode("gate-ground-unit") {{}};
		gateAirUnit = new BMHTechtreeNode("gate-air-unit") {{}};
		gateNavalUnit = new BMHTechtreeNode("gate-naval-unit") {{}};
		gateUAWStart = new BMHTechtreeNode("gate-uaw-start") {{}};
		gateUAWCrafting = new BMHTechtreeNode("gate-uaw-crafting") {{}};
		gateUAWDefence = new BMHTechtreeNode("gate-uaw-defence") {{}};
		gateUAWTurret = new BMHTechtreeNode("gate-uaw-turret") {{}};
		gateUAWTurretART = new BMHTechtreeNode("gate-uaw-turret-art") {{}};
		gateUAWTurretEN = new BMHTechtreeNode("gate-uaw-turret-en") {{}};
		gateUAWTurretMG = new BMHTechtreeNode("gate-uaw-turret-mg") {{}};
		gateUAWTurretMSL = new BMHTechtreeNode("gate-uaw-turret-msl") {{}};
		gateUAWTurretSG = new BMHTechtreeNode("gate-uaw-turret-sg") {{}};
    }
}