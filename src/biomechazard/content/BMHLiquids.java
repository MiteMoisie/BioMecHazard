package biomechazard.content;

import arc.graphics.Color;
import mindustry.content.*;
import mindustry.type.*;
import mindustry.type.Liquid;
import mindustry.content.StatusEffects;
import biomechazard.audiovisual.UAWPal;

import static mindustry.content.Items.*;

/**
* Liquides issus du mod "Unlimited Armament Works" : phlogiston liquidOxygen glycerine nitroglycerine surgeSolvent
* 	steam liquefiedPetroleumGas
* Liquides issus du mod "Fading Revelations" : acid livingSteelLiquid neutronFluid
*  waterVapor
*/

public class BMHLiquids {
	public static Liquid 
	// Liquid
	phlogiston, liquidOxygen, glycerine, nitroglycerine, surgeSolvent, acid, livingSteelLiquid, neutronFluid, 
	// Gas
	steam, liquefiedPetroleumGas, waterVapor;

	public static void load() {

		phlogiston = new Liquid("phlogiston", UAWPal.phlogiston) {{
			viscosity = 0.75f;
			flammability = Liquids.oil.flammability * 2.25f;
			explosiveness = Liquids.oil.explosiveness * 2.5f;
			heatCapacity = 0.85f;
			temperature = 4f;
			barColor = UAWPal.phlogistonMid;
			boilPoint = -1;
			gasColor = UAWPal.phlogistonFront;
			canStayOn.add(Liquids.oil);
			coolant = false;
		}};
		
		steam = new Liquid("steam", UAWPal.steamFront) {{
			gas = true;
			alwaysUnlocked = true;
			explosiveness = 0f;
			temperature = 0.75f;
			effect = StatusEffects.wet;
		}};
		
		liquefiedPetroleumGas = new Liquid("liquefied-petroleum-gas", Color.valueOf("6586b0")) {{
			gas = true;
		}};
		
		surgeSolvent = new Liquid("surge-solvent", Color.valueOf("f3e979")) {{
			
		}};
		
		acid = new CellLiquid("acid", Color.valueOf("cde03a")) {{
			viscosity = 0.2f;
			moveThroughBlocks = false;
			incinerable = false;
			capPuddles = true;
			temperature = 0.2f;
			coolant = false;
			blockReactive = false;
			//effect = BMHStatusEffects."me-acidic-burn";
			spreadDamage = 0f;
			maxSpread = 0f;
			colorFrom = Color.valueOf("b0bf1a");
			colorTo = Color.valueOf("f8f854");
		}};
		livingSteelLiquid = new CellLiquid("living-steel-liquid", Color.valueOf("9000a4")) {{
			viscosity = 0.2f;
			moveThroughBlocks = true;
			canStayOn.add(Liquids.oil);
			heatCapacity = 0.9f;
			explosiveness = 0.05f;
			incinerable = true;
			capPuddles = true;
			temperature = 0.125f;
			blockReactive = false;
			flammability = 1f;
			viscosity = 0.6f;
			spreadTarget = Liquids.oil;
			maxSpread = 0.4f;
			colorFrom = Color.valueOf("6d0071");
			colorTo = Color.valueOf("9e78dc");
		}};
		neutronFluid = new Liquid("neutron-fluid", Color.valueOf("e9e9e9")) {{
			heatCapacity = 1.5f;
			explosiveness = 2.5f;
			temperature = 0.1f;
			viscosity = 0.5f;
			flammability = 0f;
			coolant = true;
			//effect = BMHStatusEffects."me-neutron-frozen"
		}};
		waterVapor = new Liquid("water-vapor", Color.valueOf("ececec")) {{
			heatCapacity = 1.5f;
			explosiveness = 0f;
			temperature = 0.1f;
			gas = true;
			gasColor = Color.valueOf("ececec");
			flammability = 0f;
			coolant = false;
		}};
	}
}