package com.google.android.exoplayer2.c.g;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c {
    public static b m(f fVar) {
        a a2;
        AppMethodBeat.i(92313);
        com.google.android.exoplayer2.i.a.checkNotNull(fVar);
        m mVar = new m(16);
        if (a.a(fVar, mVar).id != x.bJ("RIFF")) {
            AppMethodBeat.o(92313);
            return null;
        }
        fVar.b(mVar.data, 0, 4);
        mVar.setPosition(0);
        if (mVar.readInt() != x.bJ("WAVE")) {
            AppMethodBeat.o(92313);
            return null;
        }
        while (true) {
            a2 = a.a(fVar, mVar);
            if (a2.id == x.bJ("fmt ")) {
                break;
            }
            fVar.dQ((int) a2.size);
        }
        com.google.android.exoplayer2.i.a.checkState(a2.size >= 16);
        fVar.b(mVar.data, 0, 16);
        mVar.setPosition(0);
        int xe = mVar.xe();
        int xe2 = mVar.xe();
        int xl = mVar.xl();
        int xl2 = mVar.xl();
        int xe3 = mVar.xe();
        int xe4 = mVar.xe();
        int i2 = (xe2 * xe4) / 8;
        if (xe3 != i2) {
            o oVar = new o("Expected block alignment: " + i2 + "; got: " + xe3);
            AppMethodBeat.o(92313);
            throw oVar;
        }
        int fg = x.fg(xe4);
        if (fg == 0) {
            AppMethodBeat.o(92313);
            return null;
        } else if (xe == 1 || xe == 65534) {
            fVar.dQ(((int) a2.size) - 16);
            b bVar = new b(xe2, xl, xl2, xe3, xe4, fg);
            AppMethodBeat.o(92313);
            return bVar;
        } else {
            AppMethodBeat.o(92313);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        public final int id;
        public final long size;

        private a(int i2, long j2) {
            this.id = i2;
            this.size = j2;
        }

        public static a a(f fVar, m mVar) {
            AppMethodBeat.i(92312);
            fVar.b(mVar.data, 0, 8);
            mVar.setPosition(0);
            a aVar = new a(mVar.readInt(), mVar.xg());
            AppMethodBeat.o(92312);
            return aVar;
        }
    }
}
