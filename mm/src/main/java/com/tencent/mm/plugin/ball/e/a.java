package com.tencent.mm.plugin.ball.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

public final class a {
    public long iOB = -1;
    public List<BallInfo> oWD;

    public final void BF(int i2) {
        int i3;
        int i4;
        AppMethodBeat.i(106060);
        String str = (this.oWD == null || this.oWD.isEmpty()) ? null : this.oWD.get(0).oWs.oWB;
        long nowMilliSecond = Util.nowMilliSecond();
        StringBuilder sb = new StringBuilder();
        if (this.oWD != null) {
            int size = this.oWD.size();
            i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                i4 |= this.oWD.get(i5).cig();
                if (i5 != 0) {
                    sb.append(";");
                }
                sb.append(this.oWD.get(i5).oWs.oWA);
            }
            i3 = size;
        } else {
            i3 = 0;
            i4 = 0;
        }
        String format = String.format("%s,%d,%d,%d,%d,%d,%s", str, Long.valueOf(this.iOB), Long.valueOf(nowMilliSecond), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), sb.toString());
        Log.v("MicroMsg.FloatMenuReportHelper", "whenHideMenu reportStr:%s", format);
        h.INSTANCE.kvStat(17603, format);
        this.iOB = -1;
        AppMethodBeat.o(106060);
    }
}
