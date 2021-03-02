package com.google.android.exoplayer2.f.f;

import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

final class b implements d {
    public static final b bDs = new b();
    private final List<a> bAF;

    static {
        AppMethodBeat.i(92875);
        AppMethodBeat.o(92875);
    }

    public b(a aVar) {
        AppMethodBeat.i(92871);
        this.bAF = Collections.singletonList(aVar);
        AppMethodBeat.o(92871);
    }

    private b() {
        AppMethodBeat.i(92872);
        this.bAF = Collections.emptyList();
        AppMethodBeat.o(92872);
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
        AppMethodBeat.i(92873);
        com.google.android.exoplayer2.i.a.checkArgument(i2 == 0);
        AppMethodBeat.o(92873);
        return 0;
    }

    @Override // com.google.android.exoplayer2.f.d
    public final List<a> aj(long j2) {
        AppMethodBeat.i(92874);
        if (j2 >= 0) {
            List<a> list = this.bAF;
            AppMethodBeat.o(92874);
            return list;
        }
        List<a> emptyList = Collections.emptyList();
        AppMethodBeat.o(92874);
        return emptyList;
    }
}
