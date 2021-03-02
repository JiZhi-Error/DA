package com.tencent.mm.plugin.voip.video;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.GLTextureView;
import com.tencent.mm.plugin.voip.video.b.a;
import com.tencent.mm.plugin.voip.video.b.e;
import com.tencent.mm.plugin.voip.video.b.g;
import com.tencent.mm.plugin.voip.video.d.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class OpenGlRender implements GLTextureView.m {
    public static int FLAG_Angle270 = 12;
    public static int FLAG_Angle90 = 4;
    public static int FLAG_Mirror = 16;
    public static int FLAG_NV12 = 2;
    public static int FLAG_NV21 = 3;
    public static int FLAG_RGBA = 0;
    public static int FLAG_RGBAClip = 1;
    public static int FLAG_YV12 = 0;
    public static int FLAG_YV12Edge = 1;
    private static final Object HiJ = new Object();
    private static final Object HiK = new Object();
    private static final Object HiL = new Object();
    private static final Object HiM = new Object();
    static boolean HiS = false;
    public static int His = 0;
    public static int MSG_FLUSH = 1;
    public static int MSG_RENDER = 0;
    public static int MSG_RESET = 2;
    public static int RenderLocal = 0;
    public static int RenderRemote = 1;
    static String TAG = "OpenGlRender";
    public int GUK = 0;
    public int GUL = 0;
    boolean HhU = false;
    int HhV = 0;
    long HhW = 0;
    long HhX = 0;
    int HhY = 0;
    a HhZ;
    private int HiA;
    private int HiB;
    private boolean HiC;
    private int HiD;
    private int HiE;
    private int HiF;
    private volatile boolean HiG = false;
    private volatile boolean HiH = false;
    public int HiI = 0;
    public int HiN = 0;
    public boolean HiO = false;
    long HiP = -1;
    public b HiQ;
    WeakReference<Object> HiR;
    private boolean HiT = false;
    boolean HiU = false;
    boolean Hia = false;
    boolean Hib = false;
    boolean Hic = false;
    boolean Hid = false;
    boolean Hie = false;
    int Hif = 0;
    int Hig = 0;
    public WeakReference<OpenGlView> Hih;
    public boolean Hii = false;
    public Bitmap Hij = null;
    private int Hik = 0;
    private int Hil = 0;
    private byte[] Him = null;
    private int[] Hin = null;
    private int Hio;
    private int Hip;
    private int Hiq;
    public int Hir = 0;
    private com.tencent.mm.plugin.voip.video.a.b Hit = null;
    g Hiu;
    public com.tencent.mm.plugin.xlabeffect.b Hiv = null;
    public byte[] Hiw;
    public int Hix;
    public int Hiy;
    public boolean Hiz = false;
    public float mBrightness = 1.2f;
    public float mContrast = 1.93f;
    int mRenderMode = RenderLocal;
    public float mSaturation = 1.05f;

    public interface b {
        void Lj(long j2);

        void Lk(long j2);

        void Ll(long j2);

        void fJD();
    }

    private native void Init(int i2, Object obj, int i3);

    private native void Uninit(int i2);

    private native void render32(int[] iArr, int i2, int i3, int i4, int i5);

    private native void render8(byte[] bArr, int i2, int i3, int i4, int i5);

    private native void setMode(int i2, int i3, int i4, int i5);

    private native void setParam(float f2, float f3, float f4, int i2);

    static {
        AppMethodBeat.i(115668);
        AppMethodBeat.o(115668);
    }

    public static int getGLVersion() {
        AppMethodBeat.i(115647);
        if (His == 0) {
            His = 2;
            Log.i(TAG, "init gl version: %s", Integer.valueOf(His));
        }
        int i2 = His;
        AppMethodBeat.o(115647);
        return i2;
    }

    public OpenGlRender(OpenGlView openGlView, int i2) {
        AppMethodBeat.i(115648);
        if (!HiS) {
            OpenGlRender.class.getClassLoader();
            j.Ed("mm_gl_disp");
            HiS = true;
        }
        this.mRenderMode = i2;
        this.Hih = new WeakReference<>(openGlView);
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.HhZ = new a(myLooper);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                this.HhZ = new a(mainLooper);
            } else {
                this.HhZ = null;
            }
        }
        this.HiR = null;
        if (getGLVersion() == 2) {
            this.Hit = new com.tencent.mm.plugin.voip.video.a.b();
        }
        this.HiD = 0;
        this.HiE = 0;
        this.Hiu = new g();
        this.HiA = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wevis_android_ilink_voip_skin_smooth_weight, 0);
        this.HiB = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wevis_android_ilink_voip_skin_bright_weight, 0);
        Log.d(TAG, "WeEffect face beauty skin smooth param %d", Integer.valueOf(this.HiA));
        Log.d(TAG, "WeEffect face beauty skin bright param %d", Integer.valueOf(this.HiB));
        if (this.HiA < 0) {
            this.HiA = 0;
        }
        if (this.HiA >= 100) {
            this.HiA = 100;
        }
        if (this.HiB < 0) {
            this.HiB = 0;
        }
        if (this.HiB >= 100) {
            this.HiB = 100;
        }
        if (!(this.HiA == 0 || this.HiB == 0)) {
            this.Hiz = true;
        }
        this.Him = null;
        AppMethodBeat.o(115648);
    }

    /* JADX WARNING: Removed duplicated region for block: B:164:0x05b7  */
    @Override // com.tencent.mm.plugin.voip.video.GLTextureView.m
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onDrawFrame(javax.microedition.khronos.opengles.GL10 r13) {
        /*
        // Method dump skipped, instructions count: 1718
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voip.video.OpenGlRender.onDrawFrame(javax.microedition.khronos.opengles.GL10):void");
    }

    public final void setShowMode(int i2) {
        AppMethodBeat.i(115650);
        this.HiI = i2;
        if (this.Hiu != null) {
            Log.printInfoStack(TAG, "setShowMode, mode:%d, uiWidth: %s, uiHeight: %s", Integer.valueOf(i2), Integer.valueOf(this.Hif), Integer.valueOf(this.Hig));
            if (i2 != 1) {
                this.HiU = true;
                fKP();
            } else {
                if (this.HiU) {
                    Log.i(TAG, "is need to detach");
                    fKP();
                }
                this.HiT = true;
                xu(false);
            }
            this.Hiu.adY(this.HiI);
        }
        AppMethodBeat.o(115650);
    }

    public final void a(SurfaceTexture surfaceTexture, d dVar) {
        AppMethodBeat.i(115651);
        if (this.Hiu != null) {
            this.Hiu.a(surfaceTexture, dVar);
        }
        AppMethodBeat.o(115651);
    }

    public final void releaseSurfaceTexture() {
        AppMethodBeat.i(115652);
        if (this.Hih == null || this.Hih.get() == null) {
            AppMethodBeat.o(115652);
            return;
        }
        OpenGlView openGlView = this.Hih.get();
        Log.printInfoStack(TAG, "releaseSurfaceTexture:%s", openGlView);
        openGlView.queueEvent(new Runnable() {
            /* class com.tencent.mm.plugin.voip.video.OpenGlRender.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(115641);
                e fLK = e.fLK();
                try {
                    if (fLK.HlX != null) {
                        t tVar = t.GYO;
                        t.fHz();
                        if (fLK.HcD != null) {
                            fLK.HcD.close();
                        }
                        fLK.HlX.release();
                        fLK.HlX = null;
                        Log.i("MicroMsg.VoipHardDecodeUtil", "uninit surface texture");
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.VoipHardDecodeUtil", e2, "uninitSurfaceTexture error", new Object[0]);
                    t tVar2 = t.GYO;
                    t.fHA();
                }
                Log.i(OpenGlRender.TAG, "releaseSurfaceTexture call finish");
                synchronized (OpenGlRender.HiL) {
                    try {
                        OpenGlRender.HiL.notifyAll();
                    } catch (Exception e3) {
                        Log.printErrStackTrace(OpenGlRender.TAG, e3, "", new Object[0]);
                    }
                    try {
                    } catch (Throwable th) {
                        AppMethodBeat.o(115641);
                        throw th;
                    }
                }
                AppMethodBeat.o(115641);
            }
        });
        synchronized (HiL) {
            try {
                HiL.wait(100);
                Log.i(TAG, "releaseSurfaceTexture wait finish");
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            }
            try {
            } catch (Throwable th) {
                AppMethodBeat.o(115652);
                throw th;
            }
        }
        AppMethodBeat.o(115652);
    }

    public final void a(byte[] bArr, int i2, int i3, int i4, boolean z, int i5) {
        AppMethodBeat.i(115653);
        if (this.Hia && this.Him == null) {
            this.Hio = i2;
            this.Hip = i3;
            this.Hiq = i4;
            this.Him = bArr;
            this.HiC = z;
            this.HiF = i5;
            requestRender();
        }
        AppMethodBeat.o(115653);
    }

    public final void i(byte[] bArr, int i2, int i3, int i4) {
        AppMethodBeat.i(115654);
        if (this.Hia && this.Him == null) {
            this.Hio = i2;
            this.Hip = i3;
            this.Hiq = i4;
            this.Him = bArr;
            this.HiC = false;
            requestRender();
        }
        AppMethodBeat.o(115654);
    }

    public final void a(int[] iArr, int i2, int i3, int i4, boolean z) {
        AppMethodBeat.i(115655);
        if (this.Hia && this.Hin == null) {
            this.Hio = i2;
            this.Hip = i3;
            this.Hiq = i4;
            this.Hin = iArr;
            this.HiC = z;
            requestRender();
        }
        AppMethodBeat.o(115655);
    }

    public final void jA(int i2, int i3) {
        AppMethodBeat.i(115656);
        Log.i(TAG, "video=" + i2 + "x" + i3);
        if (i2 <= 0 || i3 <= 0) {
            Log.e(TAG, "ERROR video size:%dx%d, lastviddeosize:%dx%d ", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.GUK), Integer.valueOf(this.GUL));
            AppMethodBeat.o(115656);
            return;
        }
        this.GUK = i2;
        this.GUL = i3;
        if (this.Hiu != null) {
            this.Hiu.jK(i2, i3);
        }
        AppMethodBeat.o(115656);
    }

    @Override // com.tencent.mm.plugin.voip.video.GLTextureView.m
    public final void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        AppMethodBeat.i(115657);
        Log.i(TAG, "%s onSurfaceChanged, width: %s, height: %s, self:%b, UI:%dx%d,mode:%d, lastHWDecSize:%dx%d", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(this.HiC), Integer.valueOf(this.Hif), Integer.valueOf(this.Hig), Integer.valueOf(this.mRenderMode), Integer.valueOf(this.GUK), Integer.valueOf(this.GUL));
        if (!(this.Hif == i2 && this.Hig == i3)) {
            gl10.glViewport(0, 0, i2, i3);
            this.Hif = i2;
            this.Hig = i3;
        }
        if (this.Hit != null) {
            this.Hit.jj(i2, i3);
        }
        if (this.Hiu != null) {
            this.Hiu.onSurfaceChanged(gl10, i2, i3);
        }
        if (this.Hiv == null) {
            boolean a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_voip_xsetting_allow_checkgpu, false);
            int a3 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_voip_facebeauty_gpu_rating_limited, 50);
            if (a2 && com.tencent.mm.media.k.d.aNd() < a3) {
                this.Hiz = false;
            }
        }
        if (this.Hiz) {
            if (this.Hiv == null) {
                this.Hiv = new com.tencent.mm.plugin.xlabeffect.b(0, 0, 1);
                this.Hiv.l(this.HiA, -1, -1, this.HiB, -1);
                this.Hiv.zG(false);
                this.Hiv.glh();
            }
            if (this.Hiv != null) {
                this.Hiv.setSize(i2, i3);
                this.Hix = i2;
                this.Hiy = i3;
            }
        }
        setShowMode(this.HiI);
        jA(this.GUK, this.GUL);
        AppMethodBeat.o(115657);
    }

    @Override // com.tencent.mm.plugin.voip.video.GLTextureView.m
    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        AppMethodBeat.i(115658);
        Log.i(TAG, "onSurfaceCreated...");
        if (getGLVersion() == 2) {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES20.glDisable(2929);
        }
        if (this.Hiu != null) {
            this.Hiu.onSurfaceCreated(gl10, eGLConfig);
        }
        if (v2protocal.HcC == null) {
            e fLK = e.fLK();
            try {
                fLK.HlX = fLK.fLL();
                fLK.HlW.set(false);
                Surface surface = new Surface(fLK.HlX);
                v2protocal.mSurfaceTexture = fLK.HlX;
                v2protocal.HcD = null;
                v2protocal.HcC = surface;
                fLK.HlY.MC();
                AppMethodBeat.o(115658);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.VoipHardDecodeUtil", e2, "initSurfaceTexutre error", new Object[0]);
                t tVar = t.GYO;
                t.fHy();
            }
        }
        AppMethodBeat.o(115658);
    }

    public final void onStarted() {
        AppMethodBeat.i(115659);
        this.Hib = true;
        requestRender();
        AppMethodBeat.o(115659);
    }

    public final void fKM() {
        AppMethodBeat.i(115660);
        Log.i(TAG, "%s onStop, renderMode: %s", Integer.valueOf(hashCode()), Integer.valueOf(this.mRenderMode));
        this.Hib = false;
        this.Hie = false;
        AppMethodBeat.o(115660);
    }

    public final void fKN() {
        AppMethodBeat.i(115661);
        Log.i(TAG, "%s steve: try to reset GLRender mode=%d, inited:%b, started:%b", Integer.valueOf(hashCode()), Integer.valueOf(this.mRenderMode), Boolean.valueOf(this.Hia), Boolean.valueOf(this.Hib));
        if (this.Hia && this.Hib) {
            Log.i(TAG, "%s steve: Reset GLRender first! mode=%d", Integer.valueOf(hashCode()), Integer.valueOf(this.mRenderMode));
            if (this.Hiu != null) {
                Log.i(TAG, "onResetRender need detach");
                this.HiU = true;
                fKP();
            }
            this.Hia = false;
            this.Hib = false;
            fKO();
        }
        AppMethodBeat.o(115661);
    }

    private void fKO() {
        OpenGlView openGlView;
        AppMethodBeat.i(115662);
        if (this.Hit != null) {
            if (this.Hih != null && (openGlView = this.Hih.get()) != null) {
                openGlView.queueEvent(new Runnable() {
                    /* class com.tencent.mm.plugin.voip.video.OpenGlRender.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(115645);
                        if (OpenGlRender.this.Hit != null) {
                            OpenGlRender.this.Hit.destroy();
                        }
                        AppMethodBeat.o(115645);
                    }
                });
                AppMethodBeat.o(115662);
                return;
            } else if (this.Hit != null) {
                this.Hit.destroy();
            }
        }
        AppMethodBeat.o(115662);
    }

    /* access modifiers changed from: package-private */
    public final void fKP() {
        AppMethodBeat.i(115663);
        if (this.Hih == null || this.Hih.get() == null) {
            if (this.HiU) {
                this.Hih.get().queueEvent(new Runnable() {
                    /* class com.tencent.mm.plugin.voip.video.OpenGlRender.AnonymousClass7 */

                    public final void run() {
                        AppMethodBeat.i(235828);
                        OpenGlRender.this.Hiu.fLN();
                        OpenGlRender.this.HiU = false;
                        OpenGlRender.this.Him = null;
                        OpenGlRender.this.Hin = null;
                        Log.i(OpenGlRender.TAG, "detach finish");
                        AppMethodBeat.o(235828);
                    }
                });
            }
            AppMethodBeat.o(115663);
            return;
        }
        OpenGlView openGlView = this.Hih.get();
        Log.i(TAG, "detachGLContext:%s", openGlView);
        openGlView.queueEvent(new Runnable() {
            /* class com.tencent.mm.plugin.voip.video.OpenGlRender.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(161661);
                if (OpenGlRender.this.HiU) {
                    OpenGlRender.this.Hiu.fLN();
                    OpenGlRender.this.HiU = false;
                    OpenGlRender.this.Him = null;
                    OpenGlRender.this.Hin = null;
                    Log.i(OpenGlRender.TAG, "detach finish");
                }
                synchronized (OpenGlRender.HiJ) {
                    try {
                        OpenGlRender.HiJ.notifyAll();
                    } catch (Exception e2) {
                        Log.printErrStackTrace(OpenGlRender.TAG, e2, "", new Object[0]);
                    }
                    try {
                    } catch (Throwable th) {
                        AppMethodBeat.o(161661);
                        throw th;
                    }
                }
                AppMethodBeat.o(161661);
            }
        });
        synchronized (HiJ) {
            try {
                HiJ.wait(100);
                Log.i(TAG, "detachGLContext wait finish, bNeedDetach:%s", Boolean.valueOf(this.HiU));
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            }
            try {
            } catch (Throwable th) {
                AppMethodBeat.o(115663);
                throw th;
            }
        }
        AppMethodBeat.o(115663);
    }

    private void xu(boolean z) {
        AppMethodBeat.i(115664);
        if (!(this.Hih == null || this.Hih.get() == null)) {
            if (!z) {
                OpenGlView openGlView = this.Hih.get();
                Log.i(TAG, "attachGLContext:%s", openGlView);
                openGlView.queueEvent(new Runnable() {
                    /* class com.tencent.mm.plugin.voip.video.OpenGlRender.AnonymousClass8 */

                    public final void run() {
                        boolean z = false;
                        AppMethodBeat.i(235829);
                        if (OpenGlRender.this.HiT) {
                            Log.i(OpenGlRender.TAG, "attachGLContext");
                            OpenGlRender openGlRender = OpenGlRender.this;
                            if (!OpenGlRender.this.Hiu.fLM()) {
                                z = true;
                            }
                            openGlRender.HiT = z;
                            OpenGlRender.this.Him = null;
                            OpenGlRender.this.Hin = null;
                            Log.i(OpenGlRender.TAG, "attach finish");
                        }
                        synchronized (OpenGlRender.HiK) {
                            try {
                                OpenGlRender.HiK.notifyAll();
                            } catch (Exception e2) {
                                Log.printErrStackTrace(OpenGlRender.TAG, e2, "", new Object[0]);
                            }
                            try {
                            } catch (Throwable th) {
                                AppMethodBeat.o(235829);
                                throw th;
                            }
                        }
                        AppMethodBeat.o(235829);
                    }
                });
                synchronized (HiK) {
                    try {
                        HiK.wait(100);
                        Log.i(TAG, "attachGLContext wait finish, bNeedAttach:%s", Boolean.valueOf(this.HiT));
                    } catch (Exception e2) {
                        Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                    }
                    try {
                    } catch (Throwable th) {
                        AppMethodBeat.o(115664);
                        throw th;
                    }
                }
                AppMethodBeat.o(115664);
                return;
            } else if (this.HiT) {
                Log.i(TAG, "attachGLContext");
                this.HiT = !this.Hiu.fLM();
                this.Him = null;
                this.Hin = null;
                Log.i(TAG, "attach finish");
            }
        }
        AppMethodBeat.o(115664);
    }

    public final void setVoipBeauty(int i2) {
        AppMethodBeat.i(115665);
        Log.i(TAG, "steve: isDrawingSelf:%b, set voipbeauty:%d, beautyParam:%d", Boolean.valueOf(this.HiC), Integer.valueOf(i2), Integer.valueOf(this.HiD));
        this.HiD = i2;
        AppMethodBeat.o(115665);
    }

    public final void setSpatiotemporalDenosing(int i2) {
        AppMethodBeat.i(235830);
        Log.i(TAG, "hseasun: isDrawingSelf:%b, set setSpatiotemporalDenosing:%d, beautyParam:%d", Boolean.valueOf(this.HiC), Integer.valueOf(i2), Integer.valueOf(this.HiE));
        this.HiE = i2;
        AppMethodBeat.o(235830);
    }

    class a extends MMHandler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(115646);
            OpenGlRender.this.requestRender();
            AppMethodBeat.o(115646);
        }
    }

    public final void requestRender() {
        AppMethodBeat.i(115666);
        if (this.Hih.get() != null) {
            this.Hih.get().fKT();
        }
        AppMethodBeat.o(115666);
    }

    public final void a(int i2, a.b bVar) {
        AppMethodBeat.i(115667);
        switch (i2) {
            case 1:
                if (!(this.Hiu == null || this.Hiu.fLJ() == null)) {
                    bVar.a(this.Hiu.fLJ());
                    AppMethodBeat.o(115667);
                    return;
                }
            case 2:
                if (!(this.Hit == null || this.Hit.fLB() == null)) {
                    bVar.a(this.Hit.fLB());
                    break;
                }
        }
        AppMethodBeat.o(115667);
    }

    public final void a(b.AbstractC1893b bVar) {
        AppMethodBeat.i(235831);
        if (!(this.Hiu == null || this.Hiu.fJk() == null)) {
            bVar.a(this.Hiu.fJk());
        }
        AppMethodBeat.o(235831);
    }
}
