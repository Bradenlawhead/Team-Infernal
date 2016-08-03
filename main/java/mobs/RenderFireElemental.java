
package mobs;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderDragon;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderFireElemental extends RenderLiving {

	private static final ResourceLocation Textures = new ResourceLocation("ai:textures/entity/fire_elemental.png");

	public RenderFireElemental(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
	}

	protected ResourceLocation getEntityTexture(EntityFireElemental entity) {
		return Textures;
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getEntityTexture((EntityFireElemental) entity);
	}

	protected void preRenderCallback(EntityLivingBase entity, float f) {
		GL11.glScalef(1F, 1F, 1F);
	}
}