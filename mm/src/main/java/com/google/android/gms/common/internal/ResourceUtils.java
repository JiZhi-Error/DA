package com.google.android.gms.common.internal;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ResourceUtils {
    private static final Uri zzuw = new Uri.Builder().scheme("android.resource").authority("com.google.android.gms").appendPath("drawable").build();

    @Deprecated
    public interface SignInResources {
        public static final String BUTTON_DARK_TEXT_DEFAULT = "common_google_signin_btn_text_dark_normal";
    }

    static {
        AppMethodBeat.i(4742);
        AppMethodBeat.o(4742);
    }

    private ResourceUtils() {
    }

    public static Uri getDrawableUri(String str) {
        AppMethodBeat.i(4741);
        Preconditions.checkNotNull(str, "Resource name must not be null.");
        Uri build = zzuw.buildUpon().appendPath(str).build();
        AppMethodBeat.o(4741);
        return build;
    }
}
