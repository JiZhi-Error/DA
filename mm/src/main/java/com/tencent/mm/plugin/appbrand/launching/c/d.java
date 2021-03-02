package com.tencent.mm.plugin.appbrand.launching.c;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.launching.c.a;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;

/* access modifiers changed from: package-private */
public final class d extends a {
    d() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.launching.c.a
    public final void a(String str, Uri uri, a.EnumC0736a aVar) {
        AppMethodBeat.i(47413);
        switch (aVar) {
            case ERR_URL_INVALID:
                AppBrand404PageUI.show(R.string.jc);
                AppMethodBeat.o(47413);
                return;
            case ERR_DEV_CODE_EXPIRED:
                AppBrand404PageUI.show(R.string.jd);
                AppMethodBeat.o(47413);
                return;
            case ERR_UIN_INVALID:
                AppBrand404PageUI.show(R.string.q7);
                AppMethodBeat.o(47413);
                return;
            case OK:
                AppMethodBeat.o(47413);
                return;
            default:
                AppBrand404PageUI.show(R.string.kp);
                AppMethodBeat.o(47413);
                return;
        }
    }
}
