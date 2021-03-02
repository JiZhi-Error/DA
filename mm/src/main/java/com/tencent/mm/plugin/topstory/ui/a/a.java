package com.tencent.mm.plugin.topstory.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a {
    public static void a(e eVar, String str, String str2) {
        AppMethodBeat.i(126548);
        try {
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(126548);
                return;
            }
            String nullAsNil = Util.nullAsNil(str2);
            Log.i("MicroMsg.TopStory.TopStoryJsEventNotifier", "notifyJsEvent %s %s", str, nullAsNil);
            String format = String.format("javascript:window['%s'] && %s(%s)", str, str, nullAsNil);
            if (!(eVar == null || eVar.Gqy == null)) {
                eVar.Gqy.evaluateJavascript(format, null);
            }
            AppMethodBeat.o(126548);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.TopStory.TopStoryJsEventNotifier", e2, "notifyJsEvent", new Object[0]);
            AppMethodBeat.o(126548);
        }
    }
}
