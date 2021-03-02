package com.tencent.mm.recovery.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.hp.net.SimpleHttpLogic;
import com.tencent.mm.plugin.hp.net.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.protobuf.cxv;
import com.tencent.mm.protocal.protobuf.cxw;
import com.tencent.mm.protocal.protobuf.cxz;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;

public final class a {
    public b.a ymT = new b.a() {
        /* class com.tencent.mm.recovery.a.a.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.hp.net.b.a
        public final void a(int i2, com.tencent.mm.plugin.hp.d.b bVar) {
            AppMethodBeat.i(193907);
            Log.d("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "error%d response:%s", Integer.valueOf(i2), bVar.toString());
            AppMethodBeat.o(193907);
        }
    };
    SimpleHttpLogic.Request ymU;
    SimpleHttpLogic.TaskCallback ymV = new SimpleHttpLogic.TaskCallback() {
        /* class com.tencent.mm.recovery.a.a.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.hp.net.SimpleHttpLogic.TaskCallback
        public final void onCompleted(int i2, int i3, byte[] bArr) {
            AppMethodBeat.i(193908);
            Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "onCompleted errorType:%d errorCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
            if (i2 == 0 && i3 == 200) {
                try {
                    PByteArray pByteArray = new PByteArray();
                    Log.e("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "unpack result ".concat(String.valueOf(SimpleHttpLogic.unpackResponse(bArr, pByteArray))));
                    cxw cxw = new cxw();
                    cxw.parseFrom(pByteArray.value);
                    cxz cxz = cxw.MCM;
                    if (cxz != null) {
                        a.this.ymW.a(0, new com.tencent.mm.plugin.hp.d.b(cxz));
                        AppMethodBeat.o(193908);
                        return;
                    }
                    Log.e("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "empty node. code:%d", Integer.valueOf(cxw.MCO));
                    a.this.ymW.a(-5, null);
                    AppMethodBeat.o(193908);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", e2, "debugMMTLSCheck", new Object[0]);
                    a.this.ymW.a(-2, null);
                    AppMethodBeat.o(193908);
                }
            } else {
                a.this.ymW.a(-1, null);
                AppMethodBeat.o(193908);
            }
        }
    };
    b.a ymW = this.ymT;

    public a(cxv cxv) {
        AppMethodBeat.i(193909);
        if (cxv == null) {
            String aKw = com.tencent.mm.loader.j.a.aKw();
            Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "baseTinkerId = ".concat(String.valueOf(aKw)));
            cxv = new cxv();
            cxv.MCI = aKw;
            cxv.APx = com.tencent.mm.loader.j.a.aKx();
            cxv.MCJ = b.dZe();
            cxv.MCL = 1;
        }
        try {
            this.ymU = new SimpleHttpLogic.Request();
            this.ymU.cgi = "/cgi-bin/micromsg-bin/mmtlsprconfig";
            this.ymU.host = MMApplicationContext.getResources().getString(R.string.e2c);
            PByteArray pByteArray = new PByteArray();
            Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "pack result ".concat(String.valueOf(SimpleHttpLogic.packRequest(cxv.toByteArray(), pByteArray))));
            this.ymU.body = pByteArray.value;
        } catch (IOException e2) {
            this.ymU = null;
            Log.printErrStackTrace("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", e2, "mmtls request create failed.", new Object[0]);
        }
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder();
        if (cxv != null) {
            sb.append("baseId  :").append(cxv.MCI).append("\n");
            sb.append("patchId :").append(cxv.APx).append("\n");
        }
        objArr[0] = sb.toString();
        Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "prconfig %s", objArr);
        AppMethodBeat.o(193909);
    }

    public final void a(b.a aVar) {
        AppMethodBeat.i(193910);
        this.ymW = aVar;
        if (this.ymU == null) {
            Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "doScene failed. request is null.");
            this.ymW.a(-3, null);
            AppMethodBeat.o(193910);
            return;
        }
        Log.i("MicroMsg.Tinker.NetSceneBaseMMTLSCheckCopycat", "start check");
        String str = "";
        if (BuildInfo.DEBUG) {
            str = "101.227.131.113";
        }
        SimpleHttpLogic.startRequest(this.ymU, this.ymV, str);
        AppMethodBeat.o(193910);
    }
}
