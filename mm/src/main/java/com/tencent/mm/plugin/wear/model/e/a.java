package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

public abstract class a {
    public abstract List<Integer> fWe();

    /* access modifiers changed from: protected */
    public abstract byte[] s(int i2, byte[] bArr);

    public final void c(int i2, int i3, int i4, byte[] bArr) {
        if (!afh(i4) || bArr == null || (bArr = com.tencent.mm.plugin.wear.model.a.fVM().cw(bArr)) != null) {
            byte[] s = s(i4, bArr);
            if (fWf()) {
                if (afg(i4)) {
                    s = com.tencent.mm.plugin.wear.model.a.fVM().cx(s);
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                try {
                    dataOutputStream.writeInt(i2);
                    dataOutputStream.writeInt(i3);
                    dataOutputStream.writeInt(i4);
                    if (s == null || s.length <= 0) {
                        dataOutputStream.writeInt(0);
                    } else {
                        dataOutputStream.writeInt(s.length);
                        dataOutputStream.write(s);
                    }
                    final byte[] byteArray = byteArrayOutputStream.toByteArray();
                    Log.i("MicroMsg.Wear.BaseHttpServer", "send data funId=%d length=%d", Integer.valueOf(i4), Integer.valueOf(byteArray.length));
                    if (!afi(i4)) {
                        com.tencent.mm.plugin.wear.model.a.fVM().cv(byteArray);
                    } else {
                        ThreadPool.post(new Runnable() {
                            /* class com.tencent.mm.plugin.wear.model.e.a.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(30066);
                                com.tencent.mm.plugin.wear.model.a.fVM().cv(byteArray);
                                AppMethodBeat.o(30066);
                            }
                        }, "WearSendResponseTask");
                    }
                } catch (IOException e2) {
                    Log.printErrStackTrace("MicroMsg.Wear.BaseHttpServer", e2, "gen response data error connectType=%d, sessionId=%d, funId=%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                }
            }
        } else {
            Log.e("MicroMsg.Wear.BaseHttpServer", "request data decrypt error");
        }
    }

    /* access modifiers changed from: protected */
    public boolean afg(int i2) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean afh(int i2) {
        return false;
    }

    public boolean afi(int i2) {
        return false;
    }

    public boolean fWf() {
        return true;
    }
}
