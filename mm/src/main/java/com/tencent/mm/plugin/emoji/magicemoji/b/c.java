package com.tencent.mm.plugin.emoji.magicemoji.b;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.api.v;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.magicemoji.a.a;
import com.tencent.mm.plugin.emoji.magicemoji.b.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class c implements a {
    private volatile boolean KvT = false;
    private int LAB = 10000;
    private volatile boolean LOE = false;
    private final Runnable LOH = new Runnable() {
        /* class com.tencent.mm.plugin.emoji.magicemoji.b.c.AnonymousClass3 */

        public final void run() {
            AppMethodBeat.i(199719);
            c.this.KvT = false;
            Log.i("MicroMsg.MagicEmojiWatchDog", "magic emoji service exit when timeout");
            c.erN();
            c.FU(2);
            AppMethodBeat.o(199719);
        }
    };
    private final Runnable MuG = new Runnable() {
        /* class com.tencent.mm.plugin.emoji.magicemoji.b.c.AnonymousClass4 */

        public final void run() {
            AppMethodBeat.i(259512);
            c.this.LOE = false;
            Log.i("MicroMsg.MagicEmojiWatchDog", "magic emoji service paused");
            ((v) g.af(v.class)).agN();
            AppMethodBeat.o(259512);
        }
    };
    private final ComponentCallbacks2 cVL;
    private MMHandler mKp = new MMHandler(Looper.getMainLooper());
    private boolean qYK = true;
    private boolean qYL = false;
    private String qYM = "";
    private boolean qYN = false;
    private final b qYO = new b();
    private int qYP;
    private boolean qYR;
    private boolean qYS;
    private int qYT;
    private boolean qYU;
    private int qYV = 0;
    private int qYW;
    private int qYX;
    private long qYY = 0;
    private int qYZ;
    private boolean qZa = true;
    private int qZb = ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("ClientBenchmarkLevel", -1);
    private boolean qZc = false;
    private IListener<fp> qZd = new IListener<fp>() {
        /* class com.tencent.mm.plugin.emoji.magicemoji.b.c.AnonymousClass2 */

        {
            AppMethodBeat.i(199717);
            this.__eventId = fp.class.getName().hashCode();
            AppMethodBeat.o(199717);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(fp fpVar) {
            AppMethodBeat.i(199718);
            if (c.this.qYK) {
                c.h(c.this);
                if (!c.this.qYK) {
                    Log.i("MicroMsg.MagicEmojiWatchDog", "on expt change, exit service");
                    c.erN();
                    c.FU(1);
                }
            }
            AppMethodBeat.o(199718);
            return false;
        }
    };

    static /* synthetic */ void FU(int i2) {
        AppMethodBeat.i(199735);
        oA(i2);
        AppMethodBeat.o(199735);
    }

    static /* synthetic */ int a(c cVar) {
        int i2 = cVar.qYV;
        cVar.qYV = i2 + 1;
        return i2;
    }

    static /* synthetic */ void erN() {
        AppMethodBeat.i(258022);
        cFB();
        AppMethodBeat.o(258022);
    }

    static /* synthetic */ int f(c cVar) {
        int i2 = cVar.qYZ;
        cVar.qYZ = i2 + 1;
        return i2;
    }

    static /* synthetic */ void h(c cVar) {
        AppMethodBeat.i(199736);
        cVar.cFC();
        AppMethodBeat.o(199736);
    }

    public c() {
        b.a aVar;
        b.a aVar2;
        AppMethodBeat.i(199720);
        String a2 = ((b) g.af(b.class)).a(b.a.clicfg_magic_emoji_preload, "");
        if (!Util.isNullOrNil(a2)) {
            try {
                i iVar = new i(a2);
                if (iVar.FJ("preload").getInt(a(iVar)) == 0) {
                    this.qZa = false;
                }
            } catch (com.tencent.mm.ab.g e2) {
                Log.printErrStackTrace("MicroMsg.MagicEmojiWatchDog", e2, "invalid json %s", a2);
            }
        }
        int a3 = ((b) g.af(b.class)).a(b.a.clicfg_magic_emoji_max_crash_times_android, 5);
        Log.i("MicroMsg.MagicEmojiWatchDog", "check crash times: %d >= %d", Integer.valueOf(this.qYO.qYH), Integer.valueOf(a3));
        if (this.qYO.qYH >= a3) {
            this.qYL = true;
        }
        cFC();
        int a4 = ((b) g.af(b.class)).a(b.a.clicfg_magic_emoji_pause, -1);
        if (a4 >= 0) {
            this.LAB = a4;
        }
        Log.i("MicroMsg.MagicEmojiWatchDog", "can start service %b, can preload %b, pause check time %d", Boolean.valueOf(this.qYK), Boolean.valueOf(this.qZa), Integer.valueOf(this.LAB));
        b.a aVar3 = b.a.clicfg_magic_emoji_perf_android;
        if (!BuildInfo.IS_ARM64) {
            aVar = b.a.clicfg_magic_emoji_perf_android_32bit;
        } else {
            aVar = aVar3;
        }
        String a5 = ((b) g.af(b.class)).a(aVar, "");
        if (Util.isNullOrNil(a5)) {
            this.qYU = false;
        } else {
            try {
                i iVar2 = new i(a5);
                this.qYP = iVar2.getInt("ram");
                this.qYS = iVar2.getInt("exit") == 1;
                String a6 = a(iVar2);
                this.qYW = iVar2.FJ("reload").getInt(a6);
                this.qYX = iVar2.FJ("reloadtime").getInt(a6) * 60000;
                this.qYU = true;
            } catch (com.tencent.mm.ab.g e3) {
                Log.printErrStackTrace("MicroMsg.MagicEmojiWatchDog", e3, "invalid json %s", a5);
            }
        }
        Log.i("MicroMsg.MagicEmojiWatchDog", "perf config perfMonitorEnabled[%b], maxMemoryWarningTimes[%d],exitWhenLeaveChattingUI[%b], mBenchmarkLevel[%d], maxReloadTimes[%d], maxReloadPeriod[%d]", Boolean.valueOf(this.qYU), Integer.valueOf(this.qYP), Boolean.valueOf(this.qYS), Integer.valueOf(this.qZb), Integer.valueOf(this.qYW), Integer.valueOf(this.qYX));
        b.a aVar4 = b.a.clicfg_magic_emoji_android;
        if (!BuildInfo.IS_ARM64) {
            aVar2 = b.a.clicfg_magic_emoji_android_32bit;
        } else {
            aVar2 = aVar4;
        }
        String a7 = ((b) g.af(b.class)).a(aVar2, "");
        if (Util.isNullOrNil(a7)) {
            this.qYR = false;
        } else {
            try {
                i iVar3 = new i(a7);
                this.qYT = iVar3.FJ("destroy").getInt(a(iVar3));
                this.qYR = true;
            } catch (com.tencent.mm.ab.g e4) {
                Log.printErrStackTrace("MicroMsg.MagicEmojiWatchDog", e4, "invalid json %s", a7);
            }
        }
        Log.i("MicroMsg.MagicEmojiWatchDog", "hasConfigSettings[%b], destroyServiceTimeoutMS[%d]", Boolean.valueOf(this.qYR), Integer.valueOf(this.qYT));
        this.cVL = new ComponentCallbacks2() {
            /* class com.tencent.mm.plugin.emoji.magicemoji.b.c.AnonymousClass1 */

            public final void onConfigurationChanged(Configuration configuration) {
            }

            public final void onLowMemory() {
                AppMethodBeat.i(199715);
                c.a(c.this);
                if (c.this.qYV >= c.this.qYP) {
                    Log.i("MicroMsg.MagicEmojiWatchDog", "magic emoji service exit when low memory");
                    c.erN();
                    c.FU(0);
                    c.this.qYY = Util.currentTicks();
                    c.this.qYV = 0;
                    c.f(c.this);
                }
                AppMethodBeat.o(199715);
            }

            public final void onTrimMemory(int i2) {
                AppMethodBeat.i(199716);
                c.a(c.this);
                if (c.this.qYV >= c.this.qYP) {
                    Log.i("MicroMsg.MagicEmojiWatchDog", "magic emoji service exit onTrimMemory");
                    c.erN();
                    c.FU(0);
                    c.this.qYY = Util.currentTicks();
                    c.this.qYV = 0;
                    c.f(c.this);
                }
                AppMethodBeat.o(199716);
            }
        };
        AppMethodBeat.o(199720);
    }

    private static void oA(int i2) {
        AppMethodBeat.i(199721);
        h.INSTANCE.dN(1622, i2);
        AppMethodBeat.o(199721);
    }

    private static void cFB() {
        AppMethodBeat.i(199722);
        ((v) g.af(v.class)).cFB();
        AppMethodBeat.o(199722);
    }

    private String a(i iVar) {
        AppMethodBeat.i(199723);
        i FJ = iVar.FJ("benchmark");
        int i2 = FJ.getInt("low");
        int i3 = FJ.getInt("high");
        String str = "high";
        if (this.qZb >= 0) {
            if (this.qZb <= i2) {
                str = "low";
            } else if (this.qZb <= i3) {
                str = "mid";
            }
        }
        AppMethodBeat.o(199723);
        return str;
    }

    private void cFC() {
        AppMethodBeat.i(199724);
        String a2 = ((b) g.af(b.class)).a(b.a.clicfg_magic_emoji_close_android, "");
        if (!Util.isNullOrNil(a2) && !this.qYM.equals(a2)) {
            try {
                i iVar = new i(a2);
                if (iVar.FJ("close").getInt(a(iVar)) == 1) {
                    Log.i("MicroMsg.MagicEmojiWatchDog", "magic emoji service disabled by server");
                    this.qYK = false;
                } else {
                    Log.i("MicroMsg.MagicEmojiWatchDog", "magic emoji service enable by server");
                    this.qYK = true;
                }
                this.qYM = a2;
                AppMethodBeat.o(199724);
                return;
            } catch (com.tencent.mm.ab.g e2) {
                Log.printErrStackTrace("MicroMsg.MagicEmojiWatchDog", e2, "invalid json %s", a2);
            }
        }
        AppMethodBeat.o(199724);
    }

    @Override // com.tencent.mm.plugin.emoji.magicemoji.a.a
    public final boolean cFs() {
        return this.qZa;
    }

    @Override // com.tencent.mm.plugin.emoji.magicemoji.a.a
    public final a.EnumC0959a cFt() {
        AppMethodBeat.i(199725);
        cFC();
        if (!this.qYK) {
            a.EnumC0959a aVar = a.EnumC0959a.DisabledByServer;
            AppMethodBeat.o(199725);
            return aVar;
        } else if (this.qYL) {
            a.EnumC0959a aVar2 = a.EnumC0959a.CrashTooMuch;
            AppMethodBeat.o(199725);
            return aVar2;
        } else {
            if (this.qYU && this.qYY > 0 && this.qYZ >= this.qYW) {
                if (Util.ticksToNow(this.qYY) < ((long) this.qYX)) {
                    a.EnumC0959a aVar3 = a.EnumC0959a.MemoryWarningTooMuch;
                    AppMethodBeat.o(199725);
                    return aVar3;
                }
                this.qYZ = 0;
            }
            a.EnumC0959a aVar4 = a.EnumC0959a.Ok;
            AppMethodBeat.o(199725);
            return aVar4;
        }
    }

    @Override // com.tencent.mm.plugin.emoji.magicemoji.a.a
    public final void cFu() {
        AppMethodBeat.i(199727);
        b bVar = this.qYO;
        if (!bVar.qYG) {
            CrashReportFactory.addCrashReportListener(bVar.qYI);
            bVar.qYG = true;
        }
        AppMethodBeat.o(199727);
    }

    @Override // com.tencent.mm.plugin.emoji.magicemoji.a.a
    public final void dRk() {
        AppMethodBeat.i(258021);
        if (!this.qZc) {
            EventCenter.instance.addListener(this.qZd);
            this.qZc = true;
        }
        AppMethodBeat.o(258021);
    }

    @Override // com.tencent.mm.plugin.emoji.magicemoji.a.a
    public final void cFv() {
        AppMethodBeat.i(199729);
        b bVar = this.qYO;
        if (bVar.qYG) {
            CrashReportFactory.removeCrashReportListener(bVar.qYI);
            bVar.qYG = false;
        }
        if (this.qZc) {
            EventCenter.instance.removeListener(this.qZd);
            this.qZc = false;
        }
        AppMethodBeat.o(199729);
    }

    private void dil() {
        AppMethodBeat.i(259514);
        if (this.LAB > 0 && this.LOE) {
            this.mKp.removeCallbacks(this.MuG);
            this.LOE = false;
        }
        AppMethodBeat.o(259514);
    }

    private void diL() {
        AppMethodBeat.i(259515);
        if (this.LAB > 0) {
            dil();
            this.mKp.postDelayed(this.MuG, (long) this.LAB);
            this.LOE = true;
        }
        AppMethodBeat.o(259515);
    }

    @Override // com.tencent.mm.plugin.emoji.magicemoji.a.a
    public final void cFw() {
        AppMethodBeat.i(199730);
        if (this.qYR && this.qYT > 0) {
            if (this.KvT) {
                this.mKp.removeCallbacks(this.LOH);
            } else {
                this.KvT = true;
            }
            this.mKp.postDelayed(this.LOH, (long) this.qYT);
        }
        diL();
        if (this.qYO.qYH > 0) {
            com.tencent.f.h.RTc.o(new Runnable() {
                /* class com.tencent.mm.plugin.emoji.magicemoji.b.c.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(259513);
                    c.this.qYO.cFA();
                    AppMethodBeat.o(259513);
                }
            }, 10000);
        }
        AppMethodBeat.o(199730);
    }

    @Override // com.tencent.mm.plugin.emoji.magicemoji.a.a
    public final void dhT() {
        AppMethodBeat.i(259516);
        Log.i("MicroMsg.MagicEmojiWatchDog", "on service resume");
        diL();
        if (this.qYU && !this.qYN) {
            this.qYN = true;
            MMApplicationContext.getContext().registerComponentCallbacks(this.cVL);
        }
        AppMethodBeat.o(259516);
    }

    @Override // com.tencent.mm.plugin.emoji.magicemoji.a.a
    public final void dij() {
        AppMethodBeat.i(259517);
        Log.i("MicroMsg.MagicEmojiWatchDog", "on service pause");
        dil();
        if (this.qYU) {
            if (this.qYN) {
                this.qYN = false;
                MMApplicationContext.getContext().unregisterComponentCallbacks(this.cVL);
            }
            if (this.qYS) {
                Log.i("MicroMsg.MagicEmojiWatchDog", "magic emoji service exit when service pause");
                cFB();
                oA(3);
            }
        }
        AppMethodBeat.o(259517);
    }

    @Override // com.tencent.mm.plugin.emoji.magicemoji.a.a
    public final void cFz() {
        AppMethodBeat.i(199733);
        this.qYO.cFA();
        AppMethodBeat.o(199733);
    }
}
