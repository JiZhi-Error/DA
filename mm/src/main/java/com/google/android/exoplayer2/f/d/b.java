package com.google.android.exoplayer2.f.d;

import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

final class b implements d {
    private final a[] bCD;
    private final long[] bCE;

    public b(a[] aVarArr, long[] jArr) {
        this.bCD = aVarArr;
        this.bCE = jArr;
    }

    @Override // com.google.android.exoplayer2.f.d
    public final int ai(long j2) {
        AppMethodBeat.i(92819);
        int a2 = x.a(this.bCE, j2, false, false);
        if (a2 < this.bCE.length) {
            AppMethodBeat.o(92819);
            return a2;
        }
        AppMethodBeat.o(92819);
        return -1;
    }

    @Override // com.google.android.exoplayer2.f.d
    public final int wa() {
        return this.bCE.length;
    }

    @Override // com.google.android.exoplayer2.f.d
    public final long eH(int i2) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(92820);
        if (i2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        com.google.android.exoplayer2.i.a.checkArgument(z);
        if (i2 >= this.bCE.length) {
            z2 = false;
        }
        com.google.android.exoplayer2.i.a.checkArgument(z2);
        long j2 = this.bCE[i2];
        AppMethodBeat.o(92820);
        return j2;
    }

    @Override // com.google.android.exoplayer2.f.d
    public final List<a> aj(long j2) {
        AppMethodBeat.i(92821);
        int a2 = x.a(this.bCE, j2, false);
        if (a2 == -1 || this.bCD[a2] == null) {
            List<a> emptyList = Collections.emptyList();
            AppMethodBeat.o(92821);
            return emptyList;
        }
        List<a> singletonList = Collections.singletonList(this.bCD[a2]);
        AppMethodBeat.o(92821);
        return singletonList;
    }
}
