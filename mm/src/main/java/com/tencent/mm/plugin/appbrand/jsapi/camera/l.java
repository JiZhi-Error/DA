package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.a;
import android.util.Size;
import android.view.View;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.base.i;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.permission.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tavkit.component.TAVExporter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l extends b {
    private static final int CTRL_INDEX = 329;
    public static final String NAME = "insertCamera";
    static a lQf;
    private boolean lQg;

    public interface a {
        f dN(Context context);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final View a(h hVar, JSONObject jSONObject) {
        String string;
        int[] p;
        AppMethodBeat.i(137471);
        this.lQg = false;
        Context context = hVar.getContext();
        f dN = lQf.dN(context);
        int optInt = jSONObject.optInt("cameraId");
        String optString = jSONObject.optString("mode", "normal");
        String optString2 = jSONObject.optString("devicePosition", "back");
        String optString3 = jSONObject.optString("flash", "auto");
        String optString4 = jSONObject.optString("size");
        int i2 = 288;
        char c2 = 65535;
        switch (optString4.hashCode()) {
            case -1078030475:
                if (optString4.equals(FirebaseAnalytics.b.MEDIUM)) {
                    c2 = 1;
                    break;
                }
                break;
            case 102742843:
                if (optString4.equals("large")) {
                    c2 = 2;
                    break;
                }
                break;
            case 109548807:
                if (optString4.equals("small")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                i2 = 288;
                break;
            case 1:
                i2 = 480;
                break;
            case 2:
                i2 = TAVExporter.VIDEO_EXPORT_WIDTH;
                break;
        }
        boolean optBoolean = jSONObject.optBoolean("needOutput", false);
        String optString5 = jSONObject.optString("resolution", FirebaseAnalytics.b.MEDIUM);
        dN.setAppId(hVar.getAppId());
        dN.setPage(hVar);
        dN.setCameraId(optInt);
        dN.setMode(optString);
        dN.ar(optString2, true);
        dN.setFlash(optString3);
        dN.setFrameLimitSize(i2);
        dN.setNeedOutput(optBoolean);
        dN.setResolution(optString5);
        dN.setPageOrientation(hVar.btO());
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        int a2 = g.a(optJSONObject, "width", 0);
        int a3 = g.a(optJSONObject, "height", 0);
        if (!(a2 == 0 || a3 == 0)) {
            dN.dZ(a2, a3);
        }
        e eVar = (e) hVar.M(e.class);
        if (eVar != null && (p = eVar.p(hVar)) != null && p.length == 2 && p[0] > 0 && p[1] > 0) {
            dN.setDisplayScreenSize(new Size(p[0], p[1]));
            Log.i("MicroMsg.JsApiInsertCamera", "onInsertView screen width: %d, screen height: %d", Integer.valueOf(p[0]), Integer.valueOf(p[1]));
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("scanArea");
        if (optJSONArray == null || optJSONArray.length() != 4) {
            dN.x(0, 0, a2, a3);
        } else {
            Log.i("MicroMsg.JsApiInsertCamera", "scanAreaArray:%s, scanAreaArray.length:%d", optJSONArray, Integer.valueOf(optJSONArray.length()));
            dN.x(g.zD(optJSONArray.optInt(0)), g.zD(optJSONArray.optInt(1)), g.zD(optJSONArray.optInt(2)), g.zD(optJSONArray.optInt(3)));
        }
        dN.setScanFreq(jSONObject.optInt("scanFreq"));
        boolean optBoolean2 = jSONObject.optBoolean("centerCrop");
        dN.setPreviewCenterCrop(optBoolean2);
        Log.d("MicroMsg.JsApiInsertCamera", "inflateView cameraId: %d,devicePosition: %s,flash: %s,width: %d,height: %d, centerCrop: %b", Integer.valueOf(optInt), optString2, optString3, Integer.valueOf(a2), Integer.valueOf(a3), Boolean.valueOf(optBoolean2));
        View view = dN.getView();
        if ("normal".equals(optString)) {
            string = context.getString(R.string.hh);
        } else {
            string = context.getString(R.string.hi);
        }
        view.setContentDescription(string);
        CoverViewContainer coverViewContainer = new CoverViewContainer(context, (View) dN);
        AppMethodBeat.o(137471);
        return coverViewContainer;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(137472);
        int optInt = jSONObject.optInt("cameraId");
        AppMethodBeat.o(137472);
        return optInt;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final boolean bEV() {
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final void a(h hVar, int i2, View view, JSONObject jSONObject, i iVar) {
        AppMethodBeat.i(137473);
        Log.i("MicroMsg.JsApiInsertCamera", "onInsertView cameraId=%d", Integer.valueOf(i2));
        f fVar = (f) ((CoverViewContainer) view).aB(View.class);
        if (fVar == null) {
            Log.e("MicroMsg.JsApiInsertCamera", "onInsertView(viewId : %d) failed, cameraView is null", Integer.valueOf(i2));
            iVar.ZA(h("fail:internal error", null));
            AppMethodBeat.o(137473);
            return;
        }
        final WeakReference weakReference = new WeakReference(fVar);
        final WeakReference weakReference2 = new WeakReference(hVar);
        a(hVar, fVar, iVar);
        a.C0654a.bFI().a(fVar.getCameraId(), fVar);
        hVar.a((i.d) fVar);
        hVar.a((i.b) fVar);
        hVar.a((i.c) fVar);
        com.tencent.mm.plugin.appbrand.h.a(hVar.getAppId(), new h.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.camera.l.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.h.c
            public final void onDestroy() {
                AppMethodBeat.i(137469);
                f fVar = (f) weakReference.get();
                com.tencent.mm.plugin.appbrand.jsapi.h hVar = (com.tencent.mm.plugin.appbrand.jsapi.h) weakReference2.get();
                if (!(fVar == null || hVar == null)) {
                    hVar.b((i.d) fVar);
                    hVar.b((i.b) fVar);
                    hVar.b((i.c) fVar);
                    a.C0654a.bFI().M(fVar.getCameraId(), true);
                    com.tencent.mm.plugin.appbrand.h.b(hVar.getAppId(), this);
                }
                AppMethodBeat.o(137469);
            }
        });
        fVar.setOutPutCallBack(new b() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.camera.l.AnonymousClass2 */
        });
        AppMethodBeat.o(137473);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(f fVar, f fVar2, final com.tencent.mm.plugin.appbrand.jsapi.base.i iVar) {
        AppMethodBeat.i(137474);
        final WeakReference weakReference = new WeakReference(fVar2);
        final WeakReference weakReference2 = new WeakReference(fVar);
        r.b(String.valueOf(fVar.getAppId()), new a.AbstractC0015a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.camera.l.AnonymousClass3 */

            @Override // android.support.v4.app.a.AbstractC0015a
            public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
                AppMethodBeat.i(137470);
                f fVar = (f) weakReference.get();
                f fVar2 = (f) weakReference2.get();
                if (i2 != 16) {
                    if (i2 == 18) {
                        if (iArr == null || iArr.length <= 0 || iArr[0] != 0 || fVar == null || fVar2 == null) {
                            HashMap hashMap = new HashMap();
                            if (fVar != null) {
                                hashMap.put("cameraId", Integer.valueOf(fVar.getCameraId()));
                            } else {
                                Log.w("MicroMsg.JsApiInsertCamera", "onRequestPermissionsResult weak camera is null, get Camera id fail");
                            }
                            if (fVar2 != null) {
                                new i().h(fVar2).Zh(new JSONObject(hashMap).toString()).bEo();
                            } else {
                                Log.w("MicroMsg.JsApiInsertCamera", "onRequestPermissionsResult weak camera is null, dispatch data fail");
                            }
                            a.C0654a.bFI().lOW = false;
                        } else {
                            a.C0654a.bFI().lOW = true;
                            l.this.a(fVar2, fVar, iVar);
                            AppMethodBeat.o(137470);
                            return;
                        }
                    }
                    AppMethodBeat.o(137470);
                } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0 || fVar == null || fVar2 == null) {
                    HashMap hashMap2 = new HashMap();
                    if (fVar != null) {
                        hashMap2.put("cameraId", Integer.valueOf(fVar.getCameraId()));
                    } else {
                        Log.w("MicroMsg.JsApiInsertCamera", "onRequestPermissionsResult weak camera is null, get Camera id fail");
                    }
                    if (fVar2 != null) {
                        new i().h(fVar2).Zh(new JSONObject(hashMap2).toString()).bEo();
                    } else {
                        Log.w("MicroMsg.JsApiInsertCamera", "onRequestPermissionsResult weak camera is null, dispatch data fail");
                    }
                    a.C0654a.bFI().lOV = false;
                    AppMethodBeat.o(137470);
                } else {
                    a.C0654a.bFI().lOV = true;
                    l.this.a(fVar2, fVar, iVar);
                    AppMethodBeat.o(137470);
                }
            }
        });
        Activity activity = (Activity) fVar.getContext();
        if (activity == null) {
            AppMethodBeat.o(137474);
            return false;
        }
        boolean a2 = com.tencent.luggage.h.i.a(activity, "android.permission.CAMERA", 16, "", "");
        a.C0654a.bFI().lOV = a2;
        if (!a2) {
            AppMethodBeat.o(137474);
            return false;
        }
        boolean a3 = com.tencent.luggage.h.i.a(activity, "android.permission.RECORD_AUDIO", 18, "", "");
        a.C0654a.bFI().lOW = a3;
        if (!a3) {
            AppMethodBeat.o(137474);
            return false;
        }
        r.aeq(fVar.getAppId());
        if (!this.lQg) {
            iVar.ZA(h("ok", null));
            fVar2.initView();
            this.lQg = true;
        }
        AppMethodBeat.o(137474);
        return true;
    }
}
