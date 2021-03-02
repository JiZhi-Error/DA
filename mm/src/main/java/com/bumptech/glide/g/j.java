package com.bumptech.glide.g;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public final class j {
    public static void checkArgument(boolean z, String str) {
        AppMethodBeat.i(77766);
        if (!z) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(str);
            AppMethodBeat.o(77766);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(77766);
    }

    public static <T> T checkNotNull(T t, String str) {
        AppMethodBeat.i(77767);
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException(str);
            AppMethodBeat.o(77767);
            throw nullPointerException;
        }
        AppMethodBeat.o(77767);
        return t;
    }

    public static String checkNotEmpty(String str) {
        AppMethodBeat.i(77768);
        if (TextUtils.isEmpty(str)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Must not be null or empty");
            AppMethodBeat.o(77768);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(77768);
        return str;
    }

    public static <T extends Collection<Y>, Y> T b(T t) {
        AppMethodBeat.i(77769);
        if (t.isEmpty()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Must not be empty.");
            AppMethodBeat.o(77769);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(77769);
        return t;
    }
}
