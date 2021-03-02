package com.tencent.mm.plugin.sns.ad.timeline.a.c;

import android.view.View;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.ad.timeline.a.c;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;

public abstract class a implements c {
    /* access modifiers changed from: protected */
    public abstract boolean a(View view, int i2, SnsInfo snsInfo, ADXml aDXml);

    /* access modifiers changed from: protected */
    public abstract int eXH();

    @Override // com.tencent.mm.plugin.sns.ad.timeline.a.c
    public final boolean a(View view, int i2, SnsInfo snsInfo, d dVar) {
        SnsAdClick snsAdClick;
        SnsAdClick snsAdClick2;
        int i3 = 1;
        if (snsInfo == null) {
            return false;
        }
        ADXml adXml = snsInfo.getAdXml();
        if (adXml == null) {
            return false;
        }
        try {
            boolean a2 = a(view, i2, snsInfo, adXml);
            if (a2) {
                if (dVar == null) {
                    snsAdClick2 = null;
                } else {
                    k kVar = (k) dVar.z("snsAdStatistic", null);
                    if (kVar == null) {
                        snsAdClick2 = null;
                    } else {
                        if (dVar.containsKey("flipStatus")) {
                            int intValue = ((Integer) dVar.z("flipStatus", 0)).intValue();
                            if (i2 != 0) {
                                i3 = 2;
                            }
                            snsAdClick = new SnsAdClick(i2, i3, snsInfo.field_snsId, eXH(), intValue, (byte) 0);
                        } else {
                            if (i2 != 0) {
                                i3 = 2;
                            }
                            snsAdClick = new SnsAdClick(i2, i3, snsInfo.field_snsId, 22, eXH());
                        }
                        com.tencent.mm.plugin.sns.data.k.a(snsAdClick, kVar, snsInfo, 22);
                        snsAdClick2 = snsAdClick;
                    }
                }
                if (snsAdClick2 != null) {
                    r.a(snsAdClick2);
                }
            }
            return a2;
        } catch (Throwable th) {
            return false;
        }
    }
}
