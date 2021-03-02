package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;

public class TbsVideoUtils {

    /* renamed from: a  reason: collision with root package name */
    private static u f1891a = null;

    private static void a(Context context) {
        DexLoader dexLoader = null;
        AppMethodBeat.i(54987);
        synchronized (TbsVideoUtils.class) {
            try {
                if (f1891a == null) {
                    g.a(true).a(context, false, false, null);
                    TbsWizard a2 = g.a(true).a();
                    if (a2 != null) {
                        dexLoader = a2.dexLoader();
                    }
                    if (dexLoader != null) {
                        f1891a = new u(dexLoader);
                    }
                }
            } finally {
                AppMethodBeat.o(54987);
            }
        }
    }

    public static void deleteVideoCache(Context context, String str) {
        AppMethodBeat.i(54988);
        a(context);
        if (f1891a != null) {
            f1891a.a(context, str);
        }
        AppMethodBeat.o(54988);
    }

    public static String getCurWDPDecodeType(Context context) {
        AppMethodBeat.i(54989);
        a(context);
        if (f1891a != null) {
            String a2 = f1891a.a(context);
            AppMethodBeat.o(54989);
            return a2;
        }
        AppMethodBeat.o(54989);
        return "";
    }
}
