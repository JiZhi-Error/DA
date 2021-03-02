package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.Vector;

public final class c {
    private static Vector<m> qIk = new Vector<>();
    private static m qIl;

    static {
        AppMethodBeat.i(88950);
        AppMethodBeat.o(88950);
    }

    public static void a(m mVar) {
        AppMethodBeat.i(88939);
        if (mVar != null && !qIk.contains(mVar)) {
            qIk.add(mVar);
        }
        AppMethodBeat.o(88939);
    }

    public static void b(m mVar) {
        AppMethodBeat.i(88940);
        if (mVar != null) {
            qIk.remove(mVar);
        }
        AppMethodBeat.o(88940);
    }

    public final void m(final long j2, final String str) {
        AppMethodBeat.i(88941);
        Log.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskStarted: %d, %s", Long.valueOf(j2), str);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.downloader.model.c.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(88931);
                for (m mVar : c.cBq()) {
                    mVar.k(j2, str);
                }
                if (c.qIl != null) {
                    c.qIl.k(j2, str);
                }
                AppMethodBeat.o(88931);
            }
        });
        AppMethodBeat.o(88941);
    }

    public final void n(final long j2, final String str) {
        AppMethodBeat.i(88942);
        Log.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskResumed: %d, %s", Long.valueOf(j2), str);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.downloader.model.c.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(88932);
                for (m mVar : c.cBq()) {
                    mVar.l(j2, str);
                }
                if (c.qIl != null) {
                    c.qIl.l(j2, str);
                }
                AppMethodBeat.o(88932);
            }
        });
        AppMethodBeat.o(88942);
    }

    public final void Ct(final long j2) {
        AppMethodBeat.i(88943);
        Log.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskRemoved: %d", Long.valueOf(j2));
        a Cw = d.Cw(j2);
        if (Cw != null) {
            com.tencent.mm.plugin.downloader.a.c.w(Cw.field_downloadUrl, Cw.field_secondaryUrl);
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.downloader.model.c.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(88933);
                for (m mVar : c.cBq()) {
                    mVar.Bd(j2);
                }
                if (c.qIl != null) {
                    c.qIl.Bd(j2);
                }
                AppMethodBeat.o(88933);
            }
        });
        AppMethodBeat.o(88943);
    }

    public final void c(final long j2, final String str, final boolean z) {
        AppMethodBeat.i(88944);
        Log.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskFinished: %d", Long.valueOf(j2));
        e.Cz(j2);
        a Cw = d.Cw(j2);
        if (Cw != null) {
            com.tencent.mm.plugin.downloader.a.c.w(Cw.field_downloadUrl, Cw.field_secondaryUrl);
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.downloader.model.c.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(88934);
                for (m mVar : c.cBq()) {
                    mVar.b(j2, str, z);
                }
                if (c.qIl != null) {
                    c.qIl.b(j2, str, z);
                }
                AppMethodBeat.o(88934);
            }
        });
        AppMethodBeat.o(88944);
    }

    public final void c(final long j2, final int i2, final boolean z) {
        AppMethodBeat.i(88945);
        Log.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskFailed: %d, errCode : %d", Long.valueOf(j2), Integer.valueOf(i2));
        e.Cz(j2);
        a Cw = d.Cw(j2);
        if (Cw != null) {
            com.tencent.mm.plugin.downloader.a.c.w(Cw.field_downloadUrl, Cw.field_secondaryUrl);
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.downloader.model.c.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(88935);
                for (m mVar : c.cBq()) {
                    mVar.b(j2, i2, z);
                }
                if (c.qIl != null) {
                    c.qIl.b(j2, i2, z);
                }
                AppMethodBeat.o(88935);
            }
        });
        AppMethodBeat.o(88945);
    }

    public final void Cu(final long j2) {
        AppMethodBeat.i(88946);
        Log.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskPaused: %d", Long.valueOf(j2));
        a Cw = d.Cw(j2);
        if (Cw != null) {
            com.tencent.mm.plugin.downloader.a.c.w(Cw.field_downloadUrl, Cw.field_secondaryUrl);
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.downloader.model.c.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(88936);
                for (m mVar : c.cBq()) {
                    mVar.Be(j2);
                }
                if (c.qIl != null) {
                    c.qIl.Be(j2);
                }
                AppMethodBeat.o(88936);
            }
        });
        AppMethodBeat.o(88946);
    }

    public final void b(final long j2, final String str, final long j3, final long j4) {
        AppMethodBeat.i(192256);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.downloader.model.c.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(88937);
                for (m mVar : c.cBq()) {
                    mVar.a(j2, str, j3, j4);
                }
                AppMethodBeat.o(88937);
            }
        });
        AppMethodBeat.o(192256);
    }

    public final void Cv(final long j2) {
        AppMethodBeat.i(88948);
        Log.i("MicroMsg.FileDownloaderCallbackManager", "notifyMd5Checking: %d", Long.valueOf(j2));
        e.Cy(j2);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.downloader.model.c.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(88938);
                for (m mVar : c.cBq()) {
                    mVar.Bf(j2);
                }
                AppMethodBeat.o(88938);
            }
        });
        AppMethodBeat.o(88948);
    }

    static /* synthetic */ m[] cBq() {
        AppMethodBeat.i(88949);
        m[] mVarArr = (m[]) qIk.toArray(new m[qIk.size()]);
        AppMethodBeat.o(88949);
        return mVarArr;
    }
}
