package com.tencent.mm.ui.transmit;

import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;

public final class c {
    private static final SparseIntArray Qye = new SparseIntArray();

    static {
        AppMethodBeat.i(234473);
        AppMethodBeat.o(234473);
    }

    public static void hn(String str, int i2) {
        AppMethodBeat.i(234471);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(234471);
            return;
        }
        int hashCode = str.hashCode();
        synchronized (Qye) {
            try {
                Qye.put(hashCode, Math.max(i2, 1));
            } finally {
                AppMethodBeat.o(234471);
            }
        }
    }

    public static ad.b bnX(String str) {
        boolean z;
        AppMethodBeat.i(234472);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(234472);
            return null;
        }
        int hashCode = str.hashCode();
        synchronized (Qye) {
            try {
                int i2 = Qye.get(hashCode, 0) - 1;
                if (i2 <= 0) {
                    z = true;
                    Qye.delete(hashCode);
                } else {
                    Qye.put(hashCode, i2);
                    z = false;
                }
            } catch (Throwable th) {
                AppMethodBeat.o(234472);
                throw th;
            }
        }
        if (z) {
            ad.b JW = ad.aVe().JW(str);
            AppMethodBeat.o(234472);
            return JW;
        }
        ad.b G = ad.aVe().G(str, false);
        AppMethodBeat.o(234472);
        return G;
    }
}
