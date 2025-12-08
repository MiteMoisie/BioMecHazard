package biomechazard.content.blocks;

import mindustry.world.*;
import biomechazard.content.blocks.BMHTechtreeNode;
import mindustry.world.meta.*;

import static mindustry.world.meta.BuildVisibility.*;

public class BMHTechtreeNodes {
    public static Block 
		//Arbre Quarkhod
		gateQuarkhod, gateSector, gateCore, gateCoreUnit,  gateItem, gateDrill, gateDistribution, gateDuct, gateCrafting, gatePower, 
		gateUtil, gateLogic, gateWall, gateTurret, gateUnitFactory, gateGroundUnit, gateAirUnit, gateNavalUnit, gateTurretArtillery, 
		gateTurretEnergy, gateTurretMachineGun, gateTurretMissileLauncher, gateTurretPrecisionShot, gateTurretShotgun, 
		//Arbre Unlimited Armament Works
		gateUAWStart, gateUAWCrafting, gateUAWDefence, gateUAWTurret, gateUAWTurretART, gateUAWTurretEN, gateUAWTurretMG, gateUAWTurretMSL, gateUAWTurretSG, 
		//Arbre Fading Revelations
		gateFRAmmo, gateFRBlocks, gateFRCores, gateFRCoreUnits, gateFRProduction, gateFRDistribution, gateFRDrills, gateFREffectBlocks, gateFRFactories, 
		gateFRFlyingUnits, gateFRItems, gateFRGroundUnits, gateFRLiquid, gateFRMain, gateFRNavalUnits, gateFRPower, gateFRResources, gateFRTurrets, 
		gateFRUnits, gateFRWalls;
		
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
		
		gateFRAmmo = new BMHTechtreeNode("gate-fr-ammo") {{}};
		gateFRBlocks = new BMHTechtreeNode("gate-fr-blocks") {{}};
		gateFRCores = new BMHTechtreeNode("gate-fr-cores") {{}};
		gateFRCoreUnits = new BMHTechtreeNode("gate-fr-core-units") {{}};
		gateFRProduction = new BMHTechtreeNode("gate-fr-crafters") {{}};
		gateFRDistribution = new BMHTechtreeNode("gate-fr-distribution") {{}};
		gateFRDrills = new BMHTechtreeNode("gate-fr-drills") {{}};
		gateFREffectBlocks = new BMHTechtreeNode("gate-fr-effect") {{}};
		gateFRFactories = new BMHTechtreeNode("gate-fr-factories") {{}};
		gateFRFlyingUnits = new BMHTechtreeNode("gate-fr-flying") {{}};
		gateFRItems = new BMHTechtreeNode("gate-fr-items") {{}};
		gateFRGroundUnits = new BMHTechtreeNode("gate-fr-legs") {{}};
		gateFRLiquid = new BMHTechtreeNode("gate-fr-liquids") {{}};
		gateFRMain = new BMHTechtreeNode("gate-fr-main") {{}};
		gateFRNavalUnits = new BMHTechtreeNode("gate-fr-naval") {{}};
		gateFRPower = new BMHTechtreeNode("gate-fr-power") {{}};
		gateFRResources = new BMHTechtreeNode("gate-fr-resources") {{}};
		gateFRTurrets = new BMHTechtreeNode("gate-fr-turrets") {{}};
		gateFRUnits = new BMHTechtreeNode("gate-fr-units") {{}};
		gateFRWalls = new BMHTechtreeNode("gate-fr-walls") {{}};
    }
}


