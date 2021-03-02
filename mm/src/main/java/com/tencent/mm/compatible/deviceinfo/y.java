package com.tencent.mm.compatible.deviceinfo;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import java.util.Map;

public final class y {
    public static boolean gJA = false;
    public String gJB = "";
    Map<String, String> gJC = null;
    private int gJD = 0;

    public final void oy(int i2) {
        AppMethodBeat.i(155767);
        this.gJD = i2;
        gJA = true;
        SharedPreferences.Editor edit = MultiProcessSharedPreferences.getSharedPreferences(MMApplicationContext.getContext(), "system_config_prefs", 4).edit();
        edit.putInt("update_swip_back_status", i2);
        edit.commit();
        Log.v("MicroMsg.ManuFacturerInfo", "update mSwipBackStatus(%s)", Integer.valueOf(this.gJD));
        AppMethodBeat.o(155767);
    }

    public static boolean aoW() {
        if (!gJA) {
            return false;
        }
        gJA = false;
        return true;
    }

    public final void DY(String str) {
        this.gJB = str;
    }

    public final void r(Map<String, String> map) {
        this.gJC = map;
    }
}
