package com.tencent.map.tools.internal;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.List;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private String f1352a = j.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private Context f1353b;

    public j(Context context) {
        AppMethodBeat.i(180806);
        this.f1353b = context;
        AppMethodBeat.o(180806);
    }

    public final DexClassLoader a() {
        DexClassLoader dexClassLoader;
        AppMethodBeat.i(180807);
        try {
            dexClassLoader = b();
        } catch (Throwable th) {
            g.a().a("CPL", "fail:" + th.toString());
            dexClassLoader = null;
        }
        x.e(this.f1353b);
        AppMethodBeat.o(180807);
        return dexClassLoader;
    }

    private synchronized DexClassLoader b() {
        Throwable th;
        DexClassLoader dexClassLoader;
        AppMethodBeat.i(180808);
        List<p> a2 = x.a(x.b(this.f1353b, t.q, BuildConfig.KINDA_DEFAULT));
        if (a2.isEmpty()) {
            AppMethodBeat.o(180808);
            dexClassLoader = null;
        } else {
            x.f1429f = x.a(a2);
            String b2 = x.b(this.f1353b, x.f1424a);
            String b3 = x.b(this.f1353b, x.f1425b);
            StringBuilder sb = new StringBuilder();
            int i2 = s.a(this.f1353b).f1397a;
            for (p pVar : a2) {
                if (pVar != null && !x.a(pVar.f1388a)) {
                    sb.append(b2);
                    sb.append(File.separator);
                    sb.append(pVar.f1390c);
                    sb.append(File.pathSeparator);
                } else if (pVar != null && x.a(pVar.f1388a) && pVar.f1388a == i2) {
                    x.f1430g = x.b(this.f1353b, x.f1426c + File.separator + t.F[i2] + File.separator + pVar.f1390c);
                }
            }
            try {
                long currentTimeMillis = System.currentTimeMillis();
                dexClassLoader = new DexClassLoader(sb.toString(), b3, null, getClass().getClassLoader());
                try {
                    g.a(this.f1353b).a("CPL", "suc:" + x.f1429f);
                    g.a(this.f1353b).a("CPL", "conuseT:" + (System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(180808);
                } catch (Throwable th2) {
                    th = th2;
                    g.a(this.f1353b).a("CPL", "fail:" + x.f1429f + ",exc:" + th.toString());
                    AppMethodBeat.o(180808);
                    return dexClassLoader;
                }
            } catch (Throwable th3) {
                th = th3;
                dexClassLoader = null;
                g.a(this.f1353b).a("CPL", "fail:" + x.f1429f + ",exc:" + th.toString());
                AppMethodBeat.o(180808);
                return dexClassLoader;
            }
        }
        return dexClassLoader;
    }
}
