package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import com.google.android.exoplayer2.c.b.d;
import com.google.android.exoplayer2.c.c.b;
import com.google.android.exoplayer2.c.d.g;
import com.google.android.exoplayer2.c.f.a;
import com.google.android.exoplayer2.c.f.c;
import com.google.android.exoplayer2.c.f.p;
import com.google.android.exoplayer2.c.f.u;
import com.google.android.exoplayer2.c.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;

public final class e implements h {
    private static final Constructor<? extends com.google.android.exoplayer2.c.e> bhP;
    private int bhQ;
    private int bhR;
    private int bhS;
    private int bhT;
    private int bhU = 1;
    private int bhV;

    static {
        AppMethodBeat.i(234970);
        Constructor<? extends U> constructor = null;
        try {
            constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(com.google.android.exoplayer2.c.e.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
        }
        bhP = constructor;
        AppMethodBeat.o(234970);
    }

    @Override // com.google.android.exoplayer2.c.h
    public final synchronized com.google.android.exoplayer2.c.e[] ux() {
        com.google.android.exoplayer2.c.e[] eVarArr;
        int i2 = 11;
        synchronized (this) {
            AppMethodBeat.i(234969);
            if (bhP != null) {
                i2 = 12;
            }
            eVarArr = new com.google.android.exoplayer2.c.e[i2];
            eVarArr[0] = new g(this.bhR);
            eVarArr[1] = new u(this.bhU, this.bhV);
            eVarArr[2] = new com.google.android.exoplayer2.c.d.e(this.bhS);
            eVarArr[3] = new b(this.bhT);
            eVarArr[4] = new d(this.bhQ);
            eVarArr[5] = new c();
            eVarArr[6] = new a();
            eVarArr[7] = new com.google.android.exoplayer2.c.a.b();
            eVarArr[8] = new com.google.android.exoplayer2.c.e.c();
            eVarArr[9] = new p();
            eVarArr[10] = new com.google.android.exoplayer2.c.g.a();
            if (bhP != null) {
                try {
                    eVarArr[11] = (com.google.android.exoplayer2.c.e) bhP.newInstance(new Object[0]);
                } catch (Exception e2) {
                    IllegalStateException illegalStateException = new IllegalStateException("Unexpected error creating FLAC extractor", e2);
                    AppMethodBeat.o(234969);
                    throw illegalStateException;
                }
            }
            AppMethodBeat.o(234969);
        }
        return eVarArr;
    }
}
