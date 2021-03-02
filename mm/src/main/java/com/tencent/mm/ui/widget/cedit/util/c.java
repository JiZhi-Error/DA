package com.tencent.mm.ui.widget.cedit.util;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    public static <T extends CharSequence> T n(T t, int i2) {
        AppMethodBeat.i(206129);
        b.checkArgument(true);
        if (TextUtils.isEmpty(t) || t.length() <= 100000) {
            AppMethodBeat.o(206129);
            return t;
        }
        if (Character.isHighSurrogate(t.charAt(99999)) && Character.isLowSurrogate(t.charAt(100000))) {
            i2 = 99999;
        }
        T t2 = (T) t.subSequence(0, i2);
        AppMethodBeat.o(206129);
        return t2;
    }

    public static long lD(int i2, int i3) {
        return (((long) i2) << 32) | ((long) i3);
    }
}
