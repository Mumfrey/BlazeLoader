package net.acomputerdog.BlazeLoader.api.item;

import net.acomputerdog.BlazeLoader.main.BlazeLoader;
import net.minecraft.src.Item;

public class ApiItem {

    /**
     * Gets an available item ID.  Throws a RuntimeException if none are available.
     * @return Returns a free Item ID
     */
    public static int getFreeItemId(){
        if(Item.itemsList[BlazeLoader.freeItemId] == null){
            int id = BlazeLoader.freeItemId;
            BlazeLoader.freeItemId++;
            return id;
        }else{
            int id = BlazeLoader.updateFreeItemId();
            BlazeLoader.freeItemId++;
            return id;
        }
    }

    /**
     * Gets an available item ID, checking for used IDs that have been freed.
     * Throws a RuntimeException if none are available.
     * @return Returns a free Item ID.
     */
    public static int recheckItemIds(){
        int id = BlazeLoader.resetFreeItemId();
        BlazeLoader.freeItemId++;
        return id;
    }
}
