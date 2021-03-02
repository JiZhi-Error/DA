package com.tencent.mm.plugin.websearch.api;

import android.content.ComponentName;
import android.content.Intent;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;

public class an {
    private static volatile an IEY;
    private HashMap<Integer, ao> IEX = new HashMap<>();

    private an() {
        AppMethodBeat.i(117734);
        AppMethodBeat.o(117734);
    }

    public static an fYj() {
        AppMethodBeat.i(117735);
        if (IEY == null) {
            synchronized (an.class) {
                try {
                    if (IEY == null) {
                        IEY = new an();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(117735);
                    throw th;
                }
            }
        }
        an anVar = IEY;
        AppMethodBeat.o(117735);
        return anVar;
    }

    public final void w(final String str, final int i2, final boolean z) {
        AppMethodBeat.i(184555);
        Log.i("MicroMsg.WebSearch.WebSearchPreloadExport", "preloadWebView %s %s %s %s", MMApplicationContext.getProcessName(), str, Integer.valueOf(i2), Boolean.valueOf(z));
        if (MMApplicationContext.isToolsMpProcess()) {
            Log.i("MicroMsg.WebSearch.WebSearchPreloadExport", "current preload mgr size %s", Integer.valueOf(this.IEX.size()));
            if (z) {
                this.IEX.remove(Integer.valueOf(i2));
            }
            if (!this.IEX.containsKey(Integer.valueOf(i2))) {
                ao aoVar = new ao(i2);
                aoVar.aXi(str);
                this.IEX.put(Integer.valueOf(i2), aoVar);
                AppMethodBeat.o(184555);
                return;
            }
            this.IEX.get(Integer.valueOf(i2)).aXi(str);
            AppMethodBeat.o(184555);
            return;
        }
        if (MMApplicationContext.isMainProcess()) {
            h.RTc.aX(new Runnable() {
                /* class com.tencent.mm.plugin.websearch.api.an.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(117733);
                    Log.i("MicroMsg.WebSearch.WebSearchPreloadExport", "sending broadcast");
                    an.e("com.tencent.mm.intent.ACTION_PRELOAD_SEARCH", str, i2, z);
                    AppMethodBeat.o(117733);
                }
            });
        }
        AppMethodBeat.o(184555);
    }

    static /* synthetic */ void e(String str, String str2, int i2, boolean z) {
        AppMethodBeat.i(184556);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(MMApplicationContext.getContext(), "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
        intent.putExtra("toolsmp_param_preload_url", str2);
        intent.putExtra("toolsmp_process_action_code_key", str);
        intent.putExtra("toolsmp_param_preload_search_biz", i2);
        intent.putExtra("toolsmp_param_preload_search_biz_need_reset", z);
        MMApplicationContext.getContext().sendBroadcast(intent);
        AppMethodBeat.o(184556);
    }
}
