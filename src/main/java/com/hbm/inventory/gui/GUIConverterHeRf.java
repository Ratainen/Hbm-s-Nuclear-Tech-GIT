package com.hbm.inventory.gui;

import org.lwjgl.opengl.GL11;

import com.hbm.inventory.container.ContainerConverterHeRf;
import com.hbm.lib.RefStrings;
import com.hbm.tileentity.machine.TileEntityConverterHeRf;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class GUIConverterHeRf extends GuiContainer {

	private static ResourceLocation texture = new ResourceLocation(RefStrings.MODID + ":textures/gui/gui_he_rf_converter.png");
	private TileEntityConverterHeRf diFurnace;

	public GUIConverterHeRf(EntityPlayer invPlayer, TileEntityConverterHeRf tedf) {
		super(new ContainerConverterHeRf(invPlayer, tedf));
		diFurnace = tedf;
		
		this.xSize = 176;
		this.ySize = 86;
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j) {
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		super.drawScreen(mouseX, mouseY, partialTicks);
		super.renderHoveredToolTip(mouseX, mouseY);
		if(mouseX > guiLeft + 28 && mouseX < guiLeft + 28 + 12 && mouseY < guiTop + 69 && mouseY > guiTop + 69 - 52){
			this.drawHoveringText(diFurnace.power + " HE", mouseX, mouseY);
		}
		if(mouseX > guiLeft + 136 && mouseX < guiLeft + 136 + 12 && mouseY < guiTop + 69 && mouseY > guiTop + 69 - 52){
			this.drawHoveringText(diFurnace.storage.getEnergyStored() + " RF", mouseX, mouseY);
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		super.drawDefaultBackground();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		if(diFurnace.power > 0) {
			int i = (int)diFurnace.getPowerScaled(52);
			drawTexturedModalRect(guiLeft + 28, guiTop + 69 - i, 176, 52 - i, 12, i);
		}
		
		if(diFurnace.storage.getEnergyStored() > 0) {
			int i = (int)diFurnace.getFluxScaled(52);
			drawTexturedModalRect(guiLeft + 136, guiTop + 69 - i, 188, 52 - i, 12, i);
		}
	}
}
