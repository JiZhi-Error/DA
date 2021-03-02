package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.capsulebar.a;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.permission.r;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import org.json.JSONObject;

public abstract class i extends d<c> {
    private static i.a lEv;
    private ac cwK = null;

    /* access modifiers changed from: package-private */
    public abstract void a(c cVar, JSONObject jSONObject, int i2);

    /* renamed from: b */
    public final void a(final c cVar, final JSONObject jSONObject, final int i2) {
        boolean z;
        boolean z2;
        if (cVar.ay(Activity.class) == null) {
            Log.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "hy: no page context");
            return;
        }
        r.b(cVar.getAppId(), new a.AbstractC0015a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.openvoice.i.AnonymousClass2 */

            @Override // android.support.v4.app.a.AbstractC0015a
            public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
                AppMethodBeat.i(226938);
                if (i2 != 121) {
                    Log.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestAudioPermission requestCode is not for open voice api");
                    AppMethodBeat.o(226938);
                } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                    Log.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestAudioPermission sys perm denied for open voice api");
                    cVar.i(i2, i.this.h("fail:system permission denied", null));
                    AppMethodBeat.o(226938);
                } else {
                    Log.i("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestAudioPermission permission is grant for open voice api");
                    i.this.a(cVar, jSONObject, i2);
                    AppMethodBeat.o(226938);
                }
            }
        });
        Context context = cVar.getContext();
        if (context == null || !(context instanceof Activity)) {
            Log.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "fail, requestAudioPermission pageContext is null");
            cVar.i(i2, h("fail: context is null", null));
            z = false;
        } else {
            z = b.a((Activity) context, "android.permission.RECORD_AUDIO", 121, "", "");
            if (z) {
                r.aeq(cVar.getAppId());
            }
        }
        if (!z) {
            Log.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestAudioPermission is fail");
            Log.w("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "hy: no record audio permission");
            cVar.i(i2, h("fail: no record audio permission", null));
            return;
        }
        r.b(cVar.getAppId(), new a.AbstractC0015a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.openvoice.i.AnonymousClass3 */

            @Override // android.support.v4.app.a.AbstractC0015a
            public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
                AppMethodBeat.i(226939);
                if (i2 != 122) {
                    Log.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestCameraPermission requestCode is not for open voice api");
                    AppMethodBeat.o(226939);
                } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                    Log.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestCameraPermission sys perm denied for open voice api");
                    cVar.i(i2, i.this.h("fail:system permission denied", null));
                    AppMethodBeat.o(226939);
                } else {
                    Log.i("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestCameraPermission permission is grant for open voice api");
                    i.this.a(cVar, jSONObject, i2);
                    AppMethodBeat.o(226939);
                }
            }
        });
        Context context2 = cVar.getContext();
        if (context2 == null || !(context2 instanceof Activity)) {
            Log.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "fail, requestCameraPermission pageContext is null");
            cVar.i(i2, h("fail: context is null", null));
            z2 = false;
        } else {
            z2 = b.a((Activity) context2, "android.permission.CAMERA", 122, "", "");
            if (z2) {
                r.aeq(cVar.getAppId());
            }
        }
        if (!z2) {
            Log.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "requestCameraPermission is fail");
            Log.w("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "hy: no record video permission");
            cVar.i(i2, h("fail: no record video permission", null));
            return;
        }
        x bsD = cVar.getRuntime().bsD();
        if (!(bsD.getCurrentPage() == null && bsD.getCurrentPage().getCurrentPageView() == null)) {
            this.cwK = bsD.getCurrentPage().getCurrentPageView();
        }
        a(cVar, jSONObject, i2);
    }

    public final void hl(final boolean z) {
        try {
            if (!MMHandlerThread.isMainThread()) {
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.openvoice.i.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(46692);
                        i.this.hl(z);
                        AppMethodBeat.o(46692);
                    }
                });
            } else if (this.cwK != null && this.cwK.getRuntime() != null) {
                if (lEv != null) {
                    lEv.dismiss();
                    lEv = null;
                }
                if (z) {
                    lEv = a.C0775a.ah(this.cwK.getRuntime()).a(a.b.VOICE);
                }
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.OpenVoice.JsApiOpenVoiceBase", "setSubTitle error:" + e2.toString());
        }
    }
}
