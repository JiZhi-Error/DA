package com.tencent.trtc;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.renderer.e;
import com.tencent.liteav.trtc.impl.TRTCCloudImpl;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.ITXLivePlayListener;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCStatistics;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

public class WXTRTCCloud extends TRTCCloudImpl {
    private static final String TAG = "WXTRTCCloud";
    private static WXTRTCCloud sInstance = null;
    private HashMap<String, a> mMapAudioVolumeListener = new HashMap<>();
    private HashMap<String, Integer> mMapLastUserVolumes = new HashMap<>();
    private HashMap<String, WeakReference<ITXLivePlayListener>> mMapMainStreamPlayListener = new HashMap<>();
    private HashMap<String, WeakReference<ITXLivePlayListener>> mMapSubStreamPlayListener = new HashMap<>();
    private WeakReference<ITXLivePushListener> mPushListener = null;

    public interface ITXAudioVolumeEvaluationListener {
        void onAudioVolumeEvaluationNotify(int i2);
    }

    static /* synthetic */ void access$1100(WXTRTCCloud wXTRTCCloud, String str) {
        AppMethodBeat.i(14346);
        wXTRTCCloud.apiLog(str);
        AppMethodBeat.o(14346);
    }

    static /* synthetic */ void access$1400(WXTRTCCloud wXTRTCCloud, String str) {
        AppMethodBeat.i(14347);
        wXTRTCCloud.apiLog(str);
        AppMethodBeat.o(14347);
    }

    static /* synthetic */ int access$1800(WXTRTCCloud wXTRTCCloud, long j2, int i2) {
        AppMethodBeat.i(222693);
        int nativeAddUpstream = wXTRTCCloud.nativeAddUpstream(j2, i2);
        AppMethodBeat.o(222693);
        return nativeAddUpstream;
    }

    static /* synthetic */ void access$1900(WXTRTCCloud wXTRTCCloud, String str) {
        AppMethodBeat.i(14349);
        wXTRTCCloud.apiLog(str);
        AppMethodBeat.o(14349);
    }

    static /* synthetic */ void access$2100(WXTRTCCloud wXTRTCCloud, String str) {
        AppMethodBeat.i(14350);
        wXTRTCCloud.apiLog(str);
        AppMethodBeat.o(14350);
    }

    static /* synthetic */ void access$2200(WXTRTCCloud wXTRTCCloud, String str) {
        AppMethodBeat.i(14351);
        wXTRTCCloud.apiLog(str);
        AppMethodBeat.o(14351);
    }

    static /* synthetic */ void access$2300(WXTRTCCloud wXTRTCCloud, String str) {
        AppMethodBeat.i(14352);
        wXTRTCCloud.apiLog(str);
        AppMethodBeat.o(14352);
    }

    static /* synthetic */ void access$2400(WXTRTCCloud wXTRTCCloud, String str) {
        AppMethodBeat.i(170247);
        wXTRTCCloud.apiLog(str);
        AppMethodBeat.o(170247);
    }

    static /* synthetic */ void access$2600(WXTRTCCloud wXTRTCCloud, String str) {
        AppMethodBeat.i(14354);
        wXTRTCCloud.apiLog(str);
        AppMethodBeat.o(14354);
    }

    static /* synthetic */ void access$2700(WXTRTCCloud wXTRTCCloud, String str) {
        AppMethodBeat.i(14355);
        wXTRTCCloud.apiLog(str);
        AppMethodBeat.o(14355);
    }

    static /* synthetic */ void access$2800(WXTRTCCloud wXTRTCCloud, String str) {
        AppMethodBeat.i(170248);
        wXTRTCCloud.apiLog(str);
        AppMethodBeat.o(170248);
    }

    static /* synthetic */ void access$2900(WXTRTCCloud wXTRTCCloud, String str) {
        AppMethodBeat.i(14356);
        wXTRTCCloud.apiLog(str);
        AppMethodBeat.o(14356);
    }

    static /* synthetic */ void access$3100(WXTRTCCloud wXTRTCCloud, String str) {
        AppMethodBeat.i(14358);
        wXTRTCCloud.apiLog(str);
        AppMethodBeat.o(14358);
    }

    static /* synthetic */ void access$3200(WXTRTCCloud wXTRTCCloud, String str) {
        AppMethodBeat.i(170249);
        wXTRTCCloud.apiLog(str);
        AppMethodBeat.o(170249);
    }

    static /* synthetic */ void access$3300(WXTRTCCloud wXTRTCCloud, String str) {
        AppMethodBeat.i(14359);
        wXTRTCCloud.apiLog(str);
        AppMethodBeat.o(14359);
    }

    static /* synthetic */ void access$3400(WXTRTCCloud wXTRTCCloud, String str) {
        AppMethodBeat.i(14360);
        wXTRTCCloud.apiLog(str);
        AppMethodBeat.o(14360);
    }

    static /* synthetic */ void access$3600(WXTRTCCloud wXTRTCCloud, String str) {
        AppMethodBeat.i(170250);
        wXTRTCCloud.apiLog(str);
        AppMethodBeat.o(170250);
    }

    static /* synthetic */ void access$3700(WXTRTCCloud wXTRTCCloud, String str) {
        AppMethodBeat.i(170251);
        wXTRTCCloud.apiLog(str);
        AppMethodBeat.o(170251);
    }

    static /* synthetic */ void access$3800(WXTRTCCloud wXTRTCCloud, String str) {
        AppMethodBeat.i(14362);
        wXTRTCCloud.apiLog(str);
        AppMethodBeat.o(14362);
    }

    static /* synthetic */ void access$400(WXTRTCCloud wXTRTCCloud, String str) {
        AppMethodBeat.i(14343);
        wXTRTCCloud.apiLog(str);
        AppMethodBeat.o(14343);
    }

    static /* synthetic */ int access$4400(WXTRTCCloud wXTRTCCloud, int i2, int i3) {
        AppMethodBeat.i(182438);
        int networkQuality = wXTRTCCloud.getNetworkQuality(i2, i3);
        AppMethodBeat.o(182438);
        return networkQuality;
    }

    static /* synthetic */ int access$4600(WXTRTCCloud wXTRTCCloud, int i2, int i3) {
        AppMethodBeat.i(182439);
        int networkQuality = wXTRTCCloud.getNetworkQuality(i2, i3);
        AppMethodBeat.o(182439);
        return networkQuality;
    }

    static /* synthetic */ void access$4800(WXTRTCCloud wXTRTCCloud, TXCloudVideoView tXCloudVideoView, TXCRenderAndDec tXCRenderAndDec, TRTCRoomInfo.UserInfo userInfo) {
        AppMethodBeat.i(182440);
        wXTRTCCloud.checkRemoteDashBoard(tXCloudVideoView, tXCRenderAndDec, userInfo);
        AppMethodBeat.o(182440);
    }

    static /* synthetic */ void access$4900(WXTRTCCloud wXTRTCCloud, TXCloudVideoView tXCloudVideoView, TXCRenderAndDec tXCRenderAndDec, TRTCRoomInfo.UserInfo userInfo) {
        AppMethodBeat.i(182441);
        wXTRTCCloud.checkRemoteDashBoard(tXCloudVideoView, tXCRenderAndDec, userInfo);
        AppMethodBeat.o(182441);
    }

    static /* synthetic */ void access$600(WXTRTCCloud wXTRTCCloud, String str) {
        AppMethodBeat.i(14344);
        wXTRTCCloud.apiLog(str);
        AppMethodBeat.o(14344);
    }

    static /* synthetic */ void access$800(WXTRTCCloud wXTRTCCloud, String str) {
        AppMethodBeat.i(14345);
        wXTRTCCloud.apiLog(str);
        AppMethodBeat.o(14345);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        public WeakReference<ITXAudioVolumeEvaluationListener> SpJ;

        /* renamed from: a  reason: collision with root package name */
        public int f2992a;

        /* renamed from: c  reason: collision with root package name */
        public WeakReference<ITXAudioVolumeEvaluationListener> f2993c;

        private a() {
            this.SpJ = null;
            this.f2993c = null;
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static WXTRTCCloud sharedInstance(Context context) {
        WXTRTCCloud wXTRTCCloud;
        AppMethodBeat.i(14311);
        synchronized (WXTRTCCloud.class) {
            try {
                if (sInstance == null) {
                    sInstance = new WXTRTCCloud(context);
                }
                wXTRTCCloud = sInstance;
            } finally {
                AppMethodBeat.o(14311);
            }
        }
        return wXTRTCCloud;
    }

    public static void destroySharedInstance() {
        AppMethodBeat.i(222687);
        synchronized (WXTRTCCloud.class) {
            try {
                if (sInstance != null) {
                    TXCLog.i(TAG, "trtc_api destroy instance " + sInstance);
                    sInstance.destroy();
                    sInstance = null;
                }
            } finally {
                AppMethodBeat.o(222687);
            }
        }
    }

    public WXTRTCCloud(Context context) {
        super(context);
        AppMethodBeat.i(14312);
        this.mConfig.W = false;
        this.mConfig.f786j = 1;
        this.mCaptureAndEnc.a(this.mConfig);
        this.mCaptureAndEnc.g(false);
        setLocalViewFillMode(0);
        AppMethodBeat.o(14312);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void enterRoom(TRTCCloudDef.TRTCParams tRTCParams, int i2) {
        AppMethodBeat.i(14313);
        super.enterRoom(tRTCParams, i2);
        AppMethodBeat.o(14313);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void exitRoom() {
        AppMethodBeat.i(14314);
        super.exitRoom();
        runOnSDKThread(new Runnable() {
            /* class com.tencent.trtc.WXTRTCCloud.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(14310);
                WXTRTCCloud.this.mMapAudioVolumeListener.clear();
                WXTRTCCloud.this.mMapLastUserVolumes.clear();
                WXTRTCCloud.this.mMapMainStreamPlayListener.clear();
                WXTRTCCloud.this.mMapSubStreamPlayListener.clear();
                AppMethodBeat.o(14310);
            }
        });
        AppMethodBeat.o(14314);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl, com.tencent.trtc.TRTCCloud
    public void startLocalAudio() {
        AppMethodBeat.i(14315);
        super.startLocalAudio();
        AppMethodBeat.o(14315);
    }

    public void setConfig(boolean z, boolean z2) {
        AppMethodBeat.i(14316);
        if (!(z == this.mConfig.K && z2 == this.mConfig.L)) {
            this.mConfig.K = z;
            this.mConfig.L = z2;
            this.mCaptureAndEnc.a(this.mConfig);
        }
        AppMethodBeat.o(14316);
    }

    public int getMaxZoom() {
        AppMethodBeat.i(222688);
        int q = this.mCaptureAndEnc.q();
        AppMethodBeat.o(222688);
        return q;
    }

    public void setFocusPosition(float f2, float f3) {
        AppMethodBeat.i(222689);
        this.mCaptureAndEnc.a(f2, f3);
        AppMethodBeat.o(222689);
    }

    public void setLocalSurface(final Surface surface) {
        AppMethodBeat.i(14317);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.trtc.WXTRTCCloud.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(14302);
                WXTRTCCloud.access$400(WXTRTCCloud.this, "setLocalSurface " + surface);
                WXTRTCCloud.this.mCaptureAndEnc.a(surface);
                AppMethodBeat.o(14302);
            }
        });
        AppMethodBeat.o(14317);
    }

    public void setLocalSurfaceSize(final int i2, final int i3) {
        AppMethodBeat.i(14318);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.trtc.WXTRTCCloud.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(14308);
                WXTRTCCloud.access$600(WXTRTCCloud.this, "setLocalSurfaceSize: " + i2 + "," + i3);
                WXTRTCCloud.this.mCaptureAndEnc.a(i2, i3);
                AppMethodBeat.o(14308);
            }
        });
        AppMethodBeat.o(14318);
    }

    public void pausePusher() {
        AppMethodBeat.i(14319);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.trtc.WXTRTCCloud.AnonymousClass8 */

            public final void run() {
                AppMethodBeat.i(160399);
                WXTRTCCloud.access$800(WXTRTCCloud.this, "pausePusher");
                if (WXTRTCCloud.this.mCaptureAndEnc != null) {
                    WXTRTCCloud.this.mCaptureAndEnc.g();
                }
                AppMethodBeat.o(160399);
            }
        });
        AppMethodBeat.o(14319);
    }

    public void resumePusher() {
        AppMethodBeat.i(14320);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.trtc.WXTRTCCloud.AnonymousClass9 */

            public final void run() {
                AppMethodBeat.i(14305);
                WXTRTCCloud.access$1100(WXTRTCCloud.this, "resumePusher");
                if (WXTRTCCloud.this.mCaptureAndEnc != null) {
                    WXTRTCCloud.this.mCaptureAndEnc.h();
                }
                AppMethodBeat.o(14305);
            }
        });
        AppMethodBeat.o(14320);
    }

    public void enableBlackStream(final boolean z) {
        AppMethodBeat.i(222690);
        runOnMainThread(new Runnable() {
            /* class com.tencent.trtc.WXTRTCCloud.AnonymousClass10 */

            public final void run() {
                AppMethodBeat.i(14375);
                WXTRTCCloud.access$1400(WXTRTCCloud.this, "enableBlackStream " + z);
                if (WXTRTCCloud.this.mCaptureAndEnc != null) {
                    WXTRTCCloud.this.mCaptureAndEnc.b(z);
                }
                AppMethodBeat.o(14375);
            }
        });
        runOnSDKThread(new Runnable() {
            /* class com.tencent.trtc.WXTRTCCloud.AnonymousClass11 */

            public final void run() {
                AppMethodBeat.i(14292);
                if (z) {
                    WXTRTCCloud.access$1800(WXTRTCCloud.this, WXTRTCCloud.this.mNativeRtcContext, 2);
                }
                AppMethodBeat.o(14292);
            }
        });
        AppMethodBeat.o(222690);
    }

    public void setRemoteSurface(final String str, final Surface surface) {
        AppMethodBeat.i(14322);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.trtc.WXTRTCCloud.AnonymousClass13 */

            public final void run() {
                AppMethodBeat.i(14304);
                WXTRTCCloud.access$1900(WXTRTCCloud.this, "setRemoteSurface " + str + ", " + surface);
                TRTCRoomInfo.UserInfo user = WXTRTCCloud.this.mRoomInfo.getUser(str);
                if (user != null) {
                    TXCRenderAndDec tXCRenderAndDec = user.mainRender.render;
                    if (tXCRenderAndDec != null) {
                        e videoRender = tXCRenderAndDec.getVideoRender();
                        if (videoRender != null) {
                            videoRender.a(surface);
                            AppMethodBeat.o(14304);
                            return;
                        }
                        WXTRTCCloud.access$2100(WXTRTCCloud.this, "videoRender no exist");
                        AppMethodBeat.o(14304);
                        return;
                    }
                    WXTRTCCloud.access$2200(WXTRTCCloud.this, "render no exist");
                    AppMethodBeat.o(14304);
                    return;
                }
                WXTRTCCloud.access$2300(WXTRTCCloud.this, "user no exist");
                AppMethodBeat.o(14304);
            }
        });
        AppMethodBeat.o(14322);
    }

    public void setRemoteSurfaceSize(final String str, final int i2, final int i3) {
        AppMethodBeat.i(14323);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.trtc.WXTRTCCloud.AnonymousClass14 */

            public final void run() {
                AppMethodBeat.i(14378);
                WXTRTCCloud.access$2400(WXTRTCCloud.this, "seRemoteSurfaceSize: " + str + ", " + i2 + "," + i3);
                TRTCRoomInfo.UserInfo user = WXTRTCCloud.this.mRoomInfo.getUser(str);
                if (user != null) {
                    TXCRenderAndDec tXCRenderAndDec = user.mainRender.render;
                    if (tXCRenderAndDec != null) {
                        e videoRender = tXCRenderAndDec.getVideoRender();
                        if (videoRender != null) {
                            videoRender.c(i2, i3);
                            AppMethodBeat.o(14378);
                            return;
                        }
                        WXTRTCCloud.access$2600(WXTRTCCloud.this, "videoRender no exist");
                        AppMethodBeat.o(14378);
                        return;
                    }
                    WXTRTCCloud.access$2700(WXTRTCCloud.this, "render no exist");
                    AppMethodBeat.o(14378);
                    return;
                }
                WXTRTCCloud.access$2800(WXTRTCCloud.this, "user no exist");
                AppMethodBeat.o(14378);
            }
        });
        AppMethodBeat.o(14323);
    }

    public void setRemoteSubStreamSurface(final String str, final Surface surface) {
        AppMethodBeat.i(14324);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.trtc.WXTRTCCloud.AnonymousClass12 */

            public final void run() {
                AppMethodBeat.i(14289);
                WXTRTCCloud.access$2900(WXTRTCCloud.this, "setRemoteSubStreamSurface " + str + ", " + surface);
                TRTCRoomInfo.UserInfo user = WXTRTCCloud.this.mRoomInfo.getUser(str);
                if (user != null) {
                    TXCRenderAndDec tXCRenderAndDec = user.subRender.render;
                    if (tXCRenderAndDec != null) {
                        e videoRender = tXCRenderAndDec.getVideoRender();
                        if (videoRender != null) {
                            videoRender.a(surface);
                            AppMethodBeat.o(14289);
                            return;
                        }
                        WXTRTCCloud.access$3100(WXTRTCCloud.this, "videoRender no exist");
                        AppMethodBeat.o(14289);
                        return;
                    }
                    WXTRTCCloud.access$3200(WXTRTCCloud.this, "render no exist");
                    AppMethodBeat.o(14289);
                    return;
                }
                WXTRTCCloud.access$3300(WXTRTCCloud.this, "user no exist");
                AppMethodBeat.o(14289);
            }
        });
        AppMethodBeat.o(14324);
    }

    public void setRemoteSubStreamSurfaceSize(final String str, final int i2, final int i3) {
        AppMethodBeat.i(14325);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.trtc.WXTRTCCloud.AnonymousClass15 */

            public final void run() {
                AppMethodBeat.i(14307);
                WXTRTCCloud.access$3400(WXTRTCCloud.this, "seRemoteSubStreamSurfaceSize: " + str + ", " + i2 + "," + i3);
                TRTCRoomInfo.UserInfo user = WXTRTCCloud.this.mRoomInfo.getUser(str);
                if (user != null) {
                    TXCRenderAndDec tXCRenderAndDec = user.subRender.render;
                    if (tXCRenderAndDec != null) {
                        e videoRender = tXCRenderAndDec.getVideoRender();
                        if (videoRender != null) {
                            videoRender.c(i2, i3);
                            AppMethodBeat.o(14307);
                            return;
                        }
                        WXTRTCCloud.access$3600(WXTRTCCloud.this, "videoRender no exist");
                        AppMethodBeat.o(14307);
                        return;
                    }
                    WXTRTCCloud.access$3700(WXTRTCCloud.this, "render no exist");
                    AppMethodBeat.o(14307);
                    return;
                }
                WXTRTCCloud.access$3800(WXTRTCCloud.this, "user no exist");
                AppMethodBeat.o(14307);
            }
        });
        AppMethodBeat.o(14325);
    }

    public void registerAudioVolumeEvaluationListener(final String str, final boolean z, final ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener) {
        AppMethodBeat.i(182436);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.trtc.WXTRTCCloud.AnonymousClass16 */

            public final void run() {
                a aVar;
                AppMethodBeat.i(14306);
                if (WXTRTCCloud.this.mMapAudioVolumeListener.containsKey(str)) {
                    aVar = (a) WXTRTCCloud.this.mMapAudioVolumeListener.get(str);
                } else {
                    aVar = new a((byte) 0);
                    aVar.f2992a = 0;
                }
                if (aVar != null) {
                    if (z) {
                        aVar.f2993c = new WeakReference<>(iTXAudioVolumeEvaluationListener);
                    } else {
                        aVar.SpJ = new WeakReference<>(iTXAudioVolumeEvaluationListener);
                    }
                    WXTRTCCloud.this.mMapAudioVolumeListener.put(str, aVar);
                }
                AppMethodBeat.o(14306);
            }
        });
        AppMethodBeat.o(182436);
    }

    public void unregisterAudioVolumeEvaluationListener(final String str, final boolean z) {
        AppMethodBeat.i(182437);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.trtc.WXTRTCCloud.AnonymousClass17 */

            public final void run() {
                AppMethodBeat.i(14296);
                if (WXTRTCCloud.this.mMapAudioVolumeListener.containsKey(str)) {
                    a aVar = (a) WXTRTCCloud.this.mMapAudioVolumeListener.get(str);
                    if (aVar != null) {
                        if (z) {
                            aVar.f2993c = null;
                        } else {
                            aVar.SpJ = null;
                        }
                        if (aVar.SpJ == null && aVar.f2993c == null) {
                            WXTRTCCloud.this.mMapAudioVolumeListener.remove(str);
                            AppMethodBeat.o(14296);
                            return;
                        }
                    } else {
                        WXTRTCCloud.this.mMapAudioVolumeListener.remove(str);
                    }
                }
                AppMethodBeat.o(14296);
            }
        });
        AppMethodBeat.o(182437);
    }

    public void notifyUserVoiceVolume(final ArrayList<TRTCCloudDef.TRTCVolumeInfo> arrayList, int i2) {
        AppMethodBeat.i(222691);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.trtc.WXTRTCCloud.AnonymousClass18 */

            public final void run() {
                a aVar;
                ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener;
                AppMethodBeat.i(14294);
                ArrayList arrayList = new ArrayList();
                if (arrayList != null && arrayList.size() != 0) {
                    ArrayList arrayList2 = arrayList;
                    Collections.sort(arrayList2, new Comparator<TRTCCloudDef.TRTCVolumeInfo>() {
                        /* class com.tencent.trtc.WXTRTCCloud.AnonymousClass18.AnonymousClass1 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                        @Override // java.util.Comparator
                        public final /* synthetic */ int compare(TRTCCloudDef.TRTCVolumeInfo tRTCVolumeInfo, TRTCCloudDef.TRTCVolumeInfo tRTCVolumeInfo2) {
                            return tRTCVolumeInfo2.volume - tRTCVolumeInfo.volume;
                        }
                    });
                    HashMap hashMap = new HashMap();
                    Iterator it = arrayList2.iterator();
                    int i2 = 0;
                    while (it.hasNext()) {
                        TRTCCloudDef.TRTCVolumeInfo tRTCVolumeInfo = (TRTCCloudDef.TRTCVolumeInfo) it.next();
                        if (i2 >= 10) {
                            break;
                        }
                        if (tRTCVolumeInfo.volume > 10) {
                            i2++;
                            hashMap.put(tRTCVolumeInfo.userId, Integer.valueOf(tRTCVolumeInfo.volume));
                            arrayList.add(tRTCVolumeInfo);
                        }
                        i2 = i2;
                    }
                    for (String str : WXTRTCCloud.this.mMapLastUserVolumes.keySet()) {
                        if (!hashMap.containsKey(str)) {
                            TRTCCloudDef.TRTCVolumeInfo tRTCVolumeInfo2 = new TRTCCloudDef.TRTCVolumeInfo();
                            tRTCVolumeInfo2.userId = str;
                            tRTCVolumeInfo2.volume = 0;
                            arrayList.add(tRTCVolumeInfo2);
                        }
                    }
                    WXTRTCCloud.this.mMapLastUserVolumes.clear();
                    WXTRTCCloud.this.mMapLastUserVolumes.putAll(hashMap);
                } else if (WXTRTCCloud.this.mMapLastUserVolumes.size() > 0) {
                    for (String str2 : WXTRTCCloud.this.mMapLastUserVolumes.keySet()) {
                        TRTCCloudDef.TRTCVolumeInfo tRTCVolumeInfo3 = new TRTCCloudDef.TRTCVolumeInfo();
                        tRTCVolumeInfo3.userId = str2;
                        tRTCVolumeInfo3.volume = 0;
                        arrayList.add(tRTCVolumeInfo3);
                    }
                    WXTRTCCloud.this.mMapLastUserVolumes.clear();
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    TRTCCloudDef.TRTCVolumeInfo tRTCVolumeInfo4 = (TRTCCloudDef.TRTCVolumeInfo) it2.next();
                    String str3 = tRTCVolumeInfo4.userId;
                    int i3 = tRTCVolumeInfo4.volume;
                    if (!(!WXTRTCCloud.this.mMapAudioVolumeListener.keySet().contains(str3) || (aVar = (a) WXTRTCCloud.this.mMapAudioVolumeListener.get(str3)) == null || i3 == aVar.f2992a)) {
                        aVar.f2992a = i3;
                        if (aVar.SpJ != null) {
                            iTXAudioVolumeEvaluationListener = aVar.SpJ.get();
                        } else if (aVar.f2993c != null) {
                            iTXAudioVolumeEvaluationListener = aVar.f2993c.get();
                        } else {
                            iTXAudioVolumeEvaluationListener = null;
                        }
                        if (iTXAudioVolumeEvaluationListener != null) {
                            iTXAudioVolumeEvaluationListener.onAudioVolumeEvaluationNotify(i3);
                        }
                    }
                }
                AppMethodBeat.o(14294);
            }
        });
        AppMethodBeat.o(222691);
    }

    public void setPushListener(ITXLivePushListener iTXLivePushListener) {
        AppMethodBeat.i(222692);
        this.mPushListener = new WeakReference<>(iTXLivePushListener);
        AppMethodBeat.o(222692);
    }

    public void registerPlayListener(final String str, final boolean z, final ITXLivePlayListener iTXLivePlayListener) {
        AppMethodBeat.i(14337);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.trtc.WXTRTCCloud.AnonymousClass19 */

            public final void run() {
                AppMethodBeat.i(14293);
                if (z) {
                    WXTRTCCloud.this.mMapSubStreamPlayListener.put(str, new WeakReference(iTXLivePlayListener));
                    AppMethodBeat.o(14293);
                    return;
                }
                WXTRTCCloud.this.mMapMainStreamPlayListener.put(str, new WeakReference(iTXLivePlayListener));
                AppMethodBeat.o(14293);
            }
        });
        AppMethodBeat.o(14337);
    }

    public void unregisterPlayListener(final String str, final boolean z) {
        AppMethodBeat.i(14338);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.trtc.WXTRTCCloud.AnonymousClass20 */

            public final void run() {
                AppMethodBeat.i(14309);
                if (z) {
                    WXTRTCCloud.this.mMapSubStreamPlayListener.remove(str);
                    AppMethodBeat.o(14309);
                    return;
                }
                WXTRTCCloud.this.mMapMainStreamPlayListener.remove(str);
                AppMethodBeat.o(14309);
            }
        });
        AppMethodBeat.o(14338);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl
    public void notifyEvent(final String str, final int i2, final Bundle bundle) {
        AppMethodBeat.i(14339);
        super.notifyEvent(str, i2, bundle);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.trtc.WXTRTCCloud.AnonymousClass21 */

            public final void run() {
                ITXLivePlayListener iTXLivePlayListener;
                AppMethodBeat.i(14300);
                if (!TextUtils.isEmpty(str) && (WXTRTCCloud.this.mRoomInfo.userId == null || !str.equalsIgnoreCase(WXTRTCCloud.this.mRoomInfo.userId))) {
                    int i2 = bundle.getInt("EVT_STREAM_TYPE", 2);
                    if (WXTRTCCloud.this.mRoomInfo.getUser(str) != null) {
                        WeakReference weakReference = null;
                        if (i2 == 7) {
                            if (WXTRTCCloud.this.mMapSubStreamPlayListener.keySet().contains(str)) {
                                weakReference = (WeakReference) WXTRTCCloud.this.mMapSubStreamPlayListener.get(str);
                            }
                        } else if (WXTRTCCloud.this.mMapMainStreamPlayListener.keySet().contains(str)) {
                            weakReference = (WeakReference) WXTRTCCloud.this.mMapMainStreamPlayListener.get(str);
                        }
                        if (!(weakReference == null || (iTXLivePlayListener = (ITXLivePlayListener) weakReference.get()) == null)) {
                            iTXLivePlayListener.onPlayEvent(i2, bundle);
                        }
                    }
                } else if (WXTRTCCloud.this.mPushListener != null) {
                    ITXLivePushListener iTXLivePushListener = (ITXLivePushListener) WXTRTCCloud.this.mPushListener.get();
                    if (iTXLivePushListener != null) {
                        iTXLivePushListener.onPushEvent(i2, bundle);
                    }
                    AppMethodBeat.o(14300);
                    return;
                }
                AppMethodBeat.o(14300);
            }
        });
        AppMethodBeat.o(14339);
    }

    public void notifyStatistics(final TRTCStatistics tRTCStatistics) {
        AppMethodBeat.i(14340);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.trtc.WXTRTCCloud.AnonymousClass2 */

            public final void run() {
                int i2;
                ITXLivePlayListener iTXLivePlayListener;
                ITXLivePushListener iTXLivePushListener;
                AppMethodBeat.i(14303);
                String format = String.format("%d%%|%d%%", Integer.valueOf(tRTCStatistics.appCpu), Integer.valueOf(tRTCStatistics.systemCpu));
                String b2 = TXCStatus.b("18446744073709551615", 10001);
                Iterator<TRTCStatistics.TRTCLocalStatistics> it = tRTCStatistics.localArray.iterator();
                while (it.hasNext()) {
                    TRTCStatistics.TRTCLocalStatistics next = it.next();
                    if (next.streamType == 0) {
                        int i3 = next.width;
                        int i4 = next.height;
                        int i5 = next.frameRate;
                        int i6 = next.videoBitrate;
                        int i7 = next.audioBitrate;
                        int i8 = i7 + i6;
                        int access$4400 = WXTRTCCloud.access$4400(WXTRTCCloud.this, tRTCStatistics.rtt, tRTCStatistics.upLoss);
                        int i9 = 0;
                        if (WXTRTCCloud.this.mAppScene == 1) {
                            i9 = TXCStatus.c("18446744073709551615", WearableStatusCodes.DUPLICATE_CAPABILITY);
                            if (i5 > 0) {
                                i9 = (int) (((double) (((float) ((i9 * 10) / i5)) / 10.0f)) + 0.5d);
                            }
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString(TXLiveConstants.NET_STATUS_CPU_USAGE, format);
                        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_WIDTH, i3);
                        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_HEIGHT, i4);
                        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_FPS, i5);
                        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_GOP, i9);
                        bundle.putInt(TXLiveConstants.NET_STATUS_NET_SPEED, i8);
                        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_BITRATE, i6);
                        bundle.putInt(TXLiveConstants.NET_STATUS_AUDIO_BITRATE, i7);
                        bundle.putString(TXLiveConstants.NET_STATUS_AUDIO_INFO, "");
                        bundle.putString(TXLiveConstants.NET_STATUS_SERVER_IP, b2);
                        bundle.putInt(TXLiveConstants.NET_STATUS_QUALITY_LEVEL, access$4400);
                        if (!(WXTRTCCloud.this.mPushListener == null || (iTXLivePushListener = (ITXLivePushListener) WXTRTCCloud.this.mPushListener.get()) == null)) {
                            iTXLivePushListener.onNetStatus(bundle);
                        }
                    }
                }
                Iterator<TRTCStatistics.TRTCRemoteStatistics> it2 = tRTCStatistics.remoteArray.iterator();
                while (it2.hasNext()) {
                    TRTCStatistics.TRTCRemoteStatistics next2 = it2.next();
                    int i10 = next2.streamType;
                    String str = next2.userId;
                    int i11 = next2.width;
                    int i12 = next2.height;
                    int i13 = next2.frameRate;
                    int i14 = next2.videoBitrate;
                    int i15 = next2.audioBitrate;
                    int i16 = i15 + i14;
                    int i17 = 0;
                    int i18 = 0;
                    int i19 = 0;
                    int access$4600 = WXTRTCCloud.access$4600(WXTRTCCloud.this, tRTCStatistics.rtt, next2.finalLoss);
                    TRTCRoomInfo.UserInfo user = WXTRTCCloud.this.mRoomInfo.getUser(str);
                    if (user != null) {
                        int i20 = 2;
                        switch (i10) {
                            case 0:
                                i20 = 2;
                                break;
                            case 1:
                                i20 = 3;
                                break;
                            case 2:
                                i20 = 7;
                                break;
                        }
                        i17 = TXCStatus.c(user.userID, 2007);
                        i18 = TXCStatus.c(user.userID, 6010, i20);
                        int c2 = TXCStatus.c(user.userID, 6011, i20);
                        i19 = TXCStatus.c(user.userID, 6012, i20);
                        i2 = c2;
                    } else {
                        i2 = 0;
                    }
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(TXLiveConstants.NET_STATUS_CPU_USAGE, format);
                    bundle2.putInt(TXLiveConstants.NET_STATUS_VIDEO_WIDTH, i11);
                    bundle2.putInt(TXLiveConstants.NET_STATUS_VIDEO_HEIGHT, i12);
                    bundle2.putInt(TXLiveConstants.NET_STATUS_VIDEO_FPS, i13);
                    bundle2.putInt(TXLiveConstants.NET_STATUS_NET_SPEED, i16);
                    bundle2.putInt(TXLiveConstants.NET_STATUS_VIDEO_BITRATE, i14);
                    bundle2.putInt(TXLiveConstants.NET_STATUS_AUDIO_BITRATE, i15);
                    bundle2.putInt(TXLiveConstants.NET_STATUS_AUDIO_CACHE, i17);
                    bundle2.putInt(TXLiveConstants.NET_STATUS_VIDEO_CACHE, i18);
                    bundle2.putInt(TXLiveConstants.NET_STATUS_V_SUM_CACHE_SIZE, i2);
                    bundle2.putInt(TXLiveConstants.NET_STATUS_V_DEC_CACHE_SIZE, i19);
                    bundle2.putString(TXLiveConstants.NET_STATUS_AUDIO_INFO, "");
                    bundle2.putString(TXLiveConstants.NET_STATUS_SERVER_IP, b2);
                    bundle2.putInt(TXLiveConstants.NET_STATUS_QUALITY_LEVEL, access$4600);
                    WeakReference weakReference = null;
                    if (i10 == 2) {
                        if (WXTRTCCloud.this.mMapSubStreamPlayListener.keySet().contains(str)) {
                            weakReference = (WeakReference) WXTRTCCloud.this.mMapSubStreamPlayListener.get(str);
                        }
                    } else if (WXTRTCCloud.this.mMapMainStreamPlayListener.keySet().contains(str)) {
                        weakReference = (WeakReference) WXTRTCCloud.this.mMapMainStreamPlayListener.get(str);
                    }
                    if (!(weakReference == null || (iTXLivePlayListener = (ITXLivePlayListener) weakReference.get()) == null)) {
                        iTXLivePlayListener.onNetStatus(bundle2);
                    }
                }
                AppMethodBeat.o(14303);
            }
        });
        AppMethodBeat.o(14340);
    }

    @Override // com.tencent.liteav.trtc.impl.TRTCCloudImpl
    public void checkDashBoard() {
        AppMethodBeat.i(14341);
        final TXCloudVideoView tXCloudVideoView = this.mRoomInfo.localView;
        if (tXCloudVideoView != null) {
            final CharSequence uploadStreamInfo = getUploadStreamInfo();
            TXCLog.i(TAG, "[STATUS]" + uploadStreamInfo.toString().replace("\n", ""));
            runOnMainThread(new Runnable() {
                /* class com.tencent.trtc.WXTRTCCloud.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(14287);
                    tXCloudVideoView.setDashBoardStatusInfo(uploadStreamInfo);
                    AppMethodBeat.o(14287);
                }
            });
        }
        this.mRoomInfo.forEachUser(new TRTCRoomInfo.UserAction() {
            /* class com.tencent.trtc.WXTRTCCloud.AnonymousClass5 */

            @Override // com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserAction
            public final void accept(String str, TRTCRoomInfo.UserInfo userInfo) {
                AppMethodBeat.i(182435);
                if (userInfo.mainRender.render != null && userInfo.mainRender.render.isRendering()) {
                    userInfo.mainRender.render.updateLoadInfo();
                }
                if (userInfo.subRender.render != null && userInfo.subRender.render.isRendering()) {
                    userInfo.subRender.render.updateLoadInfo();
                }
                WXTRTCCloud.access$4800(WXTRTCCloud.this, userInfo.mainRender.view, userInfo.mainRender.render, userInfo);
                WXTRTCCloud.access$4900(WXTRTCCloud.this, userInfo.subRender.view, userInfo.subRender.render, userInfo);
                AppMethodBeat.o(182435);
            }
        });
        AppMethodBeat.o(14341);
    }

    public void notifySEIMessage(final String str, final byte[] bArr) {
        AppMethodBeat.i(14342);
        runOnSDKThread(new Runnable() {
            /* class com.tencent.trtc.WXTRTCCloud.AnonymousClass6 */

            public final void run() {
                ITXLivePlayListener iTXLivePlayListener;
                AppMethodBeat.i(14290);
                if (bArr != null && bArr.length > 0) {
                    WeakReference weakReference = null;
                    if (WXTRTCCloud.this.mMapMainStreamPlayListener.keySet().contains(str)) {
                        weakReference = (WeakReference) WXTRTCCloud.this.mMapMainStreamPlayListener.get(str);
                    } else if (WXTRTCCloud.this.mMapSubStreamPlayListener.keySet().contains(str)) {
                        weakReference = (WeakReference) WXTRTCCloud.this.mMapSubStreamPlayListener.get(str);
                    }
                    if (!(weakReference == null || (iTXLivePlayListener = (ITXLivePlayListener) weakReference.get()) == null)) {
                        Bundle bundle = new Bundle();
                        bundle.putByteArray(TXLiveConstants.EVT_GET_MSG, bArr);
                        iTXLivePlayListener.onPlayEvent(2012, bundle);
                    }
                }
                AppMethodBeat.o(14290);
            }
        });
        AppMethodBeat.o(14342);
    }
}
