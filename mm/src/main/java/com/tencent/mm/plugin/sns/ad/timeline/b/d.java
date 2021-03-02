package com.tencent.mm.plugin.sns.ad.timeline.b;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.ad.g.i;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.protocal.protobuf.bvm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d {
    private static Map<String, Long> DyN = new ConcurrentHashMap();

    static {
        AppMethodBeat.i(202209);
        AppMethodBeat.o(202209);
    }

    public static boolean a(ADInfo aDInfo, String str) {
        AppMethodBeat.i(202207);
        if ((aDInfo.adActionExtTailType != ADInfo.ADChainStrengthenUserInfoFormatWording || Util.isNullOrNil(aDInfo.adActionExtTailWording) || aDInfo.adActionExtUserList.size() <= 0) && (aDInfo.adActionExtTailType != ADInfo.ADChainStrengthenDefaultWording || Util.isNullOrNil(aDInfo.adActionExtTailWording))) {
            AppMethodBeat.o(202207);
            return false;
        }
        Log.i("DynamicDataReqHelper", "use init adChainData");
        DyN.put(str, Long.valueOf(System.currentTimeMillis()));
        AppMethodBeat.o(202207);
        return true;
    }

    public static void a(String str, ADInfo aDInfo) {
        AppMethodBeat.i(202208);
        if (aDInfo == null || Util.isNullOrNil(str)) {
            Log.e("DynamicDataReqHelper", "adInfo or snsId is null, snsId = ".concat(String.valueOf(str)));
            AppMethodBeat.o(202208);
        } else if (aDInfo.adChainType != 1) {
            Log.i("DynamicDataReqHelper", "adChainType is not 1, snsId = ".concat(String.valueOf(str)));
            AppMethodBeat.o(202208);
        } else {
            int i2 = aDInfo.adChainTypeExpireTime == 0 ? 60000 : aDInfo.adChainTypeExpireTime * 1000;
            long currentTimeMillis = System.currentTimeMillis();
            Long l = DyN.get(str);
            if (currentTimeMillis - (l == null ? 0 : l.longValue()) < ((long) i2)) {
                AppMethodBeat.o(202208);
                return;
            }
            i iVar = new i("", aDInfo.aid, str, aDInfo.uxInfo);
            g.azz().a(4342, new a(str));
            g.aAg().hqi.a(iVar, 0);
            DyN.put(str, Long.valueOf(currentTimeMillis));
            AppMethodBeat.o(202208);
        }
    }

    /* access modifiers changed from: package-private */
    public static class a implements com.tencent.mm.ak.i {
        ADInfo DyO;
        private int actionType;
        private String dRS;

        /* synthetic */ a(String str) {
            this(1, str);
        }

        private a(int i2, String str) {
            this.actionType = 1;
            this.dRS = str;
        }

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(202205);
            if (qVar instanceof i) {
                try {
                    bvm bvm = (bvm) ((com.tencent.mm.ak.d) qVar.getReqResp()).iLL.iLR;
                    Log.i("DynamicDataReqHelper", "errType = " + i2 + ", errCode = " + i3 + ", snsId = " + this.dRS + ", rsp.sns_ad_id = " + (bvm == null ? "" : bvm.MbB));
                    if (i2 == 0 && i3 == 0 && bvm != null) {
                        int i4 = bvm.pTI;
                        String str2 = bvm.MbB;
                        final String str3 = bvm.MbC;
                        if (this.actionType == 1 && this.actionType == i4) {
                            if (!Util.isNullOrNil(this.dRS, str3) && this.dRS.equals(str2)) {
                                final String str4 = this.dRS;
                                h.RTc.aX(new Runnable() {
                                    /* class com.tencent.mm.plugin.sns.ad.timeline.b.d.a.AnonymousClass2 */

                                    public final void run() {
                                        String str;
                                        boolean z = true;
                                        AppMethodBeat.i(202204);
                                        try {
                                            a aVar = a.this;
                                            String str2 = str4;
                                            long aOw = r.aOw(str2);
                                            AdSnsInfo JE = aj.faR().JE(aOw);
                                            if (JE == null) {
                                                Log.e("DynamicDataReqHelper", "adInfo can not get from DB due to adsnsinfo is null, longSnsId = " + aOw + ", snsId = " + str2);
                                            } else {
                                                aVar.DyO = JE.getAdInfo();
                                            }
                                            if (a.this.DyO == null) {
                                                Log.e("DynamicDataReqHelper", "adInfo is null, can not update AdInfo, snsId = " + str4);
                                                AppMethodBeat.o(202204);
                                                return;
                                            }
                                            com.tencent.mm.plugin.sns.data.a aVar2 = new com.tencent.mm.plugin.sns.data.a();
                                            JSONObject jSONObject = new JSONObject(str3);
                                            if (jSONObject.has("WordingLink")) {
                                                aVar2.adActionExtTailLink = jSONObject.optString("WordingLink");
                                            } else {
                                                aVar2.adActionExtTailLink = null;
                                            }
                                            if (jSONObject.has("WordingType")) {
                                                aVar2.adActionExtTailType = jSONObject.optInt("WordingType");
                                                if (aVar2.adActionExtTailType == ADInfo.ADChainStrengthenUserInfoFormatWording) {
                                                    if (jSONObject.has("UserNameList")) {
                                                        JSONArray optJSONArray = jSONObject.optJSONArray("UserNameList");
                                                        aVar2.adActionExtUserList.clear();
                                                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                                            aVar2.adActionExtUserList.add(optJSONArray.optString(i2));
                                                        }
                                                    } else {
                                                        aVar2.adActionExtUserList.clear();
                                                    }
                                                    if (jSONObject.has("WordingRepAndroid")) {
                                                        String optString = jSONObject.optString("WordingRepAndroid");
                                                        if (optString.indexOf("%s") < 0) {
                                                            z = false;
                                                        }
                                                        int indexOf = optString.indexOf("%");
                                                        int lastIndexOf = optString.lastIndexOf("%");
                                                        if (!Util.isNullOrNil(optString) && z && indexOf == lastIndexOf) {
                                                            aVar2.adActionExtTailWording = optString;
                                                        }
                                                        if (!Util.isNullOrNil(aVar2.adActionExtTailWording)) {
                                                            String str3 = "";
                                                            Iterator<String> it = aVar2.adActionExtUserList.iterator();
                                                            while (it.hasNext()) {
                                                                String next = it.next();
                                                                as bjK = aj.faC().bjK(next);
                                                                if (bjK != null) {
                                                                    String arJ = bjK.arJ();
                                                                    str = !Util.isNullOrNil(arJ) ? str3 + arJ : str3 + next;
                                                                } else {
                                                                    str = str3 + next;
                                                                }
                                                                str3 = aVar2.adActionExtUserList.getLast() != next ? str + "," : str;
                                                            }
                                                            aVar2.adActionExtTailUserDisplayName = str3;
                                                            aVar2.adActionExtTailFormattedWording = String.format(aVar2.adActionExtTailWording, str3);
                                                        }
                                                    } else {
                                                        a.a(aVar2);
                                                    }
                                                } else if (aVar2.adActionExtTailType != ADInfo.ADChainStrengthenDefaultWording || !jSONObject.has("Wording")) {
                                                    a.a(aVar2);
                                                } else {
                                                    aVar2.adActionExtTailWording = jSONObject.optString("Wording");
                                                }
                                            } else {
                                                a.a(aVar2);
                                            }
                                            a aVar3 = a.this;
                                            if (aVar3.DyO == null) {
                                                Log.e("DynamicDataReqHelper", "adInfo or adChainData is null");
                                                AppMethodBeat.o(202204);
                                                return;
                                            }
                                            MMHandlerThread.postToMainThread(new Runnable(aVar2) {
                                                /* class com.tencent.mm.plugin.sns.ad.timeline.b.d.a.AnonymousClass1 */
                                                final /* synthetic */ com.tencent.mm.plugin.sns.data.a DyP;

                                                {
                                                    this.DyP = r2;
                                                }

                                                public final void run() {
                                                    AppMethodBeat.i(202203);
                                                    try {
                                                        if (this.DyP.adActionExtTailLink != null) {
                                                            a.this.DyO.adActionExtTailLink = this.DyP.adActionExtTailLink;
                                                        }
                                                        a.this.DyO.adActionExtTailType = this.DyP.adActionExtTailType;
                                                        if (this.DyP.adActionExtUserList.size() > 0) {
                                                            a.this.DyO.adActionExtUserList.clear();
                                                            a.this.DyO.adActionExtUserList.addAll(this.DyP.adActionExtUserList);
                                                        }
                                                        if (this.DyP.adActionExtTailWording != null) {
                                                            a.this.DyO.adActionExtTailWording = this.DyP.adActionExtTailWording;
                                                        }
                                                        if (this.DyP.adActionExtTailUserDisplayName != null) {
                                                            a.this.DyO.adActionExtTailUserDisplayName = this.DyP.adActionExtTailUserDisplayName;
                                                        }
                                                        if (this.DyP.adActionExtTailFormattedWording != null) {
                                                            a.this.DyO.adActionExtTailFormattedWording = this.DyP.adActionExtTailFormattedWording;
                                                        }
                                                        Log.i("DynamicDataReqHelper", "adActionExtTailWording: " + a.this.DyO.adActionExtTailWording + "，adInfo hashcode: " + a.this.DyO.hashCode());
                                                        AppMethodBeat.o(202203);
                                                    } catch (Throwable th) {
                                                        Log.e("DynamicDataReqHelper", th.toString());
                                                        AppMethodBeat.o(202203);
                                                    }
                                                }
                                            });
                                            AppMethodBeat.o(202204);
                                        } catch (Throwable th) {
                                            Log.e("DynamicDataReqHelper", th.toString());
                                            AppMethodBeat.o(202204);
                                        }
                                    }
                                });
                            }
                        }
                    }
                    g.azz().b(qVar.getType(), this);
                    AppMethodBeat.o(202205);
                    return;
                } catch (Throwable th) {
                    Log.e("DynamicDataReqHelper", "NetSceneDynamicAdDataUpdate onSceneEnd exp=" + th.toString() + ", snsId = " + this.dRS);
                }
            }
            AppMethodBeat.o(202205);
        }

        static /* synthetic */ void a(com.tencent.mm.plugin.sns.data.a aVar) {
            AppMethodBeat.i(202206);
            aVar.adActionExtTailWording = null;
            aVar.adActionExtTailUserDisplayName = null;
            aVar.adActionExtTailFormattedWording = null;
            aVar.adActionExtUserList.clear();
            AppMethodBeat.o(202206);
        }
    }
}
