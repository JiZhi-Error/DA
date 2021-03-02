package com.tencent.mm.ext.a.b;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public static int cH(Context context) {
        AppMethodBeat.i(197818);
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            if (identifier != 0) {
                int dimensionPixelSize = resources.getDimensionPixelSize(identifier);
                AppMethodBeat.o(197818);
                return dimensionPixelSize;
            }
            AppMethodBeat.o(197818);
            return 25;
        } catch (Resources.NotFoundException e2) {
            com.tencent.liteapp.b.b.e("MicroMsg.ResourceCompat", "get res of status_bar_height fail %s", e2.toString());
            AppMethodBeat.o(197818);
            return 25;
        }
    }
}
