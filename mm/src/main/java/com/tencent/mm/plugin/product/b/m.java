package com.tencent.mm.plugin.product.b;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.product.c.a;
import com.tencent.mm.plugin.product.c.c;
import com.tencent.mm.plugin.product.c.e;
import com.tencent.mm.plugin.product.c.f;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.j;
import com.tencent.mm.plugin.product.c.k;
import com.tencent.mm.plugin.product.c.l;
import com.tencent.mm.plugin.product.c.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class m {
    public int AZA = Integer.MAX_VALUE;
    public c AZB;
    public n AZC;
    public LinkedList<l> AZD = new LinkedList<>();
    public f AZE;
    public String AZF;
    public String AZG;
    public String AZx;
    public int AZy;
    public int AZz = Integer.MAX_VALUE;
    public String eby;
    public int status = 6;

    public m() {
        AppMethodBeat.i(66909);
        AppMethodBeat.o(66909);
    }

    public static m a(m mVar, String str) {
        m mVar2;
        AppMethodBeat.i(66910);
        if (mVar == null) {
            mVar2 = new m();
        } else {
            mVar2 = mVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            mVar2.AZx = jSONObject.getString("product_id");
            mVar2.AZy = jSONObject.getInt("product_type");
            mVar2.AZz = jSONObject.optInt(FirebaseAnalytics.b.QUANTITY, Integer.MAX_VALUE);
            mVar2.AZA = jSONObject.optInt("left_buy_quantity", Integer.MAX_VALUE);
            mVar2.status = jSONObject.optInt("status", 6);
            JSONObject optJSONObject = jSONObject.optJSONObject("ext_attr");
            if (optJSONObject != null) {
                mVar2.AZE = new f();
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("product_ext");
                if (optJSONObject2 != null) {
                    f fVar = mVar2.AZE;
                    j jVar = new j();
                    jVar.cSx = optJSONObject2.getInt("flag");
                    fVar.AZY = jVar;
                } else {
                    mVar2.AZE.AZZ = jSONObject.optString("ext_attr");
                }
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("base_attr");
            if (optJSONObject3 != null) {
                mVar2.AZB = new c();
                mVar2.AZB.name = optJSONObject3.getString("name");
                mVar2.AZB.AZL = optJSONObject3.getInt("ori_price");
                mVar2.AZB.AZM = optJSONObject3.getInt("up_price");
                mVar2.AZB.AZN = optJSONObject3.getInt("low_price");
                mVar2.AZB.AZO = new LinkedList<>();
                JSONArray jSONArray = optJSONObject3.getJSONArray("img_info");
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    String string = jSONArray.getString(i2);
                    if (!Util.isNullOrNil(string)) {
                        mVar2.AZB.AZO.add(string);
                    }
                }
                mVar2.AZB.iAq = optJSONObject3.getString("digest");
                mVar2.AZB.AOl = optJSONObject3.getString("fee_type");
                mVar2.AZB.detail = optJSONObject3.getString("detail");
                JSONObject optJSONObject4 = optJSONObject3.optJSONObject("share_info");
                if (optJSONObject4 != null) {
                    mVar2.AZB.AZW = new k();
                    mVar2.AZB.AZW.qGB = optJSONObject4.optString("icon_url");
                    mVar2.AZB.AZW.url = optJSONObject4.optString("url");
                }
                JSONArray optJSONArray = optJSONObject3.optJSONArray("sku_table");
                if (optJSONArray != null) {
                    mVar2.AZB.AZU = new LinkedList<>();
                    int length2 = optJSONArray.length();
                    for (int i3 = 0; i3 < length2; i3++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                        com.tencent.mm.plugin.product.c.m mVar3 = new com.tencent.mm.plugin.product.c.m();
                        mVar3.Bae = jSONObject2.getString("id");
                        mVar3.Baf = jSONObject2.getString("name");
                        mVar3.Bag = new LinkedList<>();
                        JSONArray jSONArray2 = jSONObject2.getJSONArray("value_list");
                        int length3 = jSONArray2.length();
                        for (int i4 = 0; i4 < length3; i4++) {
                            JSONObject jSONObject3 = jSONArray2.getJSONObject(i4);
                            h hVar = new h();
                            hVar.id = jSONObject3.getString("id");
                            hVar.name = jSONObject3.getString("name");
                            hVar.iJ = true;
                            mVar3.Bag.add(hVar);
                        }
                        mVar2.AZB.AZU.add(mVar3);
                    }
                }
                JSONArray optJSONArray2 = optJSONObject3.optJSONArray("actiongroup_attr");
                if (optJSONArray2 != null) {
                    mVar2.AZB.AZV = new LinkedList<>();
                    int length4 = optJSONArray2.length();
                    for (int i5 = 0; i5 < length4; i5++) {
                        JSONObject jSONObject4 = optJSONArray2.getJSONObject(i5);
                        a aVar = new a();
                        aVar.Name = jSONObject4.getString("name");
                        aVar.oUv = 0;
                        if (!Util.isNullOrNil(aVar.Name)) {
                            mVar2.AZB.AZV.add(aVar);
                        }
                        JSONArray jSONArray3 = jSONObject4.getJSONArray("action_list");
                        int length5 = jSONArray3.length();
                        for (int i6 = 0; i6 < length5; i6++) {
                            JSONObject jSONObject5 = jSONArray3.getJSONObject(i6);
                            a aVar2 = new a();
                            aVar2.Name = jSONObject5.getString("name");
                            aVar2.AZI = jSONObject5.getString("tips");
                            aVar2.oUv = jSONObject5.getInt("type");
                            aVar2.iAc = jSONObject5.getString("content");
                            aVar2.IconUrl = jSONObject5.getString("icon_url");
                            mVar2.AZB.AZV.add(aVar2);
                        }
                    }
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("available_sku_list");
            if (optJSONArray3 != null) {
                int length6 = optJSONArray3.length();
                mVar2.AZD = new LinkedList<>();
                for (int i7 = 0; i7 < length6; i7++) {
                    JSONObject jSONObject6 = optJSONArray3.getJSONObject(i7);
                    l lVar = new l();
                    lVar.Bab = jSONObject6.getString("id_info");
                    lVar.Bac = jSONObject6.getInt(FirebaseAnalytics.b.PRICE);
                    lVar.AZz = jSONObject6.getInt(FirebaseAnalytics.b.QUANTITY);
                    lVar.url = jSONObject6.getString("icon_url");
                    JSONArray jSONArray4 = jSONObject6.getJSONArray("express_fee");
                    int length7 = jSONArray4.length();
                    lVar.Bad = new LinkedList<>();
                    for (int i8 = 0; i8 < length7; i8++) {
                        JSONObject jSONObject7 = jSONArray4.getJSONObject(i8);
                        e eVar = new e();
                        eVar.id = jSONObject7.getInt("id");
                        eVar.name = jSONObject7.getString("name");
                        eVar.value = jSONObject7.getInt(FirebaseAnalytics.b.PRICE);
                        lVar.Bad.add(eVar);
                    }
                    mVar2.AZD.add(lVar);
                }
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("seller_attr");
            if (optJSONObject5 != null) {
                mVar2.AZC = new n();
                mVar2.AZC.dNI = optJSONObject5.getString("appid");
                mVar2.AZC.name = optJSONObject5.getString("name");
                mVar2.AZC.username = optJSONObject5.getString(ch.COL_USERNAME);
                mVar2.AZC.Bah = optJSONObject5.optString("logo");
                mVar2.AZC.cSx = optJSONObject5.optInt("flag", 0);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("oss_info");
            if (optJSONObject6 != null) {
                mVar2.AZF = optJSONObject6.optString("self_buy_button_word");
                mVar2.AZG = optJSONObject6.optString("product_mixed_h5_html");
            }
            AppMethodBeat.o(66910);
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.ProductInfo", e2, "", new Object[0]);
            AppMethodBeat.o(66910);
        }
        return mVar2;
    }

    public static m b(m mVar, String str) {
        String nullAsNil;
        AppMethodBeat.i(66911);
        if (mVar == null) {
            mVar = new m();
        }
        Map<String, String> parseXml = XmlParser.parseXml(str, "mallProductInfo", null);
        if (parseXml == null) {
            AppMethodBeat.o(66911);
            return null;
        }
        mVar.AZx = Util.nullAsNil(parseXml.get(".mallProductInfo.id"));
        mVar.AZy = Util.getInt(parseXml.get(".mallProductInfo.type"), 0);
        mVar.AZB = new c();
        mVar.AZB.name = Util.nullAsNil(parseXml.get(".mallProductInfo.name"));
        mVar.AZB.iAq = Util.nullAsNil(parseXml.get(".mallProductInfo.digest"));
        mVar.AZB.AZM = Util.getInt(parseXml.get(".mallProductInfo.highPrice"), 0);
        mVar.AZB.AZN = Util.getInt(parseXml.get(".mallProductInfo.lowPrice"), 0);
        mVar.AZB.AZL = Util.getInt(parseXml.get(".mallProductInfo.originPrice"), 0);
        mVar.eby = Util.nullAsNil(parseXml.get(".mallProductInfo.sourceUrl"));
        int i2 = Util.getInt(parseXml.get(".mallProductInfo.imgCount"), 0);
        if (i2 > 0) {
            mVar.AZB.AZO = new LinkedList<>();
            for (int i3 = 0; i3 < i2; i3++) {
                if (i3 == 0) {
                    nullAsNil = Util.nullAsNil(parseXml.get(".mallProductInfo.imgList.imgUrl"));
                } else {
                    nullAsNil = Util.nullAsNil(parseXml.get(".mallProductInfo.imgList.imgUrl".concat(String.valueOf(i3))));
                }
                if (!Util.isNullOrNil(nullAsNil)) {
                    mVar.AZB.AZO.add(nullAsNil);
                }
            }
        }
        mVar.AZB.AZW = new k();
        mVar.AZB.AZW.url = Util.nullAsNil(parseXml.get(".mallProductInfo.shareInfo.shareUrl"));
        mVar.AZB.AZW.qGB = Util.nullAsNil(parseXml.get(".mallProductInfo.shareInfo.shareThumbUrl"));
        mVar.AZC = new n();
        mVar.AZC.dNI = Util.nullAsNil(parseXml.get(".mallProductInfo.sellerInfo.appID"));
        mVar.AZC.name = Util.nullAsNil(parseXml.get(".mallProductInfo.sellerInfo.appName"));
        mVar.AZC.username = Util.nullAsNil(parseXml.get(".mallProductInfo.sellerInfo.usrName"));
        AppMethodBeat.o(66911);
        return mVar;
    }

    public final String eDx() {
        AppMethodBeat.i(66912);
        if (this.AZB != null && this.AZB.AZW != null && !Util.isNullOrNil(this.AZB.AZW.qGB)) {
            String str = this.AZB.AZW.qGB;
            AppMethodBeat.o(66912);
            return str;
        } else if (this.AZB == null || this.AZB.AZO == null || this.AZB.AZO.size() <= 0) {
            AppMethodBeat.o(66912);
            return null;
        } else {
            String str2 = this.AZB.AZO.get(0);
            AppMethodBeat.o(66912);
            return str2;
        }
    }
}
