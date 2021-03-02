package com.tencent.mm.plugin.appbrand.jsapi.ag.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a;
import com.tencent.mm.plugin.appbrand.jsapi.camera.g;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tavkit.component.TAVExporter;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a extends com.tencent.luggage.xweb_ext.extendplugin.a.a {
    public static AbstractC0603a mIW;
    f czm;
    g mIV;
    List<Runnable> mIX = new Vector();
    SurfaceTexture mSurfaceTexture;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ag.a.a$a  reason: collision with other inner class name */
    public interface AbstractC0603a {
        com.tencent.mm.plugin.appbrand.jsapi.camera.f dN(Context context);
    }

    public a() {
        AppMethodBeat.i(139408);
        AppMethodBeat.o(139408);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final void e(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(139409);
        super.e(surfaceTexture);
        this.mSurfaceTexture = surfaceTexture;
        Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "preTask size: %d", Integer.valueOf(this.mIX.size()));
        for (Runnable runnable : this.mIX) {
            runnable.run();
        }
        AppMethodBeat.o(139409);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final void PQ() {
        AppMethodBeat.i(139410);
        super.PQ();
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        if (this.mIV == null) {
            Log.w("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "the camera view is null");
            AppMethodBeat.o(139410);
            return;
        }
        if (this.czm instanceof h) {
            h hVar = (h) this.czm;
            hVar.b((i.d) this.mIV);
            hVar.b((i.b) this.mIV);
            hVar.b((i.c) this.mIV);
        }
        this.mIV.release();
        AppMethodBeat.o(139410);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final String h(final com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        AppMethodBeat.i(139411);
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            final f fVar = bVar.lqg;
            final p pVar = bVar.lqf;
            final JSONObject jSONObject = bVar.lnV;
            final int i2 = bVar.lqe;
            Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", Lb(), pVar.getName(), jSONObject.toString());
            final AnonymousClass1 r0 = new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.AnonymousClass1 */

                public final void run() {
                    boolean z;
                    String string;
                    AppMethodBeat.i(139401);
                    a.this.czm = fVar;
                    if (pVar instanceof com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.b) {
                        Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "insert xweb camera");
                        a aVar = a.this;
                        f fVar = fVar;
                        com.tencent.luggage.xweb_ext.extendplugin.a aVar2 = aVar;
                        JSONObject jSONObject = jSONObject;
                        p pVar = pVar;
                        int i2 = i2;
                        if (aVar.mSurfaceTexture == null) {
                            Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "insert mSurfaceTexture is null, err");
                            AppMethodBeat.o(139401);
                            return;
                        }
                        aVar.mIV = (g) a.mIW.dN(fVar.getContext());
                        if (fVar instanceof h) {
                            h hVar = (h) fVar;
                            g gVar = aVar.mIV;
                            SurfaceTexture surfaceTexture = aVar.mSurfaceTexture;
                            ((com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.b) pVar).lQg = false;
                            Context context = hVar.getContext();
                            int optInt = jSONObject.optInt("cameraId");
                            String optString = jSONObject.optString("mode", "normal");
                            String optString2 = jSONObject.optString("devicePosition", "back");
                            String optString3 = jSONObject.optString("flash", "auto");
                            String optString4 = jSONObject.optString("size");
                            int i3 = 288;
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
                                    i3 = 288;
                                    break;
                                case 1:
                                    i3 = 480;
                                    break;
                                case 2:
                                    i3 = TAVExporter.VIDEO_EXPORT_WIDTH;
                                    break;
                            }
                            boolean optBoolean = jSONObject.optBoolean("needOutput", false);
                            String optString5 = jSONObject.optString("resolution");
                            gVar.setAppId(hVar.getAppId());
                            gVar.setPage(hVar);
                            gVar.setCameraId(optInt);
                            gVar.setMode(optString);
                            gVar.ar(optString2, true);
                            gVar.setFlash(optString3);
                            gVar.setFrameLimitSize(i3);
                            gVar.setNeedOutput(optBoolean);
                            gVar.setResolution(optString5);
                            gVar.setCustomSurfaceTexture(surfaceTexture);
                            gVar.setPageOrientation(hVar.btO());
                            JSONObject optJSONObject = jSONObject.optJSONObject("position");
                            int a2 = com.tencent.mm.plugin.appbrand.ac.g.a(optJSONObject, "width", 0);
                            int a3 = com.tencent.mm.plugin.appbrand.ac.g.a(optJSONObject, "height", 0);
                            if (!(a2 == 0 || a3 == 0)) {
                                gVar.dZ(a2, a3);
                            }
                            if (hVar instanceof ac) {
                                int[] f2 = ai.f((ac) hVar);
                                gVar.setDisplayScreenSize(new Size(f2[0], f2[1]));
                            }
                            JSONArray optJSONArray = jSONObject.optJSONArray("scanArea");
                            if (optJSONArray == null || optJSONArray.length() != 4) {
                                gVar.x(0, 0, a2, a3);
                            } else {
                                Log.i("MicroMsg.JsApiInsertXWebCamera", "scanAreaArray:%s, scanAreaArray.length:%d", optJSONArray, Integer.valueOf(optJSONArray.length()));
                                gVar.x(com.tencent.mm.plugin.appbrand.ac.g.zD(optJSONArray.optInt(0)), com.tencent.mm.plugin.appbrand.ac.g.zD(optJSONArray.optInt(1)), com.tencent.mm.plugin.appbrand.ac.g.zD(optJSONArray.optInt(2)), com.tencent.mm.plugin.appbrand.ac.g.zD(optJSONArray.optInt(3)));
                            }
                            gVar.setScanFreq(jSONObject.optInt("scanFreq"));
                            gVar.setPreviewCenterCrop(jSONObject.optBoolean("centerCrop"));
                            Log.d("MicroMsg.JsApiInsertXWebCamera", "inflateView cameraId: %d,devicePosition: %s,flash: %s,width: %d,height: %d", Integer.valueOf(optInt), optString2, optString3, Integer.valueOf(a2), Integer.valueOf(a3));
                            View view = gVar.getView();
                            if ("normal".equals(optString)) {
                                string = context.getString(R.string.hh);
                            } else {
                                string = context.getString(R.string.hi);
                            }
                            view.setContentDescription(string);
                            com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.b bVar = (com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.b) pVar;
                            g gVar2 = aVar.mIV;
                            AnonymousClass3 r10 = new b.a(fVar, i2, pVar) {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.AnonymousClass3 */
                                final /* synthetic */ int cvP;
                                final /* synthetic */ f lBw;
                                final /* synthetic */ p lxy;

                                {
                                    this.lBw = r2;
                                    this.cvP = r3;
                                    this.lxy = r4;
                                }

                                @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.b.a
                                public final void bMa() {
                                    AppMethodBeat.i(139403);
                                    this.lBw.i(this.cvP, this.lxy.h("ok", null));
                                    AppMethodBeat.o(139403);
                                }
                            };
                            Log.i("MicroMsg.JsApiInsertXWebCamera", "onInsertViewWithAsyncCallback");
                            if (gVar2 == null) {
                                Log.w("MicroMsg.JsApiInsertXWebCamera", "onInsertView failed, cameraView is null");
                            } else {
                                bVar.a(hVar, gVar2, r10);
                                a.C0654a.bFI().a(gVar2.getCameraId(), gVar2);
                                hVar.a((i.d) gVar2);
                                hVar.a((i.b) gVar2);
                                hVar.a((i.c) gVar2);
                                com.tencent.mm.plugin.appbrand.h.a(hVar.getAppId(), new h.c(new WeakReference(gVar2), hVar) {
                                    /* class com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.b.AnonymousClass1 */
                                    final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.h lJT;
                                    final /* synthetic */ WeakReference lQh;

                                    {
                                        this.lQh = r2;
                                        this.lJT = r3;
                                    }

                                    @Override // com.tencent.mm.plugin.appbrand.h.c
                                    public final void onDestroy() {
                                        com.tencent.mm.plugin.appbrand.jsapi.camera.f fVar;
                                        AppMethodBeat.i(139415);
                                        if (!(this.lQh == null || (fVar = (com.tencent.mm.plugin.appbrand.jsapi.camera.f) this.lQh.get()) == null)) {
                                            this.lJT.b((i.d) fVar);
                                            this.lJT.b((i.b) fVar);
                                            this.lJT.b((i.c) fVar);
                                            a.C0654a.bFI().M(fVar.getCameraId(), true);
                                        }
                                        com.tencent.mm.plugin.appbrand.h.b(this.lJT.getAppId(), this);
                                        AppMethodBeat.o(139415);
                                    }
                                });
                                gVar2.setOutPutCallBack(new com.tencent.mm.plugin.appbrand.jsapi.camera.b() {
                                    /* class com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.b.AnonymousClass2 */
                                });
                            }
                            fVar.P(new Runnable(hVar) {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.AnonymousClass4 */
                                final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.h mIZ;

                                {
                                    this.mIZ = r2;
                                }

                                public final void run() {
                                    AppMethodBeat.i(139404);
                                    a.a(a.this, this.mIZ);
                                    AppMethodBeat.o(139404);
                                }
                            });
                            aVar2.a(new a.AbstractC0188a(hVar, fVar, aVar2) {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.AnonymousClass5 */
                                final /* synthetic */ com.tencent.luggage.xweb_ext.extendplugin.a cFk;
                                final /* synthetic */ f lBw;
                                final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.h mIZ;

                                {
                                    this.mIZ = r2;
                                    this.lBw = r3;
                                    this.cFk = r4;
                                }

                                @Override // com.tencent.luggage.xweb_ext.extendplugin.a.AbstractC0188a
                                public final void onForeground() {
                                    AppMethodBeat.i(139405);
                                    a.a(a.this, this.mIZ);
                                    AppMethodBeat.o(139405);
                                }

                                @Override // com.tencent.luggage.xweb_ext.extendplugin.a.AbstractC0188a
                                public final void hU(int i2) {
                                    AppMethodBeat.i(139406);
                                    com.tencent.mm.plugin.appbrand.jsapi.h hVar = (com.tencent.mm.plugin.appbrand.jsapi.h) this.lBw;
                                    if (hVar.getCustomViewContainer().bEh().findViewById(a.this.mIV.getView().hashCode()) != null) {
                                        hVar.getCustomViewContainer().bEh().removeView(a.this.mIV.getView());
                                    }
                                    AppMethodBeat.o(139406);
                                }

                                @Override // com.tencent.luggage.xweb_ext.extendplugin.a.AbstractC0188a
                                public final void onDestroy() {
                                    AppMethodBeat.i(139407);
                                    this.cFk.Pu();
                                    a.this.mIV = null;
                                    AppMethodBeat.o(139407);
                                }
                            });
                        }
                        AppMethodBeat.o(139401);
                    } else if (pVar instanceof d) {
                        Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "update xweb camera");
                        a.this.a(fVar, jSONObject, pVar, i2);
                        AppMethodBeat.o(139401);
                    } else {
                        if (pVar instanceof c) {
                            Log.i("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "remove xweb camera");
                            a aVar3 = a.this;
                            f fVar2 = fVar;
                            p pVar2 = pVar;
                            int i4 = i2;
                            g gVar3 = aVar3.mIV;
                            Log.i("MicroMsg.JsApiRemoveXWebCamera", "remove xweb camera view");
                            if (gVar3 == null) {
                                Log.w("MicroMsg.JsApiRemoveXWebCamera", "the camera view is null");
                                z = false;
                            } else {
                                if (fVar2 instanceof com.tencent.mm.plugin.appbrand.jsapi.h) {
                                    com.tencent.mm.plugin.appbrand.jsapi.h hVar2 = (com.tencent.mm.plugin.appbrand.jsapi.h) fVar2;
                                    hVar2.b((i.d) gVar3);
                                    hVar2.b((i.b) gVar3);
                                    hVar2.b((i.c) gVar3);
                                }
                                gVar3.release();
                                z = true;
                            }
                            if (z) {
                                fVar2.i(i4, pVar2.h("ok", null));
                                AppMethodBeat.o(139401);
                                return;
                            }
                            Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "remove fail");
                            fVar2.i(i4, pVar2.h("fail:internal error", null));
                        }
                        AppMethodBeat.o(139401);
                    }
                }
            };
            fVar.P(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(139402);
                    if (a.this.mSurfaceTexture != null || !(pVar instanceof com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.b)) {
                        r0.run();
                        AppMethodBeat.o(139402);
                        return;
                    }
                    a.this.mIX.add(r0);
                    AppMethodBeat.o(139402);
                }
            });
        }
        AppMethodBeat.o(139411);
        return null;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        return true;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final void o(MotionEvent motionEvent) {
        AppMethodBeat.i(139412);
        this.mIV.o(motionEvent);
        AppMethodBeat.o(139412);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(f fVar, JSONObject jSONObject, p pVar, int i2) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(139413);
        g gVar = this.mIV;
        Log.i("MicroMsg.JsApiUpdateXWebCamera", "update xweb camera view");
        if (gVar == null) {
            Log.w("MicroMsg.JsApiUpdateXWebCamera", "the camera view is null");
            z2 = false;
        } else {
            int optInt = jSONObject.optInt("cameraId");
            String optString = jSONObject.optString("devicePosition", "back");
            String optString2 = jSONObject.optString("flash", "auto");
            boolean optBoolean = jSONObject.optBoolean("needOutput", false);
            gVar.setAppId(fVar.getAppId());
            gVar.ar(optString, false);
            gVar.setFlash(optString2);
            gVar.setNeedOutput(optBoolean);
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            int a2 = com.tencent.mm.plugin.appbrand.ac.g.a(optJSONObject, "width", 0);
            int a3 = com.tencent.mm.plugin.appbrand.ac.g.a(optJSONObject, "height", 0);
            Log.d("MicroMsg.JsApiUpdateXWebCamera", "onUpdateView cameraId: %d, devicePosition: %s,flash: %s,width： %d,height： %d", Integer.valueOf(optInt), optString, optString2, Integer.valueOf(a2), Integer.valueOf(a3));
            if (a2 == 0 || a3 == 0) {
                z = false;
            } else {
                z = gVar.dZ(a2, a3);
            }
            if (fVar instanceof ac) {
                int[] f2 = ai.f((ac) fVar);
                gVar.setDisplayScreenSize(new Size(f2[0], f2[1]));
            }
            String optString3 = jSONObject.optString("mode");
            if (!Util.isNullOrNil(optString3)) {
                gVar.setMode(optString3);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("scanArea");
            if (optJSONArray != null && optJSONArray.length() == 4) {
                Log.i("MicroMsg.JsApiUpdateXWebCamera", "scanAreaArray:%s, scanAreaArray.length:%d", optJSONArray, Integer.valueOf(optJSONArray.length()));
                gVar.x(com.tencent.mm.plugin.appbrand.ac.g.zD(optJSONArray.optInt(0)), com.tencent.mm.plugin.appbrand.ac.g.zD(optJSONArray.optInt(1)), com.tencent.mm.plugin.appbrand.ac.g.zD(optJSONArray.optInt(2)), com.tencent.mm.plugin.appbrand.ac.g.zD(optJSONArray.optInt(3)));
            }
            gVar.setScanFreq(jSONObject.optInt("scanFreq"));
            if (z) {
                gVar.release();
                gVar.initView();
            } else {
                gVar.bFM();
            }
            z2 = true;
        }
        if (z2) {
            fVar.i(i2, pVar.h("ok", null));
            AppMethodBeat.o(139413);
        } else {
            Log.e("MicroMsg.AppBrand.SameLayer.AppBrandCameraPluginHandler", "update fail");
            fVar.i(i2, pVar.h("fail:internal error", null));
            AppMethodBeat.o(139413);
        }
    }

    static /* synthetic */ void a(a aVar, com.tencent.mm.plugin.appbrand.jsapi.h hVar) {
        AppMethodBeat.i(177199);
        View view = aVar.mIV.getView();
        if (hVar.getCustomViewContainer().bEh().findViewById(view.hashCode()) == null) {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(1, 1);
            view.setId(view.hashCode());
            hVar.getCustomViewContainer().bEh().addView(view, layoutParams);
        }
        AppMethodBeat.o(177199);
    }
}
