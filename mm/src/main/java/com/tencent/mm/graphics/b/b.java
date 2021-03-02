package com.tencent.mm.graphics.b;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.List;

public class b implements a {
    static final /* synthetic */ boolean $assertionsDisabled = (!b.class.desiredAssertionStatus());
    private Context hjW;
    private List<Double> hjX = new ArrayList(100);
    private int hjY = 0;
    public double hjZ = 0.0d;
    public double hka = 0.0d;
    public double hkb = 2.147483647E9d;
    public double hkc = 0.0d;
    public double hkd = 0.0d;

    static {
        AppMethodBeat.i(136198);
        AppMethodBeat.o(136198);
    }

    public b(Context context) {
        AppMethodBeat.i(136194);
        this.hjW = context;
        this.hjZ = cJ(context);
        Log.v("MicroMsg.MemoryRecord", "hy: init mem to " + this.hjZ);
        AppMethodBeat.o(136194);
    }

    @Override // com.tencent.mm.graphics.b.a
    public final void axD() {
        AppMethodBeat.i(136195);
        this.hjY = this.hjX.size();
        if (this.hjY == 0) {
            Log.w("MicroMsg.MemoryRecord", "hy: check frames 0!");
            AppMethodBeat.o(136195);
            return;
        }
        Double valueOf = Double.valueOf(0.0d);
        Double d2 = valueOf;
        for (Double d3 : this.hjX) {
            d2 = Double.valueOf(d2.doubleValue() + d3.doubleValue());
            this.hka = Math.max(this.hka, d3.doubleValue());
            this.hkb = Math.min(this.hkb, d3.doubleValue());
        }
        Double valueOf2 = Double.valueOf(d2.doubleValue() / ((double) this.hjY));
        this.hkd = valueOf2.doubleValue() - this.hjZ;
        this.hka -= this.hjZ;
        this.hkb -= this.hjZ;
        long j2 = 0;
        for (Double d4 : this.hjX) {
            j2 = (long) (Math.pow(d4.doubleValue() - valueOf2.doubleValue(), 2.0d) + ((double) j2));
        }
        this.hkc = Math.sqrt((double) (j2 / ((long) this.hjY)));
        AppMethodBeat.o(136195);
    }

    @Override // com.tencent.mm.graphics.b.a
    public final void axE() {
        AppMethodBeat.i(136196);
        if (this.hjX == null) {
            AppMethodBeat.o(136196);
        } else if (this.hjX.size() > 10000) {
            AppMethodBeat.o(136196);
        } else {
            if (this.hjW != null) {
                double cJ = cJ(this.hjW);
                this.hjZ = Math.min(cJ, this.hjZ);
                if (this.hjZ == cJ) {
                    Log.v("MicroMsg.MemoryRecord", "hy: updating min mem to " + this.hjZ);
                }
                this.hjX.add(Double.valueOf(cJ));
            }
            AppMethodBeat.o(136196);
        }
    }

    private static double cJ(Context context) {
        AppMethodBeat.i(136197);
        ActivityManager activityManager = (ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if ($assertionsDisabled || activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
            double d2 = (((double) (memoryInfo.totalMem - memoryInfo.availMem)) / 1024.0d) / 1024.0d;
            AppMethodBeat.o(136197);
            return d2;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(136197);
        throw assertionError;
    }
}
