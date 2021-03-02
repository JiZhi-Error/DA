package com.tencent.mm.plugin.webview.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class w {
    public g ISU;
    public final HashMap<String, String> IVj = new HashMap<>();
    public final HashMap<String, a.d> IVk = new HashMap<>();
    public final HashMap<String, String> IVl = new HashMap<>();

    public w(g gVar) {
        AppMethodBeat.i(78474);
        this.ISU = gVar;
        AppMethodBeat.o(78474);
    }

    public final String getAppId() {
        AppMethodBeat.i(78475);
        String url = this.ISU.getUrl();
        if (Util.isNullOrNil(url)) {
            AppMethodBeat.o(78475);
            return null;
        }
        String str = this.IVj.get(aYy(url));
        AppMethodBeat.o(78475);
        return str;
    }

    public static String aYy(String str) {
        AppMethodBeat.i(78476);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(78476);
            return str;
        }
        int indexOf = str.indexOf("#");
        if (indexOf < 0) {
            AppMethodBeat.o(78476);
            return str;
        }
        String substring = str.substring(0, indexOf);
        AppMethodBeat.o(78476);
        return substring;
    }

    public final String getIcon() {
        AppMethodBeat.i(78477);
        String appId = getAppId();
        if (Util.isNullOrNil(appId)) {
            AppMethodBeat.o(78477);
            return null;
        }
        String str = this.IVl.get(appId);
        AppMethodBeat.o(78477);
        return str;
    }
}
