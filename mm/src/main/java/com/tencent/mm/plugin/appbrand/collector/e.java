package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class e {
    public static StringBuilder a(TimePoint timePoint) {
        AppMethodBeat.i(146106);
        StringBuilder sb = new StringBuilder();
        if (timePoint == null) {
            Log.i("MicroMsg.CostTimeUtil", "print failed, headPoint is null.");
            AppMethodBeat.o(146106);
            return sb;
        }
        sb.append(0).append(". ").append(timePoint.name).append(" : ");
        sb.append(timePoint.lbp);
        sb.append(", ");
        sb.append(timePoint.lbo.get());
        sb.append(", ");
        sb.append(timePoint.lbp.get() - timePoint.lbp.get());
        int i2 = 0;
        TimePoint timePoint2 = timePoint;
        while (timePoint2.lbq.get() != null) {
            TimePoint timePoint3 = timePoint2.lbq.get();
            sb.append("\n");
            sb.append(i2 + 1).append(". ").append(timePoint3.name).append(" : ");
            sb.append(((double) (timePoint3.lbp.get() - timePoint2.lbp.get())) / 1000000.0d);
            i2++;
            timePoint2 = timePoint3;
        }
        sb.append("\n");
        sb.append("total cost : ").append(((double) (timePoint2.lbp.get() - timePoint.lbp.get())) / 1000000.0d);
        AppMethodBeat.o(146106);
        return sb;
    }
}
