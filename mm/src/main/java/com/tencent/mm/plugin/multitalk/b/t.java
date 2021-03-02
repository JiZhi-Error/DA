package com.tencent.mm.plugin.multitalk.b;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.ada;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Timer;

public final class t {
    public static int zKD = 14745600;
    private byte[] frameData = new byte[zKD];
    private boolean mStarted = false;
    private HandlerThread mThread = null;
    private Timer mTimer = null;
    private int qve = 0;
    private int qvf = 0;
    private final Map<String, c> qvg = new HashMap();
    private k zHs = null;
    private int zKB = 0;
    private Timer zKC = null;
    private byte[] zKE = new byte[zKD];

    static /* synthetic */ int b(t tVar) {
        int i2 = tVar.qve + 1;
        tVar.qve = i2;
        return i2;
    }

    static /* synthetic */ int f(t tVar) {
        int i2 = tVar.zKB + 1;
        tVar.zKB = i2;
        return i2;
    }

    public t(k kVar) {
        AppMethodBeat.i(239314);
        this.zHs = kVar;
        AppMethodBeat.o(239314);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        if (r9.mTimer == null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        r9.mTimer.cancel();
        r9.mTimer = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        r9.mTimer = new java.util.Timer();
        r9.mTimer.schedule(new com.tencent.mm.plugin.multitalk.b.t.AnonymousClass1(r9), 0, 20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0043, code lost:
        if (r9.zKC == null) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0045, code lost:
        r9.zKC.cancel();
        r9.zKC = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        r9.zKC = new java.util.Timer();
        r9.zKC.schedule(new com.tencent.mm.plugin.multitalk.b.t.AnonymousClass2(r9), 0, 20);
        com.tencent.matrix.trace.core.AppMethodBeat.o(239315);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean czm() {
        /*
        // Method dump skipped, instructions count: 144
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.multitalk.b.t.czm():boolean");
    }

    public final void release() {
        AppMethodBeat.i(239316);
        Log.e("MicroMsg.Multitalk.ILinkVideoMgr", "release");
        try {
            synchronized (this) {
                try {
                    if (!this.mStarted) {
                        AppMethodBeat.o(239316);
                        return;
                    }
                    this.mStarted = false;
                    stopTimer();
                    synchronized (this.qvg) {
                        try {
                            this.qvg.clear();
                        } finally {
                            AppMethodBeat.o(239316);
                        }
                    }
                } finally {
                    AppMethodBeat.o(239316);
                }
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.Multitalk.ILinkVideoMgr", "release error:" + e2.toString());
            AppMethodBeat.o(239316);
        }
    }

    public final boolean isStarted() {
        boolean z;
        synchronized (this) {
            z = this.mStarted;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public final void a(ada ada) {
        AppMethodBeat.i(239317);
        Log.e("MicroMsg.Multitalk.ILinkVideoMgr", "updateMembers");
        if (ada == null || ada.KHx == null || ada.KHx.size() == 0) {
            AppMethodBeat.o(239317);
            return;
        }
        LinkedList<acz> linkedList = ada.KHx;
        synchronized (this.qvg) {
            try {
                Iterator<acz> it = linkedList.iterator();
                while (it.hasNext()) {
                    acz next = it.next();
                    c cVar = this.qvg.get(next.openid);
                    if (cVar != null) {
                        cVar.ES(next.Lnt);
                    }
                }
            } finally {
                AppMethodBeat.o(239317);
            }
        }
    }

    private void stopTimer() {
        AppMethodBeat.i(239318);
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        if (this.zKC != null) {
            this.zKC.cancel();
            this.zKC = null;
        }
        AppMethodBeat.o(239318);
    }
}
