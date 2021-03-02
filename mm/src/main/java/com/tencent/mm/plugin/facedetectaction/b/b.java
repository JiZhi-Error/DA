package com.tencent.mm.plugin.facedetectaction.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.PluginFace;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.youtu.ytcommon.YTCommonExInterface;
import com.tencent.youtu.ytfacetrack.YTFaceTrack;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;

public final class b {
    int liveType;
    public YTPoseDetectInterface.PoseDetectOnFrame sXw = null;
    a sXx;
    int status = -1;

    public interface a {
        void a(byte[][] bArr, int i2, int i3);
    }

    static {
        AppMethodBeat.i(104209);
        tryLoadLibrary();
        YTCommonExInterface.setIsEnabledLog(true);
        YTCommonExInterface.setIsEnabledNativeLog(true);
        AppMethodBeat.o(104209);
    }

    static void tryLoadLibrary() {
        AppMethodBeat.i(104207);
        if (PluginFace.isEnabled()) {
            com.tencent.mm.plugin.expansions.a.aoa("YTCommon");
            com.tencent.mm.plugin.expansions.a.aoa("YTFaceTrackPro2");
            com.tencent.mm.plugin.expansions.a.aoa("YTNextCV");
            com.tencent.mm.plugin.expansions.a.aoa("YTPoseDetect");
        }
        AppMethodBeat.o(104207);
    }

    public static void release() {
        AppMethodBeat.i(104208);
        try {
            Log.i("MicroMsg.FaceCheckActionEngine", "release");
            if (PluginFace.isEnabled()) {
                YTPoseDetectInterface.releaseModel();
                YTFaceTrack.GlobalRelease();
            }
            AppMethodBeat.o(104208);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FaceCheckActionEngine", e2, "release error", new Object[0]);
            AppMethodBeat.o(104208);
        }
    }
}
