package com.tencent.mm.plugin.sns.ad.timeline.a.d;

import android.view.View;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.a.d;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.ad.timeline.a.c;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;

public abstract class a implements c {
    /* access modifiers changed from: protected */
    public abstract boolean a(View view, SnsInfo snsInfo, d dVar);

    @Override // com.tencent.mm.plugin.sns.ad.timeline.a.c
    public final boolean a(View view, int i2, SnsInfo snsInfo, com.tencent.mm.plugin.sns.ad.timeline.a.d dVar) {
        d dVar2;
        k kVar;
        if (view == null || snsInfo == null || snsInfo.getAdXml() == null || (dVar2 = snsInfo.getAdXml().adFinderTopicInfo) == null) {
            return false;
        }
        boolean a2 = a(view, snsInfo, dVar2);
        if (a2) {
            SnsAdClick snsAdClick = new SnsAdClick(i2, i2 == 0 ? 1 : 2, snsInfo.field_snsId, 32, 46);
            if (!(dVar == null || (kVar = (k) dVar.z("sns_ad_statistic", null)) == null)) {
                com.tencent.mm.plugin.sns.data.k.a(snsAdClick, kVar, snsInfo, 32);
            }
            r.a(snsAdClick);
        }
        return a2;
    }
}
