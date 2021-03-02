package com.tencent.mm.compatible.deviceinfo;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class d {

    public interface a {

        /* renamed from: com.tencent.mm.compatible.deviceinfo.d$a$a  reason: collision with other inner class name */
        public static class C0301a {
            public int dYT;
            public v gGr;
        }
    }

    public static int getNumberOfCameras() {
        AppMethodBeat.i(155644);
        if (!ae.gKt.gFI || !ae.gKt.gFO) {
            new g();
            com.tencent.mm.compatible.c.a aVar = com.tencent.mm.compatible.c.a.gDs;
            int anJ = com.tencent.mm.compatible.c.a.anJ();
            AppMethodBeat.o(155644);
            return anJ;
        }
        new i();
        int numberOfCameras = i.getNumberOfCameras();
        AppMethodBeat.o(155644);
        return numberOfCameras;
    }

    public static int aog() {
        AppMethodBeat.i(155645);
        if (ae.gKE.gGP == 1) {
            AppMethodBeat.o(155645);
            return 0;
        }
        com.tencent.mm.compatible.c.a aVar = com.tencent.mm.compatible.c.a.gDs;
        int anJ = com.tencent.mm.compatible.c.a.anJ();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int i2 = 0;
        while (true) {
            if (i2 >= anJ) {
                i2 = 0;
                break;
            }
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == 0) {
                Log.d("MicroMsg.CameraUtil", "tigercam get bid %d", Integer.valueOf(i2));
                break;
            }
            i2++;
        }
        Log.d("MicroMsg.CameraUtil", "tigercam getBackCameraId %d", Integer.valueOf(i2));
        AppMethodBeat.o(155645);
        return i2;
    }

    public static int aoh() {
        AppMethodBeat.i(155646);
        com.tencent.mm.compatible.c.a aVar = com.tencent.mm.compatible.c.a.gDs;
        int anJ = com.tencent.mm.compatible.c.a.anJ();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int i2 = 0;
        while (true) {
            if (i2 >= anJ) {
                i2 = 0;
                break;
            }
            Camera.getCameraInfo(i2, cameraInfo);
            if (cameraInfo.facing == 1) {
                Log.d("MicroMsg.CameraUtil", "tigercam get fid %d", Integer.valueOf(i2));
                break;
            }
            i2++;
        }
        Log.d("MicroMsg.CameraUtil", "tigercam getBackCameraId %d", Integer.valueOf(i2));
        AppMethodBeat.o(155646);
        return i2;
    }

    public static a.C0301a B(Context context, int i2) {
        AppMethodBeat.i(215250);
        a.C0301a a2 = a(context, i2, null);
        AppMethodBeat.o(215250);
        return a2;
    }

    public static a.C0301a a(Context context, int i2, Looper looper) {
        AppMethodBeat.i(155647);
        if (ae.gKt.gFQ == 1) {
            Log.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImpl20, cameraId = ".concat(String.valueOf(i2)));
            new e();
            a.C0301a d2 = e.d(looper);
            AppMethodBeat.o(155647);
            return d2;
        } else if (ae.gKt.gFI) {
            Log.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImplConfig, cameraId = ".concat(String.valueOf(i2)));
            new i();
            a.C0301a a2 = i.a(i2, looper);
            AppMethodBeat.o(155647);
            return a2;
        } else if (Build.MODEL.equals("M9")) {
            new j();
            a.C0301a d3 = j.d(looper);
            AppMethodBeat.o(155647);
            return d3;
        } else if (getNumberOfCameras() > 1) {
            Log.d("MicroMsg.CameraUtil", "openCamera(), CameraUtilImpl23, cameraId = ".concat(String.valueOf(i2)));
            new g();
            a.C0301a a3 = g.a(context, i2, looper);
            AppMethodBeat.o(155647);
            return a3;
        } else {
            new f();
            a.C0301a a4 = f.a(i2, looper);
            AppMethodBeat.o(155647);
            return a4;
        }
    }
}
