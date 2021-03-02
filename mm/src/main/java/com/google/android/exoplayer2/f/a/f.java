package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

final class f implements d {
    private final List<a> bAF;

    public f(List<a> list) {
        this.bAF = list;
    }

    @Override // com.google.android.exoplayer2.f.d
    public final int ai(long j2) {
        return j2 < 0 ? 0 : -1;
    }

    @Override // com.google.android.exoplayer2.f.d
    public final int wa() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.f.d
    public final long eH(int i2) {
        AppMethodBeat.i(92785);
        com.google.android.exoplayer2.i.a.checkArgument(i2 == 0);
        AppMethodBeat.o(92785);
        return 0;
    }

    @Override // com.google.android.exoplayer2.f.d
    public final List<a> aj(long j2) {
        AppMethodBeat.i(92786);
        if (j2 >= 0) {
            List<a> list = this.bAF;
            AppMethodBeat.o(92786);
            return list;
        }
        List<a> emptyList = Collections.emptyList();
        AppMethodBeat.o(92786);
        return emptyList;
    }
}
