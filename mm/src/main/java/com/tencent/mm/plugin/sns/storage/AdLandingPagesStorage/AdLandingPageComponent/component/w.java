package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al;
import com.tencent.mm.ui.widget.MMWebView;

public final class w extends m {
    FrameLayout EeM;
    MMWebView iGY;

    public w(Context context, al alVar, ViewGroup viewGroup) {
        super(context, alVar, viewGroup);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eWT() {
        AppMethodBeat.i(96613);
        this.iGY.setVerticalScrollBarEnabled(false);
        this.iGY.setHorizontalScrollBarEnabled(false);
        this.iGY.getSettings().setJavaScriptEnabled(true);
        this.iGY.loadUrl(((al) this.EcX).h5Url);
        this.iGY.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.iGY.setVisibility(0);
        this.EeM.setPadding(this.EeM.getPaddingLeft(), (int) ((al) this.EcX).paddingTop, this.EeM.getPaddingRight(), (int) ((al) this.EcX).paddingBottom);
        this.EeM.setLayoutParams(new LinearLayout.LayoutParams(this.mEX, this.mEY));
        AppMethodBeat.o(96613);
    }

    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final void eXe() {
        AppMethodBeat.i(96614);
        this.EeM = (FrameLayout) this.contentView;
        this.iGY = MMWebView.a.kL(this.context);
        this.EeM.addView(this.iGY);
        AppMethodBeat.o(96614);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final int getLayout() {
        return Integer.MAX_VALUE;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
    public final View eWY() {
        AppMethodBeat.i(96615);
        FrameLayout frameLayout = new FrameLayout(this.context);
        AppMethodBeat.o(96615);
        return frameLayout;
    }
}
