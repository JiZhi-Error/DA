package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    public final String appId;
    public final String dCx;
    public final String videoUrl;

    public c(String str, String str2, String str3) {
        this.appId = str;
        this.dCx = str2;
        this.videoUrl = str3;
    }

    public final String toString() {
        AppMethodBeat.i(219508);
        String str = "AppBrandPipEventBaseInfo{appId='" + this.appId + '\'' + ", pagePath='" + this.dCx + '\'' + ", videoUrl='" + this.videoUrl + '\'' + '}';
        AppMethodBeat.o(219508);
        return str;
    }
}
