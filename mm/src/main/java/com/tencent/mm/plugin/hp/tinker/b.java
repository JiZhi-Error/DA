package com.tencent.mm.plugin.hp.tinker;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class b {
    private final String yni;
    private final String ynj;

    private b(String str, String str2) {
        AppMethodBeat.i(117456);
        if (TextUtils.isEmpty(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("baseClientVersion is empty.");
            AppMethodBeat.o(117456);
            throw illegalArgumentException;
        } else if (TextUtils.isEmpty(str2)) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("patchClientVersion is empty.");
            AppMethodBeat.o(117456);
            throw illegalArgumentException2;
        } else {
            this.yni = str;
            this.ynj = str2;
            AppMethodBeat.o(117456);
        }
    }

    public static b ii(String str, String str2) {
        AppMethodBeat.i(117457);
        b bVar = new b(str, str2);
        AppMethodBeat.o(117457);
        return bVar;
    }

    public static SharedPreferences dZh() {
        AppMethodBeat.i(117458);
        try {
            MultiProcessMMKV mMKVWithTransportByName = MultiProcessMMKV.getMMKVWithTransportByName("tinker_deploy_stats_ts");
            AppMethodBeat.o(117458);
            return mMKVWithTransportByName;
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.TinkerDeployStatistic", th, "[-] Fail to init mmkv storage, fallback to system sp.", new Object[0]);
            SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("tinker_deploy_stats_ts", 4);
            AppMethodBeat.o(117458);
            return sharedPreferences;
        }
    }

    private static int aBH(String str) {
        int i2 = 0;
        AppMethodBeat.i(117459);
        try {
            if (str.startsWith("0x")) {
                str = str.substring(2);
            } else if (str.endsWith("h") || str.endsWith("H")) {
                str = str.substring(0, str.length() - 1);
            }
            i2 = Integer.parseInt(str, 16);
            AppMethodBeat.o(117459);
        } catch (Throwable th) {
            Log.e("MicroMsg.TinkerDeployStatistic", "[-] Fail to parse hex string: %s", str);
            AppMethodBeat.o(117459);
        }
        return i2;
    }

    public final String OW(int i2) {
        AppMethodBeat.i(117460);
        String str = "mmkv_key_" + aBH(this.yni) + "_" + aBH(this.ynj) + "_" + i2;
        AppMethodBeat.o(117460);
        return str;
    }

    public final void aq(int i2, long j2) {
        AppMethodBeat.i(184835);
        h.INSTANCE.a(17676, String.valueOf(i2) + ',' + aBH(this.yni) + ',' + aBH(this.ynj) + ',' + j2, true, true);
        AppMethodBeat.o(184835);
    }

    @SuppressLint({"ApplySharedPref"})
    private static void aBI(String str) {
        AppMethodBeat.i(117462);
        SharedPreferences dZh = dZh();
        if (!dZh.contains(str)) {
            dZh.edit().putLong(str, System.currentTimeMillis()).commit();
        }
        AppMethodBeat.o(117462);
    }

    public final void dZi() {
        AppMethodBeat.i(117463);
        aBI(OW(1));
        AppMethodBeat.o(117463);
    }

    public final void dZj() {
        AppMethodBeat.i(196793);
        aBI(OW(2));
        AppMethodBeat.o(196793);
    }

    @SuppressLint({"ApplySharedPref"})
    public final void dZk() {
        AppMethodBeat.i(196794);
        SharedPreferences dZh = dZh();
        String OW = OW(1);
        if (dZh.contains(OW)) {
            aq(1, System.currentTimeMillis() - dZh.getLong(OW, 0));
            dZh.edit().remove(OW).commit();
        }
        AppMethodBeat.o(196794);
    }
}
