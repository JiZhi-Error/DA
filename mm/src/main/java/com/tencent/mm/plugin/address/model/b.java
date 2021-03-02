package com.tencent.mm.plugin.address.model;

import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.Scopes;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.protocal.protobuf.bwx;
import com.tencent.mm.protocal.protobuf.bwy;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends q implements m {
    private i callback;
    private d rr;

    public b() {
        AppMethodBeat.i(20768);
        d.a aVar = new d.a();
        aVar.iLN = new bwx();
        aVar.iLO = new bwy();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo";
        aVar.funcId = 1191;
        this.rr = aVar.aXF();
        bwx bwx = (bwx) this.rr.iLK.iLR;
        bwx.source = 2;
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("invoice_info.title");
        linkedList.add("invoice_info.tax_number");
        linkedList.add("invoice_info.bank_number");
        linkedList.add("invoice_info.bank_name");
        linkedList.add("invoice_info.type");
        linkedList.add("invoice_info.email");
        linkedList.add("invoice_info.company_address");
        linkedList.add("invoice_info.company_address_detail");
        linkedList.add("invoice_info.company_address_postcode");
        linkedList.add("invoice_info.phone");
        bwx.McG = linkedList;
        bwx.McF = false;
        AppMethodBeat.o(20768);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(20769);
        Log.d("MicroMsg.NetSceneGetUserAutoFillInfo", "errType:" + i3 + ",errCode:" + i4 + ",errMsg" + str);
        if (i3 == 0 && i4 == 0) {
            a.bqc().ksN = new com.tencent.mm.plugin.j.a.a();
            Log.i("MicroMsg.NetSceneGetUserAutoFillInfo", "return is 0.now we resetList and parse the json ..");
            bwy bwy = (bwy) ((d) sVar).iLL.iLR;
            Log.i("MicroMsg.NetSceneGetUserAutoFillInfo", "resp json is.." + bwy.McH);
            if (bwy.McH != null) {
                try {
                    JSONArray jSONArray = new JSONObject(bwy.McH).getJSONArray("user_data_list").getJSONObject(0).getJSONArray("group_info_list");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                            try {
                                JSONObject jSONObject = jSONArray.getJSONObject(i5);
                                com.tencent.mm.plugin.j.a.b bVar = new com.tencent.mm.plugin.j.a.b();
                                bVar.ynP = jSONObject.getInt(FirebaseAnalytics.b.GROUP_ID);
                                bVar.ynY = jSONObject.getString("invoice_url");
                                Log.i("MicroMsg.NetSceneGetUserAutoFillInfo", "get groupid:" + jSONObject.getInt(FirebaseAnalytics.b.GROUP_ID) + "get invoiceUrl:" + jSONObject.getString("invoice_url"));
                                JSONArray jSONArray2 = jSONObject.getJSONArray("field_list");
                                if (jSONArray2 != null && jSONArray2.length() > 0) {
                                    for (int i6 = 0; i6 < jSONArray2.length(); i6++) {
                                        JSONObject jSONObject2 = jSONArray2.getJSONObject(i6);
                                        String string = jSONObject2.getString("key");
                                        char c2 = 65535;
                                        switch (string.hashCode()) {
                                            case -1787383122:
                                                if (string.equals("bank_name")) {
                                                    c2 = 2;
                                                    break;
                                                }
                                                break;
                                            case -192204195:
                                                if (string.equals("tax_number")) {
                                                    c2 = 1;
                                                    break;
                                                }
                                                break;
                                            case 3575610:
                                                if (string.equals("type")) {
                                                    c2 = 4;
                                                    break;
                                                }
                                                break;
                                            case 96619420:
                                                if (string.equals(Scopes.EMAIL)) {
                                                    c2 = 5;
                                                    break;
                                                }
                                                break;
                                            case 106642798:
                                                if (string.equals("phone")) {
                                                    c2 = 6;
                                                    break;
                                                }
                                                break;
                                            case 110371416:
                                                if (string.equals("title")) {
                                                    c2 = 0;
                                                    break;
                                                }
                                                break;
                                            case 330208940:
                                                if (string.equals("bank_number")) {
                                                    c2 = 3;
                                                    break;
                                                }
                                                break;
                                            case 944498430:
                                                if (string.equals("company_address_detail")) {
                                                    c2 = 7;
                                                    break;
                                                }
                                                break;
                                        }
                                        switch (c2) {
                                            case 0:
                                                bVar.title = jSONObject2.getString("value");
                                                break;
                                            case 1:
                                                bVar.ynR = jSONObject2.getString("value");
                                                break;
                                            case 2:
                                                bVar.ynT = jSONObject2.getString("value");
                                                break;
                                            case 3:
                                                bVar.ynS = jSONObject2.getString("value");
                                                break;
                                            case 4:
                                                bVar.type = jSONObject2.getString("value");
                                                break;
                                            case 5:
                                                bVar.fuD = jSONObject2.getString("value");
                                                break;
                                            case 6:
                                                bVar.ynV = jSONObject2.getString("value");
                                                bVar.ynW = jSONObject2.getString("value");
                                                break;
                                            case 7:
                                                bVar.ynX = jSONObject2.getString("value");
                                                break;
                                        }
                                    }
                                }
                                com.tencent.mm.plugin.address.b.a.a bqc = a.bqc();
                                if (bVar.type != null && bVar.type.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                    bVar.ynQ = "";
                                    bVar.ynW = "";
                                    bVar.fuD = "";
                                    bqc.ksN.ynO.add(bVar);
                                } else if (bVar.type != null && bVar.type.equals("1")) {
                                    bVar.ynQ = bVar.title;
                                    bVar.title = "";
                                    bVar.ynV = "";
                                    bVar.ynR = "";
                                    bVar.ynS = "";
                                    bVar.ynT = "";
                                    bVar.ynX = "";
                                    bqc.ksN.ynO.add(bVar);
                                }
                                Log.i("MicroMsg.InvoiceMgr", "type is error..");
                            } catch (JSONException e2) {
                                Log.e("MicroMsg.NetSceneGetUserAutoFillInfo", "parse error for no.".concat(String.valueOf(i5)));
                            }
                        }
                    }
                } catch (JSONException e3) {
                    Log.e("MicroMsg.NetSceneGetUserAutoFillInfo", "error parse this json");
                }
            }
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(20769);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1191;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(20770);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(20770);
        return dispatch;
    }
}
