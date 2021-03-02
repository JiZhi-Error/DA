package com.tencent.mm.plugin.appbrand.appcache.predownload.c;

import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.b;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.c;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.d;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.e;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.f;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.g;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.h;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.smtt.sdk.TbsListener;

public enum a {
    INSTANCE;
    
    public static final C0549a kQu = new C0549a<Class<? extends com.tencent.mm.plugin.appbrand.appcache.predownload.b.a>>() {
        /* class com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.AnonymousClass1 */

        {
            AppMethodBeat.i(44418);
            h(d.class, 20);
            h(c.class, 40);
            h(e.class, 80);
            h(g.class, 100);
            h(f.class, 120);
            h(i.class, 150);
            h(b.class, 160);
            h(h.class, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1);
            AppMethodBeat.o(44418);
        }
    };
    public static final C0549a kQv = new C0549a<Class<? extends com.tencent.mm.plugin.appbrand.appcache.predownload.b.a>>() {
        /* class com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.AnonymousClass2 */

        {
            AppMethodBeat.i(44419);
            h(d.class, 21);
            h(c.class, 41);
            h(e.class, 81);
            h(g.class, 101);
            h(f.class, 121);
            h(i.class, 151);
            h(b.class, 161);
            h(h.class, 172);
            AppMethodBeat.o(44419);
        }
    };
    public static final C0549a kQw = new C0549a<Class<? extends com.tencent.mm.plugin.appbrand.appcache.predownload.b.a>>() {
        /* class com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.AnonymousClass3 */

        {
            AppMethodBeat.i(44420);
            h(d.class, 22);
            h(c.class, 42);
            h(e.class, 82);
            h(g.class, 102);
            h(f.class, 122);
            h(i.class, 152);
            h(b.class, TbsListener.ErrorCode.STARTDOWNLOAD_3);
            h(h.class, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3);
            AppMethodBeat.o(44420);
        }
    };
    public static final C0549a kQx = new C0549a<Class<? extends com.tencent.mm.plugin.appbrand.appcache.predownload.b.a>>() {
        /* class com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.AnonymousClass4 */

        {
            AppMethodBeat.i(44421);
            h(d.class, 23);
            h(c.class, 43);
            h(e.class, 83);
            h(g.class, 103);
            h(f.class, 123);
            h(i.class, 153);
            h(b.class, TbsListener.ErrorCode.STARTDOWNLOAD_4);
            h(h.class, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4);
            AppMethodBeat.o(44421);
        }
    };

    public static a valueOf(String str) {
        AppMethodBeat.i(44426);
        a aVar = (a) Enum.valueOf(a.class, str);
        AppMethodBeat.o(44426);
        return aVar;
    }

    static {
        AppMethodBeat.i(44429);
        AppMethodBeat.o(44429);
    }

    public static void dN(int i2, int i3) {
        AppMethodBeat.i(261628);
        F((long) i2, (long) i3);
        AppMethodBeat.o(261628);
    }

    public static void F(long j2, long j3) {
        AppMethodBeat.i(44428);
        if (j3 < 0) {
            Log.e("MicroMsg.AppBrand.PredownloadReporter", "idkeyStat with invalid ID(%d), key (%d)", Long.valueOf(j2), Long.valueOf(j3));
            AppMethodBeat.o(44428);
            return;
        }
        if (j2 > 0) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(j2, j3, 1);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(15272, Long.valueOf(j2), Long.valueOf(j3));
        }
        if (843 != j2) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(843, j3, 1);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(15272, Integer.valueOf((int) j.CTRL_INDEX), Long.valueOf(j3));
        }
        AppMethodBeat.o(44428);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.predownload.c.a$a  reason: collision with other inner class name */
    public static class C0549a<_Key> extends SparseIntArray {
        public final void h(_Key _key, int i2) {
            AppMethodBeat.i(44422);
            super.put(_key.hashCode(), i2);
            AppMethodBeat.o(44422);
        }

        private int ct(_Key _key) {
            AppMethodBeat.i(44423);
            if (_key == null) {
                AppMethodBeat.o(44423);
                return -1;
            }
            int i2 = super.get(_key.hashCode(), -1);
            AppMethodBeat.o(44423);
            return i2;
        }

        public final int get(_Key _key) {
            AppMethodBeat.i(44424);
            int ct = ct(_key);
            AppMethodBeat.o(44424);
            return ct;
        }
    }
}
