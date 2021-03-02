package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.a;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.luggage.a.e;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.a;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.permission.r;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.wxmm.v2helper;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiChooseMultiMedia extends d {
    public static final int CTRL_INDEX = 549;
    public static final String NAME = "chooseMultiMedia";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(final f fVar, final JSONObject jSONObject, final int i2) {
        boolean z;
        String str;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean a2;
        AppMethodBeat.i(46542);
        if (p.Um(fVar.getAppId()).kCX) {
            fVar.i(i2, h("cancel", null));
            AppMethodBeat.o(46542);
            return;
        }
        final Context context = fVar.getContext();
        if (!(context instanceof Activity)) {
            fVar.i(i2, h("fail", null));
            AppMethodBeat.o(46542);
        } else if (jSONObject == null) {
            Log.e("MicroMsg.JsApiChooseMultiMedia", "chooseMedia fail, data is null");
            fVar.i(i2, h("fail:data is null", null));
            AppMethodBeat.o(46542);
        } else {
            int optInt = jSONObject.optInt("maxDuration", 10);
            Log.i("MicroMsg.JsApiChooseMultiMedia", "videoMaxDuration: %d.", Integer.valueOf(optInt));
            if (optInt <= 0 || optInt > 1800) {
                Log.e("MicroMsg.JsApiChooseMultiMedia", "chooseMedia fail, invalid maxDuration parameter");
                fVar.i(i2, h("fail:invalid maxDuration parameter", null));
                AppMethodBeat.o(46542);
                return;
            }
            context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_locCache", 0).edit().putString("locStr", null).apply();
            ((com.tencent.mm.plugin.appbrand.utils.b.a) e.M(com.tencent.mm.plugin.appbrand.utils.b.a.class)).b("wgs84", new a.b() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.utils.b.a.b
                public final void a(int i2, String str, a.C0814a aVar) {
                    AppMethodBeat.i(46493);
                    if (i2 == 0) {
                        int i3 = (int) (aVar.longitude * 1000000.0d);
                        StringBuilder sb = new StringBuilder();
                        sb.append((int) (aVar.latitude * 1000000.0d));
                        sb.append(",");
                        sb.append(i3);
                        context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_locCache", 0).edit().putString("locStr", sb.toString()).apply();
                        Log.d("MicroMsg.JsApiChooseMultiMedia", "onLocationChange latitude %f, longitude: %f, locStr: %s.", Double.valueOf(aVar.latitude), Double.valueOf(aVar.longitude), sb);
                        ((com.tencent.mm.plugin.appbrand.utils.b.a) e.M(com.tencent.mm.plugin.appbrand.utils.b.a.class)).c("wgs84", this, null);
                        AppMethodBeat.o(46493);
                        return;
                    }
                    Log.e("MicroMsg.JsApiChooseMultiMedia", "onLocationChange error, errCode: %d.", Integer.valueOf(i2));
                    AppMethodBeat.o(46493);
                }
            }, null);
            int optInt2 = jSONObject.optInt("count", 9);
            JSONObject optJSONObject = jSONObject.optJSONObject(FirebaseAnalytics.b.LOCATION);
            double d2 = 181.0d;
            double d3 = 91.0d;
            if (optJSONObject != null) {
                d2 = optJSONObject.optDouble("longitude");
                d3 = optJSONObject.optDouble("latitude");
                if (Double.isNaN(d2) || Double.isNaN(d3)) {
                    d2 = 181.0d;
                    d3 = 91.0d;
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = true;
            }
            String optString = jSONObject.optString("poiName", null);
            if (TextUtils.isEmpty(optString)) {
                str = fVar.getContext().getString(R.string.a2_);
            } else {
                str = optString;
            }
            double optDouble = jSONObject.optDouble("locationRadius", 50.0d);
            JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("cameraType");
            int optInt3 = jSONObject.optInt("pickAlbumType", 0);
            if (optJSONArray == null || optJSONArray.length() == 0) {
                z3 = true;
                z2 = true;
            } else {
                z3 = optJSONArray.toString().contains("camera");
                z2 = optJSONArray.toString().contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
            }
            if (optJSONArray2 == null || optJSONArray2.length() == 0) {
                z4 = false;
                z5 = false;
            } else {
                boolean contains = optJSONArray2.toString().contains("video");
                z4 = optJSONArray2.toString().contains("photo");
                z5 = contains;
            }
            if (z3) {
                r.b(fVar.getAppId(), new a.AbstractC0015a() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia.AnonymousClass4 */

                    @Override // android.support.v4.app.a.AbstractC0015a
                    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
                        AppMethodBeat.i(46496);
                        if (i2 != 113) {
                            AppMethodBeat.o(46496);
                        } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                            fVar.i(i2, JsApiChooseMultiMedia.this.h("fail:system permission denied", null));
                            AppMethodBeat.o(46496);
                        } else {
                            JsApiChooseMultiMedia.this.a(fVar, jSONObject, i2);
                            AppMethodBeat.o(46496);
                        }
                    }
                });
                Context context2 = fVar.getContext();
                if (!(context2 instanceof Activity)) {
                    fVar.i(i2, h("fail", null));
                    a2 = false;
                } else {
                    a2 = com.tencent.mm.pluginsdk.permission.b.a((Activity) context2, "android.permission.CAMERA", 113, "", "");
                    if (a2) {
                        r.aeq(fVar.getAppId());
                    }
                }
                if (!a2) {
                    AppMethodBeat.o(46542);
                    return;
                }
            }
            p.Un(fVar.getAppId()).kCX = true;
            h.a(fVar.getAppId(), new h.c() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.h.c
                public final void onResume() {
                    AppMethodBeat.i(46494);
                    p.Un(fVar.getAppId()).kCX = false;
                    h.b(fVar.getAppId(), this);
                    AppMethodBeat.o(46494);
                }
            });
            ChooseRequest chooseRequest = new ChooseRequest();
            chooseRequest.appId = fVar.getAppId();
            chooseRequest.count = optInt2;
            double[] c2 = a.C0451a.c(d2, d3);
            chooseRequest.longitude = c2[0];
            chooseRequest.latitude = c2[1];
            chooseRequest.kHV = str;
            chooseRequest.jiP = optDouble;
            chooseRequest.mch = z3;
            chooseRequest.mci = z2;
            chooseRequest.kyt = optInt;
            chooseRequest.mde = z5;
            chooseRequest.mdf = z4;
            chooseRequest.mdg = optInt3;
            chooseRequest.mdh = z;
            com.tencent.mm.plugin.appbrand.ipc.a.a(context, chooseRequest, new AppBrandProxyUIProcessTask.b<ChooseResult>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia.AnonymousClass3 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask$ProcessResult] */
                @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b
                public final /* synthetic */ void a(ChooseResult chooseResult) {
                    AppMethodBeat.i(46495);
                    ChooseResult chooseResult2 = chooseResult;
                    if (chooseResult2 == null) {
                        fVar.i(i2, JsApiChooseMultiMedia.this.h("fail", null));
                        AppMethodBeat.o(46495);
                        return;
                    }
                    switch (chooseResult2.resultCode) {
                        case -1:
                            HashMap hashMap = new HashMap();
                            try {
                                hashMap.put("tempFiles", new JSONArray(chooseResult2.mdi));
                            } catch (Exception e2) {
                                Log.e("MicroMsg.JsApiChooseMultiMedia", "err tempFiles json object create");
                            }
                            fVar.i(i2, JsApiChooseMultiMedia.this.n("ok", hashMap));
                            AppMethodBeat.o(46495);
                            return;
                        case 0:
                            fVar.i(i2, JsApiChooseMultiMedia.this.h("cancel", null));
                            AppMethodBeat.o(46495);
                            return;
                        default:
                            fVar.i(i2, JsApiChooseMultiMedia.this.h("fail", null));
                            AppMethodBeat.o(46495);
                            return;
                    }
                }
            });
            AppMethodBeat.o(46542);
        }
    }

    static final class a extends AppBrandProxyUIProcessTask {
        private q gxX;
        int mcq = 7;
        private DialogInterface.OnCancelListener mcu;
        ChooseRequest mdj;
        ChooseResult mdk = new ChooseResult();

        private a() {
            AppMethodBeat.i(46511);
            AppMethodBeat.o(46511);
        }

        static /* synthetic */ AppBrandLocalVideoObject a(a aVar, String str, boolean z) {
            AppMethodBeat.i(46528);
            AppBrandLocalVideoObject as = aVar.as(str, z);
            AppMethodBeat.o(46528);
            return as;
        }

        static /* synthetic */ void a(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(46529);
            aVar.b(processResult);
            AppMethodBeat.o(46529);
        }

        static /* synthetic */ String aaj(String str) {
            AppMethodBeat.i(46526);
            String aah = aah(str);
            AppMethodBeat.o(46526);
            return aah;
        }

        static /* synthetic */ String aak(String str) {
            AppMethodBeat.i(46527);
            String aai = aai(str);
            AppMethodBeat.o(46527);
            return aai;
        }

        static /* synthetic */ String aal(String str) {
            AppMethodBeat.i(46530);
            String aag = aag(str);
            AppMethodBeat.o(46530);
            return aag;
        }

        static /* synthetic */ String b(String str, long j2, int i2, int i3, int i4, String str2, String str3) {
            AppMethodBeat.i(46538);
            String a2 = a(str, j2, i2, i3, i4, str2, str3);
            AppMethodBeat.o(46538);
            return a2;
        }

        static /* synthetic */ String b(String str, long j2, int i2, int i3, String str2, String str3) {
            AppMethodBeat.i(46534);
            String a2 = a(str, j2, i2, i3, str2, str3);
            AppMethodBeat.o(46534);
            return a2;
        }

        static /* synthetic */ void b(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(46532);
            aVar.b(processResult);
            AppMethodBeat.o(46532);
        }

        static /* synthetic */ BackwardSupportUtil.ExifHelper.LatLongData bHw() {
            AppMethodBeat.i(46533);
            BackwardSupportUtil.ExifHelper.LatLongData bHu = bHu();
            AppMethodBeat.o(46533);
            return bHu;
        }

        static /* synthetic */ void c(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(46535);
            aVar.b(processResult);
            AppMethodBeat.o(46535);
        }

        static /* synthetic */ void d(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(46536);
            aVar.b(processResult);
            AppMethodBeat.o(46536);
        }

        static /* synthetic */ void e(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(46537);
            aVar.b(processResult);
            AppMethodBeat.o(46537);
        }

        static /* synthetic */ void f(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(46539);
            aVar.b(processResult);
            AppMethodBeat.o(46539);
        }

        static /* synthetic */ void g(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(46540);
            aVar.b(processResult);
            AppMethodBeat.o(46540);
        }

        static /* synthetic */ void h(a aVar, AppBrandProxyUIProcessTask.ProcessResult processResult) {
            AppMethodBeat.i(46541);
            aVar.b(processResult);
            AppMethodBeat.o(46541);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
        public final void a(AppBrandProxyUIProcessTask.ProcessRequest processRequest) {
            boolean z;
            boolean z2;
            int i2 = 3;
            int i3 = 0;
            AppMethodBeat.i(46512);
            this.mdj = (ChooseRequest) processRequest;
            if (Util.getAvailableMemoryMB(bDF()) > 200) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                u.makeText(bDF(), MMApplicationContext.getResources().getString(R.string.jh), 1).show();
            }
            bDF().mmSetOnActivityResultCallback(this);
            if (this.mdj.mdg == 1) {
                z2 = true;
            } else if (this.mdj.mdg == 2) {
                i2 = 1;
                z2 = false;
            } else if (this.mdj.mdg == 3) {
                i2 = 2;
                z2 = false;
            } else {
                z2 = false;
            }
            if (this.mdj.mch && this.mdj.mci) {
                Intent bHt = bHt();
                bHt.putExtra("query_media_type", i2);
                bHt.putExtra("key_can_select_video_and_pic", z2);
                s.a(bDF(), 1, this.mdj.count, this.mcq, bHt);
                AppMethodBeat.o(46512);
            } else if (this.mdj.mci) {
                Intent bHt2 = bHt();
                bHt2.putExtra("show_header_view", false);
                bHt2.putExtra("query_media_type", i2);
                bHt2.putExtra("key_can_select_video_and_pic", z2);
                s.a(bDF(), 1, this.mdj.count, this.mcq, bHt2);
                AppMethodBeat.o(46512);
            } else if (this.mdj.mch) {
                Intent intent = new Intent();
                intent.putExtra("album_business_bubble_media_by_coordinate_latitude", this.mdj.latitude);
                intent.putExtra("album_business_bubble_media_by_coordinate_longitude", this.mdj.longitude);
                if (this.mdj.mde && !this.mdj.mdf) {
                    i3 = 1;
                } else if (this.mdj.mdf && !this.mdj.mde) {
                    i3 = 2;
                }
                SightParams sightParams = new SightParams(7, 1);
                sightParams.mode = i3;
                sightParams.irT.duration = this.mdj.kyt;
                intent.putExtra("KEY_SIGHT_PARAMS", sightParams);
                s.a(bDF(), 2, intent, 7, i3);
                AppMethodBeat.o(46512);
            } else {
                Log.e("MicroMsg.JsApiChooseMultiMedia", "unknown scene, ignore this request");
                this.mdk.resultCode = -2;
                b(this.mdk);
                AppMethodBeat.o(46512);
            }
        }

        private Intent bHt() {
            AppMethodBeat.i(46513);
            Intent intent = new Intent();
            intent.putExtra("album_business_tag", "album_business_bubble_media_by_coordinate");
            intent.putExtra("album_video_max_duration", this.mdj.kyt);
            intent.putExtra("album_business_bubble_media_by_coordinate_distance", this.mdj.jiP);
            intent.putExtra("album_business_bubble_media_by_coordinate_latitude", this.mdj.latitude);
            intent.putExtra("album_business_bubble_media_by_coordinate_longitude", this.mdj.longitude);
            intent.putExtra("album_business_bubble_media_by_coordinate_posname", this.mdj.kHV);
            intent.putExtra("query_media_type", 3);
            intent.putExtra("send_btn_string", MMApplicationContext.getResources().getString(R.string.x5));
            intent.putExtra("gallery_report_tag", 18);
            AppMethodBeat.o(46513);
            return intent;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00c6, code lost:
            if (r0 != false) goto L_0x00c8;
         */
        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask, com.tencent.mm.ui.MMActivity.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void d(int r13, int r14, android.content.Intent r15) {
            /*
            // Method dump skipped, instructions count: 450
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia.a.d(int, int, android.content.Intent):void");
        }

        private static BackwardSupportUtil.ExifHelper.LatLongData bHu() {
            BackwardSupportUtil.ExifHelper.LatLongData latLongData;
            AppMethodBeat.i(46515);
            String string = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_locCache", 0).getString("locStr", null);
            if (string != null) {
                String[] split = string.split(",");
                float f2 = ((float) Util.getInt(split[0], 0)) / 1000000.0f;
                float f3 = ((float) Util.getInt(split[1], 0)) / 1000000.0f;
                Log.d("MicroMsg.JsApiChooseMultiMedia", "locStr: %s, latitude: %f, longitude: %f", string, Float.valueOf(f2), Float.valueOf(f3));
                latLongData = new BackwardSupportUtil.ExifHelper.LatLongData(f2, f3);
            } else {
                String str = (String) g.aAh().azQ().get(67591, (Object) null);
                if (str != null) {
                    try {
                        String[] split2 = str.split(",");
                        int intValue = Integer.valueOf(split2[0]).intValue();
                        String str2 = 1 == Integer.valueOf(split2[1]).intValue() ? TencentLocation.NETWORK_PROVIDER : "gps";
                        float intValue2 = ((float) Integer.valueOf(split2[2]).intValue()) / 1000000.0f;
                        float intValue3 = ((float) Integer.valueOf(split2[3]).intValue()) / 1000000.0f;
                        Log.d("MicroMsg.JsApiChooseMultiMedia", "cached gps coordinate, precision: %d source: %s latitude: %f longitude: %f", Integer.valueOf(intValue), str2, Float.valueOf(intValue2), Float.valueOf(intValue3));
                        latLongData = new BackwardSupportUtil.ExifHelper.LatLongData(intValue2, intValue3);
                    } catch (Exception e2) {
                        Log.e("MicroMsg.JsApiChooseMultiMedia", "getCurrentGPSData parse value error.", e2);
                        latLongData = null;
                    }
                } else {
                    Log.i("MicroMsg.JsApiChooseMultiMedia", "lbs location is null, no cached data!");
                    Log.e("MicroMsg.JsApiChooseMultiMedia", "location get error!");
                    latLongData = null;
                }
            }
            AppMethodBeat.o(46515);
            return latLongData;
        }

        private void bHv() {
            AppMethodBeat.i(46516);
            this.mcu = new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia.a.AnonymousClass4 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(46509);
                    Log.e("MicroMsg.JsApiChooseMultiMedia", "cancel show the progress dialog and finish progress");
                    a.this.mdk.resultCode = 0;
                    a.h(a.this, a.this.mdk);
                    AppMethodBeat.o(46509);
                }
            };
            MMActivity bDF = bDF();
            MMApplicationContext.getResources().getString(R.string.zb);
            this.gxX = com.tencent.mm.ui.base.h.a((Context) bDF, MMApplicationContext.getResources().getString(R.string.jj), true, this.mcu);
            AppMethodBeat.o(46516);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
        public final void bDM() {
            AppMethodBeat.i(46517);
            super.bDM();
            if (this.gxX != null) {
                this.gxX.dismiss();
                this.gxX = null;
            }
            AppMethodBeat.o(46517);
        }

        /* JADX WARNING: Removed duplicated region for block: B:42:0x01cb  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static java.lang.String aaf(java.lang.String r13) {
            /*
            // Method dump skipped, instructions count: 579
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia.a.aaf(java.lang.String):java.lang.String");
        }

        private AppBrandLocalVideoObject as(String str, boolean z) {
            com.tencent.mm.compatible.i.d dVar;
            int i2;
            int i3;
            AppMethodBeat.i(46519);
            if (z) {
                try {
                    str = aaf(str);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, remux failed, exp = %s", Util.stackTraceToString(e2));
                }
            }
            try {
                com.tencent.mm.compatible.i.d dVar2 = new com.tencent.mm.compatible.i.d();
                dVar2.setDataSource(str);
                dVar = dVar2;
            } catch (Exception e3) {
                Log.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", e3);
                dVar = null;
            }
            if (dVar == null) {
                Log.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, null meta data");
                AppMethodBeat.o(46519);
                return null;
            }
            int i4 = Util.getInt(dVar.extractMetadata(18), 0);
            int i5 = Util.getInt(dVar.extractMetadata(19), 0);
            int i6 = Util.getInt(dVar.extractMetadata(9), 0);
            if (!"90".equals(dVar.extractMetadata(24)) || i4 <= i5) {
                i2 = i5;
                i3 = i4;
            } else {
                i2 = i4;
                i3 = i5;
            }
            dVar.release();
            AppBrandLocalVideoObject O = AppBrandLocalMediaObjectManager.O(this.mdj.appId, str);
            if (O == null) {
                Log.e("MicroMsg.JsApiChooseMultiMedia", "attachVideo error, return null");
                AppMethodBeat.o(46519);
                return null;
            }
            O.duration = (i6 + 500) / 1000;
            O.width = i3;
            O.height = i2;
            O.size = com.tencent.mm.vfs.s.boW(str);
            Log.i("MicroMsg.JsApiChooseMultiMedia", "addVideoItem, return %s", O);
            AppMethodBeat.o(46519);
            return O;
        }

        private static String aag(String str) {
            AppMethodBeat.i(46520);
            String str2 = "";
            if (!Util.isNullOrNil(str)) {
                o oVar = new o(str);
                if (oVar.exists()) {
                    String name = oVar.getName();
                    String str3 = null;
                    if (!TextUtils.isEmpty(name) && name.contains(".")) {
                        str3 = name.substring(0, name.lastIndexOf("."));
                    }
                    if (TextUtils.isEmpty(str3)) {
                        str2 = com.tencent.mm.loader.j.b.aKV() + ("microMsg_" + System.currentTimeMillis()) + ".jpeg";
                    } else if (com.tencent.mm.loader.j.b.aKV() == null || !com.tencent.mm.loader.j.b.aKV().endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                        str2 = com.tencent.mm.loader.j.b.aKV() + FilePathGenerator.ANDROID_DIR_SEP + str3 + System.currentTimeMillis() + ".jpeg";
                    } else {
                        str2 = com.tencent.mm.loader.j.b.aKV() + str3 + System.currentTimeMillis() + ".jpeg";
                    }
                    if (!new o(str2).exists()) {
                        Log.i("MicroMsg.JsApiChooseMultiMedia", "file not exist for path:%s! create it!", str2);
                        Bitmap createVideoThumbnail = BitmapUtil.createVideoThumbnail(str, 2);
                        if (createVideoThumbnail == null) {
                            Log.e("MicroMsg.JsApiChooseMultiMedia", "createVideoThumbnail bitmap fail for path:%s!", str2);
                            AppMethodBeat.o(46520);
                            return "";
                        }
                        try {
                            BitmapUtil.saveBitmapToImage(createVideoThumbnail, 80, Bitmap.CompressFormat.JPEG, str2, true);
                        } catch (IOException e2) {
                            Log.e("MicroMsg.JsApiChooseMultiMedia", "saveBitmapToImage exist IOException:" + e2.getMessage());
                        }
                    } else {
                        Log.i("MicroMsg.JsApiChooseMultiMedia", "file is exist for path:%s!", str2);
                    }
                }
            }
            AppMethodBeat.o(46520);
            return str2;
        }

        private static String a(String str, long j2, int i2, int i3, String str2, String str3) {
            AppMethodBeat.i(46521);
            JSONArray jSONArray = new JSONArray();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "image");
                jSONObject.put("tempFilePath", str);
                jSONObject.put("size", j2);
                jSONObject.put("width", i2);
                jSONObject.put("height", i3);
                jSONObject.put("orientation", str2);
                jSONObject.put("mark", str3);
                jSONObject.put("scene", "camera");
                jSONArray.put(jSONObject);
                String jSONArray2 = jSONArray.toString();
                Log.i("MicroMsg.JsApiChooseMultiMedia", "parseImageItemToJson, res: %s.", jSONArray2);
                AppMethodBeat.o(46521);
                return jSONArray2;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.JsApiChooseMultiMedia", e2, "", new Object[0]);
                AppMethodBeat.o(46521);
                return "";
            }
        }

        private static String a(String str, long j2, int i2, int i3, int i4, String str2, String str3) {
            AppMethodBeat.i(46522);
            Log.i("MicroMsg.JsApiChooseMultiMedia", "parseImageItemToJson()");
            JSONArray jSONArray = new JSONArray();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", "video");
                jSONObject.put("tempFilePath", str);
                jSONObject.put("size", j2);
                jSONObject.put("width", i2);
                jSONObject.put("height", i3);
                jSONObject.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, i4);
                jSONObject.put("thumbTempFilePath", str2);
                jSONObject.put("mark", str3);
                jSONObject.put("scene", "camera");
                jSONArray.put(jSONObject);
                String jSONArray2 = jSONArray.toString();
                AppMethodBeat.o(46522);
                return jSONArray2;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.JsApiChooseMultiMedia", e2, "", new Object[0]);
                AppMethodBeat.o(46522);
                return "";
            }
        }

        private static String aah(String str) {
            Bitmap bitmap;
            AppMethodBeat.i(46523);
            String k = com.tencent.mm.vfs.s.k(com.tencent.mm.loader.j.b.aKV() + "microMsg." + System.currentTimeMillis() + ".jpg", true);
            try {
                bitmap = MMBitmapFactory.decodeFile(str);
            } catch (OutOfMemoryError e2) {
                Log.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp oom");
                try {
                    bitmap = BitmapUtil.decodeFile(str, null);
                } catch (OutOfMemoryError e3) {
                    Log.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp oom retry, oom again");
                    bitmap = null;
                } catch (Exception e4) {
                    Log.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp oom retry, e ".concat(String.valueOf(e4)));
                    bitmap = null;
                }
            } catch (NullPointerException e5) {
                try {
                    bitmap = BitmapUtil.decodeFile(str, null);
                } catch (Exception e6) {
                    Log.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp npe retry, e ".concat(String.valueOf(e6)));
                    bitmap = null;
                }
            } catch (Exception e7) {
                Log.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp e ".concat(String.valueOf(e7)));
                bitmap = null;
            }
            if (bitmap == null) {
                Log.e("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, decode bmp return null");
                AppMethodBeat.o(46523);
                return null;
            }
            long nowMilliSecond = Util.nowMilliSecond();
            boolean eN = com.tencent.mm.plugin.appbrand.utils.d.eN(k, str);
            Log.i("MicroMsg.JsApiChooseMultiMedia", "doCompressImage, ret = %b, cost = %d, %s (%d) -> %s (%d)", Boolean.valueOf(eN), Long.valueOf(Util.nowMilliSecond() - nowMilliSecond), str, Long.valueOf(com.tencent.mm.vfs.s.boW(str)), k, Long.valueOf(com.tencent.mm.vfs.s.boW(k)));
            if (eN) {
                AppMethodBeat.o(46523);
                return k;
            }
            AppMethodBeat.o(46523);
            return str;
        }

        private static String aai(String str) {
            AppMethodBeat.i(46524);
            int orientationInDegree = Exif.fromFile(str).getOrientationInDegree();
            if (orientationInDegree != 0) {
                int i2 = orientationInDegree % v2helper.VOIP_ENC_HEIGHT_LV1;
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    Bitmap decodeFile = MMBitmapFactory.decodeFile(str, options);
                    if (decodeFile == null) {
                        Log.e("MicroMsg.JsApiChooseMultiMedia", "rotate image, get null bmp");
                        AppMethodBeat.o(46524);
                        return str;
                    }
                    Bitmap rotate = BitmapUtil.rotate(decodeFile, (float) i2);
                    String str2 = com.tencent.mm.loader.j.b.aKV() + "microMsg.tmp." + System.currentTimeMillis() + (com.tencent.mm.plugin.appbrand.utils.d.d(options) ? ".jpg" : ".png");
                    try {
                        BitmapUtil.saveBitmapToImage(rotate, 80, com.tencent.mm.plugin.appbrand.utils.d.d(options) ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG, str2, true);
                        if (com.tencent.mm.plugin.appbrand.utils.d.d(options)) {
                            com.tencent.mm.plugin.appbrand.l.b.dk(str, str2);
                        }
                        AppMethodBeat.o(46524);
                        return str2;
                    } catch (Exception e2) {
                        Log.e("MicroMsg.JsApiChooseMultiMedia", "rotate image, exception occurred when saving | %s", e2);
                        com.tencent.mm.vfs.s.deleteFile(str2);
                        AppMethodBeat.o(46524);
                        return str;
                    }
                } catch (OutOfMemoryError e3) {
                    AppMethodBeat.o(46524);
                    return str;
                } catch (NullPointerException e4) {
                    AppMethodBeat.o(46524);
                    return str;
                }
            } else {
                AppMethodBeat.o(46524);
                return str;
            }
        }

        static /* synthetic */ String a(a aVar, long j2, double d2) {
            String str;
            AppMethodBeat.i(46525);
            Log.d("MicroMsg.JsApiChooseMultiMedia", "generateMarkStr, time: %d X: %f.", Long.valueOf(j2), Double.valueOf(d2));
            String valueOf = String.valueOf(j2);
            if (d2 < 0.0d) {
                str = valueOf + "00";
            } else if (d2 <= 20.0d) {
                str = valueOf + "99";
            } else if (d2 <= 40.0d) {
                str = valueOf + "97";
            } else if (d2 <= 60.0d) {
                str = valueOf + "95";
            } else if (d2 <= 80.0d) {
                str = valueOf + "93";
            } else if (d2 <= 100.0d) {
                str = valueOf + "91";
            } else if (d2 <= 120.0d) {
                str = valueOf + "89";
            } else if (d2 <= 140.0d) {
                str = valueOf + "87";
            } else if (d2 <= 160.0d) {
                str = valueOf + "85";
            } else if (d2 <= 180.0d) {
                str = valueOf + "83";
            } else if (d2 <= 200.0d) {
                str = valueOf + "81";
            } else if (d2 <= 250.0d) {
                str = valueOf + "76";
            } else if (d2 <= 300.0d) {
                str = valueOf + "71";
            } else if (d2 <= 350.0d) {
                str = valueOf + "66";
            } else if (d2 <= 400.0d) {
                str = valueOf + "61";
            } else if (d2 <= 450.0d) {
                str = valueOf + "56";
            } else if (d2 <= 500.0d) {
                str = valueOf + "51";
            } else if (d2 <= 1000.0d) {
                str = valueOf + "20";
            } else {
                str = valueOf + PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT;
            }
            if (aVar.mdj.mdh) {
                str = j2 + "01";
            }
            Log.d("MicroMsg.JsApiChooseMultiMedia", "generateMarkStr, mark: %s.", str);
            AppMethodBeat.o(46525);
            return str;
        }

        static /* synthetic */ String a(a aVar, String str) {
            AppMethodBeat.i(46531);
            if (!TextUtils.isEmpty(str)) {
                AppBrandLocalMediaObject h2 = AppBrandLocalMediaObjectManager.h(aVar.mdj.appId, str, true);
                if (h2 == null || Util.isNullOrNil(h2.dJX)) {
                    Log.e("MicroMsg.JsApiChooseMultiMedia", "addThumbItem error, localId is null");
                } else {
                    String str2 = h2.dJX;
                    AppMethodBeat.o(46531);
                    return str2;
                }
            }
            AppMethodBeat.o(46531);
            return "";
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ChooseRequest extends AppBrandProxyUIProcessTask.ProcessRequest {
        public static final Parcelable.Creator<ChooseRequest> CREATOR = new Parcelable.Creator<ChooseRequest>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia.ChooseRequest.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ ChooseRequest[] newArray(int i2) {
                return new ChooseRequest[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ChooseRequest createFromParcel(Parcel parcel) {
                AppMethodBeat.i(46497);
                ChooseRequest chooseRequest = new ChooseRequest(parcel);
                AppMethodBeat.o(46497);
                return chooseRequest;
            }
        };
        String appId;
        int count;
        double jiP;
        String kHV;
        int kyt;
        double latitude;
        double longitude;
        boolean mch;
        boolean mci;
        boolean mde;
        boolean mdf;
        int mdg;
        boolean mdh;

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final Class<? extends AppBrandProxyUIProcessTask> bCJ() {
            return a.class;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final void writeToParcel(Parcel parcel, int i2) {
            byte b2;
            byte b3;
            byte b4;
            byte b5 = 1;
            AppMethodBeat.i(46498);
            parcel.writeString(this.appId);
            parcel.writeInt(this.count);
            parcel.writeDouble(this.longitude);
            parcel.writeDouble(this.latitude);
            parcel.writeString(this.kHV);
            parcel.writeDouble(this.jiP);
            parcel.writeByte(this.mch ? (byte) 1 : 0);
            if (this.mci) {
                b2 = 1;
            } else {
                b2 = 0;
            }
            parcel.writeByte(b2);
            parcel.writeInt(this.kyt);
            if (this.mde) {
                b3 = 1;
            } else {
                b3 = 0;
            }
            parcel.writeByte(b3);
            if (this.mdf) {
                b4 = 1;
            } else {
                b4 = 0;
            }
            parcel.writeByte(b4);
            parcel.writeInt(this.mdg);
            if (!this.mdh) {
                b5 = 0;
            }
            parcel.writeByte(b5);
            AppMethodBeat.o(46498);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final void k(Parcel parcel) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4 = true;
            AppMethodBeat.i(46499);
            this.appId = parcel.readString();
            this.count = parcel.readInt();
            this.longitude = parcel.readDouble();
            this.latitude = parcel.readDouble();
            this.kHV = parcel.readString();
            this.jiP = parcel.readDouble();
            this.mch = parcel.readByte() != 0;
            if (parcel.readByte() != 0) {
                z = true;
            } else {
                z = false;
            }
            this.mci = z;
            this.kyt = parcel.readInt();
            if (parcel.readByte() != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.mde = z2;
            if (parcel.readByte() != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.mdf = z3;
            this.mdg = parcel.readInt();
            if (parcel.readByte() == 0) {
                z4 = false;
            }
            this.mdh = z4;
            AppMethodBeat.o(46499);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final int describeContents() {
            return 0;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final String bDO() {
            return "GalleryChooseMultiMedia";
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final boolean bDN() {
            return true;
        }

        ChooseRequest() {
        }

        ChooseRequest(Parcel parcel) {
            AppMethodBeat.i(46500);
            k(parcel);
            AppMethodBeat.o(46500);
        }

        static {
            AppMethodBeat.i(46501);
            AppMethodBeat.o(46501);
        }
    }

    static final class ChooseResult extends AppBrandProxyUIProcessTask.ProcessResult {
        public static final Parcelable.Creator<ChooseResult> CREATOR = new Parcelable.Creator<ChooseResult>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia.ChooseResult.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ ChooseResult[] newArray(int i2) {
                return new ChooseResult[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ChooseResult createFromParcel(Parcel parcel) {
                AppMethodBeat.i(46502);
                ChooseResult chooseResult = new ChooseResult(parcel);
                AppMethodBeat.o(46502);
                return chooseResult;
            }
        };
        String mdi;
        int resultCode;

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult
        public final void k(Parcel parcel) {
            AppMethodBeat.i(46503);
            this.resultCode = parcel.readInt();
            this.mdi = parcel.readString();
            AppMethodBeat.o(46503);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(46504);
            parcel.writeInt(this.resultCode);
            parcel.writeString(this.mdi);
            AppMethodBeat.o(46504);
        }

        ChooseResult() {
        }

        ChooseResult(Parcel parcel) {
            super(parcel);
        }

        static {
            AppMethodBeat.i(46505);
            AppMethodBeat.o(46505);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b {
        public String cBG;
        public int height;
        public int width;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    static /* synthetic */ b aae(String str) {
        String str2;
        AppMethodBeat.i(46543);
        b bVar = new b((byte) 0);
        if (!Util.isNullOrNil(str)) {
            o oVar = new o(str);
            if (oVar.exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                MMBitmapFactory.decodeFile(aa.z(oVar.her()), options);
                bVar.width = options.outWidth;
                bVar.height = options.outHeight;
                if (com.tencent.mm.plugin.appbrand.utils.d.d(options)) {
                    str2 = com.tencent.luggage.e.a.a.hN(com.tencent.luggage.e.a.a.getExifOrientation(aa.z(oVar.her())));
                } else {
                    str2 = "up";
                }
                bVar.cBG = str2;
            }
        }
        AppMethodBeat.o(46543);
        return bVar;
    }
}
