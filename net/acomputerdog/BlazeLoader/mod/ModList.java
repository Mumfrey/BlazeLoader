package net.acomputerdog.BlazeLoader.mod;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ModList {
    private static final List<Mod> loadedMods = new ArrayList<Mod>();
    private static final List<Class> unloadedMods = new ArrayList<Class>();

    public static List<Mod> getLoadedMods(){
        return loadedMods;
    }

    public static List<Class> getUnloadedMods(){
        return unloadedMods;
    }

    public static void addMod(Mod mod){
        loadedMods.add(mod);
    }

    public static void addMod(Class mod){
        unloadedMods.add(mod);
    }

    public static void startAllMods(){
        for(Class cls : unloadedMods){
            try {
                loadedMods.add((Mod)cls.getDeclaredConstructor(void.class).newInstance(null));
            } catch (ReflectiveOperationException e){
                System.out.println("[BlazeLoader] Could not start plugin: " + cls.getName());
                e.printStackTrace();
            }
        }
    }
}
