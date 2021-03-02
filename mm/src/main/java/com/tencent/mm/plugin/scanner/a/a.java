package com.tencent.mm.plugin.scanner.a;

import android.graphics.Rect;
import android.hardware.Camera;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public final class a extends com.tencent.scanlib.a.a {
    public final void ePB() {
        AppMethodBeat.i(91043);
        try {
            Log.i("MicroMsg.WxScanCamera", "set picture focus");
            Camera.Parameters parameters = this.gII.getParameters();
            if (parameters == null) {
                Log.w("MicroMsg.WxScanCamera", "camera parameters is null");
                AppMethodBeat.o(91043);
                return;
            }
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes != null) {
                Log.d("MicroMsg.WxScanCamera", "supported focus modes size = " + supportedFocusModes.size());
                for (String str : supportedFocusModes) {
                    Log.d("MicroMsg.WxScanCamera", "supported focus modes : ".concat(String.valueOf(str)));
                }
                if (supportedFocusModes.contains("continuous-picture")) {
                    Log.d("MicroMsg.WxScanCamera", "camera support continuous picture focus");
                    parameters.setFocusMode("continuous-picture");
                } else if (supportedFocusModes.contains("continuous-video")) {
                    Log.d("MicroMsg.WxScanCamera", "camera support continuous video focus");
                    parameters.setFocusMode("continuous-video");
                } else if (supportedFocusModes.contains("auto")) {
                    Log.d("MicroMsg.WxScanCamera", "camera support auto focus");
                    parameters.setFocusMode("auto");
                }
                this.gII.setParameters(parameters);
            }
            AppMethodBeat.o(91043);
        } catch (Exception e2) {
            Log.e("MicroMsg.WxScanCamera", "setPictureFocus error: %s", e2.getMessage());
            AppMethodBeat.o(91043);
        }
    }

    public final void a(float f2, float f3, Camera.AutoFocusCallback autoFocusCallback) {
        List<String> supportedFocusModes;
        AppMethodBeat.i(91044);
        int i2 = (int) (f2 * 2000.0f);
        int i3 = (int) (2000.0f * f3);
        try {
            Log.i("MicroMsg.WxScanCamera", String.format("fx %f, fy %f, x %d, y %d", Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i2), Integer.valueOf(i3)));
            Rect rect = new Rect();
            if (hkT()) {
                rect.left = (i3 - 1000) - 250;
                rect.right = (i3 - 1000) + 250;
                rect.top = ((2000 - i2) - 1000) - 250;
                rect.bottom = ((2000 - i2) - 1000) + 250;
            } else {
                rect.left = (i2 - 1000) - 250;
                rect.right = (i2 - 1000) + 250;
                rect.top = (i3 - 1000) - 250;
                rect.bottom = (i3 - 1000) + 250;
            }
            Camera.Parameters parameters = this.gII.getParameters();
            if (rect.left < -1000) {
                rect.left = -1000;
            }
            if (rect.right > 1000) {
                rect.right = 1000;
            }
            if (rect.top < -1000) {
                rect.top = -1000;
            }
            if (rect.bottom > 1000) {
                rect.bottom = 1000;
            }
            Log.i("MicroMsg.WxScanCamera", "focus area ".concat(String.valueOf(rect)));
            Rect rect2 = new Rect(rect);
            if (parameters.getMaxNumMeteringAreas() > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Camera.Area(rect2, 1000));
                parameters.setMeteringAreas(arrayList);
                if (parameters.getMaxNumFocusAreas() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(new Camera.Area(rect, 1000));
                    parameters.setFocusAreas(arrayList2);
                    this.gII.cancelAutoFocus();
                    if (this.gII != null && this.sRE && (supportedFocusModes = parameters.getSupportedFocusModes()) != null && supportedFocusModes.contains("auto") && !com.tencent.scanlib.a.isNullOrNil(parameters.getFocusMode()) && !parameters.getFocusMode().equals("auto")) {
                        parameters.setFocusMode("auto");
                    }
                    this.gII.setParameters(parameters);
                    this.gII.autoFocus(autoFocusCallback);
                    AppMethodBeat.o(91044);
                    return;
                }
                Log.i("MicroMsg.WxScanCamera", "setCaptureFocusAndMeteringArea, camera not support area focus");
                AppMethodBeat.o(91044);
                return;
            }
            Log.i("MicroMsg.WxScanCamera", "setCaptureFocusAndMeteringArea, camera not support set metering area");
            AppMethodBeat.o(91044);
        } catch (Exception e2) {
            Log.e("MicroMsg.WxScanCamera", "setCaptureFocusAndMeteringArea error: " + e2.getMessage());
            AppMethodBeat.o(91044);
        }
    }

    public final void ePC() {
        AppMethodBeat.i(91045);
        try {
            if (this.gII != null) {
                Camera.Parameters parameters = this.gII.getParameters();
                String str = parameters.get("zoom-supported");
                if (com.tencent.scanlib.a.isNullOrNil(str) || !Boolean.parseBoolean(str)) {
                    Log.i("MicroMsg.WxScanCamera", "not support zoom");
                    AppMethodBeat.o(91045);
                    return;
                }
                List<Integer> zoomRatios = parameters.getZoomRatios();
                if (zoomRatios == null || zoomRatios.size() <= 0) {
                    AppMethodBeat.o(91045);
                    return;
                }
                this.ROl = 0;
                this.mMaxZoom = (int) (((double) zoomRatios.size()) / 1.5d);
                Log.d("MicroMsg.WxScanCamera", "divideRatio: %f,max zoom: %d", Double.valueOf(1.5d), Integer.valueOf(this.mMaxZoom));
                if (this.mMaxZoom < this.ROl) {
                    this.mMaxZoom = this.ROl;
                } else if (zoomRatios.get(this.mMaxZoom).intValue() > 400) {
                    this.mMaxZoom = J(zoomRatios, 400);
                }
                Log.i("MicroMsg.WxScanCamera", "default zoom:%d,default ratio:%d,max zoom:%d,max ratio:%d", Integer.valueOf(this.ROl), zoomRatios.get(this.ROl), Integer.valueOf(this.mMaxZoom), zoomRatios.get(this.mMaxZoom));
            }
            AppMethodBeat.o(91045);
        } catch (Exception e2) {
            Log.e("MicroMsg.WxScanCamera", "init zoom exception! " + e2.getMessage());
            AppMethodBeat.o(91045);
        }
    }

    public final boolean ePD() {
        return this.ztW;
    }

    public final boolean ePE() {
        int i2;
        AppMethodBeat.i(91046);
        if (this.ROj < 0) {
            if (ePF()) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            this.ROj = i2;
        }
        if (this.ROj == 1) {
            AppMethodBeat.o(91046);
            return true;
        }
        AppMethodBeat.o(91046);
        return false;
    }

    private boolean ePF() {
        AppMethodBeat.i(91047);
        if (this.gII != null && dEO()) {
            try {
                List<String> supportedFlashModes = this.gII.getParameters().getSupportedFlashModes();
                if (supportedFlashModes == null || !supportedFlashModes.contains("torch")) {
                    Log.i("MicroMsg.WxScanCamera", "camera not support flash!!");
                } else {
                    AppMethodBeat.o(91047);
                    return true;
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.WxScanCamera", "isFlashSupported error: " + e2.getMessage());
            }
        }
        AppMethodBeat.o(91047);
        return false;
    }

    public final void ejE() {
        AppMethodBeat.i(91048);
        Log.i("MicroMsg.WxScanCamera", String.format("openFlash, camera: %s, isPreviewing: %s", this.gII, Boolean.valueOf(dEO())));
        if (this.gII != null && dEO()) {
            try {
                this.ztW = true;
                Camera.Parameters parameters = this.gII.getParameters();
                List<String> supportedFlashModes = parameters.getSupportedFlashModes();
                if (supportedFlashModes == null || !supportedFlashModes.contains("torch")) {
                    Log.i("MicroMsg.WxScanCamera", "camera not support flash!!");
                    AppMethodBeat.o(91048);
                    return;
                }
                parameters.setFlashMode("torch");
                this.gII.setParameters(parameters);
                Log.i("MicroMsg.WxScanCamera", "open flash");
                AppMethodBeat.o(91048);
                return;
            } catch (Exception e2) {
                Log.e("MicroMsg.WxScanCamera", "openFlash error: " + e2.getMessage());
            }
        }
        AppMethodBeat.o(91048);
    }

    public final void ejF() {
        AppMethodBeat.i(91049);
        Log.i("MicroMsg.WxScanCamera", String.format("closeFlash, camera: %s, isPreviewing: %s", this.gII, Boolean.valueOf(dEO())));
        if (this.gII != null && dEO()) {
            try {
                this.ztW = false;
                Camera.Parameters parameters = this.gII.getParameters();
                List<String> supportedFlashModes = parameters.getSupportedFlashModes();
                if (supportedFlashModes == null || !supportedFlashModes.contains("off")) {
                    Log.i("MicroMsg.WxScanCamera", "camera not support close flash!!");
                    AppMethodBeat.o(91049);
                    return;
                }
                parameters.setFlashMode("off");
                this.gII.setParameters(parameters);
                Log.i("MicroMsg.WxScanCamera", "close flash");
                AppMethodBeat.o(91049);
                return;
            } catch (Exception e2) {
                Log.e("MicroMsg.WxScanCamera", "closeFlash error: " + e2.getMessage());
            }
        }
        AppMethodBeat.o(91049);
    }

    public final int getPreviewFormat() {
        AppMethodBeat.i(91050);
        int previewFormat = this.gII.getParameters().getPreviewFormat();
        AppMethodBeat.o(91050);
        return previewFormat;
    }
}
