package com.tencent.mm.plugin.order.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class h extends m {
    public MallOrderDetailObject AOR;
    private int AOS;

    public h(String str) {
        this(str, null, -1);
    }

    public h(String str, String str2) {
        this(str, str2, -1);
    }

    public h(String str, String str2, int i2) {
        AppMethodBeat.i(66689);
        this.AOR = null;
        this.AOS = -1;
        HashMap hashMap = new HashMap();
        hashMap.put("trans_id", str);
        if (!Util.isNullOrNil(str2)) {
            hashMap.put("bill_id", str2);
        }
        if (this.AOS >= 0) {
            this.AOS = i2;
        }
        setRequestData(hashMap);
        AppMethodBeat.o(66689);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 108;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        ArrayList arrayList;
        boolean z;
        boolean z2;
        MallOrderDetailObject.b bVar;
        AppMethodBeat.i(66690);
        if (jSONObject != null) {
            this.AOR = new MallOrderDetailObject();
            MallOrderDetailObject mallOrderDetailObject = this.AOR;
            if (jSONObject != null) {
                try {
                    mallOrderDetailObject.ANI = MallTransactionObject.bh(jSONObject);
                } catch (JSONException e2) {
                    Log.printErrStackTrace("MicroMsg.MallOrderDetailObject", e2, "", new Object[0]);
                } catch (Exception e3) {
                    Log.printErrStackTrace("MicroMsg.MallOrderDetailObject", e3, "", new Object[0]);
                }
                try {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("status_section");
                    if (jSONObject2 != null) {
                        bVar = new MallOrderDetailObject.b();
                        bVar.ANR = jSONObject2.optString("last_status_name");
                        bVar.hXs = jSONObject2.optInt("time");
                        bVar.thumbUrl = jSONObject2.optString("thumb_url");
                        bVar.xIy = jSONObject2.optString("jump_url");
                        bVar.ANS = jSONObject2.optString("last_status_desc");
                    } else {
                        bVar = null;
                    }
                    mallOrderDetailObject.ANJ = bVar;
                } catch (JSONException e4) {
                    Log.printErrStackTrace("MicroMsg.MallOrderDetailObject", e4, "", new Object[0]);
                } catch (Exception e5) {
                    Log.printErrStackTrace("MicroMsg.MallOrderDetailObject", e5, "", new Object[0]);
                }
                try {
                    mallOrderDetailObject.ANK = MallOrderDetailObject.bf(jSONObject);
                } catch (JSONException e6) {
                    Log.printErrStackTrace("MicroMsg.MallOrderDetailObject", e6, "", new Object[0]);
                } catch (Exception e7) {
                    Log.printErrStackTrace("MicroMsg.MallOrderDetailObject", e7, "", new Object[0]);
                }
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray("normal_sections");
                    if (jSONArray == null || jSONArray.length() == 0) {
                        arrayList = null;
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        int i3 = 0;
                        boolean z3 = false;
                        while (i3 < jSONArray.length()) {
                            JSONObject jSONObject3 = jSONArray.getJSONObject(i3);
                            MallOrderDetailObject.a aVar = new MallOrderDetailObject.a();
                            if (jSONObject3.optInt("is_bar") == 0) {
                                z = false;
                            } else {
                                z = true;
                            }
                            aVar.pSj = z;
                            aVar.name = jSONObject3.optString("name");
                            if (TextUtils.isEmpty(aVar.name)) {
                                z2 = aVar.pSj;
                            } else {
                                if (z3) {
                                    aVar.pSj = z3;
                                }
                                z2 = aVar.pSj;
                                aVar.value = jSONObject3.optString("value");
                                aVar.jumpUrl = jSONObject3.optString("jump_url");
                                aVar.jumpType = jSONObject3.optInt("jump_type");
                                arrayList2.add(aVar);
                            }
                            i3++;
                            z3 = z2;
                        }
                        arrayList = arrayList2;
                    }
                    mallOrderDetailObject.ANL = arrayList;
                    List list = mallOrderDetailObject.ANL;
                    JSONObject optJSONObject = jSONObject.optJSONObject("evaluate_section");
                    if (optJSONObject != null) {
                        if (list == null) {
                            list = new ArrayList();
                        }
                        MallOrderDetailObject.a aVar2 = new MallOrderDetailObject.a();
                        if (optJSONObject.has("value")) {
                            aVar2.value = optJSONObject.optString("value");
                            aVar2.type = 2;
                        } else {
                            aVar2.type = 1;
                        }
                        int optInt = optJSONObject.optInt("order", 0);
                        if (optInt >= 0 && optInt <= optJSONObject.length() + 1) {
                            list.add(optInt, aVar2);
                        }
                    }
                } catch (JSONException e8) {
                    Log.printErrStackTrace("MicroMsg.MallOrderDetailObject", e8, "", new Object[0]);
                } catch (Exception e9) {
                    Log.printErrStackTrace("MicroMsg.MallOrderDetailObject", e9, "", new Object[0]);
                }
                mallOrderDetailObject.ANO = jSONObject.optString("safeguard_url");
                mallOrderDetailObject.rJd = jSONObject.optString("share_url");
                mallOrderDetailObject.ANQ = jSONObject.optInt("modifyTimeStamp");
                if (mallOrderDetailObject.ANJ != null && mallOrderDetailObject.ANQ <= 0) {
                    mallOrderDetailObject.ANQ = mallOrderDetailObject.ANJ.hXs;
                }
                if (mallOrderDetailObject.ANI != null) {
                    mallOrderDetailObject.ANP = mallOrderDetailObject.ANI.ANP;
                    mallOrderDetailObject.appUserName = mallOrderDetailObject.ANI.dCu;
                    mallOrderDetailObject.ANN = mallOrderDetailObject.ANI.ANN;
                    mallOrderDetailObject.ANM = mallOrderDetailObject.ANI.ANM;
                }
            }
        }
        AppMethodBeat.o(66690);
    }
}
