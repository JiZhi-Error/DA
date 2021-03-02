package com.tencent.mm.plugin.sns.ad.timeline.a.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.timeline.a.b;
import com.tencent.mm.plugin.sns.ad.timeline.a.b.a.c;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends b<b> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.sns.ad.timeline.a.c, com.tencent.mm.plugin.sns.storage.SnsInfo, com.tencent.mm.plugin.sns.ad.timeline.a.d] */
    @Override // com.tencent.mm.plugin.sns.ad.timeline.a.b
    public final /* bridge */ /* synthetic */ void a(b bVar, SnsInfo snsInfo, d dVar) {
        AppMethodBeat.i(202101);
        b bVar2 = bVar;
        if (bVar2 != null) {
            bVar2.a(snsInfo, dVar);
        }
        AppMethodBeat.o(202101);
    }

    public a(Context context) {
        super(context);
    }

    /* Return type fixed from 'com.tencent.mm.plugin.sns.ad.timeline.a.c' to match base method */
    @Override // com.tencent.mm.plugin.sns.ad.timeline.a.b
    public final /* synthetic */ b j(SnsInfo snsInfo) {
        AppMethodBeat.i(202102);
        if (snsInfo == null || snsInfo.getAdXml() == null) {
            Log.w("SnsAd.AdAvatarClicker", "the sns info or adxml is null!!!");
        } else {
            int i2 = snsInfo.getAdXml().headClickType;
            if (i2 == 2) {
                com.tencent.mm.plugin.sns.ad.timeline.a.b.a.a aVar = new com.tencent.mm.plugin.sns.ad.timeline.a.b.a.a();
                AppMethodBeat.o(202102);
                return aVar;
            } else if (i2 == 3) {
                com.tencent.mm.plugin.sns.ad.timeline.a.b.a.d dVar = new com.tencent.mm.plugin.sns.ad.timeline.a.b.a.d();
                AppMethodBeat.o(202102);
                return dVar;
            } else if (i2 == 4) {
                com.tencent.mm.plugin.sns.ad.timeline.a.b.a.b bVar = new com.tencent.mm.plugin.sns.ad.timeline.a.b.a.b();
                AppMethodBeat.o(202102);
                return bVar;
            } else if (i2 == 5) {
                c cVar = new c();
                AppMethodBeat.o(202102);
                return cVar;
            }
        }
        AppMethodBeat.o(202102);
        return null;
    }
}
