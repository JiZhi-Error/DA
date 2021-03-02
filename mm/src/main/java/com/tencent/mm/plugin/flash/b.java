package com.tencent.mm.plugin.flash;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.d;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.plugin.facedetect.model.c;
import com.tencent.mm.plugin.facedetect.model.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.rtmp.TXLiveConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class b {
    private boolean imf;
    private d.a.C0301a imk;
    Context mContext;
    int mDesiredPreviewHeight;
    int mDesiredPreviewWidth;
    private Point pbD = null;
    private Point sRF = null;
    private Point sRG = null;
    private boolean sRH;
    private int sRI;
    private Point sRK = null;
    d.b sVF = new d.b() {
        /* class com.tencent.mm.plugin.flash.b.AnonymousClass6 */

        @Override // com.tencent.mm.plugin.facedetect.model.d.b
        public final void bC(byte[] bArr) {
            AppMethodBeat.i(186510);
            c.sQB.k(bArr);
            AppMethodBeat.o(186510);
        }

        @Override // com.tencent.mm.plugin.facedetect.model.d.b
        public final com.tencent.mm.memory.a<byte[]> cSS() {
            return c.sQB;
        }
    };
    private MMTextureView sYY;
    HandlerThread sYZ;
    MMHandler sZa;
    public v sZb;
    private boolean sZc;
    public boolean sZd;
    public int sZh = 0;
    int sZl;

    public interface a {
        void a(Boolean bool, b bVar);
    }

    public b(Context context) {
        AppMethodBeat.i(186512);
        this.mContext = context;
        this.sZc = false;
        this.sZd = false;
        this.sYZ = null;
        this.sZc = false;
        AppMethodBeat.o(186512);
    }

    public final void a(MMTextureView mMTextureView, final a aVar) {
        AppMethodBeat.i(186513);
        Log.i("MicroMsg.FaceFlashManagerCamera", "openCameraForSurfaceTexture");
        this.sYY = mMTextureView;
        cUd();
        if (this.sZa != null) {
            this.sZa.post(new Runnable() {
                /* class com.tencent.mm.plugin.flash.b.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(186506);
                    boolean cUc = b.this.cUc();
                    if (!cUc) {
                        Log.i("MicroMsg.FaceFlashManagerCamera", "reopen Camera");
                        h.INSTANCE.idkeyStat(917, b.this.sZl == 1 ? 3 : 39, 1, false);
                        cUc = b.this.cUc();
                    }
                    Log.i("MicroMsg.FaceFlashManagerCamera", "isOpenCamera：%s", Boolean.valueOf(cUc));
                    h.INSTANCE.idkeyStat(917, b.this.sZl == 1 ? 2 : 38, 1, false);
                    aVar.a(Boolean.valueOf(cUc), b.this);
                    AppMethodBeat.o(186506);
                }
            });
            AppMethodBeat.o(186513);
            return;
        }
        Log.i("MicroMsg.FaceFlashManagerCamera", "back thread is not running");
        AppMethodBeat.o(186513);
    }

    /* access modifiers changed from: package-private */
    public final boolean cUc() {
        String str;
        boolean z;
        AppMethodBeat.i(186514);
        Log.i("MicroMsg.FaceFlashManagerCamera", "start open camera");
        this.sZc = false;
        this.imf = true;
        int numberOfCameras = Camera.getNumberOfCameras();
        int i2 = 0;
        while (true) {
            if (i2 >= numberOfCameras) {
                i2 = -1;
                break;
            }
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == 1 && this.imf) {
                Log.e("MicroMsg.FaceFlashManagerCamera", "openCamera found front Camera ");
                break;
            }
            if (cameraInfo.facing == 0 && !this.imf) {
                Log.e("MicroMsg.FaceFlashManagerCamera", "openCamera found front Camera");
                break;
            }
            i2++;
        }
        if (i2 == -1) {
            Log.i("MicroMsg.FaceFlashManagerCamera", "not found available camera id");
            AppMethodBeat.o(186514);
            return false;
        }
        long currentTicks = Util.currentTicks();
        if (this.imk == null) {
            Log.i("MicroMsg.FaceFlashManagerCamera", "openCameraRes is null");
            try {
                this.imk = com.tencent.mm.compatible.deviceinfo.d.a(this.mContext, i2, null);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.FaceFlashManagerCamera", e2, "MicroMsg.FaceFlashManagerError", new Object[0]);
                AppMethodBeat.o(186514);
                return false;
            }
        }
        if (this.imk == null) {
            Log.e("MicroMsg.FaceFlashManagerCamera", "in open(), openCameraRes == null");
            AppMethodBeat.o(186514);
            return false;
        }
        this.sZh = i2;
        this.sZc = true;
        Log.i("MicroMsg.FaceFlashManagerCamera", "openCamera done, cameraId=[%s] costTime=[%s]", Integer.valueOf(i2), Long.valueOf(Util.ticksToNow(currentTicks)));
        this.sRI = this.imk.dYT;
        this.sRH = this.imk.dYT % TXLiveConstants.RENDER_ROTATION_180 != 0;
        this.sZb = this.imk.gGr;
        if (this.sZb == null) {
            Log.i("MicroMsg.FaceFlashManagerCamera", "in open(), camera == null, bNeedRotate=[%s]", Boolean.valueOf(this.sRH));
            AppMethodBeat.o(186514);
            return false;
        }
        try {
            Camera.Parameters parameters = this.sZb.getParameters();
            if (parameters == null) {
                Log.i("MicroMsg.FaceFlashManagerCamera", "in open(), parameters == null");
                AppMethodBeat.o(186514);
                return false;
            }
            this.pbD = new Point(this.mContext.getResources().getDisplayMetrics().widthPixels, this.mContext.getResources().getDisplayMetrics().heightPixels);
            Point point = this.pbD;
            Point point2 = this.sRG;
            String str2 = parameters.get("preview-size-values");
            if (str2 == null) {
                str = parameters.get("preview-size-value");
            } else {
                str = str2;
            }
            Point point3 = null;
            if (str != null) {
                Log.d("MicroMsg.FaceFlashManagerCamera", "preview-size-values parameter: ".concat(String.valueOf(str)));
                point3 = a(parameters, point);
            }
            if (point3 == null) {
                point3 = new Point((point2.x >> 3) << 3, (point2.y >> 3) << 3);
            }
            this.sRF = point3;
            this.sRK = new Point(this.sRF);
            Log.d("MicroMsg.FaceFlashManagerCamera", "getCameraResolution: " + this.pbD + " camera:" + this.sRF + "bestVideoEncodeSize: " + this.sRK);
            this.mDesiredPreviewWidth = this.sRF.x;
            this.mDesiredPreviewHeight = this.sRF.y;
            parameters.setPreviewSize(this.mDesiredPreviewWidth, this.mDesiredPreviewHeight);
            Log.d("MicroMsg.FaceFlashManagerCamera", "mDesiredPreviewWidth：" + this.mDesiredPreviewWidth);
            Log.d("MicroMsg.FaceFlashManagerCamera", "mDesiredPreviewHeight：" + this.mDesiredPreviewHeight);
            parameters.setZoom(0);
            parameters.setSceneMode("auto");
            try {
                if (parameters.getSupportedFocusModes() == null || !parameters.getSupportedFocusModes().contains("auto")) {
                    Log.i("MicroMsg.FaceFlashManagerCamera", "camera not support FOCUS_MODE_AUTO");
                } else {
                    Log.i("MicroMsg.FaceFlashManagerCamera", "set FocusMode to FOCUS_MODE_AUTO");
                    parameters.setFocusMode("auto");
                }
            } catch (Exception e3) {
                Log.e("MicroMsg.FaceFlashManagerCamera", "set focus mode error: %s", e3.getMessage());
            }
            List<Integer> supportedPreviewFormats = parameters.getSupportedPreviewFormats();
            Iterator<Integer> it = supportedPreviewFormats.iterator();
            boolean z2 = false;
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                int intValue = it.next().intValue();
                Log.d("MicroMsg.FaceFlashManagerCamera", "supportedPreviewFormat: ".concat(String.valueOf(intValue)));
                if (intValue == 17) {
                    z = true;
                    break;
                }
                z2 = intValue == 842094169 ? true : z2;
            }
            if (z) {
                parameters.setPreviewFormat(17);
            } else if (z2) {
                Log.e("MicroMsg.FaceFlashManagerCamera", "Preview not support PixelFormat.YCbCr_420_SP, but hasYU12");
                parameters.setPreviewFormat(842094169);
            } else {
                Log.e("MicroMsg.FaceFlashManagerCamera", "Preview not support PixelFormat.YCbCr_420_SP. Use format: %s", supportedPreviewFormats.get(0));
                parameters.setPreviewFormat(supportedPreviewFormats.get(0).intValue());
            }
            if (this.sRH) {
                parameters.setRotation(this.sRI);
            }
            Log.d("MicroMsg.FaceFlashManagerCamera", "new ratio=".concat(String.valueOf(((double) this.mDesiredPreviewWidth) / ((double) this.mDesiredPreviewHeight))));
            a(parameters);
            List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
            Log.d("MicroMsg.FaceFlashManagerCamera", "range:" + supportedPreviewFpsRange.size());
            for (int i3 = 0; i3 < supportedPreviewFpsRange.size(); i3++) {
                int[] iArr = supportedPreviewFpsRange.get(i3);
                for (int i4 = 0; i4 < iArr.length; i4++) {
                    Log.i("MicroMsg.FaceFlashManagerCamera", "Camera SupportedPreviewFpsRange：", Integer.valueOf(iArr[i4]));
                }
            }
            Log.i("MicroMsg.FaceFlashManagerCamera", "Camera preview-fps-range：" + parameters.get("preview-fps-range"));
            Log.i("MicroMsg.FaceFlashManagerCamera", "Camera preview-fps-range：" + parameters.get("preview-frame-rate"));
            try {
                this.sZb.setParameters(parameters);
            } catch (Exception e4) {
                Log.printErrStackTrace("MicroMsg.FaceFlashManagerCamera", e4, "setParameters error", new Object[0]);
            }
            boolean z3 = this.sZc;
            AppMethodBeat.o(186514);
            return z3;
        } catch (Exception e5) {
            Log.printErrStackTrace("MicroMsg.FaceFlashManagerCamera", e5, "camera getParameters error: %s", e5.getMessage());
            AppMethodBeat.o(186514);
            return false;
        }
    }

    public final void a(SurfaceTexture surfaceTexture, final Camera.PreviewCallback previewCallback) {
        AppMethodBeat.i(186515);
        if (k(surfaceTexture)) {
            this.sZb.setPreviewCallbackWithBuffer(new Camera.PreviewCallback() {
                /* class com.tencent.mm.plugin.flash.b.AnonymousClass2 */

                public final void onPreviewFrame(byte[] bArr, Camera camera) {
                    AppMethodBeat.i(186507);
                    if (previewCallback != null) {
                        previewCallback.onPreviewFrame(bArr, camera);
                    }
                    camera.addCallbackBuffer(bArr);
                    AppMethodBeat.o(186507);
                }
            });
        }
        AppMethodBeat.o(186515);
    }

    public final boolean a(final SurfaceTexture surfaceTexture, final a aVar) {
        AppMethodBeat.i(186516);
        Log.i("MicroMsg.FaceFlashManagerCamera", "mIsPreviewing is " + this.sZd);
        if (this.sZb != null && !this.sZd) {
            this.sZd = true;
            this.sZa.post(new Runnable() {
                /* class com.tencent.mm.plugin.flash.b.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(186508);
                    try {
                        b.this.sZb.setPreviewTexture(surfaceTexture);
                        c.dj(b.this.mDesiredPreviewWidth, b.this.mDesiredPreviewHeight);
                        b.this.sZb.startPreview();
                        AppMethodBeat.o(186508);
                    } catch (IOException e2) {
                        Log.i("MicroMsg.FaceFlashManagerCamera", "start Preview failed ：" + e2.getMessage());
                        b.this.sZd = false;
                        if (aVar != null) {
                            aVar.a(Boolean.FALSE, null);
                        }
                        AppMethodBeat.o(186508);
                    }
                }
            });
            Log.i("MicroMsg.FaceFlashManagerCamera", "start preview, is previewing");
        }
        boolean z = this.sZd;
        AppMethodBeat.o(186516);
        return z;
    }

    public final boolean k(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(186517);
        boolean a2 = a(surfaceTexture, new a() {
            /* class com.tencent.mm.plugin.flash.b.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.flash.b.a
            public final void a(Boolean bool, b bVar) {
            }
        });
        AppMethodBeat.o(186517);
        return a2;
    }

    public final void setPreviewCallback(final Camera.PreviewCallback previewCallback) {
        AppMethodBeat.i(186518);
        if (this.sZb == null) {
            Log.w("MicroMsg.FaceFlashManagerCamera", "hy: camera is null. setPreviewCallback failed");
            AppMethodBeat.o(186518);
            return;
        }
        int bitsPerPixel = ((this.mDesiredPreviewWidth * this.mDesiredPreviewHeight) * ImageFormat.getBitsPerPixel(this.sZb.getParameters().getPreviewFormat())) / 8;
        for (int i2 = 0; i2 < 5; i2++) {
            this.sZb.addCallbackBuffer(c.sQB.h(Integer.valueOf(bitsPerPixel)));
        }
        this.sZb.setPreviewCallbackWithBuffer(new Camera.PreviewCallback() {
            /* class com.tencent.mm.plugin.flash.b.AnonymousClass5 */

            public final void onPreviewFrame(byte[] bArr, Camera camera) {
                AppMethodBeat.i(186509);
                if (previewCallback != null) {
                    previewCallback.onPreviewFrame(bArr, camera);
                }
                camera.addCallbackBuffer(bArr);
                AppMethodBeat.o(186509);
            }
        });
        com.tencent.mm.plugin.facedetect.model.d.cSR().a(this.sVF);
        AppMethodBeat.o(186518);
    }

    public final void stopPreview() {
        AppMethodBeat.i(186519);
        Log.i("MicroMsg.FaceFlashManagerCamera", "stopPreview, isPreviewing: %s", Boolean.valueOf(this.sZd));
        if (this.sZb != null && !this.sZb.gIJ && this.sZd) {
            Log.i("MicroMsg.FaceFlashManagerCamera", "just stopPreview");
            this.sZb.stopPreview();
            this.sZd = false;
            c.sQB.aRR();
        }
        AppMethodBeat.o(186519);
    }

    private void cUd() {
        AppMethodBeat.i(186520);
        if (this.sYZ == null) {
            Log.i("MicroMsg.FaceFlashManagerCamera", "start camera thread");
            this.sYZ = com.tencent.f.c.d.hB("cameraBackground", 5);
            this.sYZ.start();
            this.sZa = new MMHandler(this.sYZ.getLooper());
        }
        AppMethodBeat.o(186520);
    }

    private static Point a(Camera.Parameters parameters, Point point) {
        int i2;
        int i3;
        float f2;
        AppMethodBeat.i(186521);
        ArrayList<Camera.Size> arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new C1357b((byte) 0));
        Point point2 = null;
        float f3 = ((float) point.x) / ((float) point.y);
        Log.d("MicroMsg.FaceFlashManagerCamera", "screen.x: %d, screen.y: %d, ratio: %f", Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(f3));
        long availableMemoryMB = Util.getAvailableMemoryMB(MMApplicationContext.getContext());
        Log.d("MicroMsg.FaceFlashManagerCamera", "systemAvailableMemInMB: %d", Long.valueOf(availableMemoryMB));
        int i4 = point.x;
        int i5 = point.y;
        float f4 = Float.POSITIVE_INFINITY;
        for (Camera.Size size : arrayList) {
            int i6 = size.width;
            int i7 = size.height;
            Log.i("MicroMsg.FaceFlashManagerCamera", "realWidth: %d, realHeight: %d", Integer.valueOf(i6), Integer.valueOf(i7));
            int i8 = i6 * i7;
            if (i8 >= 150400 && i8 <= 983040) {
                boolean z = i6 > i7;
                if (z) {
                    i2 = i7;
                } else {
                    i2 = i6;
                }
                if (z) {
                    i3 = i6;
                } else {
                    i3 = i7;
                }
                Log.d("MicroMsg.FaceFlashManagerCamera", "maybeFlippedWidth: %d, maybeFlippedHeight: %d", Integer.valueOf(i2), Integer.valueOf(i3));
                if (i2 == point.x && i3 == point.y && k(i2, i3, availableMemoryMB)) {
                    Point point3 = new Point(i6, i7);
                    Log.i("MicroMsg.FaceFlashManagerCamera", "Found preview size exactly matching screen size: ".concat(String.valueOf(point3)));
                    AppMethodBeat.o(186521);
                    return point3;
                }
                float abs = Math.abs((((float) i2) / ((float) i3)) - f3);
                if (i6 % 10 == 0) {
                    if (abs >= f4 || !k(i6, i7, availableMemoryMB)) {
                        f2 = f4;
                    } else {
                        f2 = abs;
                        point2 = new Point(i6, i7);
                    }
                    Log.i("MicroMsg.FaceFlashManagerCamera", "diff:[%s] newdiff:[%s] w:[%s] h:[%s]", Float.valueOf(f2), Float.valueOf(abs), Integer.valueOf(i6), Integer.valueOf(i7));
                    f4 = f2;
                }
            }
        }
        if (point2 == null) {
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                point2 = new Point(previewSize.width, previewSize.height);
                Log.i("MicroMsg.FaceFlashManagerCamera", "No suitable preview sizes, using default: ".concat(String.valueOf(point2)));
            } else {
                Log.e("MicroMsg.FaceFlashManagerCamera", "hy: can not find default size!!");
            }
        }
        Log.i("MicroMsg.FaceFlashManagerCamera", "Found best approximate preview size: ".concat(String.valueOf(point2)));
        AppMethodBeat.o(186521);
        return point2;
    }

    private static void a(Camera.Parameters parameters) {
        boolean z;
        AppMethodBeat.i(186522);
        if (ae.gKt.gFP > 0) {
            Log.i("MicroMsg.FaceFlashManagerCamera", "set frame rate > 0, do not try set preview fps range");
            AppMethodBeat.o(186522);
            return;
        }
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        if (supportedPreviewFpsRange == null || supportedPreviewFpsRange.size() == 0) {
            AppMethodBeat.o(186522);
            return;
        }
        int i2 = Integer.MIN_VALUE;
        int i3 = Integer.MIN_VALUE;
        boolean z2 = false;
        int size = supportedPreviewFpsRange.size();
        int i4 = 0;
        while (i4 < size) {
            int[] iArr = supportedPreviewFpsRange.get(i4);
            if (iArr != null && iArr.length > 1) {
                int i5 = iArr[0];
                int i6 = iArr[1];
                Log.i("MicroMsg.FaceFlashManagerCamera", "dkfps %d:[%d %d]", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
                if (i5 >= 0 && i6 >= i5) {
                    if (i6 >= i3 && !z2) {
                        i3 = i6;
                        i2 = i5;
                    }
                    if (i6 >= 30000) {
                        z = true;
                        i4++;
                        z2 = z;
                    }
                }
            }
            z = z2;
            i4++;
            z2 = z;
        }
        Log.i("MicroMsg.FaceFlashManagerCamera", "dkfps get fit  [%d %d], max target fps %d", Integer.valueOf(i2), Integer.valueOf(i3), 30);
        if (i2 == Integer.MAX_VALUE || i3 == Integer.MAX_VALUE) {
            AppMethodBeat.o(186522);
            return;
        }
        try {
            parameters.setPreviewFpsRange(i2, i3);
            Log.i("MicroMsg.FaceFlashManagerCamera", "set fps range %d %d", Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(186522);
        } catch (Exception e2) {
            Log.i("MicroMsg.FaceFlashManagerCamera", "trySetPreviewFpsRangeParameters Exception, %s, %s", Looper.myLooper(), e2.getMessage());
            AppMethodBeat.o(186522);
        }
    }

    public final void dKU() {
        AppMethodBeat.i(186523);
        if (this.sZa != null) {
            this.sZa.post(new Runnable() {
                /* class com.tencent.mm.plugin.flash.b.AnonymousClass7 */

                public final void run() {
                    AppMethodBeat.i(186511);
                    b bVar = b.this;
                    Log.i("MicroMsg.FaceFlashManagerCamera", "closeCamera start");
                    com.tencent.mm.plugin.facedetect.model.d.cSR().b(bVar.sVF);
                    if (bVar.sZb != null) {
                        try {
                            if (bVar.sZd) {
                                bVar.sZd = false;
                                bVar.sZb.stopPreview();
                                bVar.sZb.setPreviewCallback(null);
                                Log.i("MicroMsg.FaceFlashManagerCamera", "stop preview, not previewing");
                            }
                        } catch (Exception e2) {
                            Log.i("MicroMsg.FaceFlashManagerCamera", "Error setting camera preview: " + e2.getMessage());
                        }
                        try {
                            bVar.sZb.release();
                            bVar.sZb = null;
                            bVar.sZb = null;
                        } catch (Exception e3) {
                            Log.i("MicroMsg.FaceFlashManagerCamera", "Error setting camera preview: " + e3.getMessage());
                            bVar.sZb = null;
                        } catch (Throwable th) {
                            bVar.sZb = null;
                            AppMethodBeat.o(186511);
                            throw th;
                        }
                    }
                    Log.i("MicroMsg.FaceFlashManagerCamera", "closeCamera end");
                    b bVar2 = b.this;
                    if (bVar2.sYZ == null) {
                        AppMethodBeat.o(186511);
                        return;
                    }
                    if (bVar2.sZa != null) {
                        bVar2.sZa.removeCallbacksAndMessages(null);
                    }
                    Log.i("MicroMsg.FaceFlashManagerCamera", "stop camera thread");
                    if (Build.VERSION.SDK_INT >= 18) {
                        bVar2.sYZ.quitSafely();
                    } else {
                        bVar2.sYZ.quit();
                    }
                    bVar2.sYZ = null;
                    bVar2.sZa = null;
                    bVar2.mContext = null;
                    Log.i("MicroMsg.FaceFlashManagerCamera", "stop camera thread finish");
                    AppMethodBeat.o(186511);
                }
            });
            AppMethodBeat.o(186523);
            return;
        }
        Log.i("MicroMsg.FaceFlashManagerCamera", "back thread is not running");
        AppMethodBeat.o(186523);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.flash.b$b  reason: collision with other inner class name */
    public static class C1357b implements Comparator<Camera.Size> {
        private C1357b() {
        }

        /* synthetic */ C1357b(byte b2) {
            this();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(Camera.Size size, Camera.Size size2) {
            Camera.Size size3 = size;
            Camera.Size size4 = size2;
            int i2 = size3.height * size3.width;
            int i3 = size4.height * size4.width;
            if (i3 < i2) {
                return -1;
            }
            if (i3 > i2) {
                return 1;
            }
            return 0;
        }
    }

    private static boolean k(int i2, int i3, long j2) {
        AppMethodBeat.i(186524);
        double d2 = ((((((double) i2) * ((double) i3)) * 3.0d) / 2.0d) / 1024.0d) / 1024.0d;
        Log.d("MicroMsg.FaceFlashManagerCamera", "dataSizeInMB: %f, availableMemInMb: %d", Double.valueOf(d2), Long.valueOf(j2));
        if (((double) j2) / d2 >= 5.0d) {
            AppMethodBeat.o(186524);
            return true;
        }
        AppMethodBeat.o(186524);
        return false;
    }

    public final Point getPreviewSize() {
        AppMethodBeat.i(186525);
        try {
            String str = this.sZb.getParameters().get("preview-size");
            Log.i("MicroMsg.FaceFlashManagerCamera", "preview size:%s", str);
            String[] split = str.split("x");
            this.mDesiredPreviewWidth = Integer.parseInt(split[0]);
            this.mDesiredPreviewHeight = Integer.parseInt(split[1]);
        } catch (Exception e2) {
        }
        Point point = new Point(this.mDesiredPreviewWidth, this.mDesiredPreviewHeight);
        AppMethodBeat.o(186525);
        return point;
    }

    public final float getAspectRatio() {
        AppMethodBeat.i(186526);
        try {
            String str = this.sZb.getParameters().get("preview-size");
            Log.i("MicroMsg.FaceFlashManagerCamera", "preview size:%s", str);
            String[] split = str.split("x");
            float parseInt = (((float) Integer.parseInt(split[0])) * 1.0f) / ((float) Integer.parseInt(split[1]));
            AppMethodBeat.o(186526);
            return parseInt;
        } catch (Exception e2) {
            AppMethodBeat.o(186526);
            return 1.0f;
        }
    }
}
