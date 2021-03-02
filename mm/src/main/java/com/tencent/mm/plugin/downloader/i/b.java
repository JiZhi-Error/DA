package com.tencent.mm.plugin.downloader.i;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class b {
    public static void a(long j2, float f2, int i2) {
        AppMethodBeat.i(89136);
        Log.d("MicroMsg.FileDownloadSP", "speed = ".concat(String.valueOf(f2)));
        String str = Math.round(100.0f * f2) + "_" + i2;
        Log.d("MicroMsg.FileDownloadSP", "speedStr = ".concat(String.valueOf(str)));
        o(j2, str);
        AppMethodBeat.o(89136);
    }

    private static void o(long j2, String str) {
        String str2;
        AppMethodBeat.i(89137);
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("download_pref", 0);
        if (sharedPreferences == null) {
            AppMethodBeat.o(89137);
            return;
        }
        String string = sharedPreferences.getString(String.valueOf(j2), "");
        if (Util.isNullOrNil(string)) {
            str2 = "1_" + str + "|";
        } else {
            String[] split = string.split("\\|");
            str2 = string + (Util.getInt(split[split.length - 1].split("_")[0], 0) + 1) + "_" + str + "|";
        }
        Log.d("MicroMsg.FileDownloadSP", "saveDownloadSpeed, speedStr = ".concat(String.valueOf(str2)));
        sharedPreferences.edit().putString(String.valueOf(j2), str2).apply();
        AppMethodBeat.o(89137);
    }
}
