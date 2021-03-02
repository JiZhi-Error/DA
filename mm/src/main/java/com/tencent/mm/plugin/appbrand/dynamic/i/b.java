package com.tencent.mm.plugin.appbrand.dynamic.i;

import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.plugin.appbrand.jsapi.k.ab;
import java.util.ArrayList;

public final class b {
    private static a lpl = new a((byte) 0);
    private static a lpm = new a((byte) 0);

    static {
        AppMethodBeat.i(121457);
        AppMethodBeat.o(121457);
    }

    public static void h(long j2, int i2) {
        AppMethodBeat.i(121454);
        if (j2 <= 0 || i2 <= 0) {
            AppMethodBeat.o(121454);
            return;
        }
        switch (h.ayU()) {
            case 1:
                a(lpm, j2, i2);
                AppMethodBeat.o(121454);
                return;
            default:
                a(lpl, j2, i2);
                AppMethodBeat.o(121454);
                return;
        }
    }

    public static void bCs() {
        AppMethodBeat.i(121455);
        a(5, 6, 7, 8, lpm);
        a(0, 1, 2, 3, lpl);
        lpm.reset();
        lpl.reset();
        AppMethodBeat.o(121455);
    }

    private static void a(a aVar, long j2, int i2) {
        synchronized (aVar) {
            aVar.cxN += j2 / 1000;
            aVar.lpn += (long) i2;
            aVar.lpo += j2 / ((long) i2);
            aVar.count++;
        }
    }

    private static void a(int i2, int i3, int i4, int i5, a aVar) {
        AppMethodBeat.i(121456);
        int i6 = aVar.count;
        long j2 = aVar.cxN;
        long j3 = aVar.lpn;
        long j4 = aVar.lpo;
        if (j2 <= 0 || j3 <= 0 || i6 <= 0 || j4 <= 0) {
            AppMethodBeat.o(121456);
            return;
        }
        ArrayList<IDKey> arrayList = new ArrayList<>();
        IDKey iDKey = new IDKey();
        iDKey.SetID(ab.CTRL_INDEX);
        iDKey.SetKey(i2);
        iDKey.SetValue(j2);
        arrayList.add(iDKey);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(ab.CTRL_INDEX);
        iDKey2.SetKey(i3);
        iDKey2.SetValue(j3);
        arrayList.add(iDKey2);
        IDKey iDKey3 = new IDKey();
        iDKey3.SetID(ab.CTRL_INDEX);
        iDKey3.SetKey(i4);
        iDKey3.SetValue((long) i6);
        arrayList.add(iDKey3);
        IDKey iDKey4 = new IDKey();
        iDKey4.SetID(ab.CTRL_INDEX);
        iDKey4.SetKey(i5);
        iDKey4.SetValue(j4);
        arrayList.add(iDKey4);
        com.tencent.mm.plugin.report.service.h.INSTANCE.b(arrayList, false);
        AppMethodBeat.o(121456);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        volatile int count;
        volatile long cxN;
        volatile long lpn;
        volatile long lpo;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final synchronized void reset() {
            this.cxN = 0;
            this.lpn = 0;
            this.count = 0;
        }
    }
}
