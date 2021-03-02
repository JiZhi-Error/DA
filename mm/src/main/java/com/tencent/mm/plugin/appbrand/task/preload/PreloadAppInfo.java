package com.tencent.mm.plugin.appbrand.task.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public class PreloadAppInfo {
    private static final String TAG = "PreloadAppInfo";
    String appId;
    int appType;
    float openRate;
    String path;

    PreloadAppInfo() {
    }

    public String toString() {
        AppMethodBeat.i(48509);
        String format = String.format("preloadAppInfo appId:%s,appType:%d,path:%s,openRate:%f", this.appId, Integer.valueOf(this.appType), this.path, Float.valueOf(this.openRate));
        AppMethodBeat.o(48509);
        return format;
    }
}
