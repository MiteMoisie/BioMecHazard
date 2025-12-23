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
import static biomechazard.content.blocks.BMHBlocksUtility.*;
import static biomechazard.content.blocks.BMHBlocksProduction.*;
//import static biomechazard.content.blocks.BMHBlocksTurret.*;
import static biomechazard.content.blocks.UAWBlocksDefense.*;
import static biomechazard.content.blocks.UAWBlocksPower.*;
import static biomechazard.content.blocks.UAWBlocksLogistic.*;
import static biomechazard.content.blocks.UAWBlocksProduction.*;
import static biomechazard.content.blocks.UAWBlocksUnits.*;
import static biomechazard.content.blocks.FRBlocksOthers.*;
import static biomechazard.content.blocks.FRBlocksLogistic.*;
//import static biomechazard.content.blocks.FRBlocksAttack.*;
import static biomechazard.content.blocks.FRBlocksProduction.*;
import static biomechazard.content.blocks.FRBlocksDefense.*;
import static biomechazard.content.blocks.FRBlocksLiquid.*;
import static biomechazard.content.blocks.FRBlocksPower.*;
import static biomechazard.content.blocks.FRBlocksTrading.*;
import static biomechazard.content.blocks.FRBlocksDrills.*;
//import static biomechazard.content.BMHBlocks.*;
import static biomechazard.content.BMHUnits.*;
import static biomechazard.content.BMHItems.*;
import static biomechazard.content.BMHLiquids.*;
import static biomechazard.content.UAWUnitTypes.*;
import static biomechazard.content.FRUnitTypes.*;

public class BMHTechtree {
    public static void load(){
		
		nodeRoot("Quarkhod", gateQuarkhod, () -> {
			
			// Secteurs
			node(gateSector);
			
			// Noyau  
			node(gateCore, () -> {
				node(coreNexus, Seq.with(new Research(coreNucleus)), () -> {
					node(coreNetwork);
					node(coreNethrax);
				});
			});
			
			// Unités de noyau
			node(gateCoreUnit, () -> {
				node(delta, () -> {
					node(epsilon);
					node(mokuge);
				});
			});
			
			// Objets//nodeProduce(livingSteel);
			node(gateItem, () -> {
				nodeProduce(steam, () -> {
					nodeProduce(anthracite, () -> {
						nodeProduce(stoutsteel, () -> {});
					});
					nodeProduce(cryogel, () -> {});
				});
				nodeProduce(cryogenicGel, () -> {
					nodeProduce(igneousAlloy, () -> {
						nodeProduce(cryogenicAlloy, () -> {});
					});
				});
				nodeProduce(livingSteel, () -> {
					nodeProduce(livingSteelLiquid, () -> {
						nodeProduce(hardenedLivingSteel, () -> {
							nodeProduce(neutronFluid, () -> {});
							nodeProduce(steelAmalgam, () -> {});
						});
					});
				});
				nodeProduce(gold, () -> {
					nodeProduce(uraniumRod, () -> {});
				});
				nodeProduce(waterVapor, () -> {
					nodeProduce(acid, () -> {});
				});
			});
			
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
			node(gateCrafting, () -> {
				node(livingSteelManufacturingIndustrialComplex, Seq.with(new Research(Items.thorium)), () -> {});
			});
			
			// Génération d'énergie
			node(gatePower);
			
			// Utilitaires
			node(gateUtil, () -> {
				node(overclockedOverdriveDome, Seq.with(new Research(overdriveDome)), () -> {});
				node(recyclingComplex);
				node(constructionPrinter, Seq.with(new Research(mendProjector)), () -> {});
			});
			
			// Systèmes logiques
			node(gateLogic);
			
			// Murs
			node(gateWall);
			
			// Tours de défense
			node(gateTurret, () -> {
				node(gateTurretPrecisionShot);
				node(gateTurretArtillery);
				node(gateTurretMachineGun);
				node(gateTurretShotgun);
				node(gateTurretEnergy);
				node(gateTurretMissileLauncher);
			});
			
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
								node(petroleumCrucible);
								node(plastFabricator);
							});
						});
					});
					node(steamPump, Seq.with(new Research(rotaryPump)), () -> {
						node(pulsometerPump, () -> {
							node(oilDerrick, Seq.with(new Research(oilExtractor)), () -> {});
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
					node(stoutSteelWallLarge, Seq.with(new Research(forceProjector)), () -> {
						node(shieldWall);
					});
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
		
		nodeRoot("Fading Revelations", gateFRMain, () -> {
			
			// Blocs
			node(gateFRBlocks, () -> {
				// Noyau  
				node(gateFRCores, () -> {
					node(coreAtom, () -> {
						node(coreElement, () -> {
							node(mainCore);
						});
					});
				});
				// Usines de fabrication
				node(gateFRProduction, () -> {
					node(copperAmmocrafter, () -> {
						node(titaniumAmmocrafter, () -> {
							node(explosiveAmmocrafter, () -> {
								node(healingAmmocrafter, () -> {
									node(homingAmmocrafter, () -> {
										node(nanobotAmmocrafter, () -> {
											node(nukeCrafter);
										});
									});
								});
							});
						});
					});
					node(livingSteelInfusionChamber, () -> {
						node(livingSteelLiquifyingChamber, () -> {
							node(livingSteelHardeningChamber, () -> {
								node(livingSteelHardeningForge);
							});
							node(livingSteelLiquifyingForge);
						});
						node(livingSteelForge);
					});
					node(invertedPulverizer, () -> {
						node(powderizer, () -> {
							node(inducedKiln, () -> {
								node(greenhouse, () -> {
									node(pyratiteForge, () -> {
										node(blastForge, () -> {
											node(graphiteForge, () -> {
												node(coalCondenser, () -> {
													node(plastaniumForge, () -> {
														node(phaseFabricForge, () -> {
															node(advancedSeperator);
														});
														node(uraniumrodCrafter);
													});
													node(surgeAlloyForge, () -> {
														node(amalgamSmelter, () -> {
															node(amalgamForge);
														});
														node(cryogenicGelMixer, () -> {
															node(igneousAlloySmelter, () -> {
																node(cryogenicAlloyFusingBasin);
															});
														});
													});
												});
											});
										});
									});
									node(sporeCrusher);
								});
								node(siliconForge, () -> {
									node(basicMultismelter);
								});
							});
						});
					});
					node(steamCondenser, () -> {
						node(dissolver, () -> {
							node(acidVat, () -> {
								node(acidEmulsifier);
							});
							node(advancedWaterExtractor, () -> {
								node(advancedCryofluidMixer);
								node(neutronBlender);
							});
						});
					});
				});
				// Distributions d'objets
				node(gateFRDistribution, () -> {
					node(titaniumJunction, () -> {
						node(titaniumRouter, () -> {
							node(titaniumBridgeConveyor, () -> {
								node(advancedUnloader, () -> {
									node(tinyMassDriver, () -> {
										node(massAccelerator);
									});
								});
							});
							node(surgeAlloyConveyor, () -> {
								node(amalgamConveyor);
								node(surgeBridgeConveyor);
							});
							node(titaniumDistributor);
						});
					});
				});
				// Récolteurs d'objets
				node(gateFRDrills, () -> {
					node(groundGrinder, () -> {
						node(groundMiller, () -> {
							node(groundCrusher, () -> {
								node(oilBore);
							});
						});
					});
					node(mechanicalSieve, () -> {
						node(pneumaticSieve, () -> {
							node(titaniumSieve, () -> {
								node(steelSieve);
							});
						});
					});
					node(tinyMechanicalDrill, () -> {
						node(tinyPneumaticDrill, () -> {
							node(titaniumDrill, () -> {
								node(compactLaserDrill, () -> {
									node(hyperDrill);
								});
							});
						});
					});
				});
				// Utilitaires
				node(gateFREffectBlocks, () -> {
					node(depository, () -> {
						node(FRBlocksLogistic.advancedLaunchPad, Seq.with(new SectorComplete(extractionOutpost)), () -> {});
						node(outpost);
					});
					node(copperTradingStation, () -> {
						node(titaniumTradingStation, () -> {
							node(thoriumTradingStation);
						});
					});
					node(leadTradingStation, () -> {
						node(coalTradingStation, () -> {
							node(graphiteTradingStation);
							node(siliconTradingStation, () -> {
								node(pyratiteTradingStation, () -> {
									node(blastCompoundTradingStation);
								});
							});
						});
						node(sandTradingStation, () -> {
							node(metaglassTradingStation);
							node(plastaniumTradingStation, () -> {
								node(phaseFabricTradingStation, () -> {
									node(surgeAlloyTradingStation);
								});
							});
						});
						node(sporePodTradingStation);
						node(miniOverdriveDome, () -> {
							node(constructionPylon);
							node(enhancedMendProjector, () -> {
								node(darkMender, () -> {
									node(forceDome);
								});
							});
						});
					});
				});
				// Conduits de fluides
				node(gateFRLiquid, () -> {
					node(liquidCanister, () -> {
						node(steelTank, () -> {
							node(plastaniumConduit);
							node(steelPump);
						});
					});
				});
				// Génération d'énergie
				node(gateFRPower, () -> {
					node(reinforcedPowerNode, () -> {
						node(reinforcedLargePowerNode, () -> {
							node(advancedSurgeTower);
							node(powerReserve);
						});
					});
					node(tinyThermalGenerator, () -> {
						node(livingSteelThermalGenerator, () -> {
							node(slagGenerator, () -> {
								node(pyratiteGenerator);
							});
						});
						node(waterVaporTurbine);
						node(titaniumSolarPanel, () -> {
							node(advancedSolarPanel, () -> {
								node(solarArray);
								node(nuclearReactor, () -> {
									node(amalgamGenerator, () -> {
										node(overloadReactor);
									});
								});
							});
						});
					});
				});
				// Tours de défense
				node(gateFRTurrets);
				// Murs
				node(gateFRWalls, () -> {
					node(copperWallHuge, () -> {
						node(copperWallGigantic, () -> {
							node(titaniumWallHuge, () -> {
								node(armoredDoor, () -> {
									node(doorHuge, () -> {
										node(doorGigantic);
									});
								});
								node(plastaniumWallHuge, () -> {
									node(plastaniumWallGigantic);
								});
								node(thoriumWallHuge, () -> {
									node(surgeAlloyWallHuge, () -> {
										node(phaseWallHuge, () -> {
											node(phaseWallGigantic);
										});
										node(surgeAlloyWallGigantic);
									});
									node(thoriumWallGigantic);
								});
								node(titaniumWallGigantic);
							});
						});
						node(livingSteelWall, () -> {
							node(livingSteelWallLarge, () -> {
								node(amalgamWall, () -> {
									node(amalgamWallLarge);
								});
							});
						});
					});
					
				});
			});
			
			// Objets
			node(gateFRItems, () -> {
				// Ressources
				node(gateFRResources, () -> {
					nodeProduce(cryogenicGel, () -> {
						nodeProduce(igneousAlloy, () -> {
							nodeProduce(cryogenicAlloy, () -> {});
						});
					});
					nodeProduce(uraniumRod, () -> {
						nodeProduce(nuke, () -> {});
					});
					nodeProduce(gold, () -> {});
					nodeProduce(livingSteel, () -> {
						nodeProduce(hardenedLivingSteel, () -> {});
						nodeProduce(livingSteelLiquid, () -> {
							nodeProduce(acid, () -> {});
							nodeProduce(neutronFluid, () -> {});
						});
						nodeProduce(steelAmalgam, () -> {});
					});
					nodeProduce(waterVapor, () -> {});
				});
				// Munitions
				nodeProduce(gateFRAmmo, () -> {
					nodeProduce(copperAmmo, () -> {
						nodeProduce(titaniumAmmo, () -> {
							nodeProduce(explosiveAmmo, () -> {
								nodeProduce(healingAmmo, () -> {
									nodeProduce(homingAmmo, () -> {
										nodeProduce(nanoAmmo, () -> {});
									});
								});
							});
						});
					});
				});
			});
			
			// Unités
			node(gateFRUnits, () -> {
				// Unités de noyau
				node(gateFRCoreUnits, () -> {
					node(deltaFR, () -> {
						node(epsilonFR, () -> {
							node(mainCoreUnit);
						});
					});
				});
				// Usines de fabrication d'unités
				node(gateFRFactories);
				// Unités terrestres
				node(gateFRGroundUnits);
				// Unités aériennes
				node(gateFRFlyingUnits);
				// Unités navales
				node(gateFRNavalUnits);
			});
		});
	}
}


