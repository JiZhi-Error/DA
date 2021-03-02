package com.tencent.mm.plugin.appbrand.debugger;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.a;
import com.tencent.mm.protocal.protobuf.euy;
import com.tencent.mm.protocal.protobuf.evg;
import com.tencent.mm.protocal.protobuf.evn;
import com.tencent.mm.protocal.protobuf.evs;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class m {
    d lhP;
    final euy lhQ = new euy();
    private String lhR;
    private int lhS = 0;
    private int lhT = 0;
    evs lhU;
    n lhV;
    AtomicInteger lhW = new AtomicInteger(0);
    long lhX = 0;
    long lhY = 0;
    long lhZ;
    long lia = System.currentTimeMillis();
    AtomicInteger lib = new AtomicInteger(0);
    private boolean lic;
    private boolean lid;
    private final HashMap<String, Method> lie = new HashMap<>();
    private final HashMap<String, evn> lif = new HashMap<>();
    LinkedList<Pair<String, ValueCallback<String>>> lig = new LinkedList<>();
    final LinkedList<p> lih = new LinkedList<>();
    final Map<String, l> lii = new HashMap();
    final LinkedList<evg> lij = new LinkedList<>();
    final HashMap<Integer, c> lik = new HashMap<>();
    int lil = 0;
    long lim = 0;
    final Object mLock = new Object();
    private int mStatus = 0;

    public m() {
        AppMethodBeat.i(147009);
        this.lhQ.KFC = BuildInfo.CLIENT_VERSION_INT;
        AppMethodBeat.o(147009);
    }

    public final void a(d dVar, String str) {
        boolean z = true;
        AppMethodBeat.i(147010);
        this.lhP = dVar;
        v.setUin(this.lhP.NP().ON().uin);
        this.lhV = v.XZ(str);
        AppBrandSysConfigLU OM = this.lhP.NP().OM();
        if (OM != null) {
            OM.cyF = this.lhV.cyF;
            OM.cyp = true;
            a aVar = (a) dVar.NP().av(a.class);
            if (aVar != null) {
                if (OM.cyF) {
                    z = false;
                }
                aVar.nhD = z;
            }
        }
        AppMethodBeat.o(147010);
    }

    public final synchronized String bAF() {
        return this.lhR;
    }

    public final synchronized void XS(String str) {
        this.lhR = str;
    }

    public final synchronized int bAG() {
        return this.lhS;
    }

    public final synchronized void wi(int i2) {
        this.lhS = i2;
    }

    public final synchronized int bAH() {
        return this.lhT;
    }

    public final synchronized void wj(int i2) {
        if (this.lhT < i2) {
            this.lhT = i2;
        }
    }

    public final synchronized void dS(int i2, int i3) {
        if (this.lhT >= i2 && this.lhT <= i3) {
            this.lhT = i3;
        }
    }

    public final synchronized void setStatus(int i2) {
        this.mStatus = i2;
    }

    private synchronized int getStatus() {
        return this.mStatus;
    }

    public final synchronized boolean isBusy() {
        return this.lic;
    }

    public final synchronized void gW(boolean z) {
        this.lic = z;
    }

    public final synchronized boolean isReady() {
        boolean z;
        AppMethodBeat.i(147011);
        if (getStatus() == 3) {
            z = true;
            AppMethodBeat.o(147011);
        } else {
            z = false;
            AppMethodBeat.o(147011);
        }
        return z;
    }

    public final synchronized boolean bAI() {
        return this.lid;
    }

    public final synchronized void gX(boolean z) {
        this.lid = z;
    }

    public final boolean isQuit() {
        AppMethodBeat.i(147012);
        if (getStatus() == 4) {
            AppMethodBeat.o(147012);
            return true;
        }
        AppMethodBeat.o(147012);
        return false;
    }

    public final boolean bAJ() {
        AppMethodBeat.i(147013);
        if (getStatus() == 5) {
            AppMethodBeat.o(147013);
            return true;
        }
        AppMethodBeat.o(147013);
        return false;
    }

    public final void wk(int i2) {
        this.lim += (long) i2;
    }

    public final boolean bAK() {
        return this.lhV.liq == 3;
    }
}
