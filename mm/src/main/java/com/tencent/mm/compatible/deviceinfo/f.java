package com.tencent.mm.compatible.deviceinfo;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.os.Looper;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.wxmm.v2helper;

final class f implements d.a {
    f() {
    }

    @TargetApi(8)
    public static d.a.C0301a a(int i2, Looper looper) {
        int i3;
        int i4;
        AppMethodBeat.i(155649);
        d.a.C0301a aVar = new d.a.C0301a();
        try {
            aVar.gGr = w.e(looper);
            aVar.dYT = 90;
            if (aVar.gGr == null) {
                AppMethodBeat.o(155649);
                return null;
            }
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i2, cameraInfo);
            switch (((WindowManager) MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay().getRotation()) {
                case 0:
                    i3 = 0;
                    break;
                case 1:
                    i3 = 90;
                    break;
                case 2:
                    i3 = TXLiveConstants.RENDER_ROTATION_180;
                    break;
                case 3:
                    i3 = 270;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            if (cameraInfo.facing == 1) {
                i4 = (360 - ((cameraInfo.orientation + i3) % v2helper.VOIP_ENC_HEIGHT_LV1)) % v2helper.VOIP_ENC_HEIGHT_LV1;
            } else {
                i4 = ((cameraInfo.orientation - i3) + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
            }
            Log.d("MicroMsg.CameraUtil.CameraUtilImpl22", "CameraUtilImpl22, open camera, info.orientation: %d, degrees: %d, result:%d", Integer.valueOf(cameraInfo.orientation), Integer.valueOf(i3), Integer.valueOf(i4));
            aVar.gGr.setDisplayOrientation(i4);
            AppMethodBeat.o(155649);
            return aVar;
        } catch (Exception e2) {
            AppMethodBeat.o(155649);
            return null;
        }
    }
}
