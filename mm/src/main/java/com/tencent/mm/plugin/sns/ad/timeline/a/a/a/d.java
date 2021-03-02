package com.tencent.mm.plugin.sns.ad.timeline.a.a.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.c.c;
import com.tencent.mm.plugin.sns.ad.i.j;
import com.tencent.mm.plugin.sns.ad.timeline.a.a.a;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends a {
    @Override // com.tencent.mm.plugin.sns.ad.timeline.a.a.a
    public final boolean a(View view, int i2, SnsInfo snsInfo, ADXml.AdCardActionBtnInfo adCardActionBtnInfo, com.tencent.mm.plugin.sns.ad.timeline.a.d dVar) {
        AppMethodBeat.i(202100);
        if (snsInfo == null || adCardActionBtnInfo == null || view == null) {
            Log.w("SnsAd.FinderTopicActionButton", "the input param is invalid!!!");
            AppMethodBeat.o(202100);
            return false;
        }
        boolean a2 = c.a(view.getContext(), adCardActionBtnInfo.finderEncryptedTopicId, adCardActionBtnInfo.finderTopicName, snsInfo);
        if (a2 && dVar != null) {
            j.a((SnsAdClick) dVar.z("snsAdClick", null), 46);
        }
        AppMethodBeat.o(202100);
        return a2;
    }
}
