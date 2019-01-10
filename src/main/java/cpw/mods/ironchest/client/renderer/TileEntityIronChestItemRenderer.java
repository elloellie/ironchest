package cpw.mods.ironchest.client.renderer;

import cpw.mods.ironchest.common.blocks.BlockChest;
import cpw.mods.ironchest.common.blocks.IronChestType;
import cpw.mods.ironchest.common.tileentity.TileEntityCopperChest;
import cpw.mods.ironchest.common.tileentity.TileEntityCrystalChest;
import cpw.mods.ironchest.common.tileentity.TileEntityDiamondChest;
import cpw.mods.ironchest.common.tileentity.TileEntityDirtChest;
import cpw.mods.ironchest.common.tileentity.TileEntityGoldChest;
import cpw.mods.ironchest.common.tileentity.TileEntityIronChest;
import cpw.mods.ironchest.common.tileentity.TileEntityObsidianChest;
import cpw.mods.ironchest.common.tileentity.TileEntitySilverChest;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TileEntityIronChestItemRenderer extends TileEntityItemStackRenderer
{
    private static final TileEntityIronChest IRON_CHEST = new TileEntityIronChest();

    private static final TileEntityGoldChest GOLD_CHEST = new TileEntityGoldChest();

    private static final TileEntityDiamondChest DIAMOND_CHEST = new TileEntityDiamondChest();

    private static final TileEntityCopperChest COPPER_CHEST = new TileEntityCopperChest();

    private static final TileEntitySilverChest SILVER_CHEST = new TileEntitySilverChest();

    private static final TileEntityCrystalChest CRYSTAL_CHEST = new TileEntityCrystalChest();

    private static final TileEntityObsidianChest OBSIDIAN_CHEST = new TileEntityObsidianChest();

    private static final TileEntityDirtChest DIRT_CHEST = new TileEntityDirtChest();

    private static final TileEntityIronChest[] CHESTS = { IRON_CHEST, GOLD_CHEST, DIAMOND_CHEST, COPPER_CHEST, SILVER_CHEST, CRYSTAL_CHEST, OBSIDIAN_CHEST,
            DIRT_CHEST };

    public static TileEntityIronChestItemRenderer instance = new TileEntityIronChestItemRenderer();

    @Override
    public void renderByItem(ItemStack itemStackIn)
    {
        Item item = itemStackIn.getItem();

        if (Block.getBlockFromItem(item) instanceof BlockChest)
        {
            IronChestType typeOut = BlockChest.getTypeFromItem(item);
            if (typeOut == null)
            {
                TileEntityRendererDispatcher.instance.renderAsItem(IRON_CHEST);
            }
            else
            {
                TileEntityRendererDispatcher.instance.renderAsItem(CHESTS[typeOut.ordinal()]);
            }
        }
        else
        {
            super.renderByItem(itemStackIn);
        }
    }
}
