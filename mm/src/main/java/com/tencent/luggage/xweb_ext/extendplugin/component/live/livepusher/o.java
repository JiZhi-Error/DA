package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.app.a;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.Surface;
import android.view.WindowManager;
import android.widget.Toast;
import com.tencent.f.c.d;
import com.tencent.luggage.h.i;
import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.permission.r;
import com.tencent.mm.plugin.appbrand.utils.ad;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePusher;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class o extends com.tencent.luggage.xweb_ext.extendplugin.a.a implements com.tencent.luggage.xweb_ext.extendplugin.component.o {
    com.tencent.luggage.xweb_ext.extendplugin.a cED;
    private a.AbstractC0188a cEE;
    int cEF;
    int cEG;
    private boolean cEJ;
    r cHl;
    public com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.c cHm;
    public com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.b cHn;
    public com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a cHo;
    private String cHp = "";
    private String cHq;
    int cHr;
    boolean cHs;
    private boolean cHt;
    private c cHu = new c(this, (byte) 0);
    private int cHv = 0;
    ad cHw;
    a cHx = new a();
    Handler cHy;
    private HandlerThread cHz = d.hA(String.format("LivePusherThread_%s", Long.valueOf(System.currentTimeMillis())), 5);
    int mCurrentScale = 1;
    Handler mHandler;
    ScaleGestureDetector mScaleGestureDetector;
    ScaleGestureDetector.OnScaleGestureListener mScaleGestureListener = new ScaleGestureDetector.OnScaleGestureListener() {
        /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.AnonymousClass16 */

        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00be, code lost:
            if (r1 < 0.9f) goto L_0x00c0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onScale(android.view.ScaleGestureDetector r9) {
            /*
            // Method dump skipped, instructions count: 219
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.AnonymousClass16.onScale(android.view.ScaleGestureDetector):boolean");
        }

        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    };
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;

    /* access modifiers changed from: package-private */
    public final String getLogTag() {
        AppMethodBeat.i(138877);
        String format = String.format("%s(%s)", "MicroMsg.SameLayer.LivePusherPluginHandler", Lb());
        AppMethodBeat.o(138877);
        return format;
    }

    public o() {
        AppMethodBeat.i(138878);
        this.cHz.start();
        this.cHy = new Handler(this.cHz.getLooper());
        this.mHandler = new Handler(MMApplicationContext.getContext().getMainLooper());
        com.tencent.luggage.xweb_ext.extendplugin.component.live.b.PP();
        this.cHl = new r(MMApplicationContext.getContext());
        this.cHl.mHandler = this.cHy;
        this.cHl.cHW = new ITXLivePushListener() {
            /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.AnonymousClass12 */

            @Override // com.tencent.rtmp.ITXLivePushListener
            public final void onPushEvent(int i2, Bundle bundle) {
                AppMethodBeat.i(178826);
                if (o.this.PS()) {
                    Log.d("MicroMsg.SameLayer.LivePusherPluginHandler", "onPushEvent, errCode:%s", Integer.valueOf(i2));
                    o.this.cHn.b(o.this.getId(), i2, bundle);
                }
                if ((i2 == 1002 || i2 == 1003 || i2 == 1018) && o.this.cHo != null) {
                    o.this.cHo.b(o.this, o.this.cED);
                    AppMethodBeat.o(178826);
                    return;
                }
                if (i2 == -1307 && o.this.cHo != null) {
                    o.this.cHo.c(o.this, o.this.cED);
                }
                AppMethodBeat.o(178826);
            }

            @Override // com.tencent.rtmp.ITXLivePushListener
            public final void onNetStatus(Bundle bundle) {
                AppMethodBeat.i(178827);
                if (o.this.PS()) {
                    o.this.cHn.e(o.this.getId(), bundle);
                }
                AppMethodBeat.o(178827);
            }
        };
        this.cHl.cId = new TXLivePusher.OnBGMNotify() {
            /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.AnonymousClass18 */

            @Override // com.tencent.rtmp.TXLivePusher.OnBGMNotify
            public final void onBGMStart() {
                AppMethodBeat.i(178829);
                if (o.this.PS()) {
                    o.this.cHn.ic(o.this.getId());
                }
                AppMethodBeat.o(178829);
            }

            @Override // com.tencent.rtmp.TXLivePusher.OnBGMNotify
            public final void onBGMProgress(long j2, long j3) {
                AppMethodBeat.i(178830);
                if (o.this.PS()) {
                    o.this.cHn.g(o.this.getId(), j2, j3);
                }
                AppMethodBeat.o(178830);
            }

            @Override // com.tencent.rtmp.TXLivePusher.OnBGMNotify
            public final void onBGMComplete(int i2) {
                AppMethodBeat.i(178831);
                if (o.this.PS()) {
                    o.this.cHn.bX(o.this.getId(), i2);
                }
                AppMethodBeat.o(178831);
            }
        };
        this.cHl.cIe = new TXLivePusher.ITXAudioVolumeEvaluationListener() {
            /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.AnonymousClass19 */

            @Override // com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener
            public final void onAudioVolumeEvaluationNotify(int i2) {
                AppMethodBeat.i(178832);
                if (o.this.PS()) {
                    o.this.cHn.bY(o.this.getId(), i2);
                }
                AppMethodBeat.o(178832);
            }
        };
        this.cHw = new ad(MMApplicationContext.getContext(), new ad.b() {
            /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.AnonymousClass20 */

            @Override // com.tencent.mm.plugin.appbrand.utils.ad.b
            public final void a(ad.a aVar, ad.a aVar2) {
                int i2;
                AppMethodBeat.i(178833);
                switch (aVar2) {
                    case LANDSCAPE:
                        i2 = 1;
                        break;
                    case PORTRAIT:
                        i2 = 0;
                        break;
                    case REVERSE_PORTRAIT:
                        i2 = 2;
                        break;
                    case REVERSE_LANDSCAPE:
                        i2 = 3;
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                a aVar3 = o.this.cHx;
                aVar3.number = 0;
                o.this.mHandler.removeCallbacks(aVar3);
                o.this.cHx.cHJ = i2;
                a aVar4 = o.this.cHx;
                o.this.mHandler.postDelayed(aVar4, 250);
                AppMethodBeat.o(178833);
            }
        });
        this.cHw.enable();
        ia(getRotationAngle());
        if (this.mHandler != null) {
            this.mHandler.post(new Runnable() {
                /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(178813);
                    o.this.mScaleGestureDetector = new ScaleGestureDetector(MMApplicationContext.getContext(), o.this.mScaleGestureListener);
                    AppMethodBeat.o(178813);
                }
            });
        }
        AppMethodBeat.o(138878);
    }

    static int getRotationAngle() {
        AppMethodBeat.i(138879);
        if (MMApplicationContext.getContext().getSystemService("window") != null) {
            int rotation = ((WindowManager) MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay().getRotation();
            AppMethodBeat.o(138879);
            return rotation;
        }
        AppMethodBeat.o(138879);
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean ia(int i2) {
        AppMethodBeat.i(138880);
        if (i2 != this.cHv) {
            this.cHv = i2;
            Log.i("MicroMsg.SameLayer.LivePusherPluginHandler", "notifyOrientationChanged, new angle:%s", Integer.valueOf(i2));
            if (this.cHl != null) {
                this.cHl.ib(i2);
                AppMethodBeat.o(138880);
                return true;
            }
        }
        AppMethodBeat.o(138880);
        return false;
    }

    class a implements Runnable {
        int cHJ;
        int number = 0;

        a() {
        }

        public final void run() {
            AppMethodBeat.i(138875);
            this.number++;
            int rotationAngle = o.getRotationAngle();
            if (rotationAngle == this.cHJ) {
                o.this.ia(rotationAngle);
                AppMethodBeat.o(138875);
                return;
            }
            if (this.number < 8) {
                o.this.mHandler.postDelayed(this, 250);
            }
            AppMethodBeat.o(138875);
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        return true;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final void e(final SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(138881);
        if (this.cHy != null) {
            this.cHy.post(new Runnable() {
                /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.AnonymousClass21 */

                public final void run() {
                    AppMethodBeat.i(138869);
                    o.a(o.this, surfaceTexture);
                    AppMethodBeat.o(138869);
                }
            });
        }
        AppMethodBeat.o(138881);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final void PQ() {
        AppMethodBeat.i(138882);
        if (this.cHy != null) {
            this.cHy.post(new Runnable() {
                /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.AnonymousClass22 */

                public final void run() {
                    AppMethodBeat.i(138870);
                    o.a(o.this);
                    AppMethodBeat.o(138870);
                }
            });
        }
        AppMethodBeat.o(138882);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final void o(final MotionEvent motionEvent) {
        AppMethodBeat.i(138883);
        if (this.cHy != null) {
            this.cHy.post(new Runnable() {
                /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.AnonymousClass23 */

                public final void run() {
                    AppMethodBeat.i(178834);
                    o.a(o.this, motionEvent);
                    AppMethodBeat.o(178834);
                }
            });
        }
        AppMethodBeat.o(138883);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final String h(final com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        AppMethodBeat.i(138884);
        if (this.cHy != null) {
            this.cHy.post(new Runnable() {
                /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.AnonymousClass24 */

                public final void run() {
                    boolean z;
                    String[] strArr;
                    String[] strArr2;
                    String[] strArr3;
                    AppMethodBeat.i(138874);
                    o oVar = o.this;
                    com.tencent.luggage.xweb_ext.extendplugin.a aVar = aVar;
                    String Pt = aVar.Pt();
                    if (!Util.isNullOrNil(Pt)) {
                        JSONObject Ps = aVar.Ps();
                        Log.i(oVar.getLogTag(), "*** handler(%s) handleJsApi(%s), data:%s", oVar.Lb(), Pt, Ps.toString());
                        new StringBuilder("handleJsApi:").append(Pt).append(", data:").append(Ps);
                        if (Pt.contains("insert")) {
                            oVar.hV(5);
                            Context context = aVar.getContext();
                            if (!(context instanceof Activity)) {
                                Log.w("MicroMsg.SameLayer.LivePusherPluginHandler", "invokeInsertAfterRequestPermission, pageContext not activity");
                                aVar.dP("fail:internal error invalid android context");
                                r.aeq(aVar.getAppId());
                                AppMethodBeat.o(138874);
                                return;
                            }
                            oVar.cHr = 0;
                            oVar.a((Activity) context, aVar);
                            AppMethodBeat.o(138874);
                            return;
                        } else if (Pt.contains("update")) {
                            oVar.hV(6);
                            if (oVar.cHl == null) {
                                Log.i(oVar.getLogTag(), "update, adapter is null");
                                AppMethodBeat.o(138874);
                                return;
                            }
                            JSONObject Ps2 = aVar.Ps();
                            oVar.a(aVar, Ps2);
                            oVar.i(Ps2);
                            oVar.k(Ps2);
                            oVar.l(Ps2);
                            oVar.j(Ps2);
                            Bundle h2 = com.tencent.luggage.xweb_ext.extendplugin.component.live.c.h(Ps2);
                            if (oVar.cHo != null) {
                                String c2 = oVar.cHo.c(aVar, h2);
                                if (!Util.isNullOrNil(c2)) {
                                    Log.i(oVar.getLogTag(), "update fail, message:%s", c2);
                                    aVar.dP("fail: can not update LivePusher to VOIP mode now");
                                    Toast.makeText(aVar.getContext(), c2, 0).show();
                                    AppMethodBeat.o(138874);
                                    return;
                                }
                            }
                            com.tencent.luggage.xweb_ext.extendplugin.component.live.a o = oVar.cHl.o(h2);
                            Log.i(oVar.getLogTag(), "update, code:%d info:%s", Integer.valueOf(o.errorCode), o.errorInfo);
                            aVar.dP(o.errorCode == 0 ? "ok" : "fail");
                            oVar.n(aVar);
                            oVar.o(aVar);
                            if (o.errorCode == 0 && oVar.cHo != null) {
                                oVar.cHo.a(oVar, oVar.cED, h2);
                                oVar.cHo.b(oVar.cED, h2);
                            }
                            AppMethodBeat.o(138874);
                            return;
                        } else if (Pt.contains("operate")) {
                            oVar.hV(7);
                            if (oVar.cHl == null) {
                                Log.i(oVar.getLogTag(), "operate, adapter is null");
                                AppMethodBeat.o(138874);
                                return;
                            }
                            JSONObject Ps3 = aVar.Ps();
                            String optString = Ps3.optString("type");
                            Log.i(oVar.getLogTag(), "operate, type:%s", optString);
                            if (Util.isNullOrNil(optString) || oVar.cHl == null) {
                                aVar.dP("fail");
                                AppMethodBeat.o(138874);
                                return;
                            } else if (optString.equals("snapshot")) {
                                oVar.cHl.cIc = new TXLivePusher.ITXSnapshotListener(aVar) {
                                    /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.AnonymousClass11 */
                                    final /* synthetic */ com.tencent.luggage.xweb_ext.extendplugin.a cFk;

                                    {
                                        this.cFk = r2;
                                    }

                                    @Override // com.tencent.rtmp.TXLivePusher.ITXSnapshotListener
                                    public final void onSnapshot(Bitmap bitmap) {
                                        AppMethodBeat.i(215640);
                                        if (this.cFk == null) {
                                            Log.e("MicroMsg.SameLayer.LivePusherPluginHandler", "operateSnapshot, invokeContext is null");
                                            AppMethodBeat.o(215640);
                                            return;
                                        }
                                        if (o.this.cHo != null) {
                                            o.this.cHo.a(this.cFk, bitmap);
                                        }
                                        AppMethodBeat.o(215640);
                                    }
                                };
                                if (oVar.cHl.f("snapshot", aVar.Ps()).errorCode != 0) {
                                    aVar.dP("fail:snapshot error");
                                }
                                AppMethodBeat.o(138874);
                                return;
                            } else if (!optString.equals("playBGM")) {
                                if (optString.equalsIgnoreCase("applyFilter") || optString.equalsIgnoreCase("applySticker") || optString.equalsIgnoreCase("applyMakeup")) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (!z) {
                                    com.tencent.luggage.xweb_ext.extendplugin.component.live.a f2 = oVar.cHl.f(optString, Ps3);
                                    Log.i(oVar.getLogTag(), "operate, type:%s, error:[%s, %s]", optString, Integer.valueOf(f2.errorCode), f2.errorInfo);
                                    aVar.dP(f2.errorCode == 0 ? "ok" : "fail");
                                    if (optString.equalsIgnoreCase("stop") && f2.errorCode == 0 && oVar.cHo != null) {
                                        oVar.cHo.c(oVar, oVar.cED);
                                    }
                                    AppMethodBeat.o(138874);
                                    return;
                                } else if (oVar.cHo == null) {
                                    Log.w(oVar.getLogTag(), "convertResourcePathAndOperateLivePusher, customHandler is null");
                                    aVar.dP("fail");
                                    AppMethodBeat.o(138874);
                                    return;
                                } else {
                                    String optString2 = Ps3.optString("path", null);
                                    if (Util.isNullOrNil(optString2)) {
                                        Log.i(oVar.getLogTag(), "convertResourcePathAndOperateLivePusher, resourcePath is empty");
                                        Log.i(oVar.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher");
                                        if (optString.equalsIgnoreCase("applySticker")) {
                                            oVar.b(aVar, Ps3);
                                            AppMethodBeat.o(138874);
                                            return;
                                        } else if (optString.equalsIgnoreCase("applyMakeup")) {
                                            String optString3 = Ps3.optString("makeupType", null);
                                            if (Util.isNullOrNil(optString3)) {
                                                Log.w(oVar.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, makeupTypeStr is empty");
                                                aVar.dP("fail");
                                                AppMethodBeat.o(138874);
                                                return;
                                            }
                                            JSONObject optJSONObject = Ps3.optJSONObject("makeup");
                                            if (optJSONObject == null) {
                                                Log.w(oVar.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, makeupJsonObj is null");
                                                aVar.dP("fail");
                                                AppMethodBeat.o(138874);
                                                return;
                                            } else if (optString3.equalsIgnoreCase("lipStick")) {
                                                com.tencent.luggage.xweb_ext.extendplugin.component.live.a f3 = oVar.cHl.f("applyMakeup", Ps3);
                                                Log.i(oVar.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, type:applyMakeup, error:[%s, %s]", Integer.valueOf(f3.errorCode), f3.errorInfo);
                                                aVar.dP(f3.errorCode == 0 ? "ok" : "fail");
                                                AppMethodBeat.o(138874);
                                                return;
                                            } else if (optString3.equalsIgnoreCase("eyeShadow")) {
                                                String optString4 = optJSONObject.optString("leftPath", null);
                                                if (Util.isNullOrNil(optString4)) {
                                                    Log.w(oVar.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, leftPath is empty");
                                                    aVar.dP("fail");
                                                    AppMethodBeat.o(138874);
                                                    return;
                                                }
                                                String optString5 = optJSONObject.optString("leftPathMD5", null);
                                                String optString6 = optJSONObject.optString("shimmerPosition", null);
                                                if (!Util.isNullOrNil(optString6)) {
                                                    strArr = new String[]{optString4, optString6};
                                                    strArr2 = new String[]{optString5, optJSONObject.optString("shimmerPositionMD5", null)};
                                                    strArr3 = new String[]{"leftPath", "shimmerPosition"};
                                                } else {
                                                    strArr = new String[]{optString4};
                                                    strArr2 = new String[]{optString5};
                                                    strArr3 = new String[]{"leftPath"};
                                                }
                                                oVar.a(strArr, strArr2, strArr3, optJSONObject, aVar, Ps3);
                                                AppMethodBeat.o(138874);
                                                return;
                                            } else if (optString3.equalsIgnoreCase("blusherStick") || optString3.equalsIgnoreCase("eyeBrow")) {
                                                String optString7 = optJSONObject.optString("leftPath", null);
                                                if (Util.isNullOrNil(optString7)) {
                                                    Log.w(oVar.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, leftPath is empty");
                                                    aVar.dP("fail");
                                                    AppMethodBeat.o(138874);
                                                    return;
                                                }
                                                String optString8 = optJSONObject.optString("leftPathMD5", null);
                                                String optString9 = optJSONObject.optString("rightPath", null);
                                                if (Util.isNullOrNil(optString9)) {
                                                    Log.w(oVar.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, rightPath is empty");
                                                    aVar.dP("fail");
                                                    AppMethodBeat.o(138874);
                                                    return;
                                                }
                                                oVar.a(new String[]{optString7, optString9}, new String[]{optString8, optJSONObject.optString("rightPathMD5", null)}, new String[]{"leftPath", "rightPath"}, optJSONObject, aVar, Ps3);
                                                AppMethodBeat.o(138874);
                                                return;
                                            } else if (optString3.equalsIgnoreCase("faceContour")) {
                                                String optString10 = optJSONObject.optString("highlightPath", null);
                                                if (Util.isNullOrNil(optString10)) {
                                                    Log.w(oVar.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, highLightPath is empty");
                                                    aVar.dP("fail");
                                                    AppMethodBeat.o(138874);
                                                    return;
                                                }
                                                String optString11 = optJSONObject.optString("highlightPathMD5", null);
                                                String optString12 = optJSONObject.optString("shadowPath", null);
                                                if (Util.isNullOrNil(optString12)) {
                                                    Log.w(oVar.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, shadowPath is empty");
                                                    aVar.dP("fail");
                                                    AppMethodBeat.o(138874);
                                                    return;
                                                }
                                                oVar.a(new String[]{optString10, optString12}, new String[]{optString11, optJSONObject.optString("shadowPathMD5", null)}, new String[]{"highlightPath", "shadowPath"}, optJSONObject, aVar, Ps3);
                                                AppMethodBeat.o(138874);
                                                return;
                                            } else {
                                                Log.w(oVar.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher2, makeupTypeStr is illegal");
                                                aVar.dP("fail");
                                                AppMethodBeat.o(138874);
                                                return;
                                            }
                                        } else {
                                            Log.w(oVar.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher, type is illegal");
                                            aVar.dP("fail");
                                            AppMethodBeat.o(138874);
                                            return;
                                        }
                                    } else {
                                        oVar.cHo.a(aVar, optString2, Ps3.optString("md5", null), optString.equalsIgnoreCase("applySticker"), new a.b(aVar, Ps3, optString) {
                                            /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.AnonymousClass6 */
                                            final /* synthetic */ com.tencent.luggage.xweb_ext.extendplugin.a cFk;
                                            final /* synthetic */ String cFo;
                                            final /* synthetic */ JSONObject cvS;

                                            {
                                                this.cFk = r2;
                                                this.cvS = r3;
                                                this.cFo = r4;
                                            }

                                            @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a.b
                                            public final void Qi() {
                                                AppMethodBeat.i(215635);
                                                Log.w(o.this.getLogTag(), "convertResourcePathAndOperateLivePusher#onLoadFailure");
                                                this.cFk.dP("fail");
                                                AppMethodBeat.o(215635);
                                            }

                                            @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a.AbstractC0191a
                                            public final void F(String str, String str2) {
                                                AppMethodBeat.i(138857);
                                                Log.i(o.this.getLogTag(), "convertResourcePathAndOperateLivePusher#onLoad, path: %s, localPath: %s", str, str2);
                                                try {
                                                    this.cvS.put("path", str2);
                                                    if (o.this.cHl == null) {
                                                        Log.w(o.this.getLogTag(), "convertResourcePathAndOperateLivePusher#onLoad, adapter is null");
                                                        AppMethodBeat.o(138857);
                                                        return;
                                                    }
                                                    com.tencent.luggage.xweb_ext.extendplugin.component.live.a f2 = o.this.cHl.f(this.cFo, this.cvS);
                                                    Log.i(o.this.getLogTag(), "convertResourcePathAndOperateLivePusher#onLoad, type:%s, error:[%s, %s]", this.cFo, Integer.valueOf(f2.errorCode), f2.errorInfo);
                                                    this.cFk.dP(f2.errorCode == 0 ? "ok" : "fail");
                                                    AppMethodBeat.o(138857);
                                                } catch (Exception e2) {
                                                    Log.w(o.this.getLogTag(), "convertResourcePathAndOperateLivePusher#onLoad, put fail since ".concat(String.valueOf(e2)));
                                                    this.cFk.dP("fail");
                                                    AppMethodBeat.o(138857);
                                                }
                                            }
                                        });
                                        AppMethodBeat.o(138874);
                                        return;
                                    }
                                }
                            } else if (oVar.cHo != null) {
                                oVar.cHo.b(aVar, new a.AbstractC0191a() {
                                    /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.AnonymousClass13 */

                                    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a.AbstractC0191a
                                    public final void F(String str, String str2) {
                                        AppMethodBeat.i(215641);
                                        if (!Util.isNullOrNil(str2)) {
                                            Log.i(o.this.getLogTag(), "operatePlayBgm, local file path:%s", str2);
                                            JSONObject jSONObject = new JSONObject();
                                            try {
                                                jSONObject.put("BGMFilePath", str2);
                                            } catch (JSONException e2) {
                                                Log.e("MicroMsg.SameLayer.LivePusherPluginHandler", "operatePlayBgm, set param fail", e2);
                                            }
                                            if (!(o.this.cHl == null || o.this.cHl.f("playBGM", jSONObject).errorCode == 0)) {
                                                Log.e("MicroMsg.SameLayer.LivePusherPluginHandler", "operatePlayBgm, play bgm fail, url:%s", str);
                                                if (o.this.cHn != null) {
                                                    HashMap<String, Object> hashMap = new HashMap<>();
                                                    hashMap.put("url", str);
                                                    o.this.cHn.a(o.this.getId(), ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL, "play bgm fail", hashMap);
                                                }
                                            }
                                            AppMethodBeat.o(215641);
                                            return;
                                        }
                                        Log.e("MicroMsg.SameLayer.LivePusherPluginHandler", "operatePlayBgm, download file fail, url:%s", str);
                                        if (o.this.cHn != null) {
                                            HashMap<String, Object> hashMap2 = new HashMap<>();
                                            hashMap2.put("url", str);
                                            o.this.cHn.a(o.this.getId(), ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL, "download file fail", hashMap2);
                                        }
                                        AppMethodBeat.o(215641);
                                    }
                                });
                                aVar.dP("ok");
                                AppMethodBeat.o(138874);
                                return;
                            } else {
                                aVar.dP("fail");
                                AppMethodBeat.o(138874);
                                return;
                            }
                        } else if (Pt.contains("remove")) {
                            oVar.hV(8);
                            oVar.release();
                            aVar.dP("ok");
                        }
                    }
                    AppMethodBeat.o(138874);
                }
            });
        }
        AppMethodBeat.o(138884);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void b(final com.tencent.luggage.xweb_ext.extendplugin.a aVar, final JSONObject jSONObject) {
        int length;
        AppMethodBeat.i(215648);
        JSONArray optJSONArray = jSONObject.optJSONArray("stickers");
        if (optJSONArray == null || (length = optJSONArray.length()) == 0) {
            Log.w(getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher, stickersJsonArr is empty");
            aVar.dP("fail");
            AppMethodBeat.o(215648);
            return;
        }
        final b bVar = new b((byte) 0);
        bVar.count = length;
        for (final int i2 = 0; i2 < length; i2++) {
            final JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject == null) {
                Log.w(getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1, stickerJsonObj(%d) is null", Integer.valueOf(i2));
                aVar.dP("fail");
                AppMethodBeat.o(215648);
                return;
            }
            String optString = optJSONObject.optString("path", null);
            if (Util.isNullOrNil(optString)) {
                Log.i(getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1, resourcePath(%d) is empty", Integer.valueOf(i2));
                aVar.dP("fail");
                AppMethodBeat.o(215648);
                return;
            }
            this.cHo.a(aVar, optString, optJSONObject.optString("md5", null), true, new a.b() {
                /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.AnonymousClass7 */

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a.b
                public final void Qi() {
                    AppMethodBeat.i(215636);
                    Log.w(o.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoadFailure#" + i2);
                    aVar.dP("fail");
                    AppMethodBeat.o(215636);
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a.AbstractC0191a
                public final void F(String str, String str2) {
                    AppMethodBeat.i(178819);
                    Log.i(o.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoad#%d, path: %s, localPath: %s", Integer.valueOf(i2), str, str2);
                    try {
                        optJSONObject.put("path", str2);
                        if (o.this.cHl == null) {
                            Log.w(o.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoad#%d, adapter is null", Integer.valueOf(i2));
                            AppMethodBeat.o(178819);
                            return;
                        }
                        b bVar = bVar;
                        bVar.count--;
                        Log.i(o.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoad#%d, pendingConvertCount: %d", Integer.valueOf(i2), Integer.valueOf(bVar.count));
                        if (bVar.count == 0) {
                            com.tencent.luggage.xweb_ext.extendplugin.component.live.a f2 = o.this.cHl.f("applySticker", jSONObject);
                            Log.i(o.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoad#%d, type:applySticker, error:[%s, %s]", Integer.valueOf(i2), Integer.valueOf(f2.errorCode), f2.errorInfo);
                            aVar.dP(f2.errorCode == 0 ? "ok" : "fail");
                        }
                        AppMethodBeat.o(178819);
                    } catch (Exception e2) {
                        Log.w(o.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoad#%d, put fail since %s", Integer.valueOf(i2), e2);
                        aVar.dP("fail");
                        AppMethodBeat.o(178819);
                    }
                }
            });
        }
        AppMethodBeat.o(215648);
    }

    /* access modifiers changed from: package-private */
    public final void a(String[] strArr, String[] strArr2, final String[] strArr3, final JSONObject jSONObject, final com.tencent.luggage.xweb_ext.extendplugin.a aVar, final JSONObject jSONObject2) {
        AppMethodBeat.i(215649);
        int length = strArr.length;
        final b bVar = new b((byte) 0);
        bVar.count = length;
        for (final int i2 = 0; i2 < length; i2++) {
            this.cHo.a(aVar, strArr[i2], strArr2[i2], false, new a.b() {
                /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.AnonymousClass8 */

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a.b
                public final void Qi() {
                    AppMethodBeat.i(215637);
                    Log.w(o.this.getLogTag(), "convertPathAndApplyMakeupInner#onLoadFailure#" + i2);
                    aVar.dP("fail");
                    AppMethodBeat.o(215637);
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a.AbstractC0191a
                public final void F(String str, String str2) {
                    AppMethodBeat.i(215638);
                    Log.i(o.this.getLogTag(), "convertPathAndApplyMakeupInner#onLoad#%d, path: %s, localPath: %s", Integer.valueOf(i2), str, str2);
                    try {
                        jSONObject.put(strArr3[i2], str2);
                        if (o.this.cHl == null) {
                            Log.w(o.this.getLogTag(), "convertPathAndApplyMakeupInner#onLoad#%d, adapter is null", Integer.valueOf(i2));
                            AppMethodBeat.o(215638);
                            return;
                        }
                        b bVar = bVar;
                        bVar.count--;
                        Log.i(o.this.getLogTag(), "convertPathAndApplyMakeupInner#onLoad#%d, pendingConvertCount: %d", Integer.valueOf(i2), Integer.valueOf(bVar.count));
                        if (bVar.count == 0) {
                            com.tencent.luggage.xweb_ext.extendplugin.component.live.a f2 = o.this.cHl.f("applyMakeup", jSONObject2);
                            Log.i(o.this.getLogTag(), "convertResourcePathWorkaroundAndOperateLivePusher1#onLoad#%d, type:applyMakeup, error:[%s, %s]", Integer.valueOf(i2), Integer.valueOf(f2.errorCode), f2.errorInfo);
                            aVar.dP(f2.errorCode == 0 ? "ok" : "fail");
                        }
                        AppMethodBeat.o(215638);
                    } catch (Exception e2) {
                        Log.w(o.this.getLogTag(), "convertPathAndApplyMakeupInner#onLoad#%d, put fail since %s", Integer.valueOf(i2), e2);
                        aVar.dP("fail");
                        AppMethodBeat.o(215638);
                    }
                }
            });
        }
        AppMethodBeat.o(215649);
    }

    /* access modifiers changed from: package-private */
    public static class b {
        int count;

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public final void n(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        AppMethodBeat.i(138885);
        if (this.cHo != null) {
            this.cHo.a(aVar, new a.AbstractC0191a() {
                /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.AnonymousClass9 */

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a.AbstractC0191a
                public final void F(String str, String str2) {
                    AppMethodBeat.i(178821);
                    if (!Util.isNullOrNil(str2)) {
                        String k = q.k(str2, false);
                        Log.i(o.this.getLogTag(), "convertBackgroundImageToLocalPath, targetPath:%s", k);
                        if (o.this.cHl != null) {
                            Bundle bundle = new Bundle();
                            bundle.putString("backgroundImage", k);
                            o.this.cHl.o(bundle);
                        }
                        AppMethodBeat.o(178821);
                        return;
                    }
                    Log.i(o.this.getLogTag(), "convertBackgroundImageToLocalPath, load background image fail");
                    if (o.this.cHn != null) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("url", str);
                        o.this.cHn.a(o.this.getId(), ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL, "load background image fail", hashMap);
                    }
                    AppMethodBeat.o(178821);
                }
            });
        }
        AppMethodBeat.o(138885);
    }

    /* access modifiers changed from: package-private */
    public final void o(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        AppMethodBeat.i(178835);
        if (this.cHo != null && !Util.isNullOrNil(this.cHp)) {
            this.cHo.a(aVar, this.cHp, this.cHq, new a.AbstractC0191a() {
                /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.AnonymousClass10 */

                @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.a.AbstractC0191a
                public final void F(String str, String str2) {
                    AppMethodBeat.i(215639);
                    if (!Util.isNullOrNil(str2)) {
                        String k = q.k(str2, false);
                        Log.i(o.this.getLogTag(), "convertFilterImageToLocalPath, targetPath:%s", k);
                        if (o.this.cHl != null) {
                            Bundle bundle = new Bundle();
                            bundle.putString("filterImage", k);
                            o.this.cHl.o(bundle);
                        }
                        AppMethodBeat.o(215639);
                        return;
                    }
                    Log.i(o.this.getLogTag(), "convertFilterImageToLocalPath, load filter image fail");
                    if (o.this.cHn != null) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("url", str);
                        o.this.cHn.a(o.this.getId(), 10005, "load filter image fail", hashMap);
                    }
                    AppMethodBeat.o(215639);
                }
            });
        }
        AppMethodBeat.o(178835);
    }

    /* access modifiers changed from: package-private */
    public final void j(JSONObject jSONObject) {
        AppMethodBeat.i(178836);
        if (jSONObject.has("filterImage")) {
            this.cHp = jSONObject.optString("filterImage", this.cHp);
            this.cHq = jSONObject.optString("filterImageMd5", null);
            if (Util.isNullOrNil(this.cHp)) {
                try {
                    jSONObject.put("filterImage", "");
                    AppMethodBeat.o(178836);
                    return;
                } catch (JSONException e2) {
                    Log.w(getLogTag(), "parseFilterImage, ignore exception:%s", e2);
                    AppMethodBeat.o(178836);
                    return;
                }
            } else if (this.cHp.startsWith(HttpWrapperBase.PROTOCAL_HTTP) || this.cHp.startsWith(HttpWrapperBase.PROTOCAL_HTTPS)) {
                jSONObject.remove("filterImage");
            }
        }
        AppMethodBeat.o(178836);
    }

    /* access modifiers changed from: package-private */
    public final void a(com.tencent.luggage.xweb_ext.extendplugin.a aVar, JSONObject jSONObject) {
        AppMethodBeat.i(138886);
        if (jSONObject.has("needEvent")) {
            this.cEJ = jSONObject.optBoolean("needEvent", false);
            if (PS()) {
                this.cHn.m(aVar);
            }
        }
        AppMethodBeat.o(138886);
    }

    /* access modifiers changed from: package-private */
    public final void i(JSONObject jSONObject) {
        JSONObject optJSONObject;
        AppMethodBeat.i(138887);
        if (jSONObject.has("position") && (optJSONObject = jSONObject.optJSONObject("position")) != null) {
            this.cEF = g.zD(optJSONObject.optInt("width", 0));
            this.cEG = g.zD(optJSONObject.optInt("height", 0));
            Log.i(getLogTag(), "parseHtmlPosition, size:[%d, %d]", Integer.valueOf(this.cEF), Integer.valueOf(this.cEG));
            PR();
        }
        AppMethodBeat.o(138887);
    }

    private void PR() {
        AppMethodBeat.i(138888);
        if (!(this.cEF == 0 || this.cEG == 0 || this.mSurfaceTexture == null || this.cHl == null)) {
            Log.i(getLogTag(), "adjustHtmlSize, size:[%d, %d]", Integer.valueOf(this.cEF), Integer.valueOf(this.cEG));
            this.mSurfaceTexture.setDefaultBufferSize(this.cEF, this.cEG);
            this.cHl.bV(this.cEF, this.cEG);
        }
        AppMethodBeat.o(138888);
    }

    /* access modifiers changed from: package-private */
    public final void k(JSONObject jSONObject) {
        boolean z = false;
        AppMethodBeat.i(138889);
        if (jSONObject.has("focusMode")) {
            if (jSONObject.optInt("focusMode", 0) != 0) {
                z = true;
            }
            this.cHs = z;
        }
        AppMethodBeat.o(138889);
    }

    /* access modifiers changed from: package-private */
    public final void l(JSONObject jSONObject) {
        AppMethodBeat.i(138890);
        if (jSONObject.has("zoom")) {
            this.cHt = jSONObject.optBoolean("zoom", false);
        }
        AppMethodBeat.o(138890);
    }

    /* access modifiers changed from: package-private */
    public final void a(final Activity activity, final com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        AppMethodBeat.i(138891);
        int i2 = this.cHr;
        this.cHr = i2 + 1;
        if (i2 > 5) {
            Log.i(getLogTag(), "doInvokeInsertAfterRequestPermission, avoid dead loop");
            aVar.dP("fail:system permission denied");
            AppMethodBeat.o(138891);
            return;
        }
        r.b(aVar.getAppId(), new a.AbstractC0015a() {
            /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.AnonymousClass14 */

            @Override // android.support.v4.app.a.AbstractC0015a
            public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
                AppMethodBeat.i(215644);
                Log.i(o.this.getLogTag(), "onRequestPermissionsResult callback, requestCode:%d", Integer.valueOf(i2));
                if (i2 != 117) {
                    if (i2 == 118) {
                        if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                            Log.i(o.this.getLogTag(), "onRequestPermissionsResult callback, microphone permission not grant");
                            aVar.dP("fail:system permission denied");
                        } else {
                            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                                /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.AnonymousClass14.AnonymousClass2 */

                                public final void run() {
                                    AppMethodBeat.i(215643);
                                    o.this.a(activity, aVar);
                                    AppMethodBeat.o(215643);
                                }
                            }, 50);
                            AppMethodBeat.o(215644);
                            return;
                        }
                    }
                    AppMethodBeat.o(215644);
                } else if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                    Log.i(o.this.getLogTag(), "onRequestPermissionsResult callback, camera permission not grant");
                    aVar.dP("fail:system permission denied");
                    AppMethodBeat.o(215644);
                } else {
                    MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                        /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.AnonymousClass14.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(215642);
                            o.this.a(activity, aVar);
                            AppMethodBeat.o(215642);
                        }
                    }, 50);
                    AppMethodBeat.o(215644);
                }
            }
        });
        if (!i.a(activity, "android.permission.CAMERA", 117, "", "")) {
            Log.i(getLogTag(), "doInvokeInsertAfterRequestPermission, no Camera Permission");
            aVar.dP("fail:system permission denied");
            AppMethodBeat.o(138891);
        } else if (!i.a(activity, "android.permission.RECORD_AUDIO", 118, "", "")) {
            Log.i(getLogTag(), "doInvokeInsertAfterRequestPermission, no Microphone Permission");
            aVar.dP("fail:system permission denied");
            AppMethodBeat.o(138891);
        } else {
            Log.i(getLogTag(), "doInvokeInsertAfterRequestPermission, invoke insertInternal");
            if (this.cHl == null) {
                Log.i(getLogTag(), "insert, adapter is null");
                AppMethodBeat.o(138891);
                return;
            }
            TXLiveBase.setAppVersion(String.format("weixin_%s", aVar.getAppId()));
            this.cED = aVar;
            this.cEE = new a.AbstractC0188a() {
                /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.AnonymousClass2 */

                @Override // com.tencent.luggage.xweb_ext.extendplugin.a.AbstractC0188a
                public final void onForeground() {
                    AppMethodBeat.i(178814);
                    Log.i(o.this.getLogTag(), "onForeground");
                    o oVar = o.this;
                    if (oVar.cHy != null) {
                        oVar.cHy.post(new Runnable() {
                            /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.AnonymousClass3 */

                            public final void run() {
                                AppMethodBeat.i(138854);
                                o oVar = o.this;
                                Log.i(oVar.getLogTag(), "*** handler(%s) handleWebViewForeground", oVar.Lb());
                                if (oVar.cHl != null) {
                                    r rVar = oVar.cHl;
                                    if (!rVar.cIa) {
                                        new com.tencent.luggage.xweb_ext.extendplugin.component.live.a();
                                    } else if (rVar.cIb) {
                                        rVar.f("start", null);
                                    } else {
                                        rVar.f("resume", null);
                                    }
                                }
                                oVar.cHw.enable();
                                AppMethodBeat.o(138854);
                            }
                        });
                    }
                    AppMethodBeat.o(178814);
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.a.AbstractC0188a
                public final void hU(int i2) {
                    AppMethodBeat.i(178815);
                    Log.i(o.this.getLogTag(), "onBackground, type: ".concat(String.valueOf(i2)));
                    o oVar = o.this;
                    if (oVar.cHy != null) {
                        oVar.cHy.post(new Runnable(i2) {
                            /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.AnonymousClass4 */
                            final /* synthetic */ int val$type;

                            {
                                this.val$type = r2;
                            }

                            public final void run() {
                                AppMethodBeat.i(178817);
                                o oVar = o.this;
                                int i2 = this.val$type;
                                Log.i(oVar.getLogTag(), "*** handler(%s) handleWebViewBackground, type:%s", oVar.Lb(), Integer.valueOf(i2));
                                if (oVar.cHo != null) {
                                    if (!oVar.cHo.a(oVar, oVar.cED, i2) && oVar.cHl != null && i2 == 4) {
                                        r rVar = oVar.cHl;
                                        if (rVar.cHW != null) {
                                            Log.i("TXLivePusherJSAdapter", "sendHandupStop, send event 5000");
                                            rVar.cHW.onPushEvent(5000, new Bundle());
                                        }
                                    }
                                    if (oVar.cHl != null) {
                                        if (i2 == 3) {
                                            Log.i(oVar.getLogTag(), "handleWebViewBackgroundInternal, type back");
                                            oVar.cHl.cc(true);
                                        } else {
                                            Log.i(oVar.getLogTag(), "handleWebViewBackgroundInternal, type others");
                                            oVar.cHl.cc(false);
                                        }
                                    }
                                }
                                oVar.cHw.disable();
                                AppMethodBeat.o(178817);
                            }
                        });
                    }
                    AppMethodBeat.o(178815);
                }

                @Override // com.tencent.luggage.xweb_ext.extendplugin.a.AbstractC0188a
                public final void onDestroy() {
                    AppMethodBeat.i(178816);
                    o oVar = o.this;
                    if (oVar.cHy != null) {
                        oVar.cHy.post(new Runnable() {
                            /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.AnonymousClass5 */

                            public final void run() {
                                AppMethodBeat.i(178818);
                                o oVar = o.this;
                                Log.i(oVar.getLogTag(), "*** handler(%s) handleWebViewDestroy", oVar.Lb());
                                oVar.release();
                                AppMethodBeat.o(178818);
                            }
                        });
                    }
                    AppMethodBeat.o(178816);
                }
            };
            aVar.a(this.cEE);
            JSONObject Ps = aVar.Ps();
            a(aVar, Ps);
            i(Ps);
            k(Ps);
            l(Ps);
            j(Ps);
            Bundle h2 = com.tencent.luggage.xweb_ext.extendplugin.component.live.c.h(Ps);
            if (this.cHo != null) {
                String c2 = this.cHo.c(aVar, h2);
                if (!Util.isNullOrNil(c2)) {
                    Log.i(getLogTag(), "insert fail, message:%s", c2);
                    aVar.dP("fail: can not insert VOIP mode LivePusher now");
                    Toast.makeText(aVar.getContext(), c2, 0).show();
                    AppMethodBeat.o(138891);
                    return;
                }
            }
            r rVar = this.cHl;
            if (rVar.cHW != null) {
                Bundle bundle = new Bundle();
                bundle.putString(TXLiveConstants.EVT_DESCRIPTION, TXLiveBase.getSDKVersionStr());
                bundle.putLong("EVT_TIME", System.currentTimeMillis());
                rVar.cHW.onPushEvent(-9999999, bundle);
            }
            r.l("InitLivePusher", h2);
            rVar.mVideoView = null;
            rVar.cHX = h2.getString("pushUrl", "");
            rVar.cHV.setPusherUrl(rVar.cHX);
            rVar.a(h2, true);
            rVar.cIh = h2.getBoolean("autopush", rVar.cIh);
            if (rVar.cIh && rVar.cHX != null && !rVar.cHX.isEmpty() && !rVar.cHV.isPushing()) {
                Log.i("TXLivePusherJSAdapter", "initLivePusher: startPusher");
                rVar.ca(rVar.cIm);
                rVar.cb(rVar.cIn);
                if (rVar.cIm && rVar.mSurface != null) {
                    rVar.cHV.setSurface(rVar.mSurface);
                }
                rVar.cHV.startPusher(rVar.cHX);
            }
            rVar.mInited = true;
            com.tencent.luggage.xweb_ext.extendplugin.component.live.a aVar2 = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a();
            Log.i(getLogTag(), "insert, code:%d info:%s", Integer.valueOf(aVar2.errorCode), aVar2.errorInfo);
            aVar.dP(aVar2.errorCode == 0 ? "ok" : "fail");
            n(aVar);
            o(aVar);
            if (aVar2.errorCode == 0 && this.cHo != null) {
                this.cHo.a(this, this.cED, h2);
            }
            AppMethodBeat.o(138891);
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.o
    public final void PG() {
        AppMethodBeat.i(215650);
        if (this.cHy != null) {
            this.cHy.post(new Runnable() {
                /* class com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.o.AnonymousClass15 */

                public final void run() {
                    AppMethodBeat.i(215645);
                    if (o.this.cHl != null) {
                        o.this.cHl.f("stop", new JSONObject());
                        r rVar = o.this.cHl;
                        if (rVar.cHW != null) {
                            Log.i("TXLivePusherJSAdapter", "sendWeChatStop, send event 5001");
                            rVar.cHW.onPushEvent(5001, new Bundle());
                        }
                    }
                    AppMethodBeat.o(215645);
                }
            });
        }
        AppMethodBeat.o(215650);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.o
    public final String PH() {
        AppMethodBeat.i(215651);
        String format = String.format("%s_%s", this.type, Integer.valueOf(getId()));
        AppMethodBeat.o(215651);
        return format;
    }

    /* access modifiers changed from: package-private */
    public final void release() {
        AppMethodBeat.i(138892);
        if (this.cHo != null) {
            this.cHo.c(this, this.cED);
            this.cHo.a(this, this.cED);
        }
        if (this.cHl != null) {
            this.cHl.Qj();
            this.cHl = null;
        }
        if (this.mSurface != null) {
            this.mSurface.release();
            this.mSurface = null;
        }
        if (this.cED != null) {
            this.cED.Pu();
            this.cEE = null;
        }
        Log.i(getLogTag(), "LivePusher release handler thread");
        if (this.cHy != null) {
            this.cHy.removeCallbacksAndMessages(null);
        }
        if (this.cHz != null) {
            this.cHz.quitSafely();
        }
        AppMethodBeat.o(138892);
    }

    /* access modifiers changed from: package-private */
    public final void hV(int i2) {
        AppMethodBeat.i(138893);
        if (this.cHm != null) {
            this.cHm.aW((long) i2);
        }
        AppMethodBeat.o(138893);
    }

    /* access modifiers changed from: package-private */
    public final boolean PS() {
        return this.cHn != null;
    }

    /* access modifiers changed from: package-private */
    public class c implements Runnable {
        MotionEvent cHK;

        private c() {
        }

        /* synthetic */ c(o oVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(138876);
            if (!(!o.this.cHs || o.this.cEF == 0 || o.this.cEG == 0)) {
                o.this.t(this.cHK.getX() / ((float) o.this.cEF), this.cHK.getY() / ((float) o.this.cEG));
            }
            AppMethodBeat.o(138876);
        }
    }

    /* access modifiers changed from: package-private */
    public final void t(float f2, float f3) {
        AppMethodBeat.i(138894);
        if (this.cHl != null) {
            this.cHl.cHV.setFocusPosition(f2, f3);
            com.tencent.luggage.xweb_ext.extendplugin.component.live.a aVar = new com.tencent.luggage.xweb_ext.extendplugin.component.live.a();
            Log.i(getLogTag(), "onTouchFocusPosition, set focus(%s, %s), code:%d, info:%s", Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(aVar.errorCode), aVar.errorInfo);
        }
        AppMethodBeat.o(138894);
    }

    static /* synthetic */ void a(o oVar, SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(215652);
        super.e(surfaceTexture);
        Log.i(oVar.getLogTag(), "*** handler(%s) handlePluginReady", oVar.Lb());
        oVar.mSurfaceTexture = surfaceTexture;
        oVar.mSurface = new Surface(surfaceTexture);
        if (oVar.cHl != null) {
            r rVar = oVar.cHl;
            Surface surface = oVar.mSurface;
            rVar.mSurface = surface;
            rVar.cHV.setSurface(surface);
            new com.tencent.luggage.xweb_ext.extendplugin.component.live.a();
            oVar.PR();
        }
        AppMethodBeat.o(215652);
    }

    static /* synthetic */ void a(o oVar) {
        AppMethodBeat.i(215653);
        super.PQ();
        Log.i(oVar.getLogTag(), "*** handler(%s) handlePluginDestroy", oVar.Lb());
        AppMethodBeat.o(215653);
    }

    static /* synthetic */ void a(o oVar, MotionEvent motionEvent) {
        AppMethodBeat.i(215654);
        super.o(motionEvent);
        Log.i(oVar.getLogTag(), "*** handler(%s) handlePluginTouch(%s)", oVar.Lb(), motionEvent);
        if (oVar.cHs || oVar.cHt) {
            if (motionEvent.getPointerCount() == 1 && motionEvent.getAction() == 0) {
                Log.i(oVar.getLogTag(), "handlePluginTouch, 1 pointer action down");
                oVar.cHu.cHK = motionEvent;
                MMHandlerThread.postToMainThreadDelayed(oVar.cHu, 100);
                AppMethodBeat.o(215654);
                return;
            } else if (motionEvent.getPointerCount() > 1 && motionEvent.getAction() == 2) {
                Log.i(oVar.getLogTag(), "handlePluginTouch, 2 pointer action move");
                MMHandlerThread.removeRunnable(oVar.cHu);
                oVar.t(-1.0f, -1.0f);
                if (oVar.cHt && oVar.mScaleGestureDetector != null) {
                    oVar.mScaleGestureDetector.onTouchEvent(motionEvent);
                }
            }
        }
        AppMethodBeat.o(215654);
    }
}
