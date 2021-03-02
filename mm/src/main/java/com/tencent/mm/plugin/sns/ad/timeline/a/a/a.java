package com.tencent.mm.plugin.sns.ad.timeline.a.a;

import android.view.View;
import com.tencent.mm.plugin.sns.ad.timeline.a.c;
import com.tencent.mm.plugin.sns.ad.timeline.a.d;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a implements c {
    /* access modifiers changed from: protected */
    public abstract boolean a(View view, int i2, SnsInfo snsInfo, ADXml.AdCardActionBtnInfo adCardActionBtnInfo, d dVar);

    @Override // com.tencent.mm.plugin.sns.ad.timeline.a.c
    public final boolean a(View view, int i2, SnsInfo snsInfo, d dVar) {
        if (snsInfo == null || snsInfo.getAdXml() == null) {
            Log.w("SnsAd.AdActionButtonClick", "the sns info or adxml is null!!!");
            return false;
        }
        ADXml.AdCardActionBtnInfo adCardActionBtnInfo = snsInfo.getAdXml().adCardActionBtnInfo;
        if (adCardActionBtnInfo != null) {
            try {
                return a(view, i2, snsInfo, adCardActionBtnInfo, dVar);
            } catch (Throwable th) {
            }
        }
        return false;
    }
}
