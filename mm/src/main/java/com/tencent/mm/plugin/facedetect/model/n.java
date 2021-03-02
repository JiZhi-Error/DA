package com.tencent.mm.plugin.facedetect.model;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.d;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.TXLiveConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class n {
    private Context context;
    public v gGr;
    private boolean imf = true;
    public boolean jyo = false;
    public Point pbD = null;
    public boolean sRE = false;
    public Point sRF = null;
    private Point sRG = null;
    private boolean sRH;
    public int sRI;
    private boolean sRJ = false;
    public Point sRK = null;

    public n(Context context2) {
        this.context = context2;
    }

    public final void i(SurfaceTexture surfaceTexture) {
        String str;
        boolean z;
        boolean z2;
        AppMethodBeat.i(103774);
        if (this.sRE) {
            Log.w("MicroMsg.FaceScanCamera", "in open(), previewing");
            release();
        }
        this.imf = true;
        com.tencent.mm.compatible.c.a aVar = com.tencent.mm.compatible.c.a.gDs;
        int anJ = com.tencent.mm.compatible.c.a.anJ();
        int i2 = 0;
        while (true) {
            if (i2 >= anJ) {
                i2 = -1;
                break;
            }
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing != 1 || !this.imf) {
                if (cameraInfo.facing == 0 && !this.imf) {
                    Log.d("MicroMsg.FaceScanCamera", "hy: front Camera found");
                    break;
                }
                i2++;
            } else {
                Log.d("MicroMsg.FaceScanCamera", "hy: front Camera found");
                break;
            }
        }
        long currentTicks = Util.currentTicks();
        d.a.C0301a a2 = d.a(this.context, i2, null);
        if (a2 == null) {
            Log.e("MicroMsg.FaceScanCamera", "in open(), openCameraRes == null");
            IOException iOException = new IOException();
            AppMethodBeat.o(103774);
            throw iOException;
        }
        this.jyo = true;
        Log.d("MicroMsg.FaceScanCamera", "openCamera done, cameraId=[%s] costTime=[%s]", Integer.valueOf(i2), Long.valueOf(Util.ticksToNow(currentTicks)));
        this.sRI = a2.dYT;
        this.sRH = a2.dYT % TXLiveConstants.RENDER_ROTATION_180 != 0;
        this.gGr = a2.gGr;
        if (this.gGr == null) {
            Log.e("MicroMsg.FaceScanCamera", "in open(), camera == null, bNeedRotate=[%s]", Boolean.valueOf(this.sRH));
            IOException iOException2 = new IOException();
            AppMethodBeat.o(103774);
            throw iOException2;
        }
        this.gGr.setPreviewTexture(surfaceTexture);
        Camera.Parameters parameters = this.gGr.getParameters();
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
            Log.d("MicroMsg.FaceScanCamera", "preview-size-values parameter: ".concat(String.valueOf(str)));
            point3 = a(parameters, point);
        }
        if (point3 == null) {
            point3 = new Point((point2.x >> 3) << 3, (point2.y >> 3) << 3);
        }
        this.sRF = point3;
        this.sRK = new Point(this.sRF);
        Log.d("MicroMsg.FaceScanCamera", "getCameraResolution: " + this.pbD + " camera:" + this.sRF + "bestVideoEncodeSize: " + this.sRK);
        parameters.setPreviewSize(this.sRF.x, this.sRF.y);
        parameters.setZoom(0);
        parameters.setSceneMode("auto");
        try {
            if (parameters.getSupportedFocusModes() == null || !parameters.getSupportedFocusModes().contains("auto")) {
                Log.i("MicroMsg.FaceScanCamera", "camera not support FOCUS_MODE_AUTO");
            } else {
                Log.i("MicroMsg.FaceScanCamera", "set FocusMode to FOCUS_MODE_AUTO");
                parameters.setFocusMode("auto");
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.FaceScanCamera", "set focus mode error: %s", e2.getMessage());
        }
        List<Integer> supportedPreviewFormats = parameters.getSupportedPreviewFormats();
        Iterator<Integer> it = supportedPreviewFormats.iterator();
        boolean z3 = false;
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            int intValue = it.next().intValue();
            Log.d("MicroMsg.FaceScanCamera", "supportedPreviewFormat: ".concat(String.valueOf(intValue)));
            if (intValue == 17) {
                z = true;
                break;
            }
            if (intValue == 842094169) {
                z2 = true;
            } else {
                z2 = z3;
            }
            z3 = z2;
        }
        if (z) {
            parameters.setPreviewFormat(17);
        } else if (z3) {
            Log.e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP, but hasYU12");
            parameters.setPreviewFormat(842094169);
        } else {
            Log.e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP. Use format: %s", supportedPreviewFormats.get(0));
            parameters.setPreviewFormat(supportedPreviewFormats.get(0).intValue());
        }
        if (this.sRH) {
            parameters.setRotation(this.sRI);
        }
        this.gGr.setParameters(parameters);
        AppMethodBeat.o(103774);
    }

    public final void release() {
        AppMethodBeat.i(103775);
        Log.d("MicroMsg.FaceScanCamera", "release(), previewing = [%s]", Boolean.valueOf(this.sRE));
        if (this.gGr != null) {
            long currentTicks = Util.currentTicks();
            if (this.sRE) {
                this.gGr.setPreviewCallback(null);
                this.gGr.stopPreview();
                this.sRE = false;
                Log.d("MicroMsg.FaceScanCamera", "stopPreview costTime=[%s]", Long.valueOf(Util.ticksToNow(currentTicks)));
            }
            long currentTicks2 = Util.currentTicks();
            this.gGr.release();
            this.gGr = null;
            this.jyo = false;
            Log.d("MicroMsg.FaceScanCamera", "camera.release() costTime=[%s]", Long.valueOf(Util.ticksToNow(currentTicks2)));
        }
        this.sRJ = false;
        AppMethodBeat.o(103775);
    }

    public final int getPreviewWidth() {
        AppMethodBeat.i(103776);
        Log.v("MicroMsg.FaceScanCamera", "hy: preview width: %d", Integer.valueOf(this.sRF.x));
        int i2 = this.sRF.x;
        AppMethodBeat.o(103776);
        return i2;
    }

    public final int getPreviewHeight() {
        AppMethodBeat.i(103777);
        Log.v("MicroMsg.FaceScanCamera", "hy: preview height: %d", Integer.valueOf(this.sRF.y));
        int i2 = this.sRF.y;
        AppMethodBeat.o(103777);
        return i2;
    }

    /* access modifiers changed from: package-private */
    public static class a implements Comparator<Camera.Size> {
        private a() {
        }

        /* synthetic */ a(byte b2) {
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

    private static Point a(Camera.Parameters parameters, Point point) {
        int i2;
        int i3;
        float f2;
        AppMethodBeat.i(103778);
        ArrayList<Camera.Size> arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new a((byte) 0));
        Point point2 = null;
        float f3 = ((float) point.x) / ((float) point.y);
        Log.d("MicroMsg.FaceScanCamera", "screen.x: %d, screen.y: %d, ratio: %f", Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(f3));
        long availableMemoryMB = Util.getAvailableMemoryMB(MMApplicationContext.getContext());
        Log.d("MicroMsg.FaceScanCamera", "systemAvailableMemInMB: %d", Long.valueOf(availableMemoryMB));
        int i4 = point.x;
        int i5 = point.y;
        float f4 = Float.POSITIVE_INFINITY;
        for (Camera.Size size : arrayList) {
            int i6 = size.width;
            int i7 = size.height;
            Log.i("MicroMsg.FaceScanCamera", "realWidth: %d, realHeight: %d", Integer.valueOf(i6), Integer.valueOf(i7));
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
                Log.d("MicroMsg.FaceScanCamera", "maybeFlippedWidth: %d, maybeFlippedHeight: %d", Integer.valueOf(i2), Integer.valueOf(i3));
                if (i2 == point.x && i3 == point.y && k(i2, i3, availableMemoryMB)) {
                    Point point3 = new Point(i6, i7);
                    Log.i("MicroMsg.FaceScanCamera", "Found preview size exactly matching screen size: ".concat(String.valueOf(point3)));
                    AppMethodBeat.o(103778);
                    return point3;
                }
                float abs = Math.abs((((float) i2) / ((float) i3)) - f3);
                if (abs >= f4 || !k(i6, i7, availableMemoryMB)) {
                    f2 = f4;
                } else {
                    f2 = abs;
                    point2 = new Point(i6, i7);
                }
                Log.i("MicroMsg.FaceScanCamera", "diff:[%s] newdiff:[%s] w:[%s] h:[%s]", Float.valueOf(f2), Float.valueOf(abs), Integer.valueOf(i6), Integer.valueOf(i7));
                f4 = f2;
            }
        }
        if (point2 == null) {
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                point2 = new Point(previewSize.width, previewSize.height);
                Log.i("MicroMsg.FaceScanCamera", "No suitable preview sizes, using default: ".concat(String.valueOf(point2)));
            } else {
                Log.e("MicroMsg.FaceScanCamera", "hy: can not find default size!!");
            }
        }
        Log.i("MicroMsg.FaceScanCamera", "Found best approximate preview size: ".concat(String.valueOf(point2)));
        AppMethodBeat.o(103778);
        return point2;
    }

    private static boolean k(int i2, int i3, long j2) {
        AppMethodBeat.i(103779);
        double d2 = ((((((double) i2) * ((double) i3)) * 3.0d) / 2.0d) / 1024.0d) / 1024.0d;
        Log.d("MicroMsg.FaceScanCamera", "dataSizeInMB: %f, availableMemInMb: %d", Double.valueOf(d2), Long.valueOf(j2));
        if (((double) j2) / d2 >= 5.0d) {
            AppMethodBeat.o(103779);
            return true;
        }
        AppMethodBeat.o(103779);
        return false;
    }

    public final void setPreviewCallback(final Camera.PreviewCallback previewCallback) {
        AppMethodBeat.i(103780);
        if (this.gGr == null) {
            Log.w("MicroMsg.FaceScanCamera", "hy: camera is null. setPreviewCallback failed");
            AppMethodBeat.o(103780);
            return;
        }
        try {
            this.gGr.addCallbackBuffer(c.sQB.h(Integer.valueOf(((getPreviewWidth() * getPreviewHeight()) * ImageFormat.getBitsPerPixel(this.gGr.getParameters().getPreviewFormat())) / 8)));
            this.gGr.setPreviewCallbackWithBuffer(new Camera.PreviewCallback() {
                /* class com.tencent.mm.plugin.facedetect.model.n.AnonymousClass1 */

                public final void onPreviewFrame(byte[] bArr, Camera camera) {
                    AppMethodBeat.i(103773);
                    if (previewCallback != null) {
                        previewCallback.onPreviewFrame(bArr, camera);
                    }
                    camera.addCallbackBuffer(bArr);
                    AppMethodBeat.o(103773);
                }
            });
            AppMethodBeat.o(103780);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FaceScanCamera", e2, "setPreviewCallback error: %s", e2.getMessage());
            AppMethodBeat.o(103780);
        }
    }
}
