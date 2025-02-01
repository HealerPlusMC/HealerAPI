package net.healer.item;

import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.JukeboxPlayableComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryPair;
import net.minecraft.util.Unit;
import org.jetbrains.annotations.NotNull;

public final class HealerItemSettings extends Item.Settings {
    Item craftingRemainingItem;

    /**
     * Sets the item that remains after crafting.
     *
     * @param Craft The item that will remain after crafting.
     * @return The current Settings instance with the updated crafting remainder.
     */
    public Item.@NotNull Settings CraftRemainder(@NotNull Item Craft) {
        this.craftingRemainingItem = Craft;
        return this;
    }

    /**
     * Marks the item as Fire-Resistant, preventing it from burning.
     *
     * @return The current Settings instance with fire resistance.
     */
    public Item.@NotNull Settings FireResistant() {
        return this.component(DataComponentTypes.FIRE_RESISTANT, Unit.INSTANCE);
    }

    /**
     * Allows the item to be played in a jukebox.
     *
     * @param Song The song to be played in the jukebox.
     * @return The current Settings instance with jukebox functionality.
     */
    public Item.Settings jukeboxPlayable(RegistryKey<JukeboxSong> Song) {
        return this.component(DataComponentTypes.JUKEBOX_PLAYABLE, new JukeboxPlayableComponent(new RegistryPair<>(Song), true));
    }

    /**
     * Sets the durability of the item and modifies its stack size to 1.
     *
     * @param Durability The maximum durability of the item.
     * @return The current Settings instance with the updated durability.
     */
    public Item.@NotNull Settings Durability(int Durability) {
        this.component(DataComponentTypes.MAX_DAMAGE, Durability);
        this.component(DataComponentTypes.MAX_STACK_SIZE, 1);
        this.component(DataComponentTypes.DAMAGE, 0);
        return this;
    }

    /**
     * Sets the food Settings for the item, such as hunger and effects.
     *
     * @param Food The food Settings to be applied to the item.
     * @return The current Settings instance with the updated food Settings.
     */
    public Item.@NotNull Settings Food(@NotNull FoodComponent Food) {
        return super.food(Food);
    }

    /**
     * Sets the maximum stack size for the item.
     *
     * @param MaxCount The maximum stack size for the item.
     * @return The current Settings instance with the updated stack size.
     */
    public Item.@NotNull Settings MaxCount(int MaxCount) {
        return super.maxCount(MaxCount);
    }
}
