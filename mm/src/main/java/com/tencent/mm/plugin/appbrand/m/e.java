package com.tencent.mm.plugin.appbrand.m;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicInteger;

public class e {
    static final /* synthetic */ boolean $assertionsDisabled = (!e.class.desiredAssertionStatus());
    private final a mNQ;
    private final AtomicInteger mNR = new AtomicInteger(1);
    final SparseArray<d> mNS = new SparseArray<>();

    public interface a {
        m yc(int i2);
    }

    static {
        AppMethodBeat.i(144171);
        AppMethodBeat.o(144171);
    }

    public e(a aVar) {
        AppMethodBeat.i(144168);
        this.mNQ = aVar;
        AppMethodBeat.o(144168);
    }

    public static int bMG() {
        return 1;
    }

    public final g xX(int i2) {
        d dVar;
        AppMethodBeat.i(144169);
        synchronized (this.mNS) {
            try {
                dVar = this.mNS.get(i2);
            } finally {
                AppMethodBeat.o(144169);
            }
        }
        return dVar;
    }

    public final g bME() {
        AppMethodBeat.i(144170);
        int incrementAndGet = this.mNR.incrementAndGet();
        f fVar = new f(this.mNQ.yc(incrementAndGet), incrementAndGet);
        synchronized (this.mNS) {
            try {
                this.mNS.put(incrementAndGet, fVar);
            } catch (Throwable th) {
                AppMethodBeat.o(144170);
                throw th;
            }
        }
        Log.i("MicroMsg.AppBrandJ2V8ContextMgr", "allocJsContext id:%d", Integer.valueOf(incrementAndGet));
        AppMethodBeat.o(144170);
        return fVar;
    }
}
