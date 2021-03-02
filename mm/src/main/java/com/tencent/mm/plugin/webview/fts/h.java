package com.tencent.mm.plugin.webview.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class h {
    public final List<Map<Object, b>> IOC = new ArrayList();
    private final MMHandler ndA;

    /* access modifiers changed from: package-private */
    public interface a {
        void a(b bVar);
    }

    public static class b {
        boolean IOJ;
        boolean IOK;
        boolean IOL;
        public Object IOM;
        public Object ION;
    }

    public h(MMHandler mMHandler) {
        AppMethodBeat.i(210839);
        for (int i2 = 0; i2 < 3; i2++) {
            this.IOC.add(new HashMap());
        }
        this.ndA = mMHandler;
        AppMethodBeat.o(210839);
    }

    public final void p(final int i2, final Object obj) {
        AppMethodBeat.i(210840);
        if (obj == null) {
            Log.e("MicroMsg.WebSearch.PGetController", "step_doCgiReq tag is null");
            AppMethodBeat.o(210840);
            return;
        }
        this.ndA.post(new Runnable() {
            /* class com.tencent.mm.plugin.webview.fts.h.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(210836);
                Log.i("MicroMsg.WebSearch.PGetController", "step_doCgiReq type:%s, reqTag:%s", Integer.valueOf(i2), obj);
                b bVar = h.this.IOC.get(i2).get(obj);
                if (bVar == null) {
                    b bVar2 = new b();
                    h.this.IOC.get(i2).put(obj, bVar2);
                    bVar = bVar2;
                }
                bVar.IOJ = true;
                AppMethodBeat.o(210836);
            }
        });
        AppMethodBeat.o(210840);
    }

    public final void a(final int i2, final Object obj, final Object obj2, final Runnable runnable, final a aVar) {
        AppMethodBeat.i(210841);
        if (obj == null) {
            Log.e("MicroMsg.WebSearch.PGetController", "step_getJsApi tag is null");
            AppMethodBeat.o(210841);
            return;
        }
        this.ndA.post(new Runnable() {
            /* class com.tencent.mm.plugin.webview.fts.h.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(210837);
                Log.i("MicroMsg.WebSearch.PGetController", "step_getJsApi type:%s, reqTag:%s, jsParams:%s", Integer.valueOf(i2), obj, obj2);
                b bVar = h.this.IOC.get(i2).get(obj);
                if (bVar == null) {
                    b bVar2 = new b();
                    h.this.IOC.get(i2).put(obj, bVar2);
                    bVar = bVar2;
                }
                bVar.IOK = true;
                bVar.IOM = obj2;
                if (!bVar.IOJ) {
                    runnable.run();
                    h.this.p(i2, obj);
                    AppMethodBeat.o(210837);
                    return;
                }
                if (bVar.IOL) {
                    Log.i("MicroMsg.WebSearch.PGetController", "step_getJsApi preget hit type:%s, reqTag:%s, jsParams:%s", Integer.valueOf(i2), obj, obj2);
                    if (aVar != null) {
                        aVar.a(bVar);
                    }
                    h.this.IOC.get(i2).remove(obj);
                }
                AppMethodBeat.o(210837);
            }
        });
        AppMethodBeat.o(210841);
    }

    public final void a(final int i2, final Object obj, final Object obj2, final a aVar) {
        AppMethodBeat.i(210842);
        this.ndA.post(new Runnable() {
            /* class com.tencent.mm.plugin.webview.fts.h.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(210838);
                Log.i("MicroMsg.WebSearch.PGetController", "step_cgiEnd type:%s reqTag:%s cgiResult:%s", Integer.valueOf(i2), obj, obj2);
                b bVar = h.this.IOC.get(i2).get(obj);
                if (bVar == null) {
                    Log.e("MicroMsg.WebSearch.PGetController", "step_cgiEnd weird null");
                    AppMethodBeat.o(210838);
                    return;
                }
                bVar.ION = obj2;
                bVar.IOL = true;
                if (bVar.IOK) {
                    if (aVar != null) {
                        aVar.a(bVar);
                    }
                    h.this.IOC.get(i2).remove(obj);
                }
                AppMethodBeat.o(210838);
            }
        });
        AppMethodBeat.o(210842);
    }
}
