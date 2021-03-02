package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class p {
    private static Boolean nWO;
    private static Boolean nWP;
    private static Boolean nWQ;

    public static boolean bXu() {
        boolean z;
        AppMethodBeat.i(227670);
        if (nWO != null) {
            boolean booleanValue = nWO.booleanValue();
            AppMethodBeat.o(227670);
            return booleanValue;
        }
        MultiProcessMMKV VQ = f.kIs.VQ();
        if (VQ == null) {
            Log.w("MicroMsg.AppBrandTaskTestSwitcher", "useManagerV2: mmkv is null");
            AppMethodBeat.o(227670);
            return false;
        }
        int i2 = VQ.getInt("enable_v2_task_manager", 2);
        if (i2 == 1) {
            z = true;
        } else {
            if (i2 != 0) {
                int a2 = ((b) g.af(b.class)).a(b.a.clicfg_android_appbrand_enable_task_manager_v2, 0);
                if (BuildInfo.IS_FLAVOR_RED) {
                    a2 = 1;
                }
                if (a2 > 0) {
                    z = true;
                }
            }
            z = false;
        }
        nWO = Boolean.valueOf(z);
        Log.i("MicroMsg.AppBrandTaskTestSwitcher", "useManagerV2: [%b]", nWO);
        boolean booleanValue2 = nWO.booleanValue();
        AppMethodBeat.o(227670);
        return booleanValue2;
    }

    public static boolean bXv() {
        AppMethodBeat.i(227671);
        if (nWP != null) {
            boolean booleanValue = nWP.booleanValue();
            AppMethodBeat.o(227671);
            return booleanValue;
        }
        MultiProcessMMKV VQ = f.kIs.VQ();
        if (VQ == null) {
            Log.w("MicroMsg.AppBrandTaskTestSwitcher", "useSingleTaskDispatchStrategy: mmkv is null");
            AppMethodBeat.o(227671);
            return false;
        }
        int i2 = VQ.getInt("enable_single_task_dispatch", 2);
        if (i2 == 1) {
            nWP = Boolean.TRUE;
        } else if (i2 == 0) {
            nWP = Boolean.FALSE;
        } else {
            int a2 = ((b) g.af(b.class)).a(b.a.clicfg_android_appbrand_enable_task_single_strategy, 0);
            if (BuildInfo.IS_FLAVOR_RED) {
                a2 = 1;
            }
            Boolean valueOf = Boolean.valueOf(a2 == 1);
            nWP = valueOf;
            if (valueOf.booleanValue() && !q.is64BitRuntime()) {
                Log.i("MicroMsg.AppBrandTaskTestSwitcher", "useSingleTaskDispatchStrategy: test is64BitRuntime fail");
                nWP = Boolean.FALSE;
            }
            if (nWP.booleanValue() && !bXu()) {
                nWP = Boolean.FALSE;
            }
        }
        Log.i("MicroMsg.AppBrandTaskTestSwitcher", "useSingleTaskDispatchStrategy: [%b]", nWP);
        boolean booleanValue2 = nWP.booleanValue();
        AppMethodBeat.o(227671);
        return booleanValue2;
    }

    public static boolean bXw() {
        AppMethodBeat.i(227672);
        if (nWQ != null) {
            boolean booleanValue = nWQ.booleanValue();
            AppMethodBeat.o(227672);
            return booleanValue;
        }
        MultiProcessMMKV VQ = f.kIs.VQ();
        if (VQ == null) {
            Log.w("MicroMsg.AppBrandTaskTestSwitcher", "useThreeTasksDispatchStrategy: mmkv is null");
            AppMethodBeat.o(227672);
            return false;
        }
        int i2 = VQ.getInt("enable_three_proc_tasks_dispatch", 2);
        if (i2 == 1) {
            nWQ = Boolean.TRUE;
        } else if (i2 == 0) {
            nWQ = Boolean.FALSE;
        } else {
            Boolean valueOf = Boolean.valueOf(((b) g.af(b.class)).a(b.a.clicfg_android_appbrand_enable_task_single_strategy, 0) == 2);
            nWQ = valueOf;
            if (valueOf.booleanValue() && !q.is64BitRuntime()) {
                Log.i("MicroMsg.AppBrandTaskTestSwitcher", "useThreeTasksDispatchStrategy: test is64BitRuntime fail");
                nWQ = Boolean.FALSE;
            }
            if (nWQ.booleanValue() && !bXu()) {
                nWQ = Boolean.FALSE;
            }
        }
        Log.i("MicroMsg.AppBrandTaskTestSwitcher", "useThreeTasksDispatchStrategy: [%b]", nWQ);
        boolean booleanValue2 = nWQ.booleanValue();
        AppMethodBeat.o(227672);
        return booleanValue2;
    }

    public static void iN(boolean z) {
        AppMethodBeat.i(227673);
        MultiProcessMMKV VQ = f.kIs.VQ();
        if (VQ != null) {
            VQ.putInt("enable_v2_task_manager", z ? 1 : 0);
        }
        AppMethodBeat.o(227673);
    }

    public static void iO(boolean z) {
        AppMethodBeat.i(227674);
        MultiProcessMMKV VQ = f.kIs.VQ();
        if (VQ != null) {
            VQ.putInt("enable_three_proc_tasks_dispatch", z ? 1 : 0);
        }
        AppMethodBeat.o(227674);
    }

    public static void iP(boolean z) {
        AppMethodBeat.i(227675);
        MultiProcessMMKV VQ = f.kIs.VQ();
        if (VQ != null) {
            VQ.putInt("enable_single_task_dispatch", z ? 1 : 0);
        }
        AppMethodBeat.o(227675);
    }
}
