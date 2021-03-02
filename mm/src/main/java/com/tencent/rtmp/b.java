package com.tencent.rtmp;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaFormat;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.gms.gcm.Task;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.liteav.audio.TXAudioEffectManager;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.audio.TXCLiveBGMPlayer;
import com.tencent.liteav.audio.e;
import com.tencent.liteav.audio.f;
import com.tencent.liteav.audio.impl.TXCAudioEngineJNI;
import com.tencent.liteav.basic.c.o;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.license.LicenceCheck;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.d;
import com.tencent.liteav.g;
import com.tencent.liteav.m;
import com.tencent.liteav.muxer.c;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.liteav.network.h;
import com.tencent.liteav.qos.TXCQoS;
import com.tencent.liteav.screencapture.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.smtt.sdk.TbsMediaPlayer;
import com.tencent.ugc.TXRecordCommon;
import java.io.File;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;

public class b implements e, com.tencent.liteav.basic.b.b, d.a, m, com.tencent.liteav.qos.a {

    /* renamed from: d  reason: collision with root package name */
    private static final String f1600d = b.class.getSimpleName();
    private ArrayList<C2183b> A;
    private TXLivePusher.ITXAudioVolumeEvaluationListener B;
    private int C;
    private com.tencent.liteav.basic.b.a D;
    private f E;
    private a F;
    private Runnable G;
    private c H;
    private boolean I;
    private String J;
    private long K;
    private boolean L;
    private TXRecordCommon.ITXVideoRecordListener M;
    private boolean N;

    /* renamed from: a  reason: collision with root package name */
    TXLivePusher.OnBGMNotify f1601a;

    /* renamed from: b  reason: collision with root package name */
    final TXAudioEffectManager.TXVoiceReverbType[] f1602b;

    /* renamed from: c  reason: collision with root package name */
    final TXAudioEffectManager.TXVoiceChangerType[] f1603c;

    /* renamed from: e  reason: collision with root package name */
    private TXCloudVideoView f1604e;

    /* renamed from: f  reason: collision with root package name */
    private TXLivePushConfig f1605f;

    /* renamed from: g  reason: collision with root package name */
    private ITXLivePushListener f1606g;

    /* renamed from: h  reason: collision with root package name */
    private int f1607h;

    /* renamed from: i  reason: collision with root package name */
    private TXLivePusher.VideoCustomProcessListener f1608i;

    /* renamed from: j  reason: collision with root package name */
    private TXLivePusher.AudioCustomProcessListener f1609j;
    private g k;
    private d l;
    private TXCStreamUploader m;
    private Context n;
    private Handler o;
    private TXCQoS p;
    private com.tencent.liteav.e q;
    private String r;
    private String s;
    private boolean t;
    private int u;
    private int v;
    private boolean w;
    private boolean x;
    private HashSet<String> y;
    private HashMap<Integer, Long> z;

    static /* synthetic */ void a(b bVar, TXLivePusher.ITXSnapshotListener iTXSnapshotListener, Bitmap bitmap) {
        AppMethodBeat.i(14222);
        bVar.a(iTXSnapshotListener, bitmap);
        AppMethodBeat.o(14222);
    }

    static /* synthetic */ void a(b bVar, String str, String str2) {
        AppMethodBeat.i(14221);
        bVar.a(str, str2);
        AppMethodBeat.o(14221);
    }

    static /* synthetic */ void i(b bVar) {
        AppMethodBeat.i(222681);
        bVar.F();
        AppMethodBeat.o(222681);
    }

    static {
        AppMethodBeat.i(14224);
        AppMethodBeat.o(14224);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.rtmp.b$b  reason: collision with other inner class name */
    public class C2183b {

        /* renamed from: a  reason: collision with root package name */
        long f1636a;

        /* renamed from: b  reason: collision with root package name */
        byte[] f1637b;

        private C2183b() {
        }
    }

    public b(Context context) {
        boolean z2 = false;
        AppMethodBeat.i(14124);
        this.f1605f = null;
        this.f1606g = null;
        this.f1607h = -1;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = "";
        this.s = "";
        this.t = false;
        this.u = -1;
        this.v = -1;
        this.w = false;
        this.x = false;
        this.y = new HashSet<>();
        this.z = new HashMap<>();
        this.f1602b = new TXAudioEffectManager.TXVoiceReverbType[]{TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_0, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_1, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_2, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_3, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_4, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_5, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_6, TXAudioEffectManager.TXVoiceReverbType.TXLiveVoiceReverbType_7};
        this.f1603c = new TXAudioEffectManager.TXVoiceChangerType[]{TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_0, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_1, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_2, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_3, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_4, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_5, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_6, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_7, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_8, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_9, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_10, TXAudioEffectManager.TXVoiceChangerType.TXLiveVoiceChangerType_11};
        this.A = new ArrayList<>();
        this.B = null;
        this.C = 0;
        this.D = new com.tencent.liteav.basic.b.a() {
            /* class com.tencent.rtmp.b.AnonymousClass1 */

            @Override // com.tencent.liteav.basic.b.a
            public void onEvent(String str, int i2, String str2, String str3) {
                AppMethodBeat.i(222682);
                TXCLog.i(b.f1600d, "onEvent => id:" + str + " code:" + i2 + " msg:" + str2 + " params:" + str3);
                if (b.this.f1606g != null) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("EVT_ID", i2);
                    bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                    if (str2 != null) {
                        StringBuilder append = new StringBuilder().append(str2);
                        if (str3 == null) {
                            str3 = "";
                        }
                        bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, append.append(str3).toString());
                    }
                    b.this.onNotifyEvent(i2, bundle);
                }
                AppMethodBeat.o(222682);
            }

            @Override // com.tencent.liteav.basic.b.a
            public void onError(String str, int i2, String str2, String str3) {
                AppMethodBeat.i(222683);
                TXCLog.e(b.f1600d, "onError => id:" + str + " code:" + i2 + " msg:" + str2 + " params:" + str3);
                if (b.this.f1606g != null) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("EVT_ID", i2);
                    bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                    if (str2 != null) {
                        StringBuilder append = new StringBuilder().append(str2);
                        if (str3 == null) {
                            str3 = "";
                        }
                        bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, append.append(str3).toString());
                    }
                    b.this.onNotifyEvent(i2, bundle);
                }
                AppMethodBeat.o(222683);
            }
        };
        this.E = new f() {
            /* class com.tencent.rtmp.b.AnonymousClass6 */

            @Override // com.tencent.liteav.audio.f
            public void onPlayStart() {
                AppMethodBeat.i(222665);
                if (b.this.f1601a != null) {
                    b.this.f1601a.onBGMStart();
                }
                AppMethodBeat.o(222665);
            }

            @Override // com.tencent.liteav.audio.f
            public void onPlayEnd(int i2) {
                AppMethodBeat.i(222666);
                if (b.this.f1601a != null) {
                    b.this.f1601a.onBGMComplete(i2);
                }
                AppMethodBeat.o(222666);
            }

            @Override // com.tencent.liteav.audio.f
            public void onPlayProgress(long j2, long j3) {
                AppMethodBeat.i(222667);
                if (b.this.f1601a != null) {
                    b.this.f1601a.onBGMProgress(j2, j3);
                }
                AppMethodBeat.o(222667);
            }
        };
        this.F = null;
        this.G = new Runnable() {
            /* class com.tencent.rtmp.b.AnonymousClass7 */

            public void run() {
                AppMethodBeat.i(222655);
                b.this.t = false;
                AppMethodBeat.o(222655);
            }
        };
        this.H = null;
        this.I = false;
        this.J = "";
        this.K = 0;
        this.L = false;
        this.N = false;
        this.f1605f = new TXLivePushConfig();
        this.k = new g();
        this.n = context.getApplicationContext();
        TXCCommonUtil.setAppContext(this.n);
        TXCLog.init();
        this.o = new Handler(Looper.getMainLooper());
        com.tencent.liteav.basic.d.c.a().a(this.n);
        TXCAudioEngine.CreateInstance(this.n, R());
        TXCAudioEngine.getInstance().clean();
        TXCAudioEngine.getInstance().addEventCallback(new WeakReference<>(this.D));
        long a2 = com.tencent.liteav.basic.d.c.a().a("Audio", "EnableAutoRestartDevice");
        TXCAudioEngine.getInstance().enableAutoRestartDevice((a2 == 1 || a2 == -1) ? true : z2);
        this.l = new d(this.n);
        this.l.d(true);
        this.l.a((com.tencent.liteav.basic.b.b) this);
        LicenceCheck.a().a((com.tencent.liteav.basic.license.f) null, this.n);
        TXCTimeUtil.initAppStartTime();
        this.z.put(-1303, 0L);
        this.z.put(1101, 0L);
        this.z.put(1006, 0L);
        AppMethodBeat.o(14124);
    }

    public void a(TXLivePushConfig tXLivePushConfig) {
        AppMethodBeat.i(14125);
        TXCLog.i(f1600d, "liteav_api setConfig " + (tXLivePushConfig != null ? tXLivePushConfig.toString() : BuildConfig.COMMAND) + " ,  pusher:" + this);
        if (tXLivePushConfig == null) {
            tXLivePushConfig = new TXLivePushConfig();
        }
        this.f1605f = tXLivePushConfig;
        b(tXLivePushConfig);
        Q();
        Monitor.a(1, "setConfig", tXLivePushConfig != null ? tXLivePushConfig.toString() : BuildConfig.COMMAND, 0);
        AppMethodBeat.o(14125);
    }

    public TXLivePushConfig i() {
        return this.f1605f;
    }

    public void a(ITXLivePushListener iTXLivePushListener) {
        AppMethodBeat.i(14126);
        TXCLog.i(f1600d, "liteav_api setPushListener ".concat(String.valueOf(iTXLivePushListener)));
        this.f1606g = iTXLivePushListener;
        AppMethodBeat.o(14126);
    }

    public void a(TXCloudVideoView tXCloudVideoView) {
        AppMethodBeat.i(14127);
        TXCLog.i(f1600d, "liteav_api startCameraPreview " + tXCloudVideoView + ", " + this);
        Monitor.a(1, "startCameraPreview [view:" + (tXCloudVideoView != null ? tXCloudVideoView.hashCode() : 0) + "]", "", 0);
        a(this.f1605f);
        if (this.k.M) {
            TXCLog.e(f1600d, "enable pure audio push , so can not start preview!");
            AppMethodBeat.o(14127);
            return;
        }
        if (!(this.f1604e == tXCloudVideoView || this.f1604e == null)) {
            this.f1604e.removeVideoView();
        }
        this.f1604e = tXCloudVideoView;
        if (this.l == null) {
            this.l = new d(this.n);
        }
        this.l.a((com.tencent.liteav.basic.b.b) this);
        this.l.a((d.a) this);
        this.l.a(tXCloudVideoView);
        this.l.b(this.f1605f.mBeautyLevel, this.f1605f.mWhiteningLevel, this.f1605f.mRuddyLevel);
        LicenceCheck.a().a((com.tencent.liteav.basic.license.f) null, this.n);
        AppMethodBeat.o(14127);
    }

    public void b(boolean z2) {
        AppMethodBeat.i(14128);
        TXCLog.i(f1600d, "liteav_api stopCameraPreview " + z2 + ", " + this);
        Monitor.a(1, "stopCameraPreview", "", 0);
        if (this.l == null) {
            AppMethodBeat.o(14128);
            return;
        }
        this.l.c(z2);
        AppMethodBeat.o(14128);
    }

    public int a(String str) {
        AppMethodBeat.i(14129);
        TXCLog.i(f1600d, "liteav_api startPusher ".concat(String.valueOf(this)));
        if (TextUtils.isEmpty(str)) {
            TXCLog.e(f1600d, "start push error when url is empty ".concat(String.valueOf(this)));
            AppMethodBeat.o(14129);
            return -1;
        }
        if (!TextUtils.isEmpty(this.r) && m()) {
            if (this.r.equalsIgnoreCase(str)) {
                TXCLog.w(f1600d, "ignore start push when new url is the same with old url  ".concat(String.valueOf(this)));
                AppMethodBeat.o(14129);
                return -1;
            }
            TXCLog.w(f1600d, " stop old push when new url is not the same with old url  ".concat(String.valueOf(this)));
            j();
        }
        TXCLog.i(f1600d, "liteav_api ================================================================================================================================================");
        TXCLog.i(f1600d, "liteav_api ================================================================================================================================================");
        TXCLog.i(f1600d, "liteav_api ============= startPush pushUrl = " + str + " SDKVersion = " + TXCCommonUtil.getSDKID() + " , " + TXCCommonUtil.getSDKVersionStr() + "=============");
        TXCLog.i(f1600d, "liteav_api ================================================================================================================================================");
        TXCLog.i(f1600d, "liteav_api ================================================================================================================================================");
        this.r = str;
        k(this.r);
        G();
        M();
        O();
        I();
        K();
        f(str);
        Monitor.a(1, "startPush(" + hashCode() + ")", "url:" + str + " sdk:" + TXCCommonUtil.getSDKID(), 0);
        C();
        if (this.f1604e != null) {
            this.f1604e.clearLog();
        }
        if (j(this.r)) {
            this.l.b(true);
        }
        y();
        AppMethodBeat.o(14129);
        return 0;
    }

    private void f(String str) {
        AppMethodBeat.i(14177);
        if (str == null) {
            AppMethodBeat.o(14177);
            return;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("rtmp://")) {
            h(lowerCase);
            AppMethodBeat.o(14177);
        } else if (lowerCase.startsWith("room://cloud.tencent.com")) {
            g(lowerCase);
            AppMethodBeat.o(14177);
        } else {
            TXCLog.i(f1600d, "initMonitor： init default monitor.");
            Monitor.a(lowerCase, 0, "");
            AppMethodBeat.o(14177);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g(java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 176
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.rtmp.b.g(java.lang.String):void");
    }

    private void h(String str) {
        AppMethodBeat.i(14201);
        String i2 = i(str);
        if (!TextUtils.isEmpty(i2)) {
            str = i2;
        }
        TXCLog.i(f1600d, "initMonitorByStreamId: streamId: ".concat(String.valueOf(str)));
        Monitor.a(str, 0, "");
        AppMethodBeat.o(14201);
    }

    private String i(String str) {
        String str2 = null;
        AppMethodBeat.i(259980);
        try {
            int lastIndexOf = str.lastIndexOf(FilePathGenerator.ANDROID_DIR_SEP);
            int indexOf = str.indexOf("?");
            if (lastIndexOf == -1) {
                TXCLog.e(f1600d, "parseStreamId: un find slash line.");
                AppMethodBeat.o(259980);
            } else {
                if (indexOf != -1) {
                    str2 = str.substring(lastIndexOf + 1, indexOf);
                } else {
                    str2 = str.substring(lastIndexOf + 1);
                }
                AppMethodBeat.o(259980);
            }
        } catch (Exception e2) {
            TXCLog.e(f1600d, "parseStreamId: catch exception.", e2);
            AppMethodBeat.o(259980);
        }
        return str2;
    }

    public void j() {
        AppMethodBeat.i(14130);
        TXCLog.i(f1600d, "liteav_api stopPusher ".concat(String.valueOf(this)));
        Monitor.a(1, "stopPush(" + hashCode() + ")", "", 0);
        w();
        D();
        L();
        J();
        N();
        t();
        P();
        TXCAudioEngine.getInstance();
        TXCAudioEngine.enableAudioEarMonitoring(false);
        this.x = false;
        this.k.P = false;
        H();
        this.r = "";
        this.y.clear();
        Monitor.a();
        this.l.b(false);
        z();
        TXCAudioEngine.getInstance().clean();
        TXCAudioEngine.getInstance().UnInitAudioDevice();
        AppMethodBeat.o(14130);
    }

    private boolean j(String str) {
        AppMethodBeat.i(259981);
        try {
            String[] split = str.split("[?&]");
            for (String str2 : split) {
                if (str2.indexOf("=") != -1) {
                    String[] split2 = str2.split("[=]");
                    if (split2.length == 2) {
                        String str3 = split2[0];
                        String str4 = split2[1];
                        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && str3.equalsIgnoreCase("enableblackstream")) {
                            if (Integer.parseInt(str4) == 1) {
                                AppMethodBeat.o(259981);
                                return true;
                            }
                            AppMethodBeat.o(259981);
                            return false;
                        }
                    } else {
                        continue;
                    }
                }
            }
        } catch (Exception e2) {
            TXCLog.w(f1600d, "parse black stream flag error " + e2.toString());
        }
        AppMethodBeat.o(259981);
        return false;
    }

    public void k() {
        AppMethodBeat.i(14132);
        TXCLog.i(f1600d, "liteav_api pausePusher ".concat(String.valueOf(this)));
        Monitor.a(1, "pausePush", "", 0);
        if (this.l != null) {
            this.l.g();
        }
        TXCLog.i(f1600d, "mPauseFlag:" + this.f1605f.mPauseFlag);
        if ((this.f1605f.mPauseFlag & 2) == 2) {
            TXCAudioEngine.getInstance().pauseAudioCapture(true);
        }
        AppMethodBeat.o(14132);
    }

    public void l() {
        AppMethodBeat.i(14133);
        TXCLog.i(f1600d, "liteav_api resumePusher ".concat(String.valueOf(this)));
        Monitor.a(1, "resumePush", "", 0);
        if (this.l != null) {
            this.l.h();
        }
        TXCAudioEngine.getInstance().resumeAudioCapture();
        AppMethodBeat.o(14133);
    }

    public boolean m() {
        AppMethodBeat.i(14134);
        if (this.l != null) {
            boolean j2 = this.l.j();
            AppMethodBeat.o(14134);
            return j2;
        }
        AppMethodBeat.o(14134);
        return false;
    }

    public void a(Surface surface) {
        AppMethodBeat.i(14135);
        TXCLog.i(f1600d, "liteav_api setSurface ".concat(String.valueOf(surface)));
        if (this.l == null) {
            AppMethodBeat.o(14135);
            return;
        }
        this.l.a(surface);
        AppMethodBeat.o(14135);
    }

    public void a(int i2, int i3) {
        AppMethodBeat.i(14136);
        TXCLog.i(f1600d, "liteav_api setSurfaceSize " + i2 + "," + i3);
        if (this.l == null) {
            AppMethodBeat.o(14136);
            return;
        }
        this.l.a(i2, i3);
        AppMethodBeat.o(14136);
    }

    public void a(float f2, float f3) {
        AppMethodBeat.i(14137);
        if (this.l != null) {
            this.l.a(f2, f3);
        }
        AppMethodBeat.o(14137);
    }

    public void n() {
        AppMethodBeat.i(14138);
        TXCLog.i(f1600d, "liteav_api startScreenCapture ");
        Monitor.a(1, "startScreenCapture", "", 0);
        if (this.l == null) {
            AppMethodBeat.o(14138);
            return;
        }
        this.l.a((a.AbstractC0160a) null);
        AppMethodBeat.o(14138);
    }

    public void o() {
        AppMethodBeat.i(14139);
        TXCLog.i(f1600d, "liteav_api stopScreenCapture ");
        Monitor.a(1, "stopScreenCapture", "", 0);
        if (this.l == null) {
            AppMethodBeat.o(14139);
            return;
        }
        this.l.l();
        AppMethodBeat.o(14139);
    }

    public void a(int i2, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6 = false;
        int i3 = 1;
        AppMethodBeat.i(14140);
        TXCLog.i(f1600d, "liteav_api setVideoQuality " + i2 + ", " + z2 + ", " + z3);
        Monitor.a(1, "setVideoQuality", "quality:" + i2 + " adjustBitrate:" + z2 + " adjustResolution:" + z2, 0);
        if (Build.VERSION.SDK_INT < 18 && (i2 == 2 || i2 == 3)) {
            i2 = 1;
        }
        if (this.f1605f == null) {
            this.f1605f = new TXLivePushConfig();
        }
        this.f1605f.setVideoFPS(18);
        boolean z7 = z3 && z2;
        switch (i2) {
            case 1:
                this.f1605f.enableAEC(false);
                this.f1605f.setHardwareAcceleration(2);
                this.f1605f.setVideoResolution(0);
                this.f1605f.setAudioSampleRate(48000);
                a(z2, z3);
                if (z7) {
                    this.f1605f.setMinVideoBitrate(301);
                    this.f1605f.setVideoBitrate(800);
                    this.f1605f.setMaxVideoBitrate(TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR);
                } else {
                    this.f1605f.setMinVideoBitrate(500);
                    this.f1605f.setVideoBitrate(800);
                    this.f1605f.setMaxVideoBitrate(TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR);
                }
                z4 = false;
                z5 = false;
                break;
            case 2:
                this.f1605f.enableAEC(false);
                this.f1605f.setHardwareAcceleration(2);
                this.f1605f.setVideoResolution(1);
                this.f1605f.setAudioSampleRate(48000);
                a(z2, z3);
                if (z7) {
                    this.f1605f.setMinVideoBitrate(600);
                    this.f1605f.setVideoBitrate(1200);
                    this.f1605f.setMaxVideoBitrate(1500);
                } else {
                    this.f1605f.setMinVideoBitrate(800);
                    this.f1605f.setVideoBitrate(1200);
                    this.f1605f.setMaxVideoBitrate(1500);
                }
                z4 = false;
                z5 = false;
                break;
            case 3:
                this.f1605f.enableAEC(false);
                this.f1605f.setHardwareAcceleration(1);
                this.f1605f.setVideoResolution(2);
                this.f1605f.setAudioSampleRate(48000);
                a(z2, z3);
                if (z7) {
                    this.f1605f.setMinVideoBitrate(600);
                    this.f1605f.setVideoBitrate(1800);
                    this.f1605f.setMaxVideoBitrate(1800);
                } else {
                    this.f1605f.setMinVideoBitrate(1000);
                    this.f1605f.setVideoBitrate(1800);
                    this.f1605f.setMaxVideoBitrate(1800);
                }
                z4 = false;
                z5 = false;
                break;
            case 4:
                if (Build.VERSION.SDK_INT < 18) {
                    this.f1605f.enableAEC(true);
                    this.f1605f.setHardwareAcceleration(0);
                    this.f1605f.setVideoResolution(0);
                    this.f1605f.setAutoAdjustBitrate(true);
                    this.f1605f.setAutoAdjustStrategy(4);
                    this.f1605f.setMinVideoBitrate(500);
                    this.f1605f.setVideoBitrate(800);
                    this.f1605f.setMaxVideoBitrate(TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR);
                } else if (this.f1607h == 1) {
                    this.f1605f.enableAEC(true);
                    this.f1605f.setHardwareAcceleration(1);
                    this.f1605f.setVideoResolution(0);
                    this.f1605f.setAutoAdjustBitrate(true);
                    this.f1605f.setAutoAdjustStrategy(4);
                    this.f1605f.setMinVideoBitrate(500);
                    this.f1605f.setVideoBitrate(800);
                    this.f1605f.setMaxVideoBitrate(TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR);
                } else if (this.f1607h == 3) {
                    this.f1605f.enableAEC(true);
                    this.f1605f.setHardwareAcceleration(1);
                    this.f1605f.setVideoResolution(2);
                    this.f1605f.setAutoAdjustBitrate(true);
                    this.f1605f.setAutoAdjustStrategy(4);
                    this.f1605f.setMinVideoBitrate(1000);
                    this.f1605f.setVideoBitrate(1800);
                    this.f1605f.setMaxVideoBitrate(1800);
                } else if (this.f1607h == 7) {
                    this.f1605f.enableAEC(true);
                    this.f1605f.setHardwareAcceleration(1);
                    this.f1605f.setVideoResolution(30);
                    this.f1605f.setAutoAdjustBitrate(true);
                    this.f1605f.setAutoAdjustStrategy(4);
                    this.f1605f.setMinVideoBitrate(2000);
                    this.f1605f.setVideoBitrate(3000);
                    this.f1605f.setMaxVideoBitrate(3000);
                } else {
                    this.f1605f.enableAEC(true);
                    this.f1605f.setHardwareAcceleration(1);
                    this.f1605f.setVideoResolution(1);
                    this.f1605f.setAutoAdjustBitrate(true);
                    this.f1605f.setAutoAdjustStrategy(4);
                    this.f1605f.setMinVideoBitrate(800);
                    this.f1605f.setVideoBitrate(1200);
                    this.f1605f.setMaxVideoBitrate(1500);
                }
                this.f1605f.setAudioSampleRate(48000);
                z4 = false;
                z5 = true;
                break;
            case 5:
                this.f1605f.enableAEC(true);
                this.f1605f.setHardwareAcceleration(1);
                this.f1605f.setVideoResolution(6);
                this.f1605f.setAutoAdjustBitrate(false);
                this.f1605f.setVideoBitrate(350);
                this.f1605f.setAudioSampleRate(48000);
                z4 = false;
                z5 = true;
                break;
            case 6:
                this.f1605f.enableAEC(true);
                this.f1605f.setHardwareAcceleration(1);
                this.f1605f.setVideoResolution(0);
                this.f1605f.setAudioSampleRate(48000);
                this.f1605f.setAutoAdjustBitrate(true);
                this.f1605f.setAutoAdjustStrategy(5);
                this.f1605f.setMinVideoBitrate(FacebookRequestErrorClassification.EC_INVALID_TOKEN);
                this.f1605f.setVideoBitrate(400);
                this.f1605f.setMaxVideoBitrate(810);
                z4 = true;
                z5 = true;
                break;
            case 7:
                this.f1605f.enableAEC(false);
                this.f1605f.setHardwareAcceleration(1);
                this.f1605f.setVideoResolution(30);
                this.f1605f.setAudioSampleRate(48000);
                a(z2, false);
                this.f1605f.setMinVideoBitrate(2500);
                this.f1605f.setVideoBitrate(3000);
                this.f1605f.setMaxVideoBitrate(3000);
                z4 = false;
                z5 = false;
                break;
            default:
                this.f1605f.setHardwareAcceleration(2);
                TXCLog.e(f1600d, "setVideoPushQuality: invalid quality ".concat(String.valueOf(i2)));
                AppMethodBeat.o(14140);
                return;
        }
        this.f1607h = i2;
        TXLivePushConfig tXLivePushConfig = this.f1605f;
        if (!z5) {
            z6 = true;
        }
        tXLivePushConfig.enableVideoHardEncoderMainProfile(z6);
        TXLivePushConfig tXLivePushConfig2 = this.f1605f;
        if (!z5) {
            i3 = 3;
        }
        tXLivePushConfig2.setVideoEncodeGop(i3);
        if (this.k != null) {
            this.k.P = z5;
            this.k.Q = z4;
        }
        a(this.f1605f);
        AppMethodBeat.o(14140);
    }

    public void p() {
        AppMethodBeat.i(14141);
        TXCLog.i(f1600d, "liteav_api switchCamera ");
        Monitor.a(1, "switchCamera", "", 0);
        if (this.l == null) {
            AppMethodBeat.o(14141);
            return;
        }
        this.l.k();
        AppMethodBeat.o(14141);
    }

    public boolean c(boolean z2) {
        AppMethodBeat.i(14142);
        TXCLog.i(f1600d, "liteav_api setMirror ".concat(String.valueOf(z2)));
        if (this.f1605f != null) {
            this.f1605f.setVideoEncoderXMirror(z2);
        }
        if (this.l == null) {
            AppMethodBeat.o(14142);
            return false;
        }
        this.l.f(z2);
        AppMethodBeat.o(14142);
        return true;
    }

    public void a(int i2) {
        AppMethodBeat.i(14143);
        TXCLog.i(f1600d, "liteav_api setRenderRotation ");
        if (this.l == null) {
            AppMethodBeat.o(14143);
            return;
        }
        this.l.g(i2);
        AppMethodBeat.o(14143);
    }

    public boolean d(boolean z2) {
        AppMethodBeat.i(14144);
        TXCLog.i(f1600d, "liteav_api turnOnFlashLight ".concat(String.valueOf(z2)));
        if (this.l == null) {
            AppMethodBeat.o(14144);
            return false;
        }
        boolean e2 = this.l.e(z2);
        AppMethodBeat.o(14144);
        return e2;
    }

    public int q() {
        AppMethodBeat.i(14145);
        if (this.l == null) {
            AppMethodBeat.o(14145);
            return 0;
        }
        int q2 = this.l.q();
        AppMethodBeat.o(14145);
        return q2;
    }

    public boolean b(int i2) {
        AppMethodBeat.i(14146);
        TXCLog.i(f1600d, "liteav_api setZoom ".concat(String.valueOf(i2)));
        if (this.l == null) {
            AppMethodBeat.o(14146);
            return false;
        }
        boolean i3 = this.l.i(i2);
        AppMethodBeat.o(14146);
        return i3;
    }

    public void a(float f2) {
        AppMethodBeat.i(14147);
        TXCLog.i(f1600d, "liteav_api setExposureCompensation ".concat(String.valueOf(f2)));
        if (this.l == null) {
            AppMethodBeat.o(14147);
            return;
        }
        this.l.a(f2);
        AppMethodBeat.o(14147);
    }

    public boolean a(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(14148);
        if (this.l != null) {
            this.l.h(i2);
            this.l.b(i3, i4, i5);
        }
        if (this.f1605f != null) {
            this.f1605f.mBeautyLevel = i3;
            this.f1605f.mWhiteningLevel = i4;
            this.f1605f.mRuddyLevel = i5;
        }
        AppMethodBeat.o(14148);
        return true;
    }

    public TXBeautyManager r() {
        AppMethodBeat.i(14151);
        if (this.l == null) {
            this.l = new d(this.n);
        }
        TXBeautyManager b2 = this.l.b();
        AppMethodBeat.o(14151);
        return b2;
    }

    public void e(boolean z2) {
        AppMethodBeat.i(14153);
        TXCLog.i(f1600d, "liteav_api setMute ".concat(String.valueOf(z2)));
        Monitor.a(1, "setMute", "mute:".concat(String.valueOf(z2)), 0);
        this.x = z2;
        TXCAudioEngine.getInstance().muteLocalAudio(z2);
        if (this.f1605f.mEnablePureAudioPush && this.m != null) {
            this.m.setAudioMute(z2);
        }
        AppMethodBeat.o(14153);
    }

    public void a(TXLivePusher.OnBGMNotify onBGMNotify) {
        AppMethodBeat.i(14154);
        TXCLog.i(f1600d, "liteav_api setBGMNofify ".concat(String.valueOf(onBGMNotify)));
        this.f1601a = onBGMNotify;
        if (this.f1601a != null) {
            TXCLiveBGMPlayer.getInstance().setOnPlayListener(this.E);
            AppMethodBeat.o(14154);
            return;
        }
        TXCLiveBGMPlayer.getInstance().setOnPlayListener(null);
        AppMethodBeat.o(14154);
    }

    public boolean b(String str) {
        AppMethodBeat.i(14152);
        TXCLog.i(f1600d, "liteav_api playBGM ".concat(String.valueOf(str)));
        boolean startPlay = TXCLiveBGMPlayer.getInstance().startPlay(str);
        AppMethodBeat.o(14152);
        return startPlay;
    }

    public boolean s() {
        AppMethodBeat.i(14156);
        TXCLog.i(f1600d, "liteav_api stopBGM ");
        boolean stopPlay = TXCLiveBGMPlayer.getInstance().stopPlay();
        AppMethodBeat.o(14156);
        return stopPlay;
    }

    public void t() {
        AppMethodBeat.i(222670);
        TXCLog.i(f1600d, "liteav_api stopAllBGM ");
        TXCLiveBGMPlayer.getInstance().stopAll();
        AppMethodBeat.o(222670);
    }

    public boolean u() {
        AppMethodBeat.i(14158);
        TXCLog.i(f1600d, "liteav_api pauseBGM ");
        boolean pause = TXCLiveBGMPlayer.getInstance().pause();
        AppMethodBeat.o(14158);
        return pause;
    }

    public boolean v() {
        AppMethodBeat.i(222671);
        TXCLog.i(f1600d, "liteav_api resumeBGM ");
        boolean resume = TXCLiveBGMPlayer.getInstance().resume();
        AppMethodBeat.o(222671);
        return resume;
    }

    public int c(String str) {
        AppMethodBeat.i(222672);
        int bGMDuration = TXCLiveBGMPlayer.getInstance().getBGMDuration(str);
        AppMethodBeat.o(222672);
        return bGMDuration;
    }

    public boolean b(float f2) {
        AppMethodBeat.i(222673);
        TXCLog.i(f1600d, "liteav_api setBGMVolume ".concat(String.valueOf(f2)));
        boolean volume = TXCLiveBGMPlayer.getInstance().setVolume(f2);
        AppMethodBeat.o(222673);
        return volume;
    }

    public boolean c(float f2) {
        AppMethodBeat.i(14160);
        TXCLog.i(f1600d, "liteav_api setMicVolume ".concat(String.valueOf(f2)));
        boolean softwareCaptureVolume = TXCAudioEngine.getInstance().setSoftwareCaptureVolume(f2);
        AppMethodBeat.o(14160);
        return softwareCaptureVolume;
    }

    public void d(float f2) {
        AppMethodBeat.i(222674);
        TXCLog.i(f1600d, "liteav_api setBGMPitch ".concat(String.valueOf(f2)));
        TXCLiveBGMPlayer.getInstance().setPitch(f2);
        AppMethodBeat.o(222674);
    }

    public boolean c(int i2) {
        AppMethodBeat.i(14163);
        TXCLiveBGMPlayer.getInstance().setBGMPosition(i2);
        AppMethodBeat.o(14163);
        return true;
    }

    public void d(int i2) {
        AppMethodBeat.i(14164);
        TXCLog.i(f1600d, "liteav_api setReverb ".concat(String.valueOf(i2)));
        if (i2 < 0 || i2 > 7) {
            TXCLog.e(f1600d, "reverbType not support :".concat(String.valueOf(i2)));
            AppMethodBeat.o(14164);
            return;
        }
        TXCAudioEngine.getInstance().setReverbType(this.f1602b[i2]);
        AppMethodBeat.o(14164);
    }

    public void e(int i2) {
        AppMethodBeat.i(14165);
        TXCLog.i(f1600d, "liteav_api setVoiceChangerType ".concat(String.valueOf(i2)));
        if (i2 < 0 || i2 > 11) {
            TXCLog.e(f1600d, "voiceChangerType not support :".concat(String.valueOf(i2)));
            AppMethodBeat.o(14165);
            return;
        }
        TXCAudioEngine.getInstance().setVoiceChangerType(this.f1603c[i2]);
        AppMethodBeat.o(14165);
    }

    public void a(TXLivePusher.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener) {
        this.B = iTXAudioVolumeEvaluationListener;
    }

    public void f(int i2) {
        AppMethodBeat.i(182228);
        TXCLog.i(f1600d, "liteav_api enableAudioVolumeEvaluation intervalMs = ".concat(String.valueOf(i2)));
        Monitor.a(1, "liteav_api enableAudioVolumeEvaluation intervalMs = ".concat(String.valueOf(i2)), "", 0);
        if (i2 > 0) {
            if (i2 < 100) {
                i2 = 100;
            }
            this.C = i2;
            y();
            AppMethodBeat.o(182228);
            return;
        }
        this.C = 0;
        z();
        AppMethodBeat.o(182228);
    }

    private void y() {
        AppMethodBeat.i(14197);
        if (this.C > 0 && m()) {
            TXCAudioEngine.getInstance();
            TXCAudioEngine.enableAudioVolumeEvaluation(true, 300);
            if (this.F == null) {
                this.F = new a();
            }
            this.F.a(this.C);
            if (this.o != null) {
                this.o.removeCallbacks(this.F);
                this.o.postDelayed(this.F, (long) this.C);
            }
        }
        AppMethodBeat.o(14197);
    }

    private void z() {
        AppMethodBeat.i(14202);
        TXCAudioEngine.getInstance();
        TXCAudioEngine.enableAudioVolumeEvaluation(false, 300);
        if (this.F != null) {
            this.F.a(0);
        }
        if (this.o != null) {
            this.o.removeCallbacks(this.F);
        }
        this.F = null;
        this.C = 0;
        AppMethodBeat.o(14202);
    }

    /* access modifiers changed from: package-private */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private int f1635b;

        private a() {
            this.f1635b = 300;
        }

        public void a(int i2) {
            this.f1635b = i2;
        }

        public void run() {
            AppMethodBeat.i(182241);
            if (b.this.m()) {
                int softwareCaptureVolumeLevel = TXCAudioEngine.getInstance().getSoftwareCaptureVolumeLevel();
                if (b.this.B != null) {
                    b.this.B.onAudioVolumeEvaluationNotify(softwareCaptureVolumeLevel);
                }
            }
            if (b.this.o != null && this.f1635b > 0) {
                b.this.o.postDelayed(b.this.F, (long) this.f1635b);
            }
            AppMethodBeat.o(182241);
        }
    }

    public void a(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        AppMethodBeat.i(14166);
        TXCLog.i(f1600d, "liteav_api setVideoRecordListener ".concat(String.valueOf(iTXVideoRecordListener)));
        this.M = iTXVideoRecordListener;
        AppMethodBeat.o(14166);
    }

    public int d(String str) {
        AppMethodBeat.i(14159);
        TXCLog.i(f1600d, "liteav_api startRecord ".concat(String.valueOf(str)));
        if (Build.VERSION.SDK_INT < 18) {
            TXCLog.e(f1600d, "API levl is too low (record need 18, current is" + Build.VERSION.SDK_INT + ")");
            AppMethodBeat.o(14159);
            return -3;
        } else if (this.L) {
            TXCLog.w(f1600d, "ignore start record when recording");
            AppMethodBeat.o(14159);
            return -1;
        } else if (this.l == null || !this.l.j()) {
            TXCLog.w(f1600d, "ignore start record when not pushing");
            AppMethodBeat.o(14159);
            return -2;
        } else {
            TXCLog.w(f1600d, "start record ");
            this.L = true;
            this.J = str;
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            this.H = new c(this.n, 1);
            this.I = false;
            this.H.a(this.J);
            B();
            TXCDRApi.txReportDAU(this.n.getApplicationContext(), com.tencent.liteav.basic.datareport.a.aH);
            if (this.l != null) {
                this.l.t();
            }
            AppMethodBeat.o(14159);
            return 0;
        }
    }

    public void w() {
        AppMethodBeat.i(222675);
        TXCLog.i(f1600d, "liteav_api stopRecord ");
        if (this.L && this.H != null) {
            int b2 = this.H.b();
            TXCLog.w(f1600d, "start record ");
            this.L = false;
            if (b2 == 0) {
                final String str = this.J;
                AsyncTask.execute(new Runnable() {
                    /* class com.tencent.rtmp.b.AnonymousClass8 */

                    public void run() {
                        AppMethodBeat.i(13938);
                        File parentFile = new File(str).getParentFile();
                        String format = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date(System.currentTimeMillis()));
                        String str = parentFile + File.separator + String.format("TXUGCCover_%s.jpg", format);
                        com.tencent.liteav.basic.util.f.a(str, str);
                        b.a(b.this, str, str);
                        AppMethodBeat.o(13938);
                    }
                });
                AppMethodBeat.o(222675);
                return;
            }
            A();
        }
        AppMethodBeat.o(222675);
    }

    public void a(final TXLivePusher.ITXSnapshotListener iTXSnapshotListener) {
        AppMethodBeat.i(14169);
        TXCLog.i(f1600d, "liteav_api snapshot ".concat(String.valueOf(iTXSnapshotListener)));
        if (this.t || iTXSnapshotListener == null || this.l == null) {
            AppMethodBeat.o(14169);
        } else if (this.l != null) {
            this.t = true;
            this.l.a(new o() {
                /* class com.tencent.rtmp.b.AnonymousClass9 */

                @Override // com.tencent.liteav.basic.c.o
                public void onTakePhotoComplete(Bitmap bitmap) {
                    AppMethodBeat.i(222668);
                    b.a(b.this, iTXSnapshotListener, bitmap);
                    b.this.t = false;
                    b.this.o.removeCallbacks(b.this.G);
                    AppMethodBeat.o(222668);
                }
            });
            this.o.postDelayed(this.G, 2000);
            AppMethodBeat.o(14169);
        } else {
            this.t = false;
            AppMethodBeat.o(14169);
        }
    }

    public int c(int i2, int i3, int i4) {
        AppMethodBeat.i(14170);
        if (this.l != null) {
            int a2 = this.l.a(i2, i3, i4, ((EGL10) EGLContext.getEGL()).eglGetCurrentContext(), 0);
            AppMethodBeat.o(14170);
            return a2;
        }
        AppMethodBeat.o(14170);
        return -1000;
    }

    public int a(byte[] bArr, int i2, int i3, int i4) {
        int i5;
        AppMethodBeat.i(14171);
        if (this.l != null) {
            switch (i2) {
                case 3:
                    i5 = 1;
                    break;
                case 4:
                default:
                    AppMethodBeat.o(14171);
                    return -1000;
                case 5:
                    i5 = 2;
                    break;
            }
            int a2 = this.l.a(bArr, i5, i3, i4, 0);
            AppMethodBeat.o(14171);
            return a2;
        }
        AppMethodBeat.o(14171);
        return -1000;
    }

    public void a(byte[] bArr) {
        AppMethodBeat.i(14172);
        TXCAudioEngine.getInstance().sendCustomPCMData(bArr, this.f1605f.mAudioSample, this.f1605f.mAudioChannels);
        AppMethodBeat.o(14172);
    }

    public void a(TXLivePusher.VideoCustomProcessListener videoCustomProcessListener) {
        AppMethodBeat.i(14173);
        TXCLog.i(f1600d, "liteav_api setVideoProcessListener ".concat(String.valueOf(videoCustomProcessListener)));
        this.f1608i = videoCustomProcessListener;
        if (this.f1608i == null) {
            if (this.l != null) {
                this.l.a((m) null);
                AppMethodBeat.o(14173);
                return;
            }
        } else if (this.l != null) {
            this.l.a((m) this);
        }
        AppMethodBeat.o(14173);
    }

    public void a(TXLivePusher.AudioCustomProcessListener audioCustomProcessListener) {
        AppMethodBeat.i(14174);
        TXCLog.i(f1600d, "liteav_api setAudioProcessListener ".concat(String.valueOf(audioCustomProcessListener)));
        this.f1609j = audioCustomProcessListener;
        AppMethodBeat.o(14174);
    }

    public boolean b(byte[] bArr) {
        AppMethodBeat.i(14175);
        if (bArr.length <= 0 || bArr.length > 2048) {
            AppMethodBeat.o(14175);
            return false;
        }
        synchronized (this) {
            try {
                if (this.A != null) {
                    C2183b bVar = new C2183b();
                    bVar.f1636a = TXCTimeUtil.generatePtsMS();
                    bVar.f1637b = a(bArr.length, e(bArr));
                    this.A.add(bVar);
                }
            } catch (Throwable th) {
                AppMethodBeat.o(14175);
                throw th;
            }
        }
        AppMethodBeat.o(14175);
        return true;
    }

    @Deprecated
    public void c(byte[] bArr) {
        AppMethodBeat.i(14176);
        synchronized (this) {
            try {
                if (this.A != null) {
                    C2183b bVar = new C2183b();
                    bVar.f1636a = TXCTimeUtil.generatePtsMS();
                    bVar.f1637b = e(bArr);
                    this.A.add(bVar);
                }
            } finally {
                AppMethodBeat.o(14176);
            }
        }
    }

    public void e(String str) {
        AppMethodBeat.i(222676);
        TXCLog.i("User", str);
        AppMethodBeat.o(222676);
    }

    @Override // com.tencent.liteav.basic.b.b
    public void onNotifyEvent(final int i2, final Bundle bundle) {
        AppMethodBeat.i(14178);
        if (this.o != null) {
            this.o.post(new Runnable() {
                /* class com.tencent.rtmp.b.AnonymousClass10 */

                public void run() {
                    AppMethodBeat.i(13547);
                    if (b.this.f1604e != null) {
                        b.this.f1604e.setLogText(null, bundle, i2);
                    }
                    AppMethodBeat.o(13547);
                }
            });
        }
        if (i2 < 0) {
            TXCLog.e(f1600d, "onNotifyEvent: ".concat(String.valueOf(String.format("%s [code:%d]", bundle != null ? bundle.getString(TXLiveConstants.EVT_DESCRIPTION) : "", Integer.valueOf(i2)))));
            Monitor.a(3, "onNotifyEvent", "event:".concat(String.valueOf(i2)), 0);
        }
        a(i2, bundle);
        AppMethodBeat.o(14178);
    }

    @Override // com.tencent.liteav.m
    public int a(int i2, int i3, int i4) {
        AppMethodBeat.i(14179);
        if (this.f1608i != null) {
            int onTextureCustomProcess = this.f1608i.onTextureCustomProcess(i2, i3, i4);
            AppMethodBeat.o(14179);
            return onTextureCustomProcess;
        }
        AppMethodBeat.o(14179);
        return 0;
    }

    @Override // com.tencent.liteav.m
    public void a() {
        AppMethodBeat.i(14180);
        if (this.f1608i != null) {
            this.f1608i.onTextureDestoryed();
        }
        AppMethodBeat.o(14180);
    }

    @Override // com.tencent.liteav.qos.a
    public int b() {
        AppMethodBeat.i(14181);
        int c2 = TXCStatus.c(this.s, 4002);
        AppMethodBeat.o(14181);
        return c2;
    }

    @Override // com.tencent.liteav.qos.a
    public int c() {
        int c2;
        AppMethodBeat.i(14182);
        int c3 = TXCStatus.c(this.s, 7002);
        if (this.k.P) {
            c2 = c3 + TXCStatus.c(this.s, TXLiteAVCode.WARNING_AUDIO_RECORDING_WRITE_FAIL);
        } else {
            c2 = c3 + TXCStatus.c(this.s, 4002);
        }
        AppMethodBeat.o(14182);
        return c2;
    }

    @Override // com.tencent.liteav.qos.a
    public int d() {
        AppMethodBeat.i(14183);
        if (this.m == null) {
            AppMethodBeat.o(14183);
            return 0;
        }
        int c2 = TXCStatus.c(this.s, 7004) + TXCStatus.c(this.s, 7003);
        AppMethodBeat.o(14183);
        return c2;
    }

    @Override // com.tencent.liteav.qos.a
    public int e() {
        return 5;
    }

    @Override // com.tencent.liteav.qos.a
    public int f() {
        AppMethodBeat.i(14184);
        int c2 = TXCStatus.c(this.s, 7005);
        AppMethodBeat.o(14184);
        return c2;
    }

    @Override // com.tencent.liteav.qos.a
    public int g() {
        AppMethodBeat.i(14185);
        int c2 = TXCStatus.c(this.s, 7007);
        AppMethodBeat.o(14185);
        return c2;
    }

    @Override // com.tencent.liteav.qos.a
    public int h() {
        AppMethodBeat.i(14186);
        int c2 = TXCStatus.c(this.s, 7021);
        AppMethodBeat.o(14186);
        return c2;
    }

    @Override // com.tencent.liteav.qos.a
    public void b(int i2, int i3, int i4) {
        AppMethodBeat.i(14187);
        if (this.l != null) {
            this.l.a(i2, i3, i4);
        }
        if (!(i3 == 0 || i4 == 0)) {
            this.k.f777a = i3;
            this.k.f778b = i4;
        }
        if (i2 != 0) {
            this.k.f779c = i2;
            Monitor.a(2, String.format("Qos: Change [mode:%d][bitrate:%d][videosize:%d*%d]", Integer.valueOf(this.k.f782f), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)), "", 0);
        }
        AppMethodBeat.o(14187);
    }

    @Override // com.tencent.liteav.qos.a
    public void a(boolean z2) {
        AppMethodBeat.i(14188);
        if (this.m != null) {
            this.m.setDropEanble(z2);
        }
        AppMethodBeat.o(14188);
    }

    @Override // com.tencent.liteav.d.a
    public void onEncVideo(TXSNALPacket tXSNALPacket) {
        AppMethodBeat.i(14189);
        if (this.p != null) {
            this.p.setHasVideo(true);
        }
        if (!(this.m == null || tXSNALPacket == null || tXSNALPacket.nalData == null)) {
            synchronized (this) {
                try {
                    if (this.A != null && !this.A.isEmpty()) {
                        Iterator<C2183b> it = this.A.iterator();
                        int i2 = 0;
                        while (it.hasNext()) {
                            C2183b next = it.next();
                            if (next.f1636a > tXSNALPacket.pts) {
                                break;
                            }
                            i2 = (next.f1637b.length <= 10240 ? next.f1637b.length : Task.EXTRAS_LIMIT_BYTES) + 5 + i2;
                        }
                        if (i2 != 0) {
                            byte[] bArr = new byte[(tXSNALPacket.nalData.length + i2)];
                            byte[] bArr2 = new byte[5];
                            Iterator<C2183b> it2 = this.A.iterator();
                            int i3 = 0;
                            int i4 = 0;
                            while (it2.hasNext()) {
                                C2183b next2 = it2.next();
                                if (next2.f1636a > tXSNALPacket.pts) {
                                    break;
                                }
                                int i5 = i3 + 1;
                                int length = next2.f1637b.length <= 10240 ? next2.f1637b.length : Task.EXTRAS_LIMIT_BYTES;
                                int i6 = length + 1;
                                bArr2[0] = (byte) ((i6 >> 24) & 255);
                                bArr2[1] = (byte) ((i6 >> 16) & 255);
                                bArr2[2] = (byte) ((i6 >> 8) & 255);
                                bArr2[3] = (byte) (i6 & 255);
                                bArr2[4] = 6;
                                System.arraycopy(bArr2, 0, bArr, i4, 5);
                                int i7 = i4 + 5;
                                System.arraycopy(next2.f1637b, 0, bArr, i7, length);
                                int i8 = i7 + length;
                                i3 = i5;
                                i4 = i8;
                            }
                            for (int i9 = 0; i9 < i3; i9++) {
                                this.A.remove(0);
                            }
                            System.arraycopy(tXSNALPacket.nalData, 0, bArr, i4, tXSNALPacket.nalData.length);
                            tXSNALPacket.nalData = bArr;
                        }
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(14189);
                    throw th;
                }
            }
            this.m.pushNAL(tXSNALPacket);
        }
        if (!(!this.L || this.H == null || tXSNALPacket == null || tXSNALPacket.nalData == null)) {
            byte[] d2 = d(tXSNALPacket.nalData);
            if (!this.I) {
                if (tXSNALPacket.nalType == 0) {
                    MediaFormat a2 = com.tencent.liteav.basic.util.f.a(d2, this.l.c(), this.l.d());
                    if (a2 != null) {
                        this.H.a(a2);
                        this.H.a();
                        this.I = true;
                        this.K = 0;
                    }
                }
            }
            a(tXSNALPacket, d2);
        }
        AppMethodBeat.o(14189);
    }

    @Override // com.tencent.liteav.audio.e
    public void onRecordRawPcmData(byte[] bArr, long j2, int i2, int i3, int i4, boolean z2) {
        AppMethodBeat.i(14190);
        TXLivePusher.AudioCustomProcessListener audioCustomProcessListener = this.f1609j;
        if (audioCustomProcessListener != null) {
            audioCustomProcessListener.onRecordRawPcmData(bArr, j2, i2, i3, i4, z2);
        }
        AppMethodBeat.o(14190);
    }

    @Override // com.tencent.liteav.audio.e
    public void onRecordPcmData(byte[] bArr, long j2, int i2, int i3, int i4) {
        AppMethodBeat.i(14191);
        TXLivePusher.AudioCustomProcessListener audioCustomProcessListener = this.f1609j;
        if (audioCustomProcessListener != null) {
            audioCustomProcessListener.onRecordPcmData(bArr, j2, i2, i3, i4);
        }
        AppMethodBeat.o(14191);
    }

    @Override // com.tencent.liteav.audio.e
    public void onRecordEncData(byte[] bArr, long j2, int i2, int i3, int i4) {
        AppMethodBeat.i(14192);
        if (this.L && this.H != null && this.I && bArr != null) {
            this.H.a(bArr, 0, bArr.length, 1000 * j2, 0);
        }
        AppMethodBeat.o(14192);
    }

    @Override // com.tencent.liteav.audio.e
    public void onRecordError(int i2, String str) {
    }

    @Override // com.tencent.liteav.d.a
    public void onEncVideoFormat(MediaFormat mediaFormat) {
        AppMethodBeat.i(14193);
        if (this.L && this.H != null) {
            this.H.a(mediaFormat);
            if (!this.I) {
                this.H.a();
                this.I = true;
                this.K = 0;
            }
        }
        AppMethodBeat.o(14193);
    }

    @Override // com.tencent.liteav.d.a
    public void onBackgroudPushStop() {
        AppMethodBeat.i(14194);
        TXCAudioEngine.getInstance().resumeAudioCapture();
        TXCAudioEngine.getInstance().muteLocalAudio(false);
        AppMethodBeat.o(14194);
    }

    private void A() {
        AppMethodBeat.i(182229);
        this.o.post(new Runnable() {
            /* class com.tencent.rtmp.b.AnonymousClass11 */

            public void run() {
                AppMethodBeat.i(13998);
                TXRecordCommon.TXRecordResult tXRecordResult = new TXRecordCommon.TXRecordResult();
                tXRecordResult.retCode = -1;
                tXRecordResult.descMsg = "record video failed";
                if (b.this.M != null) {
                    b.this.M.onRecordComplete(tXRecordResult);
                }
                TXCLog.w(b.f1600d, "record complete fail");
                AppMethodBeat.o(13998);
            }
        });
        AppMethodBeat.o(182229);
    }

    private void a(final String str, final String str2) {
        AppMethodBeat.i(14196);
        this.o.post(new Runnable() {
            /* class com.tencent.rtmp.b.AnonymousClass12 */

            public void run() {
                AppMethodBeat.i(14242);
                TXRecordCommon.TXRecordResult tXRecordResult = new TXRecordCommon.TXRecordResult();
                tXRecordResult.retCode = 0;
                tXRecordResult.descMsg = "record success";
                tXRecordResult.videoPath = str;
                tXRecordResult.coverPath = str2;
                if (b.this.M != null) {
                    b.this.M.onRecordComplete(tXRecordResult);
                }
                TXCLog.w(b.f1600d, "record complete success");
                AppMethodBeat.o(14242);
            }
        });
        AppMethodBeat.o(14196);
    }

    @TargetApi(16)
    private void B() {
        AppMethodBeat.i(14203);
        MediaFormat a2 = com.tencent.liteav.basic.util.f.a(this.f1605f.mAudioSample, this.f1605f.mAudioChannels, 2);
        if (this.H != null) {
            this.H.b(a2);
        }
        AppMethodBeat.o(14203);
    }

    private void a(TXSNALPacket tXSNALPacket, byte[] bArr) {
        int i2;
        AppMethodBeat.i(14198);
        if (this.K == 0) {
            this.K = tXSNALPacket.pts;
        }
        final long j2 = tXSNALPacket.pts - this.K;
        if (tXSNALPacket.info == null) {
            i2 = tXSNALPacket.nalType == 0 ? 1 : 0;
        } else {
            i2 = tXSNALPacket.info.flags;
        }
        this.H.b(bArr, 0, bArr.length, tXSNALPacket.pts * 1000, i2);
        this.o.post(new Runnable() {
            /* class com.tencent.rtmp.b.AnonymousClass13 */

            public void run() {
                AppMethodBeat.i(222658);
                if (b.this.M != null) {
                    b.this.M.onRecordProgress(j2);
                }
                AppMethodBeat.o(222658);
            }
        });
        AppMethodBeat.o(14198);
    }

    private void a(final TXLivePusher.ITXSnapshotListener iTXSnapshotListener, final Bitmap bitmap) {
        AppMethodBeat.i(14199);
        if (iTXSnapshotListener == null) {
            AppMethodBeat.o(14199);
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.tencent.rtmp.b.AnonymousClass2 */

            public void run() {
                AppMethodBeat.i(13936);
                if (iTXSnapshotListener != null) {
                    iTXSnapshotListener.onSnapshot(bitmap);
                }
                AppMethodBeat.o(13936);
            }
        });
        AppMethodBeat.o(14199);
    }

    private void a(boolean z2, boolean z3) {
        AppMethodBeat.i(14200);
        int b2 = b(z2, z3);
        if (b2 == -1) {
            this.f1605f.setAutoAdjustBitrate(false);
            this.f1605f.setAutoAdjustStrategy(-1);
            AppMethodBeat.o(14200);
            return;
        }
        this.f1605f.setAutoAdjustBitrate(true);
        this.f1605f.setAutoAdjustStrategy(b2);
        AppMethodBeat.o(14200);
    }

    private int b(boolean z2, boolean z3) {
        if (!z2) {
            return -1;
        }
        if (z3) {
            return 1;
        }
        return 0;
    }

    private void k(String str) {
        AppMethodBeat.i(259982);
        if (this.m != null) {
            this.m.setID(str);
        }
        if (this.l != null) {
            this.l.setID(str);
        }
        if (this.q != null) {
            this.q.d(str);
        }
        this.s = str;
        AppMethodBeat.o(259982);
    }

    private void C() {
        AppMethodBeat.i(14204);
        this.N = true;
        if (this.o != null) {
            this.o.postDelayed(new Runnable() {
                /* class com.tencent.rtmp.b.AnonymousClass3 */

                public void run() {
                    AppMethodBeat.i(13997);
                    if (b.this.N) {
                        b.i(b.this);
                    }
                    AppMethodBeat.o(13997);
                }
            }, 2000);
        }
        AppMethodBeat.o(14204);
    }

    private void D() {
        AppMethodBeat.i(14205);
        this.N = false;
        AppMethodBeat.o(14205);
    }

    private String g(int i2) {
        switch (i2) {
            case 0:
                return "UNKNOWN";
            case 1:
                return "WIFI";
            case 2:
                return "4G";
            case 3:
                return "3G";
            case 4:
                return "2G";
            case 5:
                return "WIRED";
            default:
                return "UNKNOWN";
        }
    }

    private void E() {
        AppMethodBeat.i(14206);
        com.tencent.liteav.a.a(this.s, null);
        AppMethodBeat.o(14206);
    }

    private void F() {
        int i2;
        AppMethodBeat.i(14207);
        E();
        int[] a2 = com.tencent.liteav.basic.util.f.a();
        String str = (a2[0] / 10) + FilePathGenerator.ANDROID_DIR_SEP + (a2[1] / 10) + "%";
        int c2 = TXCStatus.c(this.s, 7004);
        int c3 = TXCStatus.c(this.s, 7003);
        int c4 = TXCStatus.c(this.s, 7002);
        int c5 = TXCStatus.c(this.s, TXLiteAVCode.WARNING_AUDIO_RECORDING_WRITE_FAIL);
        int c6 = TXCStatus.c(this.s, 7007);
        int c7 = TXCStatus.c(this.s, 7005);
        int c8 = TXCStatus.c(this.s, 7006);
        String b2 = TXCStatus.b(this.s, 7012);
        double d2 = TXCStatus.d(this.s, 4001);
        int c9 = TXCStatus.c(this.s, WearableStatusCodes.DUPLICATE_CAPABILITY);
        Bundle bundle = new Bundle();
        bundle.putInt(TXLiveConstants.NET_STATUS_NET_SPEED, c2 + c3);
        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_FPS, (int) d2);
        if (d2 < 1.0d) {
            d2 = 15.0d;
        }
        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_GOP, (int) (((double) (((float) ((c9 * 10) / ((int) d2))) / 10.0f)) + 0.5d));
        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_DROP, c6);
        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_BITRATE, c5);
        bundle.putInt(TXLiveConstants.NET_STATUS_AUDIO_BITRATE, c4);
        bundle.putInt(TXLiveConstants.NET_STATUS_AUDIO_CACHE, c8);
        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_CACHE, c7);
        bundle.putCharSequence(TXLiveConstants.NET_STATUS_SERVER_IP, b2);
        bundle.putCharSequence(TXLiveConstants.NET_STATUS_CPU_USAGE, str);
        if (this.l != null) {
            bundle.putString(TXLiveConstants.NET_STATUS_AUDIO_INFO, TXCAudioEngine.getInstance().getAECType() + APLogFileUtil.SEPARATOR_LOG + this.f1605f.mAudioSample + " , " + this.f1605f.mAudioChannels);
            bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_WIDTH, this.l.c());
            bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_HEIGHT, this.l.d());
        }
        if (this.f1604e != null) {
            this.f1604e.setLogText(bundle, null, 0);
        }
        if (this.f1606g != null) {
            this.f1606g.onNetStatus(bundle);
        }
        if (this.q != null) {
            this.q.e();
        }
        int e2 = com.tencent.liteav.basic.util.f.e(this.n);
        if (com.tencent.liteav.basic.util.f.a(this.n)) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (this.u != e2) {
            Monitor.a(2, String.format("Network: net type change from %s to %s", g(this.u), g(e2)), "", 0);
            this.u = e2;
        }
        if (this.v != i2) {
            Object[] objArr = new Object[1];
            objArr[0] = i2 == 1 ? "background" : "foreground";
            Monitor.a(2, String.format("app: switch to %s", objArr), "", 0);
            this.v = i2;
        }
        if (this.o != null && this.N) {
            this.o.postDelayed(new Runnable() {
                /* class com.tencent.rtmp.b.AnonymousClass4 */

                public void run() {
                    AppMethodBeat.i(14060);
                    if (b.this.N) {
                        b.i(b.this);
                    }
                    AppMethodBeat.o(14060);
                }
            }, 2000);
        }
        AppMethodBeat.o(14207);
    }

    private void G() {
        int i2 = 5;
        int i3 = 1;
        AppMethodBeat.i(14208);
        h hVar = new h();
        hVar.f985d = this.f1605f.mAudioChannels;
        hVar.f986e = this.f1605f.mAudioSample;
        hVar.f982a = 0;
        hVar.f984c = 20;
        hVar.f983b = 0;
        hVar.f987f = 3;
        hVar.f991j = true;
        hVar.l = true;
        hVar.k = false;
        hVar.f989h = 40;
        hVar.f990i = 5000;
        hVar.m = this.k.P;
        hVar.n = this.k.Q;
        hVar.o = i(this.f1607h);
        this.m = new TXCStreamUploader(this.n, hVar);
        this.m.setID(this.s);
        this.m.setMetaData(this.f1605f.mMetaData);
        if (this.m != null) {
            this.m.setAudioInfo(this.k.s, this.k.t);
        }
        this.m.setNotifyListener(this);
        if (this.k.M) {
            this.m.setAudioMute(this.x);
        }
        this.r = this.m.start(this.r, this.k.N, this.k.O);
        if (this.k.M) {
            this.m.setMode(1);
        }
        if (this.k.P) {
            int i4 = this.k.q;
            int i5 = this.k.r;
            if (i4 >= 5) {
                i2 = i4;
            }
            if (i5 <= 1) {
                i3 = i5;
            }
            this.m.setRetryInterval(i3);
            this.m.setRetryTimes(i2);
            this.m.setVideoDropParams(false, this.k.f784h, 1000);
        } else {
            this.m.setRetryInterval(this.k.r);
            this.m.setRetryTimes(this.k.q);
            this.m.setVideoDropParams(true, 40, 3000);
        }
        this.m.setSendStrategy(this.k.P, this.k.Q);
        AppMethodBeat.o(14208);
    }

    private void H() {
        AppMethodBeat.i(14209);
        if (this.m != null) {
            this.m.stop();
            this.m.setNotifyListener(null);
            this.m = null;
        }
        AppMethodBeat.o(14209);
    }

    private void I() {
        AppMethodBeat.i(14210);
        this.p = new TXCQoS(true);
        this.p.setListener(this);
        this.p.setNotifyListener(this);
        this.p.setAutoAdjustBitrate(this.k.f783g);
        this.p.setAutoAdjustStrategy(this.k.f782f);
        this.p.setDefaultVideoResolution(this.k.k);
        this.p.setVideoEncBitrate(this.k.f781e, this.k.f780d, this.k.f779c);
        if (this.k.f783g) {
            this.p.start(2000);
        }
        AppMethodBeat.o(14210);
    }

    private void J() {
        AppMethodBeat.i(14211);
        if (this.p != null) {
            this.p.stop();
            this.p.setListener(null);
            this.p.setNotifyListener(null);
            this.p = null;
        }
        AppMethodBeat.o(14211);
    }

    private void K() {
        AppMethodBeat.i(14212);
        this.q = new com.tencent.liteav.e(this.n);
        this.q.d(this.s);
        this.q.a(this.k.f779c);
        this.q.b(this.k.s);
        this.q.a(this.k.f777a, this.k.f778b);
        this.q.a(this.r);
        this.q.a();
        AppMethodBeat.o(14212);
    }

    private void L() {
        AppMethodBeat.i(14213);
        if (this.q != null) {
            this.q.b();
            this.q = null;
        }
        AppMethodBeat.o(14213);
    }

    private void M() {
        AppMethodBeat.i(14215);
        if (this.l != null) {
            this.l.setID(this.s);
            this.l.a((d.a) this);
            this.l.e();
        }
        AppMethodBeat.o(14215);
    }

    private void N() {
        AppMethodBeat.i(182230);
        if (this.l != null) {
            this.l.a((d.a) null);
            this.l.f();
            this.l.a((d.a) null);
        }
        AppMethodBeat.o(182230);
    }

    private void O() {
        boolean z2 = false;
        AppMethodBeat.i(182231);
        TXCAudioEngine.getInstance().setEncoderSampleRate(this.f1605f.mAudioSample);
        TXCAudioEngine.getInstance().setEncoderChannels(this.f1605f.mAudioChannels);
        TXCAudioEngine.getInstance().muteLocalAudio(this.x);
        boolean z3 = (this.f1605f.mCustomModeType & 1) != 0;
        TXCAudioEngine.getInstance().setAudioCaptureDataListener(this);
        if (!TXCAudioEngine.hasTrae()) {
            z2 = true;
        }
        TXCAudioEngineJNI.nativeUseSysAudioDevice(z2);
        TXCAudioEngine.getInstance().startLocalAudio(10, z3);
        TXCAudioEngine.getInstance().enableEncodedDataCallback(true);
        AppMethodBeat.o(182231);
    }

    private void P() {
        AppMethodBeat.i(222678);
        TXCAudioEngine.getInstance().stopLocalAudio();
        AppMethodBeat.o(222678);
    }

    private void b(TXLivePushConfig tXLivePushConfig) {
        AppMethodBeat.i(14214);
        g gVar = this.k;
        gVar.f779c = tXLivePushConfig.mVideoBitrate;
        gVar.f781e = tXLivePushConfig.mMinVideoBitrate;
        gVar.f780d = tXLivePushConfig.mMaxVideoBitrate;
        gVar.f782f = tXLivePushConfig.mAutoAdjustStrategy;
        gVar.f783g = tXLivePushConfig.mAutoAdjustBitrate;
        gVar.f784h = tXLivePushConfig.mVideoFPS;
        gVar.f785i = tXLivePushConfig.mVideoEncodeGop;
        gVar.f786j = tXLivePushConfig.mHardwareAccel;
        gVar.k = tXLivePushConfig.mVideoResolution;
        gVar.n = tXLivePushConfig.mEnableVideoHardEncoderMainProfile ? 3 : 1;
        gVar.o = tXLivePushConfig.mLocalVideoMirrorType;
        gVar.s = tXLivePushConfig.mAudioSample;
        gVar.t = tXLivePushConfig.mAudioChannels;
        gVar.u = tXLivePushConfig.mEnableAec;
        gVar.v = tXLivePushConfig.mEnableAgc;
        gVar.w = tXLivePushConfig.mEnableAns;
        gVar.x = tXLivePushConfig.mVolumeType;
        gVar.D = tXLivePushConfig.mPauseFlag;
        gVar.C = tXLivePushConfig.mPauseFps;
        gVar.A = tXLivePushConfig.mPauseImg;
        gVar.B = tXLivePushConfig.mPauseTime;
        gVar.M = tXLivePushConfig.mEnablePureAudioPush;
        gVar.K = tXLivePushConfig.mTouchFocus;
        gVar.L = tXLivePushConfig.mEnableZoom;
        gVar.E = tXLivePushConfig.mWatermark;
        gVar.F = tXLivePushConfig.mWatermarkX;
        gVar.G = tXLivePushConfig.mWatermarkY;
        gVar.H = tXLivePushConfig.mWatermarkXF;
        gVar.I = tXLivePushConfig.mWatermarkYF;
        gVar.J = tXLivePushConfig.mWatermarkWidth;
        gVar.l = tXLivePushConfig.mHomeOrientation;
        gVar.N = tXLivePushConfig.mEnableNearestIP;
        gVar.O = tXLivePushConfig.mRtmpChannelType;
        gVar.q = tXLivePushConfig.mConnectRetryCount;
        gVar.r = tXLivePushConfig.mConnectRetryInterval;
        gVar.m = tXLivePushConfig.mFrontCamera;
        gVar.R = tXLivePushConfig.mCustomModeType;
        gVar.S = tXLivePushConfig.mVideoEncoderXMirror;
        gVar.T = tXLivePushConfig.mEnableHighResolutionCapture;
        gVar.V = tXLivePushConfig.mEnableScreenCaptureAutoRotate;
        gVar.z = tXLivePushConfig.mEnableAudioPreview;
        gVar.a();
        AppMethodBeat.o(14214);
    }

    private void Q() {
        int i2 = 5;
        int i3 = 1;
        AppMethodBeat.i(222679);
        if (this.l == null) {
            AppMethodBeat.o(222679);
            return;
        }
        TXCAudioEngine.getInstance().enableSoftAGC(this.k.v, 100);
        TXCAudioEngine.getInstance().enableSoftANS(this.k.w, 100);
        TXCAudioEngine.getInstance();
        TXCAudioEngine.setSystemVolumeType(this.k.x);
        TXCAudioEngine.getInstance();
        TXCAudioEngine.enableAudioEarMonitoring(this.k.z);
        this.l.a(this.k);
        this.l.b(this.k.o);
        if (this.l.j()) {
            if (this.m != null) {
                if (this.k.P) {
                    int i4 = this.k.q;
                    int i5 = this.k.r;
                    if (i4 >= 5) {
                        i2 = i4;
                    }
                    if (i5 <= 1) {
                        i3 = i5;
                    }
                    this.m.setRetryInterval(i3);
                    this.m.setRetryTimes(i2);
                    this.m.setVideoDropParams(false, this.k.f784h, 1000);
                } else {
                    this.m.setRetryInterval(this.k.r);
                    this.m.setRetryTimes(this.k.q);
                    this.m.setVideoDropParams(true, 40, 3000);
                }
                this.m.setSendStrategy(this.k.P, this.k.Q);
            }
            if (this.p != null) {
                this.p.stop();
                this.p.setAutoAdjustBitrate(this.k.f783g);
                this.p.setAutoAdjustStrategy(this.k.f782f);
                this.p.setDefaultVideoResolution(this.k.k);
                this.p.setVideoEncBitrate(this.k.f781e, this.k.f780d, this.k.f779c);
                if (this.k.f783g) {
                    this.p.start(2000);
                    AppMethodBeat.o(222679);
                    return;
                }
            }
        } else if (this.m != null) {
            this.m.setAudioInfo(this.k.s, this.k.t);
        }
        AppMethodBeat.o(222679);
    }

    private void a(final int i2, final Bundle bundle) {
        AppMethodBeat.i(14216);
        switch (i2) {
            case TXLiteAVCode.ERR_RTMP_PUSH_SERVER_REFUSE:
                i2 = 3004;
                break;
            case TXLiteAVCode.ERR_RTMP_PUSH_NO_NETWORK:
                i2 = -1307;
                break;
            case TXLiteAVCode.ERR_RTMP_PUSH_NET_ALLADDRESS_FAIL:
                i2 = -1307;
                break;
            case TXLiteAVCode.ERR_MIC_NOT_AUTHORIZED:
            case -1302:
                i2 = -1302;
                break;
            case TXLiteAVCode.ERR_CAMERA_SET_PARAM_FAIL:
            case TXLiteAVCode.ERR_CAMERA_NOT_AUTHORIZED:
            case -1301:
                i2 = -1301;
                break;
            case -1313:
                i2 = -1313;
                break;
            case -1309:
            case -1308:
            case 1003:
            case 1004:
            case 1005:
            case 1006:
            case 1007:
            case 3001:
                break;
            case -1307:
                i2 = -1307;
                break;
            case -1303:
                i2 = -1303;
                break;
            case 0:
                AppMethodBeat.o(14216);
                return;
            case 1001:
                i2 = 1001;
                break;
            case 1002:
                i2 = 1002;
                break;
            case 1008:
            case TXLiteAVCode.EVT_HW_ENCODER_START_SUCC:
            case TXLiteAVCode.EVT_SW_ENCODER_START_SUCC:
                i2 = 1008;
                break;
            case 1018:
                i2 = 1018;
                break;
            case 1019:
                i2 = 1019;
                break;
            case 1020:
                i2 = 1020;
                break;
            case 1021:
                i2 = 1021;
                break;
            case 1101:
                i2 = 1101;
                break;
            case 1102:
                i2 = 1102;
                break;
            case 1103:
                i2 = 1103;
                break;
            case 1109:
                AppMethodBeat.o(14216);
                return;
            case 2003:
                AppMethodBeat.o(14216);
                return;
            case 2009:
                AppMethodBeat.o(14216);
                return;
            case 2110:
                i2 = 2110;
                break;
            case 3002:
                i2 = 3002;
                break;
            case 3003:
                i2 = 3003;
                break;
            case 3006:
            case TXLiteAVCode.WARNING_RTMP_READ_FAIL:
                i2 = 3005;
                break;
            case TXLiteAVCode.WARNING_RTMP_NO_DATA:
                i2 = -1307;
                break;
            default:
                AppMethodBeat.o(14216);
                return;
        }
        if (this.o != null) {
            this.o.post(new Runnable() {
                /* class com.tencent.rtmp.b.AnonymousClass5 */

                public void run() {
                    AppMethodBeat.i(13555);
                    if (b.this.f1606g != null) {
                        b.this.f1606g.onPushEvent(i2, bundle);
                    }
                    AppMethodBeat.o(13555);
                }
            });
        }
        AppMethodBeat.o(14216);
    }

    private byte[] d(byte[] bArr) {
        AppMethodBeat.i(14217);
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        int i2 = 0;
        while (i2 + 4 < length) {
            int i3 = ByteBuffer.wrap(bArr, i2, 4).getInt();
            if (i2 + 4 + i3 <= length) {
                bArr2[i2] = 0;
                bArr2[i2 + 1] = 0;
                bArr2[i2 + 2] = 0;
                bArr2[i2 + 3] = 1;
            }
            i2 = i2 + i3 + 4;
        }
        AppMethodBeat.o(14217);
        return bArr2;
    }

    private byte[] e(byte[] bArr) {
        AppMethodBeat.i(14218);
        int length = ((bArr.length * 4) / 3) + 2;
        byte[] bArr2 = new byte[length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr.length && i3 < length) {
            if (i2 + 3 < bArr.length && bArr[i2] == 0 && bArr[i2 + 1] == 0 && bArr[i2 + 2] >= 0 && bArr[i2 + 2] <= 3) {
                int i4 = i3 + 1;
                int i5 = i2 + 1;
                bArr2[i3] = bArr[i2];
                int i6 = i4 + 1;
                i2 = i5 + 1;
                bArr2[i4] = bArr[i5];
                i3 = i6 + 1;
                bArr2[i6] = 3;
            }
            bArr2[i3] = bArr[i2];
            i2++;
            i3++;
        }
        byte[] bArr3 = new byte[i3];
        System.arraycopy(bArr2, 0, bArr3, 0, i3);
        AppMethodBeat.o(14218);
        return bArr3;
    }

    private byte[] a(int i2, byte[] bArr) {
        AppMethodBeat.i(14219);
        byte[] h2 = h(i2);
        byte[] bArr2 = new byte[(h2.length + 1 + bArr.length + 1)];
        bArr2[0] = -14;
        System.arraycopy(h2, 0, bArr2, 1, h2.length);
        int length = h2.length + 1;
        System.arraycopy(bArr, 0, bArr2, length, bArr.length);
        bArr2[length + bArr.length] = Byte.MIN_VALUE;
        AppMethodBeat.o(14219);
        return bArr2;
    }

    private byte[] h(int i2) {
        int i3 = (i2 / 255) + 1;
        byte[] bArr = new byte[i3];
        for (int i4 = 0; i4 < i3 - 1; i4++) {
            bArr[i4] = -1;
        }
        bArr[i3 - 1] = (byte) ((i2 % 255) & 255);
        return bArr;
    }

    private int i(int i2) {
        int a2;
        AppMethodBeat.i(182232);
        switch (i2) {
            case 1:
                a2 = (int) com.tencent.liteav.basic.d.c.a().a("QUICMode", "Live");
                break;
            case 2:
                a2 = (int) com.tencent.liteav.basic.d.c.a().a("QUICMode", "Live");
                break;
            case 3:
                a2 = (int) com.tencent.liteav.basic.d.c.a().a("QUICMode", "Live");
                break;
            case 4:
                a2 = (int) com.tencent.liteav.basic.d.c.a().a("QUICMode", "LinkMain");
                break;
            case 5:
                a2 = (int) com.tencent.liteav.basic.d.c.a().a("QUICMode", "LinkSub");
                break;
            case 6:
                a2 = (int) com.tencent.liteav.basic.d.c.a().a("QUICMode", "RTC");
                break;
            case 7:
                a2 = (int) com.tencent.liteav.basic.d.c.a().a("QUICMode", "Live");
                break;
            default:
                a2 = 0;
                break;
        }
        AppMethodBeat.o(182232);
        return a2;
    }

    private String R() {
        AppMethodBeat.i(222680);
        com.tencent.liteav.basic.d.c a2 = com.tencent.liteav.basic.d.c.a();
        String c2 = a2.c();
        if (!TextUtils.isEmpty(c2)) {
            AppMethodBeat.o(222680);
            return c2;
        }
        String buildTRAEConfig = TXCAudioEngine.buildTRAEConfig(this.n, null, a2.h(), a2.i());
        AppMethodBeat.o(222680);
        return buildTRAEConfig;
    }
}
