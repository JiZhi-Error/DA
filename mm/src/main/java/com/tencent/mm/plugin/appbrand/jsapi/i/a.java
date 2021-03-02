package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.app.Activity;
import com.tencent.luggage.h.f;
import com.tencent.luggage.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

abstract class a<CONTEXT extends f> extends d<CONTEXT> {
    boolean lWS;

    /* access modifiers changed from: protected */
    public abstract void d(CONTEXT context, JSONObject jSONObject, int i2);

    a() {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public void a(final CONTEXT context, final JSONObject jSONObject, final int i2) {
        boolean a2;
        Activity activity = context.getContext() instanceof Activity ? (Activity) context.getContext() : null;
        if (activity == null) {
            Log.e("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "operateRecorder, pageContext is null");
            context.i(i2, h("fail:internal error invalid android context", null));
            a2 = false;
        } else if (q(context)) {
            a2 = true;
        } else if (this.lWS) {
            context.i(i2, h("fail:system permission denied", null));
            a2 = false;
        } else {
            a2 = com.tencent.luggage.h.f.aK(activity).a("android.permission.ACCESS_FINE_LOCATION", new f.AbstractC0176f() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.i.a.AnonymousClass1 */

                /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: com.tencent.mm.plugin.appbrand.jsapi.i.a */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.tencent.luggage.h.f.AbstractC0176f
                public final void q(int[] iArr) {
                    AppMethodBeat.i(143625);
                    if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                        Log.e("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "SYS_PERM_DENIED");
                        a.this.lWS = true;
                        context.i(i2, a.this.h("fail:system permission denied", null));
                        AppMethodBeat.o(143625);
                        return;
                    }
                    Log.i("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "PERMISSION_GRANTED, do invoke again");
                    a.this.a(context, jSONObject, i2);
                    AppMethodBeat.o(143625);
                }
            });
        }
        if (!a2) {
            Log.e("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "%s requestPermission fail", getName());
        } else if (jSONObject == null) {
            Log.e("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "%s invalid data", getName());
            context.i(i2, h("fail:invalid data", null));
        } else {
            d(context, jSONObject, i2);
        }
    }

    static boolean q(CONTEXT context) {
        return i.n(context.getContext(), "android.permission.ACCESS_FINE_LOCATION");
    }
}
