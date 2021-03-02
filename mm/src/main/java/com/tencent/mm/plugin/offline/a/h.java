package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.eha;
import com.tencent.mm.protocal.protobuf.ehb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

public abstract class h extends q implements m {
    private i callback;
    private d rr;

    public abstract int getTenpayCgicmd();

    public abstract void onGYNetEnd(int i2, String str, JSONObject jSONObject);

    public final void setRequestData(Map<String, String> map) {
        boolean z;
        int i2 = 0;
        if (!e.gsQ()) {
            map.put("jsapi_reqkey", e.gsR());
        }
        if (this.rr == null) {
            d.a aVar = new d.a();
            aVar.iLN = new eha();
            aVar.iLO = new ehb();
            String uri = getUri();
            int funcId = getFuncId();
            aVar.uri = uri;
            aVar.funcId = funcId;
            aVar.iLP = 185;
            aVar.respCmdId = 1000000185;
            this.rr = aVar.aXF();
        }
        eha eha = (eha) this.rr.iLK.iLR;
        eha.MhQ = getTenpayCgicmd();
        eha.MhR = 1;
        Object[] array = map.keySet().toArray();
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        boolean z2 = false;
        for (Object obj : array) {
            String str = map.get(obj);
            if (!Util.isNullOrNil(str)) {
                if (z2) {
                    sb.append("&");
                }
                sb.append(obj);
                sb.append("=");
                sb.append(str);
                z2 = true;
            }
        }
        String signWith3Des = TenpayUtil.signWith3Des(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        boolean z3 = false;
        while (i2 < array.length) {
            Object obj2 = array[i2];
            String str2 = map.get(obj2);
            if (!Util.isNullOrNil(str2)) {
                if (z3) {
                    sb2.append("&");
                }
                sb2.append(obj2);
                sb2.append("=");
                sb2.append(com.tencent.mm.compatible.util.q.encode(str2));
                z = true;
            } else {
                z = z3;
            }
            i2++;
            z3 = z;
        }
        sb2.append(z3 ? "&" : "");
        sb2.append("WCPaySign");
        sb2.append("=");
        sb2.append(signWith3Des);
        eha.MhS = new SKBuiltinBuffer_t().setBuffer(sb2.toString().getBytes());
    }

    @Override // com.tencent.mm.ak.q
    public int getType() {
        return 385;
    }

    @Override // com.tencent.mm.ak.q
    public int doScene(g gVar, i iVar) {
        this.callback = iVar;
        return dispatch(gVar, this.rr, this);
    }

    @Override // com.tencent.mm.network.m
    public void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        Log.i("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + getTenpayCgicmd() + ", errType = " + i3 + ", errCode = " + i4 + ", errMsg = " + str);
        ehb ehb = (ehb) ((d) sVar).iLL.iLR;
        if (i3 != 0 || i4 != 0) {
            Map<String, String> parseXml = XmlParser.parseXml(str, "e", null);
            if (parseXml != null) {
                Log.d("MicroMsg.NetSceneTenpayOfflineBase", "CDN error!");
                str = parseXml.get(".e.Content");
            }
        } else if (ehb.MhU == 0) {
            try {
                JSONObject jSONObject = new JSONObject(z.b(ehb.MhT));
                int i5 = jSONObject.getInt("retcode");
                String str2 = ehb.MGe;
                if (Util.isNullOrNil(str2)) {
                    str2 = jSONObject.optString("retmsg");
                }
                int i6 = ehb.MGd;
                if (i5 == 0 && i6 == 0) {
                    onGYNetEnd(i5, str2, jSONObject);
                } else {
                    Log.i("MicroMsg.NetSceneTenpayOfflineBase", "ErrCode tenpayErrType : ".concat(String.valueOf(i6)));
                    if (i6 == 0) {
                        i4 = -1000;
                    } else {
                        i4 = i6;
                    }
                    Log.d("MicroMsg.NetSceneTenpayOfflineBase", "ErrCode errMsg : ".concat(String.valueOf(str2)));
                    str = str2;
                    i3 = 1000;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.NetSceneTenpayOfflineBase", e2, "", new Object[0]);
                str = MMApplicationContext.getContext().getString(R.string.ibn);
                i4 = 2;
                i3 = 1000;
            }
        } else {
            str = ehb.MhV;
            i4 = 2;
            i3 = 1000;
        }
        if (i3 != 0) {
            Log.e("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + getTenpayCgicmd() + ", errType = " + i3 + ", errCode = " + i4 + ", errMsg = " + str);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        Log.d("MicroMsg.NetSceneTenpayOfflineBase", "Cmd : " + getTenpayCgicmd() + ", errType = " + i3 + ", errCode = " + i4 + ", errMsg = " + str);
    }

    public String getUri() {
        return "/cgi-bin/micromsg-bin/tenpay";
    }

    public int getFuncId() {
        return 385;
    }
}
