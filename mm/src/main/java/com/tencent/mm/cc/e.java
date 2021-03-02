package com.tencent.mm.cc;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class e {
    public static String aJ(Context context, int i2) {
        AppMethodBeat.i(205093);
        String string = jp(context).getString(i2);
        AppMethodBeat.o(205093);
        return string;
    }

    public static Resources jp(Context context) {
        AppMethodBeat.i(205094);
        Resources resources = context != null ? context.getResources() : null;
        if (resources instanceof b) {
            AppMethodBeat.o(205094);
            return resources;
        }
        Resources resources2 = MMApplicationContext.getResources();
        AppMethodBeat.o(205094);
        return resources2;
    }
}
