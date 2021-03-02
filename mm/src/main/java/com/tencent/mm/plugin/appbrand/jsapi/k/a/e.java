package com.tencent.mm.plugin.appbrand.jsapi.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k.aa;
import com.tencent.mm.plugin.appbrand.jsapi.k.ac;
import com.tencent.mm.plugin.appbrand.jsapi.k.af;
import com.tencent.mm.plugin.appbrand.jsapi.k.ag;
import com.tencent.mm.plugin.appbrand.jsapi.k.c;
import com.tencent.mm.plugin.appbrand.jsapi.k.d;
import com.tencent.mm.plugin.appbrand.jsapi.k.g;
import com.tencent.mm.plugin.appbrand.jsapi.k.h;
import com.tencent.mm.plugin.appbrand.jsapi.k.i;
import com.tencent.mm.plugin.appbrand.jsapi.k.j;
import com.tencent.mm.plugin.appbrand.jsapi.k.l;
import com.tencent.mm.plugin.appbrand.jsapi.k.m;
import com.tencent.mm.plugin.appbrand.jsapi.k.n;
import com.tencent.mm.plugin.appbrand.jsapi.k.o;
import com.tencent.mm.plugin.appbrand.jsapi.k.p;
import com.tencent.mm.plugin.appbrand.jsapi.k.q;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.mm.plugin.appbrand.jsapi.k.t;
import com.tencent.mm.plugin.appbrand.jsapi.k.u;
import com.tencent.mm.plugin.appbrand.jsapi.k.v;
import com.tencent.mm.plugin.appbrand.jsapi.k.x;
import com.tencent.mm.plugin.appbrand.jsapi.k.z;
import com.tencent.mm.plugin.appbrand.w.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class e {
    private static final Map<String, Integer> mbp;

    static {
        AppMethodBeat.i(143707);
        HashMap hashMap = new HashMap();
        mbp = hashMap;
        hashMap.put(c.NAME, 0);
        mbp.put(h.NAME, 1);
        mbp.put(aa.NAME, 2);
        mbp.put(g.NAME, 3);
        mbp.put(z.NAME, 4);
        mbp.put(r.NAME, 5);
        mbp.put(d.NAME, 6);
        mbp.put(i.NAME, 7);
        mbp.put(l.NAME, 8);
        mbp.put(v.NAME, 9);
        mbp.put(af.NAME, 10);
        mbp.put(p.NAME, 11);
        mbp.put(n.NAME, 12);
        mbp.put(o.NAME, 13);
        mbp.put(q.NAME, 14);
        mbp.put(m.NAME, 15);
        mbp.put(ac.NAME, 16);
        mbp.put(j.NAME, 17);
        mbp.put(u.NAME, 18);
        AppMethodBeat.o(143707);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void ZZ(String str) {
        boolean z;
        int i2;
        AppMethodBeat.i(143704);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(143704);
            return;
        }
        switch (str.hashCode()) {
            case -1949215789:
                if (str.equals(ag.NAME)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -384482333:
                if (str.equals(t.NAME)) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 1282356792:
                if (str.equals(x.NAME)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        switch (z) {
            case false:
                i2 = 0;
                break;
            case true:
                i2 = 3;
                break;
            case true:
                i2 = 6;
                break;
            default:
                if (!mbp.containsKey(str)) {
                    i2 = -1;
                    break;
                } else {
                    i2 = (mbp.get(str).intValue() * 5) + 20 + 0;
                    break;
                }
        }
        if (i2 == -1) {
            Log.e("Luggage.MapReporter", "key is -1, may be err");
            AppMethodBeat.o(143704);
            return;
        }
        xg(i2);
        Log.v("Luggage.MapReporter", "name:%s invoke key:%d", str, Integer.valueOf(i2));
        AppMethodBeat.o(143704);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void e(String str, boolean z, boolean z2) {
        boolean z3;
        int i2;
        int i3;
        AppMethodBeat.i(143705);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(143705);
            return;
        }
        switch (str.hashCode()) {
            case -1949215789:
                if (str.equals(ag.NAME)) {
                    z3 = true;
                    break;
                }
                z3 = true;
                break;
            case -384482333:
                if (str.equals(t.NAME)) {
                    z3 = false;
                    break;
                }
                z3 = true;
                break;
            case 1282356792:
                if (str.equals(x.NAME)) {
                    z3 = true;
                    break;
                }
                z3 = true;
                break;
            default:
                z3 = true;
                break;
        }
        switch (z3) {
            case false:
                if (!z) {
                    i2 = 2;
                    break;
                } else {
                    i2 = 1;
                    break;
                }
            case true:
                if (!z) {
                    i2 = 5;
                    break;
                } else {
                    i2 = 4;
                    break;
                }
            case true:
                if (!z) {
                    i2 = 8;
                    break;
                } else {
                    i2 = 7;
                    break;
                }
            default:
                if (!mbp.containsKey(str)) {
                    i2 = -1;
                    break;
                } else {
                    int intValue = (mbp.get(str).intValue() * 5) + 20;
                    if (z2) {
                        i3 = z ? 3 : 4;
                    } else {
                        i3 = z ? 1 : 2;
                    }
                    i2 = i3 + intValue;
                    break;
                }
        }
        if (i2 == -1) {
            Log.e("Luggage.MapReporter", "key is -1, may be err");
            AppMethodBeat.o(143705);
            return;
        }
        xg(i2);
        Log.v("Luggage.MapReporter", "name:%s, isOk:%b, isOtherMap:%b, key:%d", str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2));
        AppMethodBeat.o(143705);
    }

    public static void xg(int i2) {
        AppMethodBeat.i(143706);
        Log.v("Luggage.MapReporter", "reportKey:%d", Integer.valueOf(i2));
        ((a) com.tencent.luggage.a.e.N(a.class)).idkeyStat(1020, (long) i2, 1, false);
        AppMethodBeat.o(143706);
    }
}
