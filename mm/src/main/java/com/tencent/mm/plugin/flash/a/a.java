package com.tencent.mm.plugin.flash.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.youtu.sdkkitframework.common.FileUtils;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    private static final String wHI = (p.cTh() + '/' + "fdv_");

    static {
        AppMethodBeat.i(186611);
        AppMethodBeat.o(186611);
    }

    public static int dKW() {
        AppMethodBeat.i(186607);
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_face_flash_verify_waiting_time, 1500);
        Log.i("MicroMsg.FaceFlashManagerConfig", "getFaceWaitingTimeMs %d", Integer.valueOf(a2));
        AppMethodBeat.o(186607);
        return a2;
    }

    public static int dKX() {
        AppMethodBeat.i(186608);
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_face_flash_read_number_interval, 1000);
        Log.i("MicroMsg.FaceFlashManagerConfig", "getFaceReadNumberTimeInterval %d", Integer.valueOf(a2));
        AppMethodBeat.o(186608);
        return a2;
    }

    public static int dKY() {
        AppMethodBeat.i(186609);
        int a2 = ((b) g.af(b.class)).a(b.a.clicfg_face_flash_read_number_before_waiting, 1000);
        Log.i("MicroMsg.FaceFlashManagerConfig", "getFaceReadNumberTimeInterval %d", Integer.valueOf(a2));
        AppMethodBeat.o(186609);
        return a2;
    }

    public static JSONObject a(YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode) {
        AppMethodBeat.i(186610);
        String str = "";
        try {
            switch (ytSDKKitFrameworkWorkMode) {
                case YT_FW_ACTION_TYPE:
                    str = ((b) g.af(b.class)).a(b.a.clicfg_face_flash_config_action, "");
                    break;
                case YT_FW_REFLECT_TYPE:
                    str = ((b) g.af(b.class)).a(b.a.clicfg_face_flash_config_reflect, "");
                    break;
                case YT_FW_ACTREFLECT_TYPE:
                    str = ((b) g.af(b.class)).a(b.a.clicfg_face_flash_config_actref, "");
                    break;
                case YT_FW_LIPREAD_TYPE:
                    str = ((b) g.af(b.class)).a(b.a.clicfg_face_flash_config_lipread, "");
                    break;
            }
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                jSONObject.put("resource_download_path", p.cTh() + FilePathGenerator.ANDROID_DIR_SEP);
                jSONObject.put("video_path", wHI + Util.currentTicks() + ".mp4");
                Log.i("MicroMsg.FaceFlashManagerConfig", "YtSDKKitConfigHelper getSDKConfig:%s", jSONObject.toString());
                AppMethodBeat.o(186610);
                return jSONObject;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FaceFlashManagerConfig", e2, "par config error. config:%s", str);
        }
        String sb = FileUtils.readAssetFile(MMApplicationContext.getContext(), "face_detect/configs/YtSDKSettings.json").toString();
        try {
            JSONObject sDKConfig = YtSDKKitConfigHelper.getSDKConfig(ytSDKKitFrameworkWorkMode, new JSONObject(sb).getJSONObject("sdk_settings"));
            sDKConfig.put("resource_download_path", p.cTh() + FilePathGenerator.ANDROID_DIR_SEP);
            sDKConfig.put("video_path", wHI + Util.currentTicks() + ".mp4");
            Log.i("MicroMsg.FaceFlashManagerConfig", "YtSDKKitConfigHelper getSDKConfig:%s", sDKConfig.toString());
            AppMethodBeat.o(186610);
            return sDKConfig;
        } catch (JSONException e3) {
            Log.printErrStackTrace("MicroMsg.FaceFlashManagerConfig", e3, "par config error. config:%s", sb);
            AppMethodBeat.o(186610);
            return null;
        }
    }
}
