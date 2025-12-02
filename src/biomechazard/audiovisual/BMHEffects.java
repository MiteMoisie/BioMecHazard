package biomechazard.audiovisual;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import mindustry.entities.*;
import mindustry.graphics.*;
import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;
import static mindustry.Vars.state;
import static biomechazard.audiovisual.UAWPal.*;

public class BMHEffects {
	public static Effect
	
	purpleBigLaserBeam = new Effect(40f, 100f, e -> {
        color(Color.valueOf("8B73C7"));
        stroke(e.fin() * 2f);
        Lines.circle(e.x, e.y, e.fout() * 50f);
    }).followParent(true).rotWithParent(true), 
	
	/** @author Eschatologue  */
	// region Status
	statusEffectCircle = new Effect(35f, e -> {
		color(e.color);

		randLenVectors(e.id, 3, 2f + e.fin() * 7f, (x, y) -> {
			Fill.circle(e.x + x, e.y + y, 0.2f + e.fslope() * 1.5f);
		});
	}),
	
	statusEffectSquare = new Effect(35f, e -> {
		color(e.color);

		randLenVectors(e.id, 3, 2f + e.fin() * 7f, (x, y) -> {
			Fill.square(e.x + x, e.y + y, 0.2f + e.fslope() * 1.5f, 45f);
		});
	}),
	// endregion Status
	
	// region Trails
	/**
	 * Vanilla trail fade but with much larger clipsize
	 */
	trailFade = new Effect(400f, 400, e -> {
		if (!(e.data instanceof Trail trail)) return;
		//lifetime is how many frames it takes to fade out the trail
		e.lifetime = trail.length * 1.4f;

		if (!state.isPaused()) {
			trail.shorten();
		}
		trail.drawCap(e.color, e.rotation);
		trail.draw(e.color, e.rotation);
	}),
	
	/** Based on Fx.fireHit */
	cryoHit = new Effect(38f, e -> {
		Draw.color(cryoFront, cryoBack, e.fin());
		Angles.randLenVectors(e.id, 5, 2f + e.fin() * 10f, (x, y) -> Fill.circle(e.x + x, e.y + y, 0.2f + e.fout() * 1.6f));
		Draw.color();
	}),
	
	// region Shooting
	shootSmoke = new Effect(30f, e -> {
		Draw.color(e.color, Color.lightGray, Color.gray, e.fin());

		Angles.randLenVectors(e.id, 9, e.finpow() * 23f, e.rotation, 20f, (x, y) -> {
			Fill.circle(e.x + x, e.y + y, e.fout() * 2.4f + 0.2f);
		});
	}),
	
	hitBulletBigColor = new Effect(13, e -> {
		Draw.color(Color.white, e.color, e.fin());
		Lines.stroke(0.5f + e.fout() * 1.5f);
		Angles.randLenVectors(e.id, 8, e.finpow() * 30f, e.rotation, 50f, (x, y) -> {
			float ang = Mathf.angle(x, y);
			lineAngle(e.x + x, e.y + y, ang, e.fout() * 4 + 1.5f);
		});
	})
	
	/** Fin du code UAW */
	
	;
	
	/** @author Eschatologue  */
	/** Refer to {@link UAWFx#shootSmoke(float, Color, boolean, float, float)} */
	public static Effect shootSmoke(float lifetime, Color color) {
		return shootSmoke(lifetime, color, false);
	}
	/** Refer to {@link UAWFx#shootSmoke(float, Color, boolean, float, float)} */
	public static Effect shootSmoke(float lifetime, Color color, boolean muzzleBreak) {
		return shootSmoke(lifetime, color, muzzleBreak, 1, 1);
	}
	/**
	 * Modified version of {@link Fx#shootBigSmoke2}
	 * @param lifetime
	 * 	[18] How long does the smoke lasts, also adjusts amount, spreads, and radius.
	 * @param color
	 * 	The color of the beginning of the smoke, will lerp to gray
	 * @param muzzleBreak
	 * 	[False] Whenever to cause 2 instances of the effect and make it spread horizontally
	 */
	public static Effect shootSmoke(float lifetime, Color color, boolean muzzleBreak, float sizeMult, float lifetimeMult) {
		int amount = (int) ((int) lifetime * 0.5f);
		float l = lifetime * 1.27f;
		float rng = lifetime * 1.1f;
		float size = (lifetime * 0.13f) * sizeMult;
		return new Effect(lifetime * lifetimeMult, e -> {
			Draw.color(color, Color.lightGray, Color.gray, e.fin());

			randLenVectors(e.id, amount, e.finpow() * l, e.rotation + (muzzleBreak ? 90 : 0), rng, (x, y) -> {
				Fill.circle(e.x + x, e.y + y, e.fout() * size + (size * 0.011f));
			});
			if (muzzleBreak) {
				randLenVectors(e.id, amount, e.finpow() * l, e.rotation + 270, rng, (x, y) -> {
					Fill.circle(e.x + x, e.y + y, e.fout() * size + (size * 0.011f));
				});
			}
			Draw.reset();
		});
	}
	/** Refer to {@link UAWFx#railShoot(float, float, Color)} */
	public static Effect railShoot(float burstLength, Color color) {
		return railShoot(burstLength, burstLength * 0.5f, color);
	}
	/**
	 * Based on {@link Fx#railShoot}
	 * @param burstLength
	 * 	[85] Side Burst Length
	 * @param lifetime
	 * 	* 	[24] Effect Lifetime
	 * @param color
	 * 	The effect color
	 */
	public static Effect railShoot(float burstLength, float lifetime, Color color) {
		float l2 = lifetime * 0.41f;
		float width = burstLength * 0.15f;
		float circleRad = burstLength * 0.58f;
		float lightRad = burstLength * 2.11f;
		return new Effect(lifetime, e -> {
			e.scaled(l2, b -> {
				color(Color.white, Color.lightGray, b.fin());
				stroke(b.fout() * 3f + 0.2f);
				Lines.circle(b.x, b.y, b.fin() * circleRad);
			});
			color(color);
			for (int i : Mathf.signs) {
				Drawf.tri(e.x, e.y, width * e.fout(), burstLength, e.rotation + 90f * i);
			}
			Drawf.light(e.x, e.y, lightRad, color, 0.9f * e.fout());
		});
	}
	/**
	 * Based on Fx.railTrail
	 * @param width
	 * 	How wide is the trail, also adjusts its height, spacing have to be adjusted manually
	 * @param color
	 * 	The color of the trail
	 */
	public static Effect railTrail(float width, Color color) {
		return new Effect(width * 1.8f, e -> {
			color(color);
			for (int i : Mathf.signs) {
				Drawf.tri(e.x, e.y, width * e.fout(), (width * 2.4f), e.rotation + 90 + 90f * i);
			}
			Drawf.light(e.x, e.y, (width * 6) * e.fout(), color, 0.5f);
		});
	}
	/** Refer to {@link UAWFx#railHit(float, float, Color)} */
	public static Effect railHit(float hitLength, Color color) {
		return railHit(hitLength, hitLength * 0.3f, color);
	}
	/**
	 * Based on {@link Fx#railHit}
	 * @param hitLength
	 * 	[60] Hit length of the effect
	 * @param lifetime
	 * 	[18]
	 */
	public static Effect railHit(float hitLength, float lifetime, Color color) {
		float clipsize = hitLength * 3.33f;
		float width = hitLength * 0.16f;
		return new Effect(lifetime, clipsize, e -> {
			color(color);

			for (int i : Mathf.signs) {
				Drawf.tri(e.x, e.y, width * e.fout(), hitLength, e.rotation + 140f * i);
			}
		});
	}
	/** Refer to {@link UAWFx#circleSplash(float, float, Color, Color, Color, int)} */
	public static Effect circleSplash(float size, float lifetime, Color frontColor, Color backColor, Color splashColor) {
		return circleSplash(size, lifetime, frontColor, backColor, splashColor, 0);
	}

	/**
	 * Used with repeating aftershocks and statusfieldprojectors
	 * @param size
	 * 	How big is the affected area
	 * @param lifetime
	 * 	How long does the circle last
	 * @param splashColor
	 * 	the color that appears on the bottom of the affected area
	 * @param pointCount
	 * 	How many circling point does the effect has
	 */
	public static Effect circleSplash(float size, float lifetime, Color frontColor, Color backColor, Color splashColor, int pointCount) {
		return new Effect(lifetime, size * 2f, e -> {
			Draw.color(frontColor, backColor, e.fin());
			Lines.stroke(e.fout() * 4f);
			Lines.circle(e.x, e.y, size + e.fout() * 3f - 2f);
			Draw.reset();
			if (pointCount > 0) {
				float offset = Mathf.randomSeed(e.id, 360f);
				for (int i = 0; i < pointCount; i++) {
					float angle = (i * 360f / pointCount + (Time.time * 3)) + (offset + 4);
					float rx = Angles.trnsx(angle, size - 2f), ry = Angles.trnsy(angle, size);
					Draw.color(frontColor, backColor, e.fin());
					Drawf.tri(
						e.x + rx, e.y + ry, 48f, 28f * e.fout(), angle);
				}
			}
			Draw.z(Layer.debris);
			Fill.light(e.x, e.y, Lines.circleVertices(size / 2), size, Color.white.cpy().a(0f), Tmp.c4.set(splashColor).a(e.fout()));
			Draw.reset();
			Drawf.light(e.x, e.y, size * 1.6f, backColor, e.fout());
		});
	}
	/** Fin du code UAW */
}
