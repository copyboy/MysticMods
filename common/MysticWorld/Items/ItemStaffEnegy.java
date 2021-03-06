package MysticWorld.Items;

import MysticWorld.MysticWorld;
import MysticWorld.Entity.EntityChargeEnergy;
import MysticWorld.Entity.EntityChargeFire;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemStaffEnegy extends Item{
	
	public ItemStaffEnegy(int id) {
		super(id);
        this.setMaxStackSize(1);
        this.setMaxDamage(64);
		this.setCreativeTab(MysticWorld.MysticWorldTab);
	}
	
	  @Override
	    public void registerIcons(IconRegister iconRegister)
	    {
	             itemIcon = iconRegister.registerIcon("MysticTextures" + ":" + "item.EnergyStaff");
	    }
	
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer){
		world.playAuxSFXAtEntity((EntityPlayer)null, 1009, (int)entityPlayer.posX, (int)entityPlayer.posY, (int)entityPlayer.posZ, 0);
	
        if (!world.isRemote)
        {
            world.spawnEntityInWorld(new EntityChargeEnergy(world, entityPlayer));
            
            itemStack.damageItem(1, entityPlayer);
        }
        
        return itemStack;
	}

}
