package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.eha;
import com.tencent.mm.protocal.protobuf.ehb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.c.b;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.c.x;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.Vector;
import org.json.JSONObject;

public abstract class m extends s {
    public static final boolean IS_SPLIT_CGI = true;
    public static final String TAG = "MicroMsg.NetSenceTenPayBase";
    public static Vector<String> cgiFunNameVector = new Vector<>();
    protected boolean isFake = false;

    public abstract int getTenpayCgicmd();

    @Override // com.tencent.mm.wallet_core.c.s
    public int getPayCgicmd() {
        return getTenpayCgicmd();
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public void configRequest(boolean z, boolean z2) {
        d dVar;
        boolean z3;
        d commReqResp = getCommReqResp();
        if (commReqResp == null) {
            d.a aVar = new d.a();
            aVar.iLN = new eha();
            aVar.iLO = new ehb();
            String uri = getUri();
            int funcId = getFuncId();
            aVar.uri = uri;
            aVar.funcId = funcId;
            aVar.iLP = 185;
            aVar.respCmdId = 1000000185;
            dVar = aVar.aXF();
            if (!canRetry()) {
                z3 = true;
            } else {
                z3 = false;
            }
            dVar.setIsUserCmd(z3);
        } else {
            dVar = commReqResp;
        }
        eha eha = (eha) dVar.iLK.iLR;
        if (z) {
            eha.MhQ = getTenpayCgicmd();
        }
        if (z2) {
            eha.MhR = 1;
        }
        setCommReqResp(dVar);
    }

    public boolean canRetry() {
        return true;
    }

    @Override // com.tencent.mm.ak.q
    public int getType() {
        return 385;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public String getEncryptUrl(String str) {
        return TenpayUtil.signWith3Des(str);
    }

    static {
        for (int i2 = 0; i2 < c.KxD.length; i2++) {
            cgiFunNameVector.add(c.KxD[i2]);
        }
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public void certSignConfig() {
        String uri = this.rr.getUri();
        if (cgiFunNameVector.contains(uri)) {
            Log.d(TAG, "black cgi bye bye %s", uri);
            return;
        }
        b.hhj();
        Log.i(TAG, "cert try get errormsg %s", Integer.valueOf(b.getLastError()));
        long currentTimeMillis = System.currentTimeMillis();
        b.hhj().init(MMApplicationContext.getContext());
        eha eha = (eha) this.rr.iLK.iLR;
        String str = "";
        String str2 = "";
        if (eha.MhS != null) {
            str = new String(eha.MhS.getBufferToBytes());
        }
        if (eha.MGc != null) {
            str2 = new String(eha.MGc.getBufferToBytes());
        }
        String str3 = new String((str + "&&" + str2).getBytes());
        ad.hhv();
        String crtNo = ad.getCrtNo();
        b.hhj();
        if (b.isCertExist(crtNo)) {
            h.INSTANCE.idkeyStat(414, 20, 1, true);
            b.hhj();
            String genUserSig = b.genUserSig(crtNo, str3);
            if (Util.isNullOrNil(genUserSig)) {
                h hVar = h.INSTANCE;
                b.hhj();
                hVar.a(20743, "user_identification", "pay_cert_sign", "", "", "", "", Integer.valueOf(b.getLastError()));
            }
            h.INSTANCE.idkeyStat(414, 21, System.currentTimeMillis() - currentTimeMillis, true);
            Log.v(TAG, "sign ret src:%s sign:%s", str3, genUserSig);
            eha.sign = genUserSig;
            eha.NgK = crtNo;
        } else {
            b.hhj();
            Log.i(TAG, "cert not exist cn %s %s", crtNo, Integer.valueOf(b.getLastError()));
        }
        Log.i(TAG, "sign cost time %s cn %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), crtNo);
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public int doSceneSimulately(d dVar, g gVar, i iVar) {
        eha eha = (eha) dVar.iLK.iLR;
        if (eha.MhS != null) {
            new String(eha.MhS.getBufferToBytes());
        }
        if (eha.MGc != null) {
            new String(eha.MGc.getBufferToBytes());
        }
        MMApplicationContext.getContext();
        getPayCgicmd();
        ae.hhx();
        if (!this.isFake) {
            return -1;
        }
        ehb ehb = (ehb) dVar.iLL.iLR;
        if (ehb == null) {
            ehb = new ehb();
        }
        ehb.MhT = new SKBuiltinBuffer_t().setBuffer("".getBytes());
        ehb.MhW = getPayCgicmd();
        ehb.MhU = 0;
        try {
            JSONObject jSONObject = new JSONObject((String) null);
            ehb.MGd = jSONObject.optInt("TenpayErrType");
            ehb.MGe = jSONObject.optString("TenpayErrMsg");
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
        }
        onGYNetEnd(1, 0, 0, "", dVar, null);
        return 1;
    }

    public void setFake() {
        this.isFake = true;
    }

    @Override // com.tencent.mm.ak.q
    public int doScene(g gVar, i iVar) {
        int doSceneSimulately;
        this.callback = iVar;
        certSignConfig();
        if (this.isFake && (doSceneSimulately = doSceneSimulately(this.rr, gVar, iVar)) != -1) {
            return doSceneSimulately;
        }
        if (!z.aUo()) {
            return dispatch(gVar, this.rr, this);
        }
        Log.e(TAG, "hy: serious error: is payupay");
        iVar.onSceneEnd(1000, -100868, "Pay Method Err", this);
        return 1;
    }

    public String getUri() {
        return "/cgi-bin/micromsg-bin/tenpay";
    }

    public int getFuncId() {
        return 385;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public void putToReqText(d dVar, SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        ((eha) dVar.iLK.iLR).MhS = sKBuiltinBuffer_t;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public void putToWXReqText(d dVar, SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        ((eha) dVar.iLK.iLR).MGc = sKBuiltinBuffer_t;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public x getRetModel(d dVar) {
        ehb ehb = (ehb) dVar.iLL.iLR;
        x xVar = new x();
        xVar.MhW = ehb.MhW;
        xVar.MhV = ehb.MhV;
        xVar.MhU = ehb.MhU;
        xVar.MhT = ehb.MhT;
        xVar.rBM = ehb.MGe;
        xVar.Ruc = ehb.MGd;
        return xVar;
    }
}
