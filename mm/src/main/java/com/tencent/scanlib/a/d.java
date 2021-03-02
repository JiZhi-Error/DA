package com.tencent.scanlib.a;

import android.hardware.Camera;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.scanlib.a.g;
import com.tencent.stubs.logger.Log;
import com.tencent.wxmm.v2helper;

final class d implements g.a {
    d() {
    }

    public static g.a.C2186a mu(int i2, int i3) {
        int i4;
        int i5;
        AppMethodBeat.i(3544);
        g.a.C2186a aVar = new g.a.C2186a();
        aVar.gII = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Log.i("CameraUtilImpl23", "Call Camera.open cameraID ".concat(String.valueOf(i2)));
            aVar.gII = Camera.open(i2);
            Log.i("CameraUtilImpl23", String.format("Call Camera.open back, use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
            if (aVar.gII == null) {
                Log.e("CameraUtilImpl23", "open camera error, not exception, but camera null");
                AppMethodBeat.o(3544);
                return null;
            }
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            long currentTimeMillis2 = System.currentTimeMillis();
            Log.i("CameraUtilImpl23", "Call Camera.getCameraInfo cameraID ".concat(String.valueOf(i2)));
            Camera.getCameraInfo(i2, cameraInfo);
            Log.i("CameraUtilImpl23", String.format("Call Camera.getCameraInfo back, use %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)));
            switch (i3) {
                case 0:
                    i4 = 0;
                    break;
                case 1:
                    i4 = 90;
                    break;
                case 2:
                    i4 = TXLiveConstants.RENDER_ROTATION_180;
                    break;
                case 3:
                    i4 = 270;
                    break;
                default:
                    i4 = 0;
                    break;
            }
            if (cameraInfo.facing == 1) {
                i5 = (360 - (cameraInfo.orientation % v2helper.VOIP_ENC_HEIGHT_LV1)) % v2helper.VOIP_ENC_HEIGHT_LV1;
            } else {
                i5 = ((cameraInfo.orientation - i4) + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
            }
            long currentTimeMillis3 = System.currentTimeMillis();
            Log.i("CameraUtilImpl23", "Call Camera.setDisplayOrientation ".concat(String.valueOf(i5)));
            aVar.gII.setDisplayOrientation(i5);
            Log.i("CameraUtilImpl23", String.format("Call Camera.setDisplayOrientation back, use %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis3)));
            aVar.dYT = i5;
            AppMethodBeat.o(3544);
            return aVar;
        } catch (Exception e2) {
            Log.e("CameraUtilImpl23", "open camera error " + e2.getMessage());
            AppMethodBeat.o(3544);
            return null;
        }
    }
}
