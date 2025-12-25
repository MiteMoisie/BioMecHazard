package biomechazard.content.blocks;

import arc.audio.*;
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

public class FRBlocksDrills{
	public static Block
		cliffGrinder, cliffMiller, compactLaserDrill, groundCrusher, groundGrinder, groundMiller, hyperDrill, 
		mechanicalSieve, pneumaticSieve, steelSieve, titaniumSieve, oilBore, ventConcentrator, 
		tungstenBore, tinyPlasmaBore, tinyMechanicalDrill, tinyPneumaticDrill, titaniumDrill;
	
	public static void load(){
		
		cliffGrinder = new WallCrafter("cliff-grinder"){{
            requirements(Category.production, with(Items.graphite, 40, Items.beryllium, 35));
            consumePower(0.2f);
			
            size = 2;
            drillTime = 80f;
            attribute = Attribute.sand;
            output = Items.sand;
            fogRadius = 2;
            researchCost = with(Items.beryllium, 160, Items.graphite, 80);
            ambientSound = Sounds.drill;
            ambientSoundVolume = 0.06f;
        }};
		
		cliffMiller = new WallCrafter("cliff-miller"){{
            requirements(Category.production, with(Items.graphite, 75, Items.beryllium, 60));
            consumePower(0.4f);
			
            size = 3;
            drillTime = 70f;
            attribute = Attribute.sand;
            output = Items.sand;
            fogRadius = 3;
            researchCost = with(Items.beryllium, 160, Items.graphite, 160);
            ambientSound = Sounds.drill;
            ambientSoundVolume = 0.08f;
        }};
		
		compactLaserDrill = new Drill("compact-laser-drill"){{
            requirements(Category.production, with(Items.copper, 25, Items.graphite, 20, Items.silicon, 20, Items.titanium, 10));
            drillTime = 250;
            size = 2;
            hasPower = true;
            tier = 4;
			drawRim = true;
			itemCapacity = 4;

            consumePower(0.6f);
            consumeLiquid(Liquids.water, 0.018f).boost();
        }};
		
		groundCrusher = new GenericCrafter("ground-crusher"){{
            requirements(Category.production, with(Items.silicon, 40, Items.copper, 160, Items.lead, 100, Items.graphite, 60));

            craftEffect = new WaveEffect(){{
				colorFrom = Color.valueOf("f7cba4");
				colorTo = Color.valueOf("d3ae8d");
				lifetime = 45f;
				sizeFrom = 12f;
				sizeTo = 0f;
			}};
            outputItem = new ItemStack(Items.sand, 12);
            craftTime = 60f;
            itemCapacity = 50;
            size = 3;
            hasItems = true;
            hasLiquids = true;
            hasPower = true;

            consumePower(6f);
			ambientSound = BMHSoundEffects.crush;
			ambientSoundVolume = 1.3f;
        }};
		
		groundGrinder = new GenericCrafter("ground-grinder"){{
            requirements(Category.production, with(Items.copper, 60, Items.lead, 30));

            craftEffect = new WaveEffect(){{
				colorFrom = Color.valueOf("f7cba4");
				colorTo = Color.valueOf("d3ae8d");
				lifetime = 45f;
				sizeFrom = 4f;
				sizeTo = 0f;
			}};
            outputItem = new ItemStack(Items.sand, 2);
            craftTime = 60f;
            itemCapacity = 15;
            size = 1;
            hasItems = true;
            hasLiquids = false;
            hasPower = true;

            consumePower(1f);
			ambientSound = BMHSoundEffects.crush;
			ambientSoundVolume = 1f;
        }};
		
		groundMiller = new GenericCrafter("ground-miller"){{
            requirements(Category.production, with(Items.copper, 100, Items.lead, 60, Items.graphite, 40));

            craftEffect = new WaveEffect(){{
				colorFrom = Color.valueOf("f7cba4");
				colorTo = Color.valueOf("d3ae8d");
				lifetime = 45f;
				sizeFrom = 8f;
				sizeTo = 0f;
			}};
            outputItem = new ItemStack(Items.sand, 4);
            craftTime = 60f;
            itemCapacity = 30;
            size = 2;
            hasItems = true;
            hasLiquids = false;
            hasPower = true;

            consumePower(2f);
			ambientSound = BMHSoundEffects.crush;
			ambientSoundVolume = 1.1f;
        }};
		
		hyperDrill = new Drill("hyper-drill"){{
            requirements(Category.production, 
				with(Items.copper, 130, Items.silicon, 120, Items.titanium, 100, Items.plastanium, 75, BMHItems.livingSteel, 75, BMHItems.hardenedLivingSteel, 75));
            drillTime = 30;
            size = 5;
            drawRim = false;
            hasPower = true;
			hasLiquids = true;
			liquidCapacity = 40f;
			hasItems = true;
			itemCapacity = 60;
            tier = 8;
            updateEffect = new ParticleEffect(){{
				particles = 8;
				line = true;
				colorFrom = Color.valueOf("61018a");
				colorTo = Color.valueOf("b200ff");
				sizeFrom = 1f;
				sizeTo = 2f;
				interp = Interp.pow2Out;
				
            }};
			updateEffectChance = 0.1f;
            rotateSpeed = 12f;
            drawMineItem = false;
            blockedItem = Items.sand;
            liquidBoostIntensity = 1.3f;

            consumePower(4f);
            consumeLiquid(Liquids.cryofluid, 0.09f);
        }};
		
		mechanicalSieve = new GenericCrafter("mechanical-sieve"){{
            requirements(Category.production, with(Items.copper, 120, Items.lead, 80));
			
			craftEffect = new MultiEffect(new WaveEffect(){{
                            sizeFrom = 0f;
							sizeTo = 12f;
							colorFrom = Color.valueOf("3b85d3");
							colorTo = Color.valueOf("2c5682");
							interp = Interp.pow2Out;
                        }});
			health = 160;
            outputItem = new ItemStack(BMHItems.gold, 1);
            craftTime = 1920f;
            itemCapacity = 20;
            size = 2;
            hasItems = true;
            hasLiquids = true;
			liquidCapacity = 100f;
            hasPower = false;
			consumeLiquid(Liquids.water, 0.3f);
			drawer = new DrawMulti(
				new DrawRegion("-bottom"), 
				new DrawLiquidTile(Liquids.water), 
				new DrawRegion("-grid"), 
				new DrawDefault()
			);
        }};
		
		pneumaticSieve = new GenericCrafter("pneumatic-sieve"){{
            requirements(Category.production, with(Items.copper, 240, Items.lead, 160, Items.graphite, 45));
			
			craftEffect = new MultiEffect(new WaveEffect(){{
                            sizeFrom = 0f;
							sizeTo = 12f;
							colorFrom = Color.valueOf("3b85d3");
							colorTo = Color.valueOf("2c5682");
							interp = Interp.pow2Out;
                        }});
			health = 220;
            outputItem = new ItemStack(BMHItems.gold, 1);
            craftTime = 960f;
            itemCapacity = 30;
            size = 2;
            hasItems = true;
            hasLiquids = true;
			liquidCapacity = 180f;
            hasPower = false;
			consumeLiquid(Liquids.water, 0.3f);
			drawer = new DrawMulti(
				new DrawRegion("-bottom"), 
				new DrawLiquidTile(Liquids.water), 
				new DrawRegion("-grid"), 
				new DrawDefault()
			);
        }};
		
		steelSieve = new GenericCrafter("steel-sieve"){{
            requirements(Category.production, with(Items.copper, 460, Items.lead, 320, Items.graphite, 210, Items.titanium, 120, BMHItems.livingSteel, 60));
			
			craftEffect = new MultiEffect(new WaveEffect(){{
                            sizeFrom = 0f;
							sizeTo = 12f;
							colorFrom = Color.valueOf("3b85d3");
							colorTo = Color.valueOf("2c5682");
							interp = Interp.pow2Out;
                        }});
			health = 465;
            outputItem = new ItemStack(BMHItems.gold, 1);
            craftTime = 240f;
            itemCapacity = 40;
            size = 4;
            hasItems = true;
            hasLiquids = true;
			liquidCapacity = 360f;
            hasPower = true;
			consumePower(4f);
			consumeLiquid(Liquids.water, 0.6f);
			drawer = new DrawMulti(
				new DrawRegion("-bottom"), 
				new DrawLiquidTile(Liquids.water), 
				new DrawRegion("-grid"), 
				new DrawDefault()
			);
        }};
		
		titaniumSieve = new GenericCrafter("titanium-sieve"){{
            requirements(Category.production, with(Items.copper, 380, Items.lead, 260, Items.graphite, 120, Items.titanium, 60));
			
			craftEffect = new MultiEffect(new WaveEffect(){{
                            sizeFrom = 0f;
							sizeTo = 12f;
							colorFrom = Color.valueOf("3b85d3");
							colorTo = Color.valueOf("2c5682");
							interp = Interp.pow2Out;
                        }});
			health = 280;
            outputItem = new ItemStack(BMHItems.gold, 1);
            craftTime = 480f;
            itemCapacity = 40;
            size = 3;
            hasItems = true;
            hasLiquids = true;
			liquidCapacity = 160f;
            hasPower = true;
			consumePower(2f);
			consumeLiquid(Liquids.water, 0.45f);
			drawer = new DrawMulti(
				new DrawRegion("-bottom"), 
				new DrawLiquidTile(Liquids.water), 
				new DrawRegion("-grid"), 
				new DrawDefault()
			);
			updateEffectChance = 0.03f;
        }};
		
		oilBore = new Fracker("oil-bore"){{
            requirements(Category.production, 
				with(Items.copper, 220, Items.graphite, 210, Items.lead, 190, Items.thorium, 160, Items.silicon, 120, Items.plastanium, 80));
            result = Liquids.oil;
            pumpAmount = 0.35f;
            size = 4;
            attribute = Attribute.oil;
            baseEfficiency = 0f;
            itemUseTime = 60f;
			health = 590;
            hasPower = true;
            hasLiquids = true;
            hasItems = true;
            itemCapacity = 15;
			liquidCapacity = 50f;
            consumeItem(Items.sand);
            consumePower(6f);
            consumeLiquid(Liquids.water, 0.15f);
			drawer = new DrawDefault();
        }};
		
		ventConcentrator = new AttributeCrafter("vent-concentrator"){{
            requirements(Category.production, with(Items.graphite, 45, Items.beryllium, 80));
            attribute = Attribute.steam;
            group = BlockGroup.liquids;
            minEfficiency = 0.00001f;
            baseEfficiency = 0f;
            displayEfficiency = false;
            craftEffect = Fx.turbinegenerate;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawBlurSpin("-rotator", 8f), new DrawRegion("-mid"), new DrawDefault());
            craftTime = 120f;
            size = 3;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.08f;
            hasLiquids = true;
            boostScale = 0.111f;
            outputLiquid = new LiquidStack(Liquids.water, 0.7f);
            consumePower(0.7f);
            liquidCapacity = 80f;
        }};
		
		tungstenBore = new BeamDrill("tungsten-bore"){{
            requirements(Category.production, with(Items.beryllium, 60, Items.tungsten, 20));
            consumePower(0.2f);
            drillTime = 160f;
            tier = 3;
            size = 2;
            range = 8;
            fogRadius = 3;
            researchCost = with(Items.beryllium, 10);
            consumeLiquid(Liquids.hydrogen, 0.005f).boost();
        }};
		
		tinyPlasmaBore = new BeamDrill("tiny-plasma-bore"){{
            requirements(Category.production, with(Items.beryllium, 10));
            consumePower(0.0375f);
            drillTime = 280f;
            tier = 3;
            size = 1;
            range = 3;
            fogRadius = 2;
            researchCost = with(Items.beryllium, 10);
            consumeLiquid(Liquids.hydrogen, 0.0014f).boost();
        }};
		
		tinyMechanicalDrill = new Drill("tiny-mechanical-drill"){{
            requirements(Category.production, with(Items.copper, 4));
            tier = 2;
            drillTime = 540;
            size = 1;
            drawMineItem = false;
			itemCapacity = 3;
            consumeLiquid(Liquids.water, 0.009f).boost();
        }};

        tinyPneumaticDrill = new Drill("tiny-pneumatic-drill"){{
            requirements(Category.production, with(Items.copper, 5, Items.graphite, 2));
            tier = 3;
            drillTime = 355;
            size = 1;
            drawMineItem = false;
			itemCapacity = 3;
            consumeLiquid(Liquids.water, 0.009f).boost();
        }};
		
		titaniumDrill = new Drill("titanium-drill"){{
            requirements(Category.production, with(Items.graphite, 10, Items.silicon, 10, Items.titanium, 20));
            tier = 5;
            drillTime = 400;
            size = 2;
			liquidCapacity = 300f;
            consumeLiquid(Liquids.water, 0.05f).boost();
        }};
		
	}
}


