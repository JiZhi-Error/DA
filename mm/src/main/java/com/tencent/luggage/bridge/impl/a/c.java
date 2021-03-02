package com.tencent.luggage.bridge.impl.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.sdk.http.HttpWrapperBase;

public class c extends a {
    @Override // com.tencent.mm.plugin.appbrand.f.a.AbstractC0580a
    public boolean match(String str) {
        AppMethodBeat.i(140368);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(140368);
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith(HttpWrapperBase.PROTOCAL_HTTP) || lowerCase.startsWith(HttpWrapperBase.PROTOCAL_HTTPS)) {
            AppMethodBeat.o(140368);
            return true;
        }
        AppMethodBeat.o(140368);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.f.a.AbstractC0580a
    public Bitmap b(String str, Rect rect, a.b bVar) {
        return null;
    }

    @Override // com.tencent.luggage.bridge.impl.a.a
    public final void a(String str, a.c cVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.f.a.AbstractC0580a
    public final String Lb() {
        return "NetworkImageReader";
    }
}
