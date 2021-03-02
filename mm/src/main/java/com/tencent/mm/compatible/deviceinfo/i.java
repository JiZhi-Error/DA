package com.tencent.mm.compatible.deviceinfo;

import android.hardware.Camera;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.d;
import com.tencent.mm.sdk.platformtools.Log;

/* access modifiers changed from: package-private */
public final class i implements d.a {
    i() {
    }

    public static int getNumberOfCameras() {
        AppMethodBeat.i(155651);
        if (!ae.gKt.gFO || ae.gKt.gFN == -1) {
            int numberOfCameras = d.getNumberOfCameras();
            Log.d("CameraUtilImplConfig", "getNumberOfCameras ".concat(String.valueOf(numberOfCameras)));
            if (numberOfCameras > 1) {
                AppMethodBeat.o(155651);
                return numberOfCameras;
            }
            AppMethodBeat.o(155651);
            return 0;
        }
        int i2 = ae.gKt.gFN;
        Log.d("CameraUtilImplConfig", "mVRCameraNum ".concat(String.valueOf(i2)));
        AppMethodBeat.o(155651);
        return i2;
    }

    public static d.a.C0301a a(int i2, Looper looper) {
        AppMethodBeat.i(155652);
        d.a.C0301a aVar = new d.a.C0301a();
        aVar.gGr = null;
        try {
            aVar.gGr = w.b(i2, looper);
            if (aVar.gGr == null) {
                AppMethodBeat.o(155652);
                return null;
            }
            aVar.dYT = 0;
            Log.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.hasVRInfo " + ae.gKt.gFI);
            Log.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRFaceRotate " + ae.gKt.gFJ);
            Log.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRFaceDisplayOrientation " + ae.gKt.gFK);
            Log.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRBackRotate " + ae.gKt.gFL);
            Log.d("CameraUtilImplConfig", "SrvDeviceInfo.mCameraInfo.mVRBackDisplayOrientation " + ae.gKt.gFM);
            if (getNumberOfCameras() > 1) {
                try {
                    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                    Camera.getCameraInfo(i2, cameraInfo);
                    Log.d("CameraUtilImplConfig", "info.facing " + cameraInfo.facing);
                    if (cameraInfo.facing == 1) {
                        if (ae.gKt.gFI && ae.gKt.gFJ != -1) {
                            aVar.dYT = ae.gKt.gFJ;
                        }
                        if (ae.gKt.gFI && ae.gKt.gFK != -1) {
                            aVar.gGr.setDisplayOrientation(ae.gKt.gFK);
                        }
                    } else {
                        if (ae.gKt.gFI && ae.gKt.gFL != -1) {
                            aVar.dYT = ae.gKt.gFL;
                        }
                        if (ae.gKt.gFI && ae.gKt.gFM != -1) {
                            aVar.gGr.setDisplayOrientation(ae.gKt.gFM);
                        }
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("CameraUtilImplConfig", e2, "", new Object[0]);
                }
            } else {
                if (ae.gKt.gFI && ae.gKt.gFL != -1) {
                    aVar.dYT = ae.gKt.gFL;
                }
                if (ae.gKt.gFI && ae.gKt.gFM != -1) {
                    aVar.gGr.setDisplayOrientation(ae.gKt.gFM);
                }
            }
            AppMethodBeat.o(155652);
            return aVar;
        } catch (Exception e3) {
            AppMethodBeat.o(155652);
            return null;
        }
    }
}
