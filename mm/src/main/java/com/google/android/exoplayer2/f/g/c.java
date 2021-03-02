package com.google.android.exoplayer2.f.g;

import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

final class c implements d {
    private final List<a> bAF;

    public c(List<a> list) {
        AppMethodBeat.i(92888);
        this.bAF = Collections.unmodifiableList(list);
        AppMethodBeat.o(92888);
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
        AppMethodBeat.i(92889);
        com.google.android.exoplayer2.i.a.checkArgument(i2 == 0);
        AppMethodBeat.o(92889);
        return 0;
    }

    @Override // com.google.android.exoplayer2.f.d
    public final List<a> aj(long j2) {
        AppMethodBeat.i(92890);
        if (j2 >= 0) {
            List<a> list = this.bAF;
            AppMethodBeat.o(92890);
            return list;
        }
        List<a> emptyList = Collections.emptyList();
        AppMethodBeat.o(92890);
        return emptyList;
    }
}
