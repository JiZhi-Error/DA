package com.tencent.mm.plugin.websearch.api;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcSharedPreferences;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.c;

public final class au {
    private static au IFC = new au();
    private volatile boolean IFA = this.mPref.getBoolean("isUseSysWebview", false);
    private boolean IFB = false;
    private long IFD;
    private SharedPreferences mPref = MultiProcSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "com.tencent.mm.plugin.websearch.WebSearchXWeb", 4, false);

    static {
        AppMethodBeat.i(117805);
        AppMethodBeat.o(117805);
    }

    public au() {
        AppMethodBeat.i(117804);
        if (System.currentTimeMillis() - this.IFD >= 7200000) {
            this.IFD = System.currentTimeMillis();
            ThreadPool.post(new Runnable() {
                /* class com.tencent.mm.plugin.websearch.api.au.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(117803);
                    a aVar = a.C0356a.hnM;
                    c Fu = a.Fu("100387");
                    if (Fu == null) {
                        Log.i("WebSearchXWeb", "openSearchPreload item is null");
                        AppMethodBeat.o(117803);
                        return;
                    }
                    au.this.IFB = Fu.isValid() && "1".equals(Fu.gzz().get("isOpen"));
                    AppMethodBeat.o(117803);
                }
            }, "WebSearchXWeb-getSwitch");
        }
        AppMethodBeat.o(117804);
    }

    public static au fYB() {
        return IFC;
    }
}
