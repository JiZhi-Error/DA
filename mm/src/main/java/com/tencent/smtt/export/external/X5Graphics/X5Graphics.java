package com.tencent.smtt.export.external.X5Graphics;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class X5Graphics {
    private static final boolean sIsEnable = true;

    public static abstract class IBeacon {
        public abstract void report(String str, HashMap<String, String> hashMap);
    }

    public static abstract class SoThinker {
        public abstract String path(String str);
    }

    public static boolean isEnable() {
        return true;
    }

    public static boolean init(Context context, String str) {
        AppMethodBeat.i(53171);
        boolean init = GraphicsLib.init(context, str, null, null);
        AppMethodBeat.o(53171);
        return init;
    }

    public static boolean init(Context context, String str, SoThinker soThinker) {
        AppMethodBeat.i(53172);
        boolean init = GraphicsLib.init(context, str, soThinker, null);
        AppMethodBeat.o(53172);
        return init;
    }

    public static boolean init(Context context, String str, IBeacon iBeacon) {
        AppMethodBeat.i(53173);
        boolean init = GraphicsLib.init(context, str, null, iBeacon);
        AppMethodBeat.o(53173);
        return init;
    }

    public static boolean init(Context context, String str, SoThinker soThinker, IBeacon iBeacon) {
        AppMethodBeat.i(53174);
        boolean init = GraphicsLib.init(context, str, soThinker, iBeacon);
        AppMethodBeat.o(53174);
        return init;
    }
}
