package com.tencent.mm.sdk.platformtools;

public class WeChatEnvironment {
    private static boolean coolassistEnv = false;
    private static String debuggerApiLevel = null;
    private static boolean hasDebugger = false;
    private static boolean monkeyEnv = false;

    public static void setMonkeyEnv(boolean z) {
        monkeyEnv = z;
    }

    public static void setCoolassistEnv(boolean z) {
        coolassistEnv = z;
    }

    public static boolean isMonkeyEnv() {
        return monkeyEnv;
    }

    public static boolean isCoolassistEnv() {
        return coolassistEnv;
    }

    public static void setHasDebugger(boolean z) {
        hasDebugger = z;
    }

    public static boolean hasDebugger() {
        return hasDebugger;
    }

    public static void setDebuggerApiLevel(String str) {
        debuggerApiLevel = str;
    }

    public static String getDebuggerApiLevel() {
        return debuggerApiLevel;
    }
}
