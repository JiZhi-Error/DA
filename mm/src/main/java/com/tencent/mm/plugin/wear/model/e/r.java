package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public final class r {
    private static AtomicInteger IyH = new AtomicInteger();

    static {
        AppMethodBeat.i(30112);
        AppMethodBeat.o(30112);
    }

    public static void a(int i2, byte[] bArr, boolean z) {
        AppMethodBeat.i(30111);
        if (z) {
            bArr = a.fVM().cx(bArr);
        }
        int incrementAndGet = IyH.incrementAndGet();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeInt(0);
            dataOutputStream.writeInt(incrementAndGet);
            dataOutputStream.writeInt(i2);
            if (bArr == null || bArr.length <= 0) {
                dataOutputStream.writeInt(0);
            } else {
                dataOutputStream.writeInt(bArr.length);
                dataOutputStream.write(bArr);
            }
            a.fVM().cv(byteArrayOutputStream.toByteArray());
            AppMethodBeat.o(30111);
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.Wear.WearPushServerLogic", e2, "gen response data error connectType=%d, sessionId=%d, funId=%d", 0, Integer.valueOf(incrementAndGet), Integer.valueOf(i2));
            AppMethodBeat.o(30111);
        }
    }
}
