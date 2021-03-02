package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.a;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.q;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePusherView;
import com.tencent.mm.plugin.appbrand.permission.r;
import com.tencent.mm.plugin.appbrand.utils.c;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePusher;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends com.tencent.mm.plugin.appbrand.jsapi.base.b {
    private static final int CTRL_INDEX = 360;
    public static final String NAME = "insertLivePusher";
    private int lXS;

    static /* synthetic */ void a(b bVar, Activity activity, com.tencent.mm.plugin.appbrand.jsapi.f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(182554);
        bVar.a(activity, fVar, jSONObject, i2);
        AppMethodBeat.o(182554);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final void a(com.tencent.mm.plugin.appbrand.jsapi.f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(145878);
        j.PP();
        if (!(fVar.getContext() instanceof Activity)) {
            Log.w("MicroMsg.JsApiInsertLivePusher", "invokeAfterRequestPermission pageContext not activity");
            fVar.i(i2, h("fail", null));
            r.aeq(fVar.getAppId());
            AppMethodBeat.o(145878);
            return;
        }
        this.lXS = 0;
        a((Activity) fVar.getContext(), fVar, jSONObject, i2);
        AppMethodBeat.o(145878);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final View a(h hVar, JSONObject jSONObject) {
        AppMethodBeat.i(145879);
        CoverViewContainer coverViewContainer = new CoverViewContainer(hVar.getContext(), new AppBrandLivePusherView(hVar.getContext()));
        AppMethodBeat.o(145879);
        return coverViewContainer;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(145880);
        int i2 = jSONObject.getInt("livePusherId");
        AppMethodBeat.o(145880);
        return i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final void a(final h hVar, final int i2, View view, JSONObject jSONObject) {
        AppMethodBeat.i(145881);
        Log.i("MicroMsg.JsApiInsertLivePusher", "onInsertView livePusherId=%d", Integer.valueOf(i2));
        if (!(view instanceof CoverViewContainer)) {
            Log.w("MicroMsg.JsApiInsertLivePusher", "the view(%s) is not a instance of CoverViewContainer", Integer.valueOf(i2));
            AppMethodBeat.o(145881);
            return;
        }
        TXLiveBase.setAppVersion(String.format("weixin_%s", hVar.getAppId()));
        final AppBrandLivePusherView appBrandLivePusherView = (AppBrandLivePusherView) ((CoverViewContainer) view).aB(AppBrandLivePusherView.class);
        if (appBrandLivePusherView == null) {
            Log.e("MicroMsg.JsApiInsertLivePusher", "pusherView null");
            AppMethodBeat.o(145881);
            return;
        }
        final AnonymousClass1 r1 = new i.d() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.live.b.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.i.d
            public final void onForeground() {
                AppMethodBeat.i(145860);
                AppBrandLivePusherView appBrandLivePusherView = appBrandLivePusherView;
                i bGO = appBrandLivePusherView.lXI.bGO();
                Log.i("MicroMsg.AppBrandLivePusherView", "onForeground code:%d info:%s", Integer.valueOf(bGO.errorCode), bGO.errorInfo);
                appBrandLivePusherView.lPK.enable();
                AppMethodBeat.o(145860);
            }
        };
        final AnonymousClass6 r2 = new i.b() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.live.b.AnonymousClass6 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.i.b
            public final void onBackground() {
                AppMethodBeat.i(145865);
                AppBrandLivePusherView appBrandLivePusherView = appBrandLivePusherView;
                i hu = appBrandLivePusherView.lXI.hu(false);
                Log.i("MicroMsg.AppBrandLivePusherView", "onBackground code:%d info:%s", Integer.valueOf(hu.errorCode), hu.errorInfo);
                appBrandLivePusherView.lPK.disable();
                AppMethodBeat.o(145865);
            }
        };
        final AnonymousClass7 r3 = new h.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.live.b.AnonymousClass7 */

            @Override // com.tencent.mm.plugin.appbrand.h.c
            public final void a(h.d dVar) {
                AppMethodBeat.i(145866);
                AppBrandLivePusherView appBrandLivePusherView = appBrandLivePusherView;
                Log.i("MicroMsg.AppBrandLivePusherView", "onAppBrandPause pauseType:%s", dVar);
                if (dVar == h.d.BACK || dVar == h.d.CLOSE || dVar == h.d.LAUNCH_MINI_PROGRAM) {
                    appBrandLivePusherView.lXI.hu(true);
                }
                AppMethodBeat.o(145866);
            }

            @Override // com.tencent.mm.plugin.appbrand.h.c
            public final void onResume() {
                AppMethodBeat.i(145867);
                appBrandLivePusherView.lXI.bGO();
                AppMethodBeat.o(145867);
            }

            @Override // com.tencent.mm.plugin.appbrand.h.c
            public final void onDestroy() {
                AppMethodBeat.i(145868);
                com.tencent.mm.plugin.appbrand.h.b(hVar.getAppId(), this);
                AppMethodBeat.o(145868);
            }
        };
        AnonymousClass8 r4 = new i.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.live.b.AnonymousClass8 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.i.c
            public final void onDestroy() {
                AppMethodBeat.i(145869);
                appBrandLivePusherView.onExit();
                hVar.b(this);
                com.tencent.mm.plugin.appbrand.h.b(hVar.getAppId(), r3);
                AppMethodBeat.o(145869);
            }
        };
        hVar.a(r1);
        hVar.a(r2);
        hVar.a(r4);
        appBrandLivePusherView.setOnExitListener(new AppBrandLivePusherView.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.live.b.AnonymousClass9 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePusherView.c
            public final void bGN() {
                AppMethodBeat.i(145870);
                hVar.b(r1);
                hVar.b(r2);
                AppMethodBeat.o(145870);
            }
        });
        com.tencent.mm.plugin.appbrand.h.a(hVar.getAppId(), r3);
        appBrandLivePusherView.setOnPushEventListener(new ITXLivePushListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.live.b.AnonymousClass10 */

            @Override // com.tencent.rtmp.ITXLivePushListener
            public final void onPushEvent(int i2, Bundle bundle) {
                AppMethodBeat.i(145871);
                Log.i("MicroMsg.JsApiInsertLivePusher", "onPushEvent errCode:%d", Integer.valueOf(i2));
                g gVar = new g((byte) 0);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("errCode", i2);
                    jSONObject.put("errMsg", bundle.getString(TXLiveConstants.EVT_DESCRIPTION));
                    jSONObject.put("livePusherId", i2);
                } catch (JSONException e2) {
                }
                hVar.a(gVar.Zh(jSONObject.toString()), (int[]) null);
                AppMethodBeat.o(145871);
            }

            @Override // com.tencent.rtmp.ITXLivePushListener
            public final void onNetStatus(Bundle bundle) {
                AppMethodBeat.i(145872);
                f fVar = new f((byte) 0);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("livePusherId", i2);
                    JSONObject jSONObject2 = new JSONObject();
                    if (bundle != null) {
                        for (String str : bundle.keySet()) {
                            jSONObject2.put(str, bundle.get(str));
                        }
                    }
                    jSONObject.put("info", jSONObject2);
                } catch (JSONException e2) {
                }
                hVar.a(fVar.Zh(jSONObject.toString()), (int[]) null);
                AppMethodBeat.o(145872);
            }
        });
        appBrandLivePusherView.setBGMNotifyListener(new TXLivePusher.OnBGMNotify() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.live.b.AnonymousClass11 */

            @Override // com.tencent.rtmp.TXLivePusher.OnBGMNotify
            public final void onBGMStart() {
                AppMethodBeat.i(145873);
                Log.i("MicroMsg.JsApiInsertLivePusher", "onBGMStart");
                d dVar = new d((byte) 0);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("livePusherId", i2);
                } catch (JSONException e2) {
                    Log.e("MicroMsg.JsApiInsertLivePusher", "onBGMStart fail", e2);
                }
                hVar.a(dVar.Zh(jSONObject.toString()), (int[]) null);
                AppMethodBeat.o(145873);
            }

            @Override // com.tencent.rtmp.TXLivePusher.OnBGMNotify
            public final void onBGMProgress(long j2, long j3) {
                AppMethodBeat.i(145874);
                c cVar = new c((byte) 0);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("progress", j2);
                    jSONObject.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, j3);
                    jSONObject.put("livePusherId", i2);
                } catch (JSONException e2) {
                    Log.e("MicroMsg.JsApiInsertLivePusher", "onBGMProgress fail", e2);
                }
                hVar.a(cVar.Zh(jSONObject.toString()), (int[]) null);
                AppMethodBeat.o(145874);
            }

            @Override // com.tencent.rtmp.TXLivePusher.OnBGMNotify
            public final void onBGMComplete(int i2) {
                AppMethodBeat.i(145875);
                Log.i("MicroMsg.JsApiInsertLivePusher", "onBGMComplete, error:%s", Integer.valueOf(i2));
                C0674b bVar = new C0674b((byte) 0);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("errCode", i2);
                    jSONObject.put("livePusherId", i2);
                } catch (JSONException e2) {
                    Log.e("MicroMsg.JsApiInsertLivePusher", "onBGMComplete fail", e2);
                }
                hVar.a(bVar.Zh(jSONObject.toString()), (int[]) null);
                AppMethodBeat.o(145875);
            }
        });
        appBrandLivePusherView.setOnErrorListener(new AppBrandLivePusherView.b() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.live.b.AnonymousClass12 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePusherView.b
            public final void a(int i2, String str, HashMap<String, Object> hashMap) {
                AppMethodBeat.i(145876);
                Log.i("MicroMsg.JsApiInsertLivePusher", "onError, error:%s", Integer.valueOf(i2));
                e eVar = new e((byte) 0);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("errCode", i2);
                    jSONObject.put("errMsg", Util.nullAsNil(str));
                    jSONObject.put("livePusherId", i2);
                    if (hashMap != null && !hashMap.isEmpty()) {
                        jSONObject.put("data", new JSONObject(hashMap));
                    }
                } catch (JSONException e2) {
                    Log.e("MicroMsg.JsApiInsertLivePusher", "onError fail", e2);
                }
                hVar.a(eVar.Zh(jSONObject.toString()), (int[]) null);
                AppMethodBeat.o(145876);
            }
        });
        appBrandLivePusherView.setAudioVolumeNotifyListener(new TXLivePusher.ITXAudioVolumeEvaluationListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.live.b.AnonymousClass13 */

            @Override // com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener
            public final void onAudioVolumeEvaluationNotify(int i2) {
                AppMethodBeat.i(182553);
                Log.i("MicroMsg.JsApiInsertLivePusher", "onAudioVolumeEvaluationNotify, volume:%s", Integer.valueOf(i2));
                a aVar = new a((byte) 0);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("volume", i2);
                    jSONObject.put("livePusherId", i2);
                } catch (JSONException e2) {
                    Log.e("MicroMsg.JsApiInsertLivePusher", "onAudioVolumeEvaluationNotify fail", e2);
                }
                hVar.a(aVar.Zh(jSONObject.toString()), (int[]) null);
                AppMethodBeat.o(182553);
            }
        });
        if (jSONObject.has("filterImage")) {
            appBrandLivePusherView.cHp = jSONObject.optString("filterImage", appBrandLivePusherView.cHp);
            appBrandLivePusherView.cHq = jSONObject.optString("filterImageMd5", null);
            if (Util.isNullOrNil(appBrandLivePusherView.cHp)) {
                try {
                    jSONObject.put("filterImage", "");
                } catch (JSONException e2) {
                    Log.w("MicroMsg.JsApiInsertLivePusher", "parseFilterImage, ignore exception:%s", e2);
                }
            } else if (appBrandLivePusherView.cHp.startsWith(HttpWrapperBase.PROTOCAL_HTTP) || appBrandLivePusherView.cHp.startsWith(HttpWrapperBase.PROTOCAL_HTTPS)) {
                jSONObject.remove("filterImage");
            }
        }
        Bundle Z = k.Z(jSONObject);
        m mVar = appBrandLivePusherView.lXI;
        m.l("InitLivePusher", Z);
        mVar.mVideoView = appBrandLivePusherView;
        mVar.mVideoView.disableLog(false);
        mVar.cHX = Z.getString("pushUrl", "");
        mVar.cHV.setPusherUrl(mVar.cHX);
        mVar.a(Z, true);
        mVar.cIh = Z.getBoolean("autopush", mVar.cIh);
        if (mVar.cIh && mVar.cHX != null && !mVar.cHX.isEmpty() && !mVar.cHV.isPushing()) {
            Log.i("TXLivePusherJSAdapter", "initLivePusher: startPusher");
            mVar.ca(mVar.cIm);
            mVar.cb(mVar.cIn);
            mVar.cHV.startPusher(mVar.cHX);
        }
        mVar.mInited = true;
        i iVar = new i();
        Log.i("MicroMsg.AppBrandLivePusherView", "onInsert code:%d info:%s", Integer.valueOf(iVar.errorCode), iVar.errorInfo);
        final String optString = jSONObject.optString("backgroundImage");
        String optString2 = jSONObject.optString("backgroundMD5");
        if (Util.isNullOrNil(optString)) {
            Log.i("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath, url is null");
        } else {
            com.tencent.mm.plugin.appbrand.utils.c.a(hVar, optString, optString2, new c.a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.live.b.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.utils.c.a
                public final void Wz(String str) {
                    AppMethodBeat.i(145861);
                    if (!Util.isNullOrNil(str)) {
                        String k = q.k(str, false);
                        Log.i("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath, targetPath:%s", k);
                        Bundle bundle = new Bundle();
                        bundle.putString("backgroundImage", k);
                        appBrandLivePusherView.P(bundle);
                        AppMethodBeat.o(145861);
                        return;
                    }
                    Log.i("MicroMsg.JsApiInsertLivePusher", "convertBackgroundImageToLocalPath, load background image fail");
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("url", optString);
                    appBrandLivePusherView.a(ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL, "load background image fail", hashMap);
                    AppMethodBeat.o(145861);
                }
            });
        }
        final String optString3 = jSONObject.optString("filterImage");
        if (Util.isNullOrNil(optString3)) {
            Log.i("MicroMsg.JsApiInsertLivePusher", "convertFilterImageToLocalPath, url is null");
        } else {
            com.tencent.mm.plugin.appbrand.utils.c.a(hVar, optString3, null, new c.a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.live.b.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.appbrand.utils.c.a
                public final void Wz(String str) {
                    AppMethodBeat.i(182548);
                    if (!Util.isNullOrNil(str)) {
                        String k = q.k(str, false);
                        Log.i("MicroMsg.JsApiInsertLivePusher", "convertFilterImageToLocalPath, localPath:%s", k);
                        Bundle bundle = new Bundle();
                        bundle.putString("filterImage", k);
                        appBrandLivePusherView.P(bundle);
                        AppMethodBeat.o(182548);
                        return;
                    }
                    Log.i("MicroMsg.JsApiInsertLivePusher", "convertFilterImageToLocalPath, load filter image fail");
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("url", optString3);
                    appBrandLivePusherView.a(10005, "load filter image fail", hashMap);
                    AppMethodBeat.o(182548);
                }
            });
        }
        String optString4 = jSONObject.optString("watermarkImage");
        String optString5 = jSONObject.optString("watermarkMD5");
        if (Util.isNullOrNil(optString4)) {
            Log.i("MicroMsg.JsApiInsertLivePusher", "convertWatermarkImageToLocalPath, url is null");
        } else {
            com.tencent.mm.plugin.appbrand.utils.c.a(hVar, optString4, optString5, new c.a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.live.b.AnonymousClass4 */

                @Override // com.tencent.mm.plugin.appbrand.utils.c.a
                public final void Wz(String str) {
                    AppMethodBeat.i(182549);
                    if (!Util.isNullOrNil(str)) {
                        String k = q.k(str, false);
                        Log.i("MicroMsg.JsApiInsertLivePusher", "convertWatermarkImageToLocalPath, localPath:%s", k);
                        Bundle bundle = new Bundle();
                        bundle.putString("watermarkImage", k);
                        appBrandLivePusherView.P(bundle);
                    }
                    AppMethodBeat.o(182549);
                }
            });
        }
        appBrandLivePusherView.setContentDescription(view.getContext().getString(R.string.hn));
        AppMethodBeat.o(145881);
    }

    private void a(final Activity activity, final com.tencent.mm.plugin.appbrand.jsapi.f fVar, final JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(145882);
        int i3 = this.lXS;
        this.lXS = i3 + 1;
        if (i3 > 5) {
            Log.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, avoid dead loop");
            AppMethodBeat.o(145882);
            return;
        }
        r.b(fVar.getAppId(), new a.AbstractC0015a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.live.b.AnonymousClass5 */

            @Override // android.support.v4.app.a.AbstractC0015a
            public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
                AppMethodBeat.i(182552);
                Log.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback requestCode:%d", Integer.valueOf(i2));
                if (i2 != 117) {
                    if (i2 == 118) {
                        if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                            Log.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback not grant");
                            fVar.i(i2, b.this.h("fail:system permission denied", null));
                        } else {
                            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.live.b.AnonymousClass5.AnonymousClass2 */

                                public final void run() {
                                    AppMethodBeat.i(182551);
                                    b.a(b.this, activity, fVar, jSONObject, i2);
                                    AppMethodBeat.o(182551);
                                }
                            }, 50);
                            AppMethodBeat.o(182552);
                            return;
                        }
                    }
                    AppMethodBeat.o(182552);
                } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                    Log.i("MicroMsg.JsApiInsertLivePusher", "onRequestPermissionsResult callback not grant");
                    fVar.i(i2, b.this.h("fail:system permission denied", null));
                    AppMethodBeat.o(182552);
                } else {
                    MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.live.b.AnonymousClass5.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(182550);
                            b.a(b.this, activity, fVar, jSONObject, i2);
                            AppMethodBeat.o(182550);
                        }
                    }, 50);
                    AppMethodBeat.o(182552);
                }
            }
        });
        if (!com.tencent.luggage.h.i.a(activity, "android.permission.CAMERA", 117, "", "")) {
            Log.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, !retCameraPermission");
            AppMethodBeat.o(145882);
        } else if (!com.tencent.luggage.h.i.a(activity, "android.permission.RECORD_AUDIO", 118, "", "")) {
            Log.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, !retMicrophonePermission");
            AppMethodBeat.o(145882);
        } else {
            Log.i("MicroMsg.JsApiInsertLivePusher", "doInvokeAfterRequestPermission, super.invoke");
            super.a(fVar, jSONObject, i2);
            AppMethodBeat.o(145882);
        }
    }

    static final class g extends bc {
        private static final int CTRL_INDEX = 368;
        private static final String NAME = "onLivePusherEvent";

        private g() {
        }

        /* synthetic */ g(byte b2) {
            this();
        }
    }

    static final class f extends bc {
        private static final int CTRL_INDEX = 411;
        private static final String NAME = "onLivePusherNetStatus";

        private f() {
        }

        /* synthetic */ f(byte b2) {
            this();
        }
    }

    static final class d extends bc {
        private static final int CTRL_INDEX = 513;
        private static final String NAME = "onLivePusherBGMStart";

        private d() {
        }

        /* synthetic */ d(byte b2) {
            this();
        }
    }

    static final class c extends bc {
        private static final int CTRL_INDEX = 514;
        private static final String NAME = "onLivePusherBGMProgress";

        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.b$b  reason: collision with other inner class name */
    static final class C0674b extends bc {
        private static final int CTRL_INDEX = 515;
        private static final String NAME = "onLivePusherBGMComplete";

        private C0674b() {
        }

        /* synthetic */ C0674b(byte b2) {
            this();
        }
    }

    static final class a extends bc {
        private static final int CTRL_INDEX = 783;
        private static final String NAME = "onLivePusherAudioVolume";

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    static final class e extends bc {
        private static final int CTRL_INDEX = 531;
        private static final String NAME = "onLivePusherError";

        private e() {
        }

        /* synthetic */ e(byte b2) {
            this();
        }
    }
}
