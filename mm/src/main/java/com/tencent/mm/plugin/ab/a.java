package com.tencent.mm.plugin.ab;

import com.tencent.mm.plugin.ab.b;
import com.tencent.mm.plugin.appbrand.m.i;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u0014\u0010\b\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0006\u001a\u00028\u0000X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "T", "Lcom/tencent/mm/plugin/webjsapi/JSAPIContext;", "", "name", "", "context", "(Ljava/lang/String;Lcom/tencent/mm/plugin/webjsapi/JSAPIContext;)V", "TAG", "getTAG", "()Ljava/lang/String;", "getContext", "()Lcom/tencent/mm/plugin/webjsapi/JSAPIContext;", "Lcom/tencent/mm/plugin/webjsapi/JSAPIContext;", "getName", "attach", "", "jsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "webview-sdk_release"})
public abstract class a<T extends b> {
    protected final T IBa;
    final String TAG = ("MicroMsg.JSAPI." + getClass().getSimpleName() + ':' + this.IBa.getClass().getSimpleName());
    private final String name;

    public a(String str, T t) {
        p.h(str, "name");
        p.h(t, "context");
        this.name = str;
        this.IBa = t;
    }

    public final void f(i iVar) {
        p.h(iVar, "jsRuntime");
        iVar.addJavascriptInterface(this, this.name);
    }
}
