package com.tencent.mm.plugin.sns.ad.timeline.a.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.a.a;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.a.c;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.a.d;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends com.tencent.mm.plugin.sns.ad.timeline.a.b<a> {
    public b(Context context) {
        super(context);
    }

    /* Return type fixed from 'com.tencent.mm.plugin.sns.ad.timeline.a.c' to match base method */
    @Override // com.tencent.mm.plugin.sns.ad.timeline.a.b
    public final /* synthetic */ a j(SnsInfo snsInfo) {
        AppMethodBeat.i(202086);
        if (snsInfo == null || snsInfo.getAdXml() == null) {
            Log.w("SnsAd.AdActionButtonClick", "the sns info or adxml is null!!!");
        } else {
            ADXml.AdCardActionBtnInfo adCardActionBtnInfo = snsInfo.getAdXml().adCardActionBtnInfo;
            if (adCardActionBtnInfo != null) {
                if (adCardActionBtnInfo.clickActionType == 8) {
                    a aVar = new a();
                    AppMethodBeat.o(202086);
                    return aVar;
                } else if (adCardActionBtnInfo.clickActionType == 9) {
                    com.tencent.mm.plugin.sns.ad.timeline.a.a.a.b bVar = new com.tencent.mm.plugin.sns.ad.timeline.a.a.a.b();
                    AppMethodBeat.o(202086);
                    return bVar;
                } else if (adCardActionBtnInfo.clickActionType == 10) {
                    c cVar = new c();
                    AppMethodBeat.o(202086);
                    return cVar;
                } else if (adCardActionBtnInfo.clickActionType == 11) {
                    d dVar = new d();
                    AppMethodBeat.o(202086);
                    return dVar;
                }
            }
        }
        AppMethodBeat.o(202086);
        return null;
    }
}
