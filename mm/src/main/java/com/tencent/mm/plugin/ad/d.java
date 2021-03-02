package com.tencent.mm.plugin.ad;

import com.tencent.mm.plugin.ac.c;
import java.util.HashMap;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 /2\u00020\u0001:\u0001/B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0019H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J$\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00042\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00180\u001fH\u0016J.\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u00042\b\u0010$\u001a\u0004\u0018\u00010\u00042\u0006\u0010%\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004H\u0016J4\u0010*\u001a\u00020\"2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00042\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00180\u001fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR6\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b`\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngineInterceptor;", "", "()V", "bizAppId", "", "getBizAppId", "()Ljava/lang/String;", "setBizAppId", "(Ljava/lang/String;)V", "contextMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getContextMap", "()Ljava/util/HashMap;", "setContextMap", "(Ljava/util/HashMap;)V", "jsEngine", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine;", "getJsEngine", "()Lcom/tencent/mm/plugin/webjsengine/WebJsEngine;", "setJsEngine", "(Lcom/tencent/mm/plugin/webjsengine/WebJsEngine;)V", "attach", "", "Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngine;", "bizPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "configPreFetcher", "id", "onCompleted", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJSContext;", "dispatchEvent", "", "appId", "url", "event", "data", "getClientInfo", "Lcom/tencent/mm/plugin/webjsengine/WebJsEngine$ClientInfo;", "type", "inject", "manifest", "Lcom/tencent/mm/plugin/webprefetcher/PrefetchManifest;", "script", "onCallback", "Companion", "webview-sdk_release"})
public abstract class d {
    public static final a ICR = new a((byte) 0);
    public HashMap<String, Integer> IBO;
    public c ICQ;
    private String jzY = "";

    public final c fXo() {
        c cVar = this.ICQ;
        if (cVar == null) {
            p.btv("jsEngine");
        }
        return cVar;
    }

    public final HashMap<String, Integer> fXp() {
        HashMap<String, Integer> hashMap = this.IBO;
        if (hashMap == null) {
            p.btv("contextMap");
        }
        return hashMap;
    }

    public final void b(c cVar) {
        p.h(cVar, "jsEngine");
        this.ICQ = cVar;
        this.IBO = cVar.IBO;
    }

    public com.tencent.mm.plugin.appbrand.appcache.p cnt() {
        return null;
    }

    public boolean S(String str, String str2, String str3) {
        p.h(str2, "event");
        return false;
    }

    public boolean a(a aVar, String str, b<? super String, x> bVar) {
        p.h(aVar, "manifest");
        p.h(str, "script");
        p.h(bVar, "onCallback");
        return false;
    }

    public final c.a lE(String str, String str2) {
        p.h(str, "type");
        p.h(str2, "appId");
        c cVar = this.ICQ;
        if (cVar == null) {
            p.btv("jsEngine");
        }
        return new c.a(str2, cVar.aWQ(str).getLong("idKey"));
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/webprefetcher/WebPrefetcherJsEngineInterceptor$Companion;", "", "()V", "typeVideo", "", "webview-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
