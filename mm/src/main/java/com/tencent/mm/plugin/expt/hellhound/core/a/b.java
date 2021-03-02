package com.tencent.mm.plugin.expt.hellhound.core.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;

public final class b {
    public static void o(String str, byte[] bArr) {
        AppMethodBeat.i(121857);
        if (TextUtils.isEmpty(str) || bArr == null) {
            AppMethodBeat.o(121857);
            return;
        }
        MultiProcessMMKV.getMMKV("_hellhound_mmkv").encode(str, bArr);
        AppMethodBeat.o(121857);
    }

    public static byte[] getBytes(String str) {
        AppMethodBeat.i(121858);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(121858);
            return null;
        }
        byte[] decodeBytes = MultiProcessMMKV.getMMKV("_hellhound_mmkv").decodeBytes(str);
        AppMethodBeat.o(121858);
        return decodeBytes;
    }

    public static void apa(String str) {
        AppMethodBeat.i(121859);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(121859);
            return;
        }
        MultiProcessMMKV.getMMKV("_hellhound_mmkv").putLong(str, -1);
        AppMethodBeat.o(121859);
    }

    public static void putString(String str, String str2) {
        AppMethodBeat.i(121860);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(121860);
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        MultiProcessMMKV.getMMKV("_hellhound_mmkv").putString(str, str2);
        AppMethodBeat.o(121860);
    }

    public static String getString(String str) {
        AppMethodBeat.i(121861);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(121861);
            return null;
        }
        String string = MultiProcessMMKV.getMMKV("_hellhound_mmkv").getString(str, null);
        AppMethodBeat.o(121861);
        return string;
    }
}
