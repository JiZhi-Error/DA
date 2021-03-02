package com.tencent.map.tools.internal;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class l {

    /* renamed from: a  reason: collision with root package name */
    private static String f1365a = l.class.getSimpleName();

    static {
        AppMethodBeat.i(180818);
        AppMethodBeat.o(180818);
    }

    public static boolean a(Context context, String str) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(180817);
        File a2 = x.a(context, t.f1403d);
        File a3 = x.a(context, t.f1407h);
        x.c(a2);
        x.c(a3);
        x.a(context, x.f1424a);
        x.a(context, x.f1425b);
        x.a(context, x.f1426c);
        String c2 = x.c(context, t.o);
        int i2 = s.a(context).f1397a;
        List<p> a4 = x.a(c2);
        if (a4.isEmpty()) {
            z = false;
        } else {
            ArrayList arrayList = new ArrayList();
            boolean z3 = true;
            for (p pVar : a4) {
                if (!x.a(pVar.f1388a) || pVar.f1388a != i2) {
                    if (x.a(pVar.f1388a)) {
                        z2 = z3;
                    } else if (x.a(context, t.f1401b + File.separator + pVar.f1393f, x.b(context, x.f1424a + File.separator + pVar.f1390c), true, true)) {
                        arrayList.add(pVar);
                    } else {
                        z2 = false;
                    }
                    z3 = z2;
                } else if (x.a(context, t.p + File.separator + t.F[i2] + File.separator + pVar.f1393f, x.b(context, x.f1426c + File.separator + t.F[i2] + File.separator + pVar.f1390c), true, true)) {
                    arrayList.add(pVar);
                } else {
                    z3 = false;
                }
            }
            if (!z3 || arrayList.isEmpty()) {
                x.c(a2);
                x.c(a3);
                z = false;
            } else {
                x.a(context, t.q, x.a(arrayList));
                y.f1437e = x.b(arrayList);
                z = true;
            }
        }
        if (!z) {
            g.a(context).a("DCV", "asset to dir fail");
            AppMethodBeat.o(180817);
            return false;
        }
        x.a(context, t.C, str);
        x.a(context, t.A, BuildConfig.KINDA_DEFAULT);
        x.a(context, t.B, BuildConfig.KINDA_DEFAULT);
        AppMethodBeat.o(180817);
        return true;
    }
}
