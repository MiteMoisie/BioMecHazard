package biomechazard.content.blocks;

import arc.graphics.*;
import arc.struct.Seq;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.WaveEffect;
import mindustry.entities.pattern.ShootSpread;
import mindustry.type.*;
import mindustry.type.Category;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import biomechazard.content.*;

import static mindustry.type.ItemStack.*;

public class FRBlocksDefense{
	
	public static Block 
		armoredDoor, copperWallHuge, copperWallGigantic, doorGigantic, doorHuge, phaseWallHuge, phaseWallGigantic, 
		plastaniumWallHuge, plastaniumWallGigantic, reinforcedSurgeWallGigantic, reinforcedSurgeWallHuge, surgeAlloyWallHuge, 
		surgeAlloyWallGigantic, thoriumWallHuge, thoriumWallGigantic, titaniumWallHuge, titaniumWallGigantic, 
		livingSteelWall, livingSteelWallLarge, amalgamWallLarge, amalgamWall, 
		armoredWall, berylliumWallGigantic, berylliumWallHuge, carbideWallGigantic, carbideWallHuge, tungstenWallGigantic, tungstenWallHuge;
	
	public static void load(){
		
		armoredDoor = new AutoDoor("armored-door"){{
            requirements(Category.defense, with(Items.titanium, 24, Items.silicon, 32));
            health = 1860;
            size = 2;
        }};
		
        copperWallHuge = new Wall("copper-wall-2"){{
            requirements(Category.defense, with(Items.copper, 54));
            health = 2880;
            size = 3;
        }};
		
        copperWallGigantic = new Wall("copper-wall-3"){{
            requirements(Category.defense, with(Items.copper, 96));
            health = 5120;
            size = 4;
        }};
		
		doorGigantic = new Door("door-gigantic"){{
            requirements(Category.defense, with(Items.titanium, 96, Items.silicon, 64));
            health = 6400;
            size = 4;
        }};
		
		doorHuge = new Door("door-huge"){{
            requirements(Category.defense, with(Items.titanium, 54, Items.silicon, 36));
            health = 3600;
            size = 3;
        }};

        phaseWallHuge = new Wall("phase-fabric-wall-2"){{
            requirements(Category.defense, with(Items.phaseFabric, 54));
            health = 5400;
            size = 3;
            chanceDeflect = 15f;
            flashHit = true;
			envDisabled = 16;
        }};

        phaseWallGigantic = new Wall("phase-fabric-wall-3"){{
            requirements(Category.defense, with(Items.phaseFabric, 96));
            health = 9600;
            size = 4;
            chanceDeflect = 20f;
            flashHit = true;
			envDisabled = 16;
        }};

        plastaniumWallHuge = new Wall("plastanium-wall-2"){{
            requirements(Category.defense, with(Items.plastanium, 54));
            health = 4680;
            size = 3;
            insulated = true;
            absorbLasers = true;
        }};

        plastaniumWallGigantic = new Wall("plastanium-wall-3"){{
            requirements(Category.defense, with(Items.plastanium, 96));
            health = 8320;
            size = 4;
            insulated = true;
            absorbLasers = true;
        }};

        surgeAlloyWallHuge = new Wall("surge-alloy-wall-2"){{
            requirements(Category.defense, with(Items.surgeAlloy, 54));
            health = 8280;
            size = 3;
            lightningChance = 0.10f;
            lightningDamage = 25f;
            lightningLength = 20;
			envDisabled = 16;
        }};

        surgeAlloyWallGigantic = new Wall("surge-alloy-wall-3"){{
            requirements(Category.defense, with(Items.surgeAlloy, 96));
            health = 14720;
            size = 4;
            lightningChance = 0.20f;
            lightningDamage = 30f;
            lightningLength = 22;
			envDisabled = 16;
        }};

        thoriumWallHuge = new Wall("thorium-wall-2"){{
            requirements(Category.defense, with(Items.thorium, 54));
            health = 7200;
            size = 3;
			envDisabled = 16;
        }};

        thoriumWallGigantic = new Wall("thorium-wall-3"){{
            requirements(Category.defense, with(Items.thorium, 96));
            health = 12800;
            size = 4;
			envDisabled = 16;
        }};

        titaniumWallHuge = new Wall("titanium-wall-2"){{
            requirements(Category.defense, with(Items.titanium, 54));
            health = 3960;
            size = 3;
        }};

        titaniumWallGigantic = new Wall("titanium-wall-3"){{
            requirements(Category.defense, with(Items.titanium, 96));
            health = 7040;
            size = 4;
        }};
		
		livingSteelWall = new MendProjector("living-steel-wall"){{
            requirements(Category.defense, with(BMHItems.hardenedLivingSteel, 6));
            size = 1;
            reload = 2500f;
            range = 1f;
			itemCapacity = 0;
			hasItems = false;
			hasPower = false;
			baseColor = Color.valueOf("8c0291");
			phaseColor = Color.valueOf("8c0291");
			insulated = true;
            healPercent = 1f;
            health = 960;
			envDisabled = 16;
        }};
		
		livingSteelWallLarge = new MendProjector("living-steel-wall-2"){{
            requirements(Category.defense, with(BMHItems.hardenedLivingSteel, 24));
            size = 2;
            reload = 2500f;
            range = 1f;
			itemCapacity = 0;
			hasItems = false;
			hasPower = false;
			baseColor = Color.valueOf("8c0291");
			phaseColor = Color.valueOf("8c0291");
			insulated = true;
            healPercent = 1f;
            health = 3220;
			envDisabled = 16;
        }};

        amalgamWallLarge = new PowerTurret("steel-alloy-wall-large"){{
            requirements(Category.defense, with(BMHItems.steelAmalgam, 24));
			hasItems = false;
			hasPower = false;
            consumePower(0.3f);
			hasLiquids = false;
			canOverdrive = false;
            size = 2;
            recoil = 0f;
			rotate = false;
			shootY = 0;
            rotateSpeed = 0f;
            shootCone = 360f;
            range = 60f;
            health = 4200;
            targetAir = false;
			targetGround = true;
            reload = 90f;
			envDisabled = 16;
			shoot = new ShootSpread(){{
				shots = 12;
				spread = 50f;
			}};
			shootType = new LightningBulletType(){{
                damage = 4;
                lightningLength = 10;
				lightningColor = Color.valueOf("bd7374");
				hitEffect = new WaveEffect(){{
					colorFrom = Color.valueOf("dbaf85");
					colorTo = Color.valueOf("ba6a83");
				}};
            }};
        }};

        amalgamWall = new PowerTurret("steel-alloy-wall-small"){{
            requirements(Category.defense, with(BMHItems.steelAmalgam, 6));
			hasItems = false;
			hasPower = false;
            consumePower(0.2f);
			hasLiquids = false;
			canOverdrive = false;
            size = 1;
            recoil = 0f;
			rotate = false;
			shootY = 0;
            rotateSpeed = 0f;
            shootCone = 360f;
            range = 30f;
            health = 1200;
            targetAir = false;
			targetGround = true;
            reload = 90f;
			envDisabled = 16;
			shoot = new ShootSpread(){{
				shots = 8;
				spread = 60f;
			}};
			shootType = new LightningBulletType(){{
                damage = 3;
                lightningLength = 7;
				lightningColor = Color.valueOf("bd7374");
				hitEffect = new WaveEffect(){{
					colorFrom = Color.valueOf("dbaf85");
					colorTo = Color.valueOf("ba6a83");
				}};
            }};
        }};

        armoredWall = new ShieldWall("armored-wall"){{
            requirements(Category.defense, ItemStack.with(Items.phaseFabric, 24, Items.surgeAlloy, 10, Items.beryllium, 18, Items.carbide, 12));
            consumePower(0.06f);
            chanceDeflect = 9f;
            health = 5820;
            armor = 18f;
            size = 2;
			shieldHealth = 1200;
            outputsPower = false;
            hasPower = true;
            consumesPower = true;
            conductivePower = true;
        }};
		
		berylliumWallGigantic = new Wall("beryllium-wall-gigantic"){{
            requirements(Category.defense, with(Items.beryllium, 96));
            health = 8320;
            size = 4;
            armor = 2f;
        }};
		
		berylliumWallHuge = new Wall("beryllium-wall-huge"){{
            requirements(Category.defense, with(Items.beryllium, 54));
            health = 4680;
            size = 3;
            armor = 2f;
        }};
		
		carbideWallGigantic = new Wall("carbide-wall-gigantic"){{
            requirements(Category.defense, with(Items.thorium, 96, Items.carbide, 96));
            health = 17280;
            size = 4;
            armor = 16f;
        }};
		
		carbideWallHuge = new Wall("carbide-wall-huge"){{
            requirements(Category.defense, with(Items.thorium, 54, Items.carbide, 54));
            health = 9720;
            size = 3;
            armor = 16f;
        }};

        reinforcedSurgeWallGigantic = new Wall("reinforced-surge-wall-gigantic"){{
            requirements(Category.defense, with(Items.surgeAlloy, 96, Items.tungsten, 32));
            health = 16000;
            armor = 20f;
            size = 4;
            lightningChance = 0.05f;
            lightningDamage = 30f;
        }};

        reinforcedSurgeWallHuge = new Wall("reinforced-surge-wall-huge"){{
            requirements(Category.defense, with(Items.surgeAlloy, 54, Items.tungsten, 18));
            health = 9000;
            armor = 20f;
            size = 3;
            lightningChance = 0.05f;
            lightningDamage = 30f;
        }};

        tungstenWallGigantic = new Wall("tungsten-wall-gigantic"){{
            requirements(Category.defense, with(Items.tungsten, 96));
            health = 11520;
            armor = 14f;
            size = 4;
        }};

        tungstenWallHuge = new Wall("tungsten-wall-huge"){{
            requirements(Category.defense, with(Items.tungsten, 54));
            health = 6480;
            armor = 14f;
            buildCostMultiplier = 8f;
            size = 3;
        }};
		
	}
}