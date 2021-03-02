package com.tencent.mm.plugin.flash;

import android.hardware.Camera;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.facedetect.PluginFace;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytcommon.tools.YTCameraSetting;
import com.tencent.ytcommon.util.YTCommonInterface;
import org.json.JSONObject;

public final class a {
    public static final String wHI = (p.cTh() + '/' + "fdv_");

    static {
        AppMethodBeat.i(186477);
        if (PluginFace.isEnabled()) {
            com.tencent.mm.plugin.expansions.a.aoa("FacePro");
            com.tencent.mm.plugin.expansions.a.aoa("YTCommon");
            com.tencent.mm.plugin.expansions.a.aoa("YTFaceTrackPro2");
            com.tencent.mm.plugin.expansions.a.aoa("YTAGReflectLiveCheck");
            com.tencent.mm.plugin.expansions.a.aoa("YTPoseDetect");
            com.tencent.mm.plugin.expansions.a.aoa("opencv_world");
            com.tencent.mm.plugin.expansions.a.aoa("YTLipReader");
        }
        YTCommonExInterface.setIsEnabledLog(true);
        YTCommonExInterface.setIsEnabledNativeLog(true);
        AppMethodBeat.o(186477);
    }

    public a() {
        AppMethodBeat.i(186471);
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_face_sdk_log_level, 4);
        a2 = (a2 < 0 || a2 > 5) ? 2 : a2;
        YtLogger.setLogLevel(a2);
        Log.i("MicroMsg.FaceFlashManager", "choose sdk log level:%s", Integer.valueOf(a2));
        YtLogger.setLoggerListener(new YtLogger.IYtLoggerListener() {
            /* class com.tencent.mm.plugin.flash.a.AnonymousClass1 */

            @Override // com.tencent.youtu.sdkkitframework.common.YtLogger.IYtLoggerListener
            public final void log(String str, String str2) {
                AppMethodBeat.i(186470);
                Log.i("MicroMsg.YTLog", "%s:%s", str, str2);
                AppMethodBeat.o(186470);
            }
        });
        AppMethodBeat.o(186471);
    }

    public static boolean dKR() {
        AppMethodBeat.i(186472);
        int initAuth = YTCommonInterface.initAuth(MMApplicationContext.getContext(), "rel_wechat_2055-12-06.lic1.2", 0);
        Log.i("MicroMsg.FaceFlashManager", "YTCommonInterface  initAuth result:%s", Integer.valueOf(initAuth));
        if (initAuth != 0) {
            Log.e("MicroMsg.FaceFlashManagerError", "YTCommonInterface  initAuth error:%s", Integer.valueOf(initAuth));
            AppMethodBeat.o(186472);
            return false;
        }
        AppMethodBeat.o(186472);
        return true;
    }

    public static boolean a(Camera camera, int i2) {
        AppMethodBeat.i(186473);
        int initCamera = YTCameraSetting.initCamera(MMApplicationContext.getContext(), camera, i2);
        Log.i("MicroMsg.FaceFlashManager", "YTCameraSetting  initCamera result:%s", Integer.valueOf(initCamera));
        if (initCamera != 0) {
            Log.e("MicroMsg.FaceFlashManagerError", "YTCommonInterface  initAuth error:%s", Integer.valueOf(initCamera));
            AppMethodBeat.o(186473);
            return false;
        }
        YtSDKKitFramework.YtSDKPlatformContext platformContext = YtSDKKitFramework.getInstance().getPlatformContext();
        platformContext.currentCamera = camera;
        platformContext.currentCameraId = i2;
        platformContext.currentRotateState = YTCameraSetting.getRotate(MMApplicationContext.getContext(), i2, 1);
        platformContext.currentAppContext = MMApplicationContext.getContext();
        AppMethodBeat.o(186473);
        return true;
    }

    public static boolean a(YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode, YtSDKKitFramework.IYtSDKKitFrameworkEventListener iYtSDKKitFrameworkEventListener) {
        AppMethodBeat.i(186474);
        JSONObject a2 = com.tencent.mm.plugin.flash.a.a.a(ytSDKKitFrameworkWorkMode);
        if (a2 == null) {
            AppMethodBeat.o(186474);
            return false;
        }
        int init = YtSDKKitFramework.getInstance().init(YtSDKKitFramework.getInstance().getPlatformContext(), a2, ytSDKKitFrameworkWorkMode, YtSDKKitConfigHelper.getPipleStateNames(ytSDKKitFrameworkWorkMode), iYtSDKKitFrameworkEventListener);
        Log.i("MicroMsg.FaceFlashManager", "YtSDKKitFramework init ret:%s", Integer.valueOf(init));
        if (init != 0) {
            Log.i("MicroMsg.FaceFlashManagerError", "YtSDKKitFramework init error:%s", Integer.valueOf(init));
            AppMethodBeat.o(186474);
            return false;
        }
        AppMethodBeat.o(186474);
        return true;
    }

    public static void reset() {
        AppMethodBeat.i(186475);
        YtSDKKitFramework.getInstance().reset();
        AppMethodBeat.o(186475);
    }

    public static void dKS() {
        AppMethodBeat.i(186476);
        Log.i("MicroMsg.FaceFlashManager", "releaseYTSdk");
        YtSDKKitFramework.getInstance().deInit();
        AppMethodBeat.o(186476);
    }
}
