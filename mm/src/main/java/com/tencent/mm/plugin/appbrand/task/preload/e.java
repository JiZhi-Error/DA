package com.tencent.mm.plugin.appbrand.task.preload;

import android.util.SparseLongArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.concurrent.TimeUnit;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002 !B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0007J*\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00150\u0014H\u0007J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u000eH\u0007J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0019\u001a\u00020\u000eH\u0002J\b\u0010\u001a\u001a\u00020\u000eH\u0002J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0010H\u0007J \u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u000eH\u0007J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter;", "", "()V", "FREQUENCY_LIMIT_INTERVAL_SECONDS", "", "KEY", "", "KEY_TEST_DISABLE", "MEMORY_PRESSURE_INTERVAL_MIN_DEFAULT_MINUTES", "SP", "TAG", "mLastPreloadTimestampMap", "Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PreloadTypeTimestampMap;", "forceDisablePreload", "", "getPreloadLevel", "", "type", "Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PRELOAD_TYPE;", "reasons", "Lkotlin/Function2;", "", "getPreloadReportIDKey", "isGame", "hitLimitByCounter", "hitLimitByMemoryPressure", "isOpenPreloadDowngrade", "onTrimMemory", "level", "reportPreloadLimited", "test_disablePreload", "disabled", "PRELOAD_TYPE", "PreloadTypeTimestampMap", "plugin-appbrand-integration_release"})
public final class e {
    private static final b nQV = new b();
    public static final e nQW = new e();

    static {
        AppMethodBeat.i(51089);
        AppMethodBeat.o(51089);
    }

    private e() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PRELOAD_TYPE;", "", "(Ljava/lang/String;I)V", "WASERVICE", "WAGAME", "WASERVICE_FAKE_NATIVE", "NIL", "Companion", "plugin-appbrand-integration_release"})
    public enum a {
        WASERVICE,
        WAGAME,
        WASERVICE_FAKE_NATIVE,
        NIL;
        
        public static final C0800a nRc = new C0800a((byte) 0);

        static {
            AppMethodBeat.i(51077);
            AppMethodBeat.o(51077);
        }

        public static final a A(g gVar) {
            AppMethodBeat.i(51080);
            a A = C0800a.A(gVar);
            AppMethodBeat.o(51080);
            return A;
        }

        public static a valueOf(String str) {
            AppMethodBeat.i(51079);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(51079);
            return aVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PRELOAD_TYPE$Companion;", "", "()V", "valueOf", "Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PRELOAD_TYPE;", "type", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandServiceType;", "plugin-appbrand-integration_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.task.preload.e$a$a  reason: collision with other inner class name */
        public static final class C0800a {
            private C0800a() {
            }

            public /* synthetic */ C0800a(byte b2) {
                this();
            }

            public static a A(g gVar) {
                AppMethodBeat.i(229449);
                p.h(gVar, "type");
                switch (f.$EnumSwitchMapping$0[gVar.ordinal()]) {
                    case 1:
                        a aVar = a.WASERVICE;
                        AppMethodBeat.o(229449);
                        return aVar;
                    case 2:
                        a aVar2 = a.WAGAME;
                        AppMethodBeat.o(229449);
                        return aVar2;
                    default:
                        a aVar3 = a.NIL;
                        AppMethodBeat.o(229449);
                        return aVar3;
                }
            }
        }
    }

    public static final int iF(boolean z) {
        return z ? 1539 : 1144;
    }

    public static final void iG(boolean z) {
        AppMethodBeat.i(51084);
        MultiProcessMMKV.getMMKV("__appbrand__preload__interval__limiter__").putBoolean("__key_test_disable__", z).commit();
        AppMethodBeat.o(51084);
    }

    public static final int a(a aVar, m<? super Boolean, ? super Boolean, x> mVar) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        AppMethodBeat.i(229451);
        p.h(aVar, "type");
        p.h(mVar, "reasons");
        boolean a2 = a(aVar);
        long nowMilliSecond = Util.nowMilliSecond();
        long j2 = MultiProcessMMKV.getMMKV("__appbrand__preload__interval__limiter__").getLong("hold_until_ms", nowMilliSecond);
        if (j2 - nowMilliSecond >= TimeUnit.DAYS.toMillis(1)) {
            Log.w("MicroMsg.AppBrand.PreloadIntervalLimiter", "hitLimit, interval >= 1day, clear sp");
            MultiProcessMMKV.getMMKV("__appbrand__preload__interval__limiter__").edit().putLong("hold_until_ms", nowMilliSecond).apply();
        } else if (j2 > nowMilliSecond) {
            z = true;
            if (!BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED) {
                z2 = true;
            } else {
                z2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_pre_load_level, 0) == 1;
            }
            Boolean valueOf = Boolean.valueOf(a2);
            if (z && !z2) {
                z3 = true;
            }
            mVar.invoke(valueOf, Boolean.valueOf(z3));
            if (a2 && !z) {
                nQV.c(aVar);
                AppMethodBeat.o(229451);
                return 2;
            } else if (z || !z2) {
                AppMethodBeat.o(229451);
                return -1;
            } else {
                AppMethodBeat.o(229451);
                return 1;
            }
        }
        z = false;
        if (!BuildInfo.DEBUG) {
        }
        z2 = true;
        Boolean valueOf2 = Boolean.valueOf(a2);
        z3 = true;
        mVar.invoke(valueOf2, Boolean.valueOf(z3));
        if (a2) {
        }
        if (z) {
        }
        AppMethodBeat.o(229451);
        return -1;
    }

    public static final void a(a aVar, boolean z, boolean z2) {
        AppMethodBeat.i(229452);
        p.h(aVar, "type");
        switch (g.$EnumSwitchMapping$0[aVar.ordinal()]) {
            case 1:
                if (z) {
                    h.INSTANCE.dN(915, 36);
                    AppMethodBeat.o(229452);
                    return;
                }
                if (z2) {
                    h.INSTANCE.dN(915, 23);
                }
                AppMethodBeat.o(229452);
                return;
            case 2:
                if (!z) {
                    if (z2) {
                        h.INSTANCE.dN(915, 22);
                        break;
                    }
                } else {
                    h.INSTANCE.dN(915, 35);
                    AppMethodBeat.o(229452);
                    return;
                }
                break;
        }
        AppMethodBeat.o(229452);
    }

    public static final boolean bWG() {
        AppMethodBeat.i(51086);
        boolean z = MultiProcessMMKV.getMMKV("__appbrand__preload__interval__limiter__").getBoolean("__key_test_disable__", false);
        AppMethodBeat.o(51086);
        return z;
    }

    private static boolean a(a aVar) {
        long j2;
        AppMethodBeat.i(51087);
        if (a.NIL == aVar) {
            AppMethodBeat.o(51087);
            return false;
        }
        try {
            j2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_process_preload_frequence_limit, 30L);
        } catch (NullPointerException e2) {
            j2 = 30;
        }
        if (Util.ticksToNow(nQV.b(aVar)) <= TimeUnit.SECONDS.toMillis(j2)) {
            AppMethodBeat.o(51087);
            return true;
        }
        AppMethodBeat.o(51087);
        return false;
    }

    public static final void onTrimMemory(int i2) {
        AppMethodBeat.i(51088);
        Log.i("MicroMsg.AppBrand.PreloadIntervalLimiter", "onTrimMemory level=" + i2 + ", process=" + MMApplicationContext.getProcessName());
        h.INSTANCE.F(915, 21);
        switch (i2) {
            case 5:
                h.INSTANCE.F(915, 24);
                break;
            case 10:
                h.INSTANCE.F(915, 25);
                break;
            case 15:
                h.INSTANCE.F(915, 26);
                break;
            case 40:
                h.INSTANCE.F(915, 27);
                break;
            case 60:
                h.INSTANCE.F(915, 28);
                break;
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                h.INSTANCE.F(915, 29);
                break;
        }
        MultiProcessMMKV.getMMKV("__appbrand__preload__interval__limiter__").edit().putLong("hold_until_ms", TimeUnit.MINUTES.toMillis(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_process_preload_memory_stress_time_limit, 10L)) + Util.nowMilliSecond()).apply();
        AppMethodBeat.o(51088);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PreloadTypeTimestampMap;", "Landroid/util/SparseLongArray;", "()V", "get", "", "type", "Lcom/tencent/mm/plugin/appbrand/task/preload/PreloadIntervalLimiter$PRELOAD_TYPE;", "update", "", "plugin-appbrand-integration_release"})
    public static final class b extends SparseLongArray {
        public b() {
            super(a.values().length);
            AppMethodBeat.i(51083);
            AppMethodBeat.o(51083);
        }

        public final long b(a aVar) {
            AppMethodBeat.i(51081);
            p.h(aVar, "type");
            if (a.NIL == aVar) {
                AppMethodBeat.o(51081);
                return 0;
            }
            long j2 = super.get(aVar.ordinal(), 0);
            AppMethodBeat.o(51081);
            return j2;
        }

        public final void c(a aVar) {
            AppMethodBeat.i(51082);
            p.h(aVar, "type");
            super.put(aVar.ordinal(), Util.currentTicks());
            AppMethodBeat.o(51082);
        }
    }
}
