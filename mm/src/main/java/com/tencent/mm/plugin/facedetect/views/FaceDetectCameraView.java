package com.tencent.mm.plugin.facedetect.views;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.TextureView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.d;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.model.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.ref.WeakReference;

public class FaceDetectCameraView extends MMTextureView implements TextureView.SurfaceTextureListener {
    private static a sVu = null;
    private ActivityManager aJf;
    private int height;
    private boolean lPD;
    private SurfaceTexture mSurfaceTexture;
    private boolean pfT;
    private long sQK;
    b sVg;
    private long sVh;
    private long sVi;
    private int sVj;
    private boolean sVk;
    private boolean sVl;
    private final Object sVm;
    private boolean sVn;
    private boolean sVo;
    private final Object sVp;
    private final Object sVq;
    private Rect sVr;
    private c sVs;
    private boolean sVt;
    public b sVv;
    private byte[] sVw;
    private boolean sVx;
    private long sVy;
    private int width;

    public interface b {
        void DG(long j2);

        void a(c cVar);

        void cTO();

        void cTP();

        Point cTQ();

        int getPreviewHeight();

        int getPreviewWidth();

        int getRotation();

        void stopPreview();
    }

    /* access modifiers changed from: package-private */
    public static class a extends MMHandler {
        private WeakReference<FaceDetectCameraView> Rd;

        /* synthetic */ a(FaceDetectCameraView faceDetectCameraView, byte b2) {
            this(faceDetectCameraView);
        }

        private a(FaceDetectCameraView faceDetectCameraView) {
            super(Looper.getMainLooper());
            AppMethodBeat.i(104093);
            this.Rd = new WeakReference<>(faceDetectCameraView);
            AppMethodBeat.o(104093);
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(104094);
            super.handleMessage(message);
            if (this.Rd == null || this.Rd.get() == null) {
                Log.e("MicroMsg.FaceDetectCameraView", "hy: no referenced view. exit");
                AppMethodBeat.o(104094);
                return;
            }
            if (message.what == 1) {
                FaceCharacteristicsResult faceCharacteristicsResult = (FaceCharacteristicsResult) message.obj;
                if (FaceCharacteristicsResult.HI(faceCharacteristicsResult.errCode)) {
                    if (this.Rd.get().sVg != null) {
                        this.Rd.get().sVg.d(faceCharacteristicsResult);
                        AppMethodBeat.o(104094);
                        return;
                    }
                } else if (FaceCharacteristicsResult.HH(faceCharacteristicsResult.errCode)) {
                    if (this.Rd.get().sVg != null) {
                        this.Rd.get().sVg.a(faceCharacteristicsResult.errCode, faceCharacteristicsResult.errMsg);
                        AppMethodBeat.o(104094);
                        return;
                    }
                } else if (this.Rd.get().sVg != null) {
                    this.Rd.get().sVg.c(faceCharacteristicsResult);
                }
            }
            AppMethodBeat.o(104094);
        }
    }

    public FaceDetectCameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceDetectCameraView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(104113);
        this.sVg = null;
        this.mSurfaceTexture = null;
        this.sVh = FaceDetectView.sWf;
        this.sVi = -1;
        this.sQK = -1;
        this.sVj = 1;
        this.lPD = false;
        this.sVk = false;
        this.sVl = false;
        this.sVm = new Object();
        this.sVn = false;
        this.sVo = false;
        this.pfT = false;
        this.sVp = new Object();
        this.sVq = new Object();
        this.sVr = null;
        this.width = aq.CTRL_INDEX;
        this.height = 576;
        this.sVs = null;
        this.sVt = false;
        this.sVv = null;
        this.sVw = null;
        this.sVx = false;
        this.sVy = -1;
        this.aJf = (ActivityManager) getContext().getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        Log.i("MicroMsg.FaceDetectCameraView", "hy: face vedio debug: %b", Boolean.valueOf(this.sVt));
        this.sVv = new c(this, (byte) 0);
        sVu = new a(this, (byte) 0);
        setOpaque(false);
        setSurfaceTextureListener(this);
        AppMethodBeat.o(104113);
    }

    public final Point getEncodeVideoBestSize() {
        AppMethodBeat.i(104114);
        Point cTQ = this.sVv.cTQ();
        AppMethodBeat.o(104114);
        return cTQ;
    }

    /* access modifiers changed from: package-private */
    public final void setCallback(b bVar) {
        this.sVg = bVar;
    }

    public final void a(c cVar) {
        AppMethodBeat.i(104115);
        this.sVv.a(cVar);
        this.sQK = -1;
        AppMethodBeat.o(104115);
    }

    public final synchronized void a(Rect rect, long j2) {
        AppMethodBeat.i(104116);
        cTJ();
        this.sVr = rect;
        cTM();
        this.sVv.DG(j2);
        AppMethodBeat.o(104116);
    }

    private static void cTJ() {
        AppMethodBeat.i(104117);
        Log.i("MicroMsg.FaceDetectCameraView", "hy: request clear queue");
        f.cSU();
        AppMethodBeat.o(104117);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(104118);
        Log.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureAvailable");
        gLi();
        this.lPD = true;
        this.mSurfaceTexture = surfaceTexture;
        if (this.sVo) {
            a(this.sVs);
        }
        AppMethodBeat.o(104118);
    }

    public final void cTK() {
        AppMethodBeat.i(104119);
        cTL();
        f.INSTANCE.sQN.sSO.cTc();
        AppMethodBeat.o(104119);
    }

    public final void cTL() {
        AppMethodBeat.i(104120);
        this.pfT = false;
        this.sVv.cTP();
        cTJ();
        int cSZ = f.INSTANCE.cSZ();
        long currentTimeMillis = System.currentTimeMillis();
        Log.i("MicroMsg.FaceDetectCameraView", "alvinluo pause motion time: %d", Long.valueOf(currentTimeMillis));
        FaceDetectReporter.cTe().ae(cSZ, currentTimeMillis);
        AppMethodBeat.o(104120);
    }

    private synchronized void cTM() {
        AppMethodBeat.i(104121);
        Log.i("MicroMsg.FaceDetectCameraView", "alvinluo capture face");
        f.INSTANCE.cSY();
        g gVar = f.INSTANCE.sQN.sSO;
        if (gVar.sQQ == null) {
            Log.e("MicroMsg.FaceDetectNativeManager", "hy: init motion no instance");
        } else {
            Log.i("MicroMsg.FaceDetectNativeManager", "hy: start init motion");
            gVar.sQQ.engineGetCurrMotion();
        }
        int cSZ = f.INSTANCE.cSZ();
        long currentTimeMillis = System.currentTimeMillis();
        Log.i("MicroMsg.FaceDetectCameraView", "alvinluo start motion time: %d", Long.valueOf(currentTimeMillis));
        FaceDetectReporter.cTe().ad(cSZ, currentTimeMillis);
        AppMethodBeat.o(104121);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(104122);
        Log.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureSizeChanged");
        this.mSurfaceTexture = surfaceTexture;
        AppMethodBeat.o(104122);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(104123);
        Log.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureDestroyed");
        this.lPD = false;
        AppMethodBeat.o(104123);
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // com.tencent.mm.ui.base.MMTextureView
    public void onAttachedToWindow() {
        AppMethodBeat.i(104124);
        super.onAttachedToWindow();
        Log.i("MicroMsg.FaceDetectCameraView", "hy: attached");
        AppMethodBeat.o(104124);
    }

    /* access modifiers changed from: package-private */
    public final synchronized FaceProNative.FaceResult cTN() {
        FaceProNative.FaceResult cTb;
        AppMethodBeat.i(104125);
        f.cSU();
        int cSY = f.INSTANCE.cSY();
        cTb = f.INSTANCE.sQN.sSO.cTb();
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(cSY);
        objArr[1] = Integer.valueOf(cTb != null ? cTb.result : -10000);
        Log.i("MicroMsg.FaceDetectCameraView", "hy: motionResult: %d, finalResult: %d", objArr);
        AppMethodBeat.o(104125);
        return cTb;
    }

    public final Bitmap getPreviewBm() {
        AppMethodBeat.i(104126);
        Bitmap bitmap = getBitmap();
        AppMethodBeat.o(104126);
        return bitmap;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(104127);
        super.onMeasure(i2, i3);
        this.width = getMeasuredWidth();
        this.height = getMeasuredHeight();
        Log.i("MicroMsg.FaceDetectCameraView", "hy: camera view on measure to %d, %d", Integer.valueOf(this.width), Integer.valueOf(this.height));
        AppMethodBeat.o(104127);
    }

    public final int getCameraRotation() {
        AppMethodBeat.i(104128);
        int rotation = this.sVv.getRotation();
        AppMethodBeat.o(104128);
        return rotation;
    }

    public final int getPreviewWidth() {
        AppMethodBeat.i(104129);
        int previewWidth = this.sVv.getPreviewWidth();
        AppMethodBeat.o(104129);
        return previewWidth;
    }

    public final int getPreviewHeight() {
        AppMethodBeat.i(104130);
        int previewHeight = this.sVv.getPreviewHeight();
        AppMethodBeat.o(104130);
        return previewHeight;
    }

    class c implements b {
        n sVD;
        Camera.PreviewCallback sVE;
        private d.b sVF;

        /* synthetic */ c(FaceDetectCameraView faceDetectCameraView, byte b2) {
            this();
        }

        private c() {
            AppMethodBeat.i(104103);
            this.sVD = null;
            this.sVE = new Camera.PreviewCallback() {
                /* class com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.c.AnonymousClass3 */

                public final void onPreviewFrame(byte[] bArr, Camera camera) {
                    AppMethodBeat.i(104100);
                    Log.v("MicroMsg.FaceDetectCameraView", "hy: on preview callback");
                    d.cSR().bB(bArr);
                    AppMethodBeat.o(104100);
                }
            };
            this.sVF = new d.b() {
                /* class com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.c.AnonymousClass4 */

                @Override // com.tencent.mm.plugin.facedetect.model.d.b
                public final void bC(byte[] bArr) {
                    AppMethodBeat.i(104102);
                    if (!FaceDetectCameraView.this.sVx) {
                        if (FaceDetectCameraView.this.sVw == null) {
                            FaceDetectCameraView.this.sVw = com.tencent.mm.plugin.facedetect.model.c.sQB.h(Integer.valueOf(bArr.length));
                        }
                        if (FaceDetectCameraView.this.sVw == null || FaceDetectCameraView.this.sVw.length < bArr.length) {
                            AppMethodBeat.o(104102);
                            return;
                        } else {
                            System.arraycopy(bArr, 0, FaceDetectCameraView.this.sVw, 0, bArr.length);
                            FaceDetectCameraView.this.sVw = bArr;
                        }
                    }
                    com.tencent.mm.plugin.facedetect.model.c.sQB.k(bArr);
                    f.cSV().post(new Runnable() {
                        /* class com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.c.AnonymousClass4.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(104101);
                            Log.v("MicroMsg.FaceDetectCameraView", "hy: on get preview");
                            long currentTicks = Util.currentTicks();
                            long j2 = currentTicks - FaceDetectCameraView.this.sVi;
                            if (FaceDetectCameraView.this.sVi >= 0) {
                                Log.v("MicroMsg.FaceDetectCameraView", "hy: tweenMillis: %d", Long.valueOf(j2));
                            }
                            if (FaceDetectCameraView.this.sVi < 0 || j2 > FaceDetectCameraView.this.sVh) {
                                FaceDetectCameraView.this.sVi = currentTicks;
                                FaceDetectCameraView.b(FaceDetectCameraView.this, FaceDetectCameraView.this.sVw);
                            }
                            AppMethodBeat.o(104101);
                        }
                    });
                    AppMethodBeat.o(104102);
                }

                @Override // com.tencent.mm.plugin.facedetect.model.d.b
                public final com.tencent.mm.memory.a<byte[]> cSS() {
                    return com.tencent.mm.plugin.facedetect.model.c.sQB;
                }
            };
            this.sVD = new n(FaceDetectCameraView.this.getContext());
            FaceDetectCameraView.this.sVi = -1;
            FaceDetectCameraView.this.sVx = false;
            AppMethodBeat.o(104103);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
            r5.sVz.sVo = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
            if (r5.sVz.lPD != false) goto L_0x008a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0051, code lost:
            if (r5.sVz.isAvailable() == false) goto L_0x007d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0053, code lost:
            com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.FaceDetectCameraView", "hy: already available. manually call available");
            r5.sVz.onSurfaceTextureAvailable(r5.sVz.getSurfaceTexture(), r5.sVz.getWidth(), r5.sVz.getHeight());
            com.tencent.matrix.trace.core.AppMethodBeat.o(104104);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x007d, code lost:
            com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.FaceDetectCameraView", "hy: not initialized yet. do after init");
            com.tencent.matrix.trace.core.AppMethodBeat.o(104104);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x008a, code lost:
            r0 = com.tencent.mm.sdk.platformtools.Util.currentTicks();
            com.tencent.mm.sdk.thread.ThreadPool.post(new com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.c.AnonymousClass1(r5), "FaceDetectCameraView_Camera");
            com.tencent.matrix.trace.core.AppMethodBeat.o(104104);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            return;
         */
        @Override // com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.b
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.plugin.facedetect.views.c r6) {
            /*
            // Method dump skipped, instructions count: 157
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.c.a(com.tencent.mm.plugin.facedetect.views.c):void");
        }

        @Override // com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.b
        public final void stopPreview() {
            AppMethodBeat.i(104105);
            synchronized (FaceDetectCameraView.this.sVq) {
                try {
                    if (this.sVD != null && this.sVD.sRE) {
                        n nVar = this.sVD;
                        if (nVar.gGr != null) {
                            nVar.gGr.stopPreview();
                            nVar.sRE = false;
                            com.tencent.mm.plugin.facedetect.model.c.sQB.aRR();
                        }
                    }
                } finally {
                    AppMethodBeat.o(104105);
                }
            }
        }

        @Override // com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.b
        public final void cTO() {
            AppMethodBeat.i(104106);
            if (!FaceDetectCameraView.this.sVl) {
                FaceDetectCameraView.this.sVl = true;
                ThreadPool.post(new Runnable() {
                    /* class com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.c.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(104099);
                        synchronized (FaceDetectCameraView.this.sVq) {
                            try {
                                if (c.this.sVD != null) {
                                    Log.d("MicroMsg.FaceDetectCameraView", "hy: closeCamera");
                                    c.this.sVD.setPreviewCallback(null);
                                    d.cSR().clear();
                                    if (FaceDetectCameraView.this.mSurfaceTexture != null) {
                                        FaceDetectCameraView.this.mSurfaceTexture.release();
                                    }
                                    c.this.sVD.release();
                                    c.this.sVD = null;
                                    Log.d("MicroMsg.FaceDetectCameraView", "hy: scanCamera.release() done");
                                    FaceDetectCameraView.this.sVl = false;
                                    AppMethodBeat.o(104099);
                                }
                            } finally {
                                AppMethodBeat.o(104099);
                            }
                        }
                    }
                }, "FaceDetectCameraView_Camera");
            }
            AppMethodBeat.o(104106);
        }

        @Override // com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.b
        public final int getPreviewWidth() {
            int previewWidth;
            AppMethodBeat.i(104107);
            synchronized (FaceDetectCameraView.this.sVq) {
                try {
                    previewWidth = this.sVD.getPreviewWidth();
                } finally {
                    AppMethodBeat.o(104107);
                }
            }
            return previewWidth;
        }

        @Override // com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.b
        public final int getPreviewHeight() {
            int previewHeight;
            AppMethodBeat.i(104108);
            synchronized (FaceDetectCameraView.this.sVq) {
                try {
                    previewHeight = this.sVD.getPreviewHeight();
                } finally {
                    AppMethodBeat.o(104108);
                }
            }
            return previewHeight;
        }

        @Override // com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.b
        public final int getRotation() {
            int i2;
            AppMethodBeat.i(104109);
            synchronized (FaceDetectCameraView.this.sVq) {
                try {
                    i2 = this.sVD.sRI;
                } finally {
                    AppMethodBeat.o(104109);
                }
            }
            return i2;
        }

        @Override // com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.b
        public final void DG(long j2) {
            AppMethodBeat.i(104110);
            synchronized (FaceDetectCameraView.this.sVq) {
                try {
                    if (this.sVD == null) {
                        Log.w("MicroMsg.FaceDetectCameraView", "hy: camera is null. return");
                        return;
                    }
                    Log.i("MicroMsg.FaceDetectCameraView", "hy: start capturing. tween: %d", Long.valueOf(j2));
                    FaceDetectCameraView.this.sVh = j2;
                    if (FaceDetectCameraView.this.pfT) {
                        Log.w("MicroMsg.FaceDetectCameraView", "hy: already scanning");
                    } else if (this.sVD == null || !this.sVD.sRE) {
                        Log.i("MicroMsg.FaceDetectCameraView", "hy: not previewed yet. wait");
                        FaceDetectCameraView.this.sVn = true;
                    } else {
                        Log.i("MicroMsg.FaceDetectCameraView", "hy: is previewing. directly start capture");
                        FaceDetectCameraView.this.sVn = false;
                        d.cSR().a(this.sVF);
                        FaceDetectCameraView.this.pfT = true;
                    }
                    AppMethodBeat.o(104110);
                } finally {
                    AppMethodBeat.o(104110);
                }
            }
        }

        @Override // com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.b
        public final void cTP() {
            AppMethodBeat.i(104111);
            synchronized (FaceDetectCameraView.this.sVq) {
                try {
                    if (this.sVD != null && this.sVD.sRE) {
                        d.cSR().b(this.sVF);
                        if (!FaceDetectCameraView.this.sVx) {
                            FaceDetectCameraView.this.sVw = null;
                        }
                    }
                } finally {
                    AppMethodBeat.o(104111);
                }
            }
        }

        @Override // com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.b
        public final Point cTQ() {
            Point point;
            AppMethodBeat.i(104112);
            synchronized (FaceDetectCameraView.this.sVq) {
                try {
                    point = this.sVD.sRK;
                } finally {
                    AppMethodBeat.o(104112);
                }
            }
            return point;
        }
    }

    static /* synthetic */ void f(FaceDetectCameraView faceDetectCameraView) {
        AppMethodBeat.i(104131);
        if (faceDetectCameraView.sVn && faceDetectCameraView.sVh > 0) {
            Log.i("MicroMsg.FaceDetectCameraView", "hy: already request scanning face and now automatically capture");
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(104091);
                    FaceDetectCameraView.this.a(FaceDetectCameraView.this.sVr, FaceDetectCameraView.this.sVh);
                    FaceDetectCameraView.this.sVn = false;
                    AppMethodBeat.o(104091);
                }
            });
        }
        AppMethodBeat.o(104131);
    }

    static /* synthetic */ void a(FaceDetectCameraView faceDetectCameraView, Point point) {
        AppMethodBeat.i(104132);
        DisplayMetrics displayMetrics = faceDetectCameraView.getResources().getDisplayMetrics();
        int i2 = displayMetrics.widthPixels;
        final int i3 = displayMetrics.heightPixels;
        Log.v("MicroMsg.FaceDetectCameraView", "alvinluo screen size: (%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        final int i4 = displayMetrics.widthPixels;
        double d2 = ((1.0d * ((double) i4)) * ((double) point.x)) / ((double) point.y);
        final int i5 = (int) d2;
        Log.i("MicroMsg.FaceDetectCameraView", "alvinluo previewResolution: (%d, %d), adjust: (%d, %d), temp:%f", Integer.valueOf(point.x), Integer.valueOf(point.y), Integer.valueOf(i4), Integer.valueOf(i5), Double.valueOf(d2));
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(104092);
                int i2 = i3 - i5;
                Log.i("MicroMsg.FaceDetectCameraView", "alvinluo restHeight: %d", Integer.valueOf(i2));
                if (i2 <= 0) {
                    AppMethodBeat.o(104092);
                    return;
                }
                int i3 = i2 / 2;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, i5);
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(FaceDetectCameraView.this.getLayoutParams());
                layoutParams.setMargins(marginLayoutParams.leftMargin, i3, marginLayoutParams.rightMargin, marginLayoutParams.height + i3);
                Log.v("MicroMsg.FaceDetectCameraView", "alvinluo margin left: %d, right: %d, top: %d, bottom: %d", Integer.valueOf(marginLayoutParams.leftMargin), Integer.valueOf(marginLayoutParams.rightMargin), Integer.valueOf(i3), Integer.valueOf(i3 + marginLayoutParams.height));
                FaceDetectCameraView.this.setLayoutParams(layoutParams);
                FaceDetectCameraView.this.invalidate();
                AppMethodBeat.o(104092);
            }
        });
        AppMethodBeat.o(104132);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0133  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void b(com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView r12, byte[] r13) {
        /*
        // Method dump skipped, instructions count: 786
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView.b(com.tencent.mm.plugin.facedetect.views.FaceDetectCameraView, byte[]):void");
    }
}
