package com.tencent.mm.compatible.util;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class n {
    public static int getStatusBarHeight(Context context) {
        AppMethodBeat.i(200824);
        int D = D(context, 0);
        AppMethodBeat.o(200824);
        return D;
    }

    public static int D(Context context, int i2) {
        AppMethodBeat.i(200825);
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            if (identifier != 0) {
                int dimensionPixelSize = resources.getDimensionPixelSize(identifier);
                AppMethodBeat.o(200825);
                return dimensionPixelSize;
            }
            AppMethodBeat.o(200825);
            return i2;
        } catch (Resources.NotFoundException e2) {
            Log.printErrStackTrace("MicroMsg.ResourceCompat", e2, "get res of status_bar_height fail", new Object[0]);
            AppMethodBeat.o(200825);
            return i2;
        }
    }
}
