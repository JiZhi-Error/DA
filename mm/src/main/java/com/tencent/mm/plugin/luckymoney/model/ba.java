package com.tencent.mm.plugin.luckymoney.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.protocal.protobuf.cbz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public class ba extends av {
    public a ebb;
    public String lHA;
    public String lHB;
    public int qwe;
    public String wFL;
    public String yQE;
    public String yXH;
    public String yXI;
    public String yXJ;
    public String yXK;
    public String yXL;
    public int yXM;

    public ba() {
        this.lHA = "";
        this.lHB = "";
        this.yXK = "";
    }

    public ba(int i2, long j2, long j3, int i3, String str, String str2, String str3, String str4, String str5, String str6, int i4, String str7) {
        this(i2, j2, j3, i3, str, str2, str3, str4, str5, str6, i4, str7, "", 0, 0, "", "", 0, "");
    }

    public ba(int i2, long j2, long j3, int i3, String str, String str2, String str3, String str4, String str5, String str6, int i4, String str7, String str8, int i5, int i6, String str9, String str10, int i7, String str11) {
        AppMethodBeat.i(213327);
        this.lHA = "";
        this.lHB = "";
        this.yXK = "";
        Log.i("MicroMsg.NetScenePrepareLuckyMoney", "NetScenePrepareLuckyMoney() uniqueId:%s, userConfiremJump:%s, unpayType:%s, cancelSendId:%s", str8, Integer.valueOf(i5), Integer.valueOf(i6), Util.nullAsNil(str9));
        this.qwe = i2;
        HashMap hashMap = new HashMap();
        if (i3 == 3) {
            hashMap.put("totalNum", "1");
        } else {
            hashMap.put("totalNum", String.valueOf(i2));
        }
        hashMap.put("totalAmount", String.valueOf(j2));
        hashMap.put("perValue", String.valueOf(j3));
        hashMap.put("hbType", String.valueOf(i3));
        hashMap.put("wishing", URLEncoder.encode(Util.nullAsNil(str)));
        hashMap.put("sendUserName", str5);
        if (!Util.isNullOrNil(str8)) {
            hashMap.put("unique_id", str8);
        }
        hashMap.put("user_confirm_jump", String.valueOf(i5));
        hashMap.put("unpay_type", String.valueOf(i6));
        hashMap.put("cancel_sendid", str9);
        hashMap.put("expression_md5", str10);
        hashMap.put("expression_type", String.valueOf(i7));
        if (!Util.isNullOrNil(str3)) {
            hashMap.put(ch.COL_USERNAME, str3);
        }
        if (!Util.isNullOrNil(str2)) {
            hashMap.put("headImg", URLEncoder.encode(str2));
            hashMap.put("nickName", URLEncoder.encode(Util.nullAsNil(str6)));
            if (!Util.isNullOrNil(str4)) {
                hashMap.put("receiveNickName", URLEncoder.encode(str4));
            }
        }
        hashMap.put("inWay", String.valueOf(i4));
        if (i4 == 0 || i4 == 1 || i4 == 7) {
            hashMap.put("needSendToMySelf", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        hashMap.put("showSourceMac", URLEncoder.encode(str7));
        hashMap.put("exclusiveRecvUsername", str11);
        setRequestData(hashMap);
        AppMethodBeat.o(213327);
    }

    @Override // com.tencent.mm.ak.q
    public int getType() {
        return 1575;
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ah, com.tencent.mm.plugin.luckymoney.model.av
    public String czD() {
        return "/cgi-bin/mmpay-bin/requestwxhb";
    }

    @Override // com.tencent.mm.plugin.luckymoney.model.ah
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(65304);
        Log.i("MicroMsg.NetScenePrepareLuckyMoney", "errCode: %s, errMsg: %s ，json：%s", Integer.valueOf(i2), str, jSONObject.toString());
        this.yQE = jSONObject.optString("sendId");
        this.wFL = jSONObject.optString("reqkey");
        this.yXH = jSONObject.optString("sendMsgXml");
        this.yXI = jSONObject.optString("guide_flag", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.yXJ = jSONObject.optString("guide_wording");
        this.lHA = jSONObject.optString("left_button_wording", "");
        this.lHB = jSONObject.optString("right_button_wording", "");
        this.yXK = jSONObject.optString("upload_credit_url", "");
        this.yXL = jSONObject.optString("id_sign", "");
        if (jSONObject.has("showmess")) {
            Log.i("MicroMsg.NetScenePrepareLuckyMoney", "has alert item");
            this.ebb = a(this, jSONObject);
        }
        AppMethodBeat.o(65304);
    }

    public static a a(ba baVar, JSONObject jSONObject) {
        AppMethodBeat.i(65305);
        a aVar = new a();
        aVar.dQx = jSONObject.optString("retmsg");
        JSONObject optJSONObject = jSONObject.optJSONObject("showmess");
        aVar.lHA = optJSONObject.optString("left_button_wording");
        aVar.lHB = optJSONObject.optString("right_button_wording");
        aVar.qwt = optJSONObject.optString("right_button_url");
        if (baVar != null) {
            baVar.yXM = jSONObject.optInt("return_to_session", 0);
        }
        AppMethodBeat.o(65305);
        return aVar;
    }

    public static boolean l(q qVar) {
        AppMethodBeat.i(65306);
        try {
            JSONObject jSONObject = new JSONObject(z.b(((cbz) ((d) qVar.getReqResp()).iLL.iLR).MhT));
            if (jSONObject.has("showmess") && Util.isEqual(jSONObject.optJSONObject("showmess").optInt("return_to_session", 0), 1)) {
                AppMethodBeat.o(65306);
                return true;
            }
        } catch (Exception e2) {
            Log.i("MicroMsg.NetScenePrepareLuckyMoney", "ifReturnByReturnToSession() Exception：%s", e2.getMessage());
        }
        AppMethodBeat.o(65306);
        return false;
    }
}
