package com.tencent.mm.plugin.report.b;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.appbrand.jsapi.dg;
import com.tencent.mm.plugin.appbrand.jsapi.dh;
import com.tencent.mm.protocal.a.a.c;
import com.tencent.mm.protocal.a.a.f;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.protobuf.blg;
import com.tencent.mm.protocal.protobuf.blh;
import com.tencent.mm.protocal.protobuf.cbh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class h extends q implements m {
    private static boolean isRunning = false;
    private static Object lock = new Object();
    private a CxQ = new a();
    private blg CxT = null;
    private i callback;
    private d rr;

    static {
        AppMethodBeat.i(143804);
        AppMethodBeat.o(143804);
    }

    public static boolean isRunning() {
        boolean z;
        synchronized (lock) {
            z = isRunning;
        }
        return z;
    }

    private static void setIsRunning(boolean z) {
        synchronized (lock) {
            isRunning = z;
        }
    }

    public h() {
        AppMethodBeat.i(143800);
        setIsRunning(true);
        this.CxT = SmcProtoBufUtil.toMMGetStrategyReq();
        if (this.CxT != null) {
            this.CxT.LlD = new cbh();
            this.CxT.LlD.Mha = a.Wi(0);
        }
        AppMethodBeat.o(143800);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(143801);
        if (g.aAg().hqi == null || g.aAg().hqi.iMw == null) {
            Log.f("MicroMsg.NetSceneGetCliKVStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(143801);
        } else if (i3 != 0) {
            Log.e("MicroMsg.NetSceneGetCliKVStrategy", "get report strategy err, errType:" + i3 + ", errCode:" + i4);
            SmcLogic.OnStrategyResp(i3, i4, null, 1);
            SmcLogic.OnStrategyResp(i3, i4, null, 2);
            this.callback.onSceneEnd(i3, i4, str, this);
            setIsRunning(false);
            AppMethodBeat.o(143801);
        } else {
            Log.d("MicroMsg.NetSceneGetCliKVStrategy", "get report strategy ok");
            blh blh = (blh) this.rr.iLL.iLR;
            this.CxQ.a(blh.LlN, 0);
            try {
                f smcKVStrategyResp = SmcProtoBufUtil.toSmcKVStrategyResp(blh);
                c smcIdkeyStrategyResp = SmcProtoBufUtil.toSmcIdkeyStrategyResp(blh);
                SmcLogic.OnStrategyResp(0, 0, smcKVStrategyResp.toByteArray(), 1);
                SmcLogic.OnStrategyResp(0, 0, smcIdkeyStrategyResp.toByteArray(), 2);
            } catch (Exception e2) {
                Log.e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), Util.stackTraceToString(e2));
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            setIsRunning(false);
            AppMethodBeat.o(143801);
        }
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        AppMethodBeat.i(143802);
        g.aAf();
        if (a.azo()) {
            AppMethodBeat.o(143802);
            return dh.CTRL_INDEX;
        }
        AppMethodBeat.o(143802);
        return dg.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        String str;
        AppMethodBeat.i(143803);
        this.callback = iVar;
        g.aAf();
        boolean azo = a.azo();
        if (!azo) {
            this.CxT.LlC = b.cD(Util.getUuidRandom());
        }
        d.a aVar = new d.a();
        aVar.iLQ = false;
        aVar.iLN = this.CxT;
        aVar.iLO = new blh();
        if (azo) {
            str = "/cgi-bin/micromsg-bin/getkvidkeystrategy";
        } else {
            str = "/cgi-bin/micromsg-bin/getkvidkeystrategyrsa";
        }
        aVar.uri = str;
        aVar.funcId = getType();
        this.rr = aVar.aXF();
        if (!azo) {
            this.rr.setRsaInfo(ac.gtS());
            this.rr.option = 1;
        }
        int dispatch = dispatch(gVar, this.rr, this);
        if (dispatch < 0) {
            Log.i("MicroMsg.NetSceneGetCliKVStrategy", "mark all failed. do scene %d", Integer.valueOf(dispatch));
            try {
                SmcLogic.OnStrategyResp(3, -1, null, 1);
                SmcLogic.OnStrategyResp(3, -1, null, 2);
                setIsRunning(false);
            } catch (Exception e2) {
                Log.e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), Util.stackTraceToString(e2));
            }
        }
        AppMethodBeat.o(143803);
        return dispatch;
    }
}
