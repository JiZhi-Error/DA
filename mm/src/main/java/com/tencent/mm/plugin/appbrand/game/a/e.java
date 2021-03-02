package com.tencent.mm.plugin.appbrand.game.a;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.aa;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0014J\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\r\u0010\u001d\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\u001eJ\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0019\u0010\"\u001a\u0004\u0018\u00010\u00022\b\u0010#\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0002\u0010$R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00028BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\u00028BX\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR\u001b\u0010\u000e\u001a\u00020\u00028BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\bR\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/game/config/WAGameConfigGCFactor;", "Lcom/tencent/mm/plugin/appbrand/game/config/WAGameDynamicConfig;", "", "()V", "TAG", "", "clicfg_magicbrush_autogcfactor_max_canvas", "getClicfg_magicbrush_autogcfactor_max_canvas", "()F", "clicfg_magicbrush_autogcfactor_max_canvas$delegate", "Lkotlin/Lazy;", "clicfg_magicbrush_autogcfactor_min_canvas", "getClicfg_magicbrush_autogcfactor_min_canvas", "clicfg_magicbrush_autogcfactor_min_canvas$delegate", "clicfg_magicbrush_autogcfactor_total_memory_ratio", "getClicfg_magicbrush_autogcfactor_total_memory_ratio", "clicfg_magicbrush_autogcfactor_total_memory_ratio$delegate", "configMemory", "Ljava/lang/Float;", "memoryInfo", "Landroid/app/ActivityManager$MemoryInfo;", "enableABTest", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "enableKv", "getActuallyGcFactor", "context", "Landroid/content/Context;", "getAvailableMemory", "", "getConfig", "()Ljava/lang/Float;", "getConfigDefaultValue", "getGcFactorAutomatic", "getMemoryUnit", "onProcessConfig", "input", "(Ljava/lang/String;)Ljava/lang/Float;", "plugin-appbrand-integration_release"})
public final class e extends v<Float> {
    private static final String TAG;
    private static Float lrt;
    private static final f lru = g.ah(b.lrA);
    private static final f lrv = g.ah(a.lrz);
    private static final f lrw = g.ah(c.lrB);
    private static ActivityManager.MemoryInfo lrx;
    public static final e lry = new e();

    static {
        AppMethodBeat.i(50366);
        StringBuilder sb = new StringBuilder("MicroMsg.WAGameGcFactor");
        String processName = MMApplicationContext.getProcessName();
        p.g(processName, "MMApplicationContext.getProcessName()");
        String packageName = MMApplicationContext.getPackageName();
        p.g(packageName, "MMApplicationContext.getPackageName()");
        TAG = sb.append(n.j(processName, packageName, "", false)).toString();
        AppMethodBeat.o(50366);
    }

    private e() {
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.game.a.v
    public final b.a bCZ() {
        return b.a.clicfg_magicbrush_gcfactor;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.game.a.v
    public final String bCY() {
        return "gcfactor";
    }

    public final float dJ(Context context) {
        AppMethodBeat.i(50370);
        p.h(context, "context");
        if (lrt != null) {
            Float f2 = lrt;
            if (f2 == null) {
                p.hyc();
            }
            float floatValue = f2.floatValue();
            AppMethodBeat.o(50370);
            return floatValue;
        }
        float floatValue2 = ((Number) super.aLT()).floatValue();
        if (floatValue2 != -1.0f) {
            Log.i(TAG, "rawConfig == [" + floatValue2 + "] != -1, just return");
            lrt = Float.valueOf(floatValue2);
            AppMethodBeat.o(50370);
            return floatValue2;
        }
        Resources resources = context.getResources();
        p.g(resources, "context.resources");
        float f3 = resources.getDisplayMetrics().density;
        Resources resources2 = context.getResources();
        p.g(resources2, "context.resources");
        float f4 = ((float) resources2.getDisplayMetrics().widthPixels) / f3;
        Resources resources3 = context.getResources();
        p.g(resources3, "context.resources");
        float f5 = 2.0f * (((float) resources3.getDisplayMetrics().heightPixels) / f3) * f4 * 4.0f;
        boolean z = f5 > 0.0f;
        if (!aa.SXc || z) {
            if (lrx == null) {
                Object systemService = context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
                if (systemService == null) {
                    t tVar = new t("null cannot be cast to non-null type android.app.ActivityManager");
                    AppMethodBeat.o(50370);
                    throw tVar;
                }
                lrx = new ActivityManager.MemoryInfo();
                ((ActivityManager) systemService).getMemoryInfo(lrx);
                String str = TAG;
                StringBuilder sb = new StringBuilder("getAvailableMemory avail = [");
                ActivityManager.MemoryInfo memoryInfo = lrx;
                if (memoryInfo == null) {
                    p.hyc();
                }
                StringBuilder append = sb.append(memoryInfo.availMem).append("] total = [");
                ActivityManager.MemoryInfo memoryInfo2 = lrx;
                if (memoryInfo2 == null) {
                    p.hyc();
                }
                Log.i(str, append.append(memoryInfo2.totalMem).append(']').toString());
            }
            ActivityManager.MemoryInfo memoryInfo3 = lrx;
            if (memoryInfo3 == null) {
                p.hyc();
            }
            long floatValue3 = (long) (((Number) lrw.getValue()).floatValue() * ((float) memoryInfo3.totalMem));
            float min = Math.min(((Number) lrv.getValue()).floatValue(), Math.max(((Number) lru.getValue()).floatValue(), ((float) floatValue3) / f5));
            float f6 = 6.7108864E7f / (min * f5);
            Log.i(TAG, "calculate gc_factor automatically unit = [" + (f5 / 1024.0f) + "]kb limit = [65536]kb system = [" + (floatValue3 / 1024) + "]kb raw = [" + min + ':' + (((float) floatValue3) / f5) + "] actually = [" + f6 + ']');
            Float valueOf = Float.valueOf(f6);
            lrt = valueOf;
            if (valueOf == null) {
                p.hyc();
            }
            float floatValue4 = valueOf.floatValue();
            AppMethodBeat.o(50370);
            return floatValue4;
        }
        AssertionError assertionError = new AssertionError("Assertion failed");
        AppMethodBeat.o(50370);
        throw assertionError;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.plugin.appbrand.game.a.v
    public final /* synthetic */ Float bDb() {
        AppMethodBeat.i(50367);
        Float valueOf = Float.valueOf(0.0f);
        AppMethodBeat.o(50367);
        return valueOf;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<Float> {
        public static final b lrA = new b();

        static {
            AppMethodBeat.i(50363);
            AppMethodBeat.o(50363);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Float invoke() {
            AppMethodBeat.i(50362);
            float a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_magicbrush_autogcfactor_min_canvas, 100.0f);
            e eVar = e.lry;
            Log.i(e.TAG, "clicfg_magicbrush_autogcfactor_min_canvas ".concat(String.valueOf(a2)));
            Float valueOf = Float.valueOf(a2);
            AppMethodBeat.o(50362);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<Float> {
        public static final a lrz = new a();

        static {
            AppMethodBeat.i(50361);
            AppMethodBeat.o(50361);
        }

        a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Float invoke() {
            AppMethodBeat.i(50360);
            float a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_magicbrush_autogcfactor_max_canvas, 600.0f);
            e eVar = e.lry;
            Log.i(e.TAG, "clicfg_magicbrush_autogcfactor_max_canvas ".concat(String.valueOf(a2)));
            Float valueOf = Float.valueOf(a2);
            AppMethodBeat.o(50360);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<Float> {
        public static final c lrB = new c();

        static {
            AppMethodBeat.i(50365);
            AppMethodBeat.o(50365);
        }

        c() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Float invoke() {
            AppMethodBeat.i(50364);
            float a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_magicbrush_autogcfactor_total_memory_ratio, 0.33f);
            e eVar = e.lry;
            Log.i(e.TAG, "clicfg_magicbrush_autogcfactor_total_memory_ratio ".concat(String.valueOf(a2)));
            Float valueOf = Float.valueOf(a2);
            AppMethodBeat.o(50364);
            return valueOf;
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.plugin.appbrand.game.a.v
    public final /* synthetic */ Float YH(String str) {
        Float buy;
        AppMethodBeat.i(50368);
        if (str == null) {
            buy = null;
        } else {
            buy = n.buy(str);
        }
        if (buy != null) {
            float floatValue = buy.floatValue();
            if ((floatValue >= 0.0f || floatValue == -1.0f) && floatValue <= 1.0f) {
                Float valueOf = Float.valueOf(floatValue);
                AppMethodBeat.o(50368);
                return valueOf;
            }
            AppMethodBeat.o(50368);
            return null;
        }
        AppMethodBeat.o(50368);
        return null;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.plugin.appbrand.game.a.v
    public final /* synthetic */ Float aLT() {
        AppMethodBeat.i(50369);
        IllegalStateException illegalStateException = new IllegalStateException("Code should not reach.");
        AppMethodBeat.o(50369);
        throw illegalStateException;
    }
}
