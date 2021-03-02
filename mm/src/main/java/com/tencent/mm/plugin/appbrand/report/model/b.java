package com.tencent.mm.plugin.appbrand.report.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.report.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public class b {
    public volatile AppBrandRuntime kEc;
    public volatile String mAppId;
    protected final v nIq;
    public volatile String nIr;
    public volatile long nIs = 0;
    public volatile long nIt = 0;
    private final LinkedList<Runnable> nIu = new LinkedList<>();

    public b(int i2) {
        AppMethodBeat.i(139925);
        this.nIq = new v("MicroMsg.AppBrandPageViewStatistics[" + i2 + "]");
        AppMethodBeat.o(139925);
    }

    public final boolean isLoading() {
        return this.nIs > 0 && this.nIt <= 0;
    }

    public final long bUD() {
        AppMethodBeat.i(139926);
        long max = Math.max(0L, this.nIt);
        AppMethodBeat.o(139926);
        return max;
    }

    public final void onBackground() {
        AppMethodBeat.i(230541);
        if (this.nIq.bUz()) {
            while (!this.nIu.isEmpty()) {
                this.nIu.pollFirst().run();
            }
        }
        AppMethodBeat.o(230541);
    }

    public final void onForeground() {
        AppMethodBeat.i(230542);
        if (this.nIs <= 0) {
            AppMethodBeat.o(230542);
            return;
        }
        v vVar = this.nIq;
        boolean z = vVar.nHO.getAndSet(1) != 1;
        Log.d("Luggage.StayingRecorder", "%s toForeground, changed:%b", vVar.mName, Boolean.valueOf(z));
        if (z) {
            vVar.nHP.exit();
            v.c cVar = vVar.nHQ;
            vVar.nHP = cVar;
            cVar.enter();
        }
        if (z) {
            this.nIu.clear();
        }
        AppMethodBeat.o(230542);
    }

    public final void onDestroy() {
        AppMethodBeat.i(230543);
        this.nIq.bUz();
        v vVar = this.nIq;
        vVar.nHO.set(-1);
        vVar.nHP = new v.d(vVar, (byte) 0);
        AppMethodBeat.o(230543);
    }

    public final long bUE() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(139927);
        if (1 == this.nIq.nHO.get()) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            int i2 = this.nIq.nHO.get();
            if (-1 == i2 || 2 == i2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                AppMethodBeat.o(139927);
                return 0;
            }
        }
        long j2 = this.nIq.nHT;
        long j3 = this.nIs;
        long j4 = this.nIt;
        if (j2 <= 0) {
            Log.i("MicroMsg.AppBrandPageViewStatistics", "foregroundMs invalid(%d), loadStart %d, loadCost %d, [%s/%s], runtimeIsFinishing=%b", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), this.mAppId, this.nIr, Boolean.valueOf(this.kEc != null && this.kEc.SO));
            if (j3 > 0 && j4 > 0 && j2 == 0) {
                long nowMilliSecond = Util.nowMilliSecond() - j3;
                AppMethodBeat.o(139927);
                return nowMilliSecond;
            }
        }
        long max = Math.max(0L, j2);
        AppMethodBeat.o(139927);
        return max;
    }
}
