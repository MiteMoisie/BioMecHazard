package biomechazard.content;

import arc.*;
import arc.struct.*;
import arc.struct.Seq;
import mindustry.content.*;
import mindustry.content.SectorPresets;
import mindustry.game.Objectives.*;
import biomechazard.content.blocks.*;

import static mindustry.content.Blocks.*;
import static mindustry.content.TechTree.*;
import static mindustry.content.SectorPresets.*;
import static mindustry.game.Objectives.*;
import static mindustry.content.Items.*;
import static mindustry.content.Liquids.*;
import static biomechazard.content.blocks.BMHTechtreeNodes.*;
import static biomechazard.content.blocks.BMHBlocksStorage.*;
import static biomechazard.content.blocks.BMHBlocksLogistic.*;
//import static biomechazard.content.blocks.BMHBlocksTurret.*;
import static biomechazard.content.blocks.UAWBlocksDefense.*;
import static biomechazard.content.blocks.UAWBlocksPower.*;
import static biomechazard.content.blocks.UAWBlocksLogistic.*;
import static biomechazard.content.blocks.UAWBlocksProduction.*;
import static biomechazard.content.blocks.UAWBlocksUnits.*;
import static biomechazard.content.BMHBlocks.*;
import static biomechazard.content.BMHUnits.*;
import static biomechazard.content.BMHItems.*;
import static biomechazard.content.BMHLiquids.*;
import static biomechazard.content.UAWUnitTypes.*;

public class BMHTechtree {
    public static void load(){
		
		nodeRoot("Quarkhod", gateQuarkhod, () -> {
			
			// Secteurs
			node(gateSector);
			
			// Noyau  
			node(gateCore, () -> {
				node(coreNethrax, Seq.with(new Research(coreNucleus)), () -> {
				});
			});
			
			// Unités de noyau
			node(gateCoreUnit, () -> {
				node(mokuge);
			});
			
			// Objets
			node(gateItem);
			
			// Récolteurs d'objets
			node(gateDrill);
			
			// Distributions d'objets
			node(gateDistribution, () -> {
				node(itemsLaunchPad, Seq.with(new SectorComplete(extractionOutpost)), () -> {
				});
				node(enhancedUnloader, Seq.with(new Research(unloader)), () -> {
					node(highOutputUnloader);
				});
				node(enhancedContainer, Seq.with(new Research(container)), () -> {
					node(enhancedVault, Seq.with(new Research(vault)), () -> {
						node(warehouse, Seq.with(new Research(coreNucleus)), () -> {
							node(largeWarehouse, Seq.with(new Research(coreNethrax)), () -> {
							});
						});
					});
				});
			});
			
			// Conduits de fluides
			node(gateDuct);
			
			// Usines de fabrication
			node(gateCrafting);
			
			// Génération d'énergie
			node(gatePower);
			
			// Utilitaires
			node(gateUtil);
			
			// Systèmes logiques
			node(gateLogic);
			
			// Murs
			node(gateWall);
			
			// Tours de défense
			node(gateTurret);
			
			// Usines de fabrication d'unités
			node(gateUnitFactory);
			
			// Unités terrestres
			node(gateGroundUnit);
			
			// Unités aériennes
			node(gateAirUnit);
			
			// Unités navales
			node(gateNavalUnit);
		});
		
		nodeRoot("Unlimited Armament Works", gateUAWStart, () -> {
			// Objets et fluides
			nodeProduce(steam, () -> {
				nodeProduce(oil, () -> {
					nodeProduce(anthracite, () -> {
						nodeProduce(stoutsteel, () -> {
						});
					});
					nodeProduce(Liquids.cryofluid, () -> {
						nodeProduce(cryogel, () -> {
						});
					});
				});
			});
			// Récolteurs d'objets | Distributions d'objets | Conduits de fluides | Usines de fabrication | Génération d'énergie
			node(gateUAWCrafting, () -> {
				node(steamKettle, Seq.with(new Research(mechanicalPump)), () -> {
					node(industrialBoiler, () -> {
						node(pressureBoiler);
						node(geothermalBoiler);
						node(steamTurbine, () -> {
							node(advancedSteamTurbine);
						});
					});
					node(steamDrill, () -> {
						node(advancedSteamDrill);
						node(steamPress, Seq.with(new Research(multiPress)), () -> {
						});
						node(steamThumper, () -> {
							node(alloyCrucible, () -> {
							});
						});
					});
					node(steamPump, Seq.with(new Research(rotaryPump)), () -> {
						node(pulsometerPump, () -> {
							node(pressurizedConduit, Seq.with(new Research(platedConduit), new Produce(stoutsteel)), () -> {
								node(platedPressurizedConduit);
								node(pressurizedLiquidRouter, () ->
									node(pressurizedLiquidJunction, () ->
										node(pressurizedLiquidBridge)
									));
							});
						});
						node(gelatinizer, Seq.with(new Research(cryofluidMixer)), () -> {
							node(cryofluidBlender);
						});
					});
				});
			});
			// Tours de défense (artillery energy machine-gun missile-launcher shotcannon snipers)
			node(gateUAWTurret, () -> {
				node(gateUAWTurretART, () -> {
					node(zounderkite, Seq.with(new Research(quadra), new Research(ashlock), new Research(salvo)), () -> {
						node(skyhammer, Seq.with(new Research(ripple)), () -> {
						});
					});
				});
				node(gateUAWTurretEN);
				node(gateUAWTurretMG, () -> {
					node(quadra, () -> {
						node(spitfire);
					});
				});
				node(gateUAWTurretMSL);
				node(gateUAWTurretSG, () -> {
					node(buckshot);
					node(tempest);
					node(strikeforce);
				});
				node(ashlock, () -> {
					node(longbow, () -> {
						node(deadeye);
					});
				});
			});
			// Murs
			node(gateUAWDefence, () -> {
				node(stoutSteelWall, () -> {
					node(stoutSteelWallLarge);
				});
			});
			// Usines de fabrication d'unités | Unités terrestres | Unités aériennes | Unités navales
			node(airGroundFactory, () -> {
				node(crotchety, () -> {
					node(cantankerous, Seq.with(new Research(gelatinizer)), () -> {
					});
				});
				node(aglovale, () -> {
					node(bedivere, () -> {
						node(calogrenant, () -> {
						});
					});
				});
				node(cavalier, Seq.with(new Research(crotchety)), () -> {
					node(centurion, () -> {
						node(caernarvon);
					});
				});
				node(UAWBlocksUnits.navalFactory, () -> {
					node(megaera, () -> {
						node(alecto);
					});
					node(arquebus, () -> {
						node(carronade, () -> {
							node(falconet);
						});
					});
				});
				node(exponentialPetroleumReconstructor, () -> {
					node(tetrativePetroleumReconstructor);
				});
			});
		});
	}
}
