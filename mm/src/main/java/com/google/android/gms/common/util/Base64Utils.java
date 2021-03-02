package com.google.android.gms.common.util;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Base64Utils {
    public static byte[] decode(String str) {
        AppMethodBeat.i(5057);
        if (str == null) {
            AppMethodBeat.o(5057);
            return null;
        }
        byte[] decode = Base64.decode(str, 0);
        AppMethodBeat.o(5057);
        return decode;
    }

    public static byte[] decodeUrlSafe(String str) {
        AppMethodBeat.i(5058);
        if (str == null) {
            AppMethodBeat.o(5058);
            return null;
        }
        byte[] decode = Base64.decode(str, 10);
        AppMethodBeat.o(5058);
        return decode;
    }

    public static byte[] decodeUrlSafeNoPadding(String str) {
        AppMethodBeat.i(5059);
        if (str == null) {
            AppMethodBeat.o(5059);
            return null;
        }
        byte[] decode = Base64.decode(str, 11);
        AppMethodBeat.o(5059);
        return decode;
    }

    public static byte[] decodeUrlSafeNoPadding(byte[] bArr) {
        AppMethodBeat.i(5060);
        if (bArr == null) {
            AppMethodBeat.o(5060);
            return null;
        }
        byte[] decode = Base64.decode(bArr, 11);
        AppMethodBeat.o(5060);
        return decode;
    }

    public static String encode(byte[] bArr) {
        AppMethodBeat.i(5061);
        if (bArr == null) {
            AppMethodBeat.o(5061);
            return null;
        }
        String encodeToString = Base64.encodeToString(bArr, 0);
        AppMethodBeat.o(5061);
        return encodeToString;
    }

    public static String encodeUrlSafe(byte[] bArr) {
        AppMethodBeat.i(5062);
        if (bArr == null) {
            AppMethodBeat.o(5062);
            return null;
        }
        String encodeToString = Base64.encodeToString(bArr, 10);
        AppMethodBeat.o(5062);
        return encodeToString;
    }

    public static String encodeUrlSafeNoPadding(byte[] bArr) {
        AppMethodBeat.i(5063);
        if (bArr == null) {
            AppMethodBeat.o(5063);
            return null;
        }
        String encodeToString = Base64.encodeToString(bArr, 11);
        AppMethodBeat.o(5063);
        return encodeToString;
    }
}
