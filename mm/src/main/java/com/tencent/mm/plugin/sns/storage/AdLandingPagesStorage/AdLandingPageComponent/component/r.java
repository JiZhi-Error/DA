package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.CircularImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class r extends m {
    CircularImageView Edy;

    public r(Context context, t tVar, ViewGroup viewGroup) {
        super(context, tVar, viewGroup);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWX() {
        AppMethodBeat.i(96502);
        ViewGroup.LayoutParams layoutParams = this.contentView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMargins((int) this.EcX.paddingLeft, (int) this.EcX.paddingTop, (int) this.EcX.paddingRight, (int) this.EcX.paddingBottom);
        }
        this.contentView.setLayoutParams(layoutParams);
        AppMethodBeat.o(96502);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final View eWY() {
        AppMethodBeat.i(96503);
        CircularImageView circularImageView = new CircularImageView(this.context);
        AppMethodBeat.o(96503);
        return circularImageView;
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXe() {
        this.Edy = (CircularImageView) this.contentView;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWT() {
        AppMethodBeat.i(96504);
        if (this.contentView == null || this.Edy == null) {
            AppMethodBeat.o(96504);
            return;
        }
        t tVar = (t) this.EcX;
        if (tVar == null) {
            AppMethodBeat.o(96504);
            return;
        }
        h.a(tVar.DYK, tVar.DZj, new f.a() {
            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
            public final void eWN() {
            }

            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
            public final void eWO() {
            }

            @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a
            public final void aNH(String str) {
                AppMethodBeat.i(96501);
                try {
                    Bitmap decodeFile = BitmapUtil.decodeFile(str);
                    r rVar = r.this;
                    if (decodeFile == null) {
                        Log.e("AdLandingPageCircleImgComp", "when set image the bmp is null!");
                        AppMethodBeat.o(96501);
                    } else if (rVar.Edy == null) {
                        Log.e("AdLandingPageCircleImgComp", "when set image the img is null!");
                        AppMethodBeat.o(96501);
                    } else if (decodeFile.getWidth() == 0) {
                        Log.e("AdLandingPageCircleImgComp", "when set image the bmp.getWidth is 0!");
                        AppMethodBeat.o(96501);
                    } else {
                        rVar.Edy.setImageBitmap(decodeFile);
                        AppMethodBeat.o(96501);
                    }
                } catch (Exception e2) {
                    Log.e("AdLandingPageCircleImgComp", "%s" + Util.stackTraceToString(e2));
                    AppMethodBeat.o(96501);
                }
            }
        });
        AppMethodBeat.o(96504);
    }
}
