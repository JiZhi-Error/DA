package com.tencent.mm.plugin.webview.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bhj;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J0\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\fH\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u0010 \u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"H\u0016J \u0010#\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010$\u001a\u00020\nH\u0016J\b\u0010%\u001a\u00020\nH\u0016J\u0010\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u000eH\u0016J\u0010\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020*H\u0016J \u0010+\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "", "()V", "controller", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "getController", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "setController", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V", "onAuthEnd", "", "reason", "", "reqUrl", "", "onAuthError", "errType", "errCode", "errMsg", "onAuthStart", "onAuthSucc", "onBinded", "onFinish", "onFontSizeChanged", "fontSize", "onForceQuit", "onGoBack", "onJsReady", "onPerformanceCollect", "performanceHelper", "Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "onPerformanceFetch", "onPermissionUpdate", "response", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onProcessResult", "onProgressBarEnd", "onProgressBarStart", "onShowContent", "html", "onStartLoaded", "data", "", "onUrlRedirect", "webview-sdk_release"})
public class j {
    public BaseWebViewController controller;

    public void gab() {
    }

    public void by(int i2, String str) {
        AppMethodBeat.i(225052);
        p.h(str, "reqUrl");
        AppMethodBeat.o(225052);
    }

    public void aXN(String str) {
        AppMethodBeat.i(225053);
        p.h(str, "reqUrl");
        AppMethodBeat.o(225053);
    }

    public void ePr() {
    }

    public void cpR() {
    }

    public void a(String str, bhj bhj) {
        AppMethodBeat.i(225054);
        p.h(str, "reqUrl");
        p.h(bhj, "response");
        AppMethodBeat.o(225054);
    }

    public void b(String str, bhj bhj) {
        AppMethodBeat.i(225055);
        p.h(str, "reqUrl");
        p.h(bhj, "response");
        AppMethodBeat.o(225055);
    }

    public void c(String str, bhj bhj) {
        AppMethodBeat.i(225056);
        p.h(str, "reqUrl");
        p.h(bhj, "response");
        AppMethodBeat.o(225056);
    }

    public void d(int i2, String str, int i3, String str2) {
        AppMethodBeat.i(225057);
        p.h(str, "reqUrl");
        p.h(str2, "errMsg");
        AppMethodBeat.o(225057);
    }

    public void a(com.tencent.mm.plugin.webview.k.j jVar) {
        AppMethodBeat.i(225058);
        p.h(jVar, "performanceHelper");
        AppMethodBeat.o(225058);
    }

    public void b(com.tencent.mm.plugin.webview.k.j jVar) {
        AppMethodBeat.i(225059);
        p.h(jVar, "performanceHelper");
        AppMethodBeat.o(225059);
    }

    public void gac() {
    }

    public void gad() {
    }

    public void onFinish() {
    }

    public void afL(int i2) {
    }

    public void aXO(String str) {
        AppMethodBeat.i(225060);
        p.h(str, "html");
        AppMethodBeat.o(225060);
    }

    public void yS(boolean z) {
    }

    public void gae() {
    }

    public void gaf() {
    }
}
