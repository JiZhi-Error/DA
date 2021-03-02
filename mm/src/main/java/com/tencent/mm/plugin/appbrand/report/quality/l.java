package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.luggage.game.c.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class l {
    static String nLb = "QualityKVReporter_19941";
    boolean mStarted;
    volatile int nLc;
    b nLd;
    private long nLe;
    private final Map<Integer, c> nLf;

    /* synthetic */ l(byte b2) {
        this();
    }

    static /* synthetic */ void a(l lVar) {
        AppMethodBeat.i(227412);
        lVar.bVd();
        AppMethodBeat.o(227412);
    }

    public final int zi(int i2) {
        AppMethodBeat.i(227407);
        long nowMilliSecond = Util.nowMilliSecond();
        if (nowMilliSecond - this.nLe > 1000) {
            bVd();
            this.nLe = nowMilliSecond;
        }
        int i3 = zj(i2).nLj;
        AppMethodBeat.o(227407);
        return i3;
    }

    /* access modifiers changed from: package-private */
    public final c zj(int i2) {
        AppMethodBeat.i(227408);
        c cVar = this.nLf.get(Integer.valueOf(i2));
        if (cVar == null) {
            IllegalStateException illegalStateException = new IllegalStateException(String.format("StatisticsWrapper null, type:%d", Integer.valueOf(i2)));
            AppMethodBeat.o(227408);
            throw illegalStateException;
        }
        AppMethodBeat.o(227408);
        return cVar;
    }

    private void bVd() {
        AppMethodBeat.i(227409);
        h hVar = h.INST;
        h.a Md = h.Md();
        this.nLf.get(1).zk(Md.cvD);
        this.nLf.get(2).zk(Md.cvJ > 0 ? Md.cvJ : Md.cvF);
        this.nLf.get(3).zk(Md.cvE);
        this.nLf.get(4).zk(Md.cvG);
        this.nLf.get(5).zk(Md.cvK);
        this.nLf.get(6).zk(Md.cvL);
        AppMethodBeat.o(227409);
    }

    /* access modifiers changed from: package-private */
    public final class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(l lVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(227406);
            l.a(l.this);
            com.tencent.f.h.RTc.a(this, (long) l.this.nLc, l.nLb);
            AppMethodBeat.o(227406);
        }
    }

    public static final class c {
        int mCount;
        int mPeak = Integer.MIN_VALUE;
        private final int mType;
        int nLi;
        int nLj;

        public c(int i2) {
            this.mType = i2;
        }

        public final void zk(int i2) {
            this.mCount++;
            this.nLi += i2;
            this.mPeak = i2 > this.mPeak ? i2 : this.mPeak;
            this.nLj = i2;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        private static final l nLg = new l((byte) 0);

        static {
            AppMethodBeat.i(227405);
            AppMethodBeat.o(227405);
        }
    }

    public static l bVe() {
        AppMethodBeat.i(227410);
        l lVar = a.nLg;
        AppMethodBeat.o(227410);
        return lVar;
    }

    private l() {
        AppMethodBeat.i(227411);
        this.nLf = new HashMap();
        this.nLf.put(1, new c(1));
        this.nLf.put(2, new c(2));
        this.nLf.put(3, new c(3));
        this.nLf.put(4, new c(4));
        this.nLf.put(5, new c(5));
        this.nLf.put(6, new c(6));
        AppMethodBeat.o(227411);
    }
}
