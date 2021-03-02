package com.tencent.mm.plugin.webview.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.util.HashSet;
import java.util.Set;

public final class a {
    public static final String ILp = (WeChatHosts.domainString(R.string.e2l) + ";" + WeChatHosts.domainString(R.string.e2_) + ";" + WeChatHosts.domainString(R.string.e2n) + ";wx-credit-repay.tencent.com;chong.qq.com;qian.tenpay.com;" + WeChatHosts.domainString(R.string.e26) + ";" + WeChatHosts.domainString(R.string.e25) + ";wx.tenpay.com");
    public static final Set<String> ILq = new HashSet<String>() {
        /* class com.tencent.mm.plugin.webview.core.a.AnonymousClass1 */

        {
            AppMethodBeat.i(224210);
            add("application/msword");
            add("application/vnd.ms-powerpoint");
            add("application/vnd.ms-excel");
            add("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
            add("application/vnd.openxmlformats-officedocument.presentationml.presentation");
            add("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            add("application/kswps");
            add("application/kset");
            add("application/ksdps");
            add("application/pdf");
            add("text/plain");
            AppMethodBeat.o(224210);
        }
    };

    static {
        AppMethodBeat.i(224211);
        AppMethodBeat.o(224211);
    }
}
