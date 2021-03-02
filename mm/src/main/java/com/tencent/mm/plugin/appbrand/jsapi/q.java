package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import org.json.JSONObject;

public abstract class q extends r {
    protected Activity activity;
    int lxP;

    /* access modifiers changed from: protected */
    public abstract void C(Intent intent);

    /* access modifiers changed from: protected */
    public abstract boolean a(Activity activity2, JSONObject jSONObject, int i2);

    /* access modifiers changed from: protected */
    public abstract void onError(int i2, String str);

    public q(p pVar, s sVar, ac acVar, JSONObject jSONObject, int i2) {
        super(pVar, sVar, acVar, jSONObject, i2);
        this.activity = AndroidContextUtil.castActivityOrNull(sVar.getRuntime().mContext);
        if (this.activity == null) {
            throw new IllegalArgumentException("JsApiActivityResultRequest. Activity is null");
        }
        this.lxP = pVar.hashCode() & 65535;
    }

    public final void run() {
        f.aK(this.activity).b(new f.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.q.AnonymousClass1 */

            @Override // com.tencent.luggage.h.f.c
            public final boolean c(int i2, int i3, Intent intent) {
                AppMethodBeat.i(174747);
                if (i2 == q.this.lxP) {
                    q.this.d(i2, i3, intent);
                    AppMethodBeat.o(174747);
                    return true;
                }
                AppMethodBeat.o(174747);
                return false;
            }
        });
        if (!a(this.activity, bEj(), this.lxP)) {
            onError(-1, "fail:system error {{launch fail}}");
        }
    }

    public final void d(int i2, int i3, Intent intent) {
        if (this.lxP == i2) {
            if (i3 == -1) {
                C(intent);
            } else if (intent == null || !intent.hasExtra("result_error_msg")) {
                onError(-1, "fail:system error {{unknow error}}");
            } else {
                onError(intent.getIntExtra("result_error_code", -1), intent.getStringExtra("result_error_msg"));
            }
        }
    }
}
