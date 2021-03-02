package com.tencent.mm.plugin.sns.ad.e;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.tools.a.a;
import java.util.Collections;
import java.util.List;

public final class j {
    public static boolean a(String str, String str2, float f2) {
        AppMethodBeat.i(201939);
        try {
            List<PointF> aOy = r.aOy(str2);
            List<PointF> aOy2 = r.aOy(str);
            if (aOy.size() > 0 && aOy2.size() > 0) {
                List<PointF> jX = a.jX(aOy2);
                double E = a.E(aOy, jX);
                Collections.reverse(aOy);
                double E2 = a.E(aOy, jX);
                float min = (float) Math.min(E, E2);
                Log.i("GestureHelper", "similarity: %f,%f, distance:%f", Double.valueOf(E), Double.valueOf(E2), Float.valueOf(min));
                if (min <= f2) {
                    AppMethodBeat.o(201939);
                    return true;
                }
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("GestureHelper", e2, "recog gesture error!", new Object[0]);
        }
        AppMethodBeat.o(201939);
        return false;
    }
}
