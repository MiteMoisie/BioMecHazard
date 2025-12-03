/**
* @author Eschatologue 
* mod "Unlimited Armament Works"
*/

package biomechazard.type.weapon;

import mindustry.type.*;

/** Weapon that kills the user */
public class SuicideWeapon extends Weapon {
	public SuicideWeapon(String name) {
		this.name = name;
		shootCone = 360f;
		shootOnDeath = true;
		mirror = false;
		reload = 1f;
		shake = 5;
	}

	public SuicideWeapon() {
		this("");
	}

}
