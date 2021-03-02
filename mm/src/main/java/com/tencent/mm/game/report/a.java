package com.tencent.mm.game.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;

public class a implements i {
    private static a hhk;

    public static a axd() {
        AppMethodBeat.i(175990);
        if (hhk == null) {
            synchronized (a.class) {
                try {
                    if (hhk == null) {
                        hhk = new a();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(175990);
                    throw th;
                }
            }
        }
        a aVar = hhk;
        AppMethodBeat.o(175990);
        return aVar;
    }

    private a() {
        AppMethodBeat.i(175991);
        g.azz().a(1223, this);
        AppMethodBeat.o(175991);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(175992);
        Log.i("MicroMsg.GameMsgReportService", "onSceneEnd, errType : %d, errCode : %d", Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(175992);
    }

    public static void b(String str, int i2, int i3, String str2, String str3) {
        AppMethodBeat.i(175993);
        Log.i("MicroMsg.GameMsgReportService", "appId = %s, opType = %d, opStatus = %d, extInfo = %s", str, Integer.valueOf(i2), Integer.valueOf(i3), str3);
        g.azz().a(new d(str, i2, i3, str2, str3), 0);
        AppMethodBeat.o(175993);
    }
}
