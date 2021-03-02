package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;

public class AssetExtension {
    public static final String SCENE_EXPORT = "export";
    public static final String SCENE_PLAY = "play";
    public static final String SCENE_THUMBNAIL = "thumbnail";
    private volatile ConcurrentHashMap<String, Object> extensionMap = new ConcurrentHashMap<>();
    private final String scene;

    public AssetExtension(String str) {
        AppMethodBeat.i(217730);
        this.scene = str;
        AppMethodBeat.o(217730);
    }

    public void addExtension(String str, Object obj) {
        AppMethodBeat.i(217731);
        this.extensionMap.put(str, obj);
        AppMethodBeat.o(217731);
    }

    public boolean containsKey(String str) {
        AppMethodBeat.i(217732);
        boolean containsKey = this.extensionMap.containsKey(str);
        AppMethodBeat.o(217732);
        return containsKey;
    }

    public boolean containsValue(String str) {
        AppMethodBeat.i(217733);
        boolean containsValue = this.extensionMap.containsValue(str);
        AppMethodBeat.o(217733);
        return containsValue;
    }

    public Object remove(String str) {
        AppMethodBeat.i(217734);
        Object remove = this.extensionMap.remove(str);
        AppMethodBeat.o(217734);
        return remove;
    }

    public String getScene() {
        return this.scene;
    }
}
