package mobs;

import main.Mainclass;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityFireElemental extends EntityMob{

	public EntityFireElemental(World p_i1738_1_) {
		super(p_i1738_1_);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
		this.isImmuneToFire = true;
		}

		public void onLivingUpdate() {
			for (int i = 0; i < 2; ++i) {
				this.worldObj.spawnParticle("largesmoke", this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width,
						this.posY + this.rand.nextDouble() * (double) this.height,
						this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width, 0.0D, 0.0D, 0.0D);
			}

			super.onLivingUpdate();
			{
				 if (!this.worldObj.isRemote)
			        {
			            if (this.isWet())
			            {
			                this.attackEntityFrom(DamageSource.drown, 1.0F);
			            }
			}
			}
		}
		 protected void fall(float p_70069_1_) {}

		    protected Item getDropItem()
		    {
		        return Mainclass.Infernium;
		    }
		    public void onLivingUpdate1()
		    {}}
		
		           
		

