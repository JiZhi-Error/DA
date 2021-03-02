package com.tencent.scanlib.a;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.scanlib.a.g;
import com.tencent.stubs.logger.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class a implements f {
    protected Point ROh = null;
    protected float ROi = 1.0f;
    protected int ROj = -1;
    protected int ROk;
    protected int ROl;
    protected volatile boolean VC = false;
    protected Camera gII;
    protected int mMaxZoom;
    protected volatile boolean sRE = false;
    protected Point sRF = null;
    protected Point sRG = null;
    protected boolean sRH;
    protected int sRI;
    protected boolean sRJ = false;
    protected boolean ztW = false;

    @Override // com.tencent.scanlib.a.f
    public final boolean dEO() {
        return this.sRE;
    }

    @Override // com.tencent.scanlib.a.f
    public final void r(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(3510);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.gII != null && !this.sRE) {
            if (surfaceTexture != null) {
                this.gII.setPreviewTexture(surfaceTexture);
            }
            if (this.sRF == null) {
                this.sRF = q(this.sRG);
                this.ROh = r(this.sRF);
            }
            Camera.Parameters parameters = this.gII.getParameters();
            parameters.setPreviewSize(this.sRF.x, this.sRF.y);
            this.gII.setParameters(parameters);
            this.gII.startPreview();
            this.sRE = true;
            Log.d("BaseScanCamera", String.format("startPreview done costTime=[%s]", Integer.valueOf((int) (System.currentTimeMillis() - currentTimeMillis))));
        }
        AppMethodBeat.o(3510);
    }

    @Override // com.tencent.scanlib.a.f
    public final void stopPreview() {
        AppMethodBeat.i(3511);
        if (this.gII != null) {
            this.gII.stopPreview();
            this.sRE = false;
        }
        AppMethodBeat.o(3511);
    }

    @Override // com.tencent.scanlib.a.f
    public final void a(Camera.PreviewCallback previewCallback) {
        AppMethodBeat.i(3512);
        if (this.gII != null) {
            try {
                this.gII.setOneShotPreviewCallback(previewCallback);
                AppMethodBeat.o(3512);
                return;
            } catch (RuntimeException e2) {
                Log.w("BaseScanCamera", "takeOneShot() " + e2.getMessage());
            }
        }
        AppMethodBeat.o(3512);
    }

    @Override // com.tencent.scanlib.a.f
    public final boolean isOpen() {
        return this.VC;
    }

    @Override // com.tencent.scanlib.a.f
    public final void aqD(int i2) {
        g.a.C2186a mu;
        AppMethodBeat.i(3513);
        if (this.VC) {
            Log.w("BaseScanCamera", "in open(), is open already");
            AppMethodBeat.o(3513);
            return;
        }
        int numberOfCameras = Camera.getNumberOfCameras();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int i3 = 0;
        while (true) {
            if (i3 >= numberOfCameras) {
                i3 = 0;
                break;
            }
            Camera.getCameraInfo(i3, cameraInfo);
            if (cameraInfo.facing == 0) {
                Log.d("ScanCameraUtil", String.format("cam get bid %d", Integer.valueOf(i3)));
                break;
            }
            i3++;
        }
        Log.d("ScanCameraUtil", String.format("cam getBackCameraId %d", Integer.valueOf(i3)));
        long currentTimeMillis = System.currentTimeMillis();
        if (Build.MODEL.equals("M9")) {
            new e();
            mu = e.hla();
        } else {
            Log.d("ScanCameraUtil", "openCamera(), CameraUtilImplAPI9, cameraId = ".concat(String.valueOf(i3)));
            new d();
            mu = d.mu(i3, i2);
        }
        if (mu == null) {
            Log.e("BaseScanCamera", "in open(), openCameraRes == null");
            AppMethodBeat.o(3513);
            return;
        }
        this.ztW = false;
        this.ROj = -1;
        this.sRI = mu.dYT;
        this.sRH = mu.dYT % TXLiveConstants.RENDER_ROTATION_180 != 0;
        Log.d("BaseScanCamera", String.format("openCamera done, cameraId=[%s] costTime=[%s] rotation[%d]", Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(this.sRI)));
        this.gII = mu.gII;
        if (this.gII == null) {
            Log.e("BaseScanCamera", "in open(), camera == null, bNeedRotate " + this.sRH);
            AppMethodBeat.o(3513);
            return;
        }
        this.VC = true;
        Camera.Parameters parameters = this.gII.getParameters();
        try {
            if (this.gII != null) {
                String str = parameters.get("zoom-supported");
                if (com.tencent.scanlib.a.isNullOrNil(str) || !Boolean.parseBoolean(str)) {
                    Log.i("BaseScanCamera", "not support zoom");
                } else {
                    List<Integer> zoomRatios = parameters.getZoomRatios();
                    if (zoomRatios != null && zoomRatios.size() > 0) {
                        this.ROl = 0;
                        this.mMaxZoom = (int) (((double) zoomRatios.size()) / 1.5d);
                        Log.d("BaseScanCamera", String.format("divideRatio: %f,max zoom: %d", Double.valueOf(1.5d), Integer.valueOf(this.mMaxZoom)));
                        if (this.mMaxZoom < this.ROl) {
                            this.mMaxZoom = this.ROl;
                        } else if (zoomRatios.get(this.mMaxZoom).intValue() > 400) {
                            this.mMaxZoom = J(zoomRatios, 400);
                        }
                        Log.i("BaseScanCamera", String.format("default zoom:%d,default ratio:%d,max zoom:%d,max ratio:%d", Integer.valueOf(this.ROl), zoomRatios.get(this.ROl), Integer.valueOf(this.mMaxZoom), zoomRatios.get(this.mMaxZoom)));
                    }
                }
            }
        } catch (Exception e2) {
            Log.e("BaseScanCamera", "init zoom exception! " + e2.getMessage());
        }
        boolean z = false;
        boolean z2 = false;
        List<Integer> supportedPreviewFormats = parameters.getSupportedPreviewFormats();
        Log.i("BaseScanCamera", "supportedPreviewFormat:".concat(String.valueOf(supportedPreviewFormats)));
        if (supportedPreviewFormats.contains(17)) {
            z = true;
        } else if (supportedPreviewFormats.contains(842094169)) {
            z2 = true;
        }
        if (z) {
            Log.i("BaseScanCamera", "Preview support NV21");
            parameters.setPreviewFormat(17);
        } else if (z2) {
            Log.i("BaseScanCamera", "Preview not support NV21, but support YV12");
            parameters.setPreviewFormat(842094169);
        } else {
            Log.i("BaseScanCamera", "Preview not support NV21 and YV12. Use format: " + supportedPreviewFormats.get(0));
            parameters.setPreviewFormat(supportedPreviewFormats.get(0).intValue());
        }
        this.gII.setParameters(parameters);
        try {
            hkY();
            AppMethodBeat.o(3513);
        } catch (Exception e3) {
            Log.e("BaseScanCamera", "set focus mode error: " + e3.getMessage());
            AppMethodBeat.o(3513);
        }
    }

    @Override // com.tencent.scanlib.a.f
    public final void close() {
        AppMethodBeat.i(3514);
        Log.i("BaseScanCamera", "close(), previewing " + this.sRE);
        if (this.gII != null) {
            this.VC = false;
            long currentTimeMillis = System.currentTimeMillis();
            this.gII.setPreviewCallback(null);
            this.gII.stopPreview();
            this.sRE = false;
            Log.i("BaseScanCamera", "stopPreview costTime " + (System.currentTimeMillis() - currentTimeMillis));
            long currentTimeMillis2 = System.currentTimeMillis();
            this.gII.release();
            this.gII = null;
            Log.i("BaseScanCamera", "camera.close() costTime " + (System.currentTimeMillis() - currentTimeMillis2));
        }
        this.ztW = false;
        this.sRJ = false;
        this.ROj = -1;
        this.sRH = false;
        AppMethodBeat.o(3514);
    }

    public final boolean hkT() {
        return this.sRH;
    }

    @Override // com.tencent.scanlib.a.f
    public final int getCameraRotation() {
        return this.sRI;
    }

    @Override // com.tencent.scanlib.a.f
    public final Point hkU() {
        return this.sRF;
    }

    @Override // com.tencent.scanlib.a.f
    public final Point hkV() {
        return this.ROh;
    }

    @Override // com.tencent.scanlib.a.f
    public final float hkW() {
        return this.ROi;
    }

    private Point o(Point point) {
        AppMethodBeat.i(3515);
        int i2 = (this.ROh.x - this.sRG.x) / 2;
        int i3 = (this.ROh.y - this.sRG.y) / 2;
        Point point2 = new Point(point.x + i2, point.y + i3);
        if (this.sRH) {
            i2 = (this.ROh.y - this.sRG.x) / 2;
            i3 = (this.ROh.x - this.sRG.y) / 2;
            point2 = new Point(point.y + i3, (this.sRG.x - point.x) + i2);
        }
        Log.d("BaseScanCamera", String.format("dx %d, dy %d", Integer.valueOf(i2), Integer.valueOf(i3)));
        Point point3 = new Point((int) (((float) point2.x) / this.ROi), (int) (((float) point2.y) / this.ROi));
        Log.i("BaseScanCamera", "viewPoint " + point + ", previewPoint " + point2 + ", scanPoint " + point3);
        AppMethodBeat.o(3515);
        return point3;
    }

    public final Rect w(Rect rect) {
        Point point;
        AppMethodBeat.i(3516);
        Rect rect2 = new Rect();
        Log.i("BaseScanCamera", String.format("visibleResolution:%s, previewResolution:%s", this.sRG, this.ROh));
        if (this.sRH) {
            point = new Point(rect.right, rect.top);
        } else {
            point = new Point(rect.left, rect.top);
        }
        Point o = o(point);
        Point o2 = o(this.sRH ? new Point(rect.left, rect.bottom) : new Point(rect.right, rect.bottom));
        rect2.set(o.x, o.y, o2.x, o2.y);
        Log.i("BaseScanCamera", String.format("uiRect %s, scanRect %s", rect, rect2));
        AppMethodBeat.o(3516);
        return rect2;
    }

    @Override // com.tencent.scanlib.a.f
    public final void p(Point point) {
        AppMethodBeat.i(3517);
        this.sRG = new Point(point);
        Log.d("BaseScanCamera", "set visible resolution: " + this.sRG);
        try {
            this.sRF = q(this.sRG);
            this.ROh = r(this.sRF);
            AppMethodBeat.o(3517);
        } catch (Exception e2) {
            Log.e("BaseScanCamera", "set preview size" + e2.getMessage());
            AppMethodBeat.o(3517);
        }
    }

    private Point q(Point point) {
        String str;
        AppMethodBeat.i(3518);
        Camera.Parameters parameters = this.gII.getParameters();
        String str2 = parameters.get("preview-size-values");
        if (str2 == null) {
            str = parameters.get("preview-size-value");
        } else {
            str = str2;
        }
        Point point2 = null;
        if (str != null) {
            Log.d("BaseScanCamera", "preview-size-values parameter: ".concat(String.valueOf(str)));
            point2 = b(parameters, point);
        }
        if (point2 == null) {
            point2 = new Point((point.x >> 3) << 3, (point.y >> 3) << 3);
        }
        AppMethodBeat.o(3518);
        return point2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.scanlib.a.a$a  reason: collision with other inner class name */
    public static class C2184a implements Comparator<Camera.Size> {
        private C2184a() {
        }

        /* synthetic */ C2184a(byte b2) {
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

    private Point b(Camera.Parameters parameters, Point point) {
        int min;
        float f2;
        AppMethodBeat.i(3520);
        ArrayList<Camera.Size> arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new C2184a((byte) 0));
        arrayList.remove(0);
        Point point2 = null;
        float f3 = ((float) point.x) / ((float) point.y);
        Log.d("BaseScanCamera", String.format("visible.x: %d, visible.y: %d, ratio: %f", Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(f3)));
        Log.i("BaseScanCamera", String.format("SCREEN_PIXELS: %s", Integer.valueOf(point.x * point.y)));
        float f4 = Float.POSITIVE_INFINITY;
        for (Camera.Size size : arrayList) {
            int i2 = size.width;
            int i3 = size.height;
            Log.i("BaseScanCamera", String.format("realWidth: %d, realHeight: %d", Integer.valueOf(i2), Integer.valueOf(i3)));
            if (!this.sRH) {
                min = i2;
            } else {
                min = Math.min(i2, i3);
            }
            int max = !this.sRH ? i3 : Math.max(i2, i3);
            Log.d("BaseScanCamera", String.format("maybeFlippedWidth: %d, maybeFlippedHeight: %d", Integer.valueOf(min), Integer.valueOf(max)));
            if (min == point.x && max == point.y) {
                Point point3 = new Point(i2, i3);
                Log.i("BaseScanCamera", "Found preview size exactly matching screen size: ".concat(String.valueOf(point3)));
                AppMethodBeat.o(3520);
                return point3;
            } else if (i2 * i3 >= 307200) {
                float abs = Math.abs((((float) min) / ((float) max)) - f3);
                if (abs < f4) {
                    f2 = abs;
                    point2 = new Point(i2, i3);
                } else {
                    f2 = f4;
                }
                Log.i("BaseScanCamera", String.format("diff:[%s] newdiff:[%s] w:[%s] h:[%s]", Float.valueOf(f2), Float.valueOf(abs), Integer.valueOf(i2), Integer.valueOf(i3)));
                f4 = f2;
            }
        }
        if (point2 == null) {
            Camera.Size previewSize = parameters.getPreviewSize();
            point2 = new Point(previewSize.width, previewSize.height);
            Log.i("BaseScanCamera", "No suitable preview sizes, using default: ".concat(String.valueOf(point2)));
        }
        Log.i("BaseScanCamera", "Found best approximate preview size: ".concat(String.valueOf(point2)));
        AppMethodBeat.o(3520);
        return point2;
    }

    public static int J(List<Integer> list, int i2) {
        int i3;
        AppMethodBeat.i(3521);
        if (list != null && list.size() > 0) {
            Log.i("BaseScanCamera", String.format("zoomRatios: %s,size: %d", list, Integer.valueOf(list.size())));
            i3 = Collections.binarySearch(list, Integer.valueOf(i2));
            Log.i("BaseScanCamera", "insert index: ".concat(String.valueOf(i3)));
            if (i3 < 0) {
                int i4 = -(i3 + 1);
                int i5 = i4 - 1;
                if (i4 < 0 || i4 > list.size() - 1 || i5 < 0 || i5 > list.size() - 1) {
                    if (i4 >= 0 && i4 <= list.size() - 1) {
                        i3 = i4;
                    } else if (i5 >= 0 && i5 <= list.size() - 1) {
                        i3 = i5;
                    }
                } else if (list.get(i4).intValue() - i2 > i2 - list.get(i5).intValue()) {
                    i3 = i5;
                } else {
                    i3 = i4;
                }
            }
            AppMethodBeat.o(3521);
            return i3;
        }
        i3 = 0;
        AppMethodBeat.o(3521);
        return i3;
    }

    public final void aqE(int i2) {
        int i3;
        AppMethodBeat.i(3522);
        if (this.gII != null && this.sRE && i2 > 0) {
            try {
                Camera.Parameters parameters = this.gII.getParameters();
                List<Integer> zoomRatios = parameters.getZoomRatios();
                if (zoomRatios == null || zoomRatios.size() <= 0) {
                    AppMethodBeat.o(3522);
                    return;
                }
                Log.d("BaseScanCamera", String.format("zoom to ratio:%d", Integer.valueOf(i2)));
                if (i2 >= zoomRatios.get(this.ROl).intValue() && i2 <= zoomRatios.get(this.mMaxZoom).intValue()) {
                    i3 = J(zoomRatios, i2);
                } else if (i2 < zoomRatios.get(this.ROl).intValue()) {
                    i3 = this.ROl;
                } else {
                    Log.i("BaseScanCamera", "exceed max zoom");
                    i3 = this.ROk + ((this.mMaxZoom - this.ROk) / 5);
                    if (i3 > this.mMaxZoom) {
                        i3 = this.mMaxZoom;
                    }
                }
                Log.i("BaseScanCamera", String.format("zoom:%d,ratio:%d", Integer.valueOf(i3), zoomRatios.get(i3)));
                this.ROk = i3;
                parameters.setZoom(i3);
                this.gII.setParameters(parameters);
                AppMethodBeat.o(3522);
                return;
            } catch (Exception e2) {
                Log.e("BaseScanCamera", "zoom scale exception:" + e2.getMessage());
            }
        }
        AppMethodBeat.o(3522);
    }

    public final void aqF(int i2) {
        AppMethodBeat.i(3523);
        if (this.gII != null && this.sRE) {
            try {
                Camera.Parameters parameters = this.gII.getParameters();
                List<Integer> zoomRatios = parameters.getZoomRatios();
                if (zoomRatios == null || zoomRatios.size() <= 0) {
                    AppMethodBeat.o(3523);
                    return;
                }
                Log.i("BaseScanCamera", String.format("zoom action:%d,beforeZoom:%d", Integer.valueOf(i2), Integer.valueOf(parameters.getZoom())));
                switch (i2) {
                    case 0:
                        this.ROk = 0;
                        break;
                    case 1:
                        this.ROk = this.ROl;
                        break;
                    case 2:
                        if (this.ROk < this.mMaxZoom) {
                            this.ROk++;
                            this.ROk = this.ROk > this.mMaxZoom ? this.mMaxZoom : this.ROk;
                            break;
                        }
                        break;
                    case 3:
                        if (this.ROk > this.ROl) {
                            this.ROk--;
                            this.ROk = this.ROk < this.ROl ? this.ROl : this.ROk;
                            break;
                        }
                        break;
                    case 4:
                        this.ROk = this.mMaxZoom;
                        break;
                    case 5:
                        if (this.ROk == this.ROl) {
                            this.ROk = this.mMaxZoom;
                            break;
                        } else {
                            this.ROk = this.ROl;
                            break;
                        }
                }
                parameters.setZoom(this.ROk);
                this.gII.setParameters(parameters);
                Log.i("BaseScanCamera", String.format("zoom action:%d,afterZoom:%d", Integer.valueOf(i2), Integer.valueOf(parameters.getZoom())));
                AppMethodBeat.o(3523);
                return;
            } catch (Exception e2) {
                Log.e("BaseScanCamera", "zoom action exception:" + e2.getMessage());
            }
        }
        AppMethodBeat.o(3523);
    }

    public final int hkX() {
        AppMethodBeat.i(3524);
        if (this.gII == null || this.gII.getParameters() == null || this.gII.getParameters().getZoomRatios() == null || this.gII.getParameters().getZoomRatios().size() <= 0) {
            AppMethodBeat.o(3524);
            return 100;
        }
        int intValue = this.gII.getParameters().getZoomRatios().get(this.ROk).intValue();
        AppMethodBeat.o(3524);
        return intValue;
    }

    @Override // com.tencent.scanlib.a.f
    public final void autoFocus(Camera.AutoFocusCallback autoFocusCallback) {
        AppMethodBeat.i(3525);
        if (this.gII != null && this.sRE) {
            try {
                this.gII.autoFocus(autoFocusCallback);
                AppMethodBeat.o(3525);
                return;
            } catch (Exception e2) {
                Log.w("BaseScanCamera", "autoFocus() " + e2.getMessage());
            }
        }
        AppMethodBeat.o(3525);
    }

    public final void cancelAutoFocus() {
        AppMethodBeat.i(3526);
        try {
            if (this.gII != null) {
                this.gII.cancelAutoFocus();
            }
            AppMethodBeat.o(3526);
        } catch (Exception e2) {
            Log.w("BaseScanCamera", "cancelAutoFocus " + e2.getMessage());
            AppMethodBeat.o(3526);
        }
    }

    public final boolean eQZ() {
        AppMethodBeat.i(3527);
        boolean equals = "auto".equals(getFocusMode());
        AppMethodBeat.o(3527);
        return equals;
    }

    @Override // com.tencent.scanlib.a.f
    public final String getFocusMode() {
        AppMethodBeat.i(3528);
        try {
            if (this.gII != null) {
                String focusMode = this.gII.getParameters().getFocusMode();
                AppMethodBeat.o(3528);
                return focusMode;
            }
        } catch (Exception e2) {
            Log.w("BaseScanCamera", "getFocusMode() " + e2.getMessage());
        }
        AppMethodBeat.o(3528);
        return "";
    }

    @Override // com.tencent.scanlib.a.f
    public final void setFocusMode(String str) {
        Camera.Parameters parameters;
        List<String> supportedFocusModes;
        AppMethodBeat.i(3529);
        try {
            if (!(this.gII == null || (supportedFocusModes = (parameters = this.gII.getParameters()).getSupportedFocusModes()) == null || !supportedFocusModes.contains(str))) {
                parameters.setFocusMode(str);
                this.gII.setParameters(parameters);
            }
            AppMethodBeat.o(3529);
        } catch (Exception e2) {
            Log.w("BaseScanCamera", "setFocusMode " + e2.getMessage());
            AppMethodBeat.o(3529);
        }
    }

    private void hkY() {
        AppMethodBeat.i(3530);
        try {
            Log.i("BaseScanCamera", "set scan focus");
            List<String> supportedFocusModes = this.gII.getParameters().getSupportedFocusModes();
            if (supportedFocusModes != null) {
                Log.i("BaseScanCamera", "supported focus modes size = " + supportedFocusModes.size());
                for (String str : supportedFocusModes) {
                    Log.i("BaseScanCamera", "supported focus modes : ".concat(String.valueOf(str)));
                }
                if (supportedFocusModes.contains("continuous-video")) {
                    Log.d("BaseScanCamera", "camera support continuous video focus");
                    setFocusMode("continuous-video");
                    AppMethodBeat.o(3530);
                    return;
                } else if (supportedFocusModes.contains("auto")) {
                    Log.d("BaseScanCamera", "camera support auto focus");
                    setFocusMode("auto");
                }
            }
            AppMethodBeat.o(3530);
        } catch (Exception e2) {
            Log.e("BaseScanCamera", "setScanFocus error: " + e2.getMessage());
            AppMethodBeat.o(3530);
        }
    }

    private Point r(Point point) {
        float f2;
        float f3;
        AppMethodBeat.i(3519);
        if (this.sRH) {
            f2 = (((float) this.sRG.x) * 1.0f) / ((float) point.y);
            f3 = (((float) this.sRG.y) * 1.0f) / ((float) point.x);
        } else {
            f2 = (((float) this.sRG.x) * 1.0f) / ((float) point.x);
            f3 = (((float) this.sRG.y) * 1.0f) / ((float) point.y);
        }
        this.ROi = Math.max(f2, f3);
        Point point2 = new Point((int) (((float) point.x) * this.ROi), (int) (((float) point.y) * this.ROi));
        AppMethodBeat.o(3519);
        return point2;
    }
}
