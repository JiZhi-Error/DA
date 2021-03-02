package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.a;
import com.tencent.mm.plugin.appbrand.keylogger.base.h;
import com.tencent.mm.plugin.appbrand.keylogger.base.j;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.a.b;
import org.json.JSONException;
import org.json.JSONObject;

public final class f {
    private static Map<String, String> mPl = new HashMap();
    private static Map<String, List<j>> mPm = new HashMap();
    private static Map<String, h> mPn = new HashMap();

    public static Pattern s(String... strArr) {
        AppMethodBeat.i(221313);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 2; i2++) {
            sb.append(strArr[i2]);
            if (i2 != 1) {
                sb.append("|");
            }
        }
        sb.append(".*");
        Pattern compile = Pattern.compile(sb.toString());
        AppMethodBeat.o(221313);
        return compile;
    }

    public static boolean abT(String str) {
        AppMethodBeat.i(221314);
        try {
            JSONObject jSONObject = new JSONObject(MultiProcessMMKV.getMMKV("Luggage.KeyStepUtils", 2).getString(String.format("KeyStepLoggerSwitch_%s", str), ""));
            long j2 = jSONObject.getLong("keepTime");
            long j3 = jSONObject.getLong("openTime");
            long currentTimeMillis = System.currentTimeMillis();
            if (j3 <= 0 || currentTimeMillis - j3 >= j2) {
                AppMethodBeat.o(221314);
                return false;
            }
            AppMethodBeat.o(221314);
            return true;
        } catch (JSONException e2) {
            AppMethodBeat.o(221314);
            return false;
        }
    }

    static {
        AppMethodBeat.i(221319);
        AppMethodBeat.o(221319);
    }

    static String aC(Class cls) {
        AppMethodBeat.i(221315);
        String name = cls.getName();
        if (mPl.containsKey(name)) {
            String str = mPl.get(name);
            AppMethodBeat.o(221315);
            return str;
        }
        try {
            String str2 = (String) cls.getDeclaredField("NAME").get(null);
            mPl.put(name, str2);
            AppMethodBeat.o(221315);
            return str2;
        } catch (NoSuchFieldException e2) {
            AppMethodBeat.o(221315);
            return null;
        } catch (IllegalAccessException e3) {
            AppMethodBeat.o(221315);
            return null;
        }
    }

    static List<j> g(Class cls, String str) {
        AppMethodBeat.i(221316);
        String str2 = cls.getName() + "_" + str;
        if (mPm.containsKey(str2)) {
            List<j> list = mPm.get(str2);
            AppMethodBeat.o(221316);
            return list;
        }
        final ArrayList arrayList = new ArrayList();
        a(cls, new h.b() {
            /* class com.tencent.mm.plugin.appbrand.keylogger.f.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.keylogger.base.h.b
            public final void a(h hVar) {
                AppMethodBeat.i(221312);
                a bNb = hVar.bNb();
                if (bNb == null) {
                    AppMethodBeat.o(221312);
                    return;
                }
                arrayList.add(new j(bNb, hVar.mPF));
                AppMethodBeat.o(221312);
            }
        }, str);
        mPm.put(str2, arrayList);
        AppMethodBeat.o(221316);
        return arrayList;
    }

    public static h h(Class cls, String str) {
        AppMethodBeat.i(221317);
        String str2 = cls.getName() + "—" + str;
        if (mPn.containsKey(str2)) {
            h hVar = mPn.get(str2);
            AppMethodBeat.o(221317);
            return hVar;
        }
        try {
            List list = (List) org.a.a.bF(cls).get("sStepNodes");
            if (list == null) {
                AppMethodBeat.o(221317);
                return null;
            }
            h f2 = h.f(list, str);
            mPn.put(str2, f2);
            AppMethodBeat.o(221317);
            return f2;
        } catch (b e2) {
            AppMethodBeat.o(221317);
            return null;
        }
    }

    static void a(Class cls, h.b bVar, String str) {
        AppMethodBeat.i(221318);
        h.a(h(cls, str), bVar);
        AppMethodBeat.o(221318);
    }
}
