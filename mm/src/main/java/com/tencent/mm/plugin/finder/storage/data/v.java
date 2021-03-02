package com.tencent.mm.plugin.finder.storage.data;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.protocal.protobuf.bbg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/data/PageRecovery;", "", "()V", "SENSITIVE_CRASH_DURATION", "", "SENSITIVE_DURATION", "TAG", "", "lastEnterTimeMs", "", "getLastEnterTimeMs", "()J", "setLastEnterTimeMs", "(J)V", "touchFile", "getTouchFile", "()Ljava/lang/String;", "touchFile$delegate", "Lkotlin/Lazy;", "enterActivity", "", "setup", "plugin-finder_release"})
public final class v {
    private static long vGE;
    private static final f vGF = g.ah(b.vGI);
    public static final v vGG = new v();

    public static String dyJ() {
        AppMethodBeat.i(252050);
        String str = (String) vGF.getValue();
        AppMethodBeat.o(252050);
        return str;
    }

    static {
        AppMethodBeat.i(252052);
        AppMethodBeat.o(252052);
    }

    private v() {
    }

    public static final /* synthetic */ String dyL() {
        AppMethodBeat.i(252053);
        String dyJ = dyJ();
        AppMethodBeat.o(252053);
        return dyJ;
    }

    public static long dyI() {
        return vGE;
    }

    public static void dyK() {
        AppMethodBeat.i(252051);
        vGE = SystemClock.uptimeMillis();
        AppMethodBeat.o(252051);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "ueh", "Lcom/tencent/mm/sdk/platformtools/MMUncaughtExceptionHandler;", "kotlin.jvm.PlatformType", "msg", "", "ex", "", "uncaughtException"})
    public static final class a implements MMUncaughtExceptionHandler.IOnUncaughtExceptionListener {
        final /* synthetic */ bbg vGH;

        public a(bbg bbg) {
            this.vGH = bbg;
        }

        @Override // com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IOnUncaughtExceptionListener
        public final void uncaughtException(MMUncaughtExceptionHandler mMUncaughtExceptionHandler, String str, Throwable th) {
            bbg bbg;
            Integer num;
            Long l = null;
            AppMethodBeat.i(252047);
            bbg bbg2 = this.vGH;
            if (bbg2 == null) {
                bbg bbg3 = new bbg();
                bbg3.crashCount = 0;
                bbg3.LKH = 0;
                bbg = bbg3;
            } else {
                bbg = bbg2;
            }
            StringBuilder append = new StringBuilder("get crash msg ").append(str).append(", isInFinder ").append(((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).isInFinder()).append(" lastEnterTimeMs:");
            v vVar = v.vGG;
            StringBuilder append2 = append.append(v.dyI()).append(" pass: ");
            long uptimeMillis = SystemClock.uptimeMillis();
            v vVar2 = v.vGG;
            StringBuilder append3 = append2.append(uptimeMillis - v.dyI()).append(" info: ");
            bbg bbg4 = this.vGH;
            StringBuilder append4 = append3.append(bbg4 != null ? Integer.valueOf(bbg4.crashCount) : null).append(' ');
            bbg bbg5 = this.vGH;
            Log.i("Finder.PageRecovery", append4.append(bbg5 != null ? Long.valueOf(bbg5.LKH) : null).toString());
            if (((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).isInFinder()) {
                long uptimeMillis2 = SystemClock.uptimeMillis();
                v vVar3 = v.vGG;
                if (uptimeMillis2 - v.dyI() <= 5000) {
                    if (System.currentTimeMillis() - bbg.LKH < 300000) {
                        bbg.crashCount++;
                    } else {
                        bbg.crashCount = 1;
                    }
                    bbg.LKH = System.currentTimeMillis();
                    v vVar4 = v.vGG;
                    s.boN(new o(v.dyL()).getParent());
                    v vVar5 = v.vGG;
                    s.C(v.dyL(), bbg.toByteArray());
                    StringBuilder sb = new StringBuilder("[setup] crash happen =");
                    v vVar6 = v.vGG;
                    StringBuilder append5 = sb.append(s.YS(v.dyL())).append(" touchFile=");
                    v vVar7 = v.vGG;
                    StringBuilder append6 = append5.append(v.dyL()).append(" info: ");
                    if (bbg != null) {
                        num = Integer.valueOf(bbg.crashCount);
                    } else {
                        num = null;
                    }
                    StringBuilder append7 = append6.append(num.intValue()).append(' ');
                    if (bbg != null) {
                        l = Long.valueOf(bbg.LKH);
                    }
                    Log.i("Finder.PageRecovery", append7.append(l.longValue()).toString());
                }
            }
            AppMethodBeat.o(252047);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<String> {
        public static final b vGI = new b();

        static {
            AppMethodBeat.i(252049);
            AppMethodBeat.o(252049);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(252048);
            StringBuilder sb = new StringBuilder();
            e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            String sb2 = sb.append(aAh.azM()).append("PageRecovery.tmp").toString();
            AppMethodBeat.o(252048);
            return sb2;
        }
    }
}
