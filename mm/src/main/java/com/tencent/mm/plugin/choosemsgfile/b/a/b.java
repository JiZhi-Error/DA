package com.tencent.mm.plugin.choosemsgfile.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class b {
    private static final ThreadPoolExecutor qnn = new ThreadPoolExecutor(0, 1, 1, TimeUnit.SECONDS, new LinkedBlockingDeque());

    static {
        AppMethodBeat.i(123226);
        AppMethodBeat.o(123226);
    }

    public static void a(a aVar, a aVar2, com.tencent.mm.vending.e.b bVar) {
        AppMethodBeat.i(123225);
        Log.i("MicroMsg.MsgFileMgr", "sumbit() item:%s", aVar);
        c cVar = null;
        switch (aVar.getType()) {
            case 1:
                cVar = new e(aVar, aVar2, bVar);
                break;
            case 2:
                cVar = new f(aVar, aVar2, bVar);
                break;
            case 3:
                cVar = new g(aVar, aVar2, bVar);
                break;
            case 4:
                cVar = new d(aVar, aVar2, bVar);
                break;
        }
        if (cVar == null) {
            Log.e("MicroMsg.MsgFileMgr", "downloadTask is null, return");
            aVar2.cyk();
            AppMethodBeat.o(123225);
        } else if (!cVar.checkValid()) {
            Log.e("MicroMsg.MsgFileMgr", "downloadTask is invalid, return");
            aVar2.cym();
            AppMethodBeat.o(123225);
        } else {
            if (!cVar.cyn()) {
                qnn.submit(cVar);
            }
            AppMethodBeat.o(123225);
        }
    }
}
