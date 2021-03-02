package com.tencent.mm.plugin.appbrand.jsapi.ag.d;

import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.ag.d.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.k.a;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.e;
import com.tencent.mm.plugin.appbrand.jsapi.k.t;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SyncTask;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends com.tencent.luggage.xweb_ext.extendplugin.a.a {
    private MMHandler mHandler = new MMHandler(String.format(Locale.ENGLISH, "MapThread_%d", Integer.valueOf(getId())));
    MMHandler mKp = new MMHandler(Looper.getMainLooper());
    volatile b mKq;
    volatile SurfaceTexture mSurfaceTexture;

    public a() {
        AppMethodBeat.i(139533);
        AppMethodBeat.o(139533);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final void e(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(139534);
        Log.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "handlePluginReady %d", Integer.valueOf(getId()));
        super.e(surfaceTexture);
        this.mSurfaceTexture = surfaceTexture;
        this.mHandler.post(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.ag.d.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(139527);
                if (a.this.mKq == null) {
                    Log.e("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "mSameLayerMapView is null, may be not insert");
                    AppMethodBeat.o(139527);
                    return;
                }
                Log.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "onSurfaceChange");
                a.this.mKq.g(a.this.mSurfaceTexture);
                AppMethodBeat.o(139527);
            }
        });
        AppMethodBeat.o(139534);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final void PQ() {
        AppMethodBeat.i(139535);
        Log.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "handlePluginDestroy %d", Integer.valueOf(getId()));
        super.PQ();
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        AppMethodBeat.o(139535);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final String h(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        AppMethodBeat.i(139536);
        if (aVar instanceof com.tencent.mm.plugin.appbrand.h.b) {
            com.tencent.mm.plugin.appbrand.h.b bVar = (com.tencent.mm.plugin.appbrand.h.b) aVar;
            final f fVar = bVar.lqg;
            final p pVar = bVar.lqf;
            final JSONObject jSONObject = bVar.lnV;
            final int i2 = bVar.lqe;
            Log.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", Lb(), pVar.getName(), jSONObject.toString());
            AnonymousClass2 r0 = new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.d.a.AnonymousClass2 */

                public final void run() {
                    boolean z = false;
                    AppMethodBeat.i(139529);
                    if (pVar instanceof com.tencent.mm.plugin.appbrand.jsapi.ag.d.a.b) {
                        Log.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "Tummy insert");
                        e.xg(9);
                        new SyncTask<Boolean>() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.ag.d.a.AnonymousClass2.AnonymousClass1 */

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // com.tencent.mm.sdk.platformtools.SyncTask
                            public final /* synthetic */ Boolean run() {
                                b bVar;
                                AppMethodBeat.i(139528);
                                a aVar = a.this;
                                com.tencent.mm.plugin.appbrand.jsapi.ag.d.a.b bVar2 = (com.tencent.mm.plugin.appbrand.jsapi.ag.d.a.b) pVar;
                                f fVar = fVar;
                                JSONObject jSONObject = jSONObject;
                                SurfaceTexture surfaceTexture = a.this.mSurfaceTexture;
                                Log.i("MicroMsg.JsApiInsertXWebMap", "insertXwebMap:%s", jSONObject);
                                double d2 = Util.getDouble(jSONObject.optString("centerLatitude"), 0.0d);
                                double d3 = Util.getDouble(jSONObject.optString("centerLongitude"), 0.0d);
                                float optDouble = (float) jSONObject.optDouble("scale", 16.0d);
                                int optInt = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0);
                                int optInt2 = jSONObject.optInt("skew", 0);
                                int i2 = Util.getInt(jSONObject.optString("maxScale"), 20);
                                int i3 = Util.getInt(jSONObject.optString("minScale"), 3);
                                if (Math.abs(d2) > 90.0d || Math.abs(d3) > 180.0d) {
                                    Log.d("MicroMsg.JsApiInsertXWebMap", "centerLatitude or centerLongitude value is error!");
                                    bVar = null;
                                } else {
                                    String appId = fVar.getAppId();
                                    String optString = jSONObject.optString("theme", "");
                                    String optString2 = jSONObject.optString("subKey", "");
                                    String appId2 = fVar.getAppId();
                                    String optString3 = jSONObject.optString("pluginId", "");
                                    if (TextUtils.isEmpty(optString3)) {
                                        optString3 = appId2;
                                    }
                                    int optInt3 = jSONObject.optInt("styleId", 0);
                                    boolean optBoolean = jSONObject.optBoolean("enableDarkMode", false);
                                    JSONObject optJSONObject = jSONObject.optJSONObject("position");
                                    if (optJSONObject == null) {
                                        Log.e("MicroMsg.JsApiInsertXWebMap", "positionObj is null, err, return");
                                        bVar = null;
                                    } else {
                                        int a2 = g.a(optJSONObject, "width", 0);
                                        int a3 = g.a(optJSONObject, "height", 0);
                                        String i4 = com.tencent.mm.plugin.appbrand.jsapi.k.a.f.i(fVar, jSONObject);
                                        HashMap hashMap = new HashMap(5);
                                        hashMap.put("theme", optString);
                                        hashMap.put("subKey", optString2);
                                        hashMap.put("subId", optString3);
                                        hashMap.put("styleId", Integer.valueOf(optInt3));
                                        hashMap.put("surface", surfaceTexture);
                                        hashMap.put("width", Integer.valueOf(a2));
                                        hashMap.put("height", Integer.valueOf(a3));
                                        hashMap.put("mapType", 2);
                                        hashMap.put("enableDarkMode", Integer.valueOf(optBoolean ? 1 : 0));
                                        bVar = ((c) com.tencent.luggage.a.e.M(c.class)).a(fVar.getContext(), i4, hashMap);
                                        if (bVar == null) {
                                            Log.e("MicroMsg.JsApiInsertXWebMap", "mapView is null, return");
                                            bVar = null;
                                        } else if (!com.tencent.mm.plugin.appbrand.jsapi.k.a.g.a(appId, com.tencent.mm.plugin.appbrand.jsapi.k.a.f.i(fVar, jSONObject), bVar)) {
                                            Log.e("MicroMsg.JsApiInsertXWebMap", "initMapView is false, return");
                                            bVar = null;
                                        } else {
                                            bVar.hw(jSONObject.optBoolean("enableZoom", true));
                                            bVar.hx(jSONObject.optBoolean("enableScroll", true));
                                            bVar.hy(jSONObject.optBoolean("enableRotate", false));
                                            bVar.hz(jSONObject.optBoolean("showCompass", false));
                                            bVar.setBuilding3dEffectEnable(jSONObject.optBoolean("enable3D", false));
                                            bVar.hA(jSONObject.optBoolean("enableOverlooking", false));
                                            bVar.hB(jSONObject.optBoolean("enableSatellite", false));
                                            bVar.hD(jSONObject.optBoolean("enableIndoor", true));
                                            bVar.hE(jSONObject.optBoolean("enableIndoorLevelPick", false));
                                            bVar.hF(jSONObject.optBoolean("showScale", true));
                                            if (jSONObject.has("enablePoi")) {
                                                bVar.setPoisEnabled(jSONObject.optBoolean("enablePoi", true));
                                            }
                                            if (jSONObject.has("enableBuilding")) {
                                                bVar.hG(jSONObject.optBoolean("enableBuilding", true));
                                            }
                                            bVar.setMaxZoomLevel(i2);
                                            bVar.setMinZoomLevel(i3);
                                            bVar.a(d2, d3, optDouble, (float) optInt, (float) optInt2);
                                            bVar.getView().setVisibility(0);
                                            if (bVar == null) {
                                                Log.e("MicroMsg.JsApiInsertXWebMap", "mapView is null, error, return");
                                                bVar = null;
                                            } else {
                                                int ab = com.tencent.mm.plugin.appbrand.jsapi.k.a.f.ab(jSONObject);
                                                bVar.a(new b.l(ab, fVar) {
                                                    /* class com.tencent.mm.plugin.appbrand.jsapi.ag.d.a.b.AnonymousClass1 */
                                                    final /* synthetic */ f lBw;
                                                    final /* synthetic */ int lYe;

                                                    {
                                                        this.lYe = r2;
                                                        this.lBw = r3;
                                                    }

                                                    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b.l
                                                    public final void a(b.u uVar) {
                                                        AppMethodBeat.i(139543);
                                                        t.b bVar = new t.b();
                                                        JSONObject jSONObject = new JSONObject();
                                                        try {
                                                            jSONObject.put("mapId", this.lYe);
                                                            jSONObject.put("data", uVar.data);
                                                        } catch (JSONException e2) {
                                                            Log.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", e2);
                                                        }
                                                        bVar.Zh(jSONObject.toString());
                                                        this.lBw.a(bVar, (int[]) null);
                                                        AppMethodBeat.o(139543);
                                                    }
                                                });
                                                bVar.a(new b.p(ab, fVar) {
                                                    /* class com.tencent.mm.plugin.appbrand.jsapi.ag.d.a.b.AnonymousClass2 */
                                                    final /* synthetic */ f lBw;
                                                    final /* synthetic */ int lYe;

                                                    {
                                                        this.lYe = r2;
                                                        this.lBw = r3;
                                                    }

                                                    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b.p
                                                    public final boolean b(b.u uVar) {
                                                        AppMethodBeat.i(139544);
                                                        t.f fVar = new t.f();
                                                        JSONObject jSONObject = new JSONObject();
                                                        try {
                                                            jSONObject.put("mapId", this.lYe);
                                                            jSONObject.put("data", uVar.data);
                                                        } catch (JSONException e2) {
                                                            Log.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", e2);
                                                        }
                                                        fVar.Zh(jSONObject.toString());
                                                        this.lBw.a(fVar, (int[]) null);
                                                        AppMethodBeat.o(139544);
                                                        return true;
                                                    }
                                                });
                                                bVar.a(new b.m(ab, fVar) {
                                                    /* class com.tencent.mm.plugin.appbrand.jsapi.ag.d.a.b.AnonymousClass3 */
                                                    final /* synthetic */ f lBw;
                                                    final /* synthetic */ int lYe;

                                                    {
                                                        this.lYe = r2;
                                                        this.lBw = r3;
                                                    }

                                                    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b.m
                                                    public final void e(double d2, double d3) {
                                                        AppMethodBeat.i(139545);
                                                        t.c cVar = new t.c();
                                                        JSONObject jSONObject = new JSONObject();
                                                        try {
                                                            jSONObject.put("mapId", this.lYe);
                                                            jSONObject.put("longitude", d2);
                                                            jSONObject.put("latitude", d3);
                                                        } catch (JSONException e2) {
                                                            Log.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", e2);
                                                        }
                                                        cVar.Zh(jSONObject.toString());
                                                        this.lBw.a(cVar, (int[]) null);
                                                        AppMethodBeat.o(139545);
                                                    }
                                                });
                                                bVar.a(new b.o(ab, fVar) {
                                                    /* class com.tencent.mm.plugin.appbrand.jsapi.ag.d.a.b.AnonymousClass4 */
                                                    final /* synthetic */ f lBw;
                                                    final /* synthetic */ int lYe;

                                                    {
                                                        this.lYe = r2;
                                                        this.lBw = r3;
                                                    }

                                                    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b.o
                                                    public final boolean c(b.u uVar) {
                                                        AppMethodBeat.i(139546);
                                                        t.e eVar = new t.e();
                                                        JSONObject jSONObject = new JSONObject();
                                                        try {
                                                            jSONObject.put("mapId", this.lYe);
                                                            jSONObject.put("data", uVar.data);
                                                        } catch (JSONException e2) {
                                                            Log.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", e2);
                                                        }
                                                        eVar.Zh(jSONObject.toString());
                                                        this.lBw.a(eVar, (int[]) null);
                                                        AppMethodBeat.o(139546);
                                                        return true;
                                                    }
                                                });
                                                bVar.a(new b.z(ab, fVar) {
                                                    /* class com.tencent.mm.plugin.appbrand.jsapi.ag.d.a.b.AnonymousClass5 */
                                                    final /* synthetic */ f lBw;
                                                    final /* synthetic */ int lYe;

                                                    {
                                                        this.lYe = r2;
                                                        this.lBw = r3;
                                                    }

                                                    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b.z
                                                    public final void a(b.t tVar) {
                                                        AppMethodBeat.i(139547);
                                                        t.g gVar = new t.g();
                                                        JSONObject jSONObject = new JSONObject();
                                                        try {
                                                            jSONObject.put("mapId", this.lYe);
                                                            jSONObject.put("latitude", tVar.latitude);
                                                            jSONObject.put("longitude", tVar.longitude);
                                                            jSONObject.put("name", tVar.name);
                                                            if (!Util.isNullOrNil(tVar.buildingId)) {
                                                                jSONObject.put("buildingId", tVar.buildingId);
                                                                jSONObject.put("floorName", tVar.floorName);
                                                            }
                                                        } catch (JSONException e2) {
                                                            Log.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", e2);
                                                        }
                                                        gVar.Zh(jSONObject.toString());
                                                        this.lBw.a(gVar, (int[]) null);
                                                        Log.v("MicroMsg.JsApiInsertXWebMap", "OnMapPoiClick %s", jSONObject.toString());
                                                        AppMethodBeat.o(139547);
                                                    }
                                                });
                                                bVar.hH(jSONObject.optBoolean("showLocation"));
                                                bVar.a(new b.w(ab, fVar, bVar) {
                                                    /* class com.tencent.mm.plugin.appbrand.jsapi.ag.d.a.b.AnonymousClass6 */
                                                    JSONObject jsonObject = new JSONObject();
                                                    final /* synthetic */ f lBw;
                                                    final /* synthetic */ int lYe;
                                                    final /* synthetic */ com.tencent.mm.plugin.appbrand.jsapi.k.a.b lYl;
                                                    AtomicBoolean lYo = new AtomicBoolean(false);
                                                    float lYp;
                                                    t.h lYq = new t.h();

                                                    {
                                                        this.lYe = r5;
                                                        this.lBw = r6;
                                                        this.lYl = r7;
                                                        AppMethodBeat.i(215882);
                                                        AppMethodBeat.o(215882);
                                                    }

                                                    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b.w
                                                    public final void a(b.a aVar, boolean z) {
                                                        AppMethodBeat.i(139549);
                                                        if (this.lYo.compareAndSet(false, true)) {
                                                            try {
                                                                this.jsonObject.remove("mapId");
                                                                this.jsonObject.put("mapId", this.lYe);
                                                                this.jsonObject.remove("type");
                                                                this.jsonObject.put("type", "begin");
                                                                if (z) {
                                                                    this.jsonObject.put("causedBy", "gesture");
                                                                } else {
                                                                    this.jsonObject.put("causedBy", "update");
                                                                }
                                                                this.jsonObject.remove(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION);
                                                                this.jsonObject.remove("skew");
                                                            } catch (JSONException e2) {
                                                                Log.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", e2);
                                                            }
                                                            this.lYq.Zh(this.jsonObject.toString());
                                                            this.lBw.a(this.lYq, (int[]) null);
                                                            this.lYp = aVar.zoom;
                                                            Log.v("MicroMsg.JsApiInsertXWebMap", "onCameraChange begin");
                                                        }
                                                        AppMethodBeat.o(139549);
                                                    }

                                                    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b.w
                                                    public final void b(b.a aVar, boolean z) {
                                                        AppMethodBeat.i(139550);
                                                        if (this.lYo.compareAndSet(true, false)) {
                                                            try {
                                                                this.jsonObject.remove("mapId");
                                                                this.jsonObject.put("mapId", this.lYe);
                                                                this.jsonObject.remove("type");
                                                                this.jsonObject.put("type", "end");
                                                                this.jsonObject.remove("causedBy");
                                                                boolean z2 = aVar.zoom != this.lYp;
                                                                if (!z) {
                                                                    this.jsonObject.put("causedBy", "update");
                                                                } else if (z2) {
                                                                    this.jsonObject.put("causedBy", "scale");
                                                                } else {
                                                                    this.jsonObject.put("causedBy", "drag");
                                                                }
                                                                this.jsonObject.remove(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION);
                                                                this.jsonObject.put(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, (double) aVar.mat);
                                                                this.jsonObject.remove("skew");
                                                                this.jsonObject.put("skew", (double) aVar.skew);
                                                                this.jsonObject.remove("scale");
                                                                this.jsonObject.put("scale", (double) this.lYl.getZoom());
                                                                a.a(this.lYl, this.jsonObject);
                                                                a.b(this.lYl, this.jsonObject);
                                                            } catch (JSONException e2) {
                                                                Log.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", e2);
                                                            }
                                                            this.lYq.Zh(this.jsonObject.toString());
                                                            this.lBw.a(this.lYq, (int[]) null);
                                                            Log.v("MicroMsg.JsApiInsertXWebMap", "onCameraChange finish, result:%s", this.jsonObject.toString());
                                                        }
                                                        AppMethodBeat.o(139550);
                                                    }
                                                });
                                                bVar.a(new b.x(ab, fVar) {
                                                    /* class com.tencent.mm.plugin.appbrand.jsapi.ag.d.a.b.AnonymousClass7 */
                                                    final /* synthetic */ f lBw;
                                                    final /* synthetic */ int lYe;

                                                    {
                                                        this.lYe = r2;
                                                        this.lBw = r3;
                                                    }

                                                    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b.x
                                                    public final void a(b.f fVar) {
                                                        AppMethodBeat.i(139551);
                                                        t.d dVar = new t.d();
                                                        JSONObject jSONObject = new JSONObject();
                                                        try {
                                                            jSONObject.put("mapId", this.lYe);
                                                            if (fVar != null) {
                                                                jSONObject.put("buildingId", fVar.buildingId);
                                                                jSONObject.put("buildingName", fVar.buildingName);
                                                                if (fVar.maA != null && fVar.maA.size() > 0) {
                                                                    JSONArray jSONArray = new JSONArray();
                                                                    for (b.g gVar : fVar.maA) {
                                                                        JSONObject jSONObject2 = new JSONObject();
                                                                        jSONObject2.put("name", gVar.floorName);
                                                                        jSONArray.put(jSONObject2);
                                                                    }
                                                                    jSONObject.put("floorList", jSONArray);
                                                                }
                                                                jSONObject.put("floorIndex", fVar.maB);
                                                            }
                                                        } catch (JSONException e2) {
                                                            Log.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", e2);
                                                        }
                                                        dVar.Zh(jSONObject.toString());
                                                        this.lBw.a(dVar, (int[]) null);
                                                        this.lBw.a(dVar);
                                                        Log.v("MicroMsg.JsApiInsertXWebMap", "OnMapIndoorStateChange:%s", jSONObject.toString());
                                                        AppMethodBeat.o(139551);
                                                    }
                                                });
                                                bVar.a(new b.s(ab, fVar) {
                                                    /* class com.tencent.mm.plugin.appbrand.jsapi.ag.d.a.b.AnonymousClass8 */
                                                    final /* synthetic */ f lBw;
                                                    final /* synthetic */ int lYe;

                                                    {
                                                        this.lYe = r2;
                                                        this.lBw = r3;
                                                    }

                                                    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b.s
                                                    public final void d(double d2, double d3) {
                                                        AppMethodBeat.i(215883);
                                                        t.a aVar = new t.a();
                                                        JSONObject jSONObject = new JSONObject();
                                                        try {
                                                            jSONObject.put("mapId", this.lYe);
                                                            jSONObject.put("longitude", d3);
                                                            jSONObject.put("latitude", d2);
                                                        } catch (JSONException e2) {
                                                            Log.e("MicroMsg.JsApiInsertXWebMap", "put JSON data error : %s", e2);
                                                        }
                                                        aVar.Zh(jSONObject.toString());
                                                        this.lBw.a(aVar, (int[]) null);
                                                        Log.v("MicroMsg.JsApiInsertXWebMap", "MapOnMapAnchorPointClick:%s", jSONObject.toString());
                                                        AppMethodBeat.o(215883);
                                                    }
                                                });
                                            }
                                        }
                                    }
                                }
                                aVar.mKq = bVar;
                                Boolean bool = Boolean.FALSE;
                                AppMethodBeat.o(139528);
                                return bool;
                            }
                        }.exec(a.this.mKp);
                        a aVar = a.this;
                        f fVar = fVar;
                        JSONObject jSONObject = jSONObject;
                        fVar.i(i2, pVar.h("ok", null));
                        e.xg(10);
                        if (fVar instanceof h) {
                            h hVar = (h) fVar;
                            hVar.a(new i.b() {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.d.a.AnonymousClass3 */

                                @Override // com.tencent.mm.plugin.appbrand.jsapi.i.b
                                public final void onBackground() {
                                    AppMethodBeat.i(139530);
                                    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "onBackground");
                                    if (a.this.mKq != null) {
                                        a.this.mKq.onPause();
                                    }
                                    AppMethodBeat.o(139530);
                                }
                            });
                            hVar.a(new i.d() {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.d.a.AnonymousClass4 */

                                @Override // com.tencent.mm.plugin.appbrand.jsapi.i.d
                                public final void onForeground() {
                                    AppMethodBeat.i(139531);
                                    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "onForeground");
                                    if (a.this.mKq != null) {
                                        a.this.mKq.onResume();
                                    }
                                    AppMethodBeat.o(139531);
                                }
                            });
                            hVar.a(new i.c(hVar, fVar, jSONObject) {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.ag.d.a.AnonymousClass5 */
                                final /* synthetic */ JSONObject cvS;
                                final /* synthetic */ f lBw;
                                final /* synthetic */ h mIZ;

                                {
                                    this.mIZ = r2;
                                    this.lBw = r3;
                                    this.cvS = r4;
                                }

                                @Override // com.tencent.mm.plugin.appbrand.jsapi.i.c
                                public final void onDestroy() {
                                    AppMethodBeat.i(139532);
                                    Log.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "onDestroy");
                                    this.mIZ.b(this);
                                    a.this.mKq = null;
                                    com.tencent.mm.plugin.appbrand.jsapi.k.a.g.dA(this.lBw.getAppId(), com.tencent.mm.plugin.appbrand.jsapi.k.a.f.i(this.lBw, this.cvS));
                                    a.this.release();
                                    AppMethodBeat.o(139532);
                                }
                            });
                        }
                        AppMethodBeat.o(139529);
                    } else if (pVar instanceof d) {
                        Log.i("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "Tummy update");
                        e.xg(12);
                        a aVar2 = a.this;
                        f fVar2 = fVar;
                        JSONObject jSONObject2 = jSONObject;
                        p pVar = pVar;
                        int i2 = i2;
                        if (aVar2.mKq == null || !d.j(fVar2, jSONObject2)) {
                            Log.e("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "update fail");
                            e.xg(14);
                            fVar2.i(i2, pVar.h("fail:internal error", null));
                            AppMethodBeat.o(139529);
                            return;
                        }
                        fVar2.i(i2, pVar.h("ok", null));
                        e.xg(13);
                        AppMethodBeat.o(139529);
                    } else {
                        if (pVar instanceof com.tencent.mm.plugin.appbrand.jsapi.ag.d.a.c) {
                            e.xg(15);
                            a aVar3 = a.this;
                            f fVar3 = fVar;
                            JSONObject jSONObject3 = jSONObject;
                            p pVar2 = pVar;
                            int i3 = i2;
                            if (jSONObject3 == null) {
                                Log.e("MicroMsg.JsApiRemoveXWebMap", "data is null");
                            } else {
                                Log.i("MicroMsg.JsApiRemoveXWebMap", "removeXWebMap:%s", jSONObject3);
                                com.tencent.mm.plugin.appbrand.jsapi.k.a.g.dA(fVar3.getAppId(), com.tencent.mm.plugin.appbrand.jsapi.k.a.f.i(fVar3, jSONObject3));
                                z = true;
                            }
                            if (z) {
                                fVar3.i(i3, pVar2.h("ok", null));
                                aVar3.mKq = null;
                                e.xg(16);
                            } else {
                                Log.e("MicroMsg.AppBrand.SameLayer.AppBrandMapPluginHandler", "remove fail");
                                e.xg(17);
                                fVar3.i(i3, pVar2.h("fail:internal error", null));
                            }
                            aVar3.release();
                        }
                        AppMethodBeat.o(139529);
                    }
                }
            };
            if (this.mHandler.getLooper() == Looper.myLooper()) {
                r0.run();
            } else {
                this.mHandler.post(r0);
            }
        }
        AppMethodBeat.o(139536);
        return null;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        return true;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final void o(MotionEvent motionEvent) {
        AppMethodBeat.i(139537);
        if (this.mKq != null) {
            this.mKq.onTouchEvent(motionEvent);
        }
        AppMethodBeat.o(139537);
    }

    /* access modifiers changed from: package-private */
    public final void release() {
        AppMethodBeat.i(139538);
        this.mHandler.quitSafely();
        AppMethodBeat.o(139538);
    }
}
