package MysticWorld.Client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.renderer.entity.RenderFireball;
import net.minecraft.item.Item;
import net.minecraft.src.ModLoader;
import net.minecraft.world.World;
import MysticWorld.CommonProxy;
import MysticWorld.Client.FX.AirFX;
import MysticWorld.Client.FX.EarthFX;
import MysticWorld.Client.FX.EnergyFX;
import MysticWorld.Client.FX.FireFX;
import MysticWorld.Client.FX.WaterFX;
import MysticWorld.Entity.EntityChargeAir;
import MysticWorld.Entity.EntityChargeEarth;
import MysticWorld.Entity.EntityChargeEnergy;
import MysticWorld.Entity.EntityChargeFire;
import MysticWorld.Entity.EntityChargeWater;
import MysticWorld.Items.ItemHandler$1;
import MysticWorld.Renderer.RenderStaffPower;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityChargeFire.class, new RenderStaffPower(0));
		RenderingRegistry.registerEntityRenderingHandler(EntityChargeWater.class, new RenderStaffPower(1));
		RenderingRegistry.registerEntityRenderingHandler(EntityChargeEarth.class, new RenderStaffPower(2));
		RenderingRegistry.registerEntityRenderingHandler(EntityChargeAir.class, new RenderStaffPower(3));
		RenderingRegistry.registerEntityRenderingHandler(EntityChargeEnergy.class, new RenderStaffPower(4));
	}
	
	public int addArmor(String armor)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
	
	//particles
	@Override
	public void airFX(World worldObj, double x, double y, double z, float scale)
	{
		AirFX airFX = new AirFX(worldObj, x, y, z, scale);
		ModLoader.getMinecraftInstance().effectRenderer.addEffect(airFX);
	}
	
	@Override
	public void earthFX(World worldObj, double x, double y, double z, float scale)
	{
		EarthFX earthFX = new EarthFX(worldObj, x, y, z, scale);
		ModLoader.getMinecraftInstance().effectRenderer.addEffect(earthFX);
	}
	
	@Override
	public void energyFX(World worldObj, double x, double y, double z, float scale)
	{
		EnergyFX energyFX = new EnergyFX(worldObj, x, y, z, scale);
		ModLoader.getMinecraftInstance().effectRenderer.addEffect(energyFX);
	}
	
	@Override
	public void fireFX(World worldObj, double x, double y, double z, float scale)
	{
		FireFX fireFX = new FireFX(worldObj, x, y, z, scale);
		ModLoader.getMinecraftInstance().effectRenderer.addEffect(fireFX);
	}
	
	@Override
	public void waterFX(World worldObj, double x, double y, double z, float scale)
	{
		WaterFX waterFX = new WaterFX(worldObj, x, y, z, scale);
		ModLoader.getMinecraftInstance().effectRenderer.addEffect(waterFX);
	}
	
}
