package com.facebook.appevents.codeless.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class UnityReflection {
    private static final String CAPTURE_VIEW_HIERARCHY_METHOD = "CaptureViewHierarchy";
    private static final String EVENT_MAPPING_METHOD = "OnReceiveMapping";
    private static final String FB_UNITY_GAME_OBJECT = "UnityFacebookSDKPlugin";
    private static final String TAG = UnityReflection.class.getCanonicalName();
    private static final String UNITY_PLAYER_CLASS = "com.unity3d.player.UnityPlayer";
    private static final String UNITY_SEND_MESSAGE_METHOD = "UnitySendMessage";
    private static Class<?> unityPlayer;

    static {
        AppMethodBeat.i(17552);
        AppMethodBeat.o(17552);
    }

    public static void sendMessage(String str, String str2, String str3) {
        AppMethodBeat.i(17549);
        try {
            if (unityPlayer == null) {
                unityPlayer = Class.forName(UNITY_PLAYER_CLASS);
            }
            unityPlayer.getMethod(UNITY_SEND_MESSAGE_METHOD, String.class, String.class, String.class).invoke(unityPlayer, str, str2, str3);
            AppMethodBeat.o(17549);
        } catch (Exception e2) {
            AppMethodBeat.o(17549);
        }
    }

    public static void captureViewHierarchy() {
        AppMethodBeat.i(17550);
        sendMessage(FB_UNITY_GAME_OBJECT, CAPTURE_VIEW_HIERARCHY_METHOD, "");
        AppMethodBeat.o(17550);
    }

    public static void sendEventMapping(String str) {
        AppMethodBeat.i(17551);
        sendMessage(FB_UNITY_GAME_OBJECT, EVENT_MAPPING_METHOD, str);
        AppMethodBeat.o(17551);
    }
}
