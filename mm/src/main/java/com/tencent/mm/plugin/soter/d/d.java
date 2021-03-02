package com.tencent.mm.plugin.soter.d;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.soter.core.a;
import com.tencent.soter.core.c.i;

public final class d {
    public static e flM() {
        AppMethodBeat.i(130840);
        flN();
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath());
        if (mmkv == null) {
            e eVar = new e();
            AppMethodBeat.o(130840);
            return eVar;
        }
        String string = mmkv.getString("cpu_id", "");
        String string2 = mmkv.getString("uid", "");
        if (Util.isNullOrNil(string) || Util.isNullOrNil(string2)) {
            Log.w("MicroMsg.SoterDeviceInfoManager", "hy: no cpu id and uid retrieved. load again");
            i hlo = a.hlo();
            if (hlo != null) {
                String str = hlo.FhU;
                String valueOf = String.valueOf(hlo.uid);
                if (!Util.isNullOrNil(str) && !Util.isNullOrNil(valueOf)) {
                    kV(str, valueOf);
                    e eVar2 = new e(str, valueOf);
                    AppMethodBeat.o(130840);
                    return eVar2;
                }
            }
            e eVar3 = new e();
            AppMethodBeat.o(130840);
            return eVar3;
        }
        Log.i("MicroMsg.SoterDeviceInfoManager", "hy:device info exists in preference. directly return");
        e eVar4 = new e(string, string2);
        AppMethodBeat.o(130840);
        return eVar4;
    }

    public static void flN() {
        AppMethodBeat.i(130841);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath());
        String string = mmkv.getString("cpu_id", null);
        String string2 = mmkv.getString("uid", null);
        if (Util.isNullOrNil(string) || Util.isNullOrNil(string2)) {
            SharedPreferences defaultPreference = MMApplicationContext.getDefaultPreference();
            if (defaultPreference == null) {
                AppMethodBeat.o(130841);
                return;
            }
            String string3 = defaultPreference.getString("cpu_id", null);
            String string4 = defaultPreference.getString("uid", null);
            Log.i("MicroMsg.SoterDeviceInfoManager", "transfer old cpuId: %s, old uid: %s", string, string2);
            mmkv.putString("cpu_id", string3);
            mmkv.putString("uid", string4);
            mmkv.commit();
        }
        AppMethodBeat.o(130841);
    }

    public static void kV(String str, String str2) {
        AppMethodBeat.i(130842);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(MMApplicationContext.getDefaultPreferencePath());
        if (mmkv == null) {
            AppMethodBeat.o(130842);
            return;
        }
        SharedPreferences.Editor edit = mmkv.edit();
        edit.putString("cpu_id", str);
        edit.putString("uid", str2);
        edit.commit();
        Log.i("MicroMsg.SoterDeviceInfoManager", "hy: save device info");
        AppMethodBeat.o(130842);
    }
}
