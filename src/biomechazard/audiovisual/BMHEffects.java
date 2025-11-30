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
	})
	
	;
}


