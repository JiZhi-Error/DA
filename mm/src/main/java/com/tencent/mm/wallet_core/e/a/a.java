package com.tencent.mm.wallet_core.e.a;

import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dbc;
import com.tencent.mm.protocal.protobuf.dbd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.c.x;
import com.tenpay.android.wechat.TenpayUtil;
import java.net.URLEncoder;

public abstract class a extends s {
    public abstract int fPU();

    @Override // com.tencent.mm.wallet_core.c.s
    public int getPayCgicmd() {
        return fPU();
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public void configRequest(boolean z, boolean z2) {
        d commReqResp = getCommReqResp();
        if (commReqResp == null) {
            d.a aVar = new d.a();
            aVar.iLN = new dbc();
            aVar.iLO = new dbd();
            aVar.uri = "/cgi-bin/mmpay-bin/payu";
            aVar.funcId = 1518;
            aVar.iLP = 0;
            aVar.respCmdId = 0;
            commReqResp = aVar.aXF();
            commReqResp.setIsUserCmd(true);
        }
        dbc dbc = (dbc) commReqResp.iLK.iLR;
        if (z) {
            dbc.MhQ = fPU();
        }
        if (z2) {
            dbc.MhR = 1;
        }
        setCommReqResp(commReqResp);
    }

    @Override // com.tencent.mm.ak.q
    public int getType() {
        return 1518;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public String getEncryptUrl(String str) {
        return TenpayUtil.signWith3Des(str);
    }

    @Override // com.tencent.mm.ak.q
    public int doScene(g gVar, i iVar) {
        this.callback = iVar;
        if (z.aUo()) {
            return dispatch(gVar, this.rr, this);
        }
        Log.e("MicroMsg.NetScenePayUBase", "hy: serious error: not payupay");
        iVar.onSceneEnd(1000, -100868, "Pay Method Err", this);
        return 1;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public void putToRequest(StringBuilder sb, String str) {
        sb.append(URLEncoder.encode(str));
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public void putToReqText(d dVar, SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        ((dbc) dVar.iLK.iLR).MhS = sKBuiltinBuffer_t;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public void putToWXReqText(d dVar, SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        ((dbc) dVar.iLK.iLR).MGc = sKBuiltinBuffer_t;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public x getRetModel(d dVar) {
        dbd dbd = (dbd) dVar.iLL.iLR;
        x xVar = new x();
        xVar.MhW = dbd.MhW;
        xVar.MhV = dbd.MhV;
        xVar.MhU = dbd.MhU;
        xVar.MhT = dbd.MhT;
        xVar.rBM = dbd.MGe;
        xVar.Ruc = dbd.MGd;
        return xVar;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public int doSceneSimulately(d dVar, g gVar, i iVar) {
        dbc dbc = (dbc) dVar.iLK.iLR;
        if (dbc.MhS != null) {
            new String(dbc.MhS.getBufferToBytes());
        }
        if (dbc.MGc != null) {
            new String(dbc.MGc.getBufferToBytes());
        }
        MMApplicationContext.getContext();
        getPayCgicmd();
        ae.hhx();
        return -1;
    }
}
