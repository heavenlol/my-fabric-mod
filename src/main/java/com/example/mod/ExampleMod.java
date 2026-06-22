package com.example.mod;

import net.fabricmc.api.ModInitializer;
import ice1000.jimgui.JImGui;

public class ExampleMod implements ModInitializer {
    public static JImGui imGui;
    private static boolean menuOpen = false;

    @Override
    public void onInitialize() {
        System.out.println("Mod loaded! Press INSERT in-game to test the menu.");
        
        // Start a separate background thread for ImGui so it doesn't crash Minecraft's main engine
        Thread imGuiThread = new Thread(() -> {
            imGui = new JImGui();
            while (!imGui.windowShouldClose()) {
                if (menuOpen) {
                    imGui.initNewFrame();
                    
                    // This is your actual window setup
                    imGui.begin("Termux Mod Menu");
                    imGui.text("Hello! This menu was compiled entirely on GitHub Actions.");
                    
                    if (imGui.button("Close Menu")) {
                        menuOpen = false;
                    }
                    
                    imGui.end();
                    imGui.render();
                } else {
                    // Sleep briefly when closed to save CPU
                    try { Thread.sleep(100); } catch (InterruptedException e) {}
                }
            }
        });
        imGuiThread.setDaemon(true);
        imGuiThread.start();
    }

    // Call this method from a keybind or mixin to toggle the window
    public static void toggleMenu() {
        menuOpen = !menuOpen;
    }
}
