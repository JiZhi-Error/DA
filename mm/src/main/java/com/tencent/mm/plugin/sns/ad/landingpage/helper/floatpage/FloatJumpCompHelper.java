package com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sns.ad.landingpage.component.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.av;

public final class FloatJumpCompHelper extends FloatCompHelperWithLifecycle<d, com.tencent.mm.plugin.sns.ad.landingpage.component.a.d> {
    public int Duc = -1;

    /* Return type fixed from 'com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z, android.view.ViewGroup] */
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.FloatCompHelperWithLifecycle
    public final /* synthetic */ com.tencent.mm.plugin.sns.ad.landingpage.component.a.d a(Context context, d dVar, ViewGroup viewGroup) {
        AppMethodBeat.i(202009);
        d dVar2 = dVar;
        if (!(context == null || dVar2 == null)) {
            this.Duc = a.fromDPToPix(context, dVar2.DtU > 0 ? dVar2.DtU : 130);
        }
        com.tencent.mm.plugin.sns.ad.landingpage.component.a.d dVar3 = new com.tencent.mm.plugin.sns.ad.landingpage.component.a.d(context, dVar2, viewGroup, this.Duc);
        AppMethodBeat.o(202009);
        return dVar3;
    }

    public FloatJumpCompHelper(d dVar, ViewGroup viewGroup) {
        super(dVar, viewGroup);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.ad.landingpage.helper.floatpage.FloatCompHelperWithLifecycle
    public final void eX(View view) {
        AppMethodBeat.i(202007);
        try {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.addRule(12);
                layoutParams2.addRule(14);
                layoutParams2.bottomMargin += eXk();
            }
            AppMethodBeat.o(202007);
        } catch (Throwable th) {
            AppMethodBeat.o(202007);
        }
    }

    private int eXk() {
        boolean z = true;
        AppMethodBeat.i(202008);
        try {
            Context context = this.mContext;
            if (context != null) {
                if (context != null) {
                    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    int max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
                    int min = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
                    if (min == 0) {
                        Log.w("SnsAd.FloatJumpCompHelper", "the width is zero!!!");
                    } else {
                        int compare = Float.compare(((float) max) / ((float) min), 1.7777778f);
                        Log.d("SnsAd.FloatJumpCompHelper", "shouldMindDeviceNavigationBar value is ".concat(String.valueOf(compare)));
                        if (compare <= 0) {
                            z = false;
                        }
                    }
                } else {
                    z = false;
                }
                if (z) {
                    int aD = av.aD(context);
                    AppMethodBeat.o(202008);
                    return aD;
                }
                int fromDPToPix = a.fromDPToPix(context, 12);
                AppMethodBeat.o(202008);
                return fromDPToPix;
            }
        } catch (Throwable th) {
            Log.e("SnsAd.FloatJumpCompHelper", "the getNavigationBarHeight has something wrong!!");
        }
        AppMethodBeat.o(202008);
        return 0;
    }
}
