package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public final class c {
    public static final String icB = com.tencent.mm.loader.j.c.icB;
    public static final String jDG = WeChatHosts.domainString(R.string.e1s);
    public static final int[] jDH = {8080, 80, JsApiPauseDownloadTask.CTRL_INDEX};
    public static final String jDI = WeChatHosts.domainString(R.string.e2c);
    public static final int[] jDJ = {80};

    static {
        AppMethodBeat.i(197090);
        AppMethodBeat.o(197090);
    }
}
