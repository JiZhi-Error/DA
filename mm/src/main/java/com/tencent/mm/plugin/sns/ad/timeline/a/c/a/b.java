package com.tencent.mm.plugin.sns.ad.timeline.a.c.a;

import android.content.Context;
import android.util.ArrayMap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.a.c;
import com.tencent.mm.plugin.sns.ad.c.b;
import com.tencent.mm.plugin.sns.ad.e.h;
import com.tencent.mm.plugin.sns.ad.timeline.a.c.a;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.bc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;

public final class b extends a {
    @Override // com.tencent.mm.plugin.sns.ad.timeline.a.c.a
    public final boolean a(View view, int i2, SnsInfo snsInfo, ADXml aDXml) {
        int i3;
        AppMethodBeat.i(202118);
        c cVar = aDXml.adFinderLiveInfo;
        if (view == null || cVar == null || snsInfo == null) {
            AppMethodBeat.o(202118);
            return false;
        }
        final Context context = view.getContext();
        if (context == null) {
            AppMethodBeat.o(202118);
            return false;
        }
        Log.d("SnsAd.FinderLiveClick", "the material of find live is clicked!");
        String v = r.v(snsInfo);
        try {
            com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.eXI().a(i2, snsInfo);
        } catch (Throwable th) {
        }
        String aB = h.aB(snsInfo.getUxinfo(), v, 0);
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.gr(aB, cVar.finderUsername);
        Object tag = view.getTag();
        int i4 = snsInfo.localid;
        if (tag instanceof bc) {
            i3 = ((bc) tag).position;
        } else {
            i3 = i4;
        }
        com.tencent.mm.plugin.expt.hellhound.a.b.c.a.report21053OnClickOnSnsAd(snsInfo.field_snsId, Util.safeParseLong(cVar.finderLiveId), cVar.finderUsername, (long) i3);
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("is_from_ad", Boolean.TRUE);
        arrayMap.put("key_extra_info", aB);
        com.tencent.mm.plugin.sns.ad.c.b.a(cVar.finderUsername, cVar.finderLiveId, cVar.finderLiveFeedExportId, cVar.finderLiveFeedNonceId, v, new b.a() {
            /* class com.tencent.mm.plugin.sns.ad.timeline.a.c.a.b.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.sns.ad.c.b.a
            public final void b(String str, int i2, Object obj) {
                AppMethodBeat.i(202117);
                if (i2 != 0) {
                    Log.w("SnsAd.FinderLiveClick", "the FinderLiveClick is called, onResult ".concat(String.valueOf(i2)));
                    try {
                        u.cH(context, "进入直播间失败");
                        AppMethodBeat.o(202117);
                        return;
                    } catch (Throwable th) {
                    }
                }
                AppMethodBeat.o(202117);
            }
        });
        AppMethodBeat.o(202118);
        return true;
    }

    @Override // com.tencent.mm.plugin.sns.ad.timeline.a.c.a
    public final int eXH() {
        return 44;
    }
}
