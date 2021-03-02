package com.google.android.exoplayer2.h.a;

import com.google.android.exoplayer2.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h {

    public static class a {
        public volatile long bGs;
        public volatile long bGt;
        public volatile long contentLength = -1;
    }

    public static String c(j jVar) {
        AppMethodBeat.i(92996);
        if (jVar.key != null) {
            String str = jVar.key;
            AppMethodBeat.o(92996);
            return str;
        }
        String uri = jVar.uri.toString();
        AppMethodBeat.o(92996);
        return uri;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b9, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ba, code lost:
        com.google.android.exoplayer2.i.x.a(r20);
        com.tencent.matrix.trace.core.AppMethodBeat.o(92997);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c3, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001a, code lost:
        r3 = r2;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b9 A[ExcHandler: all (r2v3 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x0007] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long a(com.google.android.exoplayer2.h.j r15, long r16, long r18, com.google.android.exoplayer2.h.g r20, byte[] r21, com.google.android.exoplayer2.h.a.h.a r22) {
        /*
        // Method dump skipped, instructions count: 196
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.h.a.h.a(com.google.android.exoplayer2.h.j, long, long, com.google.android.exoplayer2.h.g, byte[], com.google.android.exoplayer2.h.a.h$a):long");
    }
}
