package com.tencent.mm.plugin.appbrand.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class k {
    private static final Map<String, WxaWidgetContext> lmi = new ConcurrentHashMap();

    static {
        AppMethodBeat.i(121197);
        AppMethodBeat.o(121197);
    }

    public static boolean a(String str, WxaWidgetContext wxaWidgetContext) {
        AppMethodBeat.i(121194);
        if (Util.isNullOrNil(str) || wxaWidgetContext == null) {
            AppMethodBeat.o(121194);
            return false;
        }
        lmi.put(str, wxaWidgetContext);
        AppMethodBeat.o(121194);
        return true;
    }

    public static WxaWidgetContext Ys(String str) {
        AppMethodBeat.i(121195);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(121195);
            return null;
        }
        WxaWidgetContext wxaWidgetContext = lmi.get(str);
        AppMethodBeat.o(121195);
        return wxaWidgetContext;
    }

    public static WxaWidgetContext Yt(String str) {
        AppMethodBeat.i(121196);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(121196);
            return null;
        }
        WxaWidgetContext remove = lmi.remove(str);
        AppMethodBeat.o(121196);
        return remove;
    }
}
