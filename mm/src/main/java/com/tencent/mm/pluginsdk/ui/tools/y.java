package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public final class y {
    private static List<a> KwR = new ArrayList();

    public interface a {
        void gbt();

        void gbu();

        String getName();

        void hU(Context context);
    }

    static {
        AppMethodBeat.i(152428);
        AppMethodBeat.o(152428);
    }

    public static void a(a aVar) {
        AppMethodBeat.i(152426);
        if (aVar != null) {
            Log.d("MicroMsg.WebViewPluginCenter", "add, plugin name = " + aVar.getName());
            if (!KwR.contains(aVar)) {
                KwR.add(aVar);
            }
        }
        AppMethodBeat.o(152426);
    }

    public static List<a> gsJ() {
        return KwR;
    }

    public static void clear() {
        AppMethodBeat.i(152427);
        Log.d("MicroMsg.WebViewPluginCenter", "clear");
        KwR.clear();
        AppMethodBeat.o(152427);
    }
}
