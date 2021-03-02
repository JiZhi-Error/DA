package com.tencent.luggage.game.page;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.appbrand.m.j;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.page.aq;
import com.tencent.mm.plugin.appbrand.page.as;
import com.tencent.mm.plugin.appbrand.page.au;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import java.net.URL;
import java.util.Map;

public final class a implements bb {
    private ViewGroup cwH;
    private ViewGroup cwI;

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void aG(Context context) {
        AppMethodBeat.i(130625);
        if (this.cwH == null) {
            this.cwH = new FrameLayout(context);
        }
        if (this.cwI == null) {
            this.cwI = new FrameLayout(context);
        }
        AppMethodBeat.o(130625);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final View getWrapperView() {
        return this.cwH;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final View getContentView() {
        return this.cwI;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bz
    public final boolean c(Canvas canvas) {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void i(Runnable runnable) {
        AppMethodBeat.i(222886);
        if (runnable != null) {
            runnable.run();
        }
        AppMethodBeat.o(222886);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void x(String str, String str2) {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final String getUserAgentString() {
        return "MiniGame";
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final int getWidth() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final int getHeight() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final int getContentHeight() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final int getWebScrollX() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final int getWebScrollY() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i
    public final void addJavascriptInterface(Object obj, String str) {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void setAppBrandInfo(Map<String, String> map) {
    }

    @Override // com.tencent.mm.plugin.appbrand.m.o
    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i
    public final void a(URL url, String str, ValueCallback<String> valueCallback) {
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i
    public final void a(URL url, String str, String str2, int i2, String str3, ValueCallback<String> valueCallback) {
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i
    public final void setJsExceptionHandler(h hVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i, com.tencent.mm.plugin.appbrand.page.bb
    public final void destroy() {
        this.cwH = null;
        this.cwI = null;
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i
    public final <T extends j> T R(Class<T> cls) {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void onForeground() {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void onBackground() {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void setOnScrollChangedListener(as asVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void setWebViewLayoutListener(ap apVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void setOnTrimListener(aq aqVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void MM() {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void s(int i2, long j2) {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void setFullscreenImpl(d dVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final d getFullscreenImpl() {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final boolean MN() {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void setXWebKeyboardImpl(au auVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void setVerticalScrollBarEnabled(boolean z) {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void setBackgroundColor(int i2) {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final boolean MO() {
        return false;
    }
}
