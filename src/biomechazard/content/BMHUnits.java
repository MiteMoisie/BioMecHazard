package biomechazard.content;

import arc.func.Prov;
import arc.graphics.*;
import arc.struct.*;
//import mindustry.Vars;
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

import static mindustry.content.StatusEffects.*;
import static mindustry.Vars.*;

public class BMHUnits{
    public static UnitType mokuge;

        public static void load(){
        
        mokuge = new UnitType("mokuge"){{
			this.constructor = UnitEntity::create;
			
			outlineColor = Color.valueOf("303a45");
			health = 2280;
            armor = 25;
			flying = true;
			immunities = ObjectSet.with(disarmed, sapped, slow, sporeSlowed, unmoving, shocked, freezing);
			
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
            payloadCapacity = (3 * 3) * Vars.tilePayload;
			
            speed = 6.7f;
			rotateSpeed = 6.1f;
			accel = 0.4f;
			drag /= 5f;
			strafePenalty = 0.3f;
			
			weapons.add(new Weapon("-mouth"){{
                reload = 150f; //75f;
                shootY = 8f;
                x = 0f;
                y = 0f;
                continuous = true;
                shoot.firstShotDelay = BMHVisualEffects.purpleLaserChargeBig.lifetime -1f;
                chargeSound = Sounds.lasercharge2;
                shootSound = Sounds.beam;
                shootStatus = StatusEffects.slow;
                shootStatusDuration = 60f * 3;
                mirror = false;
                bullet = new ContinuousLaserBulletType(75f){{
                    width = 4f;
                    length = 225f;
                    drawSize = 100f;
                    lifetime = 125f;
                    healPercent = 0.5f;
                    collidesTeam = true;
                    buildingDamageMultiplier = 0.10f;
                    colors = new Color[]{Color.valueOf("00E600"), Color.valueOf("A865C9"), Color.valueOf("A865C9"), Color.valueOf("ffffff")};
					//C43737 4900FF 8B73C7
                    chargeEffect = BMHVisualEffects.purpleLaserChargeBig;
                }};
            }});
			
            hitSize = 17f;
			range = 125f;  
            
			abilities.add(new RegenAbility(){{percentAmount = 0.015f;}});
			//abilities.add(new RegenAbility(){{percentAmount = 1f / (240f * 60f * 2f) * 100f;}});
			
            engineSize = 4f;
			engineOffset = 12f;
			engineColor = Color.valueOf("E60073");
			engineColorInner = Color.valueOf("00E673");
        }};
}}
