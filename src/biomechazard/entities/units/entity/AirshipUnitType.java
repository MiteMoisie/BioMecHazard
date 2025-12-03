/**
* @author Eschatologue 
* mod "Unlimited Armament Works"
*/

package biomechazard.entities.units.entity;

import mindustry.ai.types.FlyingAI;
import biomechazard.entities.units.HelicopterUnitType;

public class AirshipUnitType extends HelicopterUnitType {
	public AirshipUnitType(String name) {
		super(name);
		lowAltitude = true;
		flying = true;
		faceTarget = false;
		aiController = FlyingAI::new;
	}
}
