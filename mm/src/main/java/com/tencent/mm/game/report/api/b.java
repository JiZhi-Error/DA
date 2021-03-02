package com.tencent.mm.game.report.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class b {
    public int hhs;
    public String hht;

    public b() {
    }

    public b(int i2, String str) {
        this.hhs = i2;
        this.hht = str;
    }

    public static b e(int i2, Object... objArr) {
        AppMethodBeat.i(117604);
        b bVar = new b();
        bVar.hhs = i2;
        StringBuilder sb = new StringBuilder();
        int length = objArr.length - 1;
        for (int i3 = 0; i3 < length; i3++) {
            sb.append(String.valueOf(objArr[i3])).append(',');
        }
        sb.append(String.valueOf(objArr[length]));
        bVar.hht = sb.toString();
        Log.d("MicroMsg.GameReportInfo", "appStat logID=%d, vals.size=%d, val = %s", Integer.valueOf(i2), Integer.valueOf(objArr.length), sb.toString());
        AppMethodBeat.o(117604);
        return bVar;
    }
}
