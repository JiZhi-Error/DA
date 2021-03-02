package com.tencent.mm.plugin.sns.ad.timeline.a.a.a;

import android.content.Context;
import android.util.ArrayMap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.c.b;
import com.tencent.mm.plugin.sns.ad.e.h;
import com.tencent.mm.plugin.sns.ad.i.j;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.a;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.u;

public final class c extends a {
    @Override // com.tencent.mm.plugin.sns.ad.timeline.a.a.a
    public final boolean a(View view, int i2, SnsInfo snsInfo, ADXml.AdCardActionBtnInfo adCardActionBtnInfo, d dVar) {
        AppMethodBeat.i(202099);
        Log.d("SnsAd.AdFinderLiveRoomClick", "the AdFinderLiveRoomClick button is clicked");
        if (view == null || snsInfo == null || adCardActionBtnInfo == null) {
            AppMethodBeat.o(202099);
            return false;
        }
        final Context context = view.getContext();
        if (context == null) {
            AppMethodBeat.o(202099);
            return false;
        }
        String v = r.v(snsInfo);
        j.a((SnsAdClick) dVar.z("snsAdClick", null), 44);
        try {
            com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.eXI().a(i2, snsInfo);
        } catch (Throwable th) {
        }
        String aB = h.aB(snsInfo.getUxinfo(), v, 0);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.gr(aB, adCardActionBtnInfo.finderUsername);
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("is_from_ad", Boolean.TRUE);
        arrayMap.put("key_extra_info", aB);
        b.a(adCardActionBtnInfo.finderUsername, adCardActionBtnInfo.finderLiveId, adCardActionBtnInfo.finderLiveFeedExportId, adCardActionBtnInfo.finderLiveFeedNonceId, v, new b.a() {
            /* class com.tencent.mm.plugin.sns.ad.timeline.a.a.a.c.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.sns.ad.c.b.a
            public final void b(String str, int i2, Object obj) {
                AppMethodBeat.i(202098);
                if (i2 != 0) {
                    Log.d("SnsAd.AdFinderLiveRoomClick", "the AdFinderLiveRoomClick is called, onResult ".concat(String.valueOf(i2)));
                    try {
                        u.cH(context, "进入直播间失败");
                        AppMethodBeat.o(202098);
                        return;
                    } catch (Throwable th) {
                    }
                }
                AppMethodBeat.o(202098);
            }
        });
        AppMethodBeat.o(202099);
        return true;
    }
}
