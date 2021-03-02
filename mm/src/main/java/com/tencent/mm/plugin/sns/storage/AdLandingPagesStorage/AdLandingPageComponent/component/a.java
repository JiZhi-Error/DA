package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.c;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a extends m {
    public a(Context context, c cVar, ViewGroup viewGroup) {
        super(context, cVar, viewGroup);
    }

    /* access modifiers changed from: protected */
    public final void a(LinearLayout linearLayout) {
        c cVar = (c) this.EcX;
        if (linearLayout != null) {
            int compare = Double.compare(cVar.DXS, cVar.DXT);
            int i2 = (int) cVar.DXS;
            int i3 = (int) cVar.DXT;
            if (compare != 0) {
                if (i2 == 0 && cVar.DXS != 0.0d) {
                    i2 = 1;
                }
                if (i3 == 0 && cVar.DXT != 0.0d) {
                    i3 = 1;
                }
            } else if (i2 == 0) {
                i3 = 1;
                i2 = 1;
            }
            Log.i("AdLandingBorderedComp", "border width top %d,bottom %d", Integer.valueOf(i2), Integer.valueOf(i3));
            if (i2 > 0) {
                LinearLayout linearLayout2 = new LinearLayout(linearLayout.getContext());
                linearLayout2.setBackgroundColor(cVar.borderColor);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, i2);
                layoutParams.gravity = 48;
                linearLayout.addView(linearLayout2, 0, layoutParams);
            }
            if (i3 > 0) {
                LinearLayout linearLayout3 = new LinearLayout(linearLayout.getContext());
                linearLayout3.setBackgroundColor(cVar.borderColor);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, i3);
                layoutParams2.gravity = 80;
                linearLayout.addView(linearLayout3, layoutParams2);
            }
        }
    }
}
