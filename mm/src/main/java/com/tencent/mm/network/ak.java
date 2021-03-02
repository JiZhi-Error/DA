package com.tencent.mm.network;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class ak {
    private static ak jGa = null;
    private HashMap<Integer, a> jGb = new HashMap<>();

    public interface a {
        int bks();
    }

    public ak() {
        AppMethodBeat.i(132943);
        AppMethodBeat.o(132943);
    }

    public static synchronized ak bkr() {
        ak akVar;
        synchronized (ak.class) {
            AppMethodBeat.i(132944);
            if (jGa == null) {
                jGa = new ak();
            }
            akVar = jGa;
            AppMethodBeat.o(132944);
        }
        return akVar;
    }

    public final synchronized int k(int i2, byte[] bArr) {
        int bks;
        AppMethodBeat.i(132945);
        a aVar = this.jGb.get(Integer.valueOf(i2));
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = aVar;
        objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        objArr[3] = Util.getStack();
        Log.i("MicroMsg.PostPushEventHandler", "postEvent event:%s cb:%s data:%s [%s]", objArr);
        if (aVar == null) {
            Object[] objArr2 = new Object[4];
            objArr2[0] = Integer.valueOf(i2);
            objArr2[1] = aVar;
            objArr2[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            objArr2[3] = Util.getStack();
            Log.e("MicroMsg.PostPushEventHandler", "postEvent cb == null  event:%s cb:%s data:%s [%s]", objArr2);
            bks = -3;
            AppMethodBeat.o(132945);
        } else {
            bks = aVar.bks();
            AppMethodBeat.o(132945);
        }
        return bks;
    }
}
