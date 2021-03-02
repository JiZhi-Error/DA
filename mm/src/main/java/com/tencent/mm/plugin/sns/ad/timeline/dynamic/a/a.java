package com.tencent.mm.plugin.sns.ad.timeline.dynamic.a;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.sns.ad.h.c;
import com.tencent.mm.plugin.sns.ad.timeline.dynamic.a;
import com.tencent.mm.plugin.sns.ad.timeline.dynamic.b;
import com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a;
import com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener.RequestListenerManager;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.protocal.protobuf.bz;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a implements a.AbstractC1710a, b {
    private final WeakReference<Activity> mActivityRef;

    public a(Activity activity) {
        AppMethodBeat.i(202140);
        this.mActivityRef = new WeakReference<>(activity);
        AppMethodBeat.o(202140);
    }

    @Override // com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.AbstractC1710a
    public final void m(SnsInfo snsInfo) {
        String uxinfo;
        AppMethodBeat.i(202141);
        if (!(snsInfo == null || snsInfo.getAdXml() == null)) {
            try {
                String Jb = r.Jb(snsInfo.field_snsId);
                ADInfo adInfo = snsInfo.getAdInfo(0);
                if (adInfo == null || !TextUtils.isEmpty(adInfo.uxInfo)) {
                    uxinfo = snsInfo.getUxinfo();
                } else {
                    uxinfo = adInfo.uxInfo;
                }
                snsInfo.getAdXml();
                bz bzVar = new bz();
                bzVar.pTI = 3;
                bzVar.data = "";
                bz[] bzVarArr = {bzVar};
                if (TextUtils.isEmpty(Jb) || TextUtils.isEmpty(uxinfo)) {
                    Log.w("SnsAd.TopicCardRequestAction", "are you sure input param is valid???");
                    AppMethodBeat.o(202141);
                    return;
                }
                new c(Jb, uxinfo, bzVarArr).a(this);
                AppMethodBeat.o(202141);
                return;
            } catch (Throwable th) {
            }
        }
        AppMethodBeat.o(202141);
    }

    @Override // com.tencent.mm.plugin.sns.ad.timeline.dynamic.b
    public final void c(int i2, String str, List<bz> list) {
        com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a aNP;
        com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener.b bVar;
        WeakReference<com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener.a> weakReference;
        com.tencent.mm.plugin.sns.ad.timeline.dynamic.listener.a aVar;
        AppMethodBeat.i(202142);
        if (i2 == 0) {
            try {
                if (!TextUtils.isEmpty(str) && !com.tencent.mm.plugin.sns.ad.i.c.isEmpty(list)) {
                    Log.d("SnsAd.TopicCardRequestAction", "the response snsId is ".concat(String.valueOf(str)));
                    bz bzVar = list.get(0);
                    if (!(bzVar == null || bzVar.pTI != 3 || TextUtils.isEmpty(bzVar.data) || (aNP = aNP(bzVar.data)) == null || this.mActivityRef == null)) {
                        Log.d("SnsAd.TopicCardRequestAction", "TopicCardResponseModel : ".concat(String.valueOf(aNP)));
                        RequestListenerManager aF = RequestListenerManager.aF(this.mActivityRef.get());
                        if (!(aF == null || (bVar = aF.DxU) == null || TextUtils.isEmpty(str) || (weakReference = bVar.iIE.get(str)) == null || (aVar = weakReference.get()) == null)) {
                            aVar.A(str, aNP);
                        }
                    }
                    AppMethodBeat.o(202142);
                    return;
                }
            } catch (Throwable th) {
                AppMethodBeat.o(202142);
                return;
            }
        }
        Log.w("SnsAd.TopicCardRequestAction", "the data is empty, or request failed!!! Do nothing!!");
        AppMethodBeat.o(202142);
    }

    private static com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a aNP(String str) {
        AppMethodBeat.i(202143);
        try {
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a aVar = new com.tencent.mm.plugin.sns.ad.timeline.dynamic.b.a();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("relationText")) {
                aVar.DrQ = jSONObject.getString("relationText");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("finderTopicResList");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    a.b bVar = new a.b();
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i2);
                    bVar.uNR = jSONObject2.optString("avatar");
                    bVar.nickname = jSONObject2.optString("nickname");
                    bVar.tag = jSONObject2.optString("tag");
                    bVar.desc = jSONObject2.optString("desc");
                    bVar.DrT = jSONObject2.optString("barBgColor");
                    bVar.DrV = jSONObject2.optString(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                    JSONObject optJSONObject = jSONObject2.optJSONObject("imageInfo");
                    if (optJSONObject != null) {
                        bVar.DxW = new a.C1711a();
                        bVar.DxW.wQO = optJSONObject.optString("mid", "");
                        bVar.DxW.url = optJSONObject.optString("url", "");
                        bVar.DxW.dWJ = optJSONObject.optString("thumb");
                        bVar.DxW.width = optJSONObject.optInt("width", 0);
                        bVar.DxW.height = optJSONObject.optInt("height", 0);
                        bVar.DxW.cnR = optJSONObject.optInt("totalSize", 0);
                    }
                    aVar.DxV.add(bVar);
                }
            }
            Log.d("SnsAd.TopicCardRequestAction", "the parse result takes " + (System.currentTimeMillis() - currentTimeMillis) + LocaleUtil.MALAY);
            AppMethodBeat.o(202143);
            return aVar;
        } catch (JSONException e2) {
            AppMethodBeat.o(202143);
            return null;
        }
    }
}
