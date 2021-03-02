package com.tencent.mm.plugin.voip.video.camera.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.c.a;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.voip.video.camera.prev.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class c {
    public static int HjA = 0;
    public static int HjB = 0;
    public static boolean HjC = true;
    public static boolean HjD = false;
    public static b Hjw;
    public static int Hjx = -1;
    public static int Hjy = -1;
    public static int Hjz = 0;
    public static int gDo = 0;

    public static boolean fLj() {
        if (!ae.gKt.gFA || ae.gKt.gFz != 8) {
            return true;
        }
        return false;
    }

    public static boolean fLk() {
        AppMethodBeat.i(235840);
        if (!HjD) {
            HjC = fLl();
            a aVar = a.gDs;
            gDo = a.anJ();
            HjD = true;
        }
        boolean z = HjC;
        AppMethodBeat.o(235840);
        return z;
    }

    private static boolean fLl() {
        boolean z = false;
        AppMethodBeat.i(235841);
        try {
            if (Class.forName("android.hardware.Camera").getDeclaredMethod("getNumberOfCameras", null) == null) {
                Log.d("GetfcMethod", "GetfcMethod is null");
            } else {
                z = true;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.CameraUtil", "find getNumberOfCameras failed: " + e2.getMessage());
        }
        AppMethodBeat.o(235841);
        return z;
    }

    public static void hH(Context context) {
        AppMethodBeat.i(235842);
        if (Hjw != null) {
            AppMethodBeat.o(235842);
            return;
        }
        Hjw = new b("*");
        if (!fLk() || ae.gKt.gFy) {
            if (fLk() && ae.gKt.gFy) {
                fLm();
            }
            if (ae.gKt.gFy) {
                Hjw.gFx = ae.gKt.gFx;
            }
            if (ae.gKt.gFH) {
                if (ae.gKt.gFG.gGn != 0) {
                    Hjw.HjY = true;
                } else {
                    Hjw.HjY = false;
                }
            }
            if (ae.gKt.gFF) {
                if (ae.gKt.gFE.gGn != 0) {
                    Hjw.HjX = true;
                } else {
                    Hjw.HjX = false;
                }
            }
            if (ae.gKt.gFF && ae.gKt.gFE.gGo >= 0) {
                Hjw.HjZ = ae.gKt.gFE.gGo;
                Hjz = Hjw.HjZ;
            }
            if (ae.gKt.gFH && ae.gKt.gFG.gGo >= 0) {
                Hjw.Hka = ae.gKt.gFG.gGo;
                HjA = Hjw.Hka;
            }
            if (ae.gKt.gFF) {
                if (Hjw.Hkb == null) {
                    Hjw.Hkb = new Point(0, 0);
                }
                Hjw.Hkb = new Point(ae.gKt.gFE.width, ae.gKt.gFE.height);
            }
            if (ae.gKt.gFH) {
                if (Hjw.Hkc == null) {
                    Hjw.Hkc = new Point(0, 0);
                }
                Hjw.Hkc = new Point(ae.gKt.gFG.width, ae.gKt.gFG.height);
            }
            if (ae.gKt.gFH && ae.gKt.gFG.fps != 0) {
                Hjw.HjW = ae.gKt.gFG.fps;
            }
            if (ae.gKt.gFF && ae.gKt.gFE.fps != 0) {
                Hjw.HjW = ae.gKt.gFE.fps;
            }
            PackageManager packageManager = context.getPackageManager();
            if (!ae.gKt.gFy && !packageManager.hasSystemFeature("android.hardware.camera")) {
                Hjw.gFx = 0;
                Hjw.HjX = false;
                Hjw.HjY = false;
            }
        } else {
            fLm();
        }
        if (ae.gKt.bik) {
            HjB = ae.gKt.gFD;
        }
        Log.i("MicroMsg.CameraUtil", "gCameraNum:" + Hjw.gFx + "\ngIsHasFrontCamera:" + Hjw.HjX + "\ngIsHasBackCamera:" + Hjw.HjY + "\ngFrontCameraId:" + Hjx + "\ngBackCameraId:" + Hjy + "\ngBackOrientation:" + Hjw.Hka + "\ngFrontOrientation:" + Hjw.HjZ + "\ngBestFps:" + Hjw.HjW + "\ngFacePreviewSize:" + Hjw.Hkb + "\ngNonFacePreviewSize:" + Hjw.Hkc + "\ngFaceCameraIsRotate180:" + Hjz + "\ngMainCameraIsRotate180:" + HjA + "\ngCameraFormat:" + HjB + "\ngFaceNotRotate:SDK:" + Build.VERSION.SDK_INT + "\n");
        AppMethodBeat.o(235842);
    }

    private static void fLm() {
        AppMethodBeat.i(235843);
        Hjw.gFx = gDo;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int i2 = 0;
        while (true) {
            try {
                if (i2 >= Hjw.gFx) {
                    break;
                }
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == 1) {
                    if (Hjx != -1) {
                        Log.d("MicroMsg.CameraUtil", "device has other camera id %s in front", Integer.valueOf(i2));
                        break;
                    }
                    Hjx = i2;
                    Hjw.HjZ = cameraInfo.orientation;
                    Hjw.HjX = true;
                } else if (cameraInfo.facing != 0) {
                    continue;
                } else if (Hjy != -1) {
                    Log.d("MicroMsg.CameraUtil", "device has other camera id %s in back", Integer.valueOf(i2));
                    break;
                } else {
                    Hjy = i2;
                    Hjw.Hka = cameraInfo.orientation;
                    Hjw.HjY = true;
                }
                i2++;
            } catch (Exception e2) {
                Log.e("MicroMsg.CameraUtil", "get camera info error: %s", e2.getMessage());
            }
        }
        String property = System.getProperty("ro.media.enc.camera.platform", null);
        boolean equalsIgnoreCase = property == null ? false : property.equalsIgnoreCase("Mediatek");
        if (Hjw.HjZ == 270 || (equalsIgnoreCase && Hjw.HjZ == 0)) {
            Hjz = 1;
        } else {
            Hjz = 0;
        }
        if (Hjw.Hka == 270 || (equalsIgnoreCase && Hjw.Hka == 0)) {
            HjA = 1;
            AppMethodBeat.o(235843);
            return;
        }
        HjA = 0;
        AppMethodBeat.o(235843);
    }
}
