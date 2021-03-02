package com.tencent.mm.plugin.expt.hellhound.a.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class b {
    public static void Hj(int i2) {
        AppMethodBeat.i(122030);
        if (!TextUtils.isEmpty("page_hell_seq_mmkv_key")) {
            MultiProcessMMKV.getMMKV("_hellhound_mmkv").putInt("page_hell_seq_mmkv_key", i2);
        }
        AppMethodBeat.o(122030);
    }
}
