package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class AppBrandCapsuleHomeButton extends AppBrandOptionButton {
    public AppBrandCapsuleHomeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AppBrandCapsuleHomeButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton
    public final Drawable getDefaultImageDrawable() {
        AppMethodBeat.i(135459);
        Drawable l = b.l(getContext(), R.drawable.bxe);
        AppMethodBeat.o(135459);
        return l;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.widget.actionbar.AppBrandOptionButton
    public final String getDefaultAccessibilityLabel() {
        AppMethodBeat.i(219626);
        String string = getContext().getString(R.string.hk);
        AppMethodBeat.o(219626);
        return string;
    }
}
