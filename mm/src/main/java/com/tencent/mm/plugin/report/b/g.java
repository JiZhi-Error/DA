package com.tencent.mm.plugin.report.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.aj;
import com.tencent.mm.protocal.protobuf.ak;
import com.tencent.mm.protocal.protobuf.bhn;
import com.tencent.mm.protocal.protobuf.bho;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class g extends q implements m {
    private static boolean isRunning = false;
    private static Object lock = new Object();
    public ak CxS;
    private i callback;
    private bhn dah = null;
    private d rr;

    static {
        AppMethodBeat.i(143799);
        AppMethodBeat.o(143799);
    }

    private static void setIsRunning(boolean z) {
        synchronized (lock) {
            isRunning = z;
        }
    }

    public g(int i2, int i3) {
        AppMethodBeat.i(143796);
        setIsRunning(true);
        aj ajVar = new aj();
        this.dah = new bhn();
        try {
            ajVar.KCZ = i2;
            ajVar.KDa = i3;
            this.dah.LSc = ajVar;
            AppMethodBeat.o(143796);
        } catch (Exception e2) {
            Log.e("MicroMsg.NetSceneGetAPMStrategy", "parse data error");
            AppMethodBeat.o(143796);
        }
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(143797);
        try {
            this.CxS = null;
            if (com.tencent.mm.kernel.g.aAg().hqi == null || com.tencent.mm.kernel.g.aAg().hqi.iMw == null) {
                Log.f("MicroMsg.NetSceneGetAPMStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
                this.callback.onSceneEnd(i3, i4, str, this);
            } else if (i3 != 0) {
                Log.e("MicroMsg.NetSceneGetAPMStrategy", "get report strategy err, errType:" + i3 + ", errCode:" + i4);
                this.callback.onSceneEnd(i3, i4, str, this);
                setIsRunning(false);
                AppMethodBeat.o(143797);
            } else {
                Log.d("MicroMsg.NetSceneGetAPMStrategy", "get report strategy ok");
                this.CxS = ((bho) this.rr.iLL.iLR).LSd;
                this.callback.onSceneEnd(i3, i4, str, this);
                setIsRunning(false);
                AppMethodBeat.o(143797);
            }
        } finally {
            setIsRunning(false);
            AppMethodBeat.o(143797);
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 914;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(143798);
        this.callback = iVar;
        com.tencent.mm.kernel.g.aAf();
        if (!a.azo()) {
            Log.w("MicroMsg.NetSceneGetAPMStrategy", "get mrs strategy must go after login");
            AppMethodBeat.o(143798);
            return -1;
        }
        d.a aVar = new d.a();
        aVar.iLQ = false;
        aVar.iLN = this.dah;
        aVar.iLO = new bho();
        aVar.uri = "/cgi-bin/micromsg-bin/getapmstrategy";
        aVar.funcId = getType();
        this.rr = aVar.aXF();
        int dispatch = dispatch(gVar, this.rr, this);
        if (dispatch < 0) {
            Log.i("MicroMsg.NetSceneGetAPMStrategy", "mark all failed. do scene %d", Integer.valueOf(dispatch));
            try {
                this.CxS = null;
                setIsRunning(false);
            } catch (Exception e2) {
                Log.e("MicroMsg.NetSceneGetAPMStrategy", "onStrategyResp failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), Util.stackTraceToString(e2));
            }
        }
        AppMethodBeat.o(143798);
        return dispatch;
    }
}
