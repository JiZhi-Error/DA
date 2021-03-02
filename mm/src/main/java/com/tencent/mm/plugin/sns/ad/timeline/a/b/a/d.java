package com.tencent.mm.plugin.sns.ad.timeline.a.b.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.i.j;
import com.tencent.mm.plugin.sns.ad.timeline.a.b.b;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.d.c;

public final class d implements b {
    @Override // com.tencent.mm.plugin.sns.ad.timeline.a.c
    public final boolean a(View view, int i2, SnsInfo snsInfo, com.tencent.mm.plugin.sns.ad.timeline.a.d dVar) {
        AppMethodBeat.i(202111);
        if (view == null || snsInfo == null || snsInfo.getAdXml() == null) {
            AppMethodBeat.o(202111);
            return false;
        }
        ADXml adXml = snsInfo.getAdXml();
        if (adXml.weAppInfo == null) {
            AppMethodBeat.o(202111);
            return false;
        }
        boolean a2 = c.a(adXml.weAppInfo.appUserName, adXml.weAppInfo.dCx, adXml.weAppInfo.appVersion, snsInfo, i2);
        AppMethodBeat.o(202111);
        return a2;
    }

    @Override // com.tencent.mm.plugin.sns.ad.timeline.a.b.b
    public final void a(SnsInfo snsInfo, com.tencent.mm.plugin.sns.ad.timeline.a.d dVar) {
        SnsAdClick snsAdClick;
        AppMethodBeat.i(202112);
        if (!(dVar == null || (snsAdClick = (SnsAdClick) dVar.z("ext_sns_ad_click", null)) == null)) {
            j.a(snsAdClick, 31);
            r.a(snsAdClick);
        }
        AppMethodBeat.o(202112);
    }
}
