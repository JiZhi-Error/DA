package com.tencent.luggage.sdk.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.a.aa;
import kotlin.a.y;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0004H\u0007¨\u0006\u0005"}, hxF = {"Lcom/tencent/luggage/sdk/wxa_ktx/JSONUtils;", "", "()V", "copy", "Lorg/json/JSONObject;", "luggage-wxa-app_release"})
public final class b {
    public static final b cCH = new b();

    static {
        AppMethodBeat.i(135552);
        AppMethodBeat.o(135552);
    }

    private b() {
    }

    public static final JSONObject f(JSONObject jSONObject) {
        AppMethodBeat.i(135551);
        p.h(jSONObject, "$this$copy");
        String[] strArr = new String[jSONObject.length()];
        Iterator<String> keys = jSONObject.keys();
        p.g(keys, "this.keys()");
        p.h(keys, "$this$withIndex");
        aa aaVar = new aa(keys);
        while (aaVar.hasNext()) {
            y yVar = (y) aaVar.next();
            strArr[yVar.index] = yVar.value;
        }
        JSONObject jSONObject2 = new JSONObject(jSONObject, strArr);
        AppMethodBeat.o(135551);
        return jSONObject2;
    }
}
