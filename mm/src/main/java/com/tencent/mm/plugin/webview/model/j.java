package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.protocal.protobuf.zp;
import com.tencent.mm.protocal.protobuf.zq;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class j {
    private final int IJt = 0;
    private final int IJu = 1;
    private final int IJv = 2;
    public LinkedList<String> IXK = null;
    public boolean pcZ = false;

    public final int h(LinkedList<String> linkedList, String str) {
        AppMethodBeat.i(78869);
        try {
            final int[] iArr = {2};
            d.a aVar = new d.a();
            aVar.iLN = new zp();
            aVar.iLO = new zq();
            aVar.uri = "/cgi-bin/micromsg-bin/checktextlanguage";
            aVar.funcId = 528;
            aVar.iLP = 0;
            aVar.respCmdId = 0;
            zp zpVar = (zp) aVar.aXF().iLK.iLR;
            zpVar.LkR = linkedList;
            zpVar.LkS = str;
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            new Bundle();
            IPCRunCgi.a(aVar.aXF(), new IPCRunCgi.a() {
                /* class com.tencent.mm.plugin.webview.model.j.AnonymousClass1 */

                @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                public final void a(int i2, int i3, String str, d dVar) {
                    AppMethodBeat.i(78868);
                    Log.i("MicroMsg.NetSceneCheckTextLanguage", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                    iArr[0] = 2;
                    if (i2 == 0 && i3 == 0) {
                        zq zqVar = (zq) dVar.iLL.iLR;
                        if (zqVar.LkU == 1) {
                            iArr[0] = 0;
                        } else if (zqVar.LkU == 2) {
                            iArr[0] = 1;
                        }
                        countDownLatch.countDown();
                        AppMethodBeat.o(78868);
                        return;
                    }
                    countDownLatch.countDown();
                    AppMethodBeat.o(78868);
                }
            });
            try {
                countDownLatch.await(1000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e2) {
                Log.w("MicroMsg.NetSceneCheckTextLanguage", e2.getMessage());
                Log.printErrStackTrace("MicroMsg.NetSceneCheckTextLanguage", e2, "", new Object[0]);
            }
            Log.i("MicroMsg.NetSceneCheckTextLanguage", "CheckTextLanguage end");
            int i2 = iArr[0];
            AppMethodBeat.o(78869);
            return i2;
        } catch (Exception e3) {
            Log.e("MicroMsg.NetSceneCheckTextLanguage", "CheckTextLanguage failed");
            AppMethodBeat.o(78869);
            return 2;
        }
    }
}
