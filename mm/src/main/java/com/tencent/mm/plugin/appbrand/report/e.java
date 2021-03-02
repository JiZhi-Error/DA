package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.debugger.o;
import com.tencent.mm.plugin.appbrand.m.c;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.x;
import com.tencent.mm.plugin.appbrand.page.at;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.xweb.WebView;

public enum e {
    X5,
    MMV8,
    WebViewBased,
    NativeScript,
    NodeJS,
    J2V8,
    WebViewX5,
    WebViewXW,
    WebViewSystem,
    Invalid;
    
    public static final e[] nGR = {MMV8, J2V8, NodeJS};

    public static e valueOf(String str) {
        AppMethodBeat.i(48040);
        e eVar = (e) Enum.valueOf(e.class, str);
        AppMethodBeat.o(48040);
        return eVar;
    }

    static {
        AppMethodBeat.i(48043);
        AppMethodBeat.o(48043);
    }

    public static e d(i iVar) {
        i iVar2;
        AppMethodBeat.i(48041);
        if (iVar instanceof c) {
            e eVar = J2V8;
            AppMethodBeat.o(48041);
            return eVar;
        } else if (iVar instanceof x) {
            e eVar2 = NodeJS;
            AppMethodBeat.o(48041);
            return eVar2;
        } else if (iVar instanceof o) {
            e eVar3 = Invalid;
            AppMethodBeat.o(48041);
            return eVar3;
        } else if (iVar instanceof bb) {
            if (iVar instanceof at) {
                iVar2 = ((at) iVar).nsV;
            } else {
                iVar2 = iVar;
            }
            if (iVar2 instanceof WebView) {
                WebView webView = (WebView) iVar2;
                if (webView.isSysKernel()) {
                    e eVar4 = WebViewSystem;
                    AppMethodBeat.o(48041);
                    return eVar4;
                } else if (webView.isXWalkKernel()) {
                    e eVar5 = WebViewXW;
                    AppMethodBeat.o(48041);
                    return eVar5;
                } else if (webView.getX5WebViewExtension() != null) {
                    e eVar6 = WebViewX5;
                    AppMethodBeat.o(48041);
                    return eVar6;
                }
            }
            e eVar7 = Invalid;
            AppMethodBeat.o(48041);
            return eVar7;
        } else if (BuildInfo.DEBUG) {
            Object[] objArr = new Object[1];
            objArr[0] = iVar == null ? BuildConfig.COMMAND : iVar.getClass().getSimpleName();
            IllegalStateException illegalStateException = new IllegalStateException(String.format("Unrecognized JsRuntime %s", objArr));
            AppMethodBeat.o(48041);
            throw illegalStateException;
        } else {
            e eVar8 = Invalid;
            AppMethodBeat.o(48041);
            return eVar8;
        }
    }

    public static String e(i iVar) {
        AppMethodBeat.i(48042);
        String name = d(iVar).name();
        if (iVar instanceof o) {
            name = name + "(remote_debug)";
        }
        AppMethodBeat.o(48042);
        return name;
    }
}
