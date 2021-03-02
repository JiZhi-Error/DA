package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.c.b.d;
import com.google.android.exoplayer2.c.c.b;
import com.google.android.exoplayer2.c.d.e;
import com.google.android.exoplayer2.c.d.g;
import com.google.android.exoplayer2.c.f.a;
import com.google.android.exoplayer2.c.f.p;
import com.google.android.exoplayer2.c.f.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;

public final class c implements h {
    private static final Constructor<? extends e> bhP;
    private int bhQ;
    private int bhR;
    private int bhS;
    private int bhT;
    private int bhU = 1;
    private int bhV;

    static {
        AppMethodBeat.i(91973);
        Constructor<? extends U> constructor = null;
        try {
            constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(e.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
        }
        bhP = constructor;
        AppMethodBeat.o(91973);
    }

    @Override // com.google.android.exoplayer2.c.h
    public final synchronized e[] ux() {
        e[] eVarArr;
        int i2 = 11;
        synchronized (this) {
            AppMethodBeat.i(91972);
            if (bhP != null) {
                i2 = 12;
            }
            eVarArr = new e[i2];
            eVarArr[0] = new d(this.bhQ);
            eVarArr[1] = new e(this.bhS);
            eVarArr[2] = new g(this.bhR);
            eVarArr[3] = new b(this.bhT);
            eVarArr[4] = new com.google.android.exoplayer2.c.f.c();
            eVarArr[5] = new a();
            eVarArr[6] = new u(this.bhU, this.bhV);
            eVarArr[7] = new com.google.android.exoplayer2.c.a.b();
            eVarArr[8] = new com.google.android.exoplayer2.c.e.c();
            eVarArr[9] = new p();
            eVarArr[10] = new com.google.android.exoplayer2.c.g.a();
            if (bhP != null) {
                try {
                    eVarArr[11] = (e) bhP.newInstance(new Object[0]);
                } catch (Exception e2) {
                    IllegalStateException illegalStateException = new IllegalStateException("Unexpected error creating FLAC extractor", e2);
                    AppMethodBeat.o(91972);
                    throw illegalStateException;
                }
            }
            AppMethodBeat.o(91972);
        }
        return eVarArr;
    }
}
