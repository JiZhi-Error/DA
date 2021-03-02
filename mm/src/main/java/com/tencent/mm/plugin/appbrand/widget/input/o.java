package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.widget.input.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum o {
    ;
    
    public static final Map<String, Integer> otl;
    public static final Set<String> otm;
    private static final a<ac, ab> otn = new a<>();

    static {
        AppMethodBeat.i(136427);
        HashSet hashSet = new HashSet();
        hashSet.add("text");
        hashSet.add("emoji");
        hashSet.add("number");
        hashSet.add("digit");
        hashSet.add("idcard");
        otm = Collections.unmodifiableSet(hashSet);
        HashMap hashMap = new HashMap(3);
        hashMap.put("digit", 2);
        hashMap.put("number", 0);
        hashMap.put("idcard", 1);
        otl = Collections.unmodifiableMap(hashMap);
        AppMethodBeat.o(136427);
    }

    public static o valueOf(String str) {
        AppMethodBeat.i(136416);
        o oVar = (o) Enum.valueOf(o.class, str);
        AppMethodBeat.o(136416);
        return oVar;
    }

    static void b(ac acVar, aa aaVar) {
        AppMethodBeat.i(136417);
        e.a(acVar, aaVar);
        AppMethodBeat.o(136417);
    }

    public static aa a(ac acVar, final int i2) {
        AppMethodBeat.i(136418);
        aa a2 = e.a(acVar, new e.a() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.o.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.widget.input.e.a
            public final boolean a(aa aaVar) {
                AppMethodBeat.i(136411);
                if (aaVar.caV() == null || ((ab) aaVar.caV()).getInputId() != i2) {
                    AppMethodBeat.o(136411);
                    return false;
                }
                AppMethodBeat.o(136411);
                return true;
            }
        });
        AppMethodBeat.o(136418);
        return a2;
    }

    public static void a(final ac acVar, final String str, final Integer num) {
        AppMethodBeat.i(136419);
        if (acVar == null) {
            AppMethodBeat.o(136419);
            return;
        }
        m.runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.o.AnonymousClass2 */

            public final void run() {
                aa a2;
                AppMethodBeat.i(136412);
                ab abVar = (ab) o.otn.get(acVar);
                if (!(abVar == null || (a2 = o.a(acVar, abVar.getInputId())) == null)) {
                    a2.a(str, num);
                }
                AppMethodBeat.o(136412);
            }
        });
        AppMethodBeat.o(136419);
    }

    public static boolean D(ac acVar) {
        AppMethodBeat.i(136420);
        boolean a2 = a(acVar, (Integer) null);
        AppMethodBeat.o(136420);
        return a2;
    }

    public static boolean a(ac acVar, int i2, int i3, int i4) {
        AppMethodBeat.i(136422);
        aa a2 = a(acVar, i2);
        if (a2 == null || !a2.A(acVar) || !a2.q(i3, i4, acVar.kEb.OG())) {
            AppMethodBeat.o(136422);
            return false;
        }
        AppMethodBeat.o(136422);
        return true;
    }

    public static boolean b(ac acVar, int i2) {
        AppMethodBeat.i(136423);
        aa a2 = a(acVar, i2);
        if (a2 == null || !a2.caU()) {
            AppMethodBeat.o(136423);
            return false;
        }
        AppMethodBeat.o(136423);
        return true;
    }

    static void a(final ac acVar, final ab abVar) {
        AppMethodBeat.i(136424);
        if (acVar == null) {
            AppMethodBeat.o(136424);
            return;
        }
        m.runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.o.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(136413);
                o.otn.put(acVar, abVar);
                AppMethodBeat.o(136413);
            }
        });
        AppMethodBeat.o(136424);
    }

    static void E(final ac acVar) {
        AppMethodBeat.i(136425);
        if (acVar == null) {
            AppMethodBeat.o(136425);
            return;
        }
        m.runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.o.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(136414);
                o.otn.remove(acVar);
                AppMethodBeat.o(136414);
            }
        });
        AppMethodBeat.o(136425);
    }

    public static aa F(ac acVar) {
        AppMethodBeat.i(136426);
        if (acVar == null) {
            AppMethodBeat.o(136426);
            return null;
        }
        ab abVar = otn.get(acVar);
        if (abVar == null) {
            AppMethodBeat.o(136426);
            return null;
        }
        aa a2 = a(acVar, abVar.getInputId());
        AppMethodBeat.o(136426);
        return a2;
    }

    public static boolean a(ac acVar, Integer num) {
        AppMethodBeat.i(136421);
        if (num == null) {
            try {
                ab abVar = otn.get(acVar);
                if (abVar == null) {
                    AppMethodBeat.o(136421);
                    return false;
                }
                num = Integer.valueOf(abVar.getInputId());
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.AppBrandInputService", th, "[NOT CRASH]", new Object[0]);
                AppMethodBeat.o(136421);
                return false;
            }
        }
        aa a2 = a(acVar, num.intValue());
        if (a2 == null || !a2.cba()) {
            AppMethodBeat.o(136421);
            return false;
        }
        AppMethodBeat.o(136421);
        return true;
    }
}
