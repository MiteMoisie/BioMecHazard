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
	
	/** @author Eschatologue  */
	statusEffectSquare = new Effect(35f, e -> {
		color(e.color);

		randLenVectors(e.id, 3, 2f + e.fin() * 7f, (x, y) -> {
			Fill.square(e.x + x, e.y + y, 0.2f + e.fslope() * 1.5f, 45f);
		});
	}),
	// endregion Status
	
	/** @author Eschatologue  */
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
	
	/** @author Eschatologue  */
	/** Based on Fx.fireHit */
	cryoHit = new Effect(38f, e -> {
		Draw.color(cryoFront, cryoBack, e.fin());
		Angles.randLenVectors(e.id, 5, 2f + e.fin() * 10f, (x, y) -> Fill.circle(e.x + x, e.y + y, 0.2f + e.fout() * 1.6f));
		Draw.color();
	}),
	
	/** @author Eschatologue  */
	// region Shooting
	shootSmoke = new Effect(30f, e -> {
		Draw.color(e.color, Color.lightGray, Color.gray, e.fin());

		Angles.randLenVectors(e.id, 9, e.finpow() * 23f, e.rotation, 20f, (x, y) -> {
			Fill.circle(e.x + x, e.y + y, e.fout() * 2.4f + 0.2f);
		});
	})
	
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
	/** Fin du code UAW */
}



