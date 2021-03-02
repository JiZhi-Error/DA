package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.statusbar.b;
import junit.framework.Assert;

public final class c extends b {
    public c(Context context) {
        super(context);
        AppMethodBeat.i(219473);
        setClickable(false);
        AppMethodBeat.o(219473);
    }

    @Override // com.tencent.mm.ui.statusbar.b
    public final void bSw() {
        AppMethodBeat.i(219474);
        super.bSw();
        super.setWillNotDraw(true);
        AppMethodBeat.o(219474);
    }

    public final void aG(Context context) {
        AppMethodBeat.i(219475);
        if (getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) getContext()).setBaseContext(context);
        }
        AppMethodBeat.o(219475);
    }

    public final void onViewAdded(View view) {
        AppMethodBeat.i(219476);
        super.onViewAdded(view);
        if (!(view instanceof g)) {
            Assert.fail("Cant add non CapsuleBar instance here !");
        }
        AppMethodBeat.o(219476);
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.widget.FrameLayout
    public final FrameLayout.LayoutParams generateDefaultLayoutParams() {
        AppMethodBeat.i(219477);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 21);
        AppMethodBeat.o(219477);
        return layoutParams;
    }
}
