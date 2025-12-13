package biomechazard.content;

import arc.func.Prov;
import arc.graphics.*;
import arc.struct.*;
import mindustry.Vars;
import mindustry.ai.*;
import mindustry.ai.types.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.*;
import mindustry.entities.part.DrawPart.PartProgress;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.content.*;
import mindustry.content.StatusEffects;
import mindustry.type.unit.*;
import mindustry.world.meta.*;
import biomechazard.content.*;
import biomechazard.audiovisual.*;

import static mindustry.content.StatusEffects.*;
import static mindustry.Vars.*;

public class BMHUnits{
	
    public static UnitType mokuge, delta, epsilon;
	
	public static void load(){
        
        mokuge = new UnitType("mokuge"){{
			//Plantage au démarrage : apparemment, ce constructeur est nécessaire
			this.constructor = UnitEntity::create;
			
			isEnemy = false;
			outlineColor = Color.valueOf("000000"); //Original 303A45
			health = 2280;
            armor = 25;
			flying = true;
			immunities = ObjectSet.with(disarmed, sapped, slow, sporeSlowed, unmoving, shocked, freezing, overdrive);
			canHeal = true;
			
			lightRadius = 35f;
			lightOpacity = 0.1f;
			fogRadius = 50f;
			outlineRadius = 2;
			
			buildRange = 300f;
            buildSpeed = 5.8f;
			
			mineRange = 300f;
            mineSpeed = 10f;
			mineTier = 10;
			mineWalls = true;
			mineFloor = true;
			mineHardnessScaling = false;
			
			itemCapacity = 150;
            payloadCapacity = (3 * 3) * tilePayload;
			
            speed = 6.7f;
			rotateSpeed = 6.1f;
			accel = 0.4f;
			drag /= 5f;
			strafePenalty = 0.3f;
			
			weapons.add(
			new Weapon("mokuge-mouth"){{
                reload = 40f; //Original 75f;
                shootY = 8f;
                x = 0f;
                y = 0f;
                continuous = true;
                shoot.firstShotDelay = BMHEffects.purpleBigLaserBeam.lifetime -1f;
                chargeSound = Sounds.lasercharge2;
                shootSound = Sounds.beam;
                shootStatus = StatusEffects.slow;
                shootStatusDuration = 60f * 3;
                mirror = false;
                bullet = new ContinuousLaserBulletType(45f){{
                    width = 4f;
                    length = 293.5f;
                    drawSize = 100f;
                    lifetime = 300f;
                    healPercent = 0.5f;
                    collidesTeam = true;
                    buildingDamageMultiplier = 0.10f;
                    colors = new Color[]{Color.valueOf("FF0000"), Color.valueOf("7665C9"), Color.valueOf("BD8BD6"), Color.valueOf("000000")};
					//, Color.valueOf("00FFFF")
                    chargeEffect = BMHEffects.purpleBigLaserBeam;
                }};
            }}/*,
			new Weapon("pglrrhvdhrlw-weapon"){{
                shootSound = Sounds.lasershoot;
                reload = 24f;
                x = 8f;
                y = 3f;
                rotate = true;
                bullet = new LaserBoltBulletType(8.32f, 26){{
                    lifetime = 35f;
                    healPercent = 25f;
                    collidesTeam = true;
                    backColor = Pal.heal;
                    frontColor = Color.valueOf("8762FF");
                }};
            }},
			new Weapon("gnthtkhnphkn-weapon"){{
                reload = 40f;
                x = 4f;
				y = -2f;
                rotate = true;
                shake = 1f;
                shoot.shots = 2;
                inaccuracy = 5f;
                velocityRnd = 0.2f;
                shootSound = Sounds.missileLong;
                bullet = new MissileBulletType(3f, 27){{
                    width = 8f;
                    height = 8f;
                    //shrinkY = 0f;
                    drag = -0.003f;
                    homingRange = 60f;
                    keepVelocity = false;
                    splashDamageRadius = 46f;
                    splashDamage = 38f;
                    lifetime = 50f;
                    trailColor = Pal.unitBack;
                    backColor = Pal.unitBack;
                    frontColor = Pal.unitFront;
                    hitEffect = Fx.blastExplosion;
                    despawnEffect = Fx.blastExplosion;
                    weaveScale = 6f;
                    weaveMag = 1f;
                }};
            }},
			new Weapon("ckrthlmmgtdrngg-weapon"){{
                y = 2f;
                x = 6f;
                shootY = 10f;
                reload = 12;
                //shake = 1f;
                rotateSpeed = 5f;
                ejectEffect = Fx.casing1;
                shootSound = Sounds.shootSpectre;
                rotate = true;
                shadow = 8f;
                bullet = new BasicBulletType(7f, 35){{
                    width = 12f;
                    height = 18f;
                    lifetime = 25f;
                    shootEffect = Fx.shootBig;
                }};
            }},
			new Weapon("ckrthlmmgtdrngg-weapon"){{
                y = -5f;
                x = 4f;
                shootY = 10f;
                reload = 12;
                //shake = 1f;
                rotateSpeed = 5f;
                ejectEffect = Fx.casing1;
                shootSound = Sounds.shootSpectre;
                rotate = true;
                shadow = 8f;
                bullet = new BasicBulletType(7f, 35){{
                    width = 12f;
                    height = 18f;
                    lifetime = 25f;
                    shootEffect = Fx.shootBig;
                }};
            }}*/
			);
			
            hitSize = 17f;
			range = 125f;  
            
			abilities.add(new RegenAbility(){{percentAmount = 0.034f;}});
			//RepairFieldAbility(float amount, float reload, float range)
			abilities.add(new RepairFieldAbility(20f, 10f, 200f));
			//StatusFieldAbility(StatusEffect effect, float duration, float reload, float range)
			abilities.add(new StatusFieldAbility(overdrive, 90f, 100f, 120f));
			
            engineSize = 3f;
			engineOffset = 12f;
			engineColor = Color.valueOf("B40059");
			engineColorInner = Color.valueOf("00E673");
        }};
		
		delta = new UnitType("delta"){{
			this.constructor = UnitEntity::create;
			flying = true;
			speed = 3.8f;
			accel = 0.125f;
			drag = 0.0625f;
			rotateSpeed = 2.1f;
			mineSpeed = 9f;
			mineTier = 3;
			health = 300;
            armor = 1;
			itemCapacity = 90;
			hitSize = 13f;
			buildSpeed = 1.25f;
			engineOffset = 8.5f;
			//rotateShooting = true;
			//isCounted = false;
			//commandLimit = 8;
			weapons.add(new Weapon("flakgun-core"){{
				reload = 38f;
                x = 5f;
                y = 2f;
				top = false;
				rotate = false;
				//shots: 5
				inaccuracy = 5f;
				velocityRnd = 0.25f;
				shootY = 3f;
				ejectEffect = Fx.casing2;
				shootSound = Sounds.shootBig;
				bullet = new BasicBulletType(){{
					damage = 12f;
					speed = 5.5f;
					width = 8f;
					height = 14f;
					shootEffect = Fx.shootSmall;
					smokeEffect = Fx.shootSmallSmoke;
					//tileDamageMultiplier: 0.07
					lifetime = 40f;
					sprite = "bullet";
				}};
				
			}});
			weapons.add(new Weapon("small-weapon-core"){{
				reload = 20f;
                x = 3f;
                y = -3f;
				top = false;
				rotate = true;
				rotateSpeed = 18f;
				//shots: 1
				inaccuracy = 1f;
				ejectEffect = Fx.casing1;
				bullet = new BasicBulletType(){{
					damage = 8f;
					speed = 8f;
					width = 4f;
					height = 9f;
					//tileDamageMultiplier: 0.03
					lifetime = 20f;
					sprite = "bullet";
				}};
				
			}});
			weapons.add(new Weapon("small-weapon-core"){{
				reload = 20.1f;
                x = 3f;
                y = -3f;
				top = false;
				rotate = true;
				rotateSpeed = 18f;
				//shots: 1
				inaccuracy = 1f;
				ejectEffect = Fx.casing1;
				bullet = new BasicBulletType(){{
					damage = 8f;
					speed = 8f;
					width = 4f;
					height = 9f;
					//tileDamageMultiplier: 0.03
					lifetime = 20f;
					sprite = "bullet";
				}};
			}});
		}};
		
		epsilon = new UnitType("epsilon"){{
			this.constructor = UnitEntity::create;
			flying = true;
			speed = 4.05f;
			accel = 0.125f;
			drag = 0.0625f;
			rotateSpeed = 2.375f;
			mineSpeed = 10f;
			mineTier = 4;
			health = 410;
            armor = 3;
			itemCapacity = 110;
			hitSize = 18f;
			buildSpeed = 1.5f;
			engineOffset = 8f;
			//rotateShooting = true;
			//isCounted = false;
			//commandLimit = 12;
			weapons.add(new Weapon("missiles-core"){{
				reload = 40f;
                x = 7f;
                y = 2f;
				shootY = 3f;
				top = false;
				rotate = true;
				//shots: 1
				inaccuracy = 2f;
				ejectEffect = null;
				shootSound = Sounds.missile;
				recoil = 3;
				rotateSpeed = 8f;
				bullet = new MissileBulletType(){{
					damage = 20f;
					splashDamage = 40f;
					splashDamageRadius = 11f;
					homingPower = 0.19f;
					homingRange = 72;
					weaveMag = 2f;
					weaveScale = 5f;
					speed = 6.5f;
					range = 280;
					drag = 0.015f;
					width = 8f;
					height = 14f;
					frontColor = Color.valueOf("fff8e8");
					backColor = Color.valueOf("f9c27a");
					trailColor = Color.valueOf("ffb855");
					hitEffect = Fx.blastExplosion;
					despawnEffect = Fx.blastExplosion;
					shootEffect = Fx.shootBig;
					smokeEffect = Fx.shootSmallSmoke;
					//tileDamageMultiplier: 0.01
					lifetime = 70f;
					status = StatusEffects.blasted;
					statusDuration = 40f;
				}};
			}});
			weapons.add(new Weapon("missiles-core"){{
				reload = 40.001f;
                x = 7f;
                y = 2f;
				shootY = 3f;
				top = false;
				rotate = true;
				//shots: 1
				inaccuracy = 2f;
				ejectEffect = null;
				shootSound = Sounds.missile;
				recoil = 3;
				rotateSpeed = 8f;
				bullet = new MissileBulletType(){{
					damage = 20f;
					splashDamage = 40f;
					splashDamageRadius = 11f;
					homingPower = 0.19f;
					homingRange = 72;
					weaveMag = 2f;
					weaveScale = 5f;
					speed = 6.5f;
					range = 280;
					drag = 0.015f;
					width = 8f;
					height = 14f;
					frontColor = Color.valueOf("fff8e8");
					backColor = Color.valueOf("f9c27a");
					trailColor = Color.valueOf("ffb855");
					hitEffect = Fx.blastExplosion;
					despawnEffect = Fx.blastExplosion;
					shootEffect = Fx.shootBig;
					smokeEffect = Fx.shootSmallSmoke;
					//tileDamageMultiplier: 0.01
					lifetime = 70f;
					status = StatusEffects.blasted;
					statusDuration = 40f;
				}};
			}});
		}};
	}
}






