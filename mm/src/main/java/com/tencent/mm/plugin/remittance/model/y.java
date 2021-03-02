package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.wxpaysdk.api.ResendMsgInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class y extends m {
    public String AOI;
    public int AOS;
    public String AOl;
    private String CpP = null;
    public String CpQ = null;
    public int CpR;
    private String CpS;
    public String CpT;
    public int CpU;
    public String CpV;
    public String CpW;
    public int CpX;
    public a CpY;
    public c CpZ;
    public e Cqa;
    public ResendMsgInfo Cqb;
    private e Cqc;
    public ArrayList<b> Cqd;
    public String Cqe;
    public String Cqf;
    public String desc;
    public double qwJ;
    public int status;
    public boolean ylG;

    public y(int i2, String str, String str2, int i3) {
        AppMethodBeat.i(67893);
        this.CpP = str;
        this.CpQ = str2;
        this.AOS = i2;
        HashMap hashMap = new HashMap();
        hashMap.put("transfer_id", str2);
        hashMap.put("trans_id", str);
        hashMap.put("invalid_time", String.valueOf(i3));
        setRequestData(hashMap);
        AppMethodBeat.o(67893);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 0;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1628;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transferquery";
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(67894);
        Log.d("Micromsg.NetSceneTenpayRemittanceQuery", "errCode " + i2 + " errMsg: " + str);
        if (i2 != 0) {
            AppMethodBeat.o(67894);
            return;
        }
        this.CpR = jSONObject.optInt("pay_time");
        this.qwJ = jSONObject.optDouble("fee") / 100.0d;
        this.AOl = jSONObject.optString("fee_type");
        this.status = jSONObject.optInt("trans_status");
        this.CpS = jSONObject.optString("trans_status_name");
        this.CpU = jSONObject.optInt("modify_time");
        this.ylG = jSONObject.optBoolean("is_payer");
        this.AOI = jSONObject.optString("refund_bank_type");
        this.CpV = jSONObject.optString("status_desc");
        this.CpW = jSONObject.optString("status_supplementary");
        this.CpX = jSONObject.optInt("delay_confirm_flag");
        this.Cqe = jSONObject.optString("banner_content");
        this.Cqf = jSONObject.optString("banner_url");
        this.desc = jSONObject.optString("desc");
        JSONObject optJSONObject = jSONObject.optJSONObject("addr_info");
        a aVar = new a();
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        aVar.Cqg = optJSONObject.optString("address_name");
        aVar.kik = optJSONObject.optString("phone_num");
        aVar.iUO = optJSONObject.optString("address");
        this.CpY = aVar;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("exposure_info");
        c cVar = new c();
        if (optJSONObject2 == null) {
            optJSONObject2 = new JSONObject();
        }
        cVar.icon = optJSONObject2.optString("icon");
        cVar.name = optJSONObject2.optString("name");
        cVar.dQx = optJSONObject2.optString("wording");
        cVar.Cqh = optJSONObject2.optInt("is_show_btn");
        cVar.Cqi = optJSONObject2.optString("btn_wording");
        cVar.Cqj = bk(optJSONObject2.optJSONObject("jump_info"));
        this.CpZ = cVar;
        this.Cqa = bl(jSONObject.optJSONObject("text_info"));
        JSONObject optJSONObject3 = jSONObject.optJSONObject("resend_info");
        ResendMsgInfo resendMsgInfo = new ResendMsgInfo();
        if (optJSONObject3 == null) {
            optJSONObject3 = new JSONObject();
        }
        resendMsgInfo.title = optJSONObject3.optString("title");
        resendMsgInfo.JQW = optJSONObject3.optString("pic");
        resendMsgInfo.description = optJSONObject3.optString("description");
        resendMsgInfo.lHA = optJSONObject3.optString("left_button_wording");
        resendMsgInfo.lHB = optJSONObject3.optString("right_button_wording");
        this.Cqb = resendMsgInfo;
        this.Cqc = bl(jSONObject.optJSONObject("middle_info"));
        this.Cqd = F(jSONObject.optJSONArray("desc_item_list"));
        AppMethodBeat.o(67894);
    }

    public static class a {
        public String Cqg;
        public String iUO;
        public String kik;

        public final String toString() {
            AppMethodBeat.i(67889);
            String str = "AddressInfo{addressName='" + this.Cqg + '\'' + ", phoneNum='" + this.kik + '\'' + ", address='" + this.iUO + '\'' + '}';
            AppMethodBeat.o(67889);
            return str;
        }
    }

    public static class d {
        public String Cqk;
        public int type;
        public String url;
        public String username;

        public final String toString() {
            AppMethodBeat.i(67891);
            String str = "JumpInfo{type=" + this.type + ", url='" + this.url + '\'' + ", username='" + this.username + '\'' + ", pagepath='" + this.Cqk + '\'' + '}';
            AppMethodBeat.o(67891);
            return str;
        }
    }

    public static class c {
        public int Cqh;
        public String Cqi;
        public d Cqj;
        public String dQx;
        public String icon;
        public String name;

        public final String toString() {
            AppMethodBeat.i(67890);
            String str = "ExposureInfo{icon='" + this.icon + '\'' + ", name='" + this.name + '\'' + ", wording='" + this.dQx + '\'' + ", isShowBtn=" + this.Cqh + ", btnWording='" + this.Cqi + '\'' + ", jumpInfo=" + this.Cqj + '}';
            AppMethodBeat.o(67890);
            return str;
        }
    }

    public static class e {
        public d Cqj;
        public String dQx;

        public final String toString() {
            AppMethodBeat.i(67892);
            String str = "TextInfo{wording='" + this.dQx + '\'' + ", jumpInfo=" + this.Cqj + '}';
            AppMethodBeat.o(67892);
            return str;
        }
    }

    public static class b {
        public String content;
        public String title;

        public final String toString() {
            AppMethodBeat.i(213734);
            String str = "DescItem{title='" + this.title + '\'' + ", content='" + this.content + '\'' + '}';
            AppMethodBeat.o(213734);
            return str;
        }
    }

    private static d bk(JSONObject jSONObject) {
        AppMethodBeat.i(67895);
        d dVar = new d();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        dVar.type = jSONObject.optInt("type");
        dVar.url = jSONObject.optString("url");
        dVar.username = jSONObject.optString(ch.COL_USERNAME);
        dVar.Cqk = jSONObject.optString("pagepath");
        AppMethodBeat.o(67895);
        return dVar;
    }

    private static e bl(JSONObject jSONObject) {
        AppMethodBeat.i(67896);
        e eVar = new e();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        eVar.dQx = jSONObject.optString("wording");
        eVar.Cqj = bk(jSONObject.optJSONObject("jump_info"));
        AppMethodBeat.o(67896);
        return eVar;
    }

    private static ArrayList<b> F(JSONArray jSONArray) {
        AppMethodBeat.i(213735);
        if (jSONArray == null) {
            jSONArray = new JSONArray();
        }
        Log.i("Micromsg.NetSceneTenpayRemittanceQuery", "parseDescItemList res：%s", jSONArray.toString());
        ArrayList<b> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                if (jSONObject != null) {
                    b bVar = new b();
                    bVar.title = jSONObject.optString("key");
                    bVar.content = jSONObject.optString("value");
                    arrayList.add(bVar);
                }
            } catch (JSONException e2) {
                Log.i("Micromsg.NetSceneTenpayRemittanceQuery", "parseDescItemList error：%s", e2.getMessage());
            }
        }
        AppMethodBeat.o(213735);
        return arrayList;
    }
}
