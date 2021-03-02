package com.tencent.mm.plugin.nfc_open;

import android.content.ComponentName;
import android.content.SharedPreferences;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cg;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.d;
import com.tencent.mm.plugin.nfc_open.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public final class a implements bd {
    private com.tencent.mm.plugin.nfc_open.b.a AEl;

    private static a exy() {
        AppMethodBeat.i(26681);
        bg.aVz();
        a aVar = (a) cg.KG("plugin.nfc_open");
        if (aVar == null) {
            Log.w("MicroMsg.SubCoreCpuCard", "[NFC]not found in MMCore, new one");
            aVar = new a();
            bg.aVz().a("plugin.nfc_open", aVar);
        }
        AppMethodBeat.o(26681);
        return aVar;
    }

    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        AppMethodBeat.i(26682);
        Log.i("MicroMsg.SubCoreCpuCard", "alvinluo process: %s", Util.getProcessNameByPid(MMApplicationContext.getContext(), Process.myPid()));
        g.aAf().azk();
        if (exy().AEl == null) {
            exy().AEl = new com.tencent.mm.plugin.nfc_open.b.a();
        }
        com.tencent.mm.plugin.nfc_open.b.a aVar = exy().AEl;
        if (aVar.dZt()) {
            Log.i("MicroMsg.CpuCardConfigManager", "do update cpu card config");
            bg.azz().a(1561, aVar);
            bg.azz().a(new b(aVar.AEn.version), 0);
        }
        bg.aVF();
        int intValue = ((Integer) c.azQ().get(ar.a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, (Object) 0)).intValue();
        if (intValue == 0) {
            bg.aVF();
            if (((Integer) c.azQ().get(ar.a.USERINFO_NFC_OPEN_DEFAULT_SWITCH_INT_SYNC, (Object) 0)).intValue() == 1) {
                st(true);
            } else {
                st(false);
            }
        } else if (intValue == 1) {
            st(true);
        } else {
            st(false);
        }
        Log.i("MicroMsg.SubCoreCpuCard", "doNFCReport start");
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.nfc_open.a.AnonymousClass1 */

            public final void run() {
                int i2;
                AppMethodBeat.i(26680);
                SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "system_config_prefs", 4);
                if (Util.ticksToNow(sharedPreferences.getLong("NFC_REPORT_TIME", 0)) > Util.MILLSECONDS_OF_DAY) {
                    int gJ = com.tencent.mm.plugin.nfc.b.a.a.exw().gJ(MMApplicationContext.getContext());
                    int i3 = gJ == 0 ? 0 : 1;
                    if (d.bHW()) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    Log.i("MicroMsg.SubCoreCpuCard", "alvinluo NFC report isSupportNFC: %d, isSupportHCE: %d", Integer.valueOf(i3), Integer.valueOf(i2));
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(12779, q.dr(true), Integer.valueOf(i3), Integer.valueOf(i2));
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putLong("NFC_REPORT_TIME", Util.currentTicks());
                    edit.commit();
                    Log.i("MicroMsg.SubCoreCpuCard", "doNFCReport status = ".concat(String.valueOf(gJ)));
                }
                AppMethodBeat.o(26680);
            }
        }, getClass().getName());
        AppMethodBeat.o(26682);
    }

    private static void st(boolean z) {
        AppMethodBeat.i(26683);
        if (z) {
            MMApplicationContext.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
            AppMethodBeat.o(26683);
            return;
        }
        MMApplicationContext.getContext().getPackageManager().setComponentEnabledSetting(new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
        AppMethodBeat.o(26683);
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
    }
}
