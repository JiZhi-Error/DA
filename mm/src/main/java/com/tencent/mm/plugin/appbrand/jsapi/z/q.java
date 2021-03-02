package com.tencent.mm.plugin.appbrand.jsapi.z;

import android.app.Activity;
import android.content.Context;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import org.json.JSONObject;

public final class q extends d {
    public static final int CTRL_INDEX = 229;
    public static final String NAME = "setScreenBrightness";
    float mud = Float.NaN;
    float mue;

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, final JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(137687);
        Log.d("MicroMsg.JsApiSetScreenBrightness", "JsApiSetScreenBrightness!");
        if (jSONObject == null) {
            fVar.i(i2, h("fail:data is null", null));
            Log.e("MicroMsg.JsApiSetScreenBrightness", "data is null");
            AppMethodBeat.o(137687);
        } else if (!(fVar.getContext() instanceof Activity)) {
            Log.e("MicroMsg.JsApiSetScreenBrightness", "setScreenBrightness, server context is not activity, don't do invoke");
            fVar.i(i2, h("fail:context is not activity", null));
            AppMethodBeat.o(137687);
        } else {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.z.q.AnonymousClass1 */

                public final void run() {
                    float f2 = 0.01f;
                    AppMethodBeat.i(137686);
                    q.this.mue = (float) jSONObject.optDouble("value");
                    if (Float.isNaN(q.this.mue) || q.this.mue < 0.0f || q.this.mue > 1.0f) {
                        fVar.i(i2, q.this.h("fail:value invalid", null));
                        Log.e("MicroMsg.JsApiSetScreenBrightness", "value invalid");
                        AppMethodBeat.o(137686);
                        return;
                    }
                    Context context = fVar.getContext();
                    if (context == null) {
                        fVar.i(i2, q.this.h("fail", null));
                        Log.e("MicroMsg.JsApiSetScreenBrightness", "context is null, invoke fail!");
                        AppMethodBeat.o(137686);
                    } else if (!(fVar.getContext() instanceof Activity)) {
                        Log.e("MicroMsg.JsApiSetScreenBrightness", "setScreenBrightness, server context is not activity, don't do invoke");
                        fVar.i(i2, q.this.h("fail:context is not activity", null));
                        AppMethodBeat.o(137686);
                    } else {
                        final Activity activity = (Activity) context;
                        final WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                        if (Float.isNaN(q.this.mud)) {
                            q.this.mud = attributes.screenBrightness;
                            h.a(fVar.getAppId(), new h.c() {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.z.q.AnonymousClass1.AnonymousClass1 */

                                @Override // com.tencent.mm.plugin.appbrand.h.c
                                public final void a(h.d dVar) {
                                    AppMethodBeat.i(137684);
                                    attributes.screenBrightness = q.this.mud;
                                    if (!(activity == null || activity.isFinishing() || activity.getWindow() == null)) {
                                        activity.getWindow().setAttributes(attributes);
                                    }
                                    AppMethodBeat.o(137684);
                                }

                                @Override // com.tencent.mm.plugin.appbrand.h.c
                                public final void onResume() {
                                    AppMethodBeat.i(137685);
                                    attributes.screenBrightness = q.this.mue;
                                    if (!(activity == null || activity.isFinishing() || activity.getWindow() == null)) {
                                        activity.getWindow().setAttributes(attributes);
                                    }
                                    AppMethodBeat.o(137685);
                                }
                            });
                        }
                        if (q.this.mue >= 0.01f) {
                            f2 = q.this.mue;
                        }
                        attributes.screenBrightness = f2;
                        activity.getWindow().setAttributes(attributes);
                        fVar.i(i2, q.this.h("ok", null));
                        AppMethodBeat.o(137686);
                    }
                }
            });
            AppMethodBeat.o(137687);
        }
    }
}
