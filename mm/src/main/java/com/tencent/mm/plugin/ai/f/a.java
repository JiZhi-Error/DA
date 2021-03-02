package com.tencent.mm.plugin.ai.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;

public final class a {
    private static String TAG = "MicroMsg.AiMMKV";
    private String name = null;

    public final MultiProcessMMKV aTI() {
        AppMethodBeat.i(238934);
        d.cRY();
        int uin = d.getUin();
        if (uin == 0) {
            AppMethodBeat.o(238934);
            return null;
        }
        String str = uin + "_WxExptAiMMKV";
        if (!Util.isEqual(this.name, str)) {
            Log.i(TAG, "%s get mmkv change uin old[%s] new[%s]", info(), this.name, str);
            this.name = str;
        }
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(this.name);
        AppMethodBeat.o(238934);
        return mmkv;
    }

    private String info() {
        AppMethodBeat.i(238935);
        String sb = new StringBuilder().append(hashCode()).toString();
        AppMethodBeat.o(238935);
        return sb;
    }
}
