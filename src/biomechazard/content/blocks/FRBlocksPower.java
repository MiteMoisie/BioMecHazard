package biomechazard.content.blocks;

import arc.audio.Sound;
import arc.graphics.*;
import arc.math.*;
import mindustry.content.*;
import mindustry.entities.effect.*;
import mindustry.world.meta.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.draw.*;
import mindustry.world.blocks.power.*;
import biomechazard.audiovisual.*;
import biomechazard.content.*;

public class FRBlocksPower{
	
	public static Block
		advancedSurgeTower, omnidirectionalBeamNode, powerReserve, reinforcedLargePowerNode, reinforcedPowerNode;
	
	public static void load(){
		
		advancedSurgeTower = new PowerNode("advanced-surge-tower"){{
            requirements(Category.power, with(Items.titanium, 14, Items.lead, 20, Items.silicon, 30, Items.phaseFabric, 25, Items.surgeAlloy, 30));
            size = 3;
            health = 320;
            maxNodes = 2;
            laserRange = 80f;
        }};
		
		omnidirectionalBeamNode = new PowerNode("odr-beam-node"){{
            requirements(Category.power, with(Items.beryllium, 10));
            size = 1;
            maxNodes = 4;
            laserRange = 10f;
            health = 90;
			//powerCapacity = 1000; //N'existe pas dans l'API. Signification dans le json inconnue.
			laserColor1 = Color.valueOf("92dd7e");
			laserColor2 = Color.valueOf("ffffff");
			laserScale = 0.6f;
			researchCostMultiplier = 0.2;
        }};
		
		powerReserve = new Battery("power-reserve"){{
            requirements(Category.power, with(Items.titanium, 120, Items.lead, 300, Items.silicon, 100, Items.surgeAlloy, 25));
            size = 6;
            health = 1480;
            consumePowerBuffered(500000f);
        }};
		
		reinforcedLargePowerNode = new PowerNode("reinforced-large-power-node"){{
            requirements(Category.power, with(Items.titanium, 6, Items.lead, 12, Items.silicon, 5));
            size = 2;
            maxNodes = 15;
            laserRange = 18f;
            health = 480;
        }};
		
		reinforcedPowerNode = new PowerNode("reinforced-power-node"){{
            requirements(Category.power, with(Items.titanium, 1, Items.lead, 2, Items.copper, 1));
            size = 1;
            maxNodes = 10;
            laserRange = 8f;
            health = 120;
		}};
		
		advancedSolarPanel = new SolarGenerator("advanced-solar-panel"){{
            requirements(Category.power, with(Items.lead, 160, Items.silicon, 220, Items.phaseFabric, 40));
            size = 3;
            powerProduction = 2.5f;
			health = 120;
			hasPower = true;
			hasLiquids = false;
        }};
		
		livingSteelThermalGenerator = new ThermalGenerator("ls-gen"){{
            requirements(Category.power, with(Items.copper, 50, Items.graphite, 45, Items.lead, 60, Items.metaglass, 50, Items.livingSteel, 35));
            attribute = Attribute.heat;
			powerProduction = 3f;
            size = 2;
			health = 240;
            generateEffect = new ParticleEffect(){{
				particles = 8;
				length = 10f;
				colorFrom = Color.valueOf("6d0071");
				colorTo = Color.valueOf("8c0291");
				interp = Interp.circleOut;
			}};
        }};
		
		overloadReactor = new ConsumeGenerator("overload-reactor"){{
            requirements(Category.power, 
				with(Items.copper, 2500, Items.lead, 2200, Items.graphite, 1800, Items.metaglass, 1600, 
				Items.silicon, 1500, Items.thorium, 1100, BMHItems.steelAmalgam, 400));
            size = 10;
			hasPower = true;
			hasItems = true;
            hasLiquids = true;
			health = 1500;
			outputLiquid = new LiquidStack(Liquids.slag, 0.1f);
			liquidCapacity = 60f;
			itemCapacity = 50;
			explodeOnFull = true;
            powerProduction = 400f;
			consumeItem(BMHItems.steelAmalgam, 2);
            itemDuration = 420f;
            //consume(new ConsumeItemFlammable());
            //consume(new ConsumeItemExplode());
            drawer = new DrawMulti(
				new DrawRegion("-bottom"), 
				new DrawLiquidTile(Liquids.slag), 
				new DrawCircles(){{
					color = Color.valueOf("ffc073");
					strokeMax = 6f;
					radius = 30f;
					amount = 5;
				}}, 
				new DrawSpikes(){{
					color = Color.valueOf("ffd59e");
					stroke = 2f;
					layers = 2;
					amount = 12;
					rotateSpeed = 0.1f;
					layerSpeed = -0.9f;
					length = 30f;
				}}, 
				new DrawParticles(){{
					color = Color.valueOf("ffc073");
					alpha = 0.6f;
					particleSize = 6f;
					particles = 32;
					particleRad = 75f;
					particleLife = 140f;
				}}, 
				new DrawBlurSpin("-rotator", 26f), 
				new DrawDefault()
            );
        }};
		
		pyratiteGenerator = new ConsumeGenerator("pyratite-generator"){{
            requirements(Category.power, with(Items.copper, 200, Items.lead, 150, Items.silicon, 90, Items.titanium, 75, Items.plastanium, 50));
			size = 2;
			hasPower = true;
			hasItems = true;
			itemDuration = 60f;
			powerProduction = 12f;
			consumeItem(Items.pyratite, 1);
        }};
		
		slagGenerator = new ConsumeGenerator("slag-generator"){{
            requirements(Category.power, with(Items.copper, 120, Items.lead, 100, Items.graphite, 60, Items.metaglass, 50, Items.titanium, 40));
			size = 3;
			health = 785;
			consumeEffect = Fx.surgeCruciSmoke;
			explodeOnFull = false;
			itemDuration = 60f;
			consumeLiquid(Liquids.slag, 0.33333f);
			powerProduction = 6.8f;
			hasLiquids = true;
			liquidCapacity = 100;
			drawer = new DrawMulti(
				new DrawRegion("-bottom"), 
				new DrawLiquidTile(Liquids.slag), 
				new DrawCircles(){{
					color = Color.valueOf("ffc073");
					strokeMax = 1f;
					radius = 10f;
					amount = 3;
				}}, 
				new DrawBlurSpin("-rotator", 0.5f), 
				new DrawDefault()
            );
        }};
		
		slagReactor = new ConsumeGenerator("slag-reactor"){{
            requirements(Category.power, with(Items.beryllium, 60, Items.tungsten, 20, Items.graphite, 50, Items.silicon, 40));
			size = 3;
			health = 785;
			consumeEffect = Fx.surgeCruciSmoke;
			explodeOnFull = false;
			itemDuration = 60f;
			consumeLiquid(Liquids.slag, 0.33333f);
			powerProduction = 7f;
			hasLiquids = true;
			liquidCapacity = 100;
			drawer = new DrawMulti(
				new DrawRegion("-bottom"), 
				new DrawLiquidTile(Liquids.slag), 
				new DrawCircles(){{
					color = Color.valueOf("ffc073");
					strokeMax = 1f;
					radius = 10f;
					amount = 3;
				}}, 
				new DrawBlurSpin("-rotator", 0.5f), 
				new DrawDefault()
            );
			effectChance = 1f;
        }};
		
		solarArray = new SolarGenerator("solar-array"){{
            requirements(Category.power, with(Items.lead, 320, Items.silicon, 440, Items.phaseFabric, 80));
            health = 620;
			size = 6;
            powerProduction = 25f;
			hasPower = true;
			hasLiquids = false;
        }};
		
		steamTurbine = new ConsumeGenerator("steam-turbine"){{
            requirements(Category.power, with(Items.copper, 60, Items.lead, 60, Items.graphite, 35, Items.silicon, 40, BMHItems.livingSteel, 20));
            outputLiquid = new LiquidStack(BMHLiquids.waterVapor, 0.05f);
			explodeOnFull = true;
			powerProduction = 13.33333f;
            itemDuration = 120f;
			consumeLiquid(Liquids.water, 0.2f);
            hasLiquids = true;
			liquidCapacity = 20f;
			size = 3;
            generateEffect = Fx.generatespark;
			ambientSound = Sounds.smelter;
			ambientSoundVolume = 0.09f;
			drawer = new DrawMulti(
				new DrawDefault(), 
				new DrawWarmupRegion(){{
					color = Color.valueOf("ff9b59");
					sinMag = 1f;
					sinScl = 20f;
				}}, 
				new DrawRegion("-turbine", 2f), 
				new DrawRegion("-turbine", -2f){{
					rotation = 45f;
				}}, 
				new DrawRegion("-cap"), 
				new DrawLiquidRegion(Liquids.water){{
					suffix = "-liquid";
				}}, 
				new DrawLiquidRegion(BMHLiquids.waterVapor){{
					suffix = "-liquid2";
				}}
            );
        }};
		
		amalgamGenerator = new ImpactReactor("steel-reactor"){{
            requirements(Category.power, 
				with(Items.copper, 750, Items.lead, 700, Items.silicon, 350, Items.graphite, 400, 
				Items.thorium, 150, BMHItems.steelAmalgam, 50, Items.metaglass, 350));
            size = 4;
            health = 1100;
			hasLiquids = true;
			hasPower = true;
			hasItems = true;
            powerProduction = 270f;
			itemCapacity = 30;
            itemDuration = 360f;
            liquidCapacity = 200f;
            consumePower(20f);
            consumeItem(BMHItems.steelAmalgam, 1f);
            consumeLiquid(Liquids.cryofluid, 0.1f);
			explosionDamage = 4000;
			explosionRadius = 320;
			explosionShake = 15f;
			explodeSound = BMHSoundEffects.nrexp;
			lightColor = Color.valueOf("000000");
        }};
		
		tinyThermalGenerator = new ThermalGenerator("tiny-thermal-gen"){{
            requirements(Category.power, with(Items.copper, 10, Items.graphite, 8, Items.lead, 15, Items.silicon, 8, Items.metaglass, 10));
            attribute = Attribute.heat;
			powerProduction = 1.6f;
            drawer = new DrawMulti(
				new DrawRegion("-bottom"), 
				new DrawCrucibleFlame(), 
				new DrawDefault()
            );
        }};
		
		titaniumSolarPanel = new SolarGenerator("titanium-panel"){{
            requirements(Category.power, with(Items.lead, 20, Items.silicon, 20, Items.titanium, 10));
            size = 2;
            powerProduction = 0.4f;
            health = 90;
			hasPower = true;
            hasLiquids = false;
        }};
		
		turbineConcentrator = new ThermalGenerator("turbine-concentrator"){{
            requirements(Category.power, with(Items.beryllium, 90, Items.graphite, 75));
            size = 3;
            attribute = Attribute.steam;
            displayEfficiencyScale = 1f;
            minEfficiency = 0.0001f;
            powerProduction = 0.48f;
            displayEfficiency = false;
            generateEffect = Fx.turbinegenerate;
            effectChance = 0.05f;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.08f;
			hasLiquids = true;
            outputLiquid = new LiquidStack(Liquids.water, 0.015f);
            fogRadius = 3;
			liquidCapacity = 20f;
            researchCost = with(Items.beryllium, 180, Items.graphite, 150);
            drawer = new DrawMulti(new DrawDefault(), new DrawBlurSpin("-rotator", 5.8f){{
                blurThresh = 0.01f;
            }});
        }};
		
		nuclearReactor = new NuclearReactor("uranium-reactor"){{
            requirements(Category.power, 
				with(Items.copper, 1000, Items.lead, 900, Items.silicon, 500, Items.graphite, 750, Items.thorium, 1200, 
				Items.titanium, 800, Items.metaglass, 500));
            size = 4;
			hasPower = true;
			hasLiquids = true;
			hasItems = true;
			//explodeOnFull = true;
			explosionShake = 10f;
			explodeSound = BMHSoundEffects.nrexp;
			explosionRadius = 500;
			explosionDamage = 10000;
			itemCapacity = 20;
			liquidCapacity = 120f;
			itemDuration = 1650f;
			powerProduction = 330f;
			heating = 0.02f;
			smokeThreshold = 0.58f;
			flashThreshold = 0.4f;
			coolantPower = 0.5f;
			fuelItem = BMHItems.uraniumRod;
            consumeLiquid(BMHLiquids.livingSteelLiquid, 0.08f);
            consumeItem(BMHItems.uraniumRod, 9);
        }};
		
	}

}
