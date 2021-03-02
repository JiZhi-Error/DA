package com.tencent.mm.plugin.sns.ad.timeline.a.d.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.a.d;
import com.tencent.mm.plugin.sns.ad.c.c;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends com.tencent.mm.plugin.sns.ad.timeline.a.d.a {
    @Override // com.tencent.mm.plugin.sns.ad.timeline.a.d.a
    public final boolean a(View view, SnsInfo snsInfo, d dVar) {
        AppMethodBeat.i(202122);
        if (dVar == null) {
            Log.w("SnsAd.FinderTopicCardAction", "the ");
            AppMethodBeat.o(202122);
            return false;
        }
        boolean a2 = c.a(view.getContext(), dVar.finderEncryptedTopicId, dVar.finderTopicName, snsInfo);
        AppMethodBeat.o(202122);
        return a2;
    }
}
