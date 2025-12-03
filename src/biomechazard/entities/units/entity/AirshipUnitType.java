/**
* @author Eschatologue 
* mod "Unlimited Armament Works"
*/

package biomechazard.entities.units.entity;

import biomechazard.entities.units.HelicopterUnitType;
import mindustry.ai.types.FlyingAI;

public class AirshipUnitType extends HelicopterUnitType {
	public AirshipUnitType(String name) {
		super(name);
		lowAltitude = true;
		flying = true;
		faceTarget = false;
		aiController = FlyingAI::new;
	}
}
