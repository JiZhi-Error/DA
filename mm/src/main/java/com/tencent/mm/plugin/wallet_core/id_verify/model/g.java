package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.eha;
import com.tencent.mm.protocal.protobuf.ehb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.c.x;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.HashMap;
import org.json.JSONObject;

public final class g extends s {
    public u HPz;
    public boolean HTF;
    public boolean HTG;
    public boolean HTH;
    public String HTI;
    public String HTJ;
    public String dNQ;
    public String dYK;
    public long igp;
    public String packageExt;
    public String token;

    public g(String str, String str2, int i2) {
        AppMethodBeat.i(70145);
        HashMap hashMap = new HashMap();
        hashMap.put("flag", "1");
        hashMap.put("true_name", str);
        hashMap.put("identify_card", str2);
        hashMap.put("cre_type", "1");
        hashMap.put("realname_scene", String.valueOf(i2));
        Log.i("MicroMsg.NetSceneRealNameVerify", "realname_scene=%d", Integer.valueOf(i2));
        setRequestData(hashMap);
        AppMethodBeat.o(70145);
    }

    public g(String str, String str2, int i2, int i3, Profession profession, String str3, String str4, String str5, String str6, long j2, String str7, String str8, String str9) {
        AppMethodBeat.i(70146);
        HashMap hashMap = new HashMap();
        hashMap.put("flag", "1");
        hashMap.put("true_name", str);
        hashMap.put("identify_card", str2);
        hashMap.put("realname_scene", String.valueOf(i2));
        hashMap.put("cre_type", String.valueOf(i3));
        if (profession != null) {
            hashMap.put("profession_name", profession.HTX);
            hashMap.put("profession_type", String.valueOf(profession.HTY));
        }
        hashMap.put("user_country", str3);
        hashMap.put("user_province", str4);
        hashMap.put("user_city", str5);
        hashMap.put("cre_expire_date", str6);
        hashMap.put("creid_renewal", String.valueOf(j2));
        hashMap.put("birth_date", str7);
        hashMap.put("nationality", str8);
        hashMap.put("session_id", str9);
        Log.i("MicroMsg.NetSceneRealNameVerify", "realname_scene=%d", Integer.valueOf(i2));
        setRequestData(hashMap);
        AppMethodBeat.o(70146);
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final int getPayCgicmd() {
        return 0;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(70147);
        if (i2 == 0) {
            this.token = jSONObject.optString("token");
            this.HTF = jSONObject.optBoolean("is_need_bind");
            this.HTG = jSONObject.optBoolean("is_need_face");
            this.HTH = jSONObject.optBoolean("is_need_Laund");
            this.HTI = jSONObject.optString("laundh5");
            this.igp = jSONObject.optLong("scene");
            this.packageExt = jSONObject.optString("package", "");
            this.dYK = jSONObject.optString("packagesign", "");
            this.HTJ = jSONObject.optString("addbankword");
            this.dNQ = this.token;
            this.HPz = u.bM(jSONObject);
        }
        AppMethodBeat.o(70147);
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void configRequest(boolean z, boolean z2) {
        AppMethodBeat.i(70148);
        d commReqResp = getCommReqResp();
        if (commReqResp == null) {
            d.a aVar = new d.a();
            aVar.iLN = new eha();
            aVar.iLO = new ehb();
            aVar.uri = "/cgi-bin/mmpay-bin/tenpay/realnameauthen";
            aVar.funcId = 1616;
            aVar.iLP = 185;
            aVar.respCmdId = 1000000185;
            commReqResp = aVar.aXF();
            commReqResp.setIsUserCmd(true);
        }
        eha eha = (eha) commReqResp.iLK.iLR;
        if (z2) {
            eha.MhR = 1;
        }
        setCommReqResp(commReqResp);
        AppMethodBeat.o(70148);
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final String getEncryptUrl(String str) {
        AppMethodBeat.i(70149);
        String signWith3Des = TenpayUtil.signWith3Des(str);
        AppMethodBeat.o(70149);
        return signWith3Des;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1616;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(70152);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(70152);
        return dispatch;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void putToReqText(d dVar, SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        ((eha) dVar.iLK.iLR).MhS = sKBuiltinBuffer_t;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void putToWXReqText(d dVar, SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        ((eha) dVar.iLK.iLR).MGc = sKBuiltinBuffer_t;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final x getRetModel(d dVar) {
        AppMethodBeat.i(70150);
        ehb ehb = (ehb) dVar.iLL.iLR;
        x xVar = new x();
        xVar.MhW = ehb.MhW;
        xVar.MhV = ehb.MhV;
        xVar.MhU = ehb.MhU;
        xVar.MhT = ehb.MhT;
        xVar.rBM = ehb.MGe;
        xVar.Ruc = ehb.MGd;
        AppMethodBeat.o(70150);
        return xVar;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final int doSceneSimulately(d dVar, com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(70151);
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
        AppMethodBeat.o(70151);
        return -1;
    }
}
