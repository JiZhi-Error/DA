package com.tencent.mm.plugin.webview.fts.b.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class a {
    public static final a IPG = new a();
    private Map<String, com.tencent.mm.plugin.webview.fts.b.a.a.a> IPF = new HashMap();

    public a() {
        AppMethodBeat.i(77985);
        AppMethodBeat.o(77985);
    }

    static {
        AppMethodBeat.i(77987);
        AppMethodBeat.o(77987);
    }

    public static a gaG() {
        return IPG;
    }

    public static com.tencent.mm.plugin.webview.fts.b.a.a.a aXY(String str) {
        com.tencent.mm.plugin.webview.fts.b.a.a.a aVar;
        AppMethodBeat.i(77986);
        if (TextUtils.isEmpty(str) || !str.startsWith("//test-widget-ui")) {
            Log.w("SearchWidgetTestUiMgr", "not test-widget-ui formate");
            AppMethodBeat.o(77986);
            return null;
        }
        String[] split = str.split("\\s+");
        if (split.length != 2) {
            Log.w("SearchWidgetTestUiMgr", "test-widget-ui arg length illegal");
            AppMethodBeat.o(77986);
            return null;
        }
        try {
            aVar = new com.tencent.mm.plugin.webview.fts.b.a.a.a(split[1]);
        } catch (Exception e2) {
            Log.printErrStackTrace("SearchWidgetTestUiMgr", e2, "", new Object[0]);
            aVar = null;
        }
        if (aVar == null) {
            AppMethodBeat.o(77986);
            return null;
        }
        IPG.IPF.put(aVar.dNI, aVar);
        Log.i("SearchWidgetTestUiMgr", "test-widget-ui args %s, %s, %s, %s", aVar.IPJ, aVar.dNI, aVar.IPH, aVar.IPI);
        AppMethodBeat.o(77986);
        return aVar;
    }
}
