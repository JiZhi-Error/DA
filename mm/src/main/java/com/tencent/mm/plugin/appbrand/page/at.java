package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.webkit.ValueCallback;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p.u;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.appbrand.m.j;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import java.net.URL;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J)\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u000e\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\r0\rH\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u0001J\t\u0010\u0010\u001a\u00020\bH\u0001J\u0013\u0010\u0011\u001a\u00020\u000f2\b\b\u0001\u0010\t\u001a\u00020\u0012H\u0001JU\u0010\u0013\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\u00140\u00142\u000e\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\r0\r2*\u0010\u0015\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\r0\r \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\r0\r\u0018\u00010\u00160\u0016H\u0001J}\u0010\u0013\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\u00140\u00142\u000e\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u000e\u0010\u0015\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u0006\u0010\u0017\u001a\u00020\u00182\u000e\u0010\u0019\u001a\n \u000b*\u0004\u0018\u00010\r0\r2*\u0010\u001a\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\r0\r \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\r0\r\u0018\u00010\u00160\u0016H\u0001JE\u0010\u0013\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\r0\r2*\u0010\f\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\r0\r \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\r0\r\u0018\u00010\u00160\u0016H\u0001JT\u0010\u001b\u001a\n \u000b*\u0004\u0018\u0001H\u001cH\u001c\"\u0010\b\u0000\u0010\u001c*\n \u000b*\u0004\u0018\u00010\u001d0\u001d2*\u0010\t\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u0001H\u001cH\u001c \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u0001H\u001cH\u001c\u0018\u00010\u001e0\u001eH\u0001¢\u0006\u0002\u0010\u001fJ\t\u0010 \u001a\u00020\u0018H\u0001J\u0011\u0010!\u001a\n \u000b*\u0004\u0018\u00010\"0\"H\u0001J\u0011\u0010#\u001a\n \u000b*\u0004\u0018\u00010$0$H\u0001J\t\u0010%\u001a\u00020\u0018H\u0001J\u0011\u0010&\u001a\n \u000b*\u0004\u0018\u00010\r0\rH\u0001J\u0011\u0010'\u001a\n \u000b*\u0004\u0018\u00010\r0\rH\u0001J\t\u0010(\u001a\u00020\u0018H\u0001J\t\u0010)\u001a\u00020\u0018H\u0001J\t\u0010*\u001a\u00020\u0018H\u0001J\u0011\u0010+\u001a\n \u000b*\u0004\u0018\u00010\"0\"H\u0001J\t\u0010,\u001a\u00020\u000fH\u0001J)\u0010-\u001a\u00020\b2\u000e\u0010.\u001a\n \u000b*\u0004\u0018\u00010\r0\r2\u000e\u0010/\u001a\n \u000b*\u0004\u0018\u00010\r0\rH\u0001J\t\u00100\u001a\u00020\bH\u0001J\t\u00101\u001a\u00020\bH\u0001J\u0015\u00102\u001a\u00020\b2\n\b\u0001\u00103\u001a\u0004\u0018\u000104H\u0001J\u0019\u00105\u001a\u00020\b2\u000e\u00106\u001a\n \u000b*\u0004\u0018\u00010707H\u0001J\t\u00108\u001a\u00020\bH\u0001JQ\u00109\u001a\u00020\b2F\u0010:\u001aB\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\r0\r\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\r0\r \u000b* \u0012\f\u0012\n \u000b*\u0004\u0018\u00010\r0\r\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\r0\r\u0018\u00010<0;H\u0001J\u0013\u0010=\u001a\u00020\b2\b\b\u0001\u0010>\u001a\u00020\u0018H\u0001J\u0019\u0010?\u001a\u00020\b2\u000e\u0010@\u001a\n \u000b*\u0004\u0018\u00010$0$H\u0001J\u0011\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\u000fH\u0001J\u0019\u0010C\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010D0DH\u0001J\u0019\u0010E\u001a\u00020\b2\u000e\u0010F\u001a\n \u000b*\u0004\u0018\u00010G0GH\u0001J\u0019\u0010H\u001a\u00020\b2\u000e\u0010F\u001a\n \u000b*\u0004\u0018\u00010I0IH\u0001J\u0011\u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020\u000fH\u0001J\u0019\u0010L\u001a\u00020\b2\u000e\u0010M\u001a\n \u000b*\u0004\u0018\u00010N0NH\u0001J\u0019\u0010O\u001a\u00020\b2\u000e\u0010@\u001a\n \u000b*\u0004\u0018\u00010P0PH\u0001J\u0019\u0010Q\u001a\u00020\b2\u0006\u0010R\u001a\u00020\u00182\u0006\u0010S\u001a\u00020TH\u0001J\t\u0010U\u001a\u00020\u000fH\u0001R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006V"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/AppBrandWebViewWrapper;", "Lcom/tencent/mm/plugin/appbrand/page/IAppBrandWebView;", "webview", "(Lcom/tencent/mm/plugin/appbrand/page/IAppBrandWebView;)V", "wrappedWebView", "getWrappedWebView", "()Lcom/tencent/mm/plugin/appbrand/page/IAppBrandWebView;", "addJavascriptInterface", "", "p0", "", "kotlin.jvm.PlatformType", "p1", "", "canOverScroll", "", "destroy", "drawScreenshotOnCanvas", "Landroid/graphics/Canvas;", "evaluateJavascript", "Ljava/net/URL;", "p2", "Landroid/webkit/ValueCallback;", "p3", "", "p4", "p5", "getAddon", "T", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddon;", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddon;", "getContentHeight", "getContentView", "Landroid/view/View;", "getFullscreenImpl", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowFullscreenHandler;", "getHeight", "getUrl", "getUserAgentString", "getWebScrollX", "getWebScrollY", "getWidth", "getWrapperView", "isInspectorEnabled", "loadData", "url", "data", "onBackground", "onForeground", "postOnReRendered", "runnable", "Ljava/lang/Runnable;", "resetContext", "context", "Landroid/content/Context;", "scrollToTop", "setAppBrandInfo", "map", "", "", u.NAME, "backgroundColor", "setFullscreenImpl", "impl", "setHorizontalScrollBarEnabled", "horizontalScrollBarEnabled", "setJsExceptionHandler", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsExceptionHandler;", "setOnScrollChangedListener", "l", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandWebViewScrollListener;", "setOnTrimListener", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandWebViewOnTrimListener;", "setVerticalScrollBarEnabled", "verticalScrollBarEnabled", "setWebViewLayoutListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/appbrand/page/AppBrandWebViewLayoutListener;", "setXWebKeyboardImpl", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandXWebKeyboard;", "smoothScrollTo", "top", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "trimmed", "luggage-wxa-app_release"})
public class at implements bb {
    public final bb nsV;

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void MM() {
        AppMethodBeat.i(140761);
        this.nsV.MM();
        AppMethodBeat.o(140761);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final boolean MN() {
        AppMethodBeat.i(140765);
        boolean MN = this.nsV.MN();
        AppMethodBeat.o(140765);
        return MN;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final boolean MO() {
        AppMethodBeat.i(219690);
        boolean MO = this.nsV.MO();
        AppMethodBeat.o(219690);
        return MO;
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i
    public final <T extends j> T R(Class<T> cls) {
        AppMethodBeat.i(140755);
        T t = (T) this.nsV.R(cls);
        AppMethodBeat.o(140755);
        return t;
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i
    public void a(URL url, String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(140751);
        this.nsV.a(url, str, valueCallback);
        AppMethodBeat.o(140751);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i
    public final void a(URL url, String str, String str2, int i2, String str3, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(140752);
        this.nsV.a(url, str, str2, i2, str3, valueCallback);
        AppMethodBeat.o(140752);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void aG(Context context) {
        AppMethodBeat.i(140737);
        this.nsV.aG(context);
        AppMethodBeat.o(140737);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i
    public void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.i(140749);
        this.nsV.addJavascriptInterface(obj, str);
        AppMethodBeat.o(140749);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bz
    public final boolean c(Canvas canvas) {
        AppMethodBeat.i(140768);
        p.h(canvas, "p0");
        boolean c2 = this.nsV.c(canvas);
        AppMethodBeat.o(140768);
        return c2;
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i, com.tencent.mm.plugin.appbrand.page.bb
    public void destroy() {
        AppMethodBeat.i(140754);
        this.nsV.destroy();
        AppMethodBeat.o(140754);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.o
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(140750);
        this.nsV.evaluateJavascript(str, valueCallback);
        AppMethodBeat.o(140750);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public int getContentHeight() {
        AppMethodBeat.i(140746);
        int contentHeight = this.nsV.getContentHeight();
        AppMethodBeat.o(140746);
        return contentHeight;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public View getContentView() {
        AppMethodBeat.i(140739);
        View contentView = this.nsV.getContentView();
        AppMethodBeat.o(140739);
        return contentView;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public d getFullscreenImpl() {
        AppMethodBeat.i(176457);
        d fullscreenImpl = this.nsV.getFullscreenImpl();
        AppMethodBeat.o(176457);
        return fullscreenImpl;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public int getHeight() {
        AppMethodBeat.i(140745);
        int height = this.nsV.getHeight();
        AppMethodBeat.o(140745);
        return height;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public String getUserAgentString() {
        AppMethodBeat.i(140742);
        String userAgentString = this.nsV.getUserAgentString();
        AppMethodBeat.o(140742);
        return userAgentString;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public int getWebScrollX() {
        AppMethodBeat.i(140747);
        int webScrollX = this.nsV.getWebScrollX();
        AppMethodBeat.o(140747);
        return webScrollX;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public int getWebScrollY() {
        AppMethodBeat.i(140748);
        int webScrollY = this.nsV.getWebScrollY();
        AppMethodBeat.o(140748);
        return webScrollY;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public int getWidth() {
        AppMethodBeat.i(140744);
        int width = this.nsV.getWidth();
        AppMethodBeat.o(140744);
        return width;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public View getWrapperView() {
        AppMethodBeat.i(140738);
        View wrapperView = this.nsV.getWrapperView();
        AppMethodBeat.o(140738);
        return wrapperView;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void i(Runnable runnable) {
        AppMethodBeat.i(140740);
        this.nsV.i(runnable);
        AppMethodBeat.o(140740);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public void onBackground() {
        AppMethodBeat.i(140757);
        this.nsV.onBackground();
        AppMethodBeat.o(140757);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public void onForeground() {
        AppMethodBeat.i(140756);
        this.nsV.onForeground();
        AppMethodBeat.o(140756);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void s(int i2, long j2) {
        AppMethodBeat.i(140762);
        this.nsV.s(i2, j2);
        AppMethodBeat.o(140762);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public void setAppBrandInfo(Map<String, String> map) {
        AppMethodBeat.i(219691);
        this.nsV.setAppBrandInfo(map);
        AppMethodBeat.o(219691);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public void setBackgroundColor(int i2) {
        AppMethodBeat.i(185200);
        this.nsV.setBackgroundColor(i2);
        AppMethodBeat.o(185200);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public void setFullscreenImpl(d dVar) {
        AppMethodBeat.i(176458);
        this.nsV.setFullscreenImpl(dVar);
        AppMethodBeat.o(176458);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i
    public void setJsExceptionHandler(h hVar) {
        AppMethodBeat.i(140753);
        this.nsV.setJsExceptionHandler(hVar);
        AppMethodBeat.o(140753);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public void setOnScrollChangedListener(as asVar) {
        AppMethodBeat.i(140758);
        this.nsV.setOnScrollChangedListener(asVar);
        AppMethodBeat.o(140758);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public void setOnTrimListener(aq aqVar) {
        AppMethodBeat.i(140760);
        this.nsV.setOnTrimListener(aqVar);
        AppMethodBeat.o(140760);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public void setVerticalScrollBarEnabled(boolean z) {
        AppMethodBeat.i(140767);
        this.nsV.setVerticalScrollBarEnabled(z);
        AppMethodBeat.o(140767);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public void setWebViewLayoutListener(ap apVar) {
        AppMethodBeat.i(140759);
        this.nsV.setWebViewLayoutListener(apVar);
        AppMethodBeat.o(140759);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public void setXWebKeyboardImpl(au auVar) {
        AppMethodBeat.i(140766);
        this.nsV.setXWebKeyboardImpl(auVar);
        AppMethodBeat.o(140766);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void x(String str, String str2) {
        AppMethodBeat.i(140741);
        this.nsV.x(str, str2);
        AppMethodBeat.o(140741);
    }

    public at(bb bbVar) {
        p.h(bbVar, "webview");
        AppMethodBeat.i(176456);
        this.nsV = bbVar;
        AppMethodBeat.o(176456);
    }
}
