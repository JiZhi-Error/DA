package com.tencent.mm.plugin.sns.ad.timeline.a.b.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.sns.ad.e.h;
import com.tencent.mm.plugin.sns.ad.i.j;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;

public final class b implements com.tencent.mm.plugin.sns.ad.timeline.a.b.b {
    @Override // com.tencent.mm.plugin.sns.ad.timeline.a.c
    public final boolean a(View view, int i2, SnsInfo snsInfo, d dVar) {
        AppMethodBeat.i(202107);
        if (view == null || snsInfo == null || snsInfo.getAdXml() == null) {
            AppMethodBeat.o(202107);
            return false;
        } else if (snsInfo.getAdXml().adHeadFinderProfile == null) {
            AppMethodBeat.o(202107);
            return false;
        } else {
            boolean a2 = h.a(view.getContext(), snsInfo, i2);
            AppMethodBeat.o(202107);
            return a2;
        }
    }

    @Override // com.tencent.mm.plugin.sns.ad.timeline.a.b.b
    public final void a(SnsInfo snsInfo, d dVar) {
        SnsAdClick snsAdClick;
        AppMethodBeat.i(202108);
        if (snsInfo != null) {
            try {
                ADXml adXml = snsInfo.getAdXml();
                if (adXml.adHeadFinderProfile != null) {
                    c.gr(h.aB(snsInfo.getUxinfo(), r.Jb(snsInfo.field_snsId), 0), adXml.adHeadFinderProfile.finderUsername);
                }
            } catch (Exception e2) {
                com.tencent.mm.audio.mix.i.b.printErrStackTrace("HABBYGE-MALI.AdFinderProfileAvatarAction", e2, "reportAd crash: %s", e2.getMessage());
            }
        }
        if (!(dVar == null || (snsAdClick = (SnsAdClick) dVar.z("ext_sns_ad_click", null)) == null)) {
            j.a(snsAdClick, 41);
            r.a(snsAdClick);
        }
        AppMethodBeat.o(202108);
    }
}
