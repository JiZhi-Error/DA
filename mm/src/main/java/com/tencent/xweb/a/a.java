package com.tencent.xweb.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebResourceRequest;

public final class a {
    WebResourceRequest SAW;

    public final Bundle getBundle() {
        boolean z;
        String str;
        AppMethodBeat.i(153550);
        if (this.SAW == null || this.SAW.getRequestHeaders() == null || this.SAW.isForMainFrame() || !this.SAW.getRequestHeaders().containsKey("Accept") || (str = this.SAW.getRequestHeaders().get("Accept")) == null || !str.startsWith("text/html")) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            Bundle bundle = new Bundle();
            bundle.putInt("resourceType", 1);
            AppMethodBeat.o(153550);
            return bundle;
        }
        AppMethodBeat.o(153550);
        return null;
    }

    public a(WebResourceRequest webResourceRequest) {
        this.SAW = webResourceRequest;
    }
}
