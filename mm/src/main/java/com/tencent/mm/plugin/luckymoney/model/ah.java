package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cby;
import com.tencent.mm.protocal.protobuf.cbz;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.c.w;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

public abstract class ah extends w {
    private i callback;
    public m jumpRemind;
    d rr;
    public a yWK;

    public interface a {
        int a(d dVar, com.tencent.mm.network.m mVar);
    }

    public abstract String czD();

    public abstract void onGYNetEnd(int i2, String str, JSONObject jSONObject);

    public final void setRequestData(Map<String, String> map) {
        String aTY = z.aTY();
        g.aAi();
        as Kn = ((l) g.af(l.class)).aSN().Kn(aTY);
        if (Kn != null) {
            map.put("province", Kn.gBR());
            map.put("city", Kn.getCityCode());
        }
        if (this.rr == null) {
            d.a aVar = new d.a();
            aVar.iLN = new cby();
            aVar.iLO = new cbz();
            aVar.uri = czD();
            aVar.funcId = getType();
            aVar.iLP = 0;
            aVar.respCmdId = 0;
            this.rr = aVar.aXF();
            this.rr.setIsUserCmd(true);
        }
        cby cby = (cby) this.rr.iLK.iLR;
        cby.MhQ = czE();
        cby.MhR = 1;
        Object[] array = map.keySet().toArray();
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (Object obj : array) {
            String str = map.get(obj);
            if (!Util.isNullOrNil(str)) {
                if (z) {
                    sb.append("&");
                }
                sb.append(obj);
                sb.append("=");
                sb.append(str);
                z = true;
            }
        }
        Log.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + cby.MhQ + ", req = " + sb.toString());
        cby.MhS = new SKBuiltinBuffer_t().setBuffer(sb.toString().getBytes());
    }

    @Override // com.tencent.mm.wallet_core.c.w
    public void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr, long j2) {
        int i5;
        Log.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + czE() + ", errType = " + i3 + ", errCode = " + i4 + ", errMsg = " + str);
        cbz cbz = (cbz) ((d) sVar).iLL.iLR;
        if (i3 == 0 && i4 == 0) {
            int i6 = cbz.MhU;
            String b2 = com.tencent.mm.platformtools.z.b(cbz.MhT);
            if (i6 != 0 || Util.isNullOrNil(b2)) {
                i3 = 1000;
                i4 = 2;
                str = cbz.MhV;
            } else {
                int i7 = cbz.dGe;
                try {
                    JSONObject jSONObject = new JSONObject(b2);
                    int i8 = jSONObject.getInt("retcode");
                    String str2 = cbz.errorMsg;
                    if (Util.isNullOrNil(str2)) {
                        str2 = jSONObject.optString("retmsg");
                    }
                    this.jumpRemind = m.cj(jSONObject);
                    if (jSONObject.has("showmess") && i8 != 268502454) {
                        Log.i("MicroMsg.NetSceneLuckyMoneyBase", "has alert item");
                        com.tencent.mm.plugin.wallet_core.model.a a2 = ba.a(null, jSONObject);
                        ut utVar = new ut();
                        utVar.eba.ebb = a2;
                        EventCenter.instance.publish(utVar);
                        Log.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + czE() + ", tenpayErrType : " + i7 + ", resp = " + b2);
                    } else if (i8 == 0 && i7 == 0) {
                        onGYNetEnd(i8, str2, jSONObject);
                        Log.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + czE() + ", tenpayErrType : " + i7 + ", resp = " + b2);
                    } else {
                        i3 = 1000;
                        if (i7 == 0) {
                            i5 = -1000;
                        } else {
                            i5 = i7;
                        }
                        str = str2;
                        i4 = i5;
                        Log.i("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + czE() + ", tenpayErrType : " + i7 + ", resp = " + b2);
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.NetSceneLuckyMoneyBase", e2, "", new Object[0]);
                    i3 = 1000;
                    i4 = 2;
                    str = MMApplicationContext.getContext().getString(R.string.ibn);
                }
            }
        } else {
            Map<String, String> parseXml = XmlParser.parseXml(str, "e", null);
            if (parseXml != null) {
                Log.d("MicroMsg.NetSceneLuckyMoneyBase", "CDN error!");
                str = parseXml.get(".e.Content");
            } else {
                str = MMApplicationContext.getContext().getString(R.string.ibn);
            }
        }
        if (i3 != 0) {
            Log.e("MicroMsg.NetSceneLuckyMoneyBase", "Cmd : " + czE() + ", errType = " + i3 + ", errCode = " + i4 + ", errMsg = " + str);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
    }

    public final boolean isJumpRemind() {
        if (this.jumpRemind == null) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mm.ak.q
    public int doScene(com.tencent.mm.network.g gVar, i iVar) {
        this.callback = iVar;
        if (this.yWK == null) {
            return dispatch(gVar, this.rr, this);
        }
        Log.i("MicroMsg.NetSceneLuckyMoneyBase", "do fack response: %s", czD());
        return this.yWK.a(this.rr, this);
    }

    public int czE() {
        return -1;
    }

    @Override // com.tencent.mm.wallet_core.c.w
    public int getCgicmdForKV() {
        return czE();
    }
}
