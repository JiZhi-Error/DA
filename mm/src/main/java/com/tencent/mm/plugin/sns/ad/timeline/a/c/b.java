package com.tencent.mm.plugin.sns.ad.timeline.a.c;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.timeline.a.c.a.a;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;

public final class b extends com.tencent.mm.plugin.sns.ad.timeline.a.b<a> {
    private int DxM = 0;

    /* Return type fixed from 'com.tencent.mm.plugin.sns.ad.timeline.a.c' to match base method */
    @Override // com.tencent.mm.plugin.sns.ad.timeline.a.b
    public final /* synthetic */ a j(SnsInfo snsInfo) {
        AppMethodBeat.i(202115);
        a k = k(snsInfo);
        AppMethodBeat.o(202115);
        return k;
    }

    public b(Context context) {
        super(context);
    }

    @Override // com.tencent.mm.plugin.sns.ad.timeline.a.b, com.tencent.mm.plugin.sns.ad.timeline.a.c
    public final boolean a(View view, int i2, SnsInfo snsInfo, d dVar) {
        AppMethodBeat.i(202113);
        this.DxM = i2;
        boolean a2 = super.a(view, i2, snsInfo, dVar);
        AppMethodBeat.o(202113);
        return a2;
    }

    private a k(SnsInfo snsInfo) {
        AppMethodBeat.i(202114);
        if (snsInfo == null) {
            AppMethodBeat.o(202114);
            return null;
        }
        try {
            ADInfo adInfo = snsInfo.getAdInfo(this.DxM);
            if (adInfo == null) {
                AppMethodBeat.o(202114);
                return null;
            } else if (adInfo.adActionType == 10) {
                com.tencent.mm.plugin.sns.ad.timeline.a.c.a.b bVar = new com.tencent.mm.plugin.sns.ad.timeline.a.c.a.b();
                AppMethodBeat.o(202114);
                return bVar;
            } else {
                if (adInfo.adActionType == 11) {
                    a aVar = new a();
                    AppMethodBeat.o(202114);
                    return aVar;
                }
                AppMethodBeat.o(202114);
                return null;
            }
        } catch (Throwable th) {
        }
    }
}
