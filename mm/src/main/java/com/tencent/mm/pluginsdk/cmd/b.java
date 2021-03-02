package com.tencent.mm.pluginsdk.cmd;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public final class b {
    private static final HashMap<String, a> JTi = new HashMap<>();
    private static final HashMap<String, a> JTj = new HashMap<>();
    private static final Pattern JTk = Pattern.compile(" +");

    static class a {
        a JTl;
        String ehK;
        int nBF;

        a() {
        }
    }

    static {
        AppMethodBeat.i(151624);
        AppMethodBeat.o(151624);
    }

    public static void a(a aVar, String... strArr) {
        AppMethodBeat.i(151620);
        synchronized (JTi) {
            try {
                for (String str : strArr) {
                    JTi.put(str, aVar);
                    Log.i("MicroMsg.UnifiedCommandProcessor", "Registered command: %s", str);
                }
            } finally {
                AppMethodBeat.o(151620);
            }
        }
    }

    public static void V(String... strArr) {
        AppMethodBeat.i(151621);
        synchronized (JTi) {
            try {
                for (String str : strArr) {
                    JTi.remove(str);
                    Log.i("MicroMsg.UnifiedCommandProcessor", "Unregistered command: %s", str);
                }
            } finally {
                AppMethodBeat.o(151621);
            }
        }
    }

    public static boolean Q(Context context, String str, String str2) {
        a aVar;
        AppMethodBeat.i(151622);
        String[] split = JTk.split(str);
        synchronized (JTi) {
            try {
                aVar = JTi.get(split[0]);
            } catch (Throwable th) {
                AppMethodBeat.o(151622);
                throw th;
            }
        }
        if (aVar != null) {
            Log.i("MicroMsg.UnifiedCommandProcessor", "Command: %s", split[0]);
            boolean a2 = aVar.a(context, split, str2);
            AppMethodBeat.o(151622);
            return a2;
        }
        AppMethodBeat.o(151622);
        return false;
    }

    static List<a> gmb() {
        ArrayList arrayList;
        AppMethodBeat.i(151623);
        synchronized (JTj) {
            try {
                arrayList = new ArrayList(JTj.values());
            } finally {
                AppMethodBeat.o(151623);
            }
        }
        return arrayList;
    }
}
