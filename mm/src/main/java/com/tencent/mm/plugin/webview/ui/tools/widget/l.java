package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

public final class l extends k {
    d JyX;
    private m JyY;

    public l(MMWebView mMWebView, boolean z, d dVar) {
        this(mMWebView, z, dVar, null);
    }

    public l(MMWebView mMWebView, boolean z, d dVar, Bundle bundle) {
        super(mMWebView, z, bundle);
        this.JyX = null;
        this.JyY = null;
        this.JyX = dVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
    public final m bLB() {
        AppMethodBeat.i(82231);
        if (this.JyY == null) {
            this.JyY = new m() {
                /* class com.tencent.mm.plugin.webview.ui.tools.widget.l.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
                public final boolean f(int i2, Bundle bundle) {
                    AppMethodBeat.i(82229);
                    if (l.this.JyX != null) {
                        boolean f2 = l.this.JyX.f(i2, bundle);
                        AppMethodBeat.o(82229);
                        return f2;
                    }
                    boolean f3 = super.f(i2, bundle);
                    AppMethodBeat.o(82229);
                    return f3;
                }

                @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
                public final void aM(Bundle bundle) {
                    AppMethodBeat.i(82230);
                    if (!(l.this.JyX instanceof e) || !((e) l.this.JyX).aXk()) {
                        super.aM(bundle);
                        AppMethodBeat.o(82230);
                        return;
                    }
                    AppMethodBeat.o(82230);
                }
            };
        }
        m mVar = this.JyY;
        AppMethodBeat.o(82231);
        return mVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
    public final void a(WebView webView, String str, Bitmap bitmap) {
        AppMethodBeat.i(82232);
        super.a(webView, str, bitmap);
        if (this.JyX instanceof e) {
            ((e) this.JyX).aXl();
        }
        AppMethodBeat.o(82232);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
    public final void f(WebView webView, String str) {
        AppMethodBeat.i(82233);
        super.f(webView, str);
        if (this.JyX instanceof e) {
            ((e) this.JyX).c((MMWebView) webView);
        }
        AppMethodBeat.o(82233);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.ui.tools.widget.k
    public final boolean Lb(String str) {
        AppMethodBeat.i(82234);
        if (this.JyX == null || !(this.JyX instanceof e)) {
            boolean Lb = super.Lb(str);
            AppMethodBeat.o(82234);
            return Lb;
        }
        boolean Lb2 = ((e) this.JyX).Lb(str);
        AppMethodBeat.o(82234);
        return Lb2;
    }
}
