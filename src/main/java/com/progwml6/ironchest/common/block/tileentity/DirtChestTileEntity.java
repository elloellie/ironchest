package com.progwml6.ironchest.common.block.tileentity;

import com.progwml6.ironchest.common.block.IronChestsBlocks;
import com.progwml6.ironchest.common.block.IronChestsTypes;
import com.progwml6.ironchest.common.inventory.IronChestContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.StringNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class DirtChestTileEntity extends GenericIronChestTileEntity {

  private static ItemStack dirtChest9000GuideBook = new ItemStack(Items.WRITTEN_BOOK);

  private static boolean bookDataCreated = false;

  public DirtChestTileEntity() {
    super(IronChestsTileEntityTypes.DIRT_CHEST.get(), IronChestsTypes.DIRTCHEST9000, IronChestsBlocks.DIRT_CHEST::get);
  }

  @Override
  protected Container createMenu(int id, PlayerInventory playerInventory) {
    return IronChestContainer.createDirtContainer(id, playerInventory, this);
  }

  @Override
  public void wasPlaced(LivingEntity entityLivingBase, ItemStack itemStack) {
    if (!(itemStack.hasTag() && itemStack.getTag().getBoolean("been_placed"))) {
      this.setInventorySlotContents(0, dirtChest9000GuideBook.copy());
    }

    if (!bookDataCreated) {
      createBookData();
    }
  }

  @Override
  public void removeAdornments() {
    if (!this.getItems().get(0).isEmpty() && this.getItems().get(0).isItemEqual(dirtChest9000GuideBook)) {
      this.getItems().set(0, ItemStack.EMPTY);
    }
  }

  private static void createBookData() {
    dirtChest9000GuideBook.setTagInfo("author", StringNBT.func_229705_a_("cpw"));

    dirtChest9000GuideBook.setTagInfo("title", StringNBT.func_229705_a_(I18n.format("book.ironchest.dirtchest9000.title")));

    ListNBT pages = new ListNBT();
    pages.add(StringNBT.func_229705_a_(ITextComponent.Serializer.toJson(new TranslationTextComponent("book.ironchest.dirtchest9000.page1"))));
    pages.add(StringNBT.func_229705_a_(ITextComponent.Serializer.toJson(new TranslationTextComponent("book.ironchest.dirtchest9000.page2"))));
    pages.add(StringNBT.func_229705_a_(ITextComponent.Serializer.toJson(new TranslationTextComponent("book.ironchest.dirtchest9000.page3"))));
    pages.add(StringNBT.func_229705_a_(ITextComponent.Serializer.toJson(new TranslationTextComponent("book.ironchest.dirtchest9000.page4"))));
    pages.add(StringNBT.func_229705_a_(ITextComponent.Serializer.toJson(new TranslationTextComponent("book.ironchest.dirtchest9000.page5"))));

    dirtChest9000GuideBook.setTagInfo("pages", pages);

    bookDataCreated = true;
  }
}