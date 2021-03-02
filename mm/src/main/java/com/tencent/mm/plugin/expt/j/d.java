package com.tencent.mm.plugin.expt.j;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.booter.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.vendor.Huawei;

public final class d implements b {
    private final String TAG = "MicroMsg.TargetStartServiceSingleton";

    @Override // com.tencent.mm.plugin.expt.j.b
    public final void axE() {
        boolean z;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(220649);
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_target26_start_service_switch, -1);
        if (!Util.isEqual(a2, 0)) {
            if (Util.isEqual(a2, 2)) {
                String a3 = ((b) g.af(b.class)).a(b.a.clicfg_target26_start_service_manu_exclusive, "");
                Log.i("MicroMsg.TargetStartServiceSingleton", "manufacturers:%s", Util.nullAs(a3, BuildConfig.COMMAND));
                if (Util.isNullOrNil(a3)) {
                    c.dg(true);
                } else {
                    String[] split = a3.split(",");
                    int i2 = 0;
                    while (true) {
                        if (i2 >= split.length) {
                            z3 = false;
                            break;
                        } else if (String.valueOf(split[i2]).equalsIgnoreCase(Build.MANUFACTURER)) {
                            c.dg(false);
                            z3 = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (!z3) {
                        c.dg(true);
                    }
                }
            } else if (Util.isEqual(a2, 1)) {
                String a4 = ((b) g.af(b.class)).a(b.a.clicfg_target26_start_service_manufacturer, "");
                Log.i("MicroMsg.TargetStartServiceSingleton", "manufacturers:%s", Util.nullAs(a4, BuildConfig.COMMAND));
                if (!Util.isNullOrNil(a4)) {
                    String[] split2 = a4.split(",");
                    int i3 = 0;
                    while (true) {
                        if (i3 >= split2.length) {
                            z2 = false;
                            break;
                        } else if (String.valueOf(split2[i3]).equalsIgnoreCase(Build.MANUFACTURER)) {
                            c.dg(true);
                            z2 = true;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (!z2) {
                        c.dg(false);
                    }
                }
            }
            int a5 = ((b) g.af(b.class)).a(b.a.clicfg_target26_start_service_switch_huawei, 0);
            if (com.tencent.mm.compatible.util.d.oD(26) || !Util.isEqual(a5, 0) || !Huawei.ifHUAWEI()) {
                c.nP(1);
                AppMethodBeat.o(220649);
            }
            String a6 = ((b) g.af(b.class)).a(b.a.clicfg_target26_start_service_huawei_info, "");
            String lowerCase = Build.MODEL.toLowerCase();
            Log.i("MicroMsg.TargetStartServiceSingleton", "model:%s startServiceHuaweiInfo:%s", lowerCase, Util.nullAs(a6, BuildConfig.COMMAND));
            try {
                if (!Util.isNullOrNil(a6)) {
                    String[] split3 = a6.split(",");
                    int i4 = 0;
                    while (true) {
                        if (i4 >= split3.length) {
                            z = false;
                            break;
                        } else if (lowerCase.startsWith(split3[i4].toLowerCase())) {
                            c.nP(1);
                            z = true;
                            break;
                        } else {
                            i4++;
                        }
                    }
                    if (!z) {
                        c.nP(0);
                    }
                    AppMethodBeat.o(220649);
                    return;
                }
                c.nP(0);
                AppMethodBeat.o(220649);
                return;
            } catch (Exception e2) {
                Log.i("MicroMsg.TargetStartServiceSingleton", "startServiceHuaweiInfo Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
                c.nP(0);
                AppMethodBeat.o(220649);
                return;
            }
        }
        c.dg(false);
        int a52 = ((b) g.af(b.class)).a(b.a.clicfg_target26_start_service_switch_huawei, 0);
        if (com.tencent.mm.compatible.util.d.oD(26)) {
        }
        c.nP(1);
        AppMethodBeat.o(220649);
    }
}
