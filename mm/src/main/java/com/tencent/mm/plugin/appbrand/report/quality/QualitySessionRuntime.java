package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.mc;
import com.tencent.mm.plugin.appbrand.launching.AppStartupPerformanceReportBundle;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import java.util.concurrent.atomic.AtomicInteger;

public class QualitySessionRuntime extends QualitySession {
    public boolean cuy;
    public q kGW;
    public j nLA = j.CreateOnRuntimeInit;
    public long nLB = 0;
    public long nLC;
    public long nLD;
    public volatile mc nLE = new mc();
    public volatile boolean nLF = false;
    public volatile boolean nLG = false;
    public volatile boolean nLH = false;
    private Boolean nLI;
    public long nLn;
    public long nLo;
    public long nLp;
    public long nLq;
    public long nLr;
    public long nLs;
    public AppStartupPerformanceReportBundle nLt;
    public int nLu;
    public final b.a nLv = new b.a();
    public final f nLw = new f();
    public AtomicInteger nLx = new AtomicInteger(0);
    public final m nLy = new m();
    public j nLz = j.CreateOnRuntimeInit;

    public final long bVg() {
        int i2;
        int i3;
        int i4 = 1;
        AppMethodBeat.i(48231);
        if (this.kGW.OS()) {
            i2 = 2;
        } else {
            i2 = 1;
        }
        if (this.nLz == j.PreloadOnProcessCreated) {
            i3 = 1;
        } else if (this.nLz == j.PreloadBeforeRuntimeInit) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        if (this.cuy) {
            long j2 = (long) ((i2 * 100) + (i3 * 10) + 0);
            AppMethodBeat.o(48231);
            return j2;
        }
        if (this.nLA != j.PreloadOnProcessCreated) {
            if (this.nLA == j.PreloadBeforeRuntimeInit) {
                i4 = 2;
            } else {
                i4 = 0;
            }
        }
        long j3 = (long) ((i2 * 100) + (i3 * 10) + i4);
        AppMethodBeat.o(48231);
        return j3;
    }

    public final synchronized boolean bVh() {
        boolean booleanValue;
        AppMethodBeat.i(48232);
        if (this.nLI == null) {
            booleanValue = false;
            AppMethodBeat.o(48232);
        } else {
            booleanValue = this.nLI.booleanValue();
            AppMethodBeat.o(48232);
        }
        return booleanValue;
    }

    public final synchronized void bVi() {
        if (this.nLI == null) {
            this.nLI = Boolean.TRUE;
        }
    }

    public final long bVj() {
        AppMethodBeat.i(227413);
        switch (this.kGW.kAH.kQM.bwY()) {
            case kQH:
                AppMethodBeat.o(227413);
                return 0;
            case BACKGROUND:
                AppMethodBeat.o(227413);
                return 1;
            case SUSPEND:
            case DESTROYED:
                AppMethodBeat.o(227413);
                return 2;
            default:
                AppMethodBeat.o(227413);
                return 0;
        }
    }

    QualitySessionRuntime(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(48233);
        AppMethodBeat.o(48233);
    }
}
