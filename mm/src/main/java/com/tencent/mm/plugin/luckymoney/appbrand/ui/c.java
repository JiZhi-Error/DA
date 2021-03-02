package com.tencent.mm.plugin.luckymoney.appbrand.ui;

import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.ui.k;
import com.tencent.mm.ui.MMActivity;

public final class c extends k {
    public c(MMActivity mMActivity) {
        super(mMActivity);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.k
    public final void A(Drawable drawable) {
        AppMethodBeat.i(64905);
        super.A(drawable);
        AppMethodBeat.o(64905);
    }
}
