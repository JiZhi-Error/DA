package com.tencent.mm.plugin.appbrand.utils;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.u.a;
import com.tencent.mm.plugin.appbrand.jsapi.u.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/utils/WeChatReferrerHelper;", "Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/IReferrerHelper;", "()V", "defaultReferrerPolicy", "Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/ReferrerPolicy;", "getDefaultReferrerPolicy", "()Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/ReferrerPolicy;", "parseReferrerPolicy", "referrerPolicyStr", "", "parseReferrerPolicyFallback", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "parseReferrerPolicyOrFallback", "data", "Lorg/json/JSONObject;", "parseReferrerPolicyStr", "provideReferrer", "plugin-appbrand-integration_release"})
public final class ak implements a {
    private static final c ohJ = c.NO_REFERRER;
    public static final ak ohK = new ak();

    static {
        AppMethodBeat.i(229615);
        AppMethodBeat.o(229615);
    }

    private ak() {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.u.a
    public final c bIw() {
        return ohJ;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.u.a
    public final String af(JSONObject jSONObject) {
        AppMethodBeat.i(229610);
        p.h(jSONObject, "data");
        if (!jSONObject.has("referrerPolicy")) {
            Log.i("MicroMsg.AppBrand.WeChatReferrerHelper", "parseReferrerPolicyStr, referrerPolicy does not exist");
            AppMethodBeat.o(229610);
            return null;
        }
        String optString = jSONObject.optString("referrerPolicy");
        p.g(optString, "referrerPolicyStr");
        if (optString.length() == 0) {
            Log.w("MicroMsg.AppBrand.WeChatReferrerHelper", "parseReferrerPolicyStr, referrerPolicyStr is empty");
            AppMethodBeat.o(229610);
            return null;
        }
        AppMethodBeat.o(229610);
        return optString;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.u.a
    public final c aaF(String str) {
        c cVar;
        AppMethodBeat.i(229611);
        p.h(str, "referrerPolicyStr");
        switch (str.hashCode()) {
            case -1008619738:
                if (str.equals(FirebaseAnalytics.b.ORIGIN)) {
                    cVar = c.ORIGIN;
                    break;
                }
                cVar = null;
                break;
            case -887956821:
                if (str.equals("no-referrer")) {
                    cVar = c.NO_REFERRER;
                    break;
                }
                cVar = null;
                break;
            default:
                cVar = null;
                break;
        }
        Log.i("MicroMsg.AppBrand.WeChatReferrerHelper", "parseReferrerPolicy, referrerPolicy: ".concat(String.valueOf(cVar)));
        AppMethodBeat.o(229611);
        return cVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.u.a
    public final c x(f fVar) {
        AppMethodBeat.i(229612);
        p.h(fVar, "component");
        com.tencent.mm.plugin.appbrand.s.a aVar = (com.tencent.mm.plugin.appbrand.s.a) fVar.av(com.tencent.mm.plugin.appbrand.s.a.class);
        if (aVar == null) {
            Log.w("MicroMsg.AppBrand.WeChatReferrerHelper", "parseReferrerPolicyFallback, networkConfig is null");
            AppMethodBeat.o(229612);
            return null;
        }
        c cVar = aVar.nhN;
        AppMethodBeat.o(229612);
        return cVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.u.a
    public final c a(JSONObject jSONObject, f fVar) {
        AppMethodBeat.i(229613);
        p.h(jSONObject, "data");
        p.h(fVar, "component");
        String af = af(jSONObject);
        if (af == null) {
            Log.i("MicroMsg.AppBrand.WeChatReferrerHelper", "parseReferrerPolicyOrFallback, referrerPolicyStr is null");
            c x = x(fVar);
            AppMethodBeat.o(229613);
            return x;
        }
        c aaF = aaF(af);
        if (aaF == null) {
            aaF = x(fVar);
        }
        AppMethodBeat.o(229613);
        return aaF;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.u.a
    public final String y(f fVar) {
        AppMethodBeat.i(229614);
        p.h(fVar, "component");
        com.tencent.mm.plugin.appbrand.s.a aVar = (com.tencent.mm.plugin.appbrand.s.a) fVar.av(com.tencent.mm.plugin.appbrand.s.a.class);
        if (aVar == null) {
            Log.w("MicroMsg.AppBrand.WeChatReferrerHelper", "provideReferrer, networkConfig is null");
            AppMethodBeat.o(229614);
            return null;
        }
        String str = aVar.referer;
        p.g(str, "referrer");
        if (str.length() == 0) {
            Log.w("MicroMsg.AppBrand.WeChatReferrerHelper", "provideReferrer, referrer is empty");
            AppMethodBeat.o(229614);
            return null;
        }
        Log.i("MicroMsg.AppBrand.WeChatReferrerHelper", "provide, referrer: ".concat(String.valueOf(str)));
        AppMethodBeat.o(229614);
        return str;
    }
}
