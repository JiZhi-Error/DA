package com.tencent.mm.plugin.appbrand.openmaterial.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b {
    WEB_VIEW("webview", 1),
    nlN("image", 2),
    nlO("video", 2),
    ATTACH("attach", 4);
    
    public final String FVD;
    private final int nlQ;

    public static b valueOf(String str) {
        AppMethodBeat.i(194364);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(194364);
        return bVar;
    }

    static {
        AppMethodBeat.i(194365);
        AppMethodBeat.o(194365);
    }

    private b(String str, int i2) {
        this.FVD = str;
        this.nlQ = i2;
    }

    public final boolean isEnabled(int i2) {
        return (this.nlQ & i2) != 0;
    }
}
