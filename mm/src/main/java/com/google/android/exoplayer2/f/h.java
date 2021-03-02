package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.b.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h extends e implements Comparable<h> {
    public long bdC;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(h hVar) {
        AppMethodBeat.i(92824);
        h hVar2 = hVar;
        if (ud() == hVar2.ud()) {
            long j2 = this.timeUs - hVar2.timeUs;
            if (j2 == 0) {
                AppMethodBeat.o(92824);
                return 0;
            } else if (j2 > 0) {
                AppMethodBeat.o(92824);
                return 1;
            } else {
                AppMethodBeat.o(92824);
                return -1;
            }
        } else if (ud()) {
            AppMethodBeat.o(92824);
            return 1;
        } else {
            AppMethodBeat.o(92824);
            return -1;
        }
    }

    public h() {
        super(1);
    }
}
