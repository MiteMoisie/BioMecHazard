package biomechazard.audiovisual;

import arc.Core;
import arc.assets.AssetDescriptor;
import arc.assets.loaders.SoundLoader;
import arc.audio.Sound;
import mindustry.Vars;

public class BMHSoundEffects {
	
	public static Sound vanillaMissileLong = new Sound();
	public static Sound vanillaShootSpectre = new Sound();
	
	public static Sound nrexp = new Sound();
	public static Sound cavalryShoot = new Sound();
	public static Sound crush = new Sound();
	public static Sound energyCharge = new Sound();
	public static Sound gasTorchBurn = new Sound();
	public static Sound gattlingShoot = new Sound();
	public static Sound hugeLaserCharge = new Sound();
	public static Sound missileSiloLaunch = new Sound();
	public static Sound nukeHit = new Sound();
	
	protected static Sound loadSound(String fileName) {
		String name = "sounds/" + fileName;
		String path = Vars.tree.get(name + ".ogg").exists() ? name + ".ogg" : name + ".mp3";

		Sound sound = new Sound();

		AssetDescriptor<?> desc = Core.assets.load(path, Sound.class, new SoundLoader.SoundParameter(sound));
		desc.errored = Throwable::printStackTrace;

		return sound;
	}
	
	public static void load() {
		if (Vars.headless) return;
		vanillaMissileLong = loadSound("vanillaMissileLong");
		vanillaShootSpectre = loadSound("vanillaShootSpectre");
		
		nrexp = loadSound("nrexp");
		cavalryShoot = new loadSound("cavalry-shoot");
		crush = loadSound("crush");
		energyCharge = loadSound("energy-charge");
		gasTorchBurn = loadSound("gas-torch-burn");
		gattlingShoot = loadSound("gattling-shoot");
		hugeLaserCharge = loadSound("huge-laser-charge");
		missileSiloLaunch = loadSound("missile-silo-launch");
		nukeHit = loadSound("nuke-hit");
	}
	

}


