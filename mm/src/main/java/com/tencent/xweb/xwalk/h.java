package com.tencent.xweb.xwalk;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.internal.e;
import com.tencent.xweb.o;
import com.tencent.xweb.xwalk.g;
import org.xwalk.core.XWalkView;

public final class h implements e {
    m SGX;
    o SGY;
    XWalkView SGZ;

    public h(XWalkView xWalkView) {
        AppMethodBeat.i(154285);
        this.SGZ = xWalkView;
        this.SGX = new m(xWalkView);
        this.SGY = new o(xWalkView);
        AppMethodBeat.o(154285);
    }

    @Override // com.tencent.xweb.internal.e
    public final void y(String str, Bitmap bitmap) {
        AppMethodBeat.i(154286);
        this.SGX.a(this.SGZ, str);
        AppMethodBeat.o(154286);
    }

    @Override // com.tencent.xweb.internal.e
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        AppMethodBeat.i(154287);
        if (customViewCallback instanceof g.a) {
            this.SGX.a(view, ((g.a) customViewCallback).SGR);
        }
        AppMethodBeat.o(154287);
    }

    @Override // com.tencent.xweb.internal.e
    public final void onHideCustomView() {
        AppMethodBeat.i(154288);
        this.SGX.huJ();
        AppMethodBeat.o(154288);
    }

    @Override // com.tencent.xweb.internal.e
    public final boolean a(String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(154289);
        if (jsResult instanceof g.c) {
            boolean b2 = this.SGX.b(this.SGZ, str, str2, ((g.c) jsResult).SGT);
            AppMethodBeat.o(154289);
            return b2;
        }
        AppMethodBeat.o(154289);
        return false;
    }

    @Override // com.tencent.xweb.internal.e
    public final boolean b(String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(154290);
        if (jsResult instanceof g.c) {
            boolean a2 = this.SGX.a(this.SGZ, str, str2, ((g.c) jsResult).SGT);
            AppMethodBeat.o(154290);
            return a2;
        }
        AppMethodBeat.o(154290);
        return false;
    }

    @Override // com.tencent.xweb.internal.e
    public final boolean a(String str, String str2, String str3, o oVar) {
        AppMethodBeat.i(154291);
        if (oVar instanceof g.e) {
            boolean a2 = this.SGX.a(this.SGZ, str, str2, str3, ((g.e) oVar).SGT);
            AppMethodBeat.o(154291);
            return a2;
        }
        AppMethodBeat.o(154291);
        return false;
    }
}
