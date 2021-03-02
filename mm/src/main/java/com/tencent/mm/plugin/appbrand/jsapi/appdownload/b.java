package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.e;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class b extends s {
    public static final int CTRL_INDEX = 662;
    public static final String NAME = "onDownloadAppStateChangeForNative";
    public static HashMap<String, b> lCV = new HashMap<>();
    private static Set<String> lCW = new HashSet();
    private MMToClientEvent.c lCU;

    public b(final com.tencent.mm.plugin.appbrand.s sVar) {
        AppMethodBeat.i(45736);
        this.lCU = new MMToClientEvent.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.b.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c
            public final void cq(Object obj) {
                AppMethodBeat.i(45732);
                if (obj instanceof AppbrandDownloadState) {
                    AppbrandDownloadState appbrandDownloadState = (AppbrandDownloadState) obj;
                    if (sVar != null) {
                        b.this.g(sVar).Zg(appbrandDownloadState.bEw().toString()).bEo();
                    }
                }
                AppMethodBeat.o(45732);
            }
        };
        MMToClientEvent.a(sVar.getAppId(), this.lCU);
        sVar.getRuntime().kAH.a(new c.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.b.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.a.c.a
            public final void a(String str, com.tencent.mm.plugin.appbrand.a.b bVar) {
                AppMethodBeat.i(45733);
                if (bVar == com.tencent.mm.plugin.appbrand.a.b.DESTROYED) {
                    MMToClientEvent.b(sVar.getAppId(), b.this.lCU);
                    b.m(sVar);
                }
                AppMethodBeat.o(45733);
            }
        });
        AppMethodBeat.o(45736);
    }

    static {
        AppMethodBeat.i(45740);
        AppMethodBeat.o(45740);
    }

    public static void a(AppbrandDownloadState appbrandDownloadState) {
        AppMethodBeat.i(45737);
        for (String str : lCW) {
            e.b(str, appbrandDownloadState);
        }
        AppMethodBeat.o(45737);
    }

    public static void a(com.tencent.mm.plugin.appbrand.s sVar, b bVar) {
        AppMethodBeat.i(45738);
        lCV.put(sVar.getAppId(), bVar);
        h.a(MainProcessIPCService.dkO, new IPCString(sVar.getAppId()), a.class, null);
        AppMethodBeat.o(45738);
    }

    static class a implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(IPCString iPCString, d<IPCVoid> dVar) {
            AppMethodBeat.i(45734);
            IPCString iPCString2 = iPCString;
            if (iPCString2 == null || Util.isNullOrNil(iPCString2.value)) {
                AppMethodBeat.o(45734);
                return;
            }
            b.lCW.add(iPCString2.value);
            AppMethodBeat.o(45734);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.appdownload.b$b  reason: collision with other inner class name */
    public static class C0626b implements com.tencent.mm.ipcinvoker.b<IPCString, IPCVoid> {
        private C0626b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(IPCString iPCString, d<IPCVoid> dVar) {
            AppMethodBeat.i(45735);
            IPCString iPCString2 = iPCString;
            if (iPCString2 == null || Util.isNullOrNil(iPCString2.value)) {
                AppMethodBeat.o(45735);
                return;
            }
            b.lCW.remove(iPCString2.value);
            AppMethodBeat.o(45735);
        }
    }

    static /* synthetic */ void m(com.tencent.mm.plugin.appbrand.s sVar) {
        AppMethodBeat.i(45739);
        lCV.remove(sVar.getAppId());
        h.a(MainProcessIPCService.dkO, new IPCString(sVar.getAppId()), C0626b.class, null);
        AppMethodBeat.o(45739);
    }
}
