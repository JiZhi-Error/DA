package com.tencent.mm.plugin.record.b;

import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.record.a.b;
import com.tencent.mm.plugin.record.a.c;
import java.util.LinkedList;
import java.util.List;

public abstract class i<T extends c> implements b {
    private boolean BGI = false;
    final int BGJ = 3;
    private final int BGK = 300000;
    private SparseArray<i<T>.a> BGL = new SparseArray<>();
    private LinkedList<T> BGM = new LinkedList<>();
    private long BGN = 0;

    /* access modifiers changed from: protected */
    public abstract List<T> eIp();

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x011b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.plugin.record.b.i r10) {
        /*
        // Method dump skipped, instructions count: 288
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.record.b.i.a(com.tencent.mm.plugin.record.b.i):void");
    }

    /* access modifiers changed from: package-private */
    public final class a {
        long BGP;
        int jNv;

        private a() {
            AppMethodBeat.i(9490);
            this.BGP = SystemClock.elapsedRealtime();
            this.jNv = i.this.BGJ;
            AppMethodBeat.o(9490);
        }

        /* synthetic */ a(i iVar, byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.record.a.b
    public final void run() {
        g.aAi();
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.record.b.i.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(9488);
                i.a(i.this);
                AppMethodBeat.o(9488);
            }

            public final String toString() {
                AppMethodBeat.i(9489);
                String str = super.toString() + "|tryDoJob";
                AppMethodBeat.o(9489);
                return str;
            }
        });
    }

    /* access modifiers changed from: protected */
    public final void eIq() {
        this.BGI = false;
        run();
    }

    public final void finish() {
        this.BGM.clear();
        this.BGL.clear();
        this.BGI = false;
    }
}
