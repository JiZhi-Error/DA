package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.dynamite.ProviderConstants;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.c.o;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.f;
import com.tencent.liteav.h;
import com.tencent.liteav.j;
import com.tencent.liteav.n;
import com.tencent.liteav.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon;
import javax.microedition.khronos.egl.EGLContext;
import org.json.JSONObject;

public class a implements b {
    private String A;
    private int B = -1;
    private long C = 0;
    private TXLivePlayer.ITXAudioVolumeEvaluationListener D = null;
    private int E = 0;
    private long F;
    private String G;
    private int H;
    private RunnableC2181a I = null;
    private TXLivePlayer.ITXAudioRawDataListener J;

    /* renamed from: a  reason: collision with root package name */
    private TXCloudVideoView f1561a;

    /* renamed from: b  reason: collision with root package name */
    private Surface f1562b;

    /* renamed from: c  reason: collision with root package name */
    private int f1563c;

    /* renamed from: d  reason: collision with root package name */
    private int f1564d;

    /* renamed from: e  reason: collision with root package name */
    private ITXLivePlayListener f1565e = null;

    /* renamed from: f  reason: collision with root package name */
    private TXLivePlayConfig f1566f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1567g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1568h = true;

    /* renamed from: i  reason: collision with root package name */
    private int f1569i;

    /* renamed from: j  reason: collision with root package name */
    private int f1570j;
    private String k = "";
    private boolean l = false;
    private int m = 100;
    private TXLivePlayer.ITXVideoRawDataListener n = null;
    private byte[] o = null;
    private Object p = null;
    private TXLivePlayer.ITXLivePlayVideoRenderListener q = null;
    private Context r;
    private Handler s;
    private n t;
    private boolean u = true;
    private float v = 1.0f;
    private boolean w = false;
    private j x;
    private boolean y;
    private long z;

    static /* synthetic */ void a(a aVar, TXLivePlayer.ITXSnapshotListener iTXSnapshotListener, Bitmap bitmap) {
        AppMethodBeat.i(14100);
        aVar.a(iTXSnapshotListener, bitmap);
        AppMethodBeat.o(14100);
    }

    public a(Context context) {
        AppMethodBeat.i(14062);
        this.r = context.getApplicationContext();
        TXCCommonUtil.setAppContext(this.r);
        TXCLog.init();
        this.s = new Handler(Looper.getMainLooper());
        TXCCommonUtil.setAppContext(this.r);
        TXCLog.init();
        AppMethodBeat.o(14062);
    }

    public void a(String str, String str2) {
        AppMethodBeat.i(259971);
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        TXCLog.i(TXLivePlayer.TAG, ("tx_liveplayer(" + hashCode() + ") " + str) + " " + str2);
        AppMethodBeat.o(259971);
    }

    public void a(TXLivePlayConfig tXLivePlayConfig) {
        AppMethodBeat.i(14063);
        a("[API] setConfig", tXLivePlayConfig != null ? tXLivePlayConfig.toString() : null);
        this.f1566f = tXLivePlayConfig;
        if (this.f1566f == null) {
            this.f1566f = new TXLivePlayConfig();
        }
        if (this.t != null) {
            h i2 = this.t.i();
            if (i2 == null) {
                i2 = new h();
            }
            this.H = (int) (this.f1566f.mMinAutoAdjustCacheTime * 1000.0f);
            i2.f790a = this.f1566f.mCacheTime;
            i2.f796g = this.f1566f.mAutoAdjustCacheTime;
            i2.f792c = this.f1566f.mMinAutoAdjustCacheTime;
            i2.f791b = this.f1566f.mMaxAutoAdjustCacheTime;
            i2.f793d = this.f1566f.mVideoBlockThreshold;
            i2.f794e = this.f1566f.mConnectRetryCount;
            i2.f795f = this.f1566f.mConnectRetryInterval;
            i2.f798i = this.f1566f.mEnableNearestIP;
            i2.m = this.f1566f.mRtmpChannelType;
            i2.f797h = this.f1567g;
            i2.n = this.f1566f.mCacheFolderPath;
            i2.o = this.f1566f.mMaxCacheItems;
            i2.f799j = this.f1566f.mEnableMessage;
            i2.k = this.f1566f.mEnableMetaData;
            i2.l = this.f1566f.mFlvSessionKey;
            i2.p = this.f1566f.mHeaders;
            this.t.a(i2);
        }
        AppMethodBeat.o(14063);
    }

    public void a(ITXLivePlayListener iTXLivePlayListener) {
        AppMethodBeat.i(14064);
        a("[API] setPlayListener", "listener:".concat(String.valueOf(iTXLivePlayListener)));
        this.f1565e = iTXLivePlayListener;
        AppMethodBeat.o(14064);
    }

    public void a(TXCloudVideoView tXCloudVideoView) {
        AppMethodBeat.i(14065);
        a("[API] setPlayerView", "old:" + this.f1561a + " new:" + tXCloudVideoView);
        this.f1561a = tXCloudVideoView;
        if (this.t != null) {
            this.t.a(tXCloudVideoView);
        }
        AppMethodBeat.o(14065);
    }

    public int a(String str, int i2) {
        AppMethodBeat.i(14066);
        if (TextUtils.isEmpty(str)) {
            TXCLog.e(TXLivePlayer.TAG, "start play error when url is empty ".concat(String.valueOf(this)));
            AppMethodBeat.o(14066);
            return -1;
        }
        if (!TextUtils.isEmpty(this.k)) {
            if (!this.k.equalsIgnoreCase(str) || !a()) {
                TXCLog.w(TXLivePlayer.TAG, " stop old play when new url is not the same with old url  ".concat(String.valueOf(this)));
                if (this.t != null) {
                    this.t.a(false);
                }
                this.k = "";
            } else {
                TXCLog.e(TXLivePlayer.TAG, "start play error when new url is the same with old url  ".concat(String.valueOf(this)));
                if (this.y) {
                    onNotifyEvent(2004, new Bundle());
                }
                if (this.y) {
                    AppMethodBeat.o(14066);
                    return 0;
                }
                AppMethodBeat.o(14066);
                return -1;
            }
        }
        TXCDRApi.initCrashReport(this.r);
        TXCLog.i(TXLivePlayer.TAG, "[API] ===========================================================================================================================================================");
        TXCLog.i(TXLivePlayer.TAG, "[API] ===========================================================================================================================================================");
        TXCLog.i(TXLivePlayer.TAG, "[API] =====  StartPlay url = " + str + " playType = " + i2 + " DeviceName = " + f.c() + " SDKVersion = " + TXCCommonUtil.getSDKID() + " , " + TXCCommonUtil.getSDKVersionStr() + "    ======");
        TXCLog.i(TXLivePlayer.TAG, "[API] ===========================================================================================================================================================");
        TXCLog.i(TXLivePlayer.TAG, "[API] ===========================================================================================================================================================");
        if (this.B == -1 || this.B != i2) {
            this.t = p.a(this.r, i2);
        }
        this.B = i2;
        if (this.t == null) {
            AppMethodBeat.o(14066);
            return -2;
        }
        this.k = c(str, i2);
        a("[API] startPlay", " url:" + str + " type:" + i2);
        a(this.f1566f);
        if (this.f1561a != null) {
            this.f1561a.clearLog();
            this.f1561a.setVisibility(0);
        }
        this.t.a(this.f1561a);
        this.t.a(this);
        this.t.d(this.u);
        if (this.f1562b != null) {
            this.t.a(this.f1562b);
            this.t.a(this.f1563c, this.f1564d);
        }
        this.t.a(this.k, i2);
        this.t.b(this.l);
        this.t.c(this.m);
        this.t.a(this.v);
        this.t.b(this.f1570j);
        this.t.a(this.f1569i);
        this.t.a(this.J);
        if (this.n != null) {
            a(this.n);
        }
        if (this.q != null) {
            a(this.q, this.p);
        }
        if (this.t.e()) {
            this.A = this.k;
            this.z = this.x != null ? this.x.a() : 0;
            if (this.z > 0) {
                this.t.f();
            }
        }
        f();
        AppMethodBeat.o(14066);
        return 0;
    }

    public int a(boolean z2) {
        AppMethodBeat.i(14067);
        a("[API] stopPlay", "need clear:".concat(String.valueOf(z2)));
        if (z2 && this.f1561a != null) {
            this.f1561a.setVisibility(8);
        }
        g();
        if (this.t != null) {
            this.t.a(z2);
        }
        this.k = "";
        this.z = 0;
        this.x = null;
        this.y = false;
        AppMethodBeat.o(14067);
        return 0;
    }

    public boolean a() {
        AppMethodBeat.i(14068);
        if (this.t != null) {
            boolean c2 = this.t.c();
            AppMethodBeat.o(14068);
            return c2;
        }
        AppMethodBeat.o(14068);
        return false;
    }

    public void b() {
        AppMethodBeat.i(14069);
        a("[API] pause", "");
        if (this.t != null) {
            TXCLog.w(TXLivePlayer.TAG, "pause play");
            this.t.a();
        }
        AppMethodBeat.o(14069);
    }

    public void c() {
        AppMethodBeat.i(14070);
        a("[API] resume", "");
        if (this.t != null) {
            this.t.b();
            if (this.t.e()) {
                this.z = this.x != null ? this.x.a() : 0;
                if (this.z > 0) {
                    this.t.f();
                }
            }
        }
        AppMethodBeat.o(14070);
    }

    public void a(Surface surface) {
        AppMethodBeat.i(14071);
        a("[API] setSurface", "old:" + this.f1562b + " new:" + surface);
        this.f1562b = surface;
        if (this.t != null) {
            this.t.a(this.f1562b);
        }
        AppMethodBeat.o(14071);
    }

    public void a(int i2, int i3) {
        AppMethodBeat.i(14072);
        a("[API] setSurfaceSize", "width:" + i2 + " height:" + i3);
        this.f1563c = i2;
        this.f1564d = i3;
        if (this.t != null) {
            this.t.a(i2, i3);
        }
        AppMethodBeat.o(14072);
    }

    public void a(int i2) {
        AppMethodBeat.i(14073);
        a("[API] setRenderMode", "mode:".concat(String.valueOf(i2)));
        this.f1569i = i2;
        if (this.t != null) {
            this.t.a(i2);
        }
        AppMethodBeat.o(14073);
    }

    public void b(int i2) {
        AppMethodBeat.i(14074);
        a("[API] setRenderRotation", "rotation:".concat(String.valueOf(i2)));
        this.f1570j = i2;
        if (this.t != null) {
            this.t.b(i2);
        }
        AppMethodBeat.o(14074);
    }

    public boolean b(boolean z2) {
        AppMethodBeat.i(14075);
        a("[API] enableHardwareDecode", "enable:".concat(String.valueOf(z2)));
        if (z2) {
            if (Build.VERSION.SDK_INT < 18) {
                TXCLog.e("HardwareDecode", "enableHardwareDecode failed, android system build.version = " + Build.VERSION.SDK_INT + ", the minimum build.version should be 18(android 4.3 or later)");
                AppMethodBeat.o(14075);
                return false;
            } else if (i()) {
                TXCLog.e("HardwareDecode", "enableHardwareDecode failed, MANUFACTURER = " + Build.MANUFACTURER + ", MODEL" + Build.MODEL);
                AppMethodBeat.o(14075);
                return false;
            }
        }
        this.f1567g = z2;
        if (this.t != null) {
            h i2 = this.t.i();
            if (i2 == null) {
                i2 = new h();
            }
            i2.f797h = this.f1567g;
            this.t.a(i2);
        }
        AppMethodBeat.o(14075);
        return true;
    }

    public void c(boolean z2) {
        AppMethodBeat.i(14076);
        a("[API] setMute", "mute:".concat(String.valueOf(z2)));
        this.l = z2;
        if (this.t != null) {
            this.t.b(z2);
        }
        AppMethodBeat.o(14076);
    }

    public void c(int i2) {
        int i3;
        int i4 = 100;
        AppMethodBeat.i(14077);
        if (i2 < 0) {
            i3 = 0;
        } else {
            i3 = i2;
        }
        if (i3 <= 100) {
            i4 = i3;
        }
        a("[API] setVolume", "volume:".concat(String.valueOf(i4)));
        this.m = i4;
        if (this.t != null) {
            this.t.c(i4);
        }
        AppMethodBeat.o(14077);
    }

    public void d(int i2) {
        AppMethodBeat.i(14078);
        a("[API] setAudioRoute", "route:".concat(String.valueOf(i2)));
        TXCAudioEngine.setAudioRoute(i2);
        AppMethodBeat.o(14078);
    }

    public int a(String str) {
        AppMethodBeat.i(14079);
        a("[SwitchStream][API] switchStream", "url:".concat(String.valueOf(str)));
        if (this.t != null) {
            int a2 = this.t.a(str);
            AppMethodBeat.o(14079);
            return a2;
        }
        AppMethodBeat.o(14079);
        return -1;
    }

    public void a(TXLivePlayer.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener) {
        this.D = iTXAudioVolumeEvaluationListener;
    }

    public void e(int i2) {
        AppMethodBeat.i(14080);
        a("[API] enableAudioVolumeEvaluation", "intervalMs:".concat(String.valueOf(i2)));
        if (i2 > 0) {
            if (i2 < 100) {
                i2 = 100;
            }
            this.E = i2;
            f();
            AppMethodBeat.o(14080);
            return;
        }
        this.E = 0;
        g();
        AppMethodBeat.o(14080);
    }

    public void b(String str) {
        boolean z2 = true;
        AppMethodBeat.i(14081);
        a("[API] callExperimentalAPI", "json:".concat(String.valueOf(str)));
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(ProviderConstants.API_PATH)) {
                TXCLog.e(TXLivePlayer.TAG, "callExperimentalAPI[lack api or illegal type]: ".concat(String.valueOf(str)));
                AppMethodBeat.o(14081);
                return;
            }
            String string = jSONObject.getString(ProviderConstants.API_PATH);
            JSONObject jSONObject2 = null;
            if (jSONObject.has(NativeProtocol.WEB_DIALOG_PARAMS)) {
                jSONObject2 = jSONObject.getJSONObject(NativeProtocol.WEB_DIALOG_PARAMS);
            }
            if (!string.equals("muteRemoteAudioInSpeaker")) {
                TXCLog.e(TXLivePlayer.TAG, "callExperimentalAPI[illegal api]: ".concat(String.valueOf(string)));
                AppMethodBeat.o(14081);
            } else if (jSONObject2 == null) {
                TXCLog.e(TXLivePlayer.TAG, "muteRemoteAudioInSpeaker[lack parameter]");
                AppMethodBeat.o(14081);
            } else if (!jSONObject2.has("enable")) {
                TXCLog.e(TXLivePlayer.TAG, "muteRemoteAudioInSpeaker[lack parameter]: enable");
                AppMethodBeat.o(14081);
            } else {
                int i2 = jSONObject2.getInt("enable");
                if (this.t != null) {
                    n nVar = this.t;
                    if (i2 != 1) {
                        z2 = false;
                    }
                    nVar.c(z2);
                }
                AppMethodBeat.o(14081);
            }
        } catch (Exception e2) {
            TXCLog.e(TXLivePlayer.TAG, "callExperimentalAPI[failed]: ".concat(String.valueOf(str)));
            AppMethodBeat.o(14081);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.rtmp.a$a  reason: collision with other inner class name */
    public class RunnableC2181a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private int f1580b;

        private RunnableC2181a() {
            this.f1580b = 300;
        }

        public void a(int i2) {
            this.f1580b = i2;
        }

        public void run() {
            AppMethodBeat.i(14240);
            if (a.this.t != null && a.this.t.c()) {
                int h2 = a.this.t.h();
                if (a.this.D != null) {
                    a.this.D.onAudioVolumeEvaluationNotify(h2);
                }
            }
            if (a.this.s != null && this.f1580b > 0) {
                a.this.s.postDelayed(a.this.I, (long) this.f1580b);
            }
            AppMethodBeat.o(14240);
        }
    }

    private void f() {
        AppMethodBeat.i(14082);
        if (this.t != null) {
            this.t.a(this.E > 0, this.E);
            if (this.E > 0) {
                if (this.I == null) {
                    this.I = new RunnableC2181a();
                }
                this.I.a(this.E);
                if (this.s != null) {
                    this.s.removeCallbacks(this.I);
                    this.s.postDelayed(this.I, (long) this.E);
                }
            }
        }
        AppMethodBeat.o(14082);
    }

    private void g() {
        AppMethodBeat.i(14083);
        if (this.t != null) {
            this.t.a(false, 0);
        }
        if (this.s != null) {
            this.s.removeCallbacks(this.I);
        }
        this.I = null;
        this.E = 0;
        AppMethodBeat.o(14083);
    }

    public void a(TXRecordCommon.ITXVideoRecordListener iTXVideoRecordListener) {
        AppMethodBeat.i(14084);
        a("[API] setVideoRecordListener", "listener:".concat(String.valueOf(iTXVideoRecordListener)));
        if (this.t != null) {
            this.t.a(iTXVideoRecordListener);
        }
        AppMethodBeat.o(14084);
    }

    public int f(int i2) {
        AppMethodBeat.i(14085);
        a("[API] startRecord", "type:".concat(String.valueOf(i2)));
        if (Build.VERSION.SDK_INT < 18) {
            TXCLog.e(TXLivePlayer.TAG, "API levl is too low (record need 18, current is" + Build.VERSION.SDK_INT + ")");
            AppMethodBeat.o(14085);
            return -3;
        } else if (!a()) {
            TXCLog.e(TXLivePlayer.TAG, "startRecord: there is no playing stream");
            AppMethodBeat.o(14085);
            return -1;
        } else if (this.t != null) {
            int d2 = this.t.d(i2);
            AppMethodBeat.o(14085);
            return d2;
        } else {
            AppMethodBeat.o(14085);
            return -1;
        }
    }

    public int d() {
        AppMethodBeat.i(14086);
        a("[API] stopRecord", "");
        if (this.t != null) {
            int d2 = this.t.d();
            AppMethodBeat.o(14086);
            return d2;
        }
        AppMethodBeat.o(14086);
        return -1;
    }

    public void a(final TXLivePlayer.ITXSnapshotListener iTXSnapshotListener) {
        AppMethodBeat.i(14087);
        a("[API] snapshot", "");
        if (this.w || iTXSnapshotListener == null) {
            AppMethodBeat.o(14087);
            return;
        }
        this.w = true;
        if (this.t != null) {
            this.t.a(new o() {
                /* class com.tencent.rtmp.a.AnonymousClass1 */

                @Override // com.tencent.liteav.basic.c.o
                public void onTakePhotoComplete(Bitmap bitmap) {
                    AppMethodBeat.i(182238);
                    a.a(a.this, iTXSnapshotListener, bitmap);
                    AppMethodBeat.o(182238);
                }
            });
            AppMethodBeat.o(14087);
            return;
        }
        this.w = false;
        AppMethodBeat.o(14087);
    }

    public boolean a(byte[] bArr) {
        AppMethodBeat.i(14088);
        if (this.k == null || this.k.isEmpty()) {
            AppMethodBeat.o(14088);
            return false;
        } else if (this.f1567g) {
            TXLog.e(TXLivePlayer.TAG, "can not addVideoRawData because of hw decode has set!");
            AppMethodBeat.o(14088);
            return false;
        } else if (this.t == null) {
            TXCLog.e(TXLivePlayer.TAG, "player hasn't created or not instanceof live player");
            AppMethodBeat.o(14088);
            return false;
        } else {
            this.o = bArr;
            AppMethodBeat.o(14088);
            return true;
        }
    }

    public int a(TXLivePlayer.ITXLivePlayVideoRenderListener iTXLivePlayVideoRenderListener, Object obj) {
        AppMethodBeat.i(222654);
        a("[API] setVideoRenderListener", "listener:" + iTXLivePlayVideoRenderListener + " context:" + obj);
        if (obj != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                if (!(obj instanceof EGLContext) && !(obj instanceof android.opengl.EGLContext)) {
                    TXCLog.w(TXLivePlayer.TAG, "[API] setVideoRenderListener error when glContext error ".concat(String.valueOf(obj)));
                    AppMethodBeat.o(222654);
                    return -1;
                }
            } else if (!(obj instanceof EGLContext)) {
                TXCLog.w(TXLivePlayer.TAG, "[API] setVideoRenderListener error when glContext error ".concat(String.valueOf(obj)));
                AppMethodBeat.o(222654);
                return -1;
            }
        }
        this.p = obj;
        this.q = iTXLivePlayVideoRenderListener;
        if (this.t != null) {
            if (iTXLivePlayVideoRenderListener != null) {
                this.t.a(new com.tencent.liteav.o() {
                    /* class com.tencent.rtmp.a.AnonymousClass2 */

                    @Override // com.tencent.liteav.o
                    public void onRenderVideoFrame(String str, int i2, TXSVideoFrame tXSVideoFrame) {
                        AppMethodBeat.i(13944);
                        if (tXSVideoFrame == null || tXSVideoFrame.width <= 0 || tXSVideoFrame.height <= 0) {
                            AppMethodBeat.o(13944);
                            return;
                        }
                        TXLivePlayer.ITXLivePlayVideoRenderListener iTXLivePlayVideoRenderListener = a.this.q;
                        if (iTXLivePlayVideoRenderListener != null) {
                            TXLivePlayer.TXLiteAVTexture tXLiteAVTexture = new TXLivePlayer.TXLiteAVTexture();
                            tXLiteAVTexture.textureId = tXSVideoFrame.textureId;
                            tXLiteAVTexture.width = tXSVideoFrame.width;
                            tXLiteAVTexture.height = tXSVideoFrame.height;
                            tXLiteAVTexture.eglContext = tXSVideoFrame.eglContext;
                            iTXLivePlayVideoRenderListener.onRenderVideoFrame(tXLiteAVTexture);
                        }
                        AppMethodBeat.o(13944);
                    }
                }, com.tencent.liteav.basic.a.b.TEXTURE_2D, obj);
            } else {
                this.t.a(null, com.tencent.liteav.basic.a.b.UNKNOWN, null);
            }
        }
        AppMethodBeat.o(222654);
        return 0;
    }

    public void a(TXLivePlayer.ITXVideoRawDataListener iTXVideoRawDataListener) {
        AppMethodBeat.i(14089);
        a("[API] setVideoRawDataListener", "listener:".concat(String.valueOf(iTXVideoRawDataListener)));
        this.n = iTXVideoRawDataListener;
        if (this.t == null) {
            AppMethodBeat.o(14089);
        } else if (iTXVideoRawDataListener != null) {
            this.t.a(new com.tencent.liteav.o() {
                /* class com.tencent.rtmp.a.AnonymousClass3 */

                @Override // com.tencent.liteav.o
                public void onRenderVideoFrame(String str, int i2, TXSVideoFrame tXSVideoFrame) {
                    AppMethodBeat.i(222663);
                    if (tXSVideoFrame == null || tXSVideoFrame.width <= 0 || tXSVideoFrame.height <= 0) {
                        AppMethodBeat.o(222663);
                        return;
                    }
                    byte[] bArr = a.this.o;
                    a.this.o = null;
                    TXLivePlayer.ITXVideoRawDataListener iTXVideoRawDataListener = a.this.n;
                    if (!(iTXVideoRawDataListener == null || bArr == null)) {
                        if (bArr.length >= ((tXSVideoFrame.width * tXSVideoFrame.height) * 3) / 2) {
                            tXSVideoFrame.loadYUVArray(bArr);
                            iTXVideoRawDataListener.onVideoRawDataAvailable(bArr, tXSVideoFrame.width, tXSVideoFrame.height, (int) tXSVideoFrame.pts);
                            tXSVideoFrame.release();
                            AppMethodBeat.o(222663);
                            return;
                        }
                        TXCLog.e(TXLivePlayer.TAG, "raw data buffer length is too large");
                    }
                    AppMethodBeat.o(222663);
                }
            }, com.tencent.liteav.basic.a.b.I420, null);
            AppMethodBeat.o(14089);
        } else {
            this.t.a(null, com.tencent.liteav.basic.a.b.UNKNOWN, null);
            AppMethodBeat.o(14089);
        }
    }

    public void a(TXLivePlayer.ITXAudioRawDataListener iTXAudioRawDataListener) {
        AppMethodBeat.i(14090);
        a("[API] setAudioRawDataListener", "listener:".concat(String.valueOf(iTXAudioRawDataListener)));
        this.J = iTXAudioRawDataListener;
        if (this.t != null) {
            this.t.a(iTXAudioRawDataListener);
        }
        AppMethodBeat.o(14090);
    }

    public int b(String str, int i2) {
        AppMethodBeat.i(14091);
        a("[API] prepareLiveSeek", "domain:" + str + " bizid:" + i2);
        if (this.x == null) {
            this.x = new j();
        }
        if (this.x != null) {
            int a2 = this.x.a(this.k, str, i2, new j.a() {
                /* class com.tencent.rtmp.a.AnonymousClass4 */

                @Override // com.tencent.liteav.j.a
                public void a(long j2) {
                    AppMethodBeat.i(222684);
                    a.this.z = j2;
                    if (a.this.t != null) {
                        a.this.t.f();
                    }
                    AppMethodBeat.o(222684);
                }
            });
            AppMethodBeat.o(14091);
            return a2;
        }
        AppMethodBeat.o(14091);
        return -1;
    }

    public void g(int i2) {
        AppMethodBeat.i(14092);
        a("[API] seek", "time:".concat(String.valueOf(i2)));
        if (this.t != null) {
            if (this.t.e() || this.y) {
                String a2 = this.x != null ? this.x.a((long) i2) : "";
                if (!TextUtils.isEmpty(a2)) {
                    this.y = a(a2, 3) == 0;
                    if (this.y) {
                        this.z = (long) (i2 * 1000);
                        AppMethodBeat.o(14092);
                        return;
                    }
                } else if (this.f1565e != null) {
                    this.f1565e.onPlayEvent(-2301, new Bundle());
                }
                AppMethodBeat.o(14092);
                return;
            }
            this.t.e(i2);
        }
        AppMethodBeat.o(14092);
    }

    public int e() {
        AppMethodBeat.i(14093);
        a("[API] resumeLive", "");
        if (this.y) {
            this.y = false;
            int a2 = a(this.A, 1);
            AppMethodBeat.o(14093);
            return a2;
        }
        AppMethodBeat.o(14093);
        return -1;
    }

    @Deprecated
    public void d(boolean z2) {
        AppMethodBeat.i(14094);
        TXCLog.i(TXLivePlayer.TAG, "[API] setAutoPlay ".concat(String.valueOf(z2)));
        this.u = z2;
        AppMethodBeat.o(14094);
    }

    @Deprecated
    public void a(float f2) {
        AppMethodBeat.i(14095);
        TXCLog.i(TXLivePlayer.TAG, "[API] setRate ".concat(String.valueOf(f2)));
        this.v = f2;
        if (this.t != null) {
            this.t.a(f2);
        }
        AppMethodBeat.o(14095);
    }

    @Override // com.tencent.liteav.basic.b.b
    public void onNotifyEvent(int i2, Bundle bundle) {
        AppMethodBeat.i(14096);
        a(i2, bundle);
        if (i2 == 15001) {
            if (this.f1561a != null) {
                this.f1561a.setLogText(bundle, null, 0);
            }
            if (this.f1565e != null) {
                this.f1565e.onNetStatus(bundle);
                AppMethodBeat.o(14096);
                return;
            }
        } else if (i2 == 2005) {
            long j2 = ((long) bundle.getInt(TXLiveConstants.EVT_PLAY_PROGRESS_MS)) + this.z;
            if (j2 > 0) {
                bundle.putInt(TXLiveConstants.EVT_PLAY_PROGRESS, (int) (j2 / 1000));
                bundle.putInt(TXLiveConstants.EVT_PLAY_PROGRESS_MS, (int) j2);
                if (this.f1565e != null) {
                    this.f1565e.onPlayEvent(i2, bundle);
                }
            }
            AppMethodBeat.o(14096);
            return;
        } else if (i2 != 2026) {
            long currentTimeMillis = System.currentTimeMillis();
            if (i2 == 2101) {
                if (currentTimeMillis - this.C < 5000) {
                    AppMethodBeat.o(14096);
                    return;
                }
                this.C = currentTimeMillis;
            }
            if (!(i2 == 2005 || i2 == 2012 || this.k == null || this.k.length() <= 0)) {
                a("onNotifyEvent", "event:" + i2 + " msg:" + bundle.getString(TXLiveConstants.EVT_DESCRIPTION));
            }
            switch (i2) {
                case TXLiteAVCode.ERR_RTMP_ACC_FETCH_STREAM_FAIL:
                    i2 = -2301;
                    break;
                case -2307:
                    i2 = -2307;
                    break;
                case -2304:
                    i2 = -2304;
                    break;
                case -2302:
                    i2 = -2302;
                    break;
                case -2301:
                    i2 = -2301;
                    break;
                case 2001:
                    i2 = 2001;
                    break;
                case 2002:
                    i2 = 2002;
                    break;
                case 2003:
                case 2105:
                    break;
                case 2004:
                    i2 = 2004;
                    break;
                case 2005:
                    i2 = 2005;
                    break;
                case 2007:
                    i2 = 2007;
                    break;
                case 2008:
                case TXLiteAVCode.EVT_HW_DECODER_START_SUCC:
                case TXLiteAVCode.EVT_SW_DECODER_START_SUCC:
                    i2 = 2008;
                    break;
                case 2009:
                    i2 = 2009;
                    break;
                case 2012:
                    i2 = 2012;
                    break;
                case 2013:
                    i2 = 2013;
                    break;
                case 2015:
                    i2 = 2015;
                    break;
                case 2028:
                    i2 = 2028;
                    break;
                case 2031:
                    i2 = 2031;
                    break;
                case 2101:
                    i2 = 2101;
                    break;
                case 2103:
                    i2 = 2103;
                    break;
                case 2106:
                    i2 = 2106;
                    break;
                case TXLiteAVCode.WARNING_SW_DECODER_START_FAIL:
                    AppMethodBeat.o(14096);
                    return;
                case 3003:
                    i2 = 3003;
                    break;
                case 3006:
                case TXLiteAVCode.WARNING_RTMP_READ_FAIL:
                    i2 = 3005;
                    break;
                case TXLiteAVCode.WARNING_PLAY_LIVE_STREAM_INFO_CONNECT_FAIL:
                    i2 = 3002;
                    break;
                case TXLiteAVCode.WARNING_NO_STEAM_SOURCE_FAIL:
                    i2 = 3002;
                    break;
                default:
                    AppMethodBeat.o(14096);
                    return;
            }
            if (this.f1561a != null) {
                this.f1561a.setLogText(null, bundle, i2);
            }
            if (this.f1565e != null) {
                this.f1565e.onPlayEvent(i2, bundle);
            }
        }
        AppMethodBeat.o(14096);
    }

    private void a(int i2, Bundle bundle) {
        AppMethodBeat.i(259972);
        if (i2 != 15001 || bundle == null) {
            if (i2 == 2007 || i2 == 2105) {
                TXCLog.i(TXLivePlayer.TAG, "[Event]code:" + i2 + " param:" + bundle);
                h();
            }
            AppMethodBeat.o(259972);
            return;
        }
        String str = this.k;
        if (str == null) {
            AppMethodBeat.o(259972);
            return;
        }
        boolean startsWith = str.startsWith("room://");
        this.G = a(bundle);
        int i3 = bundle.getInt(TXLiveConstants.NET_STATUS_AUDIO_CACHE, 0);
        int i4 = bundle.getInt(TXLiveConstants.NET_STATUS_NET_SPEED, 0);
        int i5 = bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_FPS, 0);
        int i6 = bundle.getInt(TXLiveConstants.NET_STATUS_AV_RECV_INTERVAL);
        int i7 = bundle.getInt(TXLiveConstants.NET_STATUS_AV_PLAY_INTERVAL);
        if ((!startsWith && this.H > i3) || i4 < 10 || ((i5 != 0 && i5 < 5) || Math.abs(i6) > 5000 || Math.abs(i7) > 5000)) {
            h();
        }
        AppMethodBeat.o(259972);
    }

    private void h() {
        AppMethodBeat.i(259973);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.F > 3000) {
            this.F = currentTimeMillis;
            a("[Statistics] logStatisticsStr", "statistics:" + this.G);
        }
        AppMethodBeat.o(259973);
    }

    private String a(Bundle bundle) {
        AppMethodBeat.i(259974);
        String str = " IP:" + bundle.getString(TXLiveConstants.NET_STATUS_SERVER_IP) + " RES:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_WIDTH) + "*" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_HEIGHT) + " FPS:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_FPS) + " GOP:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_GOP) + "s Speed:" + bundle.getInt(TXLiveConstants.NET_STATUS_NET_SPEED) + "Kbps AudioSpeed:" + bundle.getInt(TXLiveConstants.NET_STATUS_AUDIO_BITRATE) + "Kbps VideoSpeed:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_BITRATE) + "Kbps AudioCache:" + bundle.getInt(TXLiveConstants.NET_STATUS_AUDIO_CACHE) + " VideoCache:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_CACHE) + " VideoCacheFrameCount:" + bundle.getInt(TXLiveConstants.NET_STATUS_V_SUM_CACHE_SIZE) + " VideoDecoderCacheFrameCount:" + bundle.getInt(TXLiveConstants.NET_STATUS_V_DEC_CACHE_SIZE) + " AVJitterSync:" + bundle.getInt(TXLiveConstants.NET_STATUS_AV_RECV_INTERVAL) + " AVPlaySync:" + bundle.getInt(TXLiveConstants.NET_STATUS_AV_PLAY_INTERVAL) + " AudioParamsInfo:" + bundle.getString(TXLiveConstants.NET_STATUS_AUDIO_INFO);
        AppMethodBeat.o(259974);
        return str;
    }

    private boolean i() {
        AppMethodBeat.i(259975);
        if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI") || !Build.MODEL.equalsIgnoreCase("Che2-TL00")) {
            AppMethodBeat.o(259975);
            return false;
        }
        AppMethodBeat.o(259975);
        return true;
    }

    private String c(String str, int i2) {
        AppMethodBeat.i(14098);
        if (i2 != 6) {
            try {
                byte[] bytes = str.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                StringBuilder sb = new StringBuilder(bytes.length);
                for (int i3 = 0; i3 < bytes.length; i3++) {
                    int i4 = bytes[i3] < 0 ? bytes[i3] + 256 : bytes[i3];
                    if (i4 <= 32 || i4 >= 127 || i4 == 34 || i4 == 37 || i4 == 60 || i4 == 62 || i4 == 91 || i4 == 125 || i4 == 92 || i4 == 93 || i4 == 94 || i4 == 96 || i4 == 123 || i4 == 124) {
                        sb.append(String.format("%%%02X", Integer.valueOf(i4 == 1 ? 1 : 0)));
                    } else {
                        sb.append((char) i4);
                    }
                }
                str = sb.toString();
            } catch (Exception e2) {
                TXCLog.e(TXLivePlayer.TAG, "check play url failed.", e2);
            }
        }
        String trim = str.trim();
        AppMethodBeat.o(14098);
        return trim;
    }

    private void a(final TXLivePlayer.ITXSnapshotListener iTXSnapshotListener, final Bitmap bitmap) {
        AppMethodBeat.i(14099);
        if (iTXSnapshotListener == null) {
            AppMethodBeat.o(14099);
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class com.tencent.rtmp.a.AnonymousClass5 */

            public void run() {
                AppMethodBeat.i(222657);
                if (iTXSnapshotListener != null) {
                    iTXSnapshotListener.onSnapshot(bitmap);
                }
                a.this.w = false;
                AppMethodBeat.o(222657);
            }
        });
        AppMethodBeat.o(14099);
    }
}
