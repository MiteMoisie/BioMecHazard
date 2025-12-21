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

public class FRBlocksProduction{
	public static Block 
		livingSteelInfusionChamber, livingSteelForge, livingSteelLiquifyingChamber, livingSteelLiquifyingForge, livingSteelHardeningChamber, 
		livingSteelHardeningForge, steamCondenser, dissolver, acidVat, acidEmulsifier, advancedWaterExtractor, advancedCryofluidMixer, neutronBlender, 
		copperAmmocrafter, titaniumAmmocrafter, explosiveAmmocrafter, healingAmmocrafter, homingAmmocrafter, nanobotAmmocrafter, nukeCrafter, 
		uraniumrodCrafter, amalgamSmelter, amalgamForge, cryogenicGelMixer, igneousAlloySmelter, cryogenicAlloyFusingBasin, invertedPulverizer, 
		powderizer, inducedKiln, siliconForge, basicMultismelter, sporeCrusher, greenhouse, pyratiteForge, blastForge, graphiteForge, coalCondenser, 
		plastaniumForge, surgeAlloyForge, phaseFabricForge, advancedSeperator;
	
	public static void load(){
		
		livingSteelInfusionChamber = new GenericCrafter("living-steel-infuser"){{
            requirements(Category.crafting, with(Items.copper, 150, Items.lead, 120, Items.titanium, 50));
            craftEffect = Fx.smeltsmoke;
			updateEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(BMHItems.livingSteel, 2);
            craftTime = 50f;
            size = 2;
			health = 140;
            hasPower = true;
			hasItems = true;
            hasLiquids = false;
            consumeItems(with(Items.titanium, 2, Items.sporePod, 1));
            consumePower(0.8f);
        }};
		
		livingSteelForge = new GenericCrafter("living-steel-forge"){{
            requirements(Category.crafting, with(Items.copper, 460, Items.lead, 320, Items.titanium, 145));
            craftEffect = Fx.smeltsmoke;
			updateEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(BMHItems.livingSteel, 3);
            craftTime = 40f;
            size = 3;
			health = 285;
            hasPower = true;
			hasItems = true;
            hasLiquids = false;
            consumeItems(with(Items.titanium, 2, Items.sporePod, 1));
            consumePower(1.4f);
			drawer = new DrawMulti(new DrawDefault(), new DrawCrucibleFlame(){{flameColor = Color.valueOf("9e78dc"); midColor = Color.valueOf("8c0291");}});
        }};
		
		livingSteelLiquifyingChamber = new GenericCrafter("living-steel-liquifier"){{
            requirements(Category.crafting, with(Items.copper, 150, Items.lead, 120, Items.titanium, 50));
            craftEffect = Fx.smeltsmoke;
			updateEffect = Fx.smeltsmoke;
            outputLiquid = new LiquidStack(BMHLiquids.livingSteelLiquid, 0.2f);
            craftTime = 50f;
            size = 2;
			health = 160;
            hasPower = true;
			hasItems = true;
            hasLiquids = false;
            consumeItems(with(BMHItems.livingSteel, 1));
            consumePower(0.8f);
			consumeLiquid(Liquids.oil, 0.3f);
        }};
		
		livingSteelLiquifyingForge = new GenericCrafter("living-steel-liquifying-forge"){{
            requirements(Category.crafting, with(Items.copper, 460, Items.lead, 320, Items.titanium, 145, BMHItems.livingSteel, 100));
            craftEffect = Fx.smeltsmoke;
			updateEffect = Fx.smeltsmoke;
            outputLiquid = new LiquidStack(BMHLiquids.livingSteelLiquid, 0.4f);
            craftTime = 50f;
            size = 3;
			health = 285;
            hasPower = true;
			hasItems = true;
            hasLiquids = true;
            consumeItems(with(BMHItems.livingSteel, 2));
            consumePower(1.4f);
			consumeLiquid(Liquids.oil, 0.6f);
			drawer = new DrawMulti(new DrawDefault(), new DrawCrucibleFlame(){{flameColor = Color.valueOf("61615b"); midColor = Color.valueOf("313131");}});
        }};
		
		livingSteelHardeningChamber = new GenericCrafter("living-steel-hardener"){{
            requirements(Category.crafting, with(Items.copper, 150, Items.lead, 120, Items.titanium, 50));
            craftEffect = Fx.smeltsmoke;
			updateEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(BMHItems.hardenedLivingSteel, 2);
            craftTime = 50f;
            size = 2;
			health = 160;
            hasPower = true;
			hasItems = true;
            hasLiquids = false;
            consumeItems(with(BMHItems.livingSteel, 1, Items.thorium, 2));
            consumePower(0.8f);
        }};
		
		livingSteelHardeningForge = new GenericCrafter("living-steel-hardening-forge"){{
            requirements(Category.crafting, with(Items.copper, 460, Items.lead, 320, Items.titanium, 145));
            craftEffect = Fx.smeltsmoke;
			updateEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(BMHItems.hardenedLivingSteel, 3);
            craftTime = 40f;
            size = 3;
			health = 285;
            hasPower = true;
			hasItems = true;
            hasLiquids = false;
            consumeItems(with(BMHItems.livingSteel, 1, Items.thorium, 2));
            consumePower(1.4f);
			drawer = new DrawMulti(new DrawDefault(), new DrawCrucibleFlame(){{flameColor = Color.valueOf("8471dc"); midColor = Color.valueOf("6d5ac6");}});
        }};
		
		steamCondenser = new GenericCrafter("steam-condenser"){{
            requirements(Category.crafting, with(Items.copper, 60, Items.lead, 35));
            outputLiquid = new LiquidStack(BMHLiquids.waterVapor, 0.0125f);
            craftTime = 300f;
            size = 2;
			scaledHealth = 60;
			drawer = new DrawMulti(
				new DrawRegion("-bottom"), 
				new DrawLiquidTile(BMHLiquids.waterVapor), 
				new DrawBubbles(Color.valueOf("e9e9e9")){{
                    fill = true;
                    timeScl = 40f;
                    amount = 4;
                }},
				new DrawDefault()
			);
        }};
		
		dissolver = new GenericCrafter("dissolver"){{
            requirements(Category.crafting, with(Items.copper, 60, Items.lead, 70, Items.graphite, 50));
            outputLiquid = new LiquidStack(Liquids.slag, 0.25f);
            craftTime = 10f;
			consumePower(1.2f);
			consumeItems(with(Items.scrap, 1));
			hasPower = true;
			hasItems = true;
			hasLiquids = true;
			itemCapacity = 20;
			liquidCapacity = 25f;
            size = 2;
			drawer = new DrawMulti(
				new DrawRegion("-bottom"), 
				new DrawLiquidTile(Liquids.slag), 
				new DrawDefault()
			);
        }};
		
		acidVat = new GenericCrafter("acid-vat"){{
            requirements(Category.crafting, with(Items.copper, 60, Items.lead, 35));
            outputLiquid = new LiquidStack(BMHLiquids.acid, 0.2f);
			hasPower = true;
			consumePower(1.25f);
			hasItems = true;
			consumeItems(with(Items.lead, 1));
			hasLiquids = true;
			liquidCapacity = 40f;
            craftTime = 30f;
            size = 2;
			drawer = new DrawMulti(
				new DrawRegion("-bottom"), 
				new DrawLiquidTile(BMHLiquids.acid){{alpha = 0.87f;}}, 
				new DrawDefault()
			);
        }};
		
		acidEmulsifier = new GenericCrafter("acid-emulsifier"){{
            requirements(Category.crafting, with(Items.copper, 80, Items.graphite, 40, Items.titanium, 60));
            outputLiquid = new LiquidStack(Liquids.oil, 0.4f);
			hasPower = true;
			consumePower(1.5f);
			hasLiquids = true;
			liquidCapacity = 60f;
			consumeLiquid(BMHLiquids.acid, 0.4f);
            craftTime = 20f;
            size = 2;
			drawer = new DrawMulti(
				new DrawRegion("-bottom"), 
				new DrawLiquidTile(BMHLiquids.acid){{alpha = 0.87f;}}, 
				new DrawBubbles(Color.valueOf("cde03a")){{
                    fill = true;
                    amount = 10;
					sides = 8;
					strokeMin = 0.7f;
                }},
				new DrawDefault()
			);
        }};
		
		advancedWaterExtractor = new SolidPump("advanced-water-extractor"){{
            requirements(Category.production, with(Items.metaglass, 65, Items.graphite, 150, Items.lead, 140, Items.copper, 175));
            result = Liquids.water;
			hasPower = true;
			hasLiquids = true;
            pumpAmount = 0.3f;
            size = 3;
            liquidCapacity = 250f;
            attribute = Attribute.water;
            //envRequired |= Env.groundWater;
            consumePower(3.5f);
			health = 320;
        }};
		
		advancedCryofluidMixer = new GenericCrafter("advanced-cryofluid-mixer"){{
            requirements(Category.crafting, with(Items.graphite, 100, Items.titanium, 100, Items.silicon, 75, Items.thorium, 200));
            outputLiquid = new LiquidStack(Liquids.cryofluid, 0.4f);
			hasPower = true;
			consumePower(1.7f);
			hasLiquids = true;
			liquidCapacity = 70f;
			hasItems = true;
			itemCapacity = 30;
			consumeLiquid(Liquids.water, 0.4f);
			consumeItems(with(Items.titanium, 1));
            craftTime = 60f;
            size = 2;
			health = 340;
			updateEffect = Fx.smeltsmoke;
			drawer = new DrawMulti(
				new DrawRegion("-bottom"), 
				new DrawLiquidTile(Liquids.cryofluid), 
				new DrawSpikes(){{
					color = Color.valueOf("989aa4");
					amount = 4;
					rotateSpeed = 0.6f;
					length = 0.6f;
				}}, 
				new DrawDefault()
			);
        }};
		
		neutronBlender = new GenericCrafter("neutron-blender"){{
            requirements(Category.crafting, with(Items.metaglass, 250, Items.titanium, 220, Items.silicon, 160, BMHItems.livingSteel, 140));
            outputLiquid = new LiquidStack(BMHLiquids.neutronFluid, 0.2f);
			hasPower = true;
			consumePower(2.2f);
			hasLiquids = true;
			liquidCapacity = 120f;
			hasItems = true;
			itemCapacity = 30;
			consumeLiquids(LiquidStack.with(Liquids.oil, 0.2f, Liquids.cryofluid, 0.2f, BMHLiquids.livingSteelLiquid, 0.2f));
			ambientSound = Sounds.spellLoop;
			ambientSoundVolume = 0.4f;
			size = 3;
			drawer = new DrawMulti(
				new DrawRegion("-bottom"), 
				new DrawLiquidTile(BMHLiquids.neutronFluid), 
				new DrawMultiWeave(), 
				new DrawBubbles(Color.valueOf("8c0291")){{
					amount = 6;
					spread = 2f;
					strokeMin = 0.1f;
                }}, 
				new DrawBubbles(Color.valueOf("e9e9e9")){{
					amount = 6;
					spread = 2f;
					strokeMin = 0.1f;
                }}, 
				new DrawBubbles(Color.valueOf("87ceeb")){{
					amount = 6;
					spread = 2f;
					strokeMin = 0.1f;
                }}, 
				new DrawDefault(), 
				new DrawLiquidRegion(Liquids.cryofluid){{ suffix = "-liquid-1"; }}, 
				new DrawLiquidRegion(Liquids.oil){{ suffix = "-liquid-2"; }}, 
				new DrawLiquidRegion(BMHLiquids.livingSteelLiquid){{ suffix = "-liquid-3"; }}
			);
        }};
		
		copperAmmocrafter = new GenericCrafter("ammo-crafter-1"){{
            requirements(Category.crafting, with(Items.copper, 150, Items.lead, 120));
            size = 2;
            craftEffect = Fx.pulverizeRed;
            outputItem = new ItemStack(BMHItems.copperAmmo, 2);
            craftTime = 50f;
            hasItems = true;
            hasLiquids = false;
            hasPower = true;
            consumeItems(with(Items.coal, 1, Items.copper, 2));
			drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawGlowRegion(){{color = Color.valueOf("ffef99");}});
        }};
		
		titaniumAmmocrafter = new GenericCrafter("ammo-crafter-2"){{
            requirements(Category.crafting, with(Items.copper, 150, Items.lead, 120, Items.graphite, 55));
            size = 2;
            craftEffect = Fx.pulverizeRed;
            outputItem = new ItemStack(BMHItems.titaniumAmmo, 2);
            craftTime = 50f;
            hasItems = true;
            hasLiquids = false;
            hasPower = true;
			consumePower(0.15f);
            consumeItems(with(Items.coal, 3, Items.titanium, 2));
			drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawGlowRegion(){{color = Color.valueOf("ffef99");}});
        }};
		
		explosiveAmmocrafter = new GenericCrafter("ammo-crafter-3"){{
            requirements(Category.crafting, with(Items.copper, 150, Items.lead, 120, Items.titanium, 55));
            size = 2;
            craftEffect = Fx.pulverizeRed;
            outputItem = new ItemStack(BMHItems.explosiveAmmo, 2);
            craftTime = 50f;
            hasItems = true;
            hasLiquids = false;
            hasPower = true;
			consumePower(0.2f);
            consumeItems(with(Items.coal, 5, Items.blastCompound, 2));
			drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawGlowRegion(){{color = Color.valueOf("ffef99");}});
        }};
		
		healingAmmocrafter = new GenericCrafter("heal-ammo-crafter"){{
            requirements(Category.crafting, with(Items.copper, 150, Items.lead, 120, Items.titanium, 55));
            size = 2;
            craftEffect = Fx.pulverizeRed;
            outputItem = new ItemStack(BMHItems.healingAmmo, 2);
            craftTime = 50f;
            hasItems = true;
            hasLiquids = false;
            hasPower = true;
			consumePower(0.2f);
            consumeItems(with(Items.coal, 2, Items.sporePod, 2));
			drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawGlowRegion(){{color = Color.valueOf("ffef99");}});
        }};
		
		homingAmmocrafter = new GenericCrafter("homing-ammo-crafter"){{
            requirements(Category.crafting, with(Items.copper, 150, Items.lead, 120, Items.titanium, 55));
            size = 2;
            craftEffect = Fx.pulverizeRed;
            outputItem = new ItemStack(BMHItems.homingAmmo, 2);
            craftTime = 50f;
            hasItems = true;
            hasLiquids = false;
            hasPower = true;
			consumePower(0.2f);
            consumeItems(with(Items.coal, 2, Items.thorium, 2));
			drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawGlowRegion(){{color = Color.valueOf("ffef99");}});
        }};
		
		nanobotAmmocrafter = new GenericCrafter("nano-ammo-crafter"){{
            requirements(Category.crafting, with(Items.copper, 150, Items.lead, 120, Items.graphite, 65, Items.titanium, 55));
            size = 2;
            craftEffect = Fx.pulverizeRed;
            outputItem = new ItemStack(BMHItems.nanoAmmo, 2);
            craftTime = 50f;
            hasItems = true;
            hasLiquids = false;
            hasPower = true;
			consumePower(0.2f);
            consumeItems(with(Items.coal, 5, BMHItems.livingSteel, 2));
			drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawGlowRegion(){{color = Color.valueOf("ffef99");}});
        }};
		
		nukeCrafter = new GenericCrafter("nuke-crafter"){{
            requirements(Category.crafting, with(Items.copper, 1500, Items.lead, 1200, Items.graphite, 1000, Items.surgeAlloy, 600));
            size = 2;
            outputItem = new ItemStack(BMHItems.nuke, 1);
            craftTime = 600f;
            hasItems = true;
			itemCapacity = 60;
            hasLiquids = false;
            hasPower = true;
			consumePower(6f);
            consumeItems(with(Items.graphite, 20, Items.thorium, 10, Items.blastCompound, 10, BMHItems.uraniumRod, 10));
        }};
		
		uraniumrodCrafter = new GenericCrafter("uraniumrod-crafter"){{
            requirements(Category.crafting, with(Items.copper, 200, Items.lead, 150, Items.titanium, 60, Items.thorium, 50));
            size = 2;
            outputItem = new ItemStack(BMHItems.uraniumRod, 3);
            craftTime = 300f;
            hasItems = true;
            hasLiquids = false;
            hasPower = true;
			craftEffect = Fx.smeltsmoke;
			updateEffect = Fx.pulverizeRed;
			consumePower(1.1f);
            consumeItems(with(Items.lead, 3, Items.thorium, 1, Items.plastanium, 2, Items.phaseFabric, 1));
        }};
		
		amalgamSmelter = new GenericCrafter("amalgam-smelter"){{
            requirements(Category.crafting, with(Items.copper, 250, Items.lead, 200, Items.surgeAlloy, 50, BMHItems.livingSteel, 100));
            updateEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(BMHItems.steelAmalgam, 2);
            craftTime = 120f;
            size = 3;
			health = 240;
            hasPower = true;
			hasItems = true;
			itemCapacity = 30;
            hasLiquids = true;
			consumeLiquid(Liquids.slag, 0.2f);
            consumeItems(with(Items.copper, 2, BMHItems.livingSteel, 3, Items.surgeAlloy, 2));
            consumePower(7f);
			drawer = new DrawMulti(
				new DrawDefault(), 
				new DrawGlowRegion("-top"){{
					color = Color.valueOf("f1a397");
				}}, 
				new DrawGlowRegion("-top2"){{
					color = Color.valueOf("dbaf85");
				}}
            );
        }};
		
		amalgamForge = new GenericCrafter("amalgam-forge"){{
            requirements(Category.crafting, with(Items.copper, 360, Items.lead, 300, Items.surgeAlloy, 75, BMHItems.livingSteel, 150));
            updateEffect = Fx.smeltsmoke;
            outputItem = new ItemStack(BMHItems.steelAmalgam, 2);
            craftTime = 75f;
            size = 4;
			health = 740;
            hasPower = true;
			hasItems = true;
			itemCapacity = 30;
            hasLiquids = true;
			consumeLiquid(Liquids.slag, 0.2f);
            consumeItems(with(Items.copper, 2, BMHItems.livingSteel, 3, Items.surgeAlloy, 2));
            consumePower(7.4f);
			drawer = new DrawMulti(
				new DrawDefault(), 
				new DrawGlowRegion("-top"){{
					color = Color.valueOf("f1a397");
				}}, 
				new DrawGlowRegion("-top2"){{
					color = Color.valueOf("dbaf85");
				}}
            );
        }};
		
		cryogenicGelMixer = new GenericCrafter("cryogenic-gel-mixer"){{
            requirements(Category.crafting, with(Items.metaglass, 210, Items.lead, 250, Items.graphite, 200, Items.silicon, 150));
            updateEffectChance = 1f;
			updateEffect = new RadialEffect(){{
				layer = 118f;
				rotationSpacing = 22f;
				amount = 2;
				effect = new ParticleEffect(){{
					particles = 1;
					length = 14f;
					lifetime = 20f;
					cone = 20f;
					useRotation = false;
					baseRotation = 90f;
					sizeFrom = 1f;
					sizeTo = 0f;
					colorFrom = Color.valueOf("8ce8f100");
					colorTo = Color.valueOf("8ce8f188");
					interp = Interp.pow2;
					sizeInterp = Interp.pow3In;
					layer = 80f;
				}};
			}};
            outputItem = new ItemStack(BMHItems.cryogenicGel, 2);
            craftTime = 120f;
            size = 2;
			rotate = false;
            hasPower = true;
			hasItems = true;
			itemCapacity = 30;
            hasLiquids = true;
			liquidCapacity = 100f;
			consumeLiquid(Liquids.cryofluid, 0.8f);
            consumeItems(with(Items.silicon, 12));
            consumePower(3f);
			drawer = new DrawMulti(
				new DrawRegion("-bottom"), 
				new DrawLiquidTile(Liquids.cryofluid){{alpha = 0.5f;}}, 
				new DrawSpikes(){{
					amount = 12;
					layers = 3;
					length = 4f;
					radius = 3f;
					color = Color.valueOf("4fa4c0");
					layerSpeed = 0.34f;
					rotateSpeed = 1.1f;
					stroke = 0.6f;
				}}, 
				new DrawDefault()
            );
			ambientSound = Sounds.spellLoop;
			ambientSoundVolume = 0.2f;
        }};
		
		igneousAlloySmelter = new GenericCrafter("alloy-crafter"){{
            requirements(Category.crafting, with(Items.titanium, 200, Items.lead, 300, Items.graphite, 250, Items.silicon, 220));
            updateEffect = new RadialEffect(){{
				layer = 118f;
				rotationSpacing = 12f;
				amount = 16;
				lengthOffset = 4f;
				effect = new ParticleEffect(){{
					particles = 12;
					length = 18f;
					lifetime = 150f;
					cone = 20f;
					useRotation = false;
					baseRotation = 45f;
					sizeFrom = 3f;
					sizeTo = 0f;
					colorFrom = Color.valueOf("ffffff00");
					colorTo = Color.valueOf("ffffff88");
					interp = Interp.pow2;
					sizeInterp = Interp.pow3In;
					layer = 80f;
				}};
			}};
            outputItem = new ItemStack(BMHItems.igneousAlloy, 8);
            craftTime = 240f;
            size = 2;
			rotate = false;
            hasPower = true;
			hasItems = true;
			itemCapacity = 200;
            hasLiquids = true;
			liquidCapacity = 100f;
			consumeLiquid(Liquids.slag, 0.8f);
            consumeItems(with(Items.surgeAlloy, 16, Items.titanium, 48));
            consumePower(5f);
			drawer = new DrawMulti(
				new DrawRegion("-bottom"), 
				new DrawCrucibleFlame(), 
				new DrawDefault()
            );
			ambientSound = Sounds.smelter;
			ambientSoundVolume = 0.3f;
        }};
		
		cryogenicAlloyFusingBasin = new GenericCrafter("cryogenic-alloy-assembler"){{
            requirements(Category.crafting, 
				with(Items.metaglass, 500, Items.lead, 700, Items.graphite, 600, Items.silicon, 500, Items.surgeAlloy, 260, BMHItems.steelAmalgam, 200));
            updateEffect = new RadialEffect(){{
				layer = 118f;
				rotationSpacing = 12f;
				amount = 22;
				lengthOffset = 4f;
				effect = new ParticleEffect(){{
					particles = 12;
					length = 36f;
					lifetime = 240f;
					cone = 20f;
					useRotation = false;
					baseRotation = 65f;
					sizeFrom = 3f;
					sizeTo = 0f;
					colorFrom = Color.valueOf("ffffff00");
					colorTo = Color.valueOf("ffffff88");
					interp = Interp.pow2;
					sizeInterp = Interp.pow3In;
					layer = 80f;
				}};
			}};
			outputItem = new ItemStack(BMHItems.cryogenicAlloy, 4);
			craftTime = 60f;
			size = 4;
			rotate = false;
            hasPower = true;
			hasItems = true;
			itemCapacity = 200;
            hasLiquids = true;
			liquidCapacity = 100f;
			consumeLiquid(BMHLiquids.neutronFluid, 0.4f);
            consumeItems(with(BMHItems.igneousAlloy, 2, BMHItems.cryogenicGel, 1, Items.graphite, 4));
            consumePower(10f);
			drawer = new DrawMulti(
				new DrawRegion("-bottom"), 
				new DrawLiquidTile(BMHLiquids.neutronFluid){{alpha = 0.6f;}}, 
				new DrawCrucibleFlame(){{
					alpha = 0.8f;
					flameColor = Color.valueOf("c7e6b0");
					midColor = Color.valueOf("d4d790");
				}}, 
				new DrawDefault(), 
				new DrawGlowRegion(){{
					alpha = 0.4f;
					glowScale = 6f;
					glowIntensity = 0.3f;
					color = Color.valueOf("2cbcc9");
				}}
            );
			ambientSound = Sounds.smelter;
			ambientSoundVolume = 0.3f;
        }};
		
		invertedPulverizer = new GenericCrafter("inverted-pulverizer"){{
			requirements(Category.crafting, with(Items.copper, 30, Items.lead, 25));
			liquidCapacity = 50f;
			outputItem = new ItemStack(Items.scrap, 1);
			size = 1;
			hasPower = true;
			hasLiquids = false;
			hasItems = true;
			craftTime = 50f;
			updateEffect = Fx.pulverizeSmall;
			consumePower(0.5f);
			consumeItem(Items.sand, 1);
			ambientSound = Sounds.respawning;
			ambientSoundVolume = 0.2f;
			drawer = new DrawMulti(new DrawDefault(), new DrawBlurSpin("-spinner", -1.5f));
		}};
		
		powderizer = new GenericCrafter("powderizer"){{
			requirements(Category.crafting, with(Items.copper, 70, Items.lead, 60));
			size = 2;
			craftEffect = Fx.pulverize;
			ambientSound = Sounds.grinding;
			ambientSoundVolume = 0.4f;
			consumePower(0.75f);
			consumeItem(Items.scrap, 2);
			craftTime = 30f;
			outputItem = new ItemStack(Items.sand, 2);
			drawer = new DrawMulti(new DrawDefault(), new DrawRegion("-rotator", 0.8f, true), new DrawRegion("-top"));
		}};
		
		inducedKiln = new GenericCrafter("induced-kiln"){{
			requirements(Category.crafting, with(Items.copper, 70, Items.lead, 60, Items.graphite, 20, Items.metaglass, 15));
			size = 3;
			hasPower = true;
			hasItems = true;
			health = 240;
			hasLiquids = false;
			craftTime = 60f;
			consumePower(1.5f);
			consumeItems(with(Items.lead, 3, Items.sand, 4));
			outputItem = new ItemStack(Items.metaglass, 5);
			drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawCrucibleFlame(), new DrawDefault(), new DrawRegion("-top"));
			ambientSound = Sounds.smelter;
			ambientSoundVolume = 0.35f;
		}};
		
		siliconForge = new GenericCrafter("silicon-forge"){{
			requirements(Category.crafting, with(Items.copper, 90, Items.lead, 75, Items.graphite, 25, Items.silicon, 15));
			size = 3;
			hasPower = true;
			hasItems = true;
			hasLiquids = false;
			health = 320;
			craftTime = 60f;
			itemCapacity = 30;
			consumePower(1f);
			consumeItems(with(Items.coal, 3, Items.sand, 6));
			outputItem = new ItemStack(Items.silicon, 3);
		}};
		
		basicMultismelter = new GenericCrafter("basic-multismelter"){{
			requirements(Category.crafting, with(Items.copper, 100, Items.lead, 80, Items.graphite, 50));
			size = 3;
			consumePower(1.2f);
			consumeItems(with(Items.lead, 1, Items.sand, 3, Items.coal, 4));
			outputItems = with(Items.graphite, 1, Items.silicon, 1, Items.metaglass, 1);
			craftTime = 30f;
			drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawCrucibleFlame(), new DrawPistons(), new DrawDefault());
		}};
		
		sporeCrusher = new GenericCrafter("spore-crusher"){{
			requirements(Category.crafting, with(Items.silicon, 70, Items.lead, 80));
			size = 3;
			hasPower = true;
			hasItems = true;
			hasLiquids = true;
			itemCapacity = 20;
			health = 720;
			liquidCapacity = 120f;
			craftTime = 25f;
			updateEffect = Fx.none;
			consumePower(1.6f);
			consumeItem(Items.sporePod, 2);
			outputLiquid = new LiquidStack(Liquids.oil, 0.6f);
			craftEffect = new ParticleEffect(){{
				particles = 8;
				length = 16f;
				colorFrom = Color.valueOf("5c5e9f");
				colorTo = Color.valueOf("bf92f9");
				interp = Interp.circleIn;
			}};
		}};
		
		greenhouse = new AttributeCrafter("greenhouse"){{
			requirements(Category.production, with(Items.copper, 75, Items.lead, 75, Items.silicon, 30));
			outputItem = new ItemStack(Items.sporePod, 2);
			consumePower(1.5f);
			consumeLiquid(Liquids.water, 0.5f);
			craftEffect = Fx.smeltsmoke;
			updateEffect = Fx.pulverize;
			craftTime = 50;
			envRequired = 8;
			boostScale = 0.5556f;
			baseEfficiency = 1f;
			minEfficiency = 1f;
			maxBoost = 1f;
			attribute = Attribute.spores;
			hasLiquids = false;
			hasPower = true;
			hasItems = true;
			size = 3;
        }};
		
		pyratiteForge = new GenericCrafter("enhanced-pyratite-mixer"){{
			requirements(Category.crafting, with(Items.copper, 150, Items.lead, 120, Items.graphite, 60, Items.titanium, 30));
			size = 3;
			hasPower = true;
			hasItems = true;
			hasLiquids = false;
			health = 240;
			itemCapacity = 30;
			craftTime = 60f;
			craftEffect = Fx.pulverizeRed;
			updateEffect = Fx.pulverizeRed;
			consumePower(0.6f);
			consumeItems(with(Items.lead, 6, Items.sand, 6, Items.coal, 3));
			outputItem = new ItemStack(Items.pyratite, 3);
		}};
		
		blastForge = new GenericCrafter("enhanced-blast-mixer"){{
			requirements(Category.crafting, with(Items.copper, 300, Items.lead, 240, Items.graphite, 120, Items.titanium, 60));
			size = 3;
			hasPower = true;
			hasItems = true;
			hasLiquids = false;
			health = 240;
			craftTime = 90f;
			craftEffect = Fx.plasticExplosion;
			updateEffect = Fx.pulverizeRed;
			consumePower(0.6f);
			consumeItems(with(Items.pyratite, 2, Items.sporePod, 2));
			outputItem = new ItemStack(Items.blastCompound, 2);
		}};
		
		graphiteForge = new GenericCrafter("graphite-forge"){{
			requirements(Category.crafting, with(Items.lead, 160, Items.graphite, 75, Items.titanium, 140, Items.silicon, 45, Items.plastanium, 15));
			size = 4;
			hasPower = true;
			hasItems = true;
			hasLiquids = true;
			itemCapacity = 40;
			craftTime = 30f;
			craftEffect = Fx.blastExplosion;
			consumePower(2.5f);
			consumeItems(with(Items.coal, 4));
			consumeLiquid(Liquids.water, 0.2f);
			outputItem = new ItemStack(Items.graphite, 4);
		}};
		
		coalCondenser = new GenericCrafter("advanced-coal-centrifuge"){{
			requirements(Category.crafting, with(Items.lead, 200, Items.graphite, 75, Items.silicon, 75, Items.titanium, 200));
			outputItem = new ItemStack(Items.coal, 6);
			health = 440;
			craftTime = 90f;
			size = 2;
			hasPower = true;
			hasItems = true;
			hasLiquids = true;
			consumePower(1f);
			consumeLiquid(Liquids.oil, 0.15f);
			craftEffect = new WaveEffect(){{
				sizeFrom = 22f;
				sizeTo = 0f;
				colorFrom = Color.valueOf("5a5a5a");
				colorTo = Color.valueOf("343434");
				interp = Interp.pow2Out;
			}};
			drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawPistons(), new DrawDefault());
		}};
		
		plastaniumForge = new GenericCrafter("big-plastanium-press"){{
			requirements(Category.crafting, with(Items.lead, 160, Items.silicon, 160, Items.titanium, 140, Items.plastanium, 25));
			outputItem = new ItemStack(Items.plastanium, 4);
			health = 600;
			size = 3;
			hasPower = true;
			hasItems = true;
			hasLiquids = true;
			craftEffect = Fx.formsmoke;
			updateEffect = Fx.plasticburn;
			craftTime = 60f;
			liquidCapacity = 84f;
			drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawPistons(){{sinMag = 2f;}}, new DrawDefault());
			consumePower(3.75f);
			consumeItem(Items.titanium, 6);
			consumeLiquid(Liquids.oil, 0.6f);
		}};
		
		surgeAlloyForge = new GenericCrafter("surge-oven-big"){{
			requirements(Category.crafting, with(Items.lead, 160, Items.silicon, 160, Items.thorium, 140, Items.surgeAlloy, 25));
			outputItem = new ItemStack(Items.surgeAlloy, 2);
			consumeItems(with(Items.copper, 3, Items.lead, 4, Items.silicon, 3, Items.titanium, 2));
			consumePower(6f);
			size = 4;
			hasPower = true;
			hasItems = true;
			hasLiquids = false;
			craftTime = 90f;
			updateEffect = Fx.hitMeltdown;
			drawer = new DrawMulti(
				new DrawDefault(), 
				new DrawGlowRegion("-top"){{
					color = Color.valueOf("ffed7c");
				}}, 
				new DrawGlowRegion("-top2"){{
					color = Color.valueOf("fee650");
				}}
			);
		}};
		
		phaseFabricForge = new GenericCrafter("big-phase-weaver"){{
			requirements(Category.crafting, with(Items.lead, 320, Items.silicon, 320, Items.titanium, 140, Items.phaseFabric, 25));
			outputItem = new ItemStack(Items.phaseFabric, 4);
			health = 300;
			consumePower(9.9f);
			consumeItems(with(Items.thorium, 6, Items.sand, 15));
			size = 3;
			hasPower = true;
			hasItems = true;
			hasLiquids = false;
			itemCapacity = 60;
			craftTime = 130f;
			drawer = new DrawMulti(
				new DrawRegion("-bottom"), 
				new DrawCircles(){{
					color = Color.valueOf("ffc073");
					strokeMax = 1.2f;
					radius = 10f;
					amount = 3;
				}}, 
				new DrawSpikes(){{
					color = Color.valueOf("ffd59e");
					stroke = 1f;
					layers = 2;
					amount = 8;
					rotateSpeed = 0.5f;
					layerSpeed = -0.9f;
				}}, 
				new DrawDefault(), 
				new DrawGlowRegion("-glow"){{
					color = Color.valueOf("ffef99");
					alpha = 0.9f;
					glowIntensity = 0.6f;
				}}, 
				new DrawMultiWeave(){{
					glowColor = Color.valueOf("ffd59e");
				}}
			);
		}};
		
		advancedSeperator = new Separator("advanced-separator"){{
			requirements(Category.crafting, 
				with(Items.lead, 300, Items.graphite, 275, Items.titanium, 275, Items.plastanium, 30, Items.phaseFabric, 30, Items.surgeAlloy, 30));
			results = with(
				Items.copper, 10, 
				Items.lead, 10, 
				Items.graphite, 6, 
				Items.titanium, 6, 
				Items.thorium, 4
			);
			health = 690;
			size = 4;
			hasPower = true;
			hasItems = true;
			hasLiquids = true;
			solid = true;
			liquidCapacity = 60f;
			craftTime = 10f;
			consumePower(5.4f);
			consumeLiquid(Liquids.slag, 0.1f);
			consumeItem(Items.scrap, 2);
            drawer = new DrawMulti(new DrawDefault(), new DrawLiquidRegion(Liquids.slag){{suffix = "-liquid";}}, new DrawBlurSpin("-spinner", -5.2f));
        }};
		
	}
}

