package com.tencent.mm.plugin.appbrand.jsapi.u;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u001a\"\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"REFERRER_HEADER_NAME", "", "TAG", "buildHeaders", "", "referrer", "updateReferrers", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "referrerPolicyContainer", "Lcom/tencent/mm/plugin/appbrand/jsapi/referrer/IReferrerPolicyContainer;", "data", "Lorg/json/JSONObject;", "luggage-commons_release"})
public final class d {
    public static final String a(f fVar, b bVar, JSONObject jSONObject) {
        AppMethodBeat.i(221366);
        p.h(bVar, "referrerPolicyContainer");
        p.h(jSONObject, "data");
        if (fVar == null) {
            Log.w("MicroMsg.AppBrand.Referrers", "updateReferrers, component is null");
            AppMethodBeat.o(221366);
            return null;
        }
        a aVar = (a) e.M(a.class);
        if (aVar == null) {
            Log.w("MicroMsg.AppBrand.Referrers", "updateReferrers, referrerHelper is null");
            AppMethodBeat.o(221366);
            return null;
        }
        if (bVar.getReferrerPolicy() == null) {
            bVar.setReferrerPolicy(aVar.bIw());
        }
        c a2 = aVar.a(jSONObject, fVar);
        if (a2 != null) {
            bVar.setReferrerPolicy(a2);
        }
        Log.i("MicroMsg.AppBrand.Referrers", "updateReferrers, referrerPolicy: " + bVar.getReferrerPolicy());
        if (c.NO_REFERRER == bVar.getReferrerPolicy()) {
            AppMethodBeat.o(221366);
            return null;
        }
        String y = aVar.y(fVar);
        Log.i("MicroMsg.AppBrand.Referrers", "updateReferrers, mReferrer: ".concat(String.valueOf(y)));
        AppMethodBeat.o(221366);
        return y;
    }

    public static final Map<String, String> aaG(String str) {
        AppMethodBeat.i(221367);
        Map<String, String> map = null;
        if (str != null) {
            map = Collections.singletonMap("Referer", str);
        }
        AppMethodBeat.o(221367);
        return map;
    }
}
