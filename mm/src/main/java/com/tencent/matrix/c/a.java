package com.tencent.matrix.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.facebook.login.widget.ToolTipPopup;
import com.tencent.matrix.a.b.a.c;
import com.tencent.matrix.a.b.a.d;
import com.tencent.matrix.a.b.a.e;
import com.tencent.matrix.a.b.a.g;
import com.tencent.matrix.a.b.a.i;
import com.tencent.matrix.a.b.b;
import com.tencent.matrix.b.b;
import com.tencent.matrix.report.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.ab;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.sdk.platformtools.ApplicationGlobal;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a {
    private static long cUQ = 300000;
    private static long cUR = ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME;
    private static long cUS = 120000;
    private static long cUT = 2000;
    private static boolean cUU = false;
    private static long cUV = 2;
    private static int cUW = 100;
    private static int cUX = 200;
    private static long cUY;
    private static AtomicBoolean cUZ;
    private static b cVa;

    static /* synthetic */ long SH() {
        long j2 = cUY;
        cUY = 1 + j2;
        return j2;
    }

    public static com.tencent.matrix.a.b Sz() {
        int i2;
        ab.a(5, new y<com.tencent.mm.bw.a>() {
            /* class com.tencent.matrix.c.a.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.messenger.foundation.a.y
            public final void a(com.tencent.mm.bw.a aVar) {
                a.SH();
            }

            @Override // com.tencent.mm.plugin.messenger.foundation.a.y
            public final void b(com.tencent.mm.bw.a aVar) {
            }
        });
        ApplicationGlobal.context().registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            /* class com.tencent.matrix.c.a.AnonymousClass2 */

            private static void ey(String str) {
                com.tencent.matrix.a.b bVar;
                c cVar;
                if (com.tencent.matrix.b.isInstalled() && (bVar = (com.tencent.matrix.a.b) com.tencent.matrix.b.RG().Y(com.tencent.matrix.a.b.class)) != null && !bVar.isPluginStopped() && (cVar = (c) bVar.cQh.aa(c.class)) != null) {
                    cVar.eq(str);
                }
            }

            public final void onActivityCreated(Activity activity, Bundle bundle) {
            }

            public final void onActivityStarted(Activity activity) {
                String str = activity.getClass().getName() + "@" + activity.hashCode();
                Log.i("Matrix.battery.Lifecycle", "#onStarted: ".concat(String.valueOf(str)));
                ey(str);
            }

            public final void onActivityResumed(Activity activity) {
            }

            public final void onActivityPaused(Activity activity) {
            }

            public final void onActivityStopped(Activity activity) {
                Log.i("Matrix.battery.Lifecycle", "#onStopped: ".concat(String.valueOf(activity.getClass().getName() + "@" + activity.hashCode())));
            }

            public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public final void onActivityDestroyed(Activity activity) {
            }
        });
        cVa = new b();
        int i3 = 1;
        int i4 = 1;
        int i5 = 1;
        int i6 = 1;
        long j2 = 30000;
        long j3 = 1200000;
        long j4 = 1800000;
        long j5 = 120000;
        boolean z = false;
        boolean z2 = true;
        boolean z3 = true;
        com.tencent.mm.plugin.expt.b.b bVar = (com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class);
        if (bVar != null) {
            i3 = bVar.a(b.a.clicfg_battery_global_enable, 1);
            i4 = bVar.a(b.a.clicfg_battery_devstat_enable, 1);
            i5 = bVar.a(b.a.clicfg_battery_wakelock_enable, 1);
            int a2 = bVar.a(b.a.clicfg_battery_alarm_enable, 1);
            j2 = bVar.a(b.a.clicfg_battery_bg_delay_mils, 30000L);
            j3 = bVar.a(b.a.clicfg_battery_fg_loop_mils, 1200000L);
            j4 = bVar.a(b.a.clicfg_battery_bg_loop_mils, 1800000L);
            cUQ = bVar.a(b.a.clicfg_battery_min_stat_window, 300000L);
            cUR = bVar.a(b.a.clicfg_battery_jiffies_threshold, ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME);
            cUS = bVar.a(b.a.clicfg_battery_min_task_stat_window, 120000L);
            cUT = bVar.a(b.a.clicfg_battery_task_jiffies_threshold, 2000L);
            cUU = bVar.a(b.a.clicfg_battery_use_thread_clock, 0) == 1;
            j5 = bVar.a(b.a.clicfg_battery_wakelock_overtime, 120000L);
            cUV = (long) bVar.a(b.a.clicfg_battery_wakelock_overtime_count, 2);
            z = bVar.a(b.a.clicfg_battery_stat_pid_proc, 0) == 1;
            cUW = bVar.a(b.a.clicfg_battery_app_importance_limit, 100);
            cUX = bVar.a(b.a.clicfg_battery_app_list_over_heat, 200);
            z2 = bVar.a(b.a.clicfg_battery_fg_loop_enable, 1) == 1;
            z3 = bVar.a(b.a.clicfg_battery_bg_loop_enable, 0) == 1;
            i2 = bVar.a(b.a.clicfg_battery_threadpool_enable, 1);
            i6 = a2;
        } else {
            i2 = 1;
        }
        b.a aVar = new b.a();
        if (i3 == 1) {
            aVar.Z(e.class);
        }
        if (i4 == 1) {
            aVar.Z(c.class);
            aVar.Z(d.class);
        }
        if (i5 == 1) {
            aVar.Z(i.class);
        }
        if (i6 == 1) {
            aVar.Z(com.tencent.matrix.a.b.a.b.class);
        }
        if (i2 == 1) {
            aVar.Z(c.class);
        }
        aVar.cSa.cRU = false;
        aVar.cSa.cRJ = cVa;
        long max = Math.max(j5, (long) Util.MILLSECONDS_OF_MINUTE);
        if (max > 0) {
            aVar.cSa.cRL = max;
        }
        long max2 = Math.max(j2, 5000L);
        if (max2 > 0) {
            aVar.cSa.cRN = max2;
        }
        aVar.cSa.cRS = z2;
        long max3 = Math.max(j3, (long) Util.MILLSECONDS_OF_MINUTE);
        if (max3 > 0) {
            aVar.cSa.cRO = max3;
        }
        aVar.cSa.cRT = z3;
        long max4 = Math.max(j4, (long) Util.MILLSECONDS_OF_MINUTE);
        if (max4 > 0) {
            aVar.cSa.cRP = max4;
        }
        b.a ep = aVar.eo("MicroMsg.MMAutoAuth").eo("PlatformComm").ep("MicroMsg.JsApiSetKeepScreenOn").ep("QQBrowserVideo");
        ep.cSa.cRV = SA();
        ep.cSa.cRK = new Callable<String>() {
            /* class com.tencent.matrix.c.a.AnonymousClass3 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ String call() {
                return com.tencent.matrix.report.a.SO();
            }
        };
        int max5 = Math.max(cUX, 20);
        if (max5 >= 10) {
            ep.cSa.cRQ = max5;
        }
        ep.cSa.cRW = z;
        ep.cSa.cRR = cUW;
        Collections.sort(ep.cSa.cRZ, 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01f9: INVOKE  
              (wrap: java.util.List<com.tencent.matrix.a.b.a.g> : 0x01f2: IGET  (r3v6 java.util.List<com.tencent.matrix.a.b.a.g>) = 
              (wrap: com.tencent.matrix.a.b.b : 0x01f0: IGET  (r3v5 com.tencent.matrix.a.b.b) = (r4v10 'ep' com.tencent.matrix.a.b.b$a) com.tencent.matrix.a.b.b.a.cSa com.tencent.matrix.a.b.b)
             com.tencent.matrix.a.b.b.cRZ java.util.List)
              (wrap: com.tencent.matrix.a.b.b$a$1 : 0x01f6: CONSTRUCTOR  (r5v11 com.tencent.matrix.a.b.b$a$1) = (r4v10 'ep' com.tencent.matrix.a.b.b$a) call: com.tencent.matrix.a.b.b.a.1.<init>(com.tencent.matrix.a.b.b$a):void type: CONSTRUCTOR)
             type: STATIC call: java.util.Collections.sort(java.util.List, java.util.Comparator):void in method: com.tencent.matrix.c.a.Sz():com.tencent.matrix.a.b, file: classes4.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01f6: CONSTRUCTOR  (r5v11 com.tencent.matrix.a.b.b$a$1) = (r4v10 'ep' com.tencent.matrix.a.b.b$a) call: com.tencent.matrix.a.b.b.a.1.<init>(com.tencent.matrix.a.b.b$a):void type: CONSTRUCTOR in method: com.tencent.matrix.c.a.Sz():com.tencent.matrix.a.b, file: classes4.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.matrix.a.b.b, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            */
        /*
        // Method dump skipped, instructions count: 529
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.matrix.c.a.Sz():com.tencent.matrix.a.b");
    }

    public static boolean SA() {
        int i2;
        if (cUZ != null) {
            return cUZ.get();
        }
        com.tencent.mm.plugin.expt.b.b bVar = (com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class);
        if (bVar != null) {
            i2 = Math.max(bVar.a(b.a.clicfg_battery_dice_base, 10000), 100);
        } else {
            i2 = 10000;
        }
        boolean ip = ip(i2);
        a.C0226a.cC(ip);
        AtomicBoolean atomicBoolean = new AtomicBoolean(ip);
        cUZ = atomicBoolean;
        return atomicBoolean.get();
    }

    private static boolean ip(int i2) {
        double random = Math.random();
        if (i2 <= 0 || random >= 1.0d / ((double) i2)) {
            return false;
        }
        Log.i("Matrix.battery.BatteryCanaryConfigs", "dice hit, go kv stat!");
        return true;
    }

    public static long SB() {
        return Math.max(cUQ, 10000L);
    }

    public static long SC() {
        return Math.max(cUR, 1000L);
    }

    public static long SD() {
        return Math.max(cUS, 10000L);
    }

    public static long SE() {
        return Math.max(cUT, 1000L);
    }

    public static boolean SF() {
        return cUU;
    }

    public static long SG() {
        return Math.max(cUV, 2L);
    }

    /* renamed from: com.tencent.matrix.c.a$a  reason: collision with other inner class name */
    public static class C0219a extends g.a<C0219a> {
        public g.a.c.b<Long> cVb;
        public g.a.c.b<Integer> cVc;

        public static C0219a SI() {
            C0219a aVar = new C0219a();
            aVar.cVb = g.a.c.b.b(Long.valueOf(a.cUY));
            aVar.cVc = g.a.c.b.b(Integer.valueOf(com.tencent.mm.a.a.dgC));
            return aVar;
        }
    }
}
