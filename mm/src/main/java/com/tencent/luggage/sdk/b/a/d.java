package com.tencent.luggage.sdk.b.a;

import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.WeChatHosts;

public interface d {
    public static final String czw = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2b) + FilePathGenerator.ANDROID_DIR_SEP);
    public static final String[] czx = {"wxa_library/android.js", "wxa_library/webview_pf.js"};
    public static final String[] czy = {"WAWebview.js", "WAVConsole.js", "WAPerf.js", "WARemoteDebug.js"};

    public static class a extends q.a {
        public int czA;
        public String czz;
        public String scriptName;
    }
}
