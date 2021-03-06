package MysticWorld.Items;

import java.util.List;

import MysticWorld.MysticWorld;
import MysticWorld.Reference;
import MysticWorld.Lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemBushFruit extends ItemFood {
	
	private Icon[] icons;
	
    private static final String[] FRUIT_TYPES = new String[] {"Mundane", "Poison", "Weakness", "Slowness", "Harming", "Wither", "Health", "Speed", "Fire Resistance", "Regen", "Night Vision", "Invisibility"};


	public ItemBushFruit(int id, int health)
	{
		super(id, health, 0.6F, false);
        this.setHasSubtypes(true);
        this.setUnlocalizedName(Strings.BUSH_FRUIT_NAME);
        this.setCreativeTab(MysticWorld.MysticWorldTab);
        maxStackSize = 64;
        setAlwaysEdible();
	}
	
	  public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer player)
	  {
	    if ((player.canEat(true)) && (player.getFoodStats().getSaturationLevel() < 20.0F))
	    {
	      player.setItemInUse(par1ItemStack, getMaxItemUseDuration(par1ItemStack));
	    }

	    return par1ItemStack;
	  }
	  
	  protected void onFoodEaten(ItemStack itemstack, World world, EntityPlayer player)
	  {
		  if (!world.isRemote)
		  {
			  int duration = 0;
			  PotionEffect potion;
			  switch(itemstack.getItemDamage())
			  {
				  case 1:potion = player.getActivePotionEffect(Potion.poison);
				  if(potion != null)
				  {
					  duration = potion.duration;
				  }
				  player.addPotionEffect(new PotionEffect(Potion.poison.id, duration + 160, 0));
				  break;
				  case 2:potion = player.getActivePotionEffect(Potion.weakness);
				  if(potion != null)
				  {
					  duration = potion.duration;
				  }
				  player.addPotionEffect(new PotionEffect(Potion.weakness.id, duration + 160, 0));
				  break;
				  case 3:potion = player.getActivePotionEffect(Potion.moveSlowdown);
				  if(potion != null)
				  {
					  duration = potion.duration;
				  }
				  player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, duration + 160, 0));
				  break;
				  case 4:potion = player.getActivePotionEffect(Potion.harm);
				  if(potion != null)
				  {
					  duration = potion.duration;
				  }
				  player.addPotionEffect(new PotionEffect(Potion.harm.id, duration + 1, 0));
				  break;
				  case 5:potion = player.getActivePotionEffect(Potion.wither);
				  if(potion != null)
				  {
					  duration = potion.duration;
				  }
				  player.addPotionEffect(new PotionEffect(Potion.wither.id, duration + 160, 0));
				  break;
				  case 6:potion = player.getActivePotionEffect(Potion.heal);
				  if(potion != null)
				  {
					  duration = potion.duration;
				  }
				  player.addPotionEffect(new PotionEffect(Potion.heal.id, duration + 1, 0));
				  break;
				  case 7:potion = player.getActivePotionEffect(Potion.moveSpeed);
				  if(potion != null)
				  {
					  duration = potion.duration;
				  }
				  player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, duration + 160, 0));
				  break;
				  case 8:potion = player.getActivePotionEffect(Potion.fireResistance);
				  if(potion != null)
				  {
					  duration = potion.duration;
				  }
				  player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, duration + 160, 0));
				  break;
				  case 9:potion = player.getActivePotionEffect(Potion.regeneration);
				  if(potion != null)
				  {
					  duration = potion.duration;
				  }
				  player.addPotionEffect(new PotionEffect(Potion.regeneration.id, duration + 160, 0));
				  break;
				  case 10:potion = player.getActivePotionEffect(Potion.nightVision);
				  if(potion != null)
				  {
					  duration = potion.duration;
				  }
				  player.addPotionEffect(new PotionEffect(Potion.nightVision.id, duration + 160, 0));
				  break;
				  case 11:potion = player.getActivePotionEffect(Potion.invisibility);
				  if(potion != null)
				  {
					  duration = potion.duration;
				  }
				  player.addPotionEffect(new PotionEffect(Potion.invisibility.id, duration + 160, 0));
				  break;
			  }
		  }
	  }

	  public int getMaxItemUseDuration(ItemStack itemstack)
	  {
	    return 24;
	  }
	
    @Override
    public String getUnlocalizedName(ItemStack itemStack) {

        int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, 5);
        return super.getUnlocalizedName() + FRUIT_TYPES[meta];
    }
  
	 @Override
	 @SideOnly(Side.CLIENT)
	 public void registerIcons(IconRegister iconRegister)
	 {
		 icons = new Icon[FRUIT_TYPES.length];
		 
	     for (int i = 0; i < FRUIT_TYPES.length; ++i) {
	            icons[i] = iconRegister.registerIcon("MysticTextures" + ":" + "item.fruit_" + i);
	        }
	    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIconFromDamage(int meta) {

        int j = MathHelper.clamp_int(meta, 0, FRUIT_TYPES.length);
        return icons[j];
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
      for (int var4 = 0; var4 < FRUIT_TYPES.length; var4++)
      {
        par3List.add(new ItemStack(par1, 1, var4));
      }
    }
}

