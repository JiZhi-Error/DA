package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class t extends com.tencent.mm.plugin.appbrand.jsapi.base.b {
    public static final int CTRL_INDEX = 2;
    public static final String NAME = "insertMap";

    public static class a extends bc {
        private static final int CTRL_INDEX = 832;
        private static final String NAME = "onMapAnchorPointClick";
    }

    public static class b extends bc {
        private static final int CTRL_INDEX = 199;
        private static final String NAME = "onMapCalloutClick";
    }

    public static class c extends bc {
        private static final int CTRL_INDEX = 151;
        private static final String NAME = "onMapClick";
    }

    public static class d extends bc {
        private static final int CTRL_INDEX = 524;
        private static final String NAME = "onMapIndoorChange";
    }

    public static class e extends bc {
        private static final int CTRL_INDEX = 679;
        private static final String NAME = "onMapLabelClick";
    }

    public static class f extends bc {
        private static final int CTRL_INDEX = 142;
        private static final String NAME = "onMapMarkerClick";
    }

    public static class g extends bc {
        private static final int CTRL_INDEX = 511;
        private static final String NAME = "onMapPoiClick";
    }

    public static class h extends bc {
        private static final int CTRL_INDEX = 147;
        private static final String NAME = "onMapRegionChange";
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final View a(final com.tencent.mm.plugin.appbrand.jsapi.h hVar, final JSONObject jSONObject) {
        AppMethodBeat.i(143683);
        float f2 = Util.getFloat(jSONObject.optString("centerLatitude"), 0.0f);
        float f3 = Util.getFloat(jSONObject.optString("centerLongitude"), 0.0f);
        float f4 = Util.getFloat(jSONObject.optString("scale"), 16.0f);
        int optInt = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, 0);
        int optInt2 = jSONObject.optInt("skew", 0);
        int i2 = Util.getInt(jSONObject.optString("maxScale"), 20);
        int i3 = Util.getInt(jSONObject.optString("minScale"), 3);
        if (Math.abs(f2) > 90.0f || Math.abs(f3) > 180.0f) {
            Log.d("MicroMsg.JsApiInsertMap", "centerLatitude or centerLongitude value is error!");
            AppMethodBeat.o(143683);
            return null;
        }
        com.tencent.mm.plugin.appbrand.jsapi.k.a.e.xg(0);
        final String appId = hVar.getAppId();
        Log.i("MicroMsg.JsApiInsertMap", "insertMap appId:%s viewId:%d data:%s", appId, Integer.valueOf(H(jSONObject)), jSONObject);
        final com.tencent.mm.plugin.appbrand.jsapi.k.a.b b2 = ((com.tencent.mm.plugin.appbrand.jsapi.k.a.c) com.tencent.luggage.a.e.M(com.tencent.mm.plugin.appbrand.jsapi.k.a.c.class)).b(hVar, jSONObject);
        if (b2 == null) {
            Log.e("MicroMsg.JsApiInsertMap", "mapView is null, return");
            AppMethodBeat.o(143683);
            return null;
        } else if (!com.tencent.mm.plugin.appbrand.jsapi.k.a.g.a(appId, com.tencent.mm.plugin.appbrand.jsapi.k.a.f.i(hVar, jSONObject), b2)) {
            Log.e("MicroMsg.JsApiInsertMap", "initMapView is false, return");
            com.tencent.mm.plugin.appbrand.jsapi.k.a.e.xg(1);
            AppMethodBeat.o(143683);
            return null;
        } else {
            com.tencent.mm.plugin.appbrand.jsapi.k.a.e.xg(2);
            b2.hw(jSONObject.optBoolean("enableZoom", true));
            b2.hx(jSONObject.optBoolean("enableScroll", true));
            b2.hy(jSONObject.optBoolean("enableRotate", false));
            b2.hz(jSONObject.optBoolean("showCompass", false));
            b2.setBuilding3dEffectEnable(jSONObject.optBoolean("enable3D", false));
            b2.hA(jSONObject.optBoolean("enableOverlooking", false));
            b2.hB(jSONObject.optBoolean("enableSatellite", false));
            b2.hD(jSONObject.optBoolean("enableIndoor", true));
            b2.hE(jSONObject.optBoolean("enableIndoorLevelPick", false));
            b2.hF(jSONObject.optBoolean("showScale", true));
            if (jSONObject.has("enablePoi")) {
                b2.setPoisEnabled(jSONObject.optBoolean("enablePoi", true));
            }
            if (jSONObject.has("enableBuilding")) {
                b2.hG(jSONObject.optBoolean("enableBuilding", true));
            }
            b2.setMaxZoomLevel(i2);
            b2.setMinZoomLevel(i3);
            b2.a((double) f2, (double) f3, f4, (float) optInt, (float) optInt2);
            hVar.a(new i.b() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.k.t.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.i.b
                public final void onBackground() {
                    AppMethodBeat.i(143671);
                    Log.i("MicroMsg.JsApiInsertMap", "onBackground");
                    if (b2 != null) {
                        b2.onPause();
                    }
                    AppMethodBeat.o(143671);
                }
            });
            hVar.a(new i.d() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.k.t.AnonymousClass4 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.i.d
                public final void onForeground() {
                    AppMethodBeat.i(143673);
                    Log.i("MicroMsg.JsApiInsertMap", "onForeground");
                    if (b2 != null) {
                        b2.onResume();
                    }
                    AppMethodBeat.o(143673);
                }
            });
            hVar.a(new i.c() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.k.t.AnonymousClass5 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.i.c
                public final void onDestroy() {
                    AppMethodBeat.i(143674);
                    Log.i("MicroMsg.JsApiInsertMap", "onDestroy");
                    hVar.b(this);
                    com.tencent.mm.plugin.appbrand.jsapi.k.a.g.dA(appId, com.tencent.mm.plugin.appbrand.jsapi.k.a.f.i(hVar, jSONObject));
                    AppMethodBeat.o(143674);
                }
            });
            b2.getView().setVisibility(0);
            CoverViewContainer coverViewContainer = new CoverViewContainer(hVar.getContext(), b2.getView());
            AppMethodBeat.o(143683);
            return coverViewContainer;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(143684);
        try {
            int optInt = jSONObject.optInt("mapId");
            AppMethodBeat.o(143684);
            return optInt;
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiInsertMap", "get mapId error, exception : %s", e2);
            AppMethodBeat.o(143684);
            return -1;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final void a(final com.tencent.mm.plugin.appbrand.jsapi.h hVar, final int i2, View view, JSONObject jSONObject) {
        AppMethodBeat.i(143685);
        final com.tencent.mm.plugin.appbrand.jsapi.k.a.b dz = com.tencent.mm.plugin.appbrand.jsapi.k.a.g.dz(hVar.getAppId(), com.tencent.mm.plugin.appbrand.jsapi.k.a.f.i(hVar, jSONObject));
        if (dz == null) {
            Log.e("MicroMsg.JsApiInsertMap", "mapView is null, error, return");
            AppMethodBeat.o(143685);
            return;
        }
        dz.a(new b.l() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.k.t.AnonymousClass6 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b.l
            public final void a(b.u uVar) {
                AppMethodBeat.i(143675);
                b bVar = new b();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("mapId", i2);
                    jSONObject.put("data", uVar.data);
                } catch (JSONException e2) {
                    Log.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", e2);
                }
                bVar.Zh(jSONObject.toString());
                hVar.a(bVar, (int[]) null);
                AppMethodBeat.o(143675);
            }
        });
        dz.a(new b.p() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.k.t.AnonymousClass7 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b.p
            public final boolean b(b.u uVar) {
                AppMethodBeat.i(143676);
                f fVar = new f();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("mapId", i2);
                    jSONObject.put("data", uVar.data);
                } catch (JSONException e2) {
                    Log.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", e2);
                }
                fVar.Zh(jSONObject.toString());
                hVar.a(fVar, (int[]) null);
                AppMethodBeat.o(143676);
                return true;
            }
        });
        dz.a(new b.m() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.k.t.AnonymousClass8 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b.m
            public final void e(double d2, double d3) {
                AppMethodBeat.i(143677);
                c cVar = new c();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("mapId", i2);
                    jSONObject.put("longitude", d2);
                    jSONObject.put("latitude", d3);
                } catch (JSONException e2) {
                    Log.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", e2);
                }
                cVar.Zh(jSONObject.toString());
                hVar.a(cVar, (int[]) null);
                AppMethodBeat.o(143677);
            }
        });
        dz.a(new b.o() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.k.t.AnonymousClass9 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b.o
            public final boolean c(b.u uVar) {
                AppMethodBeat.i(143678);
                e eVar = new e();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("mapId", i2);
                    jSONObject.put("data", uVar.data);
                } catch (JSONException e2) {
                    Log.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", e2);
                }
                eVar.Zh(jSONObject.toString());
                hVar.a(eVar, (int[]) null);
                AppMethodBeat.o(143678);
                return true;
            }
        });
        dz.a(new b.z() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.k.t.AnonymousClass10 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b.z
            public final void a(b.t tVar) {
                AppMethodBeat.i(143679);
                g gVar = new g();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("mapId", i2);
                    jSONObject.put("latitude", tVar.latitude);
                    jSONObject.put("longitude", tVar.longitude);
                    jSONObject.put("name", tVar.name);
                    if (!Util.isNullOrNil(tVar.buildingId)) {
                        jSONObject.put("buildingId", tVar.buildingId);
                        jSONObject.put("floorName", tVar.floorName);
                    }
                } catch (JSONException e2) {
                    Log.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", e2);
                }
                gVar.Zh(jSONObject.toString());
                hVar.a(gVar, (int[]) null);
                Log.v("MicroMsg.JsApiInsertMap", "OnMapPoiClick %s", jSONObject.toString());
                AppMethodBeat.o(143679);
            }
        });
        dz.hH(jSONObject.optBoolean("showLocation"));
        dz.a(new b.w() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.k.t.AnonymousClass11 */
            JSONObject jsonObject = new JSONObject();
            AtomicBoolean lYo = new AtomicBoolean(false);
            float lYp;
            h lYq = new h();

            {
                AppMethodBeat.i(234550);
                AppMethodBeat.o(234550);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b.w
            public final void a(b.a aVar, boolean z) {
                AppMethodBeat.i(143681);
                if (this.lYo.compareAndSet(false, true)) {
                    try {
                        this.jsonObject.remove("mapId");
                        this.jsonObject.put("mapId", i2);
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
                        Log.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", e2);
                    }
                    this.lYq.Zh(this.jsonObject.toString());
                    hVar.a(this.lYq, (int[]) null);
                    this.lYp = aVar.zoom;
                    Log.v("MicroMsg.JsApiInsertMap", "onCameraChange begin");
                }
                AppMethodBeat.o(143681);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b.w
            public final void b(b.a aVar, boolean z) {
                AppMethodBeat.i(143682);
                if (this.lYo.compareAndSet(true, false)) {
                    try {
                        this.jsonObject.remove("mapId");
                        this.jsonObject.put("mapId", i2);
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
                        this.jsonObject.put("scale", (double) dz.getZoom());
                        a.a(dz, this.jsonObject);
                        a.b(dz, this.jsonObject);
                    } catch (JSONException e2) {
                        Log.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", e2);
                    }
                    this.lYq.Zh(this.jsonObject.toString());
                    hVar.a(this.lYq, (int[]) null);
                    Log.v("MicroMsg.JsApiInsertMap", "onCameraChange finish, result:%s", this.jsonObject.toString());
                }
                AppMethodBeat.o(143682);
            }
        });
        dz.a(new b.x() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.k.t.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b.x
            public final void a(b.f fVar) {
                AppMethodBeat.i(143672);
                d dVar = new d();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("mapId", i2);
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
                    Log.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", e2);
                }
                dVar.Zh(jSONObject.toString());
                hVar.a(dVar, (int[]) null);
                Log.v("MicroMsg.JsApiInsertMap", "OnMapIndoorStateChange:%s", jSONObject.toString());
                AppMethodBeat.o(143672);
            }
        });
        dz.a(new b.s() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.k.t.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b.s
            public final void d(double d2, double d3) {
                AppMethodBeat.i(234549);
                a aVar = new a();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("mapId", i2);
                    jSONObject.put("longitude", d3);
                    jSONObject.put("latitude", d2);
                } catch (JSONException e2) {
                    Log.e("MicroMsg.JsApiInsertMap", "put JSON data error : %s", e2);
                }
                aVar.Zh(jSONObject.toString());
                hVar.a(aVar, (int[]) null);
                Log.v("MicroMsg.JsApiInsertMap", "MapOnMapAnchorPointClick:%s", jSONObject.toString());
                AppMethodBeat.o(234549);
            }
        });
        AppMethodBeat.o(143685);
    }
}
