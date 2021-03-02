package com.tencent.mm.wallet_core.b.a;

import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cby;
import com.tencent.mm.protocal.protobuf.cbz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.wallet_core.c.w;
import java.util.Arrays;
import java.util.Map;
import org.json.JSONObject;

public abstract class a extends w {
    private i callback;
    private d rr;

    public abstract String czD();

    public abstract int czE();

    public abstract void onGYNetEnd(int i2, String str, JSONObject jSONObject);

    public final void setRequestData(Map<String, String> map) {
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
        Log.i("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + cby.MhQ + ", req = " + sb.toString());
        cby.MhS = new SKBuiltinBuffer_t().setBuffer(sb.toString().getBytes());
    }

    @Override // com.tencent.mm.wallet_core.c.w
    public void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr, long j2) {
        int i5;
        Log.i("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + czE() + ", errType = " + i3 + ", errCode = " + i4 + ", errMsg = " + str + " " + getType());
        cbz cbz = (cbz) ((d) sVar).iLL.iLR;
        if (i3 == 0 && i4 == 0) {
            int i6 = cbz.MhU;
            String b2 = z.b(cbz.MhT);
            if (i6 != 0 || Util.isNullOrNil(b2)) {
                i3 = 1000;
                i4 = 2;
                str = cbz.MhV;
            } else {
                int i7 = cbz.dGe;
                try {
                    JSONObject jSONObject = new JSONObject(b2);
                    int i8 = jSONObject.getInt("retcode");
                    String optString = jSONObject.optString("retmsg");
                    if (Util.isNullOrNil(optString)) {
                        optString = cbz.errorMsg;
                    }
                    if (!(i8 == 0 && i7 == 0) && !czF()) {
                        i3 = 1000;
                        if (i7 == 0) {
                            i5 = -1000;
                        } else {
                            i5 = i7;
                        }
                        str = optString;
                        i4 = i5;
                    } else {
                        onGYNetEnd(i8, optString, jSONObject);
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MiroMsg.NetSceneTenpayH5TransferBase", e2, "", new Object[0]);
                    i3 = 1000;
                    i4 = 2;
                }
            }
        } else {
            Map<String, String> parseXml = XmlParser.parseXml(str, "e", null);
            if (parseXml != null) {
                Log.d("MiroMsg.NetSceneTenpayH5TransferBase", "CDN error!");
                str = parseXml.get(".e.Content");
            }
            str = MMApplicationContext.getContext().getString(R.string.ibn);
        }
        if (i3 != 0) {
            Log.e("MiroMsg.NetSceneTenpayH5TransferBase", "Cmd : " + czE() + ", errType = " + i3 + ", errCode = " + i4 + ", errMsg = " + str);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
    }

    @Override // com.tencent.mm.ak.q
    public int doScene(g gVar, i iVar) {
        this.callback = iVar;
        return dispatch(gVar, this.rr, this);
    }

    public boolean czF() {
        return false;
    }
}
