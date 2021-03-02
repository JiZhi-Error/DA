package com.tencent.mm.recoveryv2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.recoveryv2.a;
import com.tencent.mm.recoveryv2.b;
import com.tencent.mm.recoveryv2.g;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public interface j {
    j a(int i2, d dVar);

    j a(b bVar);

    void begin();

    void finish();

    public static abstract class a implements j {
        protected h NBu;
        protected final AtomicReference<b> NCb;
        protected final SparseArray<List<d>> NCc;
        protected a NCd;
        protected long NCe;
        protected RecoveryCrash NCf;
        protected RecoveryCrash NCg;
        protected final Context mContext;
        protected final String mVersionName;
        protected final Handler sCt;

        public a(Context context) {
            this(context, (byte) 0);
        }

        private a(Context context, byte b2) {
            this.mContext = context;
            this.sCt = new Handler(Looper.getMainLooper());
            this.mVersionName = l.iV(this.mContext);
            this.NBu = null;
            this.NCb = new AtomicReference<>(new b.c().a(null));
            this.NCc = new SparseArray<>(2);
            this.NCc.put(1, new ArrayList());
            this.NCc.put(2, new ArrayList());
            this.NCg = RecoveryCrash.iJ(this.mContext);
        }

        public a(a aVar) {
            this.NCd = aVar;
            this.mContext = aVar.mContext;
            this.sCt = aVar.sCt;
            this.mVersionName = aVar.mVersionName;
            this.NCg = aVar.NCg;
            this.NBu = aVar.NBu;
            this.NCb = aVar.NCb;
            this.NCc = aVar.NCc;
        }

        @Override // com.tencent.mm.recoveryv2.j
        public void begin() {
            this.NCe = System.currentTimeMillis();
        }

        /* access modifiers changed from: protected */
        public final void guB() {
            if (this.NBu == null) {
                this.NBu = h.iM(this.mContext);
                this.NCb.get().a(this.NBu);
            }
            if (this.NCg == null) {
                this.NCg = RecoveryCrash.iJ(this.mContext);
            }
            this.NCg.guB();
            if (this.NCf == null) {
                RecoveryCrash recoveryCrash = this.NCg;
                Context context = recoveryCrash.mContext;
                long j2 = recoveryCrash.NBx;
                String str = recoveryCrash.NBy;
                g gVar = recoveryCrash.NBz;
                c cVar = recoveryCrash.NBA;
                this.NCf = new RecoveryCrash(context, j2, str, gVar, new c(cVar.NBC, cVar.NBz));
            }
        }

        /* access modifiers changed from: protected */
        public boolean guP() {
            a.C2043a.log(4, "MicroMsg.recovery.trigger", "onLaunchRecovery");
            try {
                this.NCb.get().a(this.mContext, this.NCf);
                return true;
            } catch (Throwable th) {
                a.w("MicroMsg.recovery.trigger", "on launch recovery action error, mission aborted", th);
                return false;
            }
        }

        /* access modifiers changed from: protected */
        public final void ajs(int i2) {
            a.C2043a.log(4, "MicroMsg.recovery.trigger", "recovery event, level = ".concat(String.valueOf(i2)));
            for (d dVar : this.NCc.get(i2)) {
                try {
                    dVar.ajq(i2);
                } catch (Throwable th) {
                    a.w("MicroMsg.recovery.trigger", "recovery event error", th);
                }
            }
        }

        /* access modifiers changed from: protected */
        public final void onTerminate() {
            a.C2043a.log(4, "MicroMsg.recovery.trigger", "#onTerminate");
            try {
                this.NCb.get().b(this.mContext, this.NCf);
            } catch (Throwable th) {
            }
        }

        /* access modifiers changed from: protected */
        public final void guQ() {
            RecoveryCrash recoveryCrash = this.NCf;
            recoveryCrash.NBA.NBC++;
            recoveryCrash.NBy = this.mVersionName;
            recoveryCrash.NBx = this.NCe;
        }

        /* access modifiers changed from: protected */
        public final void guR() {
            this.NCf.guC();
        }

        /* access modifiers changed from: protected */
        public final void Au(boolean z) {
            if (z) {
                this.NCf.save();
                return;
            }
            RecoveryCrash recoveryCrash = this.NCf;
            c cVar = recoveryCrash.NBA;
            cVar.NBz.gL("crash_count", cVar.NBC).guG();
            recoveryCrash.NBz.mK("crash_version", recoveryCrash.NBy).bT("crash_time", recoveryCrash.NBx).guG();
        }

        @Override // com.tencent.mm.recoveryv2.j
        public final /* synthetic */ j a(int i2, d dVar) {
            List<d> list = this.NCc.get(i2);
            if (list != null) {
                list.add(dVar);
            }
            return this;
        }

        @Override // com.tencent.mm.recoveryv2.j
        public final /* synthetic */ j a(b bVar) {
            this.NCb.set(bVar.a(this.NBu));
            return this;
        }
    }

    public static class d extends a {
        protected final AtomicBoolean NCm = new AtomicBoolean();
        protected final AtomicBoolean NCn = new AtomicBoolean();

        public d(a aVar) {
            super(aVar);
            AppMethodBeat.i(193848);
            AppMethodBeat.o(193848);
        }

        @Override // com.tencent.mm.recoveryv2.j, com.tencent.mm.recoveryv2.j.a
        public void begin() {
            AppMethodBeat.i(193849);
            super.begin();
            guB();
            long j2 = this.NCe - this.NCg.NBx;
            a.C2043a.log(4, "MicroMsg.recovery.safePoint", "recovery interval = ".concat(String.valueOf(j2)));
            long j3 = this.NBu.NBO;
            if (j3 <= 0 || j2 >= j3) {
                this.NCm.set(true);
                if (!TextUtils.isEmpty(this.NCg.NBy) && !this.NCg.NBy.equals(this.mVersionName)) {
                    a.C2043a.log(4, "MicroMsg.recovery.safePoint", "version code mismatch, skip");
                    guR();
                }
                if (j2 >= this.NBu.NBM) {
                    a.C2043a.log(4, "MicroMsg.recovery.safePoint", "over interval, skip");
                    guR();
                }
                int i2 = this.NCf.NBA.NBC;
                a.C2043a.log(4, "MicroMsg.recovery.safePoint", "recovery crashCount = ".concat(String.valueOf(i2)));
                if (i2 < this.NBu.NBK) {
                    guT();
                    guQ();
                    Au(false);
                    guU();
                    AppMethodBeat.o(193849);
                } else if (!guP()) {
                    a.C2043a.log(5, "MicroMsg.recovery.safePoint", "launch recovery fail");
                    Au(true);
                    AppMethodBeat.o(193849);
                } else {
                    if (i2 < this.NBu.NBL) {
                        ajs(1);
                        guQ();
                    } else {
                        ajs(2);
                        guR();
                    }
                    Au(true);
                    onTerminate();
                    AppMethodBeat.o(193849);
                }
            } else {
                a.C2043a.log(4, "MicroMsg.recovery.safePoint", "too fast, skip and do nothing, min = ".concat(String.valueOf(j3)));
                AppMethodBeat.o(193849);
            }
        }

        @Override // com.tencent.mm.recoveryv2.j
        public void finish() {
            AppMethodBeat.i(193850);
            a.C2043a.log(4, "MicroMsg.recovery.safePoint", "#finish");
            if (this.NCm.get()) {
                a.C2043a.log(4, "MicroMsg.recovery.safePoint", "clear crash point");
                guB();
                guR();
                Au(true);
            }
            AppMethodBeat.o(193850);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.recoveryv2.j.a
        public final boolean guP() {
            AppMethodBeat.i(193851);
            boolean guP = super.guP();
            if (guP) {
                i iQ = i.iQ(this.mContext);
                iQ.NBY = false;
                iQ.NBC = this.NCf.NBA.NBC;
                iQ.NBU = true;
                iQ.mFrom = 1;
                iQ.guO();
            }
            AppMethodBeat.o(193851);
            return guP;
        }

        /* access modifiers changed from: protected */
        public final void guT() {
            AppMethodBeat.i(193852);
            a.C2043a.log(4, "MicroMsg.recovery.safePoint", "onLaunchNormal");
            if (this.NCf != null && this.NCf.NBA.NBC > 0) {
                i iQ = i.iQ(this.mContext);
                iQ.NBY = false;
                iQ.NBC = this.NCf.NBA.NBC;
                iQ.NBU = false;
                iQ.mFrom = 1;
                iQ.guO();
            }
            AppMethodBeat.o(193852);
        }

        /* access modifiers changed from: protected */
        public final void guU() {
            AppMethodBeat.i(193853);
            this.sCt.postDelayed(new Runnable() {
                /* class com.tencent.mm.recoveryv2.j.d.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(193847);
                    if (d.this.NCn.get()) {
                        a.C2043a.log(4, "MicroMsg.recovery.safePoint", "auto clear task has been canceled, skip");
                        AppMethodBeat.o(193847);
                        return;
                    }
                    a.C2043a.log(4, "MicroMsg.recovery.safePoint", "auto clear point");
                    d.this.finish();
                    AppMethodBeat.o(193847);
                }
            }, this.NBu.NBP);
            AppMethodBeat.o(193853);
        }

        /* access modifiers changed from: protected */
        public final void guV() {
            AppMethodBeat.i(193854);
            this.NCn.set(true);
            AppMethodBeat.o(193854);
        }
    }

    public static class c extends d {
        public c(a aVar) {
            super(aVar);
        }

        @Override // com.tencent.mm.recoveryv2.j, com.tencent.mm.recoveryv2.j.a, com.tencent.mm.recoveryv2.j.d
        @SuppressLint({"MissingSuperCall"})
        public final void begin() {
            AppMethodBeat.i(193846);
            int i2 = this.NCg.NBA.NBC;
            if (i2 <= 0) {
                a.C2043a.log(4, "MicroMsg.recovery.safePointLazy", "no need check, crash count = ".concat(String.valueOf(i2)));
                this.NCm.set(true);
                guT();
                Executors.newCachedThreadPool().submit(new Callable<Void>() {
                    /* class com.tencent.mm.recoveryv2.j.c.AnonymousClass1 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // java.util.concurrent.Callable
                    public final /* synthetic */ Void call() {
                        AppMethodBeat.i(193845);
                        c.this.guB();
                        long j2 = c.this.NCe - c.this.NCg.NBx;
                        a.C2043a.log(4, "MicroMsg.recovery.safePointLazy", "recovery interval = ".concat(String.valueOf(j2)));
                        long j3 = c.this.NBu.NBO;
                        if (j3 <= 0 || j2 >= j3) {
                            c.this.guQ();
                            c.this.Au(true);
                            c.this.guU();
                            AppMethodBeat.o(193845);
                        } else {
                            a.C2043a.log(4, "MicroMsg.recovery.safePointLazy", "too fast, skip and do nothing, min = ".concat(String.valueOf(j3)));
                            c.this.NCm.set(false);
                            AppMethodBeat.o(193845);
                        }
                        return null;
                    }
                });
                AppMethodBeat.o(193846);
                return;
            }
            super.begin();
            new Future<Void>() {
                /* class com.tencent.mm.recoveryv2.j.c.AnonymousClass2 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // java.util.concurrent.Future
                public final /* bridge */ /* synthetic */ Void get() {
                    return null;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // java.util.concurrent.Future
                public final /* bridge */ /* synthetic */ Void get(long j2, TimeUnit timeUnit) {
                    return null;
                }

                public final boolean cancel(boolean z) {
                    return false;
                }

                public final boolean isCancelled() {
                    return false;
                }

                public final boolean isDone() {
                    return true;
                }
            };
            AppMethodBeat.o(193846);
        }
    }

    public static class e extends a {
        protected long NCa = 0;
        protected long NCh = 0;
        protected a NCp;
        protected int mFrom = 2;

        public e(Context context) {
            super(context);
        }

        public e(a aVar) {
            super(aVar);
        }

        public final e MB(long j2) {
            this.NCh = j2;
            return this;
        }

        public final e a(a aVar) {
            this.NCp = aVar;
            return this;
        }

        @Override // com.tencent.mm.recoveryv2.j, com.tencent.mm.recoveryv2.j.a
        @SuppressLint({"MissingSuperCall"})
        public final void begin() {
            AppMethodBeat.i(193859);
            aju(2);
            AppMethodBeat.o(193859);
        }

        public final void aju(int i2) {
            AppMethodBeat.i(193860);
            super.begin();
            guB();
            a.C2043a.log(4, "MicroMsg.recovery.signalHandler", "#begin");
            this.mFrom = i2;
            if (this.NCh > 0) {
                this.NCa = this.NCe - this.NCh;
            }
            long j2 = this.NCe - this.NCg.NBx;
            a.C2043a.log(4, "MicroMsg.recovery.signalHandler", "recovery interval = ".concat(String.valueOf(j2)));
            long j3 = this.NBu.NBO;
            if (j3 <= 0 || j2 >= j3) {
                if (this.NCd instanceof d) {
                    ((d) this.NCd).guV();
                }
                if (!TextUtils.isEmpty(this.NCg.NBy) && !this.NCg.NBy.equals(this.mVersionName)) {
                    a.C2043a.log(4, "MicroMsg.recovery.signalHandler", "version code mismatch, skip");
                    guR();
                }
                if (j2 < this.NBu.NBM) {
                    a.C2043a.log(4, "MicroMsg.recovery.signalHandler", "within interval, inc");
                    guQ();
                } else {
                    long j4 = this.NBu.NBN;
                    if (j2 >= j4 || this.NCp == null) {
                        a.C2043a.log(4, "MicroMsg.recovery.signalHandler", "over signal interval, clear point");
                        guR();
                        guQ();
                    } else {
                        a.C2043a.log(4, "MicroMsg.recovery.signalHandler", "within signal interval");
                        if (this.NCp.ajw(aD(j2, j4))) {
                            a.C2043a.log(4, "MicroMsg.recovery.signalHandler", "acc meet, inc");
                            guQ();
                        }
                        this.NCp.save();
                    }
                }
                int i3 = this.NCf.NBA.NBC;
                a.C2043a.log(4, "MicroMsg.recovery.signalHandler", "recovery crashCount = ".concat(String.valueOf(i3)));
                if (i3 < this.NBu.NBK) {
                    Au(true);
                    guT();
                    AppMethodBeat.o(193860);
                } else if (!guP()) {
                    a.C2043a.log(5, "MicroMsg.recovery.signalHandler", "launch recovery fail");
                    Au(true);
                    AppMethodBeat.o(193860);
                } else {
                    if (i3 < this.NBu.NBL) {
                        ajs(1);
                    } else {
                        ajs(2);
                        guR();
                    }
                    Au(true);
                    onTerminate();
                    AppMethodBeat.o(193860);
                }
            } else {
                a.C2043a.log(4, "MicroMsg.recovery.signalHandler", "too fast, skip and do nothing, min = ".concat(String.valueOf(j3)));
                AppMethodBeat.o(193860);
            }
        }

        private static int aD(long j2, long j3) {
            if (j2 >= j3) {
                return 0;
            }
            if (((float) j2) >= ((float) j3) * 0.75f) {
                return 25;
            }
            if (((float) j2) >= ((float) j3) * 0.5f) {
                return 50;
            }
            if (((float) j2) >= ((float) j3) * 0.25f) {
                return 75;
            }
            return 100;
        }

        @Override // com.tencent.mm.recoveryv2.j
        public final void finish() {
            AppMethodBeat.i(193861);
            a.C2043a.log(4, "MicroMsg.recovery.signalHandler", "#finish");
            AppMethodBeat.o(193861);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.recoveryv2.j.a
        public final boolean guP() {
            AppMethodBeat.i(193862);
            boolean guP = super.guP();
            if (guP) {
                i iQ = i.iQ(this.mContext);
                iQ.NBY = false;
                iQ.NBC = this.NCf.NBA.NBC;
                iQ.NBU = true;
                iQ.mFrom = this.mFrom;
                iQ.NCa = Math.max(this.NCa, 0L);
                iQ.save();
            }
            AppMethodBeat.o(193862);
            return guP;
        }

        private void guT() {
            AppMethodBeat.i(193863);
            a.C2043a.log(4, "MicroMsg.recovery.signalHandler", "onLaunchNormal");
            if (this.NCf.NBA.NBC > 0) {
                i iQ = i.iQ(this.mContext);
                iQ.NBY = false;
                iQ.NBC = this.NCf.NBA.NBC;
                iQ.NBU = false;
                iQ.mFrom = this.mFrom;
                iQ.NCa = Math.max(this.NCa, 0L);
                iQ.save();
            }
            AppMethodBeat.o(193863);
        }

        /* access modifiers changed from: package-private */
        public static class a {
            g NBQ;
            int NCq;
            final String mName;

            public static a cu(Context context, String str) {
                AppMethodBeat.i(193855);
                a iR = new a(str).iR(context);
                AppMethodBeat.o(193855);
                return iR;
            }

            private a(String str) {
                this.mName = str;
            }

            private a iR(Context context) {
                AppMethodBeat.i(193856);
                this.NBQ = new g.b(context, this.mName).guJ();
                this.NCq = this.NBQ.getInt("acc_total", 0);
                AppMethodBeat.o(193856);
                return this;
            }

            private a ajv(int i2) {
                this.NCq += i2;
                return this;
            }

            private boolean guW() {
                if (this.NCq < 100) {
                    return false;
                }
                this.NCq = 0;
                return true;
            }

            public final boolean ajw(int i2) {
                AppMethodBeat.i(193857);
                boolean guW = ajv(i2).guW();
                AppMethodBeat.o(193857);
                return guW;
            }

            public final void save() {
                AppMethodBeat.i(193858);
                this.NBQ.gL("acc_total", this.NCq).guF();
                AppMethodBeat.o(193858);
            }
        }
    }

    public static class b extends a {
        final long NCh = System.currentTimeMillis();
        d NCi;
        e NCj;

        static /* synthetic */ e a(b bVar) {
            AppMethodBeat.i(193844);
            e guS = bVar.guS();
            AppMethodBeat.o(193844);
            return guS;
        }

        public b(Context context) {
            super(context);
            AppMethodBeat.i(193839);
            AppMethodBeat.o(193839);
        }

        @Override // com.tencent.mm.recoveryv2.j, com.tencent.mm.recoveryv2.j.a
        public final void begin() {
            AppMethodBeat.i(193840);
            super.begin();
            synchronized (this) {
                try {
                    if (this.NCi == null && this.NCj == null) {
                        this.NCi = new c(this) {
                            /* class com.tencent.mm.recoveryv2.j.b.AnonymousClass1 */

                            @Override // com.tencent.mm.recoveryv2.j, com.tencent.mm.recoveryv2.j.d
                            public final void finish() {
                                AppMethodBeat.i(193838);
                                a.C2043a.log(4, "MicroMsg.recovery.combination", "safePoint finish, switch to signal handler");
                                if (b.this.NCj == null) {
                                    b.this.NCj = b.a(b.this);
                                }
                                super.finish();
                                AppMethodBeat.o(193838);
                            }
                        };
                        if (this.NCi != null) {
                            this.NCi.begin();
                        }
                        return;
                    }
                    if (this.NCj == null) {
                        this.NCj = guS();
                    }
                    if (this.NCj != null) {
                        this.NCj.begin();
                    }
                    AppMethodBeat.o(193840);
                } finally {
                    AppMethodBeat.o(193840);
                }
            }
        }

        public final void ajt(int i2) {
            AppMethodBeat.i(193841);
            synchronized (this) {
                try {
                    if (this.NCj == null) {
                        this.NCj = guS();
                    }
                    this.NCj.aju(i2);
                } finally {
                    AppMethodBeat.o(193841);
                }
            }
        }

        private e guS() {
            AppMethodBeat.i(193842);
            e a2 = new e(this.NCi == null ? this : this.NCi).MB(this.NCh).a(e.a.cu(this.mContext, "signal_acc"));
            AppMethodBeat.o(193842);
            return a2;
        }

        @Override // com.tencent.mm.recoveryv2.j
        public final void finish() {
            AppMethodBeat.i(193843);
            synchronized (this) {
                try {
                    if (this.NCi != null) {
                        this.NCi.finish();
                    }
                } finally {
                    AppMethodBeat.o(193843);
                }
            }
        }
    }
}
