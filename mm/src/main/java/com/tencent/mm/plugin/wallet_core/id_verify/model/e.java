package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.t.a.c;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.btq;
import com.tencent.mm.protocal.protobuf.btr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class e extends q implements m {
    public boolean HPI = false;
    private long HTD = 10;
    public btr HTE;
    private i callback;
    public com.tencent.mm.wallet_core.c.m jumpRemind;
    private d rr;

    public e(String str) {
        AppMethodBeat.i(70140);
        Log.i("MicroMsg.NetSceneGetRealnameWording", "NetSceneGetRealnameWording call: %s", str);
        d.a aVar = new d.a();
        btq btq = new btq();
        btq.Lcc = k.fQy();
        btq.session_id = str;
        if (!com.tencent.mm.pluginsdk.wallet.e.gsQ()) {
            btq.LhT = com.tencent.mm.pluginsdk.wallet.e.gsR();
        }
        aVar.iLN = btq;
        aVar.iLO = new btr();
        aVar.uri = "/cgi-bin/mmpay-bin/getrealnamewording";
        aVar.funcId = getType();
        this.rr = aVar.aXF();
        this.rr.setIsUserCmd(true);
        AppMethodBeat.o(70140);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1666;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(70141);
        this.callback = iVar;
        c.eBv().sC(false);
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(70141);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        long j2;
        AppMethodBeat.i(70142);
        Log.i("MicroMsg.NetSceneGetRealnameWording", "onGYNetEnd,errType=" + i3 + "errCode=" + i4);
        if (i3 == 0 && i4 == 0) {
            btr btr = (btr) ((d) sVar).iLL.iLR;
            this.HTE = btr;
            if (btr.Mam <= 0) {
                j2 = this.HTD;
            } else {
                j2 = btr.Mam;
            }
            this.HPI = btr.HPI;
            Log.i("MicroMsg.NetSceneGetRealnameWording", "need_agree_duty %s", Boolean.valueOf(this.HPI));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("bindcardTitle", btr.Maf);
                jSONObject.put("bindcardSubTitle", btr.Mag);
                jSONObject.put("bindIdTitle", btr.Mah);
                jSONObject.put("bindIdSubTitle", btr.Mai);
                jSONObject.put("extral_wording", btr.Maj);
                jSONObject.put("question_answer_switch", btr.Mak);
                jSONObject.put("question_answer_url", btr.Mal);
                jSONObject.put("cache_time", j2);
                jSONObject.put(AppMeasurement.Param.TIMESTAMP, Long.valueOf(System.currentTimeMillis() / 1000));
                jSONObject.put("isShowBindCard", btr.Man);
                jSONObject.put("isShowBindCardVerify", btr.Map);
                jSONObject.put("isShowBindId", btr.Mao);
                jSONObject.put("bindCardVerifyTitle", btr.Maq);
                jSONObject.put("bindCardVerifySubtitle", btr.Mar);
                jSONObject.put("bindCardVerifyAlertViewRightBtnTxt", btr.Mas);
                jSONObject.put("bindCardVerifyAlertViewContent", btr.Mat);
                jSONObject.put("isShowBindCardVerifyAlertView", btr.Mau);
                if (btr.Mav != null && btr.Mav.size() > 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    boolean z = false;
                    Iterator<String> it = btr.Mav.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (z) {
                            stringBuffer.append("\n");
                        }
                        stringBuffer.append(next);
                        z = true;
                    }
                    jSONObject.put("cache_header_titles", stringBuffer.toString());
                }
                jSONObject.put("isShowCapitalSecurity", btr.Max);
                com.tencent.mm.kernel.g.aAi();
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_REALNAME_SWITCH_WORDING_STRING_SYNC, jSONObject.toString());
                this.jumpRemind = com.tencent.mm.wallet_core.c.m.a(btr.Maw);
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.NetSceneGetRealnameWording", e2, "", new Object[0]);
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(70142);
    }
}
