package net.healer.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Unit;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.EitherHolder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.JukeboxPlayable;
import net.minecraft.world.item.JukeboxSong;
import org.jetbrains.annotations.NotNull;

/**
 * This is a helper class that extends the Item.Properties class,
 * providing additional convenience methods for customizing item properties.
 * The methods in this class help modify various item attributes like durability,
 * stack size, food properties, crafting remainder, fire resistance, and jukebox functionality.
 * These custom methods allow a more modular and cleaner approach when defining item properties.
 */
public class HealerItemProperties extends Item.Properties {
    Item craftingRemainingItem;

    /**
     * Sets the item that remains after crafting.
     *
     * @param Craft The item that will remain after crafting.
     * @return The current Properties instance with the updated crafting remainder.
     */
    public Item.@NotNull Properties CraftRemainder(@NotNull Item Craft) {
        this.craftingRemainingItem = Craft;
        return this;
    }

    /**
     * Marks the item as Fire-Resistant, preventing it from burning.
     *
     * @return The current Properties instance with fire resistance.
     */
    public Item.@NotNull Properties FireResistant() {
        return this.component(DataComponents.FIRE_RESISTANT, Unit.INSTANCE);
    }

    /**
     * Allows the item to be played in a jukebox.
     *
     * @param Song The song to be played in the jukebox.
     * @return The current Properties instance with jukebox functionality.
     */
    public Item.@NotNull Properties JukeboxPlayable(@NotNull ResourceKey<JukeboxSong> Song) {
        return this.component(DataComponents.JUKEBOX_PLAYABLE, new JukeboxPlayable(new EitherHolder<>(Song), true));
    }

    /**
     * Sets the durability of the item and modifies its stack size to 1.
     *
     * @param Durability The maximum durability of the item.
     * @return The current Properties instance with the updated durability.
     */
    public Item.@NotNull Properties Durability(int Durability) {
        this.component(DataComponents.MAX_DAMAGE, Durability);
        this.component(DataComponents.MAX_STACK_SIZE, 1);
        this.component(DataComponents.DAMAGE, 0);
        return this;
    }

    /**
     * Sets the food properties for the item, such as hunger and effects.
     *
     * @param Food The food properties to be applied to the item.
     * @return The current Properties instance with the updated food properties.
     */
    public Item.@NotNull Properties Food(@NotNull FoodProperties Food) {
        return super.food(Food);
    }

    /**
     * Sets the maximum stack size for the item.
     *
     * @param StackSize The maximum stack size for the item.
     * @return The current Properties instance with the updated stack size.
     */
    public Item.@NotNull Properties StacksTo(int StackSize) {
        return super.stacksTo(StackSize);
    }
}