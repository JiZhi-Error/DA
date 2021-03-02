package com.tencent.mm.plugin.transvoice.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvoiceaddr.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import kotlin.g.b.p;

public final class c {
    private static final c Gub = b.fAv();
    public static final a Guc = new a((byte) 0);
    public boolean GtJ;
    public int GtK;
    public int GtL;
    public long GtM;
    public int GtN;
    public int GtO;
    public long GtP;
    public long GtQ;
    public int GtR;
    public int GtS;
    public int GtT;
    public long GtU;
    public int GtV;
    public int GtW;
    public int GtX;
    public int GtY;
    public int GtZ;
    public int Gua;
    private int gmJ;
    private int networkType;
    public long ofl;

    private c() {
        this.GtR = g.jwp;
        this.GtS = g.jwp;
    }

    public /* synthetic */ c(byte b2) {
        this();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(102548);
        b bVar = b.Gue;
        AppMethodBeat.o(102548);
    }

    static final class b {
        private static final c Gud = new c((byte) 0);
        public static final b Gue = new b();

        static {
            AppMethodBeat.i(102545);
            AppMethodBeat.o(102545);
        }

        private b() {
        }

        public static c fAv() {
            return Gud;
        }
    }

    public final void setExitType(int i2) {
        AppMethodBeat.i(102546);
        if (this.GtJ) {
            this.GtJ = false;
            this.gmJ = i2;
            this.networkType = NetStatusUtil.getIOSNetType(MMApplicationContext.getContext());
            report();
            AppMethodBeat.o(102546);
            return;
        }
        reset();
        AppMethodBeat.o(102546);
    }

    private void report() {
        AppMethodBeat.i(102547);
        h hVar = h.INSTANCE;
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        Resources resources = context.getResources();
        p.g(resources, "MMApplicationContext.getContext().resources");
        Context context2 = MMApplicationContext.getContext();
        p.g(context2, "MMApplicationContext.getContext()");
        Resources resources2 = context2.getResources();
        p.g(resources2, "MMApplicationContext.getContext().resources");
        hVar.a(17164, Long.valueOf(this.ofl), Integer.valueOf(this.GtK), Integer.valueOf(this.GtL), Long.valueOf(this.GtM), Integer.valueOf(this.GtN), Integer.valueOf(this.GtO), Integer.valueOf(this.gmJ), Integer.valueOf(this.networkType), Long.valueOf(this.GtP), Long.valueOf(this.GtQ), Integer.valueOf(this.GtR), Integer.valueOf(this.GtS), Integer.valueOf(this.GtT), Long.valueOf(this.GtU), Integer.valueOf(this.GtV), Integer.valueOf(this.GtW), Integer.valueOf(this.GtX), Integer.valueOf(this.GtY), Integer.valueOf(this.GtZ), Integer.valueOf(this.Gua), Integer.valueOf(resources.getDisplayMetrics().widthPixels), Integer.valueOf(resources2.getDisplayMetrics().heightPixels));
        reset();
        AppMethodBeat.o(102547);
    }

    private void reset() {
        this.ofl = 0;
        this.GtK = 0;
        this.GtL = 0;
        this.GtM = 0;
        this.GtN = 0;
        this.GtO = 0;
        this.networkType = 0;
        this.GtP = 0;
        this.GtQ = 0;
        this.GtR = g.jwp;
        this.GtS = g.jwp;
        this.GtT = 0;
        this.GtU = 0;
        this.GtV = 0;
        this.GtW = 0;
        this.GtX = 0;
        this.GtY = 0;
        this.GtZ = 0;
        this.Gua = 0;
    }
}
