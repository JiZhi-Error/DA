package com.google.android.exoplayer2.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.regex.Pattern;

final class m extends g {
    private static final Pattern bGM = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);
    private static final Pattern bGN = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);
    private static final Pattern bGO = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);

    static {
        AppMethodBeat.i(93032);
        AppMethodBeat.o(93032);
    }

    public static File a(File file, int i2, long j2, long j3) {
        AppMethodBeat.i(93027);
        File file2 = new File(file, i2 + "." + j2 + "." + j3 + ".v3.exo");
        AppMethodBeat.o(93027);
        return file2;
    }

    public static m k(String str, long j2) {
        AppMethodBeat.i(93028);
        m mVar = new m(str, j2, -1, -9223372036854775807L, null);
        AppMethodBeat.o(93028);
        return mVar;
    }

    public static m l(String str, long j2) {
        AppMethodBeat.i(93029);
        m mVar = new m(str, j2, -1, -9223372036854775807L, null);
        AppMethodBeat.o(93029);
        return mVar;
    }

    public static m g(String str, long j2, long j3) {
        AppMethodBeat.i(93030);
        m mVar = new m(str, j2, j3, -9223372036854775807L, null);
        AppMethodBeat.o(93030);
        return mVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.h.a.m a(java.io.File r13, com.google.android.exoplayer2.h.a.j r14) {
        /*
        // Method dump skipped, instructions count: 189
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.h.a.m.a(java.io.File, com.google.android.exoplayer2.h.a.j):com.google.android.exoplayer2.h.a.m");
    }

    m(String str, long j2, long j3, long j4, File file) {
        super(str, j2, j3, j4, file);
    }
}
