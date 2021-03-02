package com.tencent.mm.plugin.patmsg.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.patmsg.a.d;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public class AvatarPatTipImageView extends AvatarPatImageView implements d {
    public PatPopupWindow ARv;

    public AvatarPatTipImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public AvatarPatTipImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(206984);
        this.ARv = new PatPopupWindow(View.inflate(MMApplicationContext.getContext(), R.layout.bhb, null));
        this.ARv.setAnimationStyle(R.style.rt);
        this.ARv.setOutsideTouchable(true);
        AppMethodBeat.o(206984);
    }

    @Override // com.tencent.mm.plugin.patmsg.ui.AvatarPatImageView
    public void setTagUsername(String str) {
        AppMethodBeat.i(206985);
        if (!Util.nullAsNil(getTagUsername()).equals(str)) {
            this.ARu.eBr();
        }
        super.setTagUsername(str);
        AppMethodBeat.o(206985);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(206986);
        super.onAttachedToWindow();
        this.ARu.ARA = this;
        AppMethodBeat.o(206986);
    }

    @Override // com.tencent.mm.plugin.patmsg.a.d
    public void aJN(String str) {
        AppMethodBeat.i(206987);
        final int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int dimensionPixelSize = MMApplicationContext.getResources().getDimensionPixelSize(R.dimen.cc);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = dimensionPixelSize;
        layoutParams.leftMargin = dimensionPixelSize;
        ((TextView) this.ARv.getContentView().findViewById(R.id.g90)).setText(l.c(MMApplicationContext.getContext(), str));
        this.ARv.a(this, layoutParams);
        post(new Runnable() {
            /* class com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(206983);
                int[] iArr = new int[2];
                View contentView = AvatarPatTipImageView.this.ARv.getContentView();
                contentView.getLocationOnScreen(iArr);
                View findViewById = contentView.findViewById(R.id.ioq);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) findViewById.getLayoutParams();
                layoutParams.leftMargin = ((iArr[0] + (AvatarPatTipImageView.this.getWidth() / 2)) - iArr[0]) - (findViewById.getWidth() / 2);
                findViewById.setLayoutParams(layoutParams);
                AppMethodBeat.o(206983);
            }
        });
        AppMethodBeat.o(206987);
    }

    @Override // com.tencent.mm.plugin.patmsg.a.d
    public final void eBp() {
        AppMethodBeat.i(206988);
        this.ARv.dismiss();
        AppMethodBeat.o(206988);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.patmsg.ui.AvatarPatImageView
    public void onDetachedFromWindow() {
        AppMethodBeat.i(206989);
        super.onDetachedFromWindow();
        this.ARu.eBr();
        this.ARv.dismiss();
        AppMethodBeat.o(206989);
    }
}
