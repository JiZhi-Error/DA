package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;

/* access modifiers changed from: package-private */
@SuppressLint({"ViewConstructor"})
public final class g extends m {
    public g(Context context, AppBrandRuntime appBrandRuntime, WxaAttributes.WxaVersionInfo wxaVersionInfo) {
        super(context, appBrandRuntime, wxaVersionInfo);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.ui.m
    public final void bWX() {
        AppMethodBeat.i(227599);
        super.bWX();
        b(getContext().getString(R.string.hr), a.n(getContext(), R.color.w), "white", a.n(getContext(), R.color.afz));
        setBackgroundResource(R.color.w);
        AppMethodBeat.o(227599);
    }
}
