package com.tencent.mm.compatible.deviceinfo;

import android.content.Context;
import android.hardware.Camera;
import android.os.Looper;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.wxmm.v2helper;

public final class g implements d.a {
    public static d.a.C0301a a(Context context, int i2, Looper looper) {
        int i3;
        int i4;
        AppMethodBeat.i(155650);
        d.a.C0301a aVar = new d.a.C0301a();
        aVar.gGr = null;
        try {
            long currentTicks = Util.currentTicks();
            Log.i("MicroMsg.CameraUtil", "ashu::begin to try Call Camera.open cameraID %d", Integer.valueOf(i2));
            aVar.gGr = w.b(i2, looper);
            Log.i("MicroMsg.CameraUtil", "ashu::Call Camera.open back,  %dms", Long.valueOf(Util.ticksToNow(currentTicks)));
            if (aVar.gGr == null) {
                Log.e("MicroMsg.CameraUtil", "open camera error, not exception, but camera null");
                AppMethodBeat.o(155650);
                return null;
            }
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            long currentTicks2 = Util.currentTicks();
            Log.i("MicroMsg.CameraUtil", "ashu::begin to Call Camera.getCameraInfo cameraID %d", Integer.valueOf(i2));
            Camera.getCameraInfo(i2, cameraInfo);
            Log.i("MicroMsg.CameraUtil", "ashu::Call Camera.getCameraInfo back, use %dms", Long.valueOf(Util.ticksToNow(currentTicks2)));
            switch (((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation()) {
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
                i4 = (360 - (cameraInfo.orientation % v2helper.VOIP_ENC_HEIGHT_LV1)) % v2helper.VOIP_ENC_HEIGHT_LV1;
            } else {
                i4 = ((cameraInfo.orientation - i3) + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
            }
            long currentTicks3 = Util.currentTicks();
            Log.i("MicroMsg.CameraUtil", "ashu::begin to Call Camera.setDisplayOrientation %d", Integer.valueOf(i4));
            aVar.gGr.setDisplayOrientation(i4);
            Log.i("MicroMsg.CameraUtil", "ashu::Call Camera.setDisplayOrientation back, use %dms", Long.valueOf(Util.ticksToNow(currentTicks3)));
            aVar.dYT = cameraInfo.orientation;
            AppMethodBeat.o(155650);
            return aVar;
        } catch (Exception e2) {
            Log.e("MicroMsg.CameraUtil", "open camera error %s", e2.getMessage());
            Log.printErrStackTrace("MicroMsg.CameraUtil", e2, "", new Object[0]);
            AppMethodBeat.o(155650);
            return null;
        }
    }
}
