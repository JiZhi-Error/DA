package com.tencent.mm.plugin.sns.ad.timeline.a.b.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.a.a;
import com.tencent.mm.plugin.sns.ad.i.j;
import com.tencent.mm.plugin.sns.ad.timeline.a.b.b;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;

public final class c implements b {
    @Override // com.tencent.mm.plugin.sns.ad.timeline.a.c
    public final boolean a(View view, int i2, SnsInfo snsInfo, d dVar) {
        AppMethodBeat.i(202109);
        if (view == null || snsInfo == null || snsInfo.getAdXml() == null) {
            Log.w("SnsAd.FinderTopicAvatarAction", "the input param is invalid!!!!");
            AppMethodBeat.o(202109);
            return false;
        }
        a aVar = snsInfo.getAdXml().adAvatarFinderTopicInfo;
        if (aVar == null) {
            Log.w("SnsAd.FinderTopicAvatarAction", "the avatarFinderTopicInfo is null return false!!!!");
            AppMethodBeat.o(202109);
            return false;
        }
        boolean a2 = com.tencent.mm.plugin.sns.ad.c.c.a(view.getContext(), aVar.finderEncryptedTopicId, aVar.finderTopicName, snsInfo);
        AppMethodBeat.o(202109);
        return a2;
    }

    @Override // com.tencent.mm.plugin.sns.ad.timeline.a.b.b
    public final void a(SnsInfo snsInfo, d dVar) {
        SnsAdClick snsAdClick;
        AppMethodBeat.i(202110);
        if (!(dVar == null || (snsAdClick = (SnsAdClick) dVar.z("ext_sns_ad_click", null)) == null)) {
            j.a(snsAdClick, 46);
            r.a(snsAdClick);
        }
        AppMethodBeat.o(202110);
    }
}
