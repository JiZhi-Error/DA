package com.tencent.mm.toolkit.a;

import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.toolkit.a.a.a;

public final class f implements com.tencent.mm.toolkit.a.a.f {
    private String OvJ;

    public f(String str) {
        this.OvJ = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a5, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a6, code lost:
        r2 = r1;
        r3 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008e A[ExcHandler: IOException | NoSuchAlgorithmException (e java.lang.Throwable), PHI: r0 
      PHI: (r0v11 java.security.DigestInputStream) = (r0v9 java.security.DigestInputStream), (r0v9 java.security.DigestInputStream), (r0v17 java.security.DigestInputStream) binds: [B:5:0x000f, B:6:?, B:10:0x0027] A[DONT_GENERATE, DONT_INLINE], Splitter:B:5:0x000f] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean h(java.io.File r5, java.lang.String r6) {
        /*
        // Method dump skipped, instructions count: 177
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.toolkit.a.f.h(java.io.File, java.lang.String):boolean");
    }

    @Override // com.tencent.mm.toolkit.a.a.f
    public final void d(c cVar) {
        AppMethodBeat.i(196823);
        if (!h(cVar.Ovr, this.OvJ)) {
            a aVar = new a(TXLiteAVCode.WARNING_SPEAKER_DEVICE_EMPTY, "File MD5 is invalid.");
            AppMethodBeat.o(196823);
            throw aVar;
        }
        AppMethodBeat.o(196823);
    }
}
