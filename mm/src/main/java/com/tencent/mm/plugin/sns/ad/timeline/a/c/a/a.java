package com.tencent.mm.plugin.sns.ad.timeline.a.c.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.a.d;
import com.tencent.mm.plugin.sns.ad.c.c;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends com.tencent.mm.plugin.sns.ad.timeline.a.c.a {
    @Override // com.tencent.mm.plugin.sns.ad.timeline.a.c.a
    public final boolean a(View view, int i2, SnsInfo snsInfo, ADXml aDXml) {
        AppMethodBeat.i(202116);
        d dVar = aDXml.adFinderTopicInfo;
        if (dVar == null || view == null) {
            Log.w("SnsAd.FinderTopicMaterialClick", "the finder topic info is null!!");
            AppMethodBeat.o(202116);
            return false;
        }
        boolean a2 = c.a(view.getContext(), dVar.finderEncryptedTopicId, dVar.finderTopicName, snsInfo);
        AppMethodBeat.o(202116);
        return a2;
    }

    @Override // com.tencent.mm.plugin.sns.ad.timeline.a.c.a
    public final int eXH() {
        return 46;
    }
}
