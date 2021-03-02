package com.tencent.mm.plugin.appbrand.game.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.AppBrandMixExportLogicService;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class b extends s {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "onStartReportCanvasData";
    public static MMToClientEvent.c kYj;

    public enum a {
        BeforeIdentifyQRCode(11),
        BeforeJumpToProfile(12),
        BeforeBack(15),
        AfterWebViewLoad(18);
        
        private final int value;

        public static a valueOf(String str) {
            AppMethodBeat.i(45163);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(45163);
            return aVar;
        }

        static {
            AppMethodBeat.i(45164);
            AppMethodBeat.o(45164);
        }

        private a(int i2) {
            this.value = i2;
        }
    }

    public final void a(com.tencent.mm.plugin.appbrand.s sVar, a aVar, int i2) {
        AppMethodBeat.i(180197);
        Log.i("MicroMsg.OnStartReportCanvasDataEvent", "hy: trigger event %d", Integer.valueOf(aVar.value));
        g(sVar);
        HashMap hashMap = new HashMap(1);
        hashMap.put("event", Integer.valueOf(aVar.value));
        hashMap.put("viewId", Integer.valueOf(i2));
        L(hashMap).bEo();
        AppMethodBeat.o(180197);
    }

    public static void b(final com.tencent.mm.plugin.appbrand.s sVar, final String str) {
        AppMethodBeat.i(180198);
        Log.i("MicroMsg.OnStartReportCanvasDataEvent", "startListeningOperationEvent, appId:%s", str);
        if (kYj == null) {
            kYj = new MMToClientEvent.c() {
                /* class com.tencent.mm.plugin.appbrand.game.e.b.b.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c
                public final void cq(Object obj) {
                    AppMethodBeat.i(45161);
                    if ((obj instanceof AppBrandMixExportLogicService.AppBrandOnStartReportCanvasDataEvent) && str.equals(((AppBrandMixExportLogicService.AppBrandOnStartReportCanvasDataEvent) obj).appId)) {
                        MMToClientEvent.b(str, this);
                        new b().a(sVar, a.BeforeIdentifyQRCode, 0);
                    }
                    AppMethodBeat.o(45161);
                }
            };
        }
        MMToClientEvent.a(str, kYj);
        AppMethodBeat.o(180198);
    }
}
