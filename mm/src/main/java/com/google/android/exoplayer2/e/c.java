package com.google.android.exoplayer2.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public interface c {
    public static final c btN = new c() {
        /* class com.google.android.exoplayer2.e.c.AnonymousClass1 */

        @Override // com.google.android.exoplayer2.e.c
        public final a d(String str, boolean z) {
            AppMethodBeat.i(92359);
            a d2 = d.d(str, z);
            AppMethodBeat.o(92359);
            return d2;
        }

        @Override // com.google.android.exoplayer2.e.c
        public final a vf() {
            AppMethodBeat.i(92360);
            a vf = d.vf();
            AppMethodBeat.o(92360);
            return vf;
        }
    };

    a d(String str, boolean z);

    a vf();
}
