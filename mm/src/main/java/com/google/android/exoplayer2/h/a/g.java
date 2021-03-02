package com.google.android.exoplayer2.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class g implements Comparable<g> {
    public final boolean bGq;
    public final long bGr;
    public final File file;
    public final String key;
    public final long length;
    public final long position;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(g gVar) {
        AppMethodBeat.i(92995);
        int d2 = d(gVar);
        AppMethodBeat.o(92995);
        return d2;
    }

    public g(String str, long j2, long j3, long j4, File file2) {
        AppMethodBeat.i(92993);
        this.key = str;
        this.position = j2;
        this.length = j3;
        this.bGq = file2 != null;
        this.file = file2;
        this.bGr = j4;
        AppMethodBeat.o(92993);
    }

    public final boolean wS() {
        return this.length == -1;
    }

    public final int d(g gVar) {
        AppMethodBeat.i(92994);
        if (!this.key.equals(gVar.key)) {
            int compareTo = this.key.compareTo(gVar.key);
            AppMethodBeat.o(92994);
            return compareTo;
        }
        long j2 = this.position - gVar.position;
        if (j2 == 0) {
            AppMethodBeat.o(92994);
            return 0;
        } else if (j2 < 0) {
            AppMethodBeat.o(92994);
            return -1;
        } else {
            AppMethodBeat.o(92994);
            return 1;
        }
    }
}
