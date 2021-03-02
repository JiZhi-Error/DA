package com.tencent.mm.ui.l.a.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.l.a.b.a.e;
import com.tencent.mm.ui.l.a.g;
import java.util.HashMap;
import java.util.Map;

public final class a extends s {
    private static final int CTRL_INDEX = -2;
    public static final String NAME = "MagicEmojiSent";

    public final void a(long j2, long j3, String str, g gVar) {
        AppMethodBeat.i(234450);
        e a2 = e.a(j2, gVar, true);
        if (a2 != null) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("msgId", Long.valueOf(j2));
            hashMap.put("msgMeta", a2.gWU());
            a(hashMap, str, a2.dJw, j3);
            if (BuildInfo.DEBUG) {
                Log.d("MicroMsg.JsEventOnMagicEmojiMsgCome", "hy: publish msg meta %s", a2.toString());
            }
            g(gVar).L(hashMap).bEo();
            AppMethodBeat.o(234450);
            return;
        }
        Log.e("MicroMsg.JsEventOnMagicEmojiMsgCome", "hy: not found the msg or convert failed!");
        AppMethodBeat.o(234450);
    }

    private static void a(Map<String, Object> map, String str, String str2, long j2) {
        AppMethodBeat.i(234451);
        HashMap hashMap = new HashMap(2);
        hashMap.put("sessionID", str);
        hashMap.put("toChatName", str2);
        hashMap.put("messageTimestamp", Long.valueOf(j2));
        map.put("reportInfo", hashMap);
        AppMethodBeat.o(234451);
    }
}
