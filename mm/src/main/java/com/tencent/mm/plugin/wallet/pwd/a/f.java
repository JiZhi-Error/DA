package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bog;
import com.tencent.mm.protocal.protobuf.boh;
import com.tencent.mm.protocal.protobuf.cbg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f extends q implements m {
    private boh HHV;
    private a HHW;
    private i callback;
    private final d rr;

    public f() {
        AppMethodBeat.i(69534);
        d.a aVar = new d.a();
        aVar.iLN = new bog();
        aVar.iLO = new boh();
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/gethbrefundconfig";
        aVar.funcId = 1477;
        this.rr = aVar.aXF();
        AppMethodBeat.o(69534);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1477;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(69535);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(69535);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(69536);
        Log.w("MicroMsg.NetSceneGetHbRefundConfig", "errType = %s errCode = %s errMsg = %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            this.HHV = (boh) ((d) sVar).iLL.iLR;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(69536);
    }

    public final a fOM() {
        AppMethodBeat.i(69537);
        if (this.HHW == null) {
            this.HHW = new a();
            this.HHW.dDN = this.HHV.dDN;
            this.HHW.HHX = this.HHV.HHX;
            this.HHW.HHY = this.HHV.HHY;
            this.HHW.HHZ = this.HHV.HHZ;
            this.HHW.HIa = this.HHV.HIa;
            this.HHW.HIb = this.HHV.HIb;
            this.HHW.HIc = this.HHV.HIc;
            this.HHW.HId = this.HHV.HId;
            this.HHW.HIe = this.HHV.HIe;
            this.HHW.HIg = this.HHV.HIg;
            this.HHW.HIf = new ArrayList<>();
            Iterator<cbg> it = this.HHV.LWw.iterator();
            while (it.hasNext()) {
                cbg next = it.next();
                this.HHW.HIf.add(new b(next.title, next.desc, next.ivw, next.HIh));
            }
        }
        a aVar = this.HHW;
        AppMethodBeat.o(69537);
        return aVar;
    }

    public static class a {
        public String HHX;
        public boolean HHY;
        public String HHZ;
        public String HIa;
        public String HIb;
        public String HIc;
        public String HId;
        public String HIe;
        public ArrayList<b> HIf = new ArrayList<>();
        public boolean HIg;
        public int dDN;

        public a() {
            AppMethodBeat.i(69528);
            AppMethodBeat.o(69528);
        }

        public final String toString() {
            AppMethodBeat.i(69529);
            String str = "HbRefundConfig{retcode=" + this.dDN + ", entrance_name='" + this.HHX + '\'' + ", reddot=" + this.HHY + ", refund_lingqian_title='" + this.HHZ + '\'' + ", refund_lingqian_desc='" + this.HIa + '\'' + ", refund_origin_title='" + this.HIb + '\'' + ", refund_origin_desc='" + this.HIc + '\'' + ", top_tip='" + this.HId + '\'' + ", refund_time_title='" + this.HIe + '\'' + ", refund_time=" + this.HIf + ", disabled=" + this.HIg + '}';
            AppMethodBeat.o(69529);
            return str;
        }

        public final String fON() {
            AppMethodBeat.i(69530);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("retcode", this.dDN);
                jSONObject.put("disabled", this.HIg);
                jSONObject.put("entrance_name", this.HHX);
                jSONObject.put("reddot", this.HHY);
                jSONObject.put("refund_lingqian_title", this.HHZ);
                jSONObject.put("refund_lingqian_desc", this.HIa);
                jSONObject.put("refund_origin_title", this.HIb);
                jSONObject.put("refund_origin_desc", this.HIc);
                jSONObject.put("top_tip", this.HId);
                jSONObject.put("refund_time_title", this.HIe);
                JSONArray jSONArray = new JSONArray();
                Iterator<b> it = this.HIf.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().getJSONObject());
                }
                jSONObject.put("refund_time", jSONArray);
                String jSONObject2 = jSONObject.toString();
                AppMethodBeat.o(69530);
                return jSONObject2;
            } catch (JSONException e2) {
                Log.e("MicroMsg.NetSceneGetHbRefundConfig", "HbRefundConfig getJSONObjectString() Exception: %s", e2.getMessage());
                AppMethodBeat.o(69530);
                return "";
            }
        }

        public static a aUZ(String str) {
            AppMethodBeat.i(69531);
            a aVar = new a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                aVar.dDN = jSONObject.optInt("retcode");
                aVar.HIg = jSONObject.optBoolean("disabled");
                aVar.HHX = jSONObject.optString("entrance_name");
                aVar.HHY = jSONObject.optBoolean("reddot");
                aVar.HHZ = jSONObject.optString("refund_lingqian_title");
                aVar.HIa = jSONObject.optString("refund_lingqian_desc");
                aVar.HIb = jSONObject.optString("refund_origin_title");
                aVar.HIc = jSONObject.optString("refund_origin_desc");
                aVar.HId = jSONObject.optString("top_tip");
                aVar.HIe = jSONObject.optString("refund_time_title");
                JSONArray optJSONArray = jSONObject.optJSONArray("refund_time");
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    ArrayList<b> arrayList = aVar.HIf;
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    b bVar = new b();
                    bVar.title = jSONObject2.optString("title");
                    bVar.desc = jSONObject2.optString("desc");
                    bVar.ivw = jSONObject2.optString("iconurl");
                    bVar.HIh = jSONObject2.optString("iconmd5");
                    arrayList.add(bVar);
                }
            } catch (JSONException e2) {
                Log.e("MicroMsg.NetSceneGetHbRefundConfig", "doGetHbRefundConfig() Exception:%s", e2.getMessage());
            }
            AppMethodBeat.o(69531);
            return aVar;
        }
    }

    public static class b {
        public String HIh;
        public String desc;
        public String ivw;
        public String title;

        public b() {
        }

        public b(String str, String str2, String str3, String str4) {
            this.title = str;
            this.desc = str2;
            this.ivw = str3;
            this.HIh = str4;
        }

        public final String toString() {
            AppMethodBeat.i(69532);
            String str = "HbRefundTimeParcelable{title='" + this.title + '\'' + ", desc='" + this.desc + '\'' + ", iconurl='" + this.ivw + '\'' + ", iconmd5='" + this.HIh + '\'' + '}';
            AppMethodBeat.o(69532);
            return str;
        }

        public final JSONObject getJSONObject() {
            AppMethodBeat.i(69533);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("title", this.title);
                jSONObject.put("desc", this.desc);
                jSONObject.put("iconurl", this.ivw);
                jSONObject.put("iconmd5", this.HIh);
            } catch (JSONException e2) {
                Log.e("MicroMsg.NetSceneGetHbRefundConfig", "HbRefundTimeParcelable getJSONObjectString() Exception: %s", e2.getMessage());
            }
            AppMethodBeat.o(69533);
            return jSONObject;
        }
    }
}
