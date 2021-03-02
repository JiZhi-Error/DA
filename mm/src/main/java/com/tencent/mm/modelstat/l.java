package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.a.b;
import com.tencent.mm.network.ag;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;

public final class l extends b.a implements h {
    public static long a(o oVar, long j2) {
        long length;
        AppMethodBeat.i(177293);
        long j3 = 0;
        try {
            o[] het = oVar.het();
            for (int i2 = 0; i2 < het.length; i2++) {
                if (het[i2].isDirectory()) {
                    length = a(het[i2], j2);
                } else {
                    if (het[i2].length() > j2) {
                        Log.i("MicroMsg.NetStatMsgExtension", "getFolderSize filesize:%s [%s]", Long.valueOf(het[i2].length()), aa.z(het[i2].mUri));
                    }
                    length = het[i2].length();
                }
                j3 += length;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.NetStatMsgExtension", "getFolderSize :%s", Util.stackTraceToString(e2));
        }
        AppMethodBeat.o(177293);
        return j3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x036b  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x039e  */
    @Override // com.tencent.mm.ak.h
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.ak.h.b b(com.tencent.mm.ak.h.a r15) {
        /*
        // Method dump skipped, instructions count: 1054
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelstat.l.b(com.tencent.mm.ak.h$a):com.tencent.mm.ak.h$b");
    }

    @Override // com.tencent.mm.network.a.b
    public final void a(final int i2, final int i3, final String str, final int i4, final String str2, final boolean z) {
        AppMethodBeat.i(151094);
        g.aAk().postToWorkerDelayed(new Runnable() {
            /* class com.tencent.mm.modelstat.l.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(151090);
                l.b(i2, i3, i4, z);
                AppMethodBeat.o(151090);
            }

            public final String toString() {
                AppMethodBeat.i(151091);
                String str = super.toString() + "|report";
                AppMethodBeat.o(151091);
                return str;
            }
        }, 3000);
        AppMethodBeat.o(151094);
    }

    @Override // com.tencent.mm.network.a.b
    public final void u(int i2, int i3, int i4, int i5) {
        long j2;
        long j3 = 0;
        AppMethodBeat.i(151095);
        if (!g.aAf().azp()) {
            AppMethodBeat.o(151095);
        } else if (!g.aAi().hrh.hrB) {
            Log.i("MicroMsg.NetStatMsgExtension", "kernel has not startup");
            AppMethodBeat.o(151095);
        } else {
            Log.i("MicroMsg.NetStatMsgExtension", "reportNetFlow wifi[%d, %d] mobile[%d, %d]", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
            if (ag.dm(MMApplicationContext.getContext())) {
                long j4 = i2 > 0 ? (long) i2 : 0;
                if (i3 > 0) {
                    j3 = (long) i3;
                }
                n.b(j4, j3, 0);
                AppMethodBeat.o(151095);
                return;
            }
            if (i4 > 0) {
                j2 = (long) i4;
            } else {
                j2 = 0;
            }
            if (i5 > 0) {
                j3 = (long) i5;
            }
            n.c(j2, j3, 0);
            AppMethodBeat.o(151095);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void b(int i2, int i3, int i4, boolean z) {
        AppMethodBeat.i(151096);
        if (!g.aAf().azp()) {
            AppMethodBeat.o(151096);
            return;
        }
        switch (i2) {
            case 4:
                Log.d("MicroMsg.NetStatMsgExtension", "recv bytes flow:".concat(String.valueOf(i4)));
                if (z) {
                    n.b((long) i4, 0, i3);
                    AppMethodBeat.o(151096);
                    return;
                }
                n.c((long) i4, 0, i3);
                AppMethodBeat.o(151096);
                return;
            case 5:
                Log.d("MicroMsg.NetStatMsgExtension", "send bytes flow:".concat(String.valueOf(i4)));
                if (z) {
                    n.b(0, (long) i4, i3);
                    AppMethodBeat.o(151096);
                    return;
                }
                n.c(0, (long) i4, i3);
                AppMethodBeat.o(151096);
                return;
            case 8:
                MMEntryLock.lock("dns_failed_report");
                break;
        }
        AppMethodBeat.o(151096);
    }

    @Override // com.tencent.mm.ak.h
    public final void b(h.c cVar) {
    }
}
