package com.bumptech.glide.load.a.a;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public static boolean f(Uri uri) {
        AppMethodBeat.i(76903);
        if (uri == null || !"content".equals(uri.getScheme()) || !"media".equals(uri.getAuthority())) {
            AppMethodBeat.o(76903);
            return false;
        }
        AppMethodBeat.o(76903);
        return true;
    }

    public static boolean g(Uri uri) {
        AppMethodBeat.i(76904);
        boolean contains = uri.getPathSegments().contains("video");
        AppMethodBeat.o(76904);
        return contains;
    }

    public static boolean aO(int i2, int i3) {
        return i2 != Integer.MIN_VALUE && i3 != Integer.MIN_VALUE && i2 <= 512 && i3 <= 384;
    }
}
