package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.downloader_app.api.DownloadWidgetTaskInfo;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f extends d<s> {
    public static final int CTRL_INDEX = 670;
    public static final String NAME = "getDownloadWidgetTaskInfoForNative";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(45792);
        final s sVar2 = sVar;
        h.a(MainProcessIPCService.dkO, null, a.class, new com.tencent.mm.ipcinvoker.d<IPCString>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.f.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(IPCString iPCString) {
                AppMethodBeat.i(45790);
                IPCString iPCString2 = iPCString;
                if (iPCString2 == null || iPCString2.value == null) {
                    sVar2.i(i2, (String) null);
                    AppMethodBeat.o(45790);
                    return;
                }
                HashMap hashMap = new HashMap();
                try {
                    hashMap.put("result", new JSONArray(iPCString2.value));
                } catch (JSONException e2) {
                }
                sVar2.i(i2, f.this.n("ok", hashMap));
                AppMethodBeat.o(45790);
            }
        });
        AppMethodBeat.o(45792);
    }

    static class a implements b<IPCVoid, IPCString> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(IPCVoid iPCVoid, com.tencent.mm.ipcinvoker.d<IPCString> dVar) {
            AppMethodBeat.i(45791);
            LinkedList<DownloadWidgetTaskInfo> cBR = ((c) g.af(c.class)).cBR();
            if (Util.isNullOrNil(cBR)) {
                dVar.bn(null);
                AppMethodBeat.o(45791);
                return;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<DownloadWidgetTaskInfo> it = cBR.iterator();
            while (it.hasNext()) {
                DownloadWidgetTaskInfo next = it.next();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("appId", next.appId);
                    jSONObject.put("status", next.pJC);
                    jSONObject.put("downloadId", next.dCa);
                    jSONObject.put("progress", next.progress);
                    jSONObject.put("progressFloat", (double) next.lCT);
                    if (next.qJh) {
                        jSONObject.put("reserveForWifi", 1);
                    }
                } catch (JSONException e2) {
                }
                jSONArray.put(jSONObject);
            }
            dVar.bn(new IPCString(jSONArray.toString()));
            AppMethodBeat.o(45791);
        }
    }
}
