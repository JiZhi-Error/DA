package com.tencent.liteav.capturer;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.tavkit.component.TAVExporter;
import com.tencent.tavkit.component.TAVPlayer;
import com.tencent.wxmm.v2helper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class a implements Camera.AutoFocusCallback, Camera.ErrorCallback, Camera.PreviewCallback {

    /* renamed from: a  reason: collision with root package name */
    private Matrix f657a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private int f658b = 0;

    /* renamed from: c  reason: collision with root package name */
    private Camera f659c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f660d = true;

    /* renamed from: e  reason: collision with root package name */
    private b f661e;

    /* renamed from: f  reason: collision with root package name */
    private int f662f = 15;

    /* renamed from: g  reason: collision with root package name */
    private int f663g = 1;

    /* renamed from: h  reason: collision with root package name */
    private int f664h;

    /* renamed from: i  reason: collision with root package name */
    private int f665i;

    /* renamed from: j  reason: collision with root package name */
    private int f666j;
    private int k;
    private SurfaceTexture l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p = false;
    private int q;
    private int r;
    private boolean s = false;
    private boolean t = false;

    /* renamed from: com.tencent.liteav.capturer.a$a  reason: collision with other inner class name */
    public enum EnumC0158a {
        RESOLUTION_INVALID(-1, -1),
        RESOLUTION_180_320(TXLiveConstants.RENDER_ROTATION_180, 320),
        RESOLUTION_270_480(270, 480),
        RESOLUTION_320_480(320, 480),
        RESOLUTION_360_640(v2helper.VOIP_ENC_HEIGHT_LV1, 640),
        RESOLUTION_540_960(TAVPlayer.VIDEO_PLAYER_WIDTH, 960),
        RESOLUTION_720_1280(TAVExporter.VIDEO_EXPORT_WIDTH, TAVExporter.VIDEO_EXPORT_HEIGHT),
        RESOLUTION_1080_1920(1080, 1920),
        RESOLUTION_HIGHEST(1080, 1920);
        
        private final int mHeight;
        private final int mWidth;

        static /* synthetic */ int a(EnumC0158a aVar) {
            AppMethodBeat.i(222315);
            int a2 = aVar.a();
            AppMethodBeat.o(222315);
            return a2;
        }

        static /* synthetic */ int b(EnumC0158a aVar) {
            AppMethodBeat.i(222316);
            int b2 = aVar.b();
            AppMethodBeat.o(222316);
            return b2;
        }

        public static EnumC0158a valueOf(String str) {
            AppMethodBeat.i(222314);
            EnumC0158a aVar = (EnumC0158a) Enum.valueOf(EnumC0158a.class, str);
            AppMethodBeat.o(222314);
            return aVar;
        }

        static {
            AppMethodBeat.i(222317);
            AppMethodBeat.o(222317);
        }

        private EnumC0158a(int i2, int i3) {
            this.mWidth = i2;
            this.mHeight = i3;
        }

        private int a() {
            return this.mWidth;
        }

        private int b() {
            return this.mHeight;
        }
    }

    public a() {
        AppMethodBeat.i(15504);
        AppMethodBeat.o(15504);
    }

    public void a(b bVar) {
        this.f661e = bVar;
    }

    public void a(SurfaceTexture surfaceTexture) {
        this.l = surfaceTexture;
    }

    public Camera.Parameters a() {
        Camera.Parameters parameters = null;
        AppMethodBeat.i(222318);
        if (this.f659c == null) {
            AppMethodBeat.o(222318);
        } else {
            try {
                parameters = this.f659c.getParameters();
                AppMethodBeat.o(222318);
            } catch (Exception e2) {
                TXCLog.e("TXCCameraCapturer", "getCameraParameters error ", e2);
                AppMethodBeat.o(222318);
            }
        }
        return parameters;
    }

    public boolean b() {
        Camera.Parameters a2;
        AppMethodBeat.i(15506);
        if (this.f659c == null || (a2 = a()) == null || a2.getMaxZoom() <= 0 || !a2.isZoomSupported()) {
            AppMethodBeat.o(15506);
            return false;
        }
        AppMethodBeat.o(15506);
        return true;
    }

    public boolean c() {
        AppMethodBeat.i(222319);
        if (this.f659c != null) {
            Camera.Parameters a2 = a();
            if (a2 != null) {
                List<String> supportedFlashModes = a2.getSupportedFlashModes();
                if (supportedFlashModes == null || !supportedFlashModes.contains("torch")) {
                    AppMethodBeat.o(222319);
                    return false;
                }
                AppMethodBeat.o(222319);
                return true;
            }
            AppMethodBeat.o(222319);
            return false;
        }
        AppMethodBeat.o(222319);
        return false;
    }

    public boolean d() {
        AppMethodBeat.i(15507);
        boolean z = this.m;
        AppMethodBeat.o(15507);
        return z;
    }

    public boolean e() {
        AppMethodBeat.i(222320);
        if (this.f659c != null) {
            Camera.Parameters a2 = a();
            if (a2 == null || a2.getMaxNumDetectedFaces() <= 0) {
                AppMethodBeat.o(222320);
                return false;
            }
            AppMethodBeat.o(222320);
            return true;
        }
        AppMethodBeat.o(222320);
        return false;
    }

    public boolean a(boolean z) {
        AppMethodBeat.i(15508);
        this.o = z;
        if (this.f659c != null) {
            boolean z2 = true;
            Camera.Parameters a2 = a();
            if (a2 == null) {
                AppMethodBeat.o(15508);
                return false;
            }
            List<String> supportedFlashModes = a2.getSupportedFlashModes();
            if (z) {
                if (supportedFlashModes == null || !supportedFlashModes.contains("torch")) {
                    z2 = false;
                } else {
                    TXCLog.i("TXCCameraCapturer", "set FLASH_MODE_TORCH");
                    a2.setFlashMode("torch");
                }
            } else if (supportedFlashModes == null || !supportedFlashModes.contains("off")) {
                z2 = false;
            } else {
                TXCLog.i("TXCCameraCapturer", "set FLASH_MODE_OFF");
                a2.setFlashMode("off");
            }
            try {
                this.f659c.setParameters(a2);
            } catch (Exception e2) {
                TXCLog.e("TXCCameraCapturer", "setParameters failed.", e2);
                z2 = false;
            }
            AppMethodBeat.o(15508);
            return z2;
        }
        AppMethodBeat.o(15508);
        return false;
    }

    public void a(EnumC0158a aVar) {
        AppMethodBeat.i(222321);
        if (aVar != EnumC0158a.RESOLUTION_INVALID) {
            this.q = EnumC0158a.a(aVar);
            this.r = EnumC0158a.b(aVar);
        }
        TXCLog.i("TXCCameraCapturer", "set resolution ".concat(String.valueOf(aVar)));
        AppMethodBeat.o(222321);
    }

    public void a(int i2) {
        this.f662f = i2;
    }

    public void b(boolean z) {
        AppMethodBeat.i(222322);
        this.t = z;
        TXCLog.i("TXCCameraCapturer", "set performance mode to ".concat(String.valueOf(z)));
        AppMethodBeat.o(222322);
    }

    public void a(float f2, float f3) {
        AppMethodBeat.i(15509);
        if (!this.s) {
            AppMethodBeat.o(15509);
            return;
        }
        try {
            this.f659c.cancelAutoFocus();
            Camera.Parameters parameters = this.f659c.getParameters();
            if (this.m) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Camera.Area(a(f2, f3, 2.0f), 1000));
                parameters.setFocusAreas(arrayList);
            }
            if (this.n) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(new Camera.Area(a(f2, f3, 3.0f), 1000));
                parameters.setMeteringAreas(arrayList2);
            }
            try {
                this.f659c.setParameters(parameters);
                this.f659c.autoFocus(this);
                AppMethodBeat.o(15509);
            } catch (Exception e2) {
                AppMethodBeat.o(15509);
            }
        } catch (Exception e3) {
            AppMethodBeat.o(15509);
        }
    }

    public void c(boolean z) {
        this.s = z;
    }

    private Rect a(float f2, float f3, float f4) {
        int i2 = 1000;
        AppMethodBeat.i(15510);
        float f5 = 200.0f * f4;
        if (this.f660d) {
            f2 = 1.0f - f2;
        }
        for (int i3 = 0; i3 < this.f666j / 90; i3++) {
            f2 = (-(-(f3 - 0.5f))) + 0.5f;
            f3 = (-(f2 - 0.5f)) + 0.5f;
        }
        int i4 = (int) ((f2 * 2000.0f) - 1000.0f);
        int i5 = (int) ((f3 * 2000.0f) - 1000.0f);
        int i6 = i4 < -1000 ? -1000 : i4;
        int i7 = i5 < -1000 ? -1000 : i5;
        int i8 = i6 + ((int) f5);
        int i9 = ((int) f5) + i7;
        if (i8 > 1000) {
            i8 = 1000;
        }
        if (i9 <= 1000) {
            i2 = i9;
        }
        Rect rect = new Rect(i6, i7, i8, i2);
        AppMethodBeat.o(15510);
        return rect;
    }

    public int f() {
        AppMethodBeat.i(222323);
        int i2 = 0;
        Camera.Parameters a2 = a();
        if (a2 != null && a2.getMaxZoom() > 0 && a2.isZoomSupported()) {
            i2 = a2.getMaxZoom();
        }
        AppMethodBeat.o(222323);
        return i2;
    }

    public boolean b(int i2) {
        boolean z = false;
        AppMethodBeat.i(222324);
        if (this.f659c != null) {
            Camera.Parameters a2 = a();
            if (a2 == null || a2.getMaxZoom() <= 0 || !a2.isZoomSupported()) {
                TXCLog.e("TXCCameraCapturer", "camera not support zoom!");
            } else if (i2 < 0 || i2 > a2.getMaxZoom()) {
                TXCLog.e("TXCCameraCapturer", "invalid zoom value : " + i2 + ", while max zoom is " + a2.getMaxZoom());
            } else {
                try {
                    a2.setZoom(i2);
                    this.f659c.setParameters(a2);
                    z = true;
                } catch (Exception e2) {
                    TXCLog.e("TXCCameraCapturer", "set zoom failed.", e2);
                }
            }
        }
        AppMethodBeat.o(222324);
        return z;
    }

    public void a(boolean z, int i2, int i3) {
        AppMethodBeat.i(222325);
        this.p = z;
        this.q = i2;
        this.r = i3;
        TXCLog.i("TXCCameraCapturer", "setCaptureBuffer %b, width: %d, height: %d", Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(222325);
    }

    public void a(float f2) {
        float f3 = 1.0f;
        float f4 = -1.0f;
        AppMethodBeat.i(15513);
        if (this.f659c != null) {
            if (f2 <= 1.0f) {
                f3 = f2;
            }
            if (f3 >= -1.0f) {
                f4 = f3;
            }
            Camera.Parameters a2 = a();
            if (a2 == null) {
                TXCLog.e("TXCCameraCapturer", "camera setExposureCompensation camera parameter is null");
                AppMethodBeat.o(15513);
                return;
            }
            int minExposureCompensation = a2.getMinExposureCompensation();
            int maxExposureCompensation = a2.getMaxExposureCompensation();
            if (minExposureCompensation == 0 || maxExposureCompensation == 0) {
                TXCLog.e("TXCCameraCapturer", "camera not support setExposureCompensation!");
            } else {
                int e2 = c.a().e();
                float f5 = f4 * ((float) maxExposureCompensation);
                if (e2 != 0 && e2 <= maxExposureCompensation && e2 >= minExposureCompensation) {
                    TXCLog.i("TXCCameraCapturer", "camera setExposureCompensation: ".concat(String.valueOf(e2)));
                    a2.setExposureCompensation(e2);
                } else if (f5 <= ((float) maxExposureCompensation) && f5 >= ((float) minExposureCompensation)) {
                    TXCLog.i("TXCCameraCapturer", "camera setExposureCompensation: ".concat(String.valueOf(f5)));
                    a2.setExposureCompensation((int) f5);
                }
            }
            try {
                this.f659c.setParameters(a2);
                AppMethodBeat.o(15513);
                return;
            } catch (Exception e3) {
                TXCLog.e("TXCCameraCapturer", "setExposureCompensation failed.", e3);
            }
        }
        AppMethodBeat.o(15513);
    }

    public void c(int i2) {
        AppMethodBeat.i(222326);
        TXCLog.w("TXCCameraCapturer", "vsize setHomeOrientation ".concat(String.valueOf(i2)));
        this.f663g = i2;
        this.f666j = (((this.k - 90) + (this.f663g * 90)) + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
        AppMethodBeat.o(222326);
    }

    public int d(boolean z) {
        int i2;
        AppMethodBeat.i(222327);
        try {
            TXCLog.i("TXCCameraCapturer", "trtc_capture: start capture");
            if (this.l == null) {
                AppMethodBeat.o(222327);
                return -2;
            }
            if (this.f659c != null) {
                g();
            }
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            int i3 = -1;
            int i4 = -1;
            for (int i5 = 0; i5 < Camera.getNumberOfCameras(); i5++) {
                Camera.getCameraInfo(i5, cameraInfo);
                TXCLog.i("TXCCameraCapturer", "camera index " + i5 + ", facing = " + cameraInfo.facing);
                if (cameraInfo.facing == 1 && i4 == -1) {
                    i4 = i5;
                }
                if (cameraInfo.facing == 0 && i3 == -1) {
                    i3 = i5;
                }
            }
            TXCLog.i("TXCCameraCapturer", "camera front, id = ".concat(String.valueOf(i4)));
            TXCLog.i("TXCCameraCapturer", "camera back , id = ".concat(String.valueOf(i3)));
            if (i4 != -1 || i3 == -1) {
                i2 = i4;
            } else {
                i2 = i3;
            }
            if (i3 == -1 && i2 != -1) {
                i3 = i2;
            }
            this.f660d = z;
            if (this.f660d) {
                this.f659c = Camera.open(i2);
            } else {
                this.f659c = Camera.open(i3);
            }
            Camera.Parameters parameters = this.f659c.getParameters();
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            if (this.s && supportedFocusModes != null && supportedFocusModes.contains("auto")) {
                TXCLog.i("TXCCameraCapturer", "support FOCUS_MODE_AUTO");
                parameters.setFocusMode("auto");
            } else if (supportedFocusModes != null && supportedFocusModes.contains("continuous-video")) {
                TXCLog.i("TXCCameraCapturer", "support FOCUS_MODE_CONTINUOUS_VIDEO");
                parameters.setFocusMode("continuous-video");
            }
            if (Build.VERSION.SDK_INT >= 14) {
                if (parameters.getMaxNumFocusAreas() > 0) {
                    this.m = true;
                }
                if (parameters.getMaxNumMeteringAreas() > 0) {
                    this.n = true;
                }
            }
            if (this.p) {
                parameters.setPreviewFormat(17);
                this.f659c.setPreviewCallback(this);
            }
            d b2 = b(this.t, this.q, this.r);
            d a2 = a(parameters, Math.max(b2.f460a, b2.f461b), Math.min(b2.f460a, b2.f461b));
            this.f664h = a2.f460a;
            this.f665i = a2.f461b;
            parameters.setPreviewSize(this.f664h, this.f665i);
            int[] e2 = e(this.f662f);
            if (e2 != null) {
                parameters.setPreviewFpsRange(e2[0], e2[1]);
            } else {
                parameters.setPreviewFrameRate(d(this.f662f));
            }
            if (this.f660d) {
                i3 = i2;
            }
            this.k = f(i3);
            this.f666j = (((this.k - 90) + (this.f663g * 90)) + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
            this.f659c.setDisplayOrientation(0);
            TXCLog.i("TXCCameraCapturer", "vsize camera orientation " + this.k + ", preview " + this.f666j + ", home orientation " + this.f663g);
            this.f659c.setPreviewTexture(this.l);
            this.f659c.setParameters(parameters);
            this.f659c.setErrorCallback(this);
            this.f659c.startPreview();
            AppMethodBeat.o(222327);
            return 0;
        } catch (IOException e3) {
            TXCLog.e("TXCCameraCapturer", "open camera failed." + e3.getMessage());
            AppMethodBeat.o(222327);
            return -1;
        } catch (Exception e4) {
            TXCLog.e("TXCCameraCapturer", "open camera failed." + e4.getMessage());
            AppMethodBeat.o(222327);
            return -1;
        }
    }

    private static d b(boolean z, int i2, int i3) {
        AppMethodBeat.i(222328);
        if (z) {
            d dVar = new d(i2, i3);
            AppMethodBeat.o(222328);
            return dVar;
        }
        d[] dVarArr = {new d(1080, 1920)};
        float min = (float) Math.min(i2, i3);
        float max = (float) Math.max(i2, i3);
        int i4 = 0;
        while (true) {
            if (i4 > 0) {
                break;
            }
            d dVar2 = dVarArr[0];
            if (min <= ((float) dVar2.f460a) && max <= ((float) dVar2.f461b)) {
                float min2 = Math.min(((float) dVar2.f460a) / min, ((float) dVar2.f461b) / max);
                i2 = (int) (((float) i2) * min2);
                i3 = (int) (min2 * ((float) i3));
                break;
            }
            i4++;
        }
        d dVar3 = new d(i2, i3);
        AppMethodBeat.o(222328);
        return dVar3;
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        AppMethodBeat.i(15516);
        b bVar = this.f661e;
        if (bVar != null) {
            bVar.a(bArr);
        }
        AppMethodBeat.o(15516);
    }

    public void g() {
        AppMethodBeat.i(222329);
        if (this.f659c != null) {
            try {
                this.f659c.setErrorCallback(null);
                this.f659c.setPreviewCallback(null);
                this.f659c.stopPreview();
                this.f659c.release();
            } catch (Exception e2) {
                TXCLog.e("TXCCameraCapturer", "stop capture failed.", e2);
            } finally {
                this.f659c = null;
                this.l = null;
                AppMethodBeat.o(222329);
            }
        } else {
            AppMethodBeat.o(222329);
        }
    }

    public int h() {
        return this.f666j;
    }

    public boolean i() {
        return this.f660d;
    }

    public int j() {
        return this.f664h;
    }

    public int k() {
        return this.f665i;
    }

    public Camera l() {
        return this.f659c;
    }

    private static d a(Camera.Parameters parameters, int i2, int i3) {
        int i4;
        AppMethodBeat.i(222330);
        TXCLog.d("TXCCameraCapturer", "camera preview wanted: %d x %d", Integer.valueOf(i2), Integer.valueOf(i3));
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        float f2 = (1.0f * ((float) i2)) / ((float) i3);
        ArrayList<Camera.Size> arrayList = new ArrayList();
        int i5 = Integer.MAX_VALUE;
        for (Camera.Size size : supportedPreviewSizes) {
            TXCLog.d("TXCCameraCapturer", "camera support preview size: %dx%d", Integer.valueOf(size.width), Integer.valueOf(size.height));
            if (size.width < 640 || size.height < 480) {
                i4 = Integer.MAX_VALUE;
            } else {
                i4 = Math.round(10.0f * Math.abs(((1.0f * ((float) size.width)) / ((float) size.height)) - f2));
            }
            if (i4 < i5) {
                arrayList.clear();
                arrayList.add(size);
                i5 = i4;
            } else if (i4 == i5) {
                arrayList.add(size);
            }
        }
        Collections.sort(arrayList, new Comparator<Camera.Size>() {
            /* class com.tencent.liteav.capturer.a.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(Camera.Size size, Camera.Size size2) {
                AppMethodBeat.i(15503);
                int a2 = a(size, size2);
                AppMethodBeat.o(15503);
                return a2;
            }

            public final int a(Camera.Size size, Camera.Size size2) {
                return (size2.width * size2.height) - (size.width * size.height);
            }
        });
        r0 = (Camera.Size) arrayList.get(0);
        float f3 = (float) (i2 * i3);
        float f4 = 2.14748365E9f;
        for (Camera.Size size2 : arrayList) {
            TXCLog.i("TXCCameraCapturer", "size in same buck: %dx%d", Integer.valueOf(size2.width), Integer.valueOf(size2.height));
            int i6 = size2.width * size2.height;
            if (((double) (((float) i6) / f3)) < 0.9d || Math.abs(((float) i6) - f3) >= f4) {
                size2 = size2;
            } else {
                f4 = Math.abs(((float) i6) - f3);
            }
        }
        TXCLog.i("TXCCameraCapturer", "best match preview size: %d x %d", Integer.valueOf(size2.width), Integer.valueOf(size2.height));
        d dVar = new d(size2.width, size2.height);
        AppMethodBeat.o(222330);
        return dVar;
    }

    public void onAutoFocus(boolean z, Camera camera) {
        AppMethodBeat.i(15521);
        if (z) {
            TXCLog.i("TXCCameraCapturer", "AUTO focus success");
            AppMethodBeat.o(15521);
            return;
        }
        TXCLog.i("TXCCameraCapturer", "AUTO focus failed");
        AppMethodBeat.o(15521);
    }

    public void onError(int i2, Camera camera) {
        AppMethodBeat.i(15522);
        TXCLog.w("TXCCameraCapturer", "camera catch error ".concat(String.valueOf(i2)));
        if ((i2 == 1 || i2 == 2 || i2 == 100) && this.f661e != null) {
            this.f661e.m();
        }
        AppMethodBeat.o(15522);
    }

    private int d(int i2) {
        int i3 = 1;
        AppMethodBeat.i(222331);
        Camera.Parameters a2 = a();
        if (a2 == null) {
            AppMethodBeat.o(222331);
        } else {
            List<Integer> supportedPreviewFrameRates = a2.getSupportedPreviewFrameRates();
            if (supportedPreviewFrameRates == null) {
                TXCLog.e("TXCCameraCapturer", "getSupportedFPS error");
                AppMethodBeat.o(222331);
            } else {
                i3 = supportedPreviewFrameRates.get(0).intValue();
                for (int i4 = 0; i4 < supportedPreviewFrameRates.size(); i4++) {
                    int intValue = supportedPreviewFrameRates.get(i4).intValue();
                    if (Math.abs(intValue - i2) - Math.abs(i3 - i2) < 0) {
                        i3 = intValue;
                    }
                }
                TXCLog.i("TXCCameraCapturer", "choose fps=".concat(String.valueOf(i3)));
                AppMethodBeat.o(222331);
            }
        }
        return i3;
    }

    private int[] e(int i2) {
        int[] iArr;
        AppMethodBeat.i(222332);
        int i3 = i2 * 1000;
        String str = "camera supported preview fps range: wantFPS = " + i3 + "\n";
        Camera.Parameters a2 = a();
        if (a2 == null) {
            AppMethodBeat.o(222332);
            return null;
        }
        List<int[]> supportedPreviewFpsRange = a2.getSupportedPreviewFpsRange();
        if (supportedPreviewFpsRange == null || supportedPreviewFpsRange.size() <= 0) {
            AppMethodBeat.o(222332);
            return null;
        }
        int[] iArr2 = supportedPreviewFpsRange.get(0);
        Collections.sort(supportedPreviewFpsRange, new Comparator<int[]>() {
            /* class com.tencent.liteav.capturer.a.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public /* synthetic */ int compare(int[] iArr, int[] iArr2) {
                AppMethodBeat.i(222312);
                int a2 = a(iArr, iArr2);
                AppMethodBeat.o(222312);
                return a2;
            }

            public int a(int[] iArr, int[] iArr2) {
                return iArr[1] - iArr2[1];
            }
        });
        for (int[] iArr3 : supportedPreviewFpsRange) {
            str = str + "camera supported preview fps range: " + iArr3[0] + " - " + iArr3[1] + "\n";
        }
        Iterator<int[]> it = supportedPreviewFpsRange.iterator();
        while (true) {
            if (!it.hasNext()) {
                iArr = iArr2;
                break;
            }
            iArr = it.next();
            if (iArr[0] <= i3 && i3 <= iArr[1]) {
                break;
            }
        }
        TXCLog.i("TXCCameraCapturer", str + "choose preview fps range: " + iArr[0] + " - " + iArr[1]);
        AppMethodBeat.o(222332);
        return iArr;
    }

    private int f(int i2) {
        int i3;
        AppMethodBeat.i(15523);
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i2, cameraInfo);
        TXCLog.i("TXCCameraCapturer", "vsize camera orientation " + cameraInfo.orientation + ", front " + (cameraInfo.facing == 1));
        int i4 = cameraInfo.orientation;
        if (i4 == 0 || i4 == 180) {
            i4 += 90;
        }
        if (cameraInfo.facing == 1) {
            i3 = (360 - i4) % v2helper.VOIP_ENC_HEIGHT_LV1;
        } else {
            i3 = (i4 + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
        }
        AppMethodBeat.o(15523);
        return i3;
    }
}
