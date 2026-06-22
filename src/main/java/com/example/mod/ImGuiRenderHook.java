package com.example.mod;

// Note: Your chosen ImGui wrapper library will dictate the exact wrapper callbacks.
// This handles passing the draw commands down to the ExampleMod layout method.
public class ImGuiRenderHook {
    
    public static void onRender() {
        // 1. Start the ImGui Frame
        // (Usually handled automatically by libraries like Fabric-GUI-ImGui or ImGuiMC)
        
        // 2. Call your custom layout
        com.example.mod.ExampleMod.drawImGuiLayout();
        
        // 3. End the ImGui Frame and hand it off to the GPU
    }
}
