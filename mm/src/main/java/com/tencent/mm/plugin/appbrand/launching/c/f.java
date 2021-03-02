package com.tencent.mm.plugin.appbrand.launching.c;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.launching.c.a;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;

/* access modifiers changed from: package-private */
public final class f extends a {
    f() {
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.launching.c.a
    public final void a(String str, Uri uri, a.EnumC0736a aVar) {
        boolean z;
        int i2 = 1;
        AppMethodBeat.i(47415);
        String queryParameter = uri == null ? "" : uri.getQueryParameter("appid");
        switch (aVar) {
            case ERR_URL_INVALID:
                if (uri == null || !uri.getBooleanQueryParameter("debug", false)) {
                    z = false;
                } else {
                    z = true;
                }
                AppBrand404PageUI.show(R.string.r7);
                if (!z) {
                    i2 = 0;
                }
                i.T(queryParameter, 2, i2 + 1);
                AppMethodBeat.o(47415);
                return;
            case ERR_DEV_CODE_EXPIRED:
                AppBrand404PageUI.show(R.string.q6);
                i.T("", 3, 2);
                AppMethodBeat.o(47415);
                return;
            case ERR_UIN_INVALID:
                AppBrand404PageUI.show(R.string.q7);
                i.T("", 4, 2);
                AppMethodBeat.o(47415);
                return;
            case OK:
                AppMethodBeat.o(47415);
                return;
            default:
                AppBrand404PageUI.show(R.string.kp);
                AppMethodBeat.o(47415);
                return;
        }
    }
}
