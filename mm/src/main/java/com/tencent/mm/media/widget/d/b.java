package com.tencent.mm.media.widget.d;

import android.hardware.Camera;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.widget.camerarecordview.d.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u0004H\u0002J\b\u0010&\u001a\u00020\u001cH\u0007J\b\u0010\u001b\u001a\u00020\u001cH\u0007J\b\u0010'\u001a\u00020\u001cH\u0003J\b\u0010!\u001a\u00020\u001cH\u0007J\b\u0010(\u001a\u00020\u001cH\u0002J\b\u0010)\u001a\u00020\u001cH\u0007J\b\u0010*\u001a\u00020\u001cH\u0007J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u0004H\u0007J\u0018\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0004H\u0007J\u0010\u00100\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u0004H\u0007J\u0010\u00101\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u0004H\u0007J\b\u00102\u001a\u00020\u001cH\u0007J\b\u00103\u001a\u00020\u001cH\u0007J\b\u00104\u001a\u00020\u001cH\u0007J\b\u00105\u001a\u00020\u001cH\u0007J\b\u00106\u001a\u00020\u001cH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 ¨\u00067"}, hxF = {"Lcom/tencent/mm/media/widget/util/CameraHelper;", "", "()V", "CAMERA_API_LEVEL1", "", "CAMERA_API_LEVEL2", "DEFAULT_CAMERA2_SUPPORT_SENCE", "", "SCENE_APPBRAND", "SCENE_CHATTING", "SCENE_EMOJI", "SCENE_FAV", "SCENE_FINDER", "SCENE_GAME", "SCENE_SNS", "SCENE_SNS_VLOG", "SCENE_STICK_PREVIEW", "SCENE_STORY", "SCENE_STORY_VLOG", "SCENE_VOIP", "TAG", "", "cameraNum", "getCameraNum", "()I", "setCameraNum", "(I)V", "hasBackCamera", "", "getHasBackCamera", "()Z", "setHasBackCamera", "(Z)V", "hasFrontCamera", "getHasFrontCamera", "setHasFrontCamera", "checkSceneSupportRecordStream", "scene", "enableSwitchCamera", "hasBackCameraInThread", "hasFrontCameraInThread", "isCameraApi2CanUse", "isCaptureUseImageCallback", "isProcessAllowToResponseCamera2", "isProcessCaptureUseImageCallback", "process", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "cameraApiLevel", "isProcessUseCamera2", "isProcessUseCamera2RecordStream", "isProcessUseVideoStabilization", "isRenderscriptSupported", "isUseRecordStream", "isVendorCameraEffectSupported", "isVendorDebugModeSupported", "plugin-mediaeditor_release"})
public final class b {
    private static boolean gFF = true;
    private static boolean gFH = true;
    private static final int[] ith = ((ae.gKA.gJi == 1 || BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) ? new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12} : new int[]{2, 1, 3, 8, 10, 12});
    private static int iti = 2;
    public static final b itj = new b();

    static {
        AppMethodBeat.i(94381);
        h.RTc.aX(AnonymousClass1.itk);
        AppMethodBeat.o(94381);
    }

    private b() {
    }

    public static int aRA() {
        return iti;
    }

    public static void rF(int i2) {
        iti = i2;
    }

    public static boolean aRB() {
        return gFF;
    }

    public static void fl(boolean z) {
        gFF = z;
    }

    public static boolean aRC() {
        return gFH;
    }

    public static void fm(boolean z) {
        gFH = z;
    }

    private static boolean aRD() {
        boolean z;
        AppMethodBeat.i(94374);
        if (ae.gKA == null || ae.gKA.gJg == -1) {
            z = false;
        } else if (ae.gKA.gJg == 3) {
            z = true;
        } else if (ae.gKA.gJg == 1) {
            AppMethodBeat.o(94374);
            return true;
        } else {
            AppMethodBeat.o(94374);
            return false;
        }
        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_camera_api_val, 2) != 2 || !z) {
            AppMethodBeat.o(94374);
            return false;
        } else if (d.oE(21)) {
            AppMethodBeat.o(94374);
            return false;
        } else if (k.apw()) {
            AppMethodBeat.o(94374);
            return false;
        } else if (k.apx()) {
            AppMethodBeat.o(94374);
            return false;
        } else {
            Object systemService = MMApplicationContext.getContext().getSystemService("camera");
            if (systemService == null) {
                t tVar = new t("null cannot be cast to non-null type android.hardware.camera2.CameraManager");
                AppMethodBeat.o(94374);
                throw tVar;
            }
            CameraManager cameraManager = (CameraManager) systemService;
            try {
                cameraManager.getCameraCharacteristics(cameraManager.getCameraIdList()[0]);
                Object obj = cameraManager.getCameraCharacteristics(AppEventsConstants.EVENT_PARAM_VALUE_NO).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
                if (obj == null) {
                    p.hyc();
                }
                int intValue = ((Number) obj).intValue();
                if (intValue == 0 || intValue == 2) {
                    AppMethodBeat.o(94374);
                    return false;
                }
                AppMethodBeat.o(94374);
                return true;
            } catch (Exception e2) {
                Log.e("MicroMsg.CameraHelper", "a camera access exception happend");
                AppMethodBeat.o(94374);
                return false;
            } catch (AssertionError e3) {
                Log.e("MicroMsg.CameraHelper", "some device has some problem in LegecyCamera ");
                AppMethodBeat.o(94374);
                return false;
            }
        }
    }

    public static final boolean aRE() {
        AppMethodBeat.i(177321);
        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_camera_use_video_stabilization_switch, true)) {
            AppMethodBeat.o(177321);
            return true;
        }
        AppMethodBeat.o(177321);
        return false;
    }

    public static final boolean a(a aVar) {
        AppMethodBeat.i(94377);
        p.h(aVar, "process");
        switch (aVar.getRecordScene()) {
            case 1:
            case 2:
            case 9:
                if (!aRF() || !rG(aVar.getRecordScene()) || !aRD()) {
                    AppMethodBeat.o(94377);
                    return false;
                }
                AppMethodBeat.o(94377);
                return true;
            default:
                AppMethodBeat.o(94377);
                return false;
        }
    }

    public static final boolean aRF() {
        AppMethodBeat.i(94378);
        if (ae.gKA == null || ae.gKA.gJk == -1) {
            boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_camera2_test_image_switch, false);
            AppMethodBeat.o(94378);
            return a2;
        } else if (ae.gKA.gJk == 1) {
            AppMethodBeat.o(94378);
            return true;
        } else {
            AppMethodBeat.o(94378);
            return false;
        }
    }

    public static final boolean aRG() {
        if (ae.gKA == null || ae.gKA.gJj == -1) {
            return false;
        }
        return ae.gKA.gJj == 1;
    }

    public static final boolean aRH() {
        AppMethodBeat.i(94379);
        if (ae.gKA == null || ae.gKA.gJl == -1) {
            boolean a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_camera2_test_renderscript_switch, false);
            AppMethodBeat.o(94379);
            return a2;
        } else if (ae.gKA.gJl == 1) {
            AppMethodBeat.o(94379);
            return true;
        } else {
            AppMethodBeat.o(94379);
            return false;
        }
    }

    public static final boolean aRI() {
        if (ae.gKA == null || ae.gKA.gJm == -1) {
            return false;
        }
        return ae.gKA.gJm == 1;
    }

    public static final boolean aQg() {
        AppMethodBeat.i(94380);
        if (iti > 1) {
            try {
                int i2 = iti;
                boolean z = false;
                boolean z2 = false;
                for (int i3 = 0; i3 < i2; i3++) {
                    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                    Camera.getCameraInfo(i3, cameraInfo);
                    if (cameraInfo.facing == 1) {
                        z2 = true;
                    }
                    if (cameraInfo.facing == 0) {
                        z = true;
                    }
                }
                if (!z2 || !z) {
                    AppMethodBeat.o(94380);
                    return false;
                }
                AppMethodBeat.o(94380);
                return true;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.CameraHelper", e2, " error", new Object[0]);
                AppMethodBeat.o(94380);
                return true;
            }
        } else {
            AppMethodBeat.o(94380);
            return false;
        }
    }

    public static final boolean aRJ() {
        return gFF;
    }

    public static final boolean aRK() {
        return gFH;
    }

    public static final boolean rG(int i2) {
        boolean z;
        AppMethodBeat.i(218939);
        String a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_camera_use_camera2_scene, "");
        if (p.j(a2, "")) {
            z = e.contains(ith, i2);
        } else {
            if (!Util.isNullOrNil(a2)) {
                p.g(a2, "supportScene");
                if (n.a((CharSequence) a2, (CharSequence) String.valueOf(i2), false)) {
                    z = true;
                }
            }
            z = false;
        }
        if (z) {
            boolean aRD = aRD();
            AppMethodBeat.o(218939);
            return aRD;
        }
        AppMethodBeat.o(218939);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0089  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean rH(int r6) {
        /*
        // Method dump skipped, instructions count: 143
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.media.widget.d.b.rH(int):boolean");
    }

    public static final /* synthetic */ boolean aRL() {
        AppMethodBeat.i(94382);
        int i2 = iti;
        for (int i3 = 0; i3 < i2; i3++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i3, cameraInfo);
            if (cameraInfo.facing == 1) {
                AppMethodBeat.o(94382);
                return true;
            }
        }
        AppMethodBeat.o(94382);
        return false;
    }

    public static final /* synthetic */ boolean aRM() {
        AppMethodBeat.i(94383);
        int i2 = iti;
        for (int i3 = 0; i3 < i2; i3++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i3, cameraInfo);
            if (cameraInfo.facing == 0) {
                AppMethodBeat.o(94383);
                return true;
            }
        }
        AppMethodBeat.o(94383);
        return false;
    }
}
