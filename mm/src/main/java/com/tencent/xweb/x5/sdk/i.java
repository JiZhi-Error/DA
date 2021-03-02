package com.tencent.xweb.x5.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;

public final class i implements c {
    @Override // com.tencent.xweb.x5.sdk.c
    public final int getTbsCoreVersion(Context context) {
        AppMethodBeat.i(154146);
        int tbsCoreVersion = WebView.getTbsCoreVersion(context);
        AppMethodBeat.o(154146);
        return tbsCoreVersion;
    }

    @Override // com.tencent.xweb.x5.sdk.c
    public final int getTbsSDKVersion(Context context) {
        AppMethodBeat.i(154147);
        int tbsSDKVersion = WebView.getTbsSDKVersion(context);
        AppMethodBeat.o(154147);
        return tbsSDKVersion;
    }

    @Override // com.tencent.xweb.x5.sdk.c
    public final String getCrashExtraMessage(Context context) {
        AppMethodBeat.i(154148);
        String crashExtraMessage = WebView.getCrashExtraMessage(context);
        AppMethodBeat.o(154148);
        return crashExtraMessage;
    }

    @Override // com.tencent.xweb.x5.sdk.c
    public final boolean getCanReboot() {
        AppMethodBeat.i(154149);
        boolean tbsNeedReboot = WebView.getTbsNeedReboot();
        AppMethodBeat.o(154149);
        return tbsNeedReboot;
    }
}
