package com.tencent.luggage.xweb_ext.extendplugin.component.video;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.tencent.f.h;
import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.g;
import com.tencent.luggage.xweb_ext.extendplugin.component.i;
import com.tencent.luggage.xweb_ext.extendplugin.component.j;
import com.tencent.luggage.xweb_ext.extendplugin.component.r;
import com.tencent.luggage.xweb_ext.extendplugin.component.s;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.d;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.e;
import com.tencent.luggage.xweb_ext.extendplugin.component.video.b.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.e.c;
import com.tencent.mm.plugin.appbrand.jsapi.x;
import com.tencent.mm.plugin.appbrand.jsapi.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tav.core.AssetExtension;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import org.json.JSONObject;

public final class c extends com.tencent.luggage.xweb_ext.extendplugin.a.a implements i {
    private z cDL = new z() {
        /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.c.AnonymousClass36 */
        private x cJL = new com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.c();

        {
            AppMethodBeat.i(215700);
            AppMethodBeat.o(215700);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.z
        public final x PW() {
            return this.cJL;
        }
    };
    public com.tencent.luggage.xweb_ext.extendplugin.a cED;
    a.AbstractC0188a cEE;
    public int cEF;
    public int cEG;
    public int cEH = 0;
    public int cEI = 0;
    boolean cEJ;
    boolean cEK;
    boolean cEL;
    final com.tencent.mm.plugin.appbrand.jsapi.video.a.a cEM = new com.tencent.mm.plugin.appbrand.jsapi.video.a.a();
    com.tencent.mm.plugin.appbrand.jsapi.u.c cEN = null;
    String cEO = null;
    boolean cER = false;
    AtomicBoolean cET = null;
    com.tencent.luggage.xweb_ext.extendplugin.component.a cEU = new com.tencent.luggage.xweb_ext.extendplugin.component.a(this, this.cDL) {
        /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.c.AnonymousClass37 */

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.a
        public final void a(String str, com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
            AppMethodBeat.i(215701);
            a(aVar);
            JSONObject Ps = aVar.Ps();
            if (str.contains("insert") || str.contains("update")) {
                if (Ps.has("autoplay")) {
                    this.cDM = Ps.optBoolean("autoplay");
                }
                Boolean K = ac.K(Ps);
                if (K != null) {
                    this.cDN = K.booleanValue();
                }
            } else if (str.contains("operate")) {
                String optString = Ps.optString("type");
                if (!Util.isNullOrNil(optString) && optString.equalsIgnoreCase(AssetExtension.SCENE_PLAY)) {
                    this.cDM = true;
                }
            } else if (str.contains("remove")) {
                this.cDM = false;
            }
            Log.d(c.this.getLogTag(), "mAutoRotationPluginHandlerCommons.handleJsApi, mIsNeedNotify: " + this.cDM + ", mIsAutoRotationEnabled: " + this.cDN);
            AppMethodBeat.o(215701);
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.a
        public final boolean Pv() {
            return !c.this.cJs;
        }
    };
    com.tencent.luggage.xweb_ext.extendplugin.component.b<e> cEV = new com.tencent.luggage.xweb_ext.extendplugin.component.b<e>() {
        /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.c.AnonymousClass38 */
        private e cJM = null;

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.b
        public final String getLogTag() {
            AppMethodBeat.i(215702);
            String logTag = c.this.getLogTag();
            AppMethodBeat.o(215702);
            return logTag;
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.b
        public final int getId() {
            AppMethodBeat.i(215703);
            int id = c.this.getId();
            AppMethodBeat.o(215703);
            return id;
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.b
        public final String getKey() {
            AppMethodBeat.i(215704);
            String key = c.this.getKey();
            AppMethodBeat.o(215704);
            return key;
        }

        /* Return type fixed from 'com.tencent.luggage.xweb_ext.extendplugin.component.c' to match base method */
        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.b
        public final /* synthetic */ e Pw() {
            AppMethodBeat.i(215705);
            if (this.cJM == null) {
                this.cJM = new e(c.this);
            }
            e eVar = this.cJM;
            AppMethodBeat.o(215705);
            return eVar;
        }
    };
    public s cEX = null;
    boolean cFb = false;
    public boolean cFc = false;
    private i cFd = new r();
    public AtomicBoolean cFe = new AtomicBoolean(false);
    volatile String cFf = null;
    volatile g cFg = null;
    volatile Bitmap cFh = null;
    public com.tencent.mm.plugin.appbrand.jsapi.video.e.c cIV;
    public d cIW;
    public com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a cIX;
    public com.tencent.luggage.xweb_ext.extendplugin.component.video.b.c cIY;
    public e cIZ;
    private boolean cJA = false;
    public b cJB = null;
    public a cJC = null;
    public float cJD = 1.0f;
    public float cJE = 1.0f;
    public f cJa;
    public com.tencent.luggage.xweb_ext.extendplugin.component.video.b.b cJb;
    volatile com.tencent.mm.plugin.appbrand.jsapi.ag.e.b cJc;
    boolean cJd;
    boolean cJe;
    boolean cJf;
    boolean cJg;
    long cJh;
    boolean cJi;
    public boolean cJj;
    volatile boolean cJk;
    boolean cJl = false;
    boolean cJm = false;
    int cJn;
    int cJo;
    String cJp;
    String cJq;
    boolean cJr;
    boolean cJs;
    private boolean cJt = false;
    private final ConcurrentLinkedQueue<Runnable> cJu = new ConcurrentLinkedQueue<>();
    Handler cJv;
    private HandlerThread cJw = com.tencent.f.c.d.hA(String.format("VideoThread_%s", Long.valueOf(System.currentTimeMillis())), 5);
    volatile com.tencent.luggage.xweb_ext.extendplugin.a cJx = null;
    Surface cJy = null;
    public a cJz = null;
    public Surface mSurface;
    public SurfaceTexture mSurfaceTexture;
    volatile String mTitle = null;
    int mVideoHeight;
    int mVideoWidth;

    public interface a {
        void a(boolean z, float f2, float f3);
    }

    public interface b {
        void cf(boolean z);
    }

    public final boolean Qo() {
        AppMethodBeat.i(177165);
        if (this.cET == null || !this.cET.get()) {
            AppMethodBeat.o(177165);
            return false;
        }
        AppMethodBeat.o(177165);
        return true;
    }

    public c() {
        AppMethodBeat.i(138972);
        this.cJw.start();
        this.cJv = new Handler(this.cJw.getLooper());
        AppMethodBeat.o(138972);
    }

    public final String getLogTag() {
        AppMethodBeat.i(138973);
        String format = String.format("%s(%s)", "MicroMsg.SameLayer.VideoPluginHandler", Lb());
        AppMethodBeat.o(138973);
        return format;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        return true;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final void e(final SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(138974);
        k(new Runnable() {
            /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.c.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(138945);
                c.a(c.this, surfaceTexture);
                AppMethodBeat.o(138945);
            }
        });
        AppMethodBeat.o(138974);
    }

    private void Qp() {
        AppMethodBeat.i(138975);
        synchronized (this.cJu) {
            try {
                if (!this.cJu.isEmpty()) {
                    Log.i(getLogTag(), "flushPendingTasks, size:%d", Integer.valueOf(this.cJu.size()));
                    Iterator<Runnable> it = this.cJu.iterator();
                    while (it.hasNext()) {
                        it.next().run();
                    }
                    this.cJu.clear();
                }
            } finally {
                AppMethodBeat.o(138975);
            }
        }
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final void PQ() {
        AppMethodBeat.i(138976);
        k(new Runnable() {
            /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.c.AnonymousClass23 */

            public final void run() {
                AppMethodBeat.i(138965);
                c.a(c.this);
                AppMethodBeat.o(138965);
            }
        });
        AppMethodBeat.o(138976);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final void s(Bitmap bitmap) {
        Bitmap bitmap2;
        boolean z;
        AppMethodBeat.i(178848);
        super.s(bitmap);
        Log.i(getLogTag(), "*** handler(%s) handlePluginScreenshotTaken", Lb());
        com.tencent.luggage.xweb_ext.extendplugin.a aVar = this.cJx;
        if (aVar == null) {
            Log.w(getLogTag(), "handlePluginScreenshotTaken4JsApiCall, invokeContext is null");
            z = false;
        } else if (bitmap == null) {
            Log.w(getLogTag(), "handlePluginScreenshotTaken4JsApiCall, bitmap is null");
            z = false;
        } else {
            if (this.cEF == 0 || this.cEG == 0) {
                bitmap2 = bitmap;
            } else {
                bitmap2 = Bitmap.createScaledBitmap(bitmap, (int) (this.cJD * ((float) this.cEF)), (int) (this.cJE * ((float) this.cEG)), false);
            }
            this.cJb.a(aVar, bitmap2);
            this.cJx = null;
            z = true;
        }
        if (!z) {
            g gVar = this.cFg;
            if (gVar == null) {
                Log.w(getLogTag(), "handlePluginScreenshotTaken4NativeCall, getSnapshotCallback is null");
                AppMethodBeat.o(178848);
                return;
            } else if (bitmap == null) {
                Log.w(getLogTag(), "handlePluginScreenshotTaken4NativeCall, bitmap is null");
                gVar.p(null);
                AppMethodBeat.o(178848);
                return;
            } else {
                if (!(this.cEF == 0 || this.cEG == 0)) {
                    bitmap = Bitmap.createScaledBitmap(bitmap, (int) (this.cJD * ((float) this.cEF)), (int) (this.cJE * ((float) this.cEG)), false);
                }
                gVar.p(bitmap);
                this.cFg = null;
            }
        }
        AppMethodBeat.o(178848);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.a.b, com.tencent.luggage.xweb_ext.extendplugin.a.a
    public final String h(final com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        AppMethodBeat.i(138977);
        k(new Runnable() {
            /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.c.AnonymousClass34 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARNING: Removed duplicated region for block: B:100:0x0382  */
            /* JADX WARNING: Removed duplicated region for block: B:111:0x03bd  */
            /* JADX WARNING: Removed duplicated region for block: B:114:0x03d1  */
            /* JADX WARNING: Removed duplicated region for block: B:117:0x03e5  */
            /* JADX WARNING: Removed duplicated region for block: B:124:0x0410  */
            /* JADX WARNING: Removed duplicated region for block: B:127:0x0419  */
            /* JADX WARNING: Removed duplicated region for block: B:133:0x0437  */
            /* JADX WARNING: Removed duplicated region for block: B:143:0x0490  */
            /* JADX WARNING: Removed duplicated region for block: B:151:0x04b4  */
            /* JADX WARNING: Removed duplicated region for block: B:158:0x0504  */
            /* JADX WARNING: Removed duplicated region for block: B:165:0x0551  */
            /* JADX WARNING: Removed duplicated region for block: B:169:0x0586  */
            /* JADX WARNING: Removed duplicated region for block: B:175:0x05a1  */
            /* JADX WARNING: Removed duplicated region for block: B:91:0x033f  */
            /* JADX WARNING: Removed duplicated region for block: B:94:0x0353  */
            /* JADX WARNING: Removed duplicated region for block: B:97:0x036e  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                // Method dump skipped, instructions count: 2740
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.luggage.xweb_ext.extendplugin.component.video.c.AnonymousClass34.run():void");
            }
        });
        AppMethodBeat.o(138977);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void p(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        AppMethodBeat.i(138978);
        if (this.cJc != null) {
            AppMethodBeat.o(138978);
            return;
        }
        this.cJc = this.cJb.a(this.cIX, aVar);
        AppMethodBeat.o(138978);
    }

    /* access modifiers changed from: package-private */
    public final void Qq() {
        AppMethodBeat.i(138979);
        if (this.cIV == null || this.mSurfaceTexture == null) {
            Log.w(getLogTag(), "VideoCanvas, registerMediaPlayer, media player or surface texture is null");
            AppMethodBeat.o(138979);
            return;
        }
        int videoWidth = this.cIV.getVideoWidth();
        int videoHeight = this.cIV.getVideoHeight();
        if (videoWidth == 0 && videoHeight == 0) {
            Log.w(getLogTag(), "VideoCanvas, registerMediaPlayer, width or height is 0");
            AppMethodBeat.o(138979);
        } else if (!this.cJt) {
            this.cJt = true;
            com.tencent.mm.plugin.appbrand.i.a.bCz().a(getId(), this, this.mSurfaceTexture, videoWidth, videoHeight, this.cED.getAppId());
            AppMethodBeat.o(138979);
        } else {
            Log.w(getLogTag(), "VideoCanvas, registerMediaPlayer, already registered");
            AppMethodBeat.o(138979);
        }
    }

    public final boolean k(Runnable runnable) {
        AppMethodBeat.i(138980);
        if (this.cJv != null) {
            if (this.cJv.getLooper() == Looper.myLooper()) {
                runnable.run();
            } else {
                this.cJv.post(runnable);
            }
            AppMethodBeat.o(138980);
            return true;
        }
        AppMethodBeat.o(138980);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean ca(final int i2, final int i3) {
        AppMethodBeat.i(215716);
        boolean k = k(new Runnable() {
            /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.c.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(138948);
                c cVar = c.this;
                int i2 = i2;
                int i3 = i3;
                if (!cVar.cJk) {
                    Log.i(cVar.getLogTag(), "onMediaPlayerError, mp released");
                    AppMethodBeat.o(138948);
                    return;
                }
                Log.i(cVar.getLogTag(), "onError, what:%d, extra:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                if (cVar.cIY != null) {
                    cVar.cIY.cd(i2, i3);
                }
                AppMethodBeat.o(138948);
            }
        });
        AppMethodBeat.o(215716);
        return k;
    }

    /* access modifiers changed from: package-private */
    public final boolean Qr() {
        com.tencent.mm.plugin.appbrand.page.ac acVar;
        AppMethodBeat.i(178849);
        if (this.cED instanceof com.tencent.mm.plugin.appbrand.h.b) {
            com.tencent.mm.plugin.appbrand.jsapi.f NN = this.cED.NN();
            if (NN instanceof com.tencent.mm.plugin.appbrand.page.ac) {
                acVar = (com.tencent.mm.plugin.appbrand.page.ac) NN;
            } else if (NN instanceof com.tencent.mm.plugin.appbrand.s) {
                acVar = ((com.tencent.mm.plugin.appbrand.s) NN).getCurrentPageView();
            } else {
                acVar = null;
            }
            if (acVar != null) {
                AppBrandRuntime runtime = acVar.getRuntime();
                Log.i(getLogTag(), "cancelResumePlayingWhenRelaunch:%s", Boolean.valueOf(runtime.kAK));
                boolean z = runtime.kAK;
                AppMethodBeat.o(178849);
                return z;
            }
        }
        AppMethodBeat.o(178849);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void c(com.tencent.luggage.xweb_ext.extendplugin.a aVar, JSONObject jSONObject) {
        AppMethodBeat.i(138981);
        if (!jSONObject.has("enableCasting")) {
            AppMethodBeat.o(138981);
            return;
        }
        boolean optBoolean = jSONObject.optBoolean("enableCasting");
        Log.d(getLogTag(), "isEnableVideoCast = ".concat(String.valueOf(optBoolean)));
        p(aVar);
        this.cJc.mKL = optBoolean;
        AppMethodBeat.o(138981);
    }

    /* access modifiers changed from: package-private */
    public final String b(com.tencent.luggage.xweb_ext.extendplugin.a aVar, String str) {
        AppMethodBeat.i(138982);
        if (this.cJb != null) {
            str = this.cJb.b(aVar, str);
        }
        AppMethodBeat.o(138982);
        return str;
    }

    /* access modifiers changed from: package-private */
    public final void cd(boolean z) {
        AppMethodBeat.i(215717);
        if (Util.isNullOrNil(this.cJq)) {
            Log.i(getLogTag(), "adjust objectFit, no video objectFit");
            AppMethodBeat.o(215717);
        } else if (QJ() == null || this.cJa == null) {
            Log.i(getLogTag(), "adjust objectFit, video not prepared");
            AppMethodBeat.o(215717);
        } else {
            float f2 = this.cJD;
            float f3 = this.cJE;
            if (this.cJa.a(this.cJq, this.cEF, this.cEG, this.mVideoWidth, this.mVideoHeight)) {
                this.cJD = this.cJa.QH();
                this.cJE = this.cJa.QI();
                Log.i(getLogTag(), "adjust objectFit:%s, scale:[%s, %s]", this.cJq, Float.valueOf(this.cJD), Float.valueOf(this.cJE));
                if (!this.cJs || this.cJy == null) {
                    com.tencent.luggage.xweb_ext.extendplugin.d.a(QJ(), this.type, getId(), this.cJD, this.cJE);
                    this.cJA = false;
                } else {
                    this.cJA = true;
                    Log.i(getLogTag(), "adjust objectFit, TextureScale sticky");
                }
                if (!((this.cJD == f2 && this.cJE == f3) || this.cJz == null)) {
                    this.cJz.a(z, this.cJD, this.cJE);
                }
            }
            AppMethodBeat.o(215717);
        }
    }

    /* access modifiers changed from: package-private */
    public final void ce(boolean z) {
        AppMethodBeat.i(215718);
        if (this.cIV != null) {
            Log.i(getLogTag(), "video prepare async");
            if (z && PS()) {
                this.cIW.onVideoWaiting();
            }
            this.cJj = false;
            this.cJg = false;
            if (this.cJb != null) {
                this.cJb.c(this.cIV);
            }
            this.cIV.prepareAsync();
        }
        AppMethodBeat.o(215718);
    }

    public final void PU() {
        AppMethodBeat.i(215719);
        k(new Runnable() {
            /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.c.AnonymousClass20 */

            public final void run() {
                AppMethodBeat.i(215686);
                if (c.this.cIV != null && !c.this.cIV.isPlaying()) {
                    c.this.i(false, true);
                }
                AppMethodBeat.o(215686);
            }
        });
        AppMethodBeat.o(215719);
    }

    /* access modifiers changed from: package-private */
    public final boolean i(boolean z, boolean z2) {
        AppMethodBeat.i(177166);
        if (this.cIV == null) {
            AppMethodBeat.o(177166);
            return false;
        } else if (this.cJj && this.cIV.isPlaying()) {
            Log.i(getLogTag(), "video play, video is playing");
            if (PS()) {
                this.cIW.ci(z);
            }
            AppMethodBeat.o(177166);
            return true;
        } else if (this.cIV != null && !this.cJj) {
            Log.i(getLogTag(), "video play, video not prepared yet, start until prepared");
            this.cJg = true;
            AppMethodBeat.o(177166);
            return true;
        } else if (this.cIV == null || this.cIV.getState() != 5) {
            if (!this.cJr) {
                Log.i(getLogTag(), "video play");
                if (this.cIV != null) {
                    if (PS()) {
                        this.cIW.ci(z);
                    }
                    Log.i(getLogTag(), "applyPluginTextureScaleIfNeed");
                    if (!this.cJA) {
                        Log.i(getLogTag(), "applyPluginTextureScaleIfNeed, TextureScale is not sticky");
                    } else if (!this.cJs || this.cJy == null) {
                        com.tencent.luggage.xweb_ext.extendplugin.d.a(QJ(), this.type, getId(), this.cJD, this.cJE);
                    } else {
                        Log.i(getLogTag(), "applyPluginTextureScaleIfNeed, in PIP mode");
                    }
                    Log.d(getLogTag(), "video play, mWebViewInBackground: %b, isRuntimeInBackground: %b", Boolean.valueOf(this.cJs), Boolean.valueOf(this.cER));
                    if (!this.cJs && !this.cER && !this.cJm) {
                        h.RTc.aV(new Runnable() {
                            /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.c.AnonymousClass21 */

                            public final void run() {
                                AppMethodBeat.i(215687);
                                Log.i(c.this.getLogTag(), "video play, requestFocus");
                                c.this.cEM.bJI();
                                AppMethodBeat.o(215687);
                            }
                        });
                    }
                    this.cIV.start();
                }
                AppMethodBeat.o(177166);
                return true;
            } else if (!z2) {
                Log.i(getLogTag(), "video has ended playing, do not restart");
                AppMethodBeat.o(177166);
                return false;
            } else {
                Log.i(getLogTag(), "video play, video has ended playing, clear surface and start again");
                this.cJr = false;
                try {
                    if (this.mSurfaceTexture != null && this.cJj) {
                        Log.i(getLogTag(), "clearSurfaceTexture");
                        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
                        EGL10 egl10 = (EGL10) EGLContext.getEGL();
                        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                        egl10.eglInitialize(eglGetDisplay, null);
                        EGLConfig[] eGLConfigArr = new EGLConfig[1];
                        egl10.eglChooseConfig(eglGetDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344}, eGLConfigArr, 1, new int[1]);
                        EGLConfig eGLConfig = eGLConfigArr[0];
                        EGLContext eglCreateContext = egl10.eglCreateContext(eglGetDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                        EGLSurface eglCreateWindowSurface = egl10.eglCreateWindowSurface(eglGetDisplay, eGLConfig, surfaceTexture, new int[]{12344});
                        egl10.eglMakeCurrent(eglGetDisplay, eglCreateWindowSurface, eglCreateWindowSurface, eglCreateContext);
                        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                        GLES20.glClear(16384);
                        egl10.eglSwapBuffers(eglGetDisplay, eglCreateWindowSurface);
                        egl10.eglDestroySurface(eglGetDisplay, eglCreateWindowSurface);
                        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
                        egl10.eglMakeCurrent(eglGetDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
                        egl10.eglDestroyContext(eglGetDisplay, eglCreateContext);
                        egl10.eglTerminate(eglGetDisplay);
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace(getLogTag(), e2, "clearSurfaceTexture error", new Object[0]);
                }
                q(this.cED);
                if (this.cIV != null) {
                    this.cJi = true;
                    String b2 = b(this.cED, this.cJp);
                    if (!Util.isNullOrNil(b2)) {
                        Qv();
                        this.cIV.dU(b2, this.cEO);
                        dT(b2);
                    } else {
                        Qv();
                        this.cIV.dU(this.cJp, this.cEO);
                        dT(this.cJp);
                    }
                    Log.i(getLogTag(), "video play, media player state:%s", Integer.valueOf(this.cIV.getState()));
                    ce(false);
                    this.cJg = true;
                }
                AppMethodBeat.o(177166);
                return true;
            }
        } else if (!z2) {
            Log.i(getLogTag(), "video has ended playing, do not restart");
            AppMethodBeat.o(177166);
            return false;
        } else {
            Log.i(getLogTag(), "video play, video has stopped now, try prepare and start when prepared");
            ce(true);
            this.cJg = true;
            AppMethodBeat.o(177166);
            return true;
        }
    }

    public final void Qs() {
        AppMethodBeat.i(215720);
        k(new Runnable() {
            /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.c.AnonymousClass22 */

            public final void run() {
                AppMethodBeat.i(215688);
                c.this.pause();
                AppMethodBeat.o(215688);
            }
        });
        AppMethodBeat.o(215720);
    }

    /* access modifiers changed from: package-private */
    public final boolean pause() {
        AppMethodBeat.i(138986);
        if (this.cIV == null) {
            AppMethodBeat.o(138986);
            return false;
        } else if (!this.cJj) {
            Log.i(getLogTag(), "video pause, video not prepared yet, pause video when prepared");
            this.cJg = false;
            AppMethodBeat.o(138986);
            return true;
        } else if (!this.cIV.isPlaying()) {
            Log.i(getLogTag(), "video pause, video is not playing");
            AppMethodBeat.o(138986);
            return true;
        } else {
            Log.i(getLogTag(), "video pause");
            Log.d(getLogTag(), "video pause, mWebViewInBackground: %b, isRuntimeInBackground: %b", Boolean.valueOf(this.cJs), Boolean.valueOf(this.cER));
            h.RTc.aV(new Runnable() {
                /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.c.AnonymousClass24 */

                public final void run() {
                    AppMethodBeat.i(215689);
                    Log.i(c.this.getLogTag(), "video pause, abandonFocus");
                    c.this.cEM.bJJ();
                    AppMethodBeat.o(215689);
                }
            });
            this.cIV.pause();
            if (PS()) {
                this.cIW.cj(false);
            }
            AppMethodBeat.o(138986);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean Qt() {
        AppMethodBeat.i(138987);
        if (this.cIV != null) {
            if (this.cJb != null) {
                this.cJb.a(this.cED, this.cIV);
            }
            if (!this.cJj) {
                Log.i(getLogTag(), "video stop, video not prepared yet, stop video when prepared");
                this.cJg = false;
                AppMethodBeat.o(138987);
                return true;
            }
            Log.i(getLogTag(), "video stop");
            Log.d(getLogTag(), "video stop, mWebViewInBackground: %b, isRuntimeInBackground: %b", Boolean.valueOf(this.cJs), Boolean.valueOf(this.cER));
            h.RTc.aV(new Runnable() {
                /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.c.AnonymousClass25 */

                {
                    AppMethodBeat.i(178842);
                    AppMethodBeat.o(178842);
                }

                public final void run() {
                    AppMethodBeat.i(215690);
                    Log.i(c.this.getLogTag(), "video stop, abandonFocus");
                    c.this.cEM.bJJ();
                    AppMethodBeat.o(215690);
                }
            });
            this.cIV.stop();
            if (PS()) {
                this.cIW.cj(true);
            }
            AppMethodBeat.o(138987);
            return true;
        }
        AppMethodBeat.o(138987);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void release() {
        AppMethodBeat.i(215721);
        Log.i(getLogTag(), "video release");
        if (this.cJb != null) {
            this.cJb.w(this.cED);
        }
        Qt();
        Qv();
        Qu();
        if (this.cIW != null) {
            this.cIW.destroy();
            this.cIW = null;
            this.cIX = null;
        }
        if (this.cJc != null) {
            com.tencent.mm.plugin.appbrand.jsapi.ag.e.b bVar = this.cJc;
            bVar.bMi().destroy();
            bVar.mKM = false;
            bVar.hV(false);
            bVar.bMi().bMr();
            this.cJc = null;
        }
        Qx();
        if (this.cED != null) {
            this.cED.Pu();
            this.cEE = null;
        }
        Log.i(getLogTag(), "video release handler thread");
        if (this.cJv != null) {
            this.cJv.removeCallbacksAndMessages(null);
        }
        if (this.cJw != null) {
            this.cJw.quitSafely();
        }
        AppMethodBeat.o(215721);
    }

    /* access modifiers changed from: package-private */
    public final boolean isPlaying() {
        AppMethodBeat.i(138989);
        if (this.cIV != null) {
            boolean isPlaying = this.cIV.isPlaying();
            AppMethodBeat.o(138989);
            return isPlaying;
        }
        AppMethodBeat.o(138989);
        return false;
    }

    public final int getCurrentPosition() {
        AppMethodBeat.i(138990);
        if (this.cIV != null) {
            int currentPosition = this.cIV.getCurrentPosition();
            AppMethodBeat.o(138990);
            return currentPosition;
        }
        AppMethodBeat.o(138990);
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final int getDuration() {
        AppMethodBeat.i(138991);
        if (this.cIV != null) {
            int duration = this.cIV.getDuration();
            AppMethodBeat.o(138991);
            return duration;
        }
        AppMethodBeat.o(138991);
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final void seek(long j2) {
        AppMethodBeat.i(138992);
        if (!this.cJj || this.cIV == null) {
            this.cJh = j2;
        } else {
            if (PS()) {
                this.cIW.onVideoWaiting();
            }
            if (this.cIV != null) {
                this.cJe = isPlaying();
                long min = Math.min((long) getDuration(), Math.max(0L, j2));
                Log.i(getLogTag(), "seek, position:%s, isPlaying:%s, videoEndPlaying:%s", Long.valueOf(min), Boolean.valueOf(this.cJe), Boolean.valueOf(this.cJr));
                this.cJr = false;
                this.cIV.seekTo(min);
                AppMethodBeat.o(138992);
                return;
            }
        }
        AppMethodBeat.o(138992);
    }

    /* access modifiers changed from: package-private */
    public final boolean j(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        AppMethodBeat.i(138993);
        Log.i(getLogTag(), "requestFullscreen");
        if (this.cJb == null || !this.cJb.j(aVar)) {
            AppMethodBeat.o(138993);
            return false;
        }
        AppMethodBeat.o(138993);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean k(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        AppMethodBeat.i(138994);
        Log.i(getLogTag(), "exitFullscreen");
        if (this.cJb == null || !this.cJb.k(aVar)) {
            AppMethodBeat.o(138994);
            return false;
        }
        AppMethodBeat.o(138994);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void takeScreenshot() {
        AppMethodBeat.i(215722);
        Log.i(getLogTag(), "takeScreenshot");
        com.tencent.luggage.xweb_ext.extendplugin.d.a(QJ(), this.type, getId());
        AppMethodBeat.o(215722);
    }

    /* access modifiers changed from: package-private */
    public final void q(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        AppMethodBeat.i(138995);
        Qu();
        r(aVar);
        Qw();
        AppMethodBeat.o(138995);
    }

    private void Qu() {
        AppMethodBeat.i(138996);
        if (this.cIV != null) {
            Log.i(getLogTag(), "releaseMediaPlayer");
            this.cIV.a((c.f) null);
            this.cIV.a((c.e) null);
            this.cIV.a((c.g) null);
            this.cIV.a((c.b) null);
            this.cIV.a((c.h) null);
            this.cIV.a((c.i) null);
            this.cIV.stop();
            this.cIV.reset();
            this.cIV.release();
        }
        this.cIV = null;
        this.cJk = false;
        AppMethodBeat.o(138996);
    }

    /* access modifiers changed from: package-private */
    public final void Qv() {
        AppMethodBeat.i(215723);
        if (this.cIV != null && (this.cIV instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f)) {
            f.b bKI = ((com.tencent.mm.plugin.appbrand.jsapi.video.e.b.f) this.cIV).bKI();
            if (this.cJb != null) {
                this.cJb.a(bKI);
            }
        }
        AppMethodBeat.o(215723);
    }

    /* access modifiers changed from: package-private */
    public final void r(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        AppMethodBeat.i(138997);
        Log.i(getLogTag(), "createMediaPlayer");
        if (this.cJb != null) {
            this.cIV = this.cJb.a(aVar, this.cJv);
        }
        if (this.cIV == null) {
            Log.e(getLogTag(), "createMediaPlayer, create media player fail");
            AppMethodBeat.o(138997);
            return;
        }
        this.cJk = true;
        this.cIV.a(new c.f() {
            /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.c.AnonymousClass27 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.f
            public final boolean cb(int i2, int i3) {
                AppMethodBeat.i(215692);
                c cVar = c.this;
                boolean k = cVar.k(new Runnable(i2, i3) {
                    /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.c.AnonymousClass5 */
                    final /* synthetic */ int cJG;
                    final /* synthetic */ int cJH;

                    {
                        this.cJG = r2;
                        this.cJH = r3;
                    }

                    public final void run() {
                        AppMethodBeat.i(215679);
                        c cVar = c.this;
                        int i2 = this.cJG;
                        int i3 = this.cJH;
                        if (!cVar.cJk) {
                            Log.i(cVar.getLogTag(), "onMediaPlayerInfo, mp released");
                            AppMethodBeat.o(215679);
                            return;
                        }
                        Log.i(cVar.getLogTag(), "onInfo, what:%d, extra:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                        if (i2 == 701) {
                            cVar.cJf = cVar.cIV.isPlaying();
                            Log.i(cVar.getLogTag(), "onInfo, buffering start, isPlayingBeforeBuffering:%b", Boolean.valueOf(cVar.cJf));
                            if (cVar.PS()) {
                                cVar.cIW.onVideoWaiting();
                            }
                            if (cVar.cJb != null) {
                                cVar.cJb.d(cVar.cIV);
                                AppMethodBeat.o(215679);
                                return;
                            }
                        } else if (i2 == 702) {
                            boolean isPlaying = cVar.cIV.isPlaying();
                            Log.i(cVar.getLogTag(), "onInfo, buffering end, isPlayingBeforeBuffering:%b, isCurrentPlaying:%b", Boolean.valueOf(cVar.cJf), Boolean.valueOf(isPlaying));
                            if (cVar.cJf) {
                                cVar.cJf = false;
                                if (isPlaying && cVar.PS()) {
                                    Log.i(cVar.getLogTag(), "onInfo, buffering end, notify video play");
                                    cVar.cIW.ci(false);
                                }
                            } else if (!isPlaying && cVar.PS()) {
                                Log.i(cVar.getLogTag(), "onInfo, buffering end, notify video pause");
                                cVar.cIW.cj(false);
                            }
                            if (cVar.cJb != null) {
                                cVar.cJb.e(cVar.cIV);
                            }
                            AppMethodBeat.o(215679);
                            return;
                        } else if (i2 == 3) {
                            if (!cVar.cJk) {
                                Log.i(cVar.getLogTag(), "onMediaPlayerVideoFirstFrame, mp released");
                                AppMethodBeat.o(215679);
                                return;
                            }
                            Log.i(cVar.getLogTag(), "onMediaPlayerVideoFirstFrame");
                            if (cVar.cJb != null) {
                                cVar.cJb.u(cVar.cED);
                            }
                        }
                        AppMethodBeat.o(215679);
                    }
                });
                AppMethodBeat.o(215692);
                return k;
            }
        });
        this.cIV.a(new c.e() {
            /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.c.AnonymousClass28 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.e
            public final boolean cc(int i2, int i3) {
                AppMethodBeat.i(215693);
                boolean ca = c.this.ca(i2, i3);
                AppMethodBeat.o(215693);
                return ca;
            }
        });
        this.cIV.a(new c.g() {
            /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.c.AnonymousClass29 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.g
            public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar) {
                AppMethodBeat.i(215694);
                c cVar2 = c.this;
                cVar2.k(new Runnable() {
                    /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.c.AnonymousClass3 */

                    public final void run() {
                        int i2;
                        int i3;
                        boolean z = false;
                        AppMethodBeat.i(138947);
                        c cVar = c.this;
                        if (!cVar.cJk) {
                            Log.i(cVar.getLogTag(), "onMediaPlayerPrepared, mp released");
                            AppMethodBeat.o(138947);
                            return;
                        }
                        Log.i(cVar.getLogTag(), "onPrepared");
                        if (cVar.cJb != null) {
                            cVar.cJb.a(cVar.cIV, (long) cVar.getDuration());
                        }
                        cVar.cJj = true;
                        cVar.cd(false);
                        if (cVar.PS() && cVar.cIV != null) {
                            d dVar = cVar.cIW;
                            if (cVar.cIV != null) {
                                i2 = cVar.cIV.getVideoWidth();
                            } else {
                                i2 = 0;
                            }
                            if (cVar.cIV != null) {
                                i3 = cVar.cIV.getVideoHeight();
                            } else {
                                i3 = 0;
                            }
                            dVar.E(i2, i3, cVar.getDuration());
                        }
                        cVar.Qq();
                        long j2 = cVar.cJh;
                        if (j2 > 0) {
                            cVar.seek(j2);
                            cVar.cJh = 0;
                        }
                        boolean z2 = !cVar.cJs;
                        if (cVar.cED.NN() instanceof com.tencent.mm.plugin.appbrand.page.ac) {
                            z2 = ((com.tencent.mm.plugin.appbrand.page.ac) cVar.cED.NN()).cwV;
                        } else {
                            Log.w(cVar.getLogTag(), "onPrepared, component is not page view");
                        }
                        if (!z2 && !cVar.PT()) {
                            Log.i(cVar.getLogTag(), "onPrepared, stop video auto play when webview in background");
                            if (cVar.cJi || cVar.cJg) {
                                z = true;
                            }
                            cVar.cET = new AtomicBoolean(z);
                            AppMethodBeat.o(138947);
                        } else if (cVar.cJi || cVar.cJg) {
                            Log.i(cVar.getLogTag(), "onPrepared, start play when prepared, mStartWhenPrepared:%s, mControlStartWhenPrepared:%s", Boolean.valueOf(cVar.cJi), Boolean.valueOf(cVar.cJg));
                            if (cVar.cJc == null || !((Boolean) cVar.cJc.mKN.a(com.tencent.mm.plugin.appbrand.jsapi.ag.e.b.cLI[1])).booleanValue()) {
                                cVar.i(cVar.cJi, true);
                                AppMethodBeat.o(138947);
                                return;
                            }
                            Log.i("MicroMsg.SameLayer.VideoPluginHandler", "onMediaPlayerPreparedInternal: castMediaPresent, avoid play when prepared");
                            AppMethodBeat.o(138947);
                        } else {
                            Log.i(cVar.getLogTag(), "onPrepared, not set start play when prepared");
                            AppMethodBeat.o(138947);
                        }
                    }
                });
                AppMethodBeat.o(215694);
            }
        });
        this.cIV.a(new c.b() {
            /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.c.AnonymousClass30 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.b
            public final void QA() {
                AppMethodBeat.i(215695);
                c cVar = c.this;
                cVar.k(new Runnable() {
                    /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.c.AnonymousClass48 */

                    public final void run() {
                        AppMethodBeat.i(138971);
                        c cVar = c.this;
                        if (!cVar.cJk) {
                            Log.i(cVar.getLogTag(), "onMediaPlayerCompletion, mp released");
                            AppMethodBeat.o(138971);
                            return;
                        }
                        Log.i(cVar.getLogTag(), "onCompletion");
                        if (cVar.PS()) {
                            cVar.cIW.onVideoEnded();
                        }
                        if (cVar.cJb != null) {
                            cVar.cJb.b(cVar.cED, cVar.cIV);
                        }
                        if (cVar.cJl) {
                            Log.i(cVar.getLogTag(), "onCompletion, video loop playing");
                            cVar.cJd = true;
                            cVar.seek(0);
                            AppMethodBeat.o(138971);
                            return;
                        }
                        Log.i(cVar.getLogTag(), "onCompletion, video end playing");
                        cVar.cJr = true;
                        if (cVar.cIV != null && (cVar.cIV instanceof com.tencent.mm.plugin.appbrand.jsapi.video.e.b.a)) {
                            cVar.cIV.pause();
                        }
                        h.RTc.aV(new Runnable() {
                            /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.c.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(138946);
                                Log.i(c.this.getLogTag(), "onCompletion, abandonFocus");
                                c.this.cEM.bJJ();
                                AppMethodBeat.o(138946);
                            }
                        });
                        AppMethodBeat.o(138971);
                    }
                });
                AppMethodBeat.o(215695);
            }
        });
        this.cIV.a(new c.h() {
            /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.c.AnonymousClass31 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.h
            public final void b(com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar) {
                AppMethodBeat.i(215696);
                c cVar2 = c.this;
                cVar2.k(new Runnable() {
                    /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.c.AnonymousClass47 */

                    public final void run() {
                        AppMethodBeat.i(138970);
                        c cVar = c.this;
                        if (!cVar.cJk) {
                            Log.i(cVar.getLogTag(), "onMediaPlayerSeekComplete, mp released");
                            AppMethodBeat.o(138970);
                            return;
                        }
                        Log.i(cVar.getLogTag(), "onSeekComplete");
                        if (cVar.PS()) {
                            cVar.cIW.m5if(cVar.getCurrentPosition());
                        }
                        if (cVar.cJd) {
                            Log.i(cVar.getLogTag(), "onSeekComplete, start when seek complete");
                            cVar.cJd = false;
                            cVar.i(false, true);
                            AppMethodBeat.o(138970);
                            return;
                        }
                        boolean isPlaying = cVar.cIV.isPlaying();
                        if (cVar.cJe) {
                            long duration = (long) cVar.cIV.getDuration();
                            long currentPosition = (long) cVar.cIV.getCurrentPosition();
                            Log.i(cVar.getLogTag(), "onSeekComplete, video playing before seeking, isCurrentPlaying:%b, position:%s, duration:%s", Boolean.valueOf(isPlaying), Long.valueOf(currentPosition), Long.valueOf(duration));
                            cVar.cJe = false;
                            if (currentPosition / 1000 < duration / 1000) {
                                Log.i(cVar.getLogTag(), "onSeekComplete, video not end");
                                if (isPlaying && cVar.PS()) {
                                    Log.i(cVar.getLogTag(), "onSeekComplete, dispatch play again");
                                    cVar.cIW.ci(false);
                                    AppMethodBeat.o(138970);
                                    return;
                                }
                            } else {
                                Log.i(cVar.getLogTag(), "onSeekComplete, video ends");
                                cVar.cIV.pause();
                                cVar.cIV.start();
                            }
                            AppMethodBeat.o(138970);
                            return;
                        }
                        Log.i(cVar.getLogTag(), "onSeekComplete, video not playing before seeking, isCurrentPlaying:%b", Boolean.valueOf(isPlaying));
                        if (!isPlaying && cVar.PS()) {
                            Log.i(cVar.getLogTag(), "onSeekComplete, dispatch pause again");
                            cVar.cIW.cj(false);
                        }
                        AppMethodBeat.o(138970);
                    }
                });
                AppMethodBeat.o(215696);
            }
        });
        this.cIV.a(new c.i() {
            /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.c.AnonymousClass32 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.i
            public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.e.c cVar, int i2, int i3) {
                AppMethodBeat.i(215697);
                c cVar2 = c.this;
                cVar2.k(new Runnable(i2, i3) {
                    /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.c.AnonymousClass46 */
                    final /* synthetic */ int val$height;
                    final /* synthetic */ int val$width;

                    {
                        this.val$width = r2;
                        this.val$height = r3;
                    }

                    public final void run() {
                        AppMethodBeat.i(138969);
                        c cVar = c.this;
                        int i2 = this.val$width;
                        int i3 = this.val$height;
                        if (!cVar.cJk) {
                            Log.i(cVar.getLogTag(), "onMediaPlayerVideoSizeChanged, mp released");
                            AppMethodBeat.o(138969);
                            return;
                        }
                        Log.i(cVar.getLogTag(), "onVideoSizeChanged, width:%d, height:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                        cVar.cd(false);
                        int duration = cVar.getDuration();
                        if (!(!cVar.cJj || cVar.cIV == null || (i2 == cVar.mVideoWidth && i3 == cVar.mVideoHeight && duration == cVar.cJn))) {
                            if (cVar.PS()) {
                                cVar.cIW.E(i2, i3, duration);
                            }
                            cVar.Qq();
                        }
                        cVar.mVideoWidth = i2;
                        cVar.mVideoHeight = i3;
                        cVar.cJn = duration;
                        AppMethodBeat.o(138969);
                    }
                });
                AppMethodBeat.o(215697);
            }
        });
        this.cIV.a(new c.a() {
            /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.c.AnonymousClass33 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.c.a
            public final void id(int i2) {
                AppMethodBeat.i(215698);
                c cVar = c.this;
                cVar.k(new Runnable(i2) {
                    /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.c.AnonymousClass45 */
                    final /* synthetic */ int cJP;

                    {
                        this.cJP = r2;
                    }

                    public final void run() {
                        AppMethodBeat.i(138968);
                        c cVar = c.this;
                        int i2 = this.cJP;
                        if (!cVar.cJk) {
                            Log.i(cVar.getLogTag(), "onMediaPlayerBufferingUpdate, mp released");
                            AppMethodBeat.o(138968);
                            return;
                        }
                        if (i2 != cVar.cJo) {
                            cVar.cJo = i2;
                            Log.i(cVar.getLogTag(), "onBufferingUpdate, percent:%s", Integer.valueOf(i2));
                        }
                        if (cVar.PS() && cVar.cJj) {
                            cVar.cIW.ie(i2);
                        }
                        AppMethodBeat.o(138968);
                    }
                });
                AppMethodBeat.o(215698);
            }
        });
        if (this.cJB != null) {
            this.cJB.cf(this.cJj);
        }
        AppMethodBeat.o(138997);
    }

    private void Qw() {
        boolean z = true;
        AppMethodBeat.i(138998);
        if (this.cIV != null) {
            this.cIV.setMute(this.cJm);
            if (this.mSurface != null) {
                boolean z2 = this.cFe.get();
                if (this.cJs || z2) {
                    String logTag = getLogTag();
                    Object[] objArr = new Object[3];
                    objArr[0] = Boolean.valueOf(this.cJs);
                    objArr[1] = Boolean.valueOf(z2);
                    if (this.cJy == null) {
                        z = false;
                    }
                    objArr[2] = Boolean.valueOf(z);
                    Log.i(logTag, "applyMediaPlayerParams, setSurface, WebViewInBackground: %b, JustPlayAudio: %b, SurfacePipSet exist: %b", objArr);
                    if (this.cJs && this.cJy != null) {
                        this.cIV.setSurface(this.cJy);
                    }
                } else {
                    Log.i(getLogTag(), "applyMediaPlayerParams, setSurface");
                    this.cIV.setSurface(this.mSurface);
                    AppMethodBeat.o(138998);
                    return;
                }
            }
        }
        AppMethodBeat.o(138998);
    }

    private void Qx() {
        AppMethodBeat.i(138999);
        if (this.mSurface != null) {
            this.mSurface.release();
            this.mSurface = null;
        }
        AppMethodBeat.o(138999);
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean PS() {
        return this.cEJ && this.cIW != null;
    }

    /* access modifiers changed from: package-private */
    public final void dT(final String str) {
        AppMethodBeat.i(215724);
        Log.i(getLogTag(), "doCheckVideoUrl, videoPath: ".concat(String.valueOf(str)));
        h.RTc.aX(new com.tencent.f.i.h() {
            /* class com.tencent.luggage.xweb_ext.extendplugin.component.video.c.AnonymousClass35 */

            /* JADX WARNING: Removed duplicated region for block: B:18:0x006a  */
            /* JADX WARNING: Removed duplicated region for block: B:22:0x0075  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                // Method dump skipped, instructions count: 134
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.luggage.xweb_ext.extendplugin.component.video.c.AnonymousClass35.run():void");
            }

            @Override // com.tencent.f.i.h, com.tencent.f.i.g
            public final String getKey() {
                return "VideoPluginHandler_checkVideoUrl";
            }
        });
        AppMethodBeat.o(215724);
    }

    /* access modifiers changed from: package-private */
    public final boolean PT() {
        AppMethodBeat.i(215725);
        boolean d2 = this.cEV.d(this.cED);
        AppMethodBeat.o(215725);
        return d2;
    }

    public final boolean e(Surface surface) {
        boolean z;
        AppMethodBeat.i(215726);
        if (this.cIV != null) {
            if (!this.cFe.get()) {
                this.cIV.setSurface(surface);
            } else {
                Log.i(getLogTag(), "setSurface, JustPlayAudio");
            }
            if (this.mSurface == surface) {
                this.cJy = null;
            } else {
                this.cJy = surface;
            }
            String logTag = getLogTag();
            Object[] objArr = new Object[1];
            if (this.cJy != null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            Log.i(logTag, "setSurface, SurfacePipSet exist: %b", objArr);
            AppMethodBeat.o(215726);
            return true;
        }
        Log.w(getLogTag(), "setSurface, MediaPlayer is null");
        AppMethodBeat.o(215726);
        return false;
    }

    public final String getKey() {
        AppMethodBeat.i(177168);
        String str = Lb() + "@" + hashCode();
        AppMethodBeat.o(177168);
        return str;
    }

    public final int Qy() {
        AppMethodBeat.i(177169);
        int i2 = (int) (((float) this.cEH) + (((1.0f - this.cJD) * ((float) this.cEF)) / 2.0f));
        Log.d(getLogTag(), "getVideoPositionX, videoPosX: ".concat(String.valueOf(i2)));
        AppMethodBeat.o(177169);
        return i2;
    }

    public final int Qz() {
        AppMethodBeat.i(177170);
        int i2 = (int) (((float) this.cEI) + (((1.0f - this.cJE) * ((float) this.cEG)) / 2.0f));
        Log.d(getLogTag(), "getVideoPositionY, videoPosY: ".concat(String.valueOf(i2)));
        AppMethodBeat.o(177170);
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final boolean PV() {
        AppMethodBeat.i(215727);
        if (this.cED == null) {
            Log.w(getLogTag(), "amIBackgroundAudioPlayer, mInsertInvokeContext is null");
            AppMethodBeat.o(215727);
            return false;
        }
        com.tencent.mm.plugin.appbrand.jsapi.ag.a f2 = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(this.cED);
        if (f2 == null) {
            Log.w(getLogTag(), "amIBackgroundAudioPlayer, audioOfVideoBackgroundPlayManager is null");
            AppMethodBeat.o(215727);
            return false;
        }
        boolean a2 = f2.a(this);
        AppMethodBeat.o(215727);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final boolean s(com.tencent.luggage.xweb_ext.extendplugin.a aVar) {
        boolean z;
        AppMethodBeat.i(215728);
        Log.d(getLogTag(), "disableBackgroundPlayAudio");
        Log.d(getLogTag(), "disableBackgroundPlayAudioInternal");
        if (aVar == null) {
            Log.w(getLogTag(), "disableBackgroundPlayAudioInternal, invokeContext is null");
            z = false;
        } else {
            com.tencent.mm.plugin.appbrand.jsapi.ag.a f2 = com.tencent.luggage.xweb_ext.extendplugin.component.e.f(aVar);
            if (f2 == null) {
                Log.w(getLogTag(), "disableBackgroundPlayAudio, audioOfVideoBackgroundPlayManager is null");
                z = false;
            } else {
                f2.c(this);
                z = true;
            }
        }
        if (z) {
            this.cFe.set(false);
            Log.d(getLogTag(), "disableBackgroundPlayAudio, webViewInBackground: %b", Boolean.valueOf(this.cJs));
            if (this.cIV != null && !this.cJs) {
                this.cIV.setSurface(this.mSurface);
            }
            this.cFc = false;
            if (this.cIW != null) {
                this.cIW.ck(false);
            }
            AppMethodBeat.o(215728);
            return true;
        }
        AppMethodBeat.o(215728);
        return false;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.i
    public final String getName() {
        AppMethodBeat.i(215729);
        String key = getKey();
        AppMethodBeat.o(215729);
        return key;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.i
    public final <AddOn extends j> void a(Class<AddOn> cls, AddOn addon) {
        AppMethodBeat.i(215730);
        Log.i(getLogTag(), "setAddOn for " + cls.getSimpleName());
        this.cFd.a(cls, addon);
        AppMethodBeat.o(215730);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.i
    public final <AddOn extends j> AddOn X(Class<AddOn> cls) {
        AppMethodBeat.i(215731);
        Log.i(getLogTag(), "getAddOn for " + cls.getSimpleName());
        AddOn addon = (AddOn) this.cFd.X(cls);
        AppMethodBeat.o(215731);
        return addon;
    }

    static /* synthetic */ void a(c cVar, SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(139000);
        super.e(surfaceTexture);
        Log.i(cVar.getLogTag(), "*** handler(%s) handlePluginReady", cVar.Lb());
        cVar.cJd = false;
        cVar.cJe = false;
        cVar.cJf = false;
        cVar.cJg = false;
        cVar.mSurfaceTexture = surfaceTexture;
        cVar.mSurface = new Surface(surfaceTexture);
        if (cVar.cIV != null) {
            Log.i(cVar.getLogTag(), "handlePluginReady, setSurface:%s", surfaceTexture);
            cVar.cIV.setSurface(cVar.mSurface);
            cVar.Qq();
        }
        cVar.Qp();
        AppMethodBeat.o(139000);
    }

    static /* synthetic */ void a(c cVar) {
        AppMethodBeat.i(139001);
        super.PQ();
        Log.i(cVar.getLogTag(), "*** handler(%s) handlePluginDestroy", cVar.Lb());
        cVar.Qt();
        cVar.Qx();
        AppMethodBeat.o(139001);
    }
}
